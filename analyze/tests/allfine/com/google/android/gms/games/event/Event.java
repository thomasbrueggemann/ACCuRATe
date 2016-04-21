package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public interface Event extends Parcelable, Freezable<Event> {
    String getDescription();

    void getDescription(CharArrayBuffer var1);

    String getEventId();

    String getFormattedValue();

    void getFormattedValue(CharArrayBuffer var1);

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    String getName();

    void getName(CharArrayBuffer var1);

    Player getPlayer();

    long getValue();

    boolean isVisible();
}
