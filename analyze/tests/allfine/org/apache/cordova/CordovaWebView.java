package org.apache.cordova;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaBridge;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.ExposedJsApi;
import org.apache.cordova.IceCreamCordovaWebViewClient;
import org.apache.cordova.LOG;
import org.apache.cordova.NativeToJsMessageQueue;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import org.apache.cordova.ScrollEvent;
import org.apache.cordova.Whitelist;

public class CordovaWebView extends WebView {
    public static final String CORDOVA_VERSION = "3.6.4";
    static final LayoutParams COVER_SCREEN_GRAVITY_CENTER = new LayoutParams(-1, -1, 17);
    public static final String TAG = "CordovaWebView";
    private HashSet<Integer> boundKeyCodes;
    CordovaBridge bridge;
    private CordovaChromeClient chromeClient;
    private CordovaInterface cordova;
    private Whitelist externalWhitelist;
    private Whitelist internalWhitelist;
    private long lastMenuEventTime;
    int loadUrlTimeout;
    String loadedUrl;
    private View mCustomView;
    private CustomViewCallback mCustomViewCallback;
    private boolean paused;
    public PluginManager pluginManager;
    private CordovaPreferences preferences;
    private BroadcastReceiver receiver;
    private CordovaResourceApi resourceApi;
    CordovaWebViewClient viewClient;

    public CordovaWebView(Context var1) {
        this(var1, (AttributeSet)null);
    }

    public CordovaWebView(Context var1, AttributeSet var2) {
        super(var1, var2);
        this.boundKeyCodes = new HashSet();
        this.loadUrlTimeout = 0;
        this.lastMenuEventTime = 0L;
    }

    @Deprecated
    public CordovaWebView(Context var1, AttributeSet var2, int var3) {
        super(var1, var2, var3);
        this.boundKeyCodes = new HashSet();
        this.loadUrlTimeout = 0;
        this.lastMenuEventTime = 0L;
    }

    @Deprecated
    @TargetApi(11)
    public CordovaWebView(Context var1, AttributeSet var2, int var3, boolean var4) {
        super(var1, var2, var3, var4);
        this.boundKeyCodes = new HashSet();
        this.loadUrlTimeout = 0;
        this.lastMenuEventTime = 0L;
    }

    @TargetApi(19)
    private void enableRemoteDebugging() {
        try {
            WebView.setWebContentsDebuggingEnabled(true);
        } catch (IllegalArgumentException var2) {
            Log.d("CordovaWebView", "You have one job! To turn on Remote Web Debugging! YOU HAVE FAILED! ");
            var2.printStackTrace();
        }
    }

    private void exposeJsInterface() {
        if(VERSION.SDK_INT < 17) {
            Log.i("CordovaWebView", "Disabled addJavascriptInterface() bridge since Android version is old.");
        } else {
            this.addJavascriptInterface(new ExposedJsApi(this.bridge), "_cordovaNative");
        }
    }

