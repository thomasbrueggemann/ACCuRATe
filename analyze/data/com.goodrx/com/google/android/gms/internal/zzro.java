package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;

public final class zzro implements Api.Optional {
   public static final zzro zzbgV = (new zzro.zza()).zzFJ();
   private final boolean zzXa;
   private final boolean zzXc;
   private final String zzXd;
   private final String zzXe;
   private final boolean zzbgW;
   private final boolean zzbgX;

   private zzro(boolean var1, boolean var2, String var3, boolean var4, String var5, boolean var6) {
      this.zzbgW = var1;
      this.zzXa = var2;
      this.zzXd = var3;
      this.zzXc = var4;
      this.zzbgX = var6;
      this.zzXe = var5;
   }

   // $FF: synthetic method
   zzro(boolean var1, boolean var2, String var3, boolean var4, String var5, boolean var6, Object var7) {
      this(var1, var2, var3, var4, var5, var6);
   }

   public boolean zzFH() {
      return this.zzbgW;
   }

   public boolean zzFI() {
      return this.zzbgX;
   }

   public boolean zzmO() {
      return this.zzXa;
   }

   public boolean zzmQ() {
      return this.zzXc;
   }

   public String zzmR() {
      return this.zzXd;
   }

   @Nullable
   public String zzmS() {
      return this.zzXe;
   }

   public static final class zza {
      private String zzbdY;
      private boolean zzbgY;
      private boolean zzbgZ;
      private boolean zzbha;
      private String zzbhb;
      private boolean zzbhc;

      public zzro zzFJ() {
         return new zzro(this.zzbgY, this.zzbgZ, this.zzbdY, this.zzbha, this.zzbhb, this.zzbhc);
      }
   }
}
