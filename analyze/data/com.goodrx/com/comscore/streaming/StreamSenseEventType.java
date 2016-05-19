package com.comscore.streaming;

public enum StreamSenseEventType {
   AD_CLICK("ad_click", 10),
   AD_END("ad_end", 9),
   AD_PAUSE("ad_pause", 8),
   AD_PLAY("ad_play", 7),
   BUFFER("buffer", 3),
   CUSTOM("custom", 6),
   END("end", 2),
   HEART_BEAT("hb", 5),
   KEEP_ALIVE("keep-alive", 4),
   PAUSE("pause", 1),
   PLAY("play", 0);

   // $FF: renamed from: a java.lang.String
   private String field_413;
   // $FF: renamed from: b int
   private int field_414;

   static {
      StreamSenseEventType[] var0 = new StreamSenseEventType[]{PLAY, PAUSE, END, BUFFER, KEEP_ALIVE, HEART_BEAT, CUSTOM, AD_PLAY, AD_PAUSE, AD_END, AD_CLICK};
   }

   private StreamSenseEventType(String var3, int var4) {
      this.field_413 = var3;
      this.field_414 = var4;
   }

   public int getCode() {
      return this.field_414;
   }

   public String getName() {
      return this.field_413;
   }

   public String toString() {
      return this.getName();
   }
}
