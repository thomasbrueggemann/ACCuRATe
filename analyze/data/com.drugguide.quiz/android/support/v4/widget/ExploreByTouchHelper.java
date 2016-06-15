package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
   private static final String DEFAULT_CLASS_NAME = View.class.getName();
   public static final int INVALID_ID = Integer.MIN_VALUE;
   private int mFocusedVirtualViewId = Integer.MIN_VALUE;
   private int mHoveredVirtualViewId = Integer.MIN_VALUE;
   private final AccessibilityManager mManager;
   private ExploreByTouchHelper.ExploreByTouchNodeProvider mNodeProvider;
   private final int[] mTempGlobalRect = new int[2];
   private final Rect mTempParentRect = new Rect();
   private final Rect mTempScreenRect = new Rect();
   private final Rect mTempVisibleRect = new Rect();
   private final View mView;

   public ExploreByTouchHelper(View var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("View may not be null");
      } else {
         this.mView = var1;
         this.mManager = (AccessibilityManager)var1.getContext().getSystemService("accessibility");
      }
   }

   private boolean clearAccessibilityFocus(int var1) {
      if(this.isAccessibilityFocused(var1)) {
         this.mFocusedVirtualViewId = Integer.MIN_VALUE;
         this.mView.invalidate();
         this.sendEventForVirtualView(var1, 65536);
         return true;
      } else {
         return false;
      }
   }

   private AccessibilityEvent createEvent(int var1, int var2) {
      switch(var1) {
      case -1:
         return this.createEventForHost(var2);
      default:
         return this.createEventForChild(var1, var2);
      }
   }

   private AccessibilityEvent createEventForChild(int var1, int var2) {
      AccessibilityEvent var3 = AccessibilityEvent.obtain(var2);
      var3.setEnabled(true);
      var3.setClassName(DEFAULT_CLASS_NAME);
      this.onPopulateEventForVirtualView(var1, var3);
      if(var3.getText().isEmpty() && var3.getContentDescription() == null) {
         throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
      } else {
         var3.setPackageName(this.mView.getContext().getPackageName());
         AccessibilityEventCompat.asRecord(var3).setSource(this.mView, var1);
         return var3;
      }
   }

   private AccessibilityEvent createEventForHost(int var1) {
      AccessibilityEvent var2 = AccessibilityEvent.obtain(var1);
      ViewCompat.onInitializeAccessibilityEvent(this.mView, var2);
      return var2;
   }

   private AccessibilityNodeInfoCompat createNode(int var1) {
      switch(var1) {
      case -1:
         return this.createNodeForHost();
      default:
         return this.createNodeForChild(var1);
      }
   }

   private AccessibilityNodeInfoCompat createNodeForChild(int var1) {
      AccessibilityNodeInfoCompat var2 = AccessibilityNodeInfoCompat.obtain();
      var2.setEnabled(true);
      var2.setClassName(DEFAULT_CLASS_NAME);
      this.onPopulateNodeForVirtualView(var1, var2);
      if(var2.getText() == null && var2.getContentDescription() == null) {
         throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
      } else {
         var2.getBoundsInParent(this.mTempParentRect);
         if(this.mTempParentRect.isEmpty()) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
         } else {
            int var3 = var2.getActions();
            if((var3 & 64) != 0) {
               throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if((var3 & 128) != 0) {
               throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else {
               var2.setPackageName(this.mView.getContext().getPackageName());
               var2.setSource(this.mView, var1);
               var2.setParent(this.mView);
               if(this.mFocusedVirtualViewId == var1) {
                  var2.setAccessibilityFocused(true);
                  var2.addAction(128);
               } else {
                  var2.setAccessibilityFocused(false);
                  var2.addAction(64);
               }

               if(this.intersectVisibleToUser(this.mTempParentRect)) {
                  var2.setVisibleToUser(true);
                  var2.setBoundsInParent(this.mTempParentRect);
               }

               this.mView.getLocationOnScreen(this.mTempGlobalRect);
               int var4 = this.mTempGlobalRect[0];
               int var5 = this.mTempGlobalRect[1];
               this.mTempScreenRect.set(this.mTempParentRect);
               this.mTempScreenRect.offset(var4, var5);
               var2.setBoundsInScreen(this.mTempScreenRect);
               return var2;
            }
         }
      }
   }

   private AccessibilityNodeInfoCompat createNodeForHost() {
      AccessibilityNodeInfoCompat var1 = AccessibilityNodeInfoCompat.obtain(this.mView);
      ViewCompat.onInitializeAccessibilityNodeInfo(this.mView, var1);
      LinkedList var2 = new LinkedList();
      this.getVisibleVirtualViews(var2);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Integer var4 = (Integer)var3.next();
         var1.addChild(this.mView, var4.intValue());
      }

      return var1;
   }

   private boolean intersectVisibleToUser(Rect var1) {
      if(var1 != null && !var1.isEmpty() && this.mView.getWindowVisibility() == 0) {
         ViewParent var2 = this.mView.getParent();

         while(true) {
            if(!(var2 instanceof View)) {
               if(var2 != null && this.mView.getLocalVisibleRect(this.mTempVisibleRect)) {
                  return var1.intersect(this.mTempVisibleRect);
               }
               break;
            }

            View var3 = (View)var2;
            if(ViewCompat.getAlpha(var3) <= 0.0F || var3.getVisibility() != 0) {
               break;
            }

            var2 = var3.getParent();
         }
      }

      return false;
   }

   private boolean isAccessibilityFocused(int var1) {
      return this.mFocusedVirtualViewId == var1;
   }

   private boolean manageFocusForChild(int var1, int var2, Bundle var3) {
      switch(var2) {
      case 64:
         return this.requestAccessibilityFocus(var1);
      case 128:
         return this.clearAccessibilityFocus(var1);
      default:
         return false;
      }
   }

   private boolean performAction(int var1, int var2, Bundle var3) {
      switch(var1) {
      case -1:
         return this.performActionForHost(var2, var3);
      default:
         return this.performActionForChild(var1, var2, var3);
      }
   }

   private boolean performActionForChild(int var1, int var2, Bundle var3) {
      switch(var2) {
      case 64:
      case 128:
         return this.manageFocusForChild(var1, var2, var3);
      default:
         return this.onPerformActionForVirtualView(var1, var2, var3);
      }
   }

   private boolean performActionForHost(int var1, Bundle var2) {
      return ViewCompat.performAccessibilityAction(this.mView, var1, var2);
   }

   private boolean requestAccessibilityFocus(int var1) {
      if(this.mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager) && !this.isAccessibilityFocused(var1)) {
         this.mFocusedVirtualViewId = var1;
         this.mView.invalidate();
         this.sendEventForVirtualView(var1, '耀');
         return true;
      } else {
         return false;
      }
   }

   private void updateHoveredVirtualView(int var1) {
      if(this.mHoveredVirtualViewId != var1) {
         int var2 = this.mHoveredVirtualViewId;
         this.mHoveredVirtualViewId = var1;
         this.sendEventForVirtualView(var1, 128);
         this.sendEventForVirtualView(var2, 256);
      }
   }

   public boolean dispatchHoverEvent(MotionEvent var1) {
      boolean var2 = true;
      if(this.mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
         switch(var1.getAction()) {
         case 7:
         case 9:
            int var3 = this.getVirtualViewAt(var1.getX(), var1.getY());
            this.updateHoveredVirtualView(var3);
            if(var3 == Integer.MIN_VALUE) {
               var2 = false;
            }

            return var2;
         case 8:
         default:
            return false;
         case 10:
            if(this.mFocusedVirtualViewId != Integer.MIN_VALUE) {
               this.updateHoveredVirtualView(Integer.MIN_VALUE);
               return var2;
            }
         }
      }

      return false;
   }

   public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1) {
      if(this.mNodeProvider == null) {
         this.mNodeProvider = new ExploreByTouchHelper.ExploreByTouchNodeProvider();
      }

      return this.mNodeProvider;
   }

   public int getFocusedVirtualView() {
      return this.mFocusedVirtualViewId;
   }

   protected abstract int getVirtualViewAt(float var1, float var2);

   protected abstract void getVisibleVirtualViews(List<Integer> var1);

   public void invalidateRoot() {
      this.invalidateVirtualView(-1);
   }

   public void invalidateVirtualView(int var1) {
      this.sendEventForVirtualView(var1, 2048);
   }

   protected abstract boolean onPerformActionForVirtualView(int var1, int var2, Bundle var3);

   protected abstract void onPopulateEventForVirtualView(int var1, AccessibilityEvent var2);

   protected abstract void onPopulateNodeForVirtualView(int var1, AccessibilityNodeInfoCompat var2);

   public boolean sendEventForVirtualView(int var1, int var2) {
      if(var1 != Integer.MIN_VALUE && this.mManager.isEnabled()) {
         ViewParent var3 = this.mView.getParent();
         if(var3 != null) {
            AccessibilityEvent var4 = this.createEvent(var1, var2);
            return ViewParentCompat.requestSendAccessibilityEvent(var3, this.mView, var4);
         }
      }

      return false;
   }

   private class ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat {
      private ExploreByTouchNodeProvider() {
      }

      // $FF: synthetic method
      ExploreByTouchNodeProvider(Object var2) {
         this();
      }

      public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int var1) {
         return ExploreByTouchHelper.this.createNode(var1);
      }

      public boolean performAction(int var1, int var2, Bundle var3) {
         return ExploreByTouchHelper.this.performAction(var1, var2, var3);
      }
   }
}
