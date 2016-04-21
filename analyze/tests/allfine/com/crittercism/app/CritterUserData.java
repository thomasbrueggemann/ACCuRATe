package com.crittercism.app;

import crittercism.android.class_764;
import java.util.Map;

public class CritterUserData {
    // $FF: renamed from: a java.util.Map
    private Map field_721;
    // $FF: renamed from: b boolean
    private final boolean field_722;

    CritterUserData(Map var1, boolean var2) {
        this.field_721 = var1;
        this.field_722 = var2;
    }

    public boolean crashedOnLastLoad() {
        if(!this.field_721.containsKey("crashedOnLastLoad")) {
            if(this.field_722) {
                class_764.method_4024("User has opted out of Crittercism.  Returning false.");
            } else {
                class_764.method_4024("CritterUserData instance has no value for crashedOnLastLoad().  Defaulting to false.");
            }

            return false;
        } else {
            return ((Boolean)this.field_721.get("crashedOnLastLoad")).booleanValue();
        }
    }

    public String getRateMyAppMessage() {
        if(!this.field_721.containsKey("message")) {
            if(this.field_722) {
                class_764.method_4024("User has opted out of Crittercism.  Returning null.");
            } else {
                class_764.method_4024("CritterUserData instance has no value for getRateMyAppMessage().  Returning null.");
            }
        }

        return (String)this.field_721.get("message");
    }

    public String getRateMyAppTitle() {
        if(!this.field_721.containsKey("title")) {
            if(this.field_722) {
                class_764.method_4024("User has opted out of Crittercism.  Returning null.");
            } else {
                class_764.method_4024("CritterUserData instance has no value for getRateMyAppTitle().  Returning null.");
            }
        }

        return (String)this.field_721.get("title");
    }

    public String getUserUUID() {
        if(!this.field_721.containsKey("userUUID")) {
            if(this.field_722) {
                class_764.method_4024("User has opted out of Crittercism.  Returning null.");
            } else {
                class_764.method_4024("CritterUserData instance has no value for getUserUUID().  Returning null.");
            }
        }

        return (String)this.field_721.get("userUUID");
    }

    public boolean isOptedOut() {
        return !this.field_721.containsKey("optOutStatus")?this.field_722:((Boolean)this.field_721.get("optOutStatus")).booleanValue();
    }

    public boolean shouldShowRateMyAppAlert() {
        if(!this.field_721.containsKey("shouldShowRateAppAlert")) {
            if(this.field_722) {
                class_764.method_4024("User has opted out of Crittercism.  Returning false.");
            } else {
                class_764.method_4024("CritterUserData instance has no value for shouldShowMyRateAppAlert().  Defaulting to false.");
            }

            return false;
        } else {
            return ((Boolean)this.field_721.get("shouldShowRateAppAlert")).booleanValue();
        }
    }
}
