package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_891;
import com.google.android.gms.maps.model.class_896;

public final class MarkerOptions implements SafeParcelable {
   public static final class_891 CREATOR = new class_891();
   // $FF: renamed from: CK int
   private final int field_1939;
   // $FF: renamed from: OH java.lang.String
   private String field_1940;
   private boolean alY = true;
   private LatLng alt;
   private float amg = 0.5F;
   private float amh = 1.0F;
   private String amp;
   private BitmapDescriptor amq;
   private boolean amr;
   private boolean ams = false;
   private float amt = 0.0F;
   private float amu = 0.5F;
   private float amv = 0.0F;
   private float mAlpha = 1.0F;

   public MarkerOptions() {
      this.field_1939 = 1;
   }

   MarkerOptions(int var1, LatLng var2, String var3, String var4, IBinder var5, float var6, float var7, boolean var8, boolean var9, boolean var10, float var11, float var12, float var13, float var14) {
      this.field_1939 = var1;
      this.alt = var2;
      this.field_1940 = var3;
      this.amp = var4;
      BitmapDescriptor var15;
      if(var5 == null) {
         var15 = null;
      } else {
         var15 = new BitmapDescriptor(class_198.class_1672.method_5291(var5));
      }

      this.amq = var15;
      this.amg = var6;
      this.amh = var7;
      this.amr = var8;
      this.alY = var9;
      this.ams = var10;
      this.amt = var11;
      this.amu = var12;
      this.amv = var13;
      this.mAlpha = var14;
   }

   public MarkerOptions alpha(float var1) {
      this.mAlpha = var1;
      return this;
   }

   public MarkerOptions anchor(float var1, float var2) {
      this.amg = var1;
      this.amh = var2;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public MarkerOptions draggable(boolean var1) {
      this.amr = var1;
      return this;
   }

   public MarkerOptions flat(boolean var1) {
      this.ams = var1;
      return this;
   }

   public float getAlpha() {
      return this.mAlpha;
   }

   public float getAnchorU() {
      return this.amg;
   }

   public float getAnchorV() {
      return this.amh;
   }

   public BitmapDescriptor getIcon() {
      return this.amq;
   }

   public float getInfoWindowAnchorU() {
      return this.amu;
   }

   public float getInfoWindowAnchorV() {
      return this.amv;
   }

   public LatLng getPosition() {
      return this.alt;
   }

   public float getRotation() {
      return this.amt;
   }

   public String getSnippet() {
      return this.amp;
   }

   public String getTitle() {
      return this.field_1940;
   }

   int getVersionCode() {
      return this.field_1939;
   }

   public MarkerOptions icon(BitmapDescriptor var1) {
      this.amq = var1;
      return this;
   }

   public MarkerOptions infoWindowAnchor(float var1, float var2) {
      this.amu = var1;
      this.amv = var2;
      return this;
   }

   public boolean isDraggable() {
      return this.amr;
   }

   public boolean isFlat() {
      return this.ams;
   }

   public boolean isVisible() {
      return this.alY;
   }

   // $FF: renamed from: oe () android.os.IBinder
   IBinder method_3224() {
      return this.amq == null?null:this.amq.method_2288().asBinder();
   }

   public MarkerOptions position(LatLng var1) {
      this.alt = var1;
      return this;
   }

   public MarkerOptions rotation(float var1) {
      this.amt = var1;
      return this;
   }

   public MarkerOptions snippet(String var1) {
      this.amp = var1;
      return this;
   }

   public MarkerOptions title(String var1) {
      this.field_1940 = var1;
      return this;
   }

   public MarkerOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_896.method_5018(this, var1, var2);
      } else {
         class_891.method_5007(this, var1, var2);
      }
   }
}
