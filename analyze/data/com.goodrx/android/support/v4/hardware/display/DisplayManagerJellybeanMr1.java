package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

final class DisplayManagerJellybeanMr1 {
   public static Display getDisplay(Object var0, int var1) {
      return ((DisplayManager)var0).getDisplay(var1);
   }

   public static Object getDisplayManager(Context var0) {
      return var0.getSystemService("display");
   }

   public static Display[] getDisplays(Object var0) {
      return ((DisplayManager)var0).getDisplays();
   }

   public static Display[] getDisplays(Object var0, String var1) {
      return ((DisplayManager)var0).getDisplays(var1);
   }
}
