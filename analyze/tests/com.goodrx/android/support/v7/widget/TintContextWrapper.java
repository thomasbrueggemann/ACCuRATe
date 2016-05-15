package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.annotation.NonNull;
import android.support.v7.widget.TintResources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper {
   private static final ArrayList<WeakReference<TintContextWrapper>> sCache = new ArrayList();
   private Resources mResources;
   private final Theme mTheme = this.getResources().newTheme();

   private TintContextWrapper(@NonNull Context var1) {
      super(var1);
      this.mTheme.setTo(var1.getTheme());
   }

   private static boolean shouldWrap(@NonNull Context var0) {
      return !(var0 instanceof TintContextWrapper) && !(var0.getResources() instanceof TintResources);
   }

   public static Context wrap(@NonNull Context var0) {
      if(shouldWrap(var0)) {
         int var1 = 0;

         for(int var2 = sCache.size(); var1 < var2; ++var1) {
            WeakReference var5 = (WeakReference)sCache.get(var1);
            TintContextWrapper var6;
            if(var5 != null) {
               var6 = (TintContextWrapper)var5.get();
            } else {
               var6 = null;
            }

            if(var6 != null && var6.getBaseContext() == var0) {
               return var6;
            }
         }

         TintContextWrapper var3 = new TintContextWrapper(var0);
         sCache.add(new WeakReference(var3));
         return var3;
      } else {
         return var0;
      }
   }

   public Resources getResources() {
      if(this.mResources == null) {
         this.mResources = new TintResources(this, super.getResources());
      }

      return this.mResources;
   }

   public Theme getTheme() {
      return this.mTheme;
   }

   public void setTheme(int var1) {
      this.mTheme.applyStyle(var1, true);
   }
}
