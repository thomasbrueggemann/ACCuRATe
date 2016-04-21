package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import com.google.android.gms.wearable.internal.class_998;
import com.google.android.gms.wearable.internal.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.wearable.internal.m
public class class_993 implements SafeParcelable, DataItem {
    public static final Creator<m> CREATOR = new class_998();
    // $FF: renamed from: BR int
    final int field_4580;
    private byte[] acH;
    private final Map<String, DataItemAsset> avv;
    private final Uri mUri;

    class_993(int var1, Uri var2, Bundle var3, byte[] var4) {
        this.field_4580 = var1;
        this.mUri = var2;
        HashMap var5 = new HashMap();
        var3.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        Iterator var6 = var3.keySet().iterator();

        while(var6.hasNext()) {
            String var7 = (String)var6.next();
            var5.put(var7, (DataItemAssetParcelable)var3.getParcelable(var7));
        }

        this.avv = var5;
        this.acH = var4;
    }

    public int describeContents() {
        return 0;
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_5213();
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.avv;
    }

    public byte[] getData() {
        return this.acH;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: m (byte[]) com.google.android.gms.wearable.internal.m
    public class_993 method_5211(byte[] var1) {
        this.acH = var1;
        return this;
    }

    // $FF: renamed from: pT () android.os.Bundle
    public Bundle method_5212() {
        Bundle var1 = new Bundle();
        var1.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        Iterator var2 = this.avv.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.putParcelable((String)var3.getKey(), new DataItemAssetParcelable((DataItemAsset)var3.getValue()));
        }

        return var1;
    }

    // $FF: renamed from: pZ () com.google.android.gms.wearable.internal.m
    public class_993 method_5213() {
        return this;
    }

    // $FF: synthetic method
    public DataItem setData(byte[] var1) {
        return this.method_5211(var1);
    }

    public String toString() {
        return this.toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean var1) {
        StringBuilder var2 = new StringBuilder("DataItemParcelable[");
        var2.append("@");
        var2.append(Integer.toHexString(this.hashCode()));
        StringBuilder var5 = (new StringBuilder()).append(",dataSz=");
        Object var6;
        if(this.acH == null) {
            var6 = "null";
        } else {
            var6 = Integer.valueOf(this.acH.length);
        }

        var2.append(var5.append(var6).toString());
        var2.append(", numAssets=" + this.avv.size());
        var2.append(", uri=" + this.mUri);
        if(!var1) {
            var2.append("]");
            return var2.toString();
        } else {
            var2.append("]\n  assets: ");
            Iterator var11 = this.avv.keySet().iterator();

            while(var11.hasNext()) {
                String var13 = (String)var11.next();
                var2.append("\n    " + var13 + ": " + this.avv.get(var13));
            }

            var2.append("\n  ]");
            return var2.toString();
        }
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_998.method_5228(this, var1, var2);
    }
}
