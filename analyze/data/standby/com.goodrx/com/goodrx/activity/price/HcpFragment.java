package com.goodrx.activity.price;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.widget.MyProgressBar;

public class HcpFragment extends BaseFragmentWitGA {
   private static final String DRUG_ID = "drug_id";
   private String mDrugId;
   private WebView mWebView;

   public static HcpFragment newInstance(String var0) {
      HcpFragment var1 = new HcpFragment();
      Bundle var2 = new Bundle();
      var2.putString("drug_id", var0);
      var1.setArguments(var2);
      return var1;
   }

   private void updateUI() {
      int var1 = 0;
      StringBuilder var2 = new StringBuilder("<!DOCTYPE HTML>");
      var2.append("<head><style>body{margin-left:5%; margin-right:5%;}ul{padding-left:1em}li{margin-bottom:1.5em;}a{color:#2196F3;text-decoration:none;text-transform:uppercase;font-size:0.8em;font-weight:600;margin-top:1.1em}</style></head><body>");
      var2.append("<p>This drug is administered by your helthcare practitioner (HCP), which usually means:<p>");
      var2.append("<ul>");
      String[] var6 = new String[]{"It may be expensive.", "You cannot fill this prescription in a regular pharmacy. Your doctor, hospital, or clinic will provide this medication.", "This drug is likely to be covered under your medical benefit if you have insurance."};

      for(int var7 = var6.length; var1 < var7; ++var1) {
         String var13 = var6[var1];
         var2.append("<font color=#585858><li>" + var13 + "</li></font>");
      }

      var2.append("</ul>");
      var2.append("Patients in need of this drug may find the cost paid by an insurance company, goverment, or non-profit organization. If you are uninsured or need help with your co-pay, the manufacturer may also offer assistance.");
      var2.append("<br/><br/>");
      var2.append("<a href=\"").append("https://www.goodrx.com/blog/health-care-practitioner-administered-drugs-what-you-need-to-know/").append("\">Learn more about HCP administered meds</a>");
      var2.append("</body>");
      this.mWebView.loadDataWithBaseURL((String)null, var2.toString(), "text/html", "utf-8", (String)null);
      ((MyProgressBar)this.getActivity().findViewById(2131886399)).dismiss();
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         this.mDrugId = this.getArguments().getString("drug_id");
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130968681, var2, false);
      this.mWebView = (WebView)var4.findViewById(2131886256);
      this.updateUI();
      return var4;
   }
}
