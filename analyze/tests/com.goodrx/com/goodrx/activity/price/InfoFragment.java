package com.goodrx.activity.price;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.activity.ImagesActivity;
import com.goodrx.activity.WebViewActivity;
import com.goodrx.adapter.InfoAdapter;
import com.goodrx.model.DrugEducation;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.widget.MyProgressBar;

public class InfoFragment extends BaseFragmentWitGA {
   private static final String DOSAGE = "dosage";
   private static final String FORM = "form";
   private static final String IMAGE_COUNT = "image_count";
   private static final String NEWS_COUNT = "news_count";
   private static final String SLUG = "slug";
   private String dosage;
   private String form;
   private int imageCount;
   private int newsCount;
   private RecyclerView recyclerView;
   private String slug;

   public static InfoFragment newInstance(String var0, String var1, String var2, int var3, int var4) {
      InfoFragment var5 = new InfoFragment();
      Bundle var6 = new Bundle();
      var6.putString("slug", var0);
      var6.putString("form", var1);
      var6.putString("dosage", var2);
      var6.putInt("news_count", var3);
      var6.putInt("image_count", var4);
      var5.setArguments(var6);
      return var5;
   }

   private void onHeaderItemClicked(int var1) {
      if(var1 != 2131886525 && var1 == 2131886529) {
         ImagesActivity.launch(this.getActivity(), this.slug, this.form, this.dosage);
      }
   }

   public void getInfo() {
      final MyProgressBar var1 = (MyProgressBar)this.getActivity().findViewById(2131886399);
      var1.show();
      GoodRxAPI.getInstance().getInfo(this.getActivity(), this.slug, new OnRequestFinishListener() {
         public void onFailure(int var1x, String var2) {
            super.onFailure(var1x, var2);
            if(InfoFragment.this.isAdded()) {
               InfoAdapter var3 = new InfoAdapter(InfoFragment.this.getActivity(), new String[0], InfoFragment.this.newsCount, InfoFragment.this.imageCount) {
                  public void onHeaderClicked(int var1x) {
                     InfoFragment.this.onHeaderItemClicked(var1x);
                  }
               };
               InfoFragment.this.recyclerView.setAdapter(var3);
            }
         }

         public void onSuccess(final DrugEducation[] var1x) {
            if(InfoFragment.this.isAdded()) {
               var1.dismiss();
               final String[] var2 = new String[var1x.length];

               for(int var3 = 0; var3 < var2.length; ++var3) {
                  var2[var3] = var1x[var3].getTitle();
               }

               InfoAdapter var4 = new InfoAdapter(InfoFragment.this.getActivity(), var2, InfoFragment.this.newsCount, InfoFragment.this.imageCount) {
                  public void onHeaderClicked(int var1xx) {
                     InfoFragment.this.onHeaderItemClicked(var1xx);
                  }

                  public void onItemClickedListener(int var1xx, String var2, View var3) {
                     String var4 = var1x[var1xx].getTitle();
                     String var5 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n<html>\n<body><style> * { font-family: arial; font-size:17; } body { padding: 5px } h1 {padding-left: 0px; font-size:20px;} p {padding: 1px 0px; line-height:150%;} ul, li {margin:0px 5px 0 7px; padding:0px; } ul { padding-left: 5px; } ul ul { padding-left: 5px; } table {border-collapse: collapse;} table tr th { background-color: #EEE; } table tr, table tr td, table tr th { border: 1px solid gray; } table tr td { font-size: 0.8em; padding: 10px; margin: 0px; vertical-align: top; } ul li { line-height: 30px; } p.head { font-weight: bold; margin-top: 1em; } p.side_effect { padding-left: 45px; margin-bottom: 5px; } em { font-weight: 500; } #info-topic-blackbox .accordion-inner { border: 3px solid #000; padding: 20px; } .accordion-inner > .consumer-group > .consumer-group { padding-top: 30px; } .footer { color: #AAA; font-size: 10px; }</style>" + var1x[var1xx].getContent() + "<p class=\"footer\">The information contained in the Truven Health Micromedex products as delivered by GoodRx is intended as an educational aid only. It is not intended as medical advice for individual conditions or treatment. It is not a substitute for a medical exam, nor does it replace the need for services provided by medical professionals. Talk to your doctor, nurse or pharmacist before taking any prescription or over the counter drugs (including any herbal medicines or supplements) or following any treatment or regimen. Only your doctor, nurse, or pharmacist can provide you with advice on what is safe and effective for you.</p> \n<p class=\"footer\">The use of the Truven Health products is at your sole risk. These products are provided \"AS IS\" and \"as available\" for use, without warranties of any kind, either express or implied. Truven Health and GoodRx make no representation or warranty as to the accuracy, reliability, timeliness, usefulness or completeness of any of the information contained in the products. Additionally, TRUVEN HEALTH MAKES NO REPRESENTATION OR WARRANTIES AS TO THE OPINIONS OR OTHER SERVICE OR DATA YOU MAY ACCESS, DOWNLOAD OR USE AS A RESULT OF USE OF THE THOMSON REUTERS HEALTHCARE PRODUCTS. ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE OR USE ARE HEREBY EXCLUDED. Truven Health does not assume any responsibility or risk for your use of the Truven Health products.</p>" + "</body>\n</html>";
                     WebViewActivity.launch(InfoFragment.this.getActivity(), var4, var5);
                  }
               };
               InfoFragment.this.recyclerView.setAdapter(var4);
            }
         }
      });
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130968682, var2, false);
      this.recyclerView = (RecyclerView)var4.findViewById(2131886458);
      this.recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
      if(this.getArguments() != null) {
         this.slug = this.getArguments().getString("slug");
         this.form = this.getArguments().getString("form");
         this.dosage = this.getArguments().getString("dosage");
         this.newsCount = this.getArguments().getInt("news_count");
         this.imageCount = this.getArguments().getInt("image_count");
         this.getInfo();
      }

      return var4;
   }

   public void onResume() {
      super.onResume();
      GAHelper.sendGoogleAnalyticsScreenView(this.getActivity(), 2131427841);
   }
}
