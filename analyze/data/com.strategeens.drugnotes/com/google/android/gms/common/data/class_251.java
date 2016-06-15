package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.common.data.d
public abstract class class_251 {
   // $FF: renamed from: JG com.google.android.gms.common.data.DataHolder
   protected final DataHolder field_525;
   // $FF: renamed from: KZ int
   protected int field_526;
   // $FF: renamed from: La int
   private int field_527;

   public class_251(DataHolder var1, int var2) {
      this.field_525 = (DataHolder)class_335.method_2311(var1);
      this.method_1658(var2);
   }

   // $FF: renamed from: a (java.lang.String, android.database.CharArrayBuffer) void
   protected void method_1654(String var1, CharArrayBuffer var2) {
      this.field_525.method_5827(var1, this.field_526, this.field_527, var2);
   }

   // $FF: renamed from: aQ (java.lang.String) boolean
   public boolean method_1655(String var1) {
      return this.field_525.method_5828(var1);
   }

   // $FF: renamed from: aR (java.lang.String) android.net.Uri
   protected Uri method_1656(String var1) {
      return this.field_525.method_5836(var1, this.field_526, this.field_527);
   }

   // $FF: renamed from: aS (java.lang.String) boolean
   protected boolean method_1657(String var1) {
      return this.field_525.method_5841(var1, this.field_526, this.field_527);
   }

   // $FF: renamed from: as (int) void
   protected void method_1658(int var1) {
      boolean var2;
      if(var1 >= 0 && var1 < this.field_525.getCount()) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_335.method_2300(var2);
      this.field_526 = var1;
      this.field_527 = this.field_525.method_5829(this.field_526);
   }

   public boolean equals(Object var1) {
      boolean var2 = var1 instanceof class_251;
      boolean var3 = false;
      if(var2) {
         class_251 var4 = (class_251)var1;
         boolean var5 = class_336.equal(Integer.valueOf(var4.field_526), Integer.valueOf(this.field_526));
         var3 = false;
         if(var5) {
            boolean var6 = class_336.equal(Integer.valueOf(var4.field_527), Integer.valueOf(this.field_527));
            var3 = false;
            if(var6) {
               DataHolder var7 = var4.field_525;
               DataHolder var8 = this.field_525;
               var3 = false;
               if(var7 == var8) {
                  var3 = true;
               }
            }
         }
      }

      return var3;
   }

   // $FF: renamed from: gW () int
   protected int method_1659() {
      return this.field_526;
   }

   protected boolean getBoolean(String var1) {
      return this.field_525.method_5832(var1, this.field_526, this.field_527);
   }

   protected byte[] getByteArray(String var1) {
      return this.field_525.method_5835(var1, this.field_526, this.field_527);
   }

   protected float getFloat(String var1) {
      return this.field_525.method_5833(var1, this.field_526, this.field_527);
   }

   protected int getInteger(String var1) {
      return this.field_525.method_5830(var1, this.field_526, this.field_527);
   }

   protected long getLong(String var1) {
      return this.field_525.method_5826(var1, this.field_526, this.field_527);
   }

   protected String getString(String var1) {
      return this.field_525.method_5831(var1, this.field_526, this.field_527);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_526), Integer.valueOf(this.field_527), this.field_525};
      return class_336.hashCode(var1);
   }

   public boolean isDataValid() {
      return !this.field_525.isClosed();
   }
}
