package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntityCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
    // $FF: renamed from: BR int
    private final int field_3600;
    // $FF: renamed from: FD int
    private final int field_3601;
    // $FF: renamed from: Fa int
    private final int field_3602;
    // $FF: renamed from: XC java.lang.String
    private final String field_3603;
    private final GameEntity aay;
    private final long abZ;
    private final byte[] acH;
    private final PlayerEntity adc;
    private final ArrayList<PlayerEntity> add;
    private final long ade;
    private final Bundle adf;

    GameRequestEntity(int var1, GameEntity var2, PlayerEntity var3, byte[] var4, String var5, ArrayList<PlayerEntity> var6, int var7, long var8, long var10, Bundle var12, int var13) {
        this.field_3600 = var1;
        this.aay = var2;
        this.adc = var3;
        this.acH = var4;
        this.field_3603 = var5;
        this.add = var6;
        this.field_3601 = var7;
        this.abZ = var8;
        this.ade = var10;
        this.adf = var12;
        this.field_3602 = var13;
    }

    public GameRequestEntity(GameRequest var1) {
        this.field_3600 = 2;
        this.aay = new GameEntity(var1.getGame());
        this.adc = new PlayerEntity(var1.getSender());
        this.field_3603 = var1.getRequestId();
        this.field_3601 = var1.getType();
        this.abZ = var1.getCreationTimestamp();
        this.ade = var1.getExpirationTimestamp();
        this.field_3602 = var1.getStatus();
        byte[] var2 = var1.getData();
        if(var2 == null) {
            this.acH = null;
        } else {
            this.acH = new byte[var2.length];
            System.arraycopy(var2, 0, this.acH, 0, var2.length);
        }

        List var3 = var1.getRecipients();
        int var4 = var3.size();
        this.add = new ArrayList(var4);
        this.adf = new Bundle();

        for(int var5 = 0; var5 < var4; ++var5) {
            Player var6 = (Player)((Player)var3.get(var5)).freeze();
            String var7 = var6.getPlayerId();
            this.add.add((PlayerEntity)var6);
            this.adf.putInt(var7, var1.getRecipientStatus(var7));
        }

    }

    // $FF: renamed from: a (com.google.android.gms.games.request.GameRequest) int
    static int method_4025(GameRequest var0) {
        Object[] var1 = new Object[] {var0.getGame(), var0.getRecipients(), var0.getRequestId(), var0.getSender(), method_4027(var0), Integer.valueOf(var0.getType()), Long.valueOf(var0.getCreationTimestamp()), Long.valueOf(var0.getExpirationTimestamp())};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.request.GameRequest, java.lang.Object) boolean
    static boolean method_4026(GameRequest var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof GameRequest)) {
            var2 = false;
        } else if(var0 != var1) {
            GameRequest var3 = (GameRequest)var1;
            if(!class_1089.equal(var3.getGame(), var0.getGame()) || !class_1089.equal(var3.getRecipients(), var0.getRecipients()) || !class_1089.equal(var3.getRequestId(), var0.getRequestId()) || !class_1089.equal(var3.getSender(), var0.getSender()) || !Arrays.equals(method_4027(var3), method_4027(var0)) || !class_1089.equal(Integer.valueOf(var3.getType()), Integer.valueOf(var0.getType())) || !class_1089.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_1089.equal(Long.valueOf(var3.getExpirationTimestamp()), Long.valueOf(var0.getExpirationTimestamp()))) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.request.GameRequest) int[]
    private static int[] method_4027(GameRequest var0) {
        List var1 = var0.getRecipients();
        int var2 = var1.size();
        int[] var3 = new int[var2];

        for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var0.getRecipientStatus(((Player)var1.get(var4)).getPlayerId());
        }

        return var3;
    }

    // $FF: renamed from: c (com.google.android.gms.games.request.GameRequest) java.lang.String
    static String method_4028(GameRequest var0) {
        return class_1089.method_5673(var0).method_5425("Game", var0.getGame()).method_5425("Sender", var0.getSender()).method_5425("Recipients", var0.getRecipients()).method_5425("Data", var0.getData()).method_5425("RequestId", var0.getRequestId()).method_5425("Type", Integer.valueOf(var0.getType())).method_5425("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_5425("ExpirationTimestamp", Long.valueOf(var0.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_4026(this, var1);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.abZ;
    }

    public byte[] getData() {
        return this.acH;
    }

    public long getExpirationTimestamp() {
        return this.ade;
    }

    public Game getGame() {
        return this.aay;
    }

    public int getRecipientStatus(String var1) {
        return this.adf.getInt(var1, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.add);
    }

    public String getRequestId() {
        return this.field_3603;
    }

    public Player getSender() {
        return this.adc;
    }

    public int getStatus() {
        return this.field_3602;
    }

    public int getType() {
        return this.field_3601;
    }

    public int getVersionCode() {
        return this.field_3600;
    }

    public int hashCode() {
        return method_4025(this);
    }

    public boolean isConsumed(String var1) {
        return this.getRecipientStatus(var1) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: lL () android.os.Bundle
    public Bundle method_4029() {
        return this.adf;
    }

    public String toString() {
        return method_4028(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        GameRequestEntityCreator.method_3006(this, var1, var2);
    }
}
