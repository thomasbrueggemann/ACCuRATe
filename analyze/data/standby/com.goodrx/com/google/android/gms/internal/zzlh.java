package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlg;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zzlh extends zzlg {
   public static final List<String> zzYf = Collections.singletonList("email");
   private Class<?> zzYg;
   private Class<?> zzYh;
   private Object zzYi;
   private Object zzYj;

   public zzlh(Activity var1, List<String> var2) {
      super(var1, zzYf, var2);
   }

   public static void zzag(Context param0) throws IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   private void zznv() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
      if(this.zzYj != null) {
         Method var21 = Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[]{Activity.class, Collection.class});
         Object var22 = this.zzYj;
         Object[] var23 = new Object[]{this.mActivity, new ArrayList(this.zzns())};
         var21.invoke(var22, var23);
      } else {
         Class var1 = Class.forName("com.facebook.Session$OpenRequest");
         Constructor var2 = var1.getConstructor(new Class[]{Activity.class});
         Object[] var3 = new Object[]{this.mActivity};
         Object var4 = var2.newInstance(var3);
         Method var5 = var1.getDeclaredMethod("setPermissions", new Class[]{List.class});
         Object[] var6 = new Object[]{new ArrayList(this.zzns())};
         var5.invoke(var4, var6);
         Class[] var8 = new Class[]{Integer.TYPE};
         Method var9 = var1.getDeclaredMethod("setRequestCode", var8);
         Object[] var10 = new Object[]{Integer.valueOf('龜')};
         var9.invoke(var4, var10);
         Class var12 = Class.forName("com.facebook.Session");
         Method var13 = var1.getDeclaredMethod("setCallback", new Class[]{Class.forName("com.facebook.Session$StatusCallback")});
         Object[] var14 = new Object[]{this.zznw()};
         var13.invoke(var4, var14);
         Constructor var16 = var12.getConstructor(new Class[]{Context.class});
         Object[] var17 = new Object[]{this.mActivity};
         Object var18 = var16.newInstance(var17);
         var12.getDeclaredMethod("setActiveSession", new Class[]{var12}).invoke((Object)null, new Object[]{var18});
         var12.getDeclaredMethod("openForRead", new Class[]{var1}).invoke(var18, new Object[]{var4});
      }
   }

   private Object zznw() throws ClassNotFoundException {
      final Class var1 = Class.forName("com.facebook.Session");
      Class var2 = Class.forName("com.facebook.Session$StatusCallback");
      return Proxy.newProxyInstance(var2.getClassLoader(), new Class[]{var2}, new InvocationHandler() {
         public Object invoke(Object var1x, Method var2, Object[] var3) throws Throwable {
            Class var4 = Class.forName("com.facebook.SessionState");
            Class[] var5 = var2.getParameterTypes();
            if(var2.getName().equals("call") && var5.length == 3 && var5[0] == var1 && var5[1] == var4 && var5[2] == Exception.class) {
               if(((Boolean)var1.getDeclaredMethod("isOpened", new Class[0]).invoke(var3[0], new Object[0])).booleanValue()) {
                  String var6 = (String)var1.getDeclaredMethod("getAccessToken", new Class[0]).invoke(var3[0], new Object[0]);
                  zzlh.this.zznt().zzk(zzlh.this.zza(IdpTokenType.zzXA, var6, zzlh.this.zznu()));
               }

               return null;
            } else {
               throw new ExceptionInInitializerError("Method not supported!");
            }
         }
      });
   }

   public void zza(zzlf.zza var1) {
      this.zzb((String)null, (String)null, (zzlf.zza)com.google.android.gms.common.internal.zzx.zzz(var1));

      Object var2;
      try {
         this.zznv();
         return;
      } catch (ClassNotFoundException var3) {
         var2 = var3;
      } catch (NoSuchMethodException var4) {
         var2 = var4;
      } catch (IllegalAccessException var5) {
         var2 = var5;
      } catch (InvocationTargetException var6) {
         var2 = var6;
      } catch (InstantiationException var7) {
         var2 = var7;
      }

      throw new RuntimeException((Throwable)var2);
   }

   public void zza(String var1, zzlf.zza var2) {
      this.zzb((String)com.google.android.gms.common.internal.zzx.zzz(var1), (String)null, (zzlf.zza)com.google.android.gms.common.internal.zzx.zzz(var2));

      Object var3;
      try {
         this.zznv();
         return;
      } catch (ClassNotFoundException var4) {
         var3 = var4;
      } catch (NoSuchMethodException var5) {
         var3 = var5;
      } catch (IllegalAccessException var6) {
         var3 = var6;
      } catch (InvocationTargetException var7) {
         var3 = var7;
      } catch (InstantiationException var8) {
         var3 = var8;
      }

      throw new RuntimeException((Throwable)var3);
   }

   public void zza(String var1, String var2, zzlf.zza var3) {
      this.zzb((String)com.google.android.gms.common.internal.zzx.zzz(var1), (String)com.google.android.gms.common.internal.zzx.zzz(var2), (zzlf.zza)com.google.android.gms.common.internal.zzx.zzz(var3));

      Object var4;
      try {
         this.zznv();
         return;
      } catch (ClassNotFoundException var5) {
         var4 = var5;
      } catch (NoSuchMethodException var6) {
         var4 = var6;
      } catch (IllegalAccessException var7) {
         var4 = var7;
      } catch (InvocationTargetException var8) {
         var4 = var8;
      } catch (InstantiationException var9) {
         var4 = var9;
      }

      throw new RuntimeException((Throwable)var4);
   }

   public boolean zza(int param1, int param2, Intent param3, zzlf.zza param4) {
      // $FF: Couldn't be decompiled
   }

   public com.google.android.gms.auth.api.signin.zzd zzmU() {
      return com.google.android.gms.auth.api.signin.zzd.zzXi;
   }
}
