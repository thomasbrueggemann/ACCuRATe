package com.robotium.solo;

public class Timeout {
   private static int largeTimeout;
   private static int smallTimeout;

   public static int getLargeTimeout() {
      return largeTimeout;
   }

   public static int getSmallTimeout() {
      return smallTimeout;
   }

   public static void setLargeTimeout(int var0) {
      largeTimeout = var0;
   }

   public static void setSmallTimeout(int var0) {
      smallTimeout = var0;
   }
}
