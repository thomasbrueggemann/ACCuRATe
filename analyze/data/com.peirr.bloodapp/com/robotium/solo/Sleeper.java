package com.robotium.solo;

class Sleeper {
   private final int MINIPAUSE = 300;
   private final int PAUSE = 500;

   public void sleep() {
      this.sleep(500);
   }

   public void sleep(int var1) {
      long var2 = (long)var1;

      try {
         Thread.sleep(var2);
      } catch (InterruptedException var5) {
         ;
      }
   }

   public void sleepMini() {
      this.sleep(300);
   }
}
