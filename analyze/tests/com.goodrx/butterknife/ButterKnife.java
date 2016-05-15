package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {
   static final Map<Class<?>, ButterKnife.ViewBinder<Object>> BINDERS = new LinkedHashMap();
   static final ButterKnife.ViewBinder<Object> NOP_VIEW_BINDER = new ButterKnife.ViewBinder() {
      public void bind(ButterKnife.Finder var1, Object var2, Object var3) {
      }

      public void unbind(Object var1) {
      }
   };
   private static boolean debug = false;

   public static void bind(Activity var0) {
      bind(var0, var0, ButterKnife.Finder.ACTIVITY);
   }

   public static void bind(Object var0, View var1) {
      bind(var0, var1, ButterKnife.Finder.VIEW);
   }

   static void bind(Object param0, Object param1, ButterKnife.Finder param2) {
      // $FF: Couldn't be decompiled
   }

   private static ButterKnife.ViewBinder<Object> findViewBinderForClass(Class<?> var0) throws IllegalAccessException, InstantiationException {
      ButterKnife.ViewBinder var1 = (ButterKnife.ViewBinder)BINDERS.get(var0);
      if(var1 != null) {
         if(debug) {
            Log.d("ButterKnife", "HIT: Cached in view binder map.");
         }

         return var1;
      } else {
         String var2 = var0.getName();
         if(!var2.startsWith("android.") && !var2.startsWith("java.")) {
            ButterKnife.ViewBinder var5;
            try {
               var5 = (ButterKnife.ViewBinder)Class.forName(var2 + "$$ViewBinder").newInstance();
               if(debug) {
                  Log.d("ButterKnife", "HIT: Loaded view binder class.");
               }
            } catch (ClassNotFoundException var6) {
               if(debug) {
                  Log.d("ButterKnife", "Not found. Trying superclass " + var0.getSuperclass().getName());
               }

               var5 = findViewBinderForClass(var0.getSuperclass());
            }

            BINDERS.put(var0, var5);
            return var5;
         } else {
            if(debug) {
               Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
            }

            return NOP_VIEW_BINDER;
         }
      }
   }

   public static void unbind(Object param0) {
      // $FF: Couldn't be decompiled
   }

   public static enum Finder {
      ACTIVITY {
         protected View findView(Object var1, int var2) {
            return ((Activity)var1).findViewById(var2);
         }

         public Context getContext(Object var1) {
            return (Activity)var1;
         }
      },
      DIALOG {
         protected View findView(Object var1, int var2) {
            return ((Dialog)var1).findViewById(var2);
         }

         public Context getContext(Object var1) {
            return ((Dialog)var1).getContext();
         }
      },
      VIEW {
         protected View findView(Object var1, int var2) {
            return ((View)var1).findViewById(var2);
         }

         public Context getContext(Object var1) {
            return ((View)var1).getContext();
         }
      };

      static {
         ButterKnife.Finder[] var0 = new ButterKnife.Finder[]{VIEW, ACTIVITY, DIALOG};
      }

      private Finder() {
      }

      // $FF: synthetic method
      Finder(Object var3) {
         this();
      }

      public <T> T castView(View var1, int var2, String var3) {
         return var1;
      }

      public <T> T findOptionalView(Object var1, int var2, String var3) {
         return this.castView(this.findView(var1, var2), var2, var3);
      }

      public <T> T findRequiredView(Object var1, int var2, String var3) {
         Object var4 = this.findOptionalView(var1, var2, var3);
         if(var4 == null) {
            String var5 = this.getContext(var1).getResources().getResourceEntryName(var2);
            throw new IllegalStateException("Required view \'" + var5 + "\' with ID " + var2 + " for " + var3 + " was not found. If this view is optional add \'@Nullable\' annotation.");
         } else {
            return var4;
         }
      }

      protected abstract View findView(Object var1, int var2);

      public abstract Context getContext(Object var1);
   }

   public interface ViewBinder<T> {
      void bind(ButterKnife.Finder var1, T var2, Object var3);

      void unbind(T var1);
   }
}
