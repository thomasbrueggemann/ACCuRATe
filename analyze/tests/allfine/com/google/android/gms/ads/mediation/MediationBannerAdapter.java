package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;

public interface MediationBannerAdapter extends MediationAdapter {
    View getBannerView();

    void requestBannerAd(Context var1, MediationBannerListener var2, Bundle var3, AdSize var4, MediationAdRequest var5, Bundle var6);
}
