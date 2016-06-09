package android.support.v7.view.menu;

class BaseWrapper<T> {
   final T mWrappedObject;

   BaseWrapper(T var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Wrapped Object can not be null.");
      } else {
         this.mWrappedObject = var1;
      }
   }

   public T getWrappedObject() {
      return this.mWrappedObject;
   }
}
