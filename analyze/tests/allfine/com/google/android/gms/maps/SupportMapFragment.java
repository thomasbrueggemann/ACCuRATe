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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.class_814;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment extends Fragment {
    private GoogleMap aiR;
    private final SupportMapFragment.class_1212 aju = new SupportMapFragment.class_1212(this);

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
        IMapFragmentDelegate var1 = this.method_5850();
        if(var1 != null) {
            IGoogleMapDelegate var3;
            try {
                var3 = var1.getMap();
            } catch (RemoteException var4) {
                throw new RuntimeRemoteException(var4);
            }

            if(var3 != null) {
                if(this.aiR == null || this.aiR.method_5457().asBinder() != var3.asBinder()) {
                    this.aiR = new GoogleMap(var3);
                }

                return this.aiR;
            }
        }

        return null;
    }

    // $FF: renamed from: mz () com.google.android.gms.maps.internal.IMapFragmentDelegate
    protected IMapFragmentDelegate method_5850() {
        this.aju.method_2717();
        return this.aju.it() == null?null:((SupportMapFragment.class_1211)this.aju.it()).method_2697();
    }

    public void onActivityCreated(Bundle var1) {
        if(var1 != null) {
            var1.setClassLoader(SupportMapFragment.class.getClassLoader());
        }

        super.onActivityCreated(var1);
    }

    public void onAttach(Activity var1) {
        super.onAttach(var1);
        this.aju.setActivity(var1);
    }

    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.aju.onCreate(var1);
    }

    public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        return this.aju.onCreateView(var1, var2, var3);
    }

    public void onDestroy() {
        this.aju.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.aju.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
        super.onInflate(var1, var2, var3);
        this.aju.setActivity(var1);
        GoogleMapOptions var4 = GoogleMapOptions.createFromAttributes(var1, var2);
        Bundle var5 = new Bundle();
        var5.putParcelable("MapOptions", var4);
        this.aju.onInflate(var1, var5, var3);
    }

    public void onLowMemory() {
        this.aju.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.aju.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.aju.onResume();
    }

    public void onSaveInstanceState(Bundle var1) {
        if(var1 != null) {
            var1.setClassLoader(SupportMapFragment.class.getClassLoader());
        }

        super.onSaveInstanceState(var1);
        this.aju.onSaveInstanceState(var1);
    }

    public void setArguments(Bundle var1) {
        super.setArguments(var1);
    }

    static class class_1211 implements LifecycleDelegate {
        // $FF: renamed from: Lt android.support.v4.app.Fragment
        private final Fragment field_1573;
        private final IMapFragmentDelegate aiS;

        public class_1211(Fragment var1, IMapFragmentDelegate var2) {
            this.aiS = (IMapFragmentDelegate)class_1090.method_5685(var2);
            this.field_1573 = (Fragment)class_1090.method_5685(var1);
        }

        // $FF: renamed from: mz () com.google.android.gms.maps.internal.IMapFragmentDelegate
        public IMapFragmentDelegate method_2697() {
            return this.aiS;
        }

        public void onCreate(Bundle param1) {
            // $FF: Couldn't be decompiled
        }

        public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
            class_206 var5;
            try {
                var5 = this.aiS.onCreateView(class_1046.method_5437(var1), class_1046.method_5437(var2), var3);
            } catch (RemoteException var6) {
                throw new RuntimeRemoteException(var6);
            }

            return (View)class_1046.method_5436(var5);
        }

        public void onDestroy() {
            try {
                this.aiS.onDestroy();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onDestroyView() {
            try {
                this.aiS.onDestroyView();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onInflate(Activity var1, Bundle var2, Bundle var3) {
            GoogleMapOptions var4 = (GoogleMapOptions)var2.getParcelable("MapOptions");

            try {
                this.aiS.onInflate(class_1046.method_5437(var1), var4, var3);
            } catch (RemoteException var6) {
                throw new RuntimeRemoteException(var6);
            }
        }

        public void onLowMemory() {
            try {
                this.aiS.onLowMemory();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onPause() {
            try {
                this.aiS.onPause();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onResume() {
            try {
                this.aiS.onResume();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onSaveInstanceState(Bundle var1) {
            try {
                this.aiS.onSaveInstanceState(var1);
            } catch (RemoteException var3) {
                throw new RuntimeRemoteException(var3);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    static class class_1212 extends a<SupportMapFragment.class_1211> {
        // $FF: renamed from: Lt android.support.v4.app.Fragment
        private final Fragment field_1584;
        protected f<SupportMapFragment.class_1211> aiT;
        // $FF: renamed from: nr android.app.Activity
        private Activity field_1585;

        class_1212(Fragment var1) {
            this.field_1584 = var1;
        }

        private void setActivity(Activity var1) {
            this.field_1585 = var1;
            this.method_2717();
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
        protected void method_2706(f<SupportMapFragment.class_1211> var1) {
            this.aiT = var1;
            this.method_2717();
        }

        // $FF: renamed from: mA () void
        public void method_2717() {
            if(this.field_1585 != null && this.aiT != null && this.it() == null) {
                try {
                    MapsInitializer.initialize(this.field_1585);
                    IMapFragmentDelegate var4 = class_814.method_4233(this.field_1585).method_651(class_1046.method_5437(this.field_1585));
                    this.aiT.method_1058(new SupportMapFragment.class_1211(this.field_1584, var4));
                } catch (RemoteException var5) {
                    throw new RuntimeRemoteException(var5);
                } catch (GooglePlayServicesNotAvailableException var6) {
                    return;
                }
            }

        }
    }
}
