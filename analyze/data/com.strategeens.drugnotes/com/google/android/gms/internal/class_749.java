package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_748;
import com.google.android.gms.internal.oa;
import com.google.android.gms.internal.oc;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.oc
public class class_749 implements SafeParcelable {
   public static final Creator<oc> CREATOR = new class_748();
   // $FF: renamed from: CK int
   final int field_3410;
   // $FF: renamed from: TW java.lang.String
   private final String field_3411;
   private final LatLng ajX;
   private final List<oa> ajY;
   private final String ajZ;
   private final String aka;
   private final String mName;

   class_749(int var1, String var2, LatLng var3, String var4, List<oa> var5, String var6, String var7) {
      this.field_3410 = var1;
      this.mName = var2;
      this.ajX = var3;
      this.field_3411 = var4;
      this.ajY = new ArrayList(var5);
      this.ajZ = var6;
      this.aka = var7;
   }

   public int describeContents() {
      return 0;
   }

   public String getAddress() {
      return this.field_3411;
   }

   public String getName() {
      return this.mName;
   }

   public String getPhoneNumber() {
      return this.ajZ;
   }

   // $FF: renamed from: nx () com.google.android.gms.maps.model.LatLng
   public LatLng method_4322() {
      return this.ajX;
   }

   // $FF: renamed from: ny () java.util.List
   public List<oa> method_4323() {
      return this.ajY;
   }

   // $FF: renamed from: nz () java.lang.String
   public String method_4324() {
      return this.aka;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_748.method_4319(this, var1, var2);
   }
}
