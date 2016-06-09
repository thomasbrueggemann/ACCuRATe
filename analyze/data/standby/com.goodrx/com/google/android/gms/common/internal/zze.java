package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class zze {
   public static final zze zzakF = zza((CharSequence)"\t\n\u000b\f\r \u0085 \u2028\u2029 　 ᠎ ").zza(zza(' ', ' '));
   public static final zze zzakG = zza((CharSequence)"\t\n\u000b\f\r \u0085 \u2028\u2029 　").zza(zza(' ', ' ')).zza(zza(' ', ' '));
   public static final zze zzakH = zza('\u0000', '\u007f');
   public static final zze zzakI;
   public static final zze zzakJ;
   public static final zze zzakK;
   public static final zze zzakL;
   public static final zze zzakM;
   public static final zze zzakN;
   public static final zze zzakO;
   public static final zze zzakP;
   public static final zze zzakQ;
   public static final zze zzakR;
   public static final zze zzakS;
   public static final zze zzakT;

   static {
      zze var0 = zza('0', '9');
      char[] var1 = "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
      int var2 = var1.length;
      zze var3 = var0;

      for(int var4 = 0; var4 < var2; ++var4) {
         char var5 = var1[var4];
         var3 = var3.zza(zza(var5, (char)(var5 + 9)));
      }

      zzakI = var3;
      zzakJ = zza('\t', '\r').zza(zza('\u001c', ' ')).zza(zzc(' ')).zza(zzc('᠎')).zza(zza(' ', ' ')).zza(zza(' ', '\u200b')).zza(zza('\u2028', '\u2029')).zza(zzc(' ')).zza(zzc('　'));
      zzakK = new zze() {
         public boolean zzd(char var1) {
            return Character.isDigit(var1);
         }
      };
      zzakL = new zze() {
         public boolean zzd(char var1) {
            return Character.isLetter(var1);
         }
      };
      zzakM = new zze() {
         public boolean zzd(char var1) {
            return Character.isLetterOrDigit(var1);
         }
      };
      zzakN = new zze() {
         public boolean zzd(char var1) {
            return Character.isUpperCase(var1);
         }
      };
      zzakO = new zze() {
         public boolean zzd(char var1) {
            return Character.isLowerCase(var1);
         }
      };
      zzakP = zza('\u0000', '\u001f').zza(zza('\u007f', '\u009f'));
      zzakQ = zza('\u0000', ' ').zza(zza('\u007f', ' ')).zza(zzc('\u00ad')).zza(zza('\u0600', '\u0603')).zza(zza((CharSequence)"\u06dd\u070f \u17b4\u17b5᠎")).zza(zza(' ', '\u200f')).zza(zza('\u2028', ' ')).zza(zza(' ', '\u2064')).zza(zza('\u206a', '\u206f')).zza(zzc('　')).zza(zza('\ud800', '\uf8ff')).zza(zza((CharSequence)"\ufeff\ufff9\ufffa\ufffb"));
      zzakR = zza('\u0000', 'ӹ').zza(zzc('־')).zza(zza('א', 'ת')).zza(zzc('׳')).zza(zzc('״')).zza(zza('\u0600', 'ۿ')).zza(zza('ݐ', 'ݿ')).zza(zza('\u0e00', '\u0e7f')).zza(zza('Ḁ', '₯')).zza(zza('℀', '℺')).zza(zza('ﭐ', '\ufdff')).zza(zza('ﹰ', '\ufeff')).zza(zza('｡', 'ￜ'));
      zzakS = new zze() {
         public zze zza(zze var1) {
            zzx.zzz(var1);
            return this;
         }

         public boolean zzb(CharSequence var1) {
            zzx.zzz(var1);
            return true;
         }

         public boolean zzd(char var1) {
            return true;
         }
      };
      zzakT = new zze() {
         public zze zza(zze var1) {
            return (zze)zzx.zzz(var1);
         }

         public boolean zzb(CharSequence var1) {
            return var1.length() == 0;
         }

         public boolean zzd(char var1) {
            return false;
         }
      };
   }

   public static zze zza(final char var0, final char var1) {
      boolean var2;
      if(var1 >= var0) {
         var2 = true;
      } else {
         var2 = false;
      }

      zzx.zzac(var2);
      return new zze() {
         public boolean zzd(char var1x) {
            return var0 <= var1x && var1x <= var1;
         }
      };
   }

   public static zze zza(CharSequence var0) {
      switch(var0.length()) {
      case 0:
         return zzakT;
      case 1:
         return zzc(var0.charAt(0));
      case 2:
         return new zze() {
            // $FF: synthetic field
            final char zzakU;
            // $FF: synthetic field
            final char zzakV;

            {
               this.zzakU = var1;
               this.zzakV = var2;
            }

            public boolean zzd(char var1) {
               return var1 == this.zzakU || var1 == this.zzakV;
            }
         };
      default:
         final char[] var1 = var0.toString().toCharArray();
         Arrays.sort(var1);
         return new zze() {
            public boolean zzd(char var1x) {
               return Arrays.binarySearch(var1, var1x) >= 0;
            }
         };
      }
   }

   public static zze zzc(final char var0) {
      return new zze() {
         public zze zza(zze var1) {
            return var1.zzd(var0)?var1:super.zza(var1);
         }

         public boolean zzd(char var1) {
            return var1 == var0;
         }
      };
   }

   public zze zza(zze var1) {
      zze[] var2 = new zze[]{this, (zze)zzx.zzz(var1)};
      return new zze.zza(Arrays.asList(var2));
   }

   public boolean zzb(CharSequence var1) {
      for(int var2 = -1 + var1.length(); var2 >= 0; --var2) {
         if(!this.zzd(var1.charAt(var2))) {
            return false;
         }
      }

      return true;
   }

   public abstract boolean zzd(char var1);

   private static class zza extends zze {
      List<zze> zzala;

      zza(List<zze> var1) {
         this.zzala = var1;
      }

      public zze zza(zze var1) {
         ArrayList var2 = new ArrayList(this.zzala);
         var2.add(zzx.zzz(var1));
         return new zze.zza(var2);
      }

      public boolean zzd(char var1) {
         Iterator var2 = this.zzala.iterator();

         do {
            if(!var2.hasNext()) {
               return false;
            }
         } while(!((zze)var2.next()).zzd(var1));

         return true;
      }
   }
}
