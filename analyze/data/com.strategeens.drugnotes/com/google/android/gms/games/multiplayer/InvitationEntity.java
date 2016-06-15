package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntityCreator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
   public static final Creator<InvitationEntity> CREATOR = new InvitationEntity.InvitationEntityCreatorCompat();
   // $FF: renamed from: CK int
   private final int field_983;
   // $FF: renamed from: YG java.lang.String
   private final String field_984;
   private final GameEntity acs;
   private final long adS;
   private final int adT;
   private final ParticipantEntity adU;
   private final ArrayList<ParticipantEntity> adV;
   private final int adW;
   private final int adX;

   InvitationEntity(int var1, GameEntity var2, String var3, long var4, int var6, ParticipantEntity var7, ArrayList<ParticipantEntity> var8, int var9, int var10) {
      this.field_983 = var1;
      this.acs = var2;
      this.field_984 = var3;
      this.adS = var4;
      this.adT = var6;
      this.adU = var7;
      this.adV = var8;
      this.adW = var9;
      this.adX = var10;
   }

   InvitationEntity(Invitation var1) {
      this.field_983 = 2;
      this.acs = new GameEntity(var1.getGame());
      this.field_984 = var1.getInvitationId();
      this.adS = var1.getCreationTimestamp();
      this.adT = var1.getInvitationType();
      this.adW = var1.getVariant();
      this.adX = var1.getAvailableAutoMatchSlots();
      String var2 = var1.getInviter().getParticipantId();
      Participant var3 = null;
      ArrayList var4 = var1.getParticipants();
      int var5 = var4.size();
      this.adV = new ArrayList(var5);

      for(int var6 = 0; var6 < var5; ++var6) {
         Participant var8 = (Participant)var4.get(var6);
         if(var8.getParticipantId().equals(var2)) {
            var3 = var8;
         }

         this.adV.add((ParticipantEntity)var8.freeze());
      }

      class_335.method_2306(var3, "Must have a valid inviter!");
      this.adU = (ParticipantEntity)var3.freeze();
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Invitation) int
   static int method_2384(Invitation var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getInvitationId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getInvitationType()), var0.getInviter(), var0.getParticipants(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getAvailableAutoMatchSlots())};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Invitation, java.lang.Object) boolean
   static boolean method_2385(Invitation var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Invitation)) {
         var2 = false;
      } else if(var0 != var1) {
         Invitation var3 = (Invitation)var1;
         if(!class_336.equal(var3.getGame(), var0.getGame()) || !class_336.equal(var3.getInvitationId(), var0.getInvitationId()) || !class_336.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_336.equal(Integer.valueOf(var3.getInvitationType()), Integer.valueOf(var0.getInvitationType())) || !class_336.equal(var3.getInviter(), var0.getInviter()) || !class_336.equal(var3.getParticipants(), var0.getParticipants()) || !class_336.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !class_336.equal(Integer.valueOf(var3.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.Invitation) java.lang.String
   static String method_2386(Invitation var0) {
      return class_336.method_2312(var0).method_3424("Game", var0.getGame()).method_3424("InvitationId", var0.getInvitationId()).method_3424("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_3424("InvitationType", Integer.valueOf(var0.getInvitationType())).method_3424("Inviter", var0.getInviter()).method_3424("Participants", var0.getParticipants()).method_3424("Variant", Integer.valueOf(var0.getVariant())).method_3424("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2385(this, var1);
   }

   public Invitation freeze() {
      return this;
   }

   public int getAvailableAutoMatchSlots() {
      return this.adX;
   }

   public long getCreationTimestamp() {
      return this.adS;
   }

   public Game getGame() {
      return this.acs;
   }

   public String getInvitationId() {
      return this.field_984;
   }

   public int getInvitationType() {
      return this.adT;
   }

   public Participant getInviter() {
      return this.adU;
   }

   public ArrayList<Participant> getParticipants() {
      return new ArrayList(this.adV);
   }

   public int getVariant() {
      return this.adW;
   }

   public int getVersionCode() {
      return this.field_983;
   }

   public int hashCode() {
      return method_2384(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_2386(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.hu()) {
         InvitationEntityCreator.method_4479(this, var1, var2);
      } else {
         this.acs.writeToParcel(var1, var2);
         var1.writeString(this.field_984);
         var1.writeLong(this.adS);
         var1.writeInt(this.adT);
         this.adU.writeToParcel(var1, var2);
         int var3 = this.adV.size();
         var1.writeInt(var3);

         for(int var4 = 0; var4 < var3; ++var4) {
            ((ParticipantEntity)this.adV.get(var4)).writeToParcel(var1, var2);
         }
      }

   }

   static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_4480(var1);
      }

      // $FF: renamed from: cz (android.os.Parcel) com.google.android.gms.games.multiplayer.InvitationEntity
      public InvitationEntity method_4480(Parcel var1) {
         if(!InvitationEntity.c(InvitationEntity.ht()) && !InvitationEntity.aW(InvitationEntity.class.getCanonicalName())) {
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
            return super.method_4480(var1);
         }
      }
   }
}
