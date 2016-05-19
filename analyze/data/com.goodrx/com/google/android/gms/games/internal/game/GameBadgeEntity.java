package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntityCreator;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
   public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntity.GameBadgeEntityCreatorCompat();
   private final int mVersionCode;
   private Uri zzaCd;
   private int zzabB;
   private String zzapg;
   private String zzaxl;

   GameBadgeEntity(int var1, int var2, String var3, String var4, Uri var5) {
      this.mVersionCode = var1;
      this.zzabB = var2;
      this.zzapg = var3;
      this.zzaxl = var4;
      this.zzaCd = var5;
   }

   public GameBadgeEntity(GameBadge var1) {
      this.mVersionCode = 1;
      this.zzabB = var1.getType();
      this.zzapg = var1.getTitle();
      this.zzaxl = var1.getDescription();
      this.zzaCd = var1.getIconImageUri();
   }

   static int zza(GameBadge var0) {
      Object[] var1 = new Object[]{Integer.valueOf(var0.getType()), var0.getTitle(), var0.getDescription(), var0.getIconImageUri()};
      return zzw.hashCode(var1);
   }

   static boolean zza(GameBadge var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof GameBadge)) {
         var2 = false;
      } else if(var0 != var1) {
         GameBadge var3 = (GameBadge)var1;
         if(!zzw.equal(Integer.valueOf(var3.getType()), var0.getTitle()) || !zzw.equal(var3.getDescription(), var0.getIconImageUri())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(GameBadge var0) {
      return zzw.zzy(var0).zzg("Type", Integer.valueOf(var0.getType())).zzg("Title", var0.getTitle()).zzg("Description", var0.getDescription()).zzg("IconImageUri", var0.getIconImageUri()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzxm();
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public Uri getIconImageUri() {
      return this.zzaCd;
   }

   public String getTitle() {
      return this.zzapg;
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
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.zzqC()) {
         GameBadgeEntityCreator.zza(this, var1, var2);
      } else {
         var1.writeInt(this.zzabB);
         var1.writeString(this.zzapg);
         var1.writeString(this.zzaxl);
         String var3;
         if(this.zzaCd == null) {
            var3 = null;
         } else {
            var3 = this.zzaCd.toString();
         }

         var1.writeString(var3);
      }
   }

   public GameBadge zzxm() {
      return this;
   }

   static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzen(var1);
      }

      public GameBadgeEntity zzen(Parcel var1) {
         if(!GameBadgeEntity.zzd(GameBadgeEntity.zzqB()) && !GameBadgeEntity.zzcF(GameBadgeEntity.class.getCanonicalName())) {
            int var2 = var1.readInt();
            String var3 = var1.readString();
            String var4 = var1.readString();
            String var5 = var1.readString();
            Uri var6;
            if(var5 == null) {
               var6 = null;
            } else {
               var6 = Uri.parse(var5);
            }

            return new GameBadgeEntity(1, var2, var3, var4, var6);
         } else {
            return super.zzen(var1);
         }
      }
   }
}
