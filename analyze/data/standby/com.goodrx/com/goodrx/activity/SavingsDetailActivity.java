package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.goodrx.activity.BlogDetailActivity;
import com.goodrx.activity.ClassDrugActivity;
import com.goodrx.activity.ConditionClassActivity;
import com.goodrx.activity.configure.PrescriptionConfigureActivity;
import com.goodrx.model.SavingsTip;
import com.goodrx.utils.DialogHelper;
import com.goodrx.widget.BaseActivityWithPasscode;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import org.parceler.Parcels;

public class SavingsDetailActivity extends BaseActivityWithPasscode {
   private static final String CSS = "*{margin: 0;padding: 0;}html{font-family:\'Helvetica Neue\';-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}body{margin:10}article,details,section,summary,aside,main,menu,nav,figcaption,figure,footer,header,hgroup{display:block}audio,canvas,progress,video{display:inline-block;vertical-align:baseline}audio:not([controls]){display:none;height:0}[hidden],template{display:none}a{background-color:transparent;}a:active,a:hover{outline:0}abbr[title]{border-bottom:1px dotted}dfn{font-style:italic}mark{background:#ff0;color:#000}b,strong{font-weight:bold}h1{font-size:2em;margin:.67em 0}small{font-size:80%}sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}sup{top:-.5em}sub{bottom:-.25em}img{border:0}svg:not(:root){overflow:hidden}figure{margin:1em 40px}hr{-moz-box-sizing:content-box;-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;height:0}pre{overflow:auto}code,kbd,pre,samp{font-family:monospace,monospace;font-size:1em}button,input,optgroup,select,textarea{color:inherit;font:inherit;margin:0}button{overflow:visible}button,select{text-transform:none}button,html input[type=\'button\'],input[type=\'reset\'],input[type=\'submit\']{cursor:pointer;-webkit-appearance:button}button[disabled],html input[disabled]{cursor:default}button::-moz-focus-inner,input::-moz-focus-inner{border:0;padding:0}input{line-height:normal}input[type=\'checkbox\'],input[type=\'radio\']{-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;padding:0}input[type=\'number\']::-webkit-inner-spin-button,input[type=\'number\']::-webkit-outer-spin-button{height:auto}input[type=\'search\']{-webkit-appearance:textfield;-moz-box-sizing:content-box;-webkit-box-sizing:content-box;-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box}input[type=\'search\']::-webkit-search-cancel-button,input[type=\'search\']::-webkit-search-decoration{-webkit-appearance:none}fieldset{border:1px solid #c0c0c0;margin:0 2px;padding:.35em .625em .75em}legend{border:0;padding:0}textarea{overflow:auto}optgroup{font-weight:bold}table{border-collapse:collapse;border-spacing:0}td,th{padding:0}:focus{outline:none}::-moz-focus-inner{border:0}*{-webkit-tap-highlight-color:rgba(0,0,0,0);-webkit-tap-highlight-color:transparent;-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;}*:before,*:after{-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box}html{font-size:62.5%}body{font-family:\'Helvetica Neue\',Helvetica,Arial,sans-serif;font-size:16px;line-height:1.5}h1,h2,h3,h4,h5,h6,ul,ol,fieldset,p,table,pre,hr{margin-bottom:15px;margin-top:0px}a{color:#0170d0;text-decoration:none;}a:hover{text-decoration:underline}a:active{color:#e5e5e5;text-decoration:underline}body{padding:20px 0 0}p{padding:0 20px}.info-table{border:none;width:100%;}.info-table tr{display:block;padding:10px 0;}.info-table tr:nth-child(odd){background:#f8f8f8}.info-table th{font-weight:700}.info-table td{font-weight:400}.info-table th,.info-table td{display:block;padding:0 20px;text-align:left;width:100%}.info-table td > a{display:block;max-width:280px;white-space:nowrap;overflow:hidden;-o-text-overflow:ellipsis;text-overflow:ellipsis}.media-object{display:block;text-align:center;width:100%;}.media-object > .media-img > img{height:128px;width:128px}.media-object > .media-body{color:#000;padding:20px}.media-object > .media-body > .tip-title{font-size:20px;font-weight:700;margin:0}.btn{-webkit-appearance:none;-webkit-font-smoothing:antialiased;background:#f0f3f5;border:none;-webkit-border-radius:3px;border-radius:3px;-webkit-box-shadow:1px 1px 2px rgba(0,0,0,0.25);box-shadow:1px 1px 2px rgba(0,0,0,0.25);color:#adadad;cursor:pointer;display:inline-block;font-size:14px;font-weight:bold;outline:none;padding:8px 12px 6px;position:relative;text-align:center;text-decoration:none;text-shadow:none;text-transform:uppercase;-webkit-transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;-moz-transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;-o-transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;-ms-transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;white-space:nowrap;}.btn:hover{-webkit-box-shadow:0 1px 1px rgba(0,0,0,0.5);box-shadow:0 1px 1px rgba(0,0,0,0.5);text-decoration:none}.btn:active{background-color:#b6c4ce}.btn > .icon{margin-right:4px;font-size:24px;vertical-align:middle}.btn > .btn-text{display:inline-block}.btn.-wide{padding:8px 24px}.btn.-wider{padding:8px 36px}.btn.-widest{padding:8px 48px}.btn.-disabled{-webkit-box-shadow:none;box-shadow:none;cursor:not-allowed}.btn.-small{padding:3px 6px}.btn.-large{font-size:16px;padding-bottom:12px;padding-top:12px;}.btn.-large > .icon{vertical-align:bottom}.btn.-block{clear:both;display:block;width:100%}.btn.btn-twitter{background:#00aced;color:#fff}.btn.btn-facebook{background:#3b5998;color:#fff}.btn.-has-spinner > .spinner{display:none;position:absolute;left:7px;top:7px}.btn.-has-spinner > .btn-text-loading{display:none}.btn.-has-spinner.-loading{padding-left:36px;}.btn.-has-spinner.-loading > .spinner,.btn.-has-spinner.-loading > .btn-text-loading{display:inline-block}.btn.-has-spinner.-loading > .btn-text{display:none}.btn.-has-toggle .text-toggle{display:none}.btn.-has-toggle.-toggle .btn-text{display:none}.btn.-has-toggle.-toggle .text-toggle{display:block}.-diabetes-center .btn{background:#4157af;color:#fff}.btn.-orange{background:#fc5830;color:#fff;}.btn.-orange:hover{background:#d64b29}.btn-primary{background:#1194f6;color:#fff;}.btn-primary.-disabled{color:#41a9f8}.btn-primary:active{background-color:#0986e4}.btn-success{background:#4caf50;color:#fff;}.btn-success.-disabled{color:#a5d8a7}.btn-success:active{background-color:#449e48}.btn-warning{background:#ff9800;color:#fff;}.btn-warning.-disabled{color:#ff9800}.btn-warning:active{background-color:#e68900}.btn-link{background:transparent;border:none;-webkit-border-radius:0;border-radius:0;-webkit-box-shadow:none;box-shadow:none;color:#adadad;font-weight:500;text-transform:uppercase;-webkit-transition:color 0.2s ease-out;-moz-transition:color 0.2s ease-out;-o-transition:color 0.2s ease-out;-ms-transition:color 0.2s ease-out;transition:color 0.2s ease-out;}.btn-link:hover{-webkit-box-shadow:none;box-shadow:none;color:#0170d0}.btn-link.-bold{font-weight:700}.btn-link.text-red{color:#f44336}.btn-link.text-blue{color:#0170d0;}.btn-link.text-blue:hover{text-decoration:underline}.btn-link.-small{font-size:11px}.btn-link[aria-expanded=\\\"true\\\"]{background:#f0f3f5;color:#000}.view-button{background:#808080;border:none;-webkit-border-radius:0 0 4px 4px;border-radius:0 0 4px 4px;color:#fff;font-size:11px;font-weight:bold;outline:none;padding:4px 16px;position:relative;text-decoration:none;text-transform:uppercase;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;white-space:nowrap}.button-group{margin:0 auto;text-align:center;}.button-group > .-wide{display:block;margin:0 auto 15px;padding-bottom:12px;padding-top:12px}.button-group > .-small{padding:3px 18px;width:45%}.button-group > .-small ~ .-small{margin-left:16px}.rate-badge{border:4px solid #f44336;-webkit-border-radius:4px;border-radius:4px;color:#f44336;padding:10px;text-align:center;text-transform:uppercase;display:inline-block;}.rate-badge > .text{font-size:14px;font-weight:700}.rate-badge > .price{font-size:24px}.rate-badge.-block{width:100%}.align-center{clear:both;margin:0 auto;text-align:center !important}.align-right{text-align:right !important}.align-left{text-align:left !important}.font-weight-light{font-weight:300 !important}.font-weight-regular{font-weight:400 !important}.font-weight-bold{font-weight:700 !important}.clearfix{zoom:1;clear:both}.clearfix:before,.clearfix:after{content:\\\"\\\";display:table}.clearfix:after{clear:both}.floatfix{overflow:hidden}.spacer{padding:0 5px;}.spacer + .spacer{padding-left:0}.pull-left{float:left}.pull-right{float:right}.mb0{margin-bottom:0}.mb-10{margin-bottom:-10px}.mb-20{margin-bottom:-20px}.mb-30{margin-bottom:-30px}.mb-40{margin-bottom:-40px}.mb10{margin-bottom:10px}.mb20{margin-bottom:20px}.mb30{margin-bottom:30px}.mb40{margin-bottom:40px}.mt0{margin-top:0}.mt10{margin-top:10px}.mt20{margin-top:20px}.mt30{margin-top:30px}.mt40{margin-top:40px}.mt-10{margin-top:-10px}.mt-20{margin-top:-20px}.mt-30{margin-top:-30px}.mt-40{margin-top:-4px}.ml0{margin-left:0}.ml-10{margin-left:-10px}.ml-20{margin-left:-20px}.ml-30{margin-left:-30px}.ml-40{margin-left:-40px}.ml10{margin-left:10px}.ml20{margin-left:20px}.ml30{margin-left:30px}.ml40{margin-left:40px}.mr0{margin-right:0}.mr-10{margin-right:-10px}.mr-20{margin-right:-20px}.mr-30{margin-right:-30px}.mr-40{margin-right:-40px}.mr10{margin-right:10px}.mr20{margin-right:20px}.mr30{margin-right:30px}.mr40{margin-right:40px}.-hidden,.hidden{display:none !important}.-show{display:block !important}.visible-sm,.visible-lg{display:none !important}@media (max-width:1024px){.hidden-sm{display:none !important}.visible-sm{display:block !important}}@media (max-width:1100px){.hidden-md{display:none !important}.visible-md{display:block !important}}@media (min-width:1300px){.hidden-lg{display:none !important}.visible-lg{display:block !important}}.width-10{width:10%}.width-20{width:20%}.width-30{width:30%}.width-40{width:40%}.width-50{width:50%}.width-100{width:100%}";
   private static final String SAVINGS_TIP = "savings_tip";
   private SavingsTip mSavingsTip;

