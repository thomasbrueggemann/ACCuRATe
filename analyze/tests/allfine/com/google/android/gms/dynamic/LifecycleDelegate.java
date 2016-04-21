package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface LifecycleDelegate {
    void onCreate(Bundle var1);

    View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3);

    void onDestroy();

    void onDestroyView();

    void onInflate(Activity var1, Bundle var2, Bundle var3);

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle var1);

    void onStart();

    void onStop();
}
