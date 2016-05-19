package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.ExceptionParser;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class StandardExceptionParser implements ExceptionParser {
   private final TreeSet<String> zzPr = new TreeSet();

   public StandardExceptionParser(Context var1, Collection<String> var2) {
      this.setIncludedPackages(var1, var2);
   }

   protected StackTraceElement getBestStackTraceElement(Throwable var1) {
      StackTraceElement[] var2 = var1.getStackTrace();
      if(var2 != null && var2.length != 0) {
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            StackTraceElement var5 = var2[var4];
            String var6 = var5.getClassName();
            Iterator var7 = this.zzPr.iterator();

            while(var7.hasNext()) {
               if(var6.startsWith((String)var7.next())) {
                  return var5;
               }
            }
         }

         return var2[0];
      } else {
         return null;
      }
   }

   protected Throwable getCause(Throwable var1) {
      while(var1.getCause() != null) {
         var1 = var1.getCause();
      }

      return var1;
   }

   public String getDescription(String var1, Throwable var2) {
      return this.getDescription(this.getCause(var2), this.getBestStackTraceElement(this.getCause(var2)), var1);
   }

   protected String getDescription(Throwable var1, StackTraceElement var2, String var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append(var1.getClass().getSimpleName());
      if(var2 != null) {
         String[] var7 = var2.getClassName().split("\\.");
         String var8 = "unknown";
         if(var7 != null && var7.length > 0) {
            var8 = var7[-1 + var7.length];
         }

         Object[] var9 = new Object[]{var8, var2.getMethodName(), Integer.valueOf(var2.getLineNumber())};
         var4.append(String.format(" (@%s:%s:%s)", var9));
      }

      if(var3 != null) {
         var4.append(String.format(" {%s}", new Object[]{var3}));
      }

      return var4.toString();
   }

   public void setIncludedPackages(Context param1, Collection<String> param2) {
      // $FF: Couldn't be decompiled
   }
}
