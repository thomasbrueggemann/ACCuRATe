package com.google.android.gms.drive.events;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public interface DriveEvent extends SafeParcelable {
   int TYPE_CHANGE = 1;

   DriveId getDriveId();

   int getType();

   public interface Listener<E extends DriveEvent> {
      void onEvent(E var1);
   }
}
