package com.robotium.solo;

import android.app.Instrumentation;
import com.robotium.solo.Sleeper;
import junit.framework.Assert;

class Sender {
   private final Instrumentation inst;
   private final Sleeper sleeper;

   Sender(Instrumentation var1, Sleeper var2) {
      this.inst = var1;
      this.sleeper = var2;
   }

   public void goBack() {
      this.sleeper.sleep();

      try {
         this.inst.sendKeyDownUpSync(4);
         this.sleeper.sleep();
      } catch (Throwable var2) {
         ;
      }
   }

   public void sendKeyCode(int var1) {
      this.sleeper.sleep();

      try {
         this.inst.sendCharacterSync(var1);
      } catch (SecurityException var5) {
         StringBuilder var3 = (new StringBuilder()).append("Can not complete action! (");
         String var4;
         if(var5 != null) {
            var4 = var5.getClass().getName() + ": " + var5.getMessage();
         } else {
            var4 = "null";
         }

         Assert.fail(var3.append(var4).append(")").toString());
      }
   }
}
