package com.comscore.streaming;

import com.comscore.streaming.StreamSenseClip;
import com.comscore.streaming.StreamSenseEventType;
import com.comscore.streaming.StreamSenseState;
import com.comscore.streaming.StreamSenseUtils;
import com.comscore.utils.CSLog;
import java.util.HashMap;
import java.util.Set;

public class StreamSensePlaylist {
   // $FF: renamed from: a com.comscore.streaming.StreamSenseClip
   private StreamSenseClip field_390 = null;
   // $FF: renamed from: b java.lang.String
   private String field_391;
   // $FF: renamed from: c int
   private int field_392;
   // $FF: renamed from: d int
   private int field_393;
   // $FF: renamed from: e int
   private int field_394;
   // $FF: renamed from: f long
   private long field_395;
   // $FF: renamed from: g long
   private long field_396;
   // $FF: renamed from: h java.util.HashMap
   private HashMap<String, String> field_397;
   // $FF: renamed from: i int
   private int field_398;
   // $FF: renamed from: j boolean
   private boolean field_399 = false;

   public StreamSensePlaylist() {
      this.field_390 = new StreamSenseClip();
      this.field_397 = new HashMap();
      this.reset();
   }

   // $FF: renamed from: a () int
   protected int method_281() {
      return this.field_392;
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseEventType, java.util.HashMap) java.util.HashMap
   protected HashMap<String, String> method_282(StreamSenseEventType var1, HashMap<String, String> var2) {
      if(var2 == null) {
         var2 = new HashMap();
      }

      var2.put("ns_st_bp", String.valueOf(this.method_291()));
      var2.put("ns_st_sp", String.valueOf(this.field_392));
      var2.put("ns_st_id", String.valueOf(this.field_391));
      if(this.field_394 > 0) {
         var2.put("ns_st_bc", String.valueOf(this.field_394));
      }

      if(var1 == StreamSenseEventType.PAUSE || var1 == StreamSenseEventType.END || var1 == StreamSenseEventType.KEEP_ALIVE || var1 == StreamSenseEventType.HEART_BEAT || var1 == null) {
         var2.put("ns_st_pa", String.valueOf(this.method_294()));
         var2.put("ns_st_pp", String.valueOf(this.field_393));
      }

      if((var1 == StreamSenseEventType.PLAY || var1 == null) && !this.method_302()) {
         var2.put("ns_st_pb", "1");
         this.method_286(true);
      }

      var2.putAll(this.getLabels());
      return var2;
   }

   // $FF: renamed from: a (int) void
   protected void method_283(int var1) {
      this.field_392 = var1;
   }

   // $FF: renamed from: a (long) void
   protected void method_284(long var1) {
      CSLog.method_372(this, "addPlaybackTime(" + var1 + ")");
      if(this.field_390.getPlaybackTimestamp() >= 0L) {
         long var3 = var1 - this.field_390.getPlaybackTimestamp();
         this.field_390.method_464(-1L);
         this.field_390.method_461(var3 + this.field_390.method_468());
         this.method_296(var3 + this.method_294());
         CSLog.method_372(this, "addPlaybackTime(" + var1 + ") ->" + var3);
      }

   }

   // $FF: renamed from: a (java.util.HashMap, com.comscore.streaming.StreamSenseState) void
   protected void method_285(HashMap<String, String> var1, StreamSenseState var2) {
      if(var1 != null) {
         this.field_397.putAll(var1);
      }

      this.method_290(this.field_397, var2);
   }

   // $FF: renamed from: a (boolean) void
   protected void method_286(boolean var1) {
      this.field_399 = var1;
   }

   // $FF: renamed from: b () void
   protected void method_287() {
      ++this.field_392;
   }

   // $FF: renamed from: b (int) void
   protected void method_288(int var1) {
      this.field_393 = var1;
   }

   // $FF: renamed from: b (long) void
   protected void method_289(long var1) {
      CSLog.method_372(this, "addBufferingTime(" + var1 + ")");
      if(this.field_390.method_469() >= 0L) {
         long var3 = var1 - this.field_390.method_469();
         this.field_390.method_466(-1L);
         this.field_390.method_457(var3 + this.field_390.method_467());
         this.method_293(var3 + this.method_291());
         CSLog.method_372(this, "addBufferingTime(" + var1 + ") ->" + var3);
      }

   }

