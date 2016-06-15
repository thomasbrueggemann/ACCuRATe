package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.internal.class_335;

public final class Action extends Thing {
   public static final String TYPE_ADD = "http://schema.org/AddAction";
   public static final String TYPE_BOOKMARK = "http://schema.org/BookmarkAction";
   public static final String TYPE_LIKE = "http://schema.org/LikeAction";
   public static final String TYPE_LISTEN = "http://schema.org/ListenAction";
   public static final String TYPE_VIEW = "http://schema.org/ViewAction";
   public static final String TYPE_WANT = "http://schema.org/WantAction";
   public static final String TYPE_WATCH = "http://schema.org/WatchAction";

   private Action(Bundle var1) {
      super(var1);
   }

   // $FF: synthetic method
   Action(Bundle var1, Object var2) {
      this(var1);
   }

   public static Action newAction(String var0, String var1, Uri var2) {
      return newAction(var0, var1, (Uri)null, var2);
   }

   public static Action newAction(String var0, String var1, Uri var2, Uri var3) {
      Action.Builder var4 = new Action.Builder(var0);
      Thing.Builder var5 = (new Thing.Builder()).setName(var1);
      String var6;
      if(var2 == null) {
         var6 = null;
      } else {
         var6 = var2.toString();
      }

      return var4.setObject(var5.setId(var6).setUrl(var3).build()).build();
   }

   public static final class Builder extends Thing.Builder {
      public Builder(String var1) {
         class_335.method_2311(var1);
         super.put("type", var1);
      }

      public Action build() {
         class_335.method_2306(this.DJ.get("object"), "setObject is required before calling build().");
         class_335.method_2306(this.DJ.get("type"), "setType is required before calling build().");
         Bundle var3 = (Bundle)this.DJ.getParcelable("object");
         class_335.method_2306(var3.get("name"), "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
         class_335.method_2306(var3.get("url"), "Must call setObject() with a valid app url. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
         return new Action(this.DJ);
      }

      public Action.Builder put(String var1, Thing var2) {
         return (Action.Builder)super.put(var1, var2);
      }

      public Action.Builder put(String var1, String var2) {
         return (Action.Builder)super.put(var1, var2);
      }

      public Action.Builder setName(String var1) {
         return (Action.Builder)super.put("name", var1);
      }

      public Action.Builder setObject(Thing var1) {
         class_335.method_2311(var1);
         return (Action.Builder)super.put("object", var1);
      }

      public Action.Builder setUrl(Uri var1) {
         if(var1 != null) {
            super.put("url", var1.toString());
         }

         return this;
      }
   }
}
