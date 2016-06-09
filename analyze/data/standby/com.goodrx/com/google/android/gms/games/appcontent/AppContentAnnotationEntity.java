package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntityCreator;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
   public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
   private final int mVersionCode;
   private final String zzaDA;
   private final String zzaDB;
   private final int zzaDC;
   private final int zzaDD;
   private final Bundle zzaDE;
   private final Uri zzaDz;
   private final String zzapg;
   private final String zzaxl;
   private final String zzyv;

   AppContentAnnotationEntity(int var1, String var2, Uri var3, String var4, String var5, String var6, String var7, int var8, int var9, Bundle var10) {
      this.mVersionCode = var1;
      this.zzaxl = var2;
      this.zzyv = var5;
      this.zzaDB = var7;
      this.zzaDC = var8;
      this.zzaDz = var3;
      this.zzaDD = var9;
      this.zzaDA = var6;
      this.zzaDE = var10;
      this.zzapg = var4;
   }

   public AppContentAnnotationEntity(AppContentAnnotation var1) {
      this.mVersionCode = 4;
      this.zzaxl = var1.getDescription();
      this.zzyv = var1.getId();
      this.zzaDB = var1.zzvT();
      this.zzaDC = var1.zzvU();
      this.zzaDz = var1.zzvV();
      this.zzaDD = var1.zzvX();
      this.zzaDA = var1.zzvY();
      this.zzaDE = var1.zzvW();
      this.zzapg = var1.getTitle();
   }

   static int zza(AppContentAnnotation var0) {
      Object[] var1 = new Object[]{var0.getDescription(), var0.getId(), var0.zzvT(), Integer.valueOf(var0.zzvU()), var0.zzvV(), Integer.valueOf(var0.zzvX()), var0.zzvY(), var0.zzvW(), var0.getTitle()};
      return zzw.hashCode(var1);
   }

   static boolean zza(AppContentAnnotation var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentAnnotation)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentAnnotation var3 = (AppContentAnnotation)var1;
         if(!zzw.equal(var3.getDescription(), var0.getDescription()) || !zzw.equal(var3.getId(), var0.getId()) || !zzw.equal(var3.zzvT(), var0.zzvT()) || !zzw.equal(Integer.valueOf(var3.zzvU()), Integer.valueOf(var0.zzvU())) || !zzw.equal(var3.zzvV(), var0.zzvV()) || !zzw.equal(Integer.valueOf(var3.zzvX()), Integer.valueOf(var0.zzvX())) || !zzw.equal(var3.zzvY(), var0.zzvY()) || !zzw.equal(var3.zzvW(), var0.zzvW()) || !zzw.equal(var3.getTitle(), var0.getTitle())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(AppContentAnnotation var0) {
      return zzw.zzy(var0).zzg("Description", var0.getDescription()).zzg("Id", var0.getId()).zzg("ImageDefaultId", var0.zzvT()).zzg("ImageHeight", Integer.valueOf(var0.zzvU())).zzg("ImageUri", var0.zzvV()).zzg("ImageWidth", Integer.valueOf(var0.zzvX())).zzg("LayoutSlot", var0.zzvY()).zzg("Modifiers", var0.zzvW()).zzg("Title", var0.getTitle()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzvZ();
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public String getId() {
      return this.zzyv;
   }

   public String getTitle() {
      return this.zzapg;
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
      AppContentAnnotationEntityCreator.zza(this, var1, var2);
   }

   public String zzvT() {
      return this.zzaDB;
   }

   public int zzvU() {
      return this.zzaDC;
   }

   public Uri zzvV() {
      return this.zzaDz;
   }

   public Bundle zzvW() {
      return this.zzaDE;
   }

   public int zzvX() {
      return this.zzaDD;
   }

   public String zzvY() {
      return this.zzaDA;
   }

   public AppContentAnnotation zzvZ() {
      return this;
   }
}
