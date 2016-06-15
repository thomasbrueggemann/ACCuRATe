package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptionsCreator;
import com.google.android.gms.maps.model.class_682;

public final class MarkerOptions implements SafeParcelable {
   public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
   // $FF: renamed from: HV java.lang.String
   private String field_2185;
   // $FF: renamed from: ZU com.google.android.gms.maps.model.LatLng
   private LatLng field_2186;
   private float aaD = 0.5F;
   private float aaE = 1.0F;
   private String aaM;
   private BitmapDescriptor aaN;
   private boolean aaO;
   private boolean aaP = false;
   private float aaQ = 0.0F;
   private float aaR = 0.5F;
   private float aaS = 0.0F;
   private boolean aav = true;
   private float mAlpha = 1.0F;
   // $FF: renamed from: xJ int
   private final int field_2187;

   public MarkerOptions() {
      this.field_2187 = 1;
   }

   MarkerOptions(int var1, LatLng var2, String var3, String var4, IBinder var5, float var6, float var7, boolean var8, boolean var9, boolean var10, float var11, float var12, float var13, float var14) {
      this.field_2187 = var1;
      this.field_2186 = var2;
      this.field_2185 = var3;
      this.aaM = var4;
      BitmapDescriptor var15;
      if(var5 == null) {
         var15 = null;
      } else {
         var15 = new BitmapDescriptor(class_157.class_1317.method_4176(var5));
      }

      this.aaN = var15;
      this.aaD = var6;
      this.aaE = var7;
      this.aaO = var8;
      this.aav = var9;
      this.aaP = var10;
      this.aaQ = var11;
      this.aaR = var12;
      this.aaS = var13;
      this.mAlpha = var14;
   }

   public MarkerOptions alpha(float var1) {
      this.mAlpha = var1;
      return this;
   }

   public MarkerOptions anchor(float var1, float var2) {
      this.aaD = var1;
      this.aaE = var2;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public MarkerOptions draggable(boolean var1) {
      this.aaO = var1;
      return this;
   }

   public MarkerOptions flat(boolean var1) {
      this.aaP = var1;
      return this;
   }

   public float getAlpha() {
      return this.mAlpha;
   }

   public float getAnchorU() {
      return this.aaD;
   }

   public float getAnchorV() {
      return this.aaE;
   }

   public BitmapDescriptor getIcon() {
      return this.aaN;
   }

   public float getInfoWindowAnchorU() {
      return this.aaR;
   }

   public float getInfoWindowAnchorV() {
      return this.aaS;
   }

   public LatLng getPosition() {
      return this.field_2186;
   }

   public float getRotation() {
      return this.aaQ;
   }

   public String getSnippet() {
      return this.aaM;
   }

   public String getTitle() {
      return this.field_2185;
   }

   int getVersionCode() {
      return this.field_2187;
   }

   public MarkerOptions icon(BitmapDescriptor var1) {
      this.aaN = var1;
      return this;
   }

   public MarkerOptions infoWindowAnchor(float var1, float var2) {
      this.aaR = var1;
      this.aaS = var2;
      return this;
   }

   public boolean isDraggable() {
      return this.aaO;
   }

   public boolean isFlat() {
      return this.aaP;
   }

   public boolean isVisible() {
      return this.aav;
   }

   // $FF: renamed from: jJ () android.os.IBinder
   IBinder method_2746() {
      return this.aaN == null?null:this.aaN.method_1958().asBinder();
   }

   public MarkerOptions position(LatLng var1) {
      this.field_2186 = var1;
      return this;
   }

   public MarkerOptions rotation(float var1) {
      this.aaQ = var1;
      return this;
   }

   public MarkerOptions snippet(String var1) {
      this.aaM = var1;
      return this;
   }

   public MarkerOptions title(String var1) {
      this.field_2185 = var1;
      return this;
   }

   public MarkerOptions visible(boolean var1) {
      this.aav = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_682.method_3980(this, var1, var2);
      } else {
         MarkerOptionsCreator.method_3641(this, var1, var2);
      }
   }
}
