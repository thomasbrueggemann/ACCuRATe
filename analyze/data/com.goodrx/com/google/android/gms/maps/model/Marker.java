package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class Marker {
   private final com.google.android.gms.maps.model.internal.zzf zzaTy;

   public Marker(com.google.android.gms.maps.model.internal.zzf var1) {
      this.zzaTy = (com.google.android.gms.maps.model.internal.zzf)zzx.zzz(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Marker)) {
         return false;
      } else {
         try {
            boolean var3 = this.zzaTy.zzj(((Marker)var1).zzaTy);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public int hashCode() {
      try {
         int var2 = this.zzaTy.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setIcon(BitmapDescriptor var1) {
      try {
         this.zzaTy.zzw(var1.zzzH());
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
