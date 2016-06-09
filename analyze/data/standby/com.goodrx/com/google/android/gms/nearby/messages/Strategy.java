package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.zzd;
import java.util.ArrayList;

public class Strategy implements SafeParcelable {
   public static final Strategy BLE_ONLY = (new Strategy.Builder()).zzjg(2).setTtlSeconds(Integer.MAX_VALUE).build();
   public static final Creator<Strategy> CREATOR = new zzd();
   public static final Strategy DEFAULT = (new Strategy.Builder()).build();
   @Deprecated
   public static final Strategy zzbbK;
   final int mVersionCode;
   @Deprecated
   final int zzbbL;
   final int zzbbM;
   final int zzbbN;
   @Deprecated
   final boolean zzbbO;
   final int zzbbP;
   final int zzbbQ;

   static {
      zzbbK = BLE_ONLY;
   }

   Strategy(int var1, int var2, int var3, int var4, boolean var5, int var6, int var7) {
      this.mVersionCode = var1;
      this.zzbbL = var2;
      if(var2 == 0) {
         this.zzbbQ = var7;
      } else {
         switch(var2) {
         case 2:
            this.zzbbQ = 1;
            break;
         case 3:
            this.zzbbQ = 2;
            break;
         default:
            this.zzbbQ = 3;
         }
      }

      this.zzbbN = var4;
      this.zzbbO = var5;
      if(var5) {
         this.zzbbP = 2;
         this.zzbbM = Integer.MAX_VALUE;
      } else {
         this.zzbbM = var3;
         switch(var6) {
         case -1:
         case 0:
         case 1:
         case 6:
            this.zzbbP = -1;
            return;
         case 2:
         case 3:
         case 4:
         case 5:
         default:
            this.zzbbP = var6;
         }
      }
   }

   private static String zzjd(int var0) {
      switch(var0) {
      case 0:
         return "DEFAULT";
      case 1:
         return "EARSHOT";
      default:
         return "UNKNOWN:" + var0;
      }
   }

   private static String zzje(int var0) {
      if(var0 == -1) {
         return "DEFAULT";
      } else {
         ArrayList var1 = new ArrayList();
         if((var0 & 4) > 0) {
            var1.add("AUDIO");
         }

         if((var0 & 2) > 0) {
            var1.add("BLE");
         }

         return var1.isEmpty()?"UNKNOWN:" + var0:var1.toString();
      }
   }

   private static String zzjf(int var0) {
      if(var0 == 3) {
         return "DEFAULT";
      } else {
         ArrayList var1 = new ArrayList();
         if((var0 & 1) > 0) {
            var1.add("BROADCAST");
         }

         if((var0 & 2) > 0) {
            var1.add("SCAN");
         }

         return var1.isEmpty()?"UNKNOWN:" + var0:var1.toString();
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof Strategy)) {
            return false;
         }

         Strategy var2 = (Strategy)var1;
         if(this.mVersionCode != var2.mVersionCode || this.zzbbQ != var2.zzbbQ || this.zzbbM != var2.zzbbM || this.zzbbN != var2.zzbbN || this.zzbbP != var2.zzbbP) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return 31 * (31 * (31 * (31 * this.mVersionCode + this.zzbbQ) + this.zzbbM) + this.zzbbN) + this.zzbbP;
   }

   public String toString() {
      return "Strategy{ttlSeconds=" + this.zzbbM + ", distanceType=" + zzjd(this.zzbbN) + ", discoveryMedium=" + zzje(this.zzbbP) + ", discoveryMode=" + zzjf(this.zzbbQ) + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }

   public int zzEr() {
      return this.zzbbP;
   }

   public int zzEs() {
      return this.zzbbQ;
   }

   public static class Builder {
      private int zzbbR = 3;
      private int zzbbS = 300;
      private int zzbbT = 0;
      private int zzbbU = -1;

      public Strategy build() {
         if(this.zzbbU == 2 && this.zzbbT == 1) {
            throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
         } else {
            return new Strategy(2, 0, this.zzbbS, this.zzbbT, false, this.zzbbU, this.zzbbR);
         }
      }

      public Strategy.Builder setTtlSeconds(int var1) {
         boolean var2;
         if(var1 != Integer.MAX_VALUE && (var1 <= 0 || var1 > 86400)) {
            var2 = false;
         } else {
            var2 = true;
         }

         Object[] var3 = new Object[]{Integer.valueOf(var1), Integer.valueOf(86400)};
         zzx.zzb(var2, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", var3);
         this.zzbbS = var1;
         return this;
      }

      public Strategy.Builder zzjg(int var1) {
         this.zzbbU = var1;
         return this;
      }
   }
}
