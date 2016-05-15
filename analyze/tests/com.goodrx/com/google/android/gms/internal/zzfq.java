package com.google.android.gms.internal;

import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzfq {
   private final boolean zzDu;
   private final boolean zzDv;
   private final boolean zzDw;
   private final boolean zzDx;
   private final boolean zzDy;

   private zzfq(zzfq.zza var1) {
      this.zzDu = var1.zzDu;
      this.zzDv = var1.zzDv;
      this.zzDw = var1.zzDw;
      this.zzDx = var1.zzDx;
      this.zzDy = var1.zzDy;
   }

   // $FF: synthetic method
   zzfq(zzfq.zza var1, Object var2) {
      this(var1);
   }

   public JSONObject toJson() {
      try {
         JSONObject var2 = (new JSONObject()).put("sms", this.zzDu).put("tel", this.zzDv).put("calendar", this.zzDw).put("storePicture", this.zzDx).put("inlineVideo", this.zzDy);
         return var2;
      } catch (JSONException var3) {
         zzin.zzb("Error occured while obtaining the MRAID capabilities.", var3);
         return null;
      }
   }

   public static final class zza {
      private boolean zzDu;
      private boolean zzDv;
      private boolean zzDw;
      private boolean zzDx;
      private boolean zzDy;

      public zzfq zzeP() {
         return new zzfq(this);
      }

      public zzfq.zza zzq(boolean var1) {
         this.zzDu = var1;
         return this;
      }

      public zzfq.zza zzr(boolean var1) {
         this.zzDv = var1;
         return this;
      }

      public zzfq.zza zzs(boolean var1) {
         this.zzDw = var1;
         return this;
      }

      public zzfq.zza zzt(boolean var1) {
         this.zzDx = var1;
         return this;
      }

      public zzfq.zza zzu(boolean var1) {
         this.zzDy = var1;
         return this;
      }
   }
}
