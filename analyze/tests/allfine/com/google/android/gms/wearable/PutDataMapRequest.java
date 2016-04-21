package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_912;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.PutDataRequest;

public class PutDataMapRequest {
    private final DataMap auX;
    private final PutDataRequest auY;

    private PutDataMapRequest(PutDataRequest var1, DataMap var2) {
        this.auY = var1;
        this.auX = new DataMap();
        if(var2 != null) {
            this.auX.putAll(var2);
        }

    }

    public static PutDataMapRequest create(String var0) {
        return new PutDataMapRequest(PutDataRequest.create(var0), (DataMap)null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem var0) {
        return new PutDataMapRequest(PutDataRequest.method_1634(var0.getUri()), var0.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String var0) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(var0), (DataMap)null);
    }

    public PutDataRequest asPutDataRequest() {
        class_912.class_1371 var1 = class_912.method_4734(this.auX);
        this.auY.setData(class_307.method_2111(var1.awb));
        int var3 = var1.awc.size();

        for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = Integer.toString(var4);
            Asset var6 = (Asset)var1.awc.get(var4);
            if(var5 == null) {
                throw new IllegalStateException("asset key cannot be null: " + var6);
            }

            if(var6 == null) {
                throw new IllegalStateException("asset cannot be null: key=" + var5);
            }

            if(Log.isLoggable("DataMap", 3)) {
                Log.d("DataMap", "asPutDataRequest: adding asset: " + var5 + " " + var6);
            }

            this.auY.putAsset(var5, var6);
        }

        return this.auY;
    }

    public DataMap getDataMap() {
        return this.auX;
    }

    public Uri getUri() {
        return this.auY.getUri();
    }
}
