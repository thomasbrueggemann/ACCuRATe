package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_753;
import com.google.android.gms.internal.oa;
import com.google.android.gms.internal.oe;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.nu
public final class class_763 implements SafeParcelable {
   public static final class_753 CREATOR = new class_753();
   // $FF: renamed from: CK int
   final int field_3424;
   final List<oa> ahn;
   private final Set<oa> aho;
   private final String ahr;
   private final boolean ahs;
   final List<oe> aht;
   final List<String> ahu;
   private final Set<oe> ahv;
   private final Set<String> ahw;

   class_763(int var1, List<oa> var2, String var3, boolean var4, List<oe> var5, List<String> var6) {
      this.field_3424 = var1;
      List var7;
      if(var2 == null) {
         var7 = Collections.emptyList();
      } else {
         var7 = Collections.unmodifiableList(var2);
      }

      this.ahn = var7;
      if(var3 == null) {
         var3 = "";
      }

      this.ahr = var3;
      this.ahs = var4;
      List var8;
      if(var5 == null) {
         var8 = Collections.emptyList();
      } else {
         var8 = Collections.unmodifiableList(var5);
      }

      this.aht = var8;
      List var9;
      if(var6 == null) {
         var9 = Collections.emptyList();
      } else {
         var9 = Collections.unmodifiableList(var6);
      }

      this.ahu = var9;
      this.aho = method_4364(this.ahn);
      this.ahv = method_4364(this.aht);
      this.ahw = method_4364(this.ahu);
   }

   // $FF: renamed from: g (java.util.List) java.util.Set
   private static <E> Set<E> method_4364(List<E> var0) {
      return var0.isEmpty()?Collections.emptySet():Collections.unmodifiableSet(new HashSet(var0));
   }

   public int describeContents() {
      class_753 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_763)) {
            return false;
         }

         class_763 var2 = (class_763)var1;
         if(!this.aho.equals(var2.aho) || this.ahs != var2.ahs || !this.ahv.equals(var2.ahv) || !this.ahw.equals(var2.ahw)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.aho, Boolean.valueOf(this.ahs), this.ahv, this.ahw};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: nu () java.lang.String
   @Deprecated
   public String method_4365() {
      return this.ahr;
   }

   // $FF: renamed from: nv () boolean
   public boolean method_4366() {
      return this.ahs;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("types", this.aho).method_3424("placeIds", this.ahw).method_3424("requireOpenNow", Boolean.valueOf(this.ahs)).method_3424("requestedUserDataTypes", this.ahv).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_753 var10000 = CREATOR;
      class_753.method_4330(this, var1, var2);
   }
}
