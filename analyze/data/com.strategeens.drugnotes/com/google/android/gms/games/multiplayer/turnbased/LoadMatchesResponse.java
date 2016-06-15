package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;

public final class LoadMatchesResponse {
   private final InvitationBuffer aes;
   private final TurnBasedMatchBuffer aet;
   private final TurnBasedMatchBuffer aeu;
   private final TurnBasedMatchBuffer aev;

   public LoadMatchesResponse(Bundle var1) {
      DataHolder var2 = method_5702(var1, 0);
      if(var2 != null) {
         this.aes = new InvitationBuffer(var2);
      } else {
         this.aes = null;
      }

      DataHolder var3 = method_5702(var1, 1);
      if(var3 != null) {
         this.aet = new TurnBasedMatchBuffer(var3);
      } else {
         this.aet = null;
      }

      DataHolder var4 = method_5702(var1, 2);
      if(var4 != null) {
         this.aeu = new TurnBasedMatchBuffer(var4);
      } else {
         this.aeu = null;
      }

      DataHolder var5 = method_5702(var1, 3);
      if(var5 != null) {
         this.aev = new TurnBasedMatchBuffer(var5);
      } else {
         this.aev = null;
      }
   }

   // $FF: renamed from: a (android.os.Bundle, int) com.google.android.gms.common.data.DataHolder
   private static DataHolder method_5702(Bundle var0, int var1) {
      String var2 = TurnBasedMatchTurnStatus.method_5274(var1);
      return !var0.containsKey(var2)?null:(DataHolder)var0.getParcelable(var2);
   }

   @Deprecated
   public void close() {
      this.release();
   }

   public TurnBasedMatchBuffer getCompletedMatches() {
      return this.aev;
   }

   public InvitationBuffer getInvitations() {
      return this.aes;
   }

   public TurnBasedMatchBuffer getMyTurnMatches() {
      return this.aet;
   }

   public TurnBasedMatchBuffer getTheirTurnMatches() {
      return this.aeu;
   }

   public boolean hasData() {
      return this.aes != null && this.aes.getCount() > 0 || this.aet != null && this.aet.getCount() > 0 || this.aeu != null && this.aeu.getCount() > 0 || this.aev != null && this.aev.getCount() > 0;
   }

   public void release() {
      if(this.aes != null) {
         this.aes.release();
      }

      if(this.aet != null) {
         this.aet.release();
      }

      if(this.aeu != null) {
         this.aeu.release();
      }

      if(this.aev != null) {
         this.aev.release();
      }

   }
}
