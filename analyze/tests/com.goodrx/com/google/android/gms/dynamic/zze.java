package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.zzd;
import java.lang.reflect.Field;

public final class zze<T> extends zzd.zza {
   private final T mWrappedObject;

   private zze(T var1) {
      this.mWrappedObject = var1;
   }

   public static <T> zzd zzC(T var0) {
      return new zze(var0);
   }

   public static <T> T zzp(zzd var0) {
      if(var0 instanceof zze) {
         return ((zze)var0).mWrappedObject;
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
}
