package android.support.v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

class TextViewCompatDonut {
   private static final int LINES = 1;
   private static final String LOG_TAG = "TextViewCompatDonut";
   private static Field sMaxModeField;
   private static boolean sMaxModeFieldFetched;
   private static Field sMaximumField;
   private static boolean sMaximumFieldFetched;
   private static Field sMinModeField;
   private static boolean sMinModeFieldFetched;
   private static Field sMinimumField;
   private static boolean sMinimumFieldFetched;

   static int getMaxLines(TextView var0) {
      if(!sMaxModeFieldFetched) {
         sMaxModeField = retrieveField("mMaxMode");
         sMaxModeFieldFetched = true;
      }

      if(sMaxModeField != null && retrieveIntFromField(sMaxModeField, var0) == 1) {
         if(!sMaximumFieldFetched) {
            sMaximumField = retrieveField("mMaximum");
            sMaximumFieldFetched = true;
         }

         if(sMaximumField != null) {
            return retrieveIntFromField(sMaximumField, var0);
         }
      }

      return -1;
   }

   static int getMinLines(TextView var0) {
      if(!sMinModeFieldFetched) {
         sMinModeField = retrieveField("mMinMode");
         sMinModeFieldFetched = true;
      }

      if(sMinModeField != null && retrieveIntFromField(sMinModeField, var0) == 1) {
         if(!sMinimumFieldFetched) {
            sMinimumField = retrieveField("mMinimum");
            sMinimumFieldFetched = true;
         }

         if(sMinimumField != null) {
            return retrieveIntFromField(sMinimumField, var0);
         }
      }

      return -1;
   }

   private static Field retrieveField(String var0) {
      Field var1 = null;

      try {
         var1 = TextView.class.getDeclaredField(var0);
         var1.setAccessible(true);
         return var1;
      } catch (NoSuchFieldException var3) {
         Log.e("TextViewCompatDonut", "Could not retrieve " + var0 + " field.");
         return var1;
      }
   }

   private static int retrieveIntFromField(Field var0, TextView var1) {
      try {
         int var4 = var0.getInt(var1);
         return var4;
      } catch (IllegalAccessException var5) {
         Log.d("TextViewCompatDonut", "Could not retrieve value of " + var0.getName() + " field.");
         return -1;
      }
   }

   static void setTextAppearance(TextView var0, int var1) {
      var0.setTextAppearance(var0.getContext(), var1);
   }
}
