package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_55;

public final class Marker {
   private final class_55 aaL;

   public Marker(class_55 var1) {
      this.aaL = (class_55)class_347.method_2170(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Marker)) {
         return false;
      } else {
         try {
            boolean var3 = this.aaL.method_254(((Marker)var1).aaL);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public float getAlpha() {
      try {
         float var2 = this.aaL.getAlpha();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var2 = this.aaL.getId();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public LatLng getPosition() {
      try {
         LatLng var2 = this.aaL.getPosition();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getRotation() {
      try {
         float var2 = this.aaL.getRotation();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getSnippet() {
      try {
         String var2 = this.aaL.getSnippet();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getTitle() {
      try {
         String var2 = this.aaL.getTitle();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.aaL.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void hideInfoWindow() {
      try {
         this.aaL.hideInfoWindow();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public boolean isDraggable() {
      try {
         boolean var2 = this.aaL.isDraggable();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isFlat() {
      try {
         boolean var2 = this.aaL.isFlat();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isInfoWindowShown() {
      try {
         boolean var2 = this.aaL.isInfoWindowShown();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var2 = this.aaL.isVisible();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.aaL.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setAlpha(float var1) {
      try {
         this.aaL.setAlpha(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setAnchor(float var1, float var2) {
      try {
         this.aaL.setAnchor(var1, var2);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setDraggable(boolean var1) {
      try {
         this.aaL.setDraggable(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setFlat(boolean var1) {
      try {
         this.aaL.setFlat(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setIcon(BitmapDescriptor var1) {
      try {
         this.aaL.method_255(var1.method_1958());
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setInfoWindowAnchor(float var1, float var2) {
      try {
         this.aaL.setInfoWindowAnchor(var1, var2);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setPosition(LatLng var1) {
      try {
         this.aaL.setPosition(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setRotation(float var1) {
      try {
         this.aaL.setRotation(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setSnippet(String var1) {
      try {
         this.aaL.setSnippet(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setTitle(String var1) {
      try {
         this.aaL.setTitle(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.aaL.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void showInfoWindow() {
      try {
         this.aaL.showInfoWindow();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }
}
