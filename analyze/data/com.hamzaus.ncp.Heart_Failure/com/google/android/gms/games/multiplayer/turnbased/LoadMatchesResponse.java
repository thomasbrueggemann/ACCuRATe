package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;

public final class LoadMatchesResponse {
   // $FF: renamed from: Ts com.google.android.gms.games.multiplayer.InvitationBuffer
   private final InvitationBuffer field_4211;
   // $FF: renamed from: Tt com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer
   private final TurnBasedMatchBuffer field_4212;
   // $FF: renamed from: Tu com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer
   private final TurnBasedMatchBuffer field_4213;
   // $FF: renamed from: Tv com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer
   private final TurnBasedMatchBuffer field_4214;

   public LoadMatchesResponse(Bundle var1) {
      DataHolder var2 = method_4473(var1, 0);
      if(var2 != null) {
         this.field_4211 = new InvitationBuffer(var2);
      } else {
         this.field_4211 = null;
      }

      DataHolder var3 = method_4473(var1, 1);
      if(var3 != null) {
         this.field_4212 = new TurnBasedMatchBuffer(var3);
      } else {
         this.field_4212 = null;
      }

      DataHolder var4 = method_4473(var1, 2);
      if(var4 != null) {
         this.field_4213 = new TurnBasedMatchBuffer(var4);
      } else {
         this.field_4213 = null;
      }

      DataHolder var5 = method_4473(var1, 3);
      if(var5 != null) {
         this.field_4214 = new TurnBasedMatchBuffer(var5);
      } else {
         this.field_4214 = null;
      }
   }

   // $FF: renamed from: a (android.os.Bundle, int) com.google.android.gms.common.data.DataHolder
   private static DataHolder method_4473(Bundle var0, int var1) {
      String var2 = TurnBasedMatchTurnStatus.method_4162(var1);
      return !var0.containsKey(var2)?null:(DataHolder)var0.getParcelable(var2);
   }

   public void close() {
      if(this.field_4211 != null) {
         this.field_4211.close();
      }

      if(this.field_4212 != null) {
         this.field_4212.close();
      }

      if(this.field_4213 != null) {
         this.field_4213.close();
      }

      if(this.field_4214 != null) {
         this.field_4214.close();
      }

   }

   public TurnBasedMatchBuffer getCompletedMatches() {
      return this.field_4214;
   }

   public InvitationBuffer getInvitations() {
      return this.field_4211;
   }

   public TurnBasedMatchBuffer getMyTurnMatches() {
      return this.field_4212;
   }

   public TurnBasedMatchBuffer getTheirTurnMatches() {
      return this.field_4213;
   }

   public boolean hasData() {
      return this.field_4211 != null && this.field_4211.getCount() > 0 || this.field_4212 != null && this.field_4212.getCount() > 0 || this.field_4213 != null && this.field_4213.getCount() > 0 || this.field_4214 != null && this.field_4214.getCount() > 0;
   }
}
