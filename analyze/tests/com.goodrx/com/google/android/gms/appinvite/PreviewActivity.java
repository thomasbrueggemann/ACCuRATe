package com.google.android.gms.appinvite;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.TextView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;

@Instrumented
public class PreviewActivity extends Activity implements TraceFieldInterface {
   private View zza(Context var1, ViewGroup var2, Bundle var3) {
      int var4 = var3.getInt("com.google.android.gms.appinvite.LAYOUT_RES_ID");
      View var5 = LayoutInflater.from(var1).inflate(var4, var2, false);
      ArrayList var6 = var3.getParcelableArrayList("com.google.android.gms.appinvite.VIEWS");
      if(var6 != null) {
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            this.zza(var5, (Bundle)var7.next());
         }
      }

      return var5;
   }

   private void zza(View var1, Bundle var2) {
      View var3 = var1.findViewById(var2.getInt("View_id"));
      Iterator var4 = var2.keySet().iterator();

      while(true) {
         while(var4.hasNext()) {
            String var5;
            byte var6;
            label63: {
               var5 = (String)var4.next();
               switch(var5.hashCode()) {
               case -1829808865:
                  if(var5.equals("View_minHeight")) {
                     var6 = 1;
                     break label63;
                  }
                  break;
               case -499175494:
                  if(var5.equals("TextView_text")) {
                     var6 = 3;
                     break label63;
                  }
                  break;
               case -111184848:
                  if(var5.equals("WebView_data")) {
                     var6 = 6;
                     break label63;
                  }
                  break;
               case 573559753:
                  if(var5.equals("TextView_textColor")) {
                     var6 = 4;
                     break label63;
                  }
                  break;
               case 966644059:
                  if(var5.equals("View_backgroundColor")) {
                     var6 = 0;
                     break label63;
                  }
                  break;
               case 1729346977:
                  if(var5.equals("TextView_isTitle")) {
                     var6 = 5;
                     break label63;
                  }
                  break;
               case 1920443715:
                  if(var5.equals("View_onClickListener")) {
                     var6 = 2;
                     break label63;
                  }
               }

               var6 = -1;
            }

            switch(var6) {
            case 0:
               var3.setBackgroundColor(var2.getInt(var5));
               break;
            case 1:
               var3.setMinimumHeight(var2.getInt(var5));
               break;
            case 2:
               String var8 = var2.getString(var5);
               byte var9;
               switch(var8.hashCode()) {
               case 94756344:
                  if(var8.equals("close")) {
                     var9 = 0;
                     break;
                  }
               default:
                  var9 = -1;
               }

               switch(var9) {
               case 0:
                  var3.setOnClickListener(new OnClickListener() {
                     public void onClick(View var1) {
                        PreviewActivity.this.finish();
                     }
                  });
                  continue;
               }
            case 3:
               if(var3 instanceof TextView) {
                  ((TextView)var3).setText(var2.getCharSequence(var5));
               }
               break;
            case 4:
               if(var3 instanceof TextView) {
                  ((TextView)var3).setTextColor(var2.getInt(var5));
               }
               break;
            case 5:
               if(var3 instanceof TextView && var2.getBoolean(var5)) {
                  this.setTitle(((TextView)var3).getText());
               }
               break;
            case 6:
               if(var3 instanceof ViewGroup) {
                  WebView var7 = new WebView(this);
                  var7.loadData(var2.getString(var5), "text/html; charset=utf-8", "UTF-8");
                  ((ViewGroup)var3).addView(var7, new LayoutParams(-1, -1));
               }
            }
         }

         return;
      }
   }

   protected void onCreate(Bundle param1) {
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
