package com.google.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Clock;
import com.google.tagmanager.Dispatcher;
import com.google.tagmanager.FutureApis;
import com.google.tagmanager.Hit;
import com.google.tagmanager.HitStore;
import com.google.tagmanager.HitStoreStateListener;
import com.google.tagmanager.Log;
import com.google.tagmanager.ServiceManagerImpl;
import com.google.tagmanager.SimpleNetworkDispatcher;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentHitStore implements HitStore {
    private static final String CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL,\'%s\' INTEGER NOT NULL);", new Object[] {"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    private static final String DATABASE_FILENAME = "gtm_urls.db";
    @VisibleForTesting
    static final String HITS_TABLE = "gtm_hits";
    static final long HIT_DISPATCH_RETRY_WINDOW = 14400000L;
    @VisibleForTesting
    static final String HIT_FIRST_DISPATCH_TIME = "hit_first_send_time";
    @VisibleForTesting
    static final String HIT_ID = "hit_id";
    private static final String HIT_ID_WHERE_CLAUSE = "hit_id=?";
    @VisibleForTesting
    static final String HIT_TIME = "hit_time";
    @VisibleForTesting
    static final String HIT_URL = "hit_url";
    private Clock mClock;
    private final Context mContext;
    private final String mDatabaseName;
    private final PersistentHitStore.UrlDatabaseHelper mDbHelper;
    private volatile Dispatcher mDispatcher;
    private long mLastDeleteStaleHitsTime;
    private final HitStoreStateListener mListener;

    PersistentHitStore(HitStoreStateListener var1, Context var2) {
        this(var1, var2, "gtm_urls.db");
    }

    @VisibleForTesting
    PersistentHitStore(HitStoreStateListener var1, Context var2, String var3) {
        this.mContext = var2.getApplicationContext();
        this.mDatabaseName = var3;
        this.mListener = var1;
        this.mClock = new Clock() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.mDbHelper = new PersistentHitStore.UrlDatabaseHelper(this.mContext, this.mDatabaseName);
        this.mDispatcher = new SimpleNetworkDispatcher(new DefaultHttpClient(), this.mContext, new PersistentHitStore.StoreDispatchListener());
        this.mLastDeleteStaleHitsTime = 0L;
    }

    // $FF: synthetic method
    static void access$200(PersistentHitStore var0, long var1, long var3) {
        var0.setHitFirstDispatchTime(var1, var3);
    }

    private void deleteHit(long var1) {
        String[] var3 = new String[] {String.valueOf(var1)};
        this.deleteHits(var3);
    }

    private SQLiteDatabase getWritableDatabase(String var1) {
        try {
            SQLiteDatabase var3 = this.mDbHelper.getWritableDatabase();
            return var3;
        } catch (SQLiteException var4) {
            Log.method_5509(var1);
            return null;
        }
    }

    private void removeOldHitIfFull() {
        int var1 = 1 + -2000 + this.getNumStoredHits();
        if(var1 > 0) {
            List var2 = this.peekHitIds(var1);
            Log.method_5507("Store full, deleting " + var2.size() + " hits to make room.");
            this.deleteHits((String[])var2.toArray(new String[0]));
        }

    }

    private void setHitFirstDispatchTime(long var1, long var3) {
        SQLiteDatabase var5 = this.getWritableDatabase("Error opening database for getNumStoredHits.");
        if(var5 != null) {
            ContentValues var6 = new ContentValues();
            var6.put("hit_first_send_time", Long.valueOf(var3));

            try {
                String[] var8 = new String[] {String.valueOf(var1)};
                var5.update("gtm_hits", var6, "hit_id=?", var8);
            } catch (SQLiteException var9) {
                Log.method_5509("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + var1);
                this.deleteHit(var1);
            }
        }
    }

    private void writeHitToDatabase(long var1, String var3) {
        SQLiteDatabase var4 = this.getWritableDatabase("Error opening database for putHit");
        if(var4 != null) {
            ContentValues var5 = new ContentValues();
            var5.put("hit_time", Long.valueOf(var1));
            var5.put("hit_url", var3);
            var5.put("hit_first_send_time", Integer.valueOf(0));

            try {
                var4.insert("gtm_hits", (String)null, var5);
                this.mListener.reportStoreIsEmpty(false);
            } catch (SQLiteException var7) {
                Log.method_5509("Error storing hit");
            }
        }
    }

    public void close() {
        try {
            this.mDbHelper.getWritableDatabase().close();
            this.mDispatcher.close();
        } catch (SQLiteException var2) {
            Log.method_5509("Error opening database for close");
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
                int var8 = var4.delete("gtm_hits", "HIT_TIME < ?", var7);
                HitStoreStateListener var9 = this.mListener;
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
        Log.method_5507("GTM Dispatch running...");
        if(this.mDispatcher.okToDispatch()) {
            List var1 = this.peekHits(40);
            if(var1.isEmpty()) {
                Log.method_5507("...nothing to dispatch");
                this.mListener.reportStoreIsEmpty(true);
                return;
            }

            this.mDispatcher.dispatchHits(var1);
            if(this.getNumStoredUntriedHits() > 0) {
                ServiceManagerImpl.getInstance().dispatch();
                return;
            }
        }

    }

    @VisibleForTesting
    public PersistentHitStore.UrlDatabaseHelper getDbHelper() {
        return this.mDbHelper;
    }

    public Dispatcher getDispatcher() {
        return this.mDispatcher;
    }

    @VisibleForTesting
    PersistentHitStore.UrlDatabaseHelper getHelper() {
        return this.mDbHelper;
    }

    int getNumStoredHits() {
        // $FF: Couldn't be decompiled
    }

    int getNumStoredUntriedHits() {
        SQLiteDatabase var1 = this.getWritableDatabase("Error opening database for getNumStoredHits.");
        if(var1 == null) {
            return 0;
        } else {
            Cursor var2 = null;
            boolean var9 = false;

            int var5;
            int var6;
            label83: {
                try {
                    var9 = true;
                    var2 = var1.query("gtm_hits", new String[] {"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", (String[])null, (String)null, (String)null, (String)null);
                    var6 = var2.getCount();
                    var9 = false;
                    break label83;
                } catch (SQLiteException var10) {
                    Log.method_5509("Error getting num untried hits");
                    var9 = false;
                } finally {
                    if(var9) {
                        if(var2 != null) {
                            var2.close();
                        }

                    }
                }

                var5 = 0;
                if(var2 != null) {
                    var2.close();
                    var5 = 0;
                }

                return var5;
            }

            var5 = var6;
            if(var2 != null) {
                var2.close();
            }

            return var5;
        }
    }

    List<String> peekHitIds(int param1) {
        // $FF: Couldn't be decompiled
    }

    public List<Hit> peekHits(int param1) {
        // $FF: Couldn't be decompiled
    }

    public void putHit(long var1, String var3) {
        this.deleteStaleHits();
        this.removeOldHitIfFull();
        this.writeHitToDatabase(var1, var3);
    }

    @VisibleForTesting
    public void setClock(Clock var1) {
        this.mClock = var1;
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
    class StoreDispatchListener implements SimpleNetworkDispatcher.DispatchListener {
        public void onHitDispatched(Hit var1) {
            PersistentHitStore.this.deleteHit(var1.getHitId());
        }

        public void onHitPermanentDispatchFailure(Hit var1) {
            PersistentHitStore.this.deleteHit(var1.getHitId());
            Log.method_5507("Permanent failure dispatching hitId: " + var1.getHitId());
        }

        public void onHitTransientDispatchFailure(Hit var1) {
            long var2 = var1.getHitFirstDispatchTime();
            if(var2 == 0L) {
                PersistentHitStore.access$200(PersistentHitStore.this, var1.getHitId(), PersistentHitStore.this.mClock.currentTimeMillis());
            } else if(14400000L + var2 < PersistentHitStore.this.mClock.currentTimeMillis()) {
                PersistentHitStore.this.deleteHit(var1.getHitId());
                Log.method_5507("Giving up on failed hitId: " + var1.getHitId());
                return;
            }

        }
    }

    @VisibleForTesting
    class UrlDatabaseHelper extends SQLiteOpenHelper {
        private boolean mBadDatabase;
        private long mLastDatabaseCheckTime = 0L;

        UrlDatabaseHelper(Context var2, String var3) {
            super(var2, var3, (CursorFactory)null, 1);
        }

        private boolean tablePresent(String var1, SQLiteDatabase var2) {
            Cursor var3 = null;

            try {
                var3 = var2.query("SQLITE_MASTER", new String[] {"name"}, "name=?", new String[] {var1}, (String)null, (String)null, (String)null);
                boolean var6 = var3.moveToFirst();
                return var6;
            } catch (SQLiteException var9) {
                Log.method_5509("Error querying for table " + var1);
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
            if(this.mBadDatabase && 3600000L + this.mLastDatabaseCheckTime > PersistentHitStore.this.mClock.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            } else {
                this.mBadDatabase = true;
                this.mLastDatabaseCheckTime = PersistentHitStore.this.mClock.currentTimeMillis();

                SQLiteDatabase var3;
                label21: {
                    SQLiteDatabase var4;
                    try {
                        var4 = super.getWritableDatabase();
                    } catch (SQLiteException var5) {
                        PersistentHitStore.this.mContext.getDatabasePath(PersistentHitStore.this.mDatabaseName).delete();
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

            if(!this.tablePresent("gtm_hits", var1)) {
                var1.execSQL(PersistentHitStore.CREATE_HITS_TABLE);
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
