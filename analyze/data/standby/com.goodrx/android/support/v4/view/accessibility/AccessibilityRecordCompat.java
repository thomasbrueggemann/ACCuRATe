package android.support.v4.view.accessibility;

import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompatIcs;
import android.support.v4.view.accessibility.AccessibilityRecordCompatIcsMr1;
import android.support.v4.view.accessibility.AccessibilityRecordCompatJellyBean;
import android.view.View;
import java.util.Collections;
import java.util.List;

public class AccessibilityRecordCompat {
   private static final AccessibilityRecordCompat.AccessibilityRecordImpl IMPL;
   private final Object mRecord;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new AccessibilityRecordCompat.AccessibilityRecordJellyBeanImpl();
      } else if(VERSION.SDK_INT >= 15) {
         IMPL = new AccessibilityRecordCompat.AccessibilityRecordIcsMr1Impl();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityRecordCompat.AccessibilityRecordIcsImpl();
      } else {
         IMPL = new AccessibilityRecordCompat.AccessibilityRecordStubImpl();
      }
   }

   public AccessibilityRecordCompat(Object var1) {
      this.mRecord = var1;
   }

   public static AccessibilityRecordCompat obtain() {
      return new AccessibilityRecordCompat(IMPL.obtain());
   }

   public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat var0) {
      return new AccessibilityRecordCompat(IMPL.obtain(var0.mRecord));
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         AccessibilityRecordCompat var2 = (AccessibilityRecordCompat)var1;
         if(this.mRecord == null) {
            if(var2.mRecord != null) {
               return false;
            }
         } else if(!this.mRecord.equals(var2.mRecord)) {
            return false;
         }
      }

      return true;
   }

   public int getAddedCount() {
      return IMPL.getAddedCount(this.mRecord);
   }

   public CharSequence getBeforeText() {
      return IMPL.getBeforeText(this.mRecord);
   }

   public CharSequence getClassName() {
      return IMPL.getClassName(this.mRecord);
   }

   public CharSequence getContentDescription() {
      return IMPL.getContentDescription(this.mRecord);
   }

   public int getCurrentItemIndex() {
      return IMPL.getCurrentItemIndex(this.mRecord);
   }

   public int getFromIndex() {
      return IMPL.getFromIndex(this.mRecord);
   }

   public Object getImpl() {
      return this.mRecord;
   }

   public int getItemCount() {
      return IMPL.getItemCount(this.mRecord);
   }

   public int getMaxScrollX() {
      return IMPL.getMaxScrollX(this.mRecord);
   }

   public int getMaxScrollY() {
      return IMPL.getMaxScrollY(this.mRecord);
   }

   public Parcelable getParcelableData() {
      return IMPL.getParcelableData(this.mRecord);
   }

   public int getRemovedCount() {
      return IMPL.getRemovedCount(this.mRecord);
   }

   public int getScrollX() {
      return IMPL.getScrollX(this.mRecord);
   }

   public int getScrollY() {
      return IMPL.getScrollY(this.mRecord);
   }

   public AccessibilityNodeInfoCompat getSource() {
      return IMPL.getSource(this.mRecord);
   }

   public List<CharSequence> getText() {
      return IMPL.getText(this.mRecord);
   }

   public int getToIndex() {
      return IMPL.getToIndex(this.mRecord);
   }

   public int getWindowId() {
      return IMPL.getWindowId(this.mRecord);
   }

   public int hashCode() {
      return this.mRecord == null?0:this.mRecord.hashCode();
   }

   public boolean isChecked() {
      return IMPL.isChecked(this.mRecord);
   }

   public boolean isEnabled() {
      return IMPL.isEnabled(this.mRecord);
   }

   public boolean isFullScreen() {
      return IMPL.isFullScreen(this.mRecord);
   }

   public boolean isPassword() {
      return IMPL.isPassword(this.mRecord);
   }

   public boolean isScrollable() {
      return IMPL.isScrollable(this.mRecord);
   }

   public void recycle() {
      IMPL.recycle(this.mRecord);
   }

   public void setAddedCount(int var1) {
      IMPL.setAddedCount(this.mRecord, var1);
   }

   public void setBeforeText(CharSequence var1) {
      IMPL.setBeforeText(this.mRecord, var1);
   }

   public void setChecked(boolean var1) {
      IMPL.setChecked(this.mRecord, var1);
   }

   public void setClassName(CharSequence var1) {
      IMPL.setClassName(this.mRecord, var1);
   }

   public void setContentDescription(CharSequence var1) {
      IMPL.setContentDescription(this.mRecord, var1);
   }

   public void setCurrentItemIndex(int var1) {
      IMPL.setCurrentItemIndex(this.mRecord, var1);
   }

   public void setEnabled(boolean var1) {
      IMPL.setEnabled(this.mRecord, var1);
   }

   public void setFromIndex(int var1) {
      IMPL.setFromIndex(this.mRecord, var1);
   }

   public void setFullScreen(boolean var1) {
      IMPL.setFullScreen(this.mRecord, var1);
   }

   public void setItemCount(int var1) {
      IMPL.setItemCount(this.mRecord, var1);
   }

   public void setMaxScrollX(int var1) {
      IMPL.setMaxScrollX(this.mRecord, var1);
   }

   public void setMaxScrollY(int var1) {
      IMPL.setMaxScrollY(this.mRecord, var1);
   }

   public void setParcelableData(Parcelable var1) {
      IMPL.setParcelableData(this.mRecord, var1);
   }

   public void setPassword(boolean var1) {
      IMPL.setPassword(this.mRecord, var1);
   }

   public void setRemovedCount(int var1) {
      IMPL.setRemovedCount(this.mRecord, var1);
   }

   public void setScrollX(int var1) {
      IMPL.setScrollX(this.mRecord, var1);
   }

   public void setScrollY(int var1) {
      IMPL.setScrollY(this.mRecord, var1);
   }

   public void setScrollable(boolean var1) {
      IMPL.setScrollable(this.mRecord, var1);
   }

   public void setSource(View var1) {
      IMPL.setSource(this.mRecord, var1);
   }

   public void setSource(View var1, int var2) {
      IMPL.setSource(this.mRecord, var1, var2);
   }

   public void setToIndex(int var1) {
      IMPL.setToIndex(this.mRecord, var1);
   }

   static class AccessibilityRecordIcsImpl extends AccessibilityRecordCompat.AccessibilityRecordStubImpl {
      public int getAddedCount(Object var1) {
         return AccessibilityRecordCompatIcs.getAddedCount(var1);
      }

      public CharSequence getBeforeText(Object var1) {
         return AccessibilityRecordCompatIcs.getBeforeText(var1);
      }

      public CharSequence getClassName(Object var1) {
         return AccessibilityRecordCompatIcs.getClassName(var1);
      }

      public CharSequence getContentDescription(Object var1) {
         return AccessibilityRecordCompatIcs.getContentDescription(var1);
      }

      public int getCurrentItemIndex(Object var1) {
         return AccessibilityRecordCompatIcs.getCurrentItemIndex(var1);
      }

      public int getFromIndex(Object var1) {
         return AccessibilityRecordCompatIcs.getFromIndex(var1);
      }

      public int getItemCount(Object var1) {
         return AccessibilityRecordCompatIcs.getItemCount(var1);
      }

      public Parcelable getParcelableData(Object var1) {
         return AccessibilityRecordCompatIcs.getParcelableData(var1);
      }

      public int getRemovedCount(Object var1) {
         return AccessibilityRecordCompatIcs.getRemovedCount(var1);
      }

      public int getScrollX(Object var1) {
         return AccessibilityRecordCompatIcs.getScrollX(var1);
      }

      public int getScrollY(Object var1) {
         return AccessibilityRecordCompatIcs.getScrollY(var1);
      }

      public AccessibilityNodeInfoCompat getSource(Object var1) {
         return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityRecordCompatIcs.getSource(var1));
      }

      public List<CharSequence> getText(Object var1) {
         return AccessibilityRecordCompatIcs.getText(var1);
      }

      public int getToIndex(Object var1) {
         return AccessibilityRecordCompatIcs.getToIndex(var1);
      }

      public int getWindowId(Object var1) {
         return AccessibilityRecordCompatIcs.getWindowId(var1);
      }

      public boolean isChecked(Object var1) {
         return AccessibilityRecordCompatIcs.isChecked(var1);
      }

      public boolean isEnabled(Object var1) {
         return AccessibilityRecordCompatIcs.isEnabled(var1);
      }

      public boolean isFullScreen(Object var1) {
         return AccessibilityRecordCompatIcs.isFullScreen(var1);
      }

      public boolean isPassword(Object var1) {
         return AccessibilityRecordCompatIcs.isPassword(var1);
      }

      public boolean isScrollable(Object var1) {
         return AccessibilityRecordCompatIcs.isScrollable(var1);
      }

      public Object obtain() {
         return AccessibilityRecordCompatIcs.obtain();
      }

      public Object obtain(Object var1) {
         return AccessibilityRecordCompatIcs.obtain(var1);
      }

      public void recycle(Object var1) {
         AccessibilityRecordCompatIcs.recycle(var1);
      }

      public void setAddedCount(Object var1, int var2) {
         AccessibilityRecordCompatIcs.setAddedCount(var1, var2);
      }

      public void setBeforeText(Object var1, CharSequence var2) {
         AccessibilityRecordCompatIcs.setBeforeText(var1, var2);
      }

      public void setChecked(Object var1, boolean var2) {
         AccessibilityRecordCompatIcs.setChecked(var1, var2);
      }

      public void setClassName(Object var1, CharSequence var2) {
         AccessibilityRecordCompatIcs.setClassName(var1, var2);
      }

      public void setContentDescription(Object var1, CharSequence var2) {
         AccessibilityRecordCompatIcs.setContentDescription(var1, var2);
      }

      public void setCurrentItemIndex(Object var1, int var2) {
         AccessibilityRecordCompatIcs.setCurrentItemIndex(var1, var2);
      }

      public void setEnabled(Object var1, boolean var2) {
         AccessibilityRecordCompatIcs.setEnabled(var1, var2);
      }

      public void setFromIndex(Object var1, int var2) {
         AccessibilityRecordCompatIcs.setFromIndex(var1, var2);
      }

      public void setFullScreen(Object var1, boolean var2) {
         AccessibilityRecordCompatIcs.setFullScreen(var1, var2);
      }

      public void setItemCount(Object var1, int var2) {
         AccessibilityRecordCompatIcs.setItemCount(var1, var2);
      }

      public void setParcelableData(Object var1, Parcelable var2) {
         AccessibilityRecordCompatIcs.setParcelableData(var1, var2);
      }

      public void setPassword(Object var1, boolean var2) {
         AccessibilityRecordCompatIcs.setPassword(var1, var2);
      }

      public void setRemovedCount(Object var1, int var2) {
         AccessibilityRecordCompatIcs.setRemovedCount(var1, var2);
      }

      public void setScrollX(Object var1, int var2) {
         AccessibilityRecordCompatIcs.setScrollX(var1, var2);
      }

      public void setScrollY(Object var1, int var2) {
         AccessibilityRecordCompatIcs.setScrollY(var1, var2);
      }

      public void setScrollable(Object var1, boolean var2) {
         AccessibilityRecordCompatIcs.setScrollable(var1, var2);
      }

      public void setSource(Object var1, View var2) {
         AccessibilityRecordCompatIcs.setSource(var1, var2);
      }

      public void setToIndex(Object var1, int var2) {
         AccessibilityRecordCompatIcs.setToIndex(var1, var2);
      }
   }

   static class AccessibilityRecordIcsMr1Impl extends AccessibilityRecordCompat.AccessibilityRecordIcsImpl {
      public int getMaxScrollX(Object var1) {
         return AccessibilityRecordCompatIcsMr1.getMaxScrollX(var1);
      }

      public int getMaxScrollY(Object var1) {
         return AccessibilityRecordCompatIcsMr1.getMaxScrollY(var1);
      }

      public void setMaxScrollX(Object var1, int var2) {
         AccessibilityRecordCompatIcsMr1.setMaxScrollX(var1, var2);
      }

      public void setMaxScrollY(Object var1, int var2) {
         AccessibilityRecordCompatIcsMr1.setMaxScrollY(var1, var2);
      }
   }

   interface AccessibilityRecordImpl {
      int getAddedCount(Object var1);

      CharSequence getBeforeText(Object var1);

      CharSequence getClassName(Object var1);

      CharSequence getContentDescription(Object var1);

      int getCurrentItemIndex(Object var1);

      int getFromIndex(Object var1);

      int getItemCount(Object var1);

      int getMaxScrollX(Object var1);

      int getMaxScrollY(Object var1);

      Parcelable getParcelableData(Object var1);

      int getRemovedCount(Object var1);

      int getScrollX(Object var1);

      int getScrollY(Object var1);

      AccessibilityNodeInfoCompat getSource(Object var1);

      List<CharSequence> getText(Object var1);

      int getToIndex(Object var1);

      int getWindowId(Object var1);

      boolean isChecked(Object var1);

      boolean isEnabled(Object var1);

      boolean isFullScreen(Object var1);

      boolean isPassword(Object var1);

      boolean isScrollable(Object var1);

      Object obtain();

      Object obtain(Object var1);

      void recycle(Object var1);

      void setAddedCount(Object var1, int var2);

      void setBeforeText(Object var1, CharSequence var2);

      void setChecked(Object var1, boolean var2);

      void setClassName(Object var1, CharSequence var2);

      void setContentDescription(Object var1, CharSequence var2);

      void setCurrentItemIndex(Object var1, int var2);

      void setEnabled(Object var1, boolean var2);

      void setFromIndex(Object var1, int var2);

      void setFullScreen(Object var1, boolean var2);

      void setItemCount(Object var1, int var2);

      void setMaxScrollX(Object var1, int var2);

      void setMaxScrollY(Object var1, int var2);

      void setParcelableData(Object var1, Parcelable var2);

      void setPassword(Object var1, boolean var2);

      void setRemovedCount(Object var1, int var2);

      void setScrollX(Object var1, int var2);

      void setScrollY(Object var1, int var2);

      void setScrollable(Object var1, boolean var2);

      void setSource(Object var1, View var2);

      void setSource(Object var1, View var2, int var3);

      void setToIndex(Object var1, int var2);
   }

   static class AccessibilityRecordJellyBeanImpl extends AccessibilityRecordCompat.AccessibilityRecordIcsMr1Impl {
      public void setSource(Object var1, View var2, int var3) {
         AccessibilityRecordCompatJellyBean.setSource(var1, var2, var3);
      }
   }

   static class AccessibilityRecordStubImpl implements AccessibilityRecordCompat.AccessibilityRecordImpl {
      public int getAddedCount(Object var1) {
         return 0;
      }

      public CharSequence getBeforeText(Object var1) {
         return null;
      }

      public CharSequence getClassName(Object var1) {
         return null;
      }

      public CharSequence getContentDescription(Object var1) {
         return null;
      }

      public int getCurrentItemIndex(Object var1) {
         return 0;
      }

      public int getFromIndex(Object var1) {
         return 0;
      }

      public int getItemCount(Object var1) {
         return 0;
      }

      public int getMaxScrollX(Object var1) {
         return 0;
      }

      public int getMaxScrollY(Object var1) {
         return 0;
      }

      public Parcelable getParcelableData(Object var1) {
         return null;
      }

      public int getRemovedCount(Object var1) {
         return 0;
      }

      public int getScrollX(Object var1) {
         return 0;
      }

      public int getScrollY(Object var1) {
         return 0;
      }

      public AccessibilityNodeInfoCompat getSource(Object var1) {
         return null;
      }

      public List<CharSequence> getText(Object var1) {
         return Collections.emptyList();
      }

      public int getToIndex(Object var1) {
         return 0;
      }

      public int getWindowId(Object var1) {
         return 0;
      }

      public boolean isChecked(Object var1) {
         return false;
      }

      public boolean isEnabled(Object var1) {
         return false;
      }

      public boolean isFullScreen(Object var1) {
         return false;
      }

      public boolean isPassword(Object var1) {
         return false;
      }

      public boolean isScrollable(Object var1) {
         return false;
      }

      public Object obtain() {
         return null;
      }

      public Object obtain(Object var1) {
         return null;
      }

      public void recycle(Object var1) {
      }

      public void setAddedCount(Object var1, int var2) {
      }

      public void setBeforeText(Object var1, CharSequence var2) {
      }

      public void setChecked(Object var1, boolean var2) {
      }

      public void setClassName(Object var1, CharSequence var2) {
      }

      public void setContentDescription(Object var1, CharSequence var2) {
      }

      public void setCurrentItemIndex(Object var1, int var2) {
      }

      public void setEnabled(Object var1, boolean var2) {
      }

      public void setFromIndex(Object var1, int var2) {
      }

      public void setFullScreen(Object var1, boolean var2) {
      }

      public void setItemCount(Object var1, int var2) {
      }

      public void setMaxScrollX(Object var1, int var2) {
      }

      public void setMaxScrollY(Object var1, int var2) {
      }

      public void setParcelableData(Object var1, Parcelable var2) {
      }

      public void setPassword(Object var1, boolean var2) {
      }

      public void setRemovedCount(Object var1, int var2) {
      }

      public void setScrollX(Object var1, int var2) {
      }

      public void setScrollY(Object var1, int var2) {
      }

      public void setScrollable(Object var1, boolean var2) {
      }

      public void setSource(Object var1, View var2) {
      }

      public void setSource(Object var1, View var2, int var3) {
      }

      public void setToIndex(Object var1, int var2) {
      }
   }
}
