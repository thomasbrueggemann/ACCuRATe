package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public interface Participant extends Parcelable, Freezable<Participant> {
   int STATUS_DECLINED = 3;
   int STATUS_FINISHED = 5;
   int STATUS_INVITED = 1;
   int STATUS_JOINED = 2;
   int STATUS_LEFT = 4;
   int STATUS_NOT_INVITED_YET = 0;
   int STATUS_UNRESPONSIVE = 6;

   // $FF: renamed from: gR () java.lang.String
   String method_232();

   int getCapabilities();

   String getDisplayName();

   void getDisplayName(CharArrayBuffer var1);

   Uri getHiResImageUri();

   @Deprecated
   String getHiResImageUrl();

   Uri getIconImageUri();

   @Deprecated
   String getIconImageUrl();

   String getParticipantId();

   Player getPlayer();

   ParticipantResult getResult();

   int getStatus();

   boolean isConnectedToRoom();
}
