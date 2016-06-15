package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_516;
import com.google.android.gms.tagmanager.class_541;
import com.google.android.gms.tagmanager.class_74;
import com.google.android.gms.tagmanager.class_75;
import com.google.android.gms.tagmanager.class_76;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// $FF: renamed from: com.google.android.gms.tagmanager.y
class class_576 implements class_74 {
   private static class_576 afr;
   // $FF: renamed from: tn java.lang.Object
   private static final Object field_3058 = new Object();
   private class_76 aeG;
   private String afs;
   private String aft;
   private class_75 afu;

   private class_576(Context var1) {
      this(class_516.method_2924(var1), new class_541());
   }

   class_576(class_75 var1, class_76 var2) {
      this.afu = var1;
      this.aeG = var2;
   }

   // $FF: renamed from: K (android.content.Context) com.google.android.gms.tagmanager.aq
   public static class_74 method_3252(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bR (java.lang.String) boolean
   public boolean method_370(String var1) {
      if(!this.aeG.method_373()) {
         class_515.method_2919("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
         return false;
      } else {
         if(this.afs != null && this.aft != null) {
            try {
               var1 = this.afs + "?" + this.aft + "=" + URLEncoder.encode(var1, "UTF-8");
               class_515.method_2918("Sending wrapped url hit: " + var1);
            } catch (UnsupportedEncodingException var3) {
               class_515.method_2921("Error wrapping URL for testing.", var3);
               return false;
            }
         }

         this.afu.method_372(var1);
         return true;
      }
   }
}
