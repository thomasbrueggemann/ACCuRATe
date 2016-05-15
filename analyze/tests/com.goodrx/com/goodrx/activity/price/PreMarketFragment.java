package com.goodrx.activity.price;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.widget.MyProgressBar;

public class PreMarketFragment extends BaseFragmentWitGA {
   private static final String DRUG_NAME = "drug_name";
   private String drugName;

   public static PreMarketFragment newInstance(String var0) {
      PreMarketFragment var1 = new PreMarketFragment();
      Bundle var2 = new Bundle();
      var2.putString("drug_name", var0);
      var1.setArguments(var2);
      return var1;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         this.drugName = this.getArguments().getString("drug_name");
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130968687, var2, false);
      TextView var5 = (TextView)var4.findViewById(2131886471);
      String var6 = this.getString(2131427755);
      Object[] var7 = new Object[]{this.drugName};
      var5.setText(String.format(var6, var7));
      ((MyProgressBar)this.getActivity().findViewById(2131886399)).dismiss();
      return var4;
   }
}
