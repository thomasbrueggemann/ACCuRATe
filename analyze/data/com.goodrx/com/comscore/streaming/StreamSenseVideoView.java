package com.comscore.streaming;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.VideoView;
import com.comscore.streaming.StreamSense;
import com.comscore.streaming.StreamSenseEventType;
import com.comscore.streaming.class_56;
import com.comscore.streaming.class_57;
import com.comscore.streaming.class_58;
import com.comscore.utils.CSLog;
import java.util.HashMap;
import java.util.Timer;

@Deprecated
public class StreamSenseVideoView extends VideoView {
   // $FF: renamed from: a java.lang.String
   private final String field_619 = "StreamSenseVideoView";
   // $FF: renamed from: b boolean
   private final boolean field_620 = true;
   // $FF: renamed from: c int
   private final int field_621 = 500;
   // $FF: renamed from: d int
   private final int field_622 = 500;
   // $FF: renamed from: e long
   private long field_623 = -1L;
   // $FF: renamed from: f com.comscore.streaming.StreamSense
   private StreamSense field_624 = null;
   // $FF: renamed from: g java.lang.String
   private String field_625 = "0x0";
   // $FF: renamed from: h long
   private long field_626 = 0L;
   // $FF: renamed from: i long
   private long field_627 = -1L;
   // $FF: renamed from: j java.lang.String
   private String field_628;
   // $FF: renamed from: k boolean
   private boolean field_629 = false;
   // $FF: renamed from: l java.util.Timer
   private Timer field_630 = null;
   // $FF: renamed from: m java.util.Timer
   private Timer field_631 = null;
   // $FF: renamed from: n android.media.MediaPlayer.OnCompletionListener
   private OnCompletionListener field_632 = null;
   // $FF: renamed from: o android.media.MediaPlayer.OnCompletionListener
   private final OnCompletionListener field_633 = new class_58(this);

   public StreamSenseVideoView(Context var1) {
      super(var1);
      this.method_596();
   }

