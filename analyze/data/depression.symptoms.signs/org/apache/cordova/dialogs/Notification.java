package org.apache.cordova.dialogs;

import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Notification extends CordovaPlugin {
   public int confirmResult = -1;
   public ProgressDialog progressDialog = null;
   public ProgressDialog spinnerDialog = null;

   public void activityStart(final String var1, final String var2) {
      synchronized(this){}

      try {
         if(this.spinnerDialog != null) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
         }

         Runnable var4 = new Runnable() {
            // $FF: synthetic field
            final CordovaInterface val$cordova;

            {
               this.val$cordova = var2x;
            }

            public void run() {
               Notification.this.spinnerDialog = ProgressDialog.show(this.val$cordova.getActivity(), var1, var2, true, true, new OnCancelListener() {
                  public void onCancel(DialogInterface var1x) {
                     Notification.this.spinnerDialog = null;
                  }
               });
            }
         };
         this.cordova.getActivity().runOnUiThread(var4);
      } finally {
         ;
      }

   }

   public void activityStop() {
      synchronized(this){}

      try {
         if(this.spinnerDialog != null) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
         }
      } finally {
         ;
      }

   }

   public void alert(final String var1, final String var2, final String var3, final CallbackContext var4) {
      synchronized(this){}

      try {
         Runnable var5 = new Runnable() {
            // $FF: synthetic field
            final CordovaInterface val$cordova;

            {
               this.val$cordova = var2x;
            }

            public void run() {
               Builder var1x = new Builder(this.val$cordova.getActivity(), 5);
               var1x.setMessage(var1);
               var1x.setTitle(var2);
               var1x.setCancelable(true);
               var1x.setPositiveButton(var3, new OnClickListener() {
                  public void onClick(DialogInterface var1x, int var2x) {
                     var1x.dismiss();
                     var4.sendPluginResult(new PluginResult(PluginResult.Status.field_13, 0));
                  }
               });
               var1x.setOnCancelListener(new OnCancelListener() {
                  public void onCancel(DialogInterface var1x) {
                     var1x.dismiss();
                     var4.sendPluginResult(new PluginResult(PluginResult.Status.field_13, 0));
                  }
               });
               var1x.create();
               ((TextView)var1x.show().findViewById(16908299)).setTextDirection(5);
            }
         };
         this.cordova.getActivity().runOnUiThread(var5);
      } finally {
         ;
      }

   }

   public void beep(final long var1) {
      this.cordova.getThreadPool().execute(new Runnable() {
         public void run() {
            Uri var1x = RingtoneManager.getDefaultUri(2);
            Ringtone var2 = RingtoneManager.getRingtone(Notification.this.cordova.getActivity().getBaseContext(), var1x);
            if(var2 != null) {
               for(long var3 = 0L; var3 < var1; ++var3) {
                  var2.play();
                  long var5 = 5000L;

                  while(var2.isPlaying() && var5 > 0L) {
                     var5 -= 100L;

                     try {
                        Thread.sleep(100L);
                     } catch (InterruptedException var8) {
                        ;
                     }
                  }
               }
            }

         }
      });
   }

   public void confirm(final String var1, final String var2, final JSONArray var3, final CallbackContext var4) {
      synchronized(this){}

      try {
         Runnable var5 = new Runnable() {
            // $FF: synthetic field
            final CordovaInterface val$cordova;

            {
               this.val$cordova = var2x;
            }

            public void run() {
               Builder var1x = new Builder(this.val$cordova.getActivity(), 5);
               var1x.setMessage(var1);
               var1x.setTitle(var2);
               var1x.setCancelable(true);
               if(var3.length() > 0) {
                  try {
                     var1x.setNegativeButton(var3.getString(0), new OnClickListener() {
                        public void onClick(DialogInterface var1x, int var2x) {
                           var1x.dismiss();
                           var4.sendPluginResult(new PluginResult(PluginResult.Status.field_13, 1));
                        }
                     });
                  } catch (JSONException var14) {
                     ;
                  }
               }

               if(var3.length() > 1) {
                  try {
                     var1x.setNeutralButton(var3.getString(1), new OnClickListener() {
                        public void onClick(DialogInterface var1x, int var2x) {
                           var1x.dismiss();
                           var4.sendPluginResult(new PluginResult(PluginResult.Status.field_13, 2));
                        }
                     });
                  } catch (JSONException var13) {
                     ;
                  }
               }

               if(var3.length() > 2) {
                  try {
                     var1x.setPositiveButton(var3.getString(2), new OnClickListener() {
                        public void onClick(DialogInterface var1x, int var2x) {
                           var1x.dismiss();
                           var4.sendPluginResult(new PluginResult(PluginResult.Status.field_13, 3));
                        }
                     });
                  } catch (JSONException var12) {
                     ;
                  }
               }

               var1x.setOnCancelListener(new OnCancelListener() {
                  public void onCancel(DialogInterface var1x) {
                     var1x.dismiss();
                     var4.sendPluginResult(new PluginResult(PluginResult.Status.field_13, 0));
                  }
               });
               var1x.create();
               ((TextView)var1x.show().findViewById(16908299)).setTextDirection(5);
            }
         };
         this.cordova.getActivity().runOnUiThread(var5);
      } finally {
         ;
      }

   }

   public boolean execute(String var1, JSONArray var2, CallbackContext var3) throws JSONException {
      boolean var5;
      if(this.cordova.getActivity().isFinishing()) {
         var5 = true;
         return var5;
      } else {
         if(var1.equals("beep")) {
            this.beep(var2.getLong(0));
         } else {
            if(var1.equals("alert")) {
               this.alert(var2.getString(0), var2.getString(1), var2.getString(2), var3);
               return true;
            }

            if(var1.equals("confirm")) {
               this.confirm(var2.getString(0), var2.getString(1), var2.getJSONArray(2), var3);
               return true;
            }

            if(var1.equals("prompt")) {
               this.prompt(var2.getString(0), var2.getString(1), var2.getJSONArray(2), var2.getString(3), var3);
               return true;
            }

            if(var1.equals("activityStart")) {
               this.activityStart(var2.getString(0), var2.getString(1));
            } else if(var1.equals("activityStop")) {
               this.activityStop();
            } else if(var1.equals("progressStart")) {
               this.progressStart(var2.getString(0), var2.getString(1));
            } else if(var1.equals("progressValue")) {
               this.progressValue(var2.getInt(0));
            } else {
               boolean var4 = var1.equals("progressStop");
               var5 = false;
               if(!var4) {
                  return var5;
               }

               this.progressStop();
            }
         }

         var3.success();
         return true;
      }
   }

   public void progressStart(final String var1, final String var2) {
      synchronized(this){}

      try {
         if(this.progressDialog != null) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
         }

         Runnable var4 = new Runnable() {
            // $FF: synthetic field
            final CordovaInterface val$cordova;

            {
               this.val$cordova = var3;
            }

            public void run() {
               Notification.this.progressDialog = new ProgressDialog(this.val$cordova.getActivity(), 5);
               Notification.this.progressDialog.setProgressStyle(1);
               Notification.this.progressDialog.setTitle(var1);
               Notification.this.progressDialog.setMessage(var2);
               Notification.this.progressDialog.setCancelable(true);
               Notification.this.progressDialog.setMax(100);
               Notification.this.progressDialog.setProgress(0);
               Notification.this.progressDialog.setOnCancelListener(new OnCancelListener() {
                  public void onCancel(DialogInterface var1x) {
                     Notification.this.progressDialog = null;
                  }
               });
               Notification.this.progressDialog.show();
            }
         };
         this.cordova.getActivity().runOnUiThread(var4);
      } finally {
         ;
      }

   }

   public void progressStop() {
      synchronized(this){}

      try {
         if(this.progressDialog != null) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
         }
      } finally {
         ;
      }

   }

   public void progressValue(int var1) {
      synchronized(this){}

      try {
         if(this.progressDialog != null) {
            this.progressDialog.setProgress(var1);
         }
      } finally {
         ;
      }

   }

   public void prompt(final String var1, final String var2, final JSONArray var3, final String var4, final CallbackContext var5) {
      synchronized(this){}

      try {
         Runnable var6 = new Runnable() {
            // $FF: synthetic field
            final CordovaInterface val$cordova;

            {
               this.val$cordova = var2x;
            }

            public void run() {
               final EditText var1x = new EditText(this.val$cordova.getActivity());
               var1x.setHint(var4);
               Builder var2x = new Builder(this.val$cordova.getActivity(), 5);
               var2x.setMessage(var1);
               var2x.setTitle(var2);
               var2x.setCancelable(true);
               var2x.setView(var1x);
               final JSONObject var7 = new JSONObject();
               if(var3.length() > 0) {
                  try {
                     var2x.setNegativeButton(var3.getString(0), new OnClickListener() {
                        public void onClick(DialogInterface param1, int param2) {
                           // $FF: Couldn't be decompiled
                        }
                     });
                  } catch (JSONException var17) {
                     ;
                  }
               }

               if(var3.length() > 1) {
                  try {
                     var2x.setNeutralButton(var3.getString(1), new OnClickListener() {
                        public void onClick(DialogInterface param1, int param2) {
                           // $FF: Couldn't be decompiled
                        }
                     });
                  } catch (JSONException var16) {
                     ;
                  }
               }

               if(var3.length() > 2) {
                  try {
                     var2x.setPositiveButton(var3.getString(2), new OnClickListener() {
                        public void onClick(DialogInterface param1, int param2) {
                           // $FF: Couldn't be decompiled
                        }
                     });
                  } catch (JSONException var15) {
                     ;
                  }
               }

               var2x.setOnCancelListener(new OnCancelListener() {
                  public void onCancel(DialogInterface param1) {
                     // $FF: Couldn't be decompiled
                  }
               });
               var2x.create();
               ((TextView)var2x.show().findViewById(16908299)).setTextDirection(5);
            }
         };
         this.cordova.getActivity().runOnUiThread(var6);
      } finally {
         ;
      }

   }
}
