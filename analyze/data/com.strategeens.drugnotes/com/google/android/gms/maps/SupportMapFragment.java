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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.class_103;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {
   private GoogleMap akS;
   private final SupportMapFragment.class_1135 alD = new SupportMapFragment.class_1135(this);

   public static SupportMapFragment newInstance() {
      return new SupportMapFragment();
   }

   public static SupportMapFragment newInstance(GoogleMapOptions var0) {
      SupportMapFragment var1 = new SupportMapFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("MapOptions", var0);
      var1.setArguments(var2);
      return var1;
   }

   @Deprecated
   public final GoogleMap getMap() {
      IMapFragmentDelegate var1 = this.method_3923();
      if(var1 != null) {
         IGoogleMapDelegate var3;
         try {
            var3 = var1.getMap();
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }

         if(var3 != null) {
            if(this.akS == null || this.akS.method_5339().asBinder() != var3.asBinder()) {
               this.akS = new GoogleMap(var3);
            }

            return this.akS;
         }
      }

      return null;
   }

   public void getMapAsync(OnMapReadyCallback var1) {
      class_335.method_2304("getMapAsync must be called on the main thread.");
      this.alD.getMapAsync(var1);
   }

   // $FF: renamed from: nN () com.google.android.gms.maps.internal.IMapFragmentDelegate
   protected IMapFragmentDelegate method_3923() {
      this.alD.method_2772();
      return this.alD.je() == null?null:((SupportMapFragment.class_1134)this.alD.je()).method_2747();
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(SupportMapFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.alD.setActivity(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.alD.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.alD.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      this.alD.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.alD.onDestroyView();
      super.onDestroyView();
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.alD.setActivity(var1);
      GoogleMapOptions var4 = GoogleMapOptions.createFromAttributes(var1, var2);
      Bundle var5 = new Bundle();
      var5.putParcelable("MapOptions", var4);
      this.alD.onInflate(var1, var5, var3);
   }

   public void onLowMemory() {
      this.alD.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.alD.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.alD.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(SupportMapFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.alD.onSaveInstanceState(var1);
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   static class class_1134 implements MapLifecycleDelegate {
      // $FF: renamed from: Mx android.support.v4.app.Fragment
      private final Fragment field_1288;
      private final IMapFragmentDelegate akT;

      public class_1134(Fragment var1, IMapFragmentDelegate var2) {
         this.akT = (IMapFragmentDelegate)class_335.method_2311(var2);
         this.field_1288 = (Fragment)class_335.method_2311(var1);
      }

      public void getMapAsync(final OnMapReadyCallback var1) {
         try {
            this.akT.getMapAsync(new class_103.class_1497() {
               // $FF: renamed from: a (com.google.android.gms.maps.internal.IGoogleMapDelegate) void
               public void method_644(IGoogleMapDelegate var1x) throws RemoteException {
                  var1.onMapReady(new GoogleMap(var1x));
               }
            });
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      // $FF: renamed from: nN () com.google.android.gms.maps.internal.IMapFragmentDelegate
      public IMapFragmentDelegate method_2747() {
         return this.akT;
      }

      public void onCreate(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         class_198 var5;
         try {
            var5 = this.akT.onCreateView(class_960.method_5293(var1), class_960.method_5293(var2), var3);
         } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
         }

         return (View)class_960.method_5292(var5);
      }

      public void onDestroy() {
         try {
            this.akT.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         try {
            this.akT.onDestroyView();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         GoogleMapOptions var4 = (GoogleMapOptions)var2.getParcelable("MapOptions");

         try {
            this.akT.onInflate(class_960.method_5293(var1), var4, var3);
         } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
         }
      }

      public void onLowMemory() {
         try {
            this.akT.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.akT.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.akT.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.akT.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public void onStart() {
      }

      public void onStop() {
      }
   }

   static class class_1135 extends a<SupportMapFragment.class_1134> {
      // $FF: renamed from: Mx android.support.v4.app.Fragment
      private final Fragment field_1300;
      protected f<SupportMapFragment.class_1134> akW;
      private final List<OnMapReadyCallback> akX = new ArrayList();
      // $FF: renamed from: nB android.app.Activity
      private Activity field_1301;

      class_1135(Fragment var1) {
         this.field_1300 = var1;
      }

      private void setActivity(Activity var1) {
         this.field_1301 = var1;
         this.method_2772();
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2761(f<SupportMapFragment.class_1134> var1) {
         this.akW = var1;
         this.method_2772();
      }

      public void getMapAsync(OnMapReadyCallback var1) {
         if(this.je() != null) {
            ((SupportMapFragment.class_1134)this.je()).getMapAsync(var1);
         } else {
            this.akX.add(var1);
         }
      }

      // $FF: renamed from: nO () void
      public void method_2772() {
         // $FF: Couldn't be decompiled
      }
   }
}
