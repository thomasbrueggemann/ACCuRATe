package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.class_1004;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
   public static final Creator<UserAddressRequest> CREATOR = new class_1004();
   // $FF: renamed from: CK int
   private final int field_3991;
   List<CountrySpecification> afH;

   UserAddressRequest() {
      this.field_3991 = 1;
   }

   UserAddressRequest(int var1, List<CountrySpecification> var2) {
      this.field_3991 = var1;
      this.afH = var2;
   }

   public static UserAddressRequest.Builder newBuilder() {
      UserAddressRequest var0 = new UserAddressRequest();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_3991;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1004.method_5560(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public UserAddressRequest.Builder addAllowedCountrySpecification(CountrySpecification var1) {
         if(UserAddressRequest.this.afH == null) {
            UserAddressRequest.this.afH = new ArrayList();
         }

         UserAddressRequest.this.afH.add(var1);
         return this;
      }

      public UserAddressRequest.Builder addAllowedCountrySpecifications(Collection<CountrySpecification> var1) {
         if(UserAddressRequest.this.afH == null) {
            UserAddressRequest.this.afH = new ArrayList();
         }

         UserAddressRequest.this.afH.addAll(var1);
         return this;
      }

      public UserAddressRequest build() {
         if(UserAddressRequest.this.afH != null) {
            UserAddressRequest.this.afH = Collections.unmodifiableList(UserAddressRequest.this.afH);
         }

         return UserAddressRequest.this;
      }
   }
}
