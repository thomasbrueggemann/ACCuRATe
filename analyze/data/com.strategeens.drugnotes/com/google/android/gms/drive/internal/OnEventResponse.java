package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.class_1014;

public class OnEventResponse implements SafeParcelable {
   public static final Creator<OnEventResponse> CREATOR = new class_1014();
   // $FF: renamed from: CK int
   final int field_2742;
   // $FF: renamed from: Pm int
   final int field_2743;
   // $FF: renamed from: QO com.google.android.gms.drive.events.ChangeEvent
   final ChangeEvent field_2744;
   // $FF: renamed from: QP com.google.android.gms.drive.events.CompletionEvent
   final CompletionEvent field_2745;

   OnEventResponse(int var1, int var2, ChangeEvent var3, CompletionEvent var4) {
      this.field_2742 = var1;
      this.field_2743 = var2;
      this.field_2744 = var3;
      this.field_2745 = var4;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: iQ () com.google.android.gms.drive.events.DriveEvent
   public DriveEvent method_3562() {
      switch(this.field_2743) {
      case 1:
         return this.field_2744;
      case 2:
         return this.field_2745;
      default:
         throw new IllegalStateException("Unexpected event type " + this.field_2743);
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1014.method_5591(this, var1, var2);
   }
}
