package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.class_748;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_347;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder implements SafeParcelable {
   public static final class_748 CREATOR = new class_748();
   // $FF: renamed from: EL com.google.android.gms.common.data.DataHolder$a
   private static final DataHolder.class_1100 field_4329 = new DataHolder.class_1100(new String[0], (String)null, null) {
   };
   // $FF: renamed from: CQ int
   private final int field_4330;
   // $FF: renamed from: ED java.lang.String[]
   private final String[] field_4331;
   // $FF: renamed from: EE android.os.Bundle
   Bundle field_4332;
   // $FF: renamed from: EF android.database.CursorWindow[]
   private final CursorWindow[] field_4333;
   // $FF: renamed from: EG android.os.Bundle
   private final Bundle field_4334;
   // $FF: renamed from: EH int[]
   int[] field_4335;
   // $FF: renamed from: EI int
   int field_4336;
   // $FF: renamed from: EJ java.lang.Object
   private Object field_4337;
   // $FF: renamed from: EK boolean
   private boolean field_4338;
   boolean mClosed;
   // $FF: renamed from: xJ int
   private final int field_4339;

   DataHolder(int var1, String[] var2, CursorWindow[] var3, int var4, Bundle var5) {
      this.mClosed = false;
      this.field_4338 = true;
      this.field_4339 = var1;
      this.field_4331 = var2;
      this.field_4333 = var3;
      this.field_4330 = var4;
      this.field_4334 = var5;
   }

   private DataHolder(DataHolder.class_1100 var1, int var2, Bundle var3) {
      this(var1.field_2677, method_4551(var1, -1), var2, var3);
   }

   public DataHolder(String[] var1, CursorWindow[] var2, int var3, Bundle var4) {
      this.mClosed = false;
      this.field_4338 = true;
      this.field_4339 = 1;
      this.field_4331 = (String[])class_347.method_2170(var1);
      this.field_4333 = (CursorWindow[])class_347.method_2170(var2);
      this.field_4330 = var3;
      this.field_4334 = var4;
      this.method_4564();
   }

   // $FF: renamed from: a (int, android.os.Bundle) com.google.android.gms.common.data.DataHolder
   public static DataHolder method_4550(int var0, Bundle var1) {
      return new DataHolder(field_4329, var0, var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder$a, int) android.database.CursorWindow[]
   private static CursorWindow[] method_4551(DataHolder.class_1100 param0, int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: af (int) com.google.android.gms.common.data.DataHolder
   public static DataHolder method_4552(int var0) {
      return method_4550(var0, (Bundle)null);
   }

   // $FF: renamed from: e (java.lang.String, int) void
   private void method_4553(String var1, int var2) {
      if(this.field_4332 != null && this.field_4332.containsKey(var1)) {
         if(this.isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
         } else if(var2 < 0 || var2 >= this.field_4336) {
            throw new CursorIndexOutOfBoundsException(var2, this.field_4336);
         }
      } else {
         throw new IllegalArgumentException("No such column: " + var1);
      }
   }

   // $FF: renamed from: a (java.lang.String, int, int) long
   public long method_4554(String var1, int var2, int var3) {
      this.method_4553(var1, var2);
      return this.field_4333[var3].getLong(var2, this.field_4332.getInt(var1));
   }

   // $FF: renamed from: a (java.lang.String, int, int, android.database.CharArrayBuffer) void
   public void method_4555(String var1, int var2, int var3, CharArrayBuffer var4) {
      this.method_4553(var1, var2);
      this.field_4333[var3].copyStringToBuffer(var2, this.field_4332.getInt(var1), var4);
   }

   // $FF: renamed from: ae (int) int
   public int method_4556(int var1) {
      int var2 = 0;
      boolean var3;
      if(var1 >= 0 && var1 < this.field_4336) {
         var3 = true;
      } else {
         var3 = false;
      }

      class_347.method_2159(var3);

      while(var2 < this.field_4335.length) {
         if(var1 < this.field_4335[var2]) {
            --var2;
            break;
         }

         ++var2;
      }

      if(var2 == this.field_4335.length) {
         --var2;
      }

      return var2;
   }

   // $FF: renamed from: av (java.lang.String) boolean
   public boolean method_4557(String var1) {
      return this.field_4332.containsKey(var1);
   }

   // $FF: renamed from: b (java.lang.String, int, int) int
   public int method_4558(String var1, int var2, int var3) {
      this.method_4553(var1, var2);
      return this.field_4333[var3].getInt(var2, this.field_4332.getInt(var1));
   }

   // $FF: renamed from: b (java.lang.Object) void
   public void method_4559(Object var1) {
      this.field_4337 = var1;
   }

   // $FF: renamed from: c (java.lang.String, int, int) java.lang.String
   public String method_4560(String var1, int var2, int var3) {
      this.method_4553(var1, var2);
      return this.field_4333[var3].getString(var2, this.field_4332.getInt(var1));
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (java.lang.String, int, int) boolean
   public boolean method_4561(String var1, int var2, int var3) {
      this.method_4553(var1, var2);
      return Long.valueOf(this.field_4333[var3].getLong(var2, this.field_4332.getInt(var1))).longValue() == 1L;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: e (java.lang.String, int, int) float
   public float method_4562(String var1, int var2, int var3) {
      this.method_4553(var1, var2);
      return this.field_4333[var3].getFloat(var2, this.field_4332.getInt(var1));
   }

   // $FF: renamed from: eP () android.os.Bundle
   public Bundle method_4563() {
      return this.field_4334;
   }

   // $FF: renamed from: eR () void
   public void method_4564() {
      int var1 = 0;
      this.field_4332 = new Bundle();

      for(int var2 = 0; var2 < this.field_4331.length; ++var2) {
         this.field_4332.putInt(this.field_4331[var2], var2);
      }

      this.field_4335 = new int[this.field_4333.length];

      int var3;
      for(var3 = 0; var1 < this.field_4333.length; ++var1) {
         this.field_4335[var1] = var3;
         int var4 = var3 - this.field_4333[var1].getStartPosition();
         var3 += this.field_4333[var1].getNumRows() - var4;
      }

      this.field_4336 = var3;
   }

   // $FF: renamed from: eS () java.lang.String[]
   String[] method_4565() {
      return this.field_4331;
   }

   // $FF: renamed from: eT () android.database.CursorWindow[]
   CursorWindow[] method_4566() {
      return this.field_4333;
   }

   // $FF: renamed from: f (java.lang.String, int, int) byte[]
   public byte[] method_4567(String var1, int var2, int var3) {
      this.method_4553(var1, var2);
      return this.field_4333[var3].getBlob(var2, this.field_4332.getInt(var1));
   }

   protected void finalize() throws Throwable {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: g (java.lang.String, int, int) android.net.Uri
   public Uri method_4568(String var1, int var2, int var3) {
      String var4 = this.method_4560(var1, var2, var3);
      return var4 == null?null:Uri.parse(var4);
   }

   public int getCount() {
      return this.field_4336;
   }

   public int getStatusCode() {
      return this.field_4330;
   }

   int getVersionCode() {
      return this.field_4339;
   }

   // $FF: renamed from: h (java.lang.String, int, int) boolean
   public boolean method_4569(String var1, int var2, int var3) {
      this.method_4553(var1, var2);
      return this.field_4333[var3].isNull(var2, this.field_4332.getInt(var1));
   }

   public boolean isClosed() {
      // $FF: Couldn't be decompiled
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_748.method_4281(this, var1, var2);
   }

   public static class class_1100 {
      // $FF: renamed from: ED java.lang.String[]
      private final String[] field_2677;
      // $FF: renamed from: EM java.util.ArrayList
      private final ArrayList<HashMap<String, Object>> field_2678;
      // $FF: renamed from: EN java.lang.String
      private final String field_2679;
      // $FF: renamed from: EO java.util.HashMap
      private final HashMap<Object, Integer> field_2680;
      // $FF: renamed from: EP boolean
      private boolean field_2681;
      // $FF: renamed from: EQ java.lang.String
      private String field_2682;

      private class_1100(String[] var1, String var2) {
         this.field_2677 = (String[])class_347.method_2170(var1);
         this.field_2678 = new ArrayList();
         this.field_2679 = var2;
         this.field_2680 = new HashMap();
         this.field_2681 = false;
         this.field_2682 = null;
      }

      // $FF: synthetic method
      class_1100(String[] var1, String var2, Object var3) {
         this(var1, var2);
      }

      // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder$a) java.util.ArrayList
      // $FF: synthetic method
      static ArrayList method_2754(DataHolder.class_1100 var0) {
         return var0.field_2678;
      }
   }
}
