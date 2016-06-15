package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_716;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
   public static final int STREAM_TYPE_BUFFERED = 1;
   public static final int STREAM_TYPE_INVALID = -1;
   public static final int STREAM_TYPE_LIVE = 2;
   public static final int STREAM_TYPE_NONE = 0;
   public static final long UNKNOWN_DURATION = -1L;
   // $FF: renamed from: FT java.lang.String
   private final String field_4236;
   // $FF: renamed from: FU int
   private int field_4237;
   // $FF: renamed from: FV java.lang.String
   private String field_4238;
   // $FF: renamed from: FW com.google.android.gms.cast.MediaMetadata
   private MediaMetadata field_4239;
   // $FF: renamed from: FX long
   private long field_4240;
   // $FF: renamed from: FY java.util.List
   private List<MediaTrack> field_4241;
   // $FF: renamed from: FZ com.google.android.gms.cast.TextTrackStyle
   private TextTrackStyle field_4242;
   // $FF: renamed from: Ga org.json.JSONObject
   private JSONObject field_4243;

   MediaInfo(String var1) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("content ID cannot be null or empty");
      } else {
         this.field_4236 = var1;
         this.field_4237 = -1;
      }
   }

   MediaInfo(JSONObject var1) throws JSONException {
      int var2 = 0;
      super();
      this.field_4236 = var1.getString("contentId");
      String var3 = var1.getString("streamType");
      if("NONE".equals(var3)) {
         this.field_4237 = 0;
      } else if("BUFFERED".equals(var3)) {
         this.field_4237 = 1;
      } else if("LIVE".equals(var3)) {
         this.field_4237 = 2;
      } else {
         this.field_4237 = -1;
      }

      this.field_4238 = var1.getString("contentType");
      if(var1.has("metadata")) {
         JSONObject var11 = var1.getJSONObject("metadata");
         this.field_4239 = new MediaMetadata(var11.getInt("metadataType"));
         this.field_4239.method_5788(var11);
      }

      this.field_4240 = -1L;
      if(var1.has("duration") && !var1.isNull("duration")) {
         double var9 = var1.optDouble("duration", 0.0D);
         if(!Double.isNaN(var9) && !Double.isInfinite(var9)) {
            this.field_4240 = class_322.method_2265(var9);
         }
      }

      if(var1.has("tracks")) {
         this.field_4241 = new ArrayList();

         for(JSONArray var6 = var1.getJSONArray("tracks"); var2 < var6.length(); ++var2) {
            MediaTrack var7 = new MediaTrack(var6.getJSONObject(var2));
            this.field_4241.add(var7);
         }
      } else {
         this.field_4241 = null;
      }

      if(var1.has("textTrackStyle")) {
         JSONObject var4 = var1.getJSONObject("textTrackStyle");
         TextTrackStyle var5 = new TextTrackStyle();
         var5.method_4158(var4);
         this.field_4242 = var5;
      } else {
         this.field_4242 = null;
      }

      this.field_4243 = var1.optJSONObject("customData");
   }

   // $FF: renamed from: a (com.google.android.gms.cast.MediaMetadata) void
   void method_5464(MediaMetadata var1) {
      this.field_4239 = var1;
   }

   // $FF: renamed from: d (java.util.List) void
   void method_5465(List<MediaTrack> var1) {
      this.field_4241 = var1;
   }

   public boolean equals(Object var1) {
      boolean var2;
      MediaInfo var5;
      label46: {
         var2 = true;
         boolean var4;
         if(this == var1) {
            var4 = var2;
         } else {
            boolean var3 = var1 instanceof MediaInfo;
            var4 = false;
            if(var3) {
               var5 = (MediaInfo)var1;
               boolean var6;
               if(this.field_4243 == null) {
                  var6 = var2;
               } else {
                  var6 = false;
               }

               boolean var7;
               if(var5.field_4243 == null) {
                  var7 = var2;
               } else {
                  var7 = false;
               }

               var4 = false;
               if(var6 == var7) {
                  if(this.field_4243 == null || var5.field_4243 == null) {
                     break label46;
                  }

                  boolean var8 = class_716.method_4194(this.field_4243, var5.field_4243);
                  var4 = false;
                  if(var8) {
                     break label46;
                  }
               }
            }
         }

         return var4;
      }

      if(!class_322.method_2262(this.field_4236, var5.field_4236) || this.field_4237 != var5.field_4237 || !class_322.method_2262(this.field_4238, var5.field_4238) || !class_322.method_2262(this.field_4239, var5.field_4239) || this.field_4240 != var5.field_4240) {
         var2 = false;
      }

      return var2;
   }

   // $FF: renamed from: fQ () void
   void method_5466() throws IllegalArgumentException {
      if(TextUtils.isEmpty(this.field_4236)) {
         throw new IllegalArgumentException("content ID cannot be null or empty");
      } else if(TextUtils.isEmpty(this.field_4238)) {
         throw new IllegalArgumentException("content type cannot be null or empty");
      } else if(this.field_4237 == -1) {
         throw new IllegalArgumentException("a valid stream type must be specified");
      }
   }

   public String getContentId() {
      return this.field_4236;
   }

   public String getContentType() {
      return this.field_4238;
   }

   public JSONObject getCustomData() {
      return this.field_4243;
   }

   public List<MediaTrack> getMediaTracks() {
      return this.field_4241;
   }

   public MediaMetadata getMetadata() {
      return this.field_4239;
   }

   public long getStreamDuration() {
      return this.field_4240;
   }

   public int getStreamType() {
      return this.field_4237;
   }

   public TextTrackStyle getTextTrackStyle() {
      return this.field_4242;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_4236, Integer.valueOf(this.field_4237), this.field_4238, this.field_4239, Long.valueOf(this.field_4240), String.valueOf(this.field_4243)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: m (long) void
   void method_5467(long var1) throws IllegalArgumentException {
      if(var1 < 0L) {
         throw new IllegalArgumentException("Stream duration cannot be negative");
      } else {
         this.field_4240 = var1;
      }
   }

   void setContentType(String var1) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("content type cannot be null or empty");
      } else {
         this.field_4238 = var1;
      }
   }

   void setCustomData(JSONObject var1) {
      this.field_4243 = var1;
   }

   void setStreamType(int var1) throws IllegalArgumentException {
      if(var1 >= -1 && var1 <= 2) {
         this.field_4237 = var1;
      } else {
         throw new IllegalArgumentException("invalid stream type");
      }
   }

   public void setTextTrackStyle(TextTrackStyle var1) {
      this.field_4242 = var1;
   }

   public JSONObject toJson() {
      // $FF: Couldn't be decompiled
   }

   public static class Builder {
      // $FF: renamed from: Gb com.google.android.gms.cast.MediaInfo
      private final MediaInfo field_1266;

      public Builder(String var1) throws IllegalArgumentException {
         if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("Content ID cannot be empty");
         } else {
            this.field_1266 = new MediaInfo(var1);
         }
      }

      public MediaInfo build() throws IllegalArgumentException {
         this.field_1266.method_5466();
         return this.field_1266;
      }

      public MediaInfo.Builder setContentType(String var1) throws IllegalArgumentException {
         this.field_1266.setContentType(var1);
         return this;
      }

      public MediaInfo.Builder setCustomData(JSONObject var1) {
         this.field_1266.setCustomData(var1);
         return this;
      }

      public MediaInfo.Builder setMediaTracks(List<MediaTrack> var1) {
         this.field_1266.method_5465(var1);
         return this;
      }

      public MediaInfo.Builder setMetadata(MediaMetadata var1) {
         this.field_1266.method_5464(var1);
         return this;
      }

      public MediaInfo.Builder setStreamDuration(long var1) throws IllegalArgumentException {
         this.field_1266.method_5467(var1);
         return this;
      }

      public MediaInfo.Builder setStreamType(int var1) throws IllegalArgumentException {
         this.field_1266.setStreamType(var1);
         return this;
      }

      public MediaInfo.Builder setTextTrackStyle(TextTrackStyle var1) {
         this.field_1266.setTextTrackStyle(var1);
         return this;
      }
   }
}
