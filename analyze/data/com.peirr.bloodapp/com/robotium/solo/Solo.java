package com.robotium.solo;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.graphics.PointF;
import android.os.Environment;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.Asserter;
import com.robotium.solo.By;
import com.robotium.solo.Checker;
import com.robotium.solo.Clicker;
import com.robotium.solo.Condition;
import com.robotium.solo.DialogUtils;
import com.robotium.solo.Getter;
import com.robotium.solo.Presser;
import com.robotium.solo.Rotator;
import com.robotium.solo.ScreenshotTaker;
import com.robotium.solo.Scroller;
import com.robotium.solo.Searcher;
import com.robotium.solo.Sender;
import com.robotium.solo.Setter;
import com.robotium.solo.Sleeper;
import com.robotium.solo.Swiper;
import com.robotium.solo.Tapper;
import com.robotium.solo.TextEnterer;
import com.robotium.solo.Timeout;
import com.robotium.solo.ViewFetcher;
import com.robotium.solo.Waiter;
import com.robotium.solo.WebElement;
import com.robotium.solo.WebUtils;
import com.robotium.solo.Zoomer;
import com.robotium.solo.class_0;
import java.util.ArrayList;
import junit.framework.Assert;

public class Solo {
   public static final int CLOSED = 0;
   public static final int DELETE = 67;
   public static final int DOWN = 20;
   public static final int ENTER = 66;
   public static final int LANDSCAPE = 0;
   public static final int LEFT = 21;
   public static final int MENU = 82;
   public static final int OPENED = 1;
   public static final int PORTRAIT = 1;
   public static final int RIGHT = 22;
   // $FF: renamed from: UP int
   public static final int field_2 = 19;
   protected final ActivityUtils activityUtils;
   protected final Asserter asserter;
   protected final Checker checker;
   protected final Clicker clicker;
   private final Solo.Config config;
   protected final DialogUtils dialogUtils;
   protected final Getter getter;
   protected final Instrumentation instrumentation;
   protected final Presser presser;
   protected final Rotator rotator;
   protected final ScreenshotTaker screenshotTaker;
   protected final Scroller scroller;
   protected final Searcher searcher;
   protected final Sender sender;
   protected final Setter setter;
   protected final Sleeper sleeper;
   protected final Swiper swiper;
   protected final Tapper tapper;
   protected final TextEnterer textEnterer;
   protected final ViewFetcher viewFetcher;
   protected final Waiter waiter;
   protected String webUrl;
   protected final WebUtils webUtils;
   protected final Zoomer zoomer;

   public Solo(Instrumentation var1) {
      this((Solo.Config)(new Solo.Config()), (Instrumentation)var1, (Activity)null);
   }

   public Solo(Instrumentation var1, Activity var2) {
      this(new Solo.Config(), var1, var2);
   }

   public Solo(Instrumentation var1, Solo.Config var2) {
      this((Solo.Config)var2, (Instrumentation)var1, (Activity)null);
   }

   public Solo(Instrumentation var1, Solo.Config var2, Activity var3) {
      this(var2, var1, var3);
   }

   private Solo(Solo.Config var1, Instrumentation var2, Activity var3) {
      this.webUrl = null;
      Solo.Config var4;
      if(var1 == null) {
         var4 = new Solo.Config();
      } else {
         var4 = var1;
      }

      this.config = var4;
      this.instrumentation = var2;
      this.sleeper = new Sleeper();
      this.sender = new Sender(var2, this.sleeper);
      this.activityUtils = new ActivityUtils(var2, var3, this.sleeper);
      this.viewFetcher = new ViewFetcher(this.activityUtils);
      this.screenshotTaker = new ScreenshotTaker(var1, this.activityUtils, this.viewFetcher, this.sleeper);
      this.dialogUtils = new DialogUtils(this.activityUtils, this.viewFetcher, this.sleeper);
      this.webUtils = new WebUtils(var1, var2, this.activityUtils, this.viewFetcher, this.sleeper);
      this.scroller = new Scroller(var1, var2, this.activityUtils, this.viewFetcher, this.sleeper);
      this.searcher = new Searcher(this.viewFetcher, this.webUtils, this.scroller, this.sleeper);
      this.waiter = new Waiter(this.activityUtils, this.viewFetcher, this.searcher, this.scroller, this.sleeper);
      this.getter = new Getter(var2, this.activityUtils, this.waiter);
      this.clicker = new Clicker(this.activityUtils, this.viewFetcher, this.sender, var2, this.sleeper, this.waiter, this.webUtils, this.dialogUtils);
      this.setter = new Setter(this.activityUtils, this.getter, this.clicker, this.waiter);
      this.asserter = new Asserter(this.activityUtils, this.waiter);
      this.checker = new Checker(this.viewFetcher, this.waiter);
      this.zoomer = new Zoomer(var2);
      this.swiper = new Swiper(var2);
      this.tapper = new Tapper(var2);
      this.rotator = new Rotator(var2);
      this.presser = new Presser(this.viewFetcher, this.clicker, var2, this.sleeper, this.waiter, this.dialogUtils);
      this.textEnterer = new TextEnterer(var2, this.clicker, this.dialogUtils);
      this.initialize();
   }

