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
import com.google.android.gms.internal.class_141;
import com.google.android.gms.internal.class_720;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_647;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// $FF: renamed from: com.google.android.gms.tagmanager.v
class class_676 implements DataLayer.class_1345 {
   private static final String ara = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' STRING NOT NULL, \'%s\' BLOB NOT NULL, \'%s\' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
   private final Executor arb;
   private class_676.class_1690 arc;
   private int ard;
   private final Context mContext;
   // $FF: renamed from: wb com.google.android.gms.internal.ld
   private class_141 field_2923;

   public class_676(Context var1) {
      this(var1, class_720.method_4198(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
   }

   class_676(Context var1, class_141 var2, String var3, int var4, Executor var5) {
      this.mContext = var1;
      this.field_2923 = var2;
      this.ard = var4;
      this.arb = var5;
      this.arc = new class_676.class_1690(this.mContext, var3);
   }

   // $FF: renamed from: al (java.lang.String) android.database.sqlite.SQLiteDatabase
   private SQLiteDatabase method_3838(String var1) {
      try {
         SQLiteDatabase var3 = this.arc.getWritableDatabase();
         return var3;
      } catch (SQLiteException var4) {
         class_613.method_3494(var1);
         return null;
      }
   }

   // $FF: renamed from: b (java.util.List, long) void
   private void method_3840(List<class_676.class_1691> param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (java.util.List, long) void
   private void method_3841(List<class_676.class_1691> var1, long var2) {
      SQLiteDatabase var4 = this.method_3838("Error opening database for writeEntryToDatabase.");
      if(var4 != null) {
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            class_676.class_1691 var6 = (class_676.class_1691)var5.next();
            ContentValues var7 = new ContentValues();
            var7.put("expires", Long.valueOf(var2));
            var7.put("key", var6.field_4462);
            var7.put("value", var6.arj);
            var4.insert("datalayer", (String)null, var7);
         }
      }

   }

   // $FF: renamed from: cA (java.lang.String) void
   private void method_3842(String var1) {
      SQLiteDatabase var2 = this.method_3838("Error opening database for clearKeysWithPrefix.");
      if(var2 != null) {
         try {
            String[] var5 = new String[]{var1, var1 + ".%"};
            int var6 = var2.delete("datalayer", "key = ? OR key LIKE ?", var5);
            class_613.method_3493("Cleared " + var6 + " items");
            return;
         } catch (SQLiteException var9) {
            class_613.method_3494("Error deleting entries with key prefix: " + var1 + " (" + var9 + ").");
         } finally {
            this.method_3852();
         }

      }
   }

   // $FF: renamed from: fI (int) void
   private void method_3843(int var1) {
      int var2 = var1 + (this.method_3851() - this.ard);
      if(var2 > 0) {
         List var3 = this.method_3844(var2);
         class_613.method_3492("DataLayer store full, deleting " + var3.size() + " entries to make room.");
         this.method_3845((String[])var3.toArray(new String[0]));
      }

   }

   // $FF: renamed from: fJ (int) java.util.List
   private List<String> method_3844(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: h (java.lang.String[]) void
   private void method_3845(String[] var1) {
      if(var1 != null && var1.length != 0) {
         SQLiteDatabase var2 = this.method_3838("Error opening database for deleteEntries.");
         if(var2 != null) {
            Object[] var3 = new Object[]{"ID", TextUtils.join(",", Collections.nCopies(var1.length, "?"))};
            String var4 = String.format("%s in (%s)", var3);

            try {
               var2.delete("datalayer", var4, var1);
               return;
            } catch (SQLiteException var6) {
               class_613.method_3494("Error deleting entries " + Arrays.toString(var1));
               return;
            }
         }
      }

   }

   // $FF: renamed from: i (java.util.List) java.util.List
   private List<DataLayer.class_1642> method_3846(List<class_676.class_1691> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class_676.class_1691 var4 = (class_676.class_1691)var3.next();
         var2.add(new DataLayer.class_1642(var4.field_4462, this.method_3847(var4.arj)));
      }

      return var2;
   }

   // $FF: renamed from: j (byte[]) java.lang.Object
   private Object method_3847(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: j (java.util.List) java.util.List
   private List<class_676.class_1691> method_3848(List<DataLayer.class_1642> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         DataLayer.class_1642 var4 = (DataLayer.class_1642)var3.next();
         var2.add(new class_676.class_1691(var4.field_4287, this.method_3849(var4.field_4288)));
      }

      return var2;
   }

   // $FF: renamed from: m (java.lang.Object) byte[]
   private byte[] method_3849(Object param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: pA () java.util.List
   private List<class_676.class_1691> method_3850() {
      SQLiteDatabase var1 = this.method_3838("Error opening database for loadSerialized.");
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

               var2.add(new class_676.class_1691(var3.getString(0), var3.getBlob(1)));
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

   // $FF: renamed from: pB () int
   private int method_3851() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: pC () void
   private void method_3852() {
      try {
         this.arc.close();
      } catch (SQLiteException var2) {
         ;
      }
   }

   // $FF: renamed from: pz () java.util.List
   private List<DataLayer.class_1642> method_3854() {
      List var2;
      try {
         this.method_3855(this.field_2923.currentTimeMillis());
         var2 = this.method_3846(this.method_3850());
      } finally {
         this.method_3852();
      }

      return var2;
   }

   // $FF: renamed from: x (long) void
   private void method_3855(long var1) {
      SQLiteDatabase var3 = this.method_3838("Error opening database for deleteOlderThan.");
      if(var3 != null) {
         try {
            String[] var5 = new String[]{Long.toString(var1)};
            int var6 = var3.delete("datalayer", "expires <= ?", var5);
            class_613.method_3493("Deleted " + var6 + " expired items");
         } catch (SQLiteException var7) {
            class_613.method_3494("Error deleting old entries.");
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer$c$a) void
   public void method_1006(final DataLayer.class_1346 var1) {
      this.arb.execute(new Runnable() {
         public void run() {
            var1.method_409(class_676.this.method_3854());
         }
      });
   }

   // $FF: renamed from: a (java.util.List, long) void
   public void method_1007(List<DataLayer.class_1642> var1, final long var2) {
      final List var4 = this.method_3848(var1);
      this.arb.execute(new Runnable() {
         public void run() {
            class_676.this.method_3840(var4, var2);
         }
      });
   }

   // $FF: renamed from: cz (java.lang.String) void
   public void method_1008(final String var1) {
      this.arb.execute(new Runnable() {
         public void run() {
            class_676.this.method_3842(var1);
         }
      });
   }

   class class_1690 extends SQLiteOpenHelper {
      class_1690(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      // $FF: renamed from: a (android.database.sqlite.SQLiteDatabase) void
      private void method_5789(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, android.database.sqlite.SQLiteDatabase) boolean
      private boolean method_5790(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         SQLiteDatabase var3;
         label16: {
            SQLiteDatabase var4;
            try {
               var4 = super.getWritableDatabase();
            } catch (SQLiteException var5) {
               class_676.this.mContext.getDatabasePath("google_tagmanager.db").delete();
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
         class_647.method_3681(var1.getPath());
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

         if(!this.method_5790("datalayer", var1)) {
            var1.execSQL(class_676.ara);
         } else {
            this.method_5789(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }

   private static class class_1691 {
      // $FF: renamed from: KP java.lang.String
      final String field_4462;
      final byte[] arj;

      class_1691(String var1, byte[] var2) {
         this.field_4462 = var1;
         this.arj = var2;
      }

      public String toString() {
         return "KeyAndSerialized: key = " + this.field_4462 + " serialized hash = " + Arrays.hashCode(this.arj);
      }
   }
}
