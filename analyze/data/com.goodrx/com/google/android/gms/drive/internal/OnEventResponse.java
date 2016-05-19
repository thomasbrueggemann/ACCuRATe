package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import com.google.android.gms.drive.events.TransferStateEvent;
import com.google.android.gms.drive.internal.zzba;

public class OnEventResponse implements SafeParcelable {
   public static final Creator<OnEventResponse> CREATOR = new zzba();
   final int mVersionCode;
   final int zzanf;
   final ChangeEvent zzasl;
   final CompletionEvent zzasm;
   final QueryResultEventParcelable zzasn;
   final ChangesAvailableEvent zzaso;
   final TransferStateEvent zzasp;
   final TransferProgressEvent zzasq;

   OnEventResponse(int var1, int var2, ChangeEvent var3, CompletionEvent var4, QueryResultEventParcelable var5, ChangesAvailableEvent var6, TransferStateEvent var7, TransferProgressEvent var8) {
      this.mVersionCode = var1;
      this.zzanf = var2;
      this.zzasl = var3;
      this.zzasm = var4;
      this.zzasn = var5;
      this.zzaso = var6;
      this.zzasp = var7;
      this.zzasq = var8;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzba.zza(this, var1, var2);
   }
}
