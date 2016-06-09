package com.comscore.streaming;

import com.comscore.streaming.AdType;
import com.comscore.streaming.ContentType;
import com.comscore.streaming.StreamSense;
import com.comscore.streaming.StreamSenseEventType;
import com.comscore.streaming.StreamSenseState;
import com.comscore.streaming.class_59;
import com.comscore.streaming.p;
import com.comscore.utils.Date;
import com.comscore.utils.Utils;
import java.util.HashMap;

public class StreamingTag {
   // $FF: renamed from: a java.lang.String[]
   private String[] field_537 = new String[]{"ns_st_ci", "c3", "c4", "c6", "ns_st_st", "ns_st_pu", "ns_st_pr", "ns_st_ep", "ns_st_sn", "ns_st_en", "ns_st_ct"};
   // $FF: renamed from: b com.comscore.streaming.StreamSense
   private StreamSense field_538;
   // $FF: renamed from: c long
   private long field_539 = 0L;
   // $FF: renamed from: d long
   private long field_540 = 0L;
   // $FF: renamed from: e int
   private int field_541 = 0;
   // $FF: renamed from: f java.util.HashMap
   private HashMap<String, String> field_542 = null;
   // $FF: renamed from: g com.comscore.streaming.p
   private class_59 field_543;
   // $FF: renamed from: h boolean
   private boolean field_544 = false;

   public StreamingTag() {
      this.field_543 = class_59.None;
      this.field_538 = new StreamSense();
      this.field_538.setLabel("ns_st_it", "r");
   }

