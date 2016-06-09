package android.support.v4.view;

import android.graphics.Rect;
import android.support.v4.view.WindowInsetsCompat;
import android.view.WindowInsets;

class WindowInsetsCompatApi21 extends WindowInsetsCompat {
   private final WindowInsets mSource;

   WindowInsetsCompatApi21(WindowInsets var1) {
      this.mSource = var1;
   }

   public WindowInsetsCompat consumeStableInsets() {
      return new WindowInsetsCompatApi21(this.mSource.consumeStableInsets());
   }

   public WindowInsetsCompat consumeSystemWindowInsets() {
      return new WindowInsetsCompatApi21(this.mSource.consumeSystemWindowInsets());
   }

   public int getStableInsetBottom() {
      return this.mSource.getStableInsetBottom();
   }

   public int getStableInsetLeft() {
      return this.mSource.getStableInsetLeft();
   }

   public int getStableInsetRight() {
      return this.mSource.getStableInsetRight();
   }

   public int getStableInsetTop() {
      return this.mSource.getStableInsetTop();
   }

   public int getSystemWindowInsetBottom() {
      return this.mSource.getSystemWindowInsetBottom();
   }

   public int getSystemWindowInsetLeft() {
      return this.mSource.getSystemWindowInsetLeft();
   }

   public int getSystemWindowInsetRight() {
      return this.mSource.getSystemWindowInsetRight();
   }

   public int getSystemWindowInsetTop() {
      return this.mSource.getSystemWindowInsetTop();
   }

   public boolean hasInsets() {
      return this.mSource.hasInsets();
   }

   public boolean hasStableInsets() {
      return this.mSource.hasStableInsets();
   }

   public boolean hasSystemWindowInsets() {
      return this.mSource.hasSystemWindowInsets();
   }

   public boolean isConsumed() {
      return this.mSource.isConsumed();
   }

   public boolean isRound() {
      return this.mSource.isRound();
   }

   public WindowInsetsCompat replaceSystemWindowInsets(int var1, int var2, int var3, int var4) {
      return new WindowInsetsCompatApi21(this.mSource.replaceSystemWindowInsets(var1, var2, var3, var4));
   }

   public WindowInsetsCompat replaceSystemWindowInsets(Rect var1) {
      return new WindowInsetsCompatApi21(this.mSource.replaceSystemWindowInsets(var1));
   }

   WindowInsets unwrap() {
      return this.mSource;
   }
}
