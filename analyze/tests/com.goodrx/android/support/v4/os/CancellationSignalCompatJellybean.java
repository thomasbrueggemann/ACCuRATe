package android.support.v4.os;

class CancellationSignalCompatJellybean {
   public static void cancel(Object var0) {
      ((android.os.CancellationSignal)var0).cancel();
   }

   public static Object create() {
      return new android.os.CancellationSignal();
   }
}