   // $FF: renamed from: b (java.util.HashMap, com.comscore.streaming.StreamSenseState) void
   protected void method_290(HashMap<String, String> var1, StreamSenseState var2) {
      String var3 = (String)var1.get("ns_st_sp");
      if(var3 != null) {
         try {
            this.field_392 = Integer.parseInt(var3);
            var1.remove("ns_st_sp");
         } catch (NumberFormatException var23) {
            ;
         }
      }

      String var4 = (String)var1.get("ns_st_bc");
      if(var4 != null) {
         try {
            this.field_394 = Integer.parseInt(var4);
            var1.remove("ns_st_bc");
         } catch (NumberFormatException var22) {
            ;
         }
      }

      String var5 = (String)var1.get("ns_st_bp");
      if(var5 != null) {
         try {
            this.field_395 = Long.parseLong(var5);
            var1.remove("ns_st_bp");
         } catch (NumberFormatException var21) {
            ;
         }
      }

      String var6 = (String)var1.get("ns_st_id");
      if(var6 != null) {
         this.field_391 = var6;
         var1.remove("ns_st_id");
      }

      if(var2 != StreamSenseState.BUFFERING) {
         String var10 = (String)var1.get("ns_st_pa");
         if(var10 != null) {
            try {
               this.field_396 = Long.parseLong(var10);
               var1.remove("ns_st_pa");
            } catch (NumberFormatException var20) {
               ;
            }
         }
      }

      if(var2 == StreamSenseState.PAUSED || var2 == StreamSenseState.IDLE || var2 == null) {
         String var7 = (String)var1.get("ns_st_pp");
         if(var7 != null) {
            try {
               this.field_393 = Integer.parseInt(var7);
               var1.remove("ns_st_pp");
            } catch (NumberFormatException var19) {
               return;
            }
         }
      }

   }

   // $FF: renamed from: c () long
   protected long method_291() {
      long var1 = this.field_395;
      if(this.field_390.method_469() >= 0L) {
         var1 += System.currentTimeMillis() - this.field_390.method_469();
      }

      return var1;
   }

   // $FF: renamed from: c (int) void
   protected void method_292(int var1) {
      this.field_394 = var1;
   }

   // $FF: renamed from: c (long) void
   protected void method_293(long var1) {
      this.field_395 = var1;
   }

   // $FF: renamed from: d () long
   protected long method_294() {
      long var1 = this.field_396;
      if(this.field_390.getPlaybackTimestamp() >= 0L) {
         var1 += System.currentTimeMillis() - this.field_390.getPlaybackTimestamp();
      }

      return var1;
   }

   // $FF: renamed from: d (int) void
   protected void method_295(int var1) {
      this.field_398 = var1;
   }

   // $FF: renamed from: d (long) void
   protected void method_296(long var1) {
      this.field_396 = var1;
   }

   // $FF: renamed from: e () int
   protected int method_297() {
      return this.field_393;
   }

   // $FF: renamed from: f () void
   protected void method_298() {
      ++this.field_393;
      this.field_390.method_459();
   }

   // $FF: renamed from: g () int
   protected int method_299() {
      return this.field_394;
   }

   public StreamSenseClip getClip() {
      return this.field_390;
   }

   public String getLabel(String var1) {
      return (String)this.field_397.get(var1);
   }

   public HashMap<String, String> getLabels() {
      return this.field_397;
   }

   public String getPlaylistId() {
      return this.field_391;
   }

   // $FF: renamed from: h () void
   protected void method_300() {
      ++this.field_394;
   }

   // $FF: renamed from: i () void
   protected void method_301() {
      ++this.field_398;
   }

   // $FF: renamed from: j () boolean
   protected boolean method_302() {
      return this.field_399;
   }

   public void reset() {
      this.reset((Set)null);
   }

   public void reset(Set<String> var1) {
      if(var1 != null && !var1.isEmpty()) {
         StreamSenseUtils.filterMap(this.field_397, var1);
      } else {
         this.field_397.clear();
      }

      this.setPlaylistId(System.currentTimeMillis() + "_" + this.field_398);
      this.method_293(0L);
      this.method_296(0L);
      this.method_288(0);
      this.method_283(0);
      this.method_292(0);
      this.field_399 = false;
   }

   public void setLabel(String var1, String var2) {
      HashMap var3 = new HashMap();
      var3.put(var1, var2);
      this.method_285(var3, (StreamSenseState)null);
   }

   public void setLabels(HashMap<String, String> var1) {
      this.method_285(var1, (StreamSenseState)null);
   }

   public void setPlaylistId(String var1) {
      this.field_391 = var1;
   }
}
