package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_419;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.ey;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.eh
@ey
public class class_421 {
   // $FF: renamed from: mH java.lang.Object
   private static final Object field_1320 = new Object();
   // $FF: renamed from: sZ java.lang.String
   private static final String field_1321 = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
   // $FF: renamed from: tb com.google.android.gms.internal.eh
   private static class_421 field_1322;
   // $FF: renamed from: ta com.google.android.gms.internal.eh$a
   private final class_421.class_1518 field_1323;

   private class_421(Context var1) {
      this.field_1323 = new class_421.class_1518(var1, "google_inapp_purchase.db");
   }

   // $FF: renamed from: j (android.content.Context) com.google.android.gms.internal.eh
   public static class_421 method_2778(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.database.Cursor) com.google.android.gms.internal.ef
   public class_419 method_2779(Cursor var1) {
      return var1 == null?null:new class_419(var1.getLong(0), var1.getString(1), var1.getString(2));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ef) void
   public void method_2780(class_419 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.internal.ef) void
   public void method_2781(class_419 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cA () void
   public void method_2782() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (long) java.util.List
   public List<ef> method_2783(long param1) {
      // $FF: Couldn't be decompiled
   }

   public int getRecordCount() {
      // $FF: Couldn't be decompiled
   }

   public SQLiteDatabase getWritableDatabase() {
      try {
         SQLiteDatabase var2 = this.field_1323.getWritableDatabase();
         return var2;
      } catch (SQLiteException var3) {
         class_368.method_2506("Error opening writable conversion tracking database");
         return null;
      }
   }

   public class class_1518 extends SQLiteOpenHelper {
      public class_1518(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 4);
      }

      public void onCreate(SQLiteDatabase var1) {
         var1.execSQL(class_421.field_1321);
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
         class_368.method_2504("Database updated from version " + var2 + " to version " + var3);
         var1.execSQL("DROP TABLE IF EXISTS InAppPurchase");
         this.onCreate(var1);
      }
   }
}