   private String assembleHtml(SavingsTip var1, String var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("<!DOCTYPE html>");
      var3.append("<html>");
      var3.append("<head><style>").append(var2).append("</style></head>");
      var3.append("<body>");
      var3.append("<div class=\"media-object\">");
      var3.append("<div class=\"media-img\">");
      var3.append("<img style=\"float: center; width: 115px; height: 115px;\" src=\"").append(var1.getIconFullUrl()).append("\"</img>");
      var3.append("</div>");
      var3.append("<div class=\"media-body\">");
      var3.append("<h3 class=\"tip-title\">").append(var1.getTitle()).append("</h3>");
      var3.append("</div>");
      var3.append("</div>");
      var3.append(var1.getLong_description());
      if(!var1.getTip_type().equals("text")) {
         var3.append("<br>");
         var3.append("<center><button type=\"button\" class=\"btn btn-primary\" onclick=\"button.performClick()\">");
         var3.append(var1.getLink_text());
         var3.append("</button></center>");
      }

      var3.append("<br><br>");
      var3.append("</body>");
      var3.append("</html>");
      return var3.toString();
   }

   private HashMap<String, String> getParams(String var1) throws UnsupportedEncodingException {
      String var2 = URLDecoder.decode(var1, "utf-8");
      String[] var3 = var2.substring(1 + var2.indexOf(63)).split("&");
      HashMap var4 = new HashMap();
      int var5 = var3.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         String[] var7 = var3[var6].split("=");
         var4.put(var7[0], var7[1]);
      }

