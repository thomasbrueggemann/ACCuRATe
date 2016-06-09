package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class PagerTitleStripIcs {
   public static void setSingleLineAllCaps(TextView var0) {
      var0.setTransformationMethod(new PagerTitleStripIcs.SingleLineAllCapsTransform(var0.getContext()));
   }

   private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
      private static final String TAG = "SingleLineAllCapsTransform";
      private Locale mLocale;

      public SingleLineAllCapsTransform(Context var1) {
         this.mLocale = var1.getResources().getConfiguration().locale;
      }

      public CharSequence getTransformation(CharSequence var1, View var2) {
         CharSequence var3 = super.getTransformation(var1, var2);
         return var3 != null?var3.toString().toUpperCase(this.mLocale):null;
      }
   }
}
