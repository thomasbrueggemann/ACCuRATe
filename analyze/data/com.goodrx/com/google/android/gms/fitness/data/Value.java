package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.MapValue;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.internal.zzmy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public final class Value implements SafeParcelable {
   public static final Creator<Value> CREATOR = new zzu();
   private final int mVersionCode;
   private final int zzawZ;
   private float zzaxe;
   private boolean zzaxq;
   private String zzaxr;
   private Map<String, MapValue> zzaxs;
   private int[] zzaxt;
   private float[] zzaxu;
   private byte[] zzaxv;

   Value(int var1, int var2, boolean var3, float var4, String var5, Bundle var6, int[] var7, float[] var8, byte[] var9) {
      this.mVersionCode = var1;
      this.zzawZ = var2;
      this.zzaxq = var3;
      this.zzaxe = var4;
      this.zzaxr = var5;
      this.zzaxs = zzv(var6);
      this.zzaxt = var7;
      this.zzaxu = var8;
      this.zzaxv = var9;
   }

   private boolean zza(Value var1) {
      if(this.zzawZ == var1.zzawZ && this.zzaxq == var1.zzaxq) {
         switch(this.zzawZ) {
         case 1:
            if(this.asInt() != var1.asInt()) {
               return false;
            }
            break;
         case 2:
            if(this.zzaxe != var1.zzaxe) {
               return false;
            }
            break;
         case 3:
            return zzw.equal(this.zzaxr, var1.zzaxr);
         case 4:
            return zzw.equal(this.zzaxs, var1.zzaxs);
         case 5:
            return Arrays.equals(this.zzaxt, var1.zzaxt);
         case 6:
            return Arrays.equals(this.zzaxu, var1.zzaxu);
         case 7:
            return Arrays.equals(this.zzaxv, var1.zzaxv);
         default:
            if(this.zzaxe != var1.zzaxe) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private static Map<String, MapValue> zzv(Bundle var0) {
      if(var0 == null) {
         return null;
      } else {
         var0.setClassLoader(MapValue.class.getClassLoader());
         ArrayMap var1 = new ArrayMap(var0.size());
         Iterator var2 = var0.keySet().iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.put(var3, var0.getParcelable(var3));
         }

         return var1;
      }
   }

   public int asInt() {
      byte var1 = 1;
      if(this.zzawZ != var1) {
         var1 = 0;
      }

      zzx.zza((boolean)var1, "Value is not in int format");
      return Float.floatToRawIntBits(this.zzaxe);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Value && this.zza((Value)var1);
   }

   public int getFormat() {
      return this.zzawZ;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Float.valueOf(this.zzaxe), this.zzaxr, this.zzaxs, this.zzaxt, this.zzaxu, this.zzaxv};
      return zzw.hashCode(var1);
   }

   public boolean isSet() {
      return this.zzaxq;
   }

   public String toString() {
      if(!this.zzaxq) {
         return "unset";
      } else {
         switch(this.zzawZ) {
         case 1:
            return Integer.toString(this.asInt());
         case 2:
            return Float.toString(this.zzaxe);
         case 3:
            return this.zzaxr;
         case 4:
            return (new TreeMap(this.zzaxs)).toString();
         case 5:
            return Arrays.toString(this.zzaxt);
         case 6:
            return Arrays.toString(this.zzaxu);
         case 7:
            return zzmy.zza(this.zzaxv, 0, this.zzaxv.length, false);
         default:
            return "unknown";
         }
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzu.zza(this, var1, var2);
   }

   String zzuA() {
      return this.zzaxr;
   }

   Bundle zzuB() {
      if(this.zzaxs == null) {
         return null;
      } else {
         Bundle var1 = new Bundle(this.zzaxs.size());
         Iterator var2 = this.zzaxs.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.putParcelable((String)var3.getKey(), (Parcelable)var3.getValue());
         }

         return var1;
      }
   }

   int[] zzuC() {
      return this.zzaxt;
   }

   float[] zzuD() {
      return this.zzaxu;
   }

   byte[] zzuE() {
      return this.zzaxv;
   }

   float zzuv() {
      return this.zzaxe;
   }
}
