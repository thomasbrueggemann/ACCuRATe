package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appdatasearch.zzd;
import com.google.android.gms.appdatasearch.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentSection implements SafeParcelable {
   public static final zzd CREATOR = new zzd();
   public static final int zzTM = Integer.parseInt("-1");
   private static final RegisterSectionInfo zzTN = (new RegisterSectionInfo.zza("SsbContext")).zzM(true).zzbB("blob").zzmh();
   final int mVersionCode;
   public final String zzTO;
   final RegisterSectionInfo zzTP;
   public final int zzTQ;
   public final byte[] zzTR;

   DocumentSection(int var1, String var2, RegisterSectionInfo var3, int var4, byte[] var5) {
      boolean var6;
      if(var4 != zzTM && zzh.zzao(var4) == null) {
         var6 = false;
      } else {
         var6 = true;
      }

      zzx.zzb(var6, "Invalid section type " + var4);
      this.mVersionCode = var1;
      this.zzTO = var2;
      this.zzTP = var3;
      this.zzTQ = var4;
      this.zzTR = var5;
      String var7 = this.zzmf();
      if(var7 != null) {
         throw new IllegalArgumentException(var7);
      }
   }

   public DocumentSection(String var1, RegisterSectionInfo var2) {
      this(1, var1, var2, zzTM, (byte[])null);
   }

   public DocumentSection(String var1, RegisterSectionInfo var2, String var3) {
      this(1, var1, var2, zzh.zzbA(var3), (byte[])null);
   }

   public DocumentSection(byte[] var1, RegisterSectionInfo var2) {
      this(1, (String)null, var2, zzTM, var1);
   }

   public static DocumentSection zzh(byte[] var0) {
      return new DocumentSection(var0, zzTN);
   }

   public int describeContents() {
      zzd var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd var10000 = CREATOR;
      zzd.zza(this, var1, var2);
   }

   public String zzmf() {
      return this.zzTQ != zzTM && zzh.zzao(this.zzTQ) == null?"Invalid section type " + this.zzTQ:(this.zzTO != null && this.zzTR != null?"Both content and blobContent set":null);
   }
}
