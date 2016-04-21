package org.apache.cordova;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.LOG;

public class LinearLayoutSoftKeyboardDetect extends LinearLayout {
    private static final String TAG = "SoftKeyboardDetect";
    private CordovaActivity app = null;
    private int oldHeight = 0;
    private int oldWidth = 0;
    private int screenHeight = 0;
    private int screenWidth = 0;

    public LinearLayoutSoftKeyboardDetect(Context var1, int var2, int var3) {
        super(var1);
        this.screenWidth = var2;
        this.screenHeight = var3;
        this.app = (CordovaActivity)var1;
    }

    protected void onMeasure(int var1, int var2) {
        super.onMeasure(var1, var2);
        LOG.method_4288("SoftKeyboardDetect", "We are in our onMeasure method");
        int var3 = MeasureSpec.getSize(var2);
        int var4 = MeasureSpec.getSize(var1);
        Object[] var5 = new Object[] {Integer.valueOf(this.oldHeight)};
        LOG.method_4290("SoftKeyboardDetect", "Old Height = %d", var5);
        Object[] var6 = new Object[] {Integer.valueOf(var3)};
        LOG.method_4290("SoftKeyboardDetect", "Height = %d", var6);
        Object[] var7 = new Object[] {Integer.valueOf(this.oldWidth)};
        LOG.method_4290("SoftKeyboardDetect", "Old Width = %d", var7);
        Object[] var8 = new Object[] {Integer.valueOf(var4)};
        LOG.method_4290("SoftKeyboardDetect", "Width = %d", var8);
        if(this.oldHeight != 0 && this.oldHeight != var3) {
            if(this.screenHeight == var4) {
                int var9 = this.screenHeight;
                this.screenHeight = this.screenWidth;
                this.screenWidth = var9;
                LOG.method_4288("SoftKeyboardDetect", "Orientation Change");
            } else if(var3 > this.oldHeight) {
                if(this.app != null) {
                    this.app.appView.sendJavascript("cordova.fireDocumentEvent(\'hidekeyboard\');");
                }
            } else if(var3 < this.oldHeight && this.app != null) {
                this.app.appView.sendJavascript("cordova.fireDocumentEvent(\'showkeyboard\');");
            }
        } else {
            LOG.method_4279("SoftKeyboardDetect", "Ignore this event");
        }

        this.oldHeight = var3;
        this.oldWidth = var4;
    }
}
