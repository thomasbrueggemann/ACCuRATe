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
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.class_814;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView extends FrameLayout {
    private StreetViewPanorama ajh;
    private final StreetViewPanoramaView.class_1244 ajq;

    public StreetViewPanoramaView(Context var1) {
        super(var1);
        this.ajq = new StreetViewPanoramaView.class_1244(this, var1, (StreetViewPanoramaOptions)null);
    }

    public StreetViewPanoramaView(Context var1, AttributeSet var2) {
        super(var1, var2);
        this.ajq = new StreetViewPanoramaView.class_1244(this, var1, (StreetViewPanoramaOptions)null);
    }

    public StreetViewPanoramaView(Context var1, AttributeSet var2, int var3) {
        super(var1, var2, var3);
        this.ajq = new StreetViewPanoramaView.class_1244(this, var1, (StreetViewPanoramaOptions)null);
    }

    public StreetViewPanoramaView(Context var1, StreetViewPanoramaOptions var2) {
        super(var1);
        this.ajq = new StreetViewPanoramaView.class_1244(this, var1, var2);
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        if(this.ajh != null) {
            return this.ajh;
        } else {
            this.ajq.method_2714();
            if(this.ajq.it() == null) {
                return null;
            } else {
                try {
                    this.ajh = new StreetViewPanorama(((StreetViewPanoramaView.class_1245)this.ajq.it()).method_3189().getStreetViewPanorama());
                } catch (RemoteException var2) {
                    throw new RuntimeRemoteException(var2);
                }

                return this.ajh;
            }
        }
    }

    public final void onCreate(Bundle var1) {
        this.ajq.onCreate(var1);
        if(this.ajq.it() == null) {
            StreetViewPanoramaView.class_1244 var10000 = this.ajq;
            StreetViewPanoramaView.class_1244.b(this);
        }

    }

    public final void onDestroy() {
        this.ajq.onDestroy();
    }

    public final void onLowMemory() {
        this.ajq.onLowMemory();
    }

    public final void onPause() {
        this.ajq.onPause();
    }

    public final void onResume() {
        this.ajq.onResume();
    }

    public final void onSaveInstanceState(Bundle var1) {
        this.ajq.onSaveInstanceState(var1);
    }

    static class class_1244 extends a<StreetViewPanoramaView.class_1245> {
        protected f<StreetViewPanoramaView.class_1245> aiT;
        private final ViewGroup aiY;
        private final StreetViewPanoramaOptions ajr;
        private final Context mContext;

        class_1244(ViewGroup var1, Context var2, StreetViewPanoramaOptions var3) {
            this.aiY = var1;
            this.mContext = var2;
            this.ajr = var3;
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
        protected void method_2706(f<StreetViewPanoramaView.class_1245> var1) {
            this.aiT = var1;
            this.method_2714();
        }

        // $FF: renamed from: mA () void
        public void method_2714() {
            if(this.aiT != null && this.it() == null) {
                try {
                    IStreetViewPanoramaViewDelegate var3 = class_814.method_4233(this.mContext).method_648(class_1046.method_5437(this.mContext), this.ajr);
                    this.aiT.method_1058(new StreetViewPanoramaView.class_1245(this.aiY, var3));
                } catch (RemoteException var4) {
                    throw new RuntimeRemoteException(var4);
                } catch (GooglePlayServicesNotAvailableException var5) {
                    return;
                }
            }

        }
    }

    static class class_1245 implements LifecycleDelegate {
        private final ViewGroup aiV;
        private final IStreetViewPanoramaViewDelegate ajs;
        private View ajt;

        public class_1245(ViewGroup var1, IStreetViewPanoramaViewDelegate var2) {
            this.ajs = (IStreetViewPanoramaViewDelegate)class_1090.method_5685(var2);
            this.aiV = (ViewGroup)class_1090.method_5685(var1);
        }

        // $FF: renamed from: mH () com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate
        public IStreetViewPanoramaViewDelegate method_3189() {
            return this.ajs;
        }

        public void onCreate(Bundle var1) {
            try {
                this.ajs.onCreate(var1);
                this.ajt = (View)class_1046.method_5436(this.ajs.getView());
                this.aiV.removeAllViews();
                this.aiV.addView(this.ajt);
            } catch (RemoteException var3) {
                throw new RuntimeRemoteException(var3);
            }
        }

        public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.ajs.onDestroy();
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
                this.ajs.onLowMemory();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onPause() {
            try {
                this.ajs.onPause();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onResume() {
            try {
                this.ajs.onResume();
            } catch (RemoteException var2) {
                throw new RuntimeRemoteException(var2);
            }
        }

        public void onSaveInstanceState(Bundle var1) {
            try {
                this.ajs.onSaveInstanceState(var1);
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
