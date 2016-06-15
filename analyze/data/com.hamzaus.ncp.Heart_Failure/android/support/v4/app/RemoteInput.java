package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.RemoteInputCompatApi20;
import android.support.v4.app.RemoteInputCompatBase;
import android.support.v4.app.RemoteInputCompatJellybean;
import android.util.Log;

public class RemoteInput extends RemoteInputCompatBase.RemoteInput {
   public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
   public static final RemoteInputCompatBase.Factory FACTORY;
   private static final RemoteInput.Impl IMPL;
   public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
   private static final String TAG = "RemoteInput";
   private final boolean mAllowFreeFormInput;
   private final CharSequence[] mChoices;
   private final Bundle mExtras;
   private final CharSequence mLabel;
   private final String mResultKey;

   static {
      if(VERSION.SDK_INT >= 20) {
         IMPL = new RemoteInput.ImplApi20();
      } else if(VERSION.SDK_INT >= 16) {
         IMPL = new RemoteInput.ImplJellybean();
      } else {
         IMPL = new RemoteInput.ImplBase();
      }

      FACTORY = new RemoteInputCompatBase.Factory() {
         public RemoteInput build(String var1, CharSequence var2, CharSequence[] var3, boolean var4, Bundle var5) {
            return new RemoteInput(var1, var2, var3, var4, var5);
         }

         public RemoteInput[] newArray(int var1) {
            return new RemoteInput[var1];
         }
      };
   }

   RemoteInput(String var1, CharSequence var2, CharSequence[] var3, boolean var4, Bundle var5) {
      this.mResultKey = var1;
      this.mLabel = var2;
      this.mChoices = var3;
      this.mAllowFreeFormInput = var4;
      this.mExtras = var5;
   }

   public static void addResultsToIntent(RemoteInput[] var0, Intent var1, Bundle var2) {
      IMPL.addResultsToIntent(var0, var1, var2);
   }

   public static Bundle getResultsFromIntent(Intent var0) {
      return IMPL.getResultsFromIntent(var0);
   }

   public boolean getAllowFreeFormInput() {
      return this.mAllowFreeFormInput;
   }

   public CharSequence[] getChoices() {
      return this.mChoices;
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public CharSequence getLabel() {
      return this.mLabel;
   }

   public String getResultKey() {
      return this.mResultKey;
   }

   public static final class Builder {
      private boolean mAllowFreeFormInput = true;
      private CharSequence[] mChoices;
      private Bundle mExtras = new Bundle();
      private CharSequence mLabel;
      private final String mResultKey;

      public Builder(String var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("Result key can\'t be null");
         } else {
            this.mResultKey = var1;
         }
      }

      public RemoteInput.Builder addExtras(Bundle var1) {
         if(var1 != null) {
            this.mExtras.putAll(var1);
         }

         return this;
      }

      public RemoteInput build() {
         return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras);
      }

      public Bundle getExtras() {
         return this.mExtras;
      }

      public RemoteInput.Builder setAllowFreeFormInput(boolean var1) {
         this.mAllowFreeFormInput = var1;
         return this;
      }

      public RemoteInput.Builder setChoices(CharSequence[] var1) {
         this.mChoices = var1;
         return this;
      }

      public RemoteInput.Builder setLabel(CharSequence var1) {
         this.mLabel = var1;
         return this;
      }
   }

   interface Impl {
      void addResultsToIntent(RemoteInput[] var1, Intent var2, Bundle var3);

      Bundle getResultsFromIntent(Intent var1);
   }

   static class ImplApi20 implements RemoteInput.Impl {
      public void addResultsToIntent(RemoteInput[] var1, Intent var2, Bundle var3) {
         RemoteInputCompatApi20.addResultsToIntent(var1, var2, var3);
      }

      public Bundle getResultsFromIntent(Intent var1) {
         return RemoteInputCompatApi20.getResultsFromIntent(var1);
      }
   }

   static class ImplBase implements RemoteInput.Impl {
      public void addResultsToIntent(RemoteInput[] var1, Intent var2, Bundle var3) {
         Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
      }

      public Bundle getResultsFromIntent(Intent var1) {
         Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
         return null;
      }
   }

   static class ImplJellybean implements RemoteInput.Impl {
      public void addResultsToIntent(RemoteInput[] var1, Intent var2, Bundle var3) {
         RemoteInputCompatJellybean.addResultsToIntent(var1, var2, var3);
      }

      public Bundle getResultsFromIntent(Intent var1) {
         return RemoteInputCompatJellybean.getResultsFromIntent(var1);
      }
   }
}
