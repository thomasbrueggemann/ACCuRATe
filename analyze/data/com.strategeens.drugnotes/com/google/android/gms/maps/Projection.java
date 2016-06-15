package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
   private final IProjectionDelegate alf;

   Projection(IProjectionDelegate var1) {
      this.alf = var1;
   }

   public LatLng fromScreenLocation(Point var1) {
      try {
         LatLng var3 = this.alf.fromScreenLocation(class_960.method_5293(var1));
         return var3;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public VisibleRegion getVisibleRegion() {
      try {
         VisibleRegion var2 = this.alf.getVisibleRegion();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public Point toScreenLocation(LatLng var1) {
      try {
         Point var3 = (Point)class_960.method_5292(this.alf.toScreenLocation(var1));
         return var3;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }
}