   private void initialize() {
      Timeout.setLargeTimeout(initializeTimeout("solo_large_timeout", this.config.timeout_large));
      Timeout.setSmallTimeout(initializeTimeout("solo_small_timeout", this.config.timeout_small));
   }

   private static int initializeTimeout(String var0, int var1) {
      try {
         int var3 = Integer.parseInt((String)Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class}).invoke((Object)null, new Object[]{var0}));
         return var3;
      } catch (Exception var4) {
         return var1;
      }
   }

   public void assertCurrentActivity(String var1, Class var2) {
      this.asserter.assertCurrentActivity(var1, var2);
   }

   public void assertCurrentActivity(String var1, Class var2, boolean var3) {
      this.asserter.assertCurrentActivity(var1, var2, var3);
   }

   public void assertCurrentActivity(String var1, String var2) {
      this.asserter.assertCurrentActivity(var1, var2);
   }

   public void assertCurrentActivity(String var1, String var2, boolean var3) {
      this.asserter.assertCurrentActivity(var1, var2, var3);
   }

   public void assertMemoryNotLow() {
      this.asserter.assertMemoryNotLow();
   }

   public void clearEditText(int var1) {
      this.textEnterer.setEditText((EditText)this.waiter.waitForAndGetView(var1, EditText.class), "");
   }

   public void clearEditText(EditText var1) {
      EditText var2 = (EditText)this.waiter.waitForView(var1, Timeout.getSmallTimeout());
      this.textEnterer.setEditText(var2, "");
   }

   public void clearLog() {
      this.waiter.clearLog();
   }

   public void clearTextInWebElement(class_0 var1) {
      this.webUtils.enterTextIntoWebElement(var1, "");
   }

   public ArrayList<TextView> clickInList(int var1) {
      return this.clicker.clickInList(var1);
   }

   public ArrayList<TextView> clickInList(int var1, int var2) {
      return this.clicker.clickInList(var1, var2, false, 0);
   }

   public ArrayList<TextView> clickLongInList(int var1) {
      return this.clicker.clickInList(var1, 0, true, 0);
   }

   public ArrayList<TextView> clickLongInList(int var1, int var2) {
      return this.clicker.clickInList(var1, var2, true, 0);
   }

   public ArrayList<TextView> clickLongInList(int var1, int var2, int var3) {
      return this.clicker.clickInList(var1, var2, true, var3);
   }

   public void clickLongOnScreen(float var1, float var2) {
      this.clicker.clickLongOnScreen(var1, var2, 0, (View)null);
   }

   public void clickLongOnScreen(float var1, float var2, int var3) {
      this.clicker.clickLongOnScreen(var1, var2, var3, (View)null);
   }

   public void clickLongOnText(String var1) {
      this.clicker.clickOnText(var1, true, 1, true, 0);
   }

   public void clickLongOnText(String var1, int var2) {
      this.clicker.clickOnText(var1, true, var2, true, 0);
   }

   public void clickLongOnText(String var1, int var2, int var3) {
      this.clicker.clickOnText(var1, true, var2, true, var3);
   }

   public void clickLongOnText(String var1, int var2, boolean var3) {
      this.clicker.clickOnText(var1, true, var2, var3, 0);
   }

   public void clickLongOnTextAndPress(String var1, int var2) {
      this.clicker.clickLongOnTextAndPress(var1, var2);
   }

   public void clickLongOnView(View var1) {
      View var2 = this.waiter.waitForView(var1, Timeout.getSmallTimeout());
      this.clicker.clickOnScreen(var2, true, 0);
   }

   public void clickLongOnView(View var1, int var2) {
      this.clicker.clickOnScreen(var1, true, var2);
   }

   public void clickOnActionBarHomeButton() {
      this.clicker.clickOnActionBarHomeButton();
   }

   public void clickOnActionBarItem(int var1) {
      this.clicker.clickOnActionBarItem(var1);
   }

   public void clickOnButton(int var1) {
      this.clicker.clickOn(Button.class, var1);
   }

   public void clickOnButton(String var1) {
      this.clicker.clickOn(Button.class, var1);
   }

   public void clickOnCheckBox(int var1) {
      this.clicker.clickOn(CheckBox.class, var1);
   }

   public void clickOnEditText(int var1) {
      this.clicker.clickOn(EditText.class, var1);
   }

   public void clickOnImage(int var1) {
      this.clicker.clickOn(ImageView.class, var1);
   }

   public void clickOnImageButton(int var1) {
      this.clicker.clickOn(ImageButton.class, var1);
   }

   public void clickOnMenuItem(String var1) {
      this.clicker.clickOnMenuItem(var1);
   }

   public void clickOnMenuItem(String var1, boolean var2) {
      this.clicker.clickOnMenuItem(var1, var2);
   }

   public void clickOnRadioButton(int var1) {
      this.clicker.clickOn(RadioButton.class, var1);
   }

   public void clickOnScreen(float var1, float var2) {
      this.sleeper.sleep();
      this.clicker.clickOnScreen(var1, var2, (View)null);
   }

   public void clickOnScreen(float var1, float var2, int var3) {
      if(VERSION.SDK_INT < 14) {
         throw new RuntimeException("clickOnScreen(float x, float y, int numberOfClicks) requires API level >= 14");
      } else {
         Tapper var4 = this.tapper;
         PointF[] var5 = new PointF[]{new PointF(var1, var2)};
         var4.generateTapGesture(var3, var5);
      }
   }

   public void clickOnText(String var1) {
      this.clicker.clickOnText(var1, false, 1, true, 0);
   }

   public void clickOnText(String var1, int var2) {
      this.clicker.clickOnText(var1, false, var2, true, 0);
   }

   public void clickOnText(String var1, int var2, boolean var3) {
      this.clicker.clickOnText(var1, false, var2, var3, 0);
   }

   public void clickOnToggleButton(String var1) {
      this.clicker.clickOn(ToggleButton.class, var1);
   }

   public void clickOnView(View var1) {
      View var2 = this.waiter.waitForView(var1, Timeout.getSmallTimeout());
      this.clicker.clickOnScreen(var2);
   }

   public void clickOnView(View var1, boolean var2) {
      if(var2) {
         this.clicker.clickOnScreen(var1);
      } else {
         View var3 = this.waiter.waitForView(var1, Timeout.getSmallTimeout());
         this.clicker.clickOnScreen(var3);
      }
   }

   public void clickOnWebElement(class_0 var1) {
      this.clickOnWebElement(var1, 0, true);
   }

   public void clickOnWebElement(class_0 var1, int var2) {
      this.clickOnWebElement(var1, var2, true);
   }

   public void clickOnWebElement(class_0 var1, int var2, boolean var3) {
      this.clicker.clickOnWebElement(var1, var2, var3, this.config.useJavaScriptToClickWebElements);
   }

   public void clickOnWebElement(WebElement var1) {
      if(var1 == null) {
         Assert.fail("WebElement is null and can therefore not be clicked!");
      }

      this.clicker.clickOnScreen((float)var1.getLocationX(), (float)var1.getLocationY(), (View)null);
   }

   public void drag(float var1, float var2, float var3, float var4, int var5) {
      this.dialogUtils.hideSoftKeyboard((EditText)null, false, true);
      this.scroller.drag(var1, var2, var3, var4, var5);
   }

   public void enterText(int var1, String var2) {
      this.textEnterer.setEditText((EditText)this.waiter.waitForAndGetView(var1, EditText.class), var2);
   }

   public void enterText(EditText var1, String var2) {
      EditText var3 = (EditText)this.waiter.waitForView(var1, Timeout.getSmallTimeout());
      this.textEnterer.setEditText(var3, var2);
   }

   public void enterTextInWebElement(class_0 var1, String var2) {
      if(this.waiter.waitForWebElement(var1, 0, Timeout.getSmallTimeout(), false) == null) {
         Assert.fail("WebElement with " + this.webUtils.splitNameByUpperCase(var1.getClass().getSimpleName()) + ": \'" + var1.getValue() + "\' is not found!");
      }

      this.webUtils.enterTextIntoWebElement(var1, var2);
   }

   public void finalize() throws Throwable {
      this.activityUtils.finalize();
   }

   public void finishOpenedActivities() {
      this.activityUtils.finishOpenedActivities();
   }

   public ActivityMonitor getActivityMonitor() {
      return this.activityUtils.getActivityMonitor();
   }

   public Button getButton(int var1) {
      return (Button)this.getter.getView(Button.class, var1);
   }

   public Button getButton(String var1) {
      return (Button)this.getter.getView(Button.class, var1, false);
   }

   public Button getButton(String var1, boolean var2) {
      return (Button)this.getter.getView(Button.class, var1, var2);
   }

   public Solo.Config getConfig() {
      return this.config;
   }

   public Activity getCurrentActivity() {
      return this.activityUtils.getCurrentActivity(false);
   }

   public ArrayList<View> getCurrentViews() {
      return this.viewFetcher.getViews((View)null, true);
   }

   public <T extends View> ArrayList<T> getCurrentViews(Class<T> var1) {
      return this.viewFetcher.getCurrentViews(var1, true);
   }

   public <T extends View> ArrayList<T> getCurrentViews(Class<T> var1, View var2) {
      return this.viewFetcher.getCurrentViews(var1, true, var2);
   }

   public <T extends View> ArrayList<T> getCurrentViews(Class<T> var1, boolean var2) {
      return this.viewFetcher.getCurrentViews(var1, var2);
   }

   public <T extends View> ArrayList<T> getCurrentViews(Class<T> var1, boolean var2, View var3) {
      return this.viewFetcher.getCurrentViews(var1, var2, var3);
   }

   public ArrayList<WebElement> getCurrentWebElements() {
      return this.webUtils.getWebElements(true);
   }

   public ArrayList<WebElement> getCurrentWebElements(By var1) {
      return this.webUtils.getWebElements(var1, true);
   }

   public EditText getEditText(int var1) {
      return (EditText)this.getter.getView(EditText.class, var1);
   }

   public EditText getEditText(String var1) {
      return (EditText)this.getter.getView(EditText.class, var1, false);
   }

   public EditText getEditText(String var1, boolean var2) {
      return (EditText)this.getter.getView(EditText.class, var1, var2);
   }

   public ImageView getImage(int var1) {
      return (ImageView)this.getter.getView(ImageView.class, var1);
   }

   public ImageButton getImageButton(int var1) {
      return (ImageButton)this.getter.getView(ImageButton.class, var1);
   }

   public String getString(int var1) {
      return this.getter.getString(var1);
   }

   public String getString(String var1) {
      return this.getter.getString(var1);
   }

   public TextView getText(int var1) {
      return (TextView)this.getter.getView(TextView.class, var1);
   }

   public TextView getText(String var1) {
      return this.getter.getView(TextView.class, var1, false);
   }

   public TextView getText(String var1, boolean var2) {
      return this.getter.getView(TextView.class, var1, var2);
   }

   public View getTopParent(View var1) {
      return this.viewFetcher.getTopParent(var1);
   }

   public View getView(int var1) {
      return this.getView(var1, 0);
   }

   public View getView(int var1, int var2) {
      View var3 = this.getter.getView(var1, var2);
      if(var3 == null) {
         int var4 = var2 + 1;
         if(var4 <= 1) {
            Assert.fail("View with id: \'" + var1 + "\' is not found!");
            return var3;
         }

         Assert.fail(var4 + " Views with id: \'" + var1 + "\' are not found!");
      }

      return var3;
   }

   public <T extends View> T getView(Class<T> var1, int var2) {
      return this.waiter.waitForAndGetView(var2, var1);
   }

   public View getView(String var1) {
      return this.getView((String)var1, 0);
   }

   public View getView(String var1, int var2) {
      View var3 = this.getter.getView(var1, var2);
      if(var3 == null) {
         int var4 = var2 + 1;
         if(var4 <= 1) {
            Assert.fail("View with id: \'" + var1 + "\' is not found!");
            return var3;
         }

         Assert.fail(var4 + " Views with id: \'" + var1 + "\' are not found!");
      }

      return var3;
   }

   public ArrayList<View> getViews() {
      try {
         ArrayList var2 = this.viewFetcher.getViews((View)null, false);
         return var2;
      } catch (Exception var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public ArrayList<View> getViews(View var1) {
      try {
         ArrayList var3 = this.viewFetcher.getViews(var1, false);
         return var3;
      } catch (Exception var4) {
         var4.printStackTrace();
         return null;
      }
   }

   public WebElement getWebElement(class_0 var1, int var2) {
      int var3 = var2 + 1;
      WebElement var4 = this.waiter.waitForWebElement(var1, var3, Timeout.getSmallTimeout(), true);
      if(var4 == null) {
         if(var3 <= 1) {
            Assert.fail("WebElement with " + this.webUtils.splitNameByUpperCase(var1.getClass().getSimpleName()) + ": \'" + var1.getValue() + "\' is not found!");
            return var4;
         }

         Assert.fail(var3 + " WebElements with " + this.webUtils.splitNameByUpperCase(var1.getClass().getSimpleName()) + ": \'" + var1.getValue() + "\' are not found!");
      }

      return var4;
   }

   public ArrayList<WebElement> getWebElements() {
      return this.webUtils.getWebElements(false);
   }

   public ArrayList<WebElement> getWebElements(By var1) {
      return this.webUtils.getWebElements(var1, false);
   }

   public String getWebUrl() {
      final WebView var1 = (WebView)this.waiter.waitForAndGetView(0, WebView.class);
      if(var1 == null) {
         Assert.fail("WebView is not found!");
      }

      this.instrumentation.runOnMainSync(new Runnable() {
         public void run() {
            Solo.this.webUrl = var1.getUrl();
         }
      });
      return this.webUrl;
   }

   public void goBack() {
      this.hideSoftKeyboard();
      this.sender.goBack();
   }

   public void goBackToActivity(String var1) {
      this.activityUtils.goBackToActivity(var1);
   }

   public void hideSoftKeyboard() {
      this.dialogUtils.hideSoftKeyboard((EditText)null, true, false);
   }

   public boolean isCheckBoxChecked(int var1) {
      return this.checker.isButtonChecked(CheckBox.class, var1);
   }

   public boolean isCheckBoxChecked(String var1) {
      return this.checker.isButtonChecked(CheckBox.class, var1);
   }

   public boolean isRadioButtonChecked(int var1) {
      return this.checker.isButtonChecked(RadioButton.class, var1);
   }

   public boolean isRadioButtonChecked(String var1) {
      return this.checker.isButtonChecked(RadioButton.class, var1);
   }

   public boolean isSpinnerTextSelected(int var1, String var2) {
      return this.checker.isSpinnerTextSelected(var1, var2);
   }

   public boolean isSpinnerTextSelected(String var1) {
      return this.checker.isSpinnerTextSelected(var1);
   }

   public boolean isTextChecked(String var1) {
      this.waiter.waitForViews(false, new Class[]{CheckedTextView.class, CompoundButton.class});
      return this.viewFetcher.getCurrentViews(CheckedTextView.class, true).size() > 0 && this.checker.isCheckedTextChecked(var1) || this.viewFetcher.getCurrentViews(CompoundButton.class, true).size() > 0 && this.checker.isButtonChecked(CompoundButton.class, var1);
   }

   public boolean isToggleButtonChecked(int var1) {
      return this.checker.isButtonChecked(ToggleButton.class, var1);
   }

   public boolean isToggleButtonChecked(String var1) {
      return this.checker.isButtonChecked(ToggleButton.class, var1);
   }

   public void pinchToZoom(PointF var1, PointF var2, PointF var3, PointF var4) {
      if(VERSION.SDK_INT < 14) {
         throw new RuntimeException("pinchToZoom() requires API level >= 14");
      } else {
         this.zoomer.generateZoomGesture(var1, var2, var3, var4);
      }
   }

   public void pressMenuItem(int var1) {
      this.presser.pressMenuItem(var1);
   }

   public void pressMenuItem(int var1, int var2) {
      this.presser.pressMenuItem(var1, var2);
   }

   public void pressSoftKeyboardNextButton() {
      this.presser.pressSoftKeyboardSearchOrNextButton(false);
   }

   public void pressSoftKeyboardSearchButton() {
      this.presser.pressSoftKeyboardSearchOrNextButton(true);
   }

   public void pressSpinnerItem(int var1, int var2) {
      this.presser.pressSpinnerItem(var1, var2);
   }

   public void rotateLarge(PointF var1, PointF var2) {
      if(VERSION.SDK_INT < 14) {
         throw new RuntimeException("rotateLarge(PointF center1, PointF center2) requires API level >= 14");
      } else {
         this.rotator.generateRotateGesture(0, var1, var2);
      }
   }

   public void rotateSmall(PointF var1, PointF var2) {
      if(VERSION.SDK_INT < 14) {
         throw new RuntimeException("rotateSmall(PointF center1, PointF center2) requires API level >= 14");
      } else {
         this.rotator.generateRotateGesture(1, var1, var2);
      }
   }

   public boolean scrollDown() {
      this.waiter.waitForViews(true, new Class[]{AbsListView.class, ScrollView.class, WebView.class});
      return this.scroller.scroll(0);
   }

   public boolean scrollDownList(int var1) {
      return this.scroller.scrollList((AbsListView)this.waiter.waitForAndGetView(var1, ListView.class), 0, false);
   }

   public boolean scrollDownList(AbsListView var1) {
      return this.scroller.scrollList(var1, 0, false);
   }

   public boolean scrollListToBottom(int var1) {
      return this.scroller.scrollList((AbsListView)this.waiter.waitForAndGetView(var1, ListView.class), 0, true);
   }

   public boolean scrollListToBottom(AbsListView var1) {
      return this.scroller.scrollList(var1, 0, true);
   }

   public void scrollListToLine(int var1, int var2) {
      this.scroller.scrollListToLine((AbsListView)this.waiter.waitForAndGetView(var1, AbsListView.class), var2);
   }

   public void scrollListToLine(AbsListView var1, int var2) {
      this.scroller.scrollListToLine(var1, var2);
   }

   public boolean scrollListToTop(int var1) {
      return this.scroller.scrollList((AbsListView)this.waiter.waitForAndGetView(var1, ListView.class), 1, true);
   }

   public boolean scrollListToTop(AbsListView var1) {
      return this.scroller.scrollList(var1, 1, true);
   }

   public void scrollToBottom() {
      this.waiter.waitForViews(true, new Class[]{AbsListView.class, ScrollView.class, WebView.class});
      this.scroller.scroll(0, true);
   }

   public void scrollToSide(int var1) {
      this.scrollToSide(var1, 0.75F);
   }

   public void scrollToSide(int var1, float var2) {
      this.scrollToSide(var1, var2, 20);
   }

   public void scrollToSide(int var1, float var2, int var3) {
      switch(var1) {
      case 21:
         this.scroller.scrollToSide(Scroller.Side.LEFT, var2, var3);
         return;
      case 22:
         this.scroller.scrollToSide(Scroller.Side.RIGHT, var2, var3);
         return;
      default:
      }
   }

   public void scrollToTop() {
      this.waiter.waitForViews(true, new Class[]{AbsListView.class, ScrollView.class, WebView.class});
      this.scroller.scroll(1, true);
   }

   public boolean scrollUp() {
      this.waiter.waitForViews(true, new Class[]{AbsListView.class, ScrollView.class, WebView.class});
      return this.scroller.scroll(1);
   }

   public boolean scrollUpList(int var1) {
      return this.scroller.scrollList((AbsListView)this.waiter.waitForAndGetView(var1, ListView.class), 1, false);
   }

   public boolean scrollUpList(AbsListView var1) {
      return this.scroller.scrollList(var1, 1, false);
   }

   public void scrollViewToSide(View var1, int var2) {
      this.scrollViewToSide(var1, var2, 0.7F);
   }

   public void scrollViewToSide(View var1, int var2, float var3) {
      this.scrollViewToSide(var1, var2, var3, 20);
   }

   public void scrollViewToSide(View var1, int var2, float var3, int var4) {
      this.waitForView(var1);
      this.sleeper.sleep();
      switch(var2) {
      case 21:
         this.scroller.scrollViewToSide(var1, Scroller.Side.LEFT, var3, var4);
         return;
      case 22:
         this.scroller.scrollViewToSide(var1, Scroller.Side.RIGHT, var3, var4);
         return;
      default:
      }
   }

   public boolean searchButton(String var1) {
      return this.searcher.searchWithTimeoutFor(Button.class, var1, 0, true, false);
   }

   public boolean searchButton(String var1, int var2) {
      return this.searcher.searchWithTimeoutFor(Button.class, var1, var2, true, false);
   }

   public boolean searchButton(String var1, int var2, boolean var3) {
      return this.searcher.searchWithTimeoutFor(Button.class, var1, var2, true, var3);
   }

   public boolean searchButton(String var1, boolean var2) {
      return this.searcher.searchWithTimeoutFor(Button.class, var1, 0, true, var2);
   }

   public boolean searchEditText(String var1) {
      return this.searcher.searchWithTimeoutFor(EditText.class, var1, 1, true, false);
   }

   public boolean searchText(String var1) {
      return this.searcher.searchWithTimeoutFor(TextView.class, var1, 0, true, false);
   }

   public boolean searchText(String var1, int var2) {
      return this.searcher.searchWithTimeoutFor(TextView.class, var1, var2, true, false);
   }

   public boolean searchText(String var1, int var2, boolean var3) {
      return this.searcher.searchWithTimeoutFor(TextView.class, var1, var2, var3, false);
   }

   public boolean searchText(String var1, int var2, boolean var3, boolean var4) {
      return this.searcher.searchWithTimeoutFor(TextView.class, var1, var2, var3, var4);
   }

   public boolean searchText(String var1, boolean var2) {
      return this.searcher.searchWithTimeoutFor(TextView.class, var1, 0, true, var2);
   }

   public boolean searchToggleButton(String var1) {
      return this.searcher.searchWithTimeoutFor(ToggleButton.class, var1, 0, true, false);
   }

   public boolean searchToggleButton(String var1, int var2) {
      return this.searcher.searchWithTimeoutFor(ToggleButton.class, var1, var2, true, false);
   }

   public void sendKey(int var1) {
      this.sender.sendKeyCode(var1);
   }

   public void setActivityOrientation(int var1) {
      this.activityUtils.setActivityOrientation(var1);
   }

   public void setDatePicker(int var1, int var2, int var3, int var4) {
      this.setDatePicker((DatePicker)this.waiter.waitForAndGetView(var1, DatePicker.class), var2, var3, var4);
   }

   public void setDatePicker(DatePicker var1, int var2, int var3, int var4) {
      DatePicker var5 = (DatePicker)this.waiter.waitForView(var1, Timeout.getSmallTimeout());
      this.setter.setDatePicker(var5, var2, var3, var4);
   }

   public void setNavigationDrawer(int var1) {
      this.setter.setNavigationDrawer(var1);
   }

   public void setProgressBar(int var1, int var2) {
      this.setProgressBar((ProgressBar)this.waiter.waitForAndGetView(var1, ProgressBar.class), var2);
   }

   public void setProgressBar(ProgressBar var1, int var2) {
      ProgressBar var3 = (ProgressBar)this.waiter.waitForView(var1, Timeout.getSmallTimeout());
      this.setter.setProgressBar(var3, var2);
   }

   public void setSlidingDrawer(int var1, int var2) {
      this.setSlidingDrawer((SlidingDrawer)this.waiter.waitForAndGetView(var1, SlidingDrawer.class), var2);
   }

   public void setSlidingDrawer(SlidingDrawer var1, int var2) {
      SlidingDrawer var3 = (SlidingDrawer)this.waiter.waitForView(var1, Timeout.getSmallTimeout());
      this.setter.setSlidingDrawer(var3, var2);
   }

   public void setTimePicker(int var1, int var2, int var3) {
      this.setTimePicker((TimePicker)this.waiter.waitForAndGetView(var1, TimePicker.class), var2, var3);
   }

   public void setTimePicker(TimePicker var1, int var2, int var3) {
      TimePicker var4 = (TimePicker)this.waiter.waitForView(var1, Timeout.getSmallTimeout());
      this.setter.setTimePicker(var4, var2, var3);
   }

   public void sleep(int var1) {
      this.sleeper.sleep(var1);
   }

   public void startScreenshotSequence(String var1) {
      this.startScreenshotSequence(var1, 80, 400, 100);
   }

   public void startScreenshotSequence(String var1, int var2, int var3, int var4) {
      this.screenshotTaker.startScreenshotSequence(var1, var2, var3, var4);
   }

   public void stopScreenshotSequence() {
      this.screenshotTaker.stopScreenshotSequence();
   }

   public void swipe(PointF var1, PointF var2, PointF var3, PointF var4) {
      if(VERSION.SDK_INT < 14) {
         throw new RuntimeException("swipe() requires API level >= 14");
      } else {
         this.swiper.generateSwipeGesture(var1, var2, var3, var4);
      }
   }

   public void takeScreenshot() {
      this.takeScreenshot((String)null);
   }

   public void takeScreenshot(String var1) {
      this.takeScreenshot(var1, 100);
   }

   public void takeScreenshot(String var1, int var2) {
      this.screenshotTaker.takeScreenshot(var1, var2);
   }

   public void typeText(int var1, String var2) {
      this.textEnterer.typeText((EditText)this.waiter.waitForAndGetView(var1, EditText.class), var2);
   }

   public void typeText(EditText var1, String var2) {
      EditText var3 = (EditText)this.waiter.waitForView(var1, Timeout.getSmallTimeout());
      this.textEnterer.typeText(var3, var2);
   }

   public void typeTextInWebElement(class_0 var1, String var2) {
      this.typeTextInWebElement(var1, var2, 0);
   }

   public void typeTextInWebElement(class_0 var1, String var2, int var3) {
      this.clicker.clickOnWebElement(var1, var3, true, false);
      this.dialogUtils.hideSoftKeyboard((EditText)null, true, true);
      this.instrumentation.sendStringSync(var2);
   }

   public void typeTextInWebElement(WebElement var1, String var2) {
      this.clickOnWebElement(var1);
      this.dialogUtils.hideSoftKeyboard((EditText)null, true, true);
      this.instrumentation.sendStringSync(var2);
   }

   public void unlockScreen() {
      this.instrumentation.runOnMainSync(new Runnable() {
         public void run() {
            Solo.this.activityUtils.getCurrentActivity(false).getWindow().addFlags(4194304);
         }
      });
   }

   public boolean waitForActivity(Class<? extends Activity> var1) {
      return this.waiter.waitForActivity(var1, Timeout.getLargeTimeout());
   }

   public boolean waitForActivity(Class<? extends Activity> var1, int var2) {
      return this.waiter.waitForActivity(var1, var2);
   }

   public boolean waitForActivity(String var1) {
      return this.waiter.waitForActivity(var1, Timeout.getLargeTimeout());
   }

   public boolean waitForActivity(String var1, int var2) {
      return this.waiter.waitForActivity(var1, var2);
   }

   public boolean waitForCondition(Condition var1, int var2) {
      return this.waiter.waitForCondition(var1, var2);
   }

   public boolean waitForDialogToClose() {
      return this.dialogUtils.waitForDialogToClose((long)Timeout.getLargeTimeout());
   }

   public boolean waitForDialogToClose(long var1) {
      return this.dialogUtils.waitForDialogToClose(var1);
   }

   public boolean waitForDialogToOpen() {
      return this.dialogUtils.waitForDialogToOpen((long)Timeout.getLargeTimeout(), true);
   }

   public boolean waitForDialogToOpen(long var1) {
      return this.dialogUtils.waitForDialogToOpen(var1, true);
   }

   public boolean waitForEmptyActivityStack(int var1) {
      return this.waiter.waitForCondition(new Condition() {
         public boolean isSatisfied() {
            return Solo.this.activityUtils.isActivityStackEmpty();
         }
      }, var1);
   }

   public boolean waitForFragmentById(int var1) {
      return this.waiter.waitForFragment((String)null, var1, Timeout.getLargeTimeout());
   }

   public boolean waitForFragmentById(int var1, int var2) {
      return this.waiter.waitForFragment((String)null, var1, var2);
   }

   public boolean waitForFragmentByTag(String var1) {
      return this.waiter.waitForFragment(var1, 0, Timeout.getLargeTimeout());
   }

   public boolean waitForFragmentByTag(String var1, int var2) {
      return this.waiter.waitForFragment(var1, 0, var2);
   }

   public boolean waitForLogMessage(String var1) {
      return this.waiter.waitForLogMessage(var1, Timeout.getLargeTimeout());
   }

   public boolean waitForLogMessage(String var1, int var2) {
      return this.waiter.waitForLogMessage(var1, var2);
   }

   public boolean waitForText(String var1) {
      return this.waiter.waitForText(var1) != null;
   }

   public boolean waitForText(String var1, int var2, long var3) {
      return this.waiter.waitForText(var1, var2, var3) != null;
   }

   public boolean waitForText(String var1, int var2, long var3, boolean var5) {
      return this.waiter.waitForText(var1, var2, var3, var5) != null;
   }

   public boolean waitForText(String var1, int var2, long var3, boolean var5, boolean var6) {
      return this.waiter.waitForText(var1, var2, var3, var5, var6, true) != null;
   }

   public boolean waitForView(int var1) {
      return this.waitForView(var1, 0, Timeout.getLargeTimeout(), true);
   }

   public boolean waitForView(int var1, int var2, int var3) {
      return this.waitForView(var1, var2, var3, true);
   }

   public boolean waitForView(int var1, int var2, int var3, boolean var4) {
      int var5 = var2 - 1;
      if(var5 < 1) {
         var5 = 0;
      }

      return this.waiter.waitForView(var1, var5, var3, var4) != null;
   }

   public <T extends View> boolean waitForView(View var1) {
      return this.waiter.waitForView(var1);
   }

   public <T extends View> boolean waitForView(View var1, int var2, boolean var3) {
      boolean var4 = false;
      if(!var3) {
         var4 = true;
      }

      return this.waiter.waitForView(var1, var2, var3, var4) != null;
   }

   public <T extends View> boolean waitForView(Class<T> var1) {
      return this.waiter.waitForView(var1, 0, Timeout.getLargeTimeout(), true);
   }

   public <T extends View> boolean waitForView(Class<T> var1, int var2, int var3) {
      int var4 = var2 - 1;
      if(var4 < 1) {
         var4 = 0;
      }

      return this.waiter.waitForView(var1, var4, var3, true);
   }

   public <T extends View> boolean waitForView(Class<T> var1, int var2, int var3, boolean var4) {
      int var5 = var2 - 1;
      if(var5 < 1) {
         var5 = 0;
      }

      return this.waiter.waitForView(var1, var5, var3, var4);
   }

   public boolean waitForWebElement(class_0 var1) {
      return this.waiter.waitForWebElement(var1, 0, Timeout.getLargeTimeout(), true) != null;
   }

   public boolean waitForWebElement(class_0 var1, int var2, int var3, boolean var4) {
      return this.waiter.waitForWebElement(var1, var2, var3, var4) != null;
   }

   public boolean waitForWebElement(class_0 var1, int var2, boolean var3) {
      WebElement var4 = this.waiter.waitForWebElement(var1, 0, var2, var3);
      boolean var5 = false;
      if(var4 != null) {
         var5 = true;
      }

      return var5;
   }

   public static class Config {
      public Solo.ScreenshotFileType screenshotFileType;
      public String screenshotSavePath = Environment.getExternalStorageDirectory() + "/Robotium-Screenshots/";
      public boolean shouldScroll;
      public int timeout_large = 20000;
      public int timeout_small = 10000;
      public boolean useJavaScriptToClickWebElements;

      public Config() {
         this.screenshotFileType = Solo.ScreenshotFileType.JPEG;
         this.shouldScroll = true;
         this.useJavaScriptToClickWebElements = false;
      }
   }

   public static enum ScreenshotFileType {
      JPEG,
      PNG;

      static {
         Solo.ScreenshotFileType[] var0 = new Solo.ScreenshotFileType[]{JPEG, PNG};
      }
   }
}
