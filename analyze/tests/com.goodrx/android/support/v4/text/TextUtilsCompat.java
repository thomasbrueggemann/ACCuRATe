package android.support.v4.text;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.text.ICUCompat;
import android.support.v4.text.TextUtilsCompatJellybeanMr1;
import java.util.Locale;

public final class TextUtilsCompat {
   private static String ARAB_SCRIPT_SUBTAG;
   private static String HEBR_SCRIPT_SUBTAG;
   private static final TextUtilsCompat.TextUtilsCompatImpl IMPL;
   public static final Locale ROOT;

   static {
      if(VERSION.SDK_INT >= 17) {
         IMPL = new TextUtilsCompat.TextUtilsCompatJellybeanMr1Impl();
      } else {
         IMPL = new TextUtilsCompat.TextUtilsCompatImpl();
      }

      ROOT = new Locale("", "");
      ARAB_SCRIPT_SUBTAG = "Arab";
      HEBR_SCRIPT_SUBTAG = "Hebr";
   }

   public static int getLayoutDirectionFromLocale(@Nullable Locale var0) {
      return IMPL.getLayoutDirectionFromLocale(var0);
   }

   @NonNull
   public static String htmlEncode(@NonNull String var0) {
      return IMPL.htmlEncode(var0);
   }

   private static class TextUtilsCompatImpl {
      private TextUtilsCompatImpl() {
      }

      // $FF: synthetic method
      TextUtilsCompatImpl(Object var1) {
         this();
      }

      private static int getLayoutDirectionFromFirstChar(@NonNull Locale var0) {
         switch(Character.getDirectionality(var0.getDisplayName(var0).charAt(0))) {
         case 1:
         case 2:
            return 1;
         default:
            return 0;
         }
      }

      public int getLayoutDirectionFromLocale(@Nullable Locale var1) {
         if(var1 != null && !var1.equals(TextUtilsCompat.ROOT)) {
            String var2 = ICUCompat.maximizeAndGetScript(var1);
            if(var2 == null) {
               return getLayoutDirectionFromFirstChar(var1);
            }

            if(var2.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG) || var2.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG)) {
               return 1;
            }
         }

         return 0;
      }

      @NonNull
      public String htmlEncode(@NonNull String var1) {
         StringBuilder var2 = new StringBuilder();

         for(int var3 = 0; var3 < var1.length(); ++var3) {
            char var4 = var1.charAt(var3);
            switch(var4) {
            case '\"':
               var2.append("&quot;");
               break;
            case '&':
               var2.append("&amp;");
               break;
            case '\'':
               var2.append("&#39;");
               break;
            case '<':
               var2.append("&lt;");
               break;
            case '>':
               var2.append("&gt;");
               break;
            default:
               var2.append(var4);
            }
         }

         return var2.toString();
      }
   }

   private static class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompat.TextUtilsCompatImpl {
      private TextUtilsCompatJellybeanMr1Impl() {
         super(null);
      }

      // $FF: synthetic method
      TextUtilsCompatJellybeanMr1Impl(Object var1) {
         this();
      }

      public int getLayoutDirectionFromLocale(@Nullable Locale var1) {
         return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(var1);
      }

      @NonNull
      public String htmlEncode(@NonNull String var1) {
         return TextUtilsCompatJellybeanMr1.htmlEncode(var1);
      }
   }
}
