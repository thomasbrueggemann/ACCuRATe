package bolts;

public class Capture<T> {
   private T value;

   public Capture() {
   }

   public Capture(T var1) {
      this.value = var1;
   }

   public T get() {
      return this.value;
   }

   public void set(T var1) {
      this.value = var1;
   }
}
