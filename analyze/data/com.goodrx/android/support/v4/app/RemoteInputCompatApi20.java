package android.support.v4.app;

import android.app.RemoteInput.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInputCompatBase;

class RemoteInputCompatApi20 {
   static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] var0, Intent var1, Bundle var2) {
      android.app.RemoteInput.addResultsToIntent(fromCompat(var0), var1, var2);
   }

   static android.app.RemoteInput[] fromCompat(RemoteInputCompatBase.RemoteInput[] var0) {
      android.app.RemoteInput[] var1;
      if(var0 == null) {
         var1 = null;
      } else {
         var1 = new android.app.RemoteInput[var0.length];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            RemoteInputCompatBase.RemoteInput var3 = var0[var2];
            var1[var2] = (new Builder(var3.getResultKey())).setLabel(var3.getLabel()).setChoices(var3.getChoices()).setAllowFreeFormInput(var3.getAllowFreeFormInput()).addExtras(var3.getExtras()).build();
         }
      }

      return var1;
   }

   static Bundle getResultsFromIntent(Intent var0) {
      return android.app.RemoteInput.getResultsFromIntent(var0);
   }

   static RemoteInputCompatBase.RemoteInput[] toCompat(android.app.RemoteInput[] var0, RemoteInputCompatBase.Factory var1) {
      RemoteInputCompatBase.RemoteInput[] var2;
      if(var0 == null) {
         var2 = null;
      } else {
         var2 = var1.newArray(var0.length);

         for(int var3 = 0; var3 < var0.length; ++var3) {
            android.app.RemoteInput var4 = var0[var3];
            var2[var3] = var1.build(var4.getResultKey(), var4.getLabel(), var4.getChoices(), var4.getAllowFreeFormInput(), var4.getExtras());
         }
      }

      return var2;
   }
}
