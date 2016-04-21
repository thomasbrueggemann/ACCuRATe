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
import com.google.android.gms.class_492;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_1065;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.class_171;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_219;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public final class WalletFragment extends Fragment {
    // $FF: renamed from: Sj android.app.Fragment
    private final Fragment field_4531 = this;
    private WalletFragmentOptions atU;
    private WalletFragmentInitParams atV;
    private MaskedWalletRequest atW;
    private MaskedWallet atX;
    private Boolean atY;
    private WalletFragment.class_1768 aud;
    private final class_1065 aue = class_1065.method_5583(this);
    private final WalletFragment.class_1769 auf = new WalletFragment.class_1769();
    private WalletFragment.class_1767 aug = new WalletFragment.class_1767(this);
    private boolean mCreated = false;

    public static WalletFragment newInstance(WalletFragmentOptions var0) {
        WalletFragment var1 = new WalletFragment();
        Bundle var2 = new Bundle();
        var2.putParcelable("extraWalletFragmentOptions", var0);
        var1.field_4531.setArguments(var2);
        return var1;
    }

    public int getState() {
        return this.aud != null?this.aud.getState():0;
    }

    public void initialize(WalletFragmentInitParams var1) {
        if(this.aud != null) {
            this.aud.initialize(var1);
            this.atV = null;
        } else {
            if(this.atV != null) {
                Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
                return;
            }

            this.atV = var1;
            if(this.atW != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }

            if(this.atX != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
                return;
            }
        }

    }

    public void onActivityResult(int var1, int var2, Intent var3) {
        super.onActivityResult(var1, var2, var3);
        if(this.aud != null) {
            this.aud.onActivityResult(var1, var2, var3);
        }

    }

    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        if(var1 != null) {
            var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams var3 = (WalletFragmentInitParams)var1.getParcelable("walletFragmentInitParams");
            if(var3 != null) {
                if(this.atV != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }

                this.atV = var3;
            }

            if(this.atW == null) {
                this.atW = (MaskedWalletRequest)var1.getParcelable("maskedWalletRequest");
            }

            if(this.atX == null) {
                this.atX = (MaskedWallet)var1.getParcelable("maskedWallet");
            }

            if(var1.containsKey("walletFragmentOptions")) {
                this.atU = (WalletFragmentOptions)var1.getParcelable("walletFragmentOptions");
            }

            if(var1.containsKey("enabled")) {
                this.atY = Boolean.valueOf(var1.getBoolean("enabled"));
            }
        } else if(this.field_4531.getArguments() != null) {
            WalletFragmentOptions var2 = (WalletFragmentOptions)this.field_4531.getArguments().getParcelable("extraWalletFragmentOptions");
            if(var2 != null) {
                var2.method_5858(this.field_4531.getActivity());
                this.atU = var2;
            }
        }

        this.mCreated = true;
        this.auf.onCreate(var1);
    }

    public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        return this.auf.onCreateView(var1, var2, var3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
        super.onInflate(var1, var2, var3);
        if(this.atU == null) {
            this.atU = WalletFragmentOptions.method_5854(var1, var2);
        }

        Bundle var4 = new Bundle();
        var4.putParcelable("attrKeyWalletFragmentOptions", this.atU);
        this.auf.onInflate(var1, var4, var3);
    }

    public void onPause() {
        super.onPause();
        this.auf.onPause();
    }

    public void onResume() {
        super.onResume();
        this.auf.onResume();
        FragmentManager var1 = this.field_4531.getActivity().getFragmentManager();
        Fragment var2 = var1.findFragmentByTag("GooglePlayServicesErrorDialog");
        if(var2 != null) {
            var1.beginTransaction().remove(var2).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_4531.getActivity()), this.field_4531.getActivity(), -1);
        }

    }

    public void onSaveInstanceState(Bundle var1) {
        super.onSaveInstanceState(var1);
        var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.auf.onSaveInstanceState(var1);
        if(this.atV != null) {
            var1.putParcelable("walletFragmentInitParams", this.atV);
            this.atV = null;
        }

        if(this.atW != null) {
            var1.putParcelable("maskedWalletRequest", this.atW);
            this.atW = null;
        }

        if(this.atX != null) {
            var1.putParcelable("maskedWallet", this.atX);
            this.atX = null;
        }

        if(this.atU != null) {
            var1.putParcelable("walletFragmentOptions", this.atU);
            this.atU = null;
        }

        if(this.atY != null) {
            var1.putBoolean("enabled", this.atY.booleanValue());
            this.atY = null;
        }

    }

    public void onStart() {
        super.onStart();
        this.auf.onStart();
    }

    public void onStop() {
        super.onStop();
        this.auf.onStop();
    }

    public void setEnabled(boolean var1) {
        if(this.aud != null) {
            this.aud.setEnabled(var1);
            this.atY = null;
        } else {
            this.atY = Boolean.valueOf(var1);
        }
    }

    public void setOnStateChangedListener(WalletFragment.OnStateChangedListener var1) {
        this.aug.method_1643(var1);
    }

    public void updateMaskedWallet(MaskedWallet var1) {
        if(this.aud != null) {
            this.aud.updateMaskedWallet(var1);
            this.atX = null;
        } else {
            this.atX = var1;
        }
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest var1) {
        if(this.aud != null) {
            this.aud.updateMaskedWalletRequest(var1);
            this.atW = null;
        } else {
            this.atW = var1;
        }
    }

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment var1, int var2, int var3, Bundle var4);
    }

    static class class_1767 extends class_171.class_1162 {
        private WalletFragment.OnStateChangedListener auh;
        private final WalletFragment aui;

        class_1767(WalletFragment var1) {
            this.aui = var1;
        }

        // $FF: renamed from: a (int, int, android.os.Bundle) void
        public void method_816(int var1, int var2, Bundle var3) {
            if(this.auh != null) {
                this.auh.onStateChanged(this.aui, var1, var2, var3);
            }

        }

        // $FF: renamed from: a (com.google.android.gms.wallet.fragment.WalletFragment$OnStateChangedListener) void
        public void method_1643(WalletFragment.OnStateChangedListener var1) {
            this.auh = var1;
        }
    }

    private static class class_1768 implements LifecycleDelegate {
        private final class_172 aub;

        private class_1768(class_172 var1) {
            this.aub = var1;
        }

        // $FF: synthetic method
        class_1768(class_172 var1, Object var2) {
            this(var1);
        }

        private int getState() {
            try {
                int var2 = this.aub.getState();
                return var2;
            } catch (RemoteException var3) {
                throw new RuntimeException(var3);
            }
        }

        private void initialize(WalletFragmentInitParams var1) {
            try {
                this.aub.initialize(var1);
            } catch (RemoteException var3) {
                throw new RuntimeException(var3);
            }
        }

        private void onActivityResult(int var1, int var2, Intent var3) {
            try {
                this.aub.onActivityResult(var1, var2, var3);
            } catch (RemoteException var5) {
                throw new RuntimeException(var5);
            }
        }

        private void setEnabled(boolean var1) {
            try {
                this.aub.setEnabled(var1);
            } catch (RemoteException var3) {
                throw new RuntimeException(var3);
            }
        }

        private void updateMaskedWallet(MaskedWallet var1) {
            try {
                this.aub.updateMaskedWallet(var1);
            } catch (RemoteException var3) {
                throw new RuntimeException(var3);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest var1) {
            try {
                this.aub.updateMaskedWalletRequest(var1);
            } catch (RemoteException var3) {
                throw new RuntimeException(var3);
            }
        }

        public void onCreate(Bundle var1) {
            try {
                this.aub.onCreate(var1);
            } catch (RemoteException var3) {
                throw new RuntimeException(var3);
            }
        }

        public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
            try {
                View var5 = (View)class_1046.method_5436(this.aub.onCreateView(class_1046.method_5437(var1), class_1046.method_5437(var2), var3));
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
                this.aub.method_817(class_1046.method_5437(var1), var4, var3);
            } catch (RemoteException var6) {
                throw new RuntimeException(var6);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.aub.onPause();
            } catch (RemoteException var2) {
                throw new RuntimeException(var2);
            }
        }

        public void onResume() {
            try {
                this.aub.onResume();
            } catch (RemoteException var2) {
                throw new RuntimeException(var2);
            }
        }

        public void onSaveInstanceState(Bundle var1) {
            try {
                this.aub.onSaveInstanceState(var1);
            } catch (RemoteException var3) {
                throw new RuntimeException(var3);
            }
        }

        public void onStart() {
            try {
                this.aub.onStart();
            } catch (RemoteException var2) {
                throw new RuntimeException(var2);
            }
        }

        public void onStop() {
            try {
                this.aub.onStop();
            } catch (RemoteException var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    private class class_1769 extends a<WalletFragment.class_1768> implements OnClickListener {
        private class_1769() {
        }

        // $FF: synthetic method
        class_1769(Object var2) {
            this();
        }

        // $FF: renamed from: a (android.widget.FrameLayout) void
        protected void method_2705(FrameLayout var1) {
            Button var2 = new Button(WalletFragment.this.field_4531.getActivity());
            var2.setText(class_492.string.wallet_buy_button_place_holder);
            int var3 = -1;
            int var4 = -2;
            if(WalletFragment.this.atU != null) {
                WalletFragmentStyle var5 = WalletFragment.this.atU.getFragmentStyle();
                if(var5 != null) {
                    DisplayMetrics var6 = WalletFragment.this.field_4531.getResources().getDisplayMetrics();
                    var3 = var5.method_6019("buyButtonWidth", var6, var3);
                    var4 = var5.method_6019("buyButtonHeight", var6, var4);
                }
            }

            var2.setLayoutParams(new LayoutParams(var3, var4));
            var2.setOnClickListener(this);
            var1.addView(var2);
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
        protected void method_2706(f<WalletFragment.class_1768> var1) {
            Activity var2 = WalletFragment.this.field_4531.getActivity();
            if(WalletFragment.this.aud == null && WalletFragment.this.mCreated && var2 != null) {
                try {
                    class_172 var4 = class_219.method_1512(var2, WalletFragment.this.aue, WalletFragment.this.atU, WalletFragment.this.aug);
                    WalletFragment.this.aud = new WalletFragment.class_1768(var4);
                    WalletFragment.this.atU = null;
                } catch (GooglePlayServicesNotAvailableException var5) {
                    return;
                }

                var1.method_1058(WalletFragment.this.aud);
                if(WalletFragment.this.atV != null) {
                    WalletFragment.this.aud.initialize(WalletFragment.this.atV);
                    WalletFragment.this.atV = null;
                }

                if(WalletFragment.this.atW != null) {
                    WalletFragment.this.aud.updateMaskedWalletRequest(WalletFragment.this.atW);
                    WalletFragment.this.atW = null;
                }

                if(WalletFragment.this.atX != null) {
                    WalletFragment.this.aud.updateMaskedWallet(WalletFragment.this.atX);
                    WalletFragment.this.atX = null;
                }

                if(WalletFragment.this.atY != null) {
                    WalletFragment.this.aud.setEnabled(WalletFragment.this.atY.booleanValue());
                    WalletFragment.this.atY = null;
                }
            }

        }

        public void onClick(View var1) {
            Activity var2 = WalletFragment.this.field_4531.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var2), var2, -1);
        }
    }
}
