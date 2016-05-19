package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.internal.zzah;
import com.google.android.gms.measurement.internal.zzai;

public class UserAttributeParcel implements SafeParcelable {
   public static final zzah CREATOR = new zzah();
   public final String name;
   public final int versionCode;
   public final String zzaVW;
   public final long zzaZm;
   public final Long zzaZn;
   public final Float zzaZo;
   public final String zzamJ;

   UserAttributeParcel(int var1, String var2, long var3, Long var5, Float var6, String var7, String var8) {
      this.versionCode = var1;
      this.name = var2;
      this.zzaZm = var3;
      this.zzaZn = var5;
      this.zzaZo = var6;
      this.zzamJ = var7;
      this.zzaVW = var8;
   }

   UserAttributeParcel(zzai var1) {
      this(var1.mName, var1.zzaZp, var1.zzNc, var1.zzaUa);
   }

   UserAttributeParcel(String var1, long var2, Object var4, String var5) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      this.versionCode = 1;
      this.name = var1;
      this.zzaZm = var2;
      this.zzaVW = var5;
      if(var4 == null) {
         this.zzaZn = null;
         this.zzaZo = null;
         this.zzamJ = null;
      } else if(var4 instanceof Long) {
         this.zzaZn = (Long)var4;
         this.zzaZo = null;
         this.zzamJ = null;
      } else if(var4 instanceof Float) {
         this.zzaZn = null;
         this.zzaZo = (Float)var4;
         this.zzamJ = null;
      } else if(var4 instanceof String) {
         this.zzaZn = null;
         this.zzaZo = null;
         this.zzamJ = (String)var4;
      } else {
         throw new IllegalArgumentException("User attribute given of un-supported type");
      }
   }

   public int describeContents() {
      return 0;
   }

   public Object getValue() {
      return this.zzaZn != null?this.zzaZn:(this.zzaZo != null?this.zzaZo:(this.zzamJ != null?this.zzamJ:null));
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzah.zza(this, var1, var2);
   }
}
