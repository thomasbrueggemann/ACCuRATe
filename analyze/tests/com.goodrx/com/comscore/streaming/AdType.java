package com.comscore.streaming;

public enum AdType {
   LinearLive("a21"),
   LinearOnDemandMidRoll("a12"),
   LinearOnDemandPostRoll("a13"),
   LinearOnDemandPreRoll("a11"),
   Other("a00");

   // $FF: renamed from: a java.lang.String
   private final String field_514;

   static {
      AdType[] var0 = new AdType[]{LinearOnDemandPreRoll, LinearOnDemandMidRoll, LinearOnDemandPostRoll, LinearLive, Other};
   }

   private AdType(String var3) {
      this.field_514 = var3;
   }

   // $FF: renamed from: a () java.lang.String
   protected String method_447() {
      return this.field_514;
   }
}
