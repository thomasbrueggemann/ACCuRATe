package com.goodrx.activity.price;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.activity.SavingsDetailActivity;
import com.goodrx.adapter.SavingsListAdapter;
import com.goodrx.model.DrugObject;
import com.goodrx.model.SavingsTip;
import com.goodrx.utils.PasscodeManager;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import org.apache.commons.lang3.ArrayUtils;
import org.parceler.Parcels;

public class SavingsFragment extends BaseFragmentWitGA {
   private static final String DRUG_OBJECT = "drug_object";
   private DrugObject mDrugObject;
   private String[] mHighlightTitles;
   private RecyclerView mRecyclerView;
   private SavingsTip[] mSavingsTips;

   private void getSavingsTips(String var1, int var2) {
      if(this.isAdded()) {
         final MyProgressBar var3 = (MyProgressBar)this.getActivity().findViewById(2131886399);
         var3.show();
         GoodRxAPI.getInstance().getSavingsTips(this.getActivity(), var1, Integer.valueOf(var2), new OnRequestFinishListener() {
            public void onSuccess(String var1) {
               var3.dismiss();
               JsonArray var2 = (new JsonParser()).parse(var1).getAsJsonObject().getAsJsonObject("results").getAsJsonArray("savings_tips");
               SavingsFragment var3x = SavingsFragment.this;
               Gson var4 = new Gson();
               Object var5;
               if(!(var4 instanceof Gson)) {
                  var5 = var4.fromJson((JsonElement)var2, (Class)SavingsTip[].class);
               } else {
                  var5 = GsonInstrumentation.fromJson((Gson)var4, (JsonElement)var2, (Class)SavingsTip[].class);
               }

               var3x.mSavingsTips = (SavingsTip[])var5;
               SavingsFragment.this.updateUI();
            }
         });
      }
   }

   public static SavingsFragment newInstance(DrugObject var0) {
      SavingsFragment var1 = new SavingsFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("drug_object", Parcels.wrap(var0));
      var1.setArguments(var2);
      return var1;
   }

   private void updateUI() {
      if(this.isAdded()) {
         String var1 = this.getActivity().getIntent().getStringExtra("com.parse.Data");
         if(var1 != null) {
            try {
               String[] var13 = new String[]{(new JsonParser()).parse(var1).getAsJsonObject().getAsJsonPrimitive("title").getAsString()};
               this.mHighlightTitles = var13;
            } catch (Exception var14) {
               ;
            }

            if(this.mHighlightTitles != null && this.mHighlightTitles.length > 0) {
               String[] var5 = this.mHighlightTitles;
               int var6 = var5.length;

               for(int var7 = 0; var7 < var6; ++var7) {
                  String var8 = var5[var7];
                  SavingsTip[] var9 = this.mSavingsTips;
                  int var10 = var9.length;

                  for(int var11 = 0; var11 < var10; ++var11) {
                     SavingsTip var12 = var9[var11];
                     if(var8.equals(var12.getTitle())) {
                        var12.setHighlight(true);
                        break;
                     }
                  }
               }
            }
         }

         SavingsListAdapter var2 = new SavingsListAdapter(this.getActivity(), this.mSavingsTips) {
            public void onItemClickedListener(int var1, SavingsTip var2, View var3) {
               super.onItemClickedListener(var1, var2, var3);
               if(SavingsFragment.this.isAdded()) {
                  if(var2.isHighlight()) {
                     SavingsFragment.this.mHighlightTitles = (String[])ArrayUtils.remove((Object[])SavingsFragment.this.mHighlightTitles, ArrayUtils.indexOf(SavingsFragment.this.mHighlightTitles, var2.getTitle()));
                     var2.setHighlight(false);
                     this.updateData(SavingsFragment.this.mSavingsTips);
                  }

                  SavingsDetailActivity.launch(SavingsFragment.this.getActivity(), var2);
               }
            }
         };
         this.mRecyclerView.setAdapter(var2);
         this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
         if(this.mHighlightTitles != null && this.mHighlightTitles.length == 1) {
            for(int var3 = 0; var3 < this.mSavingsTips.length; ++var3) {
               if(this.mSavingsTips[var3].getTitle().equals(this.mHighlightTitles[0])) {
                  if(!PasscodeManager.getInstance().isPassCodeFeatureEnabled(this.getActivity())) {
                     var2.onItemClickedListener(var3, this.mSavingsTips[var3], (View)null);
                     return;
                  }
                  break;
               }
            }
         }
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         this.mDrugObject = (DrugObject)Parcels.unwrap(this.getArguments().getParcelable("drug_object"));
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130968690, var2, false);
      this.mRecyclerView = (RecyclerView)var4.findViewById(2131886491);
      this.getSavingsTips(this.mDrugObject.getId(), this.mDrugObject.getQuantity());
      return var4;
   }
}
