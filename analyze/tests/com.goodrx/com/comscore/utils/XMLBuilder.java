package com.comscore.utils;

import com.comscore.utils.Date;
import com.comscore.utils.Utils;

public class XMLBuilder {
   // $FF: renamed from: a java.lang.StringBuilder
   private static StringBuilder field_228;
   // $FF: renamed from: b int
   private static int field_229 = -1;
   // $FF: renamed from: c int
   private static int field_230 = -1;
   // $FF: renamed from: d java.lang.String[]
   private static final String[] field_231 = new String[]{"c12", "c1", "ns_ap_an", "ns_ap_pn", "ns_ap_device", "ns_ak"};
   // $FF: renamed from: e java.lang.String[]
   private static final String[] field_232 = new String[]{"c12", "c1", "ns_ap_an", "ns_ap_pn", "ns_ap_device", "ns_ts", "ns_ak"};
   // $FF: renamed from: f long
   private static final long field_233;

   static {
      field_233 = (long)(-1 + (1 << field_232.length));
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) void
   private static void method_172(String var0, String var1) {
      field_230 = -1;
      field_229 = -1;
      int var2 = 0;

      while(true) {
         var2 = var0.indexOf(var1, var2);
         if(var2 >= 0) {
            int var3 = var2 + var1.length();
            if((var2 == 0 || var0.charAt(var2 - 1) == 38) && var3 < var0.length() && var0.charAt(var3) == 61) {
               field_229 = var3 + 1;
               field_230 = var0.indexOf(38, field_229);
               if(field_230 == -1) {
                  field_230 = var0.length();
               }
               break;
            }

            var2 = var3 + 1;
         }

         if(var2 < 0) {
            break;
         }

         if(var2 >= var0.length()) {
            return;
         }
      }

   }

   // $FF: renamed from: a (java.lang.String, java.lang.StringBuilder) void
   private static void method_173(String var0, StringBuilder var1) {
      long var2 = 0L;
      method_172(var0, "ns_ts");
      if(field_229 != -1 && field_230 > field_229) {
         var1.append("<event t=\"").append(var0, field_229, field_230).append("\">");
         int var5 = 0;

         int var9;
         for(int var6 = 0; var5 < var0.length(); var5 = var9 + 1) {
            int var8 = var0.indexOf(38, var5);
            if(var8 == -1) {
               var9 = var0.length();
            } else {
               var9 = var8;
            }

            if(var9 > var5 && var0.indexOf(61, var5) > var5) {
               boolean var10;
               label50: {
                  if(var2 != field_233) {
                     for(int var15 = 0; var15 < field_232.length; ++var15) {
                        long var16 = (long)(1 << var15);
                        if((var2 & var16) == 0L && field_232[var15].regionMatches(0, var0, var5, field_232[var15].length())) {
                           var10 = false;
                           var2 |= var16;
                           break label50;
                        }
                     }
                  }

                  var10 = true;
               }

               if(var10) {
                  if(var6 > 0) {
                     field_228.append('&');
                     var1.append('&');
                  }

                  field_228.append(var0, var5, var9);
                  var1.append(var0, var5, var9);
                  ++var6;
               }
            }
         }

         var1.append("</event>");
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder) void
   private static void method_174(StringBuilder var0) {
      String var1 = Utils.md5(field_228.toString()).toLowerCase();
      var0.insert(var0.indexOf("md5=\"") + "md5=\"".length(), var1);
   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.lang.String, java.lang.String) void
   private static void method_175(StringBuilder var0, String var1, String var2) {
      String var3 = String.valueOf(Date.unixTime());
      var0.append("<events t=\"").append(var3).append("\" ");

      for(int var5 = 0; var5 < field_231.length; ++var5) {
         method_177(var0, var1, field_231[var5]);
      }

      var0.append("dropped=\"").append(var2).append("\" md5=\"\">");
   }

   // $FF: renamed from: a (java.lang.String[], java.lang.StringBuilder) void
   private static void method_176(String[] var0, StringBuilder var1) {
      field_228 = new StringBuilder();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         if(Utils.isNotEmpty(var0[var2])) {
            method_173(var0[var2], var1);
         }
      }

   }

   // $FF: renamed from: b (java.lang.StringBuilder, java.lang.String, java.lang.String) void
   private static void method_177(StringBuilder var0, String var1, String var2) {
      method_172(var1, var2);
      if(field_229 != -1 && field_230 > field_229) {
         var0.append(var2).append("=\"").append(var1, field_229, field_230).append("\" ");
      }

   }

   public static String generateXMLRequestString(String[] var0, String var1) {
      synchronized(XMLBuilder.class){}

      String var5;
      try {
         StringBuilder var2 = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
         method_175(var2, var0[0], var1);
         method_176(var0, var2);
         method_174(var2);
         var2.append("</events>");
         var5 = var2.toString();
      } finally {
         ;
      }

      return var5;
   }

   public static String getLabelFromEvent(String var0, String var1) {
      synchronized(XMLBuilder.class){}
      boolean var6 = false;

      String var3;
      label46: {
         String var4;
         label45: {
            try {
               var6 = true;
               method_172(var0, var1);
               if(field_229 != -1) {
                  if(field_230 > field_229) {
                     var4 = var0.substring(field_229, field_230);
                     var6 = false;
                     break label45;
                  }

                  var6 = false;
               } else {
                  var6 = false;
               }
            } finally {
               if(var6) {
                  ;
               }
            }

            var3 = null;
            break label46;
         }

         var3 = var4;
      }

      return var3;
   }
}
