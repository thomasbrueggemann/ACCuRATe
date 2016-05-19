package com.comscore.streaming;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.os.Build.VERSION;
import com.comscore.streaming.StreamSense;
import com.comscore.streaming.StreamSenseEventType;
import com.comscore.streaming.class_66;
import com.comscore.streaming.class_67;
import com.comscore.streaming.class_68;
import com.comscore.streaming.class_69;
import com.comscore.streaming.class_70;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Timer;

@Deprecated
public class StreamSenseMediaPlayer extends MediaPlayer {
   // $FF: renamed from: a java.util.Timer
   Timer field_638;
   // $FF: renamed from: b java.util.Timer
   Timer field_639;
   // $FF: renamed from: c java.lang.String
   private final String field_640 = "local_file";
   // $FF: renamed from: d int
   private final int field_641 = 500;
   // $FF: renamed from: e boolean
   private final boolean field_642;
   // $FF: renamed from: f boolean
   private final boolean field_643;
   // $FF: renamed from: g boolean
   private final boolean field_644;
   // $FF: renamed from: h boolean
   private final boolean field_645;
   // $FF: renamed from: i int
   private final int field_646;
   // $FF: renamed from: j com.comscore.streaming.StreamSense
   private StreamSense field_647;
   // $FF: renamed from: k java.lang.String
   private String field_648;
   // $FF: renamed from: l java.lang.String
   private String field_649;
   // $FF: renamed from: m boolean
   private boolean field_650;
   // $FF: renamed from: n boolean
   private boolean field_651;
   // $FF: renamed from: o java.lang.String
   private String field_652;
   // $FF: renamed from: p android.media.MediaPlayer.OnCompletionListener
   private OnCompletionListener field_653;
   // $FF: renamed from: q android.media.MediaPlayer.OnCompletionListener
   private final OnCompletionListener field_654;
   // $FF: renamed from: r android.media.MediaPlayer.OnInfoListener
   private OnInfoListener field_655;
   // $FF: renamed from: s android.media.MediaPlayer.OnInfoListener
   private final OnInfoListener field_656;
   // $FF: renamed from: t android.media.MediaPlayer.OnSeekCompleteListener
   private OnSeekCompleteListener field_657;
   // $FF: renamed from: u android.media.MediaPlayer.OnSeekCompleteListener
   private final OnSeekCompleteListener field_658;
   // $FF: renamed from: v android.media.MediaPlayer.OnPreparedListener
   private OnPreparedListener field_659;
   // $FF: renamed from: w android.media.MediaPlayer.OnPreparedListener
   private final OnPreparedListener field_660;
   // $FF: renamed from: x java.util.Timer
   private Timer field_661;
   // $FF: renamed from: y java.util.Timer
   private Timer field_662;

   public StreamSenseMediaPlayer() {
      boolean var1;
      if(VERSION.SDK_INT < 9) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.field_642 = var1;
      this.field_643 = false;
      this.field_644 = false;
      this.field_645 = true;
      this.field_646 = 500;
      this.field_647 = null;
      this.field_648 = "0";
      this.field_649 = "0x0";
      this.field_650 = false;
      this.field_651 = false;
      this.field_653 = null;
      this.field_654 = new class_67(this);
      this.field_655 = null;
      this.field_656 = new class_66(this);
      this.field_657 = null;
      this.field_658 = new class_69(this);
      this.field_659 = null;
      this.field_660 = new class_68(this);
      this.field_661 = null;
      this.field_638 = null;
      this.field_639 = null;
      this.field_662 = null;
      this.method_618();
   }

   public StreamSenseMediaPlayer(boolean var1) {
      boolean var2;
      if(VERSION.SDK_INT < 9) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.field_642 = var2;
      this.field_643 = false;
      this.field_644 = false;
      this.field_645 = true;
      this.field_646 = 500;
      this.field_647 = null;
      this.field_648 = "0";
      this.field_649 = "0x0";
      this.field_650 = false;
      this.field_651 = false;
      this.field_653 = null;
      this.field_654 = new class_67(this);
      this.field_655 = null;
      this.field_656 = new class_66(this);
      this.field_657 = null;
      this.field_658 = new class_69(this);
      this.field_659 = null;
      this.field_660 = new class_68(this);
      this.field_661 = null;
      this.field_638 = null;
      this.field_639 = null;
      this.field_662 = null;
      this.method_618();
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseMediaPlayer) android.media.MediaPlayer.OnCompletionListener
   // $FF: synthetic method
   static OnCompletionListener method_602(StreamSenseMediaPlayer var0) {
      return var0.field_653;
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseMediaPlayer, java.lang.String) java.lang.String
   // $FF: synthetic method
   static String method_603(StreamSenseMediaPlayer var0, String var1) {
      var0.field_648 = var1;
      return var1;
   }

