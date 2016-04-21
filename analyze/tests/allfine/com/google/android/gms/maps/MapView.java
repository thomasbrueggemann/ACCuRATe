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
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.class_814;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
    private GoogleMap aiR;
    private final MapView.class_1246 aiU;

    public MapView(Context var1) {
        super(var1);
        this.aiU = new MapView.class_1246(this, var1, (GoogleMapOptions)null);
    }

    public MapView(Context var1, AttributeSet var2) {
        super(var1, var2);
        this.aiU = new MapView.class_1246(this, var1, GoogleMapOptions.createFromAttributes(var1, var2));
    }

    public MapView(Context var1, AttributeSet var2, int var3) {
        super(var1, var2, var3);
        this.aiU = new MapView.class_1246(this, var1, GoogleMapOptions.createFromAttributes(var1, var2));
    }

    public MapView(Context var1, GoogleMapOptions var2) {
        super(var1);
        this.aiU = new MapView.class_1246(this, var1, var2);
    }

    public final GoogleMap getMap() {
        if(this.aiR != null) {
            return this.aiR;
        } else {
            this.aiU.method_2715();
            if(this.aiU.it() == null) {
                return null;
            } else {
                try {
                    this.aiR = new GoogleMap(((MapView.class_1249)this.aiU.it()).method_3005().getMap());
                } catch (RemoteException var2) {
                    throw new RuntimeRemoteException(var2);
                }

                return this.aiR;
            }
        }
    }

    public final void onCreate(Bundle var1) {
        this.aiU.onCreate(var1);
        if(this.aiU.it() == null) {
            MapView.class_1246 var10000 = this.aiU;
            MapView.class_1246.b(this);
        }

    }

    public final void onDestroy() {
        this.aiU.onDestroy();
    }

    public final void onLowMemory() {
        this.aiU.onLowMemory();
    }

    public final void onPause() {
        this.aiU.onPause();
    }

    public final void onResume() {
        this.aiU.onResume();
    }

    public final void onSaveInstanceState(Bundle var1) {
        this.aiU.onSaveInstanceState(var1);
    }

    static class class_1249 implements LifecycleDelegate {
        private final ViewGroup aiV;
        private final IMapViewDelegate aiW;
        private View aiX;

        public class_1249(ViewGroup var1, IMapViewDelegate var2) {
            this.aiW = (IMapViewDelegate)class_1090.method_5685(var2);
            this.aiV = (ViewGroup)class_1090.method_5685(var1);
        }

        // $FF: renamed from: mB () com.google.android.gms.maps.internal.IMapViewDelegate
        public IMapViewDelegate method_3005() {
            return this.aiW;
        }

        public void onCreate(Bundle var1) {
            try {
                this.aiW.onCreate(var1);
                this.aiX = (View)class_1046.method_5436(this.aiW.getView());
                this.aiV.removeAllViews();
                this.aiV.addView(this.aiX);
            } catch (RemoteException var3) {
                throw new RuntimeRemoteException(var3);
            }
        }

        public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.aiW.onDestroy();
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
                this.aiW.onLowMemory();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onPause() {
            try {
                this.aiW.onPause();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onResume() {
            try {
                this.aiW.onResume();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onSaveInstanceState(Bundle var1) {
            try {
                this.aiW.onSaveInstanceState(var1);
            } catch (RemoteException var3) {
                throw new RuntimeRemoteException(var3);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    static class class_1246 extends a<MapView.class_1249> {
        protected f<MapView.class_1249> aiT;
        private final ViewGroup aiY;
        private final GoogleMapOptions aiZ;
        private final Context mContext;

        class_1246(ViewGroup var1, Context var2, GoogleMapOptions var3) {
            this.aiY = var1;
            this.mContext = var2;
            this.aiZ = var3;
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
        protected void method_2706(f<MapView.class_1249> var1) {
            this.aiT = var1;
            this.method_2715();
        }

        // $FF: renamed from: mA () void
        public void method_2715() {
            if(this.aiT != null && this.it() == null) {
                try {
                    IMapViewDelegate var3 = class_814.method_4233(this.mContext).method_647(class_1046.method_5437(this.mContext), this.aiZ);
                    this.aiT.method_1058(new MapView.class_1249(this.aiY, var3));
                } catch (RemoteException var4) {
                    throw new RuntimeRemoteException(var4);
                } catch (GooglePlayServicesNotAvailableException var5) {
                    return;
                }
            }

        }
    }
}
