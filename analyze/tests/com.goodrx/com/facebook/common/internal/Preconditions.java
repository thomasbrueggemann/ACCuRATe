package com.facebook.common.internal;

import javax.annotation.Nullable;

public final class Preconditions {
   private static String badElementIndex(int var0, int var1, @Nullable String var2) {
      if(var0 < 0) {
         Object[] var4 = new Object[]{var2, Integer.valueOf(var0)};
         return format("%s (%s) must not be negative", var4);
      } else if(var1 < 0) {
         throw new IllegalArgumentException("negative size: " + var1);
      } else {
         Object[] var3 = new Object[]{var2, Integer.valueOf(var0), Integer.valueOf(var1)};
         return format("%s (%s) must be less than size (%s)", var3);
      }
   }

   private static String badPositionIndex(int var0, int var1, @Nullable String var2) {
      if(var0 < 0) {
         Object[] var4 = new Object[]{var2, Integer.valueOf(var0)};
         return format("%s (%s) must not be negative", var4);
      } else if(var1 < 0) {
         throw new IllegalArgumentException("negative size: " + var1);
      } else {
         Object[] var3 = new Object[]{var2, Integer.valueOf(var0), Integer.valueOf(var1)};
         return format("%s (%s) must not be greater than size (%s)", var3);
      }
   }

   private static String badPositionIndexes(int var0, int var1, int var2) {
      if(var0 >= 0 && var0 <= var2) {
         if(var1 >= 0 && var1 <= var2) {
            Object[] var3 = new Object[]{Integer.valueOf(var1), Integer.valueOf(var0)};
            return format("end index (%s) must not be less than start index (%s)", var3);
         } else {
            return badPositionIndex(var1, var2, "end index");
         }
      } else {
         return badPositionIndex(var0, var2, "start index");
      }
   }

   public static void checkArgument(boolean var0) {
      if(!var0) {
         throw new IllegalArgumentException();
      }
   }

   public static void checkArgument(boolean var0, @Nullable Object var1) {
      if(!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }

   public static void checkArgument(boolean var0, @Nullable String var1, @Nullable Object... var2) {
      if(!var0) {
         throw new IllegalArgumentException(format(var1, var2));
      }
   }

   public static int checkElementIndex(int var0, int var1) {
      return checkElementIndex(var0, var1, "index");
   }

   public static int checkElementIndex(int var0, int var1, @Nullable String var2) {
      if(var0 >= 0 && var0 < var1) {
         return var0;
      } else {
         throw new IndexOutOfBoundsException(badElementIndex(var0, var1, var2));
      }
   }

   public static <T> T checkNotNull(T var0) {
      if(var0 == null) {
         throw new NullPointerException();
      } else {
         return var0;
      }
   }

   public static <T> T checkNotNull(T var0, @Nullable Object var1) {
      if(var0 == null) {
         throw new NullPointerException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   public static <T> T checkNotNull(T var0, @Nullable String var1, @Nullable Object... var2) {
      if(var0 == null) {
         throw new NullPointerException(format(var1, var2));
      } else {
         return var0;
      }
   }

   public static int checkPositionIndex(int var0, int var1) {
      return checkPositionIndex(var0, var1, "index");
   }

   public static int checkPositionIndex(int var0, int var1, @Nullable String var2) {
      if(var0 >= 0 && var0 <= var1) {
         return var0;
      } else {
         throw new IndexOutOfBoundsException(badPositionIndex(var0, var1, var2));
      }
   }

   public static void checkPositionIndexes(int var0, int var1, int var2) {
      if(var0 < 0 || var1 < var0 || var1 > var2) {
         throw new IndexOutOfBoundsException(badPositionIndexes(var0, var1, var2));
      }
   }

   public static void checkState(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   public static void checkState(boolean var0, @Nullable Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   public static void checkState(boolean var0, @Nullable String var1, @Nullable Object... var2) {
      if(!var0) {
         throw new IllegalStateException(format(var1, var2));
      }
   }

   static String format(@Nullable String var0, @Nullable Object... var1) {
      String var2 = String.valueOf(var0);
      StringBuilder var3 = new StringBuilder(var2.length() + 16 * var1.length);
      int var4 = 0;

      int var17;
      int var5;
      for(var5 = 0; var5 < var1.length; var5 = var17) {
         int var15 = var2.indexOf("%s", var4);
         if(var15 == -1) {
            break;
         }

         var3.append(var2.substring(var4, var15));
         var17 = var5 + 1;
         var3.append(var1[var5]);
         var4 = var15 + 2;
      }

      var3.append(var2.substring(var4));
      if(var5 < var1.length) {
         var3.append(" [");
         int var8 = var5 + 1;
         var3.append(var1[var5]);

         int var13;
         for(int var10 = var8; var10 < var1.length; var10 = var13) {
            var3.append(", ");
            var13 = var10 + 1;
            var3.append(var1[var10]);
         }

         var3.append(']');
      }

      return var3.toString();
   }
}
