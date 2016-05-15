package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.FieldChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;
import com.google.android.gms.drive.realtime.internal.event.zzc;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
   public static final Creator<ParcelableEvent> CREATOR = new zzc();
   final int mVersionCode;
   final String zzLq;
   final String zzauL;
   final List<String> zzauR;
   final boolean zzauS;
   final boolean zzauT;
   final boolean zzauU;
   final String zzauV;
   final TextInsertedDetails zzauW;
   final TextDeletedDetails zzauX;
   final ValuesAddedDetails zzauY;
   final ValuesRemovedDetails zzauZ;
   final ValuesSetDetails zzava;
   final ValueChangedDetails zzavb;
   final ReferenceShiftedDetails zzavc;
   final ObjectChangedDetails zzavd;
   final FieldChangedDetails zzave;
   final String zzrG;

   ParcelableEvent(int var1, String var2, String var3, List<String> var4, boolean var5, boolean var6, boolean var7, String var8, String var9, TextInsertedDetails var10, TextDeletedDetails var11, ValuesAddedDetails var12, ValuesRemovedDetails var13, ValuesSetDetails var14, ValueChangedDetails var15, ReferenceShiftedDetails var16, ObjectChangedDetails var17, FieldChangedDetails var18) {
      this.mVersionCode = var1;
      this.zzLq = var2;
      this.zzrG = var3;
      this.zzauR = var4;
      this.zzauS = var5;
      this.zzauT = var6;
      this.zzauU = var7;
      this.zzauL = var8;
      this.zzauV = var9;
      this.zzauW = var10;
      this.zzauX = var11;
      this.zzauY = var12;
      this.zzauZ = var13;
      this.zzava = var14;
      this.zzavb = var15;
      this.zzavc = var16;
      this.zzavd = var17;
      this.zzave = var18;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
