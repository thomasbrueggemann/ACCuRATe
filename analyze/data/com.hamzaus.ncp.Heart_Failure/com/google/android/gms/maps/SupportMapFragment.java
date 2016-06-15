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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.class_590;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment extends Fragment {
   // $FF: renamed from: ZA com.google.android.gms.maps.GoogleMap
   private GoogleMap field_3104;
   private final SupportMapFragment.class_841 aad = new SupportMapFragment.class_841(this);

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

   public final GoogleMap getMap() {
      IMapFragmentDelegate var1 = this.method_3288();
      if(var1 != null) {
         IGoogleMapDelegate var3;
         try {
            var3 = var1.getMap();
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }

         if(var3 != null) {
            if(this.field_3104 == null || this.field_3104.method_4232().asBinder() != var3.asBinder()) {
               this.field_3104 = new GoogleMap(var3);
            }

            return this.field_3104;
         }
      }

      return null;
   }

   // $FF: renamed from: jt () com.google.android.gms.maps.internal.IMapFragmentDelegate
   protected IMapFragmentDelegate method_3288() {
      this.aad.method_2445();
      return this.aad.gC() == null?null:((SupportMapFragment.class_840)this.aad.gC()).method_2424();
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(SupportMapFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.aad.setActivity(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.aad.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.aad.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      this.aad.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.aad.onDestroyView();
      super.onDestroyView();
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.aad.setActivity(var1);
      GoogleMapOptions var4 = GoogleMapOptions.createFromAttributes(var1, var2);
      Bundle var5 = new Bundle();
      var5.putParcelable("MapOptions", var4);
      this.aad.onInflate(var1, var5, var3);
   }

   public void onLowMemory() {
      this.aad.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.aad.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.aad.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(SupportMapFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.aad.onSaveInstanceState(var1);
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   static class class_840 implements LifecycleDelegate {
      // $FF: renamed from: FS android.support.v4.app.Fragment
      private final Fragment field_1681;
      // $FF: renamed from: ZB com.google.android.gms.maps.internal.IMapFragmentDelegate
      private final IMapFragmentDelegate field_1682;

      public class_840(Fragment var1, IMapFragmentDelegate var2) {
         this.field_1682 = (IMapFragmentDelegate)class_347.method_2170(var2);
         this.field_1681 = (Fragment)class_347.method_2170(var1);
      }

      // $FF: renamed from: jt () com.google.android.gms.maps.internal.IMapFragmentDelegate
      public IMapFragmentDelegate method_2424() {
         return this.field_1682;
      }

      public void onCreate(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         class_157 var5;
         try {
            var5 = this.field_1682.onCreateView(class_741.method_4178(var1), class_741.method_4178(var2), var3);
         } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
         }

         return (View)class_741.method_4177(var5);
      }

      public void onDestroy() {
         try {
            this.field_1682.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         try {
            this.field_1682.onDestroyView();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         GoogleMapOptions var4 = (GoogleMapOptions)var2.getParcelable("MapOptions");

         try {
            this.field_1682.onInflate(class_741.method_4178(var1), var4, var3);
         } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
         }
      }

      public void onLowMemory() {
         try {
            this.field_1682.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.field_1682.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.field_1682.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.field_1682.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public void onStart() {
      }

      public void onStop() {
      }
   }

   static class class_841 extends a<SupportMapFragment.class_840> {
      // $FF: renamed from: FS android.support.v4.app.Fragment
      private final Fragment field_1706;
      // $FF: renamed from: ZC com.google.android.gms.dynamic.f
      protected f<SupportMapFragment.class_840> field_1707;
      // $FF: renamed from: oe android.app.Activity
      private Activity field_1708;

      class_841(Fragment var1) {
         this.field_1706 = var1;
      }

      private void setActivity(Activity var1) {
         this.field_1708 = var1;
         this.method_2445();
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2434(f<SupportMapFragment.class_840> var1) {
         this.field_1707 = var1;
         this.method_2445();
      }

      // $FF: renamed from: ju () void
      public void method_2445() {
         if(this.field_1708 != null && this.field_1707 != null && this.gC() == null) {
            try {
               MapsInitializer.initialize(this.field_1708);
               IMapFragmentDelegate var4 = class_590.method_3324(this.field_1708).method_607(class_741.method_4178(this.field_1708));
               this.field_1707.method_868(new SupportMapFragment.class_840(this.field_1706, var4));
            } catch (RemoteException var5) {
               throw new RuntimeRemoteException(var5);
            } catch (GooglePlayServicesNotAvailableException var6) {
               return;
            }
         }

      }
   }
}
