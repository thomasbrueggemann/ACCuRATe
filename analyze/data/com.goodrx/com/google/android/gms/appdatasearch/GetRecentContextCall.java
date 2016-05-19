package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzf;
import com.google.android.gms.appdatasearch.zzg;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetRecentContextCall {
   public static class Request implements SafeParcelable {
      public static final zzf CREATOR = new zzf();
      final int mVersionCode;
      public final Account zzTT;
      public final boolean zzTU;
      public final boolean zzTV;
      public final boolean zzTW;
      public final String zzTX;

      public Request() {
         this((Account)null, false, false, false, (String)null);
      }

      Request(int var1, Account var2, boolean var3, boolean var4, boolean var5, String var6) {
         this.mVersionCode = var1;
         this.zzTT = var2;
         this.zzTU = var3;
         this.zzTV = var4;
         this.zzTW = var5;
         this.zzTX = var6;
      }

      public Request(Account var1, boolean var2, boolean var3, boolean var4, String var5) {
         this(1, var1, var2, var3, var4, var5);
      }

      public int describeContents() {
         zzf var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzf var10000 = CREATOR;
         zzf.zza(this, var1, var2);
      }
   }

   public static class Response implements Result, SafeParcelable {
      public static final zzg CREATOR = new zzg();
      final int mVersionCode;
      public Status zzTY;
      public List<UsageInfo> zzTZ;
      @Deprecated
      public String[] zzUa;

      public Response() {
         this.mVersionCode = 1;
      }

      Response(int var1, Status var2, List<UsageInfo> var3, String[] var4) {
         this.mVersionCode = var1;
         this.zzTY = var2;
         this.zzTZ = var3;
         this.zzUa = var4;
      }

      public int describeContents() {
         zzg var10000 = CREATOR;
         return 0;
      }

      public Status getStatus() {
         return this.zzTY;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzg var10000 = CREATOR;
         zzg.zza(this, var1, var2);
      }
   }
}
