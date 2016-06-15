package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.class_288;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlusShare {
   public static final String EXTRA_CALL_TO_ACTION = "com.google.android.apps.plus.CALL_TO_ACTION";
   public static final String EXTRA_CONTENT_DEEP_LINK_ID = "com.google.android.apps.plus.CONTENT_DEEP_LINK_ID";
   public static final String EXTRA_CONTENT_DEEP_LINK_METADATA = "com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA";
   public static final String EXTRA_CONTENT_URL = "com.google.android.apps.plus.CONTENT_URL";
   public static final String EXTRA_IS_INTERACTIVE_POST = "com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST";
   public static final String EXTRA_SENDER_ID = "com.google.android.apps.plus.SENDER_ID";
   public static final String KEY_CALL_TO_ACTION_DEEP_LINK_ID = "deepLinkId";
   public static final String KEY_CALL_TO_ACTION_LABEL = "label";
   public static final String KEY_CALL_TO_ACTION_URL = "url";
   public static final String KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION = "description";
   public static final String KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL = "thumbnailUrl";
   public static final String KEY_CONTENT_DEEP_LINK_METADATA_TITLE = "title";
   public static final String PARAM_CONTENT_DEEP_LINK_ID = "deep_link_id";

   @Deprecated
   protected PlusShare() {
      throw new AssertionError();
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, android.net.Uri) android.os.Bundle
   public static Bundle method_4165(String var0, String var1, Uri var2) {
      Bundle var3 = new Bundle();
      var3.putString("title", var0);
      var3.putString("description", var1);
      if(var2 != null) {
         var3.putString("thumbnailUrl", var2.toString());
      }

      return var3;
   }

   // $FF: renamed from: bv (java.lang.String) boolean
   protected static boolean method_4166(String var0) {
      if(TextUtils.isEmpty(var0)) {
         Log.e("GooglePlusPlatform", "The provided deep-link ID is empty.");
         return false;
      } else if(var0.contains(" ")) {
         Log.e("GooglePlusPlatform", "Spaces are not allowed in deep-link IDs.");
         return false;
      } else {
         return true;
      }
   }

   public static Person createPerson(String var0, String var1) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("MinimalPerson ID must not be empty.");
      } else if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("Display name must not be empty.");
      } else {
         return new class_288(var1, var0, (class_288.class_950)null, 0, (String)null);
      }
   }

   public static String getDeepLinkId(Intent var0) {
      String var1 = null;
      if(var0 != null) {
         Uri var2 = var0.getData();
         var1 = null;
         if(var2 != null) {
            var1 = var0.getData().getQueryParameter("deep_link_id");
         }
      }

      return var1;
   }

   public static class Builder {
      private boolean abE;
      private ArrayList<Uri> abF;
      private final Context mContext;
      private final Intent mIntent;

      public Builder(Activity var1) {
         this.mContext = var1;
         this.mIntent = (new Intent()).setAction("android.intent.action.SEND");
         this.mIntent.addFlags(524288);
         if(var1 != null && var1.getComponentName() != null) {
            this.abE = true;
         }

      }

      @Deprecated
      public Builder(Activity var1, PlusClient var2) {
         this(var1);
         boolean var3;
         if(var2 != null) {
            var3 = true;
         } else {
            var3 = false;
         }

         class_347.method_2161(var3, "PlusClient must not be null.");
         class_347.method_2161(var2.isConnected(), "PlusClient must be connected to create an interactive post.");
         class_347.method_2161(var2.method_2784().method_1484("https://www.googleapis.com/auth/plus.login"), "Must request PLUS_LOGIN scope in PlusClient to create an interactive post.");
         Person var4 = var2.getCurrentPerson();
         String var5;
         if(var4 != null) {
            var5 = var4.getId();
         } else {
            var5 = "0";
         }

         this.mIntent.putExtra("com.google.android.apps.plus.SENDER_ID", var5);
      }

      public Builder(Context var1) {
         this.mContext = var1;
         this.mIntent = (new Intent()).setAction("android.intent.action.SEND");
      }

      public PlusShare.Builder addCallToAction(String var1, Uri var2, String var3) {
         class_347.method_2161(this.abE, "Must include the launching activity with PlusShare.Builder constructor before setting call-to-action");
         boolean var4;
         if(var2 != null && !TextUtils.isEmpty(var2.toString())) {
            var4 = true;
         } else {
            var4 = false;
         }

         class_347.method_2168(var4, "Must provide a call to action URL");
         Bundle var5 = new Bundle();
         if(!TextUtils.isEmpty(var1)) {
            var5.putString("label", var1);
         }

         var5.putString("url", var2.toString());
         if(!TextUtils.isEmpty(var3)) {
            class_347.method_2161(PlusShare.method_4166(var3), "The specified deep-link ID was malformed.");
            var5.putString("deepLinkId", var3);
         }

         this.mIntent.putExtra("com.google.android.apps.plus.CALL_TO_ACTION", var5);
         this.mIntent.putExtra("com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST", true);
         this.mIntent.setType("text/plain");
         return this;
      }

      public PlusShare.Builder addStream(Uri var1) {
         Uri var2 = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
         if(var2 == null) {
            return this.setStream(var1);
         } else {
            if(this.abF == null) {
               this.abF = new ArrayList();
            }

            this.abF.add(var2);
            this.abF.add(var1);
            return this;
         }
      }

      public Intent getIntent() {
         byte var1 = 1;
         byte var2;
         if(this.abF != null && this.abF.size() > var1) {
            var2 = var1;
         } else {
            var2 = 0;
         }

         boolean var3 = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
         boolean var4 = this.mIntent.getBooleanExtra("com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST", false);
         byte var5;
         if(var2 != 0 && var4) {
            var5 = 0;
         } else {
            var5 = var1;
         }

         class_347.method_2161((boolean)var5, "Call-to-action buttons are only available for URLs.");
         byte var6;
         if(var4 && !this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_URL")) {
            var6 = 0;
         } else {
            var6 = var1;
         }

         class_347.method_2161((boolean)var6, "The content URL is required for interactive posts.");
         if(var4 && !this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_URL") && !this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
            var1 = 0;
         }

         class_347.method_2161((boolean)var1, "Must set content URL or content deep-link ID to use a call-to-action button.");
         if(this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
            class_347.method_2161(PlusShare.method_4166(this.mIntent.getStringExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")), "The specified deep-link ID was malformed.");
         }

         if(var2 == 0 && var3) {
            this.mIntent.setAction("android.intent.action.SEND");
            if(this.abF != null && !this.abF.isEmpty()) {
               this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.abF.get(0));
            } else {
               this.mIntent.removeExtra("android.intent.extra.STREAM");
            }

            this.abF = null;
         }

         if(var2 != 0 && !var3) {
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            if(this.abF != null && !this.abF.isEmpty()) {
               this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.abF);
            } else {
               this.mIntent.removeExtra("android.intent.extra.STREAM");
            }
         }

         if("com.google.android.gms.plus.action.SHARE_INTERNAL_GOOGLE".equals(this.mIntent.getAction())) {
            this.mIntent.setPackage("com.google.android.gms");
            return this.mIntent;
         } else if(!this.mIntent.hasExtra("android.intent.extra.STREAM")) {
            this.mIntent.setAction("com.google.android.gms.plus.action.SHARE_GOOGLE");
            this.mIntent.setPackage("com.google.android.gms");
            return this.mIntent;
         } else {
            this.mIntent.setPackage("com.google.android.apps.plus");
            return this.mIntent;
         }
      }

      public PlusShare.Builder setContentDeepLinkId(String var1) {
         return this.setContentDeepLinkId(var1, (String)null, (String)null, (Uri)null);
      }

      public PlusShare.Builder setContentDeepLinkId(String var1, String var2, String var3, Uri var4) {
         class_347.method_2168(this.abE, "Must include the launching activity with PlusShare.Builder constructor before setting deep links");
         boolean var5;
         if(!TextUtils.isEmpty(var1)) {
            var5 = true;
         } else {
            var5 = false;
         }

         class_347.method_2168(var5, "The deepLinkId parameter is required.");
         Bundle var6 = PlusShare.method_4165(var2, var3, var4);
         this.mIntent.putExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID", var1);
         this.mIntent.putExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA", var6);
         this.mIntent.setType("text/plain");
         return this;
      }

      public PlusShare.Builder setContentUrl(Uri var1) {
         String var2 = null;
         if(var1 != null) {
            var2 = var1.toString();
         }

         if(TextUtils.isEmpty(var2)) {
            this.mIntent.removeExtra("com.google.android.apps.plus.CONTENT_URL");
            return this;
         } else {
            this.mIntent.putExtra("com.google.android.apps.plus.CONTENT_URL", var2);
            return this;
         }
      }

      public PlusShare.Builder setRecipients(Person var1, List<Person> var2) {
         Intent var3 = this.mIntent;
         String var4;
         if(var1 != null) {
            var4 = var1.getId();
         } else {
            var4 = "0";
         }

         var3.putExtra("com.google.android.apps.plus.SENDER_ID", var4);
         return this.setRecipients(var2);
      }

      @Deprecated
      public PlusShare.Builder setRecipients(List<Person> var1) {
         int var2;
         if(var1 != null) {
            var2 = var1.size();
         } else {
            var2 = 0;
         }

         if(var2 == 0) {
            this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_IDS");
            this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES");
            return this;
         } else {
            ArrayList var3 = new ArrayList(var2);
            ArrayList var4 = new ArrayList(var2);
            Iterator var5 = var1.iterator();

            while(var5.hasNext()) {
               Person var8 = (Person)var5.next();
               var3.add(var8.getId());
               var4.add(var8.getDisplayName());
            }

            this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_IDS", var3);
            this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES", var4);
            return this;
         }
      }

      public PlusShare.Builder setStream(Uri var1) {
         this.abF = null;
         this.mIntent.putExtra("android.intent.extra.STREAM", var1);
         return this;
      }

      public PlusShare.Builder setText(CharSequence var1) {
         this.mIntent.putExtra("android.intent.extra.TEXT", var1);
         return this;
      }

      public PlusShare.Builder setType(String var1) {
         this.mIntent.setType(var1);
         return this;
      }
   }
}
