package com.robotium.solo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Bitmap.Config;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.GLRenderWrapper;
import com.robotium.solo.Reflect;
import com.robotium.solo.Sleeper;
import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;
import com.robotium.solo.ViewFetcher;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class ScreenshotTaker {
   private static final long TIMEOUT_SCREENSHOT_MUTEX;
   private final String LOG_TAG = "Robotium";
   private final ActivityUtils activityUtils;
   private final Solo.Config config;
   private ScreenshotTaker.ScreenShotSaver screenShotSaver = null;
   private HandlerThread screenShotSaverThread = null;
   private final Object screenshotMutex = new Object();
   private ScreenshotTaker.ScreenshotSequenceThread screenshotSequenceThread = null;
   private final Sleeper sleeper;
   private final ViewFetcher viewFetcher;

   static {
      TIMEOUT_SCREENSHOT_MUTEX = TimeUnit.SECONDS.toMillis(2L);
   }

   ScreenshotTaker(Solo.Config var1, ActivityUtils var2, ViewFetcher var3, Sleeper var4) {
      this.config = var1;
      this.activityUtils = var2;
      this.viewFetcher = var3;
      this.sleeper = var4;
   }

   // $FF: synthetic method
   static Bitmap access$300(ScreenshotTaker var0, WebView var1) {
      return var0.getBitmapOfWebView(var1);
   }

   // $FF: synthetic method
   static Bitmap access$400(ScreenshotTaker var0, View var1) {
      return var0.getBitmapOfView(var1);
   }

   // $FF: synthetic method
   static ScreenshotTaker.ScreenShotSaver access$500(ScreenshotTaker var0) {
      return var0.screenShotSaver;
   }

   // $FF: synthetic method
   static Object access$600(ScreenshotTaker var0) {
      return var0.screenshotMutex;
   }

   // $FF: synthetic method
   static String access$700(ScreenshotTaker var0, String var1) {
      return var0.getFileName(var1);
   }

   // $FF: synthetic method
   static Solo.Config access$800(ScreenshotTaker var0) {
      return var0.config;
   }

   private Bitmap getBitmapOfView(View var1) {
      var1.destroyDrawingCache();
      var1.buildDrawingCache(false);
      Bitmap var2 = var1.getDrawingCache();
      if(var2 == null) {
         return null;
      } else {
         Config var3 = var2.getConfig();
         if(var3 == null) {
            var3 = Config.ARGB_8888;
         }

         Bitmap var4 = var2.copy(var3, false);
         var2.recycle();
         var1.destroyDrawingCache();
         return var4;
      }
   }

   private Bitmap getBitmapOfWebView(WebView var1) {
      Picture var2 = var1.capturePicture();
      Bitmap var3 = Bitmap.createBitmap(var2.getWidth(), var2.getHeight(), Config.ARGB_8888);
      var2.draw(new Canvas(var3));
      return var3;
   }

   private String getFileName(String var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("ddMMyy-hhmmss");
      return var1 == null?(this.config.screenshotFileType == Solo.ScreenshotFileType.JPEG?var2.format(new Date()).toString() + ".jpg":var2.format(new Date()).toString() + ".png"):(this.config.screenshotFileType == Solo.ScreenshotFileType.JPEG?var1 + ".jpg":var1 + ".png");
   }

   private View getScreenshotView() {
      View var1 = this.viewFetcher.getRecentDecorView(this.viewFetcher.getWindowDecorViews());

      for(long var2 = SystemClock.uptimeMillis() + (long)Timeout.getSmallTimeout(); var1 == null; var1 = this.viewFetcher.getRecentDecorView(this.viewFetcher.getWindowDecorViews())) {
         boolean var4;
         if(SystemClock.uptimeMillis() > var2) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(var4) {
            return null;
         }

         this.sleeper.sleepMini();
      }

      this.wrapAllGLViews(var1);
      return var1;
   }

   private void initScreenShotSaver() {
      if(this.screenShotSaverThread == null || this.screenShotSaver == null) {
         this.screenShotSaverThread = new HandlerThread("ScreenShotSaver");
         this.screenShotSaverThread.start();
         this.screenShotSaver = new ScreenshotTaker.ScreenShotSaver(this.screenShotSaverThread);
      }

   }

   private void wrapAllGLViews(View var1) {
      ArrayList var2 = this.viewFetcher.getCurrentViews(GLSurfaceView.class, true, var1);
      CountDownLatch var3 = new CountDownLatch(var2.size());
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         GLSurfaceView var6 = (GLSurfaceView)var4.next();
         Object var7 = (new Reflect(var6)).field("mGLThread").type(GLSurfaceView.class).out(Object.class);
         Renderer var8 = (Renderer)(new Reflect(var7)).field("mRenderer").out(Renderer.class);
         if(var8 == null) {
            var8 = (Renderer)(new Reflect(var6)).field("mRenderer").out(Renderer.class);
            var7 = var6;
         }

         if(var8 == null) {
            var3.countDown();
         } else if(var8 instanceof GLRenderWrapper) {
            GLRenderWrapper var10 = (GLRenderWrapper)var8;
            var10.setTakeScreenshot();
            var10.setLatch(var3);
         } else {
            GLRenderWrapper var9 = new GLRenderWrapper(var6, var8, var3);
            (new Reflect(var7)).field("mRenderer").method_6(var9);
         }
      }

      try {
         var3.await();
      } catch (InterruptedException var11) {
         var11.printStackTrace();
      }
   }

   public void startScreenshotSequence(String var1, int var2, int var3, int var4) {
      this.initScreenShotSaver();
      if(this.screenshotSequenceThread != null) {
         throw new RuntimeException("only one screenshot sequence is supported at a time");
      } else {
         this.screenshotSequenceThread = new ScreenshotTaker.ScreenshotSequenceThread(var1, var2, var3, var4);
         this.screenshotSequenceThread.start();
      }
   }

   public void stopScreenshotSequence() {
      if(this.screenshotSequenceThread != null) {
         this.screenshotSequenceThread.interrupt();
         this.screenshotSequenceThread = null;
      }

   }

   public void takeScreenshot(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private class ScreenShotSaver extends Handler {
      public ScreenShotSaver(HandlerThread var2) {
         super(var2.getLooper());
      }

      private void saveFile(String param1, Bitmap param2, int param3) {
         // $FF: Couldn't be decompiled
      }

      public void handleMessage(Message param1) {
         // $FF: Couldn't be decompiled
      }

      public void saveBitmap(Bitmap var1, String var2, int var3) {
         Message var4 = this.obtainMessage();
         var4.arg1 = var3;
         var4.obj = var1;
         var4.getData().putString("name", var2);
         this.sendMessage(var4);
      }
   }

   private class ScreenshotRunnable implements Runnable {
      private String name;
      private int quality;
      private View view;

      public ScreenshotRunnable(View var2, String var3, int var4) {
         this.view = var2;
         this.name = var3;
         this.quality = var4;
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }

   private class ScreenshotSequenceThread extends Thread {
      private int frameDelay;
      private boolean keepRunning = true;
      private int maxFrames;
      private String name;
      private int quality;
      private int seqno = 0;

      public ScreenshotSequenceThread(String var2, int var3, int var4, int var5) {
         this.name = var2;
         this.quality = var3;
         this.frameDelay = var4;
         this.maxFrames = var5;
      }

      public void doScreenshot() {
         View var1 = ScreenshotTaker.this.getScreenshotView();
         if(var1 == null) {
            this.keepRunning = false;
         }

         String var2 = this.name + "_" + this.seqno;
         ScreenshotTaker.ScreenshotRunnable var3 = ScreenshotTaker.this.new ScreenshotRunnable(var1, var2, this.quality);
         Log.d("Robotium", "taking screenshot " + var2);
         ScreenshotTaker.this.activityUtils.getCurrentActivity(false).runOnUiThread(var3);
      }

      public void interrupt() {
         this.keepRunning = false;
         super.interrupt();
      }

      public void run() {
         while(this.seqno < this.maxFrames && this.keepRunning && !Thread.interrupted()) {
            this.doScreenshot();
            ++this.seqno;

            try {
               Thread.sleep((long)this.frameDelay);
            } catch (InterruptedException var3) {
               ;
            }
         }

         ScreenshotTaker.this.screenshotSequenceThread = null;
      }
   }
}
