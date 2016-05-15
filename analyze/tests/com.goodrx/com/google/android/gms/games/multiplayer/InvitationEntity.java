package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntityCreator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
   public static final Creator<InvitationEntity> CREATOR = new InvitationEntity.InvitationEntityCreatorCompat();
   private final int mVersionCode;
   private final String zzUO;
   private final GameEntity zzaJE;
   private final long zzaJF;
   private final int zzaJG;
   private final ParticipantEntity zzaJH;
   private final ArrayList<ParticipantEntity> zzaJI;
   private final int zzaJJ;
   private final int zzaJK;

   InvitationEntity(int var1, GameEntity var2, String var3, long var4, int var6, ParticipantEntity var7, ArrayList<ParticipantEntity> var8, int var9, int var10) {
      this.mVersionCode = var1;
      this.zzaJE = var2;
      this.zzUO = var3;
      this.zzaJF = var4;
      this.zzaJG = var6;
      this.zzaJH = var7;
      this.zzaJI = var8;
      this.zzaJJ = var9;
      this.zzaJK = var10;
   }

   InvitationEntity(Invitation var1) {
      this.mVersionCode = 2;
      this.zzaJE = new GameEntity(var1.getGame());
      this.zzUO = var1.getInvitationId();
      this.zzaJF = var1.getCreationTimestamp();
      this.zzaJG = var1.getInvitationType();
      this.zzaJJ = var1.getVariant();
      this.zzaJK = var1.getAvailableAutoMatchSlots();
      String var2 = var1.getInviter().getParticipantId();
      Participant var3 = null;
      ArrayList var4 = var1.getParticipants();
      int var5 = var4.size();
      this.zzaJI = new ArrayList(var5);

      for(int var6 = 0; var6 < var5; ++var6) {
         Participant var8 = (Participant)var4.get(var6);
         if(var8.getParticipantId().equals(var2)) {
            var3 = var8;
         }

         this.zzaJI.add((ParticipantEntity)var8.freeze());
      }

      zzx.zzb(var3, "Must have a valid inviter!");
      this.zzaJH = (ParticipantEntity)var3.freeze();
   }

   static int zza(Invitation var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getInvitationId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getInvitationType()), var0.getInviter(), var0.getParticipants(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getAvailableAutoMatchSlots())};
      return zzw.hashCode(var1);
   }

   static boolean zza(Invitation var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Invitation)) {
         var2 = false;
      } else if(var0 != var1) {
         Invitation var3 = (Invitation)var1;
         if(!zzw.equal(var3.getGame(), var0.getGame()) || !zzw.equal(var3.getInvitationId(), var0.getInvitationId()) || !zzw.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !zzw.equal(Integer.valueOf(var3.getInvitationType()), Integer.valueOf(var0.getInvitationType())) || !zzw.equal(var3.getInviter(), var0.getInviter()) || !zzw.equal(var3.getParticipants(), var0.getParticipants()) || !zzw.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !zzw.equal(Integer.valueOf(var3.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots()))) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(Invitation var0) {
      return zzw.zzy(var0).zzg("Game", var0.getGame()).zzg("InvitationId", var0.getInvitationId()).zzg("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).zzg("InvitationType", Integer.valueOf(var0.getInvitationType())).zzg("Inviter", var0.getInviter()).zzg("Participants", var0.getParticipants()).zzg("Variant", Integer.valueOf(var0.getVariant())).zzg("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Invitation freeze() {
      return this;
   }

   public int getAvailableAutoMatchSlots() {
      return this.zzaJK;
   }

   public long getCreationTimestamp() {
      return this.zzaJF;
   }

   public Game getGame() {
      return this.zzaJE;
   }

   public String getInvitationId() {
      return this.zzUO;
   }

   public int getInvitationType() {
      return this.zzaJG;
   }

   public Participant getInviter() {
      return this.zzaJH;
   }

   public ArrayList<Participant> getParticipants() {
      return new ArrayList(this.zzaJI);
   }

   public int getVariant() {
      return this.zzaJJ;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zza(this);
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.zzqC()) {
         InvitationEntityCreator.zza(this, var1, var2);
      } else {
         this.zzaJE.writeToParcel(var1, var2);
         var1.writeString(this.zzUO);
         var1.writeLong(this.zzaJF);
         var1.writeInt(this.zzaJG);
         this.zzaJH.writeToParcel(var1, var2);
         int var3 = this.zzaJI.size();
         var1.writeInt(var3);

         for(int var4 = 0; var4 < var3; ++var4) {
            ((ParticipantEntity)this.zzaJI.get(var4)).writeToParcel(var1, var2);
         }
      }

   }

   static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzer(var1);
      }

      public InvitationEntity zzer(Parcel var1) {
         if(!InvitationEntity.zzd(InvitationEntity.zzqB()) && !InvitationEntity.zzcF(InvitationEntity.class.getCanonicalName())) {
            GameEntity var2 = (GameEntity)GameEntity.CREATOR.createFromParcel(var1);
            String var3 = var1.readString();
            long var4 = var1.readLong();
            int var6 = var1.readInt();
            ParticipantEntity var7 = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(var1);
            int var8 = var1.readInt();
            ArrayList var9 = new ArrayList(var8);

            for(int var10 = 0; var10 < var8; ++var10) {
               var9.add(ParticipantEntity.CREATOR.createFromParcel(var1));
            }

            return new InvitationEntity(2, var2, var3, var4, var6, var7, var9, -1, 0);
         } else {
            return super.zzer(var1);
         }
      }
   }
}
