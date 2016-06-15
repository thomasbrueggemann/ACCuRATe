package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntityCreator;
import com.google.android.gms.internal.class_336;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
   public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
   // $FF: renamed from: CK int
   private final int field_3757;
   private final String acF;
   private final String acG;
   private final long acH;
   private final Uri acI;
   private final Uri acJ;
   private final Uri acK;

   MostRecentGameInfoEntity(int var1, String var2, String var3, long var4, Uri var6, Uri var7, Uri var8) {
      this.field_3757 = var1;
      this.acF = var2;
      this.acG = var3;
      this.acH = var4;
      this.acI = var6;
      this.acJ = var7;
      this.acK = var8;
   }

   public MostRecentGameInfoEntity(MostRecentGameInfo var1) {
      this.field_3757 = 2;
      this.acF = var1.method_248();
      this.acG = var1.method_249();
      this.acH = var1.method_250();
      this.acI = var1.method_251();
      this.acJ = var1.method_246();
      this.acK = var1.method_247();
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.player.MostRecentGameInfo) int
   static int method_4909(MostRecentGameInfo var0) {
      Object[] var1 = new Object[]{var0.method_248(), var0.method_249(), Long.valueOf(var0.method_250()), var0.method_251(), var0.method_246(), var0.method_247()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.player.MostRecentGameInfo, java.lang.Object) boolean
   static boolean method_4910(MostRecentGameInfo var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof MostRecentGameInfo)) {
         var2 = false;
      } else if(var0 != var1) {
         MostRecentGameInfo var3 = (MostRecentGameInfo)var1;
         if(!class_336.equal(var3.method_248(), var0.method_248()) || !class_336.equal(var3.method_249(), var0.method_249()) || !class_336.equal(Long.valueOf(var3.method_250()), Long.valueOf(var0.method_250())) || !class_336.equal(var3.method_251(), var0.method_251()) || !class_336.equal(var3.method_246(), var0.method_246()) || !class_336.equal(var3.method_247(), var0.method_247())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.internal.player.MostRecentGameInfo) java.lang.String
   static String method_4911(MostRecentGameInfo var0) {
      return class_336.method_2312(var0).method_3424("GameId", var0.method_248()).method_3424("GameName", var0.method_249()).method_3424("ActivityTimestampMillis", Long.valueOf(var0.method_250())).method_3424("GameIconUri", var0.method_251()).method_3424("GameHiResUri", var0.method_246()).method_3424("GameFeaturedUri", var0.method_247()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_4910(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4912();
   }

   public int getVersionCode() {
      return this.field_3757;
   }

   public int hashCode() {
      return method_4909(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: mA () android.net.Uri
   public Uri method_246() {
      return this.acJ;
   }

   // $FF: renamed from: mB () android.net.Uri
   public Uri method_247() {
      return this.acK;
   }

   // $FF: renamed from: mC () com.google.android.gms.games.internal.player.MostRecentGameInfo
   public MostRecentGameInfo method_4912() {
      return this;
   }

   // $FF: renamed from: mw () java.lang.String
   public String method_248() {
      return this.acF;
   }

   // $FF: renamed from: mx () java.lang.String
   public String method_249() {
      return this.acG;
   }

   // $FF: renamed from: my () long
   public long method_250() {
      return this.acH;
   }

   // $FF: renamed from: mz () android.net.Uri
   public Uri method_251() {
      return this.acI;
   }

   public String toString() {
      return method_4911(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      MostRecentGameInfoEntityCreator.method_2671(this, var1, var2);
   }
}
