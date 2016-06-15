package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.ab;
import com.google.android.gms.analytics.af;
import com.google.android.gms.analytics.class_1055;
import com.google.android.gms.analytics.class_173;
import com.google.android.gms.analytics.class_174;
import com.google.android.gms.analytics.class_836;
import com.google.android.gms.analytics.class_844;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.analytics.class_864;
import com.google.android.gms.analytics.class_865;
import com.google.android.gms.analytics.class_869;
import com.google.android.gms.analytics.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// $FF: renamed from: com.google.android.gms.analytics.h
public class class_839 implements class_173 {
   private final Context mContext;
   // $FF: renamed from: wl java.lang.String
   private final String field_3480;
   // $FF: renamed from: yf org.apache.http.client.HttpClient
   private final HttpClient field_3481;
   // $FF: renamed from: yg java.net.URL
   private URL field_3482;
   // $FF: renamed from: yh int
   private int field_3483;
   // $FF: renamed from: yi int
   private int field_3484;
   // $FF: renamed from: yj int
   private int field_3485;
   // $FF: renamed from: yk java.lang.String
   private String field_3486;
   // $FF: renamed from: yl java.lang.String
   private String field_3487;
   // $FF: renamed from: ym com.google.android.gms.analytics.i
   private class_836 field_3488;
   // $FF: renamed from: yn com.google.android.gms.analytics.l
   private class_844 field_3489;
   // $FF: renamed from: yo java.util.Set
   private Set<Integer> field_3490 = new HashSet();
   // $FF: renamed from: yp boolean
   private boolean field_3491 = false;
   // $FF: renamed from: yq long
   private long field_3492;
   // $FF: renamed from: yr long
   private long field_3493;
   // $FF: renamed from: ys com.google.android.gms.analytics.o
   private class_174 field_3494;
   // $FF: renamed from: yt boolean
   private volatile boolean field_3495 = false;

   class_839(HttpClient var1, Context var2, class_174 var3) {
      this.mContext = var2.getApplicationContext();
      this.field_3494 = var3;
      this.field_3480 = this.method_4645("GoogleAnalytics", "4.0", VERSION.RELEASE, class_1055.method_5793(Locale.getDefault()), Build.MODEL, Build.ID);
      this.field_3481 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.ab, java.util.List, com.google.android.gms.analytics.i) java.lang.String
   private String method_4638(ab var1, List<String> var2, i var3) {
      if(var3 != class_836.field_3469) {
         String var4 = "";
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            if(var6.length() != 0) {
               if(var4.length() != 0) {
                  var4 = var4 + "\n";
               }

               var4 = var4 + var6;
            }
         }

         return var4;
      } else {
         String var7;
         if(var1.method_4846() != null && var1.method_4846().length() != 0) {
            var7 = var1.method_4846();
         } else {
            var7 = "";
         }

         long var8 = System.currentTimeMillis();
         return TextUtils.isEmpty(var7)?"":class_865.method_4850(var1, var8);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.ab) java.net.URL
   private URL method_4639(class_864 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.af, org.apache.http.HttpHost, com.google.android.gms.analytics.i, com.google.android.gms.analytics.l) void
   private void method_4640(class_869 var1, HttpHost var2, class_836 var3, class_844 var4) {
      var1.method_4880("_bs", var3.toString());
      var1.method_4880("_cs", var4.toString());
      String var5 = var1.method_4879();
      if(!TextUtils.isEmpty(var5)) {
         HttpHost var6;
         if(var2 == null) {
            try {
               URL var8 = new URL("https://ssl.google-analytics.com");
               var6 = new HttpHost(var8.getHost(), var8.getPort(), var8.getProtocol());
            } catch (MalformedURLException var10) {
               return;
            }
         } else {
            var6 = var2;
         }

         this.method_4642(var5, var6, 1, var1, class_844.field_3506);
      }
   }

