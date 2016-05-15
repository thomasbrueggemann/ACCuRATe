package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzaa;
import com.google.android.gms.tagmanager.zzab;
import com.google.android.gms.tagmanager.zzad;
import com.google.android.gms.tagmanager.zzae;
import com.google.android.gms.tagmanager.zzaf;
import com.google.android.gms.tagmanager.zzag;
import com.google.android.gms.tagmanager.zzah;
import com.google.android.gms.tagmanager.zzai;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzam;
import com.google.android.gms.tagmanager.zzan;
import com.google.android.gms.tagmanager.zzao;
import com.google.android.gms.tagmanager.zzap;
import com.google.android.gms.tagmanager.zzaw;
import com.google.android.gms.tagmanager.zzay;
import com.google.android.gms.tagmanager.zzb;
import com.google.android.gms.tagmanager.zzbb;
import com.google.android.gms.tagmanager.zzbc;
import com.google.android.gms.tagmanager.zzbd;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzbi;
import com.google.android.gms.tagmanager.zzbj;
import com.google.android.gms.tagmanager.zzbk;
import com.google.android.gms.tagmanager.zzbu;
import com.google.android.gms.tagmanager.zzbw;
import com.google.android.gms.tagmanager.zzbx;
import com.google.android.gms.tagmanager.zzbz;
import com.google.android.gms.tagmanager.zzc;
import com.google.android.gms.tagmanager.zzcc;
import com.google.android.gms.tagmanager.zzce;
import com.google.android.gms.tagmanager.zzcf;
import com.google.android.gms.tagmanager.zzcg;
import com.google.android.gms.tagmanager.zzch;
import com.google.android.gms.tagmanager.zzcj;
import com.google.android.gms.tagmanager.zzck;
import com.google.android.gms.tagmanager.zzco;
import com.google.android.gms.tagmanager.zzcq;
import com.google.android.gms.tagmanager.zzcr;
import com.google.android.gms.tagmanager.zzcy;
import com.google.android.gms.tagmanager.zzda;
import com.google.android.gms.tagmanager.zzdb;
import com.google.android.gms.tagmanager.zzdf;
import com.google.android.gms.tagmanager.zzdg;
import com.google.android.gms.tagmanager.zzdh;
import com.google.android.gms.tagmanager.zzdi;
import com.google.android.gms.tagmanager.zzdj;
import com.google.android.gms.tagmanager.zze;
import com.google.android.gms.tagmanager.zzf;
import com.google.android.gms.tagmanager.zzg;
import com.google.android.gms.tagmanager.zzh;
import com.google.android.gms.tagmanager.zzi;
import com.google.android.gms.tagmanager.zzj;
import com.google.android.gms.tagmanager.zzl;
import com.google.android.gms.tagmanager.zzm;
import com.google.android.gms.tagmanager.zzn;
import com.google.android.gms.tagmanager.zzq;
import com.google.android.gms.tagmanager.zzr;
import com.google.android.gms.tagmanager.zzt;
import com.google.android.gms.tagmanager.zzv;
import com.google.android.gms.tagmanager.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class zzcp {
   private static final zzbw<com.google.android.gms.internal.zzag.zza> zzbkq = new zzbw(zzdf.zzHF(), true);
   private final DataLayer zzbhN;
   private volatile String zzbkA;
   private int zzbkB;
   private final zzrs.zzc zzbkr;
   private final zzah zzbks;
   private final Map<String, zzak> zzbkt;
   private final Map<String, zzak> zzbku;
   private final Map<String, zzak> zzbkv;
   private final zzl<zzrs.zza, zzbw<com.google.android.gms.internal.zzag.zza>> zzbkw;
   private final zzl<String, zzcp.zzb> zzbkx;
   private final Set<zzrs.zze> zzbky;
   private final Map<String, zzcp.zzc> zzbkz;

   public zzcp(Context var1, zzrs.zzc var2, DataLayer var3, zzt.zza var4, zzt.zza var5, zzah var6) {
      if(var2 == null) {
         throw new NullPointerException("resource cannot be null");
      } else {
         this.zzbkr = var2;
         this.zzbky = new HashSet(var2.zzHL());
         this.zzbhN = var3;
         this.zzbks = var6;
         zzm.zza var7 = new zzm.zza() {
            // $FF: synthetic method
            public int sizeOf(Object var1, Object var2) {
               return this.zza((zzrs.zza)var1, (zzbw)var2);
            }

            public int zza(zzrs.zza var1, zzbw<com.google.android.gms.internal.zzag.zza> var2) {
               return ((com.google.android.gms.internal.zzag.zza)var2.getObject()).getCachedSize();
            }
         };
         this.zzbkw = (new zzm()).zza(1048576, var7);
         zzm.zza var8 = new zzm.zza() {
            // $FF: synthetic method
            public int sizeOf(Object var1, Object var2) {
               return this.zza((String)var1, (zzcp.zzb)var2);
            }

            public int zza(String var1, zzcp.zzb var2) {
               return var1.length() + var2.getSize();
            }
         };
         this.zzbkx = (new zzm()).zza(1048576, var8);
         this.zzbkt = new HashMap();
         this.zzb(new zzj(var1));
         this.zzb(new zzt(var5));
         this.zzb(new zzx(var3));
         this.zzb(new zzdg(var1, var3));
         this.zzb(new zzdb(var1, var3));
         this.zzbku = new HashMap();
         this.zzc(new zzr());
         this.zzc(new zzae());
         this.zzc(new zzaf());
         this.zzc(new zzam());
         this.zzc(new zzan());
         this.zzc(new zzbc());
         this.zzc(new zzbd());
         this.zzc(new zzcf());
         this.zzc(new zzcy());
         this.zzbkv = new HashMap();
         this.zza((zzak)(new zzb(var1)));
         this.zza((zzak)(new zzc(var1)));
         this.zza((zzak)(new zze(var1)));
         this.zza((zzak)(new zzf(var1)));
         this.zza((zzak)(new zzg(var1)));
         this.zza((zzak)(new zzh(var1)));
         this.zza((zzak)(new zzi(var1)));
         this.zza((zzak)(new zzn()));
         this.zza((zzak)(new zzq(this.zzbkr.getVersion())));
         this.zza((zzak)(new zzt(var4)));
         this.zza((zzak)(new zzv(var3)));
         this.zza((zzak)(new zzaa(var1)));
         this.zza((zzak)(new zzab()));
         this.zza((zzak)(new zzad()));
         this.zza((zzak)(new zzai(this)));
         this.zza((zzak)(new zzao()));
         this.zza((zzak)(new zzap()));
         this.zza((zzak)(new zzaw(var1)));
         this.zza((zzak)(new zzay()));
         this.zza((zzak)(new zzbb()));
         this.zza((zzak)(new zzbi()));
         this.zza((zzak)(new zzbk(var1)));
         this.zza((zzak)(new zzbx()));
         this.zza((zzak)(new zzbz()));
         this.zza((zzak)(new zzcc()));
         this.zza((zzak)(new zzce()));
         this.zza((zzak)(new zzcg(var1)));
         this.zza((zzak)(new zzcq()));
         this.zza((zzak)(new zzcr()));
         this.zza((zzak)(new zzda()));
         this.zza((zzak)(new zzdh()));
         this.zzbkz = new HashMap();
         Iterator var9 = this.zzbky.iterator();

         while(var9.hasNext()) {
            zzrs.zze var14 = (zzrs.zze)var9.next();
            if(var6.zzGA()) {
               zza(var14.zzHT(), var14.zzHU(), "add macro");
               zza(var14.zzHY(), var14.zzHV(), "remove macro");
               zza(var14.zzHR(), var14.zzHW(), "add tag");
               zza(var14.zzHS(), var14.zzHX(), "remove tag");
            }

            for(int var15 = 0; var15 < var14.zzHT().size(); ++var15) {
               zzrs.zza var20 = (zzrs.zza)var14.zzHT().get(var15);
               String var21 = "Unknown";
               if(var6.zzGA() && var15 < var14.zzHU().size()) {
                  var21 = (String)var14.zzHU().get(var15);
               }

               zzcp.zzc var22 = zzi(this.zzbkz, zza(var20));
               var22.zza(var14);
               var22.zza(var14, var20);
               var22.zza(var14, var21);
            }

            for(int var16 = 0; var16 < var14.zzHY().size(); ++var16) {
               zzrs.zza var17 = (zzrs.zza)var14.zzHY().get(var16);
               String var18 = "Unknown";
               if(var6.zzGA() && var16 < var14.zzHV().size()) {
                  var18 = (String)var14.zzHV().get(var16);
               }

               zzcp.zzc var19 = zzi(this.zzbkz, zza(var17));
               var19.zza(var14);
               var19.zzb(var14, var17);
               var19.zzb(var14, var18);
            }
         }

         Iterator var10 = this.zzbkr.zzHM().entrySet().iterator();

         while(var10.hasNext()) {
            Entry var11 = (Entry)var10.next();
            Iterator var12 = ((List)var11.getValue()).iterator();

            while(var12.hasNext()) {
               zzrs.zza var13 = (zzrs.zza)var12.next();
               if(!zzdf.zzk((com.google.android.gms.internal.zzag.zza)var13.zzHI().get(com.google.android.gms.internal.zzae.zzgt.toString())).booleanValue()) {
                  zzi(this.zzbkz, (String)var11.getKey()).zzb(var13);
               }
            }
         }

      }
   }

   private String zzHf() {
      if(this.zzbkB <= 1) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append(Integer.toString(this.zzbkB));

         for(int var3 = 2; var3 < this.zzbkB; ++var3) {
            var1.append(' ');
         }

         var1.append(": ");
         return var1.toString();
      }
   }

   private zzbw<com.google.android.gms.internal.zzag.zza> zza(com.google.android.gms.internal.zzag.zza var1, Set<String> var2, zzdi var3) {
      if(!var1.zzjH) {
         return new zzbw(var1, true);
      } else {
         switch(var1.type) {
         case 2:
            com.google.android.gms.internal.zzag.zza var14 = zzrs.zzo(var1);
            var14.zzjy = new com.google.android.gms.internal.zzag.zza[var1.zzjy.length];

            for(int var15 = 0; var15 < var1.zzjy.length; ++var15) {
               zzbw var16 = this.zza(var1.zzjy[var15], var2, var3.zzkh(var15));
               if(var16 == zzbkq) {
                  return zzbkq;
               }

               var14.zzjy[var15] = (com.google.android.gms.internal.zzag.zza)var16.getObject();
            }

            return new zzbw(var14, false);
         case 3:
            com.google.android.gms.internal.zzag.zza var10 = zzrs.zzo(var1);
            if(var1.zzjz.length != var1.zzjA.length) {
               zzbg.method_353("Invalid serving value: " + var1.toString());
               return zzbkq;
            } else {
               var10.zzjz = new com.google.android.gms.internal.zzag.zza[var1.zzjz.length];
               var10.zzjA = new com.google.android.gms.internal.zzag.zza[var1.zzjz.length];

               for(int var11 = 0; var11 < var1.zzjz.length; ++var11) {
                  zzbw var12 = this.zza(var1.zzjz[var11], var2, var3.zzki(var11));
                  zzbw var13 = this.zza(var1.zzjA[var11], var2, var3.zzkj(var11));
                  if(var12 == zzbkq || var13 == zzbkq) {
                     return zzbkq;
                  }

                  var10.zzjz[var11] = (com.google.android.gms.internal.zzag.zza)var12.getObject();
                  var10.zzjA[var11] = (com.google.android.gms.internal.zzag.zza)var13.getObject();
               }

               return new zzbw(var10, false);
            }
         case 4:
            if(var2.contains(var1.zzjB)) {
               zzbg.method_353("Macro cycle detected.  Current macro reference: " + var1.zzjB + "." + "  Previous macro references: " + var2.toString() + ".");
               return zzbkq;
            }

            var2.add(var1.zzjB);
            zzbw var8 = zzdj.zza(this.zza(var1.zzjB, var2, var3.zzGO()), var1.zzjG);
            var2.remove(var1.zzjB);
            return var8;
         case 5:
         case 6:
         default:
            zzbg.method_353("Unknown type: " + var1.type);
            return zzbkq;
         case 7:
            com.google.android.gms.internal.zzag.zza var4 = zzrs.zzo(var1);
            var4.zzjF = new com.google.android.gms.internal.zzag.zza[var1.zzjF.length];

            for(int var5 = 0; var5 < var1.zzjF.length; ++var5) {
               zzbw var6 = this.zza(var1.zzjF[var5], var2, var3.zzkk(var5));
               if(var6 == zzbkq) {
                  return zzbkq;
               }

               var4.zzjF[var5] = (com.google.android.gms.internal.zzag.zza)var6.getObject();
            }

            return new zzbw(var4, false);
         }
      }
   }

   private zzbw<com.google.android.gms.internal.zzag.zza> zza(String var1, Set<String> var2, zzbj var3) {
      ++this.zzbkB;
      zzcp.zzb var4 = (zzcp.zzb)this.zzbkx.get(var1);
      if(var4 != null && !this.zzbks.zzGA()) {
         this.zza(var4.zzHh(), var2);
         this.zzbkB += -1;
         return var4.zzHg();
      } else {
         zzcp.zzc var5 = (zzcp.zzc)this.zzbkz.get(var1);
         if(var5 == null) {
            zzbg.method_353(this.zzHf() + "Invalid macro: " + var1);
            this.zzbkB += -1;
            return zzbkq;
         } else {
            zzbw var6 = this.zza(var1, var5.zzHi(), var5.zzHj(), var5.zzHk(), var5.zzHm(), var5.zzHl(), var2, var3.zzGq());
            zzrs.zza var7;
            if(((Set)var6.getObject()).isEmpty()) {
               var7 = var5.zzHn();
            } else {
               if(((Set)var6.getObject()).size() > 1) {
                  zzbg.zzaK(this.zzHf() + "Multiple macros active for macroName " + var1);
               }

               var7 = (zzrs.zza)((Set)var6.getObject()).iterator().next();
            }

            if(var7 == null) {
               this.zzbkB += -1;
               return zzbkq;
            } else {
               zzbw var8 = this.zza(this.zzbkv, var7, var2, var3.zzGG());
               boolean var9;
               if(var6.zzGP() && var8.zzGP()) {
                  var9 = true;
               } else {
                  var9 = false;
               }

               zzbw var10;
               if(var8 == zzbkq) {
                  var10 = zzbkq;
               } else {
                  var10 = new zzbw(var8.getObject(), var9);
               }

               com.google.android.gms.internal.zzag.zza var11 = var7.zzHh();
               if(var10.zzGP()) {
                  this.zzbkx.zzh(var1, new zzcp.zzb(var10, var11));
               }

               this.zza(var11, var2);
               this.zzbkB += -1;
               return var10;
            }
         }
      }
   }

   private zzbw<com.google.android.gms.internal.zzag.zza> zza(Map<String, zzak> var1, zzrs.zza var2, Set<String> var3, zzch var4) {
      boolean var5 = true;
      com.google.android.gms.internal.zzag.zza var6 = (com.google.android.gms.internal.zzag.zza)var2.zzHI().get(com.google.android.gms.internal.zzae.zzfG.toString());
      zzbw var9;
      if(var6 == null) {
         zzbg.method_353("No function id in properties");
         var9 = zzbkq;
      } else {
         String var7 = var6.zzjC;
         zzak var8 = (zzak)var1.get(var7);
         if(var8 == null) {
            zzbg.method_353(var7 + " has no backing implementation.");
            return zzbkq;
         }

         var9 = (zzbw)this.zzbkw.get(var2);
         if(var9 == null || this.zzbks.zzGA()) {
            HashMap var10 = new HashMap();
            Iterator var11 = var2.zzHI().entrySet().iterator();

            boolean var12;
            boolean var17;
            for(var12 = var5; var11.hasNext(); var12 = var17) {
               Entry var14 = (Entry)var11.next();
               zzcj var15 = var4.zzgj((String)var14.getKey());
               zzbw var16 = this.zza((com.google.android.gms.internal.zzag.zza)var14.getValue(), var3, var15.zze((com.google.android.gms.internal.zzag.zza)var14.getValue()));
               if(var16 == zzbkq) {
                  return zzbkq;
               }

               if(var16.zzGP()) {
                  var2.zza((String)var14.getKey(), (com.google.android.gms.internal.zzag.zza)var16.getObject());
                  var17 = var12;
               } else {
                  var17 = false;
               }

               var10.put(var14.getKey(), var16.getObject());
            }

            if(!var8.zze(var10.keySet())) {
               zzbg.method_353("Incorrect keys for function " + var7 + " required " + var8.zzGC() + " had " + var10.keySet());
               return zzbkq;
            }

            if(!var12 || !var8.zzFW()) {
               var5 = false;
            }

            zzbw var13 = new zzbw(var8.zzP(var10), var5);
            if(var5) {
               this.zzbkw.zzh(var2, var13);
            }

            var4.zzd((com.google.android.gms.internal.zzag.zza)var13.getObject());
            return var13;
         }
      }

      return var9;
   }

   private zzbw<Set<zzrs.zza>> zza(Set<zzrs.zze> var1, Set<String> var2, zzcp.zza var3, zzco var4) {
      HashSet var5 = new HashSet();
      HashSet var6 = new HashSet();
      Iterator var7 = var1.iterator();

      boolean var8;
      boolean var13;
      for(var8 = true; var7.hasNext(); var8 = var13) {
         zzrs.zze var10 = (zzrs.zze)var7.next();
         zzck var11 = var4.zzGN();
         zzbw var12 = this.zza(var10, var2, var11);
         if(((Boolean)var12.getObject()).booleanValue()) {
            var3.zza(var10, var5, var6, var11);
         }

         if(var8 && var12.zzGP()) {
            var13 = true;
         } else {
            var13 = false;
         }
      }

      var5.removeAll(var6);
      var4.zzf(var5);
      return new zzbw(var5, var8);
   }

   private static String zza(zzrs.zza var0) {
      return zzdf.zzg((com.google.android.gms.internal.zzag.zza)var0.zzHI().get(com.google.android.gms.internal.zzae.zzfR.toString()));
   }

   private void zza(com.google.android.gms.internal.zzag.zza var1, Set<String> var2) {
      if(var1 != null) {
         zzbw var3 = this.zza((com.google.android.gms.internal.zzag.zza)var1, (Set)var2, (zzdi)(new zzbu()));
         if(var3 != zzbkq) {
            Object var4 = zzdf.zzl((com.google.android.gms.internal.zzag.zza)var3.getObject());
            if(var4 instanceof Map) {
               Map var8 = (Map)var4;
               this.zzbhN.push(var8);
               return;
            }

            if(!(var4 instanceof List)) {
               zzbg.zzaK("pushAfterEvaluate: value not a Map or List");
               return;
            }

            Iterator var5 = ((List)var4).iterator();

            while(var5.hasNext()) {
               Object var6 = var5.next();
               if(var6 instanceof Map) {
                  Map var7 = (Map)var6;
                  this.zzbhN.push(var7);
               } else {
                  zzbg.zzaK("pushAfterEvaluate: value not a Map");
               }
            }
         }
      }

   }

   private static void zza(List<zzrs.zza> var0, List<String> var1, String var2) {
      if(var0.size() != var1.size()) {
         zzbg.zzaJ("Invalid resource: imbalance of rule names of functions for " + var2 + " operation. Using default rule name instead");
      }

   }

   private static void zza(Map<String, zzak> var0, zzak var1) {
      if(var0.containsKey(var1.zzGB())) {
         throw new IllegalArgumentException("Duplicate function type name: " + var1.zzGB());
      } else {
         var0.put(var1.zzGB(), var1);
      }
   }

   private static zzcp.zzc zzi(Map<String, zzcp.zzc> var0, String var1) {
      zzcp.zzc var2 = (zzcp.zzc)var0.get(var1);
      if(var2 == null) {
         var2 = new zzcp.zzc();
         var0.put(var1, var2);
      }

      return var2;
   }

   public void zzF(List<com.google.android.gms.internal.zzaf.zzi> param1) {
      // $FF: Couldn't be decompiled
   }

   String zzHe() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.zzbkA;
      } finally {
         ;
      }

      return var2;
   }

   zzbw<Boolean> zza(zzrs.zza var1, Set<String> var2, zzch var3) {
      zzbw var4 = this.zza(this.zzbku, var1, var2, var3);
      Boolean var5 = zzdf.zzk((com.google.android.gms.internal.zzag.zza)var4.getObject());
      var3.zzd(zzdf.zzR(var5));
      return new zzbw(var5, var4.zzGP());
   }

   zzbw<Boolean> zza(zzrs.zze var1, Set<String> var2, zzck var3) {
      Iterator var4 = var1.zzHQ().iterator();

      boolean var5;
      boolean var9;
      for(var5 = true; var4.hasNext(); var5 = var9) {
         zzbw var8 = this.zza((zzrs.zza)var4.next(), var2, var3.zzGH());
         if(((Boolean)var8.getObject()).booleanValue()) {
            var3.zzf(zzdf.zzR(Boolean.valueOf(false)));
            return new zzbw(Boolean.valueOf(false), var8.zzGP());
         }

         if(var5 && var8.zzGP()) {
            var9 = true;
         } else {
            var9 = false;
         }
      }

      Iterator var6 = var1.zzHP().iterator();

      while(true) {
         while(var6.hasNext()) {
            zzbw var7 = this.zza((zzrs.zza)var6.next(), var2, var3.zzGI());
            if(!((Boolean)var7.getObject()).booleanValue()) {
               var3.zzf(zzdf.zzR(Boolean.valueOf(false)));
               return new zzbw(Boolean.valueOf(false), var7.zzGP());
            }

            if(var5 && var7.zzGP()) {
               var5 = true;
            } else {
               var5 = false;
            }
         }

         var3.zzf(zzdf.zzR(Boolean.valueOf(true)));
         return new zzbw(Boolean.valueOf(true), var5);
      }
   }

   zzbw<Set<zzrs.zza>> zza(String var1, Set<zzrs.zze> var2, final Map<zzrs.zze, List<zzrs.zza>> var3, final Map<zzrs.zze, List<String>> var4, final Map<zzrs.zze, List<zzrs.zza>> var5, final Map<zzrs.zze, List<String>> var6, Set<String> var7, zzco var8) {
      return this.zza(var2, var7, new zzcp.zza() {
         public void zza(zzrs.zze var1, Set<zzrs.zza> var2, Set<zzrs.zza> var3x, zzck var4x) {
            List var5x = (List)var3.get(var1);
            List var6x = (List)var4.get(var1);
            if(var5x != null) {
               var2.addAll(var5x);
               var4x.zzGJ().zzc(var5x, var6x);
            }

            List var7 = (List)var5.get(var1);
            List var8 = (List)var6.get(var1);
            if(var7 != null) {
               var3x.addAll(var7);
               var4x.zzGK().zzc(var7, var8);
            }

         }
      }, var8);
   }

   zzbw<Set<zzrs.zza>> zza(Set<zzrs.zze> var1, zzco var2) {
      return this.zza((Set)var1, (Set)(new HashSet()), (zzcp.zza)(new zzcp.zza() {
         public void zza(zzrs.zze var1, Set<zzrs.zza> var2, Set<zzrs.zza> var3, zzck var4) {
            var2.addAll(var1.zzHR());
            var3.addAll(var1.zzHS());
            var4.zzGL().zzc(var1.zzHR(), var1.zzHW());
            var4.zzGM().zzc(var1.zzHS(), var1.zzHX());
         }
      }), (zzco)var2);
   }

   void zza(zzak var1) {
      zza(this.zzbkv, var1);
   }

   void zzb(zzak var1) {
      zza(this.zzbkt, var1);
   }

   void zzc(zzak var1) {
      zza(this.zzbku, var1);
   }

   public void zzfR(String param1) {
      // $FF: Couldn't be decompiled
   }

   public zzbw<com.google.android.gms.internal.zzag.zza> zzgn(String var1) {
      this.zzbkB = 0;
      zzag var2 = this.zzbks.zzgd(var1);
      zzbw var3 = this.zza((String)var1, (Set)(new HashSet()), (zzbj)var2.zzGx());
      var2.zzGz();
      return var3;
   }

   void zzgo(String var1) {
      synchronized(this){}

      try {
         this.zzbkA = var1;
      } finally {
         ;
      }

   }

   interface zza {
      void zza(zzrs.zze var1, Set<zzrs.zza> var2, Set<zzrs.zza> var3, zzck var4);
   }

   private static class zzb {
      private zzbw<com.google.android.gms.internal.zzag.zza> zzbkH;
      private com.google.android.gms.internal.zzag.zza zzbkI;

      public zzb(zzbw<com.google.android.gms.internal.zzag.zza> var1, com.google.android.gms.internal.zzag.zza var2) {
         this.zzbkH = var1;
         this.zzbkI = var2;
      }

      public int getSize() {
         int var1 = ((com.google.android.gms.internal.zzag.zza)this.zzbkH.getObject()).getCachedSize();
         int var2;
         if(this.zzbkI == null) {
            var2 = 0;
         } else {
            var2 = this.zzbkI.getCachedSize();
         }

         return var2 + var1;
      }

      public zzbw<com.google.android.gms.internal.zzag.zza> zzHg() {
         return this.zzbkH;
      }

      public com.google.android.gms.internal.zzag.zza zzHh() {
         return this.zzbkI;
      }
   }

   private static class zzc {
      private final Map<zzrs.zze, List<zzrs.zza>> zzbkJ = new HashMap();
      private final Map<zzrs.zze, List<zzrs.zza>> zzbkK = new HashMap();
      private final Map<zzrs.zze, List<String>> zzbkL = new HashMap();
      private final Map<zzrs.zze, List<String>> zzbkM = new HashMap();
      private zzrs.zza zzbkN;
      private final Set<zzrs.zze> zzbky = new HashSet();

      public Set<zzrs.zze> zzHi() {
         return this.zzbky;
      }

      public Map<zzrs.zze, List<zzrs.zza>> zzHj() {
         return this.zzbkJ;
      }

      public Map<zzrs.zze, List<String>> zzHk() {
         return this.zzbkL;
      }

      public Map<zzrs.zze, List<String>> zzHl() {
         return this.zzbkM;
      }

      public Map<zzrs.zze, List<zzrs.zza>> zzHm() {
         return this.zzbkK;
      }

      public zzrs.zza zzHn() {
         return this.zzbkN;
      }

      public void zza(zzrs.zze var1) {
         this.zzbky.add(var1);
      }

      public void zza(zzrs.zze var1, zzrs.zza var2) {
         Object var3 = (List)this.zzbkJ.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.zzbkJ.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      public void zza(zzrs.zze var1, String var2) {
         Object var3 = (List)this.zzbkL.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.zzbkL.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      public void zzb(zzrs.zza var1) {
         this.zzbkN = var1;
      }

      public void zzb(zzrs.zze var1, zzrs.zza var2) {
         Object var3 = (List)this.zzbkK.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.zzbkK.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      public void zzb(zzrs.zze var1, String var2) {
         Object var3 = (List)this.zzbkM.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.zzbkM.put(var1, var3);
         }

         ((List)var3).add(var2);
      }
   }
}
