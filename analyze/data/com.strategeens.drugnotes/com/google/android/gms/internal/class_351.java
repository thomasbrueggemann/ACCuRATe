package com.google.android.gms.internal;

import java.util.LinkedHashMap;

// $FF: renamed from: com.google.android.gms.internal.kj
public class class_351<K, V> {
   // $FF: renamed from: NA int
   private int field_1046;
   // $FF: renamed from: NB int
   private int field_1047;
   // $FF: renamed from: NC int
   private int field_1048;
   // $FF: renamed from: Nw java.util.LinkedHashMap
   private final LinkedHashMap<K, V> field_1049;
   // $FF: renamed from: Nx int
   private int field_1050;
   // $FF: renamed from: Ny int
   private int field_1051;
   // $FF: renamed from: Nz int
   private int field_1052;
   private int size;

   public class_351(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         this.field_1050 = var1;
         this.field_1049 = new LinkedHashMap(0, 0.75F, true);
      }
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object) int
   private int method_2431(K var1, V var2) {
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
