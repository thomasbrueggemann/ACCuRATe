package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

public class MediaUtils {
   public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.method_205("mkv", "video/x-matroska");

   @Nullable
   private static String extractExtension(String var0) {
      int var1 = var0.lastIndexOf(46);
      return var1 >= 0 && var1 != -1 + var0.length()?var0.substring(var1 + 1):null;
   }

   @Nullable
   public static String extractMime(String var0) {
      String var1 = extractExtension(var0);
      String var3;
      if(var1 == null) {
         var3 = null;
      } else {
         String var2 = var1.toLowerCase(Locale.US);
         var3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var2);
         if(var3 == null) {
            return (String)ADDITIONAL_ALLOWED_MIME_TYPES.get(var2);
         }
      }

      return var3;
   }

   public static boolean isNonNativeSupportedMimeType(String var0) {
      return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(var0);
   }

   public static boolean isPhoto(@Nullable String var0) {
      return var0 != null && var0.startsWith("image/");
   }

   public static boolean isVideo(@Nullable String var0) {
      return var0 != null && var0.startsWith("video/");
   }
}
