package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.common.stats.zzf;

public final class ConnectionEvent extends zzf implements SafeParcelable {
   public static final Creator<ConnectionEvent> CREATOR = new zza();
   final int mVersionCode;
   private final long zzane;
   private int zzanf;
   private final String zzang;
   private final String zzanh;
   private final String zzani;
   private final String zzanj;
   private final String zzank;
   private final String zzanl;
   private final long zzanm;
   private final long zzann;
   private long zzano;

   ConnectionEvent(int var1, long var2, int var4, String var5, String var6, String var7, String var8, String var9, String var10, long var11, long var13) {
      this.mVersionCode = var1;
      this.zzane = var2;
      this.zzanf = var4;
      this.zzang = var5;
      this.zzanh = var6;
      this.zzani = var7;
      this.zzanj = var8;
      this.zzano = -1L;
      this.zzank = var9;
      this.zzanl = var10;
      this.zzanm = var11;
      this.zzann = var13;
   }

   public ConnectionEvent(long var1, int var3, String var4, String var5, String var6, String var7, String var8, String var9, long var10, long var12) {
      this(1, var1, var3, var4, var5, var6, var7, var8, var9, var10, var12);
   }

   public int describeContents() {
      return 0;
   }

   public int getEventType() {
      return this.zzanf;
   }

   public long getTimeMillis() {
      return this.zzane;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public String zzrF() {
      return this.zzang;
   }

   public String zzrG() {
      return this.zzanh;
   }

   public String zzrH() {
      return this.zzani;
   }

   public String zzrI() {
      return this.zzanj;
   }

   public String zzrJ() {
      return this.zzank;
   }

   public String zzrK() {
      return this.zzanl;
   }

   public long zzrL() {
      return this.zzano;
   }

   public long zzrM() {
      return this.zzann;
   }

   public long zzrN() {
      return this.zzanm;
   }

   public String zzrO() {
      StringBuilder var1 = (new StringBuilder()).append("\t").append(this.zzrF()).append("/").append(this.zzrG()).append("\t").append(this.zzrH()).append("/").append(this.zzrI()).append("\t");
      String var2;
      if(this.zzank == null) {
         var2 = "";
      } else {
         var2 = this.zzank;
      }

      return var1.append(var2).append("\t").append(this.zzrM()).toString();
   }
}
