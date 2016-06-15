package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_302;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jv;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.jv
public class class_301 implements SafeParcelable {
   public static final Creator<jv> CREATOR = new class_302();
   // $FF: renamed from: YH com.google.android.gms.maps.model.LatLng
   private final LatLng field_1016;
   // $FF: renamed from: YI java.lang.String
   private final String field_1017;
   // $FF: renamed from: YJ java.util.List
   private final List<jt> field_1018;
   // $FF: renamed from: YK java.lang.String
   private final String field_1019;
   // $FF: renamed from: YL java.lang.String
   private final String field_1020;
   private final String mName;
   // $FF: renamed from: xJ int
   final int field_1021;

   class_301(int var1, String var2, LatLng var3, String var4, List<jt> var5, String var6, String var7) {
      this.field_1021 = var1;
      this.mName = var2;
      this.field_1016 = var3;
      this.field_1017 = var4;
      this.field_1018 = new ArrayList(var5);
      this.field_1019 = var6;
      this.field_1020 = var7;
   }

   public int describeContents() {
      return 0;
   }

   public String getAddress() {
      return this.field_1017;
   }

   public String getName() {
      return this.mName;
   }

   public String getPhoneNumber() {
      return this.field_1019;
   }

   // $FF: renamed from: jf () com.google.android.gms.maps.model.LatLng
   public LatLng method_1991() {
      return this.field_1016;
   }

   // $FF: renamed from: jg () java.util.List
   public List<jt> method_1992() {
      return this.field_1018;
   }

   // $FF: renamed from: jh () java.lang.String
   public String method_1993() {
      return this.field_1020;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_302.method_1994(this, var1, var2);
   }
}