   // $FF: renamed from: a (org.apache.http.HttpEntityEnclosingRequest) void
   private void method_4641(HttpEntityEnclosingRequest param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, org.apache.http.HttpHost, int, com.google.android.gms.analytics.af, com.google.android.gms.analytics.l) boolean
   private boolean method_4642(String param1, HttpHost param2, int param3, class_869 param4, class_844 param5) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (java.lang.String, boolean) org.apache.http.HttpEntityEnclosingRequest
   private HttpEntityEnclosingRequest method_4643(String var1, boolean var2) {
      if(TextUtils.isEmpty(var1)) {
         System.out.println("Empty hit, discarding.");
         return null;
      } else {
         String var3 = this.field_3486 + "?" + var1;
         BasicHttpEntityEnclosingRequest var4;
         if(var3.length() < this.field_3483 && !var2) {
            var4 = new BasicHttpEntityEnclosingRequest("GET", var3);
         } else if(var2) {
            var4 = new BasicHttpEntityEnclosingRequest("POST", this.field_3487);
         } else {
            var4 = new BasicHttpEntityEnclosingRequest("POST", this.field_3486);
         }

         var4.addHeader("User-Agent", this.field_3480);
         return var4;
      }
   }

   // $FF: renamed from: a (java.util.List, int) int
   int method_4644(List<ab> var1, int var2) {
      int var6;
      if(var1.isEmpty()) {
         var6 = 0;
      } else {
         if(var2 > var1.size()) {
            var2 = var1.size();
         }

         int var3 = var2 - 1;
         long var4 = 0L;

         long var13;
         for(var6 = var2; var3 > 0; var4 = var13) {
            class_864 var7 = (class_864)var1.get(var3 - 1);
            class_864 var8 = (class_864)var1.get(var3);
            long var9 = var7.method_4848();
            long var11 = var8.method_4848();
            int var15;
            if(var9 != 0L && var11 != 0L && var11 - var9 > var4) {
               var13 = var11 - var9;
               var15 = var3;
            } else {
               var13 = var4;
               var15 = var6;
            }

            --var3;
            var6 = var15;
         }
      }

      return var6;
   }

