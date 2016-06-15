package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ParcelableObjectChangedEvent;
import com.google.android.gms.drive.realtime.internal.event.class_257;

public class ParcelableEventList implements SafeParcelable {
   public static final Creator<ParcelableEventList> CREATOR = new class_257();
   // $FF: renamed from: LA boolean
   final boolean field_3096;
   // $FF: renamed from: LB com.google.android.gms.drive.realtime.internal.event.ParcelableObjectChangedEvent[]
   final ParcelableObjectChangedEvent[] field_3097;
   // $FF: renamed from: Ly com.google.android.gms.drive.realtime.internal.event.ParcelableEvent[]
   final ParcelableEvent[] field_3098;
   // $FF: renamed from: Lz com.google.android.gms.common.data.DataHolder
   final DataHolder field_3099;
   // $FF: renamed from: xJ int
   final int field_3100;

   ParcelableEventList(int var1, ParcelableEvent[] var2, DataHolder var3, boolean var4, ParcelableObjectChangedEvent[] var5) {
      this.field_3100 = var1;
      this.field_3098 = var2;
      this.field_3099 = var3;
      this.field_3096 = var4;
      this.field_3097 = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_257.method_1804(this, var1, var2);
   }
}
