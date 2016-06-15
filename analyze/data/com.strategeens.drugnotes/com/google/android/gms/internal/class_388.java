package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.class_392;
import com.google.android.gms.internal.hj;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.hp
public class class_388 implements SafeParcelable {
   public static final class_389 CREATOR = new class_389();
   // $FF: renamed from: CK int
   final int field_1210;
   // $FF: renamed from: Dh java.lang.String
   public final String field_1211;
   // $FF: renamed from: Di boolean
   public final boolean field_1212;
   // $FF: renamed from: Dj boolean
   public final boolean field_1213;
   // $FF: renamed from: Dk java.lang.String
   public final String field_1214;
   // $FF: renamed from: Dl com.google.android.gms.internal.hj[]
   public final class_392[] field_1215;
   // $FF: renamed from: Dm int[]
   final int[] field_1216;
   // $FF: renamed from: Dn java.lang.String
   public final String field_1217;
   public final String name;
   public final int weight;

   class_388(int var1, String var2, String var3, boolean var4, int var5, boolean var6, String var7, class_392[] var8, int[] var9, String var10) {
      this.field_1210 = var1;
      this.name = var2;
      this.field_1211 = var3;
      this.field_1212 = var4;
      this.weight = var5;
      this.field_1213 = var6;
      this.field_1214 = var7;
      this.field_1215 = var8;
      this.field_1216 = var9;
      this.field_1217 = var10;
   }

   class_388(String var1, String var2, boolean var3, int var4, boolean var5, String var6, class_392[] var7, int[] var8, String var9) {
      this(2, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public int describeContents() {
      class_389 var10000 = CREATOR;
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
            boolean var6 = this.field_1211.equals(var4.field_1211);
            var3 = false;
            if(var6) {
               boolean var7 = this.field_1212;
               boolean var8 = var4.field_1212;
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
      class_389 var10000 = CREATOR;
      class_389.method_2667(this, var1, var2);
   }

   public static final class class_1553 {
      // $FF: renamed from: Do java.lang.String
      private String field_3157;
      // $FF: renamed from: Dp boolean
      private boolean field_3158;
      // $FF: renamed from: Dq int
      private int field_3159;
      // $FF: renamed from: Dr boolean
      private boolean field_3160;
      // $FF: renamed from: Ds java.lang.String
      private String field_3161;
      // $FF: renamed from: Dt java.util.List
      private final List<hj> field_3162;
      // $FF: renamed from: Du java.util.BitSet
      private BitSet field_3163;
      // $FF: renamed from: Dv java.lang.String
      private String field_3164;
      private final String mName;

      public class_1553(String var1) {
         this.mName = var1;
         this.field_3159 = 1;
         this.field_3162 = new ArrayList();
      }

      // $FF: renamed from: G (boolean) com.google.android.gms.internal.hp$a
      public class_388.class_1553 method_4110(boolean var1) {
         this.field_3158 = var1;
         return this;
      }

      // $FF: renamed from: H (boolean) com.google.android.gms.internal.hp$a
      public class_388.class_1553 method_4111(boolean var1) {
         this.field_3160 = var1;
         return this;
      }

      // $FF: renamed from: Q (int) com.google.android.gms.internal.hp$a
      public class_388.class_1553 method_4112(int var1) {
         if(this.field_3163 == null) {
            this.field_3163 = new BitSet();
         }

         this.field_3163.set(var1);
         return this;
      }

      // $FF: renamed from: at (java.lang.String) com.google.android.gms.internal.hp$a
      public class_388.class_1553 method_4113(String var1) {
         this.field_3157 = var1;
         return this;
      }

      // $FF: renamed from: au (java.lang.String) com.google.android.gms.internal.hp$a
      public class_388.class_1553 method_4114(String var1) {
         this.field_3164 = var1;
         return this;
      }

      // $FF: renamed from: fG () com.google.android.gms.internal.hp
      public class_388 method_4115() {
         int var1 = 0;
         BitSet var2 = this.field_3163;
         int[] var3 = null;
         if(var2 != null) {
            var3 = new int[this.field_3163.cardinality()];

            int var5;
            for(int var4 = this.field_3163.nextSetBit(0); var4 >= 0; var1 = var5) {
               var5 = var1 + 1;
               var3[var1] = var4;
               var4 = this.field_3163.nextSetBit(var4 + 1);
            }
         }

         return new class_388(this.mName, this.field_3157, this.field_3158, this.field_3159, this.field_3160, this.field_3161, (class_392[])this.field_3162.toArray(new class_392[this.field_3162.size()]), var3, this.field_3164);
      }
   }
}
