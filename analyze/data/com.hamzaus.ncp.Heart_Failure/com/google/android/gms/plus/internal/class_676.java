package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.plus.internal.class_146;

// $FF: renamed from: com.google.android.gms.plus.internal.g
public final class class_676 {
   private static Context aag;
   private static class_146 abP;

   // $FF: renamed from: H (android.content.Context) com.google.android.gms.plus.internal.c
   private static class_146 method_3935(Context var0) throws class_676.class_799 {
      class_347.method_2170(var0);
      if(abP == null) {
         if(aag == null) {
            aag = GooglePlayServicesUtil.getRemoteContext(var0);
            if(aag == null) {
               throw new class_676.class_799("Could not get remote context.");
            }
         }

         ClassLoader var2 = aag.getClassLoader();

         try {
            abP = class_146.class_1000.method_3813((IBinder)var2.loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
         } catch (ClassNotFoundException var6) {
            throw new class_676.class_799("Could not load creator class.");
         } catch (InstantiationException var7) {
            throw new class_676.class_799("Could not instantiate creator.");
         } catch (IllegalAccessException var8) {
            throw new class_676.class_799("Could not access creator.");
         }
      }

      return abP;
   }

   // $FF: renamed from: a (android.content.Context, int, int, java.lang.String, int) android.view.View
   public static View method_3936(Context param0, int param1, int param2, String param3, int param4) {
      // $FF: Couldn't be decompiled
   }

   public static class class_799 extends Exception {
      public class_799(String var1) {
         super(var1);
      }
   }
}
