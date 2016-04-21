package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.class_551;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new class_551();
    // $FF: renamed from: BR int
    private final int field_5265;
    // $FF: renamed from: KQ android.net.Uri
    private final Uri field_5266;
    // $FF: renamed from: lf int
    private final int field_5267;
    // $FF: renamed from: lg int
    private final int field_5268;

    WebImage(int var1, Uri var2, int var3, int var4) {
        this.field_5265 = var1;
        this.field_5266 = var2;
        this.field_5267 = var3;
        this.field_5268 = var4;
    }

    public WebImage(Uri var1) throws IllegalArgumentException {
        this(var1, 0, 0);
    }

    public WebImage(Uri var1, int var2, int var3) throws IllegalArgumentException {
        this(1, var1, var2, var3);
        if(var1 == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if(var2 < 0 || var3 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject var1) throws IllegalArgumentException {
        this(method_5919(var1), var1.optInt("width", 0), var1.optInt("height", 0));
    }

    // $FF: renamed from: d (org.json.JSONObject) android.net.Uri
    private static Uri method_5919(JSONObject var0) {
        boolean var1 = var0.has("url");
        Uri var2 = null;
        if(var1) {
            Uri var4;
            try {
                var4 = Uri.parse(var0.getString("url"));
            } catch (JSONException var5) {
                return null;
            }

            var2 = var4;
        }

        return var2;
    }

    // $FF: renamed from: bK () org.json.JSONObject
    public JSONObject method_5920() {
        JSONObject var1 = new JSONObject();

        try {
            var1.put("url", this.field_5266.toString());
            var1.put("width", this.field_5267);
            var1.put("height", this.field_5268);
            return var1;
        } catch (JSONException var3) {
            return var1;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(var1 != null && var1 instanceof WebImage) {
                WebImage var2 = (WebImage)var1;
                if(class_1089.equal(this.field_5266, var2.field_5266) && this.field_5267 == var2.field_5267 && this.field_5268 == var2.field_5268) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public int getHeight() {
        return this.field_5268;
    }

    public Uri getUrl() {
        return this.field_5266;
    }

    int getVersionCode() {
        return this.field_5265;
    }

    public int getWidth() {
        return this.field_5267;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_5266, Integer.valueOf(this.field_5267), Integer.valueOf(this.field_5268)};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_5267), Integer.valueOf(this.field_5268), this.field_5266.toString()};
        return String.format("Image %dx%d %s", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_551.method_3387(this, var1, var2);
    }
}
