package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntityCreator;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
   public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
   // $FF: renamed from: CK int
   private final int field_2940;
   // $FF: renamed from: FP int
   private final int field_2941;
   // $FF: renamed from: Gt int
   private final int field_2942;
   // $FF: renamed from: Zt java.lang.String
   private final String field_2943;
   private final GameEntity acs;
   private final long adS;
   private final byte[] aeA;
   private final PlayerEntity aeU;
   private final ArrayList<PlayerEntity> aeV;
   private final long aeW;
   private final Bundle aeX;

   GameRequestEntity(int var1, GameEntity var2, PlayerEntity var3, byte[] var4, String var5, ArrayList<PlayerEntity> var6, int var7, long var8, long var10, Bundle var12, int var13) {
      this.field_2940 = var1;
      this.acs = var2;
      this.aeU = var3;
      this.aeA = var4;
      this.field_2943 = var5;
      this.aeV = var6;
      this.field_2942 = var7;
      this.adS = var8;
      this.aeW = var10;
      this.aeX = var12;
      this.field_2941 = var13;
   }

   public GameRequestEntity(GameRequest var1) {
      this.field_2940 = 2;
      this.acs = new GameEntity(var1.getGame());
      this.aeU = new PlayerEntity(var1.getSender());
      this.field_2943 = var1.getRequestId();
      this.field_2942 = var1.getType();
      this.adS = var1.getCreationTimestamp();
      this.aeW = var1.getExpirationTimestamp();
      this.field_2941 = var1.getStatus();
      byte[] var2 = var1.getData();
      if(var2 == null) {
         this.aeA = null;
      } else {
         this.aeA = new byte[var2.length];
         System.arraycopy(var2, 0, this.aeA, 0, var2.length);
      }

      List var3 = var1.getRecipients();
      int var4 = var3.size();
      this.aeV = new ArrayList(var4);
      this.aeX = new Bundle();

      for(int var5 = 0; var5 < var4; ++var5) {
         Player var6 = (Player)((Player)var3.get(var5)).freeze();
         String var7 = var6.getPlayerId();
         this.aeV.add((PlayerEntity)var6);
         this.aeX.putInt(var7, var1.getRecipientStatus(var7));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.request.GameRequest) int
   static int method_3889(GameRequest var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getRecipients(), var0.getRequestId(), var0.getSender(), method_3891(var0), Integer.valueOf(var0.getType()), Long.valueOf(var0.getCreationTimestamp()), Long.valueOf(var0.getExpirationTimestamp())};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.request.GameRequest, java.lang.Object) boolean
   static boolean method_3890(GameRequest var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof GameRequest)) {
         var2 = false;
      } else if(var0 != var1) {
         GameRequest var3 = (GameRequest)var1;
         if(!class_336.equal(var3.getGame(), var0.getGame()) || !class_336.equal(var3.getRecipients(), var0.getRecipients()) || !class_336.equal(var3.getRequestId(), var0.getRequestId()) || !class_336.equal(var3.getSender(), var0.getSender()) || !Arrays.equals(method_3891(var3), method_3891(var0)) || !class_336.equal(Integer.valueOf(var3.getType()), Integer.valueOf(var0.getType())) || !class_336.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_336.equal(Long.valueOf(var3.getExpirationTimestamp()), Long.valueOf(var0.getExpirationTimestamp()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.request.GameRequest) int[]
   private static int[] method_3891(GameRequest var0) {
      List var1 = var0.getRecipients();
      int var2 = var1.size();
      int[] var3 = new int[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = var0.getRecipientStatus(((Player)var1.get(var4)).getPlayerId());
      }

      return var3;
   }

   // $FF: renamed from: c (com.google.android.gms.games.request.GameRequest) java.lang.String
   static String method_3892(GameRequest var0) {
      return class_336.method_2312(var0).method_3424("Game", var0.getGame()).method_3424("Sender", var0.getSender()).method_3424("Recipients", var0.getRecipients()).method_3424("Data", var0.getData()).method_3424("RequestId", var0.getRequestId()).method_3424("Type", Integer.valueOf(var0.getType())).method_3424("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_3424("ExpirationTimestamp", Long.valueOf(var0.getExpirationTimestamp())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_3890(this, var1);
   }

   public GameRequest freeze() {
      return this;
   }

   public long getCreationTimestamp() {
      return this.adS;
   }

   public byte[] getData() {
      return this.aeA;
   }

   public long getExpirationTimestamp() {
      return this.aeW;
   }

   public Game getGame() {
      return this.acs;
   }

   public int getRecipientStatus(String var1) {
      return this.aeX.getInt(var1, 0);
   }

   public List<Player> getRecipients() {
      return new ArrayList(this.aeV);
   }

   public String getRequestId() {
      return this.field_2943;
   }

   public Player getSender() {
      return this.aeU;
   }

   public int getStatus() {
      return this.field_2941;
   }

   public int getType() {
      return this.field_2942;
   }

   public int getVersionCode() {
      return this.field_2940;
   }

   public int hashCode() {
      return method_3889(this);
   }

   public boolean isConsumed(String var1) {
      return this.getRecipientStatus(var1) == 1;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: mS () android.os.Bundle
   public Bundle method_3893() {
      return this.aeX;
   }

   public String toString() {
      return method_3892(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      GameRequestEntityCreator.method_3040(this, var1, var2);
   }
}
