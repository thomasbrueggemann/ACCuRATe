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
import com.google.android.gms.class_482;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.dynamic.class_980;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.class_157;
import com.google.android.gms.internal.class_158;
import com.google.android.gms.internal.class_213;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public final class SupportWalletFragment extends Fragment {
   // $FF: renamed from: Mx android.support.v4.app.Fragment
   private final Fragment field_3060 = this;
   private SupportWalletFragment.class_1537 awa;
   private final class_980 awb = class_980.method_5472(this);
   private final SupportWalletFragment.class_1538 awc = new SupportWalletFragment.class_1538();
   private SupportWalletFragment.class_1536 awd = new SupportWalletFragment.class_1536(this);
   private WalletFragmentOptions awe;
   private WalletFragmentInitParams awf;
   private MaskedWalletRequest awg;
   private MaskedWallet awh;
   private Boolean awi;
   private boolean mCreated = false;

   public static SupportWalletFragment newInstance(WalletFragmentOptions var0) {
      SupportWalletFragment var1 = new SupportWalletFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("extraWalletFragmentOptions", var0);
      var1.field_3060.setArguments(var2);
      return var1;
   }

   public int getState() {
      return this.awa != null?this.awa.getState():0;
   }

   public void initialize(WalletFragmentInitParams var1) {
      if(this.awa != null) {
         this.awa.initialize(var1);
         this.awf = null;
      } else {
         if(this.awf != null) {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
            return;
         }

         this.awf = var1;
         if(this.awg != null) {
            Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
         }

         if(this.awh != null) {
            Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            return;
         }
      }

   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(this.awa != null) {
         this.awa.onActivityResult(var1, var2, var3);
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 != null) {
         var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
         WalletFragmentInitParams var3 = (WalletFragmentInitParams)var1.getParcelable("walletFragmentInitParams");
         if(var3 != null) {
            if(this.awf != null) {
               Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
            }

            this.awf = var3;
         }

         if(this.awg == null) {
            this.awg = (MaskedWalletRequest)var1.getParcelable("maskedWalletRequest");
         }

         if(this.awh == null) {
            this.awh = (MaskedWallet)var1.getParcelable("maskedWallet");
         }

         if(var1.containsKey("walletFragmentOptions")) {
            this.awe = (WalletFragmentOptions)var1.getParcelable("walletFragmentOptions");
         }

         if(var1.containsKey("enabled")) {
            this.awi = Boolean.valueOf(var1.getBoolean("enabled"));
         }
      } else if(this.field_3060.getArguments() != null) {
         WalletFragmentOptions var2 = (WalletFragmentOptions)this.field_3060.getArguments().getParcelable("extraWalletFragmentOptions");
         if(var2 != null) {
            var2.method_5708(this.field_3060.getActivity());
            this.awe = var2;
         }
      }

      this.mCreated = true;
      this.awc.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.awc.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      super.onDestroy();
      this.mCreated = false;
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      if(this.awe == null) {
         this.awe = WalletFragmentOptions.method_5704(var1, var2);
      }

      Bundle var4 = new Bundle();
      var4.putParcelable("attrKeyWalletFragmentOptions", this.awe);
      this.awc.onInflate(var1, var4, var3);
   }

   public void onPause() {
      super.onPause();
      this.awc.onPause();
   }

   public void onResume() {
      super.onResume();
      this.awc.onResume();
      FragmentManager var1 = this.field_3060.getActivity().getSupportFragmentManager();
      Fragment var2 = var1.findFragmentByTag("GooglePlayServicesErrorDialog");
      if(var2 != null) {
         var1.beginTransaction().remove(var2).commit();
         GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_3060.getActivity()), this.field_3060.getActivity(), -1);
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
      this.awc.onSaveInstanceState(var1);
      if(this.awf != null) {
         var1.putParcelable("walletFragmentInitParams", this.awf);
         this.awf = null;
      }

      if(this.awg != null) {
         var1.putParcelable("maskedWalletRequest", this.awg);
         this.awg = null;
      }

      if(this.awh != null) {
         var1.putParcelable("maskedWallet", this.awh);
         this.awh = null;
      }

      if(this.awe != null) {
         var1.putParcelable("walletFragmentOptions", this.awe);
         this.awe = null;
      }

      if(this.awi != null) {
         var1.putBoolean("enabled", this.awi.booleanValue());
         this.awi = null;
      }

   }

   public void onStart() {
      super.onStart();
      this.awc.onStart();
   }

   public void onStop() {
      super.onStop();
      this.awc.onStop();
   }

   public void setEnabled(boolean var1) {
      if(this.awa != null) {
         this.awa.setEnabled(var1);
         this.awi = null;
      } else {
         this.awi = Boolean.valueOf(var1);
      }
   }

   public void setOnStateChangedListener(SupportWalletFragment.OnStateChangedListener var1) {
      this.awd.method_3067(var1);
   }

   public void updateMaskedWallet(MaskedWallet var1) {
      if(this.awa != null) {
         this.awa.updateMaskedWallet(var1);
         this.awh = null;
      } else {
         this.awh = var1;
      }
   }

   public void updateMaskedWalletRequest(MaskedWalletRequest var1) {
      if(this.awa != null) {
         this.awa.updateMaskedWalletRequest(var1);
         this.awg = null;
      } else {
         this.awg = var1;
      }
   }

   public interface OnStateChangedListener {
      void onStateChanged(SupportWalletFragment var1, int var2, int var3, Bundle var4);
   }

   static class class_1536 extends class_158.class_1193 {
      private SupportWalletFragment.OnStateChangedListener awj;
      private final SupportWalletFragment awk;

      class_1536(SupportWalletFragment var1) {
         this.awk = var1;
      }

      // $FF: renamed from: a (int, int, android.os.Bundle) void
      public void method_824(int var1, int var2, Bundle var3) {
         if(this.awj != null) {
            this.awj.onStateChanged(this.awk, var1, var2, var3);
         }

      }

      // $FF: renamed from: a (com.google.android.gms.wallet.fragment.SupportWalletFragment$OnStateChangedListener) void
      public void method_3067(SupportWalletFragment.OnStateChangedListener var1) {
         this.awj = var1;
      }
   }

   private static class class_1537 implements LifecycleDelegate {
      private final class_157 awl;

      private class_1537(class_157 var1) {
         this.awl = var1;
      }

      // $FF: synthetic method
      class_1537(class_157 var1, Object var2) {
         this(var1);
      }

      private int getState() {
         try {
            int var2 = this.awl.getState();
            return var2;
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void initialize(WalletFragmentInitParams var1) {
         try {
            this.awl.initialize(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void onActivityResult(int var1, int var2, Intent var3) {
         try {
            this.awl.onActivityResult(var1, var2, var3);
         } catch (RemoteException var5) {
            throw new RuntimeException(var5);
         }
      }

      private void setEnabled(boolean var1) {
         try {
            this.awl.setEnabled(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void updateMaskedWallet(MaskedWallet var1) {
         try {
            this.awl.updateMaskedWallet(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void updateMaskedWalletRequest(MaskedWalletRequest var1) {
         try {
            this.awl.updateMaskedWalletRequest(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      public void onCreate(Bundle var1) {
         try {
            this.awl.onCreate(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         try {
            View var5 = (View)class_960.method_5292(this.awl.onCreateView(class_960.method_5293(var1), class_960.method_5293(var2), var3));
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
            this.awl.method_823(class_960.method_5293(var1), var4, var3);
         } catch (RemoteException var6) {
            throw new RuntimeException(var6);
         }
      }

      public void onLowMemory() {
      }

      public void onPause() {
         try {
            this.awl.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onResume() {
         try {
            this.awl.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.awl.onSaveInstanceState(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      public void onStart() {
         try {
            this.awl.onStart();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onStop() {
         try {
            this.awl.onStop();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }
   }

   private class class_1538 extends a<SupportWalletFragment.class_1537> implements OnClickListener {
      private class_1538() {
      }

      // $FF: synthetic method
      class_1538(Object var2) {
         this();
      }

      // $FF: renamed from: a (android.widget.FrameLayout) void
      protected void method_2760(FrameLayout var1) {
         Button var2 = new Button(SupportWalletFragment.this.field_3060.getActivity());
         var2.setText(class_482.string.wallet_buy_button_place_holder);
         int var3 = -1;
         int var4 = -2;
         if(SupportWalletFragment.this.awe != null) {
            WalletFragmentStyle var5 = SupportWalletFragment.this.awe.getFragmentStyle();
            if(var5 != null) {
               DisplayMetrics var6 = SupportWalletFragment.this.field_3060.getResources().getDisplayMetrics();
               var3 = var5.method_5862("buyButtonWidth", var6, var3);
               var4 = var5.method_5862("buyButtonHeight", var6, var4);
            }
         }

         var2.setLayoutParams(new LayoutParams(var3, var4));
         var2.setOnClickListener(this);
         var1.addView(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
      protected void method_2761(f<SupportWalletFragment.class_1537> var1) {
         FragmentActivity var2 = SupportWalletFragment.this.field_3060.getActivity();
         if(SupportWalletFragment.this.awa == null && SupportWalletFragment.this.mCreated && var2 != null) {
            try {
               class_157 var4 = class_213.method_1514(var2, SupportWalletFragment.this.awb, SupportWalletFragment.this.awe, SupportWalletFragment.this.awd);
               SupportWalletFragment.this.awa = new SupportWalletFragment.class_1537(var4);
               SupportWalletFragment.this.awe = null;
            } catch (GooglePlayServicesNotAvailableException var5) {
               return;
            }

            var1.method_1066(SupportWalletFragment.this.awa);
            if(SupportWalletFragment.this.awf != null) {
               SupportWalletFragment.this.awa.initialize(SupportWalletFragment.this.awf);
               SupportWalletFragment.this.awf = null;
            }

            if(SupportWalletFragment.this.awg != null) {
               SupportWalletFragment.this.awa.updateMaskedWalletRequest(SupportWalletFragment.this.awg);
               SupportWalletFragment.this.awg = null;
            }

            if(SupportWalletFragment.this.awh != null) {
               SupportWalletFragment.this.awa.updateMaskedWallet(SupportWalletFragment.this.awh);
               SupportWalletFragment.this.awh = null;
            }

            if(SupportWalletFragment.this.awi != null) {
               SupportWalletFragment.this.awa.setEnabled(SupportWalletFragment.this.awi.booleanValue());
               SupportWalletFragment.this.awi = null;
            }
         }

      }

      public void onClick(View var1) {
         FragmentActivity var2 = SupportWalletFragment.this.field_3060.getActivity();
         GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var2), var2, -1);
      }
   }
}
