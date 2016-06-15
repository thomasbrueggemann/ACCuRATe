package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.class_55;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_619;
import com.google.android.gms.tagmanager.class_639;
import com.google.android.gms.tagmanager.class_679;
import com.google.android.gms.tagmanager.class_73;
import com.google.android.gms.tagmanager.class_74;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: com.google.android.gms.tagmanager.co
class class_622 implements Runnable {
   private volatile String aqI;
   private final String aqm;
   private final class_612 asA;
   private final String asB;
   private bg<class_55.class_1260> asC;
   private volatile class_679 asD;
   private volatile String asE;
   private final Context mContext;

   class_622(Context var1, String var2, class_612 var3, class_679 var4) {
      this.mContext = var1;
      this.asA = var3;
      this.aqm = var2;
      this.asD = var4;
      this.asB = "/r?id=" + var2;
      this.aqI = this.asB;
      this.asE = null;
   }

   public class_622(Context var1, String var2, class_679 var3) {
      this(var1, var2, new class_612(), var3);
   }

   // $FF: renamed from: qd () boolean
   private boolean method_3555() {
      NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         class_613.method_3493("...no network connectivity");
         return false;
      }
   }

   // $FF: renamed from: qe () void
   private void method_3556() {
      if(!this.method_3555()) {
         this.asC.method_395(class_73.class_1072.arV);
      } else {
         class_613.method_3493("Start loading resource from network ...");
         String var1 = this.method_3560();
         class_74 var2 = this.asA.method_3488();

         try {
            InputStream var6;
            try {
               var6 = var2.method_398(var1);
            } catch (FileNotFoundException var15) {
               class_613.method_3494("No data is retrieved from the given url: " + var1 + ". Make sure container_id: " + this.aqm + " is correct.");
               this.asC.method_395(class_73.class_1072.arX);
               return;
            } catch (IOException var16) {
               class_613.method_3496("Error when loading resources from url: " + var1 + " " + var16.getMessage(), var16);
               this.asC.method_395(class_73.class_1072.arW);
               return;
            }

            try {
               ByteArrayOutputStream var7 = new ByteArrayOutputStream();
               class_639.method_3629(var6, var7);
               class_55.class_1260 var9 = class_55.class_1260.method_2157(var7.toByteArray());
               class_613.method_3493("Successfully loaded supplemented resource: " + var9);
               if(var9.field_721 == null && var9.field_720.length == 0) {
                  class_613.method_3493("No change for container: " + this.aqm);
               }

               this.asC.method_396(var9);
            } catch (IOException var14) {
               class_613.method_3496("Error when parsing downloaded resources from url: " + var1 + " " + var14.getMessage(), var14);
               this.asC.method_395(class_73.class_1072.arX);
               return;
            }
         } finally {
            var2.close();
         }

         class_613.method_3493("Load resource from network finished.");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
   void method_3557(bg<class_55.class_1260> var1) {
      this.asC = var1;
   }

   // $FF: renamed from: cL (java.lang.String) void
   void method_3558(String var1) {
      class_613.method_3490("Setting previous container version: " + var1);
      this.asE = var1;
   }

   // $FF: renamed from: cw (java.lang.String) void
   void method_3559(String var1) {
      if(var1 == null) {
         this.aqI = this.asB;
      } else {
         class_613.method_3490("Setting CTFE URL path: " + var1);
         this.aqI = var1;
      }
   }

   // $FF: renamed from: qf () java.lang.String
   String method_3560() {
      String var1 = this.asD.method_3857() + this.aqI + "&v=a65833898";
      if(this.asE != null && !this.asE.trim().equals("")) {
         var1 = var1 + "&pv=" + this.asE;
      }

      if(class_619.method_3526().method_3528().equals(class_619.class_1644.ass)) {
         var1 = var1 + "&gtm_debug=x";
      }

      return var1;
   }

   public void run() {
      if(this.asC == null) {
         throw new IllegalStateException("callback must be set before execute");
      } else {
         this.asC.method_397();
         this.method_3556();
      }
   }
}
