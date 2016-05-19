package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicHeaderValueParser;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class URLEncodedUtils {
   private static final BitSet PATHSAFE;
   private static final BitSet PUNCT;
   private static final char[] QP_SEPS = new char[]{'&', ';'};
   private static final String QP_SEP_PATTERN;
   private static final BitSet RESERVED;
   private static final BitSet UNRESERVED;
   private static final BitSet URIC;
   private static final BitSet URLENCODER;
   private static final BitSet USERINFO;

   static {
      QP_SEP_PATTERN = "[" + new String(QP_SEPS) + "]";
      UNRESERVED = new BitSet(256);
      PUNCT = new BitSet(256);
      USERINFO = new BitSet(256);
      PATHSAFE = new BitSet(256);
      URIC = new BitSet(256);
      RESERVED = new BitSet(256);
      URLENCODER = new BitSet(256);

      for(int var0 = 97; var0 <= 122; ++var0) {
         UNRESERVED.set(var0);
      }

      for(int var1 = 65; var1 <= 90; ++var1) {
         UNRESERVED.set(var1);
      }

      for(int var2 = 48; var2 <= 57; ++var2) {
         UNRESERVED.set(var2);
      }

      UNRESERVED.set(95);
      UNRESERVED.set(45);
      UNRESERVED.set(46);
      UNRESERVED.set(42);
      URLENCODER.or(UNRESERVED);
      UNRESERVED.set(33);
      UNRESERVED.set(126);
      UNRESERVED.set(39);
      UNRESERVED.set(40);
      UNRESERVED.set(41);
      PUNCT.set(44);
      PUNCT.set(59);
      PUNCT.set(58);
      PUNCT.set(36);
      PUNCT.set(38);
      PUNCT.set(43);
      PUNCT.set(61);
      USERINFO.or(UNRESERVED);
      USERINFO.or(PUNCT);
      PATHSAFE.or(UNRESERVED);
      PATHSAFE.set(47);
      PATHSAFE.set(59);
      PATHSAFE.set(58);
      PATHSAFE.set(64);
      PATHSAFE.set(38);
      PATHSAFE.set(61);
      PATHSAFE.set(43);
      PATHSAFE.set(36);
      PATHSAFE.set(44);
      RESERVED.set(59);
      RESERVED.set(47);
      RESERVED.set(63);
      RESERVED.set(58);
      RESERVED.set(64);
      RESERVED.set(38);
      RESERVED.set(61);
      RESERVED.set(43);
      RESERVED.set(36);
      RESERVED.set(44);
      RESERVED.set(91);
      RESERVED.set(93);
      URIC.or(RESERVED);
      URIC.or(UNRESERVED);
   }

   private static String decodeFormFields(String var0, Charset var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var1 == null) {
            var1 = Consts.UTF_8;
         }

         return urlDecode(var0, var1, true);
      }
   }

   static String encPath(String var0, Charset var1) {
      return urlEncode(var0, var1, PATHSAFE, false);
   }

   static String encUric(String var0, Charset var1) {
      return urlEncode(var0, var1, URIC, false);
   }

   static String encUserInfo(String var0, Charset var1) {
      return urlEncode(var0, var1, USERINFO, false);
   }

   private static String encodeFormFields(String var0, String var1) {
      if(var0 == null) {
         return null;
      } else {
         Charset var2;
         if(var1 != null) {
            var2 = Charset.forName(var1);
         } else {
            var2 = Consts.UTF_8;
         }

         return urlEncode(var0, var2, URLENCODER, true);
      }
   }

   private static String encodeFormFields(String var0, Charset var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var1 == null) {
            var1 = Consts.UTF_8;
         }

         return urlEncode(var0, var1, URLENCODER, true);
      }
   }

   public static String format(Iterable<? extends NameValuePair> var0, char var1, Charset var2) {
      StringBuilder var3 = new StringBuilder();
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         NameValuePair var5 = (NameValuePair)var4.next();
         String var6 = encodeFormFields(var5.getName(), var2);
         String var7 = encodeFormFields(var5.getValue(), var2);
         if(var3.length() > 0) {
            var3.append(var1);
         }

         var3.append(var6);
         if(var7 != null) {
            var3.append("=");
            var3.append(var7);
         }
      }

      return var3.toString();
   }

   public static String format(Iterable<? extends NameValuePair> var0, Charset var1) {
      return format(var0, '&', var1);
   }

   public static String format(List<? extends NameValuePair> var0, char var1, String var2) {
      StringBuilder var3 = new StringBuilder();
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         NameValuePair var5 = (NameValuePair)var4.next();
         String var6 = encodeFormFields(var5.getName(), var2);
         String var7 = encodeFormFields(var5.getValue(), var2);
         if(var3.length() > 0) {
            var3.append(var1);
         }

         var3.append(var6);
         if(var7 != null) {
            var3.append("=");
            var3.append(var7);
         }
      }

      return var3.toString();
   }

   public static String format(List<? extends NameValuePair> var0, String var1) {
      return format(var0, '&', var1);
   }

   public static List<NameValuePair> parse(String var0, Charset var1) {
      return parse(var0, var1, QP_SEPS);
   }

   public static List<NameValuePair> parse(String var0, Charset var1, char... var2) {
      Object var6;
      if(var0 == null) {
         var6 = Collections.emptyList();
      } else {
         BasicHeaderValueParser var3 = BasicHeaderValueParser.INSTANCE;
         CharArrayBuffer var4 = new CharArrayBuffer(var0.length());
         var4.append(var0);
         ParserCursor var5 = new ParserCursor(0, var4.length());
         var6 = new ArrayList();

         while(!var5.atEnd()) {
            NameValuePair var7 = var3.parseNameValuePair(var4, var5, var2);
            if(var7.getName().length() > 0) {
               ((List)var6).add(new BasicNameValuePair(decodeFormFields(var7.getName(), var1), decodeFormFields(var7.getValue(), var1)));
            }
         }
      }

      return (List)var6;
   }

   private static String urlDecode(String var0, Charset var1, boolean var2) {
      if(var0 == null) {
         return null;
      } else {
         ByteBuffer var3 = ByteBuffer.allocate(var0.length());
         CharBuffer var4 = CharBuffer.wrap(var0);

         while(true) {
            while(true) {
               while(var4.hasRemaining()) {
                  char var6 = var4.get();
                  if(var6 == 37 && var4.remaining() >= 2) {
                     char var9 = var4.get();
                     char var10 = var4.get();
                     int var11 = Character.digit(var9, 16);
                     int var12 = Character.digit(var10, 16);
                     if(var11 != -1 && var12 != -1) {
                        var3.put((byte)(var12 + (var11 << 4)));
                     } else {
                        var3.put((byte)37);
                        var3.put((byte)var9);
                        var3.put((byte)var10);
                     }
                  } else if(var2 && var6 == 43) {
                     var3.put((byte)32);
                  } else {
                     var3.put((byte)var6);
                  }
               }

               var3.flip();
               return var1.decode(var3).toString();
            }
         }
      }
   }

   private static String urlEncode(String var0, Charset var1, BitSet var2, boolean var3) {
      if(var0 == null) {
         return null;
      } else {
         StringBuilder var4 = new StringBuilder();
         ByteBuffer var5 = var1.encode(var0);

         while(true) {
            while(var5.hasRemaining()) {
               int var6 = 255 & var5.get();
               if(var2.get(var6)) {
                  var4.append((char)var6);
               } else if(var3 && var6 == 32) {
                  var4.append('+');
               } else {
                  var4.append("%");
                  char var8 = Character.toUpperCase(Character.forDigit(15 & var6 >> 4, 16));
                  char var9 = Character.toUpperCase(Character.forDigit(var6 & 15, 16));
                  var4.append(var8);
                  var4.append(var9);
               }
            }

            return var4.toString();
         }
      }
   }
}
