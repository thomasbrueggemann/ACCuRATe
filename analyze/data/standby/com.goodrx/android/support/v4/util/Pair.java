package android.support.v4.util;

public class Pair<F, S> {
   public final F first;
   public final S second;

   public Pair(F var1, S var2) {
      this.first = var1;
      this.second = var2;
   }

   public static <A, B> Pair<A, B> create(A var0, B var1) {
      return new Pair(var0, var1);
   }

   private static boolean objectsEqual(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Pair) {
         Pair var2 = (Pair)var1;
         if(objectsEqual(var2.first, this.first) && objectsEqual(var2.second, this.second)) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      int var1;
      if(this.first == null) {
         var1 = 0;
      } else {
         var1 = this.first.hashCode();
      }

      Object var2 = this.second;
      int var3 = 0;
      if(var2 != null) {
         var3 = this.second.hashCode();
      }

      return var1 ^ var3;
   }
}
