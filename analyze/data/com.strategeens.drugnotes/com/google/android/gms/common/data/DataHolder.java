package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.class_969;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder implements SafeParcelable {
   public static final class_969 CREATOR = new class_969();
   // $FF: renamed from: Ll com.google.android.gms.common.data.DataHolder$a
   private static final DataHolder.class_1422 field_4481 = new DataHolder.class_1422(new String[0], (String)null, null) {
   };
   // $FF: renamed from: CK int
   private final int field_4482;
   // $FF: renamed from: Iv int
   private final int field_4483;
   // $FF: renamed from: Ld java.lang.String[]
   private final String[] field_4484;
   // $FF: renamed from: Le android.os.Bundle
   Bundle field_4485;
   // $FF: renamed from: Lf android.database.CursorWindow[]
   private final CursorWindow[] field_4486;
   // $FF: renamed from: Lg android.os.Bundle
   private final Bundle field_4487;
   // $FF: renamed from: Lh int[]
   int[] field_4488;
   // $FF: renamed from: Li int
   int field_4489;
   // $FF: renamed from: Lj java.lang.Object
   private Object field_4490;
   // $FF: renamed from: Lk boolean
   private boolean field_4491;
   boolean mClosed;

   DataHolder(int var1, String[] var2, CursorWindow[] var3, int var4, Bundle var5) {
      this.mClosed = false;
      this.field_4491 = true;
      this.field_4482 = var1;
      this.field_4484 = var2;
      this.field_4486 = var3;
      this.field_4483 = var4;
      this.field_4487 = var5;
   }

   private DataHolder(DataHolder.class_1422 var1, int var2, Bundle var3) {
      this(var1.field_2480, method_5823(var1, -1), var2, var3);
   }

   public DataHolder(String[] var1, CursorWindow[] var2, int var3, Bundle var4) {
      this.mClosed = false;
      this.field_4491 = true;
      this.field_4482 = 1;
      this.field_4484 = (String[])class_335.method_2311(var1);
      this.field_4486 = (CursorWindow[])class_335.method_2311(var2);
      this.field_4483 = var3;
      this.field_4487 = var4;
      this.method_5838();
   }

   // $FF: renamed from: a (int, android.os.Bundle) com.google.android.gms.common.data.DataHolder
   public static DataHolder method_5822(int var0, Bundle var1) {
      return new DataHolder(field_4481, var0, var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder$a, int) android.database.CursorWindow[]
   private static CursorWindow[] method_5823(DataHolder.class_1422 param0, int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: av (int) com.google.android.gms.common.data.DataHolder
   public static DataHolder method_5824(int var0) {
      return method_5822(var0, (Bundle)null);
   }

   // $FF: renamed from: g (java.lang.String, int) void
   private void method_5825(String var1, int var2) {
      if(this.field_4485 != null && this.field_4485.containsKey(var1)) {
         if(this.isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
         } else if(var2 < 0 || var2 >= this.field_4489) {
            throw new CursorIndexOutOfBoundsException(var2, this.field_4489);
         }
      } else {
         throw new IllegalArgumentException("No such column: " + var1);
      }
   }

   // $FF: renamed from: a (java.lang.String, int, int) long
   public long method_5826(String var1, int var2, int var3) {
      this.method_5825(var1, var2);
      return this.field_4486[var3].getLong(var2, this.field_4485.getInt(var1));
   }

   // $FF: renamed from: a (java.lang.String, int, int, android.database.CharArrayBuffer) void
   public void method_5827(String var1, int var2, int var3, CharArrayBuffer var4) {
      this.method_5825(var1, var2);
      this.field_4486[var3].copyStringToBuffer(var2, this.field_4485.getInt(var1), var4);
   }

   // $FF: renamed from: aQ (java.lang.String) boolean
   public boolean method_5828(String var1) {
      return this.field_4485.containsKey(var1);
   }

   // $FF: renamed from: au (int) int
   public int method_5829(int var1) {
      int var2 = 0;
      boolean var3;
      if(var1 >= 0 && var1 < this.field_4489) {
         var3 = true;
      } else {
         var3 = false;
      }

      class_335.method_2300(var3);

      while(var2 < this.field_4488.length) {
         if(var1 < this.field_4488[var2]) {
            --var2;
            break;
         }

         ++var2;
      }

      if(var2 == this.field_4488.length) {
         --var2;
      }

      return var2;
   }

   // $FF: renamed from: b (java.lang.String, int, int) int
   public int method_5830(String var1, int var2, int var3) {
      this.method_5825(var1, var2);
      return this.field_4486[var3].getInt(var2, this.field_4485.getInt(var1));
   }

   // $FF: renamed from: c (java.lang.String, int, int) java.lang.String
   public String method_5831(String var1, int var2, int var3) {
      this.method_5825(var1, var2);
      return this.field_4486[var3].getString(var2, this.field_4485.getInt(var1));
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (java.lang.String, int, int) boolean
   public boolean method_5832(String var1, int var2, int var3) {
      this.method_5825(var1, var2);
      return Long.valueOf(this.field_4486[var3].getLong(var2, this.field_4485.getInt(var1))).longValue() == 1L;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: e (java.lang.String, int, int) float
   public float method_5833(String var1, int var2, int var3) {
      this.method_5825(var1, var2);
      return this.field_4486[var3].getFloat(var2, this.field_4485.getInt(var1));
   }

   // $FF: renamed from: e (java.lang.Object) void
   public void method_5834(Object var1) {
      this.field_4490 = var1;
   }

   // $FF: renamed from: f (java.lang.String, int, int) byte[]
   public byte[] method_5835(String var1, int var2, int var3) {
      this.method_5825(var1, var2);
      return this.field_4486[var3].getBlob(var2, this.field_4485.getInt(var1));
   }

   protected void finalize() throws Throwable {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: g (java.lang.String, int, int) android.net.Uri
   public Uri method_5836(String var1, int var2, int var3) {
      String var4 = this.method_5831(var1, var2, var3);
      return var4 == null?null:Uri.parse(var4);
   }

   // $FF: renamed from: gV () android.os.Bundle
   public Bundle method_5837() {
      return this.field_4487;
   }

   // $FF: renamed from: gX () void
   public void method_5838() {
      int var1 = 0;
      this.field_4485 = new Bundle();

      for(int var2 = 0; var2 < this.field_4484.length; ++var2) {
         this.field_4485.putInt(this.field_4484[var2], var2);
      }

      this.field_4488 = new int[this.field_4486.length];

      int var3;
      for(var3 = 0; var1 < this.field_4486.length; ++var1) {
         this.field_4488[var1] = var3;
         int var4 = var3 - this.field_4486[var1].getStartPosition();
         var3 += this.field_4486[var1].getNumRows() - var4;
      }

      this.field_4489 = var3;
   }

   // $FF: renamed from: gY () java.lang.String[]
   String[] method_5839() {
      return this.field_4484;
   }

   // $FF: renamed from: gZ () android.database.CursorWindow[]
   CursorWindow[] method_5840() {
      return this.field_4486;
   }

   public int getCount() {
      return this.field_4489;
   }

   public int getStatusCode() {
      return this.field_4483;
   }

   int getVersionCode() {
      return this.field_4482;
   }

   // $FF: renamed from: h (java.lang.String, int, int) boolean
   public boolean method_5841(String var1, int var2, int var3) {
      this.method_5825(var1, var2);
      return this.field_4486[var3].isNull(var2, this.field_4485.getInt(var1));
   }

   public boolean isClosed() {
      // $FF: Couldn't be decompiled
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_969.method_5393(this, var1, var2);
   }

   public static class class_1422 {
      // $FF: renamed from: Ld java.lang.String[]
      private final String[] field_2480;
      // $FF: renamed from: Lm java.util.ArrayList
      private final ArrayList<HashMap<String, Object>> field_2481;
      // $FF: renamed from: Ln java.lang.String
      private final String field_2482;
      // $FF: renamed from: Lo java.util.HashMap
      private final HashMap<Object, Integer> field_2483;
      // $FF: renamed from: Lp boolean
      private boolean field_2484;
      // $FF: renamed from: Lq java.lang.String
      private String field_2485;

      private class_1422(String[] var1, String var2) {
         this.field_2480 = (String[])class_335.method_2311(var1);
         this.field_2481 = new ArrayList();
         this.field_2482 = var2;
         this.field_2483 = new HashMap();
         this.field_2484 = false;
         this.field_2485 = null;
      }

      // $FF: synthetic method
      class_1422(String[] var1, String var2, Object var3) {
         this(var1, var2);
      }

      // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder$a) java.util.ArrayList
      // $FF: synthetic method
      static ArrayList method_3251(DataHolder.class_1422 var0) {
         return var0.field_2481;
      }
   }

   public static class class_1421 extends RuntimeException {
      public class_1421(String var1) {
         super(var1);
      }
   }
}
