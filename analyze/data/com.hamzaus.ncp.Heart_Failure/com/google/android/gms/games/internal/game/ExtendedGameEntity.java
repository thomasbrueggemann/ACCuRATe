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
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
   public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntity.ExtendedGameEntityCreatorCompat();
   // $FF: renamed from: RA com.google.android.gms.games.snapshot.SnapshotMetadataEntity
   private final SnapshotMetadataEntity field_1434;
   // $FF: renamed from: Rq com.google.android.gms.games.GameEntity
   private final GameEntity field_1435;
   // $FF: renamed from: Rr int
   private final int field_1436;
   // $FF: renamed from: Rs boolean
   private final boolean field_1437;
   // $FF: renamed from: Rt int
   private final int field_1438;
   // $FF: renamed from: Ru long
   private final long field_1439;
   // $FF: renamed from: Rv long
   private final long field_1440;
   // $FF: renamed from: Rw java.lang.String
   private final String field_1441;
   // $FF: renamed from: Rx long
   private final long field_1442;
   // $FF: renamed from: Ry java.lang.String
   private final String field_1443;
   // $FF: renamed from: Rz java.util.ArrayList
   private final ArrayList<GameBadgeEntity> field_1444;
   // $FF: renamed from: xJ int
   private final int field_1445;

   ExtendedGameEntity(int var1, GameEntity var2, int var3, boolean var4, int var5, long var6, long var8, String var10, long var11, String var13, ArrayList<GameBadgeEntity> var14, SnapshotMetadataEntity var15) {
      this.field_1445 = var1;
      this.field_1435 = var2;
      this.field_1436 = var3;
      this.field_1437 = var4;
      this.field_1438 = var5;
      this.field_1439 = var6;
      this.field_1440 = var8;
      this.field_1441 = var10;
      this.field_1442 = var11;
      this.field_1443 = var13;
      this.field_1444 = var14;
      this.field_1434 = var15;
   }

   public ExtendedGameEntity(ExtendedGame var1) {
      this.field_1445 = 2;
      Game var2 = var1.getGame();
      GameEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new GameEntity(var2);
      }

      this.field_1435 = var3;
      this.field_1436 = var1.method_237();
      this.field_1437 = var1.method_238();
      this.field_1438 = var1.method_239();
      this.field_1439 = var1.method_240();
      this.field_1440 = var1.method_241();
      this.field_1441 = var1.method_242();
      this.field_1442 = var1.method_243();
      this.field_1443 = var1.method_244();
      SnapshotMetadata var4 = var1.method_245();
      SnapshotMetadataEntity var5 = null;
      if(var4 != null) {
         var5 = new SnapshotMetadataEntity(var4);
      }

      this.field_1434 = var5;
      ArrayList var6 = var1.method_236();
      int var7 = var6.size();
      this.field_1444 = new ArrayList(var7);

      for(int var8 = 0; var8 < var7; ++var8) {
         this.field_1444.add((GameBadgeEntity)((GameBadge)var6.get(var8)).freeze());
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.game.ExtendedGame) int
   static int method_2188(ExtendedGame var0) {
      Object[] var1 = new Object[]{var0.getGame(), Integer.valueOf(var0.method_237()), Boolean.valueOf(var0.method_238()), Integer.valueOf(var0.method_239()), Long.valueOf(var0.method_240()), Long.valueOf(var0.method_241()), var0.method_242(), Long.valueOf(var0.method_243()), var0.method_244()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.game.ExtendedGame, java.lang.Object) boolean
   static boolean method_2189(ExtendedGame var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof ExtendedGame)) {
         var2 = false;
      } else if(var0 != var1) {
         ExtendedGame var3 = (ExtendedGame)var1;
         if(!class_349.equal(var3.getGame(), var0.getGame()) || !class_349.equal(Integer.valueOf(var3.method_237()), Integer.valueOf(var0.method_237())) || !class_349.equal(Boolean.valueOf(var3.method_238()), Boolean.valueOf(var0.method_238())) || !class_349.equal(Integer.valueOf(var3.method_239()), Integer.valueOf(var0.method_239())) || !class_349.equal(Long.valueOf(var3.method_240()), Long.valueOf(var0.method_240())) || !class_349.equal(Long.valueOf(var3.method_241()), Long.valueOf(var0.method_241())) || !class_349.equal(var3.method_242(), var0.method_242()) || !class_349.equal(Long.valueOf(var3.method_243()), Long.valueOf(var0.method_243())) || !class_349.equal(var3.method_244(), var0.method_244())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.internal.game.ExtendedGame) java.lang.String
   static String method_2191(ExtendedGame var0) {
      return class_349.method_2174(var0).method_4301("Game", var0.getGame()).method_4301("Availability", Integer.valueOf(var0.method_237())).method_4301("Owned", Boolean.valueOf(var0.method_238())).method_4301("AchievementUnlockedCount", Integer.valueOf(var0.method_239())).method_4301("LastPlayedServerTimestamp", Long.valueOf(var0.method_240())).method_4301("PriceMicros", Long.valueOf(var0.method_241())).method_4301("FormattedPrice", var0.method_242()).method_4301("FullPriceMicros", Long.valueOf(var0.method_243())).method_4301("FormattedFullPrice", var0.method_244()).method_4301("Snapshot", var0.method_245()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2189(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_2195();
   }

   // $FF: synthetic method
   public Game getGame() {
      return this.method_2194();
   }

   public int getVersionCode() {
      return this.field_1445;
   }

   // $FF: renamed from: hL () java.util.ArrayList
   public ArrayList<GameBadge> method_236() {
      return new ArrayList(this.field_1444);
   }

   // $FF: renamed from: hM () int
   public int method_237() {
      return this.field_1436;
   }

   // $FF: renamed from: hN () boolean
   public boolean method_238() {
      return this.field_1437;
   }

   // $FF: renamed from: hO () int
   public int method_239() {
      return this.field_1438;
   }

   // $FF: renamed from: hP () long
   public long method_240() {
      return this.field_1439;
   }

   // $FF: renamed from: hQ () long
   public long method_241() {
      return this.field_1440;
   }

   // $FF: renamed from: hR () java.lang.String
   public String method_242() {
      return this.field_1441;
   }

   // $FF: renamed from: hS () long
   public long method_243() {
      return this.field_1442;
   }

   // $FF: renamed from: hT () java.lang.String
   public String method_244() {
      return this.field_1443;
   }

   // $FF: renamed from: hU () com.google.android.gms.games.snapshot.SnapshotMetadata
   public SnapshotMetadata method_245() {
      return this.field_1434;
   }

   // $FF: renamed from: hV () com.google.android.gms.games.GameEntity
   public GameEntity method_2194() {
      return this.field_1435;
   }

   // $FF: renamed from: hW () com.google.android.gms.games.internal.game.ExtendedGame
   public ExtendedGame method_2195() {
      return this;
   }

   public int hashCode() {
      return method_2188(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_2191(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = 0;
      if(!this.fm()) {
         ExtendedGameEntityCreator.method_4316(this, var1, var2);
      } else {
         this.field_1435.writeToParcel(var1, var2);
         var1.writeInt(this.field_1436);
         byte var4;
         if(this.field_1437) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         var1.writeInt(var4);
         var1.writeInt(this.field_1438);
         var1.writeLong(this.field_1439);
         var1.writeLong(this.field_1440);
         var1.writeString(this.field_1441);
         var1.writeLong(this.field_1442);
         var1.writeString(this.field_1443);
         int var5 = this.field_1444.size();
         var1.writeInt(var5);

         while(var3 < var5) {
            ((GameBadgeEntity)this.field_1444.get(var3)).writeToParcel(var1, var2);
            ++var3;
         }
      }

   }

   static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
      // $FF: renamed from: bg (android.os.Parcel) com.google.android.gms.games.internal.game.ExtendedGameEntity
      public ExtendedGameEntity method_4317(Parcel var1) {
         if(!ExtendedGameEntity.c(ExtendedGameEntity.fl()) && !ExtendedGameEntity.aA(ExtendedGameEntity.class.getCanonicalName())) {
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
               var15.add(GameBadgeEntity.CREATOR.method_4273(var1));
            }

            return new ExtendedGameEntity(2, var2, var3, var4, var5, var6, var8, var10, var11, var13, var15, (SnapshotMetadataEntity)null);
         } else {
            return super.method_4317(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_4317(var1);
      }
   }
}
