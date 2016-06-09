package android.support.v4.view;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompatBase;
import android.support.v4.view.LayoutInflaterFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

class LayoutInflaterCompatHC {
   private static final String TAG = "LayoutInflaterCompatHC";
   private static boolean sCheckedField;
   private static Field sLayoutInflaterFactory2Field;

   static void forceSetFactory2(LayoutInflater var0, Factory2 var1) {
      if(!sCheckedField) {
         try {
            sLayoutInflaterFactory2Field = LayoutInflater.class.getDeclaredField("mFactory2");
            sLayoutInflaterFactory2Field.setAccessible(true);
         } catch (NoSuchFieldException var6) {
            Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field \'mFactory2\' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", var6);
         }

         sCheckedField = true;
      }

      if(sLayoutInflaterFactory2Field != null) {
         try {
            sLayoutInflaterFactory2Field.set(var0, var1);
         } catch (IllegalAccessException var5) {
            Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + var0 + "; inflation may have unexpected results.", var5);
            return;
         }
      }

   }

   static void setFactory(LayoutInflater var0, LayoutInflaterFactory var1) {
      LayoutInflaterCompatHC.FactoryWrapperHC var2;
      if(var1 != null) {
         var2 = new LayoutInflaterCompatHC.FactoryWrapperHC(var1);
      } else {
         var2 = null;
      }

      var0.setFactory2(var2);
      Factory var3 = var0.getFactory();
      if(var3 instanceof Factory2) {
         forceSetFactory2(var0, (Factory2)var3);
      } else {
         forceSetFactory2(var0, var2);
      }
   }

   static class FactoryWrapperHC extends LayoutInflaterCompatBase.FactoryWrapper implements Factory2 {
      FactoryWrapperHC(LayoutInflaterFactory var1) {
         super(var1);
      }

      public View onCreateView(View var1, String var2, Context var3, AttributeSet var4) {
         return this.mDelegateFactory.onCreateView(var1, var2, var3, var4);
      }
   }
}
