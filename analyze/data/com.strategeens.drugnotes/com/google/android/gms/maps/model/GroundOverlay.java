package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_61;

public final class GroundOverlay {
   private final class_61 alZ;

   public GroundOverlay(class_61 var1) {
      this.alZ = (class_61)class_335.method_2311(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof GroundOverlay)) {
         return false;
      } else {
         try {
            boolean var3 = this.alZ.method_294(((GroundOverlay)var1).alZ);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public float getBearing() {
      try {
         float var2 = this.alZ.getBearing();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public LatLngBounds getBounds() {
      try {
         LatLngBounds var2 = this.alZ.getBounds();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getHeight() {
      try {
         float var2 = this.alZ.getHeight();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var2 = this.alZ.getId();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public LatLng getPosition() {
      try {
         LatLng var2 = this.alZ.getPosition();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getTransparency() {
      try {
         float var2 = this.alZ.getTransparency();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getWidth() {
      try {
         float var2 = this.alZ.getWidth();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var2 = this.alZ.getZIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.alZ.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var2 = this.alZ.isVisible();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.alZ.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setBearing(float var1) {
      try {
         this.alZ.setBearing(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setDimensions(float var1) {
      try {
         this.alZ.setDimensions(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setDimensions(float var1, float var2) {
      try {
         this.alZ.method_292(var1, var2);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setImage(BitmapDescriptor var1) {
      try {
         this.alZ.method_295(var1.method_2288());
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setPosition(LatLng var1) {
      try {
         this.alZ.setPosition(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setPositionFromBounds(LatLngBounds var1) {
      try {
         this.alZ.setPositionFromBounds(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setTransparency(float var1) {
      try {
         this.alZ.setTransparency(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.alZ.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.alZ.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
