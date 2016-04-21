package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.tagmanager.Container;

public interface ContainerHolder extends Releasable, Result {
    Container getContainer();

    void refresh();

    void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener var1);

    public interface ContainerAvailableListener {
        void onContainerAvailable(ContainerHolder var1, String var2);
    }
}
