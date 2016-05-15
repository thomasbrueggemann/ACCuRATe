package com.goodrx.activity.price;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.goodrx.activity.price.PriceListFragment;
import com.goodrx.model.DrugObject;
import com.goodrx.model.MyRx;
import com.goodrx.utils.MyRxUtils;
import org.parceler.Parcels;

public class RxPriceListFragment extends PriceListFragment {
   public static RxPriceListFragment newInstance(DrugObject var0) {
      RxPriceListFragment var1 = new RxPriceListFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("drug_object", Parcels.wrap(var0));
      var1.setArguments(var2);
      return var1;
   }

   protected void initComponent(View var1) {
      super.initComponent(var1);
      this.priceListAdapter.setPageType(0);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.drugObject = (DrugObject)Parcels.unwrap(this.getArguments().getParcelable("drug_object"));
      MyRx var4 = MyRxUtils.findRxByDrugId(this.getContext(), this.drugObject.getId());

      try {
         super.bestPharmacyId = var4.getPreferredPharmacy().getPharm_id();
      } catch (Exception var6) {
         ;
      }

      return super.onCreateView(var1, var2, var3);
   }
}
