package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdc;
import com.google.android.gms.tagmanager.zzdd;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzdg extends zzdd {
   // $FF: renamed from: ID java.lang.String
   private static final String field_74;
   private static final String zzblN;
   private static final String zzblO;
   private static final String zzblP;
   private static final String zzblQ;
   private static final String zzblR;
   private static final String zzblS;
   private static final String zzblT;
   private static final String zzblU;
   private static final String zzblV;
   private static final List<String> zzblW;
   private static final Pattern zzblX;
   private static final Pattern zzblY;
   private static Map<String, String> zzblZ;
   private static Map<String, String> zzbma;
   private final DataLayer zzbhN;
   private final Set<String> zzbmb;
   private final zzdc zzbmc;

   static {
      field_74 = com.google.android.gms.internal.zzad.zzcZ.toString();
      zzblN = com.google.android.gms.internal.zzae.zzdG.toString();
      zzblO = com.google.android.gms.internal.zzae.zzdQ.toString();
      zzblP = com.google.android.gms.internal.zzae.zzfn.toString();
      zzblQ = com.google.android.gms.internal.zzae.zzfh.toString();
      zzblR = com.google.android.gms.internal.zzae.zzfg.toString();
      zzblS = com.google.android.gms.internal.zzae.zzdP.toString();
      zzblT = com.google.android.gms.internal.zzae.zzhO.toString();
      zzblU = com.google.android.gms.internal.zzae.zzhR.toString();
      zzblV = com.google.android.gms.internal.zzae.zzhT.toString();
      zzblW = Arrays.asList(new String[]{"detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund"});
      zzblX = Pattern.compile("dimension(\\d+)");
      zzblY = Pattern.compile("metric(\\d+)");
   }

   public zzdg(Context var1, DataLayer var2) {
      this(var1, var2, new zzdc(var1));
   }

   zzdg(Context var1, DataLayer var2, zzdc var3) {
      super(field_74, new String[0]);
      this.zzbhN = var2;
      this.zzbmc = var3;
      this.zzbmb = new HashSet();
      this.zzbmb.add("");
      this.zzbmb.add("0");
      this.zzbmb.add("false");
   }

   private Double zzV(Object var1) {
      if(var1 instanceof String) {
         try {
            Double var3 = Double.valueOf((String)var1);
            return var3;
         } catch (NumberFormatException var4) {
            throw new RuntimeException("Cannot convert the object to Double: " + var4.getMessage());
         }
      } else if(var1 instanceof Integer) {
         return Double.valueOf(((Integer)var1).doubleValue());
      } else if(var1 instanceof Double) {
         return (Double)var1;
      } else {
         throw new RuntimeException("Cannot convert the object to Double: " + var1.toString());
      }
   }

   private Integer zzW(Object var1) {
      if(var1 instanceof String) {
         try {
            Integer var3 = Integer.valueOf((String)var1);
            return var3;
         } catch (NumberFormatException var4) {
            throw new RuntimeException("Cannot convert the object to Integer: " + var4.getMessage());
         }
      } else if(var1 instanceof Double) {
         return Integer.valueOf(((Double)var1).intValue());
      } else if(var1 instanceof Integer) {
         return (Integer)var1;
      } else {
         throw new RuntimeException("Cannot convert the object to Integer: " + var1.toString());
      }
   }

   private Promotion zzZ(Map<String, String> var1) {
      Promotion var2 = new Promotion();
      String var3 = (String)var1.get("id");
      if(var3 != null) {
         var2.setId(String.valueOf(var3));
      }

      String var4 = (String)var1.get("name");
      if(var4 != null) {
         var2.setName(String.valueOf(var4));
      }

      String var5 = (String)var1.get("creative");
      if(var5 != null) {
         var2.setCreative(String.valueOf(var5));
      }

      String var6 = (String)var1.get("position");
      if(var6 != null) {
         var2.setPosition(String.valueOf(var6));
      }

      return var2;
   }

   private void zza(Tracker param1, Map<String, com.google.android.gms.internal.zzag.zza> param2) {
      // $FF: Couldn't be decompiled
   }

   private Product zzaa(Map<String, Object> var1) {
      Product var2 = new Product();
      Object var3 = var1.get("id");
      if(var3 != null) {
         var2.setId(String.valueOf(var3));
      }

      Object var4 = var1.get("name");
      if(var4 != null) {
         var2.setName(String.valueOf(var4));
      }

      Object var5 = var1.get("brand");
      if(var5 != null) {
         var2.setBrand(String.valueOf(var5));
      }

      Object var6 = var1.get("category");
      if(var6 != null) {
         var2.setCategory(String.valueOf(var6));
      }

      Object var7 = var1.get("variant");
      if(var7 != null) {
         var2.setVariant(String.valueOf(var7));
      }

      Object var8 = var1.get("coupon");
      if(var8 != null) {
         var2.setCouponCode(String.valueOf(var8));
      }

      Object var9 = var1.get("position");
      if(var9 != null) {
         var2.setPosition(this.zzW(var9).intValue());
      }

      Object var10 = var1.get("price");
      if(var10 != null) {
         var2.setPrice(this.zzV(var10).doubleValue());
      }

      Object var11 = var1.get("quantity");
      if(var11 != null) {
         var2.setQuantity(this.zzW(var11).intValue());
      }

      Iterator var12 = var1.keySet().iterator();

      while(true) {
         while(var12.hasNext()) {
            String var13 = (String)var12.next();
            Matcher var14 = zzblX.matcher(var13);
            if(var14.matches()) {
               int var20;
               try {
                  var20 = Integer.parseInt(var14.group(1));
               } catch (NumberFormatException var22) {
                  zzbg.zzaK("illegal number in custom dimension value: " + var13);
                  continue;
               }

               var2.setCustomDimension(var20, String.valueOf(var1.get(var13)));
            } else {
               Matcher var15 = zzblY.matcher(var13);
               if(var15.matches()) {
                  int var17;
                  try {
                     var17 = Integer.parseInt(var15.group(1));
                  } catch (NumberFormatException var21) {
                     zzbg.zzaK("illegal number in custom metric value: " + var13);
                     continue;
                  }

                  var2.setCustomMetric(var17, this.zzW(var1.get(var13)).intValue());
               }
            }
         }

         return var2;
      }
   }

   private Map<String, String> zzab(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      com.google.android.gms.internal.zzag.zza var2 = (com.google.android.gms.internal.zzag.zza)var1.get(zzblU);
      if(var2 != null) {
         return this.zzc(var2);
      } else {
         if(zzblZ == null) {
            HashMap var3 = new HashMap();
            var3.put("transactionId", "&ti");
            var3.put("transactionAffiliation", "&ta");
            var3.put("transactionTax", "&tt");
            var3.put("transactionShipping", "&ts");
            var3.put("transactionTotal", "&tr");
            var3.put("transactionCurrency", "&cu");
            zzblZ = var3;
         }

         return zzblZ;
      }
   }

   private Map<String, String> zzac(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      com.google.android.gms.internal.zzag.zza var2 = (com.google.android.gms.internal.zzag.zza)var1.get(zzblV);
      if(var2 != null) {
         return this.zzc(var2);
      } else {
         if(zzbma == null) {
            HashMap var3 = new HashMap();
            var3.put("name", "&in");
            var3.put("sku", "&ic");
            var3.put("category", "&iv");
            var3.put("price", "&ip");
            var3.put("quantity", "&iq");
            var3.put("currency", "&cu");
            zzbma = var3;
         }

         return zzbma;
      }
   }

   private void zzb(Tracker param1, Map<String, com.google.android.gms.internal.zzag.zza> param2) {
      // $FF: Couldn't be decompiled
   }

   private Map<String, String> zzc(com.google.android.gms.internal.zzag.zza var1) {
      Object var2 = zzdf.zzl(var1);
      if(!(var2 instanceof Map)) {
         return null;
      } else {
         Map var3 = (Map)var2;
         LinkedHashMap var4 = new LinkedHashMap();
         Iterator var5 = var3.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            var4.put(var6.getKey().toString(), var6.getValue().toString());
         }

         return var4;
      }
   }

   private ProductAction zzd(String var1, Map<String, Object> var2) {
      ProductAction var3 = new ProductAction(var1);
      Object var4 = var2.get("id");
      if(var4 != null) {
         var3.setTransactionId(String.valueOf(var4));
      }

      Object var5 = var2.get("affiliation");
      if(var5 != null) {
         var3.setTransactionAffiliation(String.valueOf(var5));
      }

      Object var6 = var2.get("coupon");
      if(var6 != null) {
         var3.setTransactionCouponCode(String.valueOf(var6));
      }

      Object var7 = var2.get("list");
      if(var7 != null) {
         var3.setProductActionList(String.valueOf(var7));
      }

      Object var8 = var2.get("option");
      if(var8 != null) {
         var3.setCheckoutOptions(String.valueOf(var8));
      }

      Object var9 = var2.get("revenue");
      if(var9 != null) {
         var3.setTransactionRevenue(this.zzV(var9).doubleValue());
      }

      Object var10 = var2.get("tax");
      if(var10 != null) {
         var3.setTransactionTax(this.zzV(var10).doubleValue());
      }

      Object var11 = var2.get("shipping");
      if(var11 != null) {
         var3.setTransactionShipping(this.zzV(var11).doubleValue());
      }

      Object var12 = var2.get("step");
      if(var12 != null) {
         var3.setCheckoutStep(this.zzW(var12).intValue());
      }

      return var3;
   }

   private void zze(Map<String, String> var1, String var2, String var3) {
      if(var3 != null) {
         var1.put(var2, var3);
      }

   }

   private String zzgy(String var1) {
      Object var2 = this.zzbhN.get(var1);
      return var2 == null?null:var2.toString();
   }

   private List<Map<String, String>> zzgz(String var1) {
      Object var2 = this.zzbhN.get(var1);
      if(var2 == null) {
         return null;
      } else if(!(var2 instanceof List)) {
         throw new IllegalArgumentException("transactionProducts should be of type List.");
      } else {
         Iterator var3 = ((List)var2).iterator();

         do {
            if(!var3.hasNext()) {
               return (List)var2;
            }
         } while(var3.next() instanceof Map);

         throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
   }

   private boolean zzj(Map<String, com.google.android.gms.internal.zzag.zza> var1, String var2) {
      com.google.android.gms.internal.zzag.zza var3 = (com.google.android.gms.internal.zzag.zza)var1.get(var2);
      return var3 == null?false:zzdf.zzk(var3).booleanValue();
   }

   private Map<String, String> zzm(com.google.android.gms.internal.zzag.zza var1) {
      if(var1 == null) {
         return new HashMap();
      } else {
         Map var2 = this.zzc(var1);
         if(var2 == null) {
            return new HashMap();
         } else {
            String var3 = (String)var2.get("&aip");
            if(var3 != null && this.zzbmb.contains(var3.toLowerCase())) {
               var2.remove("&aip");
            }

            return var2;
         }
      }
   }

   public void zzR(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      Tracker var2 = this.zzbmc.zzgq("_GTM_DEFAULT_TRACKER_");
      var2.enableAdvertisingIdCollection(this.zzj(var1, "collect_adid"));
      if(this.zzj(var1, zzblP)) {
         this.zzb(var2, var1);
      } else if(this.zzj(var1, zzblO)) {
         var2.send(this.zzm((com.google.android.gms.internal.zzag.zza)var1.get(zzblS)));
      } else if(this.zzj(var1, zzblT)) {
         this.zza(var2, var1);
      } else {
         zzbg.zzaK("Ignoring unknown tag.");
      }
   }
}
