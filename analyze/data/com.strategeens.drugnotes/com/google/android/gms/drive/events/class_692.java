package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.events.b
public class class_692 implements Creator<CompletionEvent> {
   // $FF: renamed from: a (com.google.android.gms.drive.events.CompletionEvent, android.os.Parcel, int) void
   static void method_3962(CompletionEvent var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_510);
      class_704.method_4034(var1, 2, var0.field_515, var2, false);
      class_704.method_4038(var1, 3, var0.field_511, false);
      class_704.method_4034(var1, 4, var0.field_513, var2, false);
      class_704.method_4034(var1, 5, var0.field_514, var2, false);
      class_704.method_4034(var1, 6, var0.field_516, var2, false);
      class_704.method_4049(var1, 7, var0.field_517, false);
      class_704.method_4050(var1, 8, var0.field_512);
      class_704.method_4032(var1, 9, var0.field_518, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: Y (android.os.Parcel) com.google.android.gms.drive.events.CompletionEvent
   public CompletionEvent method_3963(Parcel var1) {
      int var2 = 0;
      IBinder var3 = null;
      int var4 = class_705.method_4059(var1);
      ArrayList var5 = null;
      MetadataBundle var6 = null;
      ParcelFileDescriptor var7 = null;
      ParcelFileDescriptor var8 = null;
      String var9 = null;
      DriveId var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = class_705.method_4058(var1);
         switch(class_705.method_4065(var12)) {
         case 1:
            var11 = class_705.method_4073(var1, var12);
            break;
         case 2:
            var10 = (DriveId)class_705.method_4061(var1, var12, DriveId.CREATOR);
            break;
         case 3:
            var9 = class_705.method_4081(var1, var12);
            break;
         case 4:
            var8 = (ParcelFileDescriptor)class_705.method_4061(var1, var12, ParcelFileDescriptor.CREATOR);
            break;
         case 5:
            var7 = (ParcelFileDescriptor)class_705.method_4061(var1, var12, ParcelFileDescriptor.CREATOR);
            break;
         case 6:
            var6 = (MetadataBundle)class_705.method_4061(var1, var12, MetadataBundle.CREATOR);
            break;
         case 7:
            var5 = class_705.method_4055(var1, var12);
            break;
         case 8:
            var2 = class_705.method_4073(var1, var12);
            break;
         case 9:
            var3 = class_705.method_4082(var1, var12);
            break;
         default:
            class_705.method_4066(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new CompletionEvent(var11, var10, var9, var8, var7, var6, var5, var2, var3);
      }
   }

   // $FF: renamed from: bg (int) com.google.android.gms.drive.events.CompletionEvent[]
   public CompletionEvent[] method_3964(int var1) {
      return new CompletionEvent[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3963(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3964(var1);
   }
}
