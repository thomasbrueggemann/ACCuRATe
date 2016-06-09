package android.support.v4.view;

import android.graphics.Rect;

public class WindowInsetsCompat {
   public WindowInsetsCompat consumeStableInsets() {
      return this;
   }

   public WindowInsetsCompat consumeSystemWindowInsets() {
      return this;
   }

   public int getStableInsetBottom() {
      return 0;
   }

   public int getStableInsetLeft() {
      return 0;
   }

   public int getStableInsetRight() {
      return 0;
   }

   public int getStableInsetTop() {
      return 0;
   }

   public int getSystemWindowInsetBottom() {
      return 0;
   }

   public int getSystemWindowInsetLeft() {
      return 0;
   }

   public int getSystemWindowInsetRight() {
      return 0;
   }

   public int getSystemWindowInsetTop() {
      return 0;
   }

   public boolean hasInsets() {
      return false;
   }

   public boolean hasStableInsets() {
      return false;
   }

   public boolean hasSystemWindowInsets() {
      return false;
   }

   public boolean isConsumed() {
      return false;
   }

   public boolean isRound() {
      return false;
   }

   public WindowInsetsCompat replaceSystemWindowInsets(int var1, int var2, int var3, int var4) {
      return this;
   }

   public WindowInsetsCompat replaceSystemWindowInsets(Rect var1) {
      return this;
   }
}
