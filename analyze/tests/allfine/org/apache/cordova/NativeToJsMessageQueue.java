package org.apache.cordova;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;

public class NativeToJsMessageQueue {
    static final boolean DISABLE_EXEC_CHAINING = false;
    private static final boolean FORCE_ENCODE_USING_EVAL = false;
    private static final String LOG_TAG = "JsMessageQueue";
    private static int MAX_PAYLOAD_SIZE = 524288000;
    private NativeToJsMessageQueue.BridgeMode activeBridgeMode;
    private final CordovaInterface cordova;
    private boolean paused;
    private final LinkedList<NativeToJsMessageQueue.JsMessage> queue = new LinkedList();
    private final NativeToJsMessageQueue.BridgeMode[] registeredListeners;
    private final CordovaWebView webView;

    public NativeToJsMessageQueue(CordovaWebView var1, CordovaInterface var2) {
        this.cordova = var2;
        this.webView = var1;
        this.registeredListeners = new NativeToJsMessageQueue.BridgeMode[4];
        this.registeredListeners[0] = new NativeToJsMessageQueue.PollingBridgeMode();
        this.registeredListeners[1] = new NativeToJsMessageQueue.LoadUrlBridgeMode();
        this.registeredListeners[2] = new NativeToJsMessageQueue.OnlineEventsBridgeMode();
        this.registeredListeners[3] = new NativeToJsMessageQueue.PrivateApiBridgeMode();
        this.reset();
    }

    private int calculatePackedMessageLength(NativeToJsMessageQueue.JsMessage var1) {
        int var2 = var1.calculateEncodedLength();
        return 1 + var2 + String.valueOf(var2).length();
    }

    private void enqueueMessage(NativeToJsMessageQueue.JsMessage param1) {
        // $FF: Couldn't be decompiled
    }

    private void packMessage(NativeToJsMessageQueue.JsMessage var1, StringBuilder var2) {
        var2.append(var1.calculateEncodedLength()).append(' ');
        var1.encodeAsMessage(var2);
    }

    private String popAndEncodeAsJs() {
        // $FF: Couldn't be decompiled
    }

    public void addJavaScript(String var1) {
        this.enqueueMessage(new NativeToJsMessageQueue.JsMessage(var1));
    }

    public void addPluginResult(PluginResult var1, String var2) {
        if(var2 == null) {
            Log.e("JsMessageQueue", "Got plugin result with no callbackId", new Throwable());
        } else {
            boolean var3;
            if(var1.getStatus() == PluginResult.Status.NO_RESULT.ordinal()) {
                var3 = true;
            } else {
                var3 = false;
            }

            boolean var4 = var1.getKeepCallback();
            if(!var3 || !var4) {
                this.enqueueMessage(new NativeToJsMessageQueue.JsMessage(var1, var2));
                return;
            }
        }

    }

    public boolean isBridgeEnabled() {
        return this.activeBridgeMode != null;
    }

    public String popAndEncode(boolean param1) {
        // $FF: Couldn't be decompiled
    }

    public void reset() {
        // $FF: Couldn't be decompiled
    }

    public void setBridgeMode(int param1) {
        // $FF: Couldn't be decompiled
    }

    public void setPaused(boolean param1) {
        // $FF: Couldn't be decompiled
    }

    private abstract class BridgeMode {
        private BridgeMode() {
        }

        // $FF: synthetic method
        BridgeMode(Object var2) {
            this();
        }

        void notifyOfFlush(boolean var1) {
        }

        abstract void onNativeToJsMessageAvailable();

        void reset() {
        }
    }

    private static class JsMessage {
        final String jsPayloadOrCallbackId;
        final PluginResult pluginResult;

        JsMessage(String var1) {
            if(var1 == null) {
                throw new NullPointerException();
            } else {
                this.jsPayloadOrCallbackId = var1;
                this.pluginResult = null;
            }
        }

        JsMessage(PluginResult var1, String var2) {
            if(var2 != null && var1 != null) {
                this.jsPayloadOrCallbackId = var2;
                this.pluginResult = var1;
            } else {
                throw new NullPointerException();
            }
        }

