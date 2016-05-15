package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.LayoutInflaterCompatBase;
import android.support.v4.view.LayoutInflaterCompatHC;
import android.support.v4.view.LayoutInflaterCompatLollipop;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;

public final class LayoutInflaterCompat {
   static final LayoutInflaterCompat.LayoutInflaterCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 21) {
         IMPL = new LayoutInflaterCompat.LayoutInflaterCompatImplV21();
      } else if(var0 >= 11) {
         IMPL = new LayoutInflaterCompat.LayoutInflaterCompatImplV11();
      } else {
         IMPL = new LayoutInflaterCompat.LayoutInflaterCompatImplBase();
      }
   }

   public static LayoutInflaterFactory getFactory(LayoutInflater var0) {
      return IMPL.getFactory(var0);
   }

   public static void setFactory(LayoutInflater var0, LayoutInflaterFactory var1) {
      IMPL.setFactory(var0, var1);
   }

   interface LayoutInflaterCompatImpl {
      LayoutInflaterFactory getFactory(LayoutInflater var1);

      void setFactory(LayoutInflater var1, LayoutInflaterFactory var2);
   }

   static class LayoutInflaterCompatImplBase implements LayoutInflaterCompat.LayoutInflaterCompatImpl {
      public LayoutInflaterFactory getFactory(LayoutInflater var1) {
         return LayoutInflaterCompatBase.getFactory(var1);
      }

      public void setFactory(LayoutInflater var1, LayoutInflaterFactory var2) {
         LayoutInflaterCompatBase.setFactory(var1, var2);
      }
   }

   static class LayoutInflaterCompatImplV11 extends LayoutInflaterCompat.LayoutInflaterCompatImplBase {
      public void setFactory(LayoutInflater var1, LayoutInflaterFactory var2) {
         LayoutInflaterCompatHC.setFactory(var1, var2);
      }
   }

   static class LayoutInflaterCompatImplV21 extends LayoutInflaterCompat.LayoutInflaterCompatImplV11 {
      public void setFactory(LayoutInflater var1, LayoutInflaterFactory var2) {
         LayoutInflaterCompatLollipop.setFactory(var1, var2);
      }
   }
}
