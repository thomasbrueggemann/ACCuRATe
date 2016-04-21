package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_443;
import com.google.android.gms.internal.ez;
import java.net.URI;
import java.net.URISyntaxException;

// $FF: renamed from: com.google.android.gms.internal.ha
@ez
public class class_410 extends WebViewClient {
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private final class_381 field_1516;
    // $FF: renamed from: xc java.lang.String
    private final String field_1517;
    // $FF: renamed from: xd boolean
    private boolean field_1518;
    // $FF: renamed from: xe com.google.android.gms.internal.fc
    private final class_443 field_1519;

    public class_410(class_443 var1, class_381 var2, String var3) {
        this.field_1517 = this.method_2650(var3);
        this.field_1518 = false;
        this.field_1516 = var2;
        this.field_1519 = var1;
    }

    // $FF: renamed from: Z (java.lang.String) java.lang.String
    private String method_2650(String var1) {
        if(!TextUtils.isEmpty(var1)) {
            try {
                if(var1.endsWith("/")) {
                    String var3 = var1.substring(0, -1 + var1.length());
                    return var3;
                }
            } catch (IndexOutOfBoundsException var4) {
                class_378.method_2458(var4.getMessage());
                return var1;
            }
        }

        return var1;
    }

    // $FF: renamed from: Y (java.lang.String) boolean
    protected boolean method_2651(String var1) {
        String var2 = this.method_2650(var1);
        if(!TextUtils.isEmpty(var2)) {
            try {
                URI var3 = new URI(var2);
                if("passback".equals(var3.getScheme())) {
                    class_378.method_2457("Passback received");
                    this.field_1519.method_2796();
                    return true;
                }

                if(!TextUtils.isEmpty(this.field_1517)) {
                    URI var5 = new URI(this.field_1517);
                    String var6 = var5.getHost();
                    String var7 = var3.getHost();
                    String var8 = var5.getPath();
                    String var9 = var3.getPath();
                    if(class_1089.equal(var6, var7) && class_1089.equal(var8, var9)) {
                        class_378.method_2457("Passback received");
                        this.field_1519.method_2796();
                        return true;
                    }
                }
            } catch (URISyntaxException var10) {
                class_378.method_2458(var10.getMessage());
                return false;
            }
        }

        return false;
    }

    public void onLoadResource(WebView var1, String var2) {
        class_378.method_2457("JavascriptAdWebViewClient::onLoadResource: " + var2);
        if(!this.method_2651(var2)) {
            this.field_1516.method_2486().onLoadResource(this.field_1516, var2);
        }

    }

    public void onPageFinished(WebView var1, String var2) {
        class_378.method_2457("JavascriptAdWebViewClient::onPageFinished: " + var2);
        if(!this.field_1518) {
            this.field_1519.method_2795();
            this.field_1518 = true;
        }

    }

    public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
        class_378.method_2457("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + var2);
        if(this.method_2651(var2)) {
            class_378.method_2457("shouldOverrideUrlLoading: received passback url");
            return true;
        } else {
            return this.field_1516.method_2486().shouldOverrideUrlLoading(this.field_1516, var2);
        }
    }
}
