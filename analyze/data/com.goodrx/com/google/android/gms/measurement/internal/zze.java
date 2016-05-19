package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.util.Pair;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.measurement.internal.zza;
import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzh;
import com.google.android.gms.measurement.internal.zzi;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class zze extends zzz {
   private static final Map<String, String> zzaVB = new ArrayMap(13);
   private final zze.zzc zzaVC;
   private final zzaf zzaVD = new zzaf(this.zzjl());

   static {
      zzaVB.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
      zzaVB.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
      zzaVB.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
      zzaVB.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
      zzaVB.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
      zzaVB.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
      zzaVB.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
      zzaVB.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
      zzaVB.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
      zzaVB.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
      zzaVB.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
      zzaVB.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
      zzaVB.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
   }

   zze(zzw var1) {
      super(var1);
      String var2 = this.zzjQ();
      this.zzaVC = new zze.zzc(this.getContext(), var2);
   }

   private boolean zzCw() {
      return this.getContext().getDatabasePath(this.zzjQ()).exists();
   }

   @TargetApi(11)
   @WorkerThread
   static int zza(Cursor var0, int var1) {
      if(VERSION.SDK_INT >= 11) {
         return var0.getType(var1);
      } else {
         CursorWindow var2 = ((SQLiteCursor)var0).getWindow();
         int var3 = var0.getPosition();
         return var2.isNull(var3, var1)?0:(var2.isLong(var3, var1)?1:(var2.isFloat(var3, var1)?2:(var2.isString(var3, var1)?3:(var2.isBlob(var3, var1)?4:-1))));
      }
   }

   @WorkerThread
   private long zza(String param1, String[] param2, long param3) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   private void zza(String var1, zzpz.zza var2) {
      this.zzjv();
      this.zzjk();
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      com.google.android.gms.common.internal.zzx.zzz(var2);
      com.google.android.gms.common.internal.zzx.zzz(var2.zzaZt);
      com.google.android.gms.common.internal.zzx.zzz(var2.zzaZs);
      if(var2.zzaZr == null) {
         this.zzAo().zzCF().zzfg("Audience with no ID");
      } else {
         int var7 = var2.zzaZr.intValue();
         zzpz.zzb[] var8 = var2.zzaZt;
         int var9 = var8.length;

         for(int var10 = 0; var10 < var9; ++var10) {
            if(var8[var10].zzaZv == null) {
               this.zzAo().zzCF().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", var1, var2.zzaZr);
               return;
            }
         }

         zzpz.zze[] var11 = var2.zzaZs;
         int var12 = var11.length;

         for(int var13 = 0; var13 < var12; ++var13) {
            if(var11[var13].zzaZv == null) {
               this.zzAo().zzCF().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", var1, var2.zzaZr);
               return;
            }
         }

         boolean var14 = true;
         zzpz.zzb[] var15 = var2.zzaZt;
         int var16 = var15.length;

         for(int var17 = 0; var17 < var16; ++var17) {
            if(!this.zza(var1, var7, var15[var17])) {
               var14 = false;
               break;
            }
         }

         boolean var18;
         label44: {
            if(var14) {
               zzpz.zze[] var19 = var2.zzaZs;
               int var20 = var19.length;

               for(int var21 = 0; var21 < var20; ++var21) {
                  boolean var22 = this.zza(var1, var7, var19[var21]);
                  var18 = false;
                  if(!var22) {
                     break label44;
                  }
               }
            }

            var18 = var14;
         }

         if(!var18) {
            this.zzB(var1, var7);
            return;
         }
      }

   }

   @WorkerThread
   private boolean zza(String param1, int param2, zzpz.zzb param3) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   private boolean zza(String param1, int param2, zzpz.zze param3) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   private long zzb(String param1, String[] param2) {
      // $FF: Couldn't be decompiled
   }

   private String zzjQ() {
      if(!this.zzCp().zzkr()) {
         return this.zzCp().zzkR();
      } else if(this.zzCp().zzks()) {
         return this.zzCp().zzkR();
      } else {
         this.zzAo().zzCG().zzfg("Using secondary database");
         return this.zzCp().zzkS();
      }
   }

   @WorkerThread
   public void beginTransaction() {
      this.zzjv();
      this.getWritableDatabase().beginTransaction();
   }

   @WorkerThread
   public void endTransaction() {
      this.zzjv();
      this.getWritableDatabase().endTransaction();
   }

   @WorkerThread
   SQLiteDatabase getWritableDatabase() {
      this.zzjk();

      try {
         SQLiteDatabase var2 = this.zzaVC.getWritableDatabase();
         return var2;
      } catch (SQLiteException var3) {
         this.zzAo().zzCF().zzj("Error opening database", var3);
         throw var3;
      }
   }

   @WorkerThread
   public void setTransactionSuccessful() {
      this.zzjv();
      this.getWritableDatabase().setTransactionSuccessful();
   }

   @WorkerThread
   public void zzA(String var1, int var2) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      this.zzjk();
      this.zzjv();

      try {
         SQLiteDatabase var5 = this.getWritableDatabase();
         String[] var6 = new String[]{var1, var1, String.valueOf(var2)};
         if(!(var5 instanceof SQLiteDatabase)) {
            var5.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like \'_ltv_%\' order by set_timestamp desc limit ?,10);", var6);
         } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)var5, "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like \'_ltv_%\' order by set_timestamp desc limit ?,10);", var6);
         }
      } catch (SQLiteException var7) {
         this.zzAo().zzCE().zze("Error pruning currencies", var1, var7);
      }
   }

   void zzB(String var1, int var2) {
      this.zzjv();
      this.zzjk();
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      SQLiteDatabase var4 = this.getWritableDatabase();
      String[] var5 = new String[]{var1, String.valueOf(var2)};
      if(!(var4 instanceof SQLiteDatabase)) {
         var4.delete("property_filters", "app_id=? and audience_id=?", var5);
      } else {
         SQLiteInstrumentation.delete((SQLiteDatabase)var4, "property_filters", "app_id=? and audience_id=?", var5);
      }

      String[] var7 = new String[]{var1, String.valueOf(var2)};
      if(!(var4 instanceof SQLiteDatabase)) {
         var4.delete("event_filters", "app_id=? and audience_id=?", var7);
      } else {
         SQLiteInstrumentation.delete((SQLiteDatabase)var4, "event_filters", "app_id=? and audience_id=?", var7);
      }
   }

   zzqb.zzf zzC(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public String zzCq() {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   void zzCr() {
      this.zzjk();
      this.zzjv();
      if(this.zzCw()) {
         long var1 = this.zzCo().zzaXm.get();
         long var3 = this.zzjl().elapsedRealtime();
         if(Math.abs(var3 - var1) > this.zzCp().zzBR()) {
            this.zzCo().zzaXm.set(var3);
            this.zzCs();
            return;
         }
      }

   }

   @WorkerThread
   void zzCs() {
      this.zzjk();
      this.zzjv();
      if(this.zzCw()) {
         SQLiteDatabase var1 = this.getWritableDatabase();
         String[] var2 = new String[]{String.valueOf(this.zzjl().currentTimeMillis()), String.valueOf(this.zzCp().zzBQ())};
         int var3;
         if(!(var1 instanceof SQLiteDatabase)) {
            var3 = var1.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", var2);
         } else {
            var3 = SQLiteInstrumentation.delete((SQLiteDatabase)var1, "queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", var2);
         }

         if(var3 > 0) {
            this.zzAo().zzCK().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(var3));
            return;
         }
      }

   }

   @WorkerThread
   public long zzCt() {
      return this.zza("select max(bundle_end_timestamp) from queue", (String[])null, 0L);
   }

   @WorkerThread
   public long zzCu() {
      return this.zza("select max(timestamp) from raw_events", (String[])null, 0L);
   }

   public boolean zzCv() {
      return this.zzb("select count(1) > 0 from raw_events", (String[])null) != 0L;
   }

   @WorkerThread
   public zzi zzI(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public void zzJ(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public zzai zzK(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   Map<Integer, List<zzpz.zzb>> zzL(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   Map<Integer, List<zzpz.zze>> zzM(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public void zzZ(long var1) {
      this.zzjk();
      this.zzjv();
      SQLiteDatabase var3 = this.getWritableDatabase();
      String[] var4 = new String[]{String.valueOf(var1)};
      int var5;
      if(!(var3 instanceof SQLiteDatabase)) {
         var5 = var3.delete("queue", "rowid=?", var4);
      } else {
         var5 = SQLiteInstrumentation.delete((SQLiteDatabase)var3, "queue", "rowid=?", var4);
      }

      if(var5 != 1) {
         this.zzAo().zzCE().zzfg("Deleted fewer rows from queue than expected");
      }

   }

   @WorkerThread
   public zze.zza zza(long param1, String param3, boolean param4, boolean param5) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   void zza(ContentValues var1, String var2, Object var3) {
      com.google.android.gms.common.internal.zzx.zzcM(var2);
      com.google.android.gms.common.internal.zzx.zzz(var3);
      if(var3 instanceof String) {
         var1.put(var2, (String)var3);
      } else if(var3 instanceof Long) {
         var1.put(var2, (Long)var3);
      } else if(var3 instanceof Float) {
         var1.put(var2, (Float)var3);
      } else {
         throw new IllegalArgumentException("Invalid value type");
      }
   }

   @WorkerThread
   public void zza(zzqb.zze param1) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public void zza(zza param1) {
      // $FF: Couldn't be decompiled
   }

   public void zza(zzh param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public void zza(zzi param1) {
      // $FF: Couldn't be decompiled
   }

   void zza(String param1, int param2, zzqb.zzf param3) {
      // $FF: Couldn't be decompiled
   }

   public void zza(String param1, long param2, zze.zzb param4) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public boolean zza(zzai param1) {
      // $FF: Couldn't be decompiled
   }

   public String zzaa(long param1) {
      // $FF: Couldn't be decompiled
   }

   public long zzb(zzqb.zze var1) throws IOException {
      this.zzjk();
      this.zzjv();
      com.google.android.gms.common.internal.zzx.zzz(var1);
      com.google.android.gms.common.internal.zzx.zzcM(var1.appId);

      byte[] var5;
      try {
         var5 = new byte[var1.getSerializedSize()];
         zzsn var6 = zzsn.zzE(var5);
         var1.writeTo(var6);
         var6.zzJo();
      } catch (IOException var13) {
         this.zzAo().zzCE().zzj("Data loss. Failed to serialize event metadata", var13);
         throw var13;
      }

      long var7 = this.zzCk().zzr(var5);
      ContentValues var9 = new ContentValues();
      var9.put("app_id", var1.appId);
      var9.put("metadata_fingerprint", Long.valueOf(var7));
      var9.put("metadata", var5);

      try {
         SQLiteDatabase var11 = this.getWritableDatabase();
         if(!(var11 instanceof SQLiteDatabase)) {
            var11.insertWithOnConflict("raw_events_metadata", (String)null, var9, 4);
            return var7;
         } else {
            SQLiteInstrumentation.insertWithOnConflict((SQLiteDatabase)var11, "raw_events_metadata", (String)null, var9, 4);
            return var7;
         }
      } catch (SQLiteException var12) {
         this.zzAo().zzCE().zzj("Error storing raw event metadata", var12);
         throw var12;
      }
   }

   @WorkerThread
   Object zzb(Cursor var1, int var2) {
      int var3 = zza(var1, var2);
      switch(var3) {
      case 0:
         this.zzAo().zzCE().zzfg("Loaded invalid null value from database");
         return null;
      case 1:
         return Long.valueOf(var1.getLong(var2));
      case 2:
         return Float.valueOf(var1.getFloat(var2));
      case 3:
         return var1.getString(var2);
      case 4:
         this.zzAo().zzCE().zzfg("Loaded invalid blob type value, ignoring it");
         return null;
      default:
         this.zzAo().zzCE().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(var3));
         return null;
      }
   }

   @WorkerThread
   void zzb(String param1, zzpz.zza[] param2) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public void zzd(String param1, byte[] param2) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public List<zzai> zzeX(String param1) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public zza zzeY(String param1) {
      // $FF: Couldn't be decompiled
   }

   public long zzeZ(String var1) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      this.zzjk();
      this.zzjv();

      int var6;
      int var7;
      try {
         SQLiteDatabase var4 = this.getWritableDatabase();
         String[] var5 = new String[]{var1, String.valueOf(this.zzCp().zzeW(var1))};
         if(!(var4 instanceof SQLiteDatabase)) {
            var7 = var4.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", var5);
            return (long)var7;
         }

         var6 = SQLiteInstrumentation.delete((SQLiteDatabase)var4, "raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", var5);
      } catch (SQLiteException var8) {
         this.zzAo().zzCE().zzj("Error deleting over the limit events", var8);
         return 0L;
      }

      var7 = var6;
      return (long)var7;
   }

   @WorkerThread
   public byte[] zzfa(String param1) {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   void zzfb(String var1) {
      this.zzjv();
      this.zzjk();
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      SQLiteDatabase var3 = this.getWritableDatabase();
      String[] var4 = new String[]{var1};
      if(!(var3 instanceof SQLiteDatabase)) {
         var3.delete("property_filters", "app_id=?", var4);
      } else {
         SQLiteInstrumentation.delete((SQLiteDatabase)var3, "property_filters", "app_id=?", var4);
      }

      String[] var6 = new String[]{var1};
      if(!(var3 instanceof SQLiteDatabase)) {
         var3.delete("event_filters", "app_id=?", var6);
      } else {
         SQLiteInstrumentation.delete((SQLiteDatabase)var3, "event_filters", "app_id=?", var6);
      }
   }

   public void zzfc(String var1) {
      SQLiteDatabase var2 = this.getWritableDatabase();

      try {
         String[] var3 = new String[]{var1, var1};
         if(!(var2 instanceof SQLiteDatabase)) {
            var2.execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", var3);
         } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)var2, "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", var3);
         }
      } catch (SQLiteException var5) {
         this.zzAo().zzCE().zzj("Failed to remove unused event metadata", var5);
      }
   }

   public long zzfd(String var1) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      return this.zza("select count(1) from events where app_id=? and name not like \'!_%\' escape \'!\'", new String[]{var1}, 0L);
   }

   protected void zziJ() {
   }

   @WorkerThread
   public List<Pair<zzqb.zze, Long>> zzn(String param1, int param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   public void zzz(List<Long> var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzjk();
      this.zzjv();
      StringBuilder var3 = new StringBuilder("rowid in (");

      for(int var4 = 0; var4 < var1.size(); ++var4) {
         if(var4 != 0) {
            var3.append(",");
         }

         var3.append(((Long)var1.get(var4)).longValue());
      }

      var3.append(")");
      SQLiteDatabase var6 = this.getWritableDatabase();
      String var7 = var3.toString();
      int var8;
      if(!(var6 instanceof SQLiteDatabase)) {
         var8 = var6.delete("raw_events", var7, (String[])null);
      } else {
         var8 = SQLiteInstrumentation.delete((SQLiteDatabase)var6, "raw_events", var7, (String[])null);
      }

      if(var8 != var1.size()) {
         this.zzAo().zzCE().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(var8), Integer.valueOf(var1.size()));
      }

   }

   public static class zza {
      long zzaVE;
      long zzaVF;
      long zzaVG;
   }

   interface zzb {
      boolean zza(long var1, zzqb.zzb var3);

      void zzc(zzqb.zze var1);
   }

   private class zzc extends SQLiteOpenHelper {
      zzc(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      @WorkerThread
      private void zza(SQLiteDatabase var1, String var2, String var3, String var4, Map<String, String> var5) throws SQLiteException {
         if(!this.zza(var1, var2)) {
            if(!(var1 instanceof SQLiteDatabase)) {
               var1.execSQL(var3);
            } else {
               SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, var3);
            }
         }

         try {
            this.zza(var1, var2, var4, var5);
         } catch (SQLiteException var7) {
            zze.this.zzAo().zzCE().zzj("Failed to verify columns on table that was just created", var2);
            throw var7;
         }
      }

      @WorkerThread
      private void zza(SQLiteDatabase var1, String var2, String var3, Map<String, String> var4) throws SQLiteException {
         Set var5 = this.zzb(var1, var2);
         String[] var6 = var3.split(",");
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            String var12 = var6[var8];
            if(!var5.remove(var12)) {
               throw new SQLiteException("Table " + var2 + " is missing required column: " + var12);
            }
         }

         if(var4 != null) {
            Iterator var9 = var4.entrySet().iterator();

            while(var9.hasNext()) {
               Entry var10 = (Entry)var9.next();
               if(!var5.remove(var10.getKey())) {
                  String var11 = (String)var10.getValue();
                  if(!(var1 instanceof SQLiteDatabase)) {
                     var1.execSQL(var11);
                  } else {
                     SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, var11);
                  }
               }
            }
         }

         if(!var5.isEmpty()) {
            throw new SQLiteException("Table " + var2 + " table has extra columns");
         }
      }

      @WorkerThread
      private boolean zza(SQLiteDatabase param1, String param2) {
         // $FF: Couldn't be decompiled
      }

      @WorkerThread
      private Set<String> zzb(SQLiteDatabase var1, String var2) {
         HashSet var3 = new HashSet();
         String var4 = "SELECT * FROM " + var2 + " LIMIT 0";
         Cursor var5;
         if(!(var1 instanceof SQLiteDatabase)) {
            var5 = var1.rawQuery(var4, (String[])null);
         } else {
            var5 = SQLiteInstrumentation.rawQuery((SQLiteDatabase)var1, var4, (String[])null);
         }

         try {
            Collections.addAll(var3, var5.getColumnNames());
         } finally {
            var5.close();
         }

         return var3;
      }

      @WorkerThread
      public SQLiteDatabase getWritableDatabase() {
         if(!zze.this.zzaVD.zzv(zze.this.zzCp().zzBN())) {
            throw new SQLiteException("Database open failed");
         } else {
            try {
               SQLiteDatabase var6 = super.getWritableDatabase();
               return var6;
            } catch (SQLiteException var8) {
               zze.this.zzaVD.start();
               zze.this.zzAo().zzCE().zzfg("Opening the database failed, dropping and recreating it");
               String var2 = zze.this.zzjQ();
               zze.this.getContext().getDatabasePath(var2).delete();

               try {
                  SQLiteDatabase var5 = super.getWritableDatabase();
                  zze.this.zzaVD.clear();
                  return var5;
               } catch (SQLiteException var7) {
                  zze.this.zzAo().zzCE().zzj("Failed to open freshly created database", var7);
                  throw var7;
               }
            }
         }
      }

      @WorkerThread
      public void onCreate(SQLiteDatabase var1) {
         if(VERSION.SDK_INT >= 9) {
            File var2 = new File(var1.getPath());
            var2.setReadable(false, false);
            var2.setWritable(false, false);
            var2.setReadable(true, true);
            var2.setWritable(true, true);
         }

      }

      @WorkerThread
      public void onOpen(SQLiteDatabase var1) {
         if(VERSION.SDK_INT < 15) {
            Cursor var2;
            if(!(var1 instanceof SQLiteDatabase)) {
               var2 = var1.rawQuery("PRAGMA journal_mode=memory", (String[])null);
            } else {
               var2 = SQLiteInstrumentation.rawQuery((SQLiteDatabase)var1, "PRAGMA journal_mode=memory", (String[])null);
            }

            try {
               var2.moveToFirst();
            } finally {
               var2.close();
            }
         }

         this.zza(var1, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", (Map)null);
         this.zza(var1, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", (Map)null);
         this.zza(var1, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.zzaVB);
         this.zza(var1, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", (Map)null);
         this.zza(var1, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", (Map)null);
         this.zza(var1, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", (Map)null);
         this.zza(var1, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", (Map)null);
         this.zza(var1, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", (Map)null);
         this.zza(var1, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", (Map)null);
      }

      @WorkerThread
      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }
}
