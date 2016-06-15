package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.class_970;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_265;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.class_877;
import com.google.android.gms.drive.metadata.internal.class_878;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_714;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
   public static final Creator<MetadataBundle> CREATOR = new class_877();
   // $FF: renamed from: CK int
   final int field_659;
   // $FF: renamed from: Ri android.os.Bundle
   final Bundle field_660;

   MetadataBundle(int var1, Bundle var2) {
      this.field_659 = var1;
      this.field_660 = (Bundle)class_335.method_2311(var2);
      this.field_660.setClassLoader(this.getClass().getClassLoader());
      ArrayList var3 = new ArrayList();
      Iterator var4 = this.field_660.keySet().iterator();

      while(var4.hasNext()) {
         String var7 = (String)var4.next();
         if(class_878.method_4947(var7) == null) {
            var3.add(var7);
            class_265.method_1703("MetadataBundle", "Ignored unknown metadata field in bundle: " + var7);
         }
      }

      Iterator var5 = var3.iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         this.field_660.remove(var6);
      }

   }

   private MetadataBundle(Bundle var1) {
      this(1, var1);
   }

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) com.google.android.gms.drive.metadata.internal.MetadataBundle
   public static <T> MetadataBundle method_2079(MetadataField<T> var0, T var1) {
      MetadataBundle var2 = method_2081();
      var2.method_2083(var0, var1);
      return var2;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.internal.MetadataBundle) com.google.android.gms.drive.metadata.internal.MetadataBundle
   public static MetadataBundle method_2080(MetadataBundle var0) {
      return new MetadataBundle(new Bundle(var0.field_660));
   }

   // $FF: renamed from: iZ () com.google.android.gms.drive.metadata.internal.MetadataBundle
   public static MetadataBundle method_2081() {
      return new MetadataBundle(new Bundle());
   }

   // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
   public <T> T method_2082(MetadataField<T> var1) {
      return var1.method_224(this.field_660);
   }

   // $FF: renamed from: b (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) void
   public <T> void method_2083(MetadataField<T> var1, T var2) {
      if(class_878.method_4947(var1.getName()) == null) {
         throw new IllegalArgumentException("Unregistered field: " + var1.getName());
      } else {
         var1.method_223(var2, this.field_660);
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
         Set var3 = this.field_660.keySet();
         if(!var3.equals(var2.field_660.keySet())) {
            return false;
         } else {
            Iterator var4 = var3.iterator();

            String var5;
            do {
               if(!var4.hasNext()) {
                  return true;
               }

               var5 = (String)var4.next();
            } while(class_336.equal(this.field_660.get(var5), var2.field_660.get(var5)));

            return false;
         }
      }
   }

   public int hashCode() {
      Iterator var1 = this.field_660.keySet().iterator();

      int var2;
      String var3;
      for(var2 = 1; var1.hasNext(); var2 = var2 * 31 + this.field_660.get(var3).hashCode()) {
         var3 = (String)var1.next();
      }

      return var2;
   }

   // $FF: renamed from: ja () java.util.Set
   public Set<MetadataField<?>> method_2084() {
      HashSet var1 = new HashSet();
      Iterator var2 = this.field_660.keySet().iterator();

      while(var2.hasNext()) {
         var1.add(class_878.method_4947((String)var2.next()));
      }

      return var1;
   }

   public void setContext(Context var1) {
      class_970 var2 = (class_970)this.method_2082(class_714.field_3304);
      if(var2 != null) {
         var2.method_5399(var1.getCacheDir());
      }

   }

   public String toString() {
      return "MetadataBundle [values=" + this.field_660 + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_877.method_4943(this, var1, var2);
   }
}
