package com.newrelic.com.google.gson.internal;

import com.newrelic.com.google.gson.InstanceCreator;
import com.newrelic.com.google.gson.JsonIOException;
import com.newrelic.com.google.gson.internal.LinkedTreeMap;
import com.newrelic.com.google.gson.internal.ObjectConstructor;
import com.newrelic.com.google.gson.internal.UnsafeAllocator;
import com.newrelic.com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class ConstructorConstructor {
   private final Map<Type, InstanceCreator<?>> instanceCreators;

   public ConstructorConstructor(Map<Type, InstanceCreator<?>> var1) {
      this.instanceCreators = var1;
   }

   private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> var1) {
      try {
         final Constructor var3 = var1.getDeclaredConstructor(new Class[0]);
         if(!var3.isAccessible()) {
            var3.setAccessible(true);
         }

         ObjectConstructor var4 = new ObjectConstructor() {
            public T construct() {
               try {
                  Object var4 = var3.newInstance((Object[])null);
                  return var4;
               } catch (InstantiationException var5) {
                  throw new RuntimeException("Failed to invoke " + var3 + " with no args", var5);
               } catch (InvocationTargetException var6) {
                  throw new RuntimeException("Failed to invoke " + var3 + " with no args", var6.getTargetException());
               } catch (IllegalAccessException var7) {
                  throw new AssertionError(var7);
               }
            }
         };
         return var4;
      } catch (NoSuchMethodException var5) {
         return null;
      }
   }

   private <T> ObjectConstructor<T> newDefaultImplementationConstructor(final Type var1, Class<? super T> var2) {
      return Collection.class.isAssignableFrom(var2)?(SortedSet.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public T construct() {
            return new TreeSet();
         }
      }:(EnumSet.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public T construct() {
            if(var1 instanceof ParameterizedType) {
               Type var1x = ((ParameterizedType)var1).getActualTypeArguments()[0];
               if(var1x instanceof Class) {
                  return EnumSet.noneOf((Class)var1x);
               } else {
                  throw new JsonIOException("Invalid EnumSet type: " + var1.toString());
               }
            } else {
               throw new JsonIOException("Invalid EnumSet type: " + var1.toString());
            }
         }
      }:(Set.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public T construct() {
            return new LinkedHashSet();
         }
      }:(Queue.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public T construct() {
            return new LinkedList();
         }
      }:new ObjectConstructor() {
         public T construct() {
            return new ArrayList();
         }
      })))):(Map.class.isAssignableFrom(var2)?(SortedMap.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public T construct() {
            return new TreeMap();
         }
      }:(var1 instanceof ParameterizedType && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType)var1).getActualTypeArguments()[0]).getRawType())?new ObjectConstructor() {
         public T construct() {
            return new LinkedHashMap();
         }
      }:new ObjectConstructor() {
         public T construct() {
            return new LinkedTreeMap();
         }
      })):null);
   }

   private <T> ObjectConstructor<T> newUnsafeAllocator(final Type var1, final Class<? super T> var2) {
      return new ObjectConstructor() {
         private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();

         public T construct() {
            try {
               Object var2x = this.unsafeAllocator.newInstance(var2);
               return var2x;
            } catch (Exception var3) {
               throw new RuntimeException("Unable to invoke no-args constructor for " + var1 + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", var3);
            }
         }
      };
   }

   public <T> ObjectConstructor<T> get(TypeToken<T> var1) {
      final Type var2 = var1.getType();
      Class var3 = var1.getRawType();
      final InstanceCreator var4 = (InstanceCreator)this.instanceCreators.get(var2);
      ObjectConstructor var5;
      if(var4 != null) {
         var5 = new ObjectConstructor() {
            public T construct() {
               return var4.createInstance(var2);
            }
         };
      } else {
         final InstanceCreator var6 = (InstanceCreator)this.instanceCreators.get(var3);
         if(var6 != null) {
            return new ObjectConstructor() {
               public T construct() {
                  return var6.createInstance(var2);
               }
            };
         }

         var5 = this.newDefaultConstructor(var3);
         if(var5 == null) {
            ObjectConstructor var7 = this.newDefaultImplementationConstructor(var2, var3);
            if(var7 != null) {
               return var7;
            }

            return this.newUnsafeAllocator(var2, var3);
         }
      }

      return var5;
   }

   public String toString() {
      return this.instanceCreators.toString();
   }
}
