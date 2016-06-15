package android.support.v4.view;

import android.view.KeyEvent;

class KeyEventCompatHoneycomb {
   public static boolean metaStateHasModifiers(int var0, int var1) {
      return KeyEvent.metaStateHasModifiers(var0, var1);
   }

   public static boolean metaStateHasNoModifiers(int var0) {
      return KeyEvent.metaStateHasNoModifiers(var0);
   }

   public static int normalizeMetaState(int var0) {
      return KeyEvent.normalizeMetaState(var0);
   }
}
