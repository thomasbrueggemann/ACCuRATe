package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameEntityCreator;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
    public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntity.ExtendedGameEntityCreatorCompat();
    // $FF: renamed from: BR int
    private final int field_2779;
    private final boolean aaA;
    private final int aaB;
    private final long aaC;
    private final long aaD;
    private final String aaE;
    private final long aaF;
    private final String aaG;
    private final ArrayList<GameBadgeEntity> aaH;
    private final SnapshotMetadataEntity aaI;
    private final GameEntity aay;
    private final int aaz;

    ExtendedGameEntity(int var1, GameEntity var2, int var3, boolean var4, int var5, long var6, long var8, String var10, long var11, String var13, ArrayList<GameBadgeEntity> var14, SnapshotMetadataEntity var15) {
        this.field_2779 = var1;
        this.aay = var2;
        this.aaz = var3;
        this.aaA = var4;
        this.aaB = var5;
        this.aaC = var6;
        this.aaD = var8;
        this.aaE = var10;
        this.aaF = var11;
        this.aaG = var13;
        this.aaH = var14;
        this.aaI = var15;
    }

    public ExtendedGameEntity(ExtendedGame var1) {
        this.field_2779 = 2;
        Game var2 = var1.getGame();
        GameEntity var3;
        if(var2 == null) {
            var3 = null;
        } else {
            var3 = new GameEntity(var2);
        }

        this.aay = var3;
        this.aaz = var1.method_211();
        this.aaA = var1.method_212();
        this.aaB = var1.method_213();
        this.aaC = var1.method_214();
        this.aaD = var1.method_215();
        this.aaE = var1.method_216();
        this.aaF = var1.method_217();
        this.aaG = var1.method_218();
        SnapshotMetadata var4 = var1.method_219();
        SnapshotMetadataEntity var5 = null;
        if(var4 != null) {
            var5 = new SnapshotMetadataEntity(var4);
        }

        this.aaI = var5;
        ArrayList var6 = var1.method_210();
        int var7 = var6.size();
        this.aaH = new ArrayList(var7);

        for(int var8 = 0; var8 < var7; ++var8) {
            this.aaH.add((GameBadgeEntity)((GameBadge)var6.get(var8)).freeze());
        }

    }

    // $FF: renamed from: a (com.google.android.gms.games.internal.game.ExtendedGame) int
    static int method_3203(ExtendedGame var0) {
        Object[] var1 = new Object[] {var0.getGame(), Integer.valueOf(var0.method_211()), Boolean.valueOf(var0.method_212()), Integer.valueOf(var0.method_213()), Long.valueOf(var0.method_214()), Long.valueOf(var0.method_215()), var0.method_216(), Long.valueOf(var0.method_217()), var0.method_218()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.internal.game.ExtendedGame, java.lang.Object) boolean
    static boolean method_3204(ExtendedGame var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof ExtendedGame)) {
            var2 = false;
        } else if(var0 != var1) {
            ExtendedGame var3 = (ExtendedGame)var1;
            if(!class_1089.equal(var3.getGame(), var0.getGame()) || !class_1089.equal(Integer.valueOf(var3.method_211()), Integer.valueOf(var0.method_211())) || !class_1089.equal(Boolean.valueOf(var3.method_212()), Boolean.valueOf(var0.method_212())) || !class_1089.equal(Integer.valueOf(var3.method_213()), Integer.valueOf(var0.method_213())) || !class_1089.equal(Long.valueOf(var3.method_214()), Long.valueOf(var0.method_214())) || !class_1089.equal(Long.valueOf(var3.method_215()), Long.valueOf(var0.method_215())) || !class_1089.equal(var3.method_216(), var0.method_216()) || !class_1089.equal(Long.valueOf(var3.method_217()), Long.valueOf(var0.method_217())) || !class_1089.equal(var3.method_218(), var0.method_218())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.internal.game.ExtendedGame) java.lang.String
    static String method_3205(ExtendedGame var0) {
        return class_1089.method_5673(var0).method_5425("Game", var0.getGame()).method_5425("Availability", Integer.valueOf(var0.method_211())).method_5425("Owned", Boolean.valueOf(var0.method_212())).method_5425("AchievementUnlockedCount", Integer.valueOf(var0.method_213())).method_5425("LastPlayedServerTimestamp", Long.valueOf(var0.method_214())).method_5425("PriceMicros", Long.valueOf(var0.method_215())).method_5425("FormattedPrice", var0.method_216()).method_5425("FullPriceMicros", Long.valueOf(var0.method_217())).method_5425("FormattedFullPrice", var0.method_218()).method_5425("Snapshot", var0.method_219()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_3204(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_3210();
    }

    // $FF: synthetic method
    public Game getGame() {
        return this.method_3209();
    }

    public int getVersionCode() {
        return this.field_2779;
    }

    public int hashCode() {
        return method_3203(this);
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: kR () java.util.ArrayList
    public ArrayList<GameBadge> method_210() {
        return new ArrayList(this.aaH);
    }

    // $FF: renamed from: kS () int
    public int method_211() {
        return this.aaz;
    }

    // $FF: renamed from: kT () boolean
    public boolean method_212() {
        return this.aaA;
    }

    // $FF: renamed from: kU () int
    public int method_213() {
        return this.aaB;
    }

    // $FF: renamed from: kV () long
    public long method_214() {
        return this.aaC;
    }

    // $FF: renamed from: kW () long
    public long method_215() {
        return this.aaD;
    }

    // $FF: renamed from: kX () java.lang.String
    public String method_216() {
        return this.aaE;
    }

    // $FF: renamed from: kY () long
    public long method_217() {
        return this.aaF;
    }

    // $FF: renamed from: kZ () java.lang.String
    public String method_218() {
        return this.aaG;
    }

    // $FF: renamed from: la () com.google.android.gms.games.snapshot.SnapshotMetadata
    public SnapshotMetadata method_219() {
        return this.aaI;
    }

    // $FF: renamed from: lb () com.google.android.gms.games.GameEntity
    public GameEntity method_3209() {
        return this.aay;
    }

    // $FF: renamed from: lc () com.google.android.gms.games.internal.game.ExtendedGame
    public ExtendedGame method_3210() {
        return this;
    }

    public String toString() {
        return method_3205(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        int var3 = 0;
        if(!this.gQ()) {
            ExtendedGameEntityCreator.method_5571(this, var1, var2);
        } else {
            this.aay.writeToParcel(var1, var2);
            var1.writeInt(this.aaz);
            byte var4;
            if(this.aaA) {
                var4 = 1;
            } else {
                var4 = 0;
            }

            var1.writeInt(var4);
            var1.writeInt(this.aaB);
            var1.writeLong(this.aaC);
            var1.writeLong(this.aaD);
            var1.writeString(this.aaE);
            var1.writeLong(this.aaF);
            var1.writeString(this.aaG);
            int var5 = this.aaH.size();
            var1.writeInt(var5);

            while(var3 < var5) {
                ((GameBadgeEntity)this.aaH.get(var3)).writeToParcel(var1, var2);
                ++var3;
            }
        }

    }

    static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
        // $FF: renamed from: cg (android.os.Parcel) com.google.android.gms.games.internal.game.ExtendedGameEntity
        public ExtendedGameEntity method_5572(Parcel var1) {
            if(!ExtendedGameEntity.c(ExtendedGameEntity.gP()) && !ExtendedGameEntity.aV(ExtendedGameEntity.class.getCanonicalName())) {
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
                    var15.add(GameBadgeEntity.CREATOR.method_5494(var1));
                }

                return new ExtendedGameEntity(2, var2, var3, var4, var5, var6, var8, var10, var11, var13, var15, (SnapshotMetadataEntity)null);
            } else {
                return super.method_5572(var1);
            }
        }

        // $FF: synthetic method
        public Object createFromParcel(Parcel var1) {
            return this.method_5572(var1);
        }
    }
}
