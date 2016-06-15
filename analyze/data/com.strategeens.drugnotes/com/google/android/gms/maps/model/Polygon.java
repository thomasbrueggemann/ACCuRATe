package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_64;
import java.util.List;

public final class Polygon {
   private final class_64 amw;

   public Polygon(class_64 var1) {
      this.amw = (class_64)class_335.method_2311(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Polygon)) {
         return false;
      } else {
         try {
            boolean var3 = this.amw.method_372(((Polygon)var1).amw);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public int getFillColor() {
      try {
         int var2 = this.amw.getFillColor();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public List<List<LatLng>> getHoles() {
      try {
         List var2 = this.amw.getHoles();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var2 = this.amw.getId();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public List<LatLng> getPoints() {
      try {
         List var2 = this.amw.getPoints();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int getStrokeColor() {
      try {
         int var2 = this.amw.getStrokeColor();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getStrokeWidth() {
      try {
         float var2 = this.amw.getStrokeWidth();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var2 = this.amw.getZIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.amw.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isGeodesic() {
      try {
         boolean var2 = this.amw.isGeodesic();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var2 = this.amw.isVisible();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.amw.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setFillColor(int var1) {
      try {
         this.amw.setFillColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setGeodesic(boolean var1) {
      try {
         this.amw.setGeodesic(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setHoles(List<? extends List<LatLng>> var1) {
      try {
         this.amw.setHoles(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setPoints(List<LatLng> var1) {
      try {
         this.amw.setPoints(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setStrokeColor(int var1) {
      try {
         this.amw.setStrokeColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setStrokeWidth(float var1) {
      try {
         this.amw.setStrokeWidth(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.amw.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.amw.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
