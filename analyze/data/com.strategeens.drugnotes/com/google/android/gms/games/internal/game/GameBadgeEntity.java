package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntityCreator;
import com.google.android.gms.internal.class_336;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
   public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntity.GameBadgeEntityCreatorCompat();
   // $FF: renamed from: CK int
   private final int field_977;
   // $FF: renamed from: Gt int
   private int field_978;
   // $FF: renamed from: OH java.lang.String
   private String field_979;
   // $FF: renamed from: UO java.lang.String
   private String field_980;
   // $FF: renamed from: WD android.net.Uri
   private Uri field_981;

   GameBadgeEntity(int var1, int var2, String var3, String var4, Uri var5) {
      this.field_977 = var1;
      this.field_978 = var2;
      this.field_979 = var3;
      this.field_980 = var4;
      this.field_981 = var5;
   }

   public GameBadgeEntity(GameBadge var1) {
      this.field_977 = 1;
      this.field_978 = var1.getType();
      this.field_979 = var1.getTitle();
      this.field_980 = var1.getDescription();
      this.field_981 = var1.getIconImageUri();
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.game.GameBadge) int
   static int method_2369(GameBadge var0) {
      Object[] var1 = new Object[]{Integer.valueOf(var0.getType()), var0.getTitle(), var0.getDescription(), var0.getIconImageUri()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.game.GameBadge, java.lang.Object) boolean
   static boolean method_2370(GameBadge var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof GameBadge)) {
         var2 = false;
      } else if(var0 != var1) {
         GameBadge var3 = (GameBadge)var1;
         if(!class_336.equal(Integer.valueOf(var3.getType()), var0.getTitle()) || !class_336.equal(var3.getDescription(), var0.getIconImageUri())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.internal.game.GameBadge) java.lang.String
   static String method_2371(GameBadge var0) {
      return class_336.method_2312(var0).method_3424("Type", Integer.valueOf(var0.getType())).method_3424("Title", var0.getTitle()).method_3424("Description", var0.getDescription()).method_3424("IconImageUri", var0.getIconImageUri()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2370(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_2375();
   }

   public String getDescription() {
      return this.field_980;
   }

   public Uri getIconImageUri() {
      return this.field_981;
   }

   public String getTitle() {
      return this.field_979;
   }

   public int getType() {
      return this.field_978;
   }

   public int getVersionCode() {
      return this.field_977;
   }

   public int hashCode() {
      return method_2369(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: mk () com.google.android.gms.games.internal.game.GameBadge
   public GameBadge method_2375() {
      return this;
   }

   public String toString() {
      return method_2371(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.hu()) {
         GameBadgeEntityCreator.method_5376(this, var1, var2);
      } else {
         var1.writeInt(this.field_978);
         var1.writeString(this.field_979);
         var1.writeString(this.field_980);
         String var3;
         if(this.field_981 == null) {
            var3 = null;
         } else {
            var3 = this.field_981.toString();
         }

         var1.writeString(var3);
      }
   }

   static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_5377(var1);
      }

      // $FF: renamed from: cv (android.os.Parcel) com.google.android.gms.games.internal.game.GameBadgeEntity
      public GameBadgeEntity method_5377(Parcel var1) {
         if(!GameBadgeEntity.c(GameBadgeEntity.ht()) && !GameBadgeEntity.aW(GameBadgeEntity.class.getCanonicalName())) {
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
            return super.method_5377(var1);
         }
      }
   }
}
