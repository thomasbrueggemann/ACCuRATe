package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_614;
import com.google.android.gms.tagmanager.class_641;
import com.google.android.gms.tagmanager.class_79;
import com.google.android.gms.tagmanager.class_80;
import com.google.android.gms.tagmanager.class_81;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// $FF: renamed from: com.google.android.gms.tagmanager.y
class class_677 implements class_79 {
   private static class_677 arl;
   // $FF: renamed from: xO java.lang.Object
   private static final Object field_2924 = new Object();
   private class_81 aqC;
   private String arm;
   private String arn;
   private class_80 aro;

   private class_677(Context var1) {
      this(class_614.method_3498(var1), new class_641());
   }

   class_677(class_80 var1, class_81 var2) {
      this.aro = var1;
      this.aqC = var2;
   }

   // $FF: renamed from: X (android.content.Context) com.google.android.gms.tagmanager.aq
   public static class_79 method_3856(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cB (java.lang.String) boolean
   public boolean method_411(String var1) {
      if(!this.aqC.method_414()) {
         class_613.method_3494("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
         return false;
      } else {
         if(this.arm != null && this.arn != null) {
            try {
               var1 = this.arm + "?" + this.arn + "=" + URLEncoder.encode(var1, "UTF-8");
               class_613.method_3493("Sending wrapped url hit: " + var1);
            } catch (UnsupportedEncodingException var3) {
               class_613.method_3496("Error wrapping URL for testing.", var3);
               return false;
            }
         }

         this.aro.method_413(var1);
         return true;
      }
   }
}
