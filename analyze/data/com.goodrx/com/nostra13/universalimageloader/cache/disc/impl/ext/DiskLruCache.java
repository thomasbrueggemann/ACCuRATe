package com.nostra13.universalimageloader.cache.disc.impl.ext;

import com.nostra13.universalimageloader.cache.disc.impl.ext.Util;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

final class DiskLruCache implements Closeable {
   static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
   private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
      public void write(int var1) throws IOException {
      }
   };
   private final int appVersion;
   private final Callable<Void> cleanupCallable;
   private final File directory;
   final ThreadPoolExecutor executorService;
   private int fileCount = 0;
   private final File journalFile;
   private final File journalFileBackup;
   private final File journalFileTmp;
   private Writer journalWriter;
   private final LinkedHashMap<String, DiskLruCache.Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
   private int maxFileCount;
   private long maxSize;
   private long nextSequenceNumber = 0L;
   private int redundantOpCount;
   private long size = 0L;
   private final int valueCount;

   private DiskLruCache(File var1, int var2, int var3, long var4, int var6) {
      this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
      this.cleanupCallable = new Callable() {
         public Void call() throws Exception {
            // $FF: Couldn't be decompiled
         }
      };
      this.directory = var1;
      this.appVersion = var2;
      this.journalFile = new File(var1, "journal");
      this.journalFileTmp = new File(var1, "journal.tmp");
      this.journalFileBackup = new File(var1, "journal.bkp");
      this.valueCount = var3;
      this.maxSize = var4;
      this.maxFileCount = var6;
   }

   // $FF: synthetic method
   static Writer access$000(DiskLruCache var0) {
      return var0.journalWriter;
   }

   // $FF: synthetic method
   static void access$100(DiskLruCache var0) throws IOException {
      var0.trimToSize();
   }

   // $FF: synthetic method
   static void access$200(DiskLruCache var0) throws IOException {
      var0.trimToFileCount();
   }

   // $FF: synthetic method
   static OutputStream access$2100() {
      return NULL_OUTPUT_STREAM;
   }

   // $FF: synthetic method
   static boolean access$300(DiskLruCache var0) {
      return var0.journalRebuildRequired();
   }

   // $FF: synthetic method
   static void access$400(DiskLruCache var0) throws IOException {
      var0.rebuildJournal();
   }

   // $FF: synthetic method
   static int access$502(DiskLruCache var0, int var1) {
      var0.redundantOpCount = var1;
      return var1;
   }

   private void checkNotClosed() {
      if(this.journalWriter == null) {
         throw new IllegalStateException("cache is closed");
      }
   }

   private void completeEdit(DiskLruCache.Editor param1, boolean param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private static void deleteIfExists(File var0) throws IOException {
      if(var0.exists() && !var0.delete()) {
         throw new IOException();
      }
   }

   private DiskLruCache.Editor edit(String param1, long param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private boolean journalRebuildRequired() {
      return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
   }

   public static DiskLruCache open(File var0, int var1, int var2, long var3, int var5) throws IOException {
      if(var3 <= 0L) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else if(var5 <= 0) {
         throw new IllegalArgumentException("maxFileCount <= 0");
      } else if(var2 <= 0) {
         throw new IllegalArgumentException("valueCount <= 0");
      } else {
         File var6 = new File(var0, "journal.bkp");
         if(var6.exists()) {
            File var7 = new File(var0, "journal");
            if(var7.exists()) {
               var6.delete();
            } else {
               renameTo(var6, var7, false);
            }
         }

         DiskLruCache var8 = new DiskLruCache(var0, var1, var2, var3, var5);
         if(var8.journalFile.exists()) {
            try {
               var8.readJournal();
               var8.processJournal();
               var8.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(var8.journalFile, true), Util.US_ASCII));
               return var8;
            } catch (IOException var12) {
               System.out.println("DiskLruCache " + var0 + " is corrupt: " + var12.getMessage() + ", removing");
               var8.delete();
            }
         }

         var0.mkdirs();
         DiskLruCache var10 = new DiskLruCache(var0, var1, var2, var3, var5);
         var10.rebuildJournal();
         return var10;
      }
   }

   private void processJournal() throws IOException {
      deleteIfExists(this.journalFileTmp);
      Iterator var1 = this.lruEntries.values().iterator();

      while(true) {
         while(var1.hasNext()) {
            DiskLruCache.Entry var2 = (DiskLruCache.Entry)var1.next();
            if(var2.currentEditor == null) {
               for(int var5 = 0; var5 < this.valueCount; ++var5) {
                  this.size += var2.lengths[var5];
                  ++this.fileCount;
               }
            } else {
               var2.currentEditor = null;

               for(int var4 = 0; var4 < this.valueCount; ++var4) {
                  deleteIfExists(var2.getCleanFile(var4));
                  deleteIfExists(var2.getDirtyFile(var4));
               }

               var1.remove();
            }
         }

         return;
      }
   }

   private void readJournal() throws IOException {
      // $FF: Couldn't be decompiled
   }

   private void readJournalLine(String var1) throws IOException {
      int var2 = var1.indexOf(32);
      if(var2 == -1) {
         throw new IOException("unexpected journal line: " + var1);
      } else {
         int var3 = var2 + 1;
         int var4 = var1.indexOf(32, var3);
         String var5;
         if(var4 == -1) {
            var5 = var1.substring(var3);
            if(var2 == "REMOVE".length() && var1.startsWith("REMOVE")) {
               this.lruEntries.remove(var5);
               return;
            }
         } else {
            var5 = var1.substring(var3, var4);
         }

         DiskLruCache.Entry var6 = (DiskLruCache.Entry)this.lruEntries.get(var5);
         if(var6 == null) {
            var6 = new DiskLruCache.Entry(var5, null);
            this.lruEntries.put(var5, var6);
         }

         if(var4 != -1 && var2 == "CLEAN".length() && var1.startsWith("CLEAN")) {
            String[] var9 = var1.substring(var4 + 1).split(" ");
            var6.readable = true;
            var6.currentEditor = null;
            var6.setLengths(var9);
         } else if(var4 == -1 && var2 == "DIRTY".length() && var1.startsWith("DIRTY")) {
            var6.currentEditor = new DiskLruCache.Editor(var6, null);
         } else if(var4 != -1 || var2 != "READ".length() || !var1.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + var1);
         }
      }
   }

   private void rebuildJournal() throws IOException {
      // $FF: Couldn't be decompiled
   }

   private static void renameTo(File var0, File var1, boolean var2) throws IOException {
      if(var2) {
         deleteIfExists(var1);
      }

      if(!var0.renameTo(var1)) {
         throw new IOException();
      }
   }

   private void trimToFileCount() throws IOException {
      while(this.fileCount > this.maxFileCount) {
         this.remove((String)((java.util.Map.Entry)this.lruEntries.entrySet().iterator().next()).getKey());
      }

   }

   private void trimToSize() throws IOException {
      while(this.size > this.maxSize) {
         this.remove((String)((java.util.Map.Entry)this.lruEntries.entrySet().iterator().next()).getKey());
      }

   }

   private void validateKey(String var1) {
      if(!LEGAL_KEY_PATTERN.matcher(var1).matches()) {
         throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + var1 + "\"");
      }
   }

   public void close() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void delete() throws IOException {
      this.close();
      Util.deleteContents(this.directory);
   }

   public DiskLruCache.Editor edit(String var1) throws IOException {
      return this.edit(var1, -1L);
   }

   public DiskLruCache.Snapshot get(String param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public File getDirectory() {
      return this.directory;
   }

   public int getMaxFileCount() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.maxFileCount;
      } finally {
         ;
      }

      return var2;
   }

   public long getMaxSize() {
      synchronized(this){}

      long var2;
      try {
         var2 = this.maxSize;
      } finally {
         ;
      }

      return var2;
   }

   public boolean remove(String param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public final class Editor {
      private boolean committed;
      private final DiskLruCache.Entry entry;
      private boolean hasErrors;
      private final boolean[] written;

      private Editor(DiskLruCache.Entry var2) {
         this.entry = var2;
         boolean[] var3;
         if(var2.readable) {
            var3 = null;
         } else {
            var3 = new boolean[DiskLruCache.this.valueCount];
         }

         this.written = var3;
      }

      // $FF: synthetic method
      Editor(DiskLruCache.Entry var2, Object var3) {
         this();
      }

      // $FF: synthetic method
      static DiskLruCache.Entry access$1500(DiskLruCache.Editor var0) {
         return var0.entry;
      }

      // $FF: synthetic method
      static boolean[] access$1600(DiskLruCache.Editor var0) {
         return var0.written;
      }

      public void abort() throws IOException {
         DiskLruCache.this.completeEdit(this, false);
      }

      public void commit() throws IOException {
         if(this.hasErrors) {
            DiskLruCache.this.completeEdit(this, false);
            DiskLruCache.this.remove(this.entry.key);
         } else {
            DiskLruCache.this.completeEdit(this, true);
         }

         this.committed = true;
      }

      public OutputStream newOutputStream(int param1) throws IOException {
         // $FF: Couldn't be decompiled
      }
   }

   private class FaultHidingOutputStream extends FilterOutputStream {
      private FaultHidingOutputStream(OutputStream var2) {
         super(var2);
      }

      // $FF: synthetic method
      FaultHidingOutputStream(OutputStream var2, Object var3) {
         this();
      }

      public void close() {
         try {
            this.out.close();
         } catch (IOException var2) {
            DiskLruCache.super.hasErrors = true;
         }
      }

      public void flush() {
         try {
            this.out.flush();
         } catch (IOException var2) {
            DiskLruCache.super.hasErrors = true;
         }
      }

      public void write(int var1) {
         try {
            this.out.write(var1);
         } catch (IOException var3) {
            DiskLruCache.super.hasErrors = true;
         }
      }

      public void write(byte[] var1, int var2, int var3) {
         try {
            this.out.write(var1, var2, var3);
         } catch (IOException var5) {
            DiskLruCache.super.hasErrors = true;
         }
      }
   }

   private final class Entry {
      private DiskLruCache.Editor currentEditor;
      private final String key;
      private final long[] lengths;
      private boolean readable;
      private long sequenceNumber;

      private Entry(String var2) {
         this.key = var2;
         this.lengths = new long[DiskLruCache.this.valueCount];
      }

      // $FF: synthetic method
      Entry(String var2, Object var3) {
         this();
      }

      // $FF: synthetic method
      static long access$1300(DiskLruCache.Entry var0) {
         return var0.sequenceNumber;
      }

      // $FF: synthetic method
      static long access$1302(DiskLruCache.Entry var0, long var1) {
         var0.sequenceNumber = var1;
         return var1;
      }

      private IOException invalidLengths(String[] var1) throws IOException {
         throw new IOException("unexpected journal line: " + Arrays.toString(var1));
      }

      private void setLengths(String[] var1) throws IOException {
         if(var1.length != DiskLruCache.this.valueCount) {
            throw this.invalidLengths(var1);
         } else {
            int var2 = 0;

            while(true) {
               try {
                  if(var2 >= var1.length) {
                     return;
                  }

                  this.lengths[var2] = Long.parseLong(var1[var2]);
               } catch (NumberFormatException var4) {
                  throw this.invalidLengths(var1);
               }

               ++var2;
            }
         }
      }

      public File getCleanFile(int var1) {
         return new File(DiskLruCache.this.directory, this.key + "" + var1);
      }

      public File getDirtyFile(int var1) {
         return new File(DiskLruCache.this.directory, this.key + "" + var1 + ".tmp");
      }

      public String getLengths() throws IOException {
         StringBuilder var1 = new StringBuilder();
         long[] var2 = this.lengths;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            long var5 = var2[var4];
            var1.append(' ').append(var5);
         }

         return var1.toString();
      }
   }

   public final class Snapshot implements Closeable {
      private File[] files;
      private final InputStream[] ins;
      private final String key;
      private final long[] lengths;
      private final long sequenceNumber;

      private Snapshot(String var2, long var3, File[] var5, InputStream[] var6, long[] var7) {
         this.key = var2;
         this.sequenceNumber = var3;
         this.files = var5;
         this.ins = var6;
         this.lengths = var7;
      }

      // $FF: synthetic method
      Snapshot(String var2, long var3, File[] var5, InputStream[] var6, long[] var7, Object var8) {
         this();
      }

      public void close() {
         InputStream[] var1 = this.ins;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            Util.closeQuietly(var1[var3]);
         }

      }

      public File getFile(int var1) {
         return this.files[var1];
      }
   }
}
