package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.class_275;
import com.google.android.gms.internal.class_281;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_349;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
   public static final int COLOR_UNSPECIFIED = 0;
   public static final float DEFAULT_FONT_SCALE = 1.0F;
   public static final int EDGE_TYPE_DEPRESSED = 4;
   public static final int EDGE_TYPE_DROP_SHADOW = 2;
   public static final int EDGE_TYPE_NONE = 0;
   public static final int EDGE_TYPE_OUTLINE = 1;
   public static final int EDGE_TYPE_RAISED = 3;
   public static final int EDGE_TYPE_UNSPECIFIED = -1;
   public static final int FONT_FAMILY_CASUAL = 4;
   public static final int FONT_FAMILY_CURSIVE = 5;
   public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
   public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
   public static final int FONT_FAMILY_SANS_SERIF = 0;
   public static final int FONT_FAMILY_SERIF = 2;
   public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
   public static final int FONT_FAMILY_UNSPECIFIED = -1;
   public static final int FONT_STYLE_BOLD = 1;
   public static final int FONT_STYLE_BOLD_ITALIC = 3;
   public static final int FONT_STYLE_ITALIC = 2;
   public static final int FONT_STYLE_NORMAL = 0;
   public static final int FONT_STYLE_UNSPECIFIED = -1;
   public static final int WINDOW_TYPE_NONE = 0;
   public static final int WINDOW_TYPE_NORMAL = 1;
   public static final int WINDOW_TYPE_ROUNDED = 2;
   public static final int WINDOW_TYPE_UNSPECIFIED = -1;
   // $FF: renamed from: Ax org.json.JSONObject
   private JSONObject field_3291;
   // $FF: renamed from: Bp float
   private float field_3292;
   // $FF: renamed from: Bq int
   private int field_3293;
   // $FF: renamed from: Br int
   private int field_3294;
   // $FF: renamed from: Bs int
   private int field_3295;
   // $FF: renamed from: Bt int
   private int field_3296;
   // $FF: renamed from: Bu int
   private int field_3297;
   // $FF: renamed from: Bv int
   private int field_3298;
   // $FF: renamed from: Bw java.lang.String
   private String field_3299;
   // $FF: renamed from: Bx int
   private int field_3300;
   // $FF: renamed from: By int
   private int field_3301;
   // $FF: renamed from: ta int
   private int field_3302;

   public TextTrackStyle() {
      this.clear();
   }

   // $FF: renamed from: ah (java.lang.String) int
   private int method_3467(String var1) {
      int var2 = 0;
      if(var1 != null) {
         int var3 = var1.length();
         var2 = 0;
         if(var3 == 9) {
            char var4 = var1.charAt(0);
            var2 = 0;
            if(var4 == 35) {
               int var9;
               try {
                  int var6 = Integer.parseInt(var1.substring(1, 3), 16);
                  int var7 = Integer.parseInt(var1.substring(3, 5), 16);
                  int var8 = Integer.parseInt(var1.substring(5, 7), 16);
                  var9 = Color.argb(Integer.parseInt(var1.substring(7, 9), 16), var6, var7, var8);
               } catch (NumberFormatException var10) {
                  return 0;
               }

               var2 = var9;
            }
         }
      }

      return var2;
   }

   private void clear() {
      this.field_3292 = 1.0F;
      this.field_3293 = 0;
      this.field_3302 = 0;
      this.field_3294 = -1;
      this.field_3295 = 0;
      this.field_3296 = -1;
      this.field_3297 = 0;
      this.field_3298 = 0;
      this.field_3299 = null;
      this.field_3300 = -1;
      this.field_3301 = -1;
      this.field_3291 = null;
   }

   public static TextTrackStyle fromSystemSettings(Context var0) {
      TextTrackStyle var1 = new TextTrackStyle();
      if(!class_275.method_1856()) {
         return var1;
      } else {
         CaptioningManager var2 = (CaptioningManager)var0.getSystemService("captioning");
         var1.setFontScale(var2.getFontScale());
         CaptionStyle var3 = var2.getUserStyle();
         var1.setBackgroundColor(var3.backgroundColor);
         var1.setForegroundColor(var3.foregroundColor);
         switch(var3.edgeType) {
         case 1:
            var1.setEdgeType(1);
            break;
         case 2:
            var1.setEdgeType(2);
            break;
         default:
            var1.setEdgeType(0);
         }

         var1.setEdgeColor(var3.edgeColor);
         Typeface var4 = var3.getTypeface();
         if(var4 != null) {
            if(Typeface.MONOSPACE.equals(var4)) {
               var1.setFontGenericFamily(1);
            } else if(Typeface.SANS_SERIF.equals(var4)) {
               var1.setFontGenericFamily(0);
            } else if(Typeface.SERIF.equals(var4)) {
               var1.setFontGenericFamily(2);
            } else {
               var1.setFontGenericFamily(0);
            }

            boolean var5 = var4.isBold();
            boolean var6 = var4.isItalic();
            if(var5 && var6) {
               var1.setFontStyle(3);
            } else if(var5) {
               var1.setFontStyle(1);
            } else if(var6) {
               var1.setFontStyle(2);
            } else {
               var1.setFontStyle(0);
            }
         }

         return var1;
      }
   }

   // $FF: renamed from: o (int) java.lang.String
   private String method_3468(int var1) {
      Object[] var2 = new Object[]{Integer.valueOf(Color.red(var1)), Integer.valueOf(Color.green(var1)), Integer.valueOf(Color.blue(var1)), Integer.valueOf(Color.alpha(var1))};
      return String.format("#%02X%02X%02X%02X", var2);
   }

   // $FF: renamed from: b (org.json.JSONObject) void
   public void method_3469(JSONObject var1) throws JSONException {
      this.clear();
      this.field_3292 = (float)var1.optDouble("fontScale", 1.0D);
      this.field_3293 = this.method_3467(var1.optString("foregroundColor"));
      this.field_3302 = this.method_3467(var1.optString("backgroundColor"));
      if(var1.has("edgeType")) {
         String var5 = var1.getString("edgeType");
         if("NONE".equals(var5)) {
            this.field_3294 = 0;
         } else if("OUTLINE".equals(var5)) {
            this.field_3294 = 1;
         } else if("DROP_SHADOW".equals(var5)) {
            this.field_3294 = 2;
         } else if("RAISED".equals(var5)) {
            this.field_3294 = 3;
         } else if("DEPRESSED".equals(var5)) {
            this.field_3294 = 4;
         }
      }

      this.field_3295 = this.method_3467(var1.optString("edgeColor"));
      if(var1.has("windowType")) {
         String var4 = var1.getString("windowType");
         if("NONE".equals(var4)) {
            this.field_3296 = 0;
         } else if("NORMAL".equals(var4)) {
            this.field_3296 = 1;
         } else if("ROUNDED_CORNERS".equals(var4)) {
            this.field_3296 = 2;
         }
      }

      this.field_3297 = this.method_3467(var1.optString("windowColor"));
      if(this.field_3296 == 2) {
         this.field_3298 = var1.optInt("windowRoundedCornerRadius", 0);
      }

      this.field_3299 = var1.optString("fontFamily", (String)null);
      if(var1.has("fontGenericFamily")) {
         String var3 = var1.getString("fontGenericFamily");
         if("SANS_SERIF".equals(var3)) {
            this.field_3300 = 0;
         } else if("MONOSPACED_SANS_SERIF".equals(var3)) {
            this.field_3300 = 1;
         } else if("SERIF".equals(var3)) {
            this.field_3300 = 2;
         } else if("MONOSPACED_SERIF".equals(var3)) {
            this.field_3300 = 3;
         } else if("CASUAL".equals(var3)) {
            this.field_3300 = 4;
         } else if("CURSIVE".equals(var3)) {
            this.field_3300 = 5;
         } else if("SMALL_CAPITALS".equals(var3)) {
            this.field_3300 = 6;
         }
      }

      if(var1.has("fontStyle")) {
         String var2 = var1.getString("fontStyle");
         if("NORMAL".equals(var2)) {
            this.field_3301 = 0;
         } else if("BOLD".equals(var2)) {
            this.field_3301 = 1;
         } else if("ITALIC".equals(var2)) {
            this.field_3301 = 2;
         } else if("BOLD_ITALIC".equals(var2)) {
            this.field_3301 = 3;
         }
      }

      this.field_3291 = var1.optJSONObject("customData");
   }

   // $FF: renamed from: dU () org.json.JSONObject
   public JSONObject method_3470() {
      // $FF: Couldn't be decompiled
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      boolean var4;
      if(this == var1) {
         var4 = var2;
      } else {
         boolean var3 = var1 instanceof TextTrackStyle;
         var4 = false;
         if(var3) {
            TextTrackStyle var5 = (TextTrackStyle)var1;
            boolean var6;
            if(this.field_3291 == null) {
               var6 = var2;
            } else {
               var6 = false;
            }

            boolean var7;
            if(var5.field_3291 == null) {
               var7 = var2;
            } else {
               var7 = false;
            }

            var4 = false;
            if(var6 == var7) {
               if(this.field_3291 != null && var5.field_3291 != null) {
                  boolean var8 = class_281.method_1868(this.field_3291, var5.field_3291);
                  var4 = false;
                  if(!var8) {
                     return var4;
                  }
               }

               if(this.field_3292 != var5.field_3292 || this.field_3293 != var5.field_3293 || this.field_3302 != var5.field_3302 || this.field_3294 != var5.field_3294 || this.field_3295 != var5.field_3295 || this.field_3296 != var5.field_3296 || this.field_3298 != var5.field_3298 || !class_332.method_2117(this.field_3299, var5.field_3299) || this.field_3300 != var5.field_3300 || this.field_3301 != var5.field_3301) {
                  var2 = false;
               }

               return var2;
            }
         }
      }

      return var4;
   }

   public int getBackgroundColor() {
      return this.field_3302;
   }

   public JSONObject getCustomData() {
      return this.field_3291;
   }

   public int getEdgeColor() {
      return this.field_3295;
   }

   public int getEdgeType() {
      return this.field_3294;
   }

   public String getFontFamily() {
      return this.field_3299;
   }

   public int getFontGenericFamily() {
      return this.field_3300;
   }

   public float getFontScale() {
      return this.field_3292;
   }

   public int getFontStyle() {
      return this.field_3301;
   }

   public int getForegroundColor() {
      return this.field_3293;
   }

   public int getWindowColor() {
      return this.field_3297;
   }

   public int getWindowCornerRadius() {
      return this.field_3298;
   }

   public int getWindowType() {
      return this.field_3296;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Float.valueOf(this.field_3292), Integer.valueOf(this.field_3293), Integer.valueOf(this.field_3302), Integer.valueOf(this.field_3294), Integer.valueOf(this.field_3295), Integer.valueOf(this.field_3296), Integer.valueOf(this.field_3297), Integer.valueOf(this.field_3298), this.field_3299, Integer.valueOf(this.field_3300), Integer.valueOf(this.field_3301), this.field_3291};
      return class_349.hashCode(var1);
   }

   public void setBackgroundColor(int var1) {
      this.field_3302 = var1;
   }

   public void setCustomData(JSONObject var1) {
      this.field_3291 = var1;
   }

   public void setEdgeColor(int var1) {
      this.field_3295 = var1;
   }

   public void setEdgeType(int var1) {
      if(var1 >= 0 && var1 <= 4) {
         this.field_3294 = var1;
      } else {
         throw new IllegalArgumentException("invalid edgeType");
      }
   }

   public void setFontFamily(String var1) {
      this.field_3299 = var1;
   }

   public void setFontGenericFamily(int var1) {
      if(var1 >= 0 && var1 <= 6) {
         this.field_3300 = var1;
      } else {
         throw new IllegalArgumentException("invalid fontGenericFamily");
      }
   }

   public void setFontScale(float var1) {
      this.field_3292 = var1;
   }

   public void setFontStyle(int var1) {
      if(var1 >= 0 && var1 <= 3) {
         this.field_3301 = var1;
      } else {
         throw new IllegalArgumentException("invalid fontStyle");
      }
   }

   public void setForegroundColor(int var1) {
      this.field_3293 = var1;
   }

   public void setWindowColor(int var1) {
      this.field_3297 = var1;
   }

   public void setWindowCornerRadius(int var1) {
      if(var1 < 0) {
         throw new IllegalArgumentException("invalid windowCornerRadius");
      } else {
         this.field_3298 = var1;
      }
   }

   public void setWindowType(int var1) {
      if(var1 >= 0 && var1 <= 2) {
         this.field_3296 = var1;
      } else {
         throw new IllegalArgumentException("invalid windowType");
      }
   }
}
