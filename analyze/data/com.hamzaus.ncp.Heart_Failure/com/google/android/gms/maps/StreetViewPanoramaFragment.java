package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.class_590;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaFragment extends Fragment {
   // $FF: renamed from: ZP com.google.android.gms.maps.StreetViewPanoramaFragment$b
   private final StreetViewPanoramaFragment.class_1339 field_4259 = new StreetViewPanoramaFragment.class_1339(this);
   // $FF: renamed from: ZQ com.google.android.gms.maps.StreetViewPanorama
   private StreetViewPanorama field_4260;

   public static StreetViewPanoramaFragment newInstance() {
      return new StreetViewPanoramaFragment();
   }

   public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions var0) {
      StreetViewPanoramaFragment var1 = new StreetViewPanoramaFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("StreetViewPanoramaOptions", var0);
      var1.setArguments(var2);
      return var1;
   }

   public final StreetViewPanorama getStreetViewPanorama() {
      IStreetViewPanoramaFragmentDelegate var1 = this.method_4495();
      if(var1 != null) {
         IStreetViewPanoramaDelegate var3;
         try {
            var3 = var1.getStreetViewPanorama();
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }

         if(var3 != null) {
            if(this.field_4260 == null || this.field_4260.method_3423().asBinder() != var3.asBinder()) {
               this.field_4260 = new StreetViewPanorama(var3);
            }

            return this.field_4260;
         }
      }

      return null;
   }

   // $FF: renamed from: jx () com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
   protected IStreetViewPanoramaFragmentDelegate method_4495() {
      this.field_4259.method_2437();
      return this.field_4259.gC() == null?null:((StreetViewPanoramaFragment.class_1338)this.field_4259.gC()).method_4604();
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.field_4259.setActivity(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.field_4259.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.field_4259.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      this.field_4259.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.field_4259.onDestroyView();
      super.onDestroyView();
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.field_4259.setActivity(var1);
      Bundle var4 = new Bundle();
      this.field_4259.onInflate(var1, var4, var3);
   }

   public void onLowMemory() {
      this.field_4259.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.field_4259.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.field_4259.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.field_4259.onSaveInstanceState(var1);
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   static class class_1338 implements LifecycleDelegate {
      // $FF: renamed from: Mg android.app.Fragment
      private final Fragment field_4375;
      // $FF: renamed from: ZR com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
      private final IStreetViewPanoramaFragmentDelegate field_4376;

      public class_1338(Fragment var1, IStreetViewPanoramaFragmentDelegate var2) {
         this.field_4376 = (IStreetViewPanoramaFragmentDelegate)class_347.method_2170(var2);
         this.field_4375 = (Fragment)class_347.method_2170(var1);
      }

      // $FF: renamed from: jx () com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
      public IStreetViewPanoramaFragmentDelegate method_4604() {
         return this.field_4376;
      }

      public void onCreate(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         class_157 var5;
         try {
            var5 = this.field_4376.onCreateView(class_741.method_4178(var1), class_741.method_4178(var2), var3);
         } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
         }

         return (View)class_741.method_4177(var5);
      }

      public void onDestroy() {
         try {
            this.field_4376.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         try {
            this.field_4376.onDestroyView();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         try {
            this.field_4376.onInflate(class_741.method_4178(var1), (StreetViewPanoramaOptions)null, var3);
         } catch (RemoteException var5) {
            throw new RuntimeRemoteException(var5);
         }
      }

      public void onLowMemory() {
         try {
            this.field_4376.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.field_4376.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.field_4376.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.field_4376.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public void onStart() {
      }

      public void onStop() {
      }
   }

   static class class_1339 extends a<StreetViewPanoramaFragment.class_1338> {
      // $FF: renamed from: Mg android.app.Fragment
      private final Fragment field_1692;
      // $FF: renamed from: ZC com.google.android.gms.dynamic.f
      protected f<StreetViewPanoramaFragment.class_1338> field_1693;
      // $FF: renamed from: oe android.app.Activity
      private Activity field_1694;

      class_1339(Fragment var1) {
         this.field_1692 = var1;
      }

      private void setActivity(Activity var1) {
         this.field_1694 = var1;
         this.method_2437();
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2434(f<StreetViewPanoramaFragment.class_1338> var1) {
         this.field_1693 = var1;
         this.method_2437();
      }

      // $FF: renamed from: ju () void
      public void method_2437() {
         if(this.field_1694 != null && this.field_1693 != null && this.gC() == null) {
            try {
               MapsInitializer.initialize(this.field_1694);
               IStreetViewPanoramaFragmentDelegate var4 = class_590.method_3324(this.field_1694).method_608(class_741.method_4178(this.field_1694));
               this.field_1693.method_868(new StreetViewPanoramaFragment.class_1338(this.field_1692, var4));
            } catch (RemoteException var5) {
               throw new RuntimeRemoteException(var5);
            } catch (GooglePlayServicesNotAvailableException var6) {
               return;
            }
         }

      }
   }
}
