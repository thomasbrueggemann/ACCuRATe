package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_161;
import com.google.android.gms.internal.class_300;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_202;
import com.google.android.gms.tagmanager.class_609;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_619;
import com.google.android.gms.tagmanager.class_639;
import com.google.android.gms.tagmanager.class_73;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

// $FF: renamed from: com.google.android.gms.tagmanager.cq
class class_638 implements class_202.class_1364 {
   private final String aqm;
   private bg<class_161.class_1310> asC;
   private final ExecutorService asJ;
   private final Context mContext;

   class_638(Context var1, String var2) {
      this.mContext = var1;
      this.aqm = var2;
      this.asJ = Executors.newSingleThreadExecutor();
   }

   // $FF: renamed from: a (java.io.ByteArrayOutputStream) com.google.android.gms.tagmanager.cr$c
   private class_639.class_1684 method_3618(ByteArrayOutputStream var1) {
      try {
         class_639.class_1684 var4 = class_609.method_3483(var1.toString("UTF-8"));
         return var4;
      } catch (UnsupportedEncodingException var5) {
         class_613.method_3490("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
         return null;
      } catch (JSONException var6) {
         class_613.method_3494("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn\'t contain a JSON container");
         return null;
      }
   }

   // $FF: renamed from: d (com.google.android.gms.internal.pu$a) void
   private void method_3619(class_161.class_1310 var1) throws IllegalArgumentException {
      if(var1.field_666 == null && var1.auC == null) {
         throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
      }
   }

   // $FF: renamed from: k (byte[]) com.google.android.gms.tagmanager.cr$c
   private class_639.class_1684 method_3620(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
   public void method_276(bg<class_161.class_1310> var1) {
      this.asC = var1;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.pu$a) void
   public void method_277(final class_161.class_1310 var1) {
      this.asJ.execute(new Runnable() {
         public void run() {
            class_638.this.method_3621(var1);
         }
      });
   }

   // $FF: renamed from: c (com.google.android.gms.internal.pu$a) boolean
   boolean method_3621(class_161.class_1310 var1) {
      File var2 = this.method_3623();

      FileOutputStream var3;
      try {
         var3 = new FileOutputStream(var2);
      } catch (FileNotFoundException var18) {
         class_613.method_3491("Error opening resource file for writing");
         return false;
      }

      try {
         var3.write(class_300.method_2088(var1));
         return true;
      } catch (IOException var19) {
         class_613.method_3494("Error writing resource to disk. Removing resource from disk.");
         var2.delete();
      } finally {
         try {
            var3.close();
         } catch (IOException var17) {
            class_613.method_3494("error closing stream for writing resource to disk");
         }

      }

      return false;
   }

   // $FF: renamed from: fH (int) com.google.android.gms.tagmanager.cr$c
   public class_639.class_1684 method_278(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: pt () void
   public void method_279() {
      this.asJ.execute(new Runnable() {
         public void run() {
            class_638.this.method_3622();
         }
      });
   }

   // $FF: renamed from: qi () void
   void method_3622() {
      if(this.asC == null) {
         throw new IllegalStateException("Callback must be set before execute");
      } else {
         this.asC.method_397();
         class_613.method_3493("Attempting to load resource from disk");
         if((class_619.method_3526().method_3528() == class_619.class_1644.asr || class_619.method_3526().method_3528() == class_619.class_1644.ass) && this.aqm.equals(class_619.method_3526().getContainerId())) {
            this.asC.method_395(class_73.class_1072.arV);
         } else {
            FileInputStream var1;
            try {
               var1 = new FileInputStream(this.method_3623());
            } catch (FileNotFoundException var24) {
               class_613.method_3490("Failed to find the resource in the disk");
               this.asC.method_395(class_73.class_1072.arV);
               return;
            }

            try {
               ByteArrayOutputStream var2 = new ByteArrayOutputStream();
               class_639.method_3629(var1, var2);
               class_161.class_1310 var9 = class_161.class_1310.method_2133(var2.toByteArray());
               this.method_3619(var9);
               this.asC.method_396(var9);
            } catch (IOException var21) {
               this.asC.method_395(class_73.class_1072.arW);
               class_613.method_3494("Failed to read the resource from disk");
            } catch (IllegalArgumentException var22) {
               this.asC.method_395(class_73.class_1072.arW);
               class_613.method_3494("Failed to read the resource from disk. The resource is inconsistent");
            } finally {
               try {
                  var1.close();
               } catch (IOException var20) {
                  class_613.method_3494("Error closing stream for reading resource from disk");
               }

            }

            class_613.method_3493("The Disk resource was successfully read.");
         }
      }
   }

   // $FF: renamed from: qj () java.io.File
   File method_3623() {
      String var1 = "resource_" + this.aqm;
      return new File(this.mContext.getDir("google_tagmanager", 0), var1);
   }

   public void release() {
      synchronized(this){}

      try {
         this.asJ.shutdown();
      } finally {
         ;
      }

   }
}
