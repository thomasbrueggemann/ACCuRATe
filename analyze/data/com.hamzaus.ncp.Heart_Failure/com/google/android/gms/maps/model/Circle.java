package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_60;

public final class Circle {
   private final class_60 aao;

   public Circle(class_60 var1) {
      this.aao = (class_60)class_347.method_2170(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Circle)) {
         return false;
      } else {
         try {
            boolean var3 = this.aao.method_329(((Circle)var1).aao);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public LatLng getCenter() {
      try {
         LatLng var2 = this.aao.getCenter();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int getFillColor() {
      try {
         int var2 = this.aao.getFillColor();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var2 = this.aao.getId();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public double getRadius() {
      try {
         double var2 = this.aao.getRadius();
         return var2;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public int getStrokeColor() {
      try {
         int var2 = this.aao.getStrokeColor();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getStrokeWidth() {
      try {
         float var2 = this.aao.getStrokeWidth();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var2 = this.aao.getZIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.aao.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var2 = this.aao.isVisible();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.aao.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setCenter(LatLng var1) {
      try {
         this.aao.setCenter(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setFillColor(int var1) {
      try {
         this.aao.setFillColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setRadius(double var1) {
      try {
         this.aao.setRadius(var1);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setStrokeColor(int var1) {
      try {
         this.aao.setStrokeColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setStrokeWidth(float var1) {
      try {
         this.aao.setStrokeWidth(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.aao.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.aao.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
