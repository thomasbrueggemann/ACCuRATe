package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzo;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
@Instrumented
public class MapFragment extends Fragment implements TraceFieldInterface {
   private final MapFragment.zzb zzaSc = new MapFragment.zzb(this);
   private GoogleMap zzaSd;

   @Deprecated
   public final GoogleMap getMap() {
      IMapFragmentDelegate var1 = this.zzzV();
      if(var1 != null) {
         IGoogleMapDelegate var3;
         try {
            var3 = var1.getMap();
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }

         if(var3 != null) {
            if(this.zzaSd == null || this.zzaSd.zzzJ().asBinder() != var3.asBinder()) {
               this.zzaSd = new GoogleMap(var3);
            }

            return this.zzaSd;
         }
      }

      return null;
   }

   public void getMapAsync(OnMapReadyCallback var1) {
      zzx.zzcD("getMapAsync must be called on the main thread.");
      this.zzaSc.getMapAsync(var1);
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(MapFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.zzaSc.setActivity(var1);
   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public View onCreateView(LayoutInflater param1, ViewGroup param2, Bundle param3) {
      // $FF: Couldn't be decompiled
   }

   public void onDestroy() {
      this.zzaSc.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.zzaSc.onDestroyView();
      super.onDestroyView();
   }

   @SuppressLint({"NewApi"})
   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.zzaSc.setActivity(var1);
      GoogleMapOptions var4 = GoogleMapOptions.createFromAttributes(var1, var2);
      Bundle var5 = new Bundle();
      var5.putParcelable("MapOptions", var4);
      this.zzaSc.onInflate(var1, var5, var3);
   }

   public void onLowMemory() {
      this.zzaSc.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.zzaSc.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.zzaSc.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(MapFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.zzaSc.onSaveInstanceState(var1);
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   protected IMapFragmentDelegate zzzV() {
      this.zzaSc.zzzW();
      return this.zzaSc.zztU() == null?null:((MapFragment.zza)this.zzaSc.zztU()).zzzV();
   }

   static class zza implements MapLifecycleDelegate {
      private final IMapFragmentDelegate zzaSe;
      private final Fragment zzavH;

      public zza(Fragment var1, IMapFragmentDelegate var2) {
         this.zzaSe = (IMapFragmentDelegate)zzx.zzz(var2);
         this.zzavH = (Fragment)zzx.zzz(var1);
      }

      public void getMapAsync(final OnMapReadyCallback var1) {
         try {
            this.zzaSe.getMapAsync(new zzo.zza() {
               public void zza(IGoogleMapDelegate var1x) throws RemoteException {
                  var1.onMapReady(new GoogleMap(var1x));
               }
            });
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public void onCreate(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         zzd var5;
         try {
            var5 = this.zzaSe.onCreateView(zze.zzC(var1), zze.zzC(var2), var3);
         } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
         }

         return (View)zze.zzp(var5);
      }

      public void onDestroy() {
         try {
            this.zzaSe.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         try {
            this.zzaSe.onDestroyView();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         GoogleMapOptions var4 = (GoogleMapOptions)var2.getParcelable("MapOptions");

         try {
            this.zzaSe.onInflate(zze.zzC(var1), var4, var3);
         } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
         }
      }

      public void onLowMemory() {
         try {
            this.zzaSe.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.zzaSe.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.zzaSe.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.zzaSe.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }

      public IMapFragmentDelegate zzzV() {
         return this.zzaSe;
      }
   }

   static class zzb extends com.google.android.gms.dynamic.zza<MapFragment.zza> {
      private Activity mActivity;
      protected zzf<MapFragment.zza> zzaSh;
      private final List<OnMapReadyCallback> zzaSi = new ArrayList();
      private final Fragment zzavH;

      zzb(Fragment var1) {
         this.zzavH = var1;
      }

      private void setActivity(Activity var1) {
         this.mActivity = var1;
         this.zzzW();
      }

      public void getMapAsync(OnMapReadyCallback var1) {
         if(this.zztU() != null) {
            ((MapFragment.zza)this.zztU()).getMapAsync(var1);
         } else {
            this.zzaSi.add(var1);
         }
      }

      protected void zza(zzf<MapFragment.zza> var1) {
         this.zzaSh = var1;
         this.zzzW();
      }

      public void zzzW() {
         // $FF: Couldn't be decompiled
      }
   }
}
