package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.class_99;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportStreetViewPanoramaFragment extends Fragment {
   private final SupportStreetViewPanoramaFragment.class_1571 alF = new SupportStreetViewPanoramaFragment.class_1571(this);
   private StreetViewPanorama alm;

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

   @Deprecated
   public final StreetViewPanorama getStreetViewPanorama() {
      IStreetViewPanoramaFragmentDelegate var1 = this.method_3936();
      if(var1 != null) {
         IStreetViewPanoramaDelegate var3;
         try {
            var3 = var1.getStreetViewPanorama();
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }

         if(var3 != null) {
            if(this.alm == null || this.alm.method_4094().asBinder() != var3.asBinder()) {
               this.alm = new StreetViewPanorama(var3);
            }

            return this.alm;
         }
      }

      return null;
   }

   public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback var1) {
      class_335.method_2304("getStreetViewPanoramaAsync() must be called on the main thread");
      this.alF.getStreetViewPanoramaAsync(var1);
   }

   // $FF: renamed from: nR () com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
   protected IStreetViewPanoramaFragmentDelegate method_3936() {
      this.alF.method_2766();
      return this.alF.je() == null?null:((SupportStreetViewPanoramaFragment.class_1069)this.alF.je()).method_4933();
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.alF.setActivity(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.alF.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.alF.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      this.alF.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.alF.onDestroyView();
      super.onDestroyView();
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.alF.setActivity(var1);
      Bundle var4 = new Bundle();
      this.alF.onInflate(var1, var4, var3);
   }

   public void onLowMemory() {
      this.alF.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.alF.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.alF.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.alF.onSaveInstanceState(var1);
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   static class class_1069 implements StreetViewLifecycleDelegate {
      // $FF: renamed from: Mx android.support.v4.app.Fragment
      private final Fragment field_3772;
      private final IStreetViewPanoramaFragmentDelegate aln;

      public class_1069(Fragment var1, IStreetViewPanoramaFragmentDelegate var2) {
         this.aln = (IStreetViewPanoramaFragmentDelegate)class_335.method_2311(var2);
         this.field_3772 = (Fragment)class_335.method_2311(var1);
      }

      public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback var1) {
         try {
            this.aln.getStreetViewPanoramaAsync(new class_99.class_1357() {
               // $FF: renamed from: a (com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate) void
               public void method_642(IStreetViewPanoramaDelegate var1x) throws RemoteException {
                  var1.onStreetViewPanoramaReady(new StreetViewPanorama(var1x));
               }
            });
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      // $FF: renamed from: nR () com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
      public IStreetViewPanoramaFragmentDelegate method_4933() {
         return this.aln;
      }

      public void onCreate(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         class_198 var5;
         try {
            var5 = this.aln.onCreateView(class_960.method_5293(var1), class_960.method_5293(var2), var3);
         } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
         }

         return (View)class_960.method_5292(var5);
      }

      public void onDestroy() {
         try {
            this.aln.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         try {
            this.aln.onDestroyView();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         try {
            this.aln.onInflate(class_960.method_5293(var1), (StreetViewPanoramaOptions)null, var3);
         } catch (RemoteException var5) {
            throw new RuntimeRemoteException(var5);
         }
      }

      public void onLowMemory() {
         try {
            this.aln.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.aln.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.aln.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.aln.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public void onStart() {
      }

      public void onStop() {
      }
   }

   static class class_1571 extends a<SupportStreetViewPanoramaFragment.class_1069> {
      // $FF: renamed from: Mx android.support.v4.app.Fragment
      private final Fragment field_1296;
      protected f<SupportStreetViewPanoramaFragment.class_1069> akW;
      private final List<OnStreetViewPanoramaReadyCallback> alq = new ArrayList();
      // $FF: renamed from: nB android.app.Activity
      private Activity field_1297;

      class_1571(Fragment var1) {
         this.field_1296 = var1;
      }

      private void setActivity(Activity var1) {
         this.field_1297 = var1;
         this.method_2766();
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2761(f<SupportStreetViewPanoramaFragment.class_1069> var1) {
         this.akW = var1;
         this.method_2766();
      }

      public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback var1) {
         if(this.je() != null) {
            ((SupportStreetViewPanoramaFragment.class_1069)this.je()).getStreetViewPanoramaAsync(var1);
         } else {
            this.alq.add(var1);
         }
      }

      // $FF: renamed from: nO () void
      public void method_2766() {
         // $FF: Couldn't be decompiled
      }
   }
}
