package com.parse;

enum PushType {
   GCM("gcm"),
   NONE("none"),
   PPNS("ppns");

   private final String pushType;

   static {
      PushType[] var0 = new PushType[]{NONE, PPNS, GCM};
   }

   private PushType(String var3) {
      this.pushType = var3;
   }

   static PushType fromString(String var0) {
      return "none".equals(var0)?NONE:("ppns".equals(var0)?PPNS:("gcm".equals(var0)?GCM:null));
   }

   public String toString() {
      return this.pushType;
   }
}
