package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_349;

// $FF: renamed from: com.google.android.gms.common.data.d
public abstract class class_206 {
   // $FF: renamed from: DD com.google.android.gms.common.data.DataHolder
   protected final DataHolder field_678;
   // $FF: renamed from: EA int
   private int field_679;
   // $FF: renamed from: Ez int
   protected int field_680;

   public class_206(DataHolder var1, int var2) {
      this.field_678 = (DataHolder)class_347.method_2170(var1);
      this.method_1348(var2);
   }

   // $FF: renamed from: a (java.lang.String, android.database.CharArrayBuffer) void
   protected void method_1347(String var1, CharArrayBuffer var2) {
      this.field_678.method_4555(var1, this.field_680, this.field_679, var2);
   }

   // $FF: renamed from: ac (int) void
   protected void method_1348(int var1) {
      boolean var2;
      if(var1 >= 0 && var1 < this.field_678.getCount()) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_347.method_2159(var2);
      this.field_680 = var1;
      this.field_679 = this.field_678.method_4556(this.field_680);
   }

   // $FF: renamed from: av (java.lang.String) boolean
   public boolean method_1349(String var1) {
      return this.field_678.method_4557(var1);
   }

   // $FF: renamed from: aw (java.lang.String) android.net.Uri
   protected Uri method_1350(String var1) {
      return this.field_678.method_4568(var1, this.field_680, this.field_679);
   }

   // $FF: renamed from: ax (java.lang.String) boolean
   protected boolean method_1351(String var1) {
      return this.field_678.method_4569(var1, this.field_680, this.field_679);
   }

   // $FF: renamed from: eQ () int
   protected int method_1352() {
      return this.field_680;
   }

   public boolean equals(Object var1) {
      boolean var2 = var1 instanceof class_206;
      boolean var3 = false;
      if(var2) {
         class_206 var4 = (class_206)var1;
         boolean var5 = class_349.equal(Integer.valueOf(var4.field_680), Integer.valueOf(this.field_680));
         var3 = false;
         if(var5) {
            boolean var6 = class_349.equal(Integer.valueOf(var4.field_679), Integer.valueOf(this.field_679));
            var3 = false;
            if(var6) {
               DataHolder var7 = var4.field_678;
               DataHolder var8 = this.field_678;
               var3 = false;
               if(var7 == var8) {
                  var3 = true;
               }
            }
         }
      }

      return var3;
   }

   protected boolean getBoolean(String var1) {
      return this.field_678.method_4561(var1, this.field_680, this.field_679);
   }

   protected byte[] getByteArray(String var1) {
      return this.field_678.method_4567(var1, this.field_680, this.field_679);
   }

   protected float getFloat(String var1) {
      return this.field_678.method_4562(var1, this.field_680, this.field_679);
   }

   protected int getInteger(String var1) {
      return this.field_678.method_4558(var1, this.field_680, this.field_679);
   }

   protected long getLong(String var1) {
      return this.field_678.method_4554(var1, this.field_680, this.field_679);
   }

   protected String getString(String var1) {
      return this.field_678.method_4560(var1, this.field_680, this.field_679);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_680), Integer.valueOf(this.field_679), this.field_678};
      return class_349.hashCode(var1);
   }

   public boolean isDataValid() {
      return !this.field_678.isClosed();
   }
}
