package com.google.android.gms.internal;

import java.util.LinkedHashMap;

// $FF: renamed from: com.google.android.gms.internal.hr
public class class_320<K, V> {
   // $FF: renamed from: GJ java.util.LinkedHashMap
   private final LinkedHashMap<K, V> field_1288;
   // $FF: renamed from: GK int
   private int field_1289;
   // $FF: renamed from: GL int
   private int field_1290;
   // $FF: renamed from: GM int
   private int field_1291;
   // $FF: renamed from: GN int
   private int field_1292;
   // $FF: renamed from: GO int
   private int field_1293;
   // $FF: renamed from: GP int
   private int field_1294;
   private int size;

   public class_320(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         this.field_1289 = var1;
         this.field_1288 = new LinkedHashMap(0, 0.75F, true);
      }
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object) int
   private int method_2046(K var1, V var2) {
      int var3 = this.sizeOf(var1, var2);
      if(var3 < 0) {
         throw new IllegalStateException("Negative size: " + var1 + "=" + var2);
      } else {
         return var3;
      }
   }

   protected V create(K var1) {
      return null;
   }

   protected void entryRemoved(boolean var1, K var2, V var3, V var4) {
   }

   public final void evictAll() {
      this.trimToSize(-1);
   }

   public final V get(K param1) {
      // $FF: Couldn't be decompiled
   }

   public final V put(K param1, V param2) {
      // $FF: Couldn't be decompiled
   }

   public final int size() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.size;
      } finally {
         ;
      }

      return var2;
   }

   protected int sizeOf(K var1, V var2) {
      return 1;
   }

   public final String toString() {
      // $FF: Couldn't be decompiled
   }

   public void trimToSize(int param1) {
      // $FF: Couldn't be decompiled
   }
}
