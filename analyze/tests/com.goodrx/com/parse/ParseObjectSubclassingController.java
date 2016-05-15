package com.parse;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

class ParseObjectSubclassingController {
   private final Object mutex = new Object();
   private final Map<String, Constructor<? extends ParseObject>> registeredSubclasses = new HashMap();

   private static Constructor<? extends ParseObject> getConstructor(Class<? extends ParseObject> var0) throws NoSuchMethodException, IllegalAccessException {
      Constructor var1 = var0.getDeclaredConstructor(new Class[0]);
      if(var1 == null) {
         throw new NoSuchMethodException();
      } else {
         int var2 = var1.getModifiers();
         if(!Modifier.isPublic(var2) && (!var0.getPackage().getName().equals("com.parse") || Modifier.isProtected(var2) || Modifier.isPrivate(var2))) {
            throw new IllegalAccessException();
         } else {
            return var1;
         }
      }
   }

   String getClassName(Class<? extends ParseObject> var1) {
      ParseClassName var2 = (ParseClassName)var1.getAnnotation(ParseClassName.class);
      if(var2 == null) {
         throw new IllegalArgumentException("No ParseClassName annotation provided on " + var1);
      } else {
         return var2.value();
      }
   }

   boolean isSubclassValid(String param1, Class<? extends ParseObject> param2) {
      // $FF: Couldn't be decompiled
   }

   ParseObject newInstance(String param1) {
      // $FF: Couldn't be decompiled
   }

   void registerSubclass(Class<? extends ParseObject> param1) {
      // $FF: Couldn't be decompiled
   }

   void unregisterSubclass(Class<? extends ParseObject> param1) {
      // $FF: Couldn't be decompiled
   }
}
