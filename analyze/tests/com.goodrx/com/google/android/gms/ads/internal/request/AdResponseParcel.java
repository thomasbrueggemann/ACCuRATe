package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.LargeParcelTeleporter;
import com.google.android.gms.ads.internal.request.StringParcel;
import com.google.android.gms.ads.internal.request.zzh;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import java.util.Collections;
import java.util.List;

@zzhb
public final class AdResponseParcel implements SafeParcelable {
   public static final zzh CREATOR = new zzh();
   public String body;
   public final int errorCode;
   public final int orientation;
   public final int versionCode;
   public final List<String> zzBQ;
   public final List<String> zzBR;
   public final long zzBU;
   private AdRequestInfoParcel zzCu;
   public final String zzEF;
   public final boolean zzHB;
   public final long zzHS;
   public final boolean zzHT;
   public final long zzHU;
   public final List<String> zzHV;
   public final String zzHW;
   public final long zzHX;
   public final String zzHY;
   public final boolean zzHZ;
   public final String zzIa;
   public final String zzIb;
   public final boolean zzIc;
   public final boolean zzId;
   public final boolean zzIe;
   public final int zzIf;
   public LargeParcelTeleporter zzIg;
   public String zzIh;
   public String zzIi;
   @Nullable
   public RewardItemParcel zzIj;
   @Nullable
   public List<String> zzIk;
   @Nullable
   public List<String> zzIl;
   @Nullable
   public boolean zzIm;
   public final boolean zzuk;
   public boolean zzul;
   public boolean zzum;

   AdResponseParcel(int var1, String var2, String var3, List<String> var4, int var5, List<String> var6, long var7, boolean var9, long var10, List<String> var12, long var13, int var15, String var16, long var17, String var19, boolean var20, String var21, String var22, boolean var23, boolean var24, boolean var25, boolean var26, boolean var27, int var28, LargeParcelTeleporter var29, String var30, String var31, boolean var32, boolean var33, RewardItemParcel var34, List<String> var35, List<String> var36, boolean var37) {
      this.versionCode = var1;
      this.zzEF = var2;
      this.body = var3;
      List var38;
      if(var4 != null) {
         var38 = Collections.unmodifiableList(var4);
      } else {
         var38 = null;
      }

      this.zzBQ = var38;
      this.errorCode = var5;
      List var39;
      if(var6 != null) {
         var39 = Collections.unmodifiableList(var6);
      } else {
         var39 = null;
      }

      this.zzBR = var39;
      this.zzHS = var7;
      this.zzHT = var9;
      this.zzHU = var10;
      List var40;
      if(var12 != null) {
         var40 = Collections.unmodifiableList(var12);
      } else {
         var40 = null;
      }

      this.zzHV = var40;
      this.zzBU = var13;
      this.orientation = var15;
      this.zzHW = var16;
      this.zzHX = var17;
      this.zzHY = var19;
      this.zzHZ = var20;
      this.zzIa = var21;
      this.zzIb = var22;
      this.zzIc = var23;
      this.zzuk = var24;
      this.zzHB = var25;
      this.zzId = var26;
      this.zzIe = var27;
      this.zzIf = var28;
      this.zzIg = var29;
      this.zzIh = var30;
      this.zzIi = var31;
      if(this.body == null && this.zzIg != null) {
         StringParcel var41 = (StringParcel)this.zzIg.zza(StringParcel.CREATOR);
         if(var41 != null && !TextUtils.isEmpty(var41.zzgz())) {
            this.body = var41.zzgz();
         }
      }

      this.zzul = var32;
      this.zzum = var33;
      this.zzIj = var34;
      this.zzIk = var35;
      this.zzIl = var36;
      this.zzIm = var37;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.zzCu != null && this.zzCu.versionCode >= 9 && !TextUtils.isEmpty(this.body)) {
         this.zzIg = new LargeParcelTeleporter(new StringParcel(this.body));
         this.body = null;
      }

      zzh.zza(this, var1, var2);
   }
}
