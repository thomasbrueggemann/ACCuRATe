package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.Transition.EpicenterCallback;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class FragmentTransitionCompat21 {
   public static void addTargets(Object var0, ArrayList<View> var1) {
      Transition var2 = (Transition)var0;
      if(var2 instanceof TransitionSet) {
         TransitionSet var6 = (TransitionSet)var2;
         int var7 = var6.getTransitionCount();

         for(int var8 = 0; var8 < var7; ++var8) {
            addTargets(var6.getTransitionAt(var8), var1);
         }
      } else if(!hasSimpleTarget(var2) && isNullOrEmpty(var2.getTargets())) {
         int var3 = var1.size();

         for(int var4 = 0; var4 < var3; ++var4) {
            var2.addTarget((View)var1.get(var4));
         }
      }

   }

   public static void addTransitionTargets(Object var0, Object var1, final View var2, final FragmentTransitionCompat21.ViewRetriever var3, final View var4, FragmentTransitionCompat21.EpicenterView var5, final Map<String, String> var6, final ArrayList<View> var7, Map<String, View> var8, final Map<String, View> var9, ArrayList<View> var10) {
      if(var0 != null || var1 != null) {
         final Transition var11 = (Transition)var0;
         if(var11 != null) {
            var11.addTarget(var4);
         }

         if(var1 != null) {
            setSharedElementTargets(var1, var4, var8, var10);
         }

         if(var3 != null) {
            var2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
               public boolean onPreDraw() {
                  var2.getViewTreeObserver().removeOnPreDrawListener(this);
                  if(var11 != null) {
                     var11.removeTarget(var4);
                  }

                  View var1 = var3.getView();
                  if(var1 != null) {
                     if(!var6.isEmpty()) {
                        FragmentTransitionCompat21.findNamedViews(var9, var1);
                        var9.keySet().retainAll(var6.values());
                        Iterator var5 = var6.entrySet().iterator();

                        while(var5.hasNext()) {
                           Entry var6x = (Entry)var5.next();
                           String var7x = (String)var6x.getValue();
                           View var8 = (View)var9.get(var7x);
                           if(var8 != null) {
                              var8.setTransitionName((String)var6x.getKey());
                           }
                        }
                     }

                     if(var11 != null) {
                        FragmentTransitionCompat21.captureTransitioningViews(var7, var1);
                        var7.removeAll(var9.values());
                        var7.add(var4);
                        FragmentTransitionCompat21.addTargets(var11, var7);
                     }
                  }

                  return true;
               }
            });
         }

         setSharedElementEpicenter(var11, var5);
      }

   }

   public static void beginDelayedTransition(ViewGroup var0, Object var1) {
      TransitionManager.beginDelayedTransition(var0, (Transition)var1);
   }

   private static void bfsAddViewChildren(List<View> var0, View var1) {
      int var2 = var0.size();
      if(!containedBeforeIndex(var0, var1, var2)) {
         var0.add(var1);

         for(int var4 = var2; var4 < var0.size(); ++var4) {
            View var5 = (View)var0.get(var4);
            if(var5 instanceof ViewGroup) {
               ViewGroup var6 = (ViewGroup)var5;
               int var7 = var6.getChildCount();

               for(int var8 = 0; var8 < var7; ++var8) {
                  View var9 = var6.getChildAt(var8);
                  if(!containedBeforeIndex(var0, var9, var2)) {
                     var0.add(var9);
                  }
               }
            }
         }
      }

   }

   public static Object captureExitingViews(Object var0, View var1, ArrayList<View> var2, Map<String, View> var3, View var4) {
      if(var0 != null) {
         captureTransitioningViews(var2, var1);
         if(var3 != null) {
            var2.removeAll(var3.values());
         }

         if(!var2.isEmpty()) {
            var2.add(var4);
            addTargets((Transition)var0, var2);
            return var0;
         }

         var0 = null;
      }

      return var0;
   }

   private static void captureTransitioningViews(ArrayList<View> var0, View var1) {
      if(var1.getVisibility() == 0) {
         if(!(var1 instanceof ViewGroup)) {
            var0.add(var1);
            return;
         }

         ViewGroup var3 = (ViewGroup)var1;
         if(var3.isTransitionGroup()) {
            var0.add(var3);
         } else {
            int var4 = var3.getChildCount();

            for(int var5 = 0; var5 < var4; ++var5) {
               captureTransitioningViews(var0, var3.getChildAt(var5));
            }
         }
      }

   }

   public static void cleanupTransitions(final View var0, final View var1, Object var2, final ArrayList<View> var3, Object var4, final ArrayList<View> var5, Object var6, final ArrayList<View> var7, Object var8, final ArrayList<View> var9, final Map<String, View> var10) {
      final Transition var11 = (Transition)var2;
      final Transition var12 = (Transition)var4;
      final Transition var13 = (Transition)var6;
      final Transition var14 = (Transition)var8;
      if(var14 != null) {
         var0.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
               var0.getViewTreeObserver().removeOnPreDrawListener(this);
               if(var11 != null) {
                  FragmentTransitionCompat21.removeTargets(var11, var3);
               }

               if(var12 != null) {
                  FragmentTransitionCompat21.removeTargets(var12, var5);
               }

               if(var13 != null) {
                  FragmentTransitionCompat21.removeTargets(var13, var7);
               }

               Iterator var1x = var10.entrySet().iterator();

               while(var1x.hasNext()) {
                  Entry var6 = (Entry)var1x.next();
                  ((View)var6.getValue()).setTransitionName((String)var6.getKey());
               }

               int var2 = var9.size();

               for(int var3x = 0; var3x < var2; ++var3x) {
                  var14.excludeTarget((View)var9.get(var3x), false);
               }

               var14.excludeTarget(var1, false);
               return true;
            }
         });
      }

   }

   public static Object cloneTransition(Object var0) {
      if(var0 != null) {
         var0 = ((Transition)var0).clone();
      }

      return var0;
   }

   private static boolean containedBeforeIndex(List<View> var0, View var1, int var2) {
      for(int var3 = 0; var3 < var2; ++var3) {
         if(var0.get(var3) == var1) {
            return true;
         }
      }

      return false;
   }

   public static void excludeTarget(Object var0, View var1, boolean var2) {
      ((Transition)var0).excludeTarget(var1, var2);
   }

   public static void findNamedViews(Map<String, View> var0, View var1) {
      if(var1.getVisibility() == 0) {
         String var2 = var1.getTransitionName();
         if(var2 != null) {
            var0.put(var2, var1);
         }

         if(var1 instanceof ViewGroup) {
            ViewGroup var3 = (ViewGroup)var1;
            int var4 = var3.getChildCount();

            for(int var5 = 0; var5 < var4; ++var5) {
               findNamedViews(var0, var3.getChildAt(var5));
            }
         }
      }

   }

   private static Rect getBoundsOnScreen(View var0) {
      Rect var1 = new Rect();
      int[] var2 = new int[2];
      var0.getLocationOnScreen(var2);
      var1.set(var2[0], var2[1], var2[0] + var0.getWidth(), var2[1] + var0.getHeight());
      return var1;
   }

   public static String getTransitionName(View var0) {
      return var0.getTransitionName();
   }

   private static boolean hasSimpleTarget(Transition var0) {
      return !isNullOrEmpty(var0.getTargetIds()) || !isNullOrEmpty(var0.getTargetNames()) || !isNullOrEmpty(var0.getTargetTypes());
   }

   private static boolean isNullOrEmpty(List var0) {
      return var0 == null || var0.isEmpty();
   }

   public static Object mergeTransitions(Object var0, Object var1, Object var2, boolean var3) {
      boolean var4 = true;
      Transition var5 = (Transition)var0;
      Transition var6 = (Transition)var1;
      Transition var7 = (Transition)var2;
      if(var5 != null && var6 != null) {
         var4 = var3;
      }

      if(var4) {
         TransitionSet var8 = new TransitionSet();
         if(var5 != null) {
            var8.addTransition(var5);
         }

         if(var6 != null) {
            var8.addTransition(var6);
         }

         if(var7 != null) {
            var8.addTransition(var7);
         }

         return var8;
      } else {
         Object var12;
         if(var6 != null && var5 != null) {
            var12 = (new TransitionSet()).addTransition(var6).addTransition(var5).setOrdering(1);
         } else if(var6 != null) {
            var12 = var6;
         } else {
            var12 = null;
            if(var5 != null) {
               var12 = var5;
            }
         }

         if(var7 != null) {
            TransitionSet var13 = new TransitionSet();
            if(var12 != null) {
               var13.addTransition((Transition)var12);
            }

            var13.addTransition(var7);
            return var13;
         } else {
            return var12;
         }
      }
   }

   public static void removeTargets(Object var0, ArrayList<View> var1) {
      Transition var2 = (Transition)var0;
      if(var2 instanceof TransitionSet) {
         TransitionSet var6 = (TransitionSet)var2;
         int var7 = var6.getTransitionCount();

         for(int var8 = 0; var8 < var7; ++var8) {
            removeTargets(var6.getTransitionAt(var8), var1);
         }
      } else if(!hasSimpleTarget(var2)) {
         List var3 = var2.getTargets();
         if(var3 != null && var3.size() == var1.size() && var3.containsAll(var1)) {
            for(int var4 = -1 + var1.size(); var4 >= 0; --var4) {
               var2.removeTarget((View)var1.get(var4));
            }
         }
      }

   }

   public static void setEpicenter(Object var0, View var1) {
      ((Transition)var0).setEpicenterCallback(new EpicenterCallback() {
         // $FF: synthetic field
         final Rect val$epicenter;

         {
            this.val$epicenter = var1;
         }

         public Rect onGetEpicenter(Transition var1) {
            return this.val$epicenter;
         }
      });
   }

   private static void setSharedElementEpicenter(Transition var0, final FragmentTransitionCompat21.EpicenterView var1) {
      if(var0 != null) {
         var0.setEpicenterCallback(new EpicenterCallback() {
            private Rect mEpicenter;

            public Rect onGetEpicenter(Transition var1x) {
               if(this.mEpicenter == null && var1.epicenter != null) {
                  this.mEpicenter = FragmentTransitionCompat21.getBoundsOnScreen(var1.epicenter);
               }

               return this.mEpicenter;
            }
         });
      }

   }

   public static void setSharedElementTargets(Object var0, View var1, Map<String, View> var2, ArrayList<View> var3) {
      TransitionSet var4 = (TransitionSet)var0;
      var3.clear();
      var3.addAll(var2.values());
      List var6 = var4.getTargets();
      var6.clear();
      int var7 = var3.size();

      for(int var8 = 0; var8 < var7; ++var8) {
         bfsAddViewChildren(var6, (View)var3.get(var8));
      }

      var3.add(var1);
      addTargets(var4, var3);
   }

   public static Object wrapSharedElementTransition(Object var0) {
      if(var0 != null) {
         Transition var1 = (Transition)var0;
         if(var1 != null) {
            TransitionSet var2 = new TransitionSet();
            var2.addTransition(var1);
            return var2;
         }
      }

      return null;
   }

   public static class EpicenterView {
      public View epicenter;
   }

   public interface ViewRetriever {
      View getView();
   }
}
