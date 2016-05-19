package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.content.EditorCompatGingerbread;

public final class SharedPreferencesCompat {
   public static final class EditorCompat {
      private static SharedPreferencesCompat.EditorCompat sInstance;
      private final SharedPreferencesCompat.Helper mHelper;

      private EditorCompat() {
         if(VERSION.SDK_INT >= 9) {
            this.mHelper = new SharedPreferencesCompat.EditorHelperApi9Impl();
         } else {
            this.mHelper = new SharedPreferencesCompat.EditorHelperBaseImpl();
         }
      }

      public static SharedPreferencesCompat.EditorCompat getInstance() {
         if(sInstance == null) {
            sInstance = new SharedPreferencesCompat.EditorCompat();
         }

         return sInstance;
      }

      public void apply(@NonNull Editor var1) {
         this.mHelper.apply(var1);
      }
   }

   private static class EditorHelperApi9Impl implements SharedPreferencesCompat.Helper {
      private EditorHelperApi9Impl() {
      }

      // $FF: synthetic method
      EditorHelperApi9Impl(Object var1) {
         this();
      }

      public void apply(@NonNull Editor var1) {
         EditorCompatGingerbread.apply(var1);
      }
   }

   private static class EditorHelperBaseImpl implements SharedPreferencesCompat.Helper {
      private EditorHelperBaseImpl() {
      }

      // $FF: synthetic method
      EditorHelperBaseImpl(Object var1) {
         this();
      }

      public void apply(@NonNull Editor var1) {
         var1.commit();
      }
   }

   private interface Helper {
      void apply(@NonNull Editor var1);
   }
}
