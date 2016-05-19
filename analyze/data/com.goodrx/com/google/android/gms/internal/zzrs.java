package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzrs {
   private static zzag.zza zza(int var0, zzaf.zzf var1, zzag.zza[] var2, Set<Integer> var3) throws zzrs.zzg {
      int var4 = 0;
      if(var3.contains(Integer.valueOf(var0))) {
         zzgC("Value cycle detected.  Current value reference: " + var0 + "." + "  Previous value references: " + var3 + ".");
      }

      zzag.zza var5 = (zzag.zza)zza(var1.zziI, var0, "values");
      if(var2[var0] != null) {
         return var2[var0];
      } else {
         zzag.zza var8;
         var3.add(Integer.valueOf(var0));
         int var7 = var5.type;
         var8 = null;
         label54:
         switch(var7) {
         case 1:
         case 5:
         case 6:
         case 8:
            var8 = var5;
            break;
         case 2:
            zzaf.zzh var31 = zzp(var5);
            var8 = zzo(var5);
            var8.zzjy = new zzag.zza[var31.zzjj.length];
            int[] var32 = var31.zzjj;
            int var33 = var32.length;
            int var34 = 0;

            while(true) {
               if(var4 >= var33) {
                  break label54;
               }

               int var35 = var32[var4];
               zzag.zza[] var36 = var8.zzjy;
               int var37 = var34 + 1;
               var36[var34] = zza(var35, var1, var2, var3);
               ++var4;
               var34 = var37;
            }
         case 3:
            var8 = zzo(var5);
            zzaf.zzh var17 = zzp(var5);
            if(var17.zzjk.length != var17.zzjl.length) {
               zzgC("Uneven map keys (" + var17.zzjk.length + ") and map values (" + var17.zzjl.length + ")");
            }

            var8.zzjz = new zzag.zza[var17.zzjk.length];
            var8.zzjA = new zzag.zza[var17.zzjk.length];
            int[] var18 = var17.zzjk;
            int var19 = var18.length;
            int var20 = 0;

            int var30;
            for(int var21 = 0; var20 < var19; var21 = var30) {
               int var28 = var18[var20];
               zzag.zza[] var29 = var8.zzjz;
               var30 = var21 + 1;
               var29[var21] = zza(var28, var1, var2, var3);
               ++var20;
            }

            int[] var22 = var17.zzjl;
            int var23 = var22.length;
            int var24 = 0;

            while(true) {
               if(var4 >= var23) {
                  break label54;
               }

               int var25 = var22[var4];
               zzag.zza[] var26 = var8.zzjA;
               int var27 = var24 + 1;
               var26[var24] = zza(var25, var1, var2, var3);
               ++var4;
               var24 = var27;
            }
         case 4:
            var8 = zzo(var5);
            var8.zzjB = com.google.android.gms.tagmanager.zzdf.zzg(zza(zzp(var5).zzjo, var1, var2, var3));
            break;
         case 7:
            var8 = zzo(var5);
            zzaf.zzh var10 = zzp(var5);
            var8.zzjF = new zzag.zza[var10.zzjn.length];
            int[] var11 = var10.zzjn;
            int var12 = var11.length;

            int var16;
            for(int var13 = 0; var4 < var12; var13 = var16) {
               int var14 = var11[var4];
               zzag.zza[] var15 = var8.zzjF;
               var16 = var13 + 1;
               var15[var13] = zza(var14, var1, var2, var3);
               ++var4;
            }
         }

         if(var8 == null) {
            zzgC("Invalid value: " + var5);
         }

         var2[var0] = var8;
         var3.remove(Integer.valueOf(var0));
         return var8;
      }
   }

   private static zzrs.zza zza(zzaf.zzb var0, zzaf.zzf var1, zzag.zza[] var2, int var3) throws zzrs.zzg {
      zzrs.zzb var4 = zzrs.zza.zzHH();
      int[] var5 = var0.zzit;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Integer var8 = Integer.valueOf(var5[var7]);
         zzaf.zze var9 = (zzaf.zze)zza(var1.zziJ, var8.intValue(), "properties");
         String var10 = (String)zza(var1.zziH, var9.key, "keys");
         zzag.zza var11 = (zzag.zza)zza(var2, var9.value, "values");
         if(zzae.zzgU.toString().equals(var10)) {
            var4.zzq(var11);
         } else {
            var4.zzb(var10, var11);
         }
      }

      return var4.zzHJ();
   }

   private static zzrs.zze zza(zzaf.zzg var0, List<zzrs.zza> var1, List<zzrs.zza> var2, List<zzrs.zza> var3, zzaf.zzf var4) {
      zzrs.zzf var5 = zzrs.zze.zzHO();
      int[] var6 = var0.zziX;
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         var5.zzd((zzrs.zza)var3.get(Integer.valueOf(var6[var8]).intValue()));
      }

      int[] var9 = var0.zziY;
      int var10 = var9.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         var5.zze((zzrs.zza)var3.get(Integer.valueOf(var9[var11]).intValue()));
      }

      int[] var12 = var0.zziZ;
      int var13 = var12.length;

      for(int var14 = 0; var14 < var13; ++var14) {
         var5.zzf((zzrs.zza)var1.get(Integer.valueOf(var12[var14]).intValue()));
      }

      int[] var15 = var0.zzjb;
      int var16 = var15.length;

      for(int var17 = 0; var17 < var16; ++var17) {
         Integer var45 = Integer.valueOf(var15[var17]);
         var5.zzgE(var4.zziI[var45.intValue()].zzjx);
      }

      int[] var18 = var0.zzja;
      int var19 = var18.length;

      for(int var20 = 0; var20 < var19; ++var20) {
         var5.zzg((zzrs.zza)var1.get(Integer.valueOf(var18[var20]).intValue()));
      }

      int[] var21 = var0.zzjc;
      int var22 = var21.length;

      for(int var23 = 0; var23 < var22; ++var23) {
         Integer var42 = Integer.valueOf(var21[var23]);
         var5.zzgF(var4.zziI[var42.intValue()].zzjx);
      }

      int[] var24 = var0.zzjd;
      int var25 = var24.length;

      for(int var26 = 0; var26 < var25; ++var26) {
         var5.zzh((zzrs.zza)var2.get(Integer.valueOf(var24[var26]).intValue()));
      }

      int[] var27 = var0.zzjf;
      int var28 = var27.length;

      for(int var29 = 0; var29 < var28; ++var29) {
         Integer var39 = Integer.valueOf(var27[var29]);
         var5.zzgG(var4.zziI[var39.intValue()].zzjx);
      }

      int[] var30 = var0.zzje;
      int var31 = var30.length;

      for(int var32 = 0; var32 < var31; ++var32) {
         var5.zzi((zzrs.zza)var2.get(Integer.valueOf(var30[var32]).intValue()));
      }

      int[] var33 = var0.zzjg;
      int var34 = var33.length;

      for(int var35 = 0; var35 < var34; ++var35) {
         Integer var36 = Integer.valueOf(var33[var35]);
         var5.zzgH(var4.zziI[var36.intValue()].zzjx);
      }

      return var5.zzHZ();
   }

   private static <T> T zza(T[] var0, int var1, String var2) throws zzrs.zzg {
      if(var1 < 0 || var1 >= var0.length) {
         zzgC("Index out of bounds detected: " + var1 + " in " + var2);
      }

      return var0[var1];
   }

   public static zzrs.zzc zzb(zzaf.zzf var0) throws zzrs.zzg {
      int var1 = 0;
      zzag.zza[] var2 = new zzag.zza[var0.zziI.length];

      for(int var3 = 0; var3 < var0.zziI.length; ++var3) {
         zza(var3, var0, var2, new HashSet(0));
      }

      zzrs.zzd var4 = zzrs.zzc.zzHK();
      ArrayList var5 = new ArrayList();

      for(int var6 = 0; var6 < var0.zziL.length; ++var6) {
         var5.add(zza(var0.zziL[var6], var0, var2, var6));
      }

      ArrayList var7 = new ArrayList();

      for(int var8 = 0; var8 < var0.zziM.length; ++var8) {
         var7.add(zza(var0.zziM[var8], var0, var2, var8));
      }

      ArrayList var9 = new ArrayList();

      for(int var10 = 0; var10 < var0.zziK.length; ++var10) {
         zzrs.zza var16 = zza(var0.zziK[var10], var0, var2, var10);
         var4.zzc(var16);
         var9.add(var16);
      }

      zzaf.zzg[] var11 = var0.zziN;

      for(int var12 = var11.length; var1 < var12; ++var1) {
         var4.zzb(zza(var11[var1], var5, var9, var7, var0));
      }

      var4.zzgD(var0.version);
      var4.zzko(var0.zziV);
      return var4.zzHN();
   }

   public static void zzb(InputStream var0, OutputStream var1) throws IOException {
      byte[] var2 = new byte[1024];

      while(true) {
         int var3 = var0.read(var2);
         if(var3 == -1) {
            return;
         }

         var1.write(var2, 0, var3);
      }
   }

   private static void zzgC(String var0) throws zzrs.zzg {
      com.google.android.gms.tagmanager.zzbg.method_353(var0);
      throw new zzrs.zzg(var0);
   }

   public static zzag.zza zzo(zzag.zza var0) {
      zzag.zza var1 = new zzag.zza();
      var1.type = var0.type;
      var1.zzjG = (int[])var0.zzjG.clone();
      if(var0.zzjH) {
         var1.zzjH = var0.zzjH;
      }

      return var1;
   }

   private static zzaf.zzh zzp(zzag.zza var0) throws zzrs.zzg {
      if((zzaf.zzh)var0.zza(zzaf.zzh.zzjh) == null) {
         zzgC("Expected a ServingValue and didn\'t get one. Value is: " + var0);
      }

      return (zzaf.zzh)var0.zza(zzaf.zzh.zzjh);
   }

   public static class zza {
      private final zzag.zza zzbkI;
      private final Map<String, zzag.zza> zzbmi;

      private zza(Map<String, zzag.zza> var1, zzag.zza var2) {
         this.zzbmi = var1;
         this.zzbkI = var2;
      }

      // $FF: synthetic method
      zza(Map var1, zzag.zza var2, Object var3) {
         this(var1, var2);
      }

      public static zzrs.zzb zzHH() {
         return new zzrs.zzb();
      }

      public String toString() {
         return "Properties: " + this.zzHI() + " pushAfterEvaluate: " + this.zzbkI;
      }

      public Map<String, zzag.zza> zzHI() {
         return Collections.unmodifiableMap(this.zzbmi);
      }

      public zzag.zza zzHh() {
         return this.zzbkI;
      }

      public void zza(String var1, zzag.zza var2) {
         this.zzbmi.put(var1, var2);
      }
   }

   public static class zzb {
      private zzag.zza zzbkI;
      private final Map<String, zzag.zza> zzbmi;

      private zzb() {
         this.zzbmi = new HashMap();
      }

      // $FF: synthetic method
      zzb(Object var1) {
         this();
      }

      public zzrs.zza zzHJ() {
         return new zzrs.zza(this.zzbmi, this.zzbkI);
      }

      public zzrs.zzb zzb(String var1, zzag.zza var2) {
         this.zzbmi.put(var1, var2);
         return this;
      }

      public zzrs.zzb zzq(zzag.zza var1) {
         this.zzbkI = var1;
         return this;
      }
   }

   public static class zzc {
      private final String zzadc;
      private final List<zzrs.zze> zzbmj;
      private final Map<String, List<zzrs.zza>> zzbmk;
      private final int zzbml;

      private zzc(List<zzrs.zze> var1, Map<String, List<zzrs.zza>> var2, String var3, int var4) {
         this.zzbmj = Collections.unmodifiableList(var1);
         this.zzbmk = Collections.unmodifiableMap(var2);
         this.zzadc = var3;
         this.zzbml = var4;
      }

      // $FF: synthetic method
      zzc(List var1, Map var2, String var3, int var4, Object var5) {
         this(var1, var2, var3, var4);
      }

      public static zzrs.zzd zzHK() {
         return new zzrs.zzd();
      }

      public String getVersion() {
         return this.zzadc;
      }

      public String toString() {
         return "Rules: " + this.zzHL() + "  Macros: " + this.zzbmk;
      }

      public List<zzrs.zze> zzHL() {
         return this.zzbmj;
      }

      public Map<String, List<zzrs.zza>> zzHM() {
         return this.zzbmk;
      }
   }

   public static class zzd {
      private String zzadc;
      private final List<zzrs.zze> zzbmj;
      private final Map<String, List<zzrs.zza>> zzbmk;
      private int zzbml;

      private zzd() {
         this.zzbmj = new ArrayList();
         this.zzbmk = new HashMap();
         this.zzadc = "";
         this.zzbml = 0;
      }

      // $FF: synthetic method
      zzd(Object var1) {
         this();
      }

      public zzrs.zzc zzHN() {
         return new zzrs.zzc(this.zzbmj, this.zzbmk, this.zzadc, this.zzbml);
      }

      public zzrs.zzd zzb(zzrs.zze var1) {
         this.zzbmj.add(var1);
         return this;
      }

      public zzrs.zzd zzc(zzrs.zza var1) {
         String var2 = com.google.android.gms.tagmanager.zzdf.zzg((zzag.zza)var1.zzHI().get(zzae.zzfR.toString()));
         Object var3 = (List)this.zzbmk.get(var2);
         if(var3 == null) {
            var3 = new ArrayList();
            this.zzbmk.put(var2, var3);
         }

         ((List)var3).add(var1);
         return this;
      }

      public zzrs.zzd zzgD(String var1) {
         this.zzadc = var1;
         return this;
      }

      public zzrs.zzd zzko(int var1) {
         this.zzbml = var1;
         return this;
      }
   }

   public static class zze {
      private final List<zzrs.zza> zzbmm;
      private final List<zzrs.zza> zzbmn;
      private final List<zzrs.zza> zzbmo;
      private final List<zzrs.zza> zzbmp;
      private final List<zzrs.zza> zzbmq;
      private final List<zzrs.zza> zzbmr;
      private final List<String> zzbms;
      private final List<String> zzbmt;
      private final List<String> zzbmu;
      private final List<String> zzbmv;

      private zze(List<zzrs.zza> var1, List<zzrs.zza> var2, List<zzrs.zza> var3, List<zzrs.zza> var4, List<zzrs.zza> var5, List<zzrs.zza> var6, List<String> var7, List<String> var8, List<String> var9, List<String> var10) {
         this.zzbmm = Collections.unmodifiableList(var1);
         this.zzbmn = Collections.unmodifiableList(var2);
         this.zzbmo = Collections.unmodifiableList(var3);
         this.zzbmp = Collections.unmodifiableList(var4);
         this.zzbmq = Collections.unmodifiableList(var5);
         this.zzbmr = Collections.unmodifiableList(var6);
         this.zzbms = Collections.unmodifiableList(var7);
         this.zzbmt = Collections.unmodifiableList(var8);
         this.zzbmu = Collections.unmodifiableList(var9);
         this.zzbmv = Collections.unmodifiableList(var10);
      }

      // $FF: synthetic method
      zze(List var1, List var2, List var3, List var4, List var5, List var6, List var7, List var8, List var9, List var10, Object var11) {
         this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

      public static zzrs.zzf zzHO() {
         return new zzrs.zzf();
      }

      public String toString() {
         return "Positive predicates: " + this.zzHP() + "  Negative predicates: " + this.zzHQ() + "  Add tags: " + this.zzHR() + "  Remove tags: " + this.zzHS() + "  Add macros: " + this.zzHT() + "  Remove macros: " + this.zzHY();
      }

      public List<zzrs.zza> zzHP() {
         return this.zzbmm;
      }

      public List<zzrs.zza> zzHQ() {
         return this.zzbmn;
      }

      public List<zzrs.zza> zzHR() {
         return this.zzbmo;
      }

      public List<zzrs.zza> zzHS() {
         return this.zzbmp;
      }

      public List<zzrs.zza> zzHT() {
         return this.zzbmq;
      }

      public List<String> zzHU() {
         return this.zzbms;
      }

      public List<String> zzHV() {
         return this.zzbmt;
      }

      public List<String> zzHW() {
         return this.zzbmu;
      }

      public List<String> zzHX() {
         return this.zzbmv;
      }

      public List<zzrs.zza> zzHY() {
         return this.zzbmr;
      }
   }

   public static class zzf {
      private final List<zzrs.zza> zzbmm;
      private final List<zzrs.zza> zzbmn;
      private final List<zzrs.zza> zzbmo;
      private final List<zzrs.zza> zzbmp;
      private final List<zzrs.zza> zzbmq;
      private final List<zzrs.zza> zzbmr;
      private final List<String> zzbms;
      private final List<String> zzbmt;
      private final List<String> zzbmu;
      private final List<String> zzbmv;

      private zzf() {
         this.zzbmm = new ArrayList();
         this.zzbmn = new ArrayList();
         this.zzbmo = new ArrayList();
         this.zzbmp = new ArrayList();
         this.zzbmq = new ArrayList();
         this.zzbmr = new ArrayList();
         this.zzbms = new ArrayList();
         this.zzbmt = new ArrayList();
         this.zzbmu = new ArrayList();
         this.zzbmv = new ArrayList();
      }

      // $FF: synthetic method
      zzf(Object var1) {
         this();
      }

      public zzrs.zze zzHZ() {
         return new zzrs.zze(this.zzbmm, this.zzbmn, this.zzbmo, this.zzbmp, this.zzbmq, this.zzbmr, this.zzbms, this.zzbmt, this.zzbmu, this.zzbmv);
      }

      public zzrs.zzf zzd(zzrs.zza var1) {
         this.zzbmm.add(var1);
         return this;
      }

      public zzrs.zzf zze(zzrs.zza var1) {
         this.zzbmn.add(var1);
         return this;
      }

      public zzrs.zzf zzf(zzrs.zza var1) {
         this.zzbmo.add(var1);
         return this;
      }

      public zzrs.zzf zzg(zzrs.zza var1) {
         this.zzbmp.add(var1);
         return this;
      }

      public zzrs.zzf zzgE(String var1) {
         this.zzbmu.add(var1);
         return this;
      }

      public zzrs.zzf zzgF(String var1) {
         this.zzbmv.add(var1);
         return this;
      }

      public zzrs.zzf zzgG(String var1) {
         this.zzbms.add(var1);
         return this;
      }

      public zzrs.zzf zzgH(String var1) {
         this.zzbmt.add(var1);
         return this;
      }

      public zzrs.zzf zzh(zzrs.zza var1) {
         this.zzbmq.add(var1);
         return this;
      }

      public zzrs.zzf zzi(zzrs.zza var1) {
         this.zzbmr.add(var1);
         return this;
      }
   }

   public static class zzg extends Exception {
      public zzg(String var1) {
         super(var1);
      }
   }
}
