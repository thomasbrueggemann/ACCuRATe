package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_63;

public final class Marker {
   private final class_63 amo;

   public Marker(class_63 var1) {
      this.amo = (class_63)class_335.method_2311(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Marker)) {
         return false;
      } else {
         try {
            boolean var3 = this.amo.method_370(((Marker)var1).amo);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public float getAlpha() {
      try {
         float var2 = this.amo.getAlpha();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var2 = this.amo.getId();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public LatLng getPosition() {
      try {
         LatLng var2 = this.amo.getPosition();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getRotation() {
      try {
         float var2 = this.amo.getRotation();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getSnippet() {
      try {
         String var2 = this.amo.getSnippet();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getTitle() {
      try {
         String var2 = this.amo.getTitle();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.amo.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void hideInfoWindow() {
      try {
         this.amo.hideInfoWindow();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public boolean isDraggable() {
      try {
         boolean var2 = this.amo.isDraggable();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isFlat() {
      try {
         boolean var2 = this.amo.isFlat();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isInfoWindowShown() {
      try {
         boolean var2 = this.amo.isInfoWindowShown();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var2 = this.amo.isVisible();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.amo.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setAlpha(float var1) {
      try {
         this.amo.setAlpha(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setAnchor(float var1, float var2) {
      try {
         this.amo.setAnchor(var1, var2);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setDraggable(boolean var1) {
      try {
         this.amo.setDraggable(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setFlat(boolean var1) {
      try {
         this.amo.setFlat(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setIcon(BitmapDescriptor var1) {
      try {
         this.amo.method_371(var1.method_2288());
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setInfoWindowAnchor(float var1, float var2) {
      try {
         this.amo.setInfoWindowAnchor(var1, var2);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setPosition(LatLng var1) {
      try {
         this.amo.setPosition(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setRotation(float var1) {
      try {
         this.amo.setRotation(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setSnippet(String var1) {
      try {
         this.amo.setSnippet(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setTitle(String var1) {
      try {
         this.amo.setTitle(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.amo.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void showInfoWindow() {
      try {
         this.amo.showInfoWindow();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }
}
