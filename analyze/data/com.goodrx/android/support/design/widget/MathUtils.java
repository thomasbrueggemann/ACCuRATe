package android.support.design.widget;

class MathUtils {
   static float constrain(float var0, float var1, float var2) {
      return var0 < var1?var1:(var0 > var2?var2:var0);
   }

   static int constrain(int var0, int var1, int var2) {
      return var0 < var1?var1:(var0 > var2?var2:var0);
   }
}
