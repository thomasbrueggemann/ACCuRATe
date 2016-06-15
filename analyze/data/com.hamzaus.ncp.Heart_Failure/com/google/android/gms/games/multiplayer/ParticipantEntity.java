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
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_349;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
   public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntity.ParticipantEntityCreatorCompat();
   // $FF: renamed from: Am int
   private final int field_1455;
   // $FF: renamed from: Lk java.lang.String
   private final String field_1456;
   // $FF: renamed from: MA java.lang.String
   private final String field_1457;
   // $FF: renamed from: Mo android.net.Uri
   private final Uri field_1458;
   // $FF: renamed from: Mp android.net.Uri
   private final Uri field_1459;
   // $FF: renamed from: Mz java.lang.String
   private final String field_1460;
   // $FF: renamed from: Ng com.google.android.gms.games.PlayerEntity
   private final PlayerEntity field_1461;
   // $FF: renamed from: Nk java.lang.String
   private final String field_1462;
   // $FF: renamed from: On java.lang.String
   private final String field_1463;
   // $FF: renamed from: SY int
   private final int field_1464;
   // $FF: renamed from: SZ boolean
   private final boolean field_1465;
   // $FF: renamed from: Ta com.google.android.gms.games.multiplayer.ParticipantResult
   private final ParticipantResult field_1466;
   // $FF: renamed from: xJ int
   private final int field_1467;

   ParticipantEntity(int var1, String var2, String var3, Uri var4, Uri var5, int var6, String var7, boolean var8, PlayerEntity var9, int var10, ParticipantResult var11, String var12, String var13) {
      this.field_1467 = var1;
      this.field_1463 = var2;
      this.field_1456 = var3;
      this.field_1458 = var4;
      this.field_1459 = var5;
      this.field_1464 = var6;
      this.field_1462 = var7;
      this.field_1465 = var8;
      this.field_1461 = var9;
      this.field_1455 = var10;
      this.field_1466 = var11;
      this.field_1460 = var12;
      this.field_1457 = var13;
   }

   public ParticipantEntity(Participant var1) {
      this.field_1467 = 3;
      this.field_1463 = var1.getParticipantId();
      this.field_1456 = var1.getDisplayName();
      this.field_1458 = var1.getIconImageUri();
      this.field_1459 = var1.getHiResImageUri();
      this.field_1464 = var1.getStatus();
      this.field_1462 = var1.method_232();
      this.field_1465 = var1.isConnectedToRoom();
      Player var2 = var1.getPlayer();
      PlayerEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new PlayerEntity(var2);
      }

      this.field_1461 = var3;
      this.field_1455 = var1.getCapabilities();
      this.field_1466 = var1.getResult();
      this.field_1460 = var1.getIconImageUrl();
      this.field_1457 = var1.getHiResImageUrl();
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Participant) int
   static int method_2202(Participant var0) {
      Object[] var1 = new Object[]{var0.getPlayer(), Integer.valueOf(var0.getStatus()), var0.method_232(), Boolean.valueOf(var0.isConnectedToRoom()), var0.getDisplayName(), var0.getIconImageUri(), var0.getHiResImageUri(), Integer.valueOf(var0.getCapabilities()), var0.getResult(), var0.getParticipantId()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Participant, java.lang.Object) boolean
   static boolean method_2203(Participant var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Participant)) {
         var2 = false;
      } else if(var0 != var1) {
         Participant var3 = (Participant)var1;
         if(!class_349.equal(var3.getPlayer(), var0.getPlayer()) || !class_349.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !class_349.equal(var3.method_232(), var0.method_232()) || !class_349.equal(Boolean.valueOf(var3.isConnectedToRoom()), Boolean.valueOf(var0.isConnectedToRoom())) || !class_349.equal(var3.getDisplayName(), var0.getDisplayName()) || !class_349.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_349.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) || !class_349.equal(Integer.valueOf(var3.getCapabilities()), Integer.valueOf(var0.getCapabilities())) || !class_349.equal(var3.getResult(), var0.getResult()) || !class_349.equal(var3.getParticipantId(), var0.getParticipantId())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.Participant) java.lang.String
   static String method_2205(Participant var0) {
      return class_349.method_2174(var0).method_4301("ParticipantId", var0.getParticipantId()).method_4301("Player", var0.getPlayer()).method_4301("Status", Integer.valueOf(var0.getStatus())).method_4301("ClientAddress", var0.method_232()).method_4301("ConnectedToRoom", Boolean.valueOf(var0.isConnectedToRoom())).method_4301("DisplayName", var0.getDisplayName()).method_4301("IconImage", var0.getIconImageUri()).method_4301("IconImageUrl", var0.getIconImageUrl()).method_4301("HiResImage", var0.getHiResImageUri()).method_4301("HiResImageUrl", var0.getHiResImageUrl()).method_4301("Capabilities", Integer.valueOf(var0.getCapabilities())).method_4301("Result", var0.getResult()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2203(this, var1);
   }

   public Participant freeze() {
      return this;
   }

   // $FF: renamed from: gR () java.lang.String
   public String method_232() {
      return this.field_1462;
   }

   public int getCapabilities() {
      return this.field_1455;
   }

   public String getDisplayName() {
      return this.field_1461 == null?this.field_1456:this.field_1461.getDisplayName();
   }

   public void getDisplayName(CharArrayBuffer var1) {
      if(this.field_1461 == null) {
         class_284.method_1876(this.field_1456, var1);
      } else {
         this.field_1461.getDisplayName(var1);
      }
   }

   public Uri getHiResImageUri() {
      return this.field_1461 == null?this.field_1459:this.field_1461.getHiResImageUri();
   }

   public String getHiResImageUrl() {
      return this.field_1461 == null?this.field_1457:this.field_1461.getHiResImageUrl();
   }

   public Uri getIconImageUri() {
      return this.field_1461 == null?this.field_1458:this.field_1461.getIconImageUri();
   }

   public String getIconImageUrl() {
      return this.field_1461 == null?this.field_1460:this.field_1461.getIconImageUrl();
   }

   public String getParticipantId() {
      return this.field_1463;
   }

   public Player getPlayer() {
      return this.field_1461;
   }

   public ParticipantResult getResult() {
      return this.field_1466;
   }

   public int getStatus() {
      return this.field_1464;
   }

   public int getVersionCode() {
      return this.field_1467;
   }

   public int hashCode() {
      return method_2202(this);
   }

   public boolean isConnectedToRoom() {
      return this.field_1465;
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_2205(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.fm()) {
         ParticipantEntityCreator.method_2860(this, var1, var2);
      } else {
         var1.writeString(this.field_1463);
         var1.writeString(this.field_1456);
         String var3;
         if(this.field_1458 == null) {
            var3 = null;
         } else {
            var3 = this.field_1458.toString();
         }

         var1.writeString(var3);
         Uri var4 = this.field_1459;
         String var5 = null;
         if(var4 != null) {
            var5 = this.field_1459.toString();
         }

         var1.writeString(var5);
         var1.writeInt(this.field_1464);
         var1.writeString(this.field_1462);
         byte var6;
         if(this.field_1465) {
            var6 = 1;
         } else {
            var6 = 0;
         }

         var1.writeInt(var6);
         PlayerEntity var7 = this.field_1461;
         byte var8 = 0;
         if(var7 != null) {
            var8 = 1;
         }

         var1.writeInt(var8);
         if(this.field_1461 != null) {
            this.field_1461.writeToParcel(var1, var2);
            return;
         }
      }

   }

   static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
      // $FF: renamed from: bm (android.os.Parcel) com.google.android.gms.games.multiplayer.ParticipantEntity
      public ParticipantEntity method_2861(Parcel var1) {
         boolean var2 = true;
         if(!ParticipantEntity.c(ParticipantEntity.fl()) && !ParticipantEntity.aA(ParticipantEntity.class.getCanonicalName())) {
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
            return super.method_2861(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_2861(var1);
      }
   }
}
