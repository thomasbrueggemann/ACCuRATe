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
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzal;
import com.google.android.gms.tagmanager.zzbg;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzw implements DataLayer.zzc {
   private static final String zzbiB = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' STRING NOT NULL, \'%s\' BLOB NOT NULL, \'%s\' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
   private final Context mContext;
   private final Executor zzbiC;
   private zzw.zza zzbiD;
   private int zzbiE;
   private zzmq zzqW;

   public zzw(Context var1) {
      this(var1, zzmt.zzsc(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
   }

   zzw(Context var1, zzmq var2, String var3, int var4, Executor var5) {
      this.mContext = var1;
      this.zzqW = var2;
      this.zzbiE = var4;
      this.zzbiC = var5;
      this.zzbiD = new zzw.zza(this.mContext, var3);
   }

   private List<DataLayer.zza> zzC(List<zzw.zzb> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         zzw.zzb var4 = (zzw.zzb)var3.next();
         var2.add(new DataLayer.zza(var4.zzvs, this.zzw(var4.zzbiK)));
      }

      return var2;
   }

   private List<zzw.zzb> zzD(List<DataLayer.zza> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         DataLayer.zza var4 = (DataLayer.zza)var3.next();
         var2.add(new zzw.zzb(var4.zzvs, this.zzJ(var4.zzNc)));
      }

      return var2;
   }

   private List<DataLayer.zza> zzGr() {
      List var2;
      try {
         this.zzal(this.zzqW.currentTimeMillis());
         var2 = this.zzC(this.zzGs());
      } finally {
         this.zzGu();
      }

      return var2;
   }

   private List<zzw.zzb> zzGs() {
      SQLiteDatabase var1 = this.zzgb("Error opening database for loadSerialized.");
      ArrayList var2 = new ArrayList();
      if(var1 == null) {
         return var2;
      } else {
         String[] var3 = new String[]{"key", "value"};
         Cursor var4;
         if(!(var1 instanceof SQLiteDatabase)) {
            var4 = var1.query("datalayer", var3, (String)null, (String[])null, (String)null, (String)null, "ID", (String)null);
         } else {
            var4 = SQLiteInstrumentation.query((SQLiteDatabase)var1, "datalayer", var3, (String)null, (String[])null, (String)null, (String)null, "ID", (String)null);
         }

         while(true) {
            boolean var7 = false;

            try {
               var7 = true;
               if(!var4.moveToNext()) {
                  var7 = false;
                  break;
               }

               var2.add(new zzw.zzb(var4.getString(0), var4.getBlob(1)));
               var7 = false;
            } finally {
               if(var7) {
                  var4.close();
               }
            }
         }

         var4.close();
         return var2;
      }
   }

   private int zzGt() {
      // $FF: Couldn't be decompiled
   }

   private void zzGu() {
      try {
         this.zzbiD.close();
      } catch (SQLiteException var2) {
         ;
      }
   }

   private byte[] zzJ(Object param1) {
      // $FF: Couldn't be decompiled
   }

   private void zzal(long param1) {
      // $FF: Couldn't be decompiled
   }

   private void zzb(List<zzw.zzb> param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   private void zzc(List<zzw.zzb> var1, long var2) {
      SQLiteDatabase var4 = this.zzgb("Error opening database for writeEntryToDatabase.");
      if(var4 != null) {
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            zzw.zzb var6 = (zzw.zzb)var5.next();
            ContentValues var7 = new ContentValues();
            var7.put("expires", Long.valueOf(var2));
            var7.put("key", var6.zzvs);
            var7.put("value", var6.zzbiK);
            if(!(var4 instanceof SQLiteDatabase)) {
               var4.insert("datalayer", (String)null, var7);
            } else {
               SQLiteInstrumentation.insert((SQLiteDatabase)var4, "datalayer", (String)null, var7);
            }
         }
      }

   }

   private void zze(String[] var1) {
      if(var1 != null && var1.length != 0) {
         SQLiteDatabase var2 = this.zzgb("Error opening database for deleteEntries.");
         if(var2 != null) {
            Object[] var3 = new Object[]{"ID", TextUtils.join(",", Collections.nCopies(var1.length, "?"))};
            String var4 = String.format("%s in (%s)", var3);

            try {
               if(!(var2 instanceof SQLiteDatabase)) {
                  var2.delete("datalayer", var4, var1);
                  return;
               }

               SQLiteInstrumentation.delete((SQLiteDatabase)var2, "datalayer", var4, var1);
               return;
            } catch (SQLiteException var6) {
               zzbg.zzaK("Error deleting entries " + Arrays.toString(var1));
               return;
            }
         }
      }

   }

   private void zzga(String param1) {
      // $FF: Couldn't be decompiled
   }

   private SQLiteDatabase zzgb(String var1) {
      try {
         SQLiteDatabase var3 = this.zzbiD.getWritableDatabase();
         return var3;
      } catch (SQLiteException var4) {
         zzbg.zzaK(var1);
         return null;
      }
   }

   private void zzkf(int var1) {
      int var2 = var1 + (this.zzGt() - this.zzbiE);
      if(var2 > 0) {
         List var3 = this.zzkg(var2);
         zzbg.zzaJ("DataLayer store full, deleting " + var3.size() + " entries to make room.");
         this.zze((String[])var3.toArray(new String[0]));
      }

   }

   private List<String> zzkg(int param1) {
      // $FF: Couldn't be decompiled
   }

   private Object zzw(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   public void zza(final DataLayer.zza var1) {
      this.zzbiC.execute(new Runnable() {
         public void run() {
            var1.zzB(zzw.this.zzGr());
         }
      });
   }

   public void zza(List<DataLayer.zza> var1, final long var2) {
      final List var4 = this.zzD(var1);
      this.zzbiC.execute(new Runnable() {
         public void run() {
            zzw.this.zzb(var4, var2);
         }
      });
   }

   public void zzfZ(final String var1) {
      this.zzbiC.execute(new Runnable() {
         public void run() {
            zzw.this.zzga(var1);
         }
      });
   }

   class zza extends SQLiteOpenHelper {
      zza(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      private boolean zza(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      private void zzc(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         SQLiteDatabase var3;
         label16: {
            SQLiteDatabase var4;
            try {
               var4 = super.getWritableDatabase();
            } catch (SQLiteException var5) {
               zzw.this.mContext.getDatabasePath("google_tagmanager.db").delete();
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
         zzal.zzbo(var1.getPath());
      }

      public void onOpen(SQLiteDatabase var1) {
         if(VERSION.SDK_INT < 15) {
            Cursor var3;
            if(!(var1 instanceof SQLiteDatabase)) {
               var3 = var1.rawQuery("PRAGMA journal_mode=memory", (String[])null);
            } else {
               var3 = SQLiteInstrumentation.rawQuery((SQLiteDatabase)var1, "PRAGMA journal_mode=memory", (String[])null);
            }

            try {
               var3.moveToFirst();
            } finally {
               var3.close();
            }
         }

         if(!this.zza("datalayer", var1)) {
            String var2 = zzw.zzbiB;
            if(!(var1 instanceof SQLiteDatabase)) {
               var1.execSQL(var2);
            } else {
               SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, var2);
            }
         } else {
            this.zzc(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }

   private static class zzb {
      final byte[] zzbiK;
      final String zzvs;

      zzb(String var1, byte[] var2) {
         this.zzvs = var1;
         this.zzbiK = var2;
      }

      public String toString() {
         return "KeyAndSerialized: key = " + this.zzvs + " serialized hash = " + Arrays.hashCode(this.zzbiK);
      }
   }
}
