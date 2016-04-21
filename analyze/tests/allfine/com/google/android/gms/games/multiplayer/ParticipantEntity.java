package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntityCreator;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.internal.class_345;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntity.ParticipantEntityCreatorCompat();
    // $FF: renamed from: BR int
    private final int field_2782;
    // $FF: renamed from: EZ int
    private final int field_2783;
    // $FF: renamed from: Fa int
    private final int field_2784;
    // $FF: renamed from: NH java.lang.String
    private final String field_2785;
    // $FF: renamed from: Vh android.net.Uri
    private final Uri field_2786;
    // $FF: renamed from: Vi android.net.Uri
    private final Uri field_2787;
    // $FF: renamed from: Vs java.lang.String
    private final String field_2788;
    // $FF: renamed from: Vt java.lang.String
    private final String field_2789;
    // $FF: renamed from: Wh com.google.android.gms.games.PlayerEntity
    private final PlayerEntity field_2790;
    // $FF: renamed from: Wq java.lang.String
    private final String field_2791;
    // $FF: renamed from: Xr java.lang.String
    private final String field_2792;
    private final boolean acg;
    private final ParticipantResult ach;

    ParticipantEntity(int var1, String var2, String var3, Uri var4, Uri var5, int var6, String var7, boolean var8, PlayerEntity var9, int var10, ParticipantResult var11, String var12, String var13) {
        this.field_2782 = var1;
        this.field_2792 = var2;
        this.field_2785 = var3;
        this.field_2786 = var4;
        this.field_2787 = var5;
        this.field_2784 = var6;
        this.field_2791 = var7;
        this.acg = var8;
        this.field_2790 = var9;
        this.field_2783 = var10;
        this.ach = var11;
        this.field_2788 = var12;
        this.field_2789 = var13;
    }

    public ParticipantEntity(Participant var1) {
        this.field_2782 = 3;
        this.field_2792 = var1.getParticipantId();
        this.field_2785 = var1.getDisplayName();
        this.field_2786 = var1.getIconImageUri();
        this.field_2787 = var1.getHiResImageUri();
        this.field_2784 = var1.getStatus();
        this.field_2791 = var1.method_207();
        this.acg = var1.isConnectedToRoom();
        Player var2 = var1.getPlayer();
        PlayerEntity var3;
        if(var2 == null) {
            var3 = null;
        } else {
            var3 = new PlayerEntity(var2);
        }

        this.field_2790 = var3;
        this.field_2783 = var1.getCapabilities();
        this.ach = var1.getResult();
        this.field_2788 = var1.getIconImageUrl();
        this.field_2789 = var1.getHiResImageUrl();
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Participant) int
    static int method_3217(Participant var0) {
        Object[] var1 = new Object[] {var0.getPlayer(), Integer.valueOf(var0.getStatus()), var0.method_207(), Boolean.valueOf(var0.isConnectedToRoom()), var0.getDisplayName(), var0.getIconImageUri(), var0.getHiResImageUri(), Integer.valueOf(var0.getCapabilities()), var0.getResult(), var0.getParticipantId()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Participant, java.lang.Object) boolean
    static boolean method_3218(Participant var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Participant)) {
            var2 = false;
        } else if(var0 != var1) {
            Participant var3 = (Participant)var1;
            if(!class_1089.equal(var3.getPlayer(), var0.getPlayer()) || !class_1089.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !class_1089.equal(var3.method_207(), var0.method_207()) || !class_1089.equal(Boolean.valueOf(var3.isConnectedToRoom()), Boolean.valueOf(var0.isConnectedToRoom())) || !class_1089.equal(var3.getDisplayName(), var0.getDisplayName()) || !class_1089.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_1089.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) || !class_1089.equal(Integer.valueOf(var3.getCapabilities()), Integer.valueOf(var0.getCapabilities())) || !class_1089.equal(var3.getResult(), var0.getResult()) || !class_1089.equal(var3.getParticipantId(), var0.getParticipantId())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.multiplayer.Participant) java.lang.String
    static String method_3219(Participant var0) {
        return class_1089.method_5673(var0).method_5425("ParticipantId", var0.getParticipantId()).method_5425("Player", var0.getPlayer()).method_5425("Status", Integer.valueOf(var0.getStatus())).method_5425("ClientAddress", var0.method_207()).method_5425("ConnectedToRoom", Boolean.valueOf(var0.isConnectedToRoom())).method_5425("DisplayName", var0.getDisplayName()).method_5425("IconImage", var0.getIconImageUri()).method_5425("IconImageUrl", var0.getIconImageUrl()).method_5425("HiResImage", var0.getHiResImageUri()).method_5425("HiResImageUrl", var0.getHiResImageUrl()).method_5425("Capabilities", Integer.valueOf(var0.getCapabilities())).method_5425("Result", var0.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_3218(this, var1);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.field_2783;
    }

    public String getDisplayName() {
        return this.field_2790 == null?this.field_2785:this.field_2790.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer var1) {
        if(this.field_2790 == null) {
            class_345.method_2325(this.field_2785, var1);
        } else {
            this.field_2790.getDisplayName(var1);
        }
    }

    public Uri getHiResImageUri() {
        return this.field_2790 == null?this.field_2787:this.field_2790.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.field_2790 == null?this.field_2789:this.field_2790.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.field_2790 == null?this.field_2786:this.field_2790.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.field_2790 == null?this.field_2788:this.field_2790.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.field_2792;
    }

    public Player getPlayer() {
        return this.field_2790;
    }

    public ParticipantResult getResult() {
        return this.ach;
    }

    public int getStatus() {
        return this.field_2784;
    }

    public int getVersionCode() {
        return this.field_2782;
    }

    public int hashCode() {
        return method_3217(this);
    }

    public boolean isConnectedToRoom() {
        return this.acg;
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: jX () java.lang.String
    public String method_207() {
        return this.field_2791;
    }

    public String toString() {
        return method_3219(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(!this.gQ()) {
            ParticipantEntityCreator.method_3373(this, var1, var2);
        } else {
            var1.writeString(this.field_2792);
            var1.writeString(this.field_2785);
            String var3;
            if(this.field_2786 == null) {
                var3 = null;
            } else {
                var3 = this.field_2786.toString();
            }

            var1.writeString(var3);
            Uri var4 = this.field_2787;
            String var5 = null;
            if(var4 != null) {
                var5 = this.field_2787.toString();
            }

            var1.writeString(var5);
            var1.writeInt(this.field_2784);
            var1.writeString(this.field_2791);
            byte var6;
            if(this.acg) {
                var6 = 1;
            } else {
                var6 = 0;
            }

            var1.writeInt(var6);
            PlayerEntity var7 = this.field_2790;
            byte var8 = 0;
            if(var7 != null) {
                var8 = 1;
            }

            var1.writeInt(var8);
            if(this.field_2790 != null) {
                this.field_2790.writeToParcel(var1, var2);
                return;
            }
        }

    }

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        // $FF: renamed from: cm (android.os.Parcel) com.google.android.gms.games.multiplayer.ParticipantEntity
        public ParticipantEntity method_3374(Parcel var1) {
            boolean var2 = true;
            if(!ParticipantEntity.c(ParticipantEntity.gP()) && !ParticipantEntity.aV(ParticipantEntity.class.getCanonicalName())) {
                String var3 = var1.readString();
                String var4 = var1.readString();
                String var5 = var1.readString();
                Uri var6;
                if(var5 == null) {
                    var6 = null;
                } else {
                    var6 = Uri.parse(var5);
                }

                String var7 = var1.readString();
                Uri var8;
                if(var7 == null) {
                    var8 = null;
                } else {
                    var8 = Uri.parse(var7);
                }

                int var9 = var1.readInt();
                String var10 = var1.readString();
                boolean var11;
                if(var1.readInt() > 0) {
                    var11 = var2;
                } else {
                    var11 = false;
                }

                if(var1.readInt() <= 0) {
                    var2 = false;
                }

                PlayerEntity var12;
                if(var2) {
                    var12 = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(var1);
                } else {
                    var12 = null;
                }

                return new ParticipantEntity(3, var3, var4, var6, var8, var9, var10, var11, var12, 7, (ParticipantResult)null, (String)null, (String)null);
            } else {
                return super.method_3374(var1);
            }
        }

        // $FF: synthetic method
        public Object createFromParcel(Parcel var1) {
            return this.method_3374(var1);
        }
    }
}
