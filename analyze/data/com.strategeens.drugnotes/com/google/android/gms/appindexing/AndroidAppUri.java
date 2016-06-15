package com.google.android.gms.appindexing;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.internal.class_336;
import java.util.Iterator;
import java.util.List;

public final class AndroidAppUri {
   private final Uri mUri;

   private AndroidAppUri(Uri var1) {
      this.mUri = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.appindexing.AndroidAppUri) boolean
   private static boolean method_4129(AndroidAppUri var0) {
      if(!"android-app".equals(var0.mUri.getScheme())) {
         throw new IllegalArgumentException("android-app scheme is required.");
      } else if(TextUtils.isEmpty(var0.getPackageName())) {
         throw new IllegalArgumentException("Package name is empty.");
      } else {
         Uri var1 = newAndroidAppUri(var0.getPackageName(), var0.getDeepLinkUri()).toUri();
         if(!var0.mUri.equals(var1)) {
            throw new IllegalArgumentException("URI is not canonical.");
         } else {
            return true;
         }
      }
   }

   public static AndroidAppUri newAndroidAppUri(Uri var0) {
      AndroidAppUri var1 = new AndroidAppUri(var0);
      if(method_4129(var1)) {
         return var1;
      } else {
         throw new IllegalArgumentException("AndroidAppUri validation failed.");
      }
   }

   public static AndroidAppUri newAndroidAppUri(String var0, Uri var1) {
      Builder var2 = (new Builder()).scheme("android-app").authority(var0);
      if(var1 != null) {
         var2.appendPath(var1.getScheme());
         if(var1.getAuthority() != null) {
            var2.appendPath(var1.getAuthority());
         }

         Iterator var4 = var1.getPathSegments().iterator();

         while(var4.hasNext()) {
            var2.appendPath((String)var4.next());
         }

         var2.encodedQuery(var1.getEncodedQuery()).encodedFragment(var1.getEncodedFragment());
      }

      return new AndroidAppUri(var2.build());
   }

   public boolean equals(Object var1) {
      return var1 instanceof AndroidAppUri?this.mUri.equals(((AndroidAppUri)var1).mUri):false;
   }

   public Uri getDeepLinkUri() {
      List var1 = this.mUri.getPathSegments();
      if(var1.size() <= 0) {
         return null;
      } else {
         String var2 = (String)var1.get(0);
         Builder var3 = new Builder();
         var3.scheme(var2);
         if(var1.size() > 1) {
            var3.authority((String)var1.get(1));

            for(int var8 = 2; var8 < var1.size(); ++var8) {
               var3.appendPath((String)var1.get(var8));
            }
         }

         var3.encodedQuery(this.mUri.getEncodedQuery());
         var3.encodedFragment(this.mUri.getEncodedFragment());
         return var3.build();
      }
   }

   public String getPackageName() {
      return this.mUri.getAuthority();
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mUri};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return this.mUri.toString();
   }

   public Uri toUri() {
      return this.mUri;
   }
}
