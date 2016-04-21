package crittercism.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import crittercism.android.class_676;
import crittercism.android.class_764;

// $FF: renamed from: crittercism.android.d
public final class class_662 {
    // $FF: renamed from: a android.net.ConnectivityManager
    private ConnectivityManager field_3226;

    public class_662(Context var1) {
        if(var1 == null) {
            class_764.method_4021("Given a null Context.");
        } else if(var1.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", var1.getPackageName()) == 0) {
            this.field_3226 = (ConnectivityManager)var1.getSystemService("connectivity");
        } else {
            class_764.method_4021("Add android.permission.ACCESS_NETWORK_STATE to AndroidManifest.xml to get more detailed OPTMZ data");
        }
    }

    // $FF: renamed from: a () crittercism.android.b
    public final class_676 method_3714() {
        if(this.field_3226 == null) {
            return class_676.field_3281;
        } else {
            NetworkInfo var1 = this.field_3226.getActiveNetworkInfo();
            return var1 != null && var1.isConnected()?class_676.method_3750(var1.getType()):class_676.field_3282;
        }
    }

    // $FF: renamed from: b () java.lang.String
    public final String method_3715() {
        if(this.field_3226 == null) {
            return "unknown";
        } else {
            NetworkInfo var1 = this.field_3226.getActiveNetworkInfo();
            if(var1 != null && var1.isConnected()) {
                int var2 = var1.getType();
                if(var2 == 0) {
                    switch(var1.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "LTE";
                    }
                } else if(var2 == 1) {
                    return "wifi";
                }

                return "unknown";
            } else {
                return "disconnected";
            }
        }
    }
}
