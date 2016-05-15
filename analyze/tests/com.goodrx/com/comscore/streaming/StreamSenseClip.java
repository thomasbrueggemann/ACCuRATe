package com.comscore.streaming;

import com.comscore.streaming.StreamSenseEventType;
import com.comscore.streaming.StreamSenseState;
import com.comscore.streaming.StreamSenseUtils;
import com.comscore.utils.Utils;
import java.util.HashMap;
import java.util.Set;

public class StreamSenseClip {
   // $FF: renamed from: a java.util.HashMap
   HashMap<String, String> field_516 = new HashMap();
   // $FF: renamed from: b int
   private int field_517;
   // $FF: renamed from: c int
   private int field_518;
   // $FF: renamed from: d long
   private long field_519;
   // $FF: renamed from: e long
   private long field_520;
   // $FF: renamed from: f long
   private long field_521;
   // $FF: renamed from: g long
   private long field_522;
   // $FF: renamed from: h java.lang.String
   private String field_523;

   public StreamSenseClip() {
      this.reset();
   }

   // $FF: renamed from: a (java.lang.String, java.util.HashMap) void
   private void method_453(String var1, HashMap<String, String> var2) {
      String var3 = (String)var2.get(var1);
      if(var3 != null) {
         this.field_516.put(var1, var3);
      }

   }

   // $FF: renamed from: a () int
   protected int method_454() {
      return this.field_517;
   }

   // $FF: renamed from: a (com.comscore.streaming.StreamSenseEventType, java.util.HashMap) java.util.HashMap
   protected HashMap<String, String> method_455(StreamSenseEventType var1, HashMap<String, String> var2) {
      if(var2 == null) {
         var2 = new HashMap();
      }

      var2.put("ns_st_cn", this.getClipId());
      var2.put("ns_st_bt", String.valueOf(this.method_467()));
      if(var1 == StreamSenseEventType.PLAY || var1 == null) {
         var2.put("ns_st_sq", String.valueOf(this.field_518));
      }

      if(var1 == StreamSenseEventType.PAUSE || var1 == StreamSenseEventType.END || var1 == StreamSenseEventType.KEEP_ALIVE || var1 == StreamSenseEventType.HEART_BEAT || var1 == null) {
         var2.put("ns_st_pt", String.valueOf(this.method_468()));
         var2.put("ns_st_pc", String.valueOf(this.field_517));
      }

      var2.putAll(this.getLabels());
      return var2;
   }

   // $FF: renamed from: a (int) void
   protected void method_456(int var1) {
      this.field_517 = var1;
   }

   // $FF: renamed from: a (long) void
   protected void method_457(long var1) {
      this.field_519 = var1;
   }

   // $FF: renamed from: a (java.util.HashMap, com.comscore.streaming.StreamSenseState) void
   protected void method_458(HashMap<String, String> var1, StreamSenseState var2) {
      if(var1 != null) {
         this.field_516.putAll(var1);
      }

      this.method_462(this.field_516, var2);
   }

   // $FF: renamed from: b () void
   protected void method_459() {
      ++this.field_517;
   }

   // $FF: renamed from: b (int) void
   protected void method_460(int var1) {
      this.field_518 = var1;
   }

   // $FF: renamed from: b (long) void
   protected void method_461(long var1) {
      this.field_521 = var1;
   }

