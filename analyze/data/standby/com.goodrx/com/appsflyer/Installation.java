package com.appsflyer;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.UUID;

public class Installation {
   private static String sID = null;

   // $FF: renamed from: id (android.content.Context) java.lang.String
   public static String method_358(Context var0) {
      synchronized(Installation.class){}

      String var4;
      try {
         if(sID == null) {
            File var2 = new File(var0.getFilesDir(), "AF_INSTALLATION");

            try {
               if(!var2.exists()) {
                  writeInstallationFile(var2, var0);
               }

               sID = readInstallationFile(var2);
            } catch (Exception var7) {
               throw new RuntimeException(var7);
            }
         }

         var4 = sID;
      } finally {
         ;
      }

      return var4;
   }

   private static String readInstallationFile(File var0) throws IOException {
      RandomAccessFile var1 = new RandomAccessFile(var0, "r");
      byte[] var2 = new byte[(int)var1.length()];
      var1.readFully(var2);
      var1.close();
      return new String(var2);
   }

   private static void writeInstallationFile(File var0, Context var1) throws IOException, NameNotFoundException {
      FileOutputStream var2 = new FileOutputStream(var0);
      PackageInfo var3 = var1.getPackageManager().getPackageInfo(var1.getPackageName(), 0);
      String var4;
      if(VERSION.SDK_INT >= 9) {
         var4 = var3.firstInstallTime + "-" + Math.abs((new Random()).nextLong());
      } else {
         var4 = UUID.randomUUID().toString();
      }

      var2.write(var4.getBytes());
      var2.close();
   }
}
