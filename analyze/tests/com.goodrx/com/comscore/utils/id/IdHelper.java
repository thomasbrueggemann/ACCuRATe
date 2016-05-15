package com.comscore.utils.id;

import android.annotation.SuppressLint;
import android.content.Context;
import com.comscore.analytics.Core;
import com.comscore.android.id.DeviceId;
import com.comscore.android.id.IdHelperAndroid;
import com.comscore.applications.EventType;
import com.comscore.utils.Storage;
import com.comscore.utils.Utils;
import com.comscore.utils.id.IdChecker;
import java.util.HashMap;

@SuppressLint({"NewApi"})
public class IdHelper {
   // $FF: renamed from: a com.comscore.analytics.Core
   private Core field_234;
   // $FF: renamed from: b java.lang.String
   private String field_235;
   // $FF: renamed from: c java.lang.String
   private String field_236;
   // $FF: renamed from: d com.comscore.utils.Storage
   private Storage field_237;
   // $FF: renamed from: e android.content.Context
   private Context field_238;
   // $FF: renamed from: f java.lang.String
   private String field_239;
   // $FF: renamed from: g java.lang.String
   private String field_240;
   // $FF: renamed from: h java.lang.String
   private String field_241;
   // $FF: renamed from: i boolean
   private boolean field_242 = false;
   // $FF: renamed from: j boolean
   private boolean field_243 = false;
   // $FF: renamed from: k boolean
   private boolean field_244 = false;
   // $FF: renamed from: l java.lang.Boolean
   private Boolean field_245;
   // $FF: renamed from: m com.comscore.utils.id.IdChecker
   private IdChecker field_246;

   public IdHelper(Context var1, Storage var2, Core var3) {
      this.field_238 = var1;
      this.field_237 = var2;
      this.field_234 = var3;
      this.field_246 = new IdChecker(this.field_238, var2);
   }

   // $FF: renamed from: a () void
   private void method_178() {
      DeviceId var1 = IdHelperAndroid.getAdvertisingDeviceId(this.field_238);
      if(var1 == null) {
         this.field_242 = true;
         this.method_179((String)null, false);
      } else if(var1.getCommonness() == 0 && var1.getPersistency() == 0) {
         this.method_179(var1.getId(), true);
      } else {
         String var2 = this.field_237.get("md5RawCrossPublisherId");
         if(!this.field_246.checkCrossPublisherId(var2)) {
            this.field_237.remove("md5RawCrossPublisherId");
            this.field_237.remove("crossPublisherId");
            this.field_235 = null;
            this.field_241 = null;
         }

         this.method_179(var1.getId(), false);
      }
   }

   // $FF: renamed from: a (java.lang.String, boolean) void
   private void method_179(String var1, boolean var2) {
      if(var1 != null) {
         this.field_242 = var2;
         String var3 = this.field_237.get("md5RawCrossPublisherId");
         boolean var4;
         if(this.field_241 == null) {
            var4 = true;
         } else {
            var4 = false;
         }

         this.field_241 = Utils.md5(var1);
         if(this.method_180(this.field_241)) {
            this.field_235 = this.field_237.get("crossPublisherId");
         } else {
            if(this.field_242 && var3 != null && !var3.isEmpty() && var3 != this.field_241) {
               this.field_243 = true;
               this.field_244 = var4;
            }

            this.field_235 = this.method_181(var1);
            this.field_237.set("crossPublisherId", this.field_235);
            this.field_237.set("md5RawCrossPublisherId", this.field_241);
         }
      } else {
         this.field_235 = null;
         this.field_241 = null;
      }
   }

   // $FF: renamed from: a (java.lang.String) boolean
   private boolean method_180(String var1) {
      String var2 = this.field_237.get("md5RawCrossPublisherId");
      return var2 != null && var2.equals(var1);
   }

   // $FF: renamed from: b (java.lang.String) java.lang.String
   private String method_181(String var1) {
      String var2 = null;
      if(var1 != null) {
         int var3 = var1.length();
         var2 = null;
         if(var3 > 0) {
            String var5;
            try {
               var5 = Utils.encrypt(var1);
            } catch (Exception var6) {
               return null;
            }

            var2 = var5;
         }
      }

      return var2;
   }

   // $FF: renamed from: b () void
   private void method_182() {
      if(this.field_237.has("vid").booleanValue()) {
         this.field_236 = this.field_237.get("vid");
         if(this.field_246.checkVisitorId()) {
            return;
         }

         HashMap var4 = new HashMap();
         var4.put("cs_c12u", this.field_237.get("vid"));
         this.field_234.notify(EventType.AGGREGATE, var4, true);
         this.field_237.remove("vid");
         this.field_236 = null;
      }

      DeviceId var1 = IdHelperAndroid.getDeviceId(this.field_238);
      String var2 = var1.getId();
      String var3 = "-cs" + var1.getSuffix();
      if(this.field_236 == null) {
         this.field_236 = Utils.md5(var2 + this.getPublisherSecret()) + var3;
         this.field_237.set("vid", this.field_236);
      }

   }

   // $FF: renamed from: c () boolean
   private boolean method_183() {
      boolean var1 = IdHelperAndroid.isAdvertisingIdEnabled(this.field_238);
      if(this.field_245 == null) {
         this.field_245 = Boolean.valueOf(var1);
      } else if(this.field_245.booleanValue() != var1) {
         this.method_178();
         return var1;
      }

      return var1;
   }

   public void generateIds() {
      if(!this.isPublisherSecretEmpty()) {
         this.field_240 = IdHelperAndroid.getDeviceId(this.field_238).getId();
         this.method_182();
         this.method_178();
      }
   }

   public String getAndroidId() {
      return this.field_240;
   }

   public String getCrossPublisherId() {
      if(this.field_242) {
         if(this.method_183()) {
            this.method_178();
            return this.field_243 && !this.field_244?"none":this.field_235;
         } else {
            return "none";
         }
      } else {
         return this.field_235;
      }
   }

   public String getMD5AdvertisingId() {
      return this.field_242 && this.method_183()?this.field_241:null;
   }

   public String getPublisherSecret() {
      if(this.field_239 == null) {
         this.field_239 = "";
      }

      return this.field_239;
   }

   public String getVisitorId() {
      return this.field_236;
   }

   public boolean isIdChanged() {
      return this.field_243;
   }

   public boolean isPublisherSecretEmpty() {
      return this.field_239 == null || this.field_239.length() == 0;
   }

   public void resetVisitorId() {
      this.field_236 = null;
      if(this.field_237.has("vid").booleanValue()) {
         this.field_237.remove("vid");
         this.generateIds();
      }
   }

   public void setPublisherSecret(String var1) {
      this.field_239 = var1;
   }
}
