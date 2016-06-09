package android.support.v13.app;

import android.app.Fragment;
import android.os.Build.VERSION;
import android.support.v13.app.FragmentCompatICS;
import android.support.v13.app.FragmentCompatICSMR1;

public class FragmentCompat {
   static final FragmentCompat.FragmentCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 15) {
         IMPL = new FragmentCompat.ICSMR1FragmentCompatImpl();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new FragmentCompat.ICSFragmentCompatImpl();
      } else {
         IMPL = new FragmentCompat.BaseFragmentCompatImpl();
      }
   }

   public static void setMenuVisibility(Fragment var0, boolean var1) {
      IMPL.setMenuVisibility(var0, var1);
   }

   public static void setUserVisibleHint(Fragment var0, boolean var1) {
      IMPL.setUserVisibleHint(var0, var1);
   }

   static class BaseFragmentCompatImpl implements FragmentCompat.FragmentCompatImpl {
      public void setMenuVisibility(Fragment var1, boolean var2) {
      }

      public void setUserVisibleHint(Fragment var1, boolean var2) {
      }
   }

   interface FragmentCompatImpl {
      void setMenuVisibility(Fragment var1, boolean var2);

      void setUserVisibleHint(Fragment var1, boolean var2);
   }

   static class ICSFragmentCompatImpl extends FragmentCompat.BaseFragmentCompatImpl {
      public void setMenuVisibility(Fragment var1, boolean var2) {
         FragmentCompatICS.setMenuVisibility(var1, var2);
      }
   }

   static class ICSMR1FragmentCompatImpl extends FragmentCompat.ICSFragmentCompatImpl {
      public void setUserVisibleHint(Fragment var1, boolean var2) {
         FragmentCompatICSMR1.setUserVisibleHint(var1, var2);
      }
   }
}
