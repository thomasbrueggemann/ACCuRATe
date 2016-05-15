package android.support.v4.text;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.text.TextUtilsCompat;
import java.util.Locale;

public final class BidiFormatter {
   private static final int DEFAULT_FLAGS = 2;
   private static final BidiFormatter DEFAULT_LTR_INSTANCE;
   private static final BidiFormatter DEFAULT_RTL_INSTANCE;
   private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
   private static final int DIR_LTR = -1;
   private static final int DIR_RTL = 1;
   private static final int DIR_UNKNOWN = 0;
   private static final String EMPTY_STRING = "";
   private static final int FLAG_STEREO_RESET = 2;
   private static final char LRE = '\u202a';
   private static final char LRM = '\u200e';
   private static final String LRM_STRING;
   private static final char PDF = '\u202c';
   private static final char RLE = '\u202b';
   private static final char RLM = '\u200f';
   private static final String RLM_STRING;
   private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
   private final int mFlags;
   private final boolean mIsRtlContext;

   static {
      DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
      LRM_STRING = Character.toString('\u200e');
      RLM_STRING = Character.toString('\u200f');
      DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
      DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
   }

   private BidiFormatter(boolean var1, int var2, TextDirectionHeuristicCompat var3) {
      this.mIsRtlContext = var1;
      this.mFlags = var2;
      this.mDefaultTextDirectionHeuristicCompat = var3;
   }

   // $FF: synthetic method
   BidiFormatter(boolean var1, int var2, TextDirectionHeuristicCompat var3, Object var4) {
      this(var1, var2, var3);
   }

   private static int getEntryDir(String var0) {
      return (new BidiFormatter.DirectionalityEstimator(var0, false)).getEntryDir();
   }

   private static int getExitDir(String var0) {
      return (new BidiFormatter.DirectionalityEstimator(var0, false)).getExitDir();
   }

   public static BidiFormatter getInstance() {
      return (new BidiFormatter.Builder()).build();
   }

   public static BidiFormatter getInstance(Locale var0) {
      return (new BidiFormatter.Builder(var0)).build();
   }

   public static BidiFormatter getInstance(boolean var0) {
      return (new BidiFormatter.Builder(var0)).build();
   }

   private static boolean isRtlLocale(Locale var0) {
      return TextUtilsCompat.getLayoutDirectionFromLocale(var0) == 1;
   }

   private String markAfter(String var1, TextDirectionHeuristicCompat var2) {
      boolean var3 = var2.isRtl((CharSequence)var1, 0, var1.length());
      return this.mIsRtlContext || !var3 && getExitDir(var1) != 1?(!this.mIsRtlContext || var3 && getExitDir(var1) != -1?"":RLM_STRING):LRM_STRING;
   }

   private String markBefore(String var1, TextDirectionHeuristicCompat var2) {
      boolean var3 = var2.isRtl((CharSequence)var1, 0, var1.length());
      return this.mIsRtlContext || !var3 && getEntryDir(var1) != 1?(!this.mIsRtlContext || var3 && getEntryDir(var1) != -1?"":RLM_STRING):LRM_STRING;
   }

   public boolean getStereoReset() {
      return (2 & this.mFlags) != 0;
   }

   public boolean isRtl(String var1) {
      return this.mDefaultTextDirectionHeuristicCompat.isRtl((CharSequence)var1, 0, var1.length());
   }

   public boolean isRtlContext() {
      return this.mIsRtlContext;
   }

   public String unicodeWrap(String var1) {
      return this.unicodeWrap(var1, this.mDefaultTextDirectionHeuristicCompat, true);
   }

   public String unicodeWrap(String var1, TextDirectionHeuristicCompat var2) {
      return this.unicodeWrap(var1, var2, true);
   }

   public String unicodeWrap(String var1, TextDirectionHeuristicCompat var2, boolean var3) {
      if(var1 == null) {
         return null;
      } else {
         boolean var4 = var2.isRtl((CharSequence)var1, 0, var1.length());
         StringBuilder var5 = new StringBuilder();
         if(this.getStereoReset() && var3) {
            TextDirectionHeuristicCompat var13;
            if(var4) {
               var13 = TextDirectionHeuristicsCompat.RTL;
            } else {
               var13 = TextDirectionHeuristicsCompat.LTR;
            }

            var5.append(this.markBefore(var1, var13));
         }

         if(var4 != this.mIsRtlContext) {
            char var9;
            if(var4) {
               var9 = 8235;
            } else {
               var9 = 8234;
            }

            var5.append(var9);
            var5.append(var1);
            var5.append('\u202c');
         } else {
            var5.append(var1);
         }

         if(var3) {
            TextDirectionHeuristicCompat var7;
            if(var4) {
               var7 = TextDirectionHeuristicsCompat.RTL;
            } else {
               var7 = TextDirectionHeuristicsCompat.LTR;
            }

            var5.append(this.markAfter(var1, var7));
         }

         return var5.toString();
      }
   }

