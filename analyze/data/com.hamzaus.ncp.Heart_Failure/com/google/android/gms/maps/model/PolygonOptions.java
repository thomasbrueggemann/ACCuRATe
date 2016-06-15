package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptionsCreator;
import com.google.android.gms.maps.model.class_683;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
   public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
   private final List<LatLng> aaU;
   private final List<List<LatLng>> aaV;
   private boolean aaW = false;
   private float aar = 10.0F;
   private int aas = -16777216;
   private int aat = 0;
   private float aau = 0.0F;
   private boolean aav = true;
   // $FF: renamed from: xJ int
   private final int field_3500;

   public PolygonOptions() {
      this.field_3500 = 1;
      this.aaU = new ArrayList();
      this.aaV = new ArrayList();
   }

   PolygonOptions(int var1, List<LatLng> var2, List var3, float var4, int var5, int var6, float var7, boolean var8, boolean var9) {
      this.field_3500 = var1;
      this.aaU = var2;
      this.aaV = var3;
      this.aar = var4;
      this.aas = var5;
      this.aat = var6;
      this.aau = var7;
      this.aav = var8;
      this.aaW = var9;
   }

   public PolygonOptions add(LatLng var1) {
      this.aaU.add(var1);
      return this;
   }

   public PolygonOptions add(LatLng... var1) {
      this.aaU.addAll(Arrays.asList(var1));
      return this;
   }

   public PolygonOptions addAll(Iterable<LatLng> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         LatLng var3 = (LatLng)var2.next();
         this.aaU.add(var3);
      }

      return this;
   }

   public PolygonOptions addHole(Iterable<LatLng> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.add((LatLng)var3.next());
      }

      this.aaV.add(var2);
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public PolygonOptions fillColor(int var1) {
      this.aat = var1;
      return this;
   }

   public PolygonOptions geodesic(boolean var1) {
      this.aaW = var1;
      return this;
   }

   public int getFillColor() {
      return this.aat;
   }

   public List<List<LatLng>> getHoles() {
      return this.aaV;
   }

   public List<LatLng> getPoints() {
      return this.aaU;
   }

   public int getStrokeColor() {
      return this.aas;
   }

   public float getStrokeWidth() {
      return this.aar;
   }

   int getVersionCode() {
      return this.field_3500;
   }

   public float getZIndex() {
      return this.aau;
   }

   public boolean isGeodesic() {
      return this.aaW;
   }

   public boolean isVisible() {
      return this.aav;
   }

   // $FF: renamed from: jK () java.util.List
   List method_3851() {
      return this.aaV;
   }

   public PolygonOptions strokeColor(int var1) {
      this.aas = var1;
      return this;
   }

   public PolygonOptions strokeWidth(float var1) {
      this.aar = var1;
      return this;
   }

   public PolygonOptions visible(boolean var1) {
      this.aav = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_683.method_3999(this, var1, var2);
      } else {
         PolygonOptionsCreator.method_4300(this, var1, var2);
      }
   }

   public PolygonOptions zIndex(float var1) {
      this.aau = var1;
      return this;
   }
}
