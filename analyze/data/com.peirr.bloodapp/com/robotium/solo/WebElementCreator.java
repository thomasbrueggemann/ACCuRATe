package com.robotium.solo;

import android.os.SystemClock;
import android.webkit.WebView;
import com.robotium.solo.Sleeper;
import com.robotium.solo.WebElement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class WebElementCreator {
   private boolean isFinished = false;
   private Sleeper sleeper;
   private List<WebElement> webElements;

   public WebElementCreator(Sleeper var1) {
      this.sleeper = var1;
      this.webElements = new CopyOnWriteArrayList();
   }

   private WebElement createWebElementAndSetLocation(String var1, WebView var2) {
      String[] var3 = var1.split(";,");
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      Hashtable var8 = new Hashtable();

      String[] var10;
      label38: {
         String[] var19;
         try {
            var4 = Math.round(Float.valueOf(var3[5]).floatValue());
            var5 = Math.round(Float.valueOf(var3[6]).floatValue());
            var6 = Math.round(Float.valueOf(var3[7]).floatValue());
            var7 = Math.round(Float.valueOf(var3[8]).floatValue());
            var19 = var3[9].split("\\#\\$");
         } catch (Exception var22) {
            var10 = null;
            break label38;
         }

         var10 = var19;
      }

      if(var10 != null) {
         int var14 = 0;

         while(true) {
            int var15 = var10.length;
            if(var14 >= var15) {
               break;
            }

            String[] var16 = var10[var14].split("::");
            if(var16.length > 1) {
               var8.put(var16[0], var16[1]);
            } else {
               var8.put(var16[0], var16[0]);
            }

            ++var14;
         }
      }

      WebElement var11;
      try {
         var11 = new WebElement(var3[0], var3[1], var3[2], var3[3], var3[4], var8);
      } catch (Exception var21) {
         return null;
      }

      try {
         this.setLocation(var11, var2, var4, var5, var6, var7);
         return var11;
      } catch (Exception var20) {
         return var11;
      }
   }

   private void setLocation(WebElement var1, WebView var2, int var3, int var4, int var5, int var6) {
      float var7 = var2.getScale();
      int[] var8 = new int[2];
      var2.getLocationOnScreen(var8);
      int var9 = (int)((double)var8[0] + ((double)var3 + Math.floor((double)(var5 / 2))) * (double)var7);
      int var10 = (int)((double)var8[1] + ((double)var4 + Math.floor((double)(var6 / 2))) * (double)var7);
      var1.setLocationX(var9);
      var1.setLocationY(var10);
   }

   private boolean waitForWebElementsToBeCreated() {
      long var1 = 5000L + SystemClock.uptimeMillis();

      while(SystemClock.uptimeMillis() < var1) {
         if(this.isFinished) {
            return true;
         }

         this.sleeper.sleepMini();
      }

      return false;
   }

   public void createWebElementAndAddInList(String var1, WebView var2) {
      WebElement var3 = this.createWebElementAndSetLocation(var1, var2);
      if(var3 != null) {
         this.webElements.add(var3);
      }

   }

   public ArrayList<WebElement> getWebElementsFromWebViews() {
      this.waitForWebElementsToBeCreated();
      return new ArrayList(this.webElements);
   }

   public boolean isFinished() {
      return this.isFinished;
   }

   public void prepareForStart() {
      this.setFinished(false);
      this.webElements.clear();
   }

   public void setFinished(boolean var1) {
      this.isFinished = var1;
   }
}
