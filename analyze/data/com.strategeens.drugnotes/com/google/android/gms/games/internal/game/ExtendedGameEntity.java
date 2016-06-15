package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameEntityCreator;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
   public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntity.ExtendedGameEntityCreatorCompat();
   // $FF: renamed from: CK int
   private final int field_982;
   private final String acA;
   private final ArrayList<GameBadgeEntity> acB;
   private final SnapshotMetadataEntity acC;
   private final GameEntity acs;
   private final int act;
   private final boolean acu;
   private final int acv;
   private final long acw;
   private final long acx;
   private final String acy;
   private final long acz;

   ExtendedGameEntity(int var1, GameEntity var2, int var3, boolean var4, int var5, long var6, long var8, String var10, long var11, String var13, ArrayList<GameBadgeEntity> var14, SnapshotMetadataEntity var15) {
      this.field_982 = var1;
      this.acs = var2;
      this.act = var3;
      this.acu = var4;
      this.acv = var5;
      this.acw = var6;
      this.acx = var8;
      this.acy = var10;
      this.acz = var11;
      this.acA = var13;
      this.acB = var14;
      this.acC = var15;
   }

   public ExtendedGameEntity(ExtendedGame var1) {
      this.field_982 = 2;
      Game var2 = var1.getGame();
      GameEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new GameEntity(var2);
      }

      this.acs = var3;
      this.act = var1.method_267();
      this.acu = var1.method_268();
      this.acv = var1.method_269();
      this.acw = var1.method_270();
      this.acx = var1.method_271();
      this.acy = var1.method_272();
      this.acz = var1.method_273();
      this.acA = var1.method_274();
      SnapshotMetadata var4 = var1.method_275();
      SnapshotMetadataEntity var5 = null;
      if(var4 != null) {
         var5 = new SnapshotMetadataEntity(var4);
      }

      this.acC = var5;
      ArrayList var6 = var1.method_266();
      int var7 = var6.size();
      this.acB = new ArrayList(var7);

      for(int var8 = 0; var8 < var7; ++var8) {
         this.acB.add((GameBadgeEntity)((GameBadge)var6.get(var8)).freeze());
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.game.ExtendedGame) int
   static int method_2376(ExtendedGame var0) {
      Object[] var1 = new Object[]{var0.getGame(), Integer.valueOf(var0.method_267()), Boolean.valueOf(var0.method_268()), Integer.valueOf(var0.method_269()), Long.valueOf(var0.method_270()), Long.valueOf(var0.method_271()), var0.method_272(), Long.valueOf(var0.method_273()), var0.method_274()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.game.ExtendedGame, java.lang.Object) boolean
   static boolean method_2377(ExtendedGame var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof ExtendedGame)) {
         var2 = false;
      } else if(var0 != var1) {
         ExtendedGame var3 = (ExtendedGame)var1;
         if(!class_336.equal(var3.getGame(), var0.getGame()) || !class_336.equal(Integer.valueOf(var3.method_267()), Integer.valueOf(var0.method_267())) || !class_336.equal(Boolean.valueOf(var3.method_268()), Boolean.valueOf(var0.method_268())) || !class_336.equal(Integer.valueOf(var3.method_269()), Integer.valueOf(var0.method_269())) || !class_336.equal(Long.valueOf(var3.method_270()), Long.valueOf(var0.method_270())) || !class_336.equal(Long.valueOf(var3.method_271()), Long.valueOf(var0.method_271())) || !class_336.equal(var3.method_272(), var0.method_272()) || !class_336.equal(Long.valueOf(var3.method_273()), Long.valueOf(var0.method_273())) || !class_336.equal(var3.method_274(), var0.method_274())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.internal.game.ExtendedGame) java.lang.String
   static String method_2378(ExtendedGame var0) {
      return class_336.method_2312(var0).method_3424("Game", var0.getGame()).method_3424("Availability", Integer.valueOf(var0.method_267())).method_3424("Owned", Boolean.valueOf(var0.method_268())).method_3424("AchievementUnlockedCount", Integer.valueOf(var0.method_269())).method_3424("LastPlayedServerTimestamp", Long.valueOf(var0.method_270())).method_3424("PriceMicros", Long.valueOf(var0.method_271())).method_3424("FormattedPrice", var0.method_272()).method_3424("FullPriceMicros", Long.valueOf(var0.method_273())).method_3424("FormattedFullPrice", var0.method_274()).method_3424("Snapshot", var0.method_275()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2377(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_2383();
   }

   // $FF: synthetic method
   public Game getGame() {
      return this.method_2382();
   }

   public int getVersionCode() {
      return this.field_982;
   }

   public int hashCode() {
      return method_2376(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: lY () java.util.ArrayList
   public ArrayList<GameBadge> method_266() {
      return new ArrayList(this.acB);
   }

   // $FF: renamed from: lZ () int
   public int method_267() {
      return this.act;
   }

   // $FF: renamed from: ma () boolean
   public boolean method_268() {
      return this.acu;
   }

   // $FF: renamed from: mb () int
   public int method_269() {
      return this.acv;
   }

   // $FF: renamed from: mc () long
   public long method_270() {
      return this.acw;
   }

   // $FF: renamed from: md () long
   public long method_271() {
      return this.acx;
   }

   // $FF: renamed from: me () java.lang.String
   public String method_272() {
      return this.acy;
   }

   // $FF: renamed from: mf () long
   public long method_273() {
      return this.acz;
   }

   // $FF: renamed from: mg () java.lang.String
   public String method_274() {
      return this.acA;
   }

   // $FF: renamed from: mh () com.google.android.gms.games.snapshot.SnapshotMetadata
   public SnapshotMetadata method_275() {
      return this.acC;
   }

   // $FF: renamed from: mi () com.google.android.gms.games.GameEntity
   public GameEntity method_2382() {
      return this.acs;
   }

   // $FF: renamed from: mj () com.google.android.gms.games.internal.game.ExtendedGame
   public ExtendedGame method_2383() {
      return this;
   }

   public String toString() {
      return method_2378(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = 0;
      if(!this.hu()) {
         ExtendedGameEntityCreator.method_5449(this, var1, var2);
      } else {
         this.acs.writeToParcel(var1, var2);
         var1.writeInt(this.act);
         byte var4;
         if(this.acu) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         var1.writeInt(var4);
         var1.writeInt(this.acv);
         var1.writeLong(this.acw);
         var1.writeLong(this.acx);
         var1.writeString(this.acy);
         var1.writeLong(this.acz);
         var1.writeString(this.acA);
         int var5 = this.acB.size();
         var1.writeInt(var5);

         while(var3 < var5) {
            ((GameBadgeEntity)this.acB.get(var3)).writeToParcel(var1, var2);
            ++var3;
         }
      }

   }

   static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_5450(var1);
      }

      // $FF: renamed from: cu (android.os.Parcel) com.google.android.gms.games.internal.game.ExtendedGameEntity
      public ExtendedGameEntity method_5450(Parcel var1) {
         if(!ExtendedGameEntity.c(ExtendedGameEntity.ht()) && !ExtendedGameEntity.aW(ExtendedGameEntity.class.getCanonicalName())) {
            GameEntity var2 = (GameEntity)GameEntity.CREATOR.createFromParcel(var1);
            int var3 = var1.readInt();
            boolean var4;
            if(var1.readInt() == 1) {
               var4 = true;
            } else {
               var4 = false;
            }

            int var5 = var1.readInt();
            long var6 = var1.readLong();
            long var8 = var1.readLong();
            String var10 = var1.readString();
            long var11 = var1.readLong();
            String var13 = var1.readString();
            int var14 = var1.readInt();
            ArrayList var15 = new ArrayList(var14);

            for(int var16 = 0; var16 < var14; ++var16) {
               var15.add(GameBadgeEntity.CREATOR.method_5377(var1));
            }

            return new ExtendedGameEntity(2, var2, var3, var4, var5, var6, var8, var10, var11, var13, var15, (SnapshotMetadataEntity)null);
         } else {
            return super.method_5450(var1);
         }
      }
   }
}
