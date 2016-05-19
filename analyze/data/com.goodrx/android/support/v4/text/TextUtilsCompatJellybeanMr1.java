package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Locale;

class TextUtilsCompatJellybeanMr1 {
   public static int getLayoutDirectionFromLocale(@Nullable Locale var0) {
      return TextUtils.getLayoutDirectionFromLocale(var0);
   }

   @NonNull
   public static String htmlEncode(@NonNull String var0) {
      return TextUtils.htmlEncode(var0);
   }
}
