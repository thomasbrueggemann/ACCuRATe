package android.support.v4.text;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextUtilsCompat;
import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
   public static final TextDirectionHeuristicCompat ANYRTL_LTR;
   public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
   public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
   public static final TextDirectionHeuristicCompat LOCALE;
   public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal((TextDirectionHeuristicsCompat.TextDirectionAlgorithm)null, false);
   public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal((TextDirectionHeuristicsCompat.TextDirectionAlgorithm)null, true);
   private static final int STATE_FALSE = 1;
   private static final int STATE_TRUE = 0;
   private static final int STATE_UNKNOWN = 2;

   static {
      FIRSTSTRONG_LTR = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.FirstStrong.INSTANCE, false);
      FIRSTSTRONG_RTL = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.FirstStrong.INSTANCE, true);
      ANYRTL_LTR = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.AnyStrong.INSTANCE_RTL, false);
      LOCALE = TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale.INSTANCE;
   }

   private static int isRtlText(int var0) {
      switch(var0) {
      case 0:
         return 1;
      case 1:
      case 2:
         return 0;
      default:
         return 2;
      }
   }

   private static int isRtlTextOrFormat(int var0) {
      switch(var0) {
      case 0:
      case 14:
      case 15:
         return 1;
      case 1:
      case 2:
      case 16:
      case 17:
         return 0;
      default:
         return 2;
      }
   }

   private static class AnyStrong implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
      public static final TextDirectionHeuristicsCompat.AnyStrong INSTANCE_LTR = new TextDirectionHeuristicsCompat.AnyStrong(false);
      public static final TextDirectionHeuristicsCompat.AnyStrong INSTANCE_RTL = new TextDirectionHeuristicsCompat.AnyStrong(true);
      private final boolean mLookForRtl;

      private AnyStrong(boolean var1) {
         this.mLookForRtl = var1;
      }

      public int checkRtl(CharSequence var1, int var2, int var3) {
         byte var4 = 1;
         boolean var5 = false;
         int var6 = var2;

         for(int var7 = var2 + var3; var6 < var7; ++var6) {
            switch(TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(var1.charAt(var6)))) {
            case 0:
               if(this.mLookForRtl) {
                  var4 = 0;
                  return var4;
               }

               var5 = true;
               break;
            case 1:
               if(!this.mLookForRtl) {
                  return var4;
               }

               var5 = true;
            }
         }

         if(!var5) {
            return 2;
         } else if(!this.mLookForRtl) {
            return 0;
         } else {
            return var4;
         }
      }
   }

   private static class FirstStrong implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
      public static final TextDirectionHeuristicsCompat.FirstStrong INSTANCE = new TextDirectionHeuristicsCompat.FirstStrong();

      public int checkRtl(CharSequence var1, int var2, int var3) {
         int var4 = 2;
         int var5 = var2;

         for(int var6 = var2 + var3; var5 < var6 && var4 == 2; ++var5) {
            var4 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(var1.charAt(var5)));
         }

         return var4;
      }
   }

   private interface TextDirectionAlgorithm {
      int checkRtl(CharSequence var1, int var2, int var3);
   }

   private abstract static class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
      private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;

      public TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm var1) {
         this.mAlgorithm = var1;
      }

      private boolean doCheck(CharSequence var1, int var2, int var3) {
         switch(this.mAlgorithm.checkRtl(var1, var2, var3)) {
         case 0:
            return true;
         case 1:
            return false;
         default:
            return this.defaultIsRtl();
         }
      }

      protected abstract boolean defaultIsRtl();

      public boolean isRtl(CharSequence var1, int var2, int var3) {
         if(var1 != null && var2 >= 0 && var3 >= 0 && var1.length() - var3 >= var2) {
            return this.mAlgorithm == null?this.defaultIsRtl():this.doCheck(var1, var2, var3);
         } else {
            throw new IllegalArgumentException();
         }
      }

      public boolean isRtl(char[] var1, int var2, int var3) {
         return this.isRtl((CharSequence)CharBuffer.wrap(var1), var2, var3);
      }
   }

   private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
      private final boolean mDefaultIsRtl;

      private TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm var1, boolean var2) {
         super(var1);
         this.mDefaultIsRtl = var2;
      }

      // $FF: synthetic method
      TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm var1, boolean var2, Object var3) {
         this(var1, var2);
      }

      protected boolean defaultIsRtl() {
         return this.mDefaultIsRtl;
      }
   }

   private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
      public static final TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale();

      public TextDirectionHeuristicLocale() {
         super((TextDirectionHeuristicsCompat.TextDirectionAlgorithm)null);
      }

      protected boolean defaultIsRtl() {
         return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
      }
   }
}
