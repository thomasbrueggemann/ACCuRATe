package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator<ZInvitationCluster> {
   // $FF: renamed from: a (com.google.android.gms.games.internal.multiplayer.ZInvitationCluster, android.os.Parcel, int) void
   static void method_4756(ZInvitationCluster var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.method_4935(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4757(var1);
   }

   // $FF: renamed from: cw (android.os.Parcel) com.google.android.gms.games.internal.multiplayer.ZInvitationCluster
   public ZInvitationCluster method_4757(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      ArrayList var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var4 = class_705.method_4068(var1, var5, InvitationEntity.CREATOR);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var5);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new ZInvitationCluster(var3, var4);
      }
   }

   // $FF: renamed from: eg (int) com.google.android.gms.games.internal.multiplayer.ZInvitationCluster[]
   public ZInvitationCluster[] method_4758(int var1) {
      return new ZInvitationCluster[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4758(var1);
   }
}
