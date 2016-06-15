package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.EventEntity;

public class EventEntityCreator implements Creator<EventEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.event.EventEntity, android.os.Parcel, int) void
   static void method_5782(EventEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getEventId(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getName(), false);
      class_704.method_4038(var1, 3, var0.getDescription(), false);
      class_704.method_4034(var1, 4, var0.getIconImageUri(), var2, false);
      class_704.method_4038(var1, 5, var0.getIconImageUrl(), false);
      class_704.method_4034(var1, 6, var0.getPlayer(), var2, false);
      class_704.method_4030(var1, 7, var0.getValue());
      class_704.method_4038(var1, 8, var0.getFormattedValue(), false);
      class_704.method_4041(var1, 9, var0.isVisible());
      class_704.method_4026(var1, var3);
   }

   public EventEntity createFromParcel(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = class_705.method_4059(var1);
      long var5 = 0L;
      PlayerEntity var7 = null;
      String var8 = null;
      Uri var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = class_705.method_4058(var1);
         switch(class_705.method_4065(var14)) {
         case 1:
            var12 = class_705.method_4081(var1, var14);
            break;
         case 2:
            var11 = class_705.method_4081(var1, var14);
            break;
         case 3:
            var10 = class_705.method_4081(var1, var14);
            break;
         case 4:
            var9 = (Uri)class_705.method_4061(var1, var14, Uri.CREATOR);
            break;
         case 5:
            var8 = class_705.method_4081(var1, var14);
            break;
         case 6:
            var7 = (PlayerEntity)class_705.method_4061(var1, var14, PlayerEntity.CREATOR);
            break;
         case 7:
            var5 = class_705.method_4075(var1, var14);
            break;
         case 8:
            var3 = class_705.method_4081(var1, var14);
            break;
         case 9:
            var2 = class_705.method_4069(var1, var14);
            break;
         case 1000:
            var13 = class_705.method_4073(var1, var14);
            break;
         default:
            class_705.method_4066(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new EventEntity(var13, var12, var11, var10, var9, var8, var7, var5, var3, var2);
      }
   }

   public EventEntity[] newArray(int var1) {
      return new EventEntity[var1];
   }
}
