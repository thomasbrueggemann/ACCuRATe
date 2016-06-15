package org.apache.cordova;

import android.app.Activity;
import android.content.Intent;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.CordovaPlugin;

public interface CordovaInterface {
   Activity getActivity();

   ExecutorService getThreadPool();

   Object onMessage(String var1, Object var2);

   void setActivityResultCallback(CordovaPlugin var1);

   void startActivityForResult(CordovaPlugin var1, Intent var2, int var3);
}