        int calculateEncodedLength() {
            if(this.pluginResult == null) {
                return 1 + this.jsPayloadOrCallbackId.length();
            } else {
                int var1 = 1 + 1 + 2 + String.valueOf(this.pluginResult.getStatus()).length() + this.jsPayloadOrCallbackId.length();
                switch(this.pluginResult.getMessageType()) {
                    case 1:
                        return var1 + 1 + this.pluginResult.getStrMessage().length();
                    case 2:
                    default:
                        return var1 + this.pluginResult.getMessage().length();
                    case 3:
                        return var1 + 1 + this.pluginResult.getMessage().length();
                    case 4:
                    case 5:
                        return var1 + 1;
                    case 6:
                        return var1 + 1 + this.pluginResult.getMessage().length();
                    case 7:
                        return var1 + 1 + this.pluginResult.getMessage().length();
                }
            }
        }

        void encodeAsJsMessage(StringBuilder var1) {
            if(this.pluginResult == null) {
                var1.append(this.jsPayloadOrCallbackId);
            } else {
                int var2 = this.pluginResult.getStatus();
                boolean var3;
                if(var2 != PluginResult.Status.field_2155.ordinal() && var2 != PluginResult.Status.NO_RESULT.ordinal()) {
                    var3 = false;
                } else {
                    var3 = true;
                }

                var1.append("cordova.callbackFromNative(\'").append(this.jsPayloadOrCallbackId).append("\',").append(var3).append(",").append(var2).append(",[");
                switch(this.pluginResult.getMessageType()) {
                    case 6:
                        var1.append("cordova.require(\'cordova/base64\').toArrayBuffer(\'").append(this.pluginResult.getMessage()).append("\')");
                        break;
                    case 7:
                        var1.append("atob(\'").append(this.pluginResult.getMessage()).append("\')");
                        break;
                    default:
                        var1.append(this.pluginResult.getMessage());
                }

                var1.append("],").append(this.pluginResult.getKeepCallback()).append(");");
            }
        }

        void encodeAsMessage(StringBuilder var1) {
            if(this.pluginResult == null) {
                var1.append('J').append(this.jsPayloadOrCallbackId);
            } else {
                int var2 = this.pluginResult.getStatus();
                boolean var3;
                if(var2 == PluginResult.Status.NO_RESULT.ordinal()) {
                    var3 = true;
                } else {
                    var3 = false;
                }

                boolean var4;
                if(var2 == PluginResult.Status.field_2155.ordinal()) {
                    var4 = true;
                } else {
                    var4 = false;
                }

                boolean var5 = this.pluginResult.getKeepCallback();
                char var6;
                if(!var3 && !var4) {
                    var6 = 70;
                } else {
                    var6 = 83;
                }

                StringBuilder var7 = var1.append(var6);
                char var8;
                if(var5) {
                    var8 = 49;
                } else {
                    var8 = 48;
                }

                var7.append(var8).append(var2).append(' ').append(this.jsPayloadOrCallbackId).append(' ');
                switch(this.pluginResult.getMessageType()) {
                    case 1:
                        var1.append('s');
                        var1.append(this.pluginResult.getStrMessage());
                        return;
                    case 2:
                    default:
                        var1.append(this.pluginResult.getMessage());
                        return;
                    case 3:
                        var1.append('n').append(this.pluginResult.getMessage());
                        return;
                    case 4:
                        var1.append(this.pluginResult.getMessage().charAt(0));
                        return;
                    case 5:
                        var1.append('N');
                        return;
                    case 6:
                        var1.append('A');
                        var1.append(this.pluginResult.getMessage());
                        return;
                    case 7:
                        var1.append('S');
                        var1.append(this.pluginResult.getMessage());
                }
            }
        }
    }

    private class LoadUrlBridgeMode extends NativeToJsMessageQueue.BridgeMode {
        final Runnable runnable;

        private LoadUrlBridgeMode() {
            super();
            this.runnable = new Runnable() {
                public void run() {
                    String var1 = NativeToJsMessageQueue.this.popAndEncodeAsJs();
                    if(var1 != null) {
                        NativeToJsMessageQueue.this.webView.loadUrlNow("javascript:" + var1);
                    }

                }
            };
        }

