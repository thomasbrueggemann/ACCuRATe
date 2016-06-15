package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.FileConflictEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.events.c
public class class_589 implements Creator<FileConflictEvent> {
   // $FF: renamed from: a (com.google.android.gms.drive.events.FileConflictEvent, android.os.Parcel, int) void
   static void method_3318(FileConflictEvent var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_4353);
      class_599.method_3365(var1, 2, var0.field_4345, var2, false);
      class_599.method_3369(var1, 3, var0.field_4354, false);
      class_599.method_3365(var1, 4, var0.field_4346, var2, false);
      class_599.method_3365(var1, 5, var0.field_4347, var2, false);
      class_599.method_3365(var1, 6, var0.field_4348, var2, false);
      class_599.method_3370(var1, 7, var0.field_4349, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: Q (android.os.Parcel) com.google.android.gms.drive.events.FileConflictEvent
   public FileConflictEvent method_3319(Parcel var1) {
      ArrayList var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      MetadataBundle var5 = null;
      ParcelFileDescriptor var6 = null;
      ParcelFileDescriptor var7 = null;
      String var8 = null;
      DriveId var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = class_600.method_3383(var1);
         switch(class_600.method_3394(var10)) {
         case 1:
            var4 = class_600.method_3402(var1, var10);
            break;
         case 2:
            var9 = (DriveId)class_600.method_3390(var1, var10, DriveId.CREATOR);
            break;
         case 3:
            var8 = class_600.method_3410(var1, var10);
            break;
         case 4:
            var7 = (ParcelFileDescriptor)class_600.method_3390(var1, var10, ParcelFileDescriptor.CREATOR);
            break;
         case 5:
            var6 = (ParcelFileDescriptor)class_600.method_3390(var1, var10, ParcelFileDescriptor.CREATOR);
            break;
         case 6:
            var5 = (MetadataBundle)class_600.method_3390(var1, var10, MetadataBundle.CREATOR);
            break;
         case 7:
            var2 = class_600.method_3386(var1, var10);
            break;
         default:
            class_600.method_3395(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new FileConflictEvent(var4, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: aL (int) com.google.android.gms.drive.events.FileConflictEvent[]
   public FileConflictEvent[] method_3320(int var1) {
      return new FileConflictEvent[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3319(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3320(var1);
   }
}
