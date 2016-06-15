package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_512;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_521;
import com.google.android.gms.tagmanager.class_539;
import com.google.android.gms.tagmanager.class_578;
import com.google.android.gms.tagmanager.class_68;
import com.google.android.gms.tagmanager.class_69;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: com.google.android.gms.tagmanager.cn
class class_525 implements Runnable {
   private volatile String aeM;
   private final String aeq;
   private final class_512 agI;
   private final String agJ;
   private bg<class_51.class_961> agK;
   private volatile class_578 agL;
   private volatile String agM;
   private final Context mContext;

   class_525(Context var1, String var2, class_512 var3, class_578 var4) {
      this.mContext = var1;
      this.agI = var3;
      this.aeq = var2;
      this.agL = var4;
      this.agJ = "/r?id=" + var2;
      this.aeM = this.agJ;
      this.agM = null;
   }

   public class_525(Context var1, String var2, class_578 var3) {
      this(var1, var2, new class_512(), var3);
   }

   // $FF: renamed from: mb () boolean
   private boolean method_2981() {
      NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         class_515.method_2918("...no network connectivity");
         return false;
      }
   }

   // $FF: renamed from: mc () void
   private void method_2982() {
      if(!this.method_2981()) {
         this.agK.method_353(class_68.class_818.agd);
      } else {
         class_515.method_2918("Start loading resource from network ...");
         String var1 = this.method_2986();
         class_69 var2 = this.agI.method_2912();

         try {
            InputStream var6;
            try {
               var6 = var2.method_356(var1);
            } catch (FileNotFoundException var15) {
               class_515.method_2919("No data is retrieved from the given url: " + var1 + ". Make sure container_id: " + this.aeq + " is correct.");
               this.agK.method_353(class_68.class_818.agf);
               return;
            } catch (IOException var16) {
               class_515.method_2921("Error when loading resources from url: " + var1 + " " + var16.getMessage(), var16);
               this.agK.method_353(class_68.class_818.age);
               return;
            }

            try {
               ByteArrayOutputStream var7 = new ByteArrayOutputStream();
               class_539.method_3042(var6, var7);
               class_51.class_961 var9 = class_51.class_961.method_1768(var7.toByteArray());
               class_515.method_2918("Successfully loaded supplemented resource: " + var9);
               if(var9.field_879 == null && var9.field_878.length == 0) {
                  class_515.method_2918("No change for container: " + this.aeq);
               }

               this.agK.method_354(var9);
            } catch (IOException var14) {
               class_515.method_2921("Error when parsing downloaded resources from url: " + var1 + " " + var14.getMessage(), var14);
               this.agK.method_353(class_68.class_818.agf);
               return;
            }
         } finally {
            var2.close();
         }

         class_515.method_2918("Load resource from network finished.");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
   void method_2983(bg<class_51.class_961> var1) {
      this.agK = var1;
   }

   // $FF: renamed from: bM (java.lang.String) void
   void method_2984(String var1) {
      if(var1 == null) {
         this.aeM = this.agJ;
      } else {
         class_515.method_2922("Setting CTFE URL path: " + var1);
         this.aeM = var1;
      }
   }

   // $FF: renamed from: cb (java.lang.String) void
   void method_2985(String var1) {
      class_515.method_2922("Setting previous container version: " + var1);
      this.agM = var1;
   }

   // $FF: renamed from: md () java.lang.String
   String method_2986() {
      String var1 = this.agL.method_3253() + this.aeM + "&v=a65833898";
      if(this.agM != null && !this.agM.trim().equals("")) {
         var1 = var1 + "&pv=" + this.agM;
      }

      if(class_521.method_2948().method_2950().equals(class_521.class_1311.agA)) {
         var1 = var1 + "&gtm_debug=x";
      }

      return var1;
   }

   public void run() {
      if(this.agK == null) {
         throw new IllegalStateException("callback must be set before execute");
      } else {
         this.agK.method_355();
         this.method_2982();
      }
   }
}
