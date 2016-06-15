package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.class_680;
import com.google.android.gms.drive.metadata.internal.class_681;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
   public static final Creator<MetadataBundle> CREATOR = new class_680();
   // $FF: renamed from: JP android.os.Bundle
   final Bundle field_814;
   // $FF: renamed from: xJ int
   final int field_815;

   MetadataBundle(int var1, Bundle var2) {
      this.field_815 = var1;
      this.field_814 = (Bundle)class_347.method_2170(var2);
      this.field_814.setClassLoader(this.getClass().getClassLoader());
      ArrayList var3 = new ArrayList();
      Iterator var4 = this.field_814.keySet().iterator();

      while(var4.hasNext()) {
         String var7 = (String)var4.next();
         if(class_681.method_3961(var7) == null) {
            var3.add(var7);
            Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + var7);
         }
      }

      Iterator var5 = var3.iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         this.field_814.remove(var6);
      }

   }

   private MetadataBundle(Bundle var1) {
      this(1, var1);
   }

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) com.google.android.gms.drive.metadata.internal.MetadataBundle
   public static <T> MetadataBundle method_1711(MetadataField<T> var0, T var1) {
      MetadataBundle var2 = method_1713();
      var2.method_1715(var0, var1);
      return var2;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.internal.MetadataBundle) com.google.android.gms.drive.metadata.internal.MetadataBundle
   public static MetadataBundle method_1712(MetadataBundle var0) {
      return new MetadataBundle(new Bundle(var0.field_814));
   }

   // $FF: renamed from: gA () com.google.android.gms.drive.metadata.internal.MetadataBundle
   public static MetadataBundle method_1713() {
      return new MetadataBundle(new Bundle());
   }

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
   public <T> T method_1714(MetadataField<T> var1) {
      return var1.method_213(this.field_814);
   }

   // $FF: renamed from: b (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) void
   public <T> void method_1715(MetadataField<T> var1, T var2) {
      if(class_681.method_3961(var1.getName()) == null) {
         throw new IllegalArgumentException("Unregistered field: " + var1.getName());
      } else {
         var1.method_212(var2, this.field_814);
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof MetadataBundle)) {
         return false;
      } else {
         MetadataBundle var2 = (MetadataBundle)var1;
         Set var3 = this.field_814.keySet();
         if(!var3.equals(var2.field_814.keySet())) {
            return false;
         } else {
            Iterator var4 = var3.iterator();

            String var5;
            do {
               if(!var4.hasNext()) {
                  return true;
               }

               var5 = (String)var4.next();
            } while(class_349.equal(this.field_814.get(var5), var2.field_814.get(var5)));

            return false;
         }
      }
   }

   // $FF: renamed from: gB () java.util.Set
   public Set<MetadataField<?>> method_1716() {
      HashSet var1 = new HashSet();
      Iterator var2 = this.field_814.keySet().iterator();

      while(var2.hasNext()) {
         var1.add(class_681.method_3961((String)var2.next()));
      }

      return var1;
   }

   public int hashCode() {
      Iterator var1 = this.field_814.keySet().iterator();

      int var2;
      String var3;
      for(var2 = 1; var1.hasNext(); var2 = var2 * 31 + this.field_814.get(var3).hashCode()) {
         var3 = (String)var1.next();
      }

      return var2;
   }

   public String toString() {
      return "MetadataBundle [values=" + this.field_814 + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_680.method_3958(this, var1, var2);
   }
}
