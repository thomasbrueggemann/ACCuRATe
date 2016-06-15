package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
import com.google.android.gms.dynamic.class_756;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.class_125;
import com.google.android.gms.internal.class_126;
import com.google.android.gms.internal.class_177;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public final class SupportWalletFragment extends Fragment {
   // $FF: renamed from: FS android.support.v4.app.Fragment
   private final Fragment field_3111 = this;
   private SupportWalletFragment.class_1177 akd;
   private final class_756 ake = class_756.method_4326(this);
   private final SupportWalletFragment.class_1178 akf = new SupportWalletFragment.class_1178();
   private SupportWalletFragment.class_1176 akg = new SupportWalletFragment.class_1176(this);
   private WalletFragmentOptions akh;
   private WalletFragmentInitParams aki;
   private MaskedWalletRequest akj;
   private MaskedWallet akk;
   private Boolean akl;
   private boolean mCreated = false;

   public static SupportWalletFragment newInstance(WalletFragmentOptions var0) {
      SupportWalletFragment var1 = new SupportWalletFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("extraWalletFragmentOptions", var0);
      var1.field_3111.setArguments(var2);
      return var1;
   }

   public int getState() {
      return this.akd != null?this.akd.getState():0;
   }

   public void initialize(WalletFragmentInitParams var1) {
      if(this.akd != null) {
         this.akd.initialize(var1);
         this.aki = null;
      } else {
         if(this.aki != null) {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
            return;
         }

         this.aki = var1;
         if(this.akj != null) {
            Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
         }

         if(this.akk != null) {
            Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            return;
         }
      }

   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(this.akd != null) {
         this.akd.onActivityResult(var1, var2, var3);
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 != null) {
         var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
         WalletFragmentInitParams var3 = (WalletFragmentInitParams)var1.getParcelable("walletFragmentInitParams");
         if(var3 != null) {
            if(this.aki != null) {
               Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
      } else if(this.field_3111.getArguments() != null) {
         WalletFragmentOptions var2 = (WalletFragmentOptions)this.field_3111.getArguments().getParcelable("extraWalletFragmentOptions");
         if(var2 != null) {
            var2.method_4484(this.field_3111.getActivity());
            this.akh = var2;
         }
      }

      this.mCreated = true;
      this.akf.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.akf.onCreateView(var1, var2, var3);
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
      this.akf.onInflate(var1, var4, var3);
   }

   public void onPause() {
      super.onPause();
      this.akf.onPause();
   }

   public void onResume() {
      super.onResume();
      this.akf.onResume();
      FragmentManager var1 = this.field_3111.getActivity().getSupportFragmentManager();
      Fragment var2 = var1.findFragmentByTag("GooglePlayServicesErrorDialog");
      if(var2 != null) {
         var1.beginTransaction().remove(var2).commit();
         GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_3111.getActivity()), this.field_3111.getActivity(), -1);
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
      this.akf.onSaveInstanceState(var1);
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
      this.akf.onStart();
   }

   public void onStop() {
      super.onStop();
      this.akf.onStop();
   }

   public void setEnabled(boolean var1) {
      if(this.akd != null) {
         this.akd.setEnabled(var1);
         this.akl = null;
      } else {
         this.akl = Boolean.valueOf(var1);
      }
   }

   public void setOnStateChangedListener(SupportWalletFragment.OnStateChangedListener var1) {
      this.akg.method_3825(var1);
   }

   public void updateMaskedWallet(MaskedWallet var1) {
      if(this.akd != null) {
         this.akd.updateMaskedWallet(var1);
         this.akk = null;
      } else {
         this.akk = var1;
      }
   }

   public void updateMaskedWalletRequest(MaskedWalletRequest var1) {
      if(this.akd != null) {
         this.akd.updateMaskedWalletRequest(var1);
         this.akj = null;
      } else {
         this.akj = var1;
      }
   }

   public interface OnStateChangedListener {
      void onStateChanged(SupportWalletFragment var1, int var2, int var3, Bundle var4);
   }

   static class class_1176 extends class_126.class_1024 {
      private SupportWalletFragment.OnStateChangedListener akm;
      private final SupportWalletFragment akn;

      class_1176(SupportWalletFragment var1) {
         this.akn = var1;
      }

      // $FF: renamed from: a (int, int, android.os.Bundle) void
      public void method_685(int var1, int var2, Bundle var3) {
         if(this.akm != null) {
            this.akm.onStateChanged(this.akn, var1, var2, var3);
         }

      }

      // $FF: renamed from: a (com.google.android.gms.wallet.fragment.SupportWalletFragment$OnStateChangedListener) void
      public void method_3825(SupportWalletFragment.OnStateChangedListener var1) {
         this.akm = var1;
      }
   }

   private static class class_1177 implements LifecycleDelegate {
      private final class_125 ako;

      private class_1177(class_125 var1) {
         this.ako = var1;
      }

      // $FF: synthetic method
      class_1177(class_125 var1, Object var2) {
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

   private class class_1178 extends a<SupportWalletFragment.class_1177> implements OnClickListener {
      private class_1178() {
      }

      // $FF: synthetic method
      class_1178(Object var2) {
         this();
      }

      // $FF: renamed from: a (android.widget.FrameLayout) void
      protected void method_2433(FrameLayout var1) {
         Button var2 = new Button(SupportWalletFragment.this.field_3111.getActivity());
         var2.setText(class_443.string.wallet_buy_button_place_holder);
         int var3 = -1;
         int var4 = -2;
         if(SupportWalletFragment.this.akh != null) {
            WalletFragmentStyle var5 = SupportWalletFragment.this.akh.getFragmentStyle();
            if(var5 != null) {
               DisplayMetrics var6 = SupportWalletFragment.this.field_3111.getResources().getDisplayMetrics();
               var3 = var5.method_4601("buyButtonWidth", var6, var3);
               var4 = var5.method_4601("buyButtonHeight", var6, var4);
            }
         }

         var2.setLayoutParams(new LayoutParams(var3, var4));
         var2.setOnClickListener(this);
         var1.addView(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2434(f<SupportWalletFragment.class_1177> var1) {
         FragmentActivity var2 = SupportWalletFragment.this.field_3111.getActivity();
         if(SupportWalletFragment.this.akd == null && SupportWalletFragment.this.mCreated && var2 != null) {
            try {
               class_125 var4 = class_177.method_1278(var2, SupportWalletFragment.this.ake, SupportWalletFragment.this.akh, SupportWalletFragment.this.akg);
               SupportWalletFragment.this.akd = new SupportWalletFragment.class_1177(var4);
               SupportWalletFragment.this.akh = null;
            } catch (GooglePlayServicesNotAvailableException var5) {
               return;
            }

            var1.method_868(SupportWalletFragment.this.akd);
            if(SupportWalletFragment.this.aki != null) {
               SupportWalletFragment.this.akd.initialize(SupportWalletFragment.this.aki);
               SupportWalletFragment.this.aki = null;
            }

            if(SupportWalletFragment.this.akj != null) {
               SupportWalletFragment.this.akd.updateMaskedWalletRequest(SupportWalletFragment.this.akj);
               SupportWalletFragment.this.akj = null;
            }

            if(SupportWalletFragment.this.akk != null) {
               SupportWalletFragment.this.akd.updateMaskedWallet(SupportWalletFragment.this.akk);
               SupportWalletFragment.this.akk = null;
            }

            if(SupportWalletFragment.this.akl != null) {
               SupportWalletFragment.this.akd.setEnabled(SupportWalletFragment.this.akl.booleanValue());
               SupportWalletFragment.this.akl = null;
            }
         }

      }

      public void onClick(View var1) {
         FragmentActivity var2 = SupportWalletFragment.this.field_3111.getActivity();
         GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var2), var2, -1);
      }
   }
}
