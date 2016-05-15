package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzbg;
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
   public static final Object OBJECT_NOT_PRESENT = new Object();
   static final String[] zzbir = "gtm.lifetime".toString().split("\\.");
   private static final Pattern zzbis = Pattern.compile("(\\d+)\\s*([smhd]?)");
   private final ConcurrentHashMap<DataLayer.zzb, Integer> zzbit;
   private final Map<String, Object> zzbiu;
   private final ReentrantLock zzbiv;
   private final LinkedList<Map<String, Object>> zzbiw;
   private final DataLayer.zzc zzbix;
   private final CountDownLatch zzbiy;

   DataLayer() {
      this(new DataLayer.zzc() {
         public void zza(DataLayer.zza var1) {
            var1.zzB(new ArrayList());
         }

         public void zza(List<DataLayer.zza> var1, long var2) {
         }

         public void zzfZ(String var1) {
         }
      });
   }

   DataLayer(DataLayer.zzc var1) {
      this.zzbix = var1;
      this.zzbit = new ConcurrentHashMap();
      this.zzbiu = new HashMap();
      this.zzbiv = new ReentrantLock();
      this.zzbiw = new LinkedList();
      this.zzbiy = new CountDownLatch(1);
      this.zzGn();
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

   private void zzGn() {
      this.zzbix.zza(new DataLayer.zza() {
         public void zzB(List<DataLayer.zza> var1) {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               DataLayer.zza var3 = (DataLayer.zza)var2.next();
               DataLayer.this.zzS(DataLayer.this.zzn(var3.zzvs, var3.zzNc));
            }

            DataLayer.this.zzbiy.countDown();
         }
      });
   }

   private void zzGo() {
      int var1 = 0;

      while(true) {
         Map var2 = (Map)this.zzbiw.poll();
         if(var2 == null) {
            return;
         }

         this.zzX(var2);
         int var3 = var1 + 1;
         if(var3 > 500) {
            this.zzbiw.clear();
            throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
         }

         var1 = var3;
      }
   }

   private void zzS(Map<String, Object> var1) {
      this.zzbiv.lock();

      try {
         this.zzbiw.offer(var1);
         if(this.zzbiv.getHoldCount() == 1) {
            this.zzGo();
         }

         this.zzT(var1);
      } finally {
         this.zzbiv.unlock();
      }

   }

   private void zzT(Map<String, Object> var1) {
      Long var2 = this.zzU(var1);
      if(var2 != null) {
         List var3 = this.zzW(var1);
         var3.remove("gtm.lifetime");
         this.zzbix.zza(var3, var2.longValue());
      }
   }

   private Long zzU(Map<String, Object> var1) {
      Object var2 = this.zzV(var1);
      return var2 == null?null:zzfY(var2.toString());
   }

   private Object zzV(Map<String, Object> var1) {
      String[] var2 = zzbir;
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

   private List<DataLayer.zza> zzW(Map<String, Object> var1) {
      ArrayList var2 = new ArrayList();
      this.zza(var1, "", var2);
      return var2;
   }

   private void zzX(Map<String, Object> param1) {
      // $FF: Couldn't be decompiled
   }

   private void zzY(Map<String, Object> var1) {
      Iterator var2 = this.zzbit.keySet().iterator();

      while(var2.hasNext()) {
         ((DataLayer.zzb)var2.next()).zzQ(var1);
      }

   }

   private void zza(Map<String, Object> var1, String var2, Collection<DataLayer.zza> var3) {
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
            this.zza((Map)var5.getValue(), var8, var3);
         } else if(!var8.equals("gtm.lifetime")) {
            var3.add(new DataLayer.zza(var8, var5.getValue()));
         }
      }

   }

   static Long zzfY(String var0) {
      Matcher var1 = zzbis.matcher(var0);
      if(!var1.matches()) {
         zzbg.zzaJ("unknown _lifetime: " + var0);
         return null;
      } else {
         long var3;
         label28: {
            long var6;
            try {
               var6 = Long.parseLong(var1.group(1));
            } catch (NumberFormatException var8) {
               zzbg.zzaK("illegal number in _lifetime value: " + var0);
               var3 = 0L;
               break label28;
            }

            var3 = var6;
         }

         if(var3 <= 0L) {
            zzbg.zzaJ("non-positive _lifetime: " + var0);
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
                  zzbg.zzaK("unknown units in _lifetime: " + var0);
                  return null;
               }
            }
         }
      }
   }

   public Object get(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void push(String var1, Object var2) {
      this.push(this.zzn(var1, var2));
   }

   public void push(Map<String, Object> var1) {
      try {
         this.zzbiy.await();
      } catch (InterruptedException var3) {
         zzbg.zzaK("DataLayer.push: unexpected InterruptedException");
      }

      this.zzS(var1);
   }

   public void pushEvent(String var1, Map<String, Object> var2) {
      HashMap var3 = new HashMap(var2);
      var3.put("event", var1);
      this.push(var3);
   }

   public String toString() {
      // $FF: Couldn't be decompiled
   }

   void zza(DataLayer.zzb var1) {
      this.zzbit.put(var1, Integer.valueOf(0));
   }

   void zzb(List<Object> var1, List<Object> var2) {
      while(var2.size() < var1.size()) {
         var2.add((Object)null);
      }

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         Object var4 = var1.get(var3);
         if(var4 instanceof List) {
            if(!(var2.get(var3) instanceof List)) {
               var2.set(var3, new ArrayList());
            }

            this.zzb((List)var4, (List)var2.get(var3));
         } else if(var4 instanceof Map) {
            if(!(var2.get(var3) instanceof Map)) {
               var2.set(var3, new HashMap());
            }

            this.zzd((Map)var4, (Map)var2.get(var3));
         } else if(var4 != OBJECT_NOT_PRESENT) {
            var2.set(var3, var4);
         }
      }

   }

   void zzd(Map<String, Object> var1, Map<String, Object> var2) {
      Iterator var3 = var1.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         Object var5 = var1.get(var4);
         if(var5 instanceof List) {
            if(!(var2.get(var4) instanceof List)) {
               var2.put(var4, new ArrayList());
            }

            this.zzb((List)var5, (List)var2.get(var4));
         } else if(var5 instanceof Map) {
            if(!(var2.get(var4) instanceof Map)) {
               var2.put(var4, new HashMap());
            }

            this.zzd((Map)var5, (Map)var2.get(var4));
         } else {
            var2.put(var4, var5);
         }
      }

   }

   void zzfX(String var1) {
      this.push(var1, (Object)null);
      this.zzbix.zzfZ(var1);
   }

   Map<String, Object> zzn(String var1, Object var2) {
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

   static final class zza {
      public final Object zzNc;
      public final String zzvs;

      zza(String var1, Object var2) {
         this.zzvs = var1;
         this.zzNc = var2;
      }

      public boolean equals(Object var1) {
         if(var1 instanceof DataLayer.zza) {
            DataLayer.zza var2 = (DataLayer.zza)var1;
            if(this.zzvs.equals(var2.zzvs) && this.zzNc.equals(var2.zzNc)) {
               return true;
            }
         }

         return false;
      }

      public int hashCode() {
         Integer[] var1 = new Integer[]{Integer.valueOf(this.zzvs.hashCode()), Integer.valueOf(this.zzNc.hashCode())};
         return Arrays.hashCode(var1);
      }

      public String toString() {
         return "Key: " + this.zzvs + " value: " + this.zzNc.toString();
      }
   }

   interface zzb {
      void zzQ(Map<String, Object> var1);
   }

   interface zzc {
      void zza(DataLayer.zza var1);

      void zza(List<DataLayer.zza> var1, long var2);

      void zzfZ(String var1);
   }

   public interface zza {
      void zzB(List<DataLayer.zza> var1);
   }
}
