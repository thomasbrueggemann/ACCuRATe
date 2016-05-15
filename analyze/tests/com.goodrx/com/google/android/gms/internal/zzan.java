package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzao;

public class zzan {
   private static final String[] zzov = new String[]{"/aclk", "/pcs/click"};
   private String zzot;
   private String[] zzou;
   private zzaj zzow;

   private Uri zza(Uri param1, Context param2, String param3, boolean param4) throws zzao {
      // $FF: Couldn't be decompiled
   }

   private Uri zza(Uri var1, String var2, String var3) throws UnsupportedOperationException {
      String var4 = var1.toString();
      int var5 = var4.indexOf("&adurl");
      if(var5 == -1) {
         var5 = var4.indexOf("?adurl");
      }

      return var5 != -1?Uri.parse(var4.substring(0, var5 + 1) + var2 + "=" + var3 + "&" + var4.substring(var5 + 1)):var1.buildUpon().appendQueryParameter(var2, var3).build();
   }

   private Uri zzb(Uri var1, String var2, String var3) {
      String var4 = var1.toString();
      int var5 = var4.indexOf(";adurl");
      if(var5 != -1) {
         return Uri.parse(var4.substring(0, var5 + 1) + var2 + "=" + var3 + ";" + var4.substring(var5 + 1));
      } else {
         String var6 = var1.getEncodedPath();
         int var7 = var4.indexOf(var6);
         return Uri.parse(var4.substring(0, var7 + var6.length()) + ";" + var2 + "=" + var3 + ";" + var4.substring(var7 + var6.length()));
      }
   }

   public Uri zza(Uri var1, Context var2) throws zzao {
      try {
         Uri var4 = this.zza(var1, var2, var1.getQueryParameter("ai"), true);
         return var4;
      } catch (UnsupportedOperationException var5) {
         throw new zzao("Provided Uri is not in a valid state");
      }
   }

   public void zza(MotionEvent var1) {
      this.zzow.zza(var1);
   }

   public boolean zza(Uri var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         try {
            boolean var3 = var1.getHost().equals(this.zzot);
            return var3;
         } catch (NullPointerException var4) {
            return false;
         }
      }
   }

   public zzaj zzab() {
      return this.zzow;
   }

   public boolean zzb(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean zzc(Uri var1) {
      boolean var2 = this.zzb(var1);
      boolean var3 = false;
      if(var2) {
         String[] var4 = zzov;
         int var5 = var4.length;
         int var6 = 0;

         while(true) {
            var3 = false;
            if(var6 >= var5) {
               break;
            }

            String var7 = var4[var6];
            if(var1.getPath().endsWith(var7)) {
               var3 = true;
               break;
            }

            ++var6;
         }
      }

      return var3;
   }
}
