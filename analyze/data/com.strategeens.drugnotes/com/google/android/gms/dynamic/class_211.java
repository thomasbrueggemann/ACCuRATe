package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.class_335;

// $FF: renamed from: com.google.android.gms.dynamic.g
public abstract class class_211<T> {
   // $FF: renamed from: TI java.lang.String
   private final String field_351;
   // $FF: renamed from: TJ java.lang.Object
   private T field_352;

   protected class_211(String var1) {
      this.field_351 = var1;
   }

   // $FF: renamed from: L (android.content.Context) java.lang.Object
   protected final T method_1510(Context var1) throws class_211.class_1565 {
      if(this.field_352 == null) {
         class_335.method_2311(var1);
         Context var3 = GooglePlayServicesUtil.getRemoteContext(var1);
         if(var3 == null) {
            throw new class_211.class_1565("Could not get remote context.");
         }

         ClassLoader var4 = var3.getClassLoader();

         try {
            this.field_352 = this.method_1511((IBinder)var4.loadClass(this.field_351).newInstance());
         } catch (ClassNotFoundException var8) {
            throw new class_211.class_1565("Could not load creator class.", var8);
         } catch (InstantiationException var9) {
            throw new class_211.class_1565("Could not instantiate creator.", var9);
         } catch (IllegalAccessException var10) {
            throw new class_211.class_1565("Could not access creator.", var10);
         }
      }

      return this.field_352;
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   protected abstract T method_1511(IBinder var1);

   public static class class_1565 extends Exception {
      public class_1565(String var1) {
         super(var1);
      }

      public class_1565(String var1, Throwable var2) {
         super(var1, var2);
      }
   }
}
