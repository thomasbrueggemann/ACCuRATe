package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

public interface SnapshotMetadata extends Parcelable, Freezable<SnapshotMetadata> {
   float getCoverImageAspectRatio();

   Uri getCoverImageUri();

   @Deprecated
   @KeepName
   String getCoverImageUrl();

   String getDescription();

   String getDeviceName();

   Game getGame();

   long getLastModifiedTimestamp();

   Player getOwner();

   long getPlayedTime();

   long getProgressValue();

   String getSnapshotId();

   String getTitle();

   String getUniqueName();

   boolean hasChangePending();
}
