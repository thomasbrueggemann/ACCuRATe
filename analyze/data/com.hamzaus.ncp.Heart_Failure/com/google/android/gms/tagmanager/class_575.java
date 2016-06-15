package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_279;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_548;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// $FF: renamed from: com.google.android.gms.tagmanager.v
class class_575 implements DataLayer.class_1026 {
   private static final String afg = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' STRING NOT NULL, \'%s\' BLOB NOT NULL, \'%s\' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
   private class_19 aec;
   private final Executor afh;
   private class_575.class_1294 afi;
   private int afj;
   private final Context mContext;

   public class_575(Context var1) {
      this(var1, class_279.method_1858(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
   }

   class_575(Context var1, class_19 var2, String var3, int var4, Executor var5) {
      this.mContext = var1;
      this.aec = var2;
      this.afj = var4;
      this.afh = var5;
      this.afi = new class_575.class_1294(this.mContext, var3);
   }

   // $FF: renamed from: S (java.lang.String) android.database.sqlite.SQLiteDatabase
   private SQLiteDatabase method_3231(String var1) {
      try {
         SQLiteDatabase var3 = this.afi.getWritableDatabase();
         return var3;
      } catch (SQLiteException var4) {
         class_515.method_2919(var1);
         return null;
      }
   }

   // $FF: renamed from: b (java.util.List, long) void
   private void method_3236(List<class_575.class_1295> param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bQ (java.lang.String) void
   private void method_3237(String var1) {
      SQLiteDatabase var2 = this.method_3231("Error opening database for clearKeysWithPrefix.");
      if(var2 != null) {
         try {
            String[] var5 = new String[]{var1, var1 + ".%"};
            int var6 = var2.delete("datalayer", "key = ? OR key LIKE ?", var5);
            class_515.method_2918("Cleared " + var6 + " items");
            return;
         } catch (SQLiteException var9) {
            class_515.method_2919("Error deleting entries with key prefix: " + var1 + " (" + var9 + ").");
         } finally {
            this.method_3246();
         }

      }
   }

   // $FF: renamed from: c (java.util.List, long) void
   private void method_3238(List<class_575.class_1295> var1, long var2) {
      SQLiteDatabase var4 = this.method_3231("Error opening database for writeEntryToDatabase.");
      if(var4 != null) {
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            class_575.class_1295 var6 = (class_575.class_1295)var5.next();
            ContentValues var7 = new ContentValues();
            var7.put("expires", Long.valueOf(var2));
            var7.put("key", var6.field_4312);
            var7.put("value", var6.afp);
            var4.insert("datalayer", (String)null, var7);
         }
      }

   }

   // $FF: renamed from: do (int) void
   private void method_3239(int var1) {
      int var2 = var1 + (this.method_3250() - this.afj);
      if(var2 > 0) {
         List var3 = this.method_3240(var2);
         class_515.method_2917("DataLayer store full, deleting " + var3.size() + " entries to make room.");
         this.method_3243((String[])var3.toArray(new String[0]));
      }

   }

   // $FF: renamed from: dp (int) java.util.List
   private List<String> method_3240(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: e (java.util.List) java.util.List
   private List<DataLayer.class_1285> method_3241(List<class_575.class_1295> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class_575.class_1295 var4 = (class_575.class_1295)var3.next();
         var2.add(new DataLayer.class_1285(var4.field_4312, this.method_3244(var4.afp)));
      }

      return var2;
   }

   // $FF: renamed from: f (java.util.List) java.util.List
   private List<class_575.class_1295> method_3242(List<DataLayer.class_1285> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         DataLayer.class_1285 var4 = (DataLayer.class_1285)var3.next();
         var2.add(new class_575.class_1295(var4.field_4141, this.method_3245(var4.afe)));
      }

      return var2;
   }

   // $FF: renamed from: g (java.lang.String[]) void
   private void method_3243(String[] var1) {
      if(var1 != null && var1.length != 0) {
         SQLiteDatabase var2 = this.method_3231("Error opening database for deleteEntries.");
         if(var2 != null) {
            Object[] var3 = new Object[]{"ID", TextUtils.join(",", Collections.nCopies(var1.length, "?"))};
            String var4 = String.format("%s in (%s)", var3);

            try {
               var2.delete("datalayer", var4, var1);
               return;
            } catch (SQLiteException var6) {
               class_515.method_2919("Error deleting entries " + Arrays.toString(var1));
               return;
            }
         }
      }

   }

   // $FF: renamed from: j (byte[]) java.lang.Object
   private Object method_3244(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: j (java.lang.Object) byte[]
   private byte[] method_3245(Object param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: lA () void
   private void method_3246() {
      try {
         this.afi.close();
      } catch (SQLiteException var2) {
         ;
      }
   }

   // $FF: renamed from: lx () java.util.List
   private List<DataLayer.class_1285> method_3248() {
      List var2;
      try {
         this.method_3251(this.aec.currentTimeMillis());
         var2 = this.method_3241(this.method_3249());
      } finally {
         this.method_3246();
      }

      return var2;
   }

   // $FF: renamed from: ly () java.util.List
   private List<class_575.class_1295> method_3249() {
      SQLiteDatabase var1 = this.method_3231("Error opening database for loadSerialized.");
      ArrayList var2 = new ArrayList();
      if(var1 == null) {
         return var2;
      } else {
         Cursor var3 = var1.query("datalayer", new String[]{"key", "value"}, (String)null, (String[])null, (String)null, (String)null, "ID", (String)null);

         while(true) {
            boolean var6 = false;

            try {
               var6 = true;
               if(!var3.moveToNext()) {
                  var6 = false;
                  break;
               }

               var2.add(new class_575.class_1295(var3.getString(0), var3.getBlob(1)));
               var6 = false;
            } finally {
               if(var6) {
                  var3.close();
               }
            }
         }

         var3.close();
         return var2;
      }
   }

   // $FF: renamed from: lz () int
   private int method_3250() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: x (long) void
   private void method_3251(long var1) {
      SQLiteDatabase var3 = this.method_3231("Error opening database for deleteOlderThan.");
      if(var3 != null) {
         try {
            String[] var5 = new String[]{Long.toString(var1)};
            int var6 = var3.delete("datalayer", "expires <= ?", var5);
            class_515.method_2918("Deleted " + var6 + " expired items");
         } catch (SQLiteException var7) {
            class_515.method_2919("Error deleting old entries.");
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer$c$a) void
   public void method_820(final DataLayer.class_1027 var1) {
      this.afh.execute(new Runnable() {
         public void run() {
            var1.method_368(class_575.this.method_3248());
         }
      });
   }

   // $FF: renamed from: a (java.util.List, long) void
   public void method_821(List<DataLayer.class_1285> var1, final long var2) {
      final List var4 = this.method_3242(var1);
      this.afh.execute(new Runnable() {
         public void run() {
            class_575.this.method_3236(var4, var2);
         }
      });
   }

   // $FF: renamed from: bP (java.lang.String) void
   public void method_822(final String var1) {
      this.afh.execute(new Runnable() {
         public void run() {
            class_575.this.method_3237(var1);
         }
      });
   }

   class class_1294 extends SQLiteOpenHelper {
      class_1294(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      // $FF: renamed from: a (android.database.sqlite.SQLiteDatabase) void
      private void method_4524(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, android.database.sqlite.SQLiteDatabase) boolean
      private boolean method_4525(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         SQLiteDatabase var3;
         label16: {
            SQLiteDatabase var4;
            try {
               var4 = super.getWritableDatabase();
            } catch (SQLiteException var5) {
               class_575.this.mContext.getDatabasePath("google_tagmanager.db").delete();
               var3 = null;
               break label16;
            }

            var3 = var4;
         }

         if(var3 == null) {
            var3 = super.getWritableDatabase();
         }

         return var3;
      }

      public void onCreate(SQLiteDatabase var1) {
         class_548.method_3101(var1.getPath());
      }

      public void onOpen(SQLiteDatabase var1) {
         if(VERSION.SDK_INT < 15) {
            Cursor var2 = var1.rawQuery("PRAGMA journal_mode=memory", (String[])null);

            try {
               var2.moveToFirst();
            } finally {
               var2.close();
            }
         }

         if(!this.method_4525("datalayer", var1)) {
            var1.execSQL(class_575.afg);
         } else {
            this.method_4524(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }

   private static class class_1295 {
      // $FF: renamed from: JI java.lang.String
      final String field_4312;
      final byte[] afp;

      class_1295(String var1, byte[] var2) {
         this.field_4312 = var1;
         this.afp = var2;
      }

      public String toString() {
         return "KeyAndSerialized: key = " + this.field_4312 + " serialized hash = " + Arrays.hashCode(this.afp);
      }
   }
}
