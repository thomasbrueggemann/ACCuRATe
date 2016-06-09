package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.app.AppOpsManagerCompat23;

public final class AppOpsManagerCompat {
   private static final AppOpsManagerCompat.AppOpsManagerImpl IMPL;
   public static final int MODE_ALLOWED = 0;
   public static final int MODE_DEFAULT = 3;
   public static final int MODE_IGNORED = 1;

   static {
      if(VERSION.SDK_INT >= 23) {
         IMPL = new AppOpsManagerCompat.AppOpsManager23();
      } else {
         IMPL = new AppOpsManagerCompat.AppOpsManagerImpl();
      }
   }

   public static int noteOp(@NonNull Context var0, @NonNull String var1, int var2, @NonNull String var3) {
      return IMPL.noteOp(var0, var1, var2, var3);
   }

   public static int noteProxyOp(@NonNull Context var0, @NonNull String var1, @NonNull String var2) {
      return IMPL.noteProxyOp(var0, var1, var2);
   }

   public static String permissionToOp(@NonNull String var0) {
      return IMPL.permissionToOp(var0);
   }

   private static class AppOpsManager23 extends AppOpsManagerCompat.AppOpsManagerImpl {
      private AppOpsManager23() {
         super(null);
      }

      // $FF: synthetic method
      AppOpsManager23(Object var1) {
         this();
      }

      public int noteOp(Context var1, String var2, int var3, String var4) {
         return AppOpsManagerCompat23.noteOp(var1, var2, var3, var4);
      }

      public int noteProxyOp(Context var1, String var2, String var3) {
         return AppOpsManagerCompat23.noteProxyOp(var1, var2, var3);
      }

      public String permissionToOp(String var1) {
         return AppOpsManagerCompat23.permissionToOp(var1);
      }
   }

   private static class AppOpsManagerImpl {
      private AppOpsManagerImpl() {
      }

      // $FF: synthetic method
      AppOpsManagerImpl(Object var1) {
         this();
      }

      public int noteOp(Context var1, String var2, int var3, String var4) {
         return 1;
      }

      public int noteProxyOp(Context var1, String var2, String var3) {
         return 1;
      }

      public String permissionToOp(String var1) {
         return null;
      }
   }
}
