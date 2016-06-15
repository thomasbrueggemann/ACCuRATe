package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.class_281;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
   public static final int STREAM_TYPE_BUFFERED = 1;
   public static final int STREAM_TYPE_INVALID = -1;
   public static final int STREAM_TYPE_LIVE = 2;
   public static final int STREAM_TYPE_NONE;
   // $FF: renamed from: Aq java.lang.String
   private final String field_4101;
   // $FF: renamed from: Ar int
   private int field_4102;
   // $FF: renamed from: As java.lang.String
   private String field_4103;
   // $FF: renamed from: At com.google.android.gms.cast.MediaMetadata
   private MediaMetadata field_4104;
   // $FF: renamed from: Au long
   private long field_4105;
   // $FF: renamed from: Av java.util.List
   private List<MediaTrack> field_4106;
   // $FF: renamed from: Aw com.google.android.gms.cast.TextTrackStyle
   private TextTrackStyle field_4107;
   // $FF: renamed from: Ax org.json.JSONObject
   private JSONObject field_4108;

   MediaInfo(String var1) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("content ID cannot be null or empty");
      } else {
         this.field_4101 = var1;
         this.field_4102 = -1;
      }
   }

   MediaInfo(JSONObject var1) throws JSONException {
      int var2 = 0;
      super();
      this.field_4101 = var1.getString("contentId");
      String var3 = var1.getString("streamType");
      if("NONE".equals(var3)) {
         this.field_4102 = 0;
      } else if("BUFFERED".equals(var3)) {
         this.field_4102 = 1;
      } else if("LIVE".equals(var3)) {
         this.field_4102 = 2;
      } else {
         this.field_4102 = -1;
      }

      this.field_4103 = var1.getString("contentType");
      if(var1.has("metadata")) {
         JSONObject var9 = var1.getJSONObject("metadata");
         this.field_4104 = new MediaMetadata(var9.getInt("metadataType"));
         this.field_4104.method_4522(var9);
      }

      this.field_4105 = class_332.method_2120(var1.optDouble("duration", 0.0D));
      if(var1.has("tracks")) {
         this.field_4106 = new ArrayList();

         for(JSONArray var6 = var1.getJSONArray("tracks"); var2 < var6.length(); ++var2) {
            MediaTrack var7 = new MediaTrack(var6.getJSONObject(var2));
            this.field_4106.add(var7);
         }
      } else {
         this.field_4106 = null;
      }

      if(var1.has("textTrackStyle")) {
         JSONObject var4 = var1.getJSONObject("textTrackStyle");
         TextTrackStyle var5 = new TextTrackStyle();
         var5.method_3469(var4);
         this.field_4107 = var5;
      } else {
         this.field_4107 = null;
      }

      this.field_4108 = var1.optJSONObject("customData");
   }

   // $FF: renamed from: a (com.google.android.gms.cast.MediaMetadata) void
   void method_4319(MediaMetadata var1) {
      this.field_4104 = var1;
   }

   // $FF: renamed from: b (java.util.List) void
   void method_4320(List<MediaTrack> var1) {
      this.field_4106 = var1;
   }

   // $FF: renamed from: dT () void
   void method_4321() throws IllegalArgumentException {
      if(TextUtils.isEmpty(this.field_4101)) {
         throw new IllegalArgumentException("content ID cannot be null or empty");
      } else if(TextUtils.isEmpty(this.field_4103)) {
         throw new IllegalArgumentException("content type cannot be null or empty");
      } else if(this.field_4102 == -1) {
         throw new IllegalArgumentException("a valid stream type must be specified");
      }
   }

   // $FF: renamed from: dU () org.json.JSONObject
   public JSONObject method_4322() {
      // $FF: Couldn't be decompiled
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
               if(this.field_4108 == null) {
                  var6 = var2;
               } else {
                  var6 = false;
               }

               boolean var7;
               if(var5.field_4108 == null) {
                  var7 = var2;
               } else {
                  var7 = false;
               }

               var4 = false;
               if(var6 == var7) {
                  if(this.field_4108 == null || var5.field_4108 == null) {
                     break label46;
                  }

                  boolean var8 = class_281.method_1868(this.field_4108, var5.field_4108);
                  var4 = false;
                  if(var8) {
                     break label46;
                  }
               }
            }
         }

         return var4;
      }

      if(!class_332.method_2117(this.field_4101, var5.field_4101) || this.field_4102 != var5.field_4102 || !class_332.method_2117(this.field_4103, var5.field_4103) || !class_332.method_2117(this.field_4104, var5.field_4104) || this.field_4105 != var5.field_4105) {
         var2 = false;
      }

      return var2;
   }

   public String getContentId() {
      return this.field_4101;
   }

   public String getContentType() {
      return this.field_4103;
   }

   public JSONObject getCustomData() {
      return this.field_4108;
   }

   public List<MediaTrack> getMediaTracks() {
      return this.field_4106;
   }

   public MediaMetadata getMetadata() {
      return this.field_4104;
   }

   public long getStreamDuration() {
      return this.field_4105;
   }

   public int getStreamType() {
      return this.field_4102;
   }

   public TextTrackStyle getTextTrackStyle() {
      return this.field_4107;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_4101, Integer.valueOf(this.field_4102), this.field_4103, this.field_4104, Long.valueOf(this.field_4105), String.valueOf(this.field_4108)};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: m (long) void
   void method_4323(long var1) throws IllegalArgumentException {
      if(var1 < 0L) {
         throw new IllegalArgumentException("Stream duration cannot be negative");
      } else {
         this.field_4105 = var1;
      }
   }

   void setContentType(String var1) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("content type cannot be null or empty");
      } else {
         this.field_4103 = var1;
      }
   }

   void setCustomData(JSONObject var1) {
      this.field_4108 = var1;
   }

   void setStreamType(int var1) throws IllegalArgumentException {
      if(var1 >= -1 && var1 <= 2) {
         this.field_4102 = var1;
      } else {
         throw new IllegalArgumentException("invalid stream type");
      }
   }

   public void setTextTrackStyle(TextTrackStyle var1) {
      this.field_4107 = var1;
   }

   public static class Builder {
      // $FF: renamed from: Ay com.google.android.gms.cast.MediaInfo
      private final MediaInfo field_1580;

      public Builder(String var1) throws IllegalArgumentException {
         if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("Content ID cannot be empty");
         } else {
            this.field_1580 = new MediaInfo(var1);
         }
      }

      public MediaInfo build() throws IllegalArgumentException {
         this.field_1580.method_4321();
         return this.field_1580;
      }

      public MediaInfo.Builder setContentType(String var1) throws IllegalArgumentException {
         this.field_1580.setContentType(var1);
         return this;
      }

      public MediaInfo.Builder setCustomData(JSONObject var1) {
         this.field_1580.setCustomData(var1);
         return this;
      }

      public MediaInfo.Builder setMediaTracks(List<MediaTrack> var1) {
         this.field_1580.method_4320(var1);
         return this;
      }

      public MediaInfo.Builder setMetadata(MediaMetadata var1) {
         this.field_1580.method_4319(var1);
         return this;
      }

      public MediaInfo.Builder setStreamDuration(long var1) throws IllegalArgumentException {
         this.field_1580.method_4323(var1);
         return this;
      }

      public MediaInfo.Builder setStreamType(int var1) throws IllegalArgumentException {
         this.field_1580.setStreamType(var1);
         return this;
      }

      public MediaInfo.Builder setTextTrackStyle(TextTrackStyle var1) {
         this.field_1580.setTextTrackStyle(var1);
         return this;
      }
   }
}
