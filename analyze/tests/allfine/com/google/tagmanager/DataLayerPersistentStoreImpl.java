package com.google.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Clock;
import com.google.tagmanager.DataLayer;
import com.google.tagmanager.FutureApis;
import com.google.tagmanager.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class DataLayerPersistentStoreImpl implements DataLayer.PersistentStore {
    private static final String CREATE_MAPS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' STRING NOT NULL, \'%s\' BLOB NOT NULL, \'%s\' INTEGER NOT NULL);", new Object[] {"datalayer", "ID", "key", "value", "expires"});
    private static final String DATABASE_NAME = "google_tagmanager.db";
    private static final String EXPIRE_FIELD = "expires";
    private static final String ID_FIELD = "ID";
    private static final String KEY_FIELD = "key";
    private static final String MAPS_TABLE = "datalayer";
    private static final int MAX_NUM_STORED_ITEMS = 2000;
    private static final String VALUE_FIELD = "value";
    private Clock mClock;
    private final Context mContext;
    private DataLayerPersistentStoreImpl.DatabaseHelper mDbHelper;
    private final Executor mExecutor;
    private int mMaxNumStoredItems;

    public DataLayerPersistentStoreImpl(Context var1) {
        this(var1, new Clock() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        }, "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    @VisibleForTesting
    DataLayerPersistentStoreImpl(Context var1, Clock var2, String var3, int var4, Executor var5) {
        this.mContext = var1;
        this.mClock = var2;
        this.mMaxNumStoredItems = var4;
        this.mExecutor = var5;
        this.mDbHelper = new DataLayerPersistentStoreImpl.DatabaseHelper(this.mContext, var3);
    }

    private void clearKeysWithPrefixSingleThreaded(String var1) {
        SQLiteDatabase var2 = this.getWritableDatabase("Error opening database for clearKeysWithPrefix.");
        if(var2 != null) {
            try {
                String[] var5 = new String[] {var1, var1 + ".%"};
                int var6 = var2.delete("datalayer", "key = ? OR key LIKE ?", var5);
                Log.method_5507("Cleared " + var6 + " items");
                return;
            } catch (SQLiteException var9) {
                Log.method_5509("Error deleting entries with key prefix: " + var1 + " (" + var9 + ").");
            } finally {
                this.closeDatabaseConnection();
            }

        }
    }

    private void closeDatabaseConnection() {
        try {
            this.mDbHelper.close();
        } catch (SQLiteException var2) {
            ;
        }
    }

    private void deleteEntries(String[] var1) {
        if(var1 != null && var1.length != 0) {
            SQLiteDatabase var2 = this.getWritableDatabase("Error opening database for deleteEntries.");
            if(var2 != null) {
                Object[] var3 = new Object[] {"ID", TextUtils.join(",", Collections.nCopies(var1.length, "?"))};
                String var4 = String.format("%s in (%s)", var3);

                try {
                    var2.delete("datalayer", var4, var1);
                    return;
                } catch (SQLiteException var6) {
                    Log.method_5509("Error deleting entries " + Arrays.toString(var1));
                    return;
                }
            }
        }

    }

    private void deleteEntriesOlderThan(long var1) {
        SQLiteDatabase var3 = this.getWritableDatabase("Error opening database for deleteOlderThan.");
        if(var3 != null) {
            try {
                String[] var5 = new String[] {Long.toString(var1)};
                int var6 = var3.delete("datalayer", "expires <= ?", var5);
                Log.method_5507("Deleted " + var6 + " expired items");
            } catch (SQLiteException var7) {
                Log.method_5509("Error deleting old entries.");
            }
        }
    }

    private int getNumStoredEntries() {
        // $FF: Couldn't be decompiled
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

    private List<DataLayerPersistentStoreImpl.KeyAndSerialized> loadSerialized() {
        SQLiteDatabase var1 = this.getWritableDatabase("Error opening database for loadSerialized.");
        ArrayList var2 = new ArrayList();
        if(var1 == null) {
            return var2;
        } else {
            Cursor var3 = var1.query("datalayer", new String[] {"key", "value"}, (String)null, (String[])null, (String)null, (String)null, "ID", (String)null);

            while(true) {
                boolean var6 = false;

                try {
                    var6 = true;
                    if(!var3.moveToNext()) {
                        var6 = false;
                        break;
                    }

                    var2.add(new DataLayerPersistentStoreImpl.KeyAndSerialized(var3.getString(0), var3.getBlob(1)));
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

    private List<DataLayer.KeyValue> loadSingleThreaded() {
        List var2;
        try {
            this.deleteEntriesOlderThan(this.mClock.currentTimeMillis());
            var2 = this.unserializeValues(this.loadSerialized());
        } finally {
            this.closeDatabaseConnection();
        }

        return var2;
    }

    private void makeRoomForEntries(int var1) {
        int var2 = var1 + (this.getNumStoredEntries() - this.mMaxNumStoredItems);
        if(var2 > 0) {
            List var3 = this.peekEntryIds(var2);
            Log.method_5505("DataLayer store full, deleting " + var3.size() + " entries to make room.");
            this.deleteEntries((String[])var3.toArray(new String[0]));
        }

    }

    private List<String> peekEntryIds(int param1) {
        // $FF: Couldn't be decompiled
    }

    private void saveSingleThreaded(List<DataLayerPersistentStoreImpl.KeyAndSerialized> param1, long param2) {
        // $FF: Couldn't be decompiled
    }

    private byte[] serialize(Object param1) {
        // $FF: Couldn't be decompiled
    }

    private List<DataLayerPersistentStoreImpl.KeyAndSerialized> serializeValues(List<DataLayer.KeyValue> var1) {
        ArrayList var2 = new ArrayList();
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            DataLayer.KeyValue var4 = (DataLayer.KeyValue)var3.next();
            var2.add(new DataLayerPersistentStoreImpl.KeyAndSerialized(var4.mKey, this.serialize(var4.mValue)));
        }

        return var2;
    }

    private Object unserialize(byte[] param1) {
        // $FF: Couldn't be decompiled
    }

    private List<DataLayer.KeyValue> unserializeValues(List<DataLayerPersistentStoreImpl.KeyAndSerialized> var1) {
        ArrayList var2 = new ArrayList();
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            DataLayerPersistentStoreImpl.KeyAndSerialized var4 = (DataLayerPersistentStoreImpl.KeyAndSerialized)var3.next();
            var2.add(new DataLayer.KeyValue(var4.mKey, this.unserialize(var4.mSerialized)));
        }

        return var2;
    }

    private void writeEntriesToDatabase(List<DataLayerPersistentStoreImpl.KeyAndSerialized> var1, long var2) {
        SQLiteDatabase var4 = this.getWritableDatabase("Error opening database for writeEntryToDatabase.");
        if(var4 != null) {
            Iterator var5 = var1.iterator();

            while(var5.hasNext()) {
                DataLayerPersistentStoreImpl.KeyAndSerialized var6 = (DataLayerPersistentStoreImpl.KeyAndSerialized)var5.next();
                ContentValues var7 = new ContentValues();
                var7.put("expires", Long.valueOf(var2));
                var7.put("key", var6.mKey);
                var7.put("value", var6.mSerialized);
                var4.insert("datalayer", (String)null, var7);
            }
        }

    }

    public void clearKeysWithPrefix(final String var1) {
        this.mExecutor.execute(new Runnable() {
            public void run() {
                DataLayerPersistentStoreImpl.this.clearKeysWithPrefixSingleThreaded(var1);
            }
        });
    }

    public void loadSaved(final DataLayer.Callback var1) {
        this.mExecutor.execute(new Runnable() {
            public void run() {
                var1.onKeyValuesLoaded(DataLayerPersistentStoreImpl.this.loadSingleThreaded());
            }
        });
    }

    public void saveKeyValues(List<DataLayer.KeyValue> var1, final long var2) {
        final List var4 = this.serializeValues(var1);
        this.mExecutor.execute(new Runnable() {
            public void run() {
                DataLayerPersistentStoreImpl.this.saveSingleThreaded(var4, var2);
            }
        });
    }

    @VisibleForTesting
    class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context var2, String var3) {
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
            SQLiteDatabase var3;
            label16: {
                SQLiteDatabase var4;
                try {
                    var4 = super.getWritableDatabase();
                } catch (SQLiteException var5) {
                    DataLayerPersistentStoreImpl.this.mContext.getDatabasePath("google_tagmanager.db").delete();
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

            if(!this.tablePresent("datalayer", var1)) {
                var1.execSQL(DataLayerPersistentStoreImpl.CREATE_MAPS_TABLE);
            } else {
                this.validateColumnsPresent(var1);
            }
        }

        public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
        }
    }

    private static class KeyAndSerialized {
        final String mKey;
        final byte[] mSerialized;

        KeyAndSerialized(String var1, byte[] var2) {
            this.mKey = var1;
            this.mSerialized = var2;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.mKey + " serialized hash = " + Arrays.hashCode(this.mSerialized);
        }
    }
}