        // $FF: synthetic method
        LoadUrlBridgeMode(Object var2) {
            this();
        }

        void onNativeToJsMessageAvailable() {
            NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.runnable);
        }
    }

    private class OnlineEventsBridgeMode extends NativeToJsMessageQueue.BridgeMode {
        private boolean ignoreNextFlush;
        private boolean online;
        final Runnable resetNetworkRunnable;
        final Runnable toggleNetworkRunnable;

        private OnlineEventsBridgeMode() {
            super();
            this.toggleNetworkRunnable = new Runnable() {
                public void run() {
                    if(!NativeToJsMessageQueue.this.queue.isEmpty()) {
                        OnlineEventsBridgeMode.this.ignoreNextFlush = false;
                        NativeToJsMessageQueue.this.webView.setNetworkAvailable(OnlineEventsBridgeMode.this.online);
                    }

                }
            };
            this.resetNetworkRunnable = new Runnable() {
                public void run() {
                    OnlineEventsBridgeMode.this.online = false;
                    OnlineEventsBridgeMode.this.ignoreNextFlush = true;
                    NativeToJsMessageQueue.this.webView.setNetworkAvailable(true);
                }
            };
        }

        // $FF: synthetic method
        OnlineEventsBridgeMode(Object var2) {
            this();
        }

        void notifyOfFlush(boolean var1) {
            if(var1 && !this.ignoreNextFlush) {
                boolean var2;
                if(!this.online) {
                    var2 = true;
                } else {
                    var2 = false;
                }

                this.online = var2;
            }

        }

        void onNativeToJsMessageAvailable() {
            NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.toggleNetworkRunnable);
        }

        void reset() {
            NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.resetNetworkRunnable);
        }
    }

    private class PollingBridgeMode extends NativeToJsMessageQueue.BridgeMode {
        private PollingBridgeMode() {
            super();
        }

        // $FF: synthetic method
        PollingBridgeMode(Object var2) {
            this();
        }

        void onNativeToJsMessageAvailable() {
        }
    }

    private class PrivateApiBridgeMode extends NativeToJsMessageQueue.BridgeMode {
        private static final int EXECUTE_JS = 194;
        boolean initFailed;
        Method sendMessageMethod;
        Object webViewCore;

        private PrivateApiBridgeMode() {
            super();
        }

        // $FF: synthetic method
        PrivateApiBridgeMode(Object var2) {
            this();
        }

        private void initReflection() {
            Object var1 = NativeToJsMessageQueue.this.webView;
            Class var2 = WebView.class;

            label20: {
                Class var8;
                try {
                    Field var7 = var2.getDeclaredField("mProvider");
                    var7.setAccessible(true);
                    var1 = var7.get(NativeToJsMessageQueue.this.webView);
                    var8 = var1.getClass();
                } catch (Throwable var10) {
                    break label20;
                }

                var2 = var8;
            }

            try {
                Field var6 = var2.getDeclaredField("mWebViewCore");
                var6.setAccessible(true);
                this.webViewCore = var6.get(var1);
                if(this.webViewCore != null) {
                    this.sendMessageMethod = this.webViewCore.getClass().getDeclaredMethod("sendMessage", new Class[] {Message.class});
                    this.sendMessageMethod.setAccessible(true);
                }

            } catch (Throwable var9) {
                this.initFailed = true;
                Log.e("JsMessageQueue", "PrivateApiBridgeMode failed to find the expected APIs.", var9);
            }
        }

        void onNativeToJsMessageAvailable() {
            if(this.sendMessageMethod == null && !this.initFailed) {
                this.initReflection();
            }

            if(this.sendMessageMethod != null) {
                Message var1 = Message.obtain((Handler)null, 194, NativeToJsMessageQueue.this.popAndEncodeAsJs());

                try {
                    this.sendMessageMethod.invoke(this.webViewCore, new Object[] {var1});
                } catch (Throwable var3) {
                    Log.e("JsMessageQueue", "Reflection message bridge failed.", var3);
                    return;
                }
            }

        }
    }
}
