package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.analytics.tracking.android.AnalyticsStore;
import com.google.analytics.tracking.android.AnalyticsStoreStateListener;
import com.google.analytics.tracking.android.Clock;
import com.google.analytics.tracking.android.Dispatcher;
import com.google.analytics.tracking.android.FutureApis;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.Hit;
import com.google.analytics.tracking.android.HitBuilder;
import com.google.analytics.tracking.android.Log;
import com.google.analytics.tracking.android.NoopDispatcher;
import com.google.analytics.tracking.android.SimpleNetworkDispatcher;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentAnalyticsStore implements AnalyticsStore {
    private static final String CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' INTEGER);", new Object[] {"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String DATABASE_FILENAME = "google_analytics_v2.db";
    @VisibleForTesting
    static final String HITS_TABLE = "hits2";
    @VisibleForTesting
    static final String HIT_APP_ID = "hit_app_id";
    @VisibleForTesting
    static final String HIT_ID = "hit_id";
    @VisibleForTesting
    static final String HIT_STRING = "hit_string";
    @VisibleForTesting
    static final String HIT_TIME = "hit_time";
    @VisibleForTesting
    static final String HIT_URL = "hit_url";
    private Clock mClock;
    private final Context mContext;
    private final String mDatabaseName;
    private final PersistentAnalyticsStore.AnalyticsDatabaseHelper mDbHelper;
    private volatile Dispatcher mDispatcher;
    private long mLastDeleteStaleHitsTime;
    private final AnalyticsStoreStateListener mListener;

    PersistentAnalyticsStore(AnalyticsStoreStateListener var1, Context var2) {
        this(var1, var2, "google_analytics_v2.db");
    }

    @VisibleForTesting
    PersistentAnalyticsStore(AnalyticsStoreStateListener var1, Context var2, String var3) {
        this.mContext = var2.getApplicationContext();
        this.mDatabaseName = var3;
        this.mListener = var1;
        this.mClock = new Clock() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.mDbHelper = new PersistentAnalyticsStore.AnalyticsDatabaseHelper(this.mContext, this.mDatabaseName);
        this.mDispatcher = new SimpleNetworkDispatcher(new DefaultHttpClient(), this.mContext);
        this.mLastDeleteStaleHitsTime = 0L;
    }

    private void fillVersionParameter(Map<String, String> var1, Collection<Command> var2) {
        String var3 = "&_v".substring(1);
        if(var2 != null) {
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
                Command var5 = (Command)var4.next();
                if("appendVersion".equals(var5.getId())) {
                    var1.put(var3, var5.getValue());
                    break;
                }
            }
        }

    }

    static String generateHitString(Map<String, String> var0) {
        ArrayList var1 = new ArrayList(var0.size());
        Iterator var2 = var0.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.add(HitBuilder.encode((String)var3.getKey()) + "=" + HitBuilder.encode((String)var3.getValue()));
        }

        return TextUtils.join("&", var1);
    }

    private SQLiteDatabase getWritableDatabase(String var1) {
        try {
            SQLiteDatabase var3 = this.mDbHelper.getWritableDatabase();
            return var3;
        } catch (SQLiteException var4) {
            Log.method_2107(var1);
            return null;
        }
    }

    private void removeOldHitIfFull() {
        int var1 = 1 + -2000 + this.getNumStoredHits();
        if(var1 > 0) {
            List var2 = this.peekHitIds(var1);
            Log.method_2106("Store full, deleting " + var2.size() + " hits to make room.");
            this.deleteHits((String[])var2.toArray(new String[0]));
        }

    }

    private void writeHitToDatabase(Map<String, String> var1, long var2, String var4) {
        SQLiteDatabase var5 = this.getWritableDatabase("Error opening database for putHit");
        if(var5 != null) {
            ContentValues var6 = new ContentValues();
            var6.put("hit_string", generateHitString(var1));
            var6.put("hit_time", Long.valueOf(var2));
            long var7 = 0L;
            if(var1.containsKey("AppUID")) {
                label30: {
                    long var13;
                    try {
                        var13 = Long.parseLong((String)var1.get("AppUID"));
                    } catch (NumberFormatException var16) {
                        break label30;
                    }

                    var7 = var13;
                }
            }

            var6.put("hit_app_id", Long.valueOf(var7));
            if(var4 == null) {
                var4 = "http://www.google-analytics.com/collect";
            }

            if(var4.length() == 0) {
                Log.method_2107("Empty path: not sending hit");
            } else {
                var6.put("hit_url", var4);

                try {
                    var5.insert("hits2", (String)null, var6);
                    this.mListener.reportStoreIsEmpty(false);
                } catch (SQLiteException var15) {
                    Log.method_2107("Error storing hit");
                }
            }
        }
    }

    public void clearHits(long var1) {
        byte var3 = 1;
        SQLiteDatabase var4 = this.getWritableDatabase("Error opening database for clearHits");
        if(var4 != null) {
            if(var1 == 0L) {
                var4.delete("hits2", (String)null, (String[])null);
            } else {
                String[] var5 = new String[var3];
                var5[0] = Long.valueOf(var1).toString();
                var4.delete("hits2", "hit_app_id = ?", var5);
            }

            AnalyticsStoreStateListener var7 = this.mListener;
            if(this.getNumStoredHits() != 0) {
                var3 = 0;
            }

            var7.reportStoreIsEmpty((boolean)var3);
        }

    }

    public void close() {
        try {
            this.mDbHelper.getWritableDatabase().close();
            this.mDispatcher.close();
        } catch (SQLiteException var2) {
            Log.method_2107("Error opening database for close");
        }
    }

    @Deprecated
    void deleteHits(Collection<Hit> var1) {
        if(var1 != null && !var1.isEmpty()) {
            String[] var2 = new String[var1.size()];
            int var3 = 0;

            int var6;
            for(Iterator var4 = var1.iterator(); var4.hasNext(); var3 = var6) {
                Hit var5 = (Hit)var4.next();
                var6 = var3 + 1;
                var2[var3] = String.valueOf(var5.getHitId());
            }

            this.deleteHits(var2);
        } else {
            Log.method_2107("Empty/Null collection passed to deleteHits.");
        }
    }

    void deleteHits(String[] param1) {
        // $FF: Couldn't be decompiled
    }

    int deleteStaleHits() {
        byte var1 = 1;
        long var2 = this.mClock.currentTimeMillis();
        if(var2 > 86400000L + this.mLastDeleteStaleHitsTime) {
            this.mLastDeleteStaleHitsTime = var2;
            SQLiteDatabase var4 = this.getWritableDatabase("Error opening database for deleteStaleHits.");
            if(var4 != null) {
                long var5 = this.mClock.currentTimeMillis() - 2592000000L;
                String[] var7 = new String[var1];
                var7[0] = Long.toString(var5);
                int var8 = var4.delete("hits2", "HIT_TIME < ?", var7);
                AnalyticsStoreStateListener var9 = this.mListener;
                if(this.getNumStoredHits() != 0) {
                    var1 = 0;
                }

                var9.reportStoreIsEmpty((boolean)var1);
                return var8;
            }
        }

        return 0;
    }

    public void dispatch() {
        Log.method_2106("Dispatch running...");
        if(this.mDispatcher.okToDispatch()) {
            List var1 = this.peekHits(40);
            if(var1.isEmpty()) {
                Log.method_2106("...nothing to dispatch");
                this.mListener.reportStoreIsEmpty(true);
                return;
            }

            int var2 = this.mDispatcher.dispatchHits(var1);
            Log.method_2106("sent " + var2 + " of " + var1.size() + " hits");
            this.deleteHits((Collection)var1.subList(0, Math.min(var2, var1.size())));
            if(var2 == var1.size() && this.getNumStoredHits() > 0) {
                GAServiceManager.getInstance().dispatchLocalHits();
                return;
            }
        }

    }

    @VisibleForTesting
    public PersistentAnalyticsStore.AnalyticsDatabaseHelper getDbHelper() {
        return this.mDbHelper;
    }

    public Dispatcher getDispatcher() {
        return this.mDispatcher;
    }

    @VisibleForTesting
    PersistentAnalyticsStore.AnalyticsDatabaseHelper getHelper() {
        return this.mDbHelper;
    }

    int getNumStoredHits() {
        // $FF: Couldn't be decompiled
    }

    List<String> peekHitIds(int param1) {
        // $FF: Couldn't be decompiled
    }

    public List<Hit> peekHits(int param1) {
        // $FF: Couldn't be decompiled
    }

    public void putHit(Map<String, String> var1, long var2, String var4, Collection<Command> var5) {
        this.deleteStaleHits();
        this.removeOldHitIfFull();
        this.fillVersionParameter(var1, var5);
        this.writeHitToDatabase(var1, var2, var4);
    }

    @VisibleForTesting
    public void setClock(Clock var1) {
        this.mClock = var1;
    }

    public void setDispatch(boolean var1) {
        Object var2;
        if(var1) {
            var2 = new SimpleNetworkDispatcher(new DefaultHttpClient(), this.mContext);
        } else {
            var2 = new NoopDispatcher();
        }

        this.mDispatcher = (Dispatcher)var2;
    }

    @VisibleForTesting
    void setDispatcher(Dispatcher var1) {
        this.mDispatcher = var1;
    }

    @VisibleForTesting
    void setLastDeleteStaleHitsTime(long var1) {
        this.mLastDeleteStaleHitsTime = var1;
    }

    @VisibleForTesting
    class AnalyticsDatabaseHelper extends SQLiteOpenHelper {
        private boolean mBadDatabase;
        private long mLastDatabaseCheckTime = 0L;

        AnalyticsDatabaseHelper(Context var2, String var3) {
            super(var2, var3, (CursorFactory)null, 1);
        }

        private boolean tablePresent(String var1, SQLiteDatabase var2) {
            Cursor var3 = null;

            try {
                var3 = var2.query("SQLITE_MASTER", new String[] {"name"}, "name=?", new String[] {var1}, (String)null, (String)null, (String)null);
                boolean var6 = var3.moveToFirst();
                return var6;
            } catch (SQLiteException var9) {
                Log.method_2107("Error querying for table " + var1);
            } finally {
                if(var3 != null) {
                    var3.close();
                }

            }

            return false;
        }

        private void validateColumnsPresent(SQLiteDatabase param1) {
            // $FF: Couldn't be decompiled
        }

        public SQLiteDatabase getWritableDatabase() {
            if(this.mBadDatabase && 3600000L + this.mLastDatabaseCheckTime > PersistentAnalyticsStore.this.mClock.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            } else {
                this.mBadDatabase = true;
                this.mLastDatabaseCheckTime = PersistentAnalyticsStore.this.mClock.currentTimeMillis();

                SQLiteDatabase var3;
                label21: {
                    SQLiteDatabase var4;
                    try {
                        var4 = super.getWritableDatabase();
                    } catch (SQLiteException var5) {
                        PersistentAnalyticsStore.this.mContext.getDatabasePath(PersistentAnalyticsStore.this.mDatabaseName).delete();
                        var3 = null;
                        break label21;
                    }

                    var3 = var4;
                }

                if(var3 == null) {
                    var3 = super.getWritableDatabase();
                }

                this.mBadDatabase = false;
                return var3;
            }
        }

        boolean isBadDatabase() {
            return this.mBadDatabase;
        }

        public void onCreate(SQLiteDatabase var1) {
            FutureApis.setOwnerOnlyReadWrite(var1.getPath());
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

            if(!this.tablePresent("hits2", var1)) {
                var1.execSQL(PersistentAnalyticsStore.CREATE_HITS_TABLE);
            } else {
                this.validateColumnsPresent(var1);
            }
        }

        public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
        }

        void setBadDatabase(boolean var1) {
            this.mBadDatabase = var1;
        }
    }
}
