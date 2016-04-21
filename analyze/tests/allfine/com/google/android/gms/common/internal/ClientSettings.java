package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.ParcelableClientSettingsCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ClientSettings {
    // $FF: renamed from: IL android.view.View
    private final View field_4708;
    // $FF: renamed from: Ls com.google.android.gms.common.internal.ClientSettings$ParcelableClientSettings
    private final ClientSettings.ParcelableClientSettings field_4709;

    public ClientSettings(String var1, Collection<String> var2, int var3, View var4, String var5) {
        this.field_4709 = new ClientSettings.ParcelableClientSettings(var1, var2, var3, var5);
        this.field_4708 = var4;
    }

    public String getAccountName() {
        return this.field_4709.getAccountName();
    }

    public String getAccountNameOrDefault() {
        return this.field_4709.getAccountNameOrDefault();
    }

    public int getGravityForPopups() {
        return this.field_4709.getGravityForPopups();
    }

    public ClientSettings.ParcelableClientSettings getParcelableClientSettings() {
        return this.field_4709;
    }

    public String getRealClientPackageName() {
        return this.field_4709.getRealClientPackageName();
    }

    public List<String> getScopes() {
        return this.field_4709.getScopes();
    }

    public String[] getScopesArray() {
        return (String[])this.field_4709.getScopes().toArray(new String[0]);
    }

    public View getViewForPopups() {
        return this.field_4708;
    }

    public static final class ParcelableClientSettings implements SafeParcelable {
        public static final ParcelableClientSettingsCreator CREATOR = new ParcelableClientSettingsCreator();
        // $FF: renamed from: BR int
        private final int field_3374;
        // $FF: renamed from: Dd java.lang.String
        private final String field_3375;
        // $FF: renamed from: IK int
        private final int field_3376;
        // $FF: renamed from: IM java.lang.String
        private final String field_3377;
        // $FF: renamed from: Jk java.util.List
        private final List<String> field_3378;

        ParcelableClientSettings(int var1, String var2, List<String> var3, int var4, String var5) {
            this.field_3378 = new ArrayList();
            this.field_3374 = var1;
            this.field_3375 = var2;
            this.field_3378.addAll(var3);
            this.field_3376 = var4;
            this.field_3377 = var5;
        }

        public ParcelableClientSettings(String var1, Collection<String> var2, int var3, String var4) {
            this(3, var1, new ArrayList(var2), var3, var4);
        }

        public int describeContents() {
            return 0;
        }

        public String getAccountName() {
            return this.field_3375;
        }

        public String getAccountNameOrDefault() {
            return this.field_3375 != null?this.field_3375:"<<default account>>";
        }

        public int getGravityForPopups() {
            return this.field_3376;
        }

        public String getRealClientPackageName() {
            return this.field_3377;
        }

        public List<String> getScopes() {
            return new ArrayList(this.field_3378);
        }

        public int getVersionCode() {
            return this.field_3374;
        }

        public void writeToParcel(Parcel var1, int var2) {
            ParcelableClientSettingsCreator.method_2845(this, var1, var2);
        }
    }
}
