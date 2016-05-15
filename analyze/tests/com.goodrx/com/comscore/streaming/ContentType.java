package com.comscore.streaming;

public enum ContentType {
   Bumper("c99"),
   Live("c13"),
   LongFormOnDemand("c11"),
   Other("c00"),
   ShortFormOnDemand("c12"),
   UserGeneratedLive("c23"),
   UserGeneratedLongFormOnDemand("c21"),
   UserGeneratedShortFormOnDemand("c22");

   // $FF: renamed from: a java.lang.String
   private final String field_225;

   static {
      ContentType[] var0 = new ContentType[]{LongFormOnDemand, ShortFormOnDemand, Live, UserGeneratedLongFormOnDemand, UserGeneratedShortFormOnDemand, UserGeneratedLive, Bumper, Other};
   }

   private ContentType(String var3) {
      this.field_225 = var3;
   }

   // $FF: renamed from: a () java.lang.String
   protected String method_171() {
      return this.field_225;
   }
}
