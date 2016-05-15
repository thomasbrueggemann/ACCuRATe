package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.request.zzf;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import java.util.Collections;
import java.util.List;

@zzhb
public final class AdRequestInfoParcel implements SafeParcelable {
   public static final zzf CREATOR = new zzf();
   public final ApplicationInfo applicationInfo;
   public final int versionCode;
   public final Bundle zzHA;
   public final boolean zzHB;
   public final Messenger zzHC;
   public final int zzHD;
   public final int zzHE;
   public final float zzHF;
   public final String zzHG;
   public final long zzHH;
   public final String zzHI;
   public final List<String> zzHJ;
   public final List<String> zzHK;
   public final long zzHL;
   public final CapabilityParcel zzHM;
   public final String zzHN;
   public final float zzHO;
   public final int zzHP;
   public final int zzHQ;
   public final Bundle zzHs;
   public final AdRequestParcel zzHt;
   public final PackageInfo zzHu;
   public final String zzHv;
   public final String zzHw;
   public final String zzHx;
   public final Bundle zzHy;
   public final int zzHz;
   public final NativeAdOptionsParcel zzrD;
   public final List<String> zzrH;
   public final String zzri;
   public final String zzrj;
   public final VersionInfoParcel zzrl;
   public final AdSizeParcel zzrp;

   AdRequestInfoParcel(int var1, Bundle var2, AdRequestParcel var3, AdSizeParcel var4, String var5, ApplicationInfo var6, PackageInfo var7, String var8, String var9, String var10, VersionInfoParcel var11, Bundle var12, int var13, List<String> var14, Bundle var15, boolean var16, Messenger var17, int var18, int var19, float var20, String var21, long var22, String var24, List<String> var25, String var26, NativeAdOptionsParcel var27, List<String> var28, long var29, CapabilityParcel var31, String var32, float var33, int var34, int var35) {
      this.versionCode = var1;
      this.zzHs = var2;
      this.zzHt = var3;
      this.zzrp = var4;
      this.zzrj = var5;
      this.applicationInfo = var6;
      this.zzHu = var7;
      this.zzHv = var8;
      this.zzHw = var9;
      this.zzHx = var10;
      this.zzrl = var11;
      this.zzHy = var12;
      this.zzHz = var13;
      this.zzrH = var14;
      List var36;
      if(var28 == null) {
         var36 = Collections.emptyList();
      } else {
         var36 = Collections.unmodifiableList(var28);
      }

      this.zzHK = var36;
      this.zzHA = var15;
      this.zzHB = var16;
      this.zzHC = var17;
      this.zzHD = var18;
      this.zzHE = var19;
      this.zzHF = var20;
      this.zzHG = var21;
      this.zzHH = var22;
      this.zzHI = var24;
      List var37;
      if(var25 == null) {
         var37 = Collections.emptyList();
      } else {
         var37 = Collections.unmodifiableList(var25);
      }

      this.zzHJ = var37;
      this.zzri = var26;
      this.zzrD = var27;
      this.zzHL = var29;
      this.zzHM = var31;
      this.zzHN = var32;
      this.zzHO = var33;
      this.zzHP = var34;
      this.zzHQ = var35;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }
}
