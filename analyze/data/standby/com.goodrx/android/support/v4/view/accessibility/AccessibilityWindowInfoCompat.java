package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityWindowInfoCompatApi21;

public class AccessibilityWindowInfoCompat {
   private static final AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl IMPL;
   public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
   public static final int TYPE_APPLICATION = 1;
   public static final int TYPE_INPUT_METHOD = 2;
   public static final int TYPE_SYSTEM = 3;
   private static final int UNDEFINED = -1;
   private Object mInfo;

   static {
      if(VERSION.SDK_INT >= 21) {
         IMPL = new AccessibilityWindowInfoCompat.AccessibilityWindowInfoApi21Impl();
      } else {
         IMPL = new AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl();
      }
   }

   private AccessibilityWindowInfoCompat(Object var1) {
      this.mInfo = var1;
   }

   public static AccessibilityWindowInfoCompat obtain() {
      return wrapNonNullInstance(IMPL.obtain());
   }

   public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat var0) {
      return wrapNonNullInstance(IMPL.obtain(var0.mInfo));
   }

   private static String typeToString(int var0) {
      switch(var0) {
      case 1:
         return "TYPE_APPLICATION";
      case 2:
         return "TYPE_INPUT_METHOD";
      case 3:
         return "TYPE_SYSTEM";
      case 4:
         return "TYPE_ACCESSIBILITY_OVERLAY";
      default:
         return "<UNKNOWN>";
      }
   }

   static AccessibilityWindowInfoCompat wrapNonNullInstance(Object var0) {
      return var0 != null?new AccessibilityWindowInfoCompat(var0):null;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         AccessibilityWindowInfoCompat var2 = (AccessibilityWindowInfoCompat)var1;
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

   public void getBoundsInScreen(Rect var1) {
      IMPL.getBoundsInScreen(this.mInfo, var1);
   }

   public AccessibilityWindowInfoCompat getChild(int var1) {
      return wrapNonNullInstance(IMPL.getChild(this.mInfo, var1));
   }

   public int getChildCount() {
      return IMPL.getChildCount(this.mInfo);
   }

   public int getId() {
      return IMPL.getId(this.mInfo);
   }

   public int getLayer() {
      return IMPL.getLayer(this.mInfo);
   }

   public AccessibilityWindowInfoCompat getParent() {
      return wrapNonNullInstance(IMPL.getParent(this.mInfo));
   }

   public AccessibilityNodeInfoCompat getRoot() {
      return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.getRoot(this.mInfo));
   }

   public int getType() {
      return IMPL.getType(this.mInfo);
   }

   public int hashCode() {
      return this.mInfo == null?0:this.mInfo.hashCode();
   }

   public boolean isAccessibilityFocused() {
      return IMPL.isAccessibilityFocused(this.mInfo);
   }

   public boolean isActive() {
      return IMPL.isActive(this.mInfo);
   }

   public boolean isFocused() {
      return IMPL.isFocused(this.mInfo);
   }

   public void recycle() {
      IMPL.recycle(this.mInfo);
   }

   public String toString() {
      boolean var1 = true;
      StringBuilder var2 = new StringBuilder();
      Rect var3 = new Rect();
      this.getBoundsInScreen(var3);
      var2.append("AccessibilityWindowInfo[");
      var2.append("id=").append(this.getId());
      var2.append(", type=").append(typeToString(this.getType()));
      var2.append(", layer=").append(this.getLayer());
      var2.append(", bounds=").append(var3);
      var2.append(", focused=").append(this.isFocused());
      var2.append(", active=").append(this.isActive());
      StringBuilder var11 = var2.append(", hasParent=");
      boolean var12;
      if(this.getParent() != null) {
         var12 = var1;
      } else {
         var12 = false;
      }

      var11.append(var12);
      StringBuilder var14 = var2.append(", hasChildren=");
      if(this.getChildCount() <= 0) {
         var1 = false;
      }

      var14.append(var1);
      var2.append(']');
      return var2.toString();
   }

   private static class AccessibilityWindowInfoApi21Impl extends AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl {
      private AccessibilityWindowInfoApi21Impl() {
         super(null);
      }

      // $FF: synthetic method
      AccessibilityWindowInfoApi21Impl(Object var1) {
         this();
      }

      public void getBoundsInScreen(Object var1, Rect var2) {
         AccessibilityWindowInfoCompatApi21.getBoundsInScreen(var1, var2);
      }

      public Object getChild(Object var1, int var2) {
         return AccessibilityWindowInfoCompatApi21.getChild(var1, var2);
      }

      public int getChildCount(Object var1) {
         return AccessibilityWindowInfoCompatApi21.getChildCount(var1);
      }

      public int getId(Object var1) {
         return AccessibilityWindowInfoCompatApi21.getId(var1);
      }

      public int getLayer(Object var1) {
         return AccessibilityWindowInfoCompatApi21.getLayer(var1);
      }

      public Object getParent(Object var1) {
         return AccessibilityWindowInfoCompatApi21.getParent(var1);
      }

      public Object getRoot(Object var1) {
         return AccessibilityWindowInfoCompatApi21.getRoot(var1);
      }

      public int getType(Object var1) {
         return AccessibilityWindowInfoCompatApi21.getType(var1);
      }

      public boolean isAccessibilityFocused(Object var1) {
         return AccessibilityWindowInfoCompatApi21.isAccessibilityFocused(var1);
      }

      public boolean isActive(Object var1) {
         return AccessibilityWindowInfoCompatApi21.isActive(var1);
      }

      public boolean isFocused(Object var1) {
         return AccessibilityWindowInfoCompatApi21.isFocused(var1);
      }

      public Object obtain() {
         return AccessibilityWindowInfoCompatApi21.obtain();
      }

      public Object obtain(Object var1) {
         return AccessibilityWindowInfoCompatApi21.obtain(var1);
      }

      public void recycle(Object var1) {
         AccessibilityWindowInfoCompatApi21.recycle(var1);
      }
   }

   private interface AccessibilityWindowInfoImpl {
      void getBoundsInScreen(Object var1, Rect var2);

      Object getChild(Object var1, int var2);

      int getChildCount(Object var1);

      int getId(Object var1);

      int getLayer(Object var1);

      Object getParent(Object var1);

      Object getRoot(Object var1);

      int getType(Object var1);

      boolean isAccessibilityFocused(Object var1);

      boolean isActive(Object var1);

      boolean isFocused(Object var1);

      Object obtain();

      Object obtain(Object var1);

      void recycle(Object var1);
   }

   private static class AccessibilityWindowInfoStubImpl implements AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl {
      private AccessibilityWindowInfoStubImpl() {
      }

      // $FF: synthetic method
      AccessibilityWindowInfoStubImpl(Object var1) {
         this();
      }

      public void getBoundsInScreen(Object var1, Rect var2) {
      }

      public Object getChild(Object var1, int var2) {
         return null;
      }

      public int getChildCount(Object var1) {
         return 0;
      }

      public int getId(Object var1) {
         return -1;
      }

      public int getLayer(Object var1) {
         return -1;
      }

      public Object getParent(Object var1) {
         return null;
      }

      public Object getRoot(Object var1) {
         return null;
      }

      public int getType(Object var1) {
         return -1;
      }

      public boolean isAccessibilityFocused(Object var1) {
         return true;
      }

      public boolean isActive(Object var1) {
         return true;
      }

      public boolean isFocused(Object var1) {
         return true;
      }

      public Object obtain() {
         return null;
      }

      public Object obtain(Object var1) {
         return null;
      }

      public void recycle(Object var1) {
      }
   }
}
