package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntityCreator;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
   public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
   private final int mVersionCode;
   private final String zzaIm;
   private final String zzaIn;
   private final long zzaIo;
   private final Uri zzaIp;
   private final Uri zzaIq;
   private final Uri zzaIr;

   MostRecentGameInfoEntity(int var1, String var2, String var3, long var4, Uri var6, Uri var7, Uri var8) {
      this.mVersionCode = var1;
      this.zzaIm = var2;
      this.zzaIn = var3;
      this.zzaIo = var4;
      this.zzaIp = var6;
      this.zzaIq = var7;
      this.zzaIr = var8;
   }

   public MostRecentGameInfoEntity(MostRecentGameInfo var1) {
      this.mVersionCode = 2;
      this.zzaIm = var1.zzxy();
      this.zzaIn = var1.zzxz();
      this.zzaIo = var1.zzxA();
      this.zzaIp = var1.zzxB();
      this.zzaIq = var1.zzxC();
      this.zzaIr = var1.zzxD();
   }

   static int zza(MostRecentGameInfo var0) {
      Object[] var1 = new Object[]{var0.zzxy(), var0.zzxz(), Long.valueOf(var0.zzxA()), var0.zzxB(), var0.zzxC(), var0.zzxD()};
      return zzw.hashCode(var1);
   }

   static boolean zza(MostRecentGameInfo var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof MostRecentGameInfo)) {
         var2 = false;
      } else if(var0 != var1) {
         MostRecentGameInfo var3 = (MostRecentGameInfo)var1;
         if(!zzw.equal(var3.zzxy(), var0.zzxy()) || !zzw.equal(var3.zzxz(), var0.zzxz()) || !zzw.equal(Long.valueOf(var3.zzxA()), Long.valueOf(var0.zzxA())) || !zzw.equal(var3.zzxB(), var0.zzxB()) || !zzw.equal(var3.zzxC(), var0.zzxC()) || !zzw.equal(var3.zzxD(), var0.zzxD())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(MostRecentGameInfo var0) {
      return zzw.zzy(var0).zzg("GameId", var0.zzxy()).zzg("GameName", var0.zzxz()).zzg("ActivityTimestampMillis", Long.valueOf(var0.zzxA())).zzg("GameIconUri", var0.zzxB()).zzg("GameHiResUri", var0.zzxC()).zzg("GameFeaturedUri", var0.zzxD()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzxE();
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
      MostRecentGameInfoEntityCreator.zza(this, var1, var2);
   }

   public long zzxA() {
      return this.zzaIo;
   }

   public Uri zzxB() {
      return this.zzaIp;
   }

   public Uri zzxC() {
      return this.zzaIq;
   }

   public Uri zzxD() {
      return this.zzaIr;
   }

   public MostRecentGameInfo zzxE() {
      return this;
   }

   public String zzxy() {
      return this.zzaIm;
   }

   public String zzxz() {
      return this.zzaIn;
   }
}
