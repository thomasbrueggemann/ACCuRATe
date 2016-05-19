package com.comscore.streaming.plugin;

import android.util.Log;
import com.comscore.streaming.StreamSense;
import com.comscore.streaming.StreamSenseClip;
import com.comscore.streaming.StreamSenseEventType;
import com.comscore.streaming.plugin.StreamSensePlayer;
import com.comscore.streaming.plugin.StreamSensePluginListener;
import com.comscore.streaming.plugin.class_2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamSensePlugin extends StreamSense {
   // $FF: renamed from: e float[][]
   private static final float[][] field_170 = new float[][]{{-1.0F, 1.0F}, {-0.5F, 0.0F, 0.5F}, {-0.3F, -0.1F, 0.1F, 0.3F}, {-0.2F, -0.1F, 0.0F, 0.1F, 0.2F}, {-0.14286F, -0.08571F, -0.02857F, 0.02857F, 0.08571F, 0.14286F}, {-0.10714F, -0.07143F, -0.03571F, 0.0F, 0.03571F, 0.07143F, 0.10714F}, {-0.08333F, -0.05952F, -0.03571F, -0.0119F, 0.0119F, 0.03571F, 0.05952F, 0.08333F}, {-0.06667F, -0.05F, -0.03333F, -0.01667F, 0.0F, 0.01667F, 0.03333F, 0.05F, 0.06667F}, {-0.05455F, -0.04242F, -0.0303F, -0.01818F, -0.00606F, 0.00606F, 0.01818F, 0.0303F, 0.04242F, 0.05455F}, {-0.04545F, -0.03636F, -0.02727F, -0.01818F, -0.00909F, 0.0F, 0.00909F, 0.01818F, 0.02727F, 0.03636F, 0.04545F}, {-0.03846F, -0.03147F, -0.02448F, -0.01748F, -0.01049F, -0.0035F, 0.0035F, 0.01049F, 0.01748F, 0.02448F, 0.03147F, 0.03846F}, {-0.03297F, -0.02747F, -0.02198F, -0.01648F, -0.01099F, -0.00549F, 0.0F, 0.00549F, 0.01099F, 0.01648F, 0.02198F, 0.02747F, 0.03297F}};
   // $FF: renamed from: A java.util.HashMap
   private HashMap<String, String> field_171 = new HashMap();
   // $FF: renamed from: B boolean
   private boolean field_172 = false;
   // $FF: renamed from: C boolean
   private boolean field_173 = false;
   // $FF: renamed from: D boolean
   private boolean field_174 = false;
   // $FF: renamed from: E java.lang.String
   private final String field_175 = "_all_";
   // $FF: renamed from: F java.lang.String[]
   private String[] field_176 = null;
   // $FF: renamed from: G int
   private int field_177 = -1;
   // $FF: renamed from: H java.lang.String[]
   private String[] field_178 = null;
   // $FF: renamed from: I int
   private int field_179 = -1;
   // $FF: renamed from: J java.util.HashMap
   private HashMap<String, String> field_180 = new HashMap();
   // $FF: renamed from: b java.lang.String
   private String field_181 = "1.0.1";
   // $FF: renamed from: c int
   private int field_182 = 10;
   // $FF: renamed from: d int
   private int field_183 = 500;
   // $FF: renamed from: f float
   private float field_184 = 1.25F;
   // $FF: renamed from: g int
   private int field_185 = 2;
   // $FF: renamed from: h int
   private int field_186 = 300;
   // $FF: renamed from: i int
   private int field_187 = 6;
   // $FF: renamed from: j java.lang.Runnable
   private Runnable field_188;
   // $FF: renamed from: k java.util.List
   private List<Long> field_189 = new ArrayList();
   // $FF: renamed from: l java.util.List
   private List<Long> field_190 = new ArrayList();
   // $FF: renamed from: m long
   private long field_191 = 0L;
   // $FF: renamed from: n boolean
   private boolean field_192 = false;
   // $FF: renamed from: o java.util.List
   private List<StreamSensePluginListener> field_193 = new ArrayList();
   // $FF: renamed from: p boolean
   private boolean field_194 = false;
   // $FF: renamed from: q boolean
   private boolean field_195 = false;
   // $FF: renamed from: r boolean
   private boolean field_196 = false;
   // $FF: renamed from: s boolean
   private boolean field_197 = false;
   // $FF: renamed from: t boolean
   private boolean field_198 = false;
   // $FF: renamed from: u com.comscore.streaming.plugin.StreamSensePlayer
   private StreamSensePlayer field_199;
   // $FF: renamed from: v boolean
   private boolean field_200 = false;
   // $FF: renamed from: w boolean
   private boolean field_201 = false;
   // $FF: renamed from: x boolean
   private boolean field_202 = false;
   // $FF: renamed from: y java.util.HashMap
   private HashMap<String, String> field_203 = new HashMap();
   // $FF: renamed from: z java.util.HashMap
   private HashMap<String, String> field_204 = new HashMap();

   public StreamSensePlugin(HashMap<String, String> var1, String var2, String var3, String var4) {
      if(var1 != null && var1.size() > 0) {
         this.method_136(var1);
      }

      this.setLabel("ns_st_mp", var2, true);
      this.setLabel("ns_st_pv", var3, true);
      this.setLabel("ns_st_mv", var4, true);
   }

   // $FF: renamed from: a (int) long
   private long method_122(int var1) {
      return ((Long)this.field_189.get(-1 + this.field_189.size() - var1)).longValue();
   }

   // $FF: renamed from: a (com.comscore.streaming.plugin.StreamSensePlugin, int) long
   // $FF: synthetic method
   static long method_123(StreamSensePlugin var0, int var1) {
      return var0.method_122(var1);
   }

   // $FF: renamed from: a (java.util.HashMap, java.util.HashMap) java.util.HashMap
   private HashMap<String, String> method_124(HashMap<String, HashMap<String, String>> var1, HashMap<String, String> var2) {
      HashMap var3 = new HashMap();
      HashMap var4;
      if(var2 != null && var2.size() > 0) {
         var4 = new HashMap(var2);
      } else {
         var4 = var3;
      }

      boolean var5;
      if(this.field_178 != null && this.field_178.length == 1 && this.field_178[0].equals("_all_")) {
         var5 = true;
      } else {
         var5 = false;
      }

      HashMap var6;
      if(var1.size() > 0) {
         if(!var5) {
            if(var4.size() > 0) {
               var4.putAll(this.method_138((HashMap)var1.get("")));
               var6 = var4;
            } else {
               var6 = this.method_138((HashMap)var1.get(""));
            }
         } else {
            var6 = var4;
         }

         Iterator var7 = ((HashMap)var1.get("")).keySet().iterator();

         while(true) {
            String var8;
            boolean var9;
            boolean var10;
            do {
               if(!var7.hasNext()) {
                  return var6;
               }

               var8 = (String)var7.next();
               var9 = Pattern.compile("^([Cc][A-Da-d]_)?ns_st_.+").matcher(var8).find();
               var10 = Pattern.compile("^[Cc][A-Da-d]?([1-9]|1[0-9]|20)$").matcher(var8).find();
            } while(!var9 && !var10);

            var6.put(var8, ((HashMap)var1.get("")).get(var8));
         }
      } else {
         var6 = var4;
         return var6;
      }
   }

   // $FF: renamed from: a (java.lang.String) void
   private void method_125(String var1) {
      if(var1 != null && var1.length() != 0) {
         Matcher var2 = Pattern.compile("([^=, ]+)\\s*=(\\s*(\'([^\']+?)\'|[a-z0-9\\._-]+)\\s*\\+?)+\\s*", 2).matcher(var1);

         while(var2.find()) {
            String[] var3 = var1.substring(var2.start(), var2.end()).split("=", 2);
            if(var3 != null && var3.length == 2) {
               String var4 = var3[0].replace(" ", "");
               if(var4 != null && var4.length() > 0) {
                  this.field_180.put(var4, var3[1]);
               }
            }
         }
      }

   }

   // $FF: renamed from: a (long) boolean
   private boolean method_126(long var1) {
      return Long.parseLong(this.getClip().getLabel("ns_st_cl")) > 0L && (var1 > Long.parseLong(this.getClip().getLabel("ns_st_cl")) || Math.abs(var1 - Long.parseLong(this.getClip().getLabel("ns_st_cl"))) < (long)this.field_183);
   }

   // $FF: renamed from: a (com.comscore.streaming.plugin.StreamSensePlugin) boolean
   // $FF: synthetic method
   static boolean method_127(StreamSensePlugin var0) {
      return var0.field_198;
   }

   // $FF: renamed from: a (com.comscore.streaming.plugin.StreamSensePlugin, long) boolean
   // $FF: synthetic method
   static boolean method_128(StreamSensePlugin var0, long var1) {
      return var0.method_126(var1);
   }

   // $FF: renamed from: a (com.comscore.streaming.plugin.StreamSensePlugin, boolean) boolean
   // $FF: synthetic method
   static boolean method_129(StreamSensePlugin var0, boolean var1) {
      var0.field_201 = var1;
      return var1;
   }

   // $FF: renamed from: b (int) long
   private long method_130(int var1) {
      return ((Long)this.field_190.get(-1 + this.field_190.size() - var1)).longValue();
   }

   // $FF: renamed from: b (com.comscore.streaming.plugin.StreamSensePlugin, int) long
   // $FF: synthetic method
   static long method_131(StreamSensePlugin var0, int var1) {
      return var0.method_130(var1);
   }

   // $FF: renamed from: b (com.comscore.streaming.plugin.StreamSensePlugin, long) long
   // $FF: synthetic method
   static long method_132(StreamSensePlugin var0, long var1) {
      var0.field_191 = var1;
      return var1;
   }

   // $FF: renamed from: b (com.comscore.streaming.plugin.StreamSensePlugin) com.comscore.streaming.plugin.StreamSensePlayer
   // $FF: synthetic method
   static StreamSensePlayer method_133(StreamSensePlugin var0) {
      return var0.field_199;
   }

   // $FF: renamed from: b (java.util.HashMap, java.util.HashMap) java.util.HashMap
   private HashMap<String, String> method_134(HashMap<String, HashMap<String, String>> param1, HashMap<String, String> param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.lang.String) void
   private void method_135(String var1) {
      if(var1 != null && var1.length() != 0) {
         String[] var2 = var1.split(",");
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String[] var5 = var2[var4].split("=", 2);
            if(var5.length == 2) {
               String var6 = var5[0].replace(" ", "");
               if(var6 != null && var6.length() > 0) {
                  String var7 = var5[1].replaceFirst("^\'+", "").replaceFirst("\'+$", "");
                  this.setLabel(var6, var7);
                  this.field_171.put(var6, var7);
               }
            }
         }
      }

   }

   // $FF: renamed from: b (java.util.HashMap) void
   private void method_136(HashMap<String, String> var1) {
      this.field_174 = Boolean.valueOf((String)var1.get("debug")).booleanValue();
      if(var1.containsKey("labelmapping")) {
         this.method_125((String)var1.get("labelmapping"));
      }

      if(var1.containsKey("persistentlabels")) {
         this.method_135((String)var1.get("persistentlabels"));
      }

      if(var1.containsKey("throttling") && Boolean.valueOf((String)var1.get("throttling")).booleanValue()) {
         this.setPausePlaySwitchDelayEnabled(true);
      } else {
         this.setPausePlaySwitchDelayEnabled(false);
      }

      if(var1.containsKey("include")) {
         String var9 = (String)var1.get("include");
         if(var9 == "_all_") {
            this.field_176 = new String[1];
            this.field_176[0] = "_all_";
         } else if(var9.length() > 0) {
            this.field_176 = var9.split(",");
         }
      }

      if((this.field_176 == null || this.field_176.length == 0 || !this.field_176[0].equals("_all_")) && var1.containsKey("include_prefixes")) {
         String var6 = (String)var1.get("include_prefixes");
         if(var6 != null && var6.length() > 0) {
            if(var6.equals("_all_")) {
               this.field_176 = new String[1];
               this.field_176[0] = "_all_";
            } else {
               if(this.field_176 == null) {
                  this.field_176 = new String[0];
               }

               this.field_177 = this.field_176.length;
               ArrayList var7 = new ArrayList(Arrays.asList(this.field_176));
               var7.addAll(Arrays.asList(var6.split(",")));
               this.field_176 = new String[var7.size()];
               this.field_176 = (String[])var7.toArray(this.field_176);
            }
         }
      }

      if(this.field_176 == null) {
         this.field_178 = new String[1];
         this.field_178[0] = "_all_";
      } else {
         if(var1.containsKey("exclude")) {
            String var5 = (String)var1.get("exclude");
            if(var5.equals("_all_")) {
               this.field_178 = new String[1];
               this.field_178[0] = "_all_";
            } else if(var5.length() > 0) {
               this.field_178 = var5.split(",");
            }
         }

         if((this.field_178 == null || this.field_178.length == 0 || !this.field_178[0].equals("_all_")) && var1.containsKey("exclude_prefixes")) {
            String var2 = (String)var1.get("exclude_prefixes");
            if(var2.equals("_all_")) {
               this.field_178 = new String[1];
               this.field_178[0] = "_all_";
               return;
            }

            if(this.field_178 == null) {
               this.field_178 = new String[0];
            }

            this.field_179 = this.field_178.length;
            ArrayList var3 = new ArrayList(Arrays.asList(this.field_178));
            var3.addAll(Arrays.asList(var2.split(",")));
            this.field_178 = new String[var3.size()];
            this.field_178 = (String[])var3.toArray(this.field_178);
            return;
         }
      }

   }

   // $FF: renamed from: b (com.comscore.streaming.plugin.StreamSensePlugin, boolean) boolean
   // $FF: synthetic method
   static boolean method_137(StreamSensePlugin var0, boolean var1) {
      var0.field_192 = var1;
      return var1;
   }

   // $FF: renamed from: c (java.util.HashMap) java.util.HashMap
   private HashMap<String, String> method_138(HashMap<String, String> var1) {
      HashMap var2 = new HashMap();
      HashMap var3 = new HashMap();
      HashMap var4;
      if(var1 != null && var1.size() > 0) {
         var4 = new HashMap(var1);
      } else {
         var4 = var3;
      }

      if(this.field_178 != null && this.field_178.length == 1 && this.field_178[0].equals("_all_")) {
         var4 = new HashMap();
      } else {
         HashMap var5;
         if(this.field_176 != null && this.field_176.length > 0 && !this.field_176[0].equals("_all_")) {
            int var18 = this.field_176.length;
            int var19 = 0;

            label126:
            while(true) {
               if(var19 >= var18) {
                  Iterator var20 = var2.keySet().iterator();

                  while(var20.hasNext()) {
                     String var21 = (String)var20.next();
                     if(!((Boolean)var2.get(var21)).booleanValue()) {
                        var4.remove(var21);
                     }
                  }

                  var5 = new HashMap();
                  break;
               }

               String var23 = this.field_176[var19];
               boolean var24;
               if(this.field_177 >= 0 && var19 >= this.field_177) {
                  var24 = true;
               } else {
                  var24 = false;
               }

               Iterator var25 = var4.keySet().iterator();

               while(true) {
                  String var26;
                  do {
                     if(!var25.hasNext()) {
                        ++var19;
                        continue label126;
                     }

                     var26 = (String)var25.next();
                  } while(var2.containsKey(var26));

                  boolean var27;
                  label120: {
                     label119: {
                        if(var24) {
                           if(var26.indexOf(var23) != 0) {
                              break label119;
                           }
                        } else if(!var26.equals(var23)) {
                           break label119;
                        }

                        var27 = true;
                        break label120;
                     }

                     var27 = false;
                  }

                  var2.put(var26, Boolean.valueOf(var27));
               }
            }
         } else {
            var5 = var2;
         }

         if(this.field_178 != null && this.field_178.length > 0) {
            int var6 = this.field_178.length;
            int var7 = 0;

            HashMap var13;
            label89:
            for(HashMap var8 = var5; var7 < var6; var8 = var13) {
               String var9 = this.field_178[var7];
               boolean var10;
               if(this.field_179 >= 0 && var7 >= this.field_179) {
                  var10 = true;
               } else {
                  var10 = false;
               }

               Iterator var11 = var4.keySet().iterator();

               while(true) {
                  String var16;
                  while(true) {
                     if(!var11.hasNext()) {
                        Iterator var12 = var8.keySet().iterator();

                        while(var12.hasNext()) {
                           String var14 = (String)var12.next();
                           if(var8.containsKey(var14) && var4.containsKey(var14)) {
                              var4.remove(var14);
                           }
                        }

                        var13 = new HashMap();
                        ++var7;
                        continue label89;
                     }

                     var16 = (String)var11.next();
                     if(var10) {
                        if(var16.indexOf(var9) == 0) {
                           break;
                        }
                     } else if(var16.equals(var9)) {
                        break;
                     }
                  }

                  var8.put(var16, Boolean.valueOf(true));
               }
            }
         }
      }

      return var4;
   }

   // $FF: renamed from: c () void
   private void method_139() {
      if(this.field_188 != null) {
         this.a.getTaskExecutor().removeEnqueuedTask(this.field_188);
         this.field_188 = null;
      }

   }

   // $FF: renamed from: c (com.comscore.streaming.plugin.StreamSensePlugin) void
   // $FF: synthetic method
   static void method_140(StreamSensePlugin var0) {
      var0.method_139();
   }

   // $FF: renamed from: c (com.comscore.streaming.plugin.StreamSensePlugin, boolean) boolean
   // $FF: synthetic method
   static boolean method_141(StreamSensePlugin var0, boolean var1) {
      var0.field_200 = var1;
      return var1;
   }

   // $FF: renamed from: d () void
   private void method_142() {
      this.method_139();
      if(this.field_198 && this.field_199 != null) {
         this.field_188 = this.method_144();
         this.a.getTaskExecutor().execute(this.field_188, 0L, true, (long)this.field_186);
      }

   }

   // $FF: renamed from: d (com.comscore.streaming.plugin.StreamSensePlugin) boolean
   // $FF: synthetic method
   static boolean method_143(StreamSensePlugin var0) {
      return var0.field_201;
   }

   // $FF: renamed from: e () java.lang.Runnable
   private Runnable method_144() {
      return new class_2(this);
   }

   // $FF: renamed from: e (com.comscore.streaming.plugin.StreamSensePlugin) java.util.List
   // $FF: synthetic method
   static List method_145(StreamSensePlugin var0) {
      return var0.field_189;
   }

   // $FF: renamed from: f (com.comscore.streaming.plugin.StreamSensePlugin) java.util.List
   // $FF: synthetic method
   static List method_146(StreamSensePlugin var0) {
      return var0.field_190;
   }

   // $FF: renamed from: f () boolean
   private boolean method_147() {
      if(this.method_122(0) < this.method_122(1)) {
         return true;
      } else {
         int var1 = this.field_186;
         int var2 = 0;

         float var3;
         for(var3 = 0.0F; var2 < this.field_189.size(); ++var2) {
            var3 += field_170[-2 + this.field_189.size()][var2] * (float)((Long)this.field_189.get(var2)).longValue();
         }

         float var6;
         int var4 = (var6 = var3 / (float)var1 - this.field_184) == 0.0F?0:(var6 < 0.0F?-1:1);
         boolean var5 = false;
         if(var4 > 0) {
            var5 = true;
         }

         return var5;
      }
   }

   // $FF: renamed from: g (com.comscore.streaming.plugin.StreamSensePlugin) boolean
   // $FF: synthetic method
   static boolean method_148(StreamSensePlugin var0) {
      return var0.field_194;
   }

   // $FF: renamed from: h (com.comscore.streaming.plugin.StreamSensePlugin) int
   // $FF: synthetic method
   static int method_149(StreamSensePlugin var0) {
      return var0.field_185;
   }

   // $FF: renamed from: i (com.comscore.streaming.plugin.StreamSensePlugin) int
   // $FF: synthetic method
   static int method_150(StreamSensePlugin var0) {
      return var0.field_187;
   }

   // $FF: renamed from: j (com.comscore.streaming.plugin.StreamSensePlugin) boolean
   // $FF: synthetic method
   static boolean method_151(StreamSensePlugin var0) {
      return var0.method_147();
   }

   // $FF: renamed from: k (com.comscore.streaming.plugin.StreamSensePlugin) boolean
   // $FF: synthetic method
   static boolean method_152(StreamSensePlugin var0) {
      return var0.field_196;
   }

   // $FF: renamed from: l (com.comscore.streaming.plugin.StreamSensePlugin) long
   // $FF: synthetic method
   static long method_153(StreamSensePlugin var0) {
      return var0.field_191;
   }

   // $FF: renamed from: m (com.comscore.streaming.plugin.StreamSensePlugin) java.util.List
   // $FF: synthetic method
   static List method_154(StreamSensePlugin var0) {
      return var0.field_193;
   }

   // $FF: renamed from: n (com.comscore.streaming.plugin.StreamSensePlugin) boolean
   // $FF: synthetic method
   static boolean method_155(StreamSensePlugin var0) {
      return var0.field_192;
   }

   // $FF: renamed from: o (com.comscore.streaming.plugin.StreamSensePlugin) boolean
   // $FF: synthetic method
   static boolean method_156(StreamSensePlugin var0) {
      return var0.field_200;
   }

   // $FF: renamed from: p (com.comscore.streaming.plugin.StreamSensePlugin) boolean
   // $FF: synthetic method
   static boolean method_157(StreamSensePlugin var0) {
      return var0.field_197;
   }

   // $FF: renamed from: q (com.comscore.streaming.plugin.StreamSensePlugin) boolean
   // $FF: synthetic method
   static boolean method_158(StreamSensePlugin var0) {
      return var0.field_195;
   }

   // $FF: renamed from: r (com.comscore.streaming.plugin.StreamSensePlugin) int
   // $FF: synthetic method
   static int method_159(StreamSensePlugin var0) {
      return var0.field_182;
   }

   public void addListener(StreamSensePluginListener var1) {
      this.field_193.add(var1);
   }

   public void clearAllListeners() {
      this.field_193.clear();
   }

   public void clearListener(StreamSensePluginListener var1) {
      this.field_193.remove(var1);
   }

   public String getGenericPluginVersion() {
      return this.field_181;
   }

   public StreamSensePlayer getPlayer() {
      return this.field_199;
   }

   public void log(String var1) {
      if(this.field_174) {
         Log.d(this.getClass().getSimpleName(), var1);
      }

   }

   public void notify(StreamSenseEventType var1, HashMap<String, String> var2, long var3) {
      if(!this.field_172 && !this.field_173) {
         if(var2 == null) {
            var2 = new HashMap();
         }

         Iterator var5 = this.field_193.iterator();

         while(var5.hasNext()) {
            ((StreamSensePluginListener)var5.next()).onGetLabels(var1, var2);
         }

         long var6;
         if(var3 > 0L) {
            var6 = var3;
         } else if(this.field_199 != null) {
            var6 = this.field_199.getPosition();
         } else {
            var6 = 0L;
         }

         if(var6 < 0L) {
            var6 = 0L;
         }

         if(var1 == StreamSenseEventType.END && this.field_198) {
            this.field_189 = new ArrayList();
            this.field_190 = new ArrayList();
            this.field_192 = false;
            this.field_200 = true;
            this.field_201 = true;
         } else if(var1 == StreamSenseEventType.PLAY) {
            this.field_202 = true;
         }

         super.notify(var1, var2, var6);
      }
   }

   public void setBitRate(long var1) {
      String var3;
      if(var1 > 0L) {
         var3 = String.valueOf(var1);
      } else {
         var3 = "0";
      }

      this.setLabel("ns_st_br", var3);
   }

   public Boolean setClip(HashMap<String, String> var1, boolean var2, HashMap<String, HashMap<String, String>> var3) {
      return this.setClip(var1, var2, var3, false);
   }

   public Boolean setClip(HashMap<String, String> var1, boolean var2, HashMap<String, HashMap<String, String>> var3, boolean var4) {
      if(this.field_202 && var1 != null && var1.get("ns_st_ci") != this.getClip().getLabel("ns_st_ci")) {
         this.notify(StreamSenseEventType.END, this.field_199.getPosition());
         this.field_202 = false;
      }

      if(var3 != null && var3.size() > 0) {
         var1 = this.method_134(var3, new HashMap(this.method_124(var3, new HashMap(var1))));
      }

      if(var4) {
         if(this.field_204 != null && this.field_204.size() > 0) {
            Iterator var8 = this.field_204.keySet().iterator();

            while(var8.hasNext()) {
               String var9 = (String)var8.next();
               var1.put(var9, this.field_204.get(var9));
            }
         }
      } else {
         this.field_204 = new HashMap();
         if(var1 != null && var1.size() > 0) {
            Iterator var5 = var1.keySet().iterator();

            while(var5.hasNext()) {
               String var6 = (String)var5.next();
               this.field_204.put(var6, var1.get(var6));
            }
         }
      }

      if(var1 != null && var1.get("ns_st_skip") != null && Boolean.parseBoolean((String)var1.get("ns_st_skip"))) {
         this.field_172 = true;
      } else {
         this.field_172 = false;
      }

      return super.setClip(var1, var2);
   }

   public void setClipLabel(String var1, String var2) {
      this.setClipLabel(var1, var2, false);
   }

   public void setClipLabel(String var1, String var2, boolean var3) {
      if(var3) {
         if(this.field_204.get(var1) == null && this.field_171.get(var1) == null) {
            this.getClip().setLabel(var1, var2);
         }

      } else {
         this.field_204.put(var1, var2);
         this.getClip().setLabel(var1, var2);
      }
   }

   public void setDetectEnd(boolean var1) {
      this.field_197 = var1;
   }

   public void setDetectPause(boolean var1) {
      this.field_195 = var1;
   }

   public void setDetectPlay(boolean var1) {
      this.field_196 = var1;
   }

   public void setDetectSeek(boolean var1) {
      this.field_194 = var1;
   }

   public void setDuration(long var1) {
      StreamSenseClip var3 = this.getClip();
      String var4;
      if(var1 >= 0L) {
         var4 = String.valueOf(var1);
      } else {
         var4 = "0";
      }

      var3.setLabel("ns_st_cl", var4);
   }

   public void setEndDetectionErrorMargin(int var1) {
      this.field_183 = var1;
   }

   public void setIsFullScreen(boolean var1) {
      String var2;
      if(var1) {
         var2 = "full";
      } else {
         var2 = "norm";
      }

      this.setLabel("ns_st_ws", var2);
   }

   public void setLabel(String var1, String var2) {
      this.setLabel(var1, var2, false);
   }

   public void setLabel(String var1, String var2, boolean var3) {
      HashMap var4 = new HashMap();
      var4.put(var1, var2);
      this.setLabels(var4, var3);
   }

   public void setLabels(HashMap<String, String> var1) {
      this.setLabels(var1, false);
   }

   public void setLabels(HashMap<String, String> var1, boolean var2) {
      if(var2) {
         if(this.field_171 != null && this.field_171.size() > 0) {
            Iterator var6 = this.field_171.keySet().iterator();

            while(var6.hasNext()) {
               String var7 = (String)var6.next();
               var1.put(var7, this.field_171.get(var7));
            }
         }
      } else {
         this.field_171 = new HashMap();
         if(var1 != null && var1.size() > 0) {
            Iterator var3 = var1.keySet().iterator();

            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               this.field_171.put(var4, var1.get(var4));
            }
         }
      }

      super.setLabels(var1);
   }

   public void setMaximumNumberOfEntriesInHistory(int var1) {
      if(var1 >= 2 && var1 <= 13) {
         this.field_187 = var1;
      }

   }

   public void setMinimumNumberOfTimeUpdateEventsBeforeSensingAnything(int var1) {
      if(var1 >= 2 && var1 <= 13) {
         this.field_185 = var1;
      }

   }

   public void setPauseDetectionErrorMargin(int var1) {
      this.field_182 = var1;
   }

   public void setPlayer(StreamSensePlayer var1) {
      this.field_199 = var1;
   }

   public Boolean setPlaylist(HashMap<String, String> var1) {
      return this.setPlaylist(var1, false);
   }

   public Boolean setPlaylist(HashMap<String, String> var1, boolean var2) {
      if(var2) {
         if(this.field_203 != null && this.field_203.size() > 0) {
            Iterator var6 = this.field_203.keySet().iterator();

            while(var6.hasNext()) {
               String var7 = (String)var6.next();
               var1.put(var7, this.field_203.get(var7));
            }
         }
      } else {
         this.field_203 = new HashMap();
         if(var1 != null && var1.size() > 0) {
            Iterator var3 = var1.keySet().iterator();

            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               this.field_203.put(var4, var1.get(var4));
            }
         }
      }

      if(var1 != null && var1.get("ns_st_skip") != null && Boolean.parseBoolean((String)var1.get("ns_st_skip"))) {
         this.field_173 = true;
      } else {
         this.field_173 = false;
      }

      return super.setPlaylist(var1);
   }

   public void setPlaylistLabel(String var1, String var2) {
      this.setPlaylistLabel(var1, var2, false);
   }

   public void setPlaylistLabel(String var1, String var2, boolean var3) {
      if(var3 && var3) {
         if(this.field_203.get(var1) == null && this.field_171.get(var1) == null) {
            this.getPlaylist().setLabel(var1, var2);
         }

      } else {
         this.field_203.put(var1, var2);
         this.getPlaylist().setLabel(var1, var2);
      }
   }

   public void setPulseSamplingInterval(int var1) {
      if(var1 > 0) {
         this.field_186 = var1;
      }

   }

   public void setSeekDetectionMinQuotient(float var1) {
      if(var1 > 1.0F) {
         this.field_184 = var1;
      }

   }

   public void setSmartStateDetection(boolean var1) {
      boolean var2 = this.field_198;
      this.field_198 = var1;
      if(!var2 && var1) {
         this.method_142();
      } else if(var2 && !var1) {
         this.method_139();
         return;
      }

   }

   public void setVideoSize(String var1) {
      StreamSenseClip var2 = this.getClip();
      if(var1 == null || var1.length() <= 0) {
         var1 = "0";
      }

      var2.setLabel("ns_st_cs", var1);
   }

   public void setVolume(int var1) {
      String var2;
      if(var1 >= 0 && var1 <= 100) {
         var2 = String.valueOf(var1);
      } else {
         var2 = "100";
      }

      this.setLabel("ns_st_vo", var2);
   }
}
