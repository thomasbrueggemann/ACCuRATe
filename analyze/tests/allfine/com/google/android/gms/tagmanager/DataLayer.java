package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.class_612;
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
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] aoG = "gtm.lifetime".toString().split("\\.");
    private static final Pattern aoH = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<DataLayer.class_1771, Integer> aoI;
    private final Map<String, Object> aoJ;
    private final ReentrantLock aoK;
    private final LinkedList<Map<String, Object>> aoL;
    private final DataLayer.class_1404 aoM;
    private final CountDownLatch aoN;

    DataLayer() {
        this(new DataLayer.class_1404() {
            // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer$c$a) void
            public void method_952(DataLayer.class_1405 var1) {
                var1.method_341(new ArrayList());
            }

            // $FF: renamed from: a (java.util.List, long) void
            public void method_953(List<DataLayer.class_1770> var1, long var2) {
            }

            // $FF: renamed from: cx (java.lang.String) void
            public void method_954(String var1) {
            }
        });
    }

    DataLayer(DataLayer.class_1404 var1) {
        this.aoM = var1;
        this.aoI = new ConcurrentHashMap();
        this.aoJ = new HashMap();
        this.aoK = new ReentrantLock();
        this.aoL = new LinkedList();
        this.aoN = new CountDownLatch(1);
        this.method_5140();
    }

    // $FF: renamed from: F (java.util.Map) void
    private void method_5129(Map<String, Object> var1) {
        this.aoK.lock();

        try {
            this.aoL.offer(var1);
            if(this.aoK.getHoldCount() == 1) {
                this.method_5141();
            }

            this.method_5130(var1);
        } finally {
            this.aoK.unlock();
        }

    }

    // $FF: renamed from: G (java.util.Map) void
    private void method_5130(Map<String, Object> var1) {
        Long var2 = this.method_5131(var1);
        if(var2 != null) {
            List var3 = this.method_5133(var1);
            var3.remove("gtm.lifetime");
            this.aoM.method_953(var3, var2.longValue());
        }
    }

    // $FF: renamed from: H (java.util.Map) java.lang.Long
    private Long method_5131(Map<String, Object> var1) {
        Object var2 = this.method_5132(var1);
        return var2 == null?null:method_5139(var2.toString());
    }

    // $FF: renamed from: I (java.util.Map) java.lang.Object
    private Object method_5132(Map<String, Object> var1) {
        String[] var2 = aoG;
        int var3 = var2.length;
        int var4 = 0;

        Object var5;
        Object var7;
        for(var5 = var1; var4 < var3; var5 = var7) {
            String var6 = var2[var4];
            if(!(var5 instanceof Map)) {
                var5 = null;
                break;
            }

            var7 = ((Map)var5).get(var6);
            ++var4;
        }

        return var5;
    }

    // $FF: renamed from: J (java.util.Map) java.util.List
    private List<DataLayer.class_1770> method_5133(Map<String, Object> var1) {
        ArrayList var2 = new ArrayList();
        this.method_5138(var1, "", var2);
        return var2;
    }

    // $FF: renamed from: K (java.util.Map) void
    private void method_5134(Map<String, Object> param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: L (java.util.Map) void
    private void method_5135(Map<String, Object> var1) {
        Iterator var2 = this.aoI.keySet().iterator();

        while(var2.hasNext()) {
            ((DataLayer.class_1771)var2.next()).method_998(var1);
        }

    }

    // $FF: renamed from: a (java.util.Map, java.lang.String, java.util.Collection) void
    private void method_5138(Map<String, Object> var1, String var2, Collection<DataLayer.class_1770> var3) {
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

            String var8 = var6.append(var7).append((String)var5.getKey()).toString();
            if(var5.getValue() instanceof Map) {
                this.method_5138((Map)var5.getValue(), var8, var3);
            } else if(!var8.equals("gtm.lifetime")) {
                var3.add(new DataLayer.class_1770(var8, var5.getValue()));
            }
        }

    }

    // $FF: renamed from: cw (java.lang.String) java.lang.Long
    static Long method_5139(String var0) {
        Matcher var1 = aoH.matcher(var0);
        if(!var1.matches()) {
            class_612.method_3457("unknown _lifetime: " + var0);
            return null;
        } else {
            long var3;
            label28: {
                long var6;
                try {
                    var6 = Long.parseLong(var1.group(1));
                } catch (NumberFormatException var8) {
                    class_612.method_3459("illegal number in _lifetime value: " + var0);
                    var3 = 0L;
                    break label28;
                }

                var3 = var6;
            }

            if(var3 <= 0L) {
                class_612.method_3457("non-positive _lifetime: " + var0);
                return null;
            } else {
                String var5 = var1.group(2);
                if(var5.length() == 0) {
                    return Long.valueOf(var3);
                } else {
                    switch(var5.charAt(0)) {
                        case 'd':
                            return Long.valueOf(24L * 60L * 60L * var3 * 1000L);
                        case 'h':
                            return Long.valueOf(60L * 60L * var3 * 1000L);
                        case 'm':
                            return Long.valueOf(60L * var3 * 1000L);
                        case 's':
                            return Long.valueOf(var3 * 1000L);
                        default:
                            class_612.method_3459("unknown units in _lifetime: " + var0);
                            return null;
                    }
                }
            }
        }
    }

    public static List<Object> listOf(Object... var0) {
        ArrayList var1 = new ArrayList();

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1.add(var0[var2]);
        }

        return var1;
    }

    public static Map<String, Object> mapOf(Object... var0) {
        if(var0.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        } else {
            HashMap var1 = new HashMap();

            for(int var2 = 0; var2 < var0.length; var2 += 2) {
                if(!(var0[var2] instanceof String)) {
                    throw new IllegalArgumentException("key is not a string: " + var0[var2]);
                }

                var1.put((String)var0[var2], var0[var2 + 1]);
            }

            return var1;
        }
    }

    // $FF: renamed from: oe () void
    private void method_5140() {
        this.aoM.method_952(new DataLayer.class_1405() {
            // $FF: renamed from: g (java.util.List) void
            public void method_341(List<DataLayer.class_1770> var1) {
                Iterator var2 = var1.iterator();

                while(var2.hasNext()) {
                    DataLayer.class_1770 var3 = (DataLayer.class_1770)var2.next();
                    DataLayer.this.method_5129(DataLayer.this.method_5145(var3.field_5131, var3.field_5132));
                }

                DataLayer.this.aoN.countDown();
            }
        });
    }

    // $FF: renamed from: of () void
    private void method_5141() {
        int var1 = 0;

        while(true) {
            Map var2 = (Map)this.aoL.poll();
            if(var2 == null) {
                return;
            }

            this.method_5134(var2);
            int var3 = var1 + 1;
            if(var3 > 500) {
                this.aoL.clear();
                throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
            }

            var1 = var3;
        }
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer$b) void
    void method_5142(DataLayer.class_1771 var1) {
        this.aoI.put(var1, Integer.valueOf(0));
    }

    // $FF: renamed from: a (java.util.Map, java.util.Map) void
    void method_5143(Map<String, Object> var1, Map<String, Object> var2) {
        Iterator var3 = var1.keySet().iterator();

        while(var3.hasNext()) {
            String var4 = (String)var3.next();
            Object var5 = var1.get(var4);
            if(var5 instanceof List) {
                if(!(var2.get(var4) instanceof List)) {
                    var2.put(var4, new ArrayList());
                }

                this.method_5144((List)var5, (List)var2.get(var4));
            } else if(var5 instanceof Map) {
                if(!(var2.get(var4) instanceof Map)) {
                    var2.put(var4, new HashMap());
                }

                this.method_5143((Map)var5, (Map)var2.get(var4));
            } else {
                var2.put(var4, var5);
            }
        }

    }

    // $FF: renamed from: b (java.util.List, java.util.List) void
    void method_5144(List<Object> var1, List<Object> var2) {
        while(var2.size() < var1.size()) {
            var2.add((Object)null);
        }

        for(int var3 = 0; var3 < var1.size(); ++var3) {
            Object var4 = var1.get(var3);
            if(var4 instanceof List) {
                if(!(var2.get(var3) instanceof List)) {
                    var2.set(var3, new ArrayList());
                }

                this.method_5144((List)var4, (List)var2.get(var3));
            } else if(var4 instanceof Map) {
                if(!(var2.get(var3) instanceof Map)) {
                    var2.set(var3, new HashMap());
                }

                this.method_5143((Map)var4, (Map)var2.get(var3));
            } else if(var4 != OBJECT_NOT_PRESENT) {
                var2.set(var3, var4);
            }
        }

    }

    // $FF: renamed from: c (java.lang.String, java.lang.Object) java.util.Map
    Map<String, Object> method_5145(String var1, Object var2) {
        HashMap var3 = new HashMap();
        String[] var4 = var1.toString().split("\\.");
        int var5 = 0;

        HashMap var6;
        HashMap var7;
        for(var6 = var3; var5 < -1 + var4.length; var6 = var7) {
            var7 = new HashMap();
            var6.put(var4[var5], var7);
            ++var5;
        }

        var6.put(var4[-1 + var4.length], var2);
        return var3;
    }

    // $FF: renamed from: cv (java.lang.String) void
    void method_5146(String var1) {
        this.push(var1, (Object)null);
        this.aoM.method_954(var1);
    }

    public Object get(String param1) {
        // $FF: Couldn't be decompiled
    }

    public void push(String var1, Object var2) {
        this.push(this.method_5145(var1, var2));
    }

    public void push(Map<String, Object> var1) {
        try {
            this.aoN.await();
        } catch (InterruptedException var3) {
            class_612.method_3459("DataLayer.push: unexpected InterruptedException");
        }

        this.method_5129(var1);
    }

    public void pushEvent(String var1, Map<String, Object> var2) {
        HashMap var3 = new HashMap(var2);
        var3.put("event", var1);
        this.push(var3);
    }

    public String toString() {
        // $FF: Couldn't be decompiled
    }

    static final class class_1770 {
        // $FF: renamed from: JO java.lang.String
        public final String field_5131;
        // $FF: renamed from: wq java.lang.Object
        public final Object field_5132;

        class_1770(String var1, Object var2) {
            this.field_5131 = var1;
            this.field_5132 = var2;
        }

        public boolean equals(Object var1) {
            if(var1 instanceof DataLayer.class_1770) {
                DataLayer.class_1770 var2 = (DataLayer.class_1770)var1;
                if(this.field_5131.equals(var2.field_5131) && this.field_5132.equals(var2.field_5132)) {
                    return true;
                }
            }

            return false;
        }

        public int hashCode() {
            Integer[] var1 = new Integer[] {Integer.valueOf(this.field_5131.hashCode()), Integer.valueOf(this.field_5132.hashCode())};
            return Arrays.hashCode(var1);
        }

        public String toString() {
            return "Key: " + this.field_5131 + " value: " + this.field_5132.toString();
        }
    }

    interface class_1771 {
        // $FF: renamed from: D (java.util.Map) void
        void method_998(Map<String, Object> var1);
    }

    interface class_1404 {
        // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer$c$a) void
        void method_952(DataLayer.class_1405 var1);

        // $FF: renamed from: a (java.util.List, long) void
        void method_953(List<DataLayer.class_1770> var1, long var2);

        // $FF: renamed from: cx (java.lang.String) void
        void method_954(String var1);
    }

    public interface class_1405 {
        // $FF: renamed from: g (java.util.List) void
        void method_341(List<DataLayer.class_1770> var1);
    }
}
