package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
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

public class StreetViewPanoramaFragment extends Fragment {
   private final StreetViewPanoramaFragment.class_1709 all = new StreetViewPanoramaFragment.class_1709(this);
   private StreetViewPanorama alm;

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

   @Deprecated
   public final StreetViewPanorama getStreetViewPanorama() {
      IStreetViewPanoramaFragmentDelegate var1 = this.method_5768();
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
      this.all.getStreetViewPanoramaAsync(var1);
   }

   // $FF: renamed from: nR () com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
   protected IStreetViewPanoramaFragmentDelegate method_5768() {
      this.all.method_2764();
      return this.all.je() == null?null:((StreetViewPanoramaFragment.class_1708)this.all.je()).method_5869();
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.all.setActivity(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.all.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.all.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      this.all.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.all.onDestroyView();
      super.onDestroyView();
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.all.setActivity(var1);
      Bundle var4 = new Bundle();
      this.all.onInflate(var1, var4, var3);
   }

   public void onLowMemory() {
      this.all.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.all.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.all.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.all.onSaveInstanceState(var1);
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   static class class_1708 implements StreetViewLifecycleDelegate {
      // $FF: renamed from: TG android.app.Fragment
      private final Fragment field_4520;
      private final IStreetViewPanoramaFragmentDelegate aln;

      public class_1708(Fragment var1, IStreetViewPanoramaFragmentDelegate var2) {
         this.aln = (IStreetViewPanoramaFragmentDelegate)class_335.method_2311(var2);
         this.field_4520 = (Fragment)class_335.method_2311(var1);
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
      public IStreetViewPanoramaFragmentDelegate method_5869() {
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

   static class class_1709 extends a<StreetViewPanoramaFragment.class_1708> {
      // $FF: renamed from: TG android.app.Fragment
      private final Fragment field_1294;
      protected f<StreetViewPanoramaFragment.class_1708> akW;
      private final List<OnStreetViewPanoramaReadyCallback> alq = new ArrayList();
      // $FF: renamed from: nB android.app.Activity
      private Activity field_1295;

      class_1709(Fragment var1) {
         this.field_1294 = var1;
      }

      private void setActivity(Activity var1) {
         this.field_1295 = var1;
         this.method_2764();
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2761(f<StreetViewPanoramaFragment.class_1708> var1) {
         this.akW = var1;
         this.method_2764();
      }

      public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback var1) {
         if(this.je() != null) {
            ((StreetViewPanoramaFragment.class_1708)this.je()).getStreetViewPanoramaAsync(var1);
         } else {
            this.alq.add(var1);
         }
      }

      // $FF: renamed from: nO () void
      public void method_2764() {
         // $FF: Couldn't be decompiled
      }
   }
}
