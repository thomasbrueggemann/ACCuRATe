package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_53;

public final class TileOverlay {
   private final class_53 aaZ;

   public TileOverlay(class_53 var1) {
      this.aaZ = (class_53)class_347.method_2170(var1);
   }

   public void clearTileCache() {
      try {
         this.aaZ.clearTileCache();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof TileOverlay)) {
         return false;
      } else {
         try {
            boolean var3 = this.aaZ.method_253(((TileOverlay)var1).aaZ);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public boolean getFadeIn() {
      try {
         boolean var2 = this.aaZ.getFadeIn();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var2 = this.aaZ.getId();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var2 = this.aaZ.getZIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.aaZ.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var2 = this.aaZ.isVisible();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.aaZ.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setFadeIn(boolean var1) {
      try {
         this.aaZ.setFadeIn(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.aaZ.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.aaZ.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
