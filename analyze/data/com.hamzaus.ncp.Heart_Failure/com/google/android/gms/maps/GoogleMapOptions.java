package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.class_443;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.GoogleMapOptionsCreator;
import com.google.android.gms.maps.class_751;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.internal.class_593;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
   public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();
   // $FF: renamed from: Zp java.lang.Boolean
   private Boolean field_734;
   // $FF: renamed from: Zq java.lang.Boolean
   private Boolean field_735;
   // $FF: renamed from: Zr int
   private int field_736 = -1;
   // $FF: renamed from: Zs com.google.android.gms.maps.model.CameraPosition
   private CameraPosition field_737;
   // $FF: renamed from: Zt java.lang.Boolean
   private Boolean field_738;
   // $FF: renamed from: Zu java.lang.Boolean
   private Boolean field_739;
   // $FF: renamed from: Zv java.lang.Boolean
   private Boolean field_740;
   // $FF: renamed from: Zw java.lang.Boolean
   private Boolean field_741;
   // $FF: renamed from: Zx java.lang.Boolean
   private Boolean field_742;
   // $FF: renamed from: Zy java.lang.Boolean
   private Boolean field_743;
   // $FF: renamed from: xJ int
   private final int field_744;

   public GoogleMapOptions() {
      this.field_744 = 1;
   }

   GoogleMapOptions(int var1, byte var2, byte var3, int var4, CameraPosition var5, byte var6, byte var7, byte var8, byte var9, byte var10, byte var11) {
      this.field_744 = var1;
      this.field_734 = class_593.method_3333(var2);
      this.field_735 = class_593.method_3333(var3);
      this.field_736 = var4;
      this.field_737 = var5;
      this.field_738 = class_593.method_3333(var6);
      this.field_739 = class_593.method_3333(var7);
      this.field_740 = class_593.method_3333(var8);
      this.field_741 = class_593.method_3333(var9);
      this.field_742 = class_593.method_3333(var10);
      this.field_743 = class_593.method_3333(var11);
   }

   public static GoogleMapOptions createFromAttributes(Context var0, AttributeSet var1) {
      if(var1 == null) {
         return null;
      } else {
         TypedArray var2 = var0.getResources().obtainAttributes(var1, class_443.styleable.MapAttrs);
         GoogleMapOptions var3 = new GoogleMapOptions();
         if(var2.hasValue(0)) {
            var3.mapType(var2.getInt(0, -1));
         }

         if(var2.hasValue(13)) {
            var3.zOrderOnTop(var2.getBoolean(13, false));
         }

         if(var2.hasValue(12)) {
            var3.useViewLifecycleInFragment(var2.getBoolean(12, false));
         }

         if(var2.hasValue(6)) {
            var3.compassEnabled(var2.getBoolean(6, true));
         }

         if(var2.hasValue(7)) {
            var3.rotateGesturesEnabled(var2.getBoolean(7, true));
         }

         if(var2.hasValue(8)) {
            var3.scrollGesturesEnabled(var2.getBoolean(8, true));
         }

         if(var2.hasValue(9)) {
            var3.tiltGesturesEnabled(var2.getBoolean(9, true));
         }

         if(var2.hasValue(11)) {
            var3.zoomGesturesEnabled(var2.getBoolean(11, true));
         }

         if(var2.hasValue(10)) {
            var3.zoomControlsEnabled(var2.getBoolean(10, true));
         }

         var3.camera(CameraPosition.createFromAttributes(var0, var1));
         var2.recycle();
         return var3;
      }
   }

   public GoogleMapOptions camera(CameraPosition var1) {
      this.field_737 = var1;
      return this;
   }

   public GoogleMapOptions compassEnabled(boolean var1) {
      this.field_739 = Boolean.valueOf(var1);
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public CameraPosition getCamera() {
      return this.field_737;
   }

   public Boolean getCompassEnabled() {
      return this.field_739;
   }

   public int getMapType() {
      return this.field_736;
   }

   public Boolean getRotateGesturesEnabled() {
      return this.field_743;
   }

   public Boolean getScrollGesturesEnabled() {
      return this.field_740;
   }

   public Boolean getTiltGesturesEnabled() {
      return this.field_742;
   }

   public Boolean getUseViewLifecycleInFragment() {
      return this.field_735;
   }

   int getVersionCode() {
      return this.field_744;
   }

   public Boolean getZOrderOnTop() {
      return this.field_734;
   }

   public Boolean getZoomControlsEnabled() {
      return this.field_738;
   }

   public Boolean getZoomGesturesEnabled() {
      return this.field_741;
   }

   // $FF: renamed from: jl () byte
   byte method_1428() {
      return class_593.method_3334(this.field_734);
   }

   // $FF: renamed from: jm () byte
   byte method_1429() {
      return class_593.method_3334(this.field_735);
   }

   // $FF: renamed from: jn () byte
   byte method_1430() {
      return class_593.method_3334(this.field_738);
   }

   // $FF: renamed from: jo () byte
   byte method_1431() {
      return class_593.method_3334(this.field_739);
   }

   // $FF: renamed from: jp () byte
   byte method_1432() {
      return class_593.method_3334(this.field_740);
   }

   // $FF: renamed from: jq () byte
   byte method_1433() {
      return class_593.method_3334(this.field_741);
   }

   // $FF: renamed from: jr () byte
   byte method_1434() {
      return class_593.method_3334(this.field_742);
   }

   // $FF: renamed from: js () byte
   byte method_1435() {
      return class_593.method_3334(this.field_743);
   }

   public GoogleMapOptions mapType(int var1) {
      this.field_736 = var1;
      return this;
   }

   public GoogleMapOptions rotateGesturesEnabled(boolean var1) {
      this.field_743 = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions scrollGesturesEnabled(boolean var1) {
      this.field_740 = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions tiltGesturesEnabled(boolean var1) {
      this.field_742 = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions useViewLifecycleInFragment(boolean var1) {
      this.field_735 = Boolean.valueOf(var1);
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_751.method_4292(this, var1, var2);
      } else {
         GoogleMapOptionsCreator.method_4210(this, var1, var2);
      }
   }

   public GoogleMapOptions zOrderOnTop(boolean var1) {
      this.field_734 = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions zoomControlsEnabled(boolean var1) {
      this.field_738 = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions zoomGesturesEnabled(boolean var1) {
      this.field_741 = Boolean.valueOf(var1);
      return this;
   }
}
