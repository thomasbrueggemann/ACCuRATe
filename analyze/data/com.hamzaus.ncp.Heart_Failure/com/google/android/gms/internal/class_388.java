package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_387;
import com.google.android.gms.internal.class_391;
import com.google.android.gms.internal.fn;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.fq
public class class_388 implements SafeParcelable {
   public static final class_387 CREATOR = new class_387();
   public final String name;
   public final int weight;
   // $FF: renamed from: xJ int
   final int field_1747;
   // $FF: renamed from: xY java.lang.String
   public final String field_1748;
   // $FF: renamed from: xZ boolean
   public final boolean field_1749;
   // $FF: renamed from: ya boolean
   public final boolean field_1750;
   // $FF: renamed from: yb java.lang.String
   public final String field_1751;
   // $FF: renamed from: yc com.google.android.gms.internal.fn[]
   public final class_391[] field_1752;
   // $FF: renamed from: yd int[]
   final int[] field_1753;
   // $FF: renamed from: ye java.lang.String
   public final String field_1754;

   class_388(int var1, String var2, String var3, boolean var4, int var5, boolean var6, String var7, class_391[] var8, int[] var9, String var10) {
      this.field_1747 = var1;
      this.name = var2;
      this.field_1748 = var3;
      this.field_1749 = var4;
      this.weight = var5;
      this.field_1750 = var6;
      this.field_1751 = var7;
      this.field_1752 = var8;
      this.field_1753 = var9;
      this.field_1754 = var10;
   }

   class_388(String var1, String var2, boolean var3, int var4, boolean var5, String var6, class_391[] var7, int[] var8, String var9) {
      this(2, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public int describeContents() {
      class_387 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = var1 instanceof class_388;
      boolean var3 = false;
      if(var2) {
         class_388 var4 = (class_388)var1;
         boolean var5 = this.name.equals(var4.name);
         var3 = false;
         if(var5) {
            boolean var6 = this.field_1748.equals(var4.field_1748);
            var3 = false;
            if(var6) {
               boolean var7 = this.field_1749;
               boolean var8 = var4.field_1749;
               var3 = false;
               if(var7 == var8) {
                  var3 = true;
               }
            }
         }
      }

      return var3;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_387 var10000 = CREATOR;
      class_387.method_2464(this, var1, var2);
   }

   public static final class class_1254 {
      private final String mName;
      // $FF: renamed from: yf java.lang.String
      private String field_4201;
      // $FF: renamed from: yg boolean
      private boolean field_4202;
      // $FF: renamed from: yh int
      private int field_4203;
      // $FF: renamed from: yi boolean
      private boolean field_4204;
      // $FF: renamed from: yj java.lang.String
      private String field_4205;
      // $FF: renamed from: yk java.util.List
      private final List<fn> field_4206;
      // $FF: renamed from: yl java.util.BitSet
      private BitSet field_4207;
      // $FF: renamed from: ym java.lang.String
      private String field_4208;

      public class_1254(String var1) {
         this.mName = var1;
         this.field_4203 = 1;
         this.field_4206 = new ArrayList();
      }

      // $FF: renamed from: I (int) com.google.android.gms.internal.fq$a
      public class_388.class_1254 method_4467(int var1) {
         if(this.field_4207 == null) {
            this.field_4207 = new BitSet();
         }

         this.field_4207.set(var1);
         return this;
      }

      // $FF: renamed from: Z (java.lang.String) com.google.android.gms.internal.fq$a
      public class_388.class_1254 method_4468(String var1) {
         this.field_4201 = var1;
         return this;
      }

      // $FF: renamed from: aa (java.lang.String) com.google.android.gms.internal.fq$a
      public class_388.class_1254 method_4469(String var1) {
         this.field_4208 = var1;
         return this;
      }

      // $FF: renamed from: dL () com.google.android.gms.internal.fq
      public class_388 method_4470() {
         int var1 = 0;
         BitSet var2 = this.field_4207;
         int[] var3 = null;
         if(var2 != null) {
            var3 = new int[this.field_4207.cardinality()];

            int var5;
            for(int var4 = this.field_4207.nextSetBit(0); var4 >= 0; var1 = var5) {
               var5 = var1 + 1;
               var3[var1] = var4;
               var4 = this.field_4207.nextSetBit(var4 + 1);
            }
         }

         return new class_388(this.mName, this.field_4201, this.field_4202, this.field_4203, this.field_4204, this.field_4205, (class_391[])this.field_4206.toArray(new class_391[this.field_4206.size()]), var3, this.field_4208);
      }

      // $FF: renamed from: w (boolean) com.google.android.gms.internal.fq$a
      public class_388.class_1254 method_4471(boolean var1) {
         this.field_4202 = var1;
         return this;
      }

      // $FF: renamed from: x (boolean) com.google.android.gms.internal.fq$a
      public class_388.class_1254 method_4472(boolean var1) {
         this.field_4204 = var1;
         return this;
      }
   }
}
