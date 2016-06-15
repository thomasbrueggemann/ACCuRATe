package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
   private final IUiSettingsDelegate aaf;

   UiSettings(IUiSettingsDelegate var1) {
      this.aaf = var1;
   }

   public boolean isCompassEnabled() {
      try {
         boolean var2 = this.aaf.isCompassEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isIndoorLevelPickerEnabled() {
      try {
         boolean var2 = this.aaf.isIndoorLevelPickerEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isMyLocationButtonEnabled() {
      try {
         boolean var2 = this.aaf.isMyLocationButtonEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isRotateGesturesEnabled() {
      try {
         boolean var2 = this.aaf.isRotateGesturesEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isScrollGesturesEnabled() {
      try {
         boolean var2 = this.aaf.isScrollGesturesEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isTiltGesturesEnabled() {
      try {
         boolean var2 = this.aaf.isTiltGesturesEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isZoomControlsEnabled() {
      try {
         boolean var2 = this.aaf.isZoomControlsEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isZoomGesturesEnabled() {
      try {
         boolean var2 = this.aaf.isZoomGesturesEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setAllGesturesEnabled(boolean var1) {
      try {
         this.aaf.setAllGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setCompassEnabled(boolean var1) {
      try {
         this.aaf.setCompassEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setIndoorLevelPickerEnabled(boolean var1) {
      try {
         this.aaf.setIndoorLevelPickerEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setMyLocationButtonEnabled(boolean var1) {
      try {
         this.aaf.setMyLocationButtonEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setRotateGesturesEnabled(boolean var1) {
      try {
         this.aaf.setRotateGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setScrollGesturesEnabled(boolean var1) {
      try {
         this.aaf.setScrollGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setTiltGesturesEnabled(boolean var1) {
      try {
         this.aaf.setTiltGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZoomControlsEnabled(boolean var1) {
      try {
         this.aaf.setZoomControlsEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZoomGesturesEnabled(boolean var1) {
      try {
         this.aaf.setZoomGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
