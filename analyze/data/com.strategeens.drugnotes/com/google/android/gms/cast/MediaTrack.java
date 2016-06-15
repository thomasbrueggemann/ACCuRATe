package com.google.android.gms.cast;

import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_716;
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
   // $FF: renamed from: Eg long
   private long field_2734;
   // $FF: renamed from: FR java.lang.String
   private String field_2735;
   // $FF: renamed from: FT java.lang.String
   private String field_2736;
   // $FF: renamed from: FV java.lang.String
   private String field_2737;
   // $FF: renamed from: Ga org.json.JSONObject
   private JSONObject field_2738;
   // $FF: renamed from: Gt int
   private int field_2739;
   // $FF: renamed from: Gu int
   private int field_2740;
   private String mName;

   MediaTrack(long var1, int var3) throws IllegalArgumentException {
      this.clear();
      this.field_2734 = var1;
      if(var3 > 0 && var3 <= 3) {
         this.field_2739 = var3;
      } else {
         throw new IllegalArgumentException("invalid type " + var3);
      }
   }

   MediaTrack(JSONObject var1) throws JSONException {
      this.method_3553(var1);
   }

   // $FF: renamed from: c (org.json.JSONObject) void
   private void method_3553(JSONObject var1) throws JSONException {
      this.clear();
      this.field_2734 = var1.getLong("trackId");
      String var2 = var1.getString("type");
      if("TEXT".equals(var2)) {
         this.field_2739 = 1;
      } else if("AUDIO".equals(var2)) {
         this.field_2739 = 2;
      } else {
         if(!"VIDEO".equals(var2)) {
            throw new JSONException("invalid type: " + var2);
         }

         this.field_2739 = 3;
      }

      this.field_2736 = var1.optString("trackContentId", (String)null);
      this.field_2737 = var1.optString("trackContentType", (String)null);
      this.mName = var1.optString("name", (String)null);
      this.field_2735 = var1.optString("language", (String)null);
      if(var1.has("subtype")) {
         String var3 = var1.getString("subtype");
         if("SUBTITLES".equals(var3)) {
            this.field_2740 = 1;
         } else if("CAPTIONS".equals(var3)) {
            this.field_2740 = 2;
         } else if("DESCRIPTIONS".equals(var3)) {
            this.field_2740 = 3;
         } else if("CHAPTERS".equals(var3)) {
            this.field_2740 = 4;
         } else {
            if(!"METADATA".equals(var3)) {
               throw new JSONException("invalid subtype: " + var3);
            }

            this.field_2740 = 5;
         }
      } else {
         this.field_2740 = 0;
      }

      this.field_2738 = var1.optJSONObject("customData");
   }

   private void clear() {
      this.field_2734 = 0L;
      this.field_2739 = 0;
      this.field_2736 = null;
      this.mName = null;
      this.field_2735 = null;
      this.field_2740 = -1;
      this.field_2738 = null;
   }

   // $FF: renamed from: ab (int) void
   void method_3554(int var1) throws IllegalArgumentException {
      if(var1 > -1 && var1 <= 5) {
         if(var1 != 0 && this.field_2739 != 1) {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
         } else {
            this.field_2740 = var1;
         }
      } else {
         throw new IllegalArgumentException("invalid subtype " + var1);
      }
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
            if(this.field_2738 == null) {
               var6 = var2;
            } else {
               var6 = false;
            }

            boolean var7;
            if(var5.field_2738 == null) {
               var7 = var2;
            } else {
               var7 = false;
            }

            var4 = false;
            if(var6 == var7) {
               if(this.field_2738 != null && var5.field_2738 != null) {
                  boolean var8 = class_716.method_4194(this.field_2738, var5.field_2738);
                  var4 = false;
                  if(!var8) {
                     return var4;
                  }
               }

               if(this.field_2734 != var5.field_2734 || this.field_2739 != var5.field_2739 || !class_322.method_2262(this.field_2736, var5.field_2736) || !class_322.method_2262(this.field_2737, var5.field_2737) || !class_322.method_2262(this.mName, var5.mName) || !class_322.method_2262(this.field_2735, var5.field_2735) || this.field_2740 != var5.field_2740) {
                  var2 = false;
               }

               return var2;
            }
         }
      }

      return var4;
   }

   public String getContentId() {
      return this.field_2736;
   }

   public String getContentType() {
      return this.field_2737;
   }

   public JSONObject getCustomData() {
      return this.field_2738;
   }

   public long getId() {
      return this.field_2734;
   }

   public String getLanguage() {
      return this.field_2735;
   }

   public String getName() {
      return this.mName;
   }

   public int getSubtype() {
      return this.field_2740;
   }

   public int getType() {
      return this.field_2739;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.field_2734), Integer.valueOf(this.field_2739), this.field_2736, this.field_2737, this.mName, this.field_2735, Integer.valueOf(this.field_2740), this.field_2738};
      return class_336.hashCode(var1);
   }

   public void setContentId(String var1) {
      this.field_2736 = var1;
   }

   public void setContentType(String var1) {
      this.field_2737 = var1;
   }

   void setCustomData(JSONObject var1) {
      this.field_2738 = var1;
   }

   void setLanguage(String var1) {
      this.field_2735 = var1;
   }

   void setName(String var1) {
      this.mName = var1;
   }

   public JSONObject toJson() {
      // $FF: Couldn't be decompiled
   }

   public static class Builder {
      // $FF: renamed from: Gv com.google.android.gms.cast.MediaTrack
      private final MediaTrack field_3842;

      public Builder(long var1, int var3) throws IllegalArgumentException {
         this.field_3842 = new MediaTrack(var1, var3);
      }

      public MediaTrack build() {
         return this.field_3842;
      }

      public MediaTrack.Builder setContentId(String var1) {
         this.field_3842.setContentId(var1);
         return this;
      }

      public MediaTrack.Builder setContentType(String var1) {
         this.field_3842.setContentType(var1);
         return this;
      }

      public MediaTrack.Builder setCustomData(JSONObject var1) {
         this.field_3842.setCustomData(var1);
         return this;
      }

      public MediaTrack.Builder setLanguage(String var1) {
         this.field_3842.setLanguage(var1);
         return this;
      }

      public MediaTrack.Builder setLanguage(Locale var1) {
         this.field_3842.setLanguage(class_322.method_2266(var1));
         return this;
      }

      public MediaTrack.Builder setName(String var1) {
         this.field_3842.setName(var1);
         return this;
      }

      public MediaTrack.Builder setSubtype(int var1) throws IllegalArgumentException {
         this.field_3842.method_3554(var1);
         return this;
      }
   }
}
