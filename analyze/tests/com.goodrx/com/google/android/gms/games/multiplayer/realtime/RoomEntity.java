package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomEntityCreator;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
   public static final Creator<RoomEntity> CREATOR = new RoomEntity.RoomEntityCreatorCompat();
   private final int mVersionCode;
   private final String zzaEw;
   private final long zzaJF;
   private final ArrayList<ParticipantEntity> zzaJI;
   private final int zzaJJ;
   private final Bundle zzaJZ;
   private final String zzaKb;
   private final int zzaKc;
   private final int zzaKd;
   private final String zzaxl;

   RoomEntity(int var1, String var2, String var3, long var4, int var6, String var7, int var8, Bundle var9, ArrayList<ParticipantEntity> var10, int var11) {
      this.mVersionCode = var1;
      this.zzaEw = var2;
      this.zzaKb = var3;
      this.zzaJF = var4;
      this.zzaKc = var6;
      this.zzaxl = var7;
      this.zzaJJ = var8;
      this.zzaJZ = var9;
      this.zzaJI = var10;
      this.zzaKd = var11;
   }

   public RoomEntity(Room var1) {
      this.mVersionCode = 2;
      this.zzaEw = var1.getRoomId();
      this.zzaKb = var1.getCreatorId();
      this.zzaJF = var1.getCreationTimestamp();
      this.zzaKc = var1.getStatus();
      this.zzaxl = var1.getDescription();
      this.zzaJJ = var1.getVariant();
      this.zzaJZ = var1.getAutoMatchCriteria();
      ArrayList var2 = var1.getParticipants();
      int var3 = var2.size();
      this.zzaJI = new ArrayList(var3);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.zzaJI.add((ParticipantEntity)((Participant)var2.get(var4)).freeze());
      }

      this.zzaKd = var1.getAutoMatchWaitEstimateSeconds();
   }

   static int zza(Room var0) {
      Object[] var1 = new Object[]{var0.getRoomId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), var0.getAutoMatchCriteria(), var0.getParticipants(), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())};
      return zzw.hashCode(var1);
   }

   static boolean zza(Room var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Room)) {
         var2 = false;
      } else if(var0 != var1) {
         Room var3 = (Room)var1;
         if(!zzw.equal(var3.getRoomId(), var0.getRoomId()) || !zzw.equal(var3.getCreatorId(), var0.getCreatorId()) || !zzw.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !zzw.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !zzw.equal(var3.getDescription(), var0.getDescription()) || !zzw.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !zzw.equal(var3.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) || !zzw.equal(var3.getParticipants(), var0.getParticipants()) || !zzw.equal(Integer.valueOf(var3.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds()))) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(Room var0) {
      return zzw.zzy(var0).zzg("RoomId", var0.getRoomId()).zzg("CreatorId", var0.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).zzg("RoomStatus", Integer.valueOf(var0.getStatus())).zzg("Description", var0.getDescription()).zzg("Variant", Integer.valueOf(var0.getVariant())).zzg("AutoMatchCriteria", var0.getAutoMatchCriteria()).zzg("Participants", var0.getParticipants()).zzg("AutoMatchWaitEstimateSeconds", Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Room freeze() {
      return this;
   }

   public Bundle getAutoMatchCriteria() {
      return this.zzaJZ;
   }

   public int getAutoMatchWaitEstimateSeconds() {
      return this.zzaKd;
   }

   public long getCreationTimestamp() {
      return this.zzaJF;
   }

   public String getCreatorId() {
      return this.zzaKb;
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public ArrayList<Participant> getParticipants() {
      return new ArrayList(this.zzaJI);
   }

   public String getRoomId() {
      return this.zzaEw;
   }

   public int getStatus() {
      return this.zzaKc;
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
         RoomEntityCreator.zza(this, var1, var2);
      } else {
         var1.writeString(this.zzaEw);
         var1.writeString(this.zzaKb);
         var1.writeLong(this.zzaJF);
         var1.writeInt(this.zzaKc);
         var1.writeString(this.zzaxl);
         var1.writeInt(this.zzaJJ);
         var1.writeBundle(this.zzaJZ);
         int var3 = this.zzaJI.size();
         var1.writeInt(var3);

         for(int var4 = 0; var4 < var3; ++var4) {
            ((ParticipantEntity)this.zzaJI.get(var4)).writeToParcel(var1, var2);
         }
      }

   }

   static final class RoomEntityCreatorCompat extends RoomEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzev(var1);
      }

      public RoomEntity zzev(Parcel var1) {
         if(!RoomEntity.zzd(RoomEntity.zzqB()) && !RoomEntity.zzcF(RoomEntity.class.getCanonicalName())) {
            String var2 = var1.readString();
            String var3 = var1.readString();
            long var4 = var1.readLong();
            int var6 = var1.readInt();
            String var7 = var1.readString();
            int var8 = var1.readInt();
            Bundle var9 = var1.readBundle();
            int var10 = var1.readInt();
            ArrayList var11 = new ArrayList(var10);

            for(int var12 = 0; var12 < var10; ++var12) {
               var11.add(ParticipantEntity.CREATOR.createFromParcel(var1));
            }

            return new RoomEntity(2, var2, var3, var4, var6, var7, var8, var9, var11, -1);
         } else {
            return super.zzev(var1);
         }
      }
   }
}
