package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.class_1090;

// $FF: renamed from: com.google.android.gms.common.api.d
public class class_1124 extends Fragment implements OnCancelListener, LoaderCallbacks<ConnectionResult> {
    // $FF: renamed from: JB boolean
    private boolean field_5195;
    // $FF: renamed from: JC int
    private int field_5196 = -1;
    // $FF: renamed from: JD com.google.android.gms.common.ConnectionResult
    private ConnectionResult field_5197;
    // $FF: renamed from: JE android.os.Handler
    private final Handler field_5198 = new Handler(Looper.getMainLooper());
    // $FF: renamed from: JF android.util.SparseArray
    private final SparseArray<class_1124.class_1221> field_5199 = new SparseArray();

    // $FF: renamed from: a (android.support.v4.app.FragmentActivity) com.google.android.gms.common.api.d
    public static class_1124 method_5820(FragmentActivity var0) {
        class_1090.method_5678("Must be called from main thread of process");
        FragmentManager var1 = var0.getSupportFragmentManager();

        class_1124 var3;
        try {
            var3 = (class_1124)var1.findFragmentByTag("GmsSupportLifecycleFragment");
        } catch (ClassCastException var4) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", var4);
        }

        if(var3 == null || var3.isRemoving()) {
            var3 = new class_1124();
            var1.beginTransaction().add(var3, "GmsSupportLifecycleFragment").commit();
            var1.executePendingTransactions();
        }

