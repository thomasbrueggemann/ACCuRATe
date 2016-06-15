package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
   private final int adW;
   private final Bundle aem;
   private final String[] aeo;
   private final int aew;

   TurnBasedMatchConfigImpl(TurnBasedMatchConfig.Builder var1) {
      this.adW = var1.adW;
      this.aew = var1.aew;
      this.aem = var1.aem;
      int var2 = var1.ael.size();
      this.aeo = (String[])var1.ael.toArray(new String[var2]);
   }

   public Bundle getAutoMatchCriteria() {
      return this.aem;
   }

   public String[] getInvitedPlayerIds() {
      return this.aeo;
   }

   public int getVariant() {
      return this.adW;
   }

   // $FF: renamed from: mO () int
   public int method_5107() {
      return this.aew;
   }
}
