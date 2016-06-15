package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
   // $FF: renamed from: ZJ com.google.android.gms.maps.internal.IProjectionDelegate
   private final IProjectionDelegate field_4292;

   Projection(IProjectionDelegate var1) {
      this.field_4292 = var1;
   }

   public LatLng fromScreenLocation(Point var1) {
      try {
         LatLng var3 = this.field_4292.fromScreenLocation(class_741.method_4178(var1));
         return var3;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public VisibleRegion getVisibleRegion() {
      try {
         VisibleRegion var2 = this.field_4292.getVisibleRegion();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public Point toScreenLocation(LatLng var1) {
      try {
         Point var3 = (Point)class_741.method_4177(this.field_4292.toScreenLocation(var1));
         return var3;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }
}