      return var4;
   }

   public static void launch(Activity var0, SavingsTip var1) {
      Intent var2 = new Intent(var0, SavingsDetailActivity.class);
      var2.putExtra("savings_tip", Parcels.wrap(var1));
      var0.startActivity(var2);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427865);
      this.setContentView(2130968638);
      this.mSavingsTip = (SavingsTip)Parcels.unwrap(this.getIntent().getParcelableExtra("savings_tip"));
      ActionBar var2 = this.getSupportActionBar();
      var2.setDisplayHomeAsUpEnabled(true);
      var2.setHomeAsUpIndicator(2130837662);
      WebView var3 = (WebView)this.findViewById(2131886256);
      var3.getSettings().setJavaScriptEnabled(true);
      var3.addJavascriptInterface(new SavingsDetailActivity.JsObject(), "button");
      var3.loadDataWithBaseURL((String)null, this.assembleHtml(this.mSavingsTip, "*{margin: 0;padding: 0;}html{font-family:\'Helvetica Neue\';-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}body{margin:10}article,details,section,summary,aside,main,menu,nav,figcaption,figure,footer,header,hgroup{display:block}audio,canvas,progress,video{display:inline-block;vertical-align:baseline}audio:not([controls]){display:none;height:0}[hidden],template{display:none}a{background-color:transparent;}a:active,a:hover{outline:0}abbr[title]{border-bottom:1px dotted}dfn{font-style:italic}mark{background:#ff0;color:#000}b,strong{font-weight:bold}h1{font-size:2em;margin:.67em 0}small{font-size:80%}sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}sup{top:-.5em}sub{bottom:-.25em}img{border:0}svg:not(:root){overflow:hidden}figure{margin:1em 40px}hr{-moz-box-sizing:content-box;-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;height:0}pre{overflow:auto}code,kbd,pre,samp{font-family:monospace,monospace;font-size:1em}button,input,optgroup,select,textarea{color:inherit;font:inherit;margin:0}button{overflow:visible}button,select{text-transform:none}button,html input[type=\'button\'],input[type=\'reset\'],input[type=\'submit\']{cursor:pointer;-webkit-appearance:button}button[disabled],html input[disabled]{cursor:default}button::-moz-focus-inner,input::-moz-focus-inner{border:0;padding:0}input{line-height:normal}input[type=\'checkbox\'],input[type=\'radio\']{-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;padding:0}input[type=\'number\']::-webkit-inner-spin-button,input[type=\'number\']::-webkit-outer-spin-button{height:auto}input[type=\'search\']{-webkit-appearance:textfield;-moz-box-sizing:content-box;-webkit-box-sizing:content-box;-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box}input[type=\'search\']::-webkit-search-cancel-button,input[type=\'search\']::-webkit-search-decoration{-webkit-appearance:none}fieldset{border:1px solid #c0c0c0;margin:0 2px;padding:.35em .625em .75em}legend{border:0;padding:0}textarea{overflow:auto}optgroup{font-weight:bold}table{border-collapse:collapse;border-spacing:0}td,th{padding:0}:focus{outline:none}::-moz-focus-inner{border:0}*{-webkit-tap-highlight-color:rgba(0,0,0,0);-webkit-tap-highlight-color:transparent;-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;}*:before,*:after{-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box}html{font-size:62.5%}body{font-family:\'Helvetica Neue\',Helvetica,Arial,sans-serif;font-size:16px;line-height:1.5}h1,h2,h3,h4,h5,h6,ul,ol,fieldset,p,table,pre,hr{margin-bottom:15px;margin-top:0px}a{color:#0170d0;text-decoration:none;}a:hover{text-decoration:underline}a:active{color:#e5e5e5;text-decoration:underline}body{padding:20px 0 0}p{padding:0 20px}.info-table{border:none;width:100%;}.info-table tr{display:block;padding:10px 0;}.info-table tr:nth-child(odd){background:#f8f8f8}.info-table th{font-weight:700}.info-table td{font-weight:400}.info-table th,.info-table td{display:block;padding:0 20px;text-align:left;width:100%}.info-table td > a{display:block;max-width:280px;white-space:nowrap;overflow:hidden;-o-text-overflow:ellipsis;text-overflow:ellipsis}.media-object{display:block;text-align:center;width:100%;}.media-object > .media-img > img{height:128px;width:128px}.media-object > .media-body{color:#000;padding:20px}.media-object > .media-body > .tip-title{font-size:20px;font-weight:700;margin:0}.btn{-webkit-appearance:none;-webkit-font-smoothing:antialiased;background:#f0f3f5;border:none;-webkit-border-radius:3px;border-radius:3px;-webkit-box-shadow:1px 1px 2px rgba(0,0,0,0.25);box-shadow:1px 1px 2px rgba(0,0,0,0.25);color:#adadad;cursor:pointer;display:inline-block;font-size:14px;font-weight:bold;outline:none;padding:8px 12px 6px;position:relative;text-align:center;text-decoration:none;text-shadow:none;text-transform:uppercase;-webkit-transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;-moz-transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;-o-transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;-ms-transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;transition:box-shadow 0.1s ease-in, color 0.2s ease-out, background-color 0.2s ease-in;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;white-space:nowrap;}.btn:hover{-webkit-box-shadow:0 1px 1px rgba(0,0,0,0.5);box-shadow:0 1px 1px rgba(0,0,0,0.5);text-decoration:none}.btn:active{background-color:#b6c4ce}.btn > .icon{margin-right:4px;font-size:24px;vertical-align:middle}.btn > .btn-text{display:inline-block}.btn.-wide{padding:8px 24px}.btn.-wider{padding:8px 36px}.btn.-widest{padding:8px 48px}.btn.-disabled{-webkit-box-shadow:none;box-shadow:none;cursor:not-allowed}.btn.-small{padding:3px 6px}.btn.-large{font-size:16px;padding-bottom:12px;padding-top:12px;}.btn.-large > .icon{vertical-align:bottom}.btn.-block{clear:both;display:block;width:100%}.btn.btn-twitter{background:#00aced;color:#fff}.btn.btn-facebook{background:#3b5998;color:#fff}.btn.-has-spinner > .spinner{display:none;position:absolute;left:7px;top:7px}.btn.-has-spinner > .btn-text-loading{display:none}.btn.-has-spinner.-loading{padding-left:36px;}.btn.-has-spinner.-loading > .spinner,.btn.-has-spinner.-loading > .btn-text-loading{display:inline-block}.btn.-has-spinner.-loading > .btn-text{display:none}.btn.-has-toggle .text-toggle{display:none}.btn.-has-toggle.-toggle .btn-text{display:none}.btn.-has-toggle.-toggle .text-toggle{display:block}.-diabetes-center .btn{background:#4157af;color:#fff}.btn.-orange{background:#fc5830;color:#fff;}.btn.-orange:hover{background:#d64b29}.btn-primary{background:#1194f6;color:#fff;}.btn-primary.-disabled{color:#41a9f8}.btn-primary:active{background-color:#0986e4}.btn-success{background:#4caf50;color:#fff;}.btn-success.-disabled{color:#a5d8a7}.btn-success:active{background-color:#449e48}.btn-warning{background:#ff9800;color:#fff;}.btn-warning.-disabled{color:#ff9800}.btn-warning:active{background-color:#e68900}.btn-link{background:transparent;border:none;-webkit-border-radius:0;border-radius:0;-webkit-box-shadow:none;box-shadow:none;color:#adadad;font-weight:500;text-transform:uppercase;-webkit-transition:color 0.2s ease-out;-moz-transition:color 0.2s ease-out;-o-transition:color 0.2s ease-out;-ms-transition:color 0.2s ease-out;transition:color 0.2s ease-out;}.btn-link:hover{-webkit-box-shadow:none;box-shadow:none;color:#0170d0}.btn-link.-bold{font-weight:700}.btn-link.text-red{color:#f44336}.btn-link.text-blue{color:#0170d0;}.btn-link.text-blue:hover{text-decoration:underline}.btn-link.-small{font-size:11px}.btn-link[aria-expanded=\\\"true\\\"]{background:#f0f3f5;color:#000}.view-button{background:#808080;border:none;-webkit-border-radius:0 0 4px 4px;border-radius:0 0 4px 4px;color:#fff;font-size:11px;font-weight:bold;outline:none;padding:4px 16px;position:relative;text-decoration:none;text-transform:uppercase;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;white-space:nowrap}.button-group{margin:0 auto;text-align:center;}.button-group > .-wide{display:block;margin:0 auto 15px;padding-bottom:12px;padding-top:12px}.button-group > .-small{padding:3px 18px;width:45%}.button-group > .-small ~ .-small{margin-left:16px}.rate-badge{border:4px solid #f44336;-webkit-border-radius:4px;border-radius:4px;color:#f44336;padding:10px;text-align:center;text-transform:uppercase;display:inline-block;}.rate-badge > .text{font-size:14px;font-weight:700}.rate-badge > .price{font-size:24px}.rate-badge.-block{width:100%}.align-center{clear:both;margin:0 auto;text-align:center !important}.align-right{text-align:right !important}.align-left{text-align:left !important}.font-weight-light{font-weight:300 !important}.font-weight-regular{font-weight:400 !important}.font-weight-bold{font-weight:700 !important}.clearfix{zoom:1;clear:both}.clearfix:before,.clearfix:after{content:\\\"\\\";display:table}.clearfix:after{clear:both}.floatfix{overflow:hidden}.spacer{padding:0 5px;}.spacer + .spacer{padding-left:0}.pull-left{float:left}.pull-right{float:right}.mb0{margin-bottom:0}.mb-10{margin-bottom:-10px}.mb-20{margin-bottom:-20px}.mb-30{margin-bottom:-30px}.mb-40{margin-bottom:-40px}.mb10{margin-bottom:10px}.mb20{margin-bottom:20px}.mb30{margin-bottom:30px}.mb40{margin-bottom:40px}.mt0{margin-top:0}.mt10{margin-top:10px}.mt20{margin-top:20px}.mt30{margin-top:30px}.mt40{margin-top:40px}.mt-10{margin-top:-10px}.mt-20{margin-top:-20px}.mt-30{margin-top:-30px}.mt-40{margin-top:-4px}.ml0{margin-left:0}.ml-10{margin-left:-10px}.ml-20{margin-left:-20px}.ml-30{margin-left:-30px}.ml-40{margin-left:-40px}.ml10{margin-left:10px}.ml20{margin-left:20px}.ml30{margin-left:30px}.ml40{margin-left:40px}.mr0{margin-right:0}.mr-10{margin-right:-10px}.mr-20{margin-right:-20px}.mr-30{margin-right:-30px}.mr-40{margin-right:-40px}.mr10{margin-right:10px}.mr20{margin-right:20px}.mr30{margin-right:30px}.mr40{margin-right:40px}.-hidden,.hidden{display:none !important}.-show{display:block !important}.visible-sm,.visible-lg{display:none !important}@media (max-width:1024px){.hidden-sm{display:none !important}.visible-sm{display:block !important}}@media (max-width:1100px){.hidden-md{display:none !important}.visible-md{display:block !important}}@media (min-width:1300px){.hidden-lg{display:none !important}.visible-lg{display:block !important}}.width-10{width:10%}.width-20{width:20%}.width-30{width:30%}.width-40{width:40%}.width-50{width:50%}.width-100{width:100%}"), "text/html", "utf-8", (String)null);
   }

   private class JsObject {
      private JsObject() {
      }

      // $FF: synthetic method
      JsObject(Object var2) {
         this();
      }

      @JavascriptInterface
      public void performClick() {
         String var1 = SavingsDetailActivity.this.mSavingsTip.getTip_type();
         String var2 = SavingsDetailActivity.this.mSavingsTip.getSlug();
         byte var3 = -1;
         switch(var1.hashCode()) {
         case -861311717:
            if(var1.equals("condition")) {
               var3 = 2;
            }
            break;
         case -579402727:
            if(var1.equals("drug_class")) {
               var3 = 1;
            }
            break;
         case 3026850:
            if(var1.equals("blog")) {
               var3 = 0;
            }
            break;
         case 3092384:
            if(var1.equals("drug")) {
               var3 = 3;
            }
            break;
         case 3321850:
            if(var1.equals("link")) {
               var3 = 4;
            }
         }

         switch(var3) {
         case 0:
            BlogDetailActivity.launch(SavingsDetailActivity.this, var2);
            return;
         case 1:
            ClassDrugActivity.launch(SavingsDetailActivity.this, var2, false);
            return;
         case 2:
            ConditionClassActivity.launch(SavingsDetailActivity.this, var2);
            return;
         case 3:
            try {
               HashMap var6 = SavingsDetailActivity.this.getParams(SavingsDetailActivity.this.mSavingsTip.getLink());
               PrescriptionConfigureActivity.launch(SavingsDetailActivity.this, (String)var6.get("label"), true, (String)var6.get("form"), (String)var6.get("strength"), Integer.valueOf((String)var6.get("quantity")));
               return;
            } catch (Exception var7) {
               PrescriptionConfigureActivity.launch(SavingsDetailActivity.this, var2, true);
               return;
            }
         case 4:
            DialogHelper.showDialog(DialogHelper.openExternalWebsite(SavingsDetailActivity.this, SavingsDetailActivity.this.mSavingsTip.getLink()));
            return;
         default:
         }
      }
   }
}
