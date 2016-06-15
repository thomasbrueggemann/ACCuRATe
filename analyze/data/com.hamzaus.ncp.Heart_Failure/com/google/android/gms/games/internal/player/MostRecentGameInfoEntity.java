package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntityCreator;
import com.google.android.gms.internal.class_349;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
   public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
   // $FF: renamed from: RF java.lang.String
   private final String field_3616;
   // $FF: renamed from: RG java.lang.String
   private final String field_3617;
   // $FF: renamed from: RH long
   private final long field_3618;
   // $FF: renamed from: RI android.net.Uri
   private final Uri field_3619;
   // $FF: renamed from: RJ android.net.Uri
   private final Uri field_3620;
   // $FF: renamed from: RK android.net.Uri
   private final Uri field_3621;
   // $FF: renamed from: xJ int
   private final int field_3622;

   MostRecentGameInfoEntity(int var1, String var2, String var3, long var4, Uri var6, Uri var7, Uri var8) {
      this.field_3622 = var1;
      this.field_3616 = var2;
      this.field_3617 = var3;
      this.field_3618 = var4;
      this.field_3619 = var6;
      this.field_3620 = var7;
      this.field_3621 = var8;
   }

   public MostRecentGameInfoEntity(MostRecentGameInfo var1) {
      this.field_3622 = 2;
      this.field_3616 = var1.method_220();
      this.field_3617 = var1.method_221();
      this.field_3618 = var1.method_222();
      this.field_3619 = var1.method_223();
      this.field_3620 = var1.method_224();
      this.field_3621 = var1.method_225();
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.player.MostRecentGameInfo) int
   static int method_3923(MostRecentGameInfo var0) {
      Object[] var1 = new Object[]{var0.method_220(), var0.method_221(), Long.valueOf(var0.method_222()), var0.method_223(), var0.method_224(), var0.method_225()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.player.MostRecentGameInfo, java.lang.Object) boolean
   static boolean method_3924(MostRecentGameInfo var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof MostRecentGameInfo)) {
         var2 = false;
      } else if(var0 != var1) {
         MostRecentGameInfo var3 = (MostRecentGameInfo)var1;
         if(!class_349.equal(var3.method_220(), var0.method_220()) || !class_349.equal(var3.method_221(), var0.method_221()) || !class_349.equal(Long.valueOf(var3.method_222()), Long.valueOf(var0.method_222())) || !class_349.equal(var3.method_223(), var0.method_223()) || !class_349.equal(var3.method_224(), var0.method_224()) || !class_349.equal(var3.method_225(), var0.method_225())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.internal.player.MostRecentGameInfo) java.lang.String
   static String method_3925(MostRecentGameInfo var0) {
      return class_349.method_2174(var0).method_4301("GameId", var0.method_220()).method_4301("GameName", var0.method_221()).method_4301("ActivityTimestampMillis", Long.valueOf(var0.method_222())).method_4301("GameIconUri", var0.method_223()).method_4301("GameHiResUri", var0.method_224()).method_4301("GameFeaturedUri", var0.method_225()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_3924(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_3926();
   }

   public int getVersionCode() {
      return this.field_3622;
   }

   public int hashCode() {
      return method_3923(this);
   }

   // $FF: renamed from: ik () java.lang.String
   public String method_220() {
      return this.field_3616;
   }

   // $FF: renamed from: il () java.lang.String
   public String method_221() {
      return this.field_3617;
   }

   // $FF: renamed from: im () long
   public long method_222() {
      return this.field_3618;
   }

   // $FF: renamed from: in () android.net.Uri
   public Uri method_223() {
      return this.field_3619;
   }

   // $FF: renamed from: io () android.net.Uri
   public Uri method_224() {
      return this.field_3620;
   }

   // $FF: renamed from: ip () android.net.Uri
   public Uri method_225() {
      return this.field_3621;
   }

   // $FF: renamed from: iq () com.google.android.gms.games.internal.player.MostRecentGameInfo
   public MostRecentGameInfo method_3926() {
      return this;
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_3925(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      MostRecentGameInfoEntityCreator.method_2153(this, var1, var2);
   }
}
