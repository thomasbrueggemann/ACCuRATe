package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.class_726;
import com.google.android.gms.internal.class_727;
import com.google.android.gms.internal.class_728;
import com.google.android.gms.internal.class_805;
import com.google.android.gms.internal.pd;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pf
public final class class_729 extends class_727 implements Moment {
   public static final class_805 CREATOR = new class_805();
   private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
   // $FF: renamed from: CE java.lang.String
   String field_3358;
   // $FF: renamed from: CK int
   final int field_3359;
   final Set<Integer> aon;
   String apa;
   class_728 api;
   class_728 apj;
   // $FF: renamed from: vc java.lang.String
   String field_3360;

   static {
      aom.put("id", class_726.class_1680.method_5316("id", 2));
      aom.put("result", class_726.class_1680.method_5310("result", 4, pd.class));
      aom.put("startDate", class_726.class_1680.method_5316("startDate", 5));
      aom.put("target", class_726.class_1680.method_5310("target", 6, pd.class));
      aom.put("type", class_726.class_1680.method_5316("type", 7));
   }

   public class_729() {
      this.field_3359 = 1;
      this.aon = new HashSet();
   }

   class_729(Set<Integer> var1, int var2, String var3, pd var4, String var5, pd var6, String var7) {
      this.aon = var1;
      this.field_3359 = var2;
      this.field_3358 = var3;
      this.api = var4;
      this.apa = var5;
      this.apj = var6;
      this.field_3360 = var7;
   }

   public class_729(Set<Integer> var1, String var2, pd var3, String var4, pd var5, String var6) {
      this.aon = var1;
      this.field_3359 = 1;
      this.field_3358 = var2;
      this.api = var3;
      this.apa = var4;
      this.apj = var5;
      this.field_3360 = var6;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
   protected boolean method_4224(class_726.class_1680 var1) {
      return this.aon.contains(Integer.valueOf(var1.method_5325()));
   }

   // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
   protected Object method_4225(class_726.class_1680 var1) {
      switch(var1.method_5325()) {
      case 2:
         return this.field_3358;
      case 3:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
      case 4:
         return this.api;
      case 5:
         return this.apa;
      case 6:
         return this.apj;
      case 7:
         return this.field_3360;
      }
   }

   public int describeContents() {
      class_805 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_729)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         class_729 var2 = (class_729)var1;
         Iterator var3 = aom.values().iterator();

         while(var3.hasNext()) {
            class_726.class_1680 var4 = (class_726.class_1680)var3.next();
            if(this.method_4224(var4)) {
               if(!var2.method_4224(var4)) {
                  return false;
               }

               if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                  return false;
               }
            } else if(var2.method_4224(var4)) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4244();
   }

   public String getId() {
      return this.field_3358;
   }

   public ItemScope getResult() {
      return this.api;
   }

   public String getStartDate() {
      return this.apa;
   }

   public ItemScope getTarget() {
      return this.apj;
   }

   public String getType() {
      return this.field_3360;
   }

   // $FF: renamed from: hK () java.util.HashMap
   public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
      return aom;
   }

   public boolean hasId() {
      return this.aon.contains(Integer.valueOf(2));
   }

   public boolean hasResult() {
      return this.aon.contains(Integer.valueOf(4));
   }

   public boolean hasStartDate() {
      return this.aon.contains(Integer.valueOf(5));
   }

   public boolean hasTarget() {
      return this.aon.contains(Integer.valueOf(6));
   }

   public boolean hasType() {
      return this.aon.contains(Integer.valueOf(7));
   }

   public int hashCode() {
      Iterator var1 = aom.values().iterator();

      int var2;
      int var4;
      for(var2 = 0; var1.hasNext(); var2 = var4) {
         class_726.class_1680 var3 = (class_726.class_1680)var1.next();
         if(this.method_4224(var3)) {
            var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
         } else {
            var4 = var2;
         }
      }

      return var2;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: oJ () com.google.android.gms.internal.pf
   public class_729 method_4244() {
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_805 var10000 = CREATOR;
      class_805.method_4449(this, var1, var2);
   }
}
