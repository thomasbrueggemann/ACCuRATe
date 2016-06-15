package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import java.util.List;

public final class Polyline {
   private final IPolylineDelegate aaX;

   public Polyline(IPolylineDelegate var1) {
      this.aaX = (IPolylineDelegate)class_347.method_2170(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Polyline)) {
         return false;
      } else {
         try {
            boolean var3 = this.aaX.equalsRemote(((Polyline)var1).aaX);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public int getColor() {
      try {
         int var2 = this.aaX.getColor();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var2 = this.aaX.getId();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public List<LatLng> getPoints() {
      try {
         List var2 = this.aaX.getPoints();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getWidth() {
      try {
         float var2 = this.aaX.getWidth();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var2 = this.aaX.getZIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.aaX.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isGeodesic() {
      try {
         boolean var2 = this.aaX.isGeodesic();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var2 = this.aaX.isVisible();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.aaX.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setColor(int var1) {
      try {
         this.aaX.setColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setGeodesic(boolean var1) {
      try {
         this.aaX.setGeodesic(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setPoints(List<LatLng> var1) {
      try {
         this.aaX.setPoints(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.aaX.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setWidth(float var1) {
      try {
         this.aaX.setWidth(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.aaX.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
