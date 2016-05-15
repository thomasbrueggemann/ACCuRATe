package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
public final class DataHolder implements SafeParcelable {
   public static final zze CREATOR = new zze();
   private static final DataHolder.zza zzajq = new DataHolder.zza(new String[0], (String)null, null) {
   };
   boolean mClosed = false;
   private final int mVersionCode;
   private final int zzade;
   private final String[] zzaji;
   Bundle zzajj;
   private final CursorWindow[] zzajk;
   private final Bundle zzajl;
   int[] zzajm;
   int zzajn;
   private Object zzajo;
   private boolean zzajp = true;

   DataHolder(int var1, String[] var2, CursorWindow[] var3, int var4, Bundle var5) {
      this.mVersionCode = var1;
      this.zzaji = var2;
      this.zzajk = var3;
      this.zzade = var4;
      this.zzajl = var5;
   }

   private void zzg(String var1, int var2) {
      if(this.zzajj != null && this.zzajj.containsKey(var1)) {
         if(this.isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
         } else if(var2 < 0 || var2 >= this.zzajn) {
            throw new CursorIndexOutOfBoundsException(var2, this.zzajn);
         }
      } else {
         throw new IllegalArgumentException("No such column: " + var1);
      }
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   public int describeContents() {
      return 0;
   }

   protected void finalize() throws Throwable {
      // $FF: Couldn't be decompiled
   }

   public int getCount() {
      return this.zzajn;
   }

   public int getStatusCode() {
      return this.zzade;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public boolean isClosed() {
      // $FF: Couldn't be decompiled
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }

   public long zzb(String var1, int var2, int var3) {
      this.zzg(var1, var2);
      return this.zzajk[var3].getLong(var2, this.zzajj.getInt(var1));
   }

   public int zzbH(int var1) {
      int var2 = 0;
      boolean var3;
      if(var1 >= 0 && var1 < this.zzajn) {
         var3 = true;
      } else {
         var3 = false;
      }

      zzx.zzab(var3);

      while(var2 < this.zzajm.length) {
         if(var1 < this.zzajm[var2]) {
            --var2;
            break;
         }

         ++var2;
      }

      if(var2 == this.zzajm.length) {
         --var2;
      }

      return var2;
   }

   public int zzc(String var1, int var2, int var3) {
      this.zzg(var1, var2);
      return this.zzajk[var3].getInt(var2, this.zzajj.getInt(var1));
   }

   public boolean zzcz(String var1) {
      return this.zzajj.containsKey(var1);
   }

   public String zzd(String var1, int var2, int var3) {
      this.zzg(var1, var2);
      return this.zzajk[var3].getString(var2, this.zzajj.getInt(var1));
   }

   public boolean zze(String var1, int var2, int var3) {
      this.zzg(var1, var2);
      return Long.valueOf(this.zzajk[var3].getLong(var2, this.zzajj.getInt(var1))).longValue() == 1L;
   }

   public float zzf(String var1, int var2, int var3) {
      this.zzg(var1, var2);
      return this.zzajk[var3].getFloat(var2, this.zzajj.getInt(var1));
   }

   public byte[] zzg(String var1, int var2, int var3) {
      this.zzg(var1, var2);
      return this.zzajk[var3].getBlob(var2, this.zzajj.getInt(var1));
   }

   public Uri zzh(String var1, int var2, int var3) {
      String var4 = this.zzd(var1, var2, var3);
      return var4 == null?null:Uri.parse(var4);
   }

   public boolean zzi(String var1, int var2, int var3) {
      this.zzg(var1, var2);
      return this.zzajk[var3].isNull(var2, this.zzajj.getInt(var1));
   }

   public Bundle zzpZ() {
      return this.zzajl;
   }

   public void zzqd() {
      int var1 = 0;
      this.zzajj = new Bundle();

      for(int var2 = 0; var2 < this.zzaji.length; ++var2) {
         this.zzajj.putInt(this.zzaji[var2], var2);
      }

      this.zzajm = new int[this.zzajk.length];

      int var3;
      for(var3 = 0; var1 < this.zzajk.length; ++var1) {
         this.zzajm[var1] = var3;
         int var4 = var3 - this.zzajk[var1].getStartPosition();
         var3 += this.zzajk[var1].getNumRows() - var4;
      }

      this.zzajn = var3;
   }

   String[] zzqe() {
      return this.zzaji;
   }

   CursorWindow[] zzqf() {
      return this.zzajk;
   }

   public void zzu(Object var1) {
      this.zzajo = var1;
   }

   public static class zza {
      private final String[] zzaji;
      private final ArrayList<HashMap<String, Object>> zzajr;
      private final String zzajs;
      private final HashMap<Object, Integer> zzajt;
      private boolean zzaju;
      private String zzajv;

      private zza(String[] var1, String var2) {
         this.zzaji = (String[])zzx.zzz(var1);
         this.zzajr = new ArrayList();
         this.zzajs = var2;
         this.zzajt = new HashMap();
         this.zzaju = false;
         this.zzajv = null;
      }

      // $FF: synthetic method
      zza(String[] var1, String var2, Object var3) {
         this(var1, var2);
      }
   }
}
