package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.auth.api.GoogleAuthApiResponseCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GoogleAuthApiResponse implements SafeParcelable {
    public static final GoogleAuthApiResponseCreator CREATOR = new GoogleAuthApiResponseCreator();
    // $FF: renamed from: DA byte[]
    final byte[] field_3406;
    // $FF: renamed from: Dz android.os.Bundle
    final Bundle field_3407;
    final int responseCode;
    final int versionCode;

    public GoogleAuthApiResponse(int var1, int var2, Bundle var3, byte[] var4) {
        this.versionCode = var1;
        this.responseCode = var2;
        this.field_3407 = var3;
        this.field_3406 = var4;
    }

    public GoogleAuthApiResponse(int var1, Bundle var2, byte[] var3) {
        this.versionCode = 1;
        this.responseCode = var1;
        this.field_3407 = var2;
        this.field_3406 = var3;
    }

    public GoogleAuthApiResponse(int var1, Map<String, String> var2, byte[] var3) {
        this(var1, method_3851(var2), var3);
    }

    // $FF: renamed from: B (java.util.Map) android.os.Bundle
    private static Bundle method_3851(Map<String, String> var0) {
        Bundle var1 = new Bundle();
        Iterator var2 = var0.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.putString((String)var3.getKey(), (String)var3.getValue());
        }

        return var1;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getBody() {
        return this.field_3406;
    }

    public Bundle getHeaders() {
        return this.field_3407;
    }

    public Map<String, String> getHeadersAsMap() {
        HashMap var1 = new HashMap();
        Iterator var2 = this.field_3407.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.put(var3, this.field_3407.getString(var3));
        }

        return var1;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void writeToParcel(Parcel var1, int var2) {
        GoogleAuthApiResponseCreator.method_3322(this, var1, var2);
    }
}
