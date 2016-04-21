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
import com.google.android.gms.class_492;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_1066;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.class_171;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_219;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public final class SupportWalletFragment extends Fragment {
    // $FF: renamed from: Lt android.support.v4.app.Fragment
    private final Fragment field_3936 = this;
    private SupportWalletFragment.class_1651 atQ;
    private final class_1066 atR = class_1066.method_5584(this);
    private final SupportWalletFragment.class_1652 atS = new SupportWalletFragment.class_1652();
    private SupportWalletFragment.class_1650 atT = new SupportWalletFragment.class_1650(this);
    private WalletFragmentOptions atU;
    private WalletFragmentInitParams atV;
    private MaskedWalletRequest atW;
    private MaskedWallet atX;
    private Boolean atY;
    private boolean mCreated = false;

    public static SupportWalletFragment newInstance(WalletFragmentOptions var0) {
        SupportWalletFragment var1 = new SupportWalletFragment();
        Bundle var2 = new Bundle();
        var2.putParcelable("extraWalletFragmentOptions", var0);
        var1.field_3936.setArguments(var2);
        return var1;
    }

    public int getState() {
        return this.atQ != null?this.atQ.getState():0;
    }

    public void initialize(WalletFragmentInitParams var1) {
        if(this.atQ != null) {
            this.atQ.initialize(var1);
            this.atV = null;
        } else {
            if(this.atV != null) {
                Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
                return;
            }

            this.atV = var1;
            if(this.atW != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }

            if(this.atX != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
                return;
            }
        }

    }

    public void onActivityResult(int var1, int var2, Intent var3) {
        super.onActivityResult(var1, var2, var3);
        if(this.atQ != null) {
            this.atQ.onActivityResult(var1, var2, var3);
        }

    }

    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        if(var1 != null) {
            var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams var3 = (WalletFragmentInitParams)var1.getParcelable("walletFragmentInitParams");
            if(var3 != null) {
                if(this.atV != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if(this.field_3936.getArguments() != null) {
            WalletFragmentOptions var2 = (WalletFragmentOptions)this.field_3936.getArguments().getParcelable("extraWalletFragmentOptions");
            if(var2 != null) {
                var2.method_5858(this.field_3936.getActivity());
                this.atU = var2;
            }
        }

        this.mCreated = true;
        this.atS.onCreate(var1);
    }

    public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        return this.atS.onCreateView(var1, var2, var3);
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
        this.atS.onInflate(var1, var4, var3);
    }

    public void onPause() {
        super.onPause();
        this.atS.onPause();
    }

    public void onResume() {
        super.onResume();
        this.atS.onResume();
        FragmentManager var1 = this.field_3936.getActivity().getSupportFragmentManager();
        Fragment var2 = var1.findFragmentByTag("GooglePlayServicesErrorDialog");
        if(var2 != null) {
            var1.beginTransaction().remove(var2).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_3936.getActivity()), this.field_3936.getActivity(), -1);
        }

    }

    public void onSaveInstanceState(Bundle var1) {
        super.onSaveInstanceState(var1);
        var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.atS.onSaveInstanceState(var1);
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
        this.atS.onStart();
    }

    public void onStop() {
        super.onStop();
        this.atS.onStop();
    }

    public void setEnabled(boolean var1) {
        if(this.atQ != null) {
            this.atQ.setEnabled(var1);
            this.atY = null;
        } else {
            this.atY = Boolean.valueOf(var1);
        }
    }

    public void setOnStateChangedListener(SupportWalletFragment.OnStateChangedListener var1) {
        this.atT.method_1644(var1);
    }

    public void updateMaskedWallet(MaskedWallet var1) {
        if(this.atQ != null) {
            this.atQ.updateMaskedWallet(var1);
            this.atX = null;
        } else {
            this.atX = var1;
        }
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest var1) {
        if(this.atQ != null) {
            this.atQ.updateMaskedWalletRequest(var1);
            this.atW = null;
        } else {
            this.atW = var1;
        }
    }

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment var1, int var2, int var3, Bundle var4);
    }

    static class class_1650 extends class_171.class_1162 {
        private SupportWalletFragment.OnStateChangedListener atZ;
        private final SupportWalletFragment aua;

        class_1650(SupportWalletFragment var1) {
            this.aua = var1;
        }

        // $FF: renamed from: a (int, int, android.os.Bundle) void
        public void method_816(int var1, int var2, Bundle var3) {
            if(this.atZ != null) {
                this.atZ.onStateChanged(this.aua, var1, var2, var3);
            }

        }

        // $FF: renamed from: a (com.google.android.gms.wallet.fragment.SupportWalletFragment$OnStateChangedListener) void
        public void method_1644(SupportWalletFragment.OnStateChangedListener var1) {
            this.atZ = var1;
        }
    }

    private static class class_1651 implements LifecycleDelegate {
        private final class_172 aub;

        private class_1651(class_172 var1) {
            this.aub = var1;
        }

        // $FF: synthetic method
        class_1651(class_172 var1, Object var2) {
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

    private class class_1652 extends a<SupportWalletFragment.class_1651> implements OnClickListener {
        private class_1652() {
        }

        // $FF: synthetic method
        class_1652(Object var2) {
            this();
        }

        // $FF: renamed from: a (android.widget.FrameLayout) void
        protected void method_2705(FrameLayout var1) {
            Button var2 = new Button(SupportWalletFragment.this.field_3936.getActivity());
            var2.setText(class_492.string.wallet_buy_button_place_holder);
            int var3 = -1;
            int var4 = -2;
            if(SupportWalletFragment.this.atU != null) {
                WalletFragmentStyle var5 = SupportWalletFragment.this.atU.getFragmentStyle();
                if(var5 != null) {
                    DisplayMetrics var6 = SupportWalletFragment.this.field_3936.getResources().getDisplayMetrics();
                    var3 = var5.method_6019("buyButtonWidth", var6, var3);
                    var4 = var5.method_6019("buyButtonHeight", var6, var4);
                }
            }

            var2.setLayoutParams(new LayoutParams(var3, var4));
            var2.setOnClickListener(this);
            var1.addView(var2);
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
        protected void method_2706(f<SupportWalletFragment.class_1651> var1) {
            FragmentActivity var2 = SupportWalletFragment.this.field_3936.getActivity();
            if(SupportWalletFragment.this.atQ == null && SupportWalletFragment.this.mCreated && var2 != null) {
                try {
                    class_172 var4 = class_219.method_1512(var2, SupportWalletFragment.this.atR, SupportWalletFragment.this.atU, SupportWalletFragment.this.atT);
                    SupportWalletFragment.this.atQ = new SupportWalletFragment.class_1651(var4);
                    SupportWalletFragment.this.atU = null;
                } catch (GooglePlayServicesNotAvailableException var5) {
                    return;
                }

                var1.method_1058(SupportWalletFragment.this.atQ);
                if(SupportWalletFragment.this.atV != null) {
                    SupportWalletFragment.this.atQ.initialize(SupportWalletFragment.this.atV);
                    SupportWalletFragment.this.atV = null;
                }

                if(SupportWalletFragment.this.atW != null) {
                    SupportWalletFragment.this.atQ.updateMaskedWalletRequest(SupportWalletFragment.this.atW);
                    SupportWalletFragment.this.atW = null;
                }

                if(SupportWalletFragment.this.atX != null) {
                    SupportWalletFragment.this.atQ.updateMaskedWallet(SupportWalletFragment.this.atX);
                    SupportWalletFragment.this.atX = null;
                }

                if(SupportWalletFragment.this.atY != null) {
                    SupportWalletFragment.this.atQ.setEnabled(SupportWalletFragment.this.atY.booleanValue());
                    SupportWalletFragment.this.atY = null;
                }
            }

        }

        public void onClick(View var1) {
            FragmentActivity var2 = SupportWalletFragment.this.field_3936.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var2), var2, -1);
        }
    }
}
