package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntityCreator;
import com.google.android.gms.internal.class_349;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
   public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntity.GameBadgeEntityCreatorCompat();
   // $FF: renamed from: AQ int
   private int field_1429;
   // $FF: renamed from: HV java.lang.String
   private String field_1430;
   // $FF: renamed from: Mm java.lang.String
   private String field_1431;
   // $FF: renamed from: Mo android.net.Uri
   private Uri field_1432;
   // $FF: renamed from: xJ int
   private final int field_1433;

   GameBadgeEntity(int var1, int var2, String var3, String var4, Uri var5) {
      this.field_1433 = var1;
      this.field_1429 = var2;
      this.field_1430 = var3;
      this.field_1431 = var4;
      this.field_1432 = var5;
   }

   public GameBadgeEntity(GameBadge var1) {
      this.field_1433 = 1;
      this.field_1429 = var1.getType();
      this.field_1430 = var1.getTitle();
      this.field_1431 = var1.getDescription();
      this.field_1432 = var1.getIconImageUri();
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.game.GameBadge) int
   static int method_2181(GameBadge var0) {
      Object[] var1 = new Object[]{Integer.valueOf(var0.getType()), var0.getTitle(), var0.getDescription(), var0.getIconImageUri()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.game.GameBadge, java.lang.Object) boolean
   static boolean method_2182(GameBadge var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof GameBadge)) {
         var2 = false;
      } else if(var0 != var1) {
         GameBadge var3 = (GameBadge)var1;
         if(!class_349.equal(Integer.valueOf(var3.getType()), var0.getTitle()) || !class_349.equal(var3.getDescription(), var0.getIconImageUri())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.internal.game.GameBadge) java.lang.String
   static String method_2184(GameBadge var0) {
      return class_349.method_2174(var0).method_4301("Type", Integer.valueOf(var0.getType())).method_4301("Title", var0.getTitle()).method_4301("Description", var0.getDescription()).method_4301("IconImageUri", var0.getIconImageUri()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2182(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_2187();
   }

   public String getDescription() {
      return this.field_1431;
   }

   public Uri getIconImageUri() {
      return this.field_1432;
   }

   public String getTitle() {
      return this.field_1430;
   }

   public int getType() {
      return this.field_1429;
   }

   public int getVersionCode() {
      return this.field_1433;
   }

   // $FF: renamed from: hX () com.google.android.gms.games.internal.game.GameBadge
   public GameBadge method_2187() {
      return this;
   }

   public int hashCode() {
      return method_2181(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_2184(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.fm()) {
         GameBadgeEntityCreator.method_4272(this, var1, var2);
      } else {
         var1.writeInt(this.field_1429);
         var1.writeString(this.field_1430);
         var1.writeString(this.field_1431);
         String var3;
         if(this.field_1432 == null) {
            var3 = null;
         } else {
            var3 = this.field_1432.toString();
         }

         var1.writeString(var3);
      }
   }

   static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
      // $FF: renamed from: bh (android.os.Parcel) com.google.android.gms.games.internal.game.GameBadgeEntity
      public GameBadgeEntity method_4273(Parcel var1) {
         if(!GameBadgeEntity.c(GameBadgeEntity.fl()) && !GameBadgeEntity.aA(GameBadgeEntity.class.getCanonicalName())) {
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
            return super.method_4273(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_4273(var1);
      }
   }
}
