package android.support.v4.provider;

import android.net.Uri;
import android.support.v4.provider.DocumentFile;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile extends DocumentFile {
   private File mFile;

   RawDocumentFile(DocumentFile var1, File var2) {
      super(var1);
      this.mFile = var2;
   }

   private static boolean deleteContents(File var0) {
      File[] var1 = var0.listFiles();
      boolean var2 = true;
      if(var1 != null) {
         int var3 = var1.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            File var5 = var1[var4];
            if(var5.isDirectory()) {
               var2 &= deleteContents(var5);
            }

            if(!var5.delete()) {
               Log.w("DocumentFile", "Failed to delete " + var5);
               var2 = false;
            }
         }
      }

      return var2;
   }

   private static String getTypeForName(String var0) {
      int var1 = var0.lastIndexOf(46);
      if(var1 >= 0) {
         String var2 = var0.substring(var1 + 1).toLowerCase();
         String var3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var2);
         if(var3 != null) {
            return var3;
         }
      }

      return "application/octet-stream";
   }

   public boolean canRead() {
      return this.mFile.canRead();
   }

   public boolean canWrite() {
      return this.mFile.canWrite();
   }

   public DocumentFile createDirectory(String var1) {
      File var2 = new File(this.mFile, var1);
      return !var2.isDirectory() && !var2.mkdir()?null:new RawDocumentFile(this, var2);
   }

   public DocumentFile createFile(String var1, String var2) {
      String var3 = MimeTypeMap.getSingleton().getExtensionFromMimeType(var1);
      if(var3 != null) {
         var2 = var2 + "." + var3;
      }

      File var4 = new File(this.mFile, var2);

      try {
         var4.createNewFile();
         RawDocumentFile var8 = new RawDocumentFile(this, var4);
         return var8;
      } catch (IOException var9) {
         Log.w("DocumentFile", "Failed to createFile: " + var9);
         return null;
      }
   }

   public boolean delete() {
      deleteContents(this.mFile);
      return this.mFile.delete();
   }

   public boolean exists() {
      return this.mFile.exists();
   }

   public String getName() {
      return this.mFile.getName();
   }

   public String getType() {
      return this.mFile.isDirectory()?null:getTypeForName(this.mFile.getName());
   }

   public Uri getUri() {
      return Uri.fromFile(this.mFile);
   }

   public boolean isDirectory() {
      return this.mFile.isDirectory();
   }

   public boolean isFile() {
      return this.mFile.isFile();
   }

   public long lastModified() {
      return this.mFile.lastModified();
   }

   public long length() {
      return this.mFile.length();
   }

   public DocumentFile[] listFiles() {
      ArrayList var1 = new ArrayList();
      File[] var2 = this.mFile.listFiles();
      if(var2 != null) {
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            var1.add(new RawDocumentFile(this, var2[var4]));
         }
      }

      return (DocumentFile[])var1.toArray(new DocumentFile[var1.size()]);
   }

   public boolean renameTo(String var1) {
      File var2 = new File(this.mFile.getParentFile(), var1);
      if(this.mFile.renameTo(var2)) {
         this.mFile = var2;
         return true;
      } else {
         return false;
      }
   }
}
