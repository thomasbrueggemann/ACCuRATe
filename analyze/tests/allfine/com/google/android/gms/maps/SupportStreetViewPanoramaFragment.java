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
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.class_814;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportStreetViewPanoramaFragment extends Fragment {
    private StreetViewPanorama ajh;
    private final SupportStreetViewPanoramaFragment.class_1679 ajv = new SupportStreetViewPanoramaFragment.class_1679(this);

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions var0) {
        SupportStreetViewPanoramaFragment var1 = new SupportStreetViewPanoramaFragment();
        Bundle var2 = new Bundle();
        var2.putParcelable("StreetViewPanoramaOptions", var0);
        var1.setArguments(var2);
        return var1;
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate var1 = this.method_4402();
        if(var1 != null) {
            IStreetViewPanoramaDelegate var3;
            try {
                var3 = var1.getStreetViewPanorama();
            } catch (RemoteException var4) {
                throw new RuntimeRemoteException(var4);
            }

            if(var3 != null) {
                if(this.ajh == null || this.ajh.method_4369().asBinder() != var3.asBinder()) {
                    this.ajh = new StreetViewPanorama(var3);
                }

                return this.ajh;
            }
        }

        return null;
    }

    // $FF: renamed from: mD () com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    protected IStreetViewPanoramaFragmentDelegate method_4402() {
        this.ajv.method_2711();
        return this.ajv.it() == null?null:((SupportStreetViewPanoramaFragment.class_1678)this.ajv.it()).method_5080();
    }

    public void onActivityCreated(Bundle var1) {
        if(var1 != null) {
            var1.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }

        super.onActivityCreated(var1);
    }

    public void onAttach(Activity var1) {
        super.onAttach(var1);
        this.ajv.setActivity(var1);
    }

    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.ajv.onCreate(var1);
    }

    public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        return this.ajv.onCreateView(var1, var2, var3);
    }

    public void onDestroy() {
        this.ajv.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.ajv.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
        super.onInflate(var1, var2, var3);
        this.ajv.setActivity(var1);
        Bundle var4 = new Bundle();
        this.ajv.onInflate(var1, var4, var3);
    }

    public void onLowMemory() {
        this.ajv.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.ajv.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.ajv.onResume();
    }

    public void onSaveInstanceState(Bundle var1) {
        if(var1 != null) {
            var1.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }

        super.onSaveInstanceState(var1);
        this.ajv.onSaveInstanceState(var1);
    }

    public void setArguments(Bundle var1) {
        super.setArguments(var1);
    }

    static class class_1678 implements LifecycleDelegate {
        // $FF: renamed from: Lt android.support.v4.app.Fragment
        private final Fragment field_4509;
        private final IStreetViewPanoramaFragmentDelegate aji;

        public class_1678(Fragment var1, IStreetViewPanoramaFragmentDelegate var2) {
            this.aji = (IStreetViewPanoramaFragmentDelegate)class_1090.method_5685(var2);
            this.field_4509 = (Fragment)class_1090.method_5685(var1);
        }

        // $FF: renamed from: mD () com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
        public IStreetViewPanoramaFragmentDelegate method_5080() {
            return this.aji;
        }

        public void onCreate(Bundle param1) {
            // $FF: Couldn't be decompiled
        }

        public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
            class_206 var5;
            try {
                var5 = this.aji.onCreateView(class_1046.method_5437(var1), class_1046.method_5437(var2), var3);
            } catch (RemoteException var6) {
                throw new RuntimeRemoteException(var6);
            }

            return (View)class_1046.method_5436(var5);
        }

        public void onDestroy() {
            try {
                this.aji.onDestroy();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onDestroyView() {
            try {
                this.aji.onDestroyView();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onInflate(Activity var1, Bundle var2, Bundle var3) {
            try {
                this.aji.onInflate(class_1046.method_5437(var1), (StreetViewPanoramaOptions)null, var3);
            } catch (RemoteException var5) {
                throw new RuntimeRemoteException(var5);
            }
        }

        public void onLowMemory() {
            try {
                this.aji.onLowMemory();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onPause() {
            try {
                this.aji.onPause();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onResume() {
            try {
                this.aji.onResume();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onSaveInstanceState(Bundle var1) {
            try {
                this.aji.onSaveInstanceState(var1);
            } catch (RemoteException var3) {
                throw new RuntimeRemoteException(var3);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    static class class_1679 extends a<SupportStreetViewPanoramaFragment.class_1678> {
        // $FF: renamed from: Lt android.support.v4.app.Fragment
        private final Fragment field_1580;
        protected f<SupportStreetViewPanoramaFragment.class_1678> aiT;
        // $FF: renamed from: nr android.app.Activity
        private Activity field_1581;

        class_1679(Fragment var1) {
            this.field_1580 = var1;
        }

        private void setActivity(Activity var1) {
            this.field_1581 = var1;
            this.method_2711();
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
        protected void method_2706(f<SupportStreetViewPanoramaFragment.class_1678> var1) {
            this.aiT = var1;
            this.method_2711();
        }

        // $FF: renamed from: mA () void
        public void method_2711() {
            if(this.field_1581 != null && this.aiT != null && this.it() == null) {
                try {
                    MapsInitializer.initialize(this.field_1581);
                    IStreetViewPanoramaFragmentDelegate var4 = class_814.method_4233(this.field_1581).method_652(class_1046.method_5437(this.field_1581));
                    this.aiT.method_1058(new SupportStreetViewPanoramaFragment.class_1678(this.field_1580, var4));
                } catch (RemoteException var5) {
                    throw new RuntimeRemoteException(var5);
                } catch (GooglePlayServicesNotAvailableException var6) {
                    return;
                }
            }

        }
    }
}
