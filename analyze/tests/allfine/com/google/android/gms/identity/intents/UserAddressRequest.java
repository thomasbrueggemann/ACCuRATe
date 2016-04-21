package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.class_1098;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR = new class_1098();
    // $FF: renamed from: BR int
    private final int field_4784;
    List<CountrySpecification> adK;

    UserAddressRequest() {
        this.field_4784 = 1;
    }

    UserAddressRequest(int var1, List<CountrySpecification> var2) {
        this.field_4784 = var1;
        this.adK = var2;
    }

    public static UserAddressRequest.Builder newBuilder() {
        UserAddressRequest var0 = new UserAddressRequest();
        return var0.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_4784;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1098.method_5717(this, var1, var2);
    }

    public final class Builder {
        private Builder() {
        }

        // $FF: synthetic method
        Builder(Object var2) {
            this();
        }

        public UserAddressRequest.Builder addAllowedCountrySpecification(CountrySpecification var1) {
            if(UserAddressRequest.this.adK == null) {
                UserAddressRequest.this.adK = new ArrayList();
            }

            UserAddressRequest.this.adK.add(var1);
            return this;
        }

        public UserAddressRequest.Builder addAllowedCountrySpecifications(Collection<CountrySpecification> var1) {
            if(UserAddressRequest.this.adK == null) {
                UserAddressRequest.this.adK = new ArrayList();
            }

            UserAddressRequest.this.adK.addAll(var1);
            return this;
        }

        public UserAddressRequest build() {
            if(UserAddressRequest.this.adK != null) {
                UserAddressRequest.this.adK = Collections.unmodifiableList(UserAddressRequest.this.adK);
            }

            return UserAddressRequest.this;
        }
    }
}
