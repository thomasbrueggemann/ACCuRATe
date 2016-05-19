package com.facebook.common.util;

import android.net.Uri;
import javax.annotation.Nullable;

public class UriUtil {
   public static final String DATA_SCHEME = "data";
   public static final String HTTPS_SCHEME = "https";
   public static final String HTTP_SCHEME = "http";
   public static final String LOCAL_ASSET_SCHEME = "asset";
   public static final String LOCAL_CONTENT_SCHEME = "content";
   public static final String LOCAL_FILE_SCHEME = "file";
   public static final String LOCAL_RESOURCE_SCHEME = "res";

   @Nullable
   public static String getSchemeOrNull(@Nullable Uri var0) {
      return var0 == null?null:var0.getScheme();
   }

   public static boolean isDataUri(@Nullable Uri var0) {
      return "data".equals(getSchemeOrNull(var0));
   }

   public static boolean isLocalAssetUri(@Nullable Uri var0) {
      return "asset".equals(getSchemeOrNull(var0));
   }

   public static boolean isLocalContentUri(@Nullable Uri var0) {
      return "content".equals(getSchemeOrNull(var0));
   }

   public static boolean isLocalFileUri(@Nullable Uri var0) {
      return "file".equals(getSchemeOrNull(var0));
   }

   public static boolean isLocalResourceUri(@Nullable Uri var0) {
      return "res".equals(getSchemeOrNull(var0));
   }

   public static boolean isNetworkUri(@Nullable Uri var0) {
      String var1 = getSchemeOrNull(var0);
      return "https".equals(var1) || "http".equals(var1);
   }

   public static Uri parseUriOrNull(@Nullable String var0) {
      return var0 != null?Uri.parse(var0):null;
   }
}
