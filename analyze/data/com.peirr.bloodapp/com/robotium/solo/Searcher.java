package com.robotium.solo;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.robotium.solo.RobotiumUtils;
import com.robotium.solo.Scroller;
import com.robotium.solo.Sleeper;
import com.robotium.solo.ViewFetcher;
import com.robotium.solo.WebElement;
import com.robotium.solo.WebUtils;
import com.robotium.solo.class_0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

class Searcher {
   private final String LOG_TAG = "Robotium";
   private final int TIMEOUT = 5000;
   private int numberOfUniqueViews;
   private final Scroller scroller;
   private final Sleeper sleeper;
   Set<TextView> uniqueTextViews;
   private final ViewFetcher viewFetcher;
   List<WebElement> webElements;
   private final WebUtils webUtils;

   public Searcher(ViewFetcher var1, WebUtils var2, Scroller var3, Sleeper var4) {
      this.viewFetcher = var1;
      this.webUtils = var2;
      this.scroller = var3;
      this.sleeper = var4;
      this.webElements = new ArrayList();
      this.uniqueTextViews = new HashSet();
   }

   private void addViewsToList(List<WebElement> var1, List<WebElement> var2) {
      int[] var3 = new int[2];
      int[] var4 = new int[2];
      Iterator var5 = var2.iterator();

      while(var5.hasNext()) {
         WebElement var6 = (WebElement)var5.next();
         boolean var7 = false;
         var6.getLocationOnScreen(var4);
         Iterator var8 = var1.iterator();

         while(var8.hasNext()) {
            WebElement var10 = (WebElement)var8.next();
            var10.getLocationOnScreen(var3);
            if(var6.getText().equals(var10.getText()) && var4[0] == var3[0] && var4[1] == var3[1]) {
               var7 = true;
            }
         }

         if(!var7) {
            var1.add(var6);
         }
      }

   }

   private WebElement getViewFromList(List<WebElement> var1, int var2) {
      int var3 = var1.size();
      WebElement var4 = null;
      if(var3 >= var2) {
         int var5 = var2 - 1;

         try {
            var4 = (WebElement)var1.get(var5);
         } catch (Exception var7) {
            var4 = null;
         }
      }

      if(var4 != null) {
         var1.clear();
      }

      return var4;
   }

   public int getNumberOfUniqueViews() {
      return this.numberOfUniqueViews;
   }

   public <T extends View> int getNumberOfUniqueViews(Set<T> var1, ArrayList<T> var2) {
      for(int var3 = 0; var3 < var2.size(); ++var3) {
         var1.add(var2.get(var3));
      }

      this.numberOfUniqueViews = var1.size();
      return this.numberOfUniqueViews;
   }

   public void logMatchesFound(String var1) {
      if(this.uniqueTextViews.size() > 0) {
         Log.d("Robotium", " There are only " + this.uniqueTextViews.size() + " matches of \'" + var1 + "\'");
      } else if(this.webElements.size() > 0) {
         Log.d("Robotium", " There are only " + this.webElements.size() + " matches of \'" + var1 + "\'");
      }

      this.uniqueTextViews.clear();
      this.webElements.clear();
   }

   public <T extends TextView> T searchFor(final Class<T> var1, String var2, int var3, long var4, boolean var6, final boolean var7) {
      if(var3 < 1) {
         var3 = 1;
      }

      Callable var8 = new Callable() {
         public Collection<T> call() throws Exception {
            Searcher.this.sleeper.sleep();
            ArrayList var1x = Searcher.this.viewFetcher.getCurrentViews(var1, true);
            if(var7) {
               var1x = RobotiumUtils.removeInvisibleViews(var1x);
            }

            if(var1.isAssignableFrom(TextView.class)) {
               var1x.addAll(Searcher.this.webUtils.getTextViewsFromWebView());
            }

            return var1x;
         }
      };
      int var9 = var3;

      try {
         TextView var11 = this.searchFor(var8, var2, var9, var4, var6);
         return var11;
      } catch (Exception var12) {
         throw new RuntimeException(var12);
      }
   }

   public <T extends TextView> T searchFor(Callable<Collection<T>> var1, String var2, int var3, long var4, boolean var6) throws Exception {
      long var7 = var4 + SystemClock.uptimeMillis();

      do {
         boolean var9;
         if(var4 > 0L && SystemClock.uptimeMillis() > var7) {
            var9 = true;
         } else {
            var9 = false;
         }

         if(var9) {
            this.logMatchesFound(var2);
            return null;
         }

         Iterator var10 = ((Collection)var1.call()).iterator();

         while(var10.hasNext()) {
            TextView var11 = (TextView)var10.next();
            if(RobotiumUtils.getNumberOfMatches(var2, var11, this.uniqueTextViews) == var3) {
               this.uniqueTextViews.clear();
               return var11;
            }
         }

         if(var6 && !this.scroller.scrollDown()) {
            this.logMatchesFound(var2);
            return null;
         }
      } while(var6);

      this.logMatchesFound(var2);
      return null;
   }

   public <T extends View> boolean searchFor(View var1) {
      Iterator var2 = this.viewFetcher.getAllViews(true).iterator();

      do {
         if(!var2.hasNext()) {
            return false;
         }
      } while(!((View)var2.next()).equals(var1));

      return true;
   }

   public <T extends View> boolean searchFor(Set<T> var1, Class<T> var2, int var3) {
      int var4 = this.getNumberOfUniqueViews(var1, RobotiumUtils.removeInvisibleViews(this.viewFetcher.getCurrentViews(var2, true)));
      return var4 > 0 && var3 < var4 || var4 > 0 && var3 == 0;
   }

   public WebElement searchForWebElement(class_0 var1, int var2) {
      if(var2 < 1) {
         var2 = 1;
      }

      ArrayList var3 = this.webUtils.getWebElements(var1, true);
      this.addViewsToList(this.webElements, var3);
      return this.getViewFromList(this.webElements, var2);
   }

   public boolean searchWithTimeoutFor(Class<? extends TextView> var1, String var2, int var3, boolean var4, boolean var5) {
      long var6 = 5000L + SystemClock.uptimeMillis();

      do {
         if(SystemClock.uptimeMillis() >= var6) {
            return false;
         }

         this.sleeper.sleep();
      } while(this.searchFor(var1, var2, var3, 0L, var4, var5) == null);

      return true;
   }
}
