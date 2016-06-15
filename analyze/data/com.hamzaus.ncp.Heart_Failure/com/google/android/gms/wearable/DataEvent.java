package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.wearable.DataItem;

public interface DataEvent extends Freezable<DataEvent> {
   int TYPE_CHANGED = 1;
   int TYPE_DELETED = 2;

   DataItem getDataItem();

   int getType();
}
