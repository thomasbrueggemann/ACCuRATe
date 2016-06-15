package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.model.IndoorLevel;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_65;
import java.util.List;

public final class IndoorBuilding {
   private final class_65 ami;

   public IndoorBuilding(class_65 var1) {
      this.ami = (class_65)class_335.method_2311(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof IndoorBuilding)) {
         return false;
      } else {
         try {
            boolean var3 = this.ami.method_373(((IndoorBuilding)var1).ami);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public int getActiveLevelIndex() {
      try {
         int var2 = this.ami.getActiveLevelIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int getDefaultLevelIndex() {
      try {
         int var2 = this.ami.getActiveLevelIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public List<IndoorLevel> getLevels() {
      // $FF: Couldn't be decompiled
   }

   public int hashCode() {
      try {
         int var2 = this.ami.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isUnderground() {
      try {
         boolean var2 = this.ami.isUnderground();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
