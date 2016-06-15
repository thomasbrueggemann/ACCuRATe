package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.class_219;
import com.google.android.gms.internal.class_221;
import com.google.android.gms.internal.class_222;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_368;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

// $FF: renamed from: com.google.android.gms.internal.ap
public class class_224 {
   // $FF: renamed from: nT int
   private final int field_372;
   // $FF: renamed from: nU int
   private final int field_373;
   // $FF: renamed from: nV com.google.android.gms.internal.ao
   private final class_222 field_374 = new class_223();
   // $FF: renamed from: nW android.util.Base64OutputStream
   private Base64OutputStream field_375;
   // $FF: renamed from: nX java.io.ByteArrayOutputStream
   private ByteArrayOutputStream field_376;

   public class_224(int var1) {
      this.field_373 = var1;
      this.field_372 = 6;
   }

   // $FF: renamed from: m (java.lang.String) java.lang.String
   private String method_1547(String var1) {
      String[] var2 = var1.split("\n");
      if(var2 != null && var2.length != 0) {
         this.field_376 = new ByteArrayOutputStream();
         this.field_375 = new Base64OutputStream(this.field_376, 10);
         Arrays.sort(var2, new Comparator() {
            public int compare(String var1, String var2) {
               return var2.length() - var1.length();
            }
         });

         for(int var3 = 0; var3 < var2.length && var3 < this.field_373; ++var3) {
            if(var2[var3].trim().length() != 0) {
               try {
                  this.field_375.write(this.field_374.method_1543(var2[var3]));
               } catch (IOException var8) {
                  class_368.method_2508("Error while writing hash to byteStream", var8);
               }
            }
         }

         try {
            this.field_375.flush();
            this.field_375.close();
            String var5 = this.field_376.toString();
            return var5;
         } catch (IOException var7) {
            class_368.method_2508("HashManager: Unable to convert to base 64", var7);
            return "";
         }
      } else {
         return "";
      }
   }

   // $FF: renamed from: a (java.util.ArrayList) java.lang.String
   public String method_1548(ArrayList<String> var1) {
      StringBuffer var2 = new StringBuffer();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.append(((String)var3.next()).toLowerCase(Locale.US));
         var2.append('\n');
      }

      switch(0) {
      case 0:
         return this.method_1549(var2.toString());
      case 1:
         return this.method_1547(var2.toString());
      default:
         return "";
      }
   }

   // $FF: renamed from: n (java.lang.String) java.lang.String
   String method_1549(String var1) {
      String[] var2 = var1.split("\n");
      if(var2 != null && var2.length != 0) {
         this.field_376 = new ByteArrayOutputStream();
         this.field_375 = new Base64OutputStream(this.field_376, 10);
         PriorityQueue var3 = new PriorityQueue(this.field_373, new Comparator() {
            // $FF: renamed from: a (com.google.android.gms.internal.as$a, com.google.android.gms.internal.as$a) int
            public int method_4142(class_219.class_1104 var1, class_219.class_1104 var2) {
               return (int)(var1.value - var2.value);
            }

            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
               return this.method_4142((class_219.class_1104)var1, (class_219.class_1104)var2);
            }
         });

         for(int var4 = 0; var4 < var2.length; ++var4) {
            String[] var10 = class_221.method_1541(var2[var4]);
            if(var10.length >= this.field_372) {
               class_219.method_1535(var10, this.field_373, this.field_372, var3);
            }
         }

         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            class_219.class_1104 var8 = (class_219.class_1104)var5.next();

            try {
               this.field_375.write(this.field_374.method_1543(var8.field_897));
            } catch (IOException var12) {
               class_368.method_2508("Error while writing hash to byteStream", var12);
            }
         }

         try {
            this.field_375.flush();
            this.field_375.close();
            String var7 = this.field_376.toString();
            return var7;
         } catch (IOException var11) {
            class_368.method_2508("HashManager: unable to convert to base 64", var11);
            return "";
         }
      } else {
         return "";
      }
   }
}
