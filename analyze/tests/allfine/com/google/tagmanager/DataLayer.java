package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    static final String LIFETIME_KEY = "gtm.lifetime";
    static final String[] LIFETIME_KEY_COMPONENTS = "gtm.lifetime".toString().split("\\.");
    private static final Pattern LIFETIME_PATTERN = Pattern.compile("(\\d+)\\s*([smhd]?)");
    static final int MAX_QUEUE_DEPTH = 500;
    public static final Object OBJECT_NOT_PRESENT = new Object();
    private final ConcurrentHashMap<DataLayer.Listener, Integer> mListeners;
    private final Map<Object, Object> mModel;
    private final DataLayer.PersistentStore mPersistentStore;
    private final CountDownLatch mPersistentStoreLoaded;
    private final ReentrantLock mPushLock;
    private final LinkedList<Map<Object, Object>> mUpdateQueue;

    @VisibleForTesting
    DataLayer() {
        this(new DataLayer.PersistentStore() {
            public void clearKeysWithPrefix(String var1) {
            }

            public void loadSaved(DataLayer.Callback var1) {
                var1.onKeyValuesLoaded(new ArrayList());
            }

            public void saveKeyValues(List<DataLayer.KeyValue> var1, long var2) {
            }
        });
    }

    DataLayer(DataLayer.PersistentStore var1) {
        this.mPersistentStore = var1;
        this.mListeners = new ConcurrentHashMap();
        this.mModel = new HashMap();
        this.mPushLock = new ReentrantLock();
        this.mUpdateQueue = new LinkedList();
        this.mPersistentStoreLoaded = new CountDownLatch(1);
        this.loadSavedMaps();
    }

    private List<DataLayer.KeyValue> flattenMap(Map<Object, Object> var1) {
        ArrayList var2 = new ArrayList();
        this.flattenMapHelper(var1, "", var2);
        return var2;
    }

    private void flattenMapHelper(Map<Object, Object> var1, String var2, Collection<DataLayer.KeyValue> var3) {
        Iterator var4 = var1.entrySet().iterator();

        while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            StringBuilder var6 = (new StringBuilder()).append(var2);
            String var7;
            if(var2.length() == 0) {
                var7 = "";
            } else {
                var7 = ".";
            }

            String var8 = var6.append(var7).append(var5.getKey()).toString();
            if(var5.getValue() instanceof Map) {
                this.flattenMapHelper((Map)var5.getValue(), var8, var3);
            } else if(!var8.equals("gtm.lifetime")) {
                var3.add(new DataLayer.KeyValue(var8, var5.getValue()));
            }
        }

    }

    private Object getLifetimeObject(Map<Object, Object> var1) {
        Object var2 = var1;
        String[] var3 = LIFETIME_KEY_COMPONENTS;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String var6 = var3[var5];
            if(!(var2 instanceof Map)) {
                var2 = null;
                break;
            }

            var2 = ((Map)var2).get(var6);
        }

        return var2;
    }

    private Long getLifetimeValue(Map<Object, Object> var1) {
        Object var2 = this.getLifetimeObject(var1);
        return var2 == null?null:parseLifetime(var2.toString());
    }

    public static List<Object> listOf(Object... var0) {
        ArrayList var1 = new ArrayList();

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1.add(var0[var2]);
        }

        return var1;
    }

    private void loadSavedMaps() {
        this.mPersistentStore.loadSaved(new DataLayer.Callback() {
            public void onKeyValuesLoaded(List<DataLayer.KeyValue> var1) {
                Iterator var2 = var1.iterator();

                while(var2.hasNext()) {
                    DataLayer.KeyValue var3 = (DataLayer.KeyValue)var2.next();
                    DataLayer.this.pushWithoutWaitingForSaved(DataLayer.this.expandKeyValue(var3.mKey, var3.mValue));
                }

                DataLayer.this.mPersistentStoreLoaded.countDown();
            }
        });
    }

    public static Map<Object, Object> mapOf(Object... var0) {
        if(var0.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        } else {
            HashMap var1 = new HashMap();

            for(int var2 = 0; var2 < var0.length; var2 += 2) {
                var1.put(var0[var2], var0[var2 + 1]);
            }

            return var1;
        }
    }

    private void notifyListeners(Map<Object, Object> var1) {
        Iterator var2 = this.mListeners.keySet().iterator();

        while(var2.hasNext()) {
            ((DataLayer.Listener)var2.next()).changed(var1);
        }

    }

    @VisibleForTesting
    static Long parseLifetime(String var0) {
        Matcher var1 = LIFETIME_PATTERN.matcher(var0);
        if(!var1.matches()) {
            Log.method_5505("unknown _lifetime: " + var0);
            return null;
        } else {
            long var2 = 0L;

            label29: {
                long var6;
                try {
                    var6 = Long.parseLong(var1.group(1));
                } catch (NumberFormatException var8) {
                    Log.method_5509("illegal number in _lifetime value: " + var0);
                    break label29;
                }

                var2 = var6;
            }

            if(var2 <= 0L) {
                Log.method_5505("non-positive _lifetime: " + var0);
                return null;
            } else {
                String var5 = var1.group(2);
                if(var5.length() == 0) {
                    return Long.valueOf(var2);
                } else {
                    switch(var5.charAt(0)) {
                        case 'd':
                            return Long.valueOf(24L * 60L * 60L * var2 * 1000L);
                        case 'h':
                            return Long.valueOf(60L * 60L * var2 * 1000L);
                        case 'm':
                            return Long.valueOf(60L * var2 * 1000L);
                        case 's':
                            return Long.valueOf(var2 * 1000L);
                        default:
                            Log.method_5509("unknown units in _lifetime: " + var0);
                            return null;
                    }
                }
            }
        }
    }

    private void processQueuedUpdates() {
        int var1 = 0;

        do {
            Map var2 = (Map)this.mUpdateQueue.poll();
            if(var2 == null) {
                return;
            }

            this.processUpdate(var2);
            ++var1;
        } while(var1 <= 500);

        this.mUpdateQueue.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    private void processUpdate(Map<Object, Object> param1) {
        // $FF: Couldn't be decompiled
    }

    private void pushWithoutWaitingForSaved(Map<Object, Object> var1) {
        this.mPushLock.lock();

        try {
            this.mUpdateQueue.offer(var1);
            if(this.mPushLock.getHoldCount() == 1) {
                this.processQueuedUpdates();
            }

            this.savePersistentlyIfNeeded(var1);
        } finally {
            this.mPushLock.unlock();
        }

    }

    private void savePersistentlyIfNeeded(Map<Object, Object> var1) {
        Long var2 = this.getLifetimeValue(var1);
        if(var2 != null) {
            List var3 = this.flattenMap(var1);
            var3.remove("gtm.lifetime");
            this.mPersistentStore.saveKeyValues(var3, var2.longValue());
        }
    }

    void clearPersistentKeysWithPrefix(String var1) {
        this.push(var1, (Object)null);
        this.mPersistentStore.clearKeysWithPrefix(var1);
    }

    Map<Object, Object> expandKeyValue(Object var1, Object var2) {
        HashMap var3 = new HashMap();
        HashMap var4 = var3;
        String[] var5 = var1.toString().split("\\.");

        for(int var6 = 0; var6 < -1 + var5.length; ++var6) {
            HashMap var7 = new HashMap();
            var4.put(var5[var6], var7);
            var4 = var7;
        }

        var4.put(var5[-1 + var5.length], var2);
        return var3;
    }

    public Object get(String param1) {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    void mergeList(List<Object> var1, List<Object> var2) {
        while(var2.size() < var1.size()) {
            var2.add((Object)null);
        }

        for(int var3 = 0; var3 < var1.size(); ++var3) {
            Object var4 = var1.get(var3);
            if(var4 instanceof List) {
                if(!(var2.get(var3) instanceof List)) {
                    var2.set(var3, new ArrayList());
                }

                this.mergeList((List)var4, (List)var2.get(var3));
            } else if(var4 instanceof Map) {
                if(!(var2.get(var3) instanceof Map)) {
                    var2.set(var3, new HashMap());
                }

                this.mergeMap((Map)var4, (Map)var2.get(var3));
            } else if(var4 != OBJECT_NOT_PRESENT) {
                var2.set(var3, var4);
            }
        }

    }

    @VisibleForTesting
    void mergeMap(Map<Object, Object> var1, Map<Object, Object> var2) {
        Iterator var3 = var1.keySet().iterator();

        while(var3.hasNext()) {
            Object var4 = var3.next();
            Object var5 = var1.get(var4);
            if(var5 instanceof List) {
                if(!(var2.get(var4) instanceof List)) {
                    var2.put(var4, new ArrayList());
                }

                this.mergeList((List)var5, (List)var2.get(var4));
            } else if(var5 instanceof Map) {
                if(!(var2.get(var4) instanceof Map)) {
                    var2.put(var4, new HashMap());
                }

                this.mergeMap((Map)var5, (Map)var2.get(var4));
            } else {
                var2.put(var4, var5);
            }
        }

    }

    public void push(Object var1, Object var2) {
        this.push(this.expandKeyValue(var1, var2));
    }

    public void push(Map<Object, Object> var1) {
        try {
            this.mPersistentStoreLoaded.await();
        } catch (InterruptedException var3) {
            Log.method_5509("DataLayer.push: unexpected InterruptedException");
        }

        this.pushWithoutWaitingForSaved(var1);
    }

    void registerListener(DataLayer.Listener var1) {
        this.mListeners.put(var1, Integer.valueOf(0));
    }

    void unregisterListener(DataLayer.Listener var1) {
        this.mListeners.remove(var1);
    }

    static final class KeyValue {
        public final String mKey;
        public final Object mValue;

        KeyValue(String var1, Object var2) {
            this.mKey = var1;
            this.mValue = var2;
        }

        public boolean equals(Object var1) {
            if(var1 instanceof DataLayer.KeyValue) {
                DataLayer.KeyValue var2 = (DataLayer.KeyValue)var1;
                if(this.mKey.equals(var2.mKey) && this.mValue.equals(var2.mValue)) {
                    return true;
                }
            }

            return false;
        }

        public int hashCode() {
            Integer[] var1 = new Integer[] {Integer.valueOf(this.mKey.hashCode()), Integer.valueOf(this.mValue.hashCode())};
            return Arrays.hashCode(var1);
        }

        public String toString() {
            return "Key: " + this.mKey + " value: " + this.mValue.toString();
        }
    }

    interface Listener {
        void changed(Map<Object, Object> var1);
    }

    interface PersistentStore {
        void clearKeysWithPrefix(String var1);

        void loadSaved(DataLayer.Callback var1);

        void saveKeyValues(List<DataLayer.KeyValue> var1, long var2);
    }

    public interface Callback {
        void onKeyValuesLoaded(List<DataLayer.KeyValue> var1);
    }
}
