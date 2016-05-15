package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class zzu {
   protected static final Comparator<byte[]> zzaw = new Comparator() {
      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.zza((byte[])var1, (byte[])var2);
      }

      public int zza(byte[] var1, byte[] var2) {
         return var1.length - var2.length;
      }
   };
   private List<byte[]> zzas = new LinkedList();
   private List<byte[]> zzat = new ArrayList(64);
   private int zzau = 0;
   private final int zzav;

   public zzu(int var1) {
      this.zzav = var1;
   }

   private void zzy() {
      synchronized(this){}

      while(true) {
         boolean var4 = false;

         try {
            var4 = true;
            if(this.zzau <= this.zzav) {
               var4 = false;
               return;
            }

            byte[] var2 = (byte[])this.zzas.remove(0);
            this.zzat.remove(var2);
            this.zzau -= var2.length;
            var4 = false;
         } finally {
            if(var4) {
               ;
            }
         }
      }
   }

   public void zza(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   public byte[] zzb(int var1) {
      synchronized(this){}
      int var2 = 0;

      byte[] var4;
      while(true) {
         boolean var6 = false;

         try {
            var6 = true;
            if(var2 >= this.zzat.size()) {
               var4 = new byte[var1];
               var6 = false;
               break;
            }

            var4 = (byte[])this.zzat.get(var2);
            if(var4.length >= var1) {
               this.zzau -= var4.length;
               this.zzat.remove(var2);
               this.zzas.remove(var4);
               var6 = false;
               break;
            }

            var6 = false;
         } finally {
            if(var6) {
               ;
            }
         }

         ++var2;
      }

      return var4;
   }
}
