package com.facebook.common.file;

import com.facebook.common.file.FileTreeVisitor;
import java.io.File;

public class FileTree {
   public static boolean deleteContents(File var0) {
      File[] var1 = var0.listFiles();
      boolean var2 = true;
      if(var1 != null) {
         int var3 = var1.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            var2 &= deleteRecursively(var1[var4]);
         }
      }

      return var2;
   }

   public static boolean deleteRecursively(File var0) {
      if(var0.isDirectory()) {
         deleteContents(var0);
      }

      return var0.delete();
   }

   public static void walkFileTree(File var0, FileTreeVisitor var1) {
      var1.preVisitDirectory(var0);
      File[] var2 = var0.listFiles();
      if(var2 != null) {
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            File var5 = var2[var4];
            if(var5.isDirectory()) {
               walkFileTree(var5, var1);
            } else {
               var1.visitFile(var5);
            }
         }
      }

      var1.postVisitDirectory(var0);
   }
}