   // $FF: renamed from: a () void
   private void method_604() {
      this.field_650 = true;
      if(this.method_644() && !this.isPlayerPausedForSeeking()) {
         this.method_638();
      }

   }

   // $FF: renamed from: a (android.media.MediaPlayer) void
   private void method_605(MediaPlayer var1) {
      this.method_641();
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseMediaPlayer, android.media.MediaPlayer) void
   // $FF: synthetic method
   static void method_606(StreamSenseMediaPlayer var0, MediaPlayer var1) {
      var0.method_605(var1);
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseMediaPlayer, java.util.HashMap) void
   // $FF: synthetic method
   static void method_607(StreamSenseMediaPlayer var0, HashMap var1) {
      var0.method_628(var1);
   }

   // $FF: renamed from: a (java.util.HashMap) void
   private void method_608(HashMap<String, String> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.util.HashMap, long) void
   private void method_609(HashMap<String, String> var1, long var2) {
      boolean var4 = this.method_623();
      boolean var5 = this.method_629();
      this.method_631();
      if(!var4 && !var5 && this.field_647 != null) {
         this.field_647.notify(StreamSenseEventType.PAUSE, var1, var2);
      }

   }

   // $FF: renamed from: a (boolean) void
   private void method_610(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseMediaPlayer, boolean) boolean
   // $FF: synthetic method
   static boolean method_611(StreamSenseMediaPlayer var0, boolean var1) {
      var0.field_651 = var1;
      return var1;
   }

   // $FF: renamed from: b () void
   private void method_612() {
      this.field_650 = false;
      if(this.method_644() && !this.isPlayerPausedForSeeking()) {
         this.method_610(true);
      }

   }

   // $FF: renamed from: b (android.media.MediaPlayer) void
   private void method_613(MediaPlayer var1) {
      if(this.method_644()) {
         this.method_610(true);
      }

   }

   // $FF: renamed from: b (com.comscore.streaming.StreamSenseMediaPlayer, android.media.MediaPlayer) void
   // $FF: synthetic method
   static void method_614(StreamSenseMediaPlayer var0, MediaPlayer var1) {
      var0.method_613(var1);
   }

   // $FF: renamed from: b (com.comscore.streaming.StreamSenseMediaPlayer, java.util.HashMap) void
   // $FF: synthetic method
   static void method_615(StreamSenseMediaPlayer var0, HashMap var1) {
      var0.method_608(var1);
   }

   // $FF: renamed from: b (java.util.HashMap) void
   private void method_616(HashMap<String, String> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.comscore.streaming.StreamSenseMediaPlayer) boolean
   // $FF: synthetic method
   static boolean method_617(StreamSenseMediaPlayer var0) {
      return var0.field_651;
   }

   // $FF: renamed from: c () void
   private void method_618() {
      super.setOnCompletionListener(this.field_654);
      super.setOnInfoListener(this.field_656);
      super.setOnSeekCompleteListener(this.field_658);
      super.setOnPreparedListener(this.field_660);
   }

   // $FF: renamed from: c (java.util.HashMap) void
   private void method_619(HashMap<String, String> var1) {
      this.method_623();
      this.method_629();
      this.method_631();
      if(this.field_647 != null) {
         this.field_647.notify(StreamSenseEventType.BUFFER, var1, this.method_642());
      }

   }

   // $FF: renamed from: c (com.comscore.streaming.StreamSenseMediaPlayer) boolean
   // $FF: synthetic method
   static boolean method_620(StreamSenseMediaPlayer var0) {
      return var0.field_650;
   }

   // $FF: renamed from: d (com.comscore.streaming.StreamSenseMediaPlayer) void
   // $FF: synthetic method
   static void method_621(StreamSenseMediaPlayer var0) {
      var0.method_604();
   }

