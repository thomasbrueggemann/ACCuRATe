package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.message.BasicHeaderElement;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.HeaderValueParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;

public class BasicHeaderValueParser implements HeaderValueParser {
   private static final char[] ALL_DELIMITERS = new char[]{';', ','};
   @Deprecated
   public static final BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
   public static final BasicHeaderValueParser INSTANCE = new BasicHeaderValueParser();

   private static boolean isOneOf(char var0, char[] var1) {
      boolean var2 = false;
      if(var1 != null) {
         int var3 = var1.length;
         int var4 = 0;

         while(true) {
            var2 = false;
            if(var4 >= var3) {
               break;
            }

            if(var0 == var1[var4]) {
               var2 = true;
               break;
            }

            ++var4;
         }
      }

      return var2;
   }

   public static HeaderElement[] parseElements(String var0, HeaderValueParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var3 = new CharArrayBuffer(var0.length());
      var3.append(var0);
      ParserCursor var4 = new ParserCursor(0, var0.length());
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((HeaderValueParser)var1).parseElements(var3, var4);
   }

   protected HeaderElement createHeaderElement(String var1, String var2, NameValuePair[] var3) {
      return new BasicHeaderElement(var1, var2, var3);
   }

   protected NameValuePair createNameValuePair(String var1, String var2) {
      return new BasicNameValuePair(var1, var2);
   }

   public HeaderElement[] parseElements(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      ArrayList var5 = new ArrayList();

      while(true) {
         HeaderElement var6;
         do {
            if(var2.atEnd()) {
               return (HeaderElement[])var5.toArray(new HeaderElement[var5.size()]);
            }

            var6 = this.parseHeaderElement(var1, var2);
         } while(var6.getName().length() == 0 && var6.getValue() == null);

         var5.add(var6);
      }
   }

   public HeaderElement parseHeaderElement(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      NameValuePair var5 = this.parseNameValuePair(var1, var2);
      boolean var6 = var2.atEnd();
      NameValuePair[] var7 = null;
      if(!var6) {
         char var8 = var1.charAt(-1 + var2.getPos());
         var7 = null;
         if(var8 != 44) {
            var7 = this.parseParameters(var1, var2);
         }
      }

      return this.createHeaderElement(var5.getName(), var5.getValue(), var7);
   }

   public NameValuePair parseNameValuePair(CharArrayBuffer var1, ParserCursor var2) {
      return this.parseNameValuePair(var1, var2, ALL_DELIMITERS);
   }

   public NameValuePair parseNameValuePair(CharArrayBuffer var1, ParserCursor var2, char[] var3) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      int var6 = var2.getPos();
      int var7 = var2.getPos();
      int var8 = var2.getUpperBound();

      boolean var9;
      while(true) {
         var9 = false;
         if(var6 >= var8) {
            break;
         }

         char var17 = var1.charAt(var6);
         var9 = false;
         if(var17 == 61) {
            break;
         }

         if(isOneOf(var17, var3)) {
            var9 = true;
            break;
         }

         ++var6;
      }

      String var10;
      if(var6 == var8) {
         var9 = true;
         var10 = var1.substringTrimmed(var7, var8);
      } else {
         var10 = var1.substringTrimmed(var7, var6);
         ++var6;
      }

      if(var9) {
         var2.updatePos(var6);
         return this.createNameValuePair(var10, (String)null);
      } else {
         int var11 = var6;
         boolean var12 = false;

         for(boolean var13 = false; var6 < var8; ++var6) {
            char var16 = var1.charAt(var6);
            if(var16 == 34 && !var13) {
               if(!var12) {
                  var12 = true;
               } else {
                  var12 = false;
               }
            }

            if(!var12 && !var13 && isOneOf(var16, var3)) {
               var9 = true;
               break;
            }

            if(var13) {
               var13 = false;
            } else if(var12 && var16 == 92) {
               var13 = true;
            } else {
               var13 = false;
            }
         }

         int var14;
         for(var14 = var6; var11 < var14 && HTTP.isWhitespace(var1.charAt(var11)); ++var11) {
            ;
         }

         while(var14 > var11 && HTTP.isWhitespace(var1.charAt(var14 - 1))) {
            --var14;
         }

         if(var14 - var11 >= 2 && var1.charAt(var11) == 34 && var1.charAt(var14 - 1) == 34) {
            ++var11;
            --var14;
         }

         String var15 = var1.substring(var11, var14);
         if(var9) {
            ++var6;
         }

         var2.updatePos(var6);
         return this.createNameValuePair(var10, var15);
      }
   }

   public NameValuePair[] parseParameters(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      int var5 = var2.getPos();

      for(int var6 = var2.getUpperBound(); var5 < var6 && HTTP.isWhitespace(var1.charAt(var5)); ++var5) {
         ;
      }

      var2.updatePos(var5);
      if(var2.atEnd()) {
         return new NameValuePair[0];
      } else {
         ArrayList var7 = new ArrayList();

         while(!var2.atEnd()) {
            var7.add(this.parseNameValuePair(var1, var2));
            if(var1.charAt(-1 + var2.getPos()) == 44) {
               break;
            }
         }

         return (NameValuePair[])var7.toArray(new NameValuePair[var7.size()]);
      }
   }
}
