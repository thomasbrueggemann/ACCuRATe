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

public class MapFragment extends Fragment {
   private final MapFragment.class_1333 akR = new MapFragment.class_1333(this);
   private GoogleMap akS;

   public static MapFragment newInstance() {
      return new MapFragment();
   }

   public static MapFragment newInstance(GoogleMapOptions var0) {
      MapFragment var1 = new MapFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("MapOptions", var0);
      var1.setArguments(var2);
      return var1;
   }

   @Deprecated
   public final GoogleMap getMap() {
      IMapFragmentDelegate var1 = this.method_5642();
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
      this.akR.getMapAsync(var1);
   }

   // $FF: renamed from: nN () com.google.android.gms.maps.internal.IMapFragmentDelegate
   protected IMapFragmentDelegate method_5642() {
      this.akR.method_2768();
      return this.akR.je() == null?null:((MapFragment.class_1332)this.akR.je()).method_3410();
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(MapFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.akR.setActivity(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.akR.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.akR.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      this.akR.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.akR.onDestroyView();
      super.onDestroyView();
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.akR.setActivity(var1);
      GoogleMapOptions var4 = GoogleMapOptions.createFromAttributes(var1, var2);
      Bundle var5 = new Bundle();
      var5.putParcelable("MapOptions", var4);
      this.akR.onInflate(var1, var5, var3);
   }

   public void onLowMemory() {
      this.akR.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.akR.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.akR.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(MapFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.akR.onSaveInstanceState(var1);
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   static class class_1332 implements MapLifecycleDelegate {
      // $FF: renamed from: TG android.app.Fragment
      private final Fragment field_2601;
      private final IMapFragmentDelegate akT;

      public class_1332(Fragment var1, IMapFragmentDelegate var2) {
         this.akT = (IMapFragmentDelegate)class_335.method_2311(var2);
         this.field_2601 = (Fragment)class_335.method_2311(var1);
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
      public IMapFragmentDelegate method_3410() {
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

   static class class_1333 extends a<MapFragment.class_1332> {
      // $FF: renamed from: TG android.app.Fragment
      private final Fragment field_1298;
      protected f<MapFragment.class_1332> akW;
      private final List<OnMapReadyCallback> akX = new ArrayList();
      // $FF: renamed from: nB android.app.Activity
      private Activity field_1299;

      class_1333(Fragment var1) {
         this.field_1298 = var1;
      }

      private void setActivity(Activity var1) {
         this.field_1299 = var1;
         this.method_2768();
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2761(f<MapFragment.class_1332> var1) {
         this.akW = var1;
         this.method_2768();
      }

      public void getMapAsync(OnMapReadyCallback var1) {
         if(this.je() != null) {
            ((MapFragment.class_1332)this.je()).getMapAsync(var1);
         } else {
            this.akX.add(var1);
         }
      }

      // $FF: renamed from: nO () void
      public void method_2768() {
         // $FF: Couldn't be decompiled
      }
   }
}
