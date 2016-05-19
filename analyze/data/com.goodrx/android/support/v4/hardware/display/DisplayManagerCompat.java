package android.support.v4.hardware.display;

import android.content.Context;
import android.support.v4.hardware.display.DisplayManagerJellybeanMr1;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat {
   public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
   private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap();

   public static DisplayManagerCompat getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public abstract Display getDisplay(int var1);

   public abstract Display[] getDisplays();

   public abstract Display[] getDisplays(String var1);

   private static class JellybeanMr1Impl extends DisplayManagerCompat {
      private final Object mDisplayManagerObj;

      public JellybeanMr1Impl(Context var1) {
         this.mDisplayManagerObj = DisplayManagerJellybeanMr1.getDisplayManager(var1);
      }

      public Display getDisplay(int var1) {
         return DisplayManagerJellybeanMr1.getDisplay(this.mDisplayManagerObj, var1);
      }

      public Display[] getDisplays() {
         return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj);
      }

      public Display[] getDisplays(String var1) {
         return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj, var1);
      }
   }

   private static class LegacyImpl extends DisplayManagerCompat {
      private final WindowManager mWindowManager;

      public LegacyImpl(Context var1) {
         this.mWindowManager = (WindowManager)var1.getSystemService("window");
      }

      public Display getDisplay(int var1) {
         Display var2 = this.mWindowManager.getDefaultDisplay();
         return var2.getDisplayId() == var1?var2:null;
      }

      public Display[] getDisplays() {
         Display[] var1 = new Display[]{this.mWindowManager.getDefaultDisplay()};
         return var1;
      }

      public Display[] getDisplays(String var1) {
         return var1 == null?this.getDisplays():new Display[0];
      }
   }
}
