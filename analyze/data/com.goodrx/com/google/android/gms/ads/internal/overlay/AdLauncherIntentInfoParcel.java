package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class AdLauncherIntentInfoParcel implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   public final Intent intent;
   public final String intentAction;
   public final String mimeType;
   public final String packageName;
   public final String url;
   public final int versionCode;
   public final String zzDK;
   public final String zzDL;
   public final String zzDM;

   public AdLauncherIntentInfoParcel(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, Intent var9) {
      this.versionCode = var1;
      this.intentAction = var2;
      this.url = var3;
      this.mimeType = var4;
      this.packageName = var5;
      this.zzDK = var6;
      this.zzDL = var7;
      this.zzDM = var8;
      this.intent = var9;
   }

   public AdLauncherIntentInfoParcel(Intent var1) {
      this(2, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, var1);
   }

   public AdLauncherIntentInfoParcel(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      this(2, var1, var2, var3, var4, var5, var6, var7, (Intent)null);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
