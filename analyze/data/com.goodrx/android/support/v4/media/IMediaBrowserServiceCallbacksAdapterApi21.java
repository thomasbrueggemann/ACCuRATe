package android.support.v4.media;

import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class IMediaBrowserServiceCallbacksAdapterApi21 {
   private Method mAsBinderMethod;
   Object mCallbackObject;
   private Method mOnConnectFailedMethod;
   private Method mOnConnectMethod;
   private Method mOnLoadChildrenMethod;

   IMediaBrowserServiceCallbacksAdapterApi21(Object var1) {
      this.mCallbackObject = var1;

      Object var2;
      try {
         Class var3 = Class.forName("android.service.media.IMediaBrowserServiceCallbacks");
         Class var4 = Class.forName("android.content.pm.ParceledListSlice");
         this.mAsBinderMethod = var3.getMethod("asBinder", new Class[0]);
         this.mOnConnectMethod = var3.getMethod("onConnect", new Class[]{String.class, Token.class, Bundle.class});
         this.mOnConnectFailedMethod = var3.getMethod("onConnectFailed", new Class[0]);
         this.mOnLoadChildrenMethod = var3.getMethod("onLoadChildren", new Class[]{String.class, var4});
         return;
      } catch (ClassNotFoundException var5) {
         var2 = var5;
      } catch (NoSuchMethodException var6) {
         var2 = var6;
      }

      ((ReflectiveOperationException)var2).printStackTrace();
   }

   IBinder asBinder() {
      Object var1;
      try {
         IBinder var2 = (IBinder)this.mAsBinderMethod.invoke(this.mCallbackObject, new Object[0]);
         return var2;
      } catch (IllegalAccessException var3) {
         var1 = var3;
      } catch (InvocationTargetException var4) {
         var1 = var4;
      }

      ((ReflectiveOperationException)var1).printStackTrace();
      return null;
   }

   void onConnect(String var1, Object var2, Bundle var3) throws RemoteException {
      Object var4;
      try {
         this.mOnConnectMethod.invoke(this.mCallbackObject, new Object[]{var1, var2, var3});
         return;
      } catch (IllegalAccessException var5) {
         var4 = var5;
      } catch (InvocationTargetException var6) {
         var4 = var6;
      }

      ((ReflectiveOperationException)var4).printStackTrace();
   }

   void onConnectFailed() throws RemoteException {
      Object var1;
      try {
         this.mOnConnectFailedMethod.invoke(this.mCallbackObject, new Object[0]);
         return;
      } catch (IllegalAccessException var2) {
         var1 = var2;
      } catch (InvocationTargetException var3) {
         var1 = var3;
      }

      ((ReflectiveOperationException)var1).printStackTrace();
   }

   void onLoadChildren(String var1, Object var2) throws RemoteException {
      Object var3;
      try {
         this.mOnLoadChildrenMethod.invoke(this.mCallbackObject, new Object[]{var1, var2});
         return;
      } catch (IllegalAccessException var4) {
         var3 = var4;
      } catch (InvocationTargetException var5) {
         var3 = var5;
      }

      ((ReflectiveOperationException)var3).printStackTrace();
   }

   static class Stub {
      static Method sAsInterfaceMethod;

      static {
         Object var0;
         try {
            sAsInterfaceMethod = Class.forName("android.service.media.IMediaBrowserServiceCallbacks$Stub").getMethod("asInterface", new Class[]{IBinder.class});
            return;
         } catch (ClassNotFoundException var1) {
            var0 = var1;
         } catch (NoSuchMethodException var2) {
            var0 = var2;
         }

         ((ReflectiveOperationException)var0).printStackTrace();
      }

      static Object asInterface(IBinder var0) {
         Object var1;
         try {
            Object var2 = sAsInterfaceMethod.invoke((Object)null, new Object[]{var0});
            return var2;
         } catch (IllegalAccessException var3) {
            var1 = var3;
         } catch (InvocationTargetException var4) {
            var1 = var4;
         }

         ((ReflectiveOperationException)var1).printStackTrace();
         return null;
      }
   }
}
