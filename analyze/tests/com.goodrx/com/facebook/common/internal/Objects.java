package com.facebook.common.internal;

import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class Objects {
   @CheckReturnValue
   public static boolean equal(@Nullable Object var0, @Nullable Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static <T> T firstNonNull(@Nullable T var0, @Nullable T var1) {
      return var0 != null?var0:Preconditions.checkNotNull(var1);
   }

   public static int hashCode(@Nullable Object... var0) {
      return Arrays.hashCode(var0);
   }

   private static String simpleName(Class<?> var0) {
      String var1 = var0.getName().replaceAll("\\$[0-9]+", "\\$");
      int var2 = var1.lastIndexOf(36);
      if(var2 == -1) {
         var2 = var1.lastIndexOf(46);
      }

      return var1.substring(var2 + 1);
   }

   public static Objects.ToStringHelper toStringHelper(Class<?> var0) {
      return new Objects.ToStringHelper(simpleName(var0));
   }

   public static Objects.ToStringHelper toStringHelper(Object var0) {
      return new Objects.ToStringHelper(simpleName(var0.getClass()));
   }

   public static Objects.ToStringHelper toStringHelper(String var0) {
      return new Objects.ToStringHelper(var0);
   }

   public static final class ToStringHelper {
      private final String className;
      private Objects.ValueHolder holderHead;
      private Objects.ValueHolder holderTail;
      private boolean omitNullValues;

      private ToStringHelper(String var1) {
         this.holderHead = new Objects.ValueHolder();
         this.holderTail = this.holderHead;
         this.omitNullValues = false;
         this.className = (String)Preconditions.checkNotNull(var1);
      }

      // $FF: synthetic method
      ToStringHelper(String var1, Object var2) {
         this(var1);
      }

      private Objects.ValueHolder addHolder() {
         Objects.ValueHolder var1 = new Objects.ValueHolder();
         this.holderTail.next = var1;
         this.holderTail = var1;
         return var1;
      }

      private Objects.ToStringHelper addHolder(@Nullable Object var1) {
         this.addHolder().value = var1;
         return this;
      }

      private Objects.ToStringHelper addHolder(String var1, @Nullable Object var2) {
         Objects.ValueHolder var3 = this.addHolder();
         var3.value = var2;
         var3.name = (String)Preconditions.checkNotNull(var1);
         return this;
      }

      public Objects.ToStringHelper add(String var1, char var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, double var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, float var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, int var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, long var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, @Nullable Object var2) {
         return this.addHolder(var1, var2);
      }

      public Objects.ToStringHelper add(String var1, boolean var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper addValue(char var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(double var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(float var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(int var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(long var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(@Nullable Object var1) {
         return this.addHolder(var1);
      }

      public Objects.ToStringHelper addValue(boolean var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper omitNullValues() {
         this.omitNullValues = true;
         return this;
      }

      public String toString() {
         boolean var1 = this.omitNullValues;
         String var2 = "";
         StringBuilder var3 = (new StringBuilder(32)).append(this.className).append('{');

         for(Objects.ValueHolder var4 = this.holderHead.next; var4 != null; var4 = var4.next) {
            if(!var1 || var4.value != null) {
               var3.append(var2);
               var2 = ", ";
               if(var4.name != null) {
                  var3.append(var4.name).append('=');
               }

               var3.append(var4.value);
            }
         }

         return var3.append('}').toString();
      }
   }

   private static final class ValueHolder {
      String name;
      Objects.ValueHolder next;
      Object value;

      private ValueHolder() {
      }

      // $FF: synthetic method
      ValueHolder(Object var1) {
         this();
      }
   }
}
