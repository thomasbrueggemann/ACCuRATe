package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

class AppCompatViewInflater {
   private static final String LOG_TAG = "AppCompatViewInflater";
   private static final String[] sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
   private static final Map<String, Constructor<? extends View>> sConstructorMap = new ArrayMap();
   private static final Class<?>[] sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
   private static final int[] sOnClickAttrs = new int[]{16843375};
   private final Object[] mConstructorArgs = new Object[2];

   private void checkOnClickListener(View var1, AttributeSet var2) {
      Context var3 = var1.getContext();
      if(var3 instanceof ContextWrapper && (VERSION.SDK_INT < 15 || ViewCompat.hasOnClickListeners(var1))) {
         TypedArray var4 = var3.obtainStyledAttributes(var2, sOnClickAttrs);
         String var5 = var4.getString(0);
         if(var5 != null) {
            var1.setOnClickListener(new AppCompatViewInflater.DeclaredOnClickListener(var1, var5));
         }

         var4.recycle();
      }
   }

   private View createView(Context param1, String param2, String param3) throws ClassNotFoundException, InflateException {
      // $FF: Couldn't be decompiled
   }

   private View createViewFromTag(Context param1, String param2, AttributeSet param3) {
      // $FF: Couldn't be decompiled
   }

   private static Context themifyContext(Context var0, AttributeSet var1, boolean var2, boolean var3) {
      TypedArray var4 = ((Context)var0).obtainStyledAttributes(var1, class_22.styleable.View, 0, 0);
      int var5 = 0;
      if(var2) {
         var5 = var4.getResourceId(class_22.styleable.View_android_theme, 0);
      }

      if(var3 && var5 == 0) {
         var5 = var4.getResourceId(class_22.styleable.View_theme, 0);
         if(var5 != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
         }
      }

      var4.recycle();
      if(var5 != 0 && (!(var0 instanceof ContextThemeWrapper) || ((ContextThemeWrapper)var0).getThemeResId() != var5)) {
         var0 = new ContextThemeWrapper((Context)var0, var5);
      }

      return (Context)var0;
   }

   public final View createView(View var1, String var2, @NonNull Context var3, @NonNull AttributeSet var4, boolean var5, boolean var6, boolean var7, boolean var8) {
      if(var5 && var1 != null) {
         var3 = var1.getContext();
      }

      if(var6 || var7) {
         var3 = themifyContext(var3, var4, var6, var7);
      }

      if(var8) {
         var3 = TintContextWrapper.wrap(var3);
      }

      byte var10 = -1;
      switch(var2.hashCode()) {
      case -1946472170:
         if(var2.equals("RatingBar")) {
            var10 = 11;
         }
         break;
      case -1455429095:
         if(var2.equals("CheckedTextView")) {
            var10 = 8;
         }
         break;
      case -1346021293:
         if(var2.equals("MultiAutoCompleteTextView")) {
            var10 = 10;
         }
         break;
      case -938935918:
         if(var2.equals("TextView")) {
            var10 = 0;
         }
         break;
      case -937446323:
         if(var2.equals("ImageButton")) {
            var10 = 5;
         }
         break;
      case -658531749:
         if(var2.equals("SeekBar")) {
            var10 = 12;
         }
         break;
      case -339785223:
         if(var2.equals("Spinner")) {
            var10 = 4;
         }
         break;
      case 776382189:
         if(var2.equals("RadioButton")) {
            var10 = 7;
         }
         break;
      case 1125864064:
         if(var2.equals("ImageView")) {
            var10 = 1;
         }
         break;
      case 1413872058:
         if(var2.equals("AutoCompleteTextView")) {
            var10 = 9;
         }
         break;
      case 1601505219:
         if(var2.equals("CheckBox")) {
            var10 = 6;
         }
         break;
      case 1666676343:
         if(var2.equals("EditText")) {
            var10 = 3;
         }
         break;
      case 2001146706:
         if(var2.equals("Button")) {
            var10 = 2;
         }
      }

      Object var11 = null;
      switch(var10) {
      case 0:
         var11 = new AppCompatTextView(var3, var4);
         break;
      case 1:
         var11 = new AppCompatImageView(var3, var4);
         break;
      case 2:
         var11 = new AppCompatButton(var3, var4);
         break;
      case 3:
         var11 = new AppCompatEditText(var3, var4);
         break;
      case 4:
         var11 = new AppCompatSpinner(var3, var4);
         break;
      case 5:
         var11 = new AppCompatImageButton(var3, var4);
         break;
      case 6:
         var11 = new AppCompatCheckBox(var3, var4);
         break;
      case 7:
         var11 = new AppCompatRadioButton(var3, var4);
         break;
      case 8:
         var11 = new AppCompatCheckedTextView(var3, var4);
         break;
      case 9:
         var11 = new AppCompatAutoCompleteTextView(var3, var4);
         break;
      case 10:
         var11 = new AppCompatMultiAutoCompleteTextView(var3, var4);
         break;
      case 11:
         var11 = new AppCompatRatingBar(var3, var4);
         break;
      case 12:
         var11 = new AppCompatSeekBar(var3, var4);
      }

      if(var11 == null && var3 != var3) {
         var11 = this.createViewFromTag(var3, var2, var4);
      }

      if(var11 != null) {
         this.checkOnClickListener((View)var11, var4);
      }

      return (View)var11;
   }

   private static class DeclaredOnClickListener implements OnClickListener {
      private final View mHostView;
      private final String mMethodName;
      private Context mResolvedContext;
      private Method mResolvedMethod;

      public DeclaredOnClickListener(@NonNull View var1, @NonNull String var2) {
         this.mHostView = var1;
         this.mMethodName = var2;
      }

      @NonNull
      private void resolveMethod(@Nullable Context param1, @NonNull String param2) {
         // $FF: Couldn't be decompiled
      }

      public void onClick(@NonNull View var1) {
         if(this.mResolvedMethod == null) {
            this.resolveMethod(this.mHostView.getContext(), this.mMethodName);
         }

         try {
            this.mResolvedMethod.invoke(this.mResolvedContext, new Object[]{var1});
         } catch (IllegalAccessException var4) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", var4);
         } catch (InvocationTargetException var5) {
            throw new IllegalStateException("Could not execute method for android:onClick", var5);
         }
      }
   }
}
