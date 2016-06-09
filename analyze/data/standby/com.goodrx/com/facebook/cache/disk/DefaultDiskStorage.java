package com.facebook.cache.disk;

import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DefaultDiskStorage implements DiskStorage {
   private static final String CONTENT_FILE_EXTENSION = ".cnt";
   private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
   private static final int SHARDING_BUCKET_COUNT = 100;
   private static final Class<?> TAG = DefaultDiskStorage.class;
   private static final String TEMP_FILE_EXTENSION = ".tmp";
   static final long TEMP_FILE_LIFETIME_MS;
   private final CacheErrorLogger mCacheErrorLogger;
   private final Clock mClock;
   private final File mRootDirectory;
   private final File mVersionDirectory;

   static {
      TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30L);
   }

   public DefaultDiskStorage(File var1, int var2, CacheErrorLogger var3) {
      Preconditions.checkNotNull(var1);
      this.mRootDirectory = var1;
      this.mVersionDirectory = new File(this.mRootDirectory, getVersionSubdirectoryName(var2));
      this.mCacheErrorLogger = var3;
      this.recreateDirectoryIfVersionChanges();
      this.mClock = SystemClock.get();
   }

   private long doRemove(File var1) {
      long var2;
      if(!var1.exists()) {
         var2 = 0L;
      } else {
         var2 = var1.length();
         if(!var1.delete()) {
            return -1L;
         }
      }

      return var2;
   }

   private DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry var1) throws IOException {
      DefaultDiskStorage.EntryImpl var2 = (DefaultDiskStorage.EntryImpl)var1;
      String var3 = "";
      byte[] var4 = var2.getResource().read();
      String var5 = this.typeOfBytes(var4);
      if(var5.equals("undefined") && var4.length >= 4) {
         Locale var6 = (Locale)null;
         Object[] var7 = new Object[]{Byte.valueOf(var4[0]), Byte.valueOf(var4[1]), Byte.valueOf(var4[2]), Byte.valueOf(var4[3])};
         var3 = String.format(var6, "0x%02X 0x%02X 0x%02X 0x%02X", var7);
      }

      return new DiskStorage.DiskDumpInfoEntry(var2.getResource().getFile().getPath(), var5, (float)var2.getSize(), var3);
   }

   private DefaultDiskStorage.FileInfo getShardFileInfo(File var1) {
      DefaultDiskStorage.FileInfo var2 = DefaultDiskStorage.FileInfo.fromFile(var1);
      if(var2 == null) {
         return null;
      } else {
         if(!this.getSubdirectory(var2.resourceId).equals(var1.getParentFile())) {
            var2 = null;
         }

         return var2;
      }
   }

   private File getSubdirectory(String var1) {
      return new File(this.getSubdirectoryPath(var1));
   }

   private String getSubdirectoryPath(String var1) {
      String var2 = String.valueOf(Math.abs(var1.hashCode() % 100));
      return this.mVersionDirectory + File.separator + var2;
   }

   @VisibleForTesting
   static String getVersionSubdirectoryName(int var0) {
      Locale var1 = (Locale)null;
      Object[] var2 = new Object[]{"v2", Integer.valueOf(100), Integer.valueOf(var0)};
      return String.format(var1, "%s.ols%d.%d", var2);
   }

   private void mkdirs(File var1, String var2) throws IOException {
      try {
         FileUtils.mkdirs(var1);
      } catch (FileUtils.CreateDirectoryException var4) {
         this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, var2, var4);
         throw var4;
      }
   }

   private boolean query(String var1, boolean var2) {
      File var3 = this.getContentFileFor(var1);
      boolean var4 = var3.exists();
      if(var2 && var4) {
         var3.setLastModified(this.mClock.now());
      }

      return var4;
   }

   private void recreateDirectoryIfVersionChanges() {
      boolean var2;
      if(!this.mRootDirectory.exists()) {
         var2 = true;
      } else {
         boolean var1 = this.mVersionDirectory.exists();
         var2 = false;
         if(!var1) {
            var2 = true;
            FileTree.deleteRecursively(this.mRootDirectory);
         }
      }

      if(var2) {
         try {
            FileUtils.mkdirs(this.mVersionDirectory);
         } catch (FileUtils.CreateDirectoryException var5) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, (Throwable)null);
            return;
         }
      }

   }

   private String typeOfBytes(byte[] var1) {
      if(var1.length >= 2) {
         if(var1[0] == -1 && var1[1] == -40) {
            return "jpg";
         }

         if(var1[0] == -119 && var1[1] == 80) {
            return "png";
         }

         if(var1[0] == 82 && var1[1] == 73) {
            return "webp";
         }

         if(var1[0] == 71 && var1[1] == 73) {
            return "gif";
         }
      }

      return "undefined";
   }

   public void clearAll() {
      FileTree.deleteContents(this.mRootDirectory);
   }

   public FileBinaryResource commit(String var1, FileBinaryResource var2, Object var3) throws IOException {
      File var4 = var2.getFile();
      File var5 = this.getContentFileFor(var1);

      try {
         FileUtils.rename(var4, var5);
      } catch (FileUtils.RenameException var9) {
         Throwable var7 = var9.getCause();
         CacheErrorLogger.CacheErrorCategory var8;
         if(var7 == null) {
            var8 = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
         } else if(var7 instanceof FileUtils.ParentDirNotFoundException) {
            var8 = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
         } else if(var7 instanceof FileNotFoundException) {
            var8 = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
         } else {
            var8 = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
         }

         this.mCacheErrorLogger.logError(var8, TAG, "commit", var9);
         throw var9;
      }

      if(var5.exists()) {
         var5.setLastModified(this.mClock.now());
      }

      return FileBinaryResource.createOrNull(var5);
   }

   public boolean contains(String var1, Object var2) {
      return this.query(var1, false);
   }

   public FileBinaryResource createTemporary(String var1, Object var2) throws IOException {
      DefaultDiskStorage.FileInfo var3 = new DefaultDiskStorage.FileInfo(DefaultDiskStorage.FileType.TEMP, var1);
      File var4 = this.getSubdirectory(var3.resourceId);
      if(!var4.exists()) {
         this.mkdirs(var4, "createTemporary");
      }

      try {
         FileBinaryResource var6 = FileBinaryResource.createOrNull(var3.createTempFile(var4));
         return var6;
      } catch (IOException var7) {
         this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "createTemporary", var7);
         throw var7;
      }
   }

   @VisibleForTesting
   File getContentFileFor(String var1) {
      return new File(this.getFilename(var1));
   }

   public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
      List var1 = this.getEntries();
      DiskStorage.DiskDumpInfo var2 = new DiskStorage.DiskDumpInfo();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         DiskStorage.DiskDumpInfoEntry var4 = this.dumpCacheEntry((DiskStorage.Entry)var3.next());
         String var5 = var4.type;
         if(!var2.typeCounts.containsKey(var5)) {
            var2.typeCounts.put(var5, Integer.valueOf(0));
         }

         var2.typeCounts.put(var5, Integer.valueOf(1 + ((Integer)var2.typeCounts.get(var5)).intValue()));
         var2.entries.add(var4);
      }

      return var2;
   }

   public List<DiskStorage.Entry> getEntries() throws IOException {
      DefaultDiskStorage.EntriesCollector var1 = new DefaultDiskStorage.EntriesCollector();
      FileTree.walkFileTree(this.mVersionDirectory, var1);
      return var1.getEntries();
   }

   public String getFilename(String var1) {
      DefaultDiskStorage.FileInfo var2 = new DefaultDiskStorage.FileInfo(DefaultDiskStorage.FileType.CONTENT, var1);
      return var2.toPath(this.getSubdirectoryPath(var2.resourceId));
   }

   public FileBinaryResource getResource(String var1, Object var2) {
      File var3 = this.getContentFileFor(var1);
      if(var3.exists()) {
         var3.setLastModified(this.mClock.now());
         return FileBinaryResource.createOrNull(var3);
      } else {
         return null;
      }
   }

   public boolean isEnabled() {
      return true;
   }

   public void purgeUnexpectedResources() {
      FileTree.walkFileTree(this.mRootDirectory, new DefaultDiskStorage.PurgingVisitor());
   }

   public long remove(DiskStorage.Entry var1) {
      return this.doRemove(((DefaultDiskStorage.EntryImpl)var1).getResource().getFile());
   }

   public long remove(String var1) {
      return this.doRemove(this.getContentFileFor(var1));
   }

   public boolean touch(String var1, Object var2) {
      return this.query(var1, true);
   }

   public void updateResource(String var1, FileBinaryResource var2, WriterCallback var3, Object var4) throws IOException {
      File var5 = var2.getFile();

      FileOutputStream var6;
      try {
         var6 = new FileOutputStream(var5);
      } catch (FileNotFoundException var15) {
         this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, TAG, "updateResource", var15);
         throw var15;
      }

      long var9;
      try {
         CountingOutputStream var7 = new CountingOutputStream(var6);
         var3.write(var7);
         var7.flush();
         var9 = var7.getCount();
      } finally {
         var6.close();
      }

      if(var5.length() != var9) {
         throw new DefaultDiskStorage.IncompleteFileException(var9, var5.length());
      }
   }

   private class EntriesCollector implements FileTreeVisitor {
      private final List<DiskStorage.Entry> result;

      private EntriesCollector() {
         this.result = new ArrayList();
      }

      // $FF: synthetic method
      EntriesCollector(Object var2) {
         this();
      }

      public List<DiskStorage.Entry> getEntries() {
         return Collections.unmodifiableList(this.result);
      }

      public void postVisitDirectory(File var1) {
      }

      public void preVisitDirectory(File var1) {
      }

      public void visitFile(File var1) {
         DefaultDiskStorage.FileInfo var2 = DefaultDiskStorage.this.getShardFileInfo(var1);
         if(var2 != null && var2.type == DefaultDiskStorage.FileType.CONTENT) {
            this.result.add(DefaultDiskStorage.this.new EntryImpl(var1));
         }

      }
   }

   @VisibleForTesting
   class EntryImpl implements DiskStorage.Entry {
      private final FileBinaryResource resource;
      private long size;
      private long timestamp;

      private EntryImpl(File var2) {
         Preconditions.checkNotNull(var2);
         this.resource = FileBinaryResource.createOrNull(var2);
         this.size = -1L;
         this.timestamp = -1L;
      }

      // $FF: synthetic method
      EntryImpl(File var2, Object var3) {
         this();
      }

      public FileBinaryResource getResource() {
         return this.resource;
      }

      public long getSize() {
         if(this.size < 0L) {
            this.size = this.resource.size();
         }

         return this.size;
      }

      public long getTimestamp() {
         if(this.timestamp < 0L) {
            this.timestamp = this.resource.getFile().lastModified();
         }

         return this.timestamp;
      }
   }

   private static class FileInfo {
      public final String resourceId;
      public final DefaultDiskStorage.FileType type;

      private FileInfo(DefaultDiskStorage.FileType var1, String var2) {
         this.type = var1;
         this.resourceId = var2;
      }

      // $FF: synthetic method
      FileInfo(DefaultDiskStorage.FileType var1, String var2, Object var3) {
         this(var1, var2);
      }

      public static DefaultDiskStorage.FileInfo fromFile(File var0) {
         String var1 = var0.getName();
         int var2 = var1.lastIndexOf(46);
         if(var2 > 0) {
            DefaultDiskStorage.FileType var3 = DefaultDiskStorage.FileType.fromExtension(var1.substring(var2));
            if(var3 != null) {
               String var4 = var1.substring(0, var2);
               if(var3.equals(DefaultDiskStorage.FileType.TEMP)) {
                  int var5 = var4.lastIndexOf(46);
                  if(var5 <= 0) {
                     return null;
                  }

                  var4 = var4.substring(0, var5);
               }

               return new DefaultDiskStorage.FileInfo(var3, var4);
            }
         }

         return null;
      }

      public File createTempFile(File var1) throws IOException {
         return File.createTempFile(this.resourceId + ".", ".tmp", var1);
      }

      public String toPath(String var1) {
         return var1 + File.separator + this.resourceId + this.type.extension;
      }

      public String toString() {
         return this.type + "(" + this.resourceId + ")";
      }
   }

   private static enum FileType {
      CONTENT(".cnt"),
      TEMP(".tmp");

      public final String extension;

      static {
         DefaultDiskStorage.FileType[] var0 = new DefaultDiskStorage.FileType[]{CONTENT, TEMP};
      }

      private FileType(String var3) {
         this.extension = var3;
      }

      public static DefaultDiskStorage.FileType fromExtension(String var0) {
         return ".cnt".equals(var0)?CONTENT:(".tmp".equals(var0)?TEMP:null);
      }
   }

   private static class IncompleteFileException extends IOException {
      public final long actual;
      public final long expected;

      public IncompleteFileException(long var1, long var3) {
         super("File was not written completely. Expected: " + var1 + ", found: " + var3);
         this.expected = var1;
         this.actual = var3;
      }
   }

   private class PurgingVisitor implements FileTreeVisitor {
      private boolean insideBaseDirectory;

      private PurgingVisitor() {
      }

      // $FF: synthetic method
      PurgingVisitor(Object var2) {
         this();
      }

      private boolean isExpectedFile(File var1) {
         DefaultDiskStorage.FileInfo var2 = DefaultDiskStorage.this.getShardFileInfo(var1);
         if(var2 == null) {
            return false;
         } else if(var2.type == DefaultDiskStorage.FileType.TEMP) {
            return this.isRecentFile(var1);
         } else {
            DefaultDiskStorage.FileType var3 = var2.type;
            DefaultDiskStorage.FileType var4 = DefaultDiskStorage.FileType.CONTENT;
            boolean var5 = false;
            if(var3 == var4) {
               var5 = true;
            }

            Preconditions.checkState(var5);
            return true;
         }
      }

      private boolean isRecentFile(File var1) {
         return var1.lastModified() > DefaultDiskStorage.this.mClock.now() - DefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
      }

      public void postVisitDirectory(File var1) {
         if(!DefaultDiskStorage.this.mRootDirectory.equals(var1) && !this.insideBaseDirectory) {
            var1.delete();
         }

         if(this.insideBaseDirectory && var1.equals(DefaultDiskStorage.this.mVersionDirectory)) {
            this.insideBaseDirectory = false;
         }

      }

      public void preVisitDirectory(File var1) {
         if(!this.insideBaseDirectory && var1.equals(DefaultDiskStorage.this.mVersionDirectory)) {
            this.insideBaseDirectory = true;
         }

      }

      public void visitFile(File var1) {
         if(!this.insideBaseDirectory || !this.isExpectedFile(var1)) {
            var1.delete();
         }

      }
   }
}
