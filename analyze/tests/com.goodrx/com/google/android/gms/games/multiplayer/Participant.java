package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public interface Participant extends Parcelable, Freezable<Participant> {
   int getCapabilities();

   String getDisplayName();

   Uri getHiResImageUri();

   @Deprecated
   @KeepName
   String getHiResImageUrl();

   Uri getIconImageUri();

   @Deprecated
   @KeepName
   String getIconImageUrl();

   String getParticipantId();

   Player getPlayer();

   ParticipantResult getResult();

   int getStatus();

   boolean isConnectedToRoom();

   String zzwt();
}
