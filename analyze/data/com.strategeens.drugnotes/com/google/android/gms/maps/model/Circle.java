package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_60;

public final class Circle {
   private final class_60 alR;

   public Circle(class_60 var1) {
      this.alR = (class_60)class_335.method_2311(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Circle)) {
         return false;
      } else {
         try {
            boolean var3 = this.alR.method_291(((Circle)var1).alR);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public LatLng getCenter() {
      try {
         LatLng var2 = this.alR.getCenter();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int getFillColor() {
      try {
         int var2 = this.alR.getFillColor();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var2 = this.alR.getId();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public double getRadius() {
      try {
         double var2 = this.alR.getRadius();
         return var2;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public int getStrokeColor() {
      try {
         int var2 = this.alR.getStrokeColor();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getStrokeWidth() {
      try {
         float var2 = this.alR.getStrokeWidth();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var2 = this.alR.getZIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.alR.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var2 = this.alR.isVisible();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.alR.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setCenter(LatLng var1) {
      try {
         this.alR.setCenter(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setFillColor(int var1) {
      try {
         this.alR.setFillColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setRadius(double var1) {
      try {
         this.alR.setRadius(var1);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setStrokeColor(int var1) {
      try {
         this.alR.setStrokeColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setStrokeWidth(float var1) {
      try {
         this.alR.setStrokeWidth(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.alR.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.alR.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
