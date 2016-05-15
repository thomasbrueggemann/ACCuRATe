package com.goodrx.activity.price;

import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.activity.price.DiscontinuedFragment;
import com.goodrx.activity.price.HcpFragment;
import com.goodrx.activity.price.OtcFragment;
import com.goodrx.activity.price.PreMarketFragment;
import com.goodrx.activity.price.PriceListFragment;
import com.goodrx.model.DrugObject;

public class PriceFragmentFactory {
   public static BaseFragmentWitGA create(DrugObject var0) {
      String var1 = var0.getDrug_page_type();
      String var2 = var0.getDrug_market_type();
      return (BaseFragmentWitGA)(var1.equals("otc")?OtcFragment.newInstance(var0):(var2.equals("discontinued")?DiscontinuedFragment.newInstance(var0.getDisplay()):(var2.equals("pre-market")?PreMarketFragment.newInstance(var0.getDisplay()):(var2.equals("hcp-administered")?HcpFragment.newInstance(var0.getId()):PriceListFragment.newInstance(var0)))));
   }
}
