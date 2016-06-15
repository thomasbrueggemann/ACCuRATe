package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntityCreator;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_719;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
   public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntity.ParticipantEntityCreatorCompat();
   // $FF: renamed from: CK int
   private final int field_985;
   // $FF: renamed from: FO int
   private final int field_986;
   // $FF: renamed from: FP int
   private final int field_987;
   // $FF: renamed from: OS java.lang.String
   private final String field_988;
   // $FF: renamed from: WD android.net.Uri
   private final Uri field_989;
   // $FF: renamed from: WE android.net.Uri
   private final Uri field_990;
   // $FF: renamed from: WO java.lang.String
   private final String field_991;
   // $FF: renamed from: WP java.lang.String
   private final String field_992;
   // $FF: renamed from: XE com.google.android.gms.games.PlayerEntity
   private final PlayerEntity field_993;
   // $FF: renamed from: Yi java.lang.String
   private final String field_994;
   // $FF: renamed from: Zk java.lang.String
   private final String field_995;
   private final boolean adZ;
   private final ParticipantResult aea;

   ParticipantEntity(int var1, String var2, String var3, Uri var4, Uri var5, int var6, String var7, boolean var8, PlayerEntity var9, int var10, ParticipantResult var11, String var12, String var13) {
      this.field_985 = var1;
      this.field_995 = var2;
      this.field_988 = var3;
      this.field_989 = var4;
      this.field_990 = var5;
      this.field_987 = var6;
      this.field_994 = var7;
      this.adZ = var8;
      this.field_993 = var9;
      this.field_986 = var10;
      this.aea = var11;
      this.field_991 = var12;
      this.field_992 = var13;
   }

   public ParticipantEntity(Participant var1) {
      this.field_985 = 3;
      this.field_995 = var1.getParticipantId();
      this.field_988 = var1.getDisplayName();
      this.field_989 = var1.getIconImageUri();
      this.field_990 = var1.getHiResImageUri();
      this.field_987 = var1.getStatus();
      this.field_994 = var1.method_257();
      this.adZ = var1.isConnectedToRoom();
      Player var2 = var1.getPlayer();
      PlayerEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new PlayerEntity(var2);
      }

      this.field_993 = var3;
      this.field_986 = var1.getCapabilities();
      this.aea = var1.getResult();
      this.field_991 = var1.getIconImageUrl();
      this.field_992 = var1.getHiResImageUrl();
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Participant) int
   static int method_2390(Participant var0) {
      Object[] var1 = new Object[]{var0.getPlayer(), Integer.valueOf(var0.getStatus()), var0.method_257(), Boolean.valueOf(var0.isConnectedToRoom()), var0.getDisplayName(), var0.getIconImageUri(), var0.getHiResImageUri(), Integer.valueOf(var0.getCapabilities()), var0.getResult(), var0.getParticipantId()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Participant, java.lang.Object) boolean
   static boolean method_2391(Participant var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Participant)) {
         var2 = false;
      } else if(var0 != var1) {
         Participant var3 = (Participant)var1;
         if(!class_336.equal(var3.getPlayer(), var0.getPlayer()) || !class_336.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !class_336.equal(var3.method_257(), var0.method_257()) || !class_336.equal(Boolean.valueOf(var3.isConnectedToRoom()), Boolean.valueOf(var0.isConnectedToRoom())) || !class_336.equal(var3.getDisplayName(), var0.getDisplayName()) || !class_336.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_336.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) || !class_336.equal(Integer.valueOf(var3.getCapabilities()), Integer.valueOf(var0.getCapabilities())) || !class_336.equal(var3.getResult(), var0.getResult()) || !class_336.equal(var3.getParticipantId(), var0.getParticipantId())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.Participant) java.lang.String
   static String method_2392(Participant var0) {
      return class_336.method_2312(var0).method_3424("ParticipantId", var0.getParticipantId()).method_3424("Player", var0.getPlayer()).method_3424("Status", Integer.valueOf(var0.getStatus())).method_3424("ClientAddress", var0.method_257()).method_3424("ConnectedToRoom", Boolean.valueOf(var0.isConnectedToRoom())).method_3424("DisplayName", var0.getDisplayName()).method_3424("IconImage", var0.getIconImageUri()).method_3424("IconImageUrl", var0.getIconImageUrl()).method_3424("HiResImage", var0.getHiResImageUri()).method_3424("HiResImageUrl", var0.getHiResImageUrl()).method_3424("Capabilities", Integer.valueOf(var0.getCapabilities())).method_3424("Result", var0.getResult()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2391(this, var1);
   }

   public Participant freeze() {
      return this;
   }

   public int getCapabilities() {
      return this.field_986;
   }

   public String getDisplayName() {
      return this.field_993 == null?this.field_988:this.field_993.getDisplayName();
   }

   public void getDisplayName(CharArrayBuffer var1) {
      if(this.field_993 == null) {
         class_719.method_4197(this.field_988, var1);
      } else {
         this.field_993.getDisplayName(var1);
      }
   }

   public Uri getHiResImageUri() {
      return this.field_993 == null?this.field_990:this.field_993.getHiResImageUri();
   }

   public String getHiResImageUrl() {
      return this.field_993 == null?this.field_992:this.field_993.getHiResImageUrl();
   }

   public Uri getIconImageUri() {
      return this.field_993 == null?this.field_989:this.field_993.getIconImageUri();
   }

   public String getIconImageUrl() {
      return this.field_993 == null?this.field_991:this.field_993.getIconImageUrl();
   }

   public String getParticipantId() {
      return this.field_995;
   }

   public Player getPlayer() {
      return this.field_993;
   }

   public ParticipantResult getResult() {
      return this.aea;
   }

   public int getStatus() {
      return this.field_987;
   }

   public int getVersionCode() {
      return this.field_985;
   }

   public int hashCode() {
      return method_2390(this);
   }

   public boolean isConnectedToRoom() {
      return this.adZ;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: le () java.lang.String
   public String method_257() {
      return this.field_994;
   }

   public String toString() {
      return method_2392(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.hu()) {
         ParticipantEntityCreator.method_3418(this, var1, var2);
      } else {
         var1.writeString(this.field_995);
         var1.writeString(this.field_988);
         String var3;
         if(this.field_989 == null) {
            var3 = null;
         } else {
            var3 = this.field_989.toString();
         }

         var1.writeString(var3);
         Uri var4 = this.field_990;
         String var5 = null;
         if(var4 != null) {
            var5 = this.field_990.toString();
         }

         var1.writeString(var5);
         var1.writeInt(this.field_987);
         var1.writeString(this.field_994);
         byte var6;
         if(this.adZ) {
            var6 = 1;
         } else {
            var6 = 0;
         }

         var1.writeInt(var6);
         PlayerEntity var7 = this.field_993;
         byte var8 = 0;
         if(var7 != null) {
            var8 = 1;
         }

         var1.writeInt(var8);
         if(this.field_993 != null) {
            this.field_993.writeToParcel(var1, var2);
            return;
         }
      }

   }

   static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
      // $FF: renamed from: cA (android.os.Parcel) com.google.android.gms.games.multiplayer.ParticipantEntity
      public ParticipantEntity method_3419(Parcel var1) {
         boolean var2 = true;
         if(!ParticipantEntity.c(ParticipantEntity.ht()) && !ParticipantEntity.aW(ParticipantEntity.class.getCanonicalName())) {
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
            return super.method_3419(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_3419(var1);
      }
   }
}
