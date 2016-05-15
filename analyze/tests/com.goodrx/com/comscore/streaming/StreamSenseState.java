package com.comscore.streaming;

import com.comscore.streaming.StreamSenseEventType;

public enum StreamSenseState {
   BUFFERING,
   IDLE,
   PAUSED,
   PLAYING;

   // $FF: renamed from: a java.lang.String
   private String field_471;
   // $FF: renamed from: b int
   private int field_472;
   // $FF: renamed from: c com.comscore.streaming.StreamSenseEventType
   private StreamSenseEventType field_473;

   static {
      IDLE = new StreamSenseState("IDLE", 0, "idle", 0, StreamSenseEventType.END);
      PLAYING = new StreamSenseState("PLAYING", 1, "playing", 1, StreamSenseEventType.PLAY);
      PAUSED = new StreamSenseState("PAUSED", 2, "paused", 2, StreamSenseEventType.PAUSE);
      BUFFERING = new StreamSenseState("BUFFERING", 3, "buffering", 3, StreamSenseEventType.BUFFER);
      StreamSenseState[] var0 = new StreamSenseState[]{IDLE, PLAYING, PAUSED, BUFFERING};
   }

   private StreamSenseState(String var3, int var4, StreamSenseEventType var5) {
      this.field_471 = var3;
      this.field_472 = var4;
      this.field_473 = var5;
   }

   public int getCode() {
      return this.field_472;
   }

   public String getName() {
      return this.field_471;
   }

   public StreamSenseEventType toEventType() {
      return this.field_473;
   }

   public String toString() {
      return this.getName();
   }
}
