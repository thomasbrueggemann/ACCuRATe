package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_66;

public final class IndoorLevel {
   private final class_66 amj;

   public IndoorLevel(class_66 var1) {
      this.amj = (class_66)class_335.method_2311(var1);
   }

   public void activate() {
      try {
         this.amj.activate();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof IndoorLevel)) {
         return false;
      } else {
         try {
            boolean var3 = this.amj.method_374(((IndoorLevel)var1).amj);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public String getName() {
      try {
         String var2 = this.amj.getName();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getShortName() {
      try {
         String var2 = this.amj.getShortName();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var2 = this.amj.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
