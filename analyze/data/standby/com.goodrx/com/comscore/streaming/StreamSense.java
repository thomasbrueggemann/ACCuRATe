package com.comscore.streaming;

import android.content.Context;
import com.comscore.analytics.Core;
import com.comscore.analytics.comScore;
import com.comscore.streaming.StreamSenseClip;
import com.comscore.streaming.StreamSenseEventType;
import com.comscore.streaming.StreamSenseListener;
import com.comscore.streaming.StreamSenseMediaPlayer;
import com.comscore.streaming.StreamSensePlaylist;
import com.comscore.streaming.StreamSenseState;
import com.comscore.streaming.StreamSenseUtils;
import com.comscore.streaming.StreamSenseVideoView;
import com.comscore.streaming.class_60;
import com.comscore.streaming.class_61;
import com.comscore.streaming.class_62;
import com.comscore.streaming.class_63;
import com.comscore.streaming.class_64;
import com.comscore.streaming.class_65;
import com.comscore.utils.CSLog;
import com.comscore.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StreamSense {
   // $FF: renamed from: a com.comscore.analytics.Core
   protected Core field_145;
   // $FF: renamed from: b java.util.HashMap
   private HashMap<String, String> field_146;
   // $FF: renamed from: c java.lang.String
   private String field_147 = null;
   // $FF: renamed from: d long
   private long field_148;
   // $FF: renamed from: e long
   private long field_149;
   // $FF: renamed from: f com.comscore.streaming.StreamSenseState
   private StreamSenseState field_150 = null;
   // $FF: renamed from: g int
   private int field_151;
   // $FF: renamed from: h com.comscore.streaming.StreamSensePlaylist
   private StreamSensePlaylist field_152 = null;
   // $FF: renamed from: i java.lang.Runnable
   private Runnable field_153 = null;
   // $FF: renamed from: j boolean
   private boolean field_154 = true;
   // $FF: renamed from: k java.lang.Runnable
   private Runnable field_155;
   // $FF: renamed from: l com.comscore.streaming.f
   private class_62 field_156 = null;
   // $FF: renamed from: m java.lang.Runnable
   private Runnable field_157;
   // $FF: renamed from: n long
   private long field_158;
   // $FF: renamed from: o int
   private int field_159;
   // $FF: renamed from: p long
   private long field_160;
   // $FF: renamed from: q boolean
   private boolean field_161;
   // $FF: renamed from: r com.comscore.streaming.StreamSenseState
   private StreamSenseState field_162;
   // $FF: renamed from: s java.lang.String
   private String field_163;
   // $FF: renamed from: t java.lang.String
   private String field_164;
   // $FF: renamed from: u java.util.HashMap
   private HashMap<String, String> field_165;
   // $FF: renamed from: v java.util.List
   private List<StreamSenseListener> field_166;
   // $FF: renamed from: w java.util.List
   private List<HashMap<String, Long>> field_167;
   // $FF: renamed from: x int
   private int field_168;
   // $FF: renamed from: y int
   private int field_169;

   public StreamSense() {
      CSLog.method_372(this, "StreamSense()");
      this.field_145 = comScore.getCore();
      this.field_146 = new HashMap();
      this.field_151 = 1;
      this.field_150 = StreamSenseState.IDLE;
      this.field_152 = new StreamSensePlaylist();
      this.field_153 = null;
      this.field_154 = true;
      this.field_157 = null;
      this.field_159 = 0;
      this.method_108();
      this.field_155 = null;
      this.field_156 = null;
      this.field_161 = false;
      this.field_162 = null;
      this.field_149 = 0L;
      this.field_168 = 1200000;
      this.field_169 = 500;
      this.field_166 = new ArrayList();
      this.field_167 = this.method_117();
      this.reset();
   }

   // $FF: renamed from: a (long) long
   private long method_86(long var1) {
      Iterator var3 = this.field_167.iterator();

      HashMap var4;
      Long var5;
      do {
         if(!var3.hasNext()) {
            return 0L;
         }

         var4 = (HashMap)var3.next();
         var5 = (Long)var4.get("playingtime");
      } while(var5 != null && var1 >= var5.longValue());

      return ((Long)var4.get("interval")).longValue();
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseEventType) com.comscore.streaming.StreamSenseState
   private StreamSenseState method_87(StreamSenseEventType var1) {
      return var1 == StreamSenseEventType.PLAY?StreamSenseState.PLAYING:(var1 == StreamSenseEventType.PAUSE?StreamSenseState.PAUSED:(var1 == StreamSenseEventType.BUFFER?StreamSenseState.BUFFERING:(var1 == StreamSenseEventType.END?StreamSenseState.IDLE:null)));
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseEventType, java.util.HashMap) java.util.HashMap
   private HashMap<String, String> method_88(StreamSenseEventType var1, HashMap<String, String> var2) {
      if(!this.field_145.isEnabled()) {
         new HashMap();
      }

      CSLog.method_372(this, "createMeasurementLabels(" + var1 + ")");
      HashMap var4 = new HashMap();
      if(var2 != null) {
         var4.putAll(var2);
      }

      if(!var4.containsKey("ns_ts")) {
         var4.put("ns_ts", String.valueOf(System.currentTimeMillis()));
      }

      if(var1 != null && !var4.containsKey("ns_st_ev")) {
         var4.put("ns_st_ev", var1.toString());
      }

      var4.putAll(this.getLabels());
      this.method_94(var1, var4);
      this.field_152.method_282(var1, var4);
      this.field_152.getClip().method_455(var1, var4);
      if(!var4.containsKey("ns_st_mp")) {
         var4.put("ns_st_mp", this.field_163);
      }

      if(!var4.containsKey("ns_st_mv")) {
         var4.put("ns_st_mv", this.field_164);
      }

      if(!var4.containsKey("ns_st_ub")) {
         var4.put("ns_st_ub", "0");
      }

      if(!var4.containsKey("ns_st_br")) {
         var4.put("ns_st_br", "0");
      }

      if(!var4.containsKey("ns_st_pn")) {
         var4.put("ns_st_pn", "1");
      }

      if(!var4.containsKey("ns_st_tp")) {
         var4.put("ns_st_tp", "1");
      }

      if(!var4.containsKey("ns_st_it")) {
         var4.put("ns_st_it", "c");
      }

      var4.put("ns_st_sv", "4.1508.28");
      return var4;
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSense) void
   // $FF: synthetic method
   static void method_89(StreamSense var0) {
      var0.method_113();
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSense, com.comscore.streaming.StreamSenseState, java.util.HashMap) void
   // $FF: synthetic method
   static void method_90(StreamSense var0, StreamSenseState var1, HashMap var2) {
      var0.method_91(var1, var2);
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseState, java.util.HashMap) void
   private void method_91(StreamSenseState var1, HashMap<String, String> var2) {
      long var3 = 0L;
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "transitionTo(" + var1 + ", " + var2 + ")");
         this.method_115();
         if(this.method_101(var1)) {
            StreamSenseState var5 = this.getState();
            long var6 = this.field_148;
            long var8 = this.method_107(var2);
            if(var6 >= var3) {
               var3 = var8 - var6;
            }

            this.method_95(this.getState(), var2);
            this.method_99(var1, var2);
            this.method_103(var1);
            Iterator var10 = this.field_166.iterator();

            while(var10.hasNext()) {
               ((StreamSenseListener)var10.next()).onStateChange(var5, var1, var2, var3);
            }

            this.method_100(var2);
            this.field_152.method_290(var2, var1);
            this.field_152.getClip().method_462(var2, var1);
            HashMap var11 = this.method_88(var1.toEventType(), var2);
            var11.putAll(var2);
            if(this.method_97(this.field_150)) {
               this.method_119(var11);
               this.field_162 = this.field_150;
               ++this.field_151;
               return;
            }
         }
      }

   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseState, java.util.HashMap, long) void
   private void method_92(StreamSenseState var1, HashMap<String, String> var2, long var3) {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "transitionTo(" + var1 + ", " + var2 + ", " + var3 + ")");
         this.method_115();
         this.field_156 = new class_63(this, var1, var2);
         this.field_145.getTaskExecutor().execute(this.field_156, var3);
      }
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseState) boolean
   private boolean method_93(StreamSenseState var1) {
      return this.field_145.isEnabled() && (var1 == StreamSenseState.PLAYING || var1 == StreamSenseState.PAUSED);
   }

   @Deprecated
   public static StreamSense analyticsFor(StreamSenseMediaPlayer var0) {
      StreamSense var1 = new StreamSense();
      var1.engageTo(var0);
      var1.setPausePlaySwitchDelayEnabled(true);
      return var1;
   }

   @Deprecated
   public static StreamSense analyticsFor(StreamSenseVideoView var0) {
      StreamSense var1 = new StreamSense();
      var1.engageTo(var0);
      return var1;
   }

   // $FF: renamed from: b (com.comscore.streaming.StreamSenseEventType, java.util.HashMap) java.util.HashMap
   private HashMap<String, String> method_94(StreamSenseEventType var1, HashMap<String, String> var2) {
      if(!this.field_145.isEnabled()) {
         var2 = new HashMap();
      } else {
         if(var2 == null) {
            var2 = new HashMap();
         }

         var2.put("ns_st_ec", String.valueOf(this.field_151));
         if(!var2.containsKey("ns_st_po")) {
            long var6 = this.field_149;
            long var8 = this.method_107(var2);
            if(var1 == StreamSenseEventType.PLAY || var1 == StreamSenseEventType.KEEP_ALIVE || var1 == StreamSenseEventType.HEART_BEAT || var1 == null && this.field_150 == StreamSenseState.PLAYING) {
               var6 += var8 - this.field_152.getClip().getPlaybackTimestamp();
            }

            var2.put("ns_st_po", String.valueOf(var6));
         }

         if(var1 == StreamSenseEventType.HEART_BEAT) {
            var2.put("ns_st_hc", String.valueOf(this.field_159));
            var2.put("ns_st_pe", "1");
            return var2;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.comscore.streaming.StreamSenseState, java.util.HashMap) void
   private void method_95(StreamSenseState var1, HashMap<String, String> var2) {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "onExit(" + var1 + ", " + var2 + ")");
         long var3 = this.method_107(var2);
         if(var1 == StreamSenseState.PLAYING) {
            this.field_152.method_284(var3);
            this.method_106();
            this.method_111();
            return;
         }

         if(var1 == StreamSenseState.BUFFERING) {
            this.field_152.method_289(var3);
            this.method_114();
            return;
         }

         if(var1 == StreamSenseState.IDLE) {
            this.getClip().reset(this.getClip().getLabels().keySet());
            return;
         }
      }

   }

   // $FF: renamed from: b (java.util.HashMap) void
   private void method_96(HashMap<String, String> var1) {
      if(this.field_145.isEnabled() && this.method_107(var1) < 0L) {
         var1.put("ns_ts", String.valueOf(System.currentTimeMillis()));
      }
   }

   // $FF: renamed from: b (com.comscore.streaming.StreamSenseState) boolean
   private boolean method_97(StreamSenseState var1) {
      return (var1 != StreamSenseState.PAUSED || this.field_162 != StreamSenseState.IDLE && this.field_162 != null) && var1 != StreamSenseState.BUFFERING && this.field_162 != var1;
   }

   // $FF: renamed from: c () void
   private void method_98() {
      if(this.field_145.isEnabled()) {
         this.method_114();
         if(this.isPauseOnBufferingEnabled() && this.method_97(StreamSenseState.PAUSED)) {
            this.field_153 = new class_61(this);
            this.field_145.getTaskExecutor().execute(this.field_153, (long)this.field_169);
            return;
         }
      }

   }

   // $FF: renamed from: c (com.comscore.streaming.StreamSenseState, java.util.HashMap) void
   private void method_99(StreamSenseState var1, HashMap<String, String> var2) {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "onEnter(" + var1 + ", " + var2 + ")");
         long var3 = this.method_107(var2);
         this.field_149 = this.method_105(var2);
         if(var1 == StreamSenseState.PLAYING) {
            this.method_102();
            this.method_110();
            this.field_152.getClip().method_464(var3);
            if(this.method_97(var1)) {
               this.field_152.getClip().method_465();
               if(this.field_152.method_281() < 1) {
                  this.field_152.method_283(1);
                  return;
               }
            }
         } else if(var1 == StreamSenseState.PAUSED) {
            if(this.method_97(var1)) {
               this.field_152.method_298();
               return;
            }
         } else if(var1 == StreamSenseState.BUFFERING) {
            this.field_152.getClip().method_466(var3);
            if(this.field_154) {
               this.method_98();
               return;
            }
         } else if(var1 == StreamSenseState.IDLE) {
            this.method_108();
            return;
         }
      }

   }

   // $FF: renamed from: c (java.util.HashMap) void
   private void method_100(HashMap<String, String> var1) {
      if(this.field_145.isEnabled()) {
         String var2 = (String)var1.get("ns_st_mp");
         if(var2 != null) {
            this.field_163 = var2;
            var1.remove("ns_st_mp");
         }

         String var3 = (String)var1.get("ns_st_mv");
         if(var3 != null) {
            this.field_164 = var3;
            var1.remove("ns_st_mv");
         }

         String var4 = (String)var1.get("ns_st_ec");
         if(var4 != null) {
            try {
               this.field_151 = Integer.parseInt(var4);
               var1.remove("ns_st_ec");
               return;
            } catch (NumberFormatException var6) {
               return;
            }
         }
      }

   }

   // $FF: renamed from: c (com.comscore.streaming.StreamSenseState) boolean
   private boolean method_101(StreamSenseState var1) {
      return var1 != null && this.getState() != var1;
   }

   // $FF: renamed from: d () void
   private void method_102() {
      if(this.field_145.isEnabled()) {
         this.method_112();
         if(this.field_167 != null) {
            long var1;
            if(this.field_158 >= 0L) {
               var1 = this.field_158;
               CSLog.method_372(this, "Resuming heart beat timer. Next event in " + var1 + " ms");
            } else {
               var1 = this.method_86(this.field_152.getClip().method_468());
               CSLog.method_372(this, "Starting heart beat timer. Next event in " + var1 + " ms");
            }

            if(var1 > 0L) {
               this.field_160 = var1 + System.currentTimeMillis();
               this.field_157 = new class_60(this);
               this.field_145.getTaskExecutor().execute(this.field_157, var1);
               return;
            }
         }
      }

   }

   // $FF: renamed from: d (com.comscore.streaming.StreamSenseState) void
   private void method_103(StreamSenseState var1) {
      if(this.field_145.isEnabled()) {
         this.field_150 = var1;
         this.field_148 = System.currentTimeMillis();
      }
   }

   // $FF: renamed from: d (java.util.HashMap) void
   private void method_104(HashMap<String, String> var1) {
      if(this.field_145.isEnabled()) {
         this.field_165 = this.method_109((HashMap)null);
         this.field_165.putAll(var1);
      }
   }

   // $FF: renamed from: e (java.util.HashMap) long
   private long method_105(HashMap<String, String> var1) {
      if(var1.containsKey("ns_st_po")) {
         try {
            long var3 = Long.valueOf((String)var1.get("ns_st_po")).longValue();
            return var3;
         } catch (NumberFormatException var5) {
            return -1L;
         }
      } else {
         return -1L;
      }
   }

   // $FF: renamed from: e () void
   private void method_106() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "Pausing heartbeat timer.");
         this.method_112();
         this.field_158 = this.field_160 - System.currentTimeMillis();
         this.field_160 = -1L;
      }
   }

   // $FF: renamed from: f (java.util.HashMap) long
   private long method_107(HashMap<String, String> var1) {
      if(var1.containsKey("ns_ts")) {
         try {
            long var3 = Long.valueOf((String)var1.get("ns_ts")).longValue();
            return var3;
         } catch (NumberFormatException var5) {
            return -1L;
         }
      } else {
         return -1L;
      }
   }

   // $FF: renamed from: f () void
   private void method_108() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "Resetting heartbeat timer.");
         this.field_158 = -1L;
         this.field_160 = -1L;
         this.field_159 = 0;
      }
   }

   // $FF: renamed from: g (java.util.HashMap) java.util.HashMap
   private HashMap<String, String> method_109(HashMap<String, String> var1) {
      return this.method_88(this.field_150.toEventType(), var1);
   }

   // $FF: renamed from: g () void
   private void method_110() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "Starting keep alive timer");
         this.method_111();
         this.field_155 = new class_64(this);
         this.field_145.getTaskExecutor().execute(this.field_155, (long)this.field_168, true, (long)this.field_168);
      }
   }

   public static String getVersion() {
      return "4.1508.28";
   }

   // $FF: renamed from: h () void
   private void method_111() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "stopKeepAliveTask()");
         if(this.field_155 != null) {
            this.field_145.getTaskExecutor().removeEnqueuedTask(this.field_155);
            this.field_155 = null;
            return;
         }
      }

   }

   // $FF: renamed from: i () void
   private void method_112() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "releaseHeartBeatTask()");
         if(this.field_157 != null) {
            this.field_145.getTaskExecutor().removeEnqueuedTask(this.field_157);
            this.field_157 = null;
            return;
         }
      }

   }

   // $FF: renamed from: j () void
   private void method_113() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "Firing paused on buffering event");
         if(this.field_162 == StreamSenseState.PLAYING) {
            this.field_152.method_300();
            this.field_152.method_298();
            this.method_119(this.method_88(StreamSenseEventType.PAUSE, (HashMap)null));
            ++this.field_151;
            this.field_162 = StreamSenseState.PAUSED;
            return;
         }
      }

   }

   // $FF: renamed from: k () void
   private void method_114() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "stopPausedOnBufferingTask()");
         if(this.field_153 != null) {
            this.field_145.getTaskExecutor().removeEnqueuedTask(this.field_153);
            this.field_153 = null;
            return;
         }
      }

   }

   // $FF: renamed from: l () void
   private void method_115() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "stopDelayedTransitionTask()");
         if(this.field_156 != null) {
            this.field_145.getTaskExecutor().removeEnqueuedTask(this.field_156);
            this.field_156 = null;
            return;
         }
      }

   }

   // $FF: renamed from: m () boolean
   private boolean method_116() {
      Context var1 = this.field_145.getAppContext();
      String var2 = this.field_145.getPublisherSecret();
      String var3 = this.field_145.getPixelURL();
      return var1 == null || var2 == null || var2.length() == 0 || var3 == null || var3.length() == 0;
   }

   // $FF: renamed from: n () java.util.List
   private List<HashMap<String, Long>> method_117() {
      ArrayList var1 = new ArrayList();
      HashMap var2 = new HashMap();
      var2.put("playingtime", Long.valueOf(60000L));
      var2.put("interval", Long.valueOf(10000L));
      var1.add(var2);
      HashMap var6 = new HashMap();
      var6.put("playingtime", (Object)null);
      var6.put("interval", Long.valueOf(60000L));
      var1.add(var6);
      return var1;
   }

   // $FF: renamed from: a () void
   protected void method_118() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "Firing heart beat");
         ++this.field_159;
         this.method_119(this.method_88(StreamSenseEventType.HEART_BEAT, (HashMap)null));
         this.field_158 = -1L;
         this.method_102();
      }
   }

   // $FF: renamed from: a (java.util.HashMap) void
   protected void method_119(HashMap<String, String> var1) {
      this.method_120(var1, true);
   }

   // $FF: renamed from: a (java.util.HashMap, boolean) void
   protected void method_120(HashMap<String, String> var1, boolean var2) {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "dispatch(" + var1 + ", " + var2 + ")");
         if(var2) {
            this.method_104(var1);
         }

         if(!this.method_116()) {
            String var3 = this.field_147;
            this.field_145.getTaskExecutor().execute(new class_65(this, var1, var3), true);
            return;
         }
      }

   }

   public void addListener(StreamSenseListener var1) {
      if(this.field_145.isEnabled()) {
         this.field_166.add(var1);
      }
   }

   // $FF: renamed from: b () void
   protected void method_121() {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "Firing keep alive");
         this.method_119(this.method_88(StreamSenseEventType.KEEP_ALIVE, (HashMap)null));
         ++this.field_151;
      }
   }

   @Deprecated
   public void engageTo(StreamSenseMediaPlayer var1) {
      var1.setStreamSense(this);
   }

   @Deprecated
   public void engageTo(StreamSenseVideoView var1) {
      var1.setStreamSense(this);
   }

   public HashMap<String, String> exportState() {
      return this.field_165;
   }

   public StreamSenseClip getClip() {
      return this.field_152.getClip();
   }

   public int getKeepAliveInterval() {
      return this.field_168;
   }

   public String getLabel(String var1) {
      return (String)this.field_146.get(var1);
   }

   public HashMap<String, String> getLabels() {
      return this.field_146;
   }

   public int getPauseOnBufferingInterval() {
      return this.field_169;
   }

   public String getPixelURL() {
      return this.field_147;
   }

   public StreamSensePlaylist getPlaylist() {
      return this.field_152;
   }

   public StreamSenseState getState() {
      return this.field_150;
   }

   public void importState(HashMap<String, String> var1) {
      if(this.field_145.isEnabled()) {
         this.reset();
         HashMap var2 = Utils.mapOfStrings(var1);
         this.field_152.method_290(var2, (StreamSenseState)null);
         this.field_152.getClip().method_462(var2, (StreamSenseState)null);
         this.method_100(var2);
         ++this.field_151;
      }
   }

   public boolean isPauseOnBufferingEnabled() {
      return this.field_154;
   }

   public boolean isPausePlaySwitchDelayEnabled() {
      return this.field_161;
   }

   public void notify(StreamSenseEventType var1, long var2) {
      this.notify(var1, new HashMap(), var2);
   }

   public void notify(StreamSenseEventType var1, HashMap<String, String> var2, long var3) {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "notify(" + var1 + ", " + var2 + ")");
         StreamSenseState var5 = this.method_87(var1);
         HashMap var6 = Utils.mapOfStrings(var2);
         this.method_96(var6);
         if(!var6.containsKey("ns_st_po")) {
            var6.put("ns_st_po", String.valueOf(var3));
         }

         if(var1 != StreamSenseEventType.PLAY && var1 != StreamSenseEventType.PAUSE && var1 != StreamSenseEventType.BUFFER && var1 != StreamSenseEventType.END) {
            HashMap var7 = this.method_88(var1, var6);
            var7.putAll(var6);
            this.method_120(var7, false);
            ++this.field_151;
         } else if(this.isPausePlaySwitchDelayEnabled() && this.method_93(this.field_150) && this.method_93(var5) && (this.field_150 != StreamSenseState.PLAYING || var5 != StreamSenseState.PAUSED || this.field_156 != null)) {
            this.method_92(var5, var6, 500L);
         } else {
            this.method_91(var5, var6);
         }
      }
   }

   public void removeListener(StreamSenseListener var1) {
      if(this.field_145.isEnabled()) {
         this.field_166.remove(var1);
      }
   }

   public void reset() {
      this.reset((Set)null);
   }

   public void reset(Set<String> var1) {
      if(this.field_145.isEnabled()) {
         CSLog.method_372(this, "Reset()");
         this.field_152.reset(var1);
         this.field_152.method_295(0);
         this.field_152.setPlaylistId(System.currentTimeMillis() + "_1");
         this.field_152.getClip().reset(var1);
         if(var1 != null && !var1.isEmpty()) {
            StreamSenseUtils.filterMap(this.field_146, var1);
         } else {
            this.field_146.clear();
         }

         this.field_151 = 1;
         this.field_159 = 0;
         this.method_106();
         this.method_108();
         this.method_111();
         this.method_114();
         this.method_115();
         this.field_150 = StreamSenseState.IDLE;
         this.field_148 = -1L;
         this.field_162 = null;
         this.field_163 = "android_puppet";
         this.field_164 = "4.1508.28";
         this.field_165 = null;
      }
   }

   public Boolean setClip(HashMap<String, String> var1) {
      return this.setClip(var1, false);
   }

   public Boolean setClip(HashMap<String, String> var1, boolean var2) {
      Boolean var3;
      if(!this.field_145.isEnabled()) {
         var3 = Boolean.FALSE;
      } else {
         var3 = Boolean.FALSE;
         if(this.field_150 == StreamSenseState.IDLE) {
            this.field_152.getClip().reset();
            this.field_152.getClip().method_458(Utils.mapOfStrings(var1), (StreamSenseState)null);
            if(var2) {
               this.field_152.method_287();
            }

            return Boolean.TRUE;
         }
      }

      return var3;
   }

   public void setHeartbeatIntervals(List<HashMap<String, Long>> var1) {
      if(this.field_145.isEnabled()) {
         this.field_167 = var1;
      }
   }

   public void setKeepAliveInterval(int var1) {
      if(this.field_145.isEnabled()) {
         this.field_168 = var1;
      }
   }

   public void setLabel(String var1, String var2) {
      if(this.field_145.isEnabled()) {
         if(var2 == null) {
            this.field_146.remove(var1);
         } else {
            this.field_146.put(var1, var2);
         }
      }
   }

   public void setLabels(HashMap<String, String> var1) {
      if(this.field_145.isEnabled() && var1 != null) {
         if(this.field_146 == null) {
            this.field_146 = Utils.mapOfStrings(var1);
         } else {
            this.field_146.putAll(Utils.mapOfStrings(var1));
         }
      }
   }

   public void setPauseOnBufferingEnabled(boolean var1) {
      if(this.field_145.isEnabled()) {
         this.field_154 = var1;
      }
   }

   public void setPauseOnBufferingInterval(int var1) {
      if(this.field_145.isEnabled()) {
         this.field_169 = var1;
      }
   }

   public void setPausePlaySwitchDelayEnabled(boolean var1) {
      if(this.field_145.isEnabled()) {
         this.field_161 = var1;
      }
   }

   public String setPixelURL(String var1) {
      if(!this.field_145.isEnabled()) {
         return this.field_147;
      } else if(var1 != null && var1.length() != 0) {
         int var2 = var1.indexOf(63);
         if(var2 >= 0) {
            if(var2 < -1 + var1.length()) {
               String[] var3 = var1.substring(var2 + 1).split("&");
               int var4 = var3.length;

               for(int var5 = 0; var5 < var4; ++var5) {
                  String[] var6 = var3[var5].split("=");
                  if(var6.length == 2) {
                     this.setLabel(var6[0], var6[1]);
                  } else if(var6.length == 1) {
                     this.setLabel("name", var6[0]);
                  }
               }

               var1 = var1.substring(0, var2 + 1);
            }
         } else {
            var1 = var1 + '?';
         }

         this.field_147 = var1;
         return this.field_147;
      } else {
         return null;
      }
   }

   public Boolean setPlaylist(HashMap<String, String> var1) {
      Boolean var2;
      if(!this.field_145.isEnabled()) {
         var2 = Boolean.FALSE;
      } else {
         var2 = Boolean.FALSE;
         if(this.field_150 == StreamSenseState.IDLE) {
            this.field_152.method_301();
            this.field_152.reset();
            this.field_152.getClip().reset();
            this.field_152.method_285(Utils.mapOfStrings(var1), (StreamSenseState)null);
            return Boolean.TRUE;
         }
      }

      return var2;
   }
}