   // $FF: renamed from: a (java.util.List, com.google.android.gms.analytics.af, boolean) int
   public int method_853(List<ab> var1, af var2, boolean var3) {
      this.field_3483 = this.field_3494.method_856();
      this.field_3484 = this.field_3494.method_857();
      this.field_3485 = this.field_3494.method_858();
      int var4 = this.field_3494.method_859();
      this.field_3486 = this.field_3494.method_861();
      this.field_3487 = this.field_3494.method_862();
      this.field_3488 = this.field_3494.method_863();
      this.field_3489 = this.field_3494.method_864();
      this.field_3490.clear();
      this.field_3490.addAll(this.field_3494.method_865());
      this.field_3493 = this.field_3494.method_860();
      if(!this.field_3491 && this.field_3490.isEmpty()) {
         this.field_3491 = true;
         this.field_3492 = System.currentTimeMillis();
      }

      if(this.field_3491 && System.currentTimeMillis() - this.field_3492 > 1000L * this.field_3493) {
         this.field_3491 = false;
      }

      class_844 var7;
      class_836 var8;
      if(this.field_3491) {
         class_836 var42 = class_836.field_3469;
         var7 = class_844.field_3506;
         var8 = var42;
      } else {
         class_836 var6 = this.field_3488;
         var7 = this.field_3489;
         var8 = var6;
      }

      int var9 = 0;
      int var10 = Math.min(var1.size(), var4);
      var2.method_4878("_hr", var1.size());
      long var11 = System.currentTimeMillis();
      ArrayList var13 = new ArrayList();
      ArrayList var14 = new ArrayList();
      long var15 = 0L;
      int var17;
      int var18;
      if(var8 != class_836.field_3469) {
         label148: {
            Iterator var34 = var1.iterator();

            int var39;
            for(var18 = 0; var34.hasNext(); var18 = var39) {
               class_864 var35 = (class_864)var34.next();
               String var36;
               if(TextUtils.isEmpty(var35.method_4846())) {
                  var36 = "";
               } else {
                  var36 = class_865.method_4850(var35, var11);
               }

               if(var36.getBytes().length > this.field_3484) {
                  var36 = "";
               }

               var13.add(var36);
               if(!TextUtils.isEmpty(var36)) {
                  int var40 = var36.getBytes().length;
                  byte var41;
                  if(var18 == 0) {
                     var41 = 0;
                  } else {
                     var41 = 1;
                  }

                  var15 += (long)(var41 + var40);
               }

               var14.add(Long.valueOf(var15));
               if(var15 <= (long)this.field_3485) {
                  var39 = var18 + 1;
               } else {
                  var39 = var18;
               }

               if(var39 == var10) {
                  var18 = var39;
                  var17 = 1;
                  break label148;
               }
            }

            var17 = 1;
         }
      } else {
         var17 = var10;
         var18 = 0;
      }

      while(var18 > 1 && ((Long)var14.get(var18 - 1)).longValue() > (long)this.field_3485) {
         --var18;
      }

      Object var19;
      label119: {
         if(var15 > (long)this.field_3485) {
            int var30;
            switch(null.field_1929[var8.ordinal()]) {
            case 1:
               var30 = var13.size() / 2;
               if(var18 <= var30) {
                  var30 = var18;
               }
               break;
            case 2:
               var30 = this.method_4644(var1, var18);
               break;
            case 3:
               var30 = this.method_4646(var1, var18);
               break;
            case 4:
               if(var15 >= (long)(2 * this.field_3485)) {
                  var30 = var18;
                  break;
               }

               int var31;
               for(var31 = -1 + var14.size(); var31 > 0 && ((Long)var14.get(var31)).longValue() > var15 / 2L; --var31) {
                  ;
               }

               var30 = var31;
               break;
            case 5:
               var30 = var18;
               break;
            default:
               class_863.method_4842("Unexpected batching strategy encountered; sending a single hit.");
               String var32 = (String)var13.get(0);
               var13.clear();
               var13.add(var32);
               var30 = 1;
            }

            if(var30 < var13.size()) {
               var19 = var13.subList(0, var30);
               break label119;
            }
         }

         var19 = var13;
      }

      int var20 = 0;
      HttpHost var21 = null;

      int var28;
      for(int var22 = 0; var22 < var17; var9 = var28) {
         class_864 var23 = (class_864)var1.get(var22);
         URL var24 = this.method_4639(var23);
         int var25 = Math.max(1, ((List)var19).size());
         int var27;
         if(var24 == null) {
            class_863.method_4842("No destination: discarding hit.");
            var27 = var20 + var25;
            var28 = var9 + var25;
         } else {
            var21 = new HttpHost(var24.getHost(), var24.getPort(), var24.getProtocol());
            if(!this.method_4642(this.method_4638(var23, (List)var19, var8), var21, var25, var2, var7)) {
               var2.method_4878("_de", 1);
               var2.method_4878("_hd", var20);
               var2.method_4878("_hs", var9);
               this.method_4640(var2, var21, var8, var7);
               return var9;
            }

            Iterator var26 = ((List)var19).iterator();

            int var29;
            for(var27 = var20; var26.hasNext(); var27 = var29) {
               if(TextUtils.isEmpty((String)var26.next())) {
                  var29 = var27 + 1;
               } else {
                  var29 = var27;
               }
            }

            var2.method_4878("_rs", 1);
            var28 = var9 + var25;
         }

         ++var22;
         var20 = var27;
      }

      var2.method_4878("_hd", var20);
      var2.method_4878("_hs", var9);
      if(var3) {
         this.method_4640(var2, var21, var8, var7);
      }

      return var9;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String) java.lang.String
   String method_4645(String var1, String var2, String var3, String var4, String var5, String var6) {
      return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{var1, var2, var3, var4, var5, var6});
   }

   // $FF: renamed from: ad (java.lang.String) void
   public void method_854(String var1) {
      try {
         this.field_3482 = new URL(var1);
      } catch (MalformedURLException var3) {
         this.field_3482 = null;
      }
   }

   // $FF: renamed from: b (java.util.List, int) int
   int method_4646(List<ab> var1, int var2) {
      if(var1.isEmpty()) {
         var2 = 0;
      } else {
         for(int var3 = var2 - 1; var3 > 0; --var3) {
            String var4 = ((class_864)var1.get(var3)).method_4846();
            if(!TextUtils.isEmpty(var4)) {
               if(var4.contains("sc=start")) {
                  return var3;
               }

               if(var4.contains("sc=end")) {
                  return var3 + 1;
               }
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: ea () boolean
   public boolean method_855() {
      NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         class_863.method_4841("...no network connectivity");
         return false;
      }
   }

   public void setDryRun(boolean var1) {
      this.field_3495 = var1;
   }
}
