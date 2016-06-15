package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptionsCreator;
import com.google.android.gms.maps.model.class_688;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
   public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
   // $FF: renamed from: Dg int
   private int field_2745 = -16777216;
   private final List<LatLng> aaU;
   private boolean aaW = false;
   private float aau = 0.0F;
   private boolean aav = true;
   private float aaz = 10.0F;
   // $FF: renamed from: xJ int
   private final int field_2746;

   public PolylineOptions() {
      this.field_2746 = 1;
      this.aaU = new ArrayList();
   }

   PolylineOptions(int var1, List var2, float var3, int var4, float var5, boolean var6, boolean var7) {
      this.field_2746 = var1;
      this.aaU = var2;
      this.aaz = var3;
      this.field_2745 = var4;
      this.aau = var5;
      this.aav = var6;
      this.aaW = var7;
   }

   public PolylineOptions add(LatLng var1) {
      this.aaU.add(var1);
      return this;
   }

   public PolylineOptions add(LatLng... var1) {
      this.aaU.addAll(Arrays.asList(var1));
      return this;
   }

   public PolylineOptions addAll(Iterable<LatLng> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         LatLng var3 = (LatLng)var2.next();
         this.aaU.add(var3);
      }

      return this;
   }

   public PolylineOptions color(int var1) {
      this.field_2745 = var1;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public PolylineOptions geodesic(boolean var1) {
      this.aaW = var1;
      return this;
   }

   public int getColor() {
      return this.field_2745;
   }

   public List<LatLng> getPoints() {
      return this.aaU;
   }

   int getVersionCode() {
      return this.field_2746;
   }

   public float getWidth() {
      return this.aaz;
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

   public PolylineOptions visible(boolean var1) {
      this.aav = var1;
      return this;
   }

   public PolylineOptions width(float var1) {
      this.aaz = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_688.method_4004(this, var1, var2);
      } else {
         PolylineOptionsCreator.method_4315(this, var1, var2);
      }
   }

   public PolylineOptions zIndex(float var1) {
      this.aau = var1;
      return this;
   }
}
