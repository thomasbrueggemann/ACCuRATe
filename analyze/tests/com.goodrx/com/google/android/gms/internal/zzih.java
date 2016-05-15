package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbd;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzbf;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzii;
import com.google.android.gms.internal.zzir;
import java.lang.Thread.UncaughtExceptionHandler;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

@zzhb
public class zzih {
   private Context mContext;
   private boolean zzJA;
   private boolean zzJz;
   private final LinkedList<Thread> zzLA;
   private Boolean zzLB;
   private boolean zzLC;
   private boolean zzLD;
   private final String zzLq;
   private final zzii zzLr;
   private BigInteger zzLs;
   private final HashSet<Object> zzLt;
   private final HashMap<String, Object> zzLu;
   private boolean zzLv;
   private int zzLw;
   private zzbv zzLx;
   private zzbf zzLy;
   private VersionInfoParcel zzpT;
   private final Object zzpV = new Object();
   private boolean zzqA;
   private zzbe zzsZ;
   private zzbd zzta;
   private final zzha zztb;
   private String zzzN;

   public zzih(zzir var1) {
      this.zzLs = BigInteger.ONE;
      this.zzLt = new HashSet();
      this.zzLu = new HashMap();
      this.zzLv = false;
      this.zzJz = true;
      this.zzLw = 0;
      this.zzqA = false;
      this.zzLx = null;
      this.zzJA = true;
      this.zzsZ = null;
      this.zzLy = null;
      this.zzta = null;
      this.zzLA = new LinkedList();
      this.zztb = null;
      this.zzLB = null;
      this.zzLC = false;
      this.zzLD = false;
      this.zzLq = var1.zzhs();
      this.zzLr = new zzii(this.zzLq);
   }

   public void zzb(Boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzb(Throwable var1, boolean var2) {
      (new zzha(this.mContext, this.zzpT, (UncaughtExceptionHandler)null, (UncaughtExceptionHandler)null)).zza(var1, var2);
   }

   public String zzd(int var1, String var2) {
      Resources var3;
      if(this.zzpT.zzNb) {
         var3 = this.mContext.getResources();
      } else {
         var3 = com.google.android.gms.common.zze.getRemoteResource(this.mContext);
      }

      return var3 == null?var2:var3.getString(var1);
   }

   public zzbv zzhb() {
      // $FF: Couldn't be decompiled
   }

   public String zzhe() {
      // $FF: Couldn't be decompiled
   }

   public Boolean zzhg() {
      // $FF: Couldn't be decompiled
   }
}
