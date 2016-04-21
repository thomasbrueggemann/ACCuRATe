package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.class_220;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_47;

public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    // $FF: renamed from: lc com.google.android.gms.internal.ds
    private class_47 field_4094;

    // $FF: renamed from: U () void
    private void method_4426() {
        if(this.field_4094 != null) {
            try {
                this.field_4094.method_184();
            } catch (RemoteException var2) {
                class_378.method_2465("Could not forward setContentViewSet to ad overlay:", var2);
                return;
            }
        }

    }

    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.field_4094 = class_220.method_1515(this);
        if(this.field_4094 == null) {
            class_378.method_2461("Could not create ad overlay.");
            this.finish();
        } else {
            try {
                this.field_4094.onCreate(var1);
            } catch (RemoteException var3) {
                class_378.method_2465("Could not forward onCreate to ad overlay:", var3);
                this.finish();
            }
        }
    }

    protected void onDestroy() {
        try {
            if(this.field_4094 != null) {
                this.field_4094.onDestroy();
            }
        } catch (RemoteException var2) {
            class_378.method_2465("Could not forward onDestroy to ad overlay:", var2);
        }

        super.onDestroy();
    }

    protected void onPause() {
        try {
            if(this.field_4094 != null) {
                this.field_4094.onPause();
            }
        } catch (RemoteException var2) {
            class_378.method_2465("Could not forward onPause to ad overlay:", var2);
            this.finish();
        }

        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();

        try {
            if(this.field_4094 != null) {
                this.field_4094.onRestart();
            }

        } catch (RemoteException var2) {
            class_378.method_2465("Could not forward onRestart to ad overlay:", var2);
            this.finish();
        }
    }

    protected void onResume() {
        super.onResume();

        try {
            if(this.field_4094 != null) {
                this.field_4094.onResume();
            }

        } catch (RemoteException var2) {
            class_378.method_2465("Could not forward onResume to ad overlay:", var2);
            this.finish();
        }
    }

    protected void onSaveInstanceState(Bundle var1) {
        try {
            if(this.field_4094 != null) {
                this.field_4094.onSaveInstanceState(var1);
            }
        } catch (RemoteException var3) {
            class_378.method_2465("Could not forward onSaveInstanceState to ad overlay:", var3);
            this.finish();
        }

        super.onSaveInstanceState(var1);
    }

    protected void onStart() {
        super.onStart();

        try {
            if(this.field_4094 != null) {
                this.field_4094.onStart();
            }

        } catch (RemoteException var2) {
            class_378.method_2465("Could not forward onStart to ad overlay:", var2);
            this.finish();
        }
    }

    protected void onStop() {
        try {
            if(this.field_4094 != null) {
                this.field_4094.onStop();
            }
        } catch (RemoteException var2) {
            class_378.method_2465("Could not forward onStop to ad overlay:", var2);
            this.finish();
        }

        super.onStop();
    }

    public void setContentView(int var1) {
        super.setContentView(var1);
        this.method_4426();
    }

    public void setContentView(View var1) {
        super.setContentView(var1);
        this.method_4426();
    }

    public void setContentView(View var1, LayoutParams var2) {
        super.setContentView(var1, var2);
        this.method_4426();
    }
}
