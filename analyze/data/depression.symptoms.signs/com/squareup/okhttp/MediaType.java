package com.squareup.okhttp;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType {
   private static final Pattern PARAMETER = Pattern.compile(";\\s*([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)|\"([^\"]*)\")");
   private static final String QUOTED = "\"([^\"]*)\"";
   private static final String TOKEN = "([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)";
   private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)");
   private final String charset;
   private final String mediaType;
   private final String subtype;
   private final String type;

   private MediaType(String var1, String var2, String var3, String var4) {
      this.mediaType = var1;
      this.type = var2;
      this.subtype = var3;
      this.charset = var4;
   }

   public static MediaType parse(String var0) {
      Matcher var1 = TYPE_SUBTYPE.matcher(var0);
      if(var1.lookingAt()) {
         String var2 = var1.group(1).toLowerCase(Locale.US);
         String var3 = var1.group(2).toLowerCase(Locale.US);
         String var4 = null;
         Matcher var5 = PARAMETER.matcher(var0);
         int var6 = var1.end();

         while(true) {
            if(var6 >= var0.length()) {
               return new MediaType(var0, var2, var3, var4);
            }

            var5.region(var6, var0.length());
            if(!var5.lookingAt()) {
               break;
            }

            String var8 = var5.group(1);
            if(var8 != null && var8.equalsIgnoreCase("charset")) {
               if(var4 != null) {
                  throw new IllegalArgumentException("Multiple charsets: " + var0);
               }

               if(var5.group(2) != null) {
                  var4 = var5.group(2);
               } else {
                  var4 = var5.group(3);
               }
            }

            var6 = var5.end();
         }
      }

      return null;
   }

   public Charset charset() {
      return this.charset != null?Charset.forName(this.charset):null;
   }

   public Charset charset(Charset var1) {
      if(this.charset != null) {
         var1 = Charset.forName(this.charset);
      }

      return var1;
   }

   public boolean equals(Object var1) {
      return var1 instanceof MediaType && ((MediaType)var1).mediaType.equals(this.mediaType);
   }

   public int hashCode() {
      return this.mediaType.hashCode();
   }

   public String subtype() {
      return this.subtype;
   }

   public String toString() {
      return this.mediaType;
   }

   public String type() {
      return this.type;
   }
}
