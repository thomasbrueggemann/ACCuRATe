package com.goodrx.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.adapter.SingleChoiceAdapter;
import com.goodrx.model.SingleChoiceItem;

public class DialogHelper {
   private static boolean isDialogShowing;

   public static Dialog createSingleChoiceDialog(Context var0, int var1, String[] var2, int var3, final OnItemClickListener var4) {
      AlertDialog.Builder var5 = new AlertDialog.Builder(var0);
      var5.setTitle(var1);
      ListView var7 = new ListView(var0);
      SingleChoiceItem[] var8 = new SingleChoiceItem[var2.length];

      for(int var9 = 0; var9 < var2.length; ++var9) {
         var8[var9] = new SingleChoiceItem(var2[var9]);
      }

      final SingleChoiceAdapter var10 = new SingleChoiceAdapter(var0, var8, var3);
      var7.setAdapter(var10);
      var5.setView(var7);
      final AlertDialog var12 = var5.create();
      var7.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4x) {
            var10.setSelectedIndex(var3);
            var4.onItemClick(var1, var2, var3, var4x);
            var12.dismiss();
         }
      });
      return var12;
   }

   public static Dialog createSingleChoiceDialogWithPositiveButton(Context var0, int var1, String[] var2, int var3, final OnItemClickListener var4, int var5, OnClickListener var6) {
      AlertDialog.Builder var7 = new AlertDialog.Builder(var0);
      var7.setTitle(var1);
      ListView var9 = new ListView(var0);
      SingleChoiceItem[] var10 = new SingleChoiceItem[var2.length];

      for(int var11 = 0; var11 < var2.length; ++var11) {
         var10[var11] = new SingleChoiceItem(var2[var11]);
      }

      final SingleChoiceAdapter var12 = new SingleChoiceAdapter(var0, var10, var3);
      var9.setAdapter(var12);
      var7.setPositiveButton(var5, var6);
      var7.setView(var9);
      final AlertDialog var15 = var7.create();
      var9.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4x) {
            var12.setSelectedIndex(var3);
            var4.onItemClick(var1, var2, var3, var4x);
            var15.dismiss();
         }
      });
      return var15;
   }

   public static AlertDialog.Builder dialogWithCustomViewBuilder(Context var0, int var1, View var2) {
      AlertDialog.Builder var3 = new AlertDialog.Builder(var0);
      var3.setTitle(var1);
      var3.setView(var2);
      return var3;
   }

   public static AlertDialog.Builder openExternalWebsite(final Context var0, final String var1) {
      View var2 = View.inflate(var0, 2130968669, (ViewGroup)null);
      ((TextView)var2.findViewById(2131886421)).setText(2131427645);
      AlertDialog.Builder var3 = new AlertDialog.Builder(var0);
      var3.setTitle(2131427644);
      var3.setView(var2);
      var3.setPositiveButton(2131428036, new OnClickListener() {
         public void onClick(DialogInterface var1x, int var2) {
            if(var1 != null) {
               Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
               var0.startActivity(var3);
            }
         }
      });
      var3.setNegativeButton(2131427682, (OnClickListener)null);
      return var3;
   }

   public static Dialog showDialog(AlertDialog.Builder var0) {
      if(isDialogShowing) {
         return null;
      } else {
         AlertDialog var1 = null;

         try {
            var1 = var0.create();
            var1.setCanceledOnTouchOutside(true);
            var1.setOnShowListener(new OnShowListener() {
               public void onShow(DialogInterface var1) {
                  DialogHelper.isDialogShowing = true;
               }
            });
            var1.setOnDismissListener(new OnDismissListener() {
               public void onDismiss(DialogInterface var1) {
                  DialogHelper.isDialogShowing = false;
               }
            });
            var1.getWindow().clearFlags(131080);
            var1.getWindow().setSoftInputMode(4);
            var1.show();
            return var1;
         } catch (Exception var3) {
            return var1;
         }
      }
   }

   public static void showDialog(Dialog var0) {
      if(!(var0.getContext() instanceof Activity) || !((Activity)((Activity)var0.getContext())).isFinishing()) {
         var0.setCanceledOnTouchOutside(true);
         var0.setOnShowListener(new OnShowListener() {
            public void onShow(DialogInterface var1) {
               DialogHelper.isDialogShowing = true;
            }
         });
         var0.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface var1) {
               DialogHelper.isDialogShowing = false;
            }
         });
         var0.getWindow().clearFlags(131080);
         var0.getWindow().setSoftInputMode(4);
         var0.show();
      }
   }

   public static void showErrorDialog(Context var0, String var1, String var2) {
      showErrorDialog(var0, var1, var2, (OnClickListener)null);
   }

   public static void showErrorDialog(Context var0, String var1, String var2, OnClickListener var3) {
      AlertDialog.Builder var4 = new AlertDialog.Builder(var0);
      var4.setTitle(var1);
      View var6 = View.inflate(var0, 2130968669, (ViewGroup)null);
      ((TextView)var6.findViewById(2131886421)).setText(var2);
      var4.setView(var6);
      var4.setPositiveButton(2131427709, var3);
      showDialog(var4);
   }
}
