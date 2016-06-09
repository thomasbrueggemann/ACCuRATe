package com.robotium.solo;

import android.app.Instrumentation;
import android.os.Build.VERSION;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.By;
import com.robotium.solo.Reflect;
import com.robotium.solo.RobotiumTextView;
import com.robotium.solo.RobotiumWebClient;
import com.robotium.solo.Sleeper;
import com.robotium.solo.Solo;
import com.robotium.solo.ViewFetcher;
import com.robotium.solo.WebElement;
import com.robotium.solo.WebElementCreator;
import com.robotium.solo.class_0;
import java.util.ArrayList;
import java.util.Iterator;

class WebUtils {
   private ActivityUtils activityUtils;
   private Solo.Config config;
   private Instrumentation inst;
   WebChromeClient originalWebChromeClient = null;
   RobotiumWebClient robotiumWebCLient;
   private ViewFetcher viewFetcher;
   WebElementCreator webElementCreator;

   public WebUtils(Solo.Config var1, Instrumentation var2, ActivityUtils var3, ViewFetcher var4, Sleeper var5) {
      this.config = var1;
      this.inst = var2;
      this.activityUtils = var3;
      this.viewFetcher = var4;
      this.webElementCreator = new WebElementCreator(var5);
      this.robotiumWebCLient = new RobotiumWebClient(var2, this.webElementCreator);
   }

   private ArrayList<TextView> createAndReturnTextViewsFromWebElements(boolean var1) {
      ArrayList var2 = new ArrayList();
      if(var1) {
         Iterator var3 = this.webElementCreator.getWebElementsFromWebViews().iterator();

         while(var3.hasNext()) {
            WebElement var4 = (WebElement)var3.next();
            if(this.isWebElementSufficientlyShown(var4)) {
               var2.add(new RobotiumTextView(this.inst.getContext(), var4.getText(), var4.getLocationX(), var4.getLocationY()));
            }
         }
      }

      return var2;
   }

   private boolean executeJavaScriptFunction(final String var1) {
      final WebView var2 = (WebView)this.viewFetcher.getFreshestView(this.viewFetcher.getCurrentViews(WebView.class, true));
      if(var2 == null) {
         return false;
      } else {
         final String var3 = this.prepareForStartOfJavascriptExecution();
         this.activityUtils.getCurrentActivity(false).runOnUiThread(new Runnable() {
            public void run() {
               if(var2 != null) {
                  var2.loadUrl("javascript:" + var3 + var1);
               }

            }
         });
         return true;
      }
   }

   private WebChromeClient getCurrentWebChromeClient() {
      Object var1 = this.viewFetcher.getFreshestView(this.viewFetcher.getCurrentViews(WebView.class, true));
      if(VERSION.SDK_INT >= 16) {
         label22: {
            Object var5;
            try {
               var5 = (new Reflect(var1)).field("mProvider").out(Object.class);
            } catch (IllegalArgumentException var7) {
               break label22;
            }

            var1 = var5;
         }
      }

      try {
         if(VERSION.SDK_INT >= 19) {
            return (WebChromeClient)(new Reflect((new Reflect(var1)).field("mContentsClientAdapter").out(Object.class))).field("mWebChromeClient").out(WebChromeClient.class);
         } else {
            WebChromeClient var3 = (WebChromeClient)(new Reflect((new Reflect(var1)).field("mCallbackProxy").out(Object.class))).field("mWebChromeClient").out(WebChromeClient.class);
            return var3;
         }
      } catch (Exception var6) {
         return null;
      }
   }

   private String getJavaScriptAsString() {
      // $FF: Couldn't be decompiled
   }

   private ArrayList<WebElement> getWebElements(boolean var1, boolean var2) {
      ArrayList var3 = new ArrayList();
      if(var1) {
         Iterator var4 = this.webElementCreator.getWebElementsFromWebViews().iterator();

         while(var4.hasNext()) {
            WebElement var5 = (WebElement)var4.next();
            if(!var2) {
               var3.add(var5);
            } else if(this.isWebElementSufficientlyShown(var5)) {
               var3.add(var5);
            }
         }
      }

      return var3;
   }

   private String prepareForStartOfJavascriptExecution() {
      this.webElementCreator.prepareForStart();
      WebChromeClient var1 = this.getCurrentWebChromeClient();
      if(var1 != null && !var1.getClass().isAssignableFrom(RobotiumWebClient.class)) {
         this.originalWebChromeClient = this.getCurrentWebChromeClient();
      }

      this.robotiumWebCLient.enableJavascriptAndSetRobotiumWebClient(this.viewFetcher.getCurrentViews(WebView.class, true), this.originalWebChromeClient);
      return this.getJavaScriptAsString();
   }