   // $FF: renamed from: d (java.util.HashMap) void
   private void method_622(HashMap<String, String> var1) {
      this.method_609(var1, this.method_642());
   }

   // $FF: renamed from: d () boolean
   private boolean method_623() {
      synchronized(this){}
      boolean var4 = false;

      boolean var2;
      label50: {
         try {
            var4 = true;
            if(this.field_661 != null) {
               this.field_661.cancel();
               this.field_661 = null;
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

   // $FF: renamed from: e () void
   private void method_624() {
      this.method_608(this.method_646());
   }

   // $FF: renamed from: e (com.comscore.streaming.StreamSenseMediaPlayer) void
   // $FF: synthetic method
   static void method_625(StreamSenseMediaPlayer var0) {
      var0.method_612();
   }

   // $FF: renamed from: e (java.util.HashMap) void
   private void method_626(HashMap<String, String> var1) {
      this.method_629();
      this.method_623();
      this.method_631();
      this.method_635();
      if(this.field_647 != null) {
         this.field_647.notify(StreamSenseEventType.END, var1, this.method_642());
      }

   }

   // $FF: renamed from: f (com.comscore.streaming.StreamSenseMediaPlayer) android.media.MediaPlayer.OnInfoListener
   // $FF: synthetic method
   static OnInfoListener method_627(StreamSenseMediaPlayer var0) {
      return var0.field_655;
   }

   // $FF: renamed from: f (java.util.HashMap) void
   private void method_628(HashMap<String, String> var1) {
      this.method_623();
      if(!this.method_631() && this.field_647 != null) {
         this.field_647.notify(StreamSenseEventType.PLAY, var1, this.method_642());
      }

   }

   // $FF: renamed from: f () boolean
   private boolean method_629() {
      synchronized(this){}
      boolean var4 = false;

      boolean var2;
      label50: {
         try {
            var4 = true;
            if(this.field_638 != null) {
               this.field_638.cancel();
               this.field_638 = null;
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

   // $FF: renamed from: g (com.comscore.streaming.StreamSenseMediaPlayer) android.media.MediaPlayer.OnSeekCompleteListener
   // $FF: synthetic method
   static OnSeekCompleteListener method_630(StreamSenseMediaPlayer var0) {
      return var0.field_657;
   }

   // $FF: renamed from: g () boolean
   private boolean method_631() {
      synchronized(this){}
      boolean var4 = false;

      boolean var2;
      label50: {
         try {
            var4 = true;
            if(this.field_639 != null) {
               this.field_639.cancel();
               this.field_639 = null;
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

   // $FF: renamed from: h (com.comscore.streaming.StreamSenseMediaPlayer) android.media.MediaPlayer.OnPreparedListener
   // $FF: synthetic method
   static OnPreparedListener method_632(StreamSenseMediaPlayer var0) {
      return var0.field_659;
   }

   // $FF: renamed from: h () void
   private void method_633() {
      this.method_616(this.method_646());
   }

   // $FF: renamed from: i (com.comscore.streaming.StreamSenseMediaPlayer) long
   // $FF: synthetic method
   static long method_634(StreamSenseMediaPlayer var0) {
      return var0.method_642();
   }

   // $FF: renamed from: i () boolean
   private boolean method_635() {
      synchronized(this){}
      boolean var4 = false;

      boolean var2;
      label50: {
         try {
            var4 = true;
            if(this.field_662 != null) {
               this.field_662.cancel();
               this.field_662 = null;
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

   // $FF: renamed from: j () void
   private void method_636() {
      synchronized(this){}

      try {
         if(this.field_642 && this.field_662 == null) {
            long var2 = this.method_642();
            this.field_662 = new Timer();
            this.field_662.schedule(new class_70(this, var2), 250L);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: j (com.comscore.streaming.StreamSenseMediaPlayer) boolean
   // $FF: synthetic method
   static boolean method_637(StreamSenseMediaPlayer var0) {
      return var0.method_623();
   }

   // $FF: renamed from: k () void
   private void method_638() {
      this.method_619(this.method_646());
   }

   // $FF: renamed from: k (com.comscore.streaming.StreamSenseMediaPlayer) void
   // $FF: synthetic method
   static void method_639(StreamSenseMediaPlayer var0) {
      var0.method_636();
   }

   // $FF: renamed from: l (com.comscore.streaming.StreamSenseMediaPlayer) java.util.Timer
   // $FF: synthetic method
   static Timer method_640(StreamSenseMediaPlayer var0) {
      return var0.field_662;
   }

   // $FF: renamed from: l () void
   private void method_641() {
      this.method_626(this.method_646());
   }

   // $FF: renamed from: m () long
   private long method_642() {
      int var2;
      try {
         var2 = this.getCurrentPosition();
      } catch (IllegalStateException var3) {
         return 0L;
      }

      return (long)var2;
   }

   // $FF: renamed from: m (com.comscore.streaming.StreamSenseMediaPlayer) boolean
   // $FF: synthetic method
   static boolean method_643(StreamSenseMediaPlayer var0) {
      return var0.method_644();
   }

   // $FF: renamed from: n () boolean
   private boolean method_644() {
      try {
         boolean var2 = this.isPlaying();
         return var2;
      } catch (IllegalStateException var3) {
         return false;
      }
   }

   // $FF: renamed from: n (com.comscore.streaming.StreamSenseMediaPlayer) boolean
   // $FF: synthetic method
   static boolean method_645(StreamSenseMediaPlayer var0) {
      return var0.method_635();
   }

   // $FF: renamed from: o () java.util.HashMap
   private HashMap<String, String> method_646() {
      HashMap var1 = new HashMap();
      var1.put("ns_ts", String.valueOf(System.currentTimeMillis()));
      var1.putAll(this.method_647());
      return var1;
   }

   // $FF: renamed from: p () java.util.HashMap
   private HashMap<String, String> method_647() {
      HashMap var1 = new HashMap();
      var1.put("ns_st_cl", this.field_648);
      var1.put("ns_st_cs", this.field_649);
      var1.put("ns_st_cu", this.field_652);
      var1.put("ns_st_mp", StreamSenseMediaPlayer.class.getSimpleName());
      var1.put("ns_st_mv", Integer.toString(VERSION.SDK_INT));
      return var1;
   }

   public boolean isPlayerPausedForBuffering() {
      return this.field_650;
   }

   public boolean isPlayerPausedForSeeking() {
      return this.field_651;
   }

   public void pause() {
      super.pause();
      this.method_635();
      this.field_650 = false;
      this.field_651 = false;
      this.method_633();
   }

   public void prepare() {
      super.prepare();
      this.field_649 = this.getVideoWidth() + "x" + this.getVideoHeight();
   }

   public void prepareAsync() {
      super.prepareAsync();
      this.field_649 = this.getVideoWidth() + "x" + this.getVideoHeight();
   }

   public void release() {
      super.release();
      this.method_641();
   }

   public void seekTo(int var1) {
      super.seekTo(var1);
      this.field_651 = true;
      if(this.method_644()) {
         this.method_609(this.method_646(), this.method_642());
      }

   }

   public void setDataSource(Context var1, Uri var2) {
      super.setDataSource(var1, var2);
      this.field_652 = var2.toString();
   }

   public void setDataSource(FileDescriptor var1) {
      super.setDataSource(var1);
      this.field_652 = "local_file";
   }

   public void setDataSource(FileDescriptor var1, long var2, long var4) {
      super.setDataSource(var1, var2, var4);
      this.field_652 = "local_file";
   }

   public void setDataSource(String var1) {
      super.setDataSource(var1);
      this.field_652 = var1;
   }

   public void setOnCompletionListener(OnCompletionListener var1) {
      super.setOnCompletionListener(this.field_654);
      this.field_653 = var1;
   }

   public void setOnInfoListener(OnInfoListener var1) {
      super.setOnInfoListener(this.field_656);
      this.field_655 = var1;
   }

   public void setOnPreparedListener(OnPreparedListener var1) {
      super.setOnPreparedListener(this.field_660);
      this.field_659 = var1;
   }

   public void setOnSeekCompleteListener(OnSeekCompleteListener var1) {
      super.setOnSeekCompleteListener(this.field_658);
      this.field_657 = var1;
   }

   public void setStreamSense(StreamSense var1) {
      this.field_647 = var1;
      this.field_647.setLabel("ns_st_pv", "4.1307.02");
   }

   public void start() {
      super.start();
      this.method_624();
   }

   public void stop() {
      super.stop();
      this.method_641();
   }
}
