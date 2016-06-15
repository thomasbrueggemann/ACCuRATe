package com.google.android.gms.cast;

import com.google.android.gms.internal.class_281;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_349;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
   public static final int SUBTYPE_CAPTIONS = 2;
   public static final int SUBTYPE_CHAPTERS = 4;
   public static final int SUBTYPE_DESCRIPTIONS = 3;
   public static final int SUBTYPE_METADATA = 5;
   public static final int SUBTYPE_NONE = 0;
   public static final int SUBTYPE_SUBTITLES = 1;
   public static final int SUBTYPE_UNKNOWN = -1;
   public static final int TYPE_AUDIO = 2;
   public static final int TYPE_TEXT = 1;
   public static final int TYPE_UNKNOWN = 0;
   public static final int TYPE_VIDEO = 3;
   // $FF: renamed from: AP long
   private long field_2879;
   // $FF: renamed from: AQ int
   private int field_2880;
   // $FF: renamed from: AR int
   private int field_2881;
   // $FF: renamed from: Ao java.lang.String
   private String field_2882;
   // $FF: renamed from: Aq java.lang.String
   private String field_2883;
   // $FF: renamed from: As java.lang.String
   private String field_2884;
   // $FF: renamed from: Ax org.json.JSONObject
   private JSONObject field_2885;
   private String mName;

   MediaTrack(long var1, int var3) throws IllegalArgumentException {
      this.clear();
      this.field_2879 = var1;
      if(var3 > 0 && var3 <= 3) {
         this.field_2880 = var3;
      } else {
         throw new IllegalArgumentException("invalid type " + var3);
      }
   }

   MediaTrack(JSONObject var1) throws JSONException {
      this.method_2974(var1);
   }

   // $FF: renamed from: b (org.json.JSONObject) void
   private void method_2974(JSONObject var1) throws JSONException {
      this.clear();
      this.field_2879 = var1.getLong("trackId");
      String var2 = var1.getString("type");
      if("TEXT".equals(var2)) {
         this.field_2880 = 1;
      } else if("AUDIO".equals(var2)) {
         this.field_2880 = 2;
      } else {
         if(!"VIDEO".equals(var2)) {
            throw new JSONException("invalid type: " + var2);
         }

         this.field_2880 = 3;
      }

      this.field_2883 = var1.optString("trackContentId", (String)null);
      this.field_2884 = var1.optString("trackContentType", (String)null);
      this.mName = var1.optString("name", (String)null);
      this.field_2882 = var1.optString("language", (String)null);
      if(var1.has("subtype")) {
         String var3 = var1.getString("subtype");
         if("SUBTITLES".equals(var3)) {
            this.field_2881 = 1;
         } else if("CAPTIONS".equals(var3)) {
            this.field_2881 = 2;
         } else if("DESCRIPTIONS".equals(var3)) {
            this.field_2881 = 3;
         } else if("CHAPTERS".equals(var3)) {
            this.field_2881 = 4;
         } else {
            if(!"METADATA".equals(var3)) {
               throw new JSONException("invalid subtype: " + var3);
            }

            this.field_2881 = 5;
         }
      } else {
         this.field_2881 = 0;
      }

      this.field_2885 = var1.optJSONObject("customData");
   }

   private void clear() {
      this.field_2879 = 0L;
      this.field_2880 = 0;
      this.field_2883 = null;
      this.mName = null;
      this.field_2882 = null;
      this.field_2881 = -1;
      this.field_2885 = null;
   }

   // $FF: renamed from: R (int) void
   void method_2975(int var1) throws IllegalArgumentException {
      if(var1 > -1 && var1 <= 5) {
         if(var1 != 0 && this.field_2880 != 1) {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
         } else {
            this.field_2881 = var1;
         }
      } else {
         throw new IllegalArgumentException("invalid subtype " + var1);
      }
   }

   // $FF: renamed from: dU () org.json.JSONObject
   public JSONObject method_2976() {
      // $FF: Couldn't be decompiled
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      boolean var4;
      if(this == var1) {
         var4 = var2;
      } else {
         boolean var3 = var1 instanceof MediaTrack;
         var4 = false;
         if(var3) {
            MediaTrack var5 = (MediaTrack)var1;
            boolean var6;
            if(this.field_2885 == null) {
               var6 = var2;
            } else {
               var6 = false;
            }

            boolean var7;
            if(var5.field_2885 == null) {
               var7 = var2;
            } else {
               var7 = false;
            }

            var4 = false;
            if(var6 == var7) {
               if(this.field_2885 != null && var5.field_2885 != null) {
                  boolean var8 = class_281.method_1868(this.field_2885, var5.field_2885);
                  var4 = false;
                  if(!var8) {
                     return var4;
                  }
               }

               if(this.field_2879 != var5.field_2879 || this.field_2880 != var5.field_2880 || !class_332.method_2117(this.field_2883, var5.field_2883) || !class_332.method_2117(this.field_2884, var5.field_2884) || !class_332.method_2117(this.mName, var5.mName) || !class_332.method_2117(this.field_2882, var5.field_2882) || this.field_2881 != var5.field_2881) {
                  var2 = false;
               }

               return var2;
            }
         }
      }

      return var4;
   }

   public String getContentId() {
      return this.field_2883;
   }

   public String getContentType() {
      return this.field_2884;
   }

   public JSONObject getCustomData() {
      return this.field_2885;
   }

   public long getId() {
      return this.field_2879;
   }

   public String getLanguage() {
      return this.field_2882;
   }

   public String getName() {
      return this.mName;
   }

   public int getSubtype() {
      return this.field_2881;
   }

   public int getType() {
      return this.field_2880;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.field_2879), Integer.valueOf(this.field_2880), this.field_2883, this.field_2884, this.mName, this.field_2882, Integer.valueOf(this.field_2881), this.field_2885};
      return class_349.hashCode(var1);
   }

   public void setContentId(String var1) {
      this.field_2883 = var1;
   }

   public void setContentType(String var1) {
      this.field_2884 = var1;
   }

   void setCustomData(JSONObject var1) {
      this.field_2885 = var1;
   }

   void setLanguage(String var1) {
      this.field_2882 = var1;
   }

   void setName(String var1) {
      this.mName = var1;
   }

   public static class Builder {
      // $FF: renamed from: AS com.google.android.gms.cast.MediaTrack
      private final MediaTrack field_3702;

      public Builder(long var1, int var3) throws IllegalArgumentException {
         this.field_3702 = new MediaTrack(var1, var3);
      }

      public MediaTrack build() {
         return this.field_3702;
      }

      public MediaTrack.Builder setContentId(String var1) {
         this.field_3702.setContentId(var1);
         return this;
      }

      public MediaTrack.Builder setContentType(String var1) {
         this.field_3702.setContentType(var1);
         return this;
      }

      public MediaTrack.Builder setCustomData(JSONObject var1) {
         this.field_3702.setCustomData(var1);
         return this;
      }

      public MediaTrack.Builder setLanguage(String var1) {
         this.field_3702.setLanguage(var1);
         return this;
      }

      public MediaTrack.Builder setLanguage(Locale var1) {
         this.field_3702.setLanguage(class_332.method_2121(var1));
         return this;
      }

      public MediaTrack.Builder setName(String var1) {
         this.field_3702.setName(var1);
         return this;
      }

      public MediaTrack.Builder setSubtype(int var1) throws IllegalArgumentException {
         this.field_3702.method_2975(var1);
         return this;
      }
   }
}
