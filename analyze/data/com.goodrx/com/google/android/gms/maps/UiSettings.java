package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
   private final IUiSettingsDelegate zzaST;

   UiSettings(IUiSettingsDelegate var1) {
      this.zzaST = var1;
   }

   public void setAllGesturesEnabled(boolean var1) {
      try {
         this.zzaST.setAllGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZoomControlsEnabled(boolean var1) {
      try {
         this.zzaST.setZoomControlsEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