   public StreamSenseVideoView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.method_596();
   }

   public StreamSenseVideoView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.method_596();
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseVideoView) long
   // $FF: synthetic method
   static long method_573(StreamSenseVideoView var0) {
      return var0.getCurrentPlayerSafePosition();
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseVideoView, long) long
   // $FF: synthetic method
   static long method_574(StreamSenseVideoView var0, long var1) {
      long var3 = var1 + var0.field_626;
      var0.field_626 = var3;
      return var3;
   }

   // $FF: renamed from: a (android.media.MediaPlayer) void
   private void method_575(MediaPlayer var1) {
      CSLog.method_372("StreamSenseVideoView", "onPlaybackCompleted");
      this.method_586(this.method_598(), this.getCurrentPlayerSafePosition());
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseVideoView, android.media.MediaPlayer) void
   // $FF: synthetic method
   static void method_576(StreamSenseVideoView var0, MediaPlayer var1) {
      var0.method_575(var1);
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseVideoView, java.util.HashMap) void
   // $FF: synthetic method
   static void method_577(StreamSenseVideoView var0, HashMap var1) {
      var0.method_579(var1);
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseVideoView, java.util.HashMap, long) void
   // $FF: synthetic method
   static void method_578(StreamSenseVideoView var0, HashMap var1, long var2) {
      var0.method_583(var1, var2);
   }

   // $FF: renamed from: a (java.util.HashMap) void
   private void method_579(HashMap<String, String> var1) {
      synchronized(this){}

      try {
         this.method_592();
         if(this.field_630 == null) {
            long var4 = this.getCurrentPlayerSafePosition();
            CSLog.method_372("StreamSenseVideoView", "startStartTimer:" + var4);
            this.field_630 = new Timer();
            this.field_630.schedule(new class_56(this, var4, var1), 500L);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: a (java.util.HashMap, long) void
   private void method_580(HashMap<String, String> var1, long var2) {
      this.method_592();
      this.method_589();
      if(this.field_624 != null) {
         this.field_624.notify(StreamSenseEventType.END, var1, var2);
      }

   }

   // $FF: renamed from: a () boolean
   private boolean method_581() {
      try {
         boolean var2 = this.isPlaying();
         return var2;
      } catch (IllegalStateException var3) {
         return false;
      }
   }

   // $FF: renamed from: b (com.comscore.streaming.StreamSenseVideoView) long
   // $FF: synthetic method
   static long method_582(StreamSenseVideoView var0) {
      return var0.field_626;
   }

   // $FF: renamed from: b (java.util.HashMap, long) void
   private void method_583(HashMap<String, String> var1, long var2) {
      this.field_629 = false;
      this.method_589();
      if(this.field_624 != null) {
         this.field_624.notify(StreamSenseEventType.PLAY, var1, var2);
      }

   }

   // $FF: renamed from: b () boolean
   private boolean method_584() {
      return this.field_629;
   }

   // $FF: renamed from: c () void
   private void method_585() {
      CSLog.method_372("StreamSenseVideoView", "onPauseForBuffering");
      this.field_629 = true;
      this.field_627 = System.currentTimeMillis();
      if(this.method_581()) {
         this.method_586(this.method_598(), this.getCurrentPlayerSafePosition());
         this.method_591();
      }

   }

   // $FF: renamed from: c (java.util.HashMap, long) void
   private void method_586(HashMap<String, String> var1, long var2) {
      if(!this.method_589() && this.field_624 != null) {
         this.field_624.notify(StreamSenseEventType.PAUSE, var1, var2);
      }

   }

   // $FF: renamed from: c (com.comscore.streaming.StreamSenseVideoView) boolean
   // $FF: synthetic method
   static boolean method_587(StreamSenseVideoView var0) {
      return var0.method_589();
   }

   // $FF: renamed from: d (com.comscore.streaming.StreamSenseVideoView) void
   // $FF: synthetic method
   static void method_588(StreamSenseVideoView var0) {
      var0.method_594();
   }

   // $FF: renamed from: d () boolean
   private boolean method_589() {
      synchronized(this){}
      boolean var4 = false;

      boolean var2;
      label50: {
         try {
            var4 = true;
            if(this.field_630 != null) {
               CSLog.method_372("StreamSenseVideoView", "cancelStartTimer");
               this.field_630.cancel();
               this.field_630 = null;
               var4 = false;
               break label50;
            }

            var4 = false;
         } finally {
            if(var4) {
               ;
            }
         }

         var2 = false;
         return var2;
      }

      var2 = true;
      return var2;
   }

   // $FF: renamed from: e (com.comscore.streaming.StreamSenseVideoView) java.util.Timer
   // $FF: synthetic method
   static Timer method_590(StreamSenseVideoView var0) {
      return var0.field_631;
   }

   // $FF: renamed from: e () void
   private void method_591() {
      this.method_579(this.method_598());
   }

   // $FF: renamed from: f () boolean
   private boolean method_592() {
      synchronized(this){}
      boolean var4 = false;

      boolean var2;
      label50: {
         try {
            var4 = true;
            CSLog.method_372("StreamSenseVideoView", "cancelPlayingPollTimer()");
            if(this.field_631 != null) {
               this.field_631.cancel();
               this.field_631 = null;
               var4 = false;
               break label50;
            }

            var4 = false;
         } finally {
            if(var4) {
               ;
            }
         }

         var2 = false;
         return var2;
      }

      var2 = true;
      return var2;
   }

   // $FF: renamed from: f (com.comscore.streaming.StreamSenseVideoView) boolean
   // $FF: synthetic method
   static boolean method_593(StreamSenseVideoView var0) {
      return var0.method_581();
   }

   // $FF: renamed from: g () void
   private void method_594() {
      synchronized(this){}

      try {
         if(this.field_631 == null) {
            CSLog.method_372("StreamSenseVideoView", "startPlayingPollTimer");
            long var2 = this.getCurrentPlayerSafePosition();
            this.field_631 = new Timer();
            this.field_631.schedule(new class_57(this, var2), 250L);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: g (com.comscore.streaming.StreamSenseVideoView) boolean
   // $FF: synthetic method
   static boolean method_595(StreamSenseVideoView var0) {
      return var0.method_584();
   }

   private long getCurrentPlayerSafePosition() {
      int var2;
      try {
         var2 = this.getCurrentPosition();
      } catch (IllegalStateException var3) {
         CSLog.method_374("StreamSenseVideoView", "getCurrentSafePlayerPosition");
         return 0L;
      }

      return (long)var2;
   }

   private HashMap<String, String> getPlayerMetadata() {
      HashMap var1 = new HashMap();
      if(this.field_623 <= 0L) {
         this.field_623 = (long)this.getDuration();
      }

      var1.put("ns_st_cl", String.valueOf(this.field_623));
      if(this.field_625 == null || this.field_625.equals("0x0")) {
         this.field_625 = this.getWidth() + "x" + this.getHeight();
      }

      var1.put("ns_st_cs", this.field_625);
      var1.put("ns_st_cu", this.field_628);
      var1.put("ns_st_mp", StreamSenseVideoView.class.getSimpleName());
      var1.put("ns_st_mv", Integer.toString(VERSION.SDK_INT));
      return var1;
   }

   // $FF: renamed from: h () void
   private void method_596() {
      super.setOnCompletionListener(this.field_633);
   }

   // $FF: renamed from: h (com.comscore.streaming.StreamSenseVideoView) boolean
   // $FF: synthetic method
   static boolean method_597(StreamSenseVideoView var0) {
      return var0.method_592();
   }

   // $FF: renamed from: i () java.util.HashMap
   private HashMap<String, String> method_598() {
      HashMap var1 = new HashMap();
      var1.put("ns_ts", String.valueOf(System.currentTimeMillis()));
      var1.putAll(this.getPlayerMetadata());
      return var1;
   }

   // $FF: renamed from: i (com.comscore.streaming.StreamSenseVideoView) void
   // $FF: synthetic method
   static void method_599(StreamSenseVideoView var0) {
      var0.method_585();
   }

   // $FF: renamed from: j (com.comscore.streaming.StreamSenseVideoView) android.media.MediaPlayer.OnCompletionListener
   // $FF: synthetic method
   static OnCompletionListener method_600(StreamSenseVideoView var0) {
      return var0.field_632;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      CSLog.method_372("StreamSenseVideoView", "onDetachedFromWindow");
      this.method_580(this.method_598(), this.getCurrentPlayerSafePosition());
   }

   public void pause() {
      super.pause();
      CSLog.method_372("StreamSenseVideoView", "pause");
      this.method_592();
      if(this.field_629) {
         this.field_626 += System.currentTimeMillis() - this.field_627;
      }

      this.field_629 = false;
      this.field_627 = -1L;
      this.method_586(this.method_598(), this.getCurrentPlayerSafePosition());
   }

   @TargetApi(8)
   public void resume() {
      if(VERSION.SDK_INT >= 8) {
         super.resume();
      }

      CSLog.method_372("StreamSenseVideoView", "resume");
      this.method_583(this.method_598(), this.getCurrentPlayerSafePosition());
   }

   public void seekTo(int var1) {
      super.seekTo(var1);
      CSLog.method_372("StreamSenseVideoView", "seekTo:" + var1);
      if(this.method_581()) {
         this.method_592();
         this.method_589();
         this.method_586(this.method_598(), -1L);
         this.method_591();
      }

   }

   public void setOnCompletionListener(OnCompletionListener var1) {
      super.setOnCompletionListener(this.field_633);
      this.field_632 = var1;
   }

   public void setStreamSense(StreamSense var1) {
      this.field_624 = var1;
      this.field_624.setLabel("ns_st_pv", "4.1307.02");
   }

   public void setVideoPath(String var1) {
      super.setVideoPath(var1);
      this.field_628 = var1;
   }

   public void setVideoURI(Uri var1) {
      super.setVideoURI(var1);
      this.field_628 = var1.toString();
   }

   public void start() {
      super.start();
      if(this.field_630 == null) {
         CSLog.method_372("StreamSenseVideoView", "start");
         this.method_591();
      }

   }

   public void stopPlayback() {
      super.stopPlayback();
      CSLog.method_372("StreamSenseVideoView", "stopPlayback");
      this.method_580(this.method_598(), this.getCurrentPlayerSafePosition());
   }
}
