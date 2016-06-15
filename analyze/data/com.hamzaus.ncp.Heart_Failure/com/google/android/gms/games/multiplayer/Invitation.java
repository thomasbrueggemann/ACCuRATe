package com.google.android.gms.games.multiplayer;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.Participatable;

public interface Invitation extends Parcelable, Freezable<Invitation>, Participatable {
   int INVITATION_TYPE_REAL_TIME = 0;
   int INVITATION_TYPE_TURN_BASED = 1;

   int getAvailableAutoMatchSlots();

   long getCreationTimestamp();

   Game getGame();

   String getInvitationId();

   int getInvitationType();

   Participant getInviter();

   int getVariant();
}
