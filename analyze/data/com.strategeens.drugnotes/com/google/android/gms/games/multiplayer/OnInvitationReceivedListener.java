package com.google.android.gms.games.multiplayer;

import com.google.android.gms.games.multiplayer.Invitation;

public interface OnInvitationReceivedListener {
   void onInvitationReceived(Invitation var1);

   void onInvitationRemoved(String var1);
}
