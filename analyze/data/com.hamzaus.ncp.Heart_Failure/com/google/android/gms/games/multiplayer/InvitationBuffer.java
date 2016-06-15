package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationRef;

public final class InvitationBuffer extends g<Invitation> {
   public InvitationBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: c (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2626(int var1, int var2) {
      return this.method_2633(var1, var2);
   }

   // $FF: renamed from: eU () java.lang.String
   protected String method_2627() {
      return "external_invitation_id";
   }

   // $FF: renamed from: g (int, int) com.google.android.gms.games.multiplayer.Invitation
   protected Invitation method_2633(int var1, int var2) {
      return new InvitationRef(this.DD, var1, var2);
   }
}