   public void enterTextIntoWebElement(class_0 var1, String var2) {
      if(var1 instanceof class_0.class_2) {
         this.executeJavaScriptFunction("enterTextById(\"" + var1.getValue() + "\", \"" + var2 + "\");");
      } else {
         if(var1 instanceof class_0.Xpath) {
            this.executeJavaScriptFunction("enterTextByXpath(\"" + var1.getValue() + "\", \"" + var2 + "\");");
            return;
         }

         if(var1 instanceof class_0.CssSelector) {
            this.executeJavaScriptFunction("enterTextByCssSelector(\"" + var1.getValue() + "\", \"" + var2 + "\");");
            return;
         }

         if(var1 instanceof class_0.Name) {
            this.executeJavaScriptFunction("enterTextByName(\"" + var1.getValue() + "\", \"" + var2 + "\");");
            return;
         }

         if(var1 instanceof class_0.ClassName) {
            this.executeJavaScriptFunction("enterTextByClassName(\"" + var1.getValue() + "\", \"" + var2 + "\");");
            return;
         }

         if(var1 instanceof class_0.Text) {
            this.executeJavaScriptFunction("enterTextByTextContent(\"" + var1.getValue() + "\", \"" + var2 + "\");");
            return;
         }

         if(var1 instanceof class_0.TagName) {
            this.executeJavaScriptFunction("enterTextByTagName(\"" + var1.getValue() + "\", \"" + var2 + "\");");
            return;
         }
      }

   }

   public boolean executeJavaScript(class_0 var1, boolean var2) {
      return var1 instanceof class_0.class_2?this.executeJavaScriptFunction("id(\"" + var1.getValue() + "\", \"" + var2 + "\");"):(var1 instanceof class_0.Xpath?this.executeJavaScriptFunction("xpath(\"" + var1.getValue() + "\", \"" + var2 + "\");"):(var1 instanceof class_0.CssSelector?this.executeJavaScriptFunction("cssSelector(\"" + var1.getValue() + "\", \"" + var2 + "\");"):(var1 instanceof class_0.Name?this.executeJavaScriptFunction("name(\"" + var1.getValue() + "\", \"" + var2 + "\");"):(var1 instanceof class_0.ClassName?this.executeJavaScriptFunction("className(\"" + var1.getValue() + "\", \"" + var2 + "\");"):(var1 instanceof class_0.Text?this.executeJavaScriptFunction("textContent(\"" + var1.getValue() + "\", \"" + var2 + "\");"):(var1 instanceof class_0.TagName?this.executeJavaScriptFunction("tagName(\"" + var1.getValue() + "\", \"" + var2 + "\");"):false))))));
   }

   public ArrayList<TextView> getTextViewsFromWebView() {
      return this.createAndReturnTextViewsFromWebElements(this.executeJavaScriptFunction("allTexts();"));
   }

   public ArrayList<WebElement> getWebElements(By var1, boolean var2) {
      boolean var3 = this.executeJavaScript(var1, false);
      return this.config.useJavaScriptToClickWebElements?(!var3?new ArrayList():this.webElementCreator.getWebElementsFromWebViews()):this.getWebElements(var3, var2);
   }

   public ArrayList<WebElement> getWebElements(boolean var1) {
      return this.getWebElements(this.executeJavaScriptFunction("allWebElements();"), var1);
   }

   public final boolean isWebElementSufficientlyShown(WebElement var1) {
      WebView var2 = (WebView)this.viewFetcher.getFreshestView(this.viewFetcher.getCurrentViews(WebView.class, true));
      int[] var3 = new int[2];
      if(var2 != null && var1 != null) {
         var2.getLocationOnScreen(var3);
         if(var3[1] + var2.getHeight() > var1.getLocationY()) {
            return true;
         }
      }

      return false;
   }

   public String splitNameByUpperCase(String var1) {
      String[] var2 = var1.split("(?=\\p{Upper})");
      StringBuilder var3 = new StringBuilder();
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var2[var5];
         if(var3.length() > 0) {
            var3.append(" " + var6.toLowerCase());
         } else {
            var3.append(var6.toLowerCase());
         }
      }

      return var3.toString();
   }
}
