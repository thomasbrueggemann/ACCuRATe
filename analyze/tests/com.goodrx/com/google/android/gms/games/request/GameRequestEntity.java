package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
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
   public static final Creator<GameRequestEntity> CREATOR = new GameRequestEntityCreator();
   private final int mVersionCode;
   private final int zzBc;
   private final String zzEY;
   private final GameEntity zzaJE;
   private final long zzaJF;
   private final PlayerEntity zzaKG;
   private final ArrayList<PlayerEntity> zzaKH;
   private final long zzaKI;
   private final Bundle zzaKJ;
   private final byte[] zzaKm;
   private final int zzabB;

   GameRequestEntity(int var1, GameEntity var2, PlayerEntity var3, byte[] var4, String var5, ArrayList<PlayerEntity> var6, int var7, long var8, long var10, Bundle var12, int var13) {
      this.mVersionCode = var1;
      this.zzaJE = var2;
      this.zzaKG = var3;
      this.zzaKm = var4;
      this.zzEY = var5;
      this.zzaKH = var6;
      this.zzabB = var7;
      this.zzaJF = var8;
      this.zzaKI = var10;
      this.zzaKJ = var12;
      this.zzBc = var13;
   }

   public GameRequestEntity(GameRequest var1) {
      this.mVersionCode = 2;
      this.zzaJE = new GameEntity(var1.getGame());
      this.zzaKG = new PlayerEntity(var1.getSender());
      this.zzEY = var1.getRequestId();
      this.zzabB = var1.getType();
      this.zzaJF = var1.getCreationTimestamp();
      this.zzaKI = var1.getExpirationTimestamp();
      this.zzBc = var1.getStatus();
      byte[] var2 = var1.getData();
      if(var2 == null) {
         this.zzaKm = null;
      } else {
         this.zzaKm = new byte[var2.length];
         System.arraycopy(var2, 0, this.zzaKm, 0, var2.length);
      }

      List var3 = var1.getRecipients();
      int var4 = var3.size();
      this.zzaKH = new ArrayList(var4);
      this.zzaKJ = new Bundle();

      for(int var5 = 0; var5 < var4; ++var5) {
         Player var6 = (Player)((Player)var3.get(var5)).freeze();
         String var7 = var6.getPlayerId();
         this.zzaKH.add((PlayerEntity)var6);
         this.zzaKJ.putInt(var7, var1.getRecipientStatus(var7));
      }

   }

   static int zza(GameRequest var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getRecipients(), var0.getRequestId(), var0.getSender(), zzb(var0), Integer.valueOf(var0.getType()), Long.valueOf(var0.getCreationTimestamp()), Long.valueOf(var0.getExpirationTimestamp())};
      return zzw.hashCode(var1);
   }

   static boolean zza(GameRequest var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof GameRequest)) {
         var2 = false;
      } else if(var0 != var1) {
         GameRequest var3 = (GameRequest)var1;
         if(!zzw.equal(var3.getGame(), var0.getGame()) || !zzw.equal(var3.getRecipients(), var0.getRecipients()) || !zzw.equal(var3.getRequestId(), var0.getRequestId()) || !zzw.equal(var3.getSender(), var0.getSender()) || !Arrays.equals(zzb(var3), zzb(var0)) || !zzw.equal(Integer.valueOf(var3.getType()), Integer.valueOf(var0.getType())) || !zzw.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !zzw.equal(Long.valueOf(var3.getExpirationTimestamp()), Long.valueOf(var0.getExpirationTimestamp()))) {
            return false;
         }
      }

      return var2;
   }

   private static int[] zzb(GameRequest var0) {
      List var1 = var0.getRecipients();
      int var2 = var1.size();
      int[] var3 = new int[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = var0.getRecipientStatus(((Player)var1.get(var4)).getPlayerId());
      }

      return var3;
   }

   static String zzc(GameRequest var0) {
      return zzw.zzy(var0).zzg("Game", var0.getGame()).zzg("Sender", var0.getSender()).zzg("Recipients", var0.getRecipients()).zzg("Data", var0.getData()).zzg("RequestId", var0.getRequestId()).zzg("Type", Integer.valueOf(var0.getType())).zzg("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(var0.getExpirationTimestamp())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public GameRequest freeze() {
      return this;
   }

   public long getCreationTimestamp() {
      return this.zzaJF;
   }

   public byte[] getData() {
      return this.zzaKm;
   }

   public long getExpirationTimestamp() {
      return this.zzaKI;
   }

   public Game getGame() {
      return this.zzaJE;
   }

   public int getRecipientStatus(String var1) {
      return this.zzaKJ.getInt(var1, 0);
   }

   public List<Player> getRecipients() {
      return new ArrayList(this.zzaKH);
   }

   public String getRequestId() {
      return this.zzEY;
   }

   public Player getSender() {
      return this.zzaKG;
   }

   public int getStatus() {
      return this.zzBc;
   }

   public int getType() {
      return this.zzabB;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zza(this);
   }

   public String toString() {
      return zzc(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      GameRequestEntityCreator.zza(this, var1, var2);
   }

   public Bundle zzxT() {
      return this.zzaKJ;
   }
}
