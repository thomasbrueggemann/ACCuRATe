package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzhb;
import java.util.ArrayList;
import java.util.Iterator;

@zzhb
public class zzbc {
   private final Object zzpV = new Object();
   private final int zzsK;
   private final int zzsL;
   private final int zzsM;
   private final zzbh zzsN;
   private ArrayList<String> zzsO = new ArrayList();
   private ArrayList<String> zzsP = new ArrayList();
   private int zzsQ = 0;
   private int zzsR = 0;
   private int zzsS = 0;
   private int zzsT;
   private String zzsU = "";
   private String zzsV = "";

   public zzbc(int var1, int var2, int var3, int var4) {
      this.zzsK = var1;
      this.zzsL = var2;
      this.zzsM = var3;
      this.zzsN = new zzbh(var4);
   }

   private String zza(ArrayList<String> var1, int var2) {
      String var6;
      if(var1.isEmpty()) {
         var6 = "";
      } else {
         StringBuffer var3 = new StringBuffer();
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            var3.append((String)var4.next());
            var3.append(' ');
            if(var3.length() > var2) {
               break;
            }
         }

         var3.deleteCharAt(-1 + var3.length());
         var6 = var3.toString();
         if(var6.length() >= var2) {
            return var6.substring(0, var2);
         }
      }

      return var6;
   }

   private void zze(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean equals(Object var1) {
      if(var1 instanceof zzbc) {
         if(var1 == this) {
            return true;
         }

         zzbc var2 = (zzbc)var1;
         if(var2.zzcy() != null && var2.zzcy().equals(this.zzcy())) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      return this.zzcy().hashCode();
   }

   public String toString() {
      return "ActivityContent fetchId: " + this.zzsR + " score:" + this.zzsT + " total_length:" + this.zzsQ + "\n text: " + this.zza(this.zzsO, 100) + "\n viewableText" + this.zza(this.zzsP, 100) + "\n signture: " + this.zzsU + "\n viewableSignture: " + this.zzsV;
   }

   int zzb(int var1, int var2) {
      return var1 * this.zzsK + var2 * this.zzsL;
   }

   public void zzc(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void zzcB() {
      // $FF: Couldn't be decompiled
   }

   public void zzcC() {
      // $FF: Couldn't be decompiled
   }

   public void zzcD() {
      // $FF: Couldn't be decompiled
   }

   int zzcE() {
      return this.zzsQ;
   }

   public boolean zzcx() {
      // $FF: Couldn't be decompiled
   }

   public String zzcy() {
      return this.zzsU;
   }

   public void zzd(String var1, boolean var2) {
      this.zze(var1, var2);
   }

   public void zzh(int var1) {
      this.zzsR = var1;
   }
}
