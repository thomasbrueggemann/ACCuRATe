package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_487;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.gx
@ez
public class class_366 extends WebChromeClient {
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private final class_381 field_1342;

    public class_366(class_381 var1) {
        this.field_1342 = var1;
    }

    // $FF: renamed from: a (android.app.AlertDialog.Builder, java.lang.String, android.webkit.JsResult) void
    private static void method_2410(Builder var0, String var1, final JsResult var2) {
        var0.setMessage(var1).setPositiveButton(17039370, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2x) {
                var2.confirm();
            }
        }).setNegativeButton(17039360, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2x) {
                var2.cancel();
            }
        }).setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface var1) {
                var2.cancel();
            }
        }).create().show();
    }

    // $FF: renamed from: a (android.content.Context, android.app.AlertDialog.Builder, java.lang.String, java.lang.String, android.webkit.JsPromptResult) void
    private static void method_2411(Context var0, Builder var1, String var2, String var3, final JsPromptResult var4) {
        LinearLayout var5 = new LinearLayout(var0);
        var5.setOrientation(1);
        TextView var6 = new TextView(var0);
        var6.setText(var2);
        final EditText var7 = new EditText(var0);
        var7.setText(var3);
        var5.addView(var6);
        var5.addView(var7);
        var1.setView(var5).setPositiveButton(17039370, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
                var4.confirm(var7.getText().toString());
            }
        }).setNegativeButton(17039360, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
                var4.cancel();
            }
        }).setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface var1) {
                var4.cancel();
            }
        }).create().show();
    }

    // $FF: renamed from: c (android.webkit.WebView) android.content.Context
    private final Context method_2412(WebView var1) {
        Context var3;
        if(!(var1 instanceof class_381)) {
            var3 = var1.getContext();
        } else {
            class_381 var2 = (class_381)var1;
            var3 = var2.method_2491();
            if(var3 == null) {
                return var2.getContext();
            }
        }

        return var3;
    }

    // $FF: renamed from: a (android.view.View, int, android.webkit.WebChromeClient.CustomViewCallback) void
    protected final void method_2413(View var1, int var2, CustomViewCallback var3) {
        class_487 var4 = this.field_1342.method_2485();
        if(var4 == null) {
            class_378.method_2461("Could not get ad overlay when showing custom view.");
            var3.onCustomViewHidden();
        } else {
            var4.method_2978(var1, var3);
            var4.setRequestedOrientation(var2);
        }
    }

    // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, java.lang.String, android.webkit.JsResult, android.webkit.JsPromptResult, boolean) boolean
    protected boolean method_2414(Context param1, String param2, String param3, String param4, JsResult param5, JsPromptResult param6, boolean param7) {
        // $FF: Couldn't be decompiled
    }

    public final void onCloseWindow(WebView var1) {
        if(!(var1 instanceof class_381)) {
            class_378.method_2461("Tried to close a WebView that wasn\'t an AdWebView.");
        } else {
            class_487 var2 = ((class_381)var1).method_2485();
            if(var2 == null) {
                class_378.method_2461("Tried to close an AdWebView not associated with an overlay.");
            } else {
                var2.close();
            }
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage var1) {
        String var2 = "JS: " + var1.message() + " (" + var1.sourceId() + ":" + var1.lineNumber() + ")";
        if(var2.contains("Application Cache")) {
            return super.onConsoleMessage(var1);
        } else {
            switch(null.field_1034[var1.messageLevel().ordinal()]) {
                case 1:
                    class_378.method_2458(var2);
                    break;
                case 2:
                    class_378.method_2461(var2);
                    break;
                case 3:
                case 4:
                    class_378.method_2459(var2);
                    break;
                case 5:
                    class_378.method_2457(var2);
                    break;
                default:
                    class_378.method_2459(var2);
            }

            return super.onConsoleMessage(var1);
        }
    }

    public final boolean onCreateWindow(WebView var1, boolean var2, boolean var3, Message var4) {
        WebViewTransport var5 = (WebViewTransport)var4.obj;
        WebView var6 = new WebView(var1.getContext());
        var6.setWebViewClient(this.field_1342.method_2486());
        var5.setWebView(var6);
        var4.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String var1, String var2, long var3, long var5, long var7, QuotaUpdater var9) {
        long var10 = 5242880L - var7;
        if(var10 <= 0L) {
            var9.updateQuota(var3);
        } else {
            if(var3 == 0L) {
                if(var5 > var10 || var5 > 1048576L) {
                    var5 = 0L;
                }
            } else if(var5 == 0L) {
                var5 = Math.min(var3 + Math.min(131072L, var10), 1048576L);
            } else {
                if(var5 <= Math.min(1048576L - var3, var10)) {
                    var3 += var5;
                }

                var5 = var3;
            }

            var9.updateQuota(var5);
        }
    }

    public final void onHideCustomView() {
        class_487 var1 = this.field_1342.method_2485();
        if(var1 == null) {
            class_378.method_2461("Could not get ad overlay when hiding custom view.");
        } else {
            var1.method_2981();
        }
    }

    public final boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
        return this.method_2414(this.method_2412(var1), var2, var3, (String)null, var4, (JsPromptResult)null, false);
    }

    public final boolean onJsBeforeUnload(WebView var1, String var2, String var3, JsResult var4) {
        return this.method_2414(this.method_2412(var1), var2, var3, (String)null, var4, (JsPromptResult)null, false);
    }

    public final boolean onJsConfirm(WebView var1, String var2, String var3, JsResult var4) {
        return this.method_2414(this.method_2412(var1), var2, var3, (String)null, var4, (JsPromptResult)null, false);
    }

    public final boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
        return this.method_2414(this.method_2412(var1), var2, var3, var4, (JsResult)null, var5, true);
    }

    public final void onReachedMaxAppCacheSize(long var1, long var3, QuotaUpdater var5) {
        long var6 = 5242880L - var3;
        long var8 = 131072L + var1;
        if(var6 < var8) {
            var5.updateQuota(0L);
        } else {
            var5.updateQuota(var8);
        }
    }

    public final void onShowCustomView(View var1, CustomViewCallback var2) {
        this.method_2413(var1, -1, var2);
    }
}
