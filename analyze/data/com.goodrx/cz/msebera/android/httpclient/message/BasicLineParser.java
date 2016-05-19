package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.message.BasicStatusLine;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

public class BasicLineParser implements LineParser {
   @Deprecated
   public static final BasicLineParser DEFAULT = new BasicLineParser();
   public static final BasicLineParser INSTANCE = new BasicLineParser();
   protected final ProtocolVersion protocol;

   public BasicLineParser() {
      this((ProtocolVersion)null);
   }

   public BasicLineParser(ProtocolVersion var1) {
      if(var1 == null) {
         var1 = HttpVersion.HTTP_1_1;
      }

      this.protocol = (ProtocolVersion)var1;
   }

   protected ProtocolVersion createProtocolVersion(int var1, int var2) {
      return this.protocol.forVersion(var1, var2);
   }

   protected StatusLine createStatusLine(ProtocolVersion var1, int var2, String var3) {
      return new BasicStatusLine(var1, var2, var3);
   }

   public boolean hasProtocolVersion(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      int var5 = var2.getPos();
      String var6 = this.protocol.getProtocol();
      int var7 = var6.length();
      if(var1.length() >= var7 + 4) {
         if(var5 < 0) {
            var5 = -4 + var1.length() - var7;
         } else if(var5 == 0) {
            while(var5 < var1.length() && HTTP.isWhitespace(var1.charAt(var5))) {
               ++var5;
            }
         }

         if(4 + var5 + var7 <= var1.length()) {
            boolean var8 = true;

            for(int var9 = 0; var8 && var9 < var7; ++var9) {
               if(var1.charAt(var5 + var9) == var6.charAt(var9)) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            }

            if(var8) {
               if(var1.charAt(var5 + var7) == 47) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            }

            return var8;
         }
      }

      return false;
   }

   public Header parseHeader(CharArrayBuffer var1) throws ParseException {
      return new BufferedHeader(var1);
   }

   public ProtocolVersion parseProtocolVersion(CharArrayBuffer var1, ParserCursor var2) throws ParseException {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      String var5 = this.protocol.getProtocol();
      int var6 = var5.length();
      int var7 = var2.getPos();
      int var8 = var2.getUpperBound();
      this.skipWhitespace(var1, var2);
      int var9 = var2.getPos();
      if(4 + var9 + var6 > var8) {
         throw new ParseException("Not a valid protocol version: " + var1.substring(var7, var8));
      } else {
         boolean var10 = true;

         for(int var11 = 0; var10 && var11 < var6; ++var11) {
            if(var1.charAt(var9 + var11) == var5.charAt(var11)) {
               var10 = true;
            } else {
               var10 = false;
            }
         }

         if(var10) {
            if(var1.charAt(var9 + var6) == 47) {
               var10 = true;
            } else {
               var10 = false;
            }
         }

         if(!var10) {
            throw new ParseException("Not a valid protocol version: " + var1.substring(var7, var8));
         } else {
            int var12 = var9 + var6 + 1;
            int var13 = var1.indexOf(46, var12, var8);
            if(var13 == -1) {
               throw new ParseException("Invalid protocol version number: " + var1.substring(var7, var8));
            } else {
               int var15;
               try {
                  var15 = Integer.parseInt(var1.substringTrimmed(var12, var13));
               } catch (NumberFormatException var21) {
                  throw new ParseException("Invalid protocol major version number: " + var1.substring(var7, var8));
               }

               int var16 = var13 + 1;
               int var17 = var1.indexOf(32, var16, var8);
               if(var17 == -1) {
                  var17 = var8;
               }

               int var19;
               try {
                  var19 = Integer.parseInt(var1.substringTrimmed(var16, var17));
               } catch (NumberFormatException var20) {
                  throw new ParseException("Invalid protocol minor version number: " + var1.substring(var7, var8));
               }

               var2.updatePos(var17);
               return this.createProtocolVersion(var15, var19);
            }
         }
      }
   }

   public StatusLine parseStatusLine(CharArrayBuffer param1, ParserCursor param2) throws ParseException {
      // $FF: Couldn't be decompiled
   }

   protected void skipWhitespace(CharArrayBuffer var1, ParserCursor var2) {
      int var3 = var2.getPos();

      for(int var4 = var2.getUpperBound(); var3 < var4 && HTTP.isWhitespace(var1.charAt(var3)); ++var3) {
         ;
      }

      var2.updatePos(var3);
   }
}
