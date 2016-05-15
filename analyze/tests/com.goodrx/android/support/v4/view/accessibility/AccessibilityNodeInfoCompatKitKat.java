package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatKitKat {
   public static boolean canOpenPopup(Object var0) {
      return ((AccessibilityNodeInfo)var0).canOpenPopup();
   }

   static Object getCollectionInfo(Object var0) {
      return ((AccessibilityNodeInfo)var0).getCollectionInfo();
   }

   static Object getCollectionItemInfo(Object var0) {
      return ((AccessibilityNodeInfo)var0).getCollectionItemInfo();
   }

   public static Bundle getExtras(Object var0) {
      return ((AccessibilityNodeInfo)var0).getExtras();
   }

   public static int getInputType(Object var0) {
      return ((AccessibilityNodeInfo)var0).getInputType();
   }

   static int getLiveRegion(Object var0) {
      return ((AccessibilityNodeInfo)var0).getLiveRegion();
   }

   static Object getRangeInfo(Object var0) {
      return ((AccessibilityNodeInfo)var0).getRangeInfo();
   }

   public static boolean isContentInvalid(Object var0) {
      return ((AccessibilityNodeInfo)var0).isContentInvalid();
   }

   public static boolean isDismissable(Object var0) {
      return ((AccessibilityNodeInfo)var0).isDismissable();
   }

   public static boolean isMultiLine(Object var0) {
      return ((AccessibilityNodeInfo)var0).isMultiLine();
   }

   public static Object obtainCollectionInfo(int var0, int var1, boolean var2, int var3) {
      return android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(var0, var1, var2);
   }

   public static Object obtainCollectionItemInfo(int var0, int var1, int var2, int var3, boolean var4) {
      return android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(var0, var1, var2, var3, var4);
   }

   public static void setCanOpenPopup(Object var0, boolean var1) {
      ((AccessibilityNodeInfo)var0).setCanOpenPopup(var1);
   }

   public static void setCollectionInfo(Object var0, Object var1) {
      ((AccessibilityNodeInfo)var0).setCollectionInfo((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo)var1);
   }

   public static void setCollectionItemInfo(Object var0, Object var1) {
      ((AccessibilityNodeInfo)var0).setCollectionItemInfo((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo)var1);
   }

   public static void setContentInvalid(Object var0, boolean var1) {
      ((AccessibilityNodeInfo)var0).setContentInvalid(var1);
   }

   public static void setDismissable(Object var0, boolean var1) {
      ((AccessibilityNodeInfo)var0).setDismissable(var1);
   }

   public static void setInputType(Object var0, int var1) {
      ((AccessibilityNodeInfo)var0).setInputType(var1);
   }

   static void setLiveRegion(Object var0, int var1) {
      ((AccessibilityNodeInfo)var0).setLiveRegion(var1);
   }

   public static void setMultiLine(Object var0, boolean var1) {
      ((AccessibilityNodeInfo)var0).setMultiLine(var1);
   }

   public static void setRangeInfo(Object var0, Object var1) {
      ((AccessibilityNodeInfo)var0).setRangeInfo((android.view.accessibility.AccessibilityNodeInfo.RangeInfo)var1);
   }

   static class CollectionInfo {
      static int getColumnCount(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo)var0).getColumnCount();
      }

      static int getRowCount(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo)var0).getRowCount();
      }

      static boolean isHierarchical(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo)var0).isHierarchical();
      }
   }

   static class CollectionItemInfo {
      static int getColumnIndex(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo)var0).getColumnIndex();
      }

      static int getColumnSpan(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo)var0).getColumnSpan();
      }

      static int getRowIndex(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo)var0).getRowIndex();
      }

      static int getRowSpan(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo)var0).getRowSpan();
      }

      static boolean isHeading(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo)var0).isHeading();
      }
   }

   static class RangeInfo {
      static float getCurrent(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo)var0).getCurrent();
      }

      static float getMax(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo)var0).getMax();
      }

      static float getMin(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo)var0).getMin();
      }

      static int getType(Object var0) {
         return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo)var0).getType();
      }
   }
}
