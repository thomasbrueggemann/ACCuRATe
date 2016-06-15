package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_895;
import com.google.android.gms.maps.model.class_900;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
   public static final class_895 CREATOR = new class_895();
   // $FF: renamed from: CK int
   private final int field_2538;
   private float alX = 0.0F;
   private boolean alY = true;
   private float amc = 10.0F;
   private final List<LatLng> amx;
   private boolean amz = false;
   private int mColor = -16777216;

   public PolylineOptions() {
      this.field_2538 = 1;
      this.amx = new ArrayList();
   }

   PolylineOptions(int var1, List var2, float var3, int var4, float var5, boolean var6, boolean var7) {
      this.field_2538 = var1;
      this.amx = var2;
      this.amc = var3;
      this.mColor = var4;
      this.alX = var5;
      this.alY = var6;
      this.amz = var7;
   }

   public PolylineOptions add(LatLng var1) {
      this.amx.add(var1);
      return this;
   }

   public PolylineOptions add(LatLng... var1) {
      this.amx.addAll(Arrays.asList(var1));
      return this;
   }

   public PolylineOptions addAll(Iterable<LatLng> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         LatLng var3 = (LatLng)var2.next();
         this.amx.add(var3);
      }

      return this;
   }

   public PolylineOptions color(int var1) {
      this.mColor = var1;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public PolylineOptions geodesic(boolean var1) {
      this.amz = var1;
      return this;
   }

   public int getColor() {
      return this.mColor;
   }

   public List<LatLng> getPoints() {
      return this.amx;
   }

   int getVersionCode() {
      return this.field_2538;
   }

   public float getWidth() {
      return this.amc;
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

   public PolylineOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public PolylineOptions width(float var1) {
      this.amc = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_900.method_5028(this, var1, var2);
      } else {
         class_895.method_5015(this, var1, var2);
      }
   }

   public PolylineOptions zIndex(float var1) {
      this.alX = var1;
      return this;
   }
}
