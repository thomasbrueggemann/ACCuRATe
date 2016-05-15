package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class CloseableHttpResponseProxy implements InvocationHandler {
   private static final Constructor<?> CONSTRUCTOR;
   private final HttpResponse original;

   static {
      try {
         CONSTRUCTOR = Proxy.getProxyClass(CloseableHttpResponseProxy.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}).getConstructor(new Class[]{InvocationHandler.class});
      } catch (NoSuchMethodException var1) {
         throw new IllegalStateException(var1);
      }
   }

   CloseableHttpResponseProxy(HttpResponse var1) {
      this.original = var1;
   }

   public static CloseableHttpResponse newProxy(HttpResponse var0) {
      try {
         Constructor var4 = CONSTRUCTOR;
         Object[] var5 = new Object[]{new CloseableHttpResponseProxy(var0)};
         CloseableHttpResponse var6 = (CloseableHttpResponse)var4.newInstance(var5);
         return var6;
      } catch (InstantiationException var7) {
         throw new IllegalStateException(var7);
      } catch (InvocationTargetException var8) {
         throw new IllegalStateException(var8);
      } catch (IllegalAccessException var9) {
         throw new IllegalStateException(var9);
      }
   }

   public void close() throws IOException {
      EntityUtils.consume(this.original.getEntity());
   }

   public Object invoke(Object var1, Method var2, Object[] var3) throws Throwable {
      if(var2.getName().equals("close")) {
         this.close();
         return null;
      } else {
         try {
            Object var6 = var2.invoke(this.original, var3);
            return var6;
         } catch (InvocationTargetException var7) {
            Throwable var5 = var7.getCause();
            if(var5 != null) {
               throw var5;
            } else {
               throw var7;
            }
         }
      }
   }
}
