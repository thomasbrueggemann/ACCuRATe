package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.class_590;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
   // $FF: renamed from: ZA com.google.android.gms.maps.GoogleMap
   private GoogleMap field_3368;
   // $FF: renamed from: ZD com.google.android.gms.maps.MapView$b
   private final MapView.class_862 field_3369;

   public MapView(Context var1) {
      super(var1);
      this.field_3369 = new MapView.class_862(this, var1, (GoogleMapOptions)null);
   }

   public MapView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.field_3369 = new MapView.class_862(this, var1, GoogleMapOptions.createFromAttributes(var1, var2));
   }

   public MapView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.field_3369 = new MapView.class_862(this, var1, GoogleMapOptions.createFromAttributes(var1, var2));
   }

   public MapView(Context var1, GoogleMapOptions var2) {
      super(var1);
      this.field_3369 = new MapView.class_862(this, var1, var2);
   }

   public final GoogleMap getMap() {
      if(this.field_3368 != null) {
         return this.field_3368;
      } else {
         this.field_3369.method_2443();
         if(this.field_3369.gC() == null) {
            return null;
         } else {
            try {
               this.field_3368 = new GoogleMap(((MapView.class_865)this.field_3369.gC()).method_2682().getMap());
            } catch (RemoteException var2) {
               throw new RuntimeRemoteException(var2);
            }

            return this.field_3368;
         }
      }
   }

   public final void onCreate(Bundle var1) {
      this.field_3369.onCreate(var1);
      if(this.field_3369.gC() == null) {
         MapView.class_862 var10000 = this.field_3369;
         MapView.class_862.b(this);
      }

   }

   public final void onDestroy() {
      this.field_3369.onDestroy();
   }

   public final void onLowMemory() {
      this.field_3369.onLowMemory();
   }

   public final void onPause() {
      this.field_3369.onPause();
   }

   public final void onResume() {
      this.field_3369.onResume();
   }

   public final void onSaveInstanceState(Bundle var1) {
      this.field_3369.onSaveInstanceState(var1);
   }

   static class class_865 implements LifecycleDelegate {
      // $FF: renamed from: ZE android.view.ViewGroup
      private final ViewGroup field_2053;
      // $FF: renamed from: ZF com.google.android.gms.maps.internal.IMapViewDelegate
      private final IMapViewDelegate field_2054;
      // $FF: renamed from: ZG android.view.View
      private View field_2055;

      public class_865(ViewGroup var1, IMapViewDelegate var2) {
         this.field_2054 = (IMapViewDelegate)class_347.method_2170(var2);
         this.field_2053 = (ViewGroup)class_347.method_2170(var1);
      }

      // $FF: renamed from: jv () com.google.android.gms.maps.internal.IMapViewDelegate
      public IMapViewDelegate method_2682() {
         return this.field_2054;
      }

      public void onCreate(Bundle var1) {
         try {
            this.field_2054.onCreate(var1);
            this.field_2055 = (View)class_741.method_4177(this.field_2054.getView());
            this.field_2053.removeAllViews();
            this.field_2053.addView(this.field_2055);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
      }

      public void onDestroy() {
         try {
            this.field_2054.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
      }

      public void onLowMemory() {
         try {
            this.field_2054.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.field_2054.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.field_2054.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.field_2054.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public void onStart() {
      }

      public void onStop() {
      }
   }

   static class class_862 extends a<MapView.class_865> {
      // $FF: renamed from: ZC com.google.android.gms.dynamic.f
      protected f<MapView.class_865> field_1703;
      // $FF: renamed from: ZH android.view.ViewGroup
      private final ViewGroup field_1704;
      // $FF: renamed from: ZI com.google.android.gms.maps.GoogleMapOptions
      private final GoogleMapOptions field_1705;
      private final Context mContext;

      class_862(ViewGroup var1, Context var2, GoogleMapOptions var3) {
         this.field_1704 = var1;
         this.mContext = var2;
         this.field_1705 = var3;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2434(f<MapView.class_865> var1) {
         this.field_1703 = var1;
         this.method_2443();
      }

      // $FF: renamed from: ju () void
      public void method_2443() {
         if(this.field_1703 != null && this.gC() == null) {
            try {
               IMapViewDelegate var3 = class_590.method_3324(this.mContext).method_603(class_741.method_4178(this.mContext), this.field_1705);
               this.field_1703.method_868(new MapView.class_865(this.field_1704, var3));
            } catch (RemoteException var4) {
               throw new RuntimeRemoteException(var4);
            } catch (GooglePlayServicesNotAvailableException var5) {
               return;
            }
         }

      }
   }
}
