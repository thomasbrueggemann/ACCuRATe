package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public interface ImageDownloader {
   InputStream getStream(String var1, Object var2) throws IOException;

   public static enum Scheme {
      ASSETS("assets"),
      CONTENT("content"),
      DRAWABLE("drawable"),
      FILE("file"),
      HTTP("http"),
      HTTPS("https"),
      UNKNOWN("");

      private String scheme;
      private String uriPrefix;

      static {
         ImageDownloader.Scheme[] var0 = new ImageDownloader.Scheme[]{HTTP, HTTPS, FILE, CONTENT, ASSETS, DRAWABLE, UNKNOWN};
      }

      private Scheme(String var3) {
         this.scheme = var3;
         this.uriPrefix = var3 + "://";
      }

      private boolean belongsTo(String var1) {
         return var1.toLowerCase(Locale.US).startsWith(this.uriPrefix);
      }

      public static ImageDownloader.Scheme ofUri(String var0) {
         if(var0 != null) {
            ImageDownloader.Scheme[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
               ImageDownloader.Scheme var4 = var1[var3];
               if(var4.belongsTo(var0)) {
                  return var4;
               }
            }
         }

         return UNKNOWN;
      }

      public String crop(String var1) {
         if(!this.belongsTo(var1)) {
            Object[] var2 = new Object[]{var1, this.scheme};
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn\'t have expected scheme [%2$s]", var2));
         } else {
            return var1.substring(this.uriPrefix.length());
         }
      }

      public String wrap(String var1) {
         return this.uriPrefix + var1;
      }
   }
}
