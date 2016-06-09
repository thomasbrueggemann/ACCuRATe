package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.zzf;

public final class MarkerOptions implements SafeParcelable {
   public static final zzf CREATOR = new zzf();
   private float mAlpha = 1.0F;
   private final int mVersionCode;
   private LatLng zzaSF;
   private BitmapDescriptor zzaTA;
   private boolean zzaTB;
   private boolean zzaTC = false;
   private float zzaTD = 0.0F;
   private float zzaTE = 0.5F;
   private float zzaTF = 0.0F;
   private boolean zzaTi = true;
   private float zzaTp = 0.5F;
   private float zzaTq = 1.0F;
   private String zzaTz;
   private String zzapg;

   public MarkerOptions() {
      this.mVersionCode = 1;
   }

   MarkerOptions(int var1, LatLng var2, String var3, String var4, IBinder var5, float var6, float var7, boolean var8, boolean var9, boolean var10, float var11, float var12, float var13, float var14) {
      this.mVersionCode = var1;
      this.zzaSF = var2;
      this.zzapg = var3;
      this.zzaTz = var4;
      BitmapDescriptor var15;
      if(var5 == null) {
         var15 = null;
      } else {
         var15 = new BitmapDescriptor(com.google.android.gms.dynamic.zzd.zza.zzbs(var5));
      }

      this.zzaTA = var15;
      this.zzaTp = var6;
      this.zzaTq = var7;
      this.zzaTB = var8;
      this.zzaTi = var9;
      this.zzaTC = var10;
      this.zzaTD = var11;
      this.zzaTE = var12;
      this.zzaTF = var13;
      this.mAlpha = var14;
   }

   public int describeContents() {
      return 0;
   }

   public float getAlpha() {
      return this.mAlpha;
   }

   public float getAnchorU() {
      return this.zzaTp;
   }

   public float getAnchorV() {
      return this.zzaTq;
   }

   public float getInfoWindowAnchorU() {
      return this.zzaTE;
   }

   public float getInfoWindowAnchorV() {
      return this.zzaTF;
   }

   public LatLng getPosition() {
      return this.zzaSF;
   }

   public float getRotation() {
      return this.zzaTD;
   }

   public String getSnippet() {
      return this.zzaTz;
   }

   public String getTitle() {
      return this.zzapg;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public MarkerOptions icon(BitmapDescriptor var1) {
      this.zzaTA = var1;
      return this;
   }

   public boolean isDraggable() {
      return this.zzaTB;
   }

   public boolean isFlat() {
      return this.zzaTC;
   }

   public boolean isVisible() {
      return this.zzaTi;
   }

   public MarkerOptions position(LatLng var1) {
      this.zzaSF = var1;
      return this;
   }

   public MarkerOptions snippet(String var1) {
      this.zzaTz = var1;
      return this;
   }

   public MarkerOptions title(String var1) {
      this.zzapg = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   IBinder zzAk() {
      return this.zzaTA == null?null:this.zzaTA.zzzH().asBinder();
   }
}
