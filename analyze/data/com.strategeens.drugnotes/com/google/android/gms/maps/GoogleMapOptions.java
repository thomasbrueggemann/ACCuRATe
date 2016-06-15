package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.class_482;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.class_972;
import com.google.android.gms.maps.class_974;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.internal.class_698;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
   public static final class_974 CREATOR = new class_974();
   // $FF: renamed from: CK int
   private final int field_593;
   private Boolean akF;
   private Boolean akG;
   private int akH = -1;
   private CameraPosition akI;
   private Boolean akJ;
   private Boolean akK;
   private Boolean akL;
   private Boolean akM;
   private Boolean akN;
   private Boolean akO;
   private Boolean akP;
   private Boolean akQ;

   public GoogleMapOptions() {
      this.field_593 = 1;
   }

   GoogleMapOptions(int var1, byte var2, byte var3, int var4, CameraPosition var5, byte var6, byte var7, byte var8, byte var9, byte var10, byte var11, byte var12, byte var13) {
      this.field_593 = var1;
      this.akF = class_698.method_3999(var2);
      this.akG = class_698.method_3999(var3);
      this.akH = var4;
      this.akI = var5;
      this.akJ = class_698.method_3999(var6);
      this.akK = class_698.method_3999(var7);
      this.akL = class_698.method_3999(var8);
      this.akM = class_698.method_3999(var9);
      this.akN = class_698.method_3999(var10);
      this.akO = class_698.method_3999(var11);
      this.akP = class_698.method_3999(var12);
      this.akQ = class_698.method_3999(var13);
   }

   public static GoogleMapOptions createFromAttributes(Context var0, AttributeSet var1) {
      if(var1 == null) {
         return null;
      } else {
         TypedArray var2 = var0.getResources().obtainAttributes(var1, class_482.styleable.MapAttrs);
         GoogleMapOptions var3 = new GoogleMapOptions();
         if(var2.hasValue(class_482.styleable.MapAttrs_mapType)) {
            var3.mapType(var2.getInt(class_482.styleable.MapAttrs_mapType, -1));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_zOrderOnTop)) {
            var3.zOrderOnTop(var2.getBoolean(class_482.styleable.MapAttrs_zOrderOnTop, false));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_useViewLifecycle)) {
            var3.useViewLifecycleInFragment(var2.getBoolean(class_482.styleable.MapAttrs_useViewLifecycle, false));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_uiCompass)) {
            var3.compassEnabled(var2.getBoolean(class_482.styleable.MapAttrs_uiCompass, true));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_uiRotateGestures)) {
            var3.rotateGesturesEnabled(var2.getBoolean(class_482.styleable.MapAttrs_uiRotateGestures, true));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_uiScrollGestures)) {
            var3.scrollGesturesEnabled(var2.getBoolean(class_482.styleable.MapAttrs_uiScrollGestures, true));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_uiTiltGestures)) {
            var3.tiltGesturesEnabled(var2.getBoolean(class_482.styleable.MapAttrs_uiTiltGestures, true));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_uiZoomGestures)) {
            var3.zoomGesturesEnabled(var2.getBoolean(class_482.styleable.MapAttrs_uiZoomGestures, true));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_uiZoomControls)) {
            var3.zoomControlsEnabled(var2.getBoolean(class_482.styleable.MapAttrs_uiZoomControls, true));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_liteMode)) {
            var3.liteMode(var2.getBoolean(class_482.styleable.MapAttrs_liteMode, false));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_uiMapToolbar)) {
            var3.mapToolbarEnabled(var2.getBoolean(class_482.styleable.MapAttrs_uiMapToolbar, true));
         }

         var3.camera(CameraPosition.createFromAttributes(var0, var1));
         var2.recycle();
         return var3;
      }
   }

   public GoogleMapOptions camera(CameraPosition var1) {
      this.akI = var1;
      return this;
   }

   public GoogleMapOptions compassEnabled(boolean var1) {
      this.akK = Boolean.valueOf(var1);
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public CameraPosition getCamera() {
      return this.akI;
   }

   public Boolean getCompassEnabled() {
      return this.akK;
   }

   public Boolean getLiteMode() {
      return this.akP;
   }

   public Boolean getMapToolbarEnabled() {
      return this.akQ;
   }

   public int getMapType() {
      return this.akH;
   }

   public Boolean getRotateGesturesEnabled() {
      return this.akO;
   }

   public Boolean getScrollGesturesEnabled() {
      return this.akL;
   }

   public Boolean getTiltGesturesEnabled() {
      return this.akN;
   }

   public Boolean getUseViewLifecycleInFragment() {
      return this.akG;
   }

   int getVersionCode() {
      return this.field_593;
   }

   public Boolean getZOrderOnTop() {
      return this.akF;
   }

   public Boolean getZoomControlsEnabled() {
      return this.akJ;
   }

   public Boolean getZoomGesturesEnabled() {
      return this.akM;
   }

   public GoogleMapOptions liteMode(boolean var1) {
      this.akP = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions mapToolbarEnabled(boolean var1) {
      this.akQ = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions mapType(int var1) {
      this.akH = var1;
      return this;
   }

   // $FF: renamed from: nD () byte
   byte method_1770() {
      return class_698.method_4000(this.akF);
   }

   // $FF: renamed from: nE () byte
   byte method_1771() {
      return class_698.method_4000(this.akG);
   }

   // $FF: renamed from: nF () byte
   byte method_1772() {
      return class_698.method_4000(this.akJ);
   }

   // $FF: renamed from: nG () byte
   byte method_1773() {
      return class_698.method_4000(this.akK);
   }

   // $FF: renamed from: nH () byte
   byte method_1774() {
      return class_698.method_4000(this.akL);
   }

   // $FF: renamed from: nI () byte
   byte method_1775() {
      return class_698.method_4000(this.akM);
   }

   // $FF: renamed from: nJ () byte
   byte method_1776() {
      return class_698.method_4000(this.akN);
   }

   // $FF: renamed from: nK () byte
   byte method_1777() {
      return class_698.method_4000(this.akO);
   }

   // $FF: renamed from: nL () byte
   byte method_1778() {
      return class_698.method_4000(this.akP);
   }

   // $FF: renamed from: nM () byte
   byte method_1779() {
      return class_698.method_4000(this.akQ);
   }

   public GoogleMapOptions rotateGesturesEnabled(boolean var1) {
      this.akO = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions scrollGesturesEnabled(boolean var1) {
      this.akL = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions tiltGesturesEnabled(boolean var1) {
      this.akN = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions useViewLifecycleInFragment(boolean var1) {
      this.akG = Boolean.valueOf(var1);
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_972.method_5412(this, var1, var2);
      } else {
         class_974.method_5416(this, var1, var2);
      }
   }

   public GoogleMapOptions zOrderOnTop(boolean var1) {
      this.akF = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions zoomControlsEnabled(boolean var1) {
      this.akJ = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions zoomGesturesEnabled(boolean var1) {
      this.akM = Boolean.valueOf(var1);
      return this;
   }
}
