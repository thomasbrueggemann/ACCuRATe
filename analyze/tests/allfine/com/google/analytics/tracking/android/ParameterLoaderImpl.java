package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.analytics.tracking.android.Log;
import com.google.analytics.tracking.android.ParameterLoader;

class ParameterLoaderImpl implements ParameterLoader {
    private final Context mContext;
    private String mOverrideResourcePackageName;

    public ParameterLoaderImpl(Context var1) {
        if(var1 == null) {
            throw new NullPointerException("Context cannot be null");
        } else {
            this.mContext = var1.getApplicationContext();
        }
    }

    private int getResourceIdForType(String var1, String var2) {
        if(this.mContext == null) {
            return 0;
        } else {
            String var3;
            if(this.mOverrideResourcePackageName != null) {
                var3 = this.mOverrideResourcePackageName;
            } else {
                var3 = this.mContext.getPackageName();
            }

            return this.mContext.getResources().getIdentifier(var1, var2, var3);
        }
    }

    public boolean getBoolean(String var1) {
        int var2 = this.getResourceIdForType(var1, "bool");
        return var2 == 0?false:"true".equalsIgnoreCase(this.mContext.getString(var2));
    }

    public Double getDoubleFromString(String var1) {
        String var2 = this.getString(var1);
        if(TextUtils.isEmpty(var2)) {
            return null;
        } else {
            try {
                Double var4 = Double.valueOf(Double.parseDouble(var2));
                return var4;
            } catch (NumberFormatException var5) {
                Log.method_2107("NumberFormatException parsing " + var2);
                return null;
            }
        }
    }

    public int getInt(String var1, int var2) {
        int var3 = this.getResourceIdForType(var1, "integer");
        if(var3 == 0) {
            return var2;
        } else {
            try {
                int var5 = Integer.parseInt(this.mContext.getString(var3));
                return var5;
            } catch (NumberFormatException var6) {
                Log.method_2107("NumberFormatException parsing " + this.mContext.getString(var3));
                return var2;
            }
        }
    }

    public String getString(String var1) {
        int var2 = this.getResourceIdForType(var1, "string");
        return var2 == 0?null:this.mContext.getString(var2);
    }

    public boolean isBooleanKeyPresent(String var1) {
        return this.getResourceIdForType(var1, "bool") != 0;
    }

    public void setResourcePackageName(String var1) {
        this.mOverrideResourcePackageName = var1;
    }
}
