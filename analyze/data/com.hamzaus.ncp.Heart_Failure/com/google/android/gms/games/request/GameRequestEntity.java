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
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
   public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
   // $FF: renamed from: AQ int
   private final int field_3072;
   // $FF: renamed from: Oy java.lang.String
   private final String field_3073;
   // $FF: renamed from: Rq com.google.android.gms.games.GameEntity
   private final GameEntity field_3074;
   // $FF: renamed from: SR long
   private final long field_3075;
   // $FF: renamed from: SY int
   private final int field_3076;
   // $FF: renamed from: TC byte[]
   private final byte[] field_3077;
   // $FF: renamed from: TX com.google.android.gms.games.PlayerEntity
   private final PlayerEntity field_3078;
   // $FF: renamed from: TY java.util.ArrayList
   private final ArrayList<PlayerEntity> field_3079;
   // $FF: renamed from: TZ long
   private final long field_3080;
   // $FF: renamed from: Ua android.os.Bundle
   private final Bundle field_3081;
   // $FF: renamed from: xJ int
   private final int field_3082;

   GameRequestEntity(int var1, GameEntity var2, PlayerEntity var3, byte[] var4, String var5, ArrayList<PlayerEntity> var6, int var7, long var8, long var10, Bundle var12, int var13) {
      this.field_3082 = var1;
      this.field_3074 = var2;
      this.field_3078 = var3;
      this.field_3077 = var4;
      this.field_3073 = var5;
      this.field_3079 = var6;
      this.field_3072 = var7;
      this.field_3075 = var8;
      this.field_3080 = var10;
      this.field_3081 = var12;
      this.field_3076 = var13;
   }

   public GameRequestEntity(GameRequest var1) {
      this.field_3082 = 2;
      this.field_3074 = new GameEntity(var1.getGame());
      this.field_3078 = new PlayerEntity(var1.getSender());
      this.field_3073 = var1.getRequestId();
      this.field_3072 = var1.getType();
      this.field_3075 = var1.getCreationTimestamp();
      this.field_3080 = var1.getExpirationTimestamp();
      this.field_3076 = var1.getStatus();
      byte[] var2 = var1.getData();
      if(var2 == null) {
         this.field_3077 = null;
      } else {
         this.field_3077 = new byte[var2.length];
         System.arraycopy(var2, 0, this.field_3077, 0, var2.length);
      }

      List var3 = var1.getRecipients();
      int var4 = var3.size();
      this.field_3079 = new ArrayList(var4);
      this.field_3081 = new Bundle();

      for(int var5 = 0; var5 < var4; ++var5) {
         Player var6 = (Player)((Player)var3.get(var5)).freeze();
         String var7 = var6.getPlayerId();
         this.field_3079.add((PlayerEntity)var6);
         this.field_3081.putInt(var7, var1.getRecipientStatus(var7));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.request.GameRequest) int
   static int method_3275(GameRequest var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getRecipients(), var0.getRequestId(), var0.getSender(), method_3277(var0), Integer.valueOf(var0.getType()), Long.valueOf(var0.getCreationTimestamp()), Long.valueOf(var0.getExpirationTimestamp())};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.request.GameRequest, java.lang.Object) boolean
   static boolean method_3276(GameRequest var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof GameRequest)) {
         var2 = false;
      } else if(var0 != var1) {
         GameRequest var3 = (GameRequest)var1;
         if(!class_349.equal(var3.getGame(), var0.getGame()) || !class_349.equal(var3.getRecipients(), var0.getRecipients()) || !class_349.equal(var3.getRequestId(), var0.getRequestId()) || !class_349.equal(var3.getSender(), var0.getSender()) || !Arrays.equals(method_3277(var3), method_3277(var0)) || !class_349.equal(Integer.valueOf(var3.getType()), Integer.valueOf(var0.getType())) || !class_349.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_349.equal(Long.valueOf(var3.getExpirationTimestamp()), Long.valueOf(var0.getExpirationTimestamp()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.request.GameRequest) int[]
   private static int[] method_3277(GameRequest var0) {
      List var1 = var0.getRecipients();
      int var2 = var1.size();
      int[] var3 = new int[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = var0.getRecipientStatus(((Player)var1.get(var4)).getPlayerId());
      }

      return var3;
   }

   // $FF: renamed from: c (com.google.android.gms.games.request.GameRequest) java.lang.String
   static String method_3278(GameRequest var0) {
      return class_349.method_2174(var0).method_4301("Game", var0.getGame()).method_4301("Sender", var0.getSender()).method_4301("Recipients", var0.getRecipients()).method_4301("Data", var0.getData()).method_4301("RequestId", var0.getRequestId()).method_4301("Type", Integer.valueOf(var0.getType())).method_4301("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_4301("ExpirationTimestamp", Long.valueOf(var0.getExpirationTimestamp())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_3276(this, var1);
   }

   public GameRequest freeze() {
      return this;
   }

   public long getCreationTimestamp() {
      return this.field_3075;
   }

   public byte[] getData() {
      return this.field_3077;
   }

   public long getExpirationTimestamp() {
      return this.field_3080;
   }

   public Game getGame() {
      return this.field_3074;
   }

   public int getRecipientStatus(String var1) {
      return this.field_3081.getInt(var1, 0);
   }

   public List<Player> getRecipients() {
      return new ArrayList(this.field_3079);
   }

   public String getRequestId() {
      return this.field_3073;
   }

   public Player getSender() {
      return this.field_3078;
   }

   public int getStatus() {
      return this.field_3076;
   }

   public int getType() {
      return this.field_3072;
   }

   public int getVersionCode() {
      return this.field_3082;
   }

   public int hashCode() {
      return method_3275(this);
   }

   // $FF: renamed from: iG () android.os.Bundle
   public Bundle method_3279() {
      return this.field_3081;
   }

   public boolean isConsumed(String var1) {
      return this.getRecipientStatus(var1) == 1;
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_3278(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      GameRequestEntityCreator.method_2683(this, var1, var2);
   }
}
