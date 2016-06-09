package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

public class BasicHeaderValueFormatter {
   @Deprecated
   public static final BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
   public static final BasicHeaderValueFormatter INSTANCE = new BasicHeaderValueFormatter();

   protected void doFormatValue(CharArrayBuffer var1, String var2, boolean var3) {
      boolean var4 = var3;
      if(!var3) {
         for(int var7 = 0; var7 < var2.length() && !var4; ++var7) {
            var4 = this.isSeparator(var2.charAt(var7));
         }
      }

      if(var4) {
         var1.append('\"');
      }

      for(int var5 = 0; var5 < var2.length(); ++var5) {
         char var6 = var2.charAt(var5);
         if(this.isUnsafe(var6)) {
            var1.append('\\');
         }

         var1.append(var6);
      }

      if(var4) {
         var1.append('\"');
      }

   }

   protected int estimateHeaderElementLen(HeaderElement var1) {
      int var2;
      if(var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.getName().length();
         String var3 = var1.getValue();
         if(var3 != null) {
            var2 += 3 + var3.length();
         }

         int var4 = var1.getParameterCount();
         if(var4 > 0) {
            for(int var5 = 0; var5 < var4; ++var5) {
               var2 += 2 + this.estimateNameValuePairLen(var1.getParameter(var5));
            }
         }
      }

      return var2;
   }

   protected int estimateNameValuePairLen(NameValuePair var1) {
      int var2;
      if(var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.getName().length();
         String var3 = var1.getValue();
         if(var3 != null) {
            return var2 + 3 + var3.length();
         }
      }

      return var2;
   }

   protected int estimateParametersLen(NameValuePair[] var1) {
      int var2 = 0;
      int var3;
      if(var1 != null && var1.length >= 1) {
         var3 = 2 * (-1 + var1.length);

         for(int var4 = var1.length; var2 < var4; ++var2) {
            var3 += this.estimateNameValuePairLen(var1[var2]);
         }
      } else {
         var3 = 0;
      }

      return var3;
   }

   public CharArrayBuffer formatHeaderElement(CharArrayBuffer var1, HeaderElement var2, boolean var3) {
      Args.notNull(var2, "Header element");
      int var5 = this.estimateHeaderElementLen(var2);
      CharArrayBuffer var6 = var1;
      if(var1 == null) {
         var6 = new CharArrayBuffer(var5);
      } else {
         var1.ensureCapacity(var5);
      }

      var6.append(var2.getName());
      String var7 = var2.getValue();
      if(var7 != null) {
         var6.append('=');
         this.doFormatValue(var6, var7, var3);
      }

      int var8 = var2.getParameterCount();
      if(var8 > 0) {
         for(int var9 = 0; var9 < var8; ++var9) {
            var6.append("; ");
            this.formatNameValuePair(var6, var2.getParameter(var9), var3);
         }
      }

      return var6;
   }

   public CharArrayBuffer formatNameValuePair(CharArrayBuffer var1, NameValuePair var2, boolean var3) {
      Args.notNull(var2, "Name / value pair");
      int var5 = this.estimateNameValuePairLen(var2);
      CharArrayBuffer var6 = var1;
      if(var1 == null) {
         var6 = new CharArrayBuffer(var5);
      } else {
         var1.ensureCapacity(var5);
      }

      var6.append(var2.getName());
      String var7 = var2.getValue();
      if(var7 != null) {
         var6.append('=');
         this.doFormatValue(var6, var7, var3);
      }

      return var6;
   }

   public CharArrayBuffer formatParameters(CharArrayBuffer var1, NameValuePair[] var2, boolean var3) {
      Args.notNull(var2, "Header parameter array");
      int var5 = this.estimateParametersLen(var2);
      CharArrayBuffer var6 = var1;
      if(var1 == null) {
         var6 = new CharArrayBuffer(var5);
      } else {
         var1.ensureCapacity(var5);
      }

      for(int var7 = 0; var7 < var2.length; ++var7) {
         if(var7 > 0) {
            var6.append("; ");
         }

         this.formatNameValuePair(var6, var2[var7], var3);
      }

      return var6;
   }

   protected boolean isSeparator(char var1) {
      return " ;,:@()<>\\\"/[]?={}\t".indexOf(var1) >= 0;
   }

   protected boolean isUnsafe(char var1) {
      return "\"\\".indexOf(var1) >= 0;
   }
}
