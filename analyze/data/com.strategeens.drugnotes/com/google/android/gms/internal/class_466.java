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
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.dt
@ey
public final class class_466 extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   private final class_371 field_1587;
   // $FF: renamed from: so android.widget.MediaController
   private final MediaController field_1588;
   // $FF: renamed from: sp com.google.android.gms.internal.dt$a
   private final class_466.class_1125 field_1589;
   // $FF: renamed from: sq android.widget.VideoView
   private final VideoView field_1590;
   // $FF: renamed from: sr long
   private long field_1591;
   // $FF: renamed from: ss java.lang.String
   private String field_1592;

   public class_466(Context var1, class_371 var2) {
      super(var1);
      this.field_1587 = var2;
      this.field_1590 = new VideoView(var1);
      LayoutParams var3 = new LayoutParams(-1, -1, 17);
      this.addView(this.field_1590, var3);
      this.field_1588 = new MediaController(var1);
      this.field_1589 = new class_466.class_1125(this);
      this.field_1589.method_4463();
      this.field_1590.setOnCompletionListener(this);
      this.field_1590.setOnPreparedListener(this);
      this.field_1590.setOnErrorListener(this);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu, java.lang.String) void
   private static void method_2963(class_371 var0, String var1) {
      method_2966(var0, var1, new HashMap(1));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu, java.lang.String, java.lang.String) void
   public static void method_2964(class_371 var0, String var1, String var2) {
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

      method_2966(var0, "error", var5);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu, java.lang.String, java.lang.String, java.lang.String) void
   private static void method_2965(class_371 var0, String var1, String var2, String var3) {
      HashMap var4 = new HashMap(2);
      var4.put(var2, var3);
      method_2966(var0, var1, var4);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu, java.lang.String, java.util.Map) void
   private static void method_2966(gu var0, String var1, Map<String, String> var2) {
      var2.put("event", var1);
      var0.method_2523("onVideoEvent", var2);
   }

   // $FF: renamed from: C (java.lang.String) void
   public void method_2967(String var1) {
      this.field_1592 = var1;
   }

   // $FF: renamed from: b (android.view.MotionEvent) void
   public void method_2968(MotionEvent var1) {
      this.field_1590.dispatchTouchEvent(var1);
   }

   // $FF: renamed from: cq () void
   public void method_2969() {
      if(!TextUtils.isEmpty(this.field_1592)) {
         this.field_1590.setVideoPath(this.field_1592);
      } else {
         method_2964(this.field_1587, "no_src", (String)null);
      }
   }

   // $FF: renamed from: cr () void
   public void method_2970() {
      long var1 = (long)this.field_1590.getCurrentPosition();
      if(this.field_1591 != var1) {
         float var3 = (float)var1 / 1000.0F;
         method_2965(this.field_1587, "timeupdate", "time", String.valueOf(var3));
         this.field_1591 = var1;
      }

   }

   public void destroy() {
      this.field_1589.cancel();
      this.field_1590.stopPlayback();
   }

   public void onCompletion(MediaPlayer var1) {
      method_2963(this.field_1587, "ended");
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      method_2964(this.field_1587, String.valueOf(var2), String.valueOf(var3));
      return true;
   }

   public void onPrepared(MediaPlayer var1) {
      float var2 = (float)this.field_1590.getDuration() / 1000.0F;
      method_2965(this.field_1587, "canplaythrough", "duration", String.valueOf(var2));
   }

   public void pause() {
      this.field_1590.pause();
   }

   public void play() {
      this.field_1590.start();
   }

   // $FF: renamed from: s (boolean) void
   public void method_2971(boolean var1) {
      if(var1) {
         this.field_1590.setMediaController(this.field_1588);
      } else {
         this.field_1588.hide();
         this.field_1590.setMediaController((MediaController)null);
      }
   }

   public void seekTo(int var1) {
      this.field_1590.seekTo(var1);
   }

   private static final class class_1125 {
      // $FF: renamed from: mv java.lang.Runnable
      private final Runnable field_3446;
      // $FF: renamed from: st boolean
      private volatile boolean field_3447 = false;

      public class_1125(final class_466 var1) {
         this.field_3446 = new Runnable() {
            // $FF: renamed from: su java.lang.ref.WeakReference
            private final WeakReference<dt> field_1263 = new WeakReference(var1);

            public void run() {
               class_466 var1x = (class_466)this.field_1263.get();
               if(!class_1125.this.field_3447 && var1x != null) {
                  var1x.method_2970();
                  class_1125.this.method_4463();
               }

            }
         };
      }

      public void cancel() {
         this.field_3447 = true;
         class_367.field_1120.removeCallbacks(this.field_3446);
      }

      // $FF: renamed from: cs () void
      public void method_4463() {
         class_367.field_1120.postDelayed(this.field_3446, 250L);
      }
   }
}
