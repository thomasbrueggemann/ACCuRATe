package com.google.android.gms.measurement.internal;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzi;
import com.google.android.gms.measurement.internal.zzs;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

class zzc extends zzz {
   zzc(zzw var1) {
      super(var1);
   }

   private Boolean zza(zzpz.zzb var1, zzqb.zzb var2, long var3) {
      if(var1.zzaZz != null) {
         Boolean var28 = (new zzs(var1.zzaZz)).zzac(var3);
         if(var28 == null) {
            return null;
         }

         if(!var28.booleanValue()) {
            return Boolean.valueOf(false);
         }
      }

      HashSet var5 = new HashSet();
      zzpz.zzc[] var6 = var1.zzaZx;
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         zzpz.zzc var26 = var6[var8];
         if(TextUtils.isEmpty(var26.zzaZE)) {
            this.zzAo().zzCF().zzj("null or empty param name in filter. event", var2.name);
            return null;
         }

         var5.add(var26.zzaZE);
      }

      ArrayMap var9 = new ArrayMap();
      zzqb.zzc[] var10 = var2.zzbae;
      int var11 = var10.length;

      for(int var12 = 0; var12 < var11; ++var12) {
         zzqb.zzc var22 = var10[var12];
         if(var5.contains(var22.name)) {
            if(var22.zzbai != null) {
               var9.put(var22.name, var22.zzbai);
            } else if(var22.zzaZo != null) {
               var9.put(var22.name, var22.zzaZo);
            } else {
               if(var22.zzamJ == null) {
                  this.zzAo().zzCF().zze("Unknown value for param. event, param", var2.name, var22.name);
                  return null;
               }

               var9.put(var22.name, var22.zzamJ);
            }
         }
      }

      zzpz.zzc[] var13 = var1.zzaZx;
      int var14 = var13.length;

      for(int var15 = 0; var15 < var14; ++var15) {
         zzpz.zzc var16 = var13[var15];
         String var17 = var16.zzaZE;
         if(TextUtils.isEmpty(var17)) {
            this.zzAo().zzCF().zzj("Event has empty param name. event", var2.name);
            return null;
         }

         Object var18 = var9.get(var17);
         if(var18 instanceof Long) {
            if(var16.zzaZC == null) {
               this.zzAo().zzCF().zze("No number filter for long param. event, param", var2.name, var17);
               return null;
            }

            Boolean var21 = (new zzs(var16.zzaZC)).zzac(((Long)var18).longValue());
            if(var21 == null) {
               return null;
            }

            if(!var21.booleanValue()) {
               return Boolean.valueOf(false);
            }
         } else if(var18 instanceof Float) {
            if(var16.zzaZC == null) {
               this.zzAo().zzCF().zze("No number filter for float param. event, param", var2.name, var17);
               return null;
            }

            Boolean var20 = (new zzs(var16.zzaZC)).zzi(((Float)var18).floatValue());
            if(var20 == null) {
               return null;
            }

            if(!var20.booleanValue()) {
               return Boolean.valueOf(false);
            }
         } else {
            if(!(var18 instanceof String)) {
               if(var18 == null) {
                  this.zzAo().zzCK().zze("Missing param for filter. event, param", var2.name, var17);
                  return Boolean.valueOf(false);
               }

               this.zzAo().zzCF().zze("Unknown param type. event, param", var2.name, var17);
               return null;
            }

            if(var16.zzaZB == null) {
               this.zzAo().zzCF().zze("No string filter for String param. event, param", var2.name, var17);
               return null;
            }

            Boolean var19 = (new zzae(var16.zzaZB)).zzfp((String)var18);
            if(var19 == null) {
               return null;
            }

            if(!var19.booleanValue()) {
               return Boolean.valueOf(false);
            }
         }
      }

