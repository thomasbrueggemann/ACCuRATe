package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
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

public class SupportStreetViewPanoramaFragment extends Fragment {
   // $FF: renamed from: ZQ com.google.android.gms.maps.StreetViewPanorama
   private StreetViewPanorama field_3110;
   private final SupportStreetViewPanoramaFragment.class_1210 aae = new SupportStreetViewPanoramaFragment.class_1210(this);

   public static SupportStreetViewPanoramaFragment newInstance() {
      return new SupportStreetViewPanoramaFragment();
   }

   public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions var0) {
      SupportStreetViewPanoramaFragment var1 = new SupportStreetViewPanoramaFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("StreetViewPanoramaOptions", var0);
      var1.setArguments(var2);
      return var1;
   }

   public final StreetViewPanorama getStreetViewPanorama() {
      IStreetViewPanoramaFragmentDelegate var1 = this.method_3290();
      if(var1 != null) {
         IStreetViewPanoramaDelegate var3;
         try {
            var3 = var1.getStreetViewPanorama();
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }

         if(var3 != null) {
            if(this.field_3110 == null || this.field_3110.method_3423().asBinder() != var3.asBinder()) {
               this.field_3110 = new StreetViewPanorama(var3);
            }

            return this.field_3110;
         }
      }

      return null;
   }

   // $FF: renamed from: jx () com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
   protected IStreetViewPanoramaFragmentDelegate method_3290() {
      this.aae.method_2439();
      return this.aae.gC() == null?null:((SupportStreetViewPanoramaFragment.class_1209)this.aae.gC()).method_3948();
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.aae.setActivity(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.aae.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.aae.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      this.aae.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.aae.onDestroyView();
      super.onDestroyView();
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.aae.setActivity(var1);
      Bundle var4 = new Bundle();
      this.aae.onInflate(var1, var4, var3);
   }

   public void onLowMemory() {
      this.aae.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.aae.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.aae.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.aae.onSaveInstanceState(var1);
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   static class class_1209 implements LifecycleDelegate {
      // $FF: renamed from: FS android.support.v4.app.Fragment
      private final Fragment field_3632;
      // $FF: renamed from: ZR com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
      private final IStreetViewPanoramaFragmentDelegate field_3633;

      public class_1209(Fragment var1, IStreetViewPanoramaFragmentDelegate var2) {
         this.field_3633 = (IStreetViewPanoramaFragmentDelegate)class_347.method_2170(var2);
         this.field_3632 = (Fragment)class_347.method_2170(var1);
      }

      // $FF: renamed from: jx () com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
      public IStreetViewPanoramaFragmentDelegate method_3948() {
         return this.field_3633;
      }

      public void onCreate(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         class_157 var5;
         try {
            var5 = this.field_3633.onCreateView(class_741.method_4178(var1), class_741.method_4178(var2), var3);
         } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
         }

         return (View)class_741.method_4177(var5);
      }

      public void onDestroy() {
         try {
            this.field_3633.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         try {
            this.field_3633.onDestroyView();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         try {
            this.field_3633.onInflate(class_741.method_4178(var1), (StreetViewPanoramaOptions)null, var3);
         } catch (RemoteException var5) {
            throw new RuntimeRemoteException(var5);
         }
      }

      public void onLowMemory() {
         try {
            this.field_3633.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.field_3633.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.field_3633.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.field_3633.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public void onStart() {
      }

      public void onStop() {
      }
   }

   static class class_1210 extends a<SupportStreetViewPanoramaFragment.class_1209> {
      // $FF: renamed from: FS android.support.v4.app.Fragment
      private final Fragment field_1695;
      // $FF: renamed from: ZC com.google.android.gms.dynamic.f
      protected f<SupportStreetViewPanoramaFragment.class_1209> field_1696;
      // $FF: renamed from: oe android.app.Activity
      private Activity field_1697;

      class_1210(Fragment var1) {
         this.field_1695 = var1;
      }

      private void setActivity(Activity var1) {
         this.field_1697 = var1;
         this.method_2439();
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2434(f<SupportStreetViewPanoramaFragment.class_1209> var1) {
         this.field_1696 = var1;
         this.method_2439();
      }

      // $FF: renamed from: ju () void
      public void method_2439() {
         if(this.field_1697 != null && this.field_1696 != null && this.gC() == null) {
            try {
               MapsInitializer.initialize(this.field_1697);
               IStreetViewPanoramaFragmentDelegate var4 = class_590.method_3324(this.field_1697).method_608(class_741.method_4178(this.field_1697));
               this.field_1696.method_868(new SupportStreetViewPanoramaFragment.class_1209(this.field_1695, var4));
            } catch (RemoteException var5) {
               throw new RuntimeRemoteException(var5);
            } catch (GooglePlayServicesNotAvailableException var6) {
               return;
            }
         }

      }
   }
}
