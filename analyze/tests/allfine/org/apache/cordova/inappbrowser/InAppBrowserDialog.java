package org.apache.cordova.inappbrowser;

import android.app.Dialog;
import android.content.Context;
import org.apache.cordova.inappbrowser.InAppBrowser;

public class InAppBrowserDialog extends Dialog {
    Context context;
    InAppBrowser inAppBrowser = null;

    public InAppBrowserDialog(Context var1, int var2) {
        super(var1, var2);
        this.context = var1;
    }

    public void onBackPressed() {
        if(this.inAppBrowser == null) {
            this.dismiss();
        } else {
            this.inAppBrowser.closeDialog();
        }
    }

    public void setInAppBroswer(InAppBrowser var1) {
        this.inAppBrowser = var1;
    }
}
