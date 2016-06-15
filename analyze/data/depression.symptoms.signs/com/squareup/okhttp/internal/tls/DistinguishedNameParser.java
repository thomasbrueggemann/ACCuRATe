package com.squareup.okhttp.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser {
   private int beg;
   private char[] chars;
   private int cur;
   // $FF: renamed from: dn java.lang.String
   private final String field_17;
   private int end;
   private final int length;
   private int pos;

   public DistinguishedNameParser(X500Principal var1) {
      this.field_17 = var1.getName("RFC2253");
      this.length = this.field_17.length();
   }

   private String escapedAV() {
      this.beg = this.pos;
      this.end = this.pos;

      while(this.pos < this.length) {
         switch(this.chars[this.pos]) {
         case ' ':
            this.cur = this.end;
            ++this.pos;
            char[] var1 = this.chars;
            int var2 = this.end;
            this.end = var2 + 1;

            for(var1[var2] = 32; this.pos < this.length && this.chars[this.pos] == 32; ++this.pos) {
               char[] var3 = this.chars;
               int var4 = this.end;
               this.end = var4 + 1;
               var3[var4] = 32;
            }

            if(this.pos == this.length || this.chars[this.pos] == 44 || this.chars[this.pos] == 43 || this.chars[this.pos] == 59) {
               return new String(this.chars, this.beg, this.cur - this.beg);
            }
            break;
         case '+':
         case ',':
         case ';':
            return new String(this.chars, this.beg, this.end - this.beg);
         case '\\':
            char[] var5 = this.chars;
            int var6 = this.end;
            this.end = var6 + 1;
            var5[var6] = this.getEscaped();
            ++this.pos;
            break;
         default:
            char[] var7 = this.chars;
            int var8 = this.end;
            this.end = var8 + 1;
            var7[var8] = this.chars[this.pos];
            ++this.pos;
         }
      }

      return new String(this.chars, this.beg, this.end - this.beg);
   }

   private int getByte(int var1) {
      if(var1 + 1 >= this.length) {
         throw new IllegalStateException("Malformed DN: " + this.field_17);
      } else {
         char var2 = this.chars[var1];
         int var3;
         if(var2 >= 48 && var2 <= 57) {
            var3 = var2 - 48;
         } else if(var2 >= 97 && var2 <= 102) {
            var3 = var2 - 87;
         } else {
            if(var2 < 65 || var2 > 70) {
               throw new IllegalStateException("Malformed DN: " + this.field_17);
            }

            var3 = var2 - 55;
         }

         char var4 = this.chars[var1 + 1];
         int var5;
         if(var4 >= 48 && var4 <= 57) {
            var5 = var4 - 48;
         } else if(var4 >= 97 && var4 <= 102) {
            var5 = var4 - 87;
         } else {
            if(var4 < 65 || var4 > 70) {
               throw new IllegalStateException("Malformed DN: " + this.field_17);
            }

            var5 = var4 - 55;
         }

         return var5 + (var3 << 4);
      }
   }

   private char getEscaped() {
      ++this.pos;
      if(this.pos == this.length) {
         throw new IllegalStateException("Unexpected end of DN: " + this.field_17);
      } else {
         switch(this.chars[this.pos]) {
         case ' ':
         case '\"':
         case '#':
         case '%':
         case '*':
         case '+':
         case ',':
         case ';':
         case '<':
         case '=':
         case '>':
         case '\\':
         case '_':
            return this.chars[this.pos];
         default:
            return this.getUTF8();
         }
      }
   }

   private char getUTF8() {
      char var1 = 63;
      int var2 = this.getByte(this.pos);
      ++this.pos;
      if(var2 < 128) {
         var1 = (char)var2;
      } else if(var2 >= 192 && var2 <= 247) {
         byte var3;
         int var4;
         if(var2 <= 223) {
            var3 = 1;
            var4 = var2 & 31;
         } else if(var2 <= 239) {
            var3 = 2;
            var4 = var2 & 15;
         } else {
            var3 = 3;
            var4 = var2 & 7;
         }

         int var5 = 0;

         while(true) {
            if(var5 >= var3) {
               return (char)var4;
            }

            ++this.pos;
            if(this.pos == this.length || this.chars[this.pos] != 92) {
               break;
            }

            ++this.pos;
            int var6 = this.getByte(this.pos);
            ++this.pos;
            if((var6 & 192) != 128) {
               break;
            }

            var4 = (var4 << 6) + (var6 & 63);
            ++var5;
         }
      }

      return var1;
   }

   private String hexAV() {
      if(4 + this.pos >= this.length) {
         throw new IllegalStateException("Unexpected end of DN: " + this.field_17);
      } else {
         this.beg = this.pos++;

         label57:
         while(true) {
            if(this.pos == this.length || this.chars[this.pos] == 43 || this.chars[this.pos] == 44 || this.chars[this.pos] == 59) {
               this.end = this.pos;
               break;
            }

            if(this.chars[this.pos] == 32) {
               this.end = this.pos++;

               while(true) {
                  if(this.pos >= this.length || this.chars[this.pos] != 32) {
                     break label57;
                  }

                  ++this.pos;
               }
            }

            if(this.chars[this.pos] >= 65 && this.chars[this.pos] <= 70) {
               char[] var5 = this.chars;
               int var6 = this.pos;
               var5[var6] = (char)(32 + var5[var6]);
            }

            ++this.pos;
         }

         int var1 = this.end - this.beg;
         if(var1 >= 5 && (var1 & 1) != 0) {
            byte[] var2 = new byte[var1 / 2];
            int var3 = 0;

            for(int var4 = 1 + this.beg; var3 < var2.length; ++var3) {
               var2[var3] = (byte)this.getByte(var4);
               var4 += 2;
            }

            return new String(this.chars, this.beg, var1);
         } else {
            throw new IllegalStateException("Unexpected end of DN: " + this.field_17);
         }
      }
   }

   private String nextAT() {
      while(this.pos < this.length && this.chars[this.pos] == 32) {
         ++this.pos;
      }

      if(this.pos == this.length) {
         return null;
      } else {
         for(this.beg = this.pos++; this.pos < this.length && this.chars[this.pos] != 61 && this.chars[this.pos] != 32; ++this.pos) {
            ;
         }

         if(this.pos >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.field_17);
         } else {
            this.end = this.pos;
            if(this.chars[this.pos] == 32) {
               while(true) {
                  if(this.pos >= this.length || this.chars[this.pos] == 61 || this.chars[this.pos] != 32) {
                     if(this.chars[this.pos] != 61 || this.pos == this.length) {
                        throw new IllegalStateException("Unexpected end of DN: " + this.field_17);
                     }
                     break;
                  }

                  ++this.pos;
               }
            }

            ++this.pos;

            while(this.pos < this.length && this.chars[this.pos] == 32) {
               ++this.pos;
            }

            if(this.end - this.beg > 4 && this.chars[3 + this.beg] == 46 && (this.chars[this.beg] == 79 || this.chars[this.beg] == 111) && (this.chars[1 + this.beg] == 73 || this.chars[1 + this.beg] == 105) && (this.chars[2 + this.beg] == 68 || this.chars[2 + this.beg] == 100)) {
               this.beg += 4;
            }

            return new String(this.chars, this.beg, this.end - this.beg);
         }
      }
   }

   private String quotedAV() {
      ++this.pos;
      this.beg = this.pos;

      for(this.end = this.beg; this.pos != this.length; ++this.end) {
         if(this.chars[this.pos] == 34) {
            ++this.pos;

            while(this.pos < this.length && this.chars[this.pos] == 32) {
               ++this.pos;
            }

            return new String(this.chars, this.beg, this.end - this.beg);
         }

         if(this.chars[this.pos] == 92) {
            this.chars[this.end] = this.getEscaped();
         } else {
            this.chars[this.end] = this.chars[this.pos];
         }

         ++this.pos;
      }

      throw new IllegalStateException("Unexpected end of DN: " + this.field_17);
   }

   public String findMostSpecific(String var1) {
      this.pos = 0;
      this.beg = 0;
      this.end = 0;
      this.cur = 0;
      this.chars = this.field_17.toCharArray();
      String var2 = this.nextAT();
      String var3;
      if(var2 == null) {
         var3 = null;
      } else {
         while(true) {
            var3 = "";
            if(this.pos == this.length) {
               return null;
            }

            switch(this.chars[this.pos]) {
            case '\"':
               var3 = this.quotedAV();
               break;
            case '#':
               var3 = this.hexAV();
            case '+':
            case ',':
            case ';':
               break;
            default:
               var3 = this.escapedAV();
            }

            if(var1.equalsIgnoreCase(var2)) {
               break;
            }

            if(this.pos >= this.length) {
               return null;
            }

            if(this.chars[this.pos] != 44 && this.chars[this.pos] != 59 && this.chars[this.pos] != 43) {
               throw new IllegalStateException("Malformed DN: " + this.field_17);
            }

            ++this.pos;
            var2 = this.nextAT();
            if(var2 == null) {
               throw new IllegalStateException("Malformed DN: " + this.field_17);
            }
         }
      }

      return var3;
   }
}
