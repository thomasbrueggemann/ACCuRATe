package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ec
class class_376 {
   // $FF: renamed from: qP java.util.List
   private final List<String> field_1630;
   // $FF: renamed from: qQ java.util.List
   private final List<String> field_1631;
   // $FF: renamed from: qR java.lang.String
   private final String field_1632;
   // $FF: renamed from: qS java.lang.String
   private final String field_1633;
   // $FF: renamed from: qT java.lang.String
   private final String field_1634;
   // $FF: renamed from: qU java.lang.String
   private final String field_1635;
   // $FF: renamed from: qV java.lang.String
   private final String field_1636;
   // $FF: renamed from: qW boolean
   private final boolean field_1637;
   // $FF: renamed from: qX int
   private final int field_1638;

   public class_376(Map<String, String> var1) {
      this.field_1636 = (String)var1.get("url");
      this.field_1633 = (String)var1.get("base_uri");
      this.field_1634 = (String)var1.get("post_parameters");
      this.field_1637 = parseBoolean((String)var1.get("drt_include"));
      this.field_1632 = (String)var1.get("activation_overlay_url");
      this.field_1631 = this.method_2398((String)var1.get("check_packages"));
      this.field_1638 = this.parseInt((String)var1.get("request_id"));
      this.field_1635 = (String)var1.get("type");
      this.field_1630 = this.method_2398((String)var1.get("errors"));
   }

   private static boolean parseBoolean(String var0) {
      return var0 != null && (var0.equals("1") || var0.equals("true"));
   }

   private int parseInt(String var1) {
      return var1 == null?0:Integer.parseInt(var1);
   }

   // $FF: renamed from: t (java.lang.String) java.util.List
   private List<String> method_2398(String var1) {
      return var1 == null?null:Arrays.asList(var1.split(","));
   }

   // $FF: renamed from: bt () java.util.List
   public List<String> method_2399() {
      return this.field_1630;
   }

   // $FF: renamed from: bu () java.lang.String
   public String method_2400() {
      return this.field_1634;
   }

   // $FF: renamed from: bv () boolean
   public boolean method_2401() {
      return this.field_1637;
   }

   public String getType() {
      return this.field_1635;
   }

   public String getUrl() {
      return this.field_1636;
   }
}
