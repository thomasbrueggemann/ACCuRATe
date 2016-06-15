package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.mediation.customevent.CustomEventListener;

@Deprecated
public interface CustomEventBannerListener extends CustomEventListener {
   void onClick();

   void onReceivedAd(View var1);
}
