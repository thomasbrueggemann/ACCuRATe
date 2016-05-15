package com.newrelic.agent.android.instrumentation;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.CancellationSignal;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;

public class SQLiteInstrumentation {
   private static final ArrayList<String> categoryParams;

   static {
      String[] var0 = new String[]{"category", MetricCategory.class.getName(), "DATABASE"};
      categoryParams = new ArrayList(Arrays.asList(var0));
   }

   @ReplaceCallSite
   public static int delete(SQLiteDatabase var0, String var1, String var2, String[] var3) {
      TraceMachine.enterMethod("SQLiteDatabase#delete", categoryParams);
      int var4 = var0.delete(var1, var2, var3);
      TraceMachine.exitMethod();
      return var4;
   }

   @ReplaceCallSite
   public static void execSQL(SQLiteDatabase var0, String var1) throws SQLException {
      TraceMachine.enterMethod("SQLiteDatabase#execSQL", categoryParams);
      var0.execSQL(var1);
      TraceMachine.exitMethod();
   }

   @ReplaceCallSite
   public static void execSQL(SQLiteDatabase var0, String var1, Object[] var2) throws SQLException {
      TraceMachine.enterMethod("SQLiteDatabase#execSQL", categoryParams);
      var0.execSQL(var1, var2);
      TraceMachine.exitMethod();
   }

   @ReplaceCallSite
   public static long insert(SQLiteDatabase var0, String var1, String var2, ContentValues var3) {
      TraceMachine.enterMethod("SQLiteDatabase#insert", categoryParams);
      long var4 = var0.insert(var1, var2, var3);
      TraceMachine.exitMethod();
      return var4;
   }

   @ReplaceCallSite
   public static long insertOrThrow(SQLiteDatabase var0, String var1, String var2, ContentValues var3) throws SQLException {
      TraceMachine.enterMethod("SQLiteDatabase#insertOrThrow", categoryParams);
      long var4 = var0.insertOrThrow(var1, var2, var3);
      TraceMachine.exitMethod();
      return var4;
   }

   @ReplaceCallSite
   public static long insertWithOnConflict(SQLiteDatabase var0, String var1, String var2, ContentValues var3, int var4) {
      TraceMachine.enterMethod("SQLiteDatabase#insertWithOnConflict", categoryParams);
      long var5 = var0.insertWithOnConflict(var1, var2, var3, var4);
      TraceMachine.exitMethod();
      return var5;
   }

   @ReplaceCallSite
   public static Cursor query(SQLiteDatabase var0, String var1, String[] var2, String var3, String[] var4, String var5, String var6, String var7) {
      TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
      Cursor var8 = var0.query(var1, var2, var3, var4, var5, var6, var7);
      TraceMachine.exitMethod();
      return var8;
   }

   @ReplaceCallSite
   public static Cursor query(SQLiteDatabase var0, String var1, String[] var2, String var3, String[] var4, String var5, String var6, String var7, String var8) {
      TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
      Cursor var9 = var0.query(var1, var2, var3, var4, var5, var6, var7, var8);
      TraceMachine.exitMethod();
      return var9;
   }

   @ReplaceCallSite
   public static Cursor query(SQLiteDatabase var0, boolean var1, String var2, String[] var3, String var4, String[] var5, String var6, String var7, String var8, String var9) {
      TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
      Cursor var10 = var0.query(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      TraceMachine.exitMethod();
      return var10;
   }

   @ReplaceCallSite
   public static Cursor query(SQLiteDatabase var0, boolean var1, String var2, String[] var3, String var4, String[] var5, String var6, String var7, String var8, String var9, CancellationSignal var10) {
      TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
      Cursor var11 = var0.query(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      TraceMachine.exitMethod();
      return var11;
   }

   @ReplaceCallSite
   public static Cursor queryWithFactory(SQLiteDatabase var0, CursorFactory var1, boolean var2, String var3, String[] var4, String var5, String[] var6, String var7, String var8, String var9, String var10) {
      TraceMachine.enterMethod("SQLiteDatabase#queryWithFactory", categoryParams);
      Cursor var11 = var0.queryWithFactory(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      TraceMachine.exitMethod();
      return var11;
   }

   @ReplaceCallSite
   public static Cursor queryWithFactory(SQLiteDatabase var0, CursorFactory var1, boolean var2, String var3, String[] var4, String var5, String[] var6, String var7, String var8, String var9, String var10, CancellationSignal var11) {
      TraceMachine.enterMethod("SQLiteDatabase#queryWithFactory", categoryParams);
      Cursor var12 = var0.queryWithFactory(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      TraceMachine.exitMethod();
      return var12;
   }

   @ReplaceCallSite
   public static Cursor rawQuery(SQLiteDatabase var0, String var1, String[] var2) {
      TraceMachine.enterMethod("SQLiteDatabase#rawQuery", categoryParams);
      Cursor var3 = var0.rawQuery(var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite
   public static Cursor rawQuery(SQLiteDatabase var0, String var1, String[] var2, CancellationSignal var3) {
      TraceMachine.enterMethod("SQLiteDatabase#rawQuery", categoryParams);
      Cursor var4 = var0.rawQuery(var1, var2, var3);
      TraceMachine.exitMethod();
      return var4;
   }

   @ReplaceCallSite
   public static Cursor rawQueryWithFactory(SQLiteDatabase var0, CursorFactory var1, String var2, String[] var3, String var4) {
      TraceMachine.enterMethod("SQLiteDatabase#rawQueryWithFactory", categoryParams);
      Cursor var5 = var0.rawQueryWithFactory(var1, var2, var3, var4);
      TraceMachine.exitMethod();
      return var5;
   }

   @ReplaceCallSite
   public static Cursor rawQueryWithFactory(SQLiteDatabase var0, CursorFactory var1, String var2, String[] var3, String var4, CancellationSignal var5) {
      TraceMachine.enterMethod("SQLiteDatabase#rawQueryWithFactory", categoryParams);
      Cursor var6 = var0.rawQueryWithFactory(var1, var2, var3, var4, var5);
      TraceMachine.exitMethod();
      return var6;
   }

   @ReplaceCallSite
   public static long replace(SQLiteDatabase var0, String var1, String var2, ContentValues var3) {
      TraceMachine.enterMethod("SQLiteDatabase#replace", categoryParams);
      long var4 = var0.replace(var1, var2, var3);
      TraceMachine.exitMethod();
      return var4;
   }

   @ReplaceCallSite
   public static long replaceOrThrow(SQLiteDatabase var0, String var1, String var2, ContentValues var3) throws SQLException {
      TraceMachine.enterMethod("SQLiteDatabase#replaceOrThrow", categoryParams);
      long var4 = var0.replaceOrThrow(var1, var2, var3);
      TraceMachine.exitMethod();
      return var4;
   }

   @ReplaceCallSite
   public static int update(SQLiteDatabase var0, String var1, ContentValues var2, String var3, String[] var4) {
      TraceMachine.enterMethod("SQLiteDatabase#update", categoryParams);
      int var5 = var0.update(var1, var2, var3, var4);
      TraceMachine.exitMethod();
      return var5;
   }

   @ReplaceCallSite
   public static int updateWithOnConflict(SQLiteDatabase var0, String var1, ContentValues var2, String var3, String[] var4, int var5) {
      TraceMachine.enterMethod("SQLiteDatabase#updateWithOnConflict", categoryParams);
      int var6 = var0.updateWithOnConflict(var1, var2, var3, var4, var5);
      TraceMachine.exitMethod();
      return var6;
   }
}
