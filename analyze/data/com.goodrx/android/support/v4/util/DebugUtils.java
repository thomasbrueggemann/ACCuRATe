package android.support.v4.util;

public class DebugUtils {
   public static void buildShortClassTag(Object var0, StringBuilder var1) {
      if(var0 == null) {
         var1.append("null");
      } else {
         String var2 = var0.getClass().getSimpleName();
         if(var2 == null || var2.length() <= 0) {
            var2 = var0.getClass().getName();
            int var3 = var2.lastIndexOf(46);
            if(var3 > 0) {
               var2 = var2.substring(var3 + 1);
            }
         }

         var1.append(var2);
         var1.append('{');
         var1.append(Integer.toHexString(System.identityHashCode(var0)));
      }
   }
}
