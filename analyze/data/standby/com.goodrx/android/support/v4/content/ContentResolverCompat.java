package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.os.CancellationSignal;

public final class ContentResolverCompat {
   private static final ContentResolverCompat.ContentResolverCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new ContentResolverCompat.ContentResolverCompatImplJB();
      } else {
         IMPL = new ContentResolverCompat.ContentResolverCompatImplBase();
      }
   }

   public static Cursor query(ContentResolver var0, Uri var1, String[] var2, String var3, String[] var4, String var5, CancellationSignal var6) {
      return IMPL.query(var0, var1, var2, var3, var4, var5, var6);
   }

   interface ContentResolverCompatImpl {
      Cursor query(ContentResolver var1, Uri var2, String[] var3, String var4, String[] var5, String var6, CancellationSignal var7);
   }

   static class ContentResolverCompatImplBase implements ContentResolverCompat.ContentResolverCompatImpl {
      public Cursor query(ContentResolver var1, Uri var2, String[] var3, String var4, String[] var5, String var6, CancellationSignal var7) {
         if(var7 != null) {
            var7.throwIfCanceled();
         }

         return var1.query(var2, var3, var4, var5, var6);
      }
   }

   static class ContentResolverCompatImplJB extends ContentResolverCompat.ContentResolverCompatImplBase {
      public Cursor query(ContentResolver param1, Uri param2, String[] param3, String param4, String[] param5, String param6, CancellationSignal param7) {
         // $FF: Couldn't be decompiled
      }
   }
}
