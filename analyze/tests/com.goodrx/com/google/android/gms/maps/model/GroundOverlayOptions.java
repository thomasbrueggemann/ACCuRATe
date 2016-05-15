package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.zzc;

public final class GroundOverlayOptions implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   private final int mVersionCode;
   private LatLngBounds zzaRk;
   private float zzaTa;
   private float zzaTh;
   private boolean zzaTi = true;
   private BitmapDescriptor zzaTk;
   private LatLng zzaTl;
   private float zzaTm;
   private float zzaTn;
   private float zzaTo = 0.0F;
   private float zzaTp = 0.5F;
   private float zzaTq = 0.5F;
   private boolean zzaTr = false;

   public GroundOverlayOptions() {
      this.mVersionCode = 1;
   }

   GroundOverlayOptions(int var1, IBinder var2, LatLng var3, float var4, float var5, LatLngBounds var6, float var7, float var8, boolean var9, float var10, float var11, float var12, boolean var13) {
      this.mVersionCode = var1;
      this.zzaTk = new BitmapDescriptor(com.google.android.gms.dynamic.zzd.zza.zzbs(var2));
      this.zzaTl = var3;
      this.zzaTm = var4;
      this.zzaTn = var5;
      this.zzaRk = var6;
      this.zzaTa = var7;
      this.zzaTh = var8;
      this.zzaTi = var9;
      this.zzaTo = var10;
      this.zzaTp = var11;
      this.zzaTq = var12;
      this.zzaTr = var13;
   }

   public int describeContents() {
      return 0;
   }

   public float getAnchorU() {
      return this.zzaTp;
   }

   public float getAnchorV() {
      return this.zzaTq;
   }

   public float getBearing() {
      return this.zzaTa;
   }

   public LatLngBounds getBounds() {
      return this.zzaRk;
   }

   public float getHeight() {
      return this.zzaTn;
   }

   public LatLng getLocation() {
      return this.zzaTl;
   }

   public float getTransparency() {
      return this.zzaTo;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public float getWidth() {
      return this.zzaTm;
   }

   public float getZIndex() {
      return this.zzaTh;
   }

   public boolean isClickable() {
      return this.zzaTr;
   }

   public boolean isVisible() {
      return this.zzaTi;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }

   IBinder zzAj() {
      return this.zzaTk.zzzH().asBinder();
   }
}
