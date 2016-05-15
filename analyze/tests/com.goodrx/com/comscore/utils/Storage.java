package com.comscore.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.comscore.utils.class_17;
import java.util.HashMap;
import java.util.HashSet;

public class Storage {
   public static final String APP_NAME_KEY = "appName";
   // $FF: renamed from: h java.lang.String
   private static final String field_432 = "cSPrefs";
   // $FF: renamed from: i long
   private static final long field_433 = 300L;
   // $FF: renamed from: a android.content.SharedPreferences
   protected SharedPreferences field_434;
   // $FF: renamed from: b java.util.HashMap
   protected final HashMap<String, String> field_435;
   // $FF: renamed from: c java.util.HashSet
   protected final HashSet<String> field_436;
   // $FF: renamed from: d java.lang.Object
   protected final Object field_437;
   // $FF: renamed from: e java.lang.Object
   protected final Object field_438;
   // $FF: renamed from: f long
   protected long field_439;
   // $FF: renamed from: g boolean
   protected boolean field_440;
   // $FF: renamed from: j java.lang.Runnable
   private final Runnable field_441;

   public Storage(Context var1) {
      this(var1, "cSPrefs");
   }

   public Storage(Context var1, String var2) {
      this.field_435 = new HashMap();
      this.field_436 = new HashSet();
      this.field_437 = new Object();
      this.field_438 = new Object();
      this.field_439 = -1L;
      this.field_440 = false;
      this.field_441 = new class_17(this);
      this.method_336(var1, var2);
   }

   // $FF: renamed from: a () void
   protected void method_335() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String) void
   protected void method_336(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void add(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b () void
   protected void method_337() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c () void
   protected void method_338() {
      // $FF: Couldn't be decompiled
   }

   public void clear() {
      // $FF: Couldn't be decompiled
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   public String get(String param1) {
      // $FF: Couldn't be decompiled
   }

   public Boolean has(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void remove(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void set(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }
}
