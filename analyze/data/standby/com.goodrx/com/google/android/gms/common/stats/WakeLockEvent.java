package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.stats.zzf;
import com.google.android.gms.common.stats.zzh;
import java.util.List;

public final class WakeLockEvent extends zzf implements SafeParcelable {
   public static final Creator<WakeLockEvent> CREATOR = new zzh();
   private final long mTimeout;
   final int mVersionCode;
   private final String zzanQ;
   private final int zzanR;
   private final List<String> zzanS;
   private final String zzanT;
   private int zzanU;
   private final String zzanV;
   private final String zzanW;
   private final float zzanX;
   private final long zzane;
   private int zzanf;
   private final long zzanm;
   private long zzano;

   WakeLockEvent(int var1, long var2, int var4, String var5, int var6, List<String> var7, String var8, long var9, int var11, String var12, String var13, float var14, long var15) {
      this.mVersionCode = var1;
      this.zzane = var2;
      this.zzanf = var4;
      this.zzanQ = var5;
      this.zzanV = var12;
      this.zzanR = var6;
      this.zzano = -1L;
      this.zzanS = var7;
      this.zzanT = var8;
      this.zzanm = var9;
      this.zzanU = var11;
      this.zzanW = var13;
      this.zzanX = var14;
      this.mTimeout = var15;
   }

   public WakeLockEvent(long var1, int var3, String var4, int var5, List<String> var6, String var7, long var8, int var10, String var11, String var12, float var13, long var14) {
      this(1, var1, var3, var4, var5, var6, var7, var8, var10, var11, var12, var13, var14);
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
      zzh.zza(this, var1, var2);
   }

   public String zzrK() {
      return this.zzanT;
   }

   public long zzrL() {
      return this.zzano;
   }

   public long zzrN() {
      return this.zzanm;
   }

   public String zzrO() {
      StringBuilder var1 = (new StringBuilder()).append("\t").append(this.zzrR()).append("\t").append(this.zzrT()).append("\t");
      String var2;
      if(this.zzrU() == null) {
         var2 = "";
      } else {
         var2 = TextUtils.join(",", this.zzrU());
      }

      StringBuilder var3 = var1.append(var2).append("\t").append(this.zzrV()).append("\t");
      String var4;
      if(this.zzrS() == null) {
         var4 = "";
      } else {
         var4 = this.zzrS();
      }

      StringBuilder var5 = var3.append(var4).append("\t");
      String var6;
      if(this.zzrW() == null) {
         var6 = "";
      } else {
         var6 = this.zzrW();
      }

      return var5.append(var6).append("\t").append(this.zzrX()).toString();
   }

   public String zzrR() {
      return this.zzanQ;
   }

   public String zzrS() {
      return this.zzanV;
   }

   public int zzrT() {
      return this.zzanR;
   }

   public List<String> zzrU() {
      return this.zzanS;
   }

   public int zzrV() {
      return this.zzanU;
   }

   public String zzrW() {
      return this.zzanW;
   }

   public float zzrX() {
      return this.zzanX;
   }

   public long zzrY() {
      return this.mTimeout;
   }
}
