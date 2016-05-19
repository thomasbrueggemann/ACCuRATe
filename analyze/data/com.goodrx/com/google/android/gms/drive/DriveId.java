package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zze;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zzsu;

public class DriveId implements SafeParcelable {
   public static final Creator<DriveId> CREATOR = new zze();
   final int mVersionCode;
   final String zzaoL;
   final long zzaoM;
   final int zzaoN;
   private volatile String zzaoO = null;
   final long zzaou;
   private volatile String zzaow = null;

   DriveId(int var1, String var2, long var3, long var5, int var7) {
      this.mVersionCode = var1;
      this.zzaoL = var2;
      boolean var8;
      if(!"".equals(var2)) {
         var8 = true;
      } else {
         var8 = false;
      }

      boolean var9;
      label15: {
         zzx.zzac(var8);
         if(var2 == null) {
            long var11;
            int var10 = (var11 = var3 - -1L) == 0L?0:(var11 < 0L?-1:1);
            var9 = false;
            if(var10 == 0) {
               break label15;
            }
         }

         var9 = true;
      }

      zzx.zzac(var9);
      this.zzaoM = var3;
      this.zzaou = var5;
      this.zzaoN = var7;
   }

   public int describeContents() {
      return 0;
   }

   public final String encodeToString() {
      if(this.zzaow == null) {
         String var1 = Base64.encodeToString(this.zzsu(), 10);
         this.zzaow = "DriveId:" + var1;
      }

      return this.zzaow;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 instanceof DriveId) {
         DriveId var3 = (DriveId)var1;
         if(var3.zzaou == this.zzaou) {
            if(var3.zzaoM == -1L && this.zzaoM == -1L) {
               return var3.zzaoL.equals(this.zzaoL);
            }

            if(this.zzaoL == null || var3.zzaoL == null) {
               if(var3.zzaoM != this.zzaoM) {
                  var2 = false;
               }

               return var2;
            }

            if(var3.zzaoM == this.zzaoM) {
               if(var3.zzaoL.equals(this.zzaoL)) {
                  return var2;
               }

               zzz.zzz("DriveId", "Unexpected unequal resourceId for same DriveId object.");
               return false;
            }
         }
      }

      return false;
   }

   public int hashCode() {
      return this.zzaoM == -1L?this.zzaoL.hashCode():(this.zzaou + String.valueOf(this.zzaoM)).hashCode();
   }

   public String toString() {
      return this.encodeToString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }

   final byte[] zzsu() {
      zzat var1 = new zzat();
      var1.versionCode = this.mVersionCode;
      String var2;
      if(this.zzaoL == null) {
         var2 = "";
      } else {
         var2 = this.zzaoL;
      }

      var1.zzarY = var2;
      var1.zzarZ = this.zzaoM;
      var1.zzarW = this.zzaou;
      var1.zzasa = this.zzaoN;
      return zzsu.toByteArray(var1);
   }
}