   // $FF: renamed from: a (java.util.HashMap) java.util.HashMap
   private HashMap<String, String> method_479(HashMap<String, String> var1) {
      HashMap var2 = Utils.mapOfStrings(var1);
      String[] var3 = this.field_537;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var3[var5];
         if(!var2.containsKey(var6)) {
            if(var6 == "ns_st_ci") {
               var2.put(var6, "0");
            } else {
               var2.put(var6, "*null");
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: a (long) void
   private void method_480(long var1) {
      if(this.field_538.getState() != StreamSenseState.IDLE && this.field_538.getState() != StreamSenseState.PAUSED) {
         this.field_538.notify(StreamSenseEventType.END, this.method_484(var1));
      } else if(this.field_538.getState() == StreamSenseState.PAUSED) {
         this.field_538.notify(StreamSenseEventType.END, this.field_540);
         return;
      }

   }

   // $FF: renamed from: a (long, java.util.HashMap) void
   private void method_481(long var1, HashMap<String, String> var3) {
      this.method_480(var1);
      ++this.field_541;
      if(!var3.containsKey("ns_st_cn")) {
         var3.put("ns_st_cn", String.valueOf(this.field_541));
      }

      if(!var3.containsKey("ns_st_pn")) {
         var3.put("ns_st_pn", "1");
      }

      if(!var3.containsKey("ns_st_tp")) {
         var3.put("ns_st_tp", "0");
      }

      this.field_538.setClip(var3);
      this.field_542 = var3;
      this.field_539 = var1;
      this.field_540 = 0L;
      this.field_538.notify(StreamSenseEventType.PLAY, this.field_540);
   }

   // $FF: renamed from: a (java.util.HashMap, com.comscore.streaming.p) void
   private void method_482(HashMap<String, String> var1, p var2) {
      long var3 = Date.unixTime();
      HashMap var5 = this.method_479(Utils.mapOfStrings(var1));
      if(this.field_543 == class_59.None) {
         this.field_543 = var2;
      }

      if(this.field_544 && this.field_543 == var2) {
         if(!this.method_486(var5)) {
            this.method_481(var3, var5);
         } else {
            this.field_538.getClip().setLabels(var5);
            if(this.field_538.getState() != StreamSenseState.PLAYING) {
               this.field_539 = var3;
               this.field_538.notify(StreamSenseEventType.PLAY, this.field_540);
            }
         }
      } else {
         this.method_481(var3, var5);
      }

      this.field_544 = true;
      this.field_543 = var2;
   }

   // $FF: renamed from: a (java.lang.String, java.util.HashMap, java.util.HashMap) boolean
   private boolean method_483(String var1, HashMap<String, String> var2, HashMap<String, String> var3) {
      boolean var4 = true;
      if(var1 != null) {
         boolean var5;
         if(var2 != null) {
            var5 = var4;
         } else {
            var5 = false;
         }

         if(var3 == null) {
            var4 = false;
         }

         if(var4 & var5) {
            String var6 = (String)var2.get(var1);
            String var7 = (String)var3.get(var1);
            if(var6 != null && var7 != null) {
               return var6.equals(var7);
            }
         }
      }

      return false;
   }

   // $FF: renamed from: b (long) long
   private long method_484(long var1) {
      if(this.field_539 > 0L && var1 >= this.field_539) {
         this.field_540 += var1 - this.field_539;
      } else {
         this.field_540 = 0L;
      }

      return this.field_540;
   }

   // $FF: renamed from: b (java.util.HashMap) void
   private void method_485(HashMap<String, String> var1) {
      long var2 = Date.unixTime();
      this.method_480(var2);
      ++this.field_541;
      HashMap var4 = this.method_479(Utils.mapOfStrings(var1));
      if(!var4.containsKey("ns_st_cn")) {
         var4.put("ns_st_cn", String.valueOf(this.field_541));
      }

      if(!var4.containsKey("ns_st_pn")) {
         var4.put("ns_st_pn", "1");
      }

      if(!var4.containsKey("ns_st_tp")) {
         var4.put("ns_st_tp", "1");
      }

      if(!var4.containsKey("ns_st_ad")) {
         var4.put("ns_st_ad", "1");
      }

      this.field_538.setClip(var4);
      this.field_540 = 0L;
      this.field_538.notify(StreamSenseEventType.PLAY, this.field_540);
      this.field_539 = var2;
      this.field_544 = false;
   }

   // $FF: renamed from: c (java.util.HashMap) boolean
   private boolean method_486(HashMap<String, String> var1) {
      HashMap var2 = this.method_479(Utils.mapOfStrings(var1));
      String[] var3 = this.field_537;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         if(!this.method_483(var3[var5], this.field_542, var2)) {
            return false;
         }
      }

      return true;
   }

   @Deprecated
   public void playAdvertisement() {
      HashMap var1 = new HashMap();
      var1.put("ns_st_ct", "va");
      this.method_485(var1);
   }

   @Deprecated
   public void playAudioAdvertisement() {
      this.playAudioAdvertisement(new HashMap());
   }

   @Deprecated
   public void playAudioAdvertisement(HashMap<String, String> var1) {
      this.playAudioAdvertisement(var1, (AdType)null);
   }

   public void playAudioAdvertisement(HashMap<String, String> var1, AdType var2) {
      HashMap var3 = new HashMap();
      if(var1 != null) {
         var3.putAll(var1);
      }

      if(!var3.containsKey("ns_st_ct")) {
         String var4;
         if(var2 == null) {
            var4 = "a" + "a";
         } else {
            var4 = "a" + var2.method_447();
         }

         var3.put("ns_st_ct", var4);
      }

      this.method_485(var3);
   }

   @Deprecated
   public void playAudioContentPart(HashMap<String, String> var1) {
      this.playAudioContentPart(var1, (ContentType)null);
   }

   public void playAudioContentPart(HashMap<String, String> var1, ContentType var2) {
      HashMap var3 = new HashMap();
      if(var1 != null) {
         var3.putAll(var1);
      }

      if(!var3.containsKey("ns_st_ct")) {
         String var4;
         if(var2 == null) {
            var4 = "a" + "c";
         } else {
            var4 = "a" + var2.method_171();
         }

         var3.put("ns_st_ct", var4);
      }

      this.method_482(var3, class_59.AudioContent);
   }

   @Deprecated
   public void playContentPart(HashMap<String, String> var1) {
      HashMap var2 = new HashMap();
      if(var1 != null) {
         var2.putAll(var1);
      }

      if(!var2.containsKey("ns_st_ct")) {
         var2.put("ns_st_ct", "vc");
      }

      this.method_482(var2, class_59.VideoContent);
   }

   @Deprecated
   public void playVideoAdvertisement() {
      this.playVideoAdvertisement(new HashMap());
   }

   @Deprecated
   public void playVideoAdvertisement(HashMap<String, String> var1) {
      this.playVideoAdvertisement(var1, (AdType)null);
   }

   public void playVideoAdvertisement(HashMap<String, String> var1, AdType var2) {
      HashMap var3 = new HashMap();
      if(var1 != null) {
         var3.putAll(var1);
      }

      if(!var3.containsKey("ns_st_ct")) {
         String var4;
         if(var2 == null) {
            var4 = "v" + "a";
         } else {
            var4 = "v" + var2.method_447();
         }

         var3.put("ns_st_ct", var4);
      }

      this.method_485(var3);
   }

   @Deprecated
   public void playVideoContentPart(HashMap<String, String> var1) {
      this.playVideoContentPart(var1, (ContentType)null);
   }

   public void playVideoContentPart(HashMap<String, String> var1, ContentType var2) {
      HashMap var3 = new HashMap();
      if(var1 != null) {
         var3.putAll(var1);
      }

      if(!var3.containsKey("ns_st_ct")) {
         String var4;
         if(var2 == null) {
            var4 = "v" + "c";
         } else {
            var4 = "v" + var2.method_171();
         }

         var3.put("ns_st_ct", var4);
      }

      this.method_482(var3, class_59.VideoContent);
   }

   public void stop() {
      long var1 = Date.unixTime();
      this.field_538.notify(StreamSenseEventType.PAUSE, this.method_484(var1));
   }
}
