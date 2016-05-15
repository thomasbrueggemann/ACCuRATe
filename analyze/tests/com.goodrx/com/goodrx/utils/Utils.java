package com.goodrx.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.goodrx.activity.WelcomeActivity;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.model.CouponObject;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.tracker.ContainerHolderSingleton;
import com.goodrx.utils.tracker.TVSquaredCollector;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Iterator;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.droidparts.widget.ClearableEditText;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
   public static void cancelNotification(Context var0, int var1) {
      NotificationManagerCompat.from(var0).cancel(var1);
   }

   public static String changePhoneNumberToUriFormat(String var0) {
      String var1 = var0.split(" ")[0];
      StringBuilder var2 = new StringBuilder();

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         char var4 = var1.charAt(var3);
         if(var4 >= 48 && var4 <= 57) {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   public static boolean checkCameraHardware(Context var0) {
      if(var0.getPackageManager().hasSystemFeature("android.hardware.camera")) {
         return true;
      } else {
         AlertDialog.Builder var1 = new AlertDialog.Builder(var0);
         var1.setTitle(2131427456);
         var1.setMessage(2131427457);
         var1.setPositiveButton(2131427709, (OnClickListener)null);
         DialogHelper.showDialog(var1);
         return false;
      }
   }

   public static int convertDpToPixel(Context var0, double var1) {
      return (int)(var1 * (double)var0.getResources().getDisplayMetrics().density);
   }

   public static void copyTextContent(final Activity var0, String var1, String var2, int var3, CouponObject var4, String var5) {
      RequestParams var6 = new RequestParams();
      var6.add("drug_id", var1);
      var6.add("pharmacy_id", var2);
      var6.add("quantity", String.valueOf(var3));
      var6.add("name", var4.getCoupon_network());
      var6.add("phone", "");
      var6.add("price", var5);
      var6.add("send", "0");
      CacheHttpRequestHelper.getInstance().post("https://www.goodrx.com/mobile-api/v3/coupon/text", var6, new MyResponseHandler(var0) {
         public void onSuccess(String var1) {
            try {
               new JSONObject;
               String var4 = JSONObjectInstrumentation.init(var1).getString("text");
               Utils.copyToClipBoard(var0, "coupon_text", var4);
               AlertDialog.Builder var5 = new AlertDialog.Builder(var0);
               var5.setTitle(var0.getResources().getString(2131427497));
               var5.setMessage(var0.getResources().getString(2131427498));
               var5.setPositiveButton(2131427709, (OnClickListener)null);
               DialogHelper.showDialog(var5);
            } catch (JSONException var6) {
               var6.printStackTrace();
            }
         }
      });
   }

   public static void copyToClipBoard(Context var0, String var1, String var2) {
      ((ClipboardManager)var0.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(var1, var2));
   }

   public static String formatDistance(double var0) {
      Object[] var2 = new Object[]{Double.valueOf(var0)};
      String var3 = String.format("%.1f", var2);
      return !var3.equals("1") && !var3.equals("1.0")?var3 + " miles":var3 + " mile";
   }

   public static String formatPhoneNumber(String var0) {
      if(var0.length() == 0) {
         return "";
      } else {
         String[] var1 = var0.split(" ")[0].split("-");
         return "(" + var1[1] + ") " + var1[2] + "-" + var1[3];
      }
   }

   public static String formatPrice(Double var0) {
      if(var0 == null) {
         return "";
      } else if(var0.doubleValue() <= 0.01D) {
         return "Free";
      } else {
         String var1 = "$0.00";
         if(var0.doubleValue() > 1000.0D) {
            var1 = "$###,###";
         }

         return (new DecimalFormat(var1)).format(var0);
      }
   }

   public static String getAbTestVariant(Context var0) {
      Editor var1 = var0.getSharedPreferences("ab_test", 0).edit();
      var1.putString("result", (String)null).apply();

      try {
         String var3 = ContainerHolderSingleton.getContainerHolder().getContainer().getString("interstitial");
         var1.putString("result", "android_reminder_interstitial_" + var3).apply();
         Log.d("goodrx_abtest", var3);
         return var3;
      } catch (Exception var4) {
         return "";
      }
   }

   public static int getBackgroundColor(View var0) {
      Drawable var1 = var0.getBackground();
      boolean var2 = var1 instanceof ColorDrawable;
      int var3 = 0;
      if(var2) {
         var3 = ((ColorDrawable)var1).getColor();
      }

      return var3;
   }

   public static long getCurrentTimeInMillis() {
      return System.currentTimeMillis();
   }

   public static boolean isInteger(String var0) {
      try {
         Integer.parseInt(var0);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      }
   }

   public static boolean isNumber(String var0) {
      try {
         Double.parseDouble(var0);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      }
   }

   public static boolean isOnline(Context var0) {
      NetworkInfo var1 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
      return var1 != null && var1.isConnectedOrConnecting();
   }

   public static boolean isServiceRunning(Context var0, Class<?> var1) {
      Iterator var2 = ((ActivityManager)var0.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();

      RunningServiceInfo var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (RunningServiceInfo)var2.next();
      } while(!var1.getName().equals(var3.service.getClassName()));

      return true;
   }

   public static boolean isValidString(String... var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         if(var0[var1] == null || var0[var1].length() == 0 || var0[var1].equalsIgnoreCase("null")) {
            return false;
         }
      }

      return true;
   }

   public static void makeCall(final Context var0, String var1, String var2, final String var3) {
      AlertDialog.Builder var4 = new AlertDialog.Builder(var0);
      if(var1 != null) {
         var4.setTitle(var1);
      }

      var4.setMessage(var2);
      var4.setPositiveButton(2131428036, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var1.dismiss();
            Utils.openDialPanel(var0, var3);
         }
      });
      var4.setNegativeButton(2131427682, (OnClickListener)null);
      DialogHelper.showDialog(var4);
   }

   public static Snackbar makeSnackBar(View var0, String var1) {
      Snackbar var2 = Snackbar.make(var0, Html.fromHtml(var1), 0);
      ((TextView)var2.getView().findViewById(2131886403)).setTextColor(-1);
      return var2;
   }

   public static void openAppStore(Context var0) {
      String var1 = var0.getPackageName();

      try {
         var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + var1)));
      } catch (ActivityNotFoundException var3) {
         var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + var1)));
      }
   }

   public static void openDialPanel(Context var0, String var1) {
      Intent var2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + var1));
      var2.addFlags(268435456);
      boolean var4;
      if(var0.getPackageManager().queryIntentActivities(var2, 65536).size() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if(var4) {
         var0.startActivity(var2);
      } else {
         copyToClipBoard(var0, "phone_number", var1);
         AlertDialog.Builder var5 = new AlertDialog.Builder(var0);
         var5.setTitle(var0.getResources().getString(2131427732));
         var5.setMessage(var0.getResources().getString(2131427733));
         var5.setPositiveButton(2131427709, (OnClickListener)null);
         DialogHelper.showDialog(var5);
      }
   }

   public static void openWebIntent(Activity var0, String var1) {
      try {
         var0.startActivity((new Intent("android.intent.action.VIEW")).setData(Uri.parse(var1)));
      } catch (Exception var3) {
         ;
      }
   }

   public static void reinitTokens(Context var0) {
      Intent var1 = new Intent(var0, WelcomeActivity.class);
      var1.addFlags(67108864);
      var0.startActivity(var1);
   }

   public static void removeFolder(File var0) {
   }

   public static void removeFolder(String var0) {
      removeFolder(new File(var0));
   }

   public static void restartApp(Activity var0) {
      Intent var1 = new Intent(var0, MainActivity.class);
      var1.setFlags(335544320);
      var0.startActivity(var1);
   }

   public static void sendEmail(final Activity var0, final String var1, final String var2, final int var3, final CouponObject var4, final String var5) {
      View var6 = LayoutInflater.from(var0).inflate(2130968670, (ViewGroup)null);
      final ClearableEditText var7 = (ClearableEditText)var6.findViewById(2131886422);
      var7.setSingleLine(true);
      var7.setHint(2131427553);
      AlertDialog.Builder var8 = new AlertDialog.Builder(var0);
      var8.setTitle(var0.getResources().getString(2131427552));
      var8.setMessage(var0.getResources().getString(2131427554));
      var8.setView(var6);
      var8.setPositiveButton(2131427883, (OnClickListener)null);
      var8.setNegativeButton(2131427459, (OnClickListener)null);
      final AlertDialog var14 = var8.create();
      var14.getWindow().clearFlags(131080);
      var14.getWindow().setSoftInputMode(4);
      var14.show();
      var14.getButton(-1).setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1x) {
            if(Utils.validateEmail(var7.getText().toString())) {
               var14.dismiss();
               RequestParams var2x = new RequestParams();
               var2x.add("drug_id", var1);
               var2x.add("pharmacy_id", var2);
               var2x.add("quantity", String.valueOf(var3));
               var2x.add("name", var4.getCoupon_network());
               var2x.add("email", var7.getText().toString());
               var2x.add("price", var5);
               Utils.sendTextOrEmail(var0, "https://www.goodrx.com/mobile-api/v3/coupon/email", var2x, var0.getResources().getString(2131427555));
               Utils.showToast(var0, var0.getResources().getString(2131427885));
            } else {
               var7.setText("");
               Utils.showToast(var0, var0.getResources().getString(2131427625));
            }
         }
      });
   }

   public static void sendEmail(Context var0, String var1, String var2) {
      Intent var3 = new Intent("android.intent.action.SENDTO");
      var3.setData(Uri.parse("mailto:" + var1));
      var3.putExtra("android.intent.extra.SUBJECT", var2);
      var0.startActivity(var3);
   }

   public static void sendTVSquredTrackingEvent(Activity var0, String var1, String var2) {
      String var3 = var0.getSharedPreferences("goodrx", 0).getString("adid", (String)null);
      if(var3 != null) {
         try {
            TVSquaredCollector var4 = new TVSquaredCollector(var0, "collector-228.tvsquared.com", "228-1");
            var4.setUserId(var3);
            var4.track(var1, var2, "", 1.0F, "");
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }
   }

   public static void sendText(final Activity var0, final String var1, final String var2, final int var3, final CouponObject var4, final String var5) {
      View var6 = LayoutInflater.from(var0).inflate(2130968670, (ViewGroup)null);
      final ClearableEditText var7 = (ClearableEditText)var6.findViewById(2131886422);
      var7.setSingleLine(true);
      var7.setInputType(2);
      AlertDialog.Builder var8 = new AlertDialog.Builder(var0);
      var8.setTitle(var0.getString(2131427919));
      var8.setMessage(var0.getString(2131427920));
      var8.setView(var6);
      var8.setPositiveButton(2131427883, (OnClickListener)null);
      var8.setNegativeButton(2131427459, (OnClickListener)null);
      final AlertDialog var14 = var8.create();
      var14.getWindow().clearFlags(131080);
      var14.getWindow().setSoftInputMode(4);
      var14.show();
      var14.getButton(-1).setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1x) {
            if(Utils.validatePhoneNumber(var7.getText().toString())) {
               var14.dismiss();
               RequestParams var2x = new RequestParams();
               var2x.add("drug_id", var1);
               var2x.add("pharmacy_id", var2);
               var2x.add("quantity", String.valueOf(var3));
               var2x.add("name", var4.getCoupon_network());
               var2x.add("phone", var7.getText().toString());
               var2x.add("price", var5);
               Utils.sendTextOrEmail(var0, "https://www.goodrx.com/mobile-api/v3/coupon/text", var2x, var0.getString(2131427921));
            } else {
               var7.setText("");
               Utils.showToast(var0, var0.getResources().getString(2131427626));
            }
         }
      });
   }

   public static void sendTextOrEmail(final Activity var0, String var1, RequestParams var2, final String var3) {
      CacheHttpRequestHelper.getInstance().post(var1, var2, new MyResponseHandler(var0) {
         public void onSuccess(String var1) {
            Utils.showToast(var0, var3);
         }
      });
   }

   public static String sha1HexEncode(String var0) {
      return new String(Hex.encodeHex(DigestUtils.sha1(var0)));
   }

   public static void showToast(Context var0, String var1) {
      Toast.makeText(var0, var1, 0).show();
   }

   public static boolean validateEmail(String var0) {
      return EmailValidator.getInstance().isValid(var0);
   }

   public static boolean validatePhoneNumber(String var0) {
      int var1 = var0.length();
      int var2 = 0;

      while(true) {
         if(var2 < var1) {
            if(var0.charAt(var2) >= 48 && var0.charAt(var2) <= 57) {
               ++var2;
               continue;
            }
            break;
         }

         if(var1 != 10 && var1 != 11) {
            break;
         }

         return true;
      }

      return false;
   }
}
