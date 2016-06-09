package android.support.v4.view;

import android.support.v4.view.LayoutInflaterCompatHC;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;

class LayoutInflaterCompatLollipop {
   static void setFactory(LayoutInflater var0, LayoutInflaterFactory var1) {
      LayoutInflaterCompatHC.FactoryWrapperHC var2;
      if(var1 != null) {
         var2 = new LayoutInflaterCompatHC.FactoryWrapperHC(var1);
      } else {
         var2 = null;
      }

      var0.setFactory2(var2);
   }
}
