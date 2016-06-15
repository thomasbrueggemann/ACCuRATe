package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatIcs;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfoCompat {
   public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
   public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
   public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
   public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
   public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
   public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
   public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
   public static final int ACTION_CLEAR_FOCUS = 2;
   public static final int ACTION_CLEAR_SELECTION = 8;
   public static final int ACTION_CLICK = 16;
   public static final int ACTION_COPY = 16384;
   public static final int ACTION_CUT = 65536;
   public static final int ACTION_FOCUS = 1;
   public static final int ACTION_LONG_CLICK = 32;
   public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
   public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
   public static final int ACTION_PASTE = 32768;
   public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
   public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
   public static final int ACTION_SCROLL_BACKWARD = 8192;
   public static final int ACTION_SCROLL_FORWARD = 4096;
   public static final int ACTION_SELECT = 4;
   public static final int ACTION_SET_SELECTION = 131072;
   public static final int FOCUS_ACCESSIBILITY = 2;
   public static final int FOCUS_INPUT = 1;
   private static final AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl IMPL;
   public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
   public static final int MOVEMENT_GRANULARITY_LINE = 4;
   public static final int MOVEMENT_GRANULARITY_PAGE = 16;
   public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
   public static final int MOVEMENT_GRANULARITY_WORD = 2;
   private final Object mInfo;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl();
      } else if(VERSION.SDK_INT >= 18) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl();
      } else if(VERSION.SDK_INT >= 16) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl();
      } else {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl();
      }
   }

   public AccessibilityNodeInfoCompat(Object var1) {
      this.mInfo = var1;
   }

   private static String getActionSymbolicName(int var0) {
      switch(var0) {
      case 1:
         return "ACTION_FOCUS";
      case 2:
         return "ACTION_CLEAR_FOCUS";
      case 4:
         return "ACTION_SELECT";
      case 8:
         return "ACTION_CLEAR_SELECTION";
      case 16:
         return "ACTION_CLICK";
      case 32:
         return "ACTION_LONG_CLICK";
      case 64:
         return "ACTION_ACCESSIBILITY_FOCUS";
      case 128:
         return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
      case 256:
         return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
      case 512:
         return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
      case 1024:
         return "ACTION_NEXT_HTML_ELEMENT";
      case 2048:
         return "ACTION_PREVIOUS_HTML_ELEMENT";
      case 4096:
         return "ACTION_SCROLL_FORWARD";
      case 8192:
         return "ACTION_SCROLL_BACKWARD";
      case 16384:
         return "ACTION_COPY";
      case 32768:
         return "ACTION_PASTE";
      case 65536:
         return "ACTION_CUT";
      case 131072:
         return "ACTION_SET_SELECTION";
      default:
         return "ACTION_UNKNOWN";
      }
   }

   public static AccessibilityNodeInfoCompat obtain() {
      return wrapNonNullInstance(IMPL.obtain());
   }

   public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat var0) {
      return wrapNonNullInstance(IMPL.obtain(var0.mInfo));
   }

   public static AccessibilityNodeInfoCompat obtain(View var0) {
      return wrapNonNullInstance(IMPL.obtain(var0));
   }

   public static AccessibilityNodeInfoCompat obtain(View var0, int var1) {
      return wrapNonNullInstance(IMPL.obtain(var0, var1));
   }

   static AccessibilityNodeInfoCompat wrapNonNullInstance(Object var0) {
      return var0 != null?new AccessibilityNodeInfoCompat(var0):null;
   }

   public void addAction(int var1) {
      IMPL.addAction(this.mInfo, var1);
   }

   public void addChild(View var1) {
      IMPL.addChild(this.mInfo, var1);
   }

   public void addChild(View var1, int var2) {
      IMPL.addChild(this.mInfo, var1, var2);
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         AccessibilityNodeInfoCompat var2 = (AccessibilityNodeInfoCompat)var1;
         if(this.mInfo == null) {
            if(var2.mInfo != null) {
               return false;
            }
         } else if(!this.mInfo.equals(var2.mInfo)) {
            return false;
         }
      }

      return true;
   }

   public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String var1) {
      ArrayList var2 = new ArrayList();
      List var3 = IMPL.findAccessibilityNodeInfosByText(this.mInfo, var1);
      int var4 = var3.size();

      for(int var5 = 0; var5 < var4; ++var5) {
         var2.add(new AccessibilityNodeInfoCompat(var3.get(var5)));
      }

      return var2;
   }

   public AccessibilityNodeInfoCompat findFocus(int var1) {
      return wrapNonNullInstance(IMPL.findFocus(this.mInfo, var1));
   }

   public AccessibilityNodeInfoCompat focusSearch(int var1) {
      return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, var1));
   }

   public int getActions() {
      return IMPL.getActions(this.mInfo);
   }

   public void getBoundsInParent(Rect var1) {
      IMPL.getBoundsInParent(this.mInfo, var1);
   }

   public void getBoundsInScreen(Rect var1) {
      IMPL.getBoundsInScreen(this.mInfo, var1);
   }

   public AccessibilityNodeInfoCompat getChild(int var1) {
      return wrapNonNullInstance(IMPL.getChild(this.mInfo, var1));
   }

   public int getChildCount() {
      return IMPL.getChildCount(this.mInfo);
   }

   public CharSequence getClassName() {
      return IMPL.getClassName(this.mInfo);
   }

   public CharSequence getContentDescription() {
      return IMPL.getContentDescription(this.mInfo);
   }

   public Object getInfo() {
      return this.mInfo;
   }

   public int getLiveRegion() {
      return IMPL.getLiveRegion(this.mInfo);
   }

   public int getMovementGranularities() {
      return IMPL.getMovementGranularities(this.mInfo);
   }

   public CharSequence getPackageName() {
      return IMPL.getPackageName(this.mInfo);
   }

   public AccessibilityNodeInfoCompat getParent() {
      return wrapNonNullInstance(IMPL.getParent(this.mInfo));
   }

   public CharSequence getText() {
      return IMPL.getText(this.mInfo);
   }

   public String getViewIdResourceName() {
      return IMPL.getViewIdResourceName(this.mInfo);
   }

   public int getWindowId() {
      return IMPL.getWindowId(this.mInfo);
   }

   public int hashCode() {
      return this.mInfo == null?0:this.mInfo.hashCode();
   }

   public boolean isAccessibilityFocused() {
      return IMPL.isAccessibilityFocused(this.mInfo);
   }

   public boolean isCheckable() {
      return IMPL.isCheckable(this.mInfo);
   }

   public boolean isChecked() {
      return IMPL.isChecked(this.mInfo);
   }

   public boolean isClickable() {
      return IMPL.isClickable(this.mInfo);
   }

   public boolean isEnabled() {
      return IMPL.isEnabled(this.mInfo);
   }

   public boolean isFocusable() {
      return IMPL.isFocusable(this.mInfo);
   }

   public boolean isFocused() {
      return IMPL.isFocused(this.mInfo);
   }

   public boolean isLongClickable() {
      return IMPL.isLongClickable(this.mInfo);
   }

   public boolean isPassword() {
      return IMPL.isPassword(this.mInfo);
   }

   public boolean isScrollable() {
      return IMPL.isScrollable(this.mInfo);
   }

   public boolean isSelected() {
      return IMPL.isSelected(this.mInfo);
   }

   public boolean isVisibleToUser() {
      return IMPL.isVisibleToUser(this.mInfo);
   }

   public boolean performAction(int var1) {
      return IMPL.performAction(this.mInfo, var1);
   }

   public boolean performAction(int var1, Bundle var2) {
      return IMPL.performAction(this.mInfo, var1, var2);
   }

   public void recycle() {
      IMPL.recycle(this.mInfo);
   }

   public void setAccessibilityFocused(boolean var1) {
      IMPL.setAccessibilityFocused(this.mInfo, var1);
   }

   public void setBoundsInParent(Rect var1) {
      IMPL.setBoundsInParent(this.mInfo, var1);
   }

   public void setBoundsInScreen(Rect var1) {
      IMPL.setBoundsInScreen(this.mInfo, var1);
   }

   public void setCheckable(boolean var1) {
      IMPL.setCheckable(this.mInfo, var1);
   }

   public void setChecked(boolean var1) {
      IMPL.setChecked(this.mInfo, var1);
   }

   public void setClassName(CharSequence var1) {
      IMPL.setClassName(this.mInfo, var1);
   }

   public void setClickable(boolean var1) {
      IMPL.setClickable(this.mInfo, var1);
   }

   public void setContentDescription(CharSequence var1) {
      IMPL.setContentDescription(this.mInfo, var1);
   }

   public void setEnabled(boolean var1) {
      IMPL.setEnabled(this.mInfo, var1);
   }

   public void setFocusable(boolean var1) {
      IMPL.setFocusable(this.mInfo, var1);
   }

   public void setFocused(boolean var1) {
      IMPL.setFocused(this.mInfo, var1);
   }

   public void setLiveRegion(int var1) {
      IMPL.setLiveRegion(this.mInfo, var1);
   }

   public void setLongClickable(boolean var1) {
      IMPL.setLongClickable(this.mInfo, var1);
   }

   public void setMovementGranularities(int var1) {
      IMPL.setMovementGranularities(this.mInfo, var1);
   }

   public void setPackageName(CharSequence var1) {
      IMPL.setPackageName(this.mInfo, var1);
   }

   public void setParent(View var1) {
      IMPL.setParent(this.mInfo, var1);
   }

   public void setParent(View var1, int var2) {
      IMPL.setParent(this.mInfo, var1, var2);
   }

   public void setPassword(boolean var1) {
      IMPL.setPassword(this.mInfo, var1);
   }

   public void setScrollable(boolean var1) {
      IMPL.setScrollable(this.mInfo, var1);
   }

   public void setSelected(boolean var1) {
      IMPL.setSelected(this.mInfo, var1);
   }

   public void setSource(View var1) {
      IMPL.setSource(this.mInfo, var1);
   }

   public void setSource(View var1, int var2) {
      IMPL.setSource(this.mInfo, var1, var2);
   }

   public void setText(CharSequence var1) {
      IMPL.setText(this.mInfo, var1);
   }

   public void setViewIdResourceName(String var1) {
      IMPL.setViewIdResourceName(this.mInfo, var1);
   }

   public void setVisibleToUser(boolean var1) {
      IMPL.setVisibleToUser(this.mInfo, var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(super.toString());
      Rect var3 = new Rect();
      this.getBoundsInParent(var3);
      var1.append("; boundsInParent: " + var3);
      this.getBoundsInScreen(var3);
      var1.append("; boundsInScreen: " + var3);
      var1.append("; packageName: ").append(this.getPackageName());
      var1.append("; className: ").append(this.getClassName());
      var1.append("; text: ").append(this.getText());
      var1.append("; contentDescription: ").append(this.getContentDescription());
      var1.append("; viewId: ").append(this.getViewIdResourceName());
      var1.append("; checkable: ").append(this.isCheckable());
      var1.append("; checked: ").append(this.isChecked());
      var1.append("; focusable: ").append(this.isFocusable());
      var1.append("; focused: ").append(this.isFocused());
      var1.append("; selected: ").append(this.isSelected());
      var1.append("; clickable: ").append(this.isClickable());
      var1.append("; longClickable: ").append(this.isLongClickable());
      var1.append("; enabled: ").append(this.isEnabled());
      var1.append("; password: ").append(this.isPassword());
      var1.append("; scrollable: " + this.isScrollable());
      var1.append("; [");
      int var22 = this.getActions();

      while(var22 != 0) {
         int var24 = 1 << Integer.numberOfTrailingZeros(var22);
         var22 &= ~var24;
         var1.append(getActionSymbolicName(var24));
         if(var22 != 0) {
            var1.append(", ");
         }
      }

      var1.append("]");
      return var1.toString();
   }

   static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl {
      public void addAction(Object var1, int var2) {
         AccessibilityNodeInfoCompatIcs.addAction(var1, var2);
      }

      public void addChild(Object var1, View var2) {
         AccessibilityNodeInfoCompatIcs.addChild(var1, var2);
      }

      public List<Object> findAccessibilityNodeInfosByText(Object var1, String var2) {
         return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(var1, var2);
      }

      public int getActions(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getActions(var1);
      }

      public void getBoundsInParent(Object var1, Rect var2) {
         AccessibilityNodeInfoCompatIcs.getBoundsInParent(var1, var2);
      }

      public void getBoundsInScreen(Object var1, Rect var2) {
         AccessibilityNodeInfoCompatIcs.getBoundsInScreen(var1, var2);
      }

      public Object getChild(Object var1, int var2) {
         return AccessibilityNodeInfoCompatIcs.getChild(var1, var2);
      }

      public int getChildCount(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getChildCount(var1);
      }

      public CharSequence getClassName(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getClassName(var1);
      }

      public CharSequence getContentDescription(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getContentDescription(var1);
      }

      public CharSequence getPackageName(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getPackageName(var1);
      }

      public Object getParent(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getParent(var1);
      }

      public CharSequence getText(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getText(var1);
      }

      public int getWindowId(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getWindowId(var1);
      }

      public boolean isCheckable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isCheckable(var1);
      }

      public boolean isChecked(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isChecked(var1);
      }

      public boolean isClickable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isClickable(var1);
      }

      public boolean isEnabled(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isEnabled(var1);
      }

      public boolean isFocusable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isFocusable(var1);
      }

      public boolean isFocused(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isFocused(var1);
      }

      public boolean isLongClickable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isLongClickable(var1);
      }

      public boolean isPassword(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isPassword(var1);
      }

      public boolean isScrollable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isScrollable(var1);
      }

      public boolean isSelected(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isSelected(var1);
      }

      public Object obtain() {
         return AccessibilityNodeInfoCompatIcs.obtain();
      }

      public Object obtain(View var1) {
         return AccessibilityNodeInfoCompatIcs.obtain(var1);
      }

      public Object obtain(Object var1) {
         return AccessibilityNodeInfoCompatIcs.obtain(var1);
      }

      public boolean performAction(Object var1, int var2) {
         return AccessibilityNodeInfoCompatIcs.performAction(var1, var2);
      }

      public void recycle(Object var1) {
         AccessibilityNodeInfoCompatIcs.recycle(var1);
      }

      public void setBoundsInParent(Object var1, Rect var2) {
         AccessibilityNodeInfoCompatIcs.setBoundsInParent(var1, var2);
      }

      public void setBoundsInScreen(Object var1, Rect var2) {
         AccessibilityNodeInfoCompatIcs.setBoundsInScreen(var1, var2);
      }

      public void setCheckable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setCheckable(var1, var2);
      }

      public void setChecked(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setChecked(var1, var2);
      }

      public void setClassName(Object var1, CharSequence var2) {
         AccessibilityNodeInfoCompatIcs.setClassName(var1, var2);
      }

      public void setClickable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setClickable(var1, var2);
      }

      public void setContentDescription(Object var1, CharSequence var2) {
         AccessibilityNodeInfoCompatIcs.setContentDescription(var1, var2);
      }

      public void setEnabled(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setEnabled(var1, var2);
      }

      public void setFocusable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setFocusable(var1, var2);
      }

      public void setFocused(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setFocused(var1, var2);
      }

      public void setLongClickable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setLongClickable(var1, var2);
      }

      public void setPackageName(Object var1, CharSequence var2) {
         AccessibilityNodeInfoCompatIcs.setPackageName(var1, var2);
      }

      public void setParent(Object var1, View var2) {
         AccessibilityNodeInfoCompatIcs.setParent(var1, var2);
      }

      public void setPassword(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setPassword(var1, var2);
      }

      public void setScrollable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setScrollable(var1, var2);
      }

      public void setSelected(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setSelected(var1, var2);
      }

      public void setSource(Object var1, View var2) {
         AccessibilityNodeInfoCompatIcs.setSource(var1, var2);
      }

      public void setText(Object var1, CharSequence var2) {
         AccessibilityNodeInfoCompatIcs.setText(var1, var2);
      }
   }

   interface AccessibilityNodeInfoImpl {
      void addAction(Object var1, int var2);

      void addChild(Object var1, View var2);

      void addChild(Object var1, View var2, int var3);

      List<Object> findAccessibilityNodeInfosByText(Object var1, String var2);

      Object findFocus(Object var1, int var2);

      Object focusSearch(Object var1, int var2);

      int getActions(Object var1);

      void getBoundsInParent(Object var1, Rect var2);

      void getBoundsInScreen(Object var1, Rect var2);

      Object getChild(Object var1, int var2);

      int getChildCount(Object var1);

      CharSequence getClassName(Object var1);

      CharSequence getContentDescription(Object var1);

      int getLiveRegion(Object var1);

      int getMovementGranularities(Object var1);

      CharSequence getPackageName(Object var1);

      Object getParent(Object var1);

      CharSequence getText(Object var1);

      String getViewIdResourceName(Object var1);

      int getWindowId(Object var1);

      boolean isAccessibilityFocused(Object var1);

      boolean isCheckable(Object var1);

      boolean isChecked(Object var1);

      boolean isClickable(Object var1);

      boolean isEnabled(Object var1);

      boolean isFocusable(Object var1);

      boolean isFocused(Object var1);

      boolean isLongClickable(Object var1);

      boolean isPassword(Object var1);

      boolean isScrollable(Object var1);

      boolean isSelected(Object var1);

      boolean isVisibleToUser(Object var1);

      Object obtain();

      Object obtain(View var1);

      Object obtain(View var1, int var2);

      Object obtain(Object var1);

      boolean performAction(Object var1, int var2);

      boolean performAction(Object var1, int var2, Bundle var3);

      void recycle(Object var1);

      void setAccessibilityFocused(Object var1, boolean var2);

      void setBoundsInParent(Object var1, Rect var2);

      void setBoundsInScreen(Object var1, Rect var2);

      void setCheckable(Object var1, boolean var2);

      void setChecked(Object var1, boolean var2);

      void setClassName(Object var1, CharSequence var2);

      void setClickable(Object var1, boolean var2);

      void setContentDescription(Object var1, CharSequence var2);

      void setEnabled(Object var1, boolean var2);

      void setFocusable(Object var1, boolean var2);

      void setFocused(Object var1, boolean var2);

      void setLiveRegion(Object var1, int var2);

      void setLongClickable(Object var1, boolean var2);

      void setMovementGranularities(Object var1, int var2);

      void setPackageName(Object var1, CharSequence var2);

      void setParent(Object var1, View var2);

      void setParent(Object var1, View var2, int var3);

      void setPassword(Object var1, boolean var2);

      void setScrollable(Object var1, boolean var2);

      void setSelected(Object var1, boolean var2);

      void setSource(Object var1, View var2);

      void setSource(Object var1, View var2, int var3);

      void setText(Object var1, CharSequence var2);

      void setViewIdResourceName(Object var1, String var2);

      void setVisibleToUser(Object var1, boolean var2);
   }

   static class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl {
      public void addChild(Object var1, View var2, int var3) {
         AccessibilityNodeInfoCompatJellyBean.addChild(var1, var2, var3);
      }

      public Object findFocus(Object var1, int var2) {
         return AccessibilityNodeInfoCompatJellyBean.findFocus(var1, var2);
      }

      public Object focusSearch(Object var1, int var2) {
         return AccessibilityNodeInfoCompatJellyBean.focusSearch(var1, var2);
      }

      public int getMovementGranularities(Object var1) {
         return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(var1);
      }

      public boolean isAccessibilityFocused(Object var1) {
         return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(var1);
      }

      public boolean isVisibleToUser(Object var1) {
         return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(var1);
      }

      public Object obtain(View var1, int var2) {
         return AccessibilityNodeInfoCompatJellyBean.obtain(var1, var2);
      }

      public boolean performAction(Object var1, int var2, Bundle var3) {
         return AccessibilityNodeInfoCompatJellyBean.performAction(var1, var2, var3);
      }

      public void setAccessibilityFocused(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(var1, var2);
      }

      public void setMovementGranularities(Object var1, int var2) {
         AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(var1, var2);
      }

      public void setParent(Object var1, View var2, int var3) {
         AccessibilityNodeInfoCompatJellyBean.setParent(var1, var2, var3);
      }

      public void setSource(Object var1, View var2, int var3) {
         AccessibilityNodeInfoCompatJellyBean.setSource(var1, var2, var3);
      }

      public void setVisibleToUser(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(var1, var2);
      }
   }

   static class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl {
      public String getViewIdResourceName(Object var1) {
         return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(var1);
      }

      public void setViewIdResourceName(Object var1, String var2) {
         AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(var1, var2);
      }
   }

   static class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl {
      public int getLiveRegion(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.getLiveRegion(var1);
      }

      public void setLiveRegion(Object var1, int var2) {
         AccessibilityNodeInfoCompatKitKat.setLiveRegion(var1, var2);
      }
   }

   static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl {
      public void addAction(Object var1, int var2) {
      }

      public void addChild(Object var1, View var2) {
      }

      public void addChild(Object var1, View var2, int var3) {
      }

      public List<Object> findAccessibilityNodeInfosByText(Object var1, String var2) {
         return Collections.emptyList();
      }

      public Object findFocus(Object var1, int var2) {
         return null;
      }

      public Object focusSearch(Object var1, int var2) {
         return null;
      }

      public int getActions(Object var1) {
         return 0;
      }

      public void getBoundsInParent(Object var1, Rect var2) {
      }

      public void getBoundsInScreen(Object var1, Rect var2) {
      }

      public Object getChild(Object var1, int var2) {
         return null;
      }

      public int getChildCount(Object var1) {
         return 0;
      }

      public CharSequence getClassName(Object var1) {
         return null;
      }

      public CharSequence getContentDescription(Object var1) {
         return null;
      }

      public int getLiveRegion(Object var1) {
         return 0;
      }

      public int getMovementGranularities(Object var1) {
         return 0;
      }

      public CharSequence getPackageName(Object var1) {
         return null;
      }

      public Object getParent(Object var1) {
         return null;
      }

      public CharSequence getText(Object var1) {
         return null;
      }

      public String getViewIdResourceName(Object var1) {
         return null;
      }

      public int getWindowId(Object var1) {
         return 0;
      }

      public boolean isAccessibilityFocused(Object var1) {
         return false;
      }

      public boolean isCheckable(Object var1) {
         return false;
      }

      public boolean isChecked(Object var1) {
         return false;
      }

      public boolean isClickable(Object var1) {
         return false;
      }

      public boolean isEnabled(Object var1) {
         return false;
      }

      public boolean isFocusable(Object var1) {
         return false;
      }

      public boolean isFocused(Object var1) {
         return false;
      }

      public boolean isLongClickable(Object var1) {
         return false;
      }

      public boolean isPassword(Object var1) {
         return false;
      }

      public boolean isScrollable(Object var1) {
         return false;
      }

      public boolean isSelected(Object var1) {
         return false;
      }

      public boolean isVisibleToUser(Object var1) {
         return false;
      }

      public Object obtain() {
         return null;
      }

      public Object obtain(View var1) {
         return null;
      }

      public Object obtain(View var1, int var2) {
         return null;
      }

      public Object obtain(Object var1) {
         return null;
      }

      public boolean performAction(Object var1, int var2) {
         return false;
      }

      public boolean performAction(Object var1, int var2, Bundle var3) {
         return false;
      }

      public void recycle(Object var1) {
      }

      public void setAccessibilityFocused(Object var1, boolean var2) {
      }

      public void setBoundsInParent(Object var1, Rect var2) {
      }

      public void setBoundsInScreen(Object var1, Rect var2) {
      }

      public void setCheckable(Object var1, boolean var2) {
      }

      public void setChecked(Object var1, boolean var2) {
      }

      public void setClassName(Object var1, CharSequence var2) {
      }

      public void setClickable(Object var1, boolean var2) {
      }

      public void setContentDescription(Object var1, CharSequence var2) {
      }

      public void setEnabled(Object var1, boolean var2) {
      }

      public void setFocusable(Object var1, boolean var2) {
      }

      public void setFocused(Object var1, boolean var2) {
      }

      public void setLiveRegion(Object var1, int var2) {
      }

      public void setLongClickable(Object var1, boolean var2) {
      }

      public void setMovementGranularities(Object var1, int var2) {
      }

      public void setPackageName(Object var1, CharSequence var2) {
      }

      public void setParent(Object var1, View var2) {
      }

      public void setParent(Object var1, View var2, int var3) {
      }

      public void setPassword(Object var1, boolean var2) {
      }

      public void setScrollable(Object var1, boolean var2) {
      }

      public void setSelected(Object var1, boolean var2) {
      }

      public void setSource(Object var1, View var2) {
      }

      public void setSource(Object var1, View var2, int var3) {
      }

      public void setText(Object var1, CharSequence var2) {
      }

      public void setViewIdResourceName(Object var1, String var2) {
      }

      public void setVisibleToUser(Object var1, boolean var2) {
      }
   }
}