    private void initIfNecessary() {
        if(this.pluginManager == null) {
            Log.w("CordovaWebView", "CordovaWebView.init() was not called. This will soon be required.");
            CordovaInterface var2 = (CordovaInterface)this.getContext();
            if(!Config.isInitialized()) {
                Config.init(var2.getActivity());
            }

            this.init(var2, this.makeWebViewClient(var2), this.makeWebChromeClient(var2), Config.getPluginEntries(), Config.getWhitelist(), Config.getExternalWhitelist(), Config.getPreferences());
        }

    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebViewSettings() {
        this.setInitialScale(0);
        this.setVerticalScrollBarEnabled(false);
        if(this.shouldRequestFocusOnInit()) {
            this.requestFocusFromTouch();
        }

        WebSettings var1 = this.getSettings();
        var1.setJavaScriptEnabled(true);
        var1.setJavaScriptCanOpenWindowsAutomatically(true);
        var1.setLayoutAlgorithm(LayoutAlgorithm.NORMAL);

        try {
            Class[] var14 = new Class[] {Boolean.TYPE};
            Method var15 = WebSettings.class.getMethod("setNavDump", var14);
            String var16 = Build.MANUFACTURER;
            Log.d("CordovaWebView", "CordovaWebView is running on device made by: " + var16);
            if(VERSION.SDK_INT < 11 && Build.MANUFACTURER.contains("HTC")) {
                Object[] var18 = new Object[] {Boolean.valueOf(true)};
                var15.invoke(var1, var18);
            }
        } catch (NoSuchMethodException var19) {
            Log.d("CordovaWebView", "We are on a modern version of Android, we will deprecate HTC 2.3 devices in 2.8");
        } catch (IllegalArgumentException var20) {
            Log.d("CordovaWebView", "Doing the NavDump failed with bad arguments");
        } catch (IllegalAccessException var21) {
            Log.d("CordovaWebView", "This should never happen: IllegalAccessException means this isn\'t Android anymore");
        } catch (InvocationTargetException var22) {
            Log.d("CordovaWebView", "This should never happen: InvocationTargetException means this isn\'t Android anymore.");
        }

        var1.setSaveFormData(false);
        var1.setSavePassword(false);
        if(VERSION.SDK_INT > 15) {
            CordovaWebView.Level16Apis.enableUniversalAccess(var1);
        }

        String var4 = this.getContext().getApplicationContext().getDir("database", 0).getPath();
        var1.setDatabaseEnabled(true);
        var1.setDatabasePath(var4);
        if((2 & this.getContext().getApplicationContext().getApplicationInfo().flags) != 0 && VERSION.SDK_INT >= 19) {
            this.enableRemoteDebugging();
        }

        var1.setGeolocationDatabasePath(var4);
        var1.setDomStorageEnabled(true);
        var1.setGeolocationEnabled(true);
        var1.setAppCacheMaxSize(5242880L);
        var1.setAppCachePath(var4);
        var1.setAppCacheEnabled(true);
        var1.getUserAgentString();
        IntentFilter var6 = new IntentFilter();
        var6.addAction("android.intent.action.CONFIGURATION_CHANGED");
        if(this.receiver == null) {
            this.receiver = new BroadcastReceiver() {
                public void onReceive(Context var1, Intent var2) {
                    CordovaWebView.this.getSettings().getUserAgentString();
                }
            };
            this.getContext().registerReceiver(this.receiver, var6);
        }

    }

    public boolean backHistory() {
        if(super.canGoBack()) {
            super.goBack();
            return true;
        } else {
            return false;
        }
    }

    @Deprecated
    public void bindButton(int var1, boolean var2, boolean var3) {
        this.setButtonPlumbedToJs(var1, var3);
    }

    @Deprecated
    public void bindButton(String var1, boolean var2) {
        if(var1.compareTo("volumeup") == 0) {
            this.setButtonPlumbedToJs(24, var2);
        } else if(var1.compareTo("volumedown") == 0) {
            this.setButtonPlumbedToJs(25, var2);
            return;
        }

    }

    @Deprecated
    public void bindButton(boolean var1) {
        this.setButtonPlumbedToJs(4, var1);
    }

    public Whitelist getExternalWhitelist() {
        return this.externalWhitelist;
    }

    public CordovaPreferences getPreferences() {
        return this.preferences;
    }

    public String getProperty(String var1, String var2) {
        Bundle var3 = this.cordova.getActivity().getIntent().getExtras();
        if(var3 != null) {
            Object var4 = var3.get(var1.toLowerCase(Locale.getDefault()));
            if(var4 != null) {
                return var4.toString();
            }
        }

        return var2;
    }

    public CordovaResourceApi getResourceApi() {
        return this.resourceApi;
    }

    public CordovaChromeClient getWebChromeClient() {
        return this.chromeClient;
    }

    public Whitelist getWhitelist() {
        return this.internalWhitelist;
    }

    @Deprecated
    public boolean hadKeyEvent() {
        return false;
    }

    public void handleDestroy() {
        this.loadUrl("javascript:try{cordova.require(\'cordova/channel\').onDestroy.fire();}catch(e){console.log(\'exception firing destroy event from native\');};");
        this.loadUrl("about:blank");
        if(this.pluginManager != null) {
            this.pluginManager.onDestroy();
        }

        if(this.receiver != null) {
            try {
                this.getContext().unregisterReceiver(this.receiver);
            } catch (Exception var2) {
                Log.e("CordovaWebView", "Error unregistering configuration receiver: " + var2.getMessage(), var2);
                return;
            }
        }

    }

    public void handlePause(boolean var1) {
        LOG.method_4279("CordovaWebView", "Handle the pause");
        this.loadUrl("javascript:try{cordova.fireDocumentEvent(\'pause\');}catch(e){console.log(\'exception firing pause event from native\');};");
        if(this.pluginManager != null) {
            this.pluginManager.onPause(var1);
        }

        if(!var1) {
            this.pauseTimers();
        }

        this.paused = true;
    }

    public void handleResume(boolean var1, boolean var2) {
        this.loadUrl("javascript:try{cordova.fireDocumentEvent(\'resume\');}catch(e){console.log(\'exception firing resume event from native\');};");
        if(this.pluginManager != null) {
            this.pluginManager.onResume(var1);
        }

        this.resumeTimers();
        this.paused = false;
    }

    public void hideCustomView() {
        Log.d("CordovaWebView", "Hiding Custom View");
        if(this.mCustomView != null) {
            this.mCustomView.setVisibility(8);
            ((ViewGroup)this.getParent()).removeView(this.mCustomView);
            this.mCustomView = null;
            this.mCustomViewCallback.onCustomViewHidden();
            this.setVisibility(0);
        }
    }

    public void init(CordovaInterface var1, CordovaWebViewClient var2, CordovaChromeClient var3, List<PluginEntry> var4, Whitelist var5, Whitelist var6, CordovaPreferences var7) {
        if(this.cordova != null) {
            throw new IllegalStateException();
        } else {
            this.cordova = var1;
            this.viewClient = var2;
            this.chromeClient = var3;
            this.internalWhitelist = var5;
            this.externalWhitelist = var6;
            this.preferences = var7;
            super.setWebChromeClient(var3);
            super.setWebViewClient(var2);
            this.pluginManager = new PluginManager(this, this.cordova, var4);
            this.bridge = new CordovaBridge(this.pluginManager, new NativeToJsMessageQueue(this, var1));
            this.resourceApi = new CordovaResourceApi(this.getContext(), this.pluginManager);
            this.pluginManager.addService("App", "org.apache.cordova.App");
            this.initWebViewSettings();
            this.exposeJsInterface();
        }
    }

    @Deprecated
    public boolean isBackButtonBound() {
        return this.isButtonPlumbedToJs(4);
    }

    public boolean isButtonPlumbedToJs(int var1) {
        return this.boundKeyCodes.contains(Integer.valueOf(var1));
    }

    public boolean isCustomViewShowing() {
        return this.mCustomView != null;
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void loadUrl(String var1) {
        if(!var1.equals("about:blank") && !var1.startsWith("javascript:")) {
            this.loadUrlIntoView(var1);
        } else {
            this.loadUrlNow(var1);
        }
    }

    @Deprecated
    public void loadUrl(String var1, int var2) {
        if(var1 == null) {
            this.loadUrlIntoView(Config.getStartUrl());
        } else {
            this.loadUrlIntoView(var1);
        }
    }

    public void loadUrlIntoView(String var1) {
        this.loadUrlIntoView(var1, true);
    }

    public void loadUrlIntoView(String var1, int var2) {
        if(!var1.startsWith("javascript:") && !this.canGoBack()) {
            Object[] var3 = new Object[] {var1, Integer.valueOf(var2)};
            LOG.method_4281("CordovaWebView", "loadUrlIntoView(%s, %d)", var3);
            this.postMessage("splashscreen", "show");
        }

        this.loadUrlIntoView(var1);
    }

    public void loadUrlIntoView(final String var1, boolean var2) {
        LOG.method_4279("CordovaWebView", ">>> loadUrl(" + var1 + ")");
        this.initIfNecessary();
        if(var2) {
            this.loadedUrl = var1;
            this.pluginManager.init();
        }

        final int var3 = this.loadUrlTimeout;
        final Runnable var4 = new Runnable() {
            // $FF: synthetic field
            final Runnable val$loadError;
            // $FF: synthetic field
            final int val$loadUrlTimeoutValue;

            {
                this.val$loadUrlTimeoutValue = var2;
                this.val$loadError = var5;
            }

            public void run() {
                // $FF: Couldn't be decompiled
            }
        };
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                CordovaWebView.this.cordova.getThreadPool().execute(var4);
                CordovaWebView.this.loadUrlNow(var1);
            }
        });
    }

    void loadUrlNow(String var1) {
        if(LOG.isLoggable(3) && !var1.startsWith("javascript:")) {
            LOG.method_4279("CordovaWebView", ">>> loadUrlNow()");
        }

        if(var1.startsWith("file://") || var1.startsWith("javascript:") || this.internalWhitelist.isUrlWhiteListed(var1)) {
            super.loadUrl(var1);
        }

    }

    public CordovaChromeClient makeWebChromeClient(CordovaInterface var1) {
        return new CordovaChromeClient(var1, this);
    }

    public CordovaWebViewClient makeWebViewClient(CordovaInterface var1) {
        return (CordovaWebViewClient)(VERSION.SDK_INT < 14?new CordovaWebViewClient(var1, this):new IceCreamCordovaWebViewClient(var1, this));
    }

    public boolean onKeyDown(int var1, KeyEvent var2) {
        if(this.boundKeyCodes.contains(Integer.valueOf(var1))) {
            if(var1 == 25) {
                this.loadUrl("javascript:cordova.fireDocumentEvent(\'volumedownbutton\');");
                return true;
            } else if(var1 == 24) {
                this.loadUrl("javascript:cordova.fireDocumentEvent(\'volumeupbutton\');");
                return true;
            } else {
                return super.onKeyDown(var1, var2);
            }
        } else if(var1 != 4) {
            if(var1 == 82) {
                View var3 = this.getFocusedChild();
                if(var3 != null) {
                    ((InputMethodManager)this.cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(var3.getWindowToken(), 0);
                    this.cordova.getActivity().openOptionsMenu();
                    return true;
                } else {
                    return super.onKeyDown(var1, var2);
                }
            } else {
                return super.onKeyDown(var1, var2);
            }
        } else {
            boolean var5;
            if(this.startOfHistory()) {
                boolean var6 = this.isButtonPlumbedToJs(4);
                var5 = false;
                if(!var6) {
                    return var5;
                }
            }

            var5 = true;
            return var5;
        }
    }

    public boolean onKeyUp(int var1, KeyEvent var2) {
        if(var1 == 4) {
            if(this.mCustomView != null) {
                this.hideCustomView();
                return true;
            }

            if(this.isButtonPlumbedToJs(4)) {
                this.loadUrl("javascript:cordova.fireDocumentEvent(\'backbutton\');");
                return true;
            }

            if(this.backHistory()) {
                return true;
            }
        } else {
            if(var1 == 82) {
                if(this.lastMenuEventTime < var2.getEventTime()) {
                    this.loadUrl("javascript:cordova.fireDocumentEvent(\'menubutton\');");
                }

                this.lastMenuEventTime = var2.getEventTime();
                return super.onKeyUp(var1, var2);
            }

            if(var1 == 84) {
                this.loadUrl("javascript:cordova.fireDocumentEvent(\'searchbutton\');");
                return true;
            }
        }

        return super.onKeyUp(var1, var2);
    }

    public void onNewIntent(Intent var1) {
        if(this.pluginManager != null) {
            this.pluginManager.onNewIntent(var1);
        }

    }

    public void onScrollChanged(int var1, int var2, int var3, int var4) {
        super.onScrollChanged(var1, var2, var3, var4);
        this.postMessage("onScrollChanged", new ScrollEvent(var1, var2, var3, var4, this));
    }

    public void postMessage(String var1, Object var2) {
        if(this.pluginManager != null) {
            this.pluginManager.postMessage(var1, var2);
        }

    }

    public void printBackForwardList() {
        WebBackForwardList var1 = this.copyBackForwardList();
        int var2 = var1.getSize();

        for(int var3 = 0; var3 < var2; ++var3) {
            String var4 = var1.getItemAtIndex(var3).getUrl();
            LOG.method_4279("CordovaWebView", "The URL at index: " + Integer.toString(var3) + " is " + var4);
        }

    }

    public WebBackForwardList restoreState(Bundle var1) {
        WebBackForwardList var2 = super.restoreState(var1);
        Log.d("CordovaWebView", "WebView restoration crew now restoring!");
        this.pluginManager.init();
        return var2;
    }

    @Deprecated
    public void sendJavascript(String var1) {
        this.bridge.getMessageQueue().addJavaScript(var1);
    }

    public void sendPluginResult(PluginResult var1, String var2) {
        this.bridge.getMessageQueue().addPluginResult(var1, var2);
    }

    public void setButtonPlumbedToJs(int var1, boolean var2) {
        switch(var1) {
            case 4:
            case 24:
            case 25:
                if(var2) {
                    this.boundKeyCodes.add(Integer.valueOf(var1));
                    return;
                }

                this.boundKeyCodes.remove(Integer.valueOf(var1));
                return;
            default:
                throw new IllegalArgumentException("Unsupported keycode: " + var1);
        }
    }

    public void setWebChromeClient(WebChromeClient var1) {
        this.chromeClient = (CordovaChromeClient)var1;
        super.setWebChromeClient(var1);
    }

    public void setWebViewClient(WebViewClient var1) {
        this.viewClient = (CordovaWebViewClient)var1;
        super.setWebViewClient(var1);
    }

    protected boolean shouldRequestFocusOnInit() {
        return true;
    }

    public void showCustomView(View var1, CustomViewCallback var2) {
        Log.d("CordovaWebView", "showing Custom View");
        if(this.mCustomView != null) {
            var2.onCustomViewHidden();
        } else {
            this.mCustomView = var1;
            this.mCustomViewCallback = var2;
            ViewGroup var4 = (ViewGroup)this.getParent();
            var4.addView(var1, COVER_SCREEN_GRAVITY_CENTER);
            this.setVisibility(8);
            var4.setVisibility(0);
            var4.bringToFront();
        }
    }

    public void showWebPage(String param1, boolean param2, boolean param3, HashMap<String, Object> param4) {
        // $FF: Couldn't be decompiled
    }

    public boolean startOfHistory() {
        WebHistoryItem var1 = this.copyBackForwardList().getItemAtIndex(0);
        boolean var2 = false;
        if(var1 != null) {
            String var3 = var1.getUrl();
            String var4 = this.getUrl();
            LOG.method_4279("CordovaWebView", "The current URL is: " + var4);
            LOG.method_4279("CordovaWebView", "The URL at item 0 is: " + var3);
            var2 = var4.equals(var3);
        }

        return var2;
    }

    public void stopLoading() {
        this.viewClient.isCurrentlyLoading = false;
        super.stopLoading();
    }

    @Deprecated
    public void storeResult(int var1, int var2, Intent var3) {
    }

    class ActivityResult {
        Intent incoming;
        int request;
        int result;

        public ActivityResult(int var2, int var3, Intent var4) {
            this.request = var2;
            this.result = var3;
            this.incoming = var4;
        }
    }

    @TargetApi(16)
    private static class Level16Apis {
        static void enableUniversalAccess(WebSettings var0) {
            var0.setAllowUniversalAccessFromFileURLs(true);
        }
    }
}
