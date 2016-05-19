package com.comscore.android.id;

public class DeviceId {
   // $FF: renamed from: a java.lang.String
   private String field_528;
   // $FF: renamed from: b java.lang.String
   private String field_529;
   // $FF: renamed from: c int
   private int field_530;
   // $FF: renamed from: d int
   private int field_531;

   public DeviceId(String var1) {
      this.field_529 = var1;
      this.field_530 = 0;
      this.field_531 = 0;
   }

   public DeviceId(String var1, int var2, int var3) {
      this.field_529 = var1;
      this.field_530 = var2;
      this.field_531 = var3;
   }

   public DeviceId(String var1, String var2, int var3, int var4) {
      this.field_528 = var1;
      this.field_529 = var2;
      this.field_530 = var3;
      this.field_531 = var4;
   }

   public int getCommonness() {
      return this.field_530;
   }

   public String getId() {
      return this.field_529;
   }

   public String getName() {
      return this.field_528;
   }

   public int getPersistency() {
      return this.field_531;
   }

   public String getSuffix() {
      return this.getCommonness() + "" + this.getPersistency();
   }
}
