package com.goodrx.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.goodrx.utils.DialogHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GrxWebView extends WebView {
   public GrxWebView(Context var1) {
      super(var1);
      this.init(var1);
   }

   public GrxWebView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
   }

   private void init(Context var1) {
      this.setWebViewClient(new GrxWebView.WebClient());
   }

   private class WebClient extends WebViewClient {
      private List<String> mInternalUrl = new ArrayList();

      public WebClient() {
         this.mInternalUrl.add("m.goodrx.com");
         this.mInternalUrl.add("www.goodrx.com");
      }

      private boolean isInternalUrl(String var1) {
         if(var1 != null) {
            Iterator var2 = this.mInternalUrl.iterator();

            while(var2.hasNext()) {
               String var3 = (String)var2.next();
               if(var1.toLowerCase().contains(var3)) {
                  return true;
               }
            }
         }

         return false;
      }

      public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
         if(!this.isInternalUrl(var2)) {
            DialogHelper.openExternalWebsite(GrxWebView.this.getContext(), var2).show();
         } else {
            GrxWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var2)));
         }

         return true;
      }
   }
}
