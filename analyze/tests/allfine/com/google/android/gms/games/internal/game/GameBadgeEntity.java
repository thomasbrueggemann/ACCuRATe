package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntityCreator;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntity.GameBadgeEntityCreatorCompat();
    // $FF: renamed from: BR int
    private final int field_2774;
    // $FF: renamed from: FD int
    private int field_2775;
    // $FF: renamed from: Nw java.lang.String
    private String field_2776;
    // $FF: renamed from: Tr java.lang.String
    private String field_2777;
    // $FF: renamed from: Vh android.net.Uri
    private Uri field_2778;

    GameBadgeEntity(int var1, int var2, String var3, String var4, Uri var5) {
        this.field_2774 = var1;
        this.field_2775 = var2;
        this.field_2776 = var3;
        this.field_2777 = var4;
        this.field_2778 = var5;
    }

    public GameBadgeEntity(GameBadge var1) {
        this.field_2774 = 1;
        this.field_2775 = var1.getType();
        this.field_2776 = var1.getTitle();
        this.field_2777 = var1.getDescription();
        this.field_2778 = var1.getIconImageUri();
    }

    // $FF: renamed from: a (com.google.android.gms.games.internal.game.GameBadge) int
    static int method_3196(GameBadge var0) {
        Object[] var1 = new Object[] {Integer.valueOf(var0.getType()), var0.getTitle(), var0.getDescription(), var0.getIconImageUri()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.internal.game.GameBadge, java.lang.Object) boolean
    static boolean method_3197(GameBadge var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof GameBadge)) {
            var2 = false;
        } else if(var0 != var1) {
            GameBadge var3 = (GameBadge)var1;
            if(!class_1089.equal(Integer.valueOf(var3.getType()), var0.getTitle()) || !class_1089.equal(var3.getDescription(), var0.getIconImageUri())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.internal.game.GameBadge) java.lang.String
    static String method_3198(GameBadge var0) {
        return class_1089.method_5673(var0).method_5425("Type", Integer.valueOf(var0.getType())).method_5425("Title", var0.getTitle()).method_5425("Description", var0.getDescription()).method_5425("IconImageUri", var0.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_3197(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_3202();
    }

    public String getDescription() {
        return this.field_2777;
    }

    public Uri getIconImageUri() {
        return this.field_2778;
    }

    public String getTitle() {
        return this.field_2776;
    }

    public int getType() {
        return this.field_2775;
    }

    public int getVersionCode() {
        return this.field_2774;
    }

    public int hashCode() {
        return method_3196(this);
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: ld () com.google.android.gms.games.internal.game.GameBadge
    public GameBadge method_3202() {
        return this;
    }

    public String toString() {
        return method_3198(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(!this.gQ()) {
            GameBadgeEntityCreator.method_5493(this, var1, var2);
        } else {
            var1.writeInt(this.field_2775);
            var1.writeString(this.field_2776);
            var1.writeString(this.field_2777);
            String var3;
            if(this.field_2778 == null) {
                var3 = null;
            } else {
                var3 = this.field_2778.toString();
            }

            var1.writeString(var3);
        }
    }

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        // $FF: renamed from: ch (android.os.Parcel) com.google.android.gms.games.internal.game.GameBadgeEntity
        public GameBadgeEntity method_5494(Parcel var1) {
            if(!GameBadgeEntity.c(GameBadgeEntity.gP()) && !GameBadgeEntity.aV(GameBadgeEntity.class.getCanonicalName())) {
                int var2 = var1.readInt();
                String var3 = var1.readString();
                String var4 = var1.readString();
                String var5 = var1.readString();
                Uri var6;
                if(var5 == null) {
                    var6 = null;
                } else {
                    var6 = Uri.parse(var5);
                }

                return new GameBadgeEntity(1, var2, var3, var4, var6);
            } else {
                return super.method_5494(var1);
            }
        }

        // $FF: synthetic method
        public Object createFromParcel(Parcel var1) {
            return this.method_5494(var1);
        }
    }
}
