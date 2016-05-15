package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Looper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;

@zzhb
public class zzha implements UncaughtExceptionHandler {
   private Context mContext;
   private VersionInfoParcel zzEZ;
   private UncaughtExceptionHandler zzHe;
   private UncaughtExceptionHandler zzHf;

   public zzha(Context var1, VersionInfoParcel var2, UncaughtExceptionHandler var3, UncaughtExceptionHandler var4) {
      this.zzHe = var3;
      this.zzHf = var4;
      this.mContext = var1;
      this.zzEZ = var2;
   }

   private static boolean zzA(Context var0) {
      return ((Boolean)zzbt.zzvG.get()).booleanValue();
   }

   private Throwable zzb(Throwable var1) {
      if(((Boolean)zzbt.zzvH.get()).booleanValue()) {
         return var1;
      } else {
         LinkedList var2;
         for(var2 = new LinkedList(); var1 != null; var1 = var1.getCause()) {
            var2.push(var1);
         }

         Throwable var3;
         Throwable var11;
         for(var3 = null; !var2.isEmpty(); var3 = var11) {
            Throwable var4 = (Throwable)var2.pop();
            StackTraceElement[] var5 = var4.getStackTrace();
            ArrayList var6 = new ArrayList();
            var6.add(new StackTraceElement(var4.getClass().getName(), "<filtered>", "<filtered>", 1));
            int var8 = var5.length;
            int var9 = 0;

            boolean var10;
            for(var10 = false; var9 < var8; ++var9) {
               StackTraceElement var12 = var5[var9];
               if(this.zzat(var12.getClassName())) {
                  var6.add(var12);
                  var10 = true;
               } else if(this.zzau(var12.getClassName())) {
                  var6.add(var12);
               } else {
                  var6.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
               }
            }

            if(var10) {
               if(var3 == null) {
                  var11 = new Throwable(var4.getMessage());
               } else {
                  var11 = new Throwable(var4.getMessage(), var3);
               }

               var11.setStackTrace((StackTraceElement[])var6.toArray(new StackTraceElement[0]));
            } else {
               var11 = var3;
            }
         }

         return var3;
      }
   }

   public void uncaughtException(Thread var1, Throwable var2) {
      if(this.zza(var2)) {
         if(Looper.getMainLooper().getThread() != var1) {
            this.zza(var2, true);
            return;
         }

         this.zza(var2, false);
      }

      if(this.zzHe != null) {
         this.zzHe.uncaughtException(var1, var2);
      } else if(this.zzHf != null) {
         this.zzHf.uncaughtException(var1, var2);
      }
   }

   String zza(Class var1, Throwable var2, boolean var3) {
      StringWriter var4 = new StringWriter();
      var2.printStackTrace(new PrintWriter(var4));
      return (new Builder()).scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", com.google.android.gms.ads.internal.zzr.zzbC().zzht()).appendQueryParameter("js", this.zzEZ.afmaVersion).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", var1.getName()).appendQueryParameter("stacktrace", var4.toString()).appendQueryParameter("eids", TextUtils.join(",", zzbt.zzdr())).appendQueryParameter("trapped", String.valueOf(var3)).toString();
   }

   public void zza(Throwable var1, boolean var2) {
      if(zzA(this.mContext)) {
         Throwable var3 = this.zzb(var1);
         if(var3 != null) {
            Class var4 = var1.getClass();
            ArrayList var5 = new ArrayList();
            var5.add(this.zza(var4, var3, var2));
            com.google.android.gms.ads.internal.zzr.zzbC().zza(this.mContext, this.zzEZ.afmaVersion, var5, com.google.android.gms.ads.internal.zzr.zzbF().zzhe());
            return;
         }
      }

   }

   protected boolean zza(Throwable var1) {
      boolean var2 = true;
      if(var1 == null) {
         return false;
      } else {
         boolean var3 = false;

         boolean var4;
         for(var4 = false; var1 != null; var1 = var1.getCause()) {
            StackTraceElement[] var5 = var1.getStackTrace();
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
               StackTraceElement var8 = var5[var7];
               if(this.zzat(var8.getClassName())) {
                  var4 = var2;
               }

               if(this.getClass().getName().equals(var8.getClassName())) {
                  var3 = var2;
               }
            }
         }

         if(!var4 || var3) {
            var2 = false;
         }

         return var2;
      }
   }

   protected boolean zzat(String var1) {
      if(TextUtils.isEmpty(var1)) {
         return false;
      } else if(var1.startsWith("com.google.android.gms.ads")) {
         return true;
      } else if(var1.startsWith("com.google.ads")) {
         return true;
      } else {
         try {
            boolean var3 = Class.forName(var1).isAnnotationPresent(zzhb.class);
            return var3;
         } catch (Exception var4) {
            zzin.zza("Fail to check class type for class " + var1, var4);
            return false;
         }
      }
   }

   protected boolean zzau(String var1) {
      return !TextUtils.isEmpty(var1) && (var1.startsWith("android.") || var1.startsWith("java."));
   }
}
