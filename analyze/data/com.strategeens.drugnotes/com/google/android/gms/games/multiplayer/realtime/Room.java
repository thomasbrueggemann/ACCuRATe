package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.Participatable;
import java.util.ArrayList;

public interface Room extends Parcelable, Freezable<Room>, Participatable {
   int ROOM_STATUS_ACTIVE = 3;
   int ROOM_STATUS_AUTO_MATCHING = 1;
   int ROOM_STATUS_CONNECTING = 2;
   int ROOM_STATUS_INVITING = 0;
   int ROOM_VARIANT_DEFAULT = -1;

   Bundle getAutoMatchCriteria();

   int getAutoMatchWaitEstimateSeconds();

   long getCreationTimestamp();

   String getCreatorId();

   String getDescription();

   void getDescription(CharArrayBuffer var1);

   Participant getParticipant(String var1);

   String getParticipantId(String var1);

   ArrayList<String> getParticipantIds();

   int getParticipantStatus(String var1);

   String getRoomId();

   int getStatus();

   int getVariant();
}
