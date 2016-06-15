package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.EventEntity;

public class EventEntityCreator implements Creator<EventEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.event.EventEntity, android.os.Parcel, int) void
   static void method_4516(EventEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.getEventId(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.getName(), false);
      class_599.method_3369(var1, 3, var0.getDescription(), false);
      class_599.method_3365(var1, 4, var0.getIconImageUri(), var2, false);
      class_599.method_3369(var1, 5, var0.getIconImageUrl(), false);
      class_599.method_3365(var1, 6, var0.getPlayer(), var2, false);
      class_599.method_3361(var1, 7, var0.getValue());
      class_599.method_3369(var1, 8, var0.getFormattedValue(), false);
      class_599.method_3372(var1, 9, var0.isVisible());
      class_599.method_3357(var1, var3);
   }

   public EventEntity createFromParcel(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = class_600.method_3385(var1);
      long var5 = 0L;
      PlayerEntity var7 = null;
      String var8 = null;
      Uri var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = class_600.method_3383(var1);
         switch(class_600.method_3394(var14)) {
         case 1:
            var12 = class_600.method_3410(var1, var14);
            break;
         case 2:
            var11 = class_600.method_3410(var1, var14);
            break;
         case 3:
            var10 = class_600.method_3410(var1, var14);
            break;
         case 4:
            var9 = (Uri)class_600.method_3390(var1, var14, Uri.CREATOR);
            break;
         case 5:
            var8 = class_600.method_3410(var1, var14);
            break;
         case 6:
            var7 = (PlayerEntity)class_600.method_3390(var1, var14, PlayerEntity.CREATOR);
            break;
         case 7:
            var5 = class_600.method_3404(var1, var14);
            break;
         case 8:
            var3 = class_600.method_3410(var1, var14);
            break;
         case 9:
            var2 = class_600.method_3398(var1, var14);
            break;
         case 1000:
            var13 = class_600.method_3402(var1, var14);
            break;
         default:
            class_600.method_3395(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new EventEntity(var13, var12, var11, var10, var9, var8, var7, var5, var3, var2);
      }
   }

   public EventEntity[] newArray(int var1) {
      return new EventEntity[var1];
   }
}
