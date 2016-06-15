package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.content.IntentCompatHoneycomb;
import android.support.v4.content.IntentCompatIcsMr1;

public class IntentCompat {
   public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
   public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
   public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
   public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
   public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
   public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
   public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
   private static final IntentCompat.IntentCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 15) {
         IMPL = new IntentCompat.IntentCompatImplIcsMr1();
      } else if(var0 >= 11) {
         IMPL = new IntentCompat.IntentCompatImplHC();
      } else {
         IMPL = new IntentCompat.IntentCompatImplBase();
      }
   }

   public static Intent makeMainActivity(ComponentName var0) {
      return IMPL.makeMainActivity(var0);
   }

   public static Intent makeMainSelectorActivity(String var0, String var1) {
      return IMPL.makeMainSelectorActivity(var0, var1);
   }

   public static Intent makeRestartActivityTask(ComponentName var0) {
      return IMPL.makeRestartActivityTask(var0);
   }

   interface IntentCompatImpl {
      Intent makeMainActivity(ComponentName var1);

      Intent makeMainSelectorActivity(String var1, String var2);

      Intent makeRestartActivityTask(ComponentName var1);
   }

   static class IntentCompatImplBase implements IntentCompat.IntentCompatImpl {
      public Intent makeMainActivity(ComponentName var1) {
         Intent var2 = new Intent("android.intent.action.MAIN");
         var2.setComponent(var1);
         var2.addCategory("android.intent.category.LAUNCHER");
         return var2;
      }

      public Intent makeMainSelectorActivity(String var1, String var2) {
         Intent var3 = new Intent(var1);
         var3.addCategory(var2);
         return var3;
      }

      public Intent makeRestartActivityTask(ComponentName var1) {
         Intent var2 = this.makeMainActivity(var1);
         var2.addFlags(268468224);
         return var2;
      }
   }

   static class IntentCompatImplHC extends IntentCompat.IntentCompatImplBase {
      public Intent makeMainActivity(ComponentName var1) {
         return IntentCompatHoneycomb.makeMainActivity(var1);
      }

      public Intent makeRestartActivityTask(ComponentName var1) {
         return IntentCompatHoneycomb.makeRestartActivityTask(var1);
      }
   }

   static class IntentCompatImplIcsMr1 extends IntentCompat.IntentCompatImplHC {
      public Intent makeMainSelectorActivity(String var1, String var2) {
         return IntentCompatIcsMr1.makeMainSelectorActivity(var1, var2);
      }
   }
}
