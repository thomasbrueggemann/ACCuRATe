package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_285;
import com.google.android.gms.internal.class_286;
import com.google.android.gms.internal.class_624;
import com.google.android.gms.internal.ko;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.kq
public final class class_287 extends class_285 implements SafeParcelable, Moment {
   public static final class_624 CREATOR = new class_624();
   private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
   private final Set<Integer> acp;
   private String adc;
   private class_286 adk;
   private class_286 adl;
   // $FF: renamed from: qU java.lang.String
   private String field_985;
   // $FF: renamed from: xD java.lang.String
   private String field_986;
   // $FF: renamed from: xJ int
   private final int field_987;

   static {
      aco.put("id", class_285.class_944.method_3210("id", 2));
      aco.put("result", class_285.class_944.method_3204("result", 4, ko.class));
      aco.put("startDate", class_285.class_944.method_3210("startDate", 5));
      aco.put("target", class_285.class_944.method_3204("target", 6, ko.class));
      aco.put("type", class_285.class_944.method_3210("type", 7));
   }

   public class_287() {
      this.field_987 = 1;
      this.acp = new HashSet();
   }

   class_287(Set<Integer> var1, int var2, String var3, ko var4, String var5, ko var6, String var7) {
      this.acp = var1;
      this.field_987 = var2;
      this.field_986 = var3;
      this.adk = var4;
      this.adc = var5;
      this.adl = var6;
      this.field_985 = var7;
   }

   public class_287(Set<Integer> var1, String var2, ko var3, String var4, ko var5, String var6) {
      this.acp = var1;
      this.field_987 = 1;
      this.field_986 = var2;
      this.adk = var3;
      this.adc = var4;
      this.adl = var5;
      this.field_985 = var6;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
   protected boolean method_1880(class_285.class_944 var1) {
      return this.acp.contains(Integer.valueOf(var1.method_3218()));
   }

   // $FF: renamed from: aF (java.lang.String) java.lang.Object
   protected Object method_1881(String var1) {
      return null;
   }

   // $FF: renamed from: aG (java.lang.String) boolean
   protected boolean method_1882(String var1) {
      return false;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
   protected Object method_1885(class_285.class_944 var1) {
      switch(var1.method_3218()) {
      case 2:
         return this.field_986;
      case 3:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
      case 4:
         return this.adk;
      case 5:
         return this.adc;
      case 6:
         return this.adl;
      case 7:
         return this.field_985;
      }
   }

   public int describeContents() {
      class_624 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_287)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         class_287 var2 = (class_287)var1;
         Iterator var3 = aco.values().iterator();

         while(var3.hasNext()) {
            class_285.class_944 var4 = (class_285.class_944)var3.next();
            if(this.method_1880(var4)) {
               if(!var2.method_1880(var4)) {
                  return false;
               }

               if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                  return false;
               }
            } else if(var2.method_1880(var4)) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: renamed from: fB () java.util.HashMap
   public HashMap<String, class_285.class_944<?, ?>> method_1886() {
      return aco;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1930();
   }

   public String getId() {
      return this.field_986;
   }

   public ItemScope getResult() {
      return this.adk;
   }

   public String getStartDate() {
      return this.adc;
   }

   public ItemScope getTarget() {
      return this.adl;
   }

   public String getType() {
      return this.field_985;
   }

   int getVersionCode() {
      return this.field_987;
   }

   public boolean hasId() {
      return this.acp.contains(Integer.valueOf(2));
   }

   public boolean hasResult() {
      return this.acp.contains(Integer.valueOf(4));
   }

   public boolean hasStartDate() {
      return this.acp.contains(Integer.valueOf(5));
   }

   public boolean hasTarget() {
      return this.acp.contains(Integer.valueOf(6));
   }

   public boolean hasType() {
      return this.acp.contains(Integer.valueOf(7));
   }

   public int hashCode() {
      Iterator var1 = aco.values().iterator();

      int var2;
      int var4;
      for(var2 = 0; var1.hasNext(); var2 = var4) {
         class_285.class_944 var3 = (class_285.class_944)var1.next();
         if(this.method_1880(var3)) {
            var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
         } else {
            var4 = var2;
         }
      }

      return var2;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: kf () java.util.Set
   Set<Integer> method_1927() {
      return this.acp;
   }

   // $FF: renamed from: kw () com.google.android.gms.internal.ko
   class_286 method_1928() {
      return this.adk;
   }

   // $FF: renamed from: kx () com.google.android.gms.internal.ko
   class_286 method_1929() {
      return this.adl;
   }

   // $FF: renamed from: ky () com.google.android.gms.internal.kq
   public class_287 method_1930() {
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_624 var10000 = CREATOR;
      class_624.method_3620(this, var1, var2);
   }
}
