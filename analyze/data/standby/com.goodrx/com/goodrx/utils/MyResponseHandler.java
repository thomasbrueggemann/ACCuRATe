package com.goodrx.utils;

import android.app.Activity;
import android.content.Context;
import com.goodrx.activity.InternetErrorActivity;
import com.goodrx.activity.ServerErrorActivity;
import cz.msebera.android.httpclient.Header;

public abstract class MyResponseHandler {
   private Context context;

   public MyResponseHandler(Context var1) {
      this.context = var1;
   }

   public Context getContext() {
      return this.context;
   }

   public void onFailure(int var1, Header[] var2, byte[] var3, Throwable var4, String var5) {
      if(this.context instanceof Activity) {
         if(var1 != 0) {
            ServerErrorActivity.launch((Activity)this.context, var1, var5);
            return;
         }

         InternetErrorActivity.launch((Activity)this.context);
      }

   }

   public abstract void onSuccess(String var1);
}
