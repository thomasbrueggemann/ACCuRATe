package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
   final AccessibilityDelegateCompat mItemDelegate = new AccessibilityDelegateCompat() {
      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         super.onInitializeAccessibilityNodeInfo(var1, var2);
         if(!RecyclerViewAccessibilityDelegate.this.shouldIgnore() && RecyclerViewAccessibilityDelegate.this.mRecyclerView.getLayoutManager() != null) {
            RecyclerViewAccessibilityDelegate.this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(var1, var2);
         }

      }

      public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
         return super.performAccessibilityAction(var1, var2, var3)?true:(!RecyclerViewAccessibilityDelegate.this.shouldIgnore() && RecyclerViewAccessibilityDelegate.this.mRecyclerView.getLayoutManager() != null?RecyclerViewAccessibilityDelegate.this.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(var1, var2, var3):false);
      }
   };
   final RecyclerView mRecyclerView;

   public RecyclerViewAccessibilityDelegate(RecyclerView var1) {
      this.mRecyclerView = var1;
   }

   private boolean shouldIgnore() {
      return this.mRecyclerView.hasPendingAdapterUpdates();
   }

   AccessibilityDelegateCompat getItemDelegate() {
      return this.mItemDelegate;
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      super.onInitializeAccessibilityEvent(var1, var2);
      var2.setClassName(RecyclerView.class.getName());
      if(var1 instanceof RecyclerView && !this.shouldIgnore()) {
         RecyclerView var3 = (RecyclerView)var1;
         if(var3.getLayoutManager() != null) {
            var3.getLayoutManager().onInitializeAccessibilityEvent(var2);
         }
      }

   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      super.onInitializeAccessibilityNodeInfo(var1, var2);
      var2.setClassName(RecyclerView.class.getName());
      if(!this.shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
         this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(var2);
      }

   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      return super.performAccessibilityAction(var1, var2, var3)?true:(!this.shouldIgnore() && this.mRecyclerView.getLayoutManager() != null?this.mRecyclerView.getLayoutManager().performAccessibilityAction(var2, var3):false);
   }
}
