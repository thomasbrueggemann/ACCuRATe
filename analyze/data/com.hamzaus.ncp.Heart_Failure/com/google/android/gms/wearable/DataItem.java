package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Map;

public interface DataItem extends Freezable<DataItem> {
   Map<String, DataItemAsset> getAssets();

   byte[] getData();

   Uri getUri();

   DataItem setData(byte[] var1);
}
