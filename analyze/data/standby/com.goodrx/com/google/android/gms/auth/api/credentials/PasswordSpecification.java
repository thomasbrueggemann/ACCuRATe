package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification implements SafeParcelable {
   public static final zzf CREATOR = new zzf();
   public static final PasswordSpecification zzWl = (new PasswordSpecification.zza()).zzh(12, 16).zzbG("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zze("abcdefghijkmnopqrstxyz", 1).zze("ABCDEFGHJKLMNPQRSTXY", 1).zze("3456789", 1).zzmA();
   public static final PasswordSpecification zzWm = (new PasswordSpecification.zza()).zzh(12, 16).zzbG("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zze("abcdefghijklmnopqrstuvwxyz", 1).zze("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zze("1234567890", 1).zzmA();
   final int mVersionCode;
   final String zzWn;
   final List<String> zzWo;
   final List<Integer> zzWp;
   final int zzWq;
   final int zzWr;
   private final int[] zzWs;
   private final Random zzuy;

   PasswordSpecification(int var1, String var2, List<String> var3, List<Integer> var4, int var5, int var6) {
      this.mVersionCode = var1;
      this.zzWn = var2;
      this.zzWo = Collections.unmodifiableList(var3);
      this.zzWp = Collections.unmodifiableList(var4);
      this.zzWq = var5;
      this.zzWr = var6;
      this.zzWs = this.zzmz();
      this.zzuy = new SecureRandom();
   }

   private int zza(char var1) {
      return var1 - 32;
   }

   private static String zzb(Collection<Character> var0) {
      char[] var1 = new char[var0.size()];
      Iterator var2 = var0.iterator();

      int var5;
      for(int var3 = 0; var2.hasNext(); var3 = var5) {
         char var4 = ((Character)var2.next()).charValue();
         var5 = var3 + 1;
         var1[var3] = var4;
      }

      return new String(var1);
   }

   private static boolean zzb(int var0, int var1, int var2) {
      return var0 < var1 || var0 > var2;
   }

   private int[] zzmz() {
      int[] var1 = new int[95];
      Arrays.fill(var1, -1);
      Iterator var2 = this.zzWo.iterator();

      for(int var3 = 0; var2.hasNext(); ++var3) {
         char[] var4 = ((String)var2.next()).toCharArray();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var1[this.zza(var4[var6])] = var3;
         }
      }

      return var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   public static class zza {
      private final List<String> zzWo = new ArrayList();
      private final List<Integer> zzWp = new ArrayList();
      private int zzWq = 12;
      private int zzWr = 16;
      private final TreeSet<Character> zzWt = new TreeSet();

      private void zzmB() {
         Iterator var1 = this.zzWp.iterator();

         int var2;
         for(var2 = 0; var1.hasNext(); var2 += ((Integer)var1.next()).intValue()) {
            ;
         }

         if(var2 > this.zzWr) {
            throw new PasswordSpecification.zzb("required character count cannot be greater than the max password size");
         }
      }

      private void zzmC() {
         boolean[] var1 = new boolean[95];
         Iterator var2 = this.zzWo.iterator();

         while(var2.hasNext()) {
            char[] var3 = ((String)var2.next()).toCharArray();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               char var6 = var3[var5];
               if(var1[var6 - 32]) {
                  throw new PasswordSpecification.zzb("character " + var6 + " occurs in more than one required character set");
               }

               var1[var6 - 32] = true;
            }
         }

      }

      private TreeSet<Character> zzq(String var1, String var2) {
         if(TextUtils.isEmpty(var1)) {
            throw new PasswordSpecification.zzb(var2 + " cannot be null or empty");
         } else {
            TreeSet var3 = new TreeSet();
            char[] var4 = var1.toCharArray();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               char var7 = var4[var6];
               if(PasswordSpecification.zzb(var7, 32, 126)) {
                  throw new PasswordSpecification.zzb(var2 + " must only contain ASCII printable characters");
               }

               var3.add(Character.valueOf(var7));
            }

            return var3;
         }
      }

      public PasswordSpecification.zza zzbG(@NonNull String var1) {
         this.zzWt.addAll(this.zzq(var1, "allowedChars"));
         return this;
      }

      public PasswordSpecification.zza zze(@NonNull String var1, int var2) {
         if(var2 < 1) {
            throw new PasswordSpecification.zzb("count must be at least 1");
         } else {
            TreeSet var3 = this.zzq(var1, "requiredChars");
            this.zzWo.add(PasswordSpecification.zzb(var3));
            this.zzWp.add(Integer.valueOf(var2));
            return this;
         }
      }

      public PasswordSpecification.zza zzh(int var1, int var2) {
         if(var1 < 1) {
            throw new PasswordSpecification.zzb("minimumSize must be at least 1");
         } else if(var1 > var2) {
            throw new PasswordSpecification.zzb("maximumSize must be greater than or equal to minimumSize");
         } else {
            this.zzWq = var1;
            this.zzWr = var2;
            return this;
         }
      }

      public PasswordSpecification zzmA() {
         if(this.zzWt.isEmpty()) {
            throw new PasswordSpecification.zzb("no allowed characters specified");
         } else {
            this.zzmB();
            this.zzmC();
            return new PasswordSpecification(1, PasswordSpecification.zzb(this.zzWt), this.zzWo, this.zzWp, this.zzWq, this.zzWr);
         }
      }
   }

   public static class zzb extends Error {
      public zzb(String var1) {
         super(var1);
      }
   }
}
