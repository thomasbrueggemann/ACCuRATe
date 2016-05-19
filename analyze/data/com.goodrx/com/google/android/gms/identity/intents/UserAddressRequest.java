package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.zza;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
   public static final Creator<UserAddressRequest> CREATOR = new zza();
   private final int mVersionCode;
   List<CountrySpecification> zzaMA;

   UserAddressRequest() {
      this.mVersionCode = 1;
   }

   UserAddressRequest(int var1, List<CountrySpecification> var2) {
      this.mVersionCode = var1;
      this.zzaMA = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
