package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntityCreator;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
   public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntity.ParticipantEntityCreatorCompat();
   private final int mVersionCode;
   private final int zzBc;
   private final String zzWQ;
   private final Uri zzaCd;
   private final Uri zzaCe;
   private final String zzaCo;
   private final String zzaCp;
   private final String zzaDX;
   private final PlayerEntity zzaDq;
   private final String zzaFa;
   private final boolean zzaJM;
   private final ParticipantResult zzaJN;
   private final int zzaab;

   ParticipantEntity(int var1, String var2, String var3, Uri var4, Uri var5, int var6, String var7, boolean var8, PlayerEntity var9, int var10, ParticipantResult var11, String var12, String var13) {
      this.mVersionCode = var1;
      this.zzaFa = var2;
      this.zzWQ = var3;
      this.zzaCd = var4;
      this.zzaCe = var5;
      this.zzBc = var6;
      this.zzaDX = var7;
      this.zzaJM = var8;
      this.zzaDq = var9;
      this.zzaab = var10;
      this.zzaJN = var11;
      this.zzaCo = var12;
      this.zzaCp = var13;
   }

   public ParticipantEntity(Participant var1) {
      this.mVersionCode = 3;
      this.zzaFa = var1.getParticipantId();
      this.zzWQ = var1.getDisplayName();
      this.zzaCd = var1.getIconImageUri();
      this.zzaCe = var1.getHiResImageUri();
      this.zzBc = var1.getStatus();
      this.zzaDX = var1.zzwt();
      this.zzaJM = var1.isConnectedToRoom();
      Player var2 = var1.getPlayer();
      PlayerEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new PlayerEntity(var2);
      }

      this.zzaDq = var3;
      this.zzaab = var1.getCapabilities();
      this.zzaJN = var1.getResult();
      this.zzaCo = var1.getIconImageUrl();
      this.zzaCp = var1.getHiResImageUrl();
   }

   static int zza(Participant var0) {
      Object[] var1 = new Object[]{var0.getPlayer(), Integer.valueOf(var0.getStatus()), var0.zzwt(), Boolean.valueOf(var0.isConnectedToRoom()), var0.getDisplayName(), var0.getIconImageUri(), var0.getHiResImageUri(), Integer.valueOf(var0.getCapabilities()), var0.getResult(), var0.getParticipantId()};
      return zzw.hashCode(var1);
   }

   static boolean zza(Participant var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Participant)) {
         var2 = false;
      } else if(var0 != var1) {
         Participant var3 = (Participant)var1;
         if(!zzw.equal(var3.getPlayer(), var0.getPlayer()) || !zzw.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !zzw.equal(var3.zzwt(), var0.zzwt()) || !zzw.equal(Boolean.valueOf(var3.isConnectedToRoom()), Boolean.valueOf(var0.isConnectedToRoom())) || !zzw.equal(var3.getDisplayName(), var0.getDisplayName()) || !zzw.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !zzw.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) || !zzw.equal(Integer.valueOf(var3.getCapabilities()), Integer.valueOf(var0.getCapabilities())) || !zzw.equal(var3.getResult(), var0.getResult()) || !zzw.equal(var3.getParticipantId(), var0.getParticipantId())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(Participant var0) {
      return zzw.zzy(var0).zzg("ParticipantId", var0.getParticipantId()).zzg("Player", var0.getPlayer()).zzg("Status", Integer.valueOf(var0.getStatus())).zzg("ClientAddress", var0.zzwt()).zzg("ConnectedToRoom", Boolean.valueOf(var0.isConnectedToRoom())).zzg("DisplayName", var0.getDisplayName()).zzg("IconImage", var0.getIconImageUri()).zzg("IconImageUrl", var0.getIconImageUrl()).zzg("HiResImage", var0.getHiResImageUri()).zzg("HiResImageUrl", var0.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(var0.getCapabilities())).zzg("Result", var0.getResult()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Participant freeze() {
      return this;
   }

   public int getCapabilities() {
      return this.zzaab;
   }

   public String getDisplayName() {
      return this.zzaDq == null?this.zzWQ:this.zzaDq.getDisplayName();
   }

   public Uri getHiResImageUri() {
      return this.zzaDq == null?this.zzaCe:this.zzaDq.getHiResImageUri();
   }

   public String getHiResImageUrl() {
      return this.zzaDq == null?this.zzaCp:this.zzaDq.getHiResImageUrl();
   }

   public Uri getIconImageUri() {
      return this.zzaDq == null?this.zzaCd:this.zzaDq.getIconImageUri();
   }

   public String getIconImageUrl() {
      return this.zzaDq == null?this.zzaCo:this.zzaDq.getIconImageUrl();
   }

   public String getParticipantId() {
      return this.zzaFa;
   }

   public Player getPlayer() {
      return this.zzaDq;
   }

   public ParticipantResult getResult() {
      return this.zzaJN;
   }

   public int getStatus() {
      return this.zzBc;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zza(this);
   }

   public boolean isConnectedToRoom() {
      return this.zzaJM;
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.zzqC()) {
         ParticipantEntityCreator.zza(this, var1, var2);
      } else {
         var1.writeString(this.zzaFa);
         var1.writeString(this.zzWQ);
         String var3;
         if(this.zzaCd == null) {
            var3 = null;
         } else {
            var3 = this.zzaCd.toString();
         }

         var1.writeString(var3);
         Uri var4 = this.zzaCe;
         String var5 = null;
         if(var4 != null) {
            var5 = this.zzaCe.toString();
         }

         var1.writeString(var5);
         var1.writeInt(this.zzBc);
         var1.writeString(this.zzaDX);
         byte var6;
         if(this.zzaJM) {
            var6 = 1;
         } else {
            var6 = 0;
         }

         var1.writeInt(var6);
         PlayerEntity var7 = this.zzaDq;
         byte var8 = 0;
         if(var7 != null) {
            var8 = 1;
         }

         var1.writeInt(var8);
         if(this.zzaDq != null) {
            this.zzaDq.writeToParcel(var1, var2);
            return;
         }
      }

   }

   public String zzwt() {
      return this.zzaDX;
   }

   static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzes(var1);
      }

      public ParticipantEntity zzes(Parcel var1) {
         boolean var2 = true;
         if(!ParticipantEntity.zzd(ParticipantEntity.zzqB()) && !ParticipantEntity.zzcF(ParticipantEntity.class.getCanonicalName())) {
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
            return super.zzes(var1);
         }
      }
   }
}
