package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.internal.ck;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.ey;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ck
public final class class_406 extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
   // $FF: renamed from: lL com.google.android.gms.internal.ey
   private final class_369 field_1791;
   // $FF: renamed from: oG android.widget.MediaController
   private final MediaController field_1792;
   // $FF: renamed from: oH com.google.android.gms.internal.ck$a
   private final class_406.class_987 field_1793;
   // $FF: renamed from: oI android.widget.VideoView
   private final VideoView field_1794;
   // $FF: renamed from: oJ long
   private long field_1795;
   // $FF: renamed from: oK java.lang.String
   private String field_1796;

   public class_406(Context var1, class_369 var2) {
      super(var1);
      this.field_1791 = var2;
      this.field_1794 = new VideoView(var1);
      LayoutParams var3 = new LayoutParams(-1, -1, 17);
      this.addView(this.field_1794, var3);
      this.field_1792 = new MediaController(var1);
      this.field_1793 = new class_406.class_987(this);
      this.field_1793.method_3322();
      this.field_1794.setOnCompletionListener(this);
      this.field_1794.setOnPreparedListener(this);
      this.field_1794.setOnErrorListener(this);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ey, java.lang.String) void
   private static void method_2494(class_369 var0, String var1) {
      method_2497(var0, var1, new HashMap(1));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ey, java.lang.String, java.lang.String) void
   public static void method_2495(class_369 var0, String var1, String var2) {
      boolean var3;
      if(var2 == null) {
         var3 = true;
      } else {
         var3 = false;
      }

      byte var4;
      if(var3) {
         var4 = 2;
      } else {
         var4 = 3;
      }

      HashMap var5 = new HashMap(var4);
      var5.put("what", var1);
      if(!var3) {
         var5.put("extra", var2);
      }

      method_2497(var0, "error", var5);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ey, java.lang.String, java.lang.String, java.lang.String) void
   private static void method_2496(class_369 var0, String var1, String var2, String var3) {
      HashMap var4 = new HashMap(2);
      var4.put(var2, var3);
      method_2497(var0, var1, var4);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ey, java.lang.String, java.util.Map) void
   private static void method_2497(ey var0, String var1, Map<String, String> var2) {
      var2.put("event", var1);
      var0.method_2342("onVideoEvent", var2);
   }

   // $FF: renamed from: aV () void
   public void method_2498() {
      if(!TextUtils.isEmpty(this.field_1796)) {
         this.field_1794.setVideoPath(this.field_1796);
      } else {
         method_2495(this.field_1791, "no_src", (String)null);
      }
   }

   // $FF: renamed from: aW () void
   public void method_2499() {
      long var1 = (long)this.field_1794.getCurrentPosition();
      if(this.field_1795 != var1) {
         float var3 = (float)var1 / 1000.0F;
         method_2496(this.field_1791, "timeupdate", "time", String.valueOf(var3));
         this.field_1795 = var1;
      }

   }

   // $FF: renamed from: b (android.view.MotionEvent) void
   public void method_2500(MotionEvent var1) {
      this.field_1794.dispatchTouchEvent(var1);
   }

   public void destroy() {
      this.field_1793.cancel();
      this.field_1794.stopPlayback();
   }

   // $FF: renamed from: l (boolean) void
   public void method_2501(boolean var1) {
      if(var1) {
         this.field_1794.setMediaController(this.field_1792);
      } else {
         this.field_1792.hide();
         this.field_1794.setMediaController((MediaController)null);
      }
   }

   // $FF: renamed from: o (java.lang.String) void
   public void method_2502(String var1) {
      this.field_1796 = var1;
   }

   public void onCompletion(MediaPlayer var1) {
      method_2494(this.field_1791, "ended");
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      method_2495(this.field_1791, String.valueOf(var2), String.valueOf(var3));
      return true;
   }

   public void onPrepared(MediaPlayer var1) {
      float var2 = (float)this.field_1794.getDuration() / 1000.0F;
      method_2496(this.field_1791, "canplaythrough", "duration", String.valueOf(var2));
   }

   public void pause() {
      this.field_1794.pause();
   }

   public void play() {
      this.field_1794.start();
   }

   public void seekTo(int var1) {
      this.field_1794.seekTo(var1);
   }

   private static final class class_987 {
      // $FF: renamed from: le java.lang.Runnable
      private final Runnable field_3119;
      // $FF: renamed from: oL boolean
      private volatile boolean field_3120 = false;

      public class_987(final class_406 var1) {
         this.field_3119 = new Runnable() {
            // $FF: renamed from: oM java.lang.ref.WeakReference
            private final WeakReference<ck> field_2747 = new WeakReference(var1);

            public void run() {
               class_406 var1x = (class_406)this.field_2747.get();
               if(!class_987.this.field_3120 && var1x != null) {
                  var1x.method_2499();
                  class_987.this.method_3322();
               }

            }
         };
      }

      // $FF: renamed from: aX () void
      public void method_3322() {
         class_371.field_1606.postDelayed(this.field_3119, 250L);
      }

      public void cancel() {
         this.field_3120 = true;
         class_371.field_1606.removeCallbacks(this.field_3119);
      }
   }
}
