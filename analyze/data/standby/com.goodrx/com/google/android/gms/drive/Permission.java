package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzj;

public class Permission implements SafeParcelable {
   public static final Creator<Permission> CREATOR = new zzj();
   final int mVersionCode;
   private String zzapk;
   private int zzapl;
   private String zzapm;
   private String zzapn;
   private int zzapo;
   private boolean zzapp;

   Permission(int var1, String var2, int var3, String var4, String var5, int var6, boolean var7) {
      this.mVersionCode = var1;
      this.zzapk = var2;
      this.zzapl = var3;
      this.zzapm = var4;
      this.zzapn = var5;
      this.zzapo = var6;
      this.zzapp = var7;
   }

   public static boolean zzcA(int var0) {
      switch(var0) {
      case 0:
      case 1:
      case 2:
      case 3:
         return true;
      default:
         return false;
      }
   }

   public static boolean zzcz(int var0) {
      switch(var0) {
      case 256:
      case 257:
      case 258:
         return true;
      default:
         return false;
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(var1 != this) {
            Permission var3 = (Permission)var1;
            if(!zzw.equal(this.zzapk, var3.zzapk) || this.zzapl != var3.zzapl || this.zzapo != var3.zzapo || this.zzapp != var3.zzapp) {
               return false;
            }
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   public int getRole() {
      return !zzcA(this.zzapo)?-1:this.zzapo;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzapk, Integer.valueOf(this.zzapl), Integer.valueOf(this.zzapo), Boolean.valueOf(this.zzapp)};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }

   public String zzsO() {
      return !zzcz(this.zzapl)?null:this.zzapk;
   }

   public int zzsP() {
      return !zzcz(this.zzapl)?-1:this.zzapl;
   }

   public String zzsQ() {
      return this.zzapm;
   }

   public String zzsR() {
      return this.zzapn;
   }

   public boolean zzsS() {
      return this.zzapp;
   }
}