      return Boolean.valueOf(true);
   }

   private Boolean zza(zzpz.zze var1, zzqb.zzg var2) {
      zzpz.zzc var3 = var1.zzaZM;
      if(var3 == null) {
         this.zzAo().zzCF().zzj("Missing property filter. property", var2.name);
         return null;
      } else if(var2.zzbai != null) {
         if(var3.zzaZC == null) {
            this.zzAo().zzCF().zzj("No number filter for long property. property", var2.name);
            return null;
         } else {
            return (new zzs(var3.zzaZC)).zzac(var2.zzbai.longValue());
         }
      } else if(var2.zzaZo != null) {
         if(var3.zzaZC == null) {
            this.zzAo().zzCF().zzj("No number filter for float property. property", var2.name);
            return null;
         } else {
            return (new zzs(var3.zzaZC)).zzi(var2.zzaZo.floatValue());
         }
      } else if(var2.zzamJ != null) {
         if(var3.zzaZB == null) {
            if(var3.zzaZC == null) {
               this.zzAo().zzCF().zzj("No string or number filter defined. property", var2.name);
               return null;
            } else {
               zzs var4 = new zzs(var3.zzaZC);
               if(!var3.zzaZC.zzaZG.booleanValue()) {
                  if(this.zzeQ(var2.zzamJ)) {
                     try {
                        Boolean var8 = var4.zzac(Long.parseLong(var2.zzamJ));
                        return var8;
                     } catch (NumberFormatException var9) {
                        this.zzAo().zzCF().zze("User property value exceeded Long value range. property, value", var2.name, var2.zzamJ);
                        return null;
                     }
                  } else {
                     this.zzAo().zzCF().zze("Invalid user property value for Long number filter. property, value", var2.name, var2.zzamJ);
                     return null;
                  }
               } else if(this.zzeR(var2.zzamJ)) {
                  try {
                     float var6 = Float.parseFloat(var2.zzamJ);
                     if(!Float.isInfinite(var6)) {
                        return var4.zzi(var6);
                     } else {
                        this.zzAo().zzCF().zze("User property value exceeded Float value range. property, value", var2.name, var2.zzamJ);
                        return null;
                     }
                  } catch (NumberFormatException var10) {
                     this.zzAo().zzCF().zze("User property value exceeded Float value range. property, value", var2.name, var2.zzamJ);
                     return null;
                  }
               } else {
                  this.zzAo().zzCF().zze("Invalid user property value for Float number filter. property, value", var2.name, var2.zzamJ);
                  return null;
               }
            }
         } else {
            return (new zzae(var3.zzaZB)).zzfp(var2.zzamJ);
         }
      } else {
         this.zzAo().zzCF().zzj("User property has no value, property", var2.name);
         return null;
      }
   }

   void zza(String var1, zzpz.zza[] var2) {
      this.zzCj().zzb(var1, var2);
   }

   zzqb.zza[] zza(String var1, zzqb.zzb[] var2, zzqb.zzg[] var3) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      HashSet var5 = new HashSet();
      ArrayMap var6 = new ArrayMap();
      ArrayMap var7 = new ArrayMap();
      ArrayMap var8 = new ArrayMap();
      if(var2 != null) {
         ArrayMap var9 = new ArrayMap();
         int var10 = var2.length;

         label197:
         for(int var11 = 0; var11 < var10; ++var11) {
            zzqb.zzb var45 = var2[var11];
            zzi var46 = this.zzCj().zzI(var1, var45.name);
            zzi var47;
            if(var46 == null) {
               this.zzAo().zzCF().zzj("Event aggregate wasn\'t created during raw event logging. event", var45.name);
               var47 = new zzi(var1, var45.name, 1L, 1L, var45.zzbaf.longValue());
            } else {
               var47 = var46.zzCB();
            }

            this.zzCj().zza(var47);
            long var48 = var47.zzaVP;
            Map var50 = (Map)var9.get(var45.name);
            Object var51;
            if(var50 == null) {
               Object var69 = this.zzCj().zzL(var1, var45.name);
               if(var69 == null) {
                  var69 = new ArrayMap();
               }

               var9.put(var45.name, var69);
               var51 = var69;
            } else {
               var51 = var50;
            }

            this.zzAo().zzCK().zze("Found audiences. event, audience count", var45.name, Integer.valueOf(((Map)var51).size()));
            Iterator var52 = ((Map)var51).keySet().iterator();

            while(true) {
               while(true) {
                  if(!var52.hasNext()) {
                     continue label197;
                  }

                  int var53 = ((Integer)var52.next()).intValue();
                  if(var5.contains(Integer.valueOf(var53))) {
                     this.zzAo().zzCK().zzj("Skipping failed audience ID", Integer.valueOf(var53));
                  } else {
                     zzqb.zza var54 = (zzqb.zza)var6.get(Integer.valueOf(var53));
                     zzqb.zza var57;
                     if(var54 == null) {
                        zzqb.zza var55 = new zzqb.zza();
                        var6.put(Integer.valueOf(var53), var55);
                        var55.zzbac = Boolean.valueOf(false);
                        var57 = var55;
                     } else {
                        var57 = var54;
                     }

                     List var58 = (List)((Map)var51).get(Integer.valueOf(var53));
                     BitSet var59 = (BitSet)var7.get(Integer.valueOf(var53));
                     BitSet var60 = (BitSet)var8.get(Integer.valueOf(var53));
                     if(var59 == null) {
                        var59 = new BitSet();
                        var7.put(Integer.valueOf(var53), var59);
                        var60 = new BitSet();
                        var8.put(Integer.valueOf(var53), var60);
                     }

                     if(var57.zzbab == null && !var57.zzbac.booleanValue()) {
                        zzqb.zzf var67 = this.zzCj().zzC(var1, var53);
                        if(var67 == null) {
                           var57.zzbac = Boolean.valueOf(true);
                        } else {
                           var57.zzbab = var67;

                           for(int var68 = 0; var68 < 64 * var67.zzbaH.length; ++var68) {
                              if(zzaj.zza(var67.zzbaH, var68)) {
                                 this.zzAo().zzCK().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(var53), Integer.valueOf(var68));
                                 var59.set(var68);
                                 var60.set(var68);
                              }
                           }
                        }
                     }

                     Iterator var63 = var58.iterator();

                     while(var63.hasNext()) {
                        zzpz.zzb var64 = (zzpz.zzb)var63.next();
                        if(this.zzAo().zzQ(2)) {
                           this.zzAo().zzCK().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(var53), var64.zzaZv, var64.zzaZw);
                           this.zzAo().zzCK().zzj("Filter definition", var64);
                        }

                        if(var64.zzaZv.intValue() > 256) {
                           this.zzAo().zzCF().zzj("Invalid event filter ID > 256. id", var64.zzaZv);
                        } else if(!var60.get(var64.zzaZv.intValue())) {
                           Boolean var65 = this.zza(var64, var45, var48);
                           this.zzAo().zzCK().zzj("Event filter result", var65);
                           if(var65 == null) {
                              var5.add(Integer.valueOf(var53));
                           } else {
                              var60.set(var64.zzaZv.intValue());
                              if(var65.booleanValue()) {
                                 var59.set(var64.zzaZv.intValue());
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if(var3 != null) {
         ArrayMap var12 = new ArrayMap();
         int var13 = var3.length;

         label165:
         for(int var14 = 0; var14 < var13; ++var14) {
            zzqb.zzg var22 = var3[var14];
            Map var23 = (Map)var12.get(var22.name);
            Object var24;
            if(var23 == null) {
               Object var43 = this.zzCj().zzM(var1, var22.name);
               if(var43 == null) {
                  var43 = new ArrayMap();
               }

               var12.put(var22.name, var43);
               var24 = var43;
            } else {
               var24 = var23;
            }

            this.zzAo().zzCK().zze("Found audiences. property, audience count", var22.name, Integer.valueOf(((Map)var24).size()));
            Iterator var25 = ((Map)var24).keySet().iterator();

            while(true) {
               while(true) {
                  if(!var25.hasNext()) {
                     continue label165;
                  }

                  int var26 = ((Integer)var25.next()).intValue();
                  if(var5.contains(Integer.valueOf(var26))) {
                     this.zzAo().zzCK().zzj("Skipping failed audience ID", Integer.valueOf(var26));
                  } else {
                     zzqb.zza var27 = (zzqb.zza)var6.get(Integer.valueOf(var26));
                     zzqb.zza var30;
                     if(var27 == null) {
                        zzqb.zza var28 = new zzqb.zza();
                        var6.put(Integer.valueOf(var26), var28);
                        var28.zzbac = Boolean.valueOf(false);
                        var30 = var28;
                     } else {
                        var30 = var27;
                     }

                     List var31 = (List)((Map)var24).get(Integer.valueOf(var26));
                     BitSet var32 = (BitSet)var7.get(Integer.valueOf(var26));
                     BitSet var33 = (BitSet)var8.get(Integer.valueOf(var26));
                     if(var32 == null) {
                        var32 = new BitSet();
                        var7.put(Integer.valueOf(var26), var32);
                        var33 = new BitSet();
                        var8.put(Integer.valueOf(var26), var33);
                     }

                     if(var30.zzbab == null && !var30.zzbac.booleanValue()) {
                        zzqb.zzf var41 = this.zzCj().zzC(var1, var26);
                        if(var41 == null) {
                           var30.zzbac = Boolean.valueOf(true);
                        } else {
                           var30.zzbab = var41;

                           for(int var42 = 0; var42 < 64 * var41.zzbaH.length; ++var42) {
                              if(zzaj.zza(var41.zzbaH, var42)) {
                                 var32.set(var42);
                                 var33.set(var42);
                              }
                           }
                        }
                     }

                     Iterator var36 = var31.iterator();

                     while(var36.hasNext()) {
                        zzpz.zze var37 = (zzpz.zze)var36.next();
                        if(this.zzAo().zzQ(2)) {
                           this.zzAo().zzCK().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(var26), var37.zzaZv, var37.zzaZL);
                           this.zzAo().zzCK().zzj("Filter definition", var37);
                        }

                        if(var37.zzaZv == null || var37.zzaZv.intValue() > 256) {
                           this.zzAo().zzCF().zzj("Invalid property filter ID. id", String.valueOf(var37.zzaZv));
                           var5.add(Integer.valueOf(var26));
                           break;
                        }

                        if(var33.get(var37.zzaZv.intValue())) {
                           this.zzAo().zzCK().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(var26), var37.zzaZv);
                        } else {
                           Boolean var39 = this.zza(var37, var22);
                           this.zzAo().zzCK().zzj("Property filter result", var39);
                           if(var39 == null) {
                              var5.add(Integer.valueOf(var26));
                           } else {
                              var33.set(var37.zzaZv.intValue());
                              if(var39.booleanValue()) {
                                 var32.set(var37.zzaZv.intValue());
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      zzqb.zza[] var15 = new zzqb.zza[var7.size()];
      Iterator var16 = var7.keySet().iterator();
      int var17 = 0;

      while(var16.hasNext()) {
         int var18 = ((Integer)var16.next()).intValue();
         if(!var5.contains(Integer.valueOf(var18))) {
            zzqb.zza var19 = (zzqb.zza)var6.get(Integer.valueOf(var18));
            zzqb.zza var20;
            if(var19 == null) {
               var20 = new zzqb.zza();
            } else {
               var20 = var19;
            }

            int var21 = var17 + 1;
            var15[var17] = var20;
            var20.zzaZr = Integer.valueOf(var18);
            var20.zzbaa = new zzqb.zzf();
            var20.zzbaa.zzbaH = zzaj.zza((BitSet)var7.get(Integer.valueOf(var18)));
            var20.zzbaa.zzbaG = zzaj.zza((BitSet)var8.get(Integer.valueOf(var18)));
            this.zzCj().zza(var1, var18, var20.zzbaa);
            var17 = var21;
         }
      }

      return (zzqb.zza[])Arrays.copyOf(var15, var17);
   }

   boolean zzeQ(String var1) {
      return Pattern.matches("[+-]?[0-9]+", var1);
   }

   boolean zzeR(String var1) {
      return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", var1);
   }

   protected void zziJ() {
   }
}
