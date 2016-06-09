package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator {
   public static UnsafeAllocator create() {
      try {
         Class var10 = Class.forName("sun.misc.Unsafe");
         Field var11 = var10.getDeclaredField("theUnsafe");
         var11.setAccessible(true);
         final Object var12 = var11.get((Object)null);
         UnsafeAllocator var13 = new UnsafeAllocator() {
            // $FF: synthetic field
            final Method val$allocateInstance;

            {
               this.val$allocateInstance = var1;
            }

            public <T> T newInstance(Class<T> var1) throws Exception {
               return this.val$allocateInstance.invoke(var12, new Object[]{var1});
            }
         };
         return var13;
      } catch (Exception var16) {
         try {
            final Method var8 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
            var8.setAccessible(true);
            UnsafeAllocator var9 = new UnsafeAllocator() {
               public <T> T newInstance(Class<T> var1) throws Exception {
                  return var8.invoke((Object)null, new Object[]{var1, Object.class});
               }
            };
            return var9;
         } catch (Exception var15) {
            try {
               Method var3 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
               var3.setAccessible(true);
               final int var4 = ((Integer)var3.invoke((Object)null, new Object[]{Object.class})).intValue();
               Class[] var5 = new Class[]{Class.class, Integer.TYPE};
               final Method var6 = ObjectStreamClass.class.getDeclaredMethod("newInstance", var5);
               var6.setAccessible(true);
               UnsafeAllocator var7 = new UnsafeAllocator() {
                  public <T> T newInstance(Class<T> var1) throws Exception {
                     Method var2 = var6;
                     Object[] var3 = new Object[]{var1, Integer.valueOf(var4)};
                     return var2.invoke((Object)null, var3);
                  }
               };
               return var7;
            } catch (Exception var14) {
               return new UnsafeAllocator() {
                  public <T> T newInstance(Class<T> var1) {
                     throw new UnsupportedOperationException("Cannot allocate " + var1);
                  }
               };
            }
         }
      }
   }

   public abstract <T> T newInstance(Class<T> var1) throws Exception;
}
