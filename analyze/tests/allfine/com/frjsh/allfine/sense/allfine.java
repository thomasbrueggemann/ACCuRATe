package com.frjsh.allfine.sense;

import android.os.Bundle;
import org.apache.cordova.CordovaActivity;

public class allfine extends CordovaActivity {
    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        super.init();
        this.loadUrl(this.launchUrl);
    }
}