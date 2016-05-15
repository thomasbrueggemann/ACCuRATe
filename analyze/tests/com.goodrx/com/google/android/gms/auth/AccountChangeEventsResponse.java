package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
   public static final Creator<AccountChangeEventsResponse> CREATOR = new zzc();
   final int mVersion;
   final List<AccountChangeEvent> zzpH;

   AccountChangeEventsResponse(int var1, List<AccountChangeEvent> var2) {
      this.mVersion = var1;
      this.zzpH = (List)zzx.zzz(var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
