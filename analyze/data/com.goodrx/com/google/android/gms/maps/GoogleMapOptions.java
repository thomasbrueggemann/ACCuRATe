package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.class_54;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.zza;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
   public static final zza CREATOR = new zza();
   private final int mVersionCode;
   private Boolean zzaRP;
   private Boolean zzaRQ;
   private int zzaRR = -1;
   private CameraPosition zzaRS;
   private Boolean zzaRT;
   private Boolean zzaRU;
   private Boolean zzaRV;
   private Boolean zzaRW;
   private Boolean zzaRX;
   private Boolean zzaRY;
   private Boolean zzaRZ;
   private Boolean zzaSa;
   private Boolean zzaSb;

   public GoogleMapOptions() {
      this.mVersionCode = 1;
   }

   GoogleMapOptions(int var1, byte var2, byte var3, int var4, CameraPosition var5, byte var6, byte var7, byte var8, byte var9, byte var10, byte var11, byte var12, byte var13, byte var14) {
      this.mVersionCode = var1;
      this.zzaRP = com.google.android.gms.maps.internal.zza.zza(var2);
      this.zzaRQ = com.google.android.gms.maps.internal.zza.zza(var3);
      this.zzaRR = var4;
      this.zzaRS = var5;
      this.zzaRT = com.google.android.gms.maps.internal.zza.zza(var6);
      this.zzaRU = com.google.android.gms.maps.internal.zza.zza(var7);
      this.zzaRV = com.google.android.gms.maps.internal.zza.zza(var8);
      this.zzaRW = com.google.android.gms.maps.internal.zza.zza(var9);
      this.zzaRX = com.google.android.gms.maps.internal.zza.zza(var10);
      this.zzaRY = com.google.android.gms.maps.internal.zza.zza(var11);
      this.zzaRZ = com.google.android.gms.maps.internal.zza.zza(var12);
      this.zzaSa = com.google.android.gms.maps.internal.zza.zza(var13);
      this.zzaSb = com.google.android.gms.maps.internal.zza.zza(var14);
   }

   public static GoogleMapOptions createFromAttributes(Context var0, AttributeSet var1) {
      if(var1 == null) {
         return null;
      } else {
         TypedArray var2 = var0.getResources().obtainAttributes(var1, class_54.styleable.MapAttrs);
         GoogleMapOptions var3 = new GoogleMapOptions();
         if(var2.hasValue(class_54.styleable.MapAttrs_mapType)) {
            var3.mapType(var2.getInt(class_54.styleable.MapAttrs_mapType, -1));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_zOrderOnTop)) {
            var3.zOrderOnTop(var2.getBoolean(class_54.styleable.MapAttrs_zOrderOnTop, false));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_useViewLifecycle)) {
            var3.useViewLifecycleInFragment(var2.getBoolean(class_54.styleable.MapAttrs_useViewLifecycle, false));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_uiCompass)) {
            var3.compassEnabled(var2.getBoolean(class_54.styleable.MapAttrs_uiCompass, true));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_uiRotateGestures)) {
            var3.rotateGesturesEnabled(var2.getBoolean(class_54.styleable.MapAttrs_uiRotateGestures, true));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_uiScrollGestures)) {
            var3.scrollGesturesEnabled(var2.getBoolean(class_54.styleable.MapAttrs_uiScrollGestures, true));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_uiTiltGestures)) {
            var3.tiltGesturesEnabled(var2.getBoolean(class_54.styleable.MapAttrs_uiTiltGestures, true));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_uiZoomGestures)) {
            var3.zoomGesturesEnabled(var2.getBoolean(class_54.styleable.MapAttrs_uiZoomGestures, true));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_uiZoomControls)) {
            var3.zoomControlsEnabled(var2.getBoolean(class_54.styleable.MapAttrs_uiZoomControls, true));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_liteMode)) {
            var3.liteMode(var2.getBoolean(class_54.styleable.MapAttrs_liteMode, false));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_uiMapToolbar)) {
            var3.mapToolbarEnabled(var2.getBoolean(class_54.styleable.MapAttrs_uiMapToolbar, true));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_ambientEnabled)) {
            var3.ambientEnabled(var2.getBoolean(class_54.styleable.MapAttrs_ambientEnabled, false));
         }

         var3.camera(CameraPosition.createFromAttributes(var0, var1));
         var2.recycle();
         return var3;
      }
   }

   public GoogleMapOptions ambientEnabled(boolean var1) {
      this.zzaSb = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions camera(CameraPosition var1) {
      this.zzaRS = var1;
      return this;
   }

   public GoogleMapOptions compassEnabled(boolean var1) {
      this.zzaRU = Boolean.valueOf(var1);
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public CameraPosition getCamera() {
      return this.zzaRS;
   }

   public int getMapType() {
      return this.zzaRR;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public GoogleMapOptions liteMode(boolean var1) {
      this.zzaRZ = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions mapToolbarEnabled(boolean var1) {
      this.zzaSa = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions mapType(int var1) {
      this.zzaRR = var1;
      return this;
   }

   public GoogleMapOptions rotateGesturesEnabled(boolean var1) {
      this.zzaRY = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions scrollGesturesEnabled(boolean var1) {
      this.zzaRV = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions tiltGesturesEnabled(boolean var1) {
      this.zzaRX = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions useViewLifecycleInFragment(boolean var1) {
      this.zzaRQ = Boolean.valueOf(var1);
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public GoogleMapOptions zOrderOnTop(boolean var1) {
      this.zzaRP = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions zoomControlsEnabled(boolean var1) {
      this.zzaRT = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions zoomGesturesEnabled(boolean var1) {
      this.zzaRW = Boolean.valueOf(var1);
      return this;
   }

   byte zzzK() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRP);
   }

   byte zzzL() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRQ);
   }

   byte zzzM() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRT);
   }

   byte zzzN() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRU);
   }

   byte zzzO() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRV);
   }

   byte zzzP() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRW);
   }

   byte zzzQ() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRX);
   }

   byte zzzR() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRY);
   }

   byte zzzS() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRZ);
   }

   byte zzzT() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaSa);
   }

   byte zzzU() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaSb);
   }
}
