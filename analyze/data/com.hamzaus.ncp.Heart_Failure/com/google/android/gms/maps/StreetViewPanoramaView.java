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
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.class_590;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView extends FrameLayout {
   // $FF: renamed from: ZQ com.google.android.gms.maps.StreetViewPanorama
   private StreetViewPanorama field_2049;
   // $FF: renamed from: ZZ com.google.android.gms.maps.StreetViewPanoramaView$a
   private final StreetViewPanoramaView.class_860 field_2050;

   public StreetViewPanoramaView(Context var1) {
      super(var1);
      this.field_2050 = new StreetViewPanoramaView.class_860(this, var1, (StreetViewPanoramaOptions)null);
   }

   public StreetViewPanoramaView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.field_2050 = new StreetViewPanoramaView.class_860(this, var1, (StreetViewPanoramaOptions)null);
   }

   public StreetViewPanoramaView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.field_2050 = new StreetViewPanoramaView.class_860(this, var1, (StreetViewPanoramaOptions)null);
   }

   public StreetViewPanoramaView(Context var1, StreetViewPanoramaOptions var2) {
      super(var1);
      this.field_2050 = new StreetViewPanoramaView.class_860(this, var1, var2);
   }

   public final StreetViewPanorama getStreetViewPanorama() {
      if(this.field_2049 != null) {
         return this.field_2049;
      } else {
         this.field_2050.method_2442();
         if(this.field_2050.gC() == null) {
            return null;
         } else {
            try {
               this.field_2049 = new StreetViewPanorama(((StreetViewPanoramaView.class_861)this.field_2050.gC()).method_2748().getStreetViewPanorama());
            } catch (RemoteException var2) {
               throw new RuntimeRemoteException(var2);
            }

            return this.field_2049;
         }
      }
   }

   public final void onCreate(Bundle var1) {
      this.field_2050.onCreate(var1);
      if(this.field_2050.gC() == null) {
         StreetViewPanoramaView.class_860 var10000 = this.field_2050;
         StreetViewPanoramaView.class_860.b(this);
      }

   }

   public final void onDestroy() {
      this.field_2050.onDestroy();
   }

   public final void onLowMemory() {
      this.field_2050.onLowMemory();
   }

   public final void onPause() {
      this.field_2050.onPause();
   }

   public final void onResume() {
      this.field_2050.onResume();
   }

   public final void onSaveInstanceState(Bundle var1) {
      this.field_2050.onSaveInstanceState(var1);
   }

   static class class_860 extends a<StreetViewPanoramaView.class_861> {
      // $FF: renamed from: ZC com.google.android.gms.dynamic.f
      protected f<StreetViewPanoramaView.class_861> field_1701;
      // $FF: renamed from: ZH android.view.ViewGroup
      private final ViewGroup field_1702;
      private final StreetViewPanoramaOptions aaa;
      private final Context mContext;

      class_860(ViewGroup var1, Context var2, StreetViewPanoramaOptions var3) {
         this.field_1702 = var1;
         this.mContext = var2;
         this.aaa = var3;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2434(f<StreetViewPanoramaView.class_861> var1) {
         this.field_1701 = var1;
         this.method_2442();
      }

      // $FF: renamed from: ju () void
      public void method_2442() {
         if(this.field_1701 != null && this.gC() == null) {
            try {
               IStreetViewPanoramaViewDelegate var3 = class_590.method_3324(this.mContext).method_604(class_741.method_4178(this.mContext), this.aaa);
               this.field_1701.method_868(new StreetViewPanoramaView.class_861(this.field_1702, var3));
            } catch (RemoteException var4) {
               throw new RuntimeRemoteException(var4);
            } catch (GooglePlayServicesNotAvailableException var5) {
               return;
            }
         }

      }
   }

   static class class_861 implements LifecycleDelegate {
      // $FF: renamed from: ZE android.view.ViewGroup
      private final ViewGroup field_2661;
      private final IStreetViewPanoramaViewDelegate aab;
      private View aac;

      public class_861(ViewGroup var1, IStreetViewPanoramaViewDelegate var2) {
         this.aab = (IStreetViewPanoramaViewDelegate)class_347.method_2170(var2);
         this.field_2661 = (ViewGroup)class_347.method_2170(var1);
      }

      // $FF: renamed from: jB () com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate
      public IStreetViewPanoramaViewDelegate method_2748() {
         return this.aab;
      }

      public void onCreate(Bundle var1) {
         try {
            this.aab.onCreate(var1);
            this.aac = (View)class_741.method_4177(this.aab.getView());
            this.field_2661.removeAllViews();
            this.field_2661.addView(this.aac);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
      }

      public void onDestroy() {
         try {
            this.aab.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
      }

      public void onLowMemory() {
         try {
            this.aab.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.aab.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.aab.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.aab.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public void onStart() {
      }

      public void onStop() {
      }
   }
}
