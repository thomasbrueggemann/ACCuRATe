package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.class_776;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
   public static final Creator<UserAddressRequest> CREATOR = new class_776();
   // $FF: renamed from: UB java.util.List
   List<CountrySpecification> field_3925;
   // $FF: renamed from: xJ int
   private final int field_3926;

   UserAddressRequest() {
      this.field_3926 = 1;
   }

   UserAddressRequest(int var1, List<CountrySpecification> var2) {
      this.field_3926 = var1;
      this.field_3925 = var2;
   }

   public static UserAddressRequest.Builder newBuilder() {
      UserAddressRequest var0 = new UserAddressRequest();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_3926;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_776.method_4364(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public UserAddressRequest.Builder addAllowedCountrySpecification(CountrySpecification var1) {
         if(UserAddressRequest.this.field_3925 == null) {
            UserAddressRequest.this.field_3925 = new ArrayList();
         }

         UserAddressRequest.this.field_3925.add(var1);
         return this;
      }

      public UserAddressRequest.Builder addAllowedCountrySpecifications(Collection<CountrySpecification> var1) {
         if(UserAddressRequest.this.field_3925 == null) {
            UserAddressRequest.this.field_3925 = new ArrayList();
         }

         UserAddressRequest.this.field_3925.addAll(var1);
         return this;
      }

      public UserAddressRequest build() {
         if(UserAddressRequest.this.field_3925 != null) {
            UserAddressRequest.this.field_3925 = Collections.unmodifiableList(UserAddressRequest.this.field_3925);
         }

         return UserAddressRequest.this;
      }
   }
}
