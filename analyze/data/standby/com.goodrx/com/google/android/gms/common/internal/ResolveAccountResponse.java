package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountResponse implements SafeParcelable {
   public static final Creator<ResolveAccountResponse> CREATOR = new zzz();
   final int mVersionCode;
   private boolean zzahx;
   IBinder zzakA;
   private ConnectionResult zzams;
   private boolean zzamt;

   ResolveAccountResponse(int var1, IBinder var2, ConnectionResult var3, boolean var4, boolean var5) {
      this.mVersionCode = var1;
      this.zzakA = var2;
      this.zzams = var3;
      this.zzahx = var4;
      this.zzamt = var5;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof ResolveAccountResponse)) {
            return false;
         }

         ResolveAccountResponse var2 = (ResolveAccountResponse)var1;
         if(!this.zzams.equals(var2.zzams) || !this.zzqX().equals(var2.zzqX())) {
            return false;
         }
      }

      return true;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzz.zza(this, var1, var2);
   }

   public zzp zzqX() {
      return zzp.zza.zzaP(this.zzakA);
   }

   public ConnectionResult zzqY() {
      return this.zzams;
   }

   public boolean zzqZ() {
      return this.zzahx;
   }

   public boolean zzra() {
      return this.zzamt;
   }
}
