package com.google.gson.internal;

import com.google.gson.internal.$Gson$Preconditions;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class $Gson$Types {
   static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

   public static GenericArrayType arrayOf(Type var0) {
      return new $Gson$Types.GenericArrayTypeImpl(var0);
   }

   public static Type canonicalize(Type var0) {
      if(var0 instanceof Class) {
         Class var3 = (Class)var0;
         Object var4;
         if(var3.isArray()) {
            var4 = new $Gson$Types.GenericArrayTypeImpl(canonicalize(var3.getComponentType()));
         } else {
            var4 = var3;
         }

         return (Type)var4;
      } else if(var0 instanceof ParameterizedType) {
         ParameterizedType var2 = (ParameterizedType)var0;
         return new $Gson$Types.ParameterizedTypeImpl(var2.getOwnerType(), var2.getRawType(), var2.getActualTypeArguments());
      } else if(var0 instanceof GenericArrayType) {
         return new $Gson$Types.GenericArrayTypeImpl(((GenericArrayType)var0).getGenericComponentType());
      } else if(var0 instanceof WildcardType) {
         WildcardType var1 = (WildcardType)var0;
         return new $Gson$Types.WildcardTypeImpl(var1.getUpperBounds(), var1.getLowerBounds());
      } else {
         return var0;
      }
   }

   static void checkNotPrimitive(Type var0) {
      boolean var1;
      if(var0 instanceof Class && ((Class)var0).isPrimitive()) {
         var1 = false;
      } else {
         var1 = true;
      }

      $Gson$Preconditions.checkArgument(var1);
   }

   private static Class<?> declaringClassOf(TypeVariable<?> var0) {
      GenericDeclaration var1 = var0.getGenericDeclaration();
      return var1 instanceof Class?(Class)var1:null;
   }

   static boolean equal(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static boolean equals(Type var0, Type var1) {
      boolean var2 = true;
      boolean var4;
      if(var0 == var1) {
         var4 = var2;
      } else {
         if(var0 instanceof Class) {
            return var0.equals(var1);
         }

         if(var0 instanceof ParameterizedType) {
            boolean var14 = var1 instanceof ParameterizedType;
            var4 = false;
            if(var14) {
               ParameterizedType var15 = (ParameterizedType)var0;
               ParameterizedType var16 = (ParameterizedType)var1;
               if(!equal(var15.getOwnerType(), var16.getOwnerType()) || !var15.getRawType().equals(var16.getRawType()) || !Arrays.equals(var15.getActualTypeArguments(), var16.getActualTypeArguments())) {
                  var2 = false;
               }

               return var2;
            }
         } else if(var0 instanceof GenericArrayType) {
            boolean var11 = var1 instanceof GenericArrayType;
            var4 = false;
            if(var11) {
               GenericArrayType var12 = (GenericArrayType)var0;
               GenericArrayType var13 = (GenericArrayType)var1;
               return equals(var12.getGenericComponentType(), var13.getGenericComponentType());
            }
         } else if(var0 instanceof WildcardType) {
            boolean var8 = var1 instanceof WildcardType;
            var4 = false;
            if(var8) {
               WildcardType var9 = (WildcardType)var0;
               WildcardType var10 = (WildcardType)var1;
               if(!Arrays.equals(var9.getUpperBounds(), var10.getUpperBounds()) || !Arrays.equals(var9.getLowerBounds(), var10.getLowerBounds())) {
                  var2 = false;
               }

               return var2;
            }
         } else {
            boolean var3 = var0 instanceof TypeVariable;
            var4 = false;
            if(var3) {
               boolean var5 = var1 instanceof TypeVariable;
               var4 = false;
               if(var5) {
                  TypeVariable var6 = (TypeVariable)var0;
                  TypeVariable var7 = (TypeVariable)var1;
                  if(var6.getGenericDeclaration() != var7.getGenericDeclaration() || !var6.getName().equals(var7.getName())) {
                     var2 = false;
                  }

                  return var2;
               }
            }
         }
      }

      return var4;
   }

   public static Type getArrayComponentType(Type var0) {
      return (Type)(var0 instanceof GenericArrayType?((GenericArrayType)var0).getGenericComponentType():((Class)var0).getComponentType());
   }

   public static Type getCollectionElementType(Type var0, Class<?> var1) {
      Type var2 = getSupertype(var0, var1, Collection.class);
      if(var2 instanceof WildcardType) {
         var2 = ((WildcardType)var2).getUpperBounds()[0];
      }

      return (Type)(var2 instanceof ParameterizedType?((ParameterizedType)var2).getActualTypeArguments()[0]:Object.class);
   }

   static Type getGenericSupertype(Type var0, Class<?> var1, Class<?> var2) {
      if(var2 == var1) {
         return var0;
      } else {
         if(var2.isInterface()) {
            Class[] var4 = var1.getInterfaces();
            int var5 = 0;

            for(int var6 = var4.length; var5 < var6; ++var5) {
               if(var4[var5] == var2) {
                  return var1.getGenericInterfaces()[var5];
               }

               if(var2.isAssignableFrom(var4[var5])) {
                  return getGenericSupertype(var1.getGenericInterfaces()[var5], var4[var5], var2);
               }
            }
         }

         if(!var1.isInterface()) {
            while(var1 != Object.class) {
               Class var3 = var1.getSuperclass();
               if(var3 == var2) {
                  return var1.getGenericSuperclass();
               }

               if(var2.isAssignableFrom(var3)) {
                  return getGenericSupertype(var1.getGenericSuperclass(), var3, var2);
               }

               var1 = var3;
            }
         }

         return var2;
      }
   }

   public static Type[] getMapKeyAndValueTypes(Type var0, Class<?> var1) {
      if(var0 == Properties.class) {
         return new Type[]{String.class, String.class};
      } else {
         Type var2 = getSupertype(var0, var1, Map.class);
         return var2 instanceof ParameterizedType?((ParameterizedType)var2).getActualTypeArguments():new Type[]{Object.class, Object.class};
      }
   }

   public static Class<?> getRawType(Type var0) {
      if(var0 instanceof Class) {
         return (Class)var0;
      } else if(var0 instanceof ParameterizedType) {
         Type var2 = ((ParameterizedType)var0).getRawType();
         $Gson$Preconditions.checkArgument(var2 instanceof Class);
         return (Class)var2;
      } else if(var0 instanceof GenericArrayType) {
         return Array.newInstance(getRawType(((GenericArrayType)var0).getGenericComponentType()), 0).getClass();
      } else if(var0 instanceof TypeVariable) {
         return Object.class;
      } else if(var0 instanceof WildcardType) {
         return getRawType(((WildcardType)var0).getUpperBounds()[0]);
      } else {
         String var1;
         if(var0 == null) {
            var1 = "null";
         } else {
            var1 = var0.getClass().getName();
         }

         throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + var0 + "> is of type " + var1);
      }
   }

   static Type getSupertype(Type var0, Class<?> var1, Class<?> var2) {
      $Gson$Preconditions.checkArgument(var2.isAssignableFrom(var1));
      return resolve(var0, var1, getGenericSupertype(var0, var1, var2));
   }

   static int hashCodeOrZero(Object var0) {
      return var0 != null?var0.hashCode():0;
   }

   private static int indexOf(Object[] var0, Object var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         if(var1.equals(var0[var2])) {
            return var2;
         }
      }

      throw new NoSuchElementException();
   }

   public static ParameterizedType newParameterizedTypeWithOwner(Type var0, Type var1, Type... var2) {
      return new $Gson$Types.ParameterizedTypeImpl(var0, var1, var2);
   }

   public static Type resolve(Type var0, Class<?> var1, Type var2) {
      while(true) {
         Object var3;
         if(var2 instanceof TypeVariable) {
            TypeVariable var20 = (TypeVariable)var2;
            var2 = resolveTypeVariable(var0, var1, var20);
            if(var2 != var20) {
               continue;
            }

            var3 = var2;
         } else {
            if(var2 instanceof Class && ((Class)var2).isArray()) {
               Object var17 = (Class)var2;
               Class var18 = ((Class)var17).getComponentType();
               Type var19 = resolve(var0, var1, var18);
               if(var18 != var19) {
                  var17 = arrayOf(var19);
               }

               return (Type)var17;
            }

            if(var2 instanceof GenericArrayType) {
               var3 = (GenericArrayType)var2;
               Type var15 = ((GenericArrayType)var3).getGenericComponentType();
               Type var16 = resolve(var0, var1, var15);
               if(var15 != var16) {
                  return arrayOf(var16);
               }
            } else if(var2 instanceof ParameterizedType) {
               var3 = (ParameterizedType)var2;
               Type var8 = ((ParameterizedType)var3).getOwnerType();
               Type var9 = resolve(var0, var1, var8);
               boolean var10;
               if(var9 != var8) {
                  var10 = true;
               } else {
                  var10 = false;
               }

               Type[] var11 = ((ParameterizedType)var3).getActualTypeArguments();
               int var12 = 0;

               for(int var13 = var11.length; var12 < var13; ++var12) {
                  Type var14 = resolve(var0, var1, var11[var12]);
                  if(var14 != var11[var12]) {
                     if(!var10) {
                        var11 = (Type[])var11.clone();
                        var10 = true;
                     }

                     var11[var12] = var14;
                  }
               }

               if(var10) {
                  return newParameterizedTypeWithOwner(var9, ((ParameterizedType)var3).getRawType(), var11);
               }
            } else {
               if(!(var2 instanceof WildcardType)) {
                  return var2;
               }

               var3 = (WildcardType)var2;
               Type[] var4 = ((WildcardType)var3).getLowerBounds();
               Type[] var5 = ((WildcardType)var3).getUpperBounds();
               if(var4.length == 1) {
                  Type var7 = resolve(var0, var1, var4[0]);
                  if(var7 != var4[0]) {
                     return supertypeOf(var7);
                  }
               } else if(var5.length == 1) {
                  Type var6 = resolve(var0, var1, var5[0]);
                  if(var6 != var5[0]) {
                     return subtypeOf(var6);
                  }
               }
            }
         }

         return (Type)var3;
      }
   }

   static Type resolveTypeVariable(Type var0, Class<?> var1, TypeVariable<?> var2) {
      Class var3 = declaringClassOf(var2);
      if(var3 != null) {
         Type var4 = getGenericSupertype(var0, var1, var3);
         if(var4 instanceof ParameterizedType) {
            int var5 = indexOf(var3.getTypeParameters(), var2);
            return ((ParameterizedType)var4).getActualTypeArguments()[var5];
         }
      }

      return var2;
   }

   public static WildcardType subtypeOf(Type var0) {
      return new $Gson$Types.WildcardTypeImpl(new Type[]{var0}, EMPTY_TYPE_ARRAY);
   }

   public static WildcardType supertypeOf(Type var0) {
      return new $Gson$Types.WildcardTypeImpl(new Type[]{Object.class}, new Type[]{var0});
   }

   public static String typeToString(Type var0) {
      return var0 instanceof Class?((Class)var0).getName():var0.toString();
   }

   private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
      private final Type componentType;

      public GenericArrayTypeImpl(Type var1) {
         this.componentType = $Gson$Types.canonicalize(var1);
      }

      public boolean equals(Object var1) {
         return var1 instanceof GenericArrayType && $Gson$Types.equals(this, (GenericArrayType)var1);
      }

      public Type getGenericComponentType() {
         return this.componentType;
      }

      public int hashCode() {
         return this.componentType.hashCode();
      }

      public String toString() {
         return $Gson$Types.typeToString(this.componentType) + "[]";
      }
   }

   private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
      private final Type ownerType;
      private final Type rawType;
      private final Type[] typeArguments;

      public ParameterizedTypeImpl(Type var1, Type var2, Type... var3) {
         if(var2 instanceof Class) {
            Class var7 = (Class)var2;
            boolean var8;
            if(!Modifier.isStatic(var7.getModifiers()) && var7.getEnclosingClass() != null) {
               var8 = false;
            } else {
               var8 = true;
            }

            boolean var9;
            label31: {
               if(var1 == null) {
                  var9 = false;
                  if(!var8) {
                     break label31;
                  }
               }

               var9 = true;
            }

            $Gson$Preconditions.checkArgument(var9);
         }

         Type var4;
         if(var1 == null) {
            var4 = null;
         } else {
            var4 = $Gson$Types.canonicalize(var1);
         }

         this.ownerType = var4;
         this.rawType = $Gson$Types.canonicalize(var2);
         this.typeArguments = (Type[])var3.clone();

         for(int var5 = 0; var5 < this.typeArguments.length; ++var5) {
            $Gson$Preconditions.checkNotNull(this.typeArguments[var5]);
            $Gson$Types.checkNotPrimitive(this.typeArguments[var5]);
            this.typeArguments[var5] = $Gson$Types.canonicalize(this.typeArguments[var5]);
         }

      }

      public boolean equals(Object var1) {
         return var1 instanceof ParameterizedType && $Gson$Types.equals(this, (ParameterizedType)var1);
      }

      public Type[] getActualTypeArguments() {
         return (Type[])this.typeArguments.clone();
      }

      public Type getOwnerType() {
         return this.ownerType;
      }

      public Type getRawType() {
         return this.rawType;
      }

      public int hashCode() {
         return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ $Gson$Types.hashCodeOrZero(this.ownerType);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder(30 * (1 + this.typeArguments.length));
         var1.append($Gson$Types.typeToString(this.rawType));
         if(this.typeArguments.length == 0) {
            return var1.toString();
         } else {
            var1.append("<").append($Gson$Types.typeToString(this.typeArguments[0]));

            for(int var4 = 1; var4 < this.typeArguments.length; ++var4) {
               var1.append(", ").append($Gson$Types.typeToString(this.typeArguments[var4]));
            }

            return var1.append(">").toString();
         }
      }
   }

   private static final class WildcardTypeImpl implements Serializable, WildcardType {
      private final Type lowerBound;
      private final Type upperBound;

      public WildcardTypeImpl(Type[] var1, Type[] var2) {
         byte var3 = 1;
         super();
         byte var4;
         if(var2.length <= var3) {
            var4 = var3;
         } else {
            var4 = 0;
         }

         $Gson$Preconditions.checkArgument((boolean)var4);
         byte var5;
         if(var1.length == var3) {
            var5 = var3;
         } else {
            var5 = 0;
         }

         $Gson$Preconditions.checkArgument((boolean)var5);
         if(var2.length == var3) {
            $Gson$Preconditions.checkNotNull(var2[0]);
            $Gson$Types.checkNotPrimitive(var2[0]);
            if(var1[0] != Object.class) {
               var3 = 0;
            }

            $Gson$Preconditions.checkArgument((boolean)var3);
            this.lowerBound = $Gson$Types.canonicalize(var2[0]);
            this.upperBound = Object.class;
         } else {
            $Gson$Preconditions.checkNotNull(var1[0]);
            $Gson$Types.checkNotPrimitive(var1[0]);
            this.lowerBound = null;
            this.upperBound = $Gson$Types.canonicalize(var1[0]);
         }
      }

      public boolean equals(Object var1) {
         return var1 instanceof WildcardType && $Gson$Types.equals(this, (WildcardType)var1);
      }

      public Type[] getLowerBounds() {
         if(this.lowerBound != null) {
            Type[] var1 = new Type[]{this.lowerBound};
            return var1;
         } else {
            return $Gson$Types.EMPTY_TYPE_ARRAY;
         }
      }

      public Type[] getUpperBounds() {
         Type[] var1 = new Type[]{this.upperBound};
         return var1;
      }

      public int hashCode() {
         int var1;
         if(this.lowerBound != null) {
            var1 = 31 + this.lowerBound.hashCode();
         } else {
            var1 = 1;
         }

         return var1 ^ 31 + this.upperBound.hashCode();
      }

      public String toString() {
         return this.lowerBound != null?"? super " + $Gson$Types.typeToString(this.lowerBound):(this.upperBound == Object.class?"?":"? extends " + $Gson$Types.typeToString(this.upperBound));
      }
   }
}
