package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
   private final IUiSettingsDelegate alH;

   UiSettings(IUiSettingsDelegate var1) {
      this.alH = var1;
   }

   public boolean isCompassEnabled() {
      try {
         boolean var2 = this.alH.isCompassEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isIndoorLevelPickerEnabled() {
      try {
         boolean var2 = this.alH.isIndoorLevelPickerEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isMapToolbarEnabled() {
      try {
         boolean var2 = this.alH.isMapToolbarEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isMyLocationButtonEnabled() {
      try {
         boolean var2 = this.alH.isMyLocationButtonEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isRotateGesturesEnabled() {
      try {
         boolean var2 = this.alH.isRotateGesturesEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isScrollGesturesEnabled() {
      try {
         boolean var2 = this.alH.isScrollGesturesEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isTiltGesturesEnabled() {
      try {
         boolean var2 = this.alH.isTiltGesturesEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isZoomControlsEnabled() {
      try {
         boolean var2 = this.alH.isZoomControlsEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isZoomGesturesEnabled() {
      try {
         boolean var2 = this.alH.isZoomGesturesEnabled();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setAllGesturesEnabled(boolean var1) {
      try {
         this.alH.setAllGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setCompassEnabled(boolean var1) {
      try {
         this.alH.setCompassEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setIndoorLevelPickerEnabled(boolean var1) {
      try {
         this.alH.setIndoorLevelPickerEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setMapToolbarEnabled(boolean var1) {
      try {
         this.alH.setMapToolbarEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setMyLocationButtonEnabled(boolean var1) {
      try {
         this.alH.setMyLocationButtonEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setRotateGesturesEnabled(boolean var1) {
      try {
         this.alH.setRotateGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setScrollGesturesEnabled(boolean var1) {
      try {
         this.alH.setScrollGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setTiltGesturesEnabled(boolean var1) {
      try {
         this.alH.setTiltGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZoomControlsEnabled(boolean var1) {
      try {
         this.alH.setZoomControlsEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZoomGesturesEnabled(boolean var1) {
      try {
         this.alH.setZoomGesturesEnabled(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
