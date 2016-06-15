package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_894;
import com.google.android.gms.maps.model.class_897;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
   public static final class_897 CREATOR = new class_897();
   // $FF: renamed from: CK int
   private final int field_3620;
   private float alU = 10.0F;
   private int alV = -16777216;
   private int alW = 0;
   private float alX = 0.0F;
   private boolean alY = true;
   private final List<LatLng> amx;
   private final List<List<LatLng>> amy;
   private boolean amz = false;

   public PolygonOptions() {
      this.field_3620 = 1;
      this.amx = new ArrayList();
      this.amy = new ArrayList();
   }

   PolygonOptions(int var1, List<LatLng> var2, List var3, float var4, int var5, int var6, float var7, boolean var8, boolean var9) {
      this.field_3620 = var1;
      this.amx = var2;
      this.amy = var3;
      this.alU = var4;
      this.alV = var5;
      this.alW = var6;
      this.alX = var7;
      this.alY = var8;
      this.amz = var9;
   }

   public PolygonOptions add(LatLng var1) {
      this.amx.add(var1);
      return this;
   }

   public PolygonOptions add(LatLng... var1) {
      this.amx.addAll(Arrays.asList(var1));
      return this;
   }

   public PolygonOptions addAll(Iterable<LatLng> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         LatLng var3 = (LatLng)var2.next();
         this.amx.add(var3);
      }

      return this;
   }

   public PolygonOptions addHole(Iterable<LatLng> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.add((LatLng)var3.next());
      }

      this.amy.add(var2);
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public PolygonOptions fillColor(int var1) {
      this.alW = var1;
      return this;
   }

   public PolygonOptions geodesic(boolean var1) {
      this.amz = var1;
      return this;
   }

   public int getFillColor() {
      return this.alW;
   }

   public List<List<LatLng>> getHoles() {
      return this.amy;
   }

   public List<LatLng> getPoints() {
      return this.amx;
   }

   public int getStrokeColor() {
      return this.alV;
   }

   public float getStrokeWidth() {
      return this.alU;
   }

   int getVersionCode() {
      return this.field_3620;
   }

   public float getZIndex() {
      return this.alX;
   }

   public boolean isGeodesic() {
      return this.amz;
   }

   public boolean isVisible() {
      return this.alY;
   }

   // $FF: renamed from: of () java.util.List
   List method_4818() {
      return this.amy;
   }

   public PolygonOptions strokeColor(int var1) {
      this.alV = var1;
      return this;
   }

   public PolygonOptions strokeWidth(float var1) {
      this.alU = var1;
      return this;
   }

   public PolygonOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_894.method_5014(this, var1, var2);
      } else {
         class_897.method_5019(this, var1, var2);
      }
   }

   public PolygonOptions zIndex(float var1) {
      this.alX = var1;
      return this;
   }
}
