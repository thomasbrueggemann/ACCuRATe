package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_59;

public final class IndoorLevel {
   private final class_59 aaG;

   public IndoorLevel(class_59 var1) {
      this.aaG = (class_59)class_347.method_2170(var1);
   }

   public void activate() {
      try {
         this.aaG.activate();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof IndoorLevel)) {
         return false;
      } else {
         try {
            boolean var3 = this.aaG.method_328(((IndoorLevel)var1).aaG);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public String getName() {
      try {
         String var2 = this.aaG.getName();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getShortName() {
      try {
         String var2 = this.aaG.getShortName();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.aaG.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
