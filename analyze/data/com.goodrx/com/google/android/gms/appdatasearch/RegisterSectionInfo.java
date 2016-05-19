package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.Feature;
import com.google.android.gms.appdatasearch.zzi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo implements SafeParcelable {
   public static final zzi CREATOR = new zzi();
   final int mVersionCode;
   public final String name;
   public final int weight;
   public final String zzUd;
   public final boolean zzUe;
   public final boolean zzUf;
   public final String zzUg;
   public final Feature[] zzUh;
   final int[] zzUi;
   public final String zzUj;

   RegisterSectionInfo(int var1, String var2, String var3, boolean var4, int var5, boolean var6, String var7, Feature[] var8, int[] var9, String var10) {
      this.mVersionCode = var1;
      this.name = var2;
      this.zzUd = var3;
      this.zzUe = var4;
      this.weight = var5;
      this.zzUf = var6;
      this.zzUg = var7;
      this.zzUh = var8;
      this.zzUi = var9;
      this.zzUj = var10;
   }

   RegisterSectionInfo(String var1, String var2, boolean var3, int var4, boolean var5, String var6, Feature[] var7, int[] var8, String var9) {
      this(2, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public int describeContents() {
      zzi var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi var10000 = CREATOR;
      zzi.zza(this, var1, var2);
   }

   public static final class zza {
      private final String mName;
      private String zzUk;
      private boolean zzUl;
      private int zzUm;
      private boolean zzUn;
      private String zzUo;
      private final List<Feature> zzUp;
      private BitSet zzUq;
      private String zzUr;

      public zza(String var1) {
         this.mName = var1;
         this.zzUm = 1;
         this.zzUp = new ArrayList();
      }

      public RegisterSectionInfo.zza zzM(boolean var1) {
         this.zzUl = var1;
         return this;
      }

      public RegisterSectionInfo.zza zzN(boolean var1) {
         this.zzUn = var1;
         return this;
      }

      public RegisterSectionInfo.zza zzap(int var1) {
         if(this.zzUq == null) {
            this.zzUq = new BitSet();
         }

         this.zzUq.set(var1);
         return this;
      }

      public RegisterSectionInfo.zza zzbB(String var1) {
         this.zzUk = var1;
         return this;
      }

      public RegisterSectionInfo.zza zzbC(String var1) {
         this.zzUr = var1;
         return this;
      }

      public RegisterSectionInfo zzmh() {
         int var1 = 0;
         BitSet var2 = this.zzUq;
         int[] var3 = null;
         if(var2 != null) {
            var3 = new int[this.zzUq.cardinality()];

            int var5;
            for(int var4 = this.zzUq.nextSetBit(0); var4 >= 0; var1 = var5) {
               var5 = var1 + 1;
               var3[var1] = var4;
               var4 = this.zzUq.nextSetBit(var4 + 1);
            }
         }

         return new RegisterSectionInfo(this.mName, this.zzUk, this.zzUl, this.zzUm, this.zzUn, this.zzUo, (Feature[])this.zzUp.toArray(new Feature[this.zzUp.size()]), var3, this.zzUr);
      }
   }
}
