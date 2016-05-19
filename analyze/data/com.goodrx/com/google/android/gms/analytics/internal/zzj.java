package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzaj;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.analytics.internal.zzx;
import com.google.android.gms.internal.zzmz;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class zzj extends zzd implements Closeable {
   private static final String zzQR = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
   private static final String zzQS = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
   private final zzj.zza zzQT;
   private final zzaj zzQU = new zzaj(this.zzjl());
   private final zzaj zzQV = new zzaj(this.zzjl());

   zzj(zzf var1) {
      super(var1);
      String var2 = this.zzjQ();
      this.zzQT = new zzj.zza(var1.getContext(), var2);
   }

   private static String zzI(Map<String, String> var0) {
      com.google.android.gms.common.internal.zzx.zzz(var0);
      Builder var2 = new Builder();
      Iterator var3 = var0.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var5 = (Entry)var3.next();
         var2.appendQueryParameter((String)var5.getKey(), (String)var5.getValue());
      }

      String var4 = var2.build().getEncodedQuery();
      if(var4 == null) {
         var4 = "";
      }

      return var4;
   }

   private long zza(String param1, String[] param2, long param3) {
      // $FF: Couldn't be decompiled
   }

   private long zzb(String param1, String[] param2) {
      // $FF: Couldn't be decompiled
   }

   private String zzd(zzab var1) {
      return var1.zzlt()?this.zzjn().zzkF():this.zzjn().zzkG();
   }

   private static String zze(zzab var0) {
      com.google.android.gms.common.internal.zzx.zzz(var0);
      Builder var2 = new Builder();
      Iterator var3 = var0.zzn().entrySet().iterator();

      while(var3.hasNext()) {
         Entry var5 = (Entry)var3.next();
         String var6 = (String)var5.getKey();
         if(!"ht".equals(var6) && !"qt".equals(var6) && !"AppUID".equals(var6)) {
            var2.appendQueryParameter(var6, (String)var5.getValue());
         }
      }

      String var4 = var2.build().getEncodedQuery();
      if(var4 == null) {
         var4 = "";
      }

      return var4;
   }

   private void zzjP() {
      int var1 = this.zzjn().zzkP();
      long var2 = this.zzjG();
      if(var2 > (long)(var1 - 1)) {
         List var4 = this.zzo(1L + (var2 - (long)var1));
         this.zzd("Store full, deleting hits to make room, count", Integer.valueOf(var4.size()));
         this.zzo(var4);
      }

   }

   private String zzjQ() {
      return !this.zzjn().zzkr()?this.zzjn().zzkR():(this.zzjn().zzks()?this.zzjn().zzkR():this.zzjn().zzkS());
   }

   public void beginTransaction() {
      this.zzjv();
      this.getWritableDatabase().beginTransaction();
   }

   public void close() {
      try {
         this.zzQT.close();
      } catch (SQLiteException var3) {
         this.zze("Sql error closing database", var3);
      } catch (IllegalStateException var4) {
         this.zze("Error closing database", var4);
      }
   }

   public void endTransaction() {
      this.zzjv();
      this.getWritableDatabase().endTransaction();
   }

   SQLiteDatabase getWritableDatabase() {
      try {
         SQLiteDatabase var2 = this.zzQT.getWritableDatabase();
         return var2;
      } catch (SQLiteException var3) {
         this.zzd("Error opening database", var3);
         throw var3;
      }
   }

   boolean isEmpty() {
      return this.zzjG() == 0L;
   }

   public void setTransactionSuccessful() {
      this.zzjv();
      this.getWritableDatabase().setTransactionSuccessful();
   }

   public long zza(long var1, String var3, String var4) {
      com.google.android.gms.common.internal.zzx.zzcM(var3);
      com.google.android.gms.common.internal.zzx.zzcM(var4);
      this.zzjv();
      this.zzjk();
      String[] var7 = new String[]{String.valueOf(var1), var3, var4};
      return this.zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", var7, 0L);
   }

   public void zza(long var1, String var3) {
      com.google.android.gms.common.internal.zzx.zzcM(var3);
      this.zzjv();
      this.zzjk();
      SQLiteDatabase var5 = this.getWritableDatabase();
      String[] var6 = new String[]{String.valueOf(var1), var3};
      int var7;
      if(!(var5 instanceof SQLiteDatabase)) {
         var7 = var5.delete("properties", "app_uid=? AND cid<>?", var6);
      } else {
         var7 = SQLiteInstrumentation.delete((SQLiteDatabase)var5, "properties", "app_uid=? AND cid<>?", var6);
      }

      if(var7 > 0) {
         this.zza("Deleted property records", Integer.valueOf(var7));
      }

   }

   public void zzb(zzh param1) {
      // $FF: Couldn't be decompiled
   }

   Map<String, String> zzbi(String param1) {
      // $FF: Couldn't be decompiled
   }

   Map<String, String> zzbj(String var1) {
      if(TextUtils.isEmpty(var1)) {
         return new HashMap(0);
      } else {
         try {
            Map var3 = zzmz.zza(new URI("?" + var1), "UTF-8");
            return var3;
         } catch (URISyntaxException var4) {
            this.zze("Error parsing property parameters", var4);
            return new HashMap(0);
         }
      }
   }

   public void zzc(zzab param1) {
      // $FF: Couldn't be decompiled
   }

   protected void zziJ() {
   }

   public long zzjG() {
      this.zzjk();
      this.zzjv();
      return this.zzb("SELECT COUNT(*) FROM hits2", (String[])null);
   }

   public int zzjN() {
      this.zzjk();
      this.zzjv();
      if(!this.zzQU.zzv(86400000L)) {
         return 0;
      } else {
         this.zzQU.start();
         this.zzbd("Deleting stale hits (if any)");
         SQLiteDatabase var1 = this.getWritableDatabase();
         long var2 = this.zzjl().currentTimeMillis() - 2592000000L;
         String[] var4 = new String[]{Long.toString(var2)};
         int var5;
         if(!(var1 instanceof SQLiteDatabase)) {
            var5 = var1.delete("hits2", "hit_time < ?", var4);
         } else {
            var5 = SQLiteInstrumentation.delete((SQLiteDatabase)var1, "hits2", "hit_time < ?", var4);
         }

         this.zza("Deleted stale hits, count", Integer.valueOf(var5));
         return var5;
      }
   }

   public long zzjO() {
      this.zzjk();
      this.zzjv();
      return this.zza(zzQS, (String[])null, 0L);
   }

   public List<Long> zzo(long param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzo(List<Long> param1) {
      // $FF: Couldn't be decompiled
   }

   public List<zzab> zzp(long param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzq(long var1) {
      this.zzjk();
      this.zzjv();
      ArrayList var3 = new ArrayList(1);
      var3.add(Long.valueOf(var1));
      this.zza("Deleting hit, id", Long.valueOf(var1));
      this.zzo(var3);
   }

   public List<zzh> zzr(long param1) {
      // $FF: Couldn't be decompiled
   }

   class zza extends SQLiteOpenHelper {
      zza(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      private void zza(SQLiteDatabase var1) {
         byte var2 = 1;
         Set var3 = this.zzb(var1, "hits2");
         String[] var4 = new String[4];
         var4[0] = "hit_id";
         var4[var2] = "hit_string";
         var4[2] = "hit_time";
         var4[3] = "hit_url";
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            String var7 = var4[var6];
            if(!var3.remove(var7)) {
               throw new SQLiteException("Database hits2 is missing required column: " + var7);
            }
         }

         if(var3.remove("hit_app_id")) {
            var2 = 0;
         }

         if(!var3.isEmpty()) {
            throw new SQLiteException("Database hits2 has extra columns");
         } else {
            if(var2 != 0) {
               if(var1 instanceof SQLiteDatabase) {
                  SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, "ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
                  return;
               }

               var1.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }

         }
      }

      private boolean zza(SQLiteDatabase param1, String param2) {
         // $FF: Couldn't be decompiled
      }

      private Set<String> zzb(SQLiteDatabase param1, String param2) {
         // $FF: Couldn't be decompiled
      }

      private void zzb(SQLiteDatabase var1) {
         int var2 = 0;
         Set var3 = this.zzb(var1, "properties");
         String[] var4 = new String[]{"app_uid", "cid", "tid", "params", "adid", "hits_count"};

         for(int var5 = var4.length; var2 < var5; ++var2) {
            String var6 = var4[var2];
            if(!var3.remove(var6)) {
               throw new SQLiteException("Database properties is missing required column: " + var6);
            }
         }

         if(!var3.isEmpty()) {
            throw new SQLiteException("Database properties table has extra columns");
         }
      }

      public SQLiteDatabase getWritableDatabase() {
         if(!zzj.this.zzQV.zzv(3600000L)) {
            throw new SQLiteException("Database open failed");
         } else {
            try {
               SQLiteDatabase var6 = super.getWritableDatabase();
               return var6;
            } catch (SQLiteException var8) {
               zzj.this.zzQV.start();
               zzj.this.zzbh("Opening the database failed, dropping the table and recreating it");
               String var2 = zzj.this.zzjQ();
               zzj.this.getContext().getDatabasePath(var2).delete();

               try {
                  SQLiteDatabase var5 = super.getWritableDatabase();
                  zzj.this.zzQV.clear();
                  return var5;
               } catch (SQLiteException var7) {
                  zzj.this.zze("Failed to open freshly created database", var7);
                  throw var7;
               }
            }
         }
      }

      public void onCreate(SQLiteDatabase var1) {
         zzx.zzbo(var1.getPath());
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

         if(!this.zza(var1, "hits2")) {
            String var2 = zzj.zzQR;
            if(!(var1 instanceof SQLiteDatabase)) {
               var1.execSQL(var2);
            } else {
               SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, var2);
            }
         } else {
            this.zza(var1);
         }

         if(!this.zza(var1, "properties")) {
            if(!(var1 instanceof SQLiteDatabase)) {
               var1.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            } else {
               SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, "CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            }
         } else {
            this.zzb(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }
}
