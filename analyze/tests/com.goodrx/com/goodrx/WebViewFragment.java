package com.goodrx;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.MyProgressBar;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class WebViewFragment extends Fragment implements TraceFieldInterface {
   private static final String ENABLE_JAVA_SCRIPT = "enable_java_script";
   private static final String URL = "url";
   private boolean enableJavaScript;
   private MyProgressBar myProgressBar;
   private String url;
   private WebView webView;

   public static WebViewFragment newInstance(String var0, boolean var1) {
      WebViewFragment var2 = new WebViewFragment();
      Bundle var3 = new Bundle();
      var3.putString("url", var0);
      var3.putBoolean("enable_java_script", var1);
      var2.setArguments(var3);
      return var2;
   }

   public void getHtmlString(String var1) {
      this.myProgressBar.show();
      GoodRxAPI.getInstance().getStaticContent(this.getActivity(), var1, new OnRequestFinishListener() {
         public void onSuccess(String var1) {
            WebViewFragment.this.myProgressBar.dismiss();
            WebViewFragment.this.webView.loadDataWithBaseURL((String)null, "<style type = \"text/css\">\n\tbody {padding: 15px 8px;}\n</style>" + var1, "text/html", "utf-8", (String)null);
         }
      });
   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public View onCreateView(LayoutInflater param1, ViewGroup param2, Bundle param3) {
      // $FF: Couldn't be decompiled
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }
}
