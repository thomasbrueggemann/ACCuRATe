package com.nostra13.universalimageloader.utils;

import com.nostra13.universalimageloader.core.assist.ImageSize;
import java.util.Comparator;

public final class MemoryCacheUtils {
   public static Comparator<String> createFuzzyKeyComparator() {
      return new Comparator() {
         public int compare(String var1, String var2) {
            return var1.substring(0, var1.lastIndexOf("_")).compareTo(var2.substring(0, var2.lastIndexOf("_")));
         }
      };
   }

   public static String generateKey(String var0, ImageSize var1) {
      return var0 + "_" + var1.getWidth() + "x" + var1.getHeight();
   }
}
