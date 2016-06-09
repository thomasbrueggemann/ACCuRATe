package com.loopj.android.http;

import android.os.Message;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import cz.msebera.android.httpclient.HttpEntity;
import java.io.IOException;

public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
   private static final String LOG_TAG = "DataAsyncHttpRH";
   protected static final int PROGRESS_DATA_MESSAGE = 7;

   public static byte[] copyOfRange(byte[] var0, int var1, int var2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException {
      if(var1 > var2) {
         throw new IllegalArgumentException();
      } else {
         int var3 = var0.length;
         if(var1 >= 0 && var1 <= var3) {
            int var4 = var2 - var1;
            int var5 = Math.min(var4, var3 - var1);
            byte[] var6 = new byte[var4];
            System.arraycopy(var0, var1, var6, 0, var5);
            return var6;
         } else {
            throw new ArrayIndexOutOfBoundsException();
         }
      }
   }

   byte[] getResponseData(HttpEntity param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   protected void handleMessage(Message var1) {
      super.handleMessage(var1);
      switch(var1.what) {
      case 7:
         Object[] var2 = (Object[])((Object[])var1.obj);
         if(var2 != null && var2.length >= 1) {
            try {
               this.onProgressData((byte[])((byte[])var2[0]));
               return;
            } catch (Throwable var4) {
               AsyncHttpClient.log.method_4("DataAsyncHttpRH", "custom onProgressData contains an error", var4);
               return;
            }
         }

         AsyncHttpClient.log.method_3("DataAsyncHttpRH", "PROGRESS_DATA_MESSAGE didn\'t got enough params");
         return;
      default:
      }
   }

   public void onProgressData(byte[] var1) {
      AsyncHttpClient.log.method_1("DataAsyncHttpRH", "onProgressData(byte[]) was not overriden, but callback was received");
   }

   public final void sendProgressDataMessage(byte[] var1) {
      this.sendMessage(this.obtainMessage(7, new Object[]{var1}));
   }
}
