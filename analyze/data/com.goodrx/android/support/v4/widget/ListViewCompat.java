package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.widget.ListViewCompatDonut;
import android.support.v4.widget.ListViewCompatKitKat;
import android.widget.ListView;

public final class ListViewCompat {
   public static void scrollListBy(@NonNull ListView var0, int var1) {
      if(VERSION.SDK_INT >= 19) {
         ListViewCompatKitKat.scrollListBy(var0, var1);
      } else {
         ListViewCompatDonut.scrollListBy(var0, var1);
      }
   }
}
