package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.class_613;
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
   static final String[] aqQ = "gtm.lifetime".toString().split("\\.");
   private static final Pattern aqR = Pattern.compile("(\\d+)\\s*([smhd]?)");
   private final ConcurrentHashMap<DataLayer.class_1643, Integer> aqS;
   private final Map<String, Object> aqT;
   private final ReentrantLock aqU;
   private final LinkedList<Map<String, Object>> aqV;
   private final DataLayer.class_1345 aqW;
   private final CountDownLatch aqX;

   DataLayer() {
      this(new DataLayer.class_1345() {
         // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer$c$a) void
         public void method_1006(DataLayer.class_1346 var1) {
            var1.method_409(new ArrayList());
         }

         // $FF: renamed from: a (java.util.List, long) void
         public void method_1007(List<DataLayer.class_1642> var1, long var2) {
         }

         // $FF: renamed from: cz (java.lang.String) void
         public void method_1008(String var1) {
         }
      });
   }

   DataLayer(DataLayer.class_1345 var1) {
      this.aqW = var1;
      this.aqS = new ConcurrentHashMap();
      this.aqT = new HashMap();
      this.aqU = new ReentrantLock();
      this.aqV = new LinkedList();
      this.aqX = new CountDownLatch(1);
      this.method_4992();
   }

   // $FF: renamed from: E (java.util.Map) void
   private void method_4981(Map<String, Object> var1) {
      this.aqU.lock();

      try {
         this.aqV.offer(var1);
         if(this.aqU.getHoldCount() == 1) {
            this.method_4993();
         }

         this.method_4982(var1);
      } finally {
         this.aqU.unlock();
      }

   }

   // $FF: renamed from: F (java.util.Map) void
   private void method_4982(Map<String, Object> var1) {
      Long var2 = this.method_4983(var1);
      if(var2 != null) {
         List var3 = this.method_4985(var1);
         var3.remove("gtm.lifetime");
         this.aqW.method_1007(var3, var2.longValue());
      }
   }

   // $FF: renamed from: G (java.util.Map) java.lang.Long
   private Long method_4983(Map<String, Object> var1) {
      Object var2 = this.method_4984(var1);
      return var2 == null?null:method_4991(var2.toString());
   }

   // $FF: renamed from: H (java.util.Map) java.lang.Object
   private Object method_4984(Map<String, Object> var1) {
      String[] var2 = aqQ;
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

   // $FF: renamed from: I (java.util.Map) java.util.List
   private List<DataLayer.class_1642> method_4985(Map<String, Object> var1) {
      ArrayList var2 = new ArrayList();
      this.method_4990(var1, "", var2);
      return var2;
   }

   // $FF: renamed from: J (java.util.Map) void
   private void method_4986(Map<String, Object> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: K (java.util.Map) void
   private void method_4987(Map<String, Object> var1) {
      Iterator var2 = this.aqS.keySet().iterator();

      while(var2.hasNext()) {
         ((DataLayer.class_1643)var2.next()).method_1009(var1);
      }

   }

   // $FF: renamed from: a (java.util.Map, java.lang.String, java.util.Collection) void
   private void method_4990(Map<String, Object> var1, String var2, Collection<DataLayer.class_1642> var3) {
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
            this.method_4990((Map)var5.getValue(), var8, var3);
         } else if(!var8.equals("gtm.lifetime")) {
            var3.add(new DataLayer.class_1642(var8, var5.getValue()));
         }
      }

   }

   // $FF: renamed from: cy (java.lang.String) java.lang.Long
   static Long method_4991(String var0) {
      Matcher var1 = aqR.matcher(var0);
      if(!var1.matches()) {
         class_613.method_3492("unknown _lifetime: " + var0);
         return null;
      } else {
         long var3;
         label28: {
            long var6;
            try {
               var6 = Long.parseLong(var1.group(1));
            } catch (NumberFormatException var8) {
               class_613.method_3494("illegal number in _lifetime value: " + var0);
               var3 = 0L;
               break label28;
            }

            var3 = var6;
         }

         if(var3 <= 0L) {
            class_613.method_3492("non-positive _lifetime: " + var0);
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
                  class_613.method_3494("unknown units in _lifetime: " + var0);
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

   // $FF: renamed from: pv () void
   private void method_4992() {
      this.aqW.method_1006(new DataLayer.class_1346() {
         // $FF: renamed from: h (java.util.List) void
         public void method_409(List<DataLayer.class_1642> var1) {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               DataLayer.class_1642 var3 = (DataLayer.class_1642)var2.next();
               DataLayer.this.method_4981(DataLayer.this.method_4997(var3.field_4287, var3.field_4288));
            }

            DataLayer.this.aqX.countDown();
         }
      });
   }

   // $FF: renamed from: pw () void
   private void method_4993() {
      int var1 = 0;

      while(true) {
         Map var2 = (Map)this.aqV.poll();
         if(var2 == null) {
            return;
         }

         this.method_4986(var2);
         int var3 = var1 + 1;
         if(var3 > 500) {
            this.aqV.clear();
            throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
         }

         var1 = var3;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer$b) void
   void method_4994(DataLayer.class_1643 var1) {
      this.aqS.put(var1, Integer.valueOf(0));
   }

   // $FF: renamed from: a (java.util.Map, java.util.Map) void
   void method_4995(Map<String, Object> var1, Map<String, Object> var2) {
      Iterator var3 = var1.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         Object var5 = var1.get(var4);
         if(var5 instanceof List) {
            if(!(var2.get(var4) instanceof List)) {
               var2.put(var4, new ArrayList());
            }

            this.method_4996((List)var5, (List)var2.get(var4));
         } else if(var5 instanceof Map) {
            if(!(var2.get(var4) instanceof Map)) {
               var2.put(var4, new HashMap());
            }

            this.method_4995((Map)var5, (Map)var2.get(var4));
         } else {
            var2.put(var4, var5);
         }
      }

   }

   // $FF: renamed from: b (java.util.List, java.util.List) void
   void method_4996(List<Object> var1, List<Object> var2) {
      while(var2.size() < var1.size()) {
         var2.add((Object)null);
      }

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         Object var4 = var1.get(var3);
         if(var4 instanceof List) {
            if(!(var2.get(var3) instanceof List)) {
               var2.set(var3, new ArrayList());
            }

            this.method_4996((List)var4, (List)var2.get(var3));
         } else if(var4 instanceof Map) {
            if(!(var2.get(var3) instanceof Map)) {
               var2.set(var3, new HashMap());
            }

            this.method_4995((Map)var4, (Map)var2.get(var3));
         } else if(var4 != OBJECT_NOT_PRESENT) {
            var2.set(var3, var4);
         }
      }

   }

   // $FF: renamed from: c (java.lang.String, java.lang.Object) java.util.Map
   Map<String, Object> method_4997(String var1, Object var2) {
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

   // $FF: renamed from: cx (java.lang.String) void
   void method_4998(String var1) {
      this.push(var1, (Object)null);
      this.aqW.method_1008(var1);
   }

   public Object get(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void push(String var1, Object var2) {
      this.push(this.method_4997(var1, var2));
   }

   public void push(Map<String, Object> var1) {
      try {
         this.aqX.await();
      } catch (InterruptedException var3) {
         class_613.method_3494("DataLayer.push: unexpected InterruptedException");
      }

      this.method_4981(var1);
   }

   public void pushEvent(String var1, Map<String, Object> var2) {
      HashMap var3 = new HashMap(var2);
      var3.put("event", var1);
      this.push(var3);
   }

   public String toString() {
      // $FF: Couldn't be decompiled
   }

   static final class class_1642 {
      // $FF: renamed from: KP java.lang.String
      public final String field_4287;
      // $FF: renamed from: wF java.lang.Object
      public final Object field_4288;

      class_1642(String var1, Object var2) {
         this.field_4287 = var1;
         this.field_4288 = var2;
      }

      public boolean equals(Object var1) {
         if(var1 instanceof DataLayer.class_1642) {
            DataLayer.class_1642 var2 = (DataLayer.class_1642)var1;
            if(this.field_4287.equals(var2.field_4287) && this.field_4288.equals(var2.field_4288)) {
               return true;
            }
         }

         return false;
      }

      public int hashCode() {
         Integer[] var1 = new Integer[]{Integer.valueOf(this.field_4287.hashCode()), Integer.valueOf(this.field_4288.hashCode())};
         return Arrays.hashCode(var1);
      }

      public String toString() {
         return "Key: " + this.field_4287 + " value: " + this.field_4288.toString();
      }
   }

   interface class_1643 {
      // $FF: renamed from: C (java.util.Map) void
      void method_1009(Map<String, Object> var1);
   }

   interface class_1345 {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer$c$a) void
      void method_1006(DataLayer.class_1346 var1);

      // $FF: renamed from: a (java.util.List, long) void
      void method_1007(List<DataLayer.class_1642> var1, long var2);

      // $FF: renamed from: cz (java.lang.String) void
      void method_1008(String var1);
   }

   public interface class_1346 {
      // $FF: renamed from: h (java.util.List) void
      void method_409(List<DataLayer.class_1642> var1);
   }
}
