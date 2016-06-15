package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.class_876;
import com.google.android.gms.internal.class_335;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
   public static final Creator<AppVisibleCustomProperties> CREATOR = new class_876();
   // $FF: renamed from: Rd com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
   public static final AppVisibleCustomProperties field_2602 = (new AppVisibleCustomProperties.class_1334()).method_5520();
   // $FF: renamed from: CK int
   final int field_2603;
   // $FF: renamed from: Re java.util.List
   final List<CustomProperty> field_2604;

   AppVisibleCustomProperties(int var1, Collection<CustomProperty> var2) {
      this.field_2603 = var1;
      class_335.method_2311(var2);
      this.field_2604 = new ArrayList(var2);
   }

   private AppVisibleCustomProperties(Collection<CustomProperty> var1) {
      this(1, var1);
   }

   // $FF: synthetic method
   AppVisibleCustomProperties(Collection var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: iV () java.util.Map
   public Map<CustomPropertyKey, String> method_3411() {
      HashMap var1 = new HashMap(this.field_2604.size());
      Iterator var2 = this.field_2604.iterator();

      while(var2.hasNext()) {
         CustomProperty var3 = (CustomProperty)var2.next();
         var1.put(var3.method_4353(), var3.getValue());
      }

      return Collections.unmodifiableMap(var1);
   }

   public Iterator<CustomProperty> iterator() {
      return this.field_2604.iterator();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_876.method_4940(this, var1, var2);
   }

   public static class class_1334 {
      // $FF: renamed from: Rf java.util.Map
      private final Map<CustomPropertyKey, CustomProperty> field_4278 = new HashMap();

      // $FF: renamed from: a (com.google.android.gms.drive.metadata.CustomPropertyKey, java.lang.String) com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties$a
      public AppVisibleCustomProperties.class_1334 method_5519(CustomPropertyKey var1, String var2) {
         class_335.method_2306(var1, "key");
         this.field_4278.put(var1, new CustomProperty(var1, var2));
         return this;
      }

      // $FF: renamed from: iW () com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
      public AppVisibleCustomProperties method_5520() {
         return new AppVisibleCustomProperties(this.field_4278.values());
      }
   }
}
