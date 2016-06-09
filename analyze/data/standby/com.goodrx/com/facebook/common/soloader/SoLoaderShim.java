package com.facebook.common.soloader;

public class SoLoaderShim {
   private static volatile SoLoaderShim.Handler sHandler = new SoLoaderShim.DefaultHandler();

   public static void loadLibrary(String var0) {
      sHandler.loadLibrary(var0);
   }

   public static void setHandler(SoLoaderShim.Handler var0) {
      if(var0 == null) {
         throw new NullPointerException("Handler cannot be null");
      } else {
         sHandler = var0;
      }
   }

   public static void setInTestMode() {
      setHandler(new SoLoaderShim.Handler() {
         public void loadLibrary(String var1) {
         }
      });
   }

   public static class DefaultHandler implements SoLoaderShim.Handler {
      public void loadLibrary(String var1) {
         System.loadLibrary(var1);
      }
   }

   public interface Handler {
      void loadLibrary(String var1);
   }
}
