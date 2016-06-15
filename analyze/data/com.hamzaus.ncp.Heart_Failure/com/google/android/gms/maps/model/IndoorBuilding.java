package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.model.IndoorLevel;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_58;
import java.util.List;

public final class IndoorBuilding {
   private final class_58 aaF;

   public IndoorBuilding(class_58 var1) {
      this.aaF = (class_58)class_347.method_2170(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof IndoorBuilding)) {
         return false;
      } else {
         try {
            boolean var3 = this.aaF.method_327(((IndoorBuilding)var1).aaF);
            return var3;
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }
   }

   public int getActiveLevelIndex() {
      try {
         int var2 = this.aaF.getActiveLevelIndex();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int getDefaultLevelIndex() {
      try {
         int var2 = this.aaF.getActiveLevelIndex();
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
         int var2 = this.aaF.hashCodeRemote();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isUnderground() {
      try {
         boolean var2 = this.aaF.isUnderground();
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
