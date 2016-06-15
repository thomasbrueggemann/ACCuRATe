package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_413;
import com.google.android.gms.internal.cw;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.cy
public class class_415 {
   // $FF: renamed from: lq java.lang.Object
   private static final Object field_1827 = new Object();
   // $FF: renamed from: pp java.lang.String
   private static final String field_1828 = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
   // $FF: renamed from: pr com.google.android.gms.internal.cy
   private static class_415 field_1829;
   // $FF: renamed from: pq com.google.android.gms.internal.cy$a
   private final class_415.class_1173 field_1830;

   private class_415(Context var1) {
      this.field_1830 = new class_415.class_1173(var1, "google_inapp_purchase.db");
   }

   // $FF: renamed from: h (android.content.Context) com.google.android.gms.internal.cy
   public static class_415 method_2537(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.database.Cursor) com.google.android.gms.internal.cw
   public class_413 method_2538(Cursor var1) {
      return var1 == null?null:new class_413(var1.getLong(0), var1.getString(1), var1.getString(2));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.cw) void
   public void method_2539(class_413 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.internal.cw) void
   public void method_2540(class_413 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bf () void
   public void method_2541() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (long) java.util.List
   public List<cw> method_2542(long param1) {
      // $FF: Couldn't be decompiled
   }

   public int getRecordCount() {
      // $FF: Couldn't be decompiled
   }

   public SQLiteDatabase getWritableDatabase() {
      try {
         SQLiteDatabase var2 = this.field_1830.getWritableDatabase();
         return var2;
      } catch (SQLiteException var3) {
         class_370.method_2358("Error opening writable conversion tracking database");
         return null;
      }
   }

   public class class_1173 extends SQLiteOpenHelper {
      public class_1173(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 4);
      }

      public void onCreate(SQLiteDatabase var1) {
         var1.execSQL(class_415.field_1828);
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
         class_370.method_2356("Database updated from version " + var2 + " to version " + var3);
         var1.execSQL("DROP TABLE IF EXISTS InAppPurchase");
         this.onCreate(var1);
      }
   }
}
