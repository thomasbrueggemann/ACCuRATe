package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.internal.class_347;
import java.util.ArrayList;

public final class TurnBasedMatchConfig {
   // $FF: renamed from: SV int
   private final int field_3720;
   // $FF: renamed from: Tk java.lang.String[]
   private final String[] field_3721;
   // $FF: renamed from: Tl android.os.Bundle
   private final Bundle field_3722;
   // $FF: renamed from: Tw int
   private final int field_3723;

   private TurnBasedMatchConfig(TurnBasedMatchConfig.Builder var1) {
      this.field_3720 = var1.field_672;
      this.field_3723 = var1.field_675;
      this.field_3722 = var1.field_673;
      int var2 = var1.field_674.size();
      this.field_3721 = (String[])var1.field_674.toArray(new String[var2]);
   }

   // $FF: synthetic method
   TurnBasedMatchConfig(TurnBasedMatchConfig.Builder var1, Object var2) {
      this(var1);
   }

   public static TurnBasedMatchConfig.Builder builder() {
      return new TurnBasedMatchConfig.Builder();
   }

   public static Bundle createAutoMatchCriteria(int var0, int var1, long var2) {
      Bundle var4 = new Bundle();
      var4.putInt("min_automatch_players", var0);
      var4.putInt("max_automatch_players", var1);
      var4.putLong("exclusive_bit_mask", var2);
      return var4;
   }

   public Bundle getAutoMatchCriteria() {
      return this.field_3722;
   }

   public String[] getInvitedPlayerIds() {
      return this.field_3721;
   }

   public int getVariant() {
      return this.field_3720;
   }

   // $FF: renamed from: iC () int
   public int method_4050() {
      return this.field_3723;
   }

   public static final class Builder {
      // $FF: renamed from: SV int
      int field_672;
      // $FF: renamed from: Tl android.os.Bundle
      Bundle field_673;
      // $FF: renamed from: To java.util.ArrayList
      ArrayList<String> field_674;
      // $FF: renamed from: Tw int
      int field_675;

      private Builder() {
         this.field_672 = -1;
         this.field_674 = new ArrayList();
         this.field_673 = null;
         this.field_675 = 2;
      }

      // $FF: synthetic method
      Builder(Object var1) {
         this();
      }

      public TurnBasedMatchConfig.Builder addInvitedPlayer(String var1) {
         class_347.method_2170(var1);
         this.field_674.add(var1);
         return this;
      }

      public TurnBasedMatchConfig.Builder addInvitedPlayers(ArrayList<String> var1) {
         class_347.method_2170(var1);
         this.field_674.addAll(var1);
         return this;
      }

      public TurnBasedMatchConfig build() {
         return new TurnBasedMatchConfig(this);
      }

      public TurnBasedMatchConfig.Builder setAutoMatchCriteria(Bundle var1) {
         this.field_673 = var1;
         return this;
      }

      public TurnBasedMatchConfig.Builder setVariant(int var1) {
         boolean var2;
         if(var1 != -1 && var1 <= 0) {
            var2 = false;
         } else {
            var2 = true;
         }

         class_347.method_2168(var2, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
         this.field_672 = var1;
         return this;
      }
   }
}
