package com.facebook.binaryresource;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.common.internal.Files;
import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileBinaryResource implements BinaryResource {
   private final File mFile;

   private FileBinaryResource(File var1) {
      this.mFile = (File)Preconditions.checkNotNull(var1);
   }

   public static FileBinaryResource createOrNull(File var0) {
      return var0 != null?new FileBinaryResource(var0):null;
   }

   public boolean equals(Object var1) {
      if(var1 != null && var1 instanceof FileBinaryResource) {
         FileBinaryResource var2 = (FileBinaryResource)var1;
         return this.mFile.equals(var2.mFile);
      } else {
         return false;
      }
   }

   public File getFile() {
      return this.mFile;
   }

   public int hashCode() {
      return this.mFile.hashCode();
   }

   public InputStream openStream() throws IOException {
      return new FileInputStream(this.mFile);
   }

   public byte[] read() throws IOException {
      return Files.toByteArray(this.mFile);
   }

   public long size() {
      return this.mFile.length();
   }
}
