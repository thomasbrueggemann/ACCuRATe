package com.parse;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import bolts.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

class ParseSQLiteCursor implements Cursor {
   private Cursor cursor;
   private Executor executor;

   private ParseSQLiteCursor(Cursor var1, Executor var2) {
      this.cursor = var1;
      this.executor = var2;
   }

   public static Cursor create(Cursor var0, Executor var1) {
      return (Cursor)(VERSION.SDK_INT >= 14?var0:new ParseSQLiteCursor(var0, var1));
   }

   public void close() {
      Task.call(new Callable() {
         public Void call() throws Exception {
            ParseSQLiteCursor.this.cursor.close();
            return null;
         }
      }, this.executor);
   }

   public void copyStringToBuffer(int var1, CharArrayBuffer var2) {
      this.cursor.copyStringToBuffer(var1, var2);
   }

   @Deprecated
   public void deactivate() {
      this.cursor.deactivate();
   }

   public byte[] getBlob(int var1) {
      return this.cursor.getBlob(var1);
   }

   public int getColumnCount() {
      return this.cursor.getColumnCount();
   }

   public int getColumnIndex(String var1) {
      return this.cursor.getColumnIndex(var1);
   }

   public int getColumnIndexOrThrow(String var1) throws IllegalArgumentException {
      return this.cursor.getColumnIndexOrThrow(var1);
   }

   public String getColumnName(int var1) {
      return this.cursor.getColumnName(var1);
   }

   public String[] getColumnNames() {
      return this.cursor.getColumnNames();
   }

   public int getCount() {
      return this.cursor.getCount();
   }

   public double getDouble(int var1) {
      return this.cursor.getDouble(var1);
   }

   public Bundle getExtras() {
      return this.cursor.getExtras();
   }

   public float getFloat(int var1) {
      return this.cursor.getFloat(var1);
   }

   public int getInt(int var1) {
      return this.cursor.getInt(var1);
   }

   public long getLong(int var1) {
      return this.cursor.getLong(var1);
   }

   @TargetApi(19)
   public Uri getNotificationUri() {
      return this.cursor.getNotificationUri();
   }

   public int getPosition() {
      return this.cursor.getPosition();
   }

   public short getShort(int var1) {
      return this.cursor.getShort(var1);
   }

   public String getString(int var1) {
      return this.cursor.getString(var1);
   }

   @TargetApi(11)
   public int getType(int var1) {
      return this.cursor.getType(var1);
   }

   public boolean getWantsAllOnMoveCalls() {
      return this.cursor.getWantsAllOnMoveCalls();
   }

   public boolean isAfterLast() {
      return this.cursor.isAfterLast();
   }

   public boolean isBeforeFirst() {
      return this.cursor.isBeforeFirst();
   }

   public boolean isClosed() {
      return this.cursor.isClosed();
   }

   public boolean isFirst() {
      return this.cursor.isFirst();
   }

   public boolean isLast() {
      return this.cursor.isLast();
   }

   public boolean isNull(int var1) {
      return this.cursor.isNull(var1);
   }

   public boolean move(int var1) {
      return this.cursor.move(var1);
   }

   public boolean moveToFirst() {
      return this.cursor.moveToFirst();
   }

   public boolean moveToLast() {
      return this.cursor.moveToLast();
   }

   public boolean moveToNext() {
      return this.cursor.moveToNext();
   }

   public boolean moveToPosition(int var1) {
      return this.cursor.moveToPosition(var1);
   }

   public boolean moveToPrevious() {
      return this.cursor.moveToPrevious();
   }

   public void registerContentObserver(ContentObserver var1) {
      this.cursor.registerContentObserver(var1);
   }

   public void registerDataSetObserver(DataSetObserver var1) {
      this.cursor.registerDataSetObserver(var1);
   }

   @Deprecated
   public boolean requery() {
      return this.cursor.requery();
   }

   public Bundle respond(Bundle var1) {
      return this.cursor.respond(var1);
   }

   public void setNotificationUri(ContentResolver var1, Uri var2) {
      this.cursor.setNotificationUri(var1, var2);
   }

   public void unregisterContentObserver(ContentObserver var1) {
      this.cursor.unregisterContentObserver(var1);
   }

   public void unregisterDataSetObserver(DataSetObserver var1) {
      this.cursor.unregisterDataSetObserver(var1);
   }
}
