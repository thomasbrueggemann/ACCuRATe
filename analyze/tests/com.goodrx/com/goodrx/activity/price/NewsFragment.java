package com.goodrx.activity.price;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.activity.WebViewActivity;
import com.goodrx.adapter.NewsListAdapter;
import com.goodrx.model.News;
import com.goodrx.utils.PasscodeManager;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.ArrayUtils;

public class NewsFragment extends BaseFragmentWitGA {
   private static final String SLUG = "slug";
   private View emptyView;
   private String[] highlightTitles;
   private RecyclerView recyclerView;
   private String slug;

   public static NewsFragment newInstance(String var0) {
      NewsFragment var1 = new NewsFragment();
      Bundle var2 = new Bundle();
      var2.putString("slug", var0);
      var1.setArguments(var2);
      return var1;
   }

   public void getNews(String var1) {
      final MyProgressBar var2 = (MyProgressBar)this.getActivity().findViewById(2131886399);
      var2.show();
      GoodRxAPI.getInstance().getNews(this.getActivity(), var1, new OnRequestFinishListener() {
         public void onFailure(int var1, String var2x) {
            super.onFailure(var1, var2x);
            NewsFragment.this.emptyView.setVisibility(0);
            NewsFragment.this.recyclerView.setVisibility(8);
            var2.dismiss();
         }

         public void onSuccess(final News[] var1) {
            if(NewsFragment.this.isAdded()) {
               var2.dismiss();
               if(NewsFragment.this.highlightTitles != null && NewsFragment.this.highlightTitles.length > 0) {
                  int var4 = var1.length;

                  for(int var5 = 0; var5 < var4; ++var5) {
                     News var6 = var1[var5];
                     String[] var7 = NewsFragment.this.highlightTitles;
                     int var8 = var7.length;

                     for(int var9 = 0; var9 < var8; ++var9) {
                        String var10 = var7[var9];
                        if(var6.getTitle().equals(var10)) {
                           var6.setSelected(true);
                           break;
                        }
                     }
                  }
               }

               NewsListAdapter var2x = new NewsListAdapter(NewsFragment.this.getActivity(), var1) {
                  public void onItemClickedListener(int var1x, News var2x, View var3) {
                     super.onItemClickedListener(var1x, var2x, var3);
                     if(var2x.isSelected()) {
                        NewsFragment.this.highlightTitles = (String[])ArrayUtils.remove((Object[])NewsFragment.this.highlightTitles, ArrayUtils.indexOf(NewsFragment.this.highlightTitles, var2x.getTitle()));
                        var1[var1x].setSelected(false);
                        this.updateData(var1);
                     }

                     String var4 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n<html>\n<body>" + "<style>p, li { font-family: arial; } p {padding: 5px 10px; } ul, li {margin:0px 10px 0 15px; padding:0px; }</style>";
                     String var5 = var4 + "<p><b><font size=4>" + var2x.getTitle() + "</b></font><br/><br/>";
                     String var6 = var5 + "by " + var2x.getAuthor() + "<br/><br/> <font color=green>" + var2x.getPublishedDate() + "</font></p>";
                     String var7 = var6 + var2x.getContent();
                     String var8 = var7 + "</body>\n</html>";
                     WebViewActivity.launch(NewsFragment.this.getActivity(), NewsFragment.this.getString(2131427546), var8);
                  }
               };
               NewsFragment.this.recyclerView.setAdapter(var2x);
               NewsFragment.this.recyclerView.setLayoutManager(new LinearLayoutManager(NewsFragment.this.getActivity()));
               if(NewsFragment.this.highlightTitles != null && NewsFragment.this.highlightTitles.length == 1) {
                  for(int var3 = 0; var3 < var1.length; ++var3) {
                     if(var1[var3].getTitle().equals(NewsFragment.this.highlightTitles[0])) {
                        if(!PasscodeManager.getInstance().isPassCodeFeatureEnabled(NewsFragment.this.getActivity())) {
                           var2x.onItemClickedListener(var3, var1[var3], (View)null);
                           return;
                        }
                        break;
                     }
                  }
               }
            }

         }
      });
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         this.slug = this.getArguments().getString("slug");
         String var2 = this.getActivity().getIntent().getStringExtra("com.parse.Data");
         if(var2 != null) {
            try {
               String[] var4 = new String[]{(new JsonParser()).parse(var2).getAsJsonObject().getAsJsonPrimitive("title").getAsString()};
               this.highlightTitles = var4;
               return;
            } catch (Exception var5) {
               return;
            }
         }
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130968684, var2, false);
      this.recyclerView = (RecyclerView)var4.findViewById(2131886463);
      this.emptyView = var4.findViewById(2131886464);
      this.getNews(this.slug);
      return var4;
   }
}
