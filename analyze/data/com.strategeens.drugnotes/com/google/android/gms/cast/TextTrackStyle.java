package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_712;
import com.google.android.gms.internal.class_716;
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
   // $FF: renamed from: GT float
   private float field_3258;
   // $FF: renamed from: GU int
   private int field_3259;
   // $FF: renamed from: GV int
   private int field_3260;
   // $FF: renamed from: GW int
   private int field_3261;
   // $FF: renamed from: GX int
   private int field_3262;
   // $FF: renamed from: GY int
   private int field_3263;
   // $FF: renamed from: GZ int
   private int field_3264;
   // $FF: renamed from: Ga org.json.JSONObject
   private JSONObject field_3265;
   // $FF: renamed from: Ha java.lang.String
   private String field_3266;
   // $FF: renamed from: Hb int
   private int field_3267;
   // $FF: renamed from: Hc int
   private int field_3268;
   // $FF: renamed from: xB int
   private int field_3269;

   public TextTrackStyle() {
      this.clear();
   }

   // $FF: renamed from: aC (java.lang.String) int
   private int method_4156(String var1) {
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
      this.field_3258 = 1.0F;
      this.field_3259 = 0;
      this.field_3269 = 0;
      this.field_3260 = -1;
      this.field_3261 = 0;
      this.field_3262 = -1;
      this.field_3263 = 0;
      this.field_3264 = 0;
      this.field_3266 = null;
      this.field_3267 = -1;
      this.field_3268 = -1;
      this.field_3265 = null;
   }

   public static TextTrackStyle fromSystemSettings(Context var0) {
      TextTrackStyle var1 = new TextTrackStyle();
      if(!class_712.method_4183()) {
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

   // $FF: renamed from: u (int) java.lang.String
   private String method_4157(int var1) {
      Object[] var2 = new Object[]{Integer.valueOf(Color.red(var1)), Integer.valueOf(Color.green(var1)), Integer.valueOf(Color.blue(var1)), Integer.valueOf(Color.alpha(var1))};
      return String.format("#%02X%02X%02X%02X", var2);
   }

   // $FF: renamed from: c (org.json.JSONObject) void
   public void method_4158(JSONObject var1) throws JSONException {
      this.clear();
      this.field_3258 = (float)var1.optDouble("fontScale", 1.0D);
      this.field_3259 = this.method_4156(var1.optString("foregroundColor"));
      this.field_3269 = this.method_4156(var1.optString("backgroundColor"));
      if(var1.has("edgeType")) {
         String var5 = var1.getString("edgeType");
         if("NONE".equals(var5)) {
            this.field_3260 = 0;
         } else if("OUTLINE".equals(var5)) {
            this.field_3260 = 1;
         } else if("DROP_SHADOW".equals(var5)) {
            this.field_3260 = 2;
         } else if("RAISED".equals(var5)) {
            this.field_3260 = 3;
         } else if("DEPRESSED".equals(var5)) {
            this.field_3260 = 4;
         }
      }

      this.field_3261 = this.method_4156(var1.optString("edgeColor"));
      if(var1.has("windowType")) {
         String var4 = var1.getString("windowType");
         if("NONE".equals(var4)) {
            this.field_3262 = 0;
         } else if("NORMAL".equals(var4)) {
            this.field_3262 = 1;
         } else if("ROUNDED_CORNERS".equals(var4)) {
            this.field_3262 = 2;
         }
      }

      this.field_3263 = this.method_4156(var1.optString("windowColor"));
      if(this.field_3262 == 2) {
         this.field_3264 = var1.optInt("windowRoundedCornerRadius", 0);
      }

      this.field_3266 = var1.optString("fontFamily", (String)null);
      if(var1.has("fontGenericFamily")) {
         String var3 = var1.getString("fontGenericFamily");
         if("SANS_SERIF".equals(var3)) {
            this.field_3267 = 0;
         } else if("MONOSPACED_SANS_SERIF".equals(var3)) {
            this.field_3267 = 1;
         } else if("SERIF".equals(var3)) {
            this.field_3267 = 2;
         } else if("MONOSPACED_SERIF".equals(var3)) {
            this.field_3267 = 3;
         } else if("CASUAL".equals(var3)) {
            this.field_3267 = 4;
         } else if("CURSIVE".equals(var3)) {
            this.field_3267 = 5;
         } else if("SMALL_CAPITALS".equals(var3)) {
            this.field_3267 = 6;
         }
      }

      if(var1.has("fontStyle")) {
         String var2 = var1.getString("fontStyle");
         if("NORMAL".equals(var2)) {
            this.field_3268 = 0;
         } else if("BOLD".equals(var2)) {
            this.field_3268 = 1;
         } else if("ITALIC".equals(var2)) {
            this.field_3268 = 2;
         } else if("BOLD_ITALIC".equals(var2)) {
            this.field_3268 = 3;
         }
      }

      this.field_3265 = var1.optJSONObject("customData");
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
            if(this.field_3265 == null) {
               var6 = var2;
            } else {
               var6 = false;
            }

            boolean var7;
            if(var5.field_3265 == null) {
               var7 = var2;
            } else {
               var7 = false;
            }

            var4 = false;
            if(var6 == var7) {
               if(this.field_3265 != null && var5.field_3265 != null) {
                  boolean var8 = class_716.method_4194(this.field_3265, var5.field_3265);
                  var4 = false;
                  if(!var8) {
                     return var4;
                  }
               }

               if(this.field_3258 != var5.field_3258 || this.field_3259 != var5.field_3259 || this.field_3269 != var5.field_3269 || this.field_3260 != var5.field_3260 || this.field_3261 != var5.field_3261 || this.field_3262 != var5.field_3262 || this.field_3264 != var5.field_3264 || !class_322.method_2262(this.field_3266, var5.field_3266) || this.field_3267 != var5.field_3267 || this.field_3268 != var5.field_3268) {
                  var2 = false;
               }

               return var2;
            }
         }
      }

      return var4;
   }

   public int getBackgroundColor() {
      return this.field_3269;
   }

   public JSONObject getCustomData() {
      return this.field_3265;
   }

   public int getEdgeColor() {
      return this.field_3261;
   }

   public int getEdgeType() {
      return this.field_3260;
   }

   public String getFontFamily() {
      return this.field_3266;
   }

   public int getFontGenericFamily() {
      return this.field_3267;
   }

   public float getFontScale() {
      return this.field_3258;
   }

   public int getFontStyle() {
      return this.field_3268;
   }

   public int getForegroundColor() {
      return this.field_3259;
   }

   public int getWindowColor() {
      return this.field_3263;
   }

   public int getWindowCornerRadius() {
      return this.field_3264;
   }

   public int getWindowType() {
      return this.field_3262;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Float.valueOf(this.field_3258), Integer.valueOf(this.field_3259), Integer.valueOf(this.field_3269), Integer.valueOf(this.field_3260), Integer.valueOf(this.field_3261), Integer.valueOf(this.field_3262), Integer.valueOf(this.field_3263), Integer.valueOf(this.field_3264), this.field_3266, Integer.valueOf(this.field_3267), Integer.valueOf(this.field_3268), this.field_3265};
      return class_336.hashCode(var1);
   }

   public void setBackgroundColor(int var1) {
      this.field_3269 = var1;
   }

   public void setCustomData(JSONObject var1) {
      this.field_3265 = var1;
   }

   public void setEdgeColor(int var1) {
      this.field_3261 = var1;
   }

   public void setEdgeType(int var1) {
      if(var1 >= 0 && var1 <= 4) {
         this.field_3260 = var1;
      } else {
         throw new IllegalArgumentException("invalid edgeType");
      }
   }

   public void setFontFamily(String var1) {
      this.field_3266 = var1;
   }

   public void setFontGenericFamily(int var1) {
      if(var1 >= 0 && var1 <= 6) {
         this.field_3267 = var1;
      } else {
         throw new IllegalArgumentException("invalid fontGenericFamily");
      }
   }

   public void setFontScale(float var1) {
      this.field_3258 = var1;
   }

   public void setFontStyle(int var1) {
      if(var1 >= 0 && var1 <= 3) {
         this.field_3268 = var1;
      } else {
         throw new IllegalArgumentException("invalid fontStyle");
      }
   }

   public void setForegroundColor(int var1) {
      this.field_3259 = var1;
   }

   public void setWindowColor(int var1) {
      this.field_3263 = var1;
   }

   public void setWindowCornerRadius(int var1) {
      if(var1 < 0) {
         throw new IllegalArgumentException("invalid windowCornerRadius");
      } else {
         this.field_3264 = var1;
      }
   }

   public void setWindowType(int var1) {
      if(var1 >= 0 && var1 <= 2) {
         this.field_3262 = var1;
      } else {
         throw new IllegalArgumentException("invalid windowType");
      }
   }

   public JSONObject toJson() {
      // $FF: Couldn't be decompiled
   }
}
