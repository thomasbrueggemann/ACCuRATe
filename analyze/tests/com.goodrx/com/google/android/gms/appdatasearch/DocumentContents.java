package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.zzb;
import com.google.android.gms.appdatasearch.zzh;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class DocumentContents implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   public final Account account;
   final int mVersionCode;
   final DocumentSection[] zzTC;
   public final String zzTD;
   public final boolean zzTE;

   DocumentContents(int var1, DocumentSection[] var2, String var3, boolean var4, Account var5) {
      this.mVersionCode = var1;
      this.zzTC = var2;
      this.zzTD = var3;
      this.zzTE = var4;
      this.account = var5;
   }

   DocumentContents(String var1, boolean var2, Account var3, DocumentSection... var4) {
      this(1, var4, var1, var2, var3);
      BitSet var5 = new BitSet(zzh.zzmg());

      for(int var6 = 0; var6 < var4.length; ++var6) {
         int var7 = var4[var6].zzTQ;
         if(var7 != -1) {
            if(var5.get(var7)) {
               throw new IllegalArgumentException("Duplicate global search section type " + zzh.zzao(var7));
            }

            var5.set(var7);
         }
      }

   }

   public int describeContents() {
      zzb var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb var10000 = CREATOR;
      zzb.zza(this, var1, var2);
   }

   public static class zza {
      private List<DocumentSection> zzTF;
      private String zzTG;
      private boolean zzTH;
      private Account zzTI;

      public DocumentContents.zza zzL(boolean var1) {
         this.zzTH = var1;
         return this;
      }

      public DocumentContents.zza zza(DocumentSection var1) {
         if(this.zzTF == null) {
            this.zzTF = new ArrayList();
         }

         this.zzTF.add(var1);
         return this;
      }

      public DocumentContents.zza zzb(Account var1) {
         this.zzTI = var1;
         return this;
      }

      public DocumentContents.zza zzbz(String var1) {
         this.zzTG = var1;
         return this;
      }

      public DocumentContents zzme() {
         String var1 = this.zzTG;
         boolean var2 = this.zzTH;
         Account var3 = this.zzTI;
         DocumentSection[] var4;
         if(this.zzTF != null) {
            var4 = (DocumentSection[])this.zzTF.toArray(new DocumentSection[this.zzTF.size()]);
         } else {
            var4 = null;
         }

         return new DocumentContents(var1, var2, var3, var4);
      }
   }
}
