package com.google.android.gms.drive.events;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.c;

public interface DriveEvent extends SafeParcelable {
    int getType();

    public interface Listener<E extends DriveEvent> extends c {
        void onEvent(E var1);
    }
}
