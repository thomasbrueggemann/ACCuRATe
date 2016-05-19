package com.newrelic.com.google.gson.reflect;

import com.newrelic.com.google.gson.internal.$Gson$Preconditions;
import com.newrelic.com.google.gson.internal.$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T> {
   final int hashCode;
   final Class<? super T> rawType;
   final Type type;

   protected TypeToken() {
      this.type = getSuperclassTypeParameter(this.getClass());
      this.rawType = $Gson$Types.getRawType(this.type);
      this.hashCode = this.type.hashCode();
   }

   TypeToken(Type var1) {
      this.type = $Gson$Types.canonicalize((Type)$Gson$Preconditions.checkNotNull(var1));
      this.rawType = $Gson$Types.getRawType(this.type);
      this.hashCode = this.type.hashCode();
   }

   private static AssertionError buildUnexpectedTypeError(Type var0, Class... var1) {
      StringBuilder var2 = new StringBuilder("Unexpected type. Expected one of: ");
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.append(var1[var4].getName()).append(", ");
      }

      var2.append("but got: ").append(var0.getClass().getName()).append(", for type token: ").append(var0.toString()).append('.');
      return new AssertionError(var2.toString());
   }

   public static <T> TypeToken<T> get(Class<T> var0) {
      return new TypeToken(var0);
   }

   public static TypeToken<?> get(Type var0) {
      return new TypeToken(var0);
   }

   static Type getSuperclassTypeParameter(Class<?> var0) {
      Type var1 = var0.getGenericSuperclass();
      if(var1 instanceof Class) {
         throw new RuntimeException("Missing type parameter.");
      } else {
         return $Gson$Types.canonicalize(((ParameterizedType)var1).getActualTypeArguments()[0]);
      }
   }

   private static boolean isAssignableFrom(Type var0, GenericArrayType var1) {
      Type var2 = var1.getGenericComponentType();
      if(!(var2 instanceof ParameterizedType)) {
         return true;
      } else {
         Object var3 = var0;
         if(var0 instanceof GenericArrayType) {
            var3 = ((GenericArrayType)var0).getGenericComponentType();
         } else if(var0 instanceof Class) {
            Class var4;
            for(var4 = (Class)var0; var4.isArray(); var4 = var4.getComponentType()) {
               ;
            }

            var3 = var4;
         }

         return isAssignableFrom((Type)var3, (ParameterizedType)var2, new HashMap());
      }
   }

   private static boolean isAssignableFrom(Type var0, ParameterizedType var1, Map<String, Type> var2) {
      if(var0 == null) {
         return false;
      } else if(var1.equals(var0)) {
         return true;
      } else {
         Class var3 = $Gson$Types.getRawType(var0);
         boolean var4 = var0 instanceof ParameterizedType;
         ParameterizedType var5 = null;
         if(var4) {
            var5 = (ParameterizedType)var0;
         }

         if(var5 != null) {
            Type[] var9 = var5.getActualTypeArguments();
            TypeVariable[] var10 = var3.getTypeParameters();

            for(int var11 = 0; var11 < var9.length; ++var11) {
               Type var12 = var9[var11];

               TypeVariable var13;
               for(var13 = var10[var11]; var12 instanceof TypeVariable; var12 = (Type)var2.get(((TypeVariable)var12).getName())) {
                  ;
               }

               var2.put(var13.getName(), var12);
            }

            if(typeEquals(var5, var1, var2)) {
               return true;
            }
         }

         Type[] var6 = var3.getGenericInterfaces();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            if(isAssignableFrom(var6[var8], var1, new HashMap(var2))) {
               return true;
            }
         }

         return isAssignableFrom(var3.getGenericSuperclass(), var1, new HashMap(var2));
      }
   }

   private static boolean matches(Type var0, Type var1, Map<String, Type> var2) {
      return var1.equals(var0) || var0 instanceof TypeVariable && var1.equals(var2.get(((TypeVariable)var0).getName()));
   }

   private static boolean typeEquals(ParameterizedType var0, ParameterizedType var1, Map<String, Type> var2) {
      if(var0.getRawType().equals(var1.getRawType())) {
         Type[] var3 = var0.getActualTypeArguments();
         Type[] var4 = var1.getActualTypeArguments();
         int var5 = 0;

         while(true) {
            if(var5 >= var3.length) {
               return true;
            }

            if(!matches(var3[var5], var4[var5], var2)) {
               break;
            }

            ++var5;
         }
      }

      return false;
   }

   public final boolean equals(Object var1) {
      return var1 instanceof TypeToken && $Gson$Types.equals(this.type, ((TypeToken)var1).type);
   }

   public final Class<? super T> getRawType() {
      return this.rawType;
   }

   public final Type getType() {
      return this.type;
   }

   public final int hashCode() {
      return this.hashCode;
   }

   @Deprecated
   public boolean isAssignableFrom(TypeToken<?> var1) {
      return this.isAssignableFrom(var1.getType());
   }

   @Deprecated
   public boolean isAssignableFrom(Class<?> var1) {
      return this.isAssignableFrom((Type)var1);
   }

   @Deprecated
   public boolean isAssignableFrom(Type var1) {
      if(var1 == null) {
         return false;
      } else if(this.type.equals(var1)) {
         return true;
      } else if(this.type instanceof Class) {
         return this.rawType.isAssignableFrom($Gson$Types.getRawType(var1));
      } else if(this.type instanceof ParameterizedType) {
         return isAssignableFrom(var1, (ParameterizedType)this.type, new HashMap());
      } else if(!(this.type instanceof GenericArrayType)) {
         throw buildUnexpectedTypeError(this.type, new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
      } else {
         boolean var2;
         if(this.rawType.isAssignableFrom($Gson$Types.getRawType(var1)) && isAssignableFrom(var1, (GenericArrayType)this.type)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }

   public final String toString() {
      return $Gson$Types.typeToString(this.type);
   }
}