   public String unicodeWrap(String var1, boolean var2) {
      return this.unicodeWrap(var1, this.mDefaultTextDirectionHeuristicCompat, var2);
   }

   public static final class Builder {
      private int mFlags;
      private boolean mIsRtlContext;
      private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

      public Builder() {
         this.initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
      }

      public Builder(Locale var1) {
         this.initialize(BidiFormatter.isRtlLocale(var1));
      }

      public Builder(boolean var1) {
         this.initialize(var1);
      }

      private static BidiFormatter getDefaultInstanceFromContext(boolean var0) {
         return var0?BidiFormatter.DEFAULT_RTL_INSTANCE:BidiFormatter.DEFAULT_LTR_INSTANCE;
      }

      private void initialize(boolean var1) {
         this.mIsRtlContext = var1;
         this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
         this.mFlags = 2;
      }

      public BidiFormatter build() {
         return this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC?getDefaultInstanceFromContext(this.mIsRtlContext):new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
      }

      public BidiFormatter.Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat var1) {
         this.mTextDirectionHeuristicCompat = var1;
         return this;
      }

      public BidiFormatter.Builder stereoReset(boolean var1) {
         if(var1) {
            this.mFlags |= 2;
            return this;
         } else {
            this.mFlags &= -3;
            return this;
         }
      }
   }

   private static class DirectionalityEstimator {
      private static final byte[] DIR_TYPE_CACHE = new byte[1792];
      private static final int DIR_TYPE_CACHE_SIZE = 1792;
      private int charIndex;
      private final boolean isHtml;
      private char lastChar;
      private final int length;
      private final String text;

      static {
         for(int var0 = 0; var0 < 1792; ++var0) {
            DIR_TYPE_CACHE[var0] = Character.getDirectionality(var0);
         }

      }

      DirectionalityEstimator(String var1, boolean var2) {
         this.text = var1;
         this.isHtml = var2;
         this.length = var1.length();
      }

      private static byte getCachedDirectionality(char var0) {
         return var0 < 1792?DIR_TYPE_CACHE[var0]:Character.getDirectionality(var0);
      }

      private byte skipEntityBackward() {
         int var1 = this.charIndex;

         while(this.charIndex > 0) {
            String var2 = this.text;
            int var3 = -1 + this.charIndex;
            this.charIndex = var3;
            this.lastChar = var2.charAt(var3);
            if(this.lastChar == 38) {
               return (byte)12;
            }

            if(this.lastChar == 59) {
               break;
            }
         }

         this.charIndex = var1;
         this.lastChar = 59;
         return (byte)13;
      }

      private byte skipEntityForward() {
         while(true) {
            if(this.charIndex < this.length) {
               String var1 = this.text;
               int var2 = this.charIndex;
               this.charIndex = var2 + 1;
               char var3 = var1.charAt(var2);
               this.lastChar = var3;
               if(var3 != 59) {
                  continue;
               }
            }

            return (byte)12;
         }
      }

      private byte skipTagBackward() {
         int var1 = this.charIndex;

         while(this.charIndex > 0) {
            String var2 = this.text;
            int var3 = -1 + this.charIndex;
            this.charIndex = var3;
            this.lastChar = var2.charAt(var3);
            if(this.lastChar == 60) {
               return (byte)12;
            }

            if(this.lastChar == 62) {
               break;
            }

            if(this.lastChar == 34 || this.lastChar == 39) {
               char var4 = this.lastChar;

               while(this.charIndex > 0) {
                  String var5 = this.text;
                  int var6 = -1 + this.charIndex;
                  this.charIndex = var6;
                  char var7 = var5.charAt(var6);
                  this.lastChar = var7;
                  if(var7 == var4) {
                     break;
                  }
               }
            }
         }

         this.charIndex = var1;
         this.lastChar = 62;
         return (byte)13;
      }

      private byte skipTagForward() {
         int var1 = this.charIndex;

         while(true) {
            do {
               if(this.charIndex >= this.length) {
                  this.charIndex = var1;
                  this.lastChar = 60;
                  return (byte)13;
               }

               String var2 = this.text;
               int var3 = this.charIndex;
               this.charIndex = var3 + 1;
               this.lastChar = var2.charAt(var3);
               if(this.lastChar == 62) {
                  return (byte)12;
               }
            } while(this.lastChar != 34 && this.lastChar != 39);

            char var4 = this.lastChar;

            while(this.charIndex < this.length) {
               String var5 = this.text;
               int var6 = this.charIndex;
               this.charIndex = var6 + 1;
               char var7 = var5.charAt(var6);
               this.lastChar = var7;
               if(var7 == var4) {
                  break;
               }
            }
         }
      }

      byte dirTypeBackward() {
         this.lastChar = this.text.charAt(-1 + this.charIndex);
         byte var1;
         if(Character.isLowSurrogate(this.lastChar)) {
            int var2 = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex -= Character.charCount(var2);
            var1 = Character.getDirectionality(var2);
         } else {
            this.charIndex += -1;
            var1 = getCachedDirectionality(this.lastChar);
            if(this.isHtml) {
               if(this.lastChar == 62) {
                  return this.skipTagBackward();
               }

               if(this.lastChar == 59) {
                  return this.skipEntityBackward();
               }
            }
         }

         return var1;
      }

      byte dirTypeForward() {
         this.lastChar = this.text.charAt(this.charIndex);
         byte var1;
         if(Character.isHighSurrogate(this.lastChar)) {
            int var2 = Character.codePointAt(this.text, this.charIndex);
            this.charIndex += Character.charCount(var2);
            var1 = Character.getDirectionality(var2);
         } else {
            ++this.charIndex;
            var1 = getCachedDirectionality(this.lastChar);
            if(this.isHtml) {
               if(this.lastChar == 60) {
                  return this.skipTagForward();
               }

               if(this.lastChar == 38) {
                  return this.skipEntityForward();
               }
            }
         }

         return var1;
      }

      int getEntryDir() {
         this.charIndex = 0;
         int var1 = 0;
         byte var2 = 0;
         int var3 = 0;

         while(this.charIndex < this.length && var3 == 0) {
            switch(this.dirTypeForward()) {
            case 0:
               if(var1 == 0) {
                  var2 = -1;
                  return var2;
               }

               var3 = var1;
               break;
            case 1:
            case 2:
               if(var1 == 0) {
                  return 1;
               }

               var3 = var1;
               break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
               var3 = var1;
            case 9:
               break;
            case 14:
            case 15:
               ++var1;
               var2 = -1;
               break;
            case 16:
            case 17:
               ++var1;
               var2 = 1;
               break;
            case 18:
               --var1;
               var2 = 0;
            }
         }

         if(var3 == 0) {
            return 0;
         } else if(var2 == 0) {
            while(this.charIndex > 0) {
               switch(this.dirTypeBackward()) {
               case 14:
               case 15:
                  if(var3 == var1) {
                     return -1;
                  }

                  --var1;
                  break;
               case 16:
               case 17:
                  if(var3 == var1) {
                     return 1;
                  }

                  --var1;
                  break;
               case 18:
                  ++var1;
               }
            }

            return 0;
         } else {
            return var2;
         }
      }

      int getExitDir() {
         this.charIndex = this.length;
         int var1 = 0;
         int var2 = 0;

         while(this.charIndex > 0) {
            switch(this.dirTypeBackward()) {
            case 0:
               if(var1 == 0) {
                  return -1;
               }

               if(var2 == 0) {
                  var2 = var1;
               }
               break;
            case 1:
            case 2:
               if(var1 == 0) {
                  return 1;
               }

               if(var2 == 0) {
                  var2 = var1;
               }
               break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
               if(var2 == 0) {
                  var2 = var1;
               }
            case 9:
               break;
            case 14:
            case 15:
               if(var2 == var1) {
                  return -1;
               }

               --var1;
               break;
            case 16:
            case 17:
               if(var2 == var1) {
                  return 1;
               }

               --var1;
               break;
            case 18:
               ++var1;
            }
         }

         return 0;
      }
   }
}
