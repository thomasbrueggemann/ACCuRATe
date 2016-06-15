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
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
   public static final Creator<InvitationEntity> CREATOR = new InvitationEntity.InvitationEntityCreatorCompat();
   // $FF: renamed from: NN java.lang.String
   private final String field_1446;
   // $FF: renamed from: Rq com.google.android.gms.games.GameEntity
   private final GameEntity field_1447;
   // $FF: renamed from: SR long
   private final long field_1448;
   // $FF: renamed from: SS int
   private final int field_1449;
   // $FF: renamed from: ST com.google.android.gms.games.multiplayer.ParticipantEntity
   private final ParticipantEntity field_1450;
   // $FF: renamed from: SU java.util.ArrayList
   private final ArrayList<ParticipantEntity> field_1451;
   // $FF: renamed from: SV int
   private final int field_1452;
   // $FF: renamed from: SW int
   private final int field_1453;
   // $FF: renamed from: xJ int
   private final int field_1454;

   InvitationEntity(int var1, GameEntity var2, String var3, long var4, int var6, ParticipantEntity var7, ArrayList<ParticipantEntity> var8, int var9, int var10) {
      this.field_1454 = var1;
      this.field_1447 = var2;
      this.field_1446 = var3;
      this.field_1448 = var4;
      this.field_1449 = var6;
      this.field_1450 = var7;
      this.field_1451 = var8;
      this.field_1452 = var9;
      this.field_1453 = var10;
   }

   InvitationEntity(Invitation var1) {
      this.field_1454 = 2;
      this.field_1447 = new GameEntity(var1.getGame());
      this.field_1446 = var1.getInvitationId();
      this.field_1448 = var1.getCreationTimestamp();
      this.field_1449 = var1.getInvitationType();
      this.field_1452 = var1.getVariant();
      this.field_1453 = var1.getAvailableAutoMatchSlots();
      String var2 = var1.getInviter().getParticipantId();
      Participant var3 = null;
      ArrayList var4 = var1.getParticipants();
      int var5 = var4.size();
      this.field_1451 = new ArrayList(var5);

      for(int var6 = 0; var6 < var5; ++var6) {
         Participant var8 = (Participant)var4.get(var6);
         if(var8.getParticipantId().equals(var2)) {
            var3 = var8;
         }

         this.field_1451.add((ParticipantEntity)var8.freeze());
      }

      class_347.method_2166(var3, "Must have a valid inviter!");
      this.field_1450 = (ParticipantEntity)var3.freeze();
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Invitation) int
   static int method_2196(Invitation var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getInvitationId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getInvitationType()), var0.getInviter(), var0.getParticipants(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getAvailableAutoMatchSlots())};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Invitation, java.lang.Object) boolean
   static boolean method_2197(Invitation var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Invitation)) {
         var2 = false;
      } else if(var0 != var1) {
         Invitation var3 = (Invitation)var1;
         if(!class_349.equal(var3.getGame(), var0.getGame()) || !class_349.equal(var3.getInvitationId(), var0.getInvitationId()) || !class_349.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_349.equal(Integer.valueOf(var3.getInvitationType()), Integer.valueOf(var0.getInvitationType())) || !class_349.equal(var3.getInviter(), var0.getInviter()) || !class_349.equal(var3.getParticipants(), var0.getParticipants()) || !class_349.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !class_349.equal(Integer.valueOf(var3.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.Invitation) java.lang.String
   static String method_2199(Invitation var0) {
      return class_349.method_2174(var0).method_4301("Game", var0.getGame()).method_4301("InvitationId", var0.getInvitationId()).method_4301("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_4301("InvitationType", Integer.valueOf(var0.getInvitationType())).method_4301("Inviter", var0.getInviter()).method_4301("Participants", var0.getParticipants()).method_4301("Variant", Integer.valueOf(var0.getVariant())).method_4301("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2197(this, var1);
   }

   public Invitation freeze() {
      return this;
   }

   public int getAvailableAutoMatchSlots() {
      return this.field_1453;
   }

   public long getCreationTimestamp() {
      return this.field_1448;
   }

   public Game getGame() {
      return this.field_1447;
   }

   public String getInvitationId() {
      return this.field_1446;
   }

   public int getInvitationType() {
      return this.field_1449;
   }

   public Participant getInviter() {
      return this.field_1450;
   }

   public ArrayList<Participant> getParticipants() {
      return new ArrayList(this.field_1451);
   }

   public int getVariant() {
      return this.field_1452;
   }

   public int getVersionCode() {
      return this.field_1454;
   }

   public int hashCode() {
      return method_2196(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_2199(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.fm()) {
         InvitationEntityCreator.method_3665(this, var1, var2);
      } else {
         this.field_1447.writeToParcel(var1, var2);
         var1.writeString(this.field_1446);
         var1.writeLong(this.field_1448);
         var1.writeInt(this.field_1449);
         this.field_1450.writeToParcel(var1, var2);
         int var3 = this.field_1451.size();
         var1.writeInt(var3);

         for(int var4 = 0; var4 < var3; ++var4) {
            ((ParticipantEntity)this.field_1451.get(var4)).writeToParcel(var1, var2);
         }
      }

   }

   static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
      // $FF: renamed from: bl (android.os.Parcel) com.google.android.gms.games.multiplayer.InvitationEntity
      public InvitationEntity method_3666(Parcel var1) {
         if(!InvitationEntity.c(InvitationEntity.fl()) && !InvitationEntity.aA(InvitationEntity.class.getCanonicalName())) {
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
            return super.method_3666(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_3666(var1);
      }
   }
}
