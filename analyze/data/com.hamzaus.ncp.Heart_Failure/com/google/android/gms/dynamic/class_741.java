package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.d;
import java.lang.reflect.Field;

// $FF: renamed from: com.google.android.gms.dynamic.e
public final class class_741<T> extends class_157.class_1317 {
   // $FF: renamed from: Mh java.lang.Object
   private final T field_3918;

   private class_741(T var1) {
      this.field_3918 = var1;
   }

   // $FF: renamed from: e (com.google.android.gms.dynamic.d) java.lang.Object
   public static <T> T method_4177(d var0) {
      if(var0 instanceof class_741) {
         return ((class_741)var0).field_3918;
      } else {
         IBinder var1 = var0.asBinder();
         Field[] var2 = var1.getClass().getDeclaredFields();
         if(var2.length == 1) {
            Field var3 = var2[0];
            if(!var3.isAccessible()) {
               var3.setAccessible(true);

               try {
                  Object var7 = var3.get(var1);
                  return var7;
               } catch (NullPointerException var8) {
                  throw new IllegalArgumentException("Binder object is null.", var8);
               } catch (IllegalArgumentException var9) {
                  throw new IllegalArgumentException("remoteBinder is the wrong class.", var9);
               } catch (IllegalAccessException var10) {
                  throw new IllegalArgumentException("Could not access the field in remoteBinder.", var10);
               }
            } else {
               throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
         } else {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
         }
      }
   }

   // $FF: renamed from: h (java.lang.Object) com.google.android.gms.dynamic.d
   public static <T> d method_4178(T var0) {
      return new class_741(var0);
   }
}
