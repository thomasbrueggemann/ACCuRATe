package android.support.v4.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInputCompatBase;

class RemoteInputCompatJellybean {
   public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
   private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
   private static final String KEY_CHOICES = "choices";
   private static final String KEY_EXTRAS = "extras";
   private static final String KEY_LABEL = "label";
   private static final String KEY_RESULT_KEY = "resultKey";
   public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";

   static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] var0, Intent var1, Bundle var2) {
      Bundle var3 = new Bundle();
      int var4 = var0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         RemoteInputCompatBase.RemoteInput var8 = var0[var5];
         Object var9 = var2.get(var8.getResultKey());
         if(var9 instanceof CharSequence) {
            var3.putCharSequence(var8.getResultKey(), (CharSequence)var9);
         }
      }

      Intent var6 = new Intent();
      var6.putExtra("android.remoteinput.resultsData", var3);
      var1.setClipData(ClipData.newIntent("android.remoteinput.results", var6));
   }

   static RemoteInputCompatBase.RemoteInput fromBundle(Bundle var0, RemoteInputCompatBase.Factory var1) {
      return var1.build(var0.getString("resultKey"), var0.getCharSequence("label"), var0.getCharSequenceArray("choices"), var0.getBoolean("allowFreeFormInput"), var0.getBundle("extras"));
   }

   static RemoteInputCompatBase.RemoteInput[] fromBundleArray(Bundle[] var0, RemoteInputCompatBase.Factory var1) {
      RemoteInputCompatBase.RemoteInput[] var2;
      if(var0 == null) {
         var2 = null;
      } else {
         var2 = var1.newArray(var0.length);

         for(int var3 = 0; var3 < var0.length; ++var3) {
            var2[var3] = fromBundle(var0[var3], var1);
         }
      }

      return var2;
   }

   static Bundle getResultsFromIntent(Intent var0) {
      ClipData var1 = var0.getClipData();
      if(var1 != null) {
         ClipDescription var2 = var1.getDescription();
         if(var2.hasMimeType("text/vnd.android.intent") && var2.getLabel().equals("android.remoteinput.results")) {
            return (Bundle)var1.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
         }
      }

      return null;
   }

   static Bundle toBundle(RemoteInputCompatBase.RemoteInput var0) {
      Bundle var1 = new Bundle();
      var1.putString("resultKey", var0.getResultKey());
      var1.putCharSequence("label", var0.getLabel());
      var1.putCharSequenceArray("choices", var0.getChoices());
      var1.putBoolean("allowFreeFormInput", var0.getAllowFreeFormInput());
      var1.putBundle("extras", var0.getExtras());
      return var1;
   }

   static Bundle[] toBundleArray(RemoteInputCompatBase.RemoteInput[] var0) {
      Bundle[] var1;
      if(var0 == null) {
         var1 = null;
      } else {
         var1 = new Bundle[var0.length];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            var1[var2] = toBundle(var0[var2]);
         }
      }

      return var1;
   }
}