        return var3;
    }

    // $FF: renamed from: a (int, com.google.android.gms.common.ConnectionResult) void
    private void method_5821(int var1, ConnectionResult var2) {
        if(!this.field_5195) {
            this.field_5195 = true;
            this.field_5196 = var1;
            this.field_5197 = var2;
            this.field_5198.post(new class_1124.class_1225(var1, var2));
        }

    }

    // $FF: renamed from: an (int) void
    private void method_5824(int var1) {
        if(var1 == this.field_5196) {
            this.method_5826();
        }

    }

    // $FF: renamed from: b (int, com.google.android.gms.common.ConnectionResult) void
    private void method_5825(int var1, ConnectionResult var2) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        class_1124.class_1221 var4 = (class_1124.class_1221)this.field_5199.get(var1);
        if(var4 != null) {
            this.method_5830(var1);
            GoogleApiClient.OnConnectionFailedListener var5 = var4.field_1767;
            if(var5 != null) {
                var5.onConnectionFailed(var2);
            }
        }

        this.method_5826();
    }

    // $FF: renamed from: gu () void
    private void method_5826() {
        int var1 = 0;
        this.field_5195 = false;
        this.field_5196 = -1;
        this.field_5197 = null;

        for(LoaderManager var2 = this.getLoaderManager(); var1 < this.field_5199.size(); ++var1) {
            int var3 = this.field_5199.keyAt(var1);
            class_1124.class_1222 var4 = this.method_5831(var3);
            if(var4 != null) {
                var4.method_2836();
            }

            var2.initLoader(var3, (Bundle)null, this);
        }

    }

    // $FF: renamed from: a (int, com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) void
    public void method_5827(int var1, GoogleApiClient var2, GoogleApiClient.OnConnectionFailedListener var3) {
        class_1090.method_5681(var2, "GoogleApiClient instance cannot be null");
        boolean var5;
        if(this.field_5199.indexOfKey(var1) < 0) {
            var5 = true;
        } else {
            var5 = false;
        }

        class_1090.method_5676(var5, "Already managing a GoogleApiClient with id " + var1);
        class_1124.class_1221 var6 = new class_1124.class_1221(var2, var3);
        this.field_5199.put(var1, var6);
        if(this.getActivity() != null) {
            this.getLoaderManager().initLoader(var1, (Bundle)null, this);
        }

    }

    // $FF: renamed from: a (android.support.v4.content.Loader, com.google.android.gms.common.ConnectionResult) void
    public void method_5828(Loader<ConnectionResult> var1, ConnectionResult var2) {
        if(var2.isSuccess()) {
            this.method_5824(var1.getId());
        } else {
            this.method_5821(var1.getId(), var2);
        }
    }

    // $FF: renamed from: ak (int) com.google.android.gms.common.api.GoogleApiClient
    public GoogleApiClient method_5829(int var1) {
        if(this.getActivity() != null) {
            class_1124.class_1222 var2 = this.method_5831(var1);
            if(var2 != null) {
                return var2.field_1769;
            }
        }

        return null;
    }

    // $FF: renamed from: al (int) void
    public void method_5830(int var1) {
        this.getLoaderManager().destroyLoader(var1);
        this.field_5199.remove(var1);
    }

    // $FF: renamed from: am (int) com.google.android.gms.common.api.d$a
    class_1124.class_1222 method_5831(int var1) {
        try {
            class_1124.class_1222 var3 = (class_1124.class_1222)this.getLoaderManager().getLoader(var1);
            return var3;
        } catch (ClassCastException var4) {
            throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", var4);
        }
    }

    public void onActivityResult(int var1, int var2, Intent var3) {
        boolean var4;
        label21: {
            var4 = true;
            switch(var1) {
                case 1:
                    if(var2 == -1) {
                        break label21;
                    }
                    break;
                case 2:
                    if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.getActivity()) == 0) {
                        break label21;
                    }
            }

            var4 = false;
        }

        if(var4) {
            this.method_5826();
        } else {
            this.method_5825(this.field_5196, this.field_5197);
        }
    }

    public void onAttach(Activity var1) {
        super.onAttach(var1);

        for(int var2 = 0; var2 < this.field_5199.size(); ++var2) {
            int var3 = this.field_5199.keyAt(var2);
            class_1124.class_1222 var4 = this.method_5831(var3);
            if(var4 != null && ((class_1124.class_1221)this.field_5199.valueAt(var2)).field_1766 != var4.field_1769) {
                this.getLoaderManager().restartLoader(var3, (Bundle)null, this);
            } else {
                this.getLoaderManager().initLoader(var3, (Bundle)null, this);
            }
        }

    }

    public void onCancel(DialogInterface var1) {
        this.method_5825(this.field_5196, this.field_5197);
    }

    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        if(var1 != null) {
            this.field_5195 = var1.getBoolean("resolving_error", false);
            this.field_5196 = var1.getInt("failed_client_id", -1);
            if(this.field_5196 >= 0) {
                this.field_5197 = new ConnectionResult(var1.getInt("failed_status"), (PendingIntent)var1.getParcelable("failed_resolution"));
            }
        }

    }

    public Loader<ConnectionResult> onCreateLoader(int var1, Bundle var2) {
        return new class_1124.class_1222(this.getActivity(), ((class_1124.class_1221)this.field_5199.get(var1)).field_1766);
    }

    // $FF: synthetic method
    public void onLoadFinished(Loader var1, Object var2) {
        this.method_5828(var1, (ConnectionResult)var2);
    }

    public void onLoaderReset(Loader<ConnectionResult> var1) {
        if(var1.getId() == this.field_5196) {
            this.method_5826();
        }

    }

    public void onSaveInstanceState(Bundle var1) {
        super.onSaveInstanceState(var1);
        var1.putBoolean("resolving_error", this.field_5195);
        if(this.field_5196 >= 0) {
            var1.putInt("failed_client_id", this.field_5196);
            var1.putInt("failed_status", this.field_5197.getErrorCode());
            var1.putParcelable("failed_resolution", this.field_5197.getResolution());
        }

    }

    public void onStart() {
        super.onStart();
        if(!this.field_5195) {
            for(int var1 = 0; var1 < this.field_5199.size(); ++var1) {
                this.getLoaderManager().initLoader(this.field_5199.keyAt(var1), (Bundle)null, this);
            }
        }

    }

    static class class_1222 extends Loader<ConnectionResult> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        // $FF: renamed from: JG com.google.android.gms.common.api.GoogleApiClient
        public final GoogleApiClient field_1769;
        // $FF: renamed from: JH boolean
        private boolean field_1770;
        // $FF: renamed from: JI com.google.android.gms.common.ConnectionResult
        private ConnectionResult field_1771;

        public class_1222(Context var1, GoogleApiClient var2) {
            super(var1);
            this.field_1769 = var2;
        }

        // $FF: renamed from: a (com.google.android.gms.common.ConnectionResult) void
        private void method_2835(ConnectionResult var1) {
            this.field_1771 = var1;
            if(this.isStarted() && !this.isAbandoned()) {
                this.deliverResult(var1);
            }

        }

        // $FF: renamed from: gv () void
        public void method_2836() {
            if(this.field_1770) {
                this.field_1770 = false;
                if(this.isStarted() && !this.isAbandoned()) {
                    this.field_1769.connect();
                }
            }

        }

        public void onConnected(Bundle var1) {
            this.field_1770 = false;
            this.method_2835(ConnectionResult.field_4377);
        }

        public void onConnectionFailed(ConnectionResult var1) {
            this.field_1770 = true;
            this.method_2835(var1);
        }

        public void onConnectionSuspended(int var1) {
        }

        protected void onReset() {
            this.field_1771 = null;
            this.field_1770 = false;
            this.field_1769.unregisterConnectionCallbacks(this);
            this.field_1769.unregisterConnectionFailedListener(this);
            this.field_1769.disconnect();
        }

        protected void onStartLoading() {
            super.onStartLoading();
            this.field_1769.registerConnectionCallbacks(this);
            this.field_1769.registerConnectionFailedListener(this);
            if(this.field_1771 != null) {
                this.deliverResult(this.field_1771);
            }

            if(!this.field_1769.isConnected() && !this.field_1769.isConnecting() && !this.field_1770) {
                this.field_1769.connect();
            }

        }

        protected void onStopLoading() {
            this.field_1769.disconnect();
        }
    }

    private static class class_1221 {
        // $FF: renamed from: JG com.google.android.gms.common.api.GoogleApiClient
        public final GoogleApiClient field_1766;
        // $FF: renamed from: JJ com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
        public final GoogleApiClient.OnConnectionFailedListener field_1767;

        private class_1221(GoogleApiClient var1, GoogleApiClient.OnConnectionFailedListener var2) {
            this.field_1766 = var1;
            this.field_1767 = var2;
        }

        // $FF: synthetic method
        class_1221(GoogleApiClient var1, GoogleApiClient.OnConnectionFailedListener var2, Object var3) {
            this(var1, var2);
        }
    }

    private class class_1225 implements Runnable {
        // $FF: renamed from: JK int
        private final int field_1784;
        // $FF: renamed from: JL com.google.android.gms.common.ConnectionResult
        private final ConnectionResult field_1785;

        public class_1225(int var2, ConnectionResult var3) {
            this.field_1784 = var2;
            this.field_1785 = var3;
        }

        public void run() {
            if(this.field_1785.hasResolution()) {
                try {
                    int var3 = 1 + (1 + class_1124.this.getActivity().getSupportFragmentManager().getFragments().indexOf(class_1124.this) << 16);
                    this.field_1785.startResolutionForResult(class_1124.this.getActivity(), var3);
                } catch (SendIntentException var4) {
                    class_1124.this.method_5826();
                }
            } else if(GooglePlayServicesUtil.isUserRecoverableError(this.field_1785.getErrorCode())) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.field_1785.getErrorCode(), class_1124.this.getActivity(), class_1124.this, 2, class_1124.this);
            } else {
                class_1124.this.method_5825(this.field_1784, this.field_1785);
            }
        }
    }
}
