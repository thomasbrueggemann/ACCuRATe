package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_61;

public final class GroundOverlay {
   private final class_61 aaw;

   public GroundOverlay(class_61 var1) {
      this.aaw = (class_61)class_347.method_2170(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof GroundOverlay)) {
         return false;
      } else {
         try {
            boolean var3 = this.aaw.method_331(((GroundOverlay)var1).aaw);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public float getBearing() {
      try {
         float var2 = this.aaw.getBearing();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public LatLngBounds getBounds() {
      try {
         LatLngBounds var2 = this.aaw.getBounds();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getHeight() {
      try {
         float var2 = this.aaw.getHeight();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var2 = this.aaw.getId();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public LatLng getPosition() {
      try {
         LatLng var2 = this.aaw.getPosition();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getTransparency() {
      try {
         float var2 = this.aaw.getTransparency();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getWidth() {
      try {
         float var2 = this.aaw.getWidth();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var2 = this.aaw.getZIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.aaw.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var2 = this.aaw.isVisible();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.aaw.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setBearing(float var1) {
      try {
         this.aaw.setBearing(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setDimensions(float var1) {
      try {
         this.aaw.setDimensions(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setDimensions(float var1, float var2) {
      try {
         this.aaw.method_330(var1, var2);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setImage(BitmapDescriptor var1) {
      try {
         this.aaw.method_332(var1.method_1958());
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setPosition(LatLng var1) {
      try {
         this.aaw.setPosition(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setPositionFromBounds(LatLngBounds var1) {
      try {
         this.aaw.setPositionFromBounds(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setTransparency(float var1) {
      try {
         this.aaw.setTransparency(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.aaw.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.aaw.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