   // $FF: renamed from: b (java.util.HashMap, com.comscore.streaming.StreamSenseState) void
   protected void method_462(HashMap<String, String> var1, StreamSenseState var2) {
      String var3 = (String)var1.get("ns_st_cn");
      if(var3 != null) {
         this.setClipId(var3);
         var1.remove("ns_st_cn");
      }

      String var4 = (String)var1.get("ns_st_bt");
      if(var4 != null) {
         try {
            this.field_519 = Long.parseLong(var4);
            var1.remove("ns_st_bt");
         } catch (NumberFormatException var18) {
            ;
         }
      }

      this.method_453("ns_st_cl", var1);
      this.method_453("ns_st_pn", var1);
      this.method_453("ns_st_tp", var1);
      this.method_453("ns_st_ub", var1);
      this.method_453("ns_st_br", var1);
      if(var2 == StreamSenseState.PLAYING || var2 == null) {
         String var5 = (String)var1.get("ns_st_sq");
         if(var5 != null) {
            try {
               this.field_518 = Integer.parseInt(var5);
               var1.remove("ns_st_sq");
            } catch (NumberFormatException var17) {
               ;
            }
         }
      }

      if(var2 != StreamSenseState.BUFFERING) {
         String var9 = (String)var1.get("ns_st_pt");
         if(var9 != null) {
            try {
               this.field_521 = Long.parseLong(var9);
               var1.remove("ns_st_pt");
            } catch (NumberFormatException var16) {
               ;
            }
         }
      }

      if(var2 == StreamSenseState.PAUSED || var2 == StreamSenseState.IDLE || var2 == null) {
         String var6 = (String)var1.get("ns_st_pc");
         if(var6 != null) {
            try {
               this.field_517 = Integer.parseInt(var6);
               var1.remove("ns_st_pc");
            } catch (NumberFormatException var15) {
               return;
            }
         }
      }

   }

   // $FF: renamed from: c () int
   protected int method_463() {
      return this.field_518;
   }

   // $FF: renamed from: c (long) void
   protected void method_464(long var1) {
      this.field_522 = var1;
   }

   // $FF: renamed from: d () void
   protected void method_465() {
      ++this.field_518;
   }

   // $FF: renamed from: d (long) void
   protected void method_466(long var1) {
      this.field_520 = var1;
   }

   // $FF: renamed from: e () long
   protected long method_467() {
      long var1 = this.field_519;
      if(this.field_520 >= 0L) {
         var1 += System.currentTimeMillis() - this.field_520;
      }

      return var1;
   }

   // $FF: renamed from: f () long
   protected long method_468() {
      long var1 = this.field_521;
      if(this.field_522 >= 0L) {
         var1 += System.currentTimeMillis() - this.field_522;
      }

      return var1;
   }

   // $FF: renamed from: g () long
   protected long method_469() {
      return this.field_520;
   }

   public String getClipId() {
      if(Utils.isEmpty(this.field_523)) {
         this.setClipId("1");
      }

      return this.field_523;
   }

   public String getLabel(String var1) {
      return (String)this.field_516.get(var1);
   }

   public HashMap<String, String> getLabels() {
      return this.field_516;
   }

   public long getPlaybackTimestamp() {
      return this.field_522;
   }

   public void reset() {
      this.reset((Set)null);
   }

   public void reset(Set<String> var1) {
      if(var1 != null && !var1.isEmpty()) {
         StreamSenseUtils.filterMap(this.field_516, var1);
      } else {
         this.field_516.clear();
      }

      if(!this.field_516.containsKey("ns_st_cl")) {
         this.field_516.put("ns_st_cl", "0");
      }

      if(!this.field_516.containsKey("ns_st_pn")) {
         this.field_516.put("ns_st_pn", "1");
      }

      if(!this.field_516.containsKey("ns_st_tp")) {
         this.field_516.put("ns_st_tp", "1");
      }

      this.method_456(0);
      this.method_460(0);
      this.method_457(0L);
      this.method_466(-1L);
      this.method_461(0L);
      this.method_464(-1L);
   }

   public void setClipId(String var1) {
      this.field_523 = var1;
   }

   public void setLabel(String var1, String var2) {
      HashMap var3 = new HashMap();
      var3.put(var1, var2);
      this.method_458(var3, (StreamSenseState)null);
   }

   public void setLabels(HashMap<String, String> var1) {
      this.method_458(var1, (StreamSenseState)null);
   }
}
