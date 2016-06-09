package com.goodrx.activity.price;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.activity.SearchActivity;
import com.goodrx.widget.MyProgressBar;

public class DiscontinuedFragment extends BaseFragmentWitGA {
   private static final String DRUG_NAME = "drug_name";
   private String drugName;

   public static DiscontinuedFragment newInstance(String var0) {
      DiscontinuedFragment var1 = new DiscontinuedFragment();
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
      View var4 = var1.inflate(2130968680, var2, false);
      TextView var5 = (TextView)var4.findViewById(2131886456);
      String var6 = this.getString(2131427530);
      Object[] var7 = new Object[]{this.drugName};
      var5.setText(String.format(var6, var7));
      ((TextView)var4.findViewById(2131886457)).setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(DiscontinuedFragment.this.isAdded()) {
               SearchActivity.launch(DiscontinuedFragment.this.getActivity());
            }
         }
      });
      ((MyProgressBar)this.getActivity().findViewById(2131886399)).dismiss();
      return var4;
   }
}
