package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.class_443;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.dynamic.class_755;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.class_125;
import com.google.android.gms.internal.class_126;
import com.google.android.gms.internal.class_177;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public final class WalletFragment extends Fragment {
   // $FF: renamed from: Mg android.app.Fragment
   private final Fragment field_3664 = this;
   private WalletFragmentOptions akh;
   private WalletFragmentInitParams aki;
   private MaskedWalletRequest akj;
   private MaskedWallet akk;
   private Boolean akl;
   private WalletFragment.class_1283 akq;
   private final class_755 akr = class_755.method_4325(this);
   private final WalletFragment.class_1284 aks = new WalletFragment.class_1284();
   private WalletFragment.class_1282 akt = new WalletFragment.class_1282(this);
   private boolean mCreated = false;

   public static WalletFragment newInstance(WalletFragmentOptions var0) {
      WalletFragment var1 = new WalletFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("extraWalletFragmentOptions", var0);
      var1.field_3664.setArguments(var2);
      return var1;
   }

   public int getState() {
      return this.akq != null?this.akq.getState():0;
   }

   public void initialize(WalletFragmentInitParams var1) {
      if(this.akq != null) {
         this.akq.initialize(var1);
         this.aki = null;
      } else {
         if(this.aki != null) {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
            return;
         }

         this.aki = var1;
         if(this.akj != null) {
            Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
         }

         if(this.akk != null) {
            Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            return;
         }
      }

   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(this.akq != null) {
         this.akq.onActivityResult(var1, var2, var3);
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 != null) {
         var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
         WalletFragmentInitParams var3 = (WalletFragmentInitParams)var1.getParcelable("walletFragmentInitParams");
         if(var3 != null) {
            if(this.aki != null) {
               Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
            }

            this.aki = var3;
         }

         if(this.akj == null) {
            this.akj = (MaskedWalletRequest)var1.getParcelable("maskedWalletRequest");
         }

         if(this.akk == null) {
            this.akk = (MaskedWallet)var1.getParcelable("maskedWallet");
         }

         if(var1.containsKey("walletFragmentOptions")) {
            this.akh = (WalletFragmentOptions)var1.getParcelable("walletFragmentOptions");
         }

         if(var1.containsKey("enabled")) {
            this.akl = Boolean.valueOf(var1.getBoolean("enabled"));
         }
      } else if(this.field_3664.getArguments() != null) {
         WalletFragmentOptions var2 = (WalletFragmentOptions)this.field_3664.getArguments().getParcelable("extraWalletFragmentOptions");
         if(var2 != null) {
            var2.method_4484(this.field_3664.getActivity());
            this.akh = var2;
         }
      }

      this.mCreated = true;
      this.aks.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.aks.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      super.onDestroy();
      this.mCreated = false;
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      if(this.akh == null) {
         this.akh = WalletFragmentOptions.method_4480(var1, var2);
      }

      Bundle var4 = new Bundle();
      var4.putParcelable("attrKeyWalletFragmentOptions", this.akh);
      this.aks.onInflate(var1, var4, var3);
   }

   public void onPause() {
      super.onPause();
      this.aks.onPause();
   }

   public void onResume() {
      super.onResume();
      this.aks.onResume();
      FragmentManager var1 = this.field_3664.getActivity().getFragmentManager();
      Fragment var2 = var1.findFragmentByTag("GooglePlayServicesErrorDialog");
      if(var2 != null) {
         var1.beginTransaction().remove(var2).commit();
         GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_3664.getActivity()), this.field_3664.getActivity(), -1);
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
      this.aks.onSaveInstanceState(var1);
      if(this.aki != null) {
         var1.putParcelable("walletFragmentInitParams", this.aki);
         this.aki = null;
      }

      if(this.akj != null) {
         var1.putParcelable("maskedWalletRequest", this.akj);
         this.akj = null;
      }

      if(this.akk != null) {
         var1.putParcelable("maskedWallet", this.akk);
         this.akk = null;
      }

      if(this.akh != null) {
         var1.putParcelable("walletFragmentOptions", this.akh);
         this.akh = null;
      }

      if(this.akl != null) {
         var1.putBoolean("enabled", this.akl.booleanValue());
         this.akl = null;
      }

   }

   public void onStart() {
      super.onStart();
      this.aks.onStart();
   }

   public void onStop() {
      super.onStop();
      this.aks.onStop();
   }

   public void setEnabled(boolean var1) {
      if(this.akq != null) {
         this.akq.setEnabled(var1);
         this.akl = null;
      } else {
         this.akl = Boolean.valueOf(var1);
      }
   }

   public void setOnStateChangedListener(WalletFragment.OnStateChangedListener var1) {
      this.akt.method_3824(var1);
   }

   public void updateMaskedWallet(MaskedWallet var1) {
      if(this.akq != null) {
         this.akq.updateMaskedWallet(var1);
         this.akk = null;
      } else {
         this.akk = var1;
      }
   }

   public void updateMaskedWalletRequest(MaskedWalletRequest var1) {
      if(this.akq != null) {
         this.akq.updateMaskedWalletRequest(var1);
         this.akj = null;
      } else {
         this.akj = var1;
      }
   }

   public interface OnStateChangedListener {
      void onStateChanged(WalletFragment var1, int var2, int var3, Bundle var4);
   }

   static class class_1282 extends class_126.class_1024 {
      private WalletFragment.OnStateChangedListener aku;
      private final WalletFragment akv;

      class_1282(WalletFragment var1) {
         this.akv = var1;
      }

      // $FF: renamed from: a (int, int, android.os.Bundle) void
      public void method_685(int var1, int var2, Bundle var3) {
         if(this.aku != null) {
            this.aku.onStateChanged(this.akv, var1, var2, var3);
         }

      }

      // $FF: renamed from: a (com.google.android.gms.wallet.fragment.WalletFragment$OnStateChangedListener) void
      public void method_3824(WalletFragment.OnStateChangedListener var1) {
         this.aku = var1;
      }
   }

   private static class class_1283 implements LifecycleDelegate {
      private final class_125 ako;

      private class_1283(class_125 var1) {
         this.ako = var1;
      }

      // $FF: synthetic method
      class_1283(class_125 var1, Object var2) {
         this(var1);
      }

      private int getState() {
         try {
            int var2 = this.ako.getState();
            return var2;
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void initialize(WalletFragmentInitParams var1) {
         try {
            this.ako.initialize(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void onActivityResult(int var1, int var2, Intent var3) {
         try {
            this.ako.onActivityResult(var1, var2, var3);
         } catch (RemoteException var5) {
            throw new RuntimeException(var5);
         }
      }

      private void setEnabled(boolean var1) {
         try {
            this.ako.setEnabled(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void updateMaskedWallet(MaskedWallet var1) {
         try {
            this.ako.updateMaskedWallet(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void updateMaskedWalletRequest(MaskedWalletRequest var1) {
         try {
            this.ako.updateMaskedWalletRequest(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      public void onCreate(Bundle var1) {
         try {
            this.ako.onCreate(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         try {
            View var5 = (View)class_741.method_4177(this.ako.onCreateView(class_741.method_4178(var1), class_741.method_4178(var2), var3));
            return var5;
         } catch (RemoteException var6) {
            throw new RuntimeException(var6);
         }
      }

      public void onDestroy() {
      }

      public void onDestroyView() {
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         WalletFragmentOptions var4 = (WalletFragmentOptions)var2.getParcelable("extraWalletFragmentOptions");

         try {
            this.ako.method_684(class_741.method_4178(var1), var4, var3);
         } catch (RemoteException var6) {
            throw new RuntimeException(var6);
         }
      }

      public void onLowMemory() {
      }

      public void onPause() {
         try {
            this.ako.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onResume() {
         try {
            this.ako.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.ako.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      public void onStart() {
         try {
            this.ako.onStart();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onStop() {
         try {
            this.ako.onStop();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }
   }

   private class class_1284 extends a<WalletFragment.class_1283> implements OnClickListener {
      private class_1284() {
      }

      // $FF: synthetic method
      class_1284(Object var2) {
         this();
      }

      // $FF: renamed from: a (android.widget.FrameLayout) void
      protected void method_2433(FrameLayout var1) {
         Button var2 = new Button(WalletFragment.this.field_3664.getActivity());
         var2.setText(class_443.string.wallet_buy_button_place_holder);
         int var3 = -1;
         int var4 = -2;
         if(WalletFragment.this.akh != null) {
            WalletFragmentStyle var5 = WalletFragment.this.akh.getFragmentStyle();
            if(var5 != null) {
               DisplayMetrics var6 = WalletFragment.this.field_3664.getResources().getDisplayMetrics();
               var3 = var5.method_4601("buyButtonWidth", var6, var3);
               var4 = var5.method_4601("buyButtonHeight", var6, var4);
            }
         }

         var2.setLayoutParams(new LayoutParams(var3, var4));
         var2.setOnClickListener(this);
         var1.addView(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2434(f<WalletFragment.class_1283> var1) {
         Activity var2 = WalletFragment.this.field_3664.getActivity();
         if(WalletFragment.this.akq == null && WalletFragment.this.mCreated && var2 != null) {
            try {
               class_125 var4 = class_177.method_1278(var2, WalletFragment.this.akr, WalletFragment.this.akh, WalletFragment.this.akt);
               WalletFragment.this.akq = new WalletFragment.class_1283(var4);
               WalletFragment.this.akh = null;
            } catch (GooglePlayServicesNotAvailableException var5) {
               return;
            }

            var1.method_868(WalletFragment.this.akq);
            if(WalletFragment.this.aki != null) {
               WalletFragment.this.akq.initialize(WalletFragment.this.aki);
               WalletFragment.this.aki = null;
            }

            if(WalletFragment.this.akj != null) {
               WalletFragment.this.akq.updateMaskedWalletRequest(WalletFragment.this.akj);
               WalletFragment.this.akj = null;
            }

            if(WalletFragment.this.akk != null) {
               WalletFragment.this.akq.updateMaskedWallet(WalletFragment.this.akk);
               WalletFragment.this.akk = null;
            }

            if(WalletFragment.this.akl != null) {
               WalletFragment.this.akq.setEnabled(WalletFragment.this.akl.booleanValue());
               WalletFragment.this.akl = null;
            }
         }

      }

      public void onClick(View var1) {
         Activity var2 = WalletFragment.this.field_3664.getActivity();
         GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var2), var2, -1);
      }
   }
}
