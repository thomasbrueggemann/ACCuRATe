package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.class_347;

// $FF: renamed from: com.google.android.gms.dynamic.g
public abstract class class_176<T> {
   // $FF: renamed from: Mi java.lang.String
   private final String field_573;
   // $FF: renamed from: Mj java.lang.Object
   private T field_574;

   protected class_176(String var1) {
      this.field_573 = var1;
   }

   // $FF: renamed from: D (android.content.Context) java.lang.Object
   protected final T method_1276(Context var1) throws class_176.class_1202 {
      if(this.field_574 == null) {
         class_347.method_2170(var1);
         Context var3 = GooglePlayServicesUtil.getRemoteContext(var1);
         if(var3 == null) {
            throw new class_176.class_1202("Could not get remote context.");
         }

         ClassLoader var4 = var3.getClassLoader();

         try {
            this.field_574 = this.method_1277((IBinder)var4.loadClass(this.field_573).newInstance());
         } catch (ClassNotFoundException var8) {
            throw new class_176.class_1202("Could not load creator class.");
         } catch (InstantiationException var9) {
            throw new class_176.class_1202("Could not instantiate creator.");
         } catch (IllegalAccessException var10) {
            throw new class_176.class_1202("Could not access creator.");
         }
      }

      return this.field_574;
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   protected abstract T method_1277(IBinder var1);

   public static class class_1202 extends Exception {
      public class_1202(String var1) {
         super(var1);
      }

      public class_1202(String var1, Throwable var2) {
         super(var1, var2);
      }
   }
}
