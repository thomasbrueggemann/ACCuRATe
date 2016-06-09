package com.goodrx.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.model.DrugObject;
import com.goodrx.model.EventBusMessage;
import com.goodrx.model.LocationEntity;
import com.goodrx.model.Price;
import com.goodrx.utils.Utils;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.utils.recyclerview.BaseRecyclerViewAdapter;
import com.goodrx.utils.recyclerview.BaseViewHolder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.apache.commons.lang3.ArrayUtils;
import org.greenrobot.eventbus.EventBus;

public abstract class PriceListAdapter extends BaseRecyclerViewAdapter<Price> {
   public static final int LIST_ITEM_FOOTER = 2;
   public static final int LIST_ITEM_HEADER = 1;
   public static final int LIST_ITEM_LOW_PRICE = 4;
   public static final int LIST_ITEM_NORMAL = 0;
   public static final int LIST_ITEM_PREFERRED_PHARMACY = 3;
   public static final int LIST_ITEM_PREFERRED_PHARMACY_PRICE_CHANGE = 5;
   public static final int PRICE = 1;
   // $FF: renamed from: RX int
   public static final int field_4;
   private String bestPharmacyId;
   private DrugObject drugObject;
   private boolean hasFooter;
   private boolean hideLocation;
   private String[] highLightPharmacyIds;
   private int pageType;

   public PriceListAdapter(Context var1, boolean var2, boolean var3, String var4, DrugObject var5, String... var6) {
      super(var1);
      this.hideLocation = var2;
      this.hasFooter = var3;
      this.bestPharmacyId = var4;
      this.drugObject = var5;
      this.highLightPharmacyIds = var6;
      this.pageType = 1;
   }

   public Price[] getDataArray() {
      return (Price[])this.mDataArray;
   }

   public int getItemCount() {
      return 1 + ((Price[])this.mDataArray).length;
   }

   public int getItemViewType(int var1) {
      if(var1 == 0) {
         return 1;
      } else if(var1 == -1 + this.getItemCount() && this.hasFooter) {
         return 2;
      } else {
         int var2 = var1 - 1;
         Price var3 = ((Price[])this.mDataArray)[var2];
         boolean var4 = ArrayUtils.contains(this.highLightPharmacyIds, var3.getPharmacy_object().getId());
         return var3.getPharmacy_object().getId().equals(this.bestPharmacyId)?(var4?5:3):(var4?4:0);
      }
   }

   public BaseViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      if(var2 == 0) {
         return new PriceListAdapter.PriceViewHolder(this.mInflater.inflate(2130968740, var1, false));
      } else if(var2 == 1) {
         return new PriceListAdapter.HeaderViewHolder(this.mInflater.inflate(2130968709, var1, false));
      } else if(var2 == 2) {
         return new PriceListAdapter.FooterViewHolder(this.mInflater.inflate(2130968695, var1, false));
      } else {
         int var3;
         if(var2 == 3) {
            var3 = 2130968738;
         } else if(var2 == 5) {
            var3 = 2130968739;
         } else {
            var3 = 2130968737;
         }

         return new PriceListAdapter.PriceViewHolder(this.mInflater.inflate(var3, var1, false));
      }
   }

   public abstract void onFooterViewClicked(int var1);

   public abstract void onHeaderViewClicked(int var1);

   public void setPageType(int var1) {
      this.pageType = var1;
   }

   public void updateData(Price[] var1, boolean var2) {
      this.hideLocation = var2;
      Price var3 = var1[-1 + var1.length];
      if(this.hasFooter && !var3.getPharmacy_object().getType().equals("local_nabp")) {
         this.hasFooter = false;
      }

      super.updateData(var1);
   }

   class FooterViewHolder extends BaseViewHolder implements OnClickListener {
      TextView txtPrice;
      View viewAbout;
      View viewCant;
      View viewMore;

      public FooterViewHolder(View var2) {
         super(var2);
         this.viewMore.setOnClickListener(this);
         this.viewCant.setOnClickListener(this);
         this.viewAbout.setOnClickListener(this);
      }

      protected void onBind(int var1) {
         int var2 = var1 - 1;
         this.txtPrice.setText(Utils.formatPrice(Double.valueOf(((Price[])PriceListAdapter.this.mDataArray)[var2].getPrice())));
      }

      public void onClick(View var1) {
         PriceListAdapter.this.onFooterViewClicked(var1.getId());
      }
   }

   class HeaderViewHolder extends BaseViewHolder implements OnClickListener {
      View headerLayout;
      ImageView imgMap;
      TextView txtDrugInfo;
      TextView txtLocation;

      public HeaderViewHolder(View var2) {
         super(var2);
         this.headerLayout.setOnClickListener(this);
         this.imgMap.setOnClickListener(this);
         if(PriceListAdapter.this.pageType == 1) {
            this.headerLayout.setBackgroundResource(2131755082);
            this.txtDrugInfo.setTextColor(ContextCompat.getColor(PriceListAdapter.this.mContext, 17170444));
            this.txtLocation.setTextColor(ContextCompat.getColor(PriceListAdapter.this.mContext, 2131755083));
            this.imgMap.setColorFilter(ContextCompat.getColor(PriceListAdapter.this.mContext, 2131755021));
         }

      }

      protected void onBind(int var1) {
         TextView var2 = this.txtDrugInfo;
         String var3 = PriceListAdapter.this.mContext.getString(2131427766);
         Object[] var4 = new Object[]{PriceListAdapter.this.drugObject.getDrugInfo()};
         var2.setText(String.format(var3, var4));
         LocationUtils.LocationOption var5 = LocationUtils.getLocationOption(PriceListAdapter.this.mContext);
         if(var5 == LocationUtils.LocationOption.NONE) {
            this.txtLocation.setText(2131427688);
         } else {
            LocationEntity var6 = LocationUtils.getLocationEntity(PriceListAdapter.this.mContext);
            if(var6 != null) {
               this.txtLocation.setText(var6.getFullDisplay());
            }
         }

         if(var5 != LocationUtils.LocationOption.NONE && PriceListAdapter.this.hasFooter) {
            this.imgMap.setVisibility(0);
         } else {
            this.imgMap.setVisibility(8);
         }
      }

      public void onClick(View var1) {
         PriceListAdapter.this.onHeaderViewClicked(var1.getId());
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface PageType {
   }

   class PriceViewHolder extends BaseViewHolder implements OnClickListener {
      ImageView imgLocation;
      View layoutPrice;
      TextView txtDistance;
      TextView txtNameHidden;
      TextView txtPharmacyName;
      TextView txtPrice;
      TextView txtType;

      public PriceViewHolder(View var2) {
         super(var2);
         var2.setOnClickListener(this);
      }

      private void setColor(int var1, int var2) {
      }

      protected void onBind(int var1) {
         boolean var2 = true;
         final int var3 = var1 - 1;
         Price var4 = ((Price[])PriceListAdapter.this.mDataArray)[var3];
         this.txtPharmacyName.setText(var4.getPharmacy_object().getName());
         this.txtDistance.setVisibility(0);
         this.imgLocation.setVisibility(0);
         String var5 = Utils.formatPrice(Double.valueOf(var4.getPrice()));
         this.txtPrice.setText(var5);
         this.txtType.setText(var4.getType_display());
         this.layoutPrice.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               EventBus.getDefault().post(new EventBusMessage("priceClicked", ((Price[])PriceListAdapter.this.mDataArray)[var3]));
            }
         });
         boolean var6 = var4.getPharmacy_object().getName().toLowerCase().contains("pet");
         View var7 = this.layoutPrice;
         boolean var8;
         if(!var6) {
            var8 = var2;
         } else {
            var8 = false;
         }

         var7.setClickable(var8);
         View var9 = this.layoutPrice;
         if(var6) {
            var2 = false;
         }

         var9.setEnabled(var2);
         this.txtNameHidden.setVisibility(8);
         if(var4.getPharmacy_object().getType().equals("nabp")) {
            this.txtNameHidden.setVisibility(0);
         }

         if(!var4.getType().equals("online") && !var4.getType().equals("affiliate")) {
            if(!PriceListAdapter.this.hideLocation && var4.getPharmacy_object().getClosest_location() != null) {
               this.imgLocation.setImageResource(2130837719);
               this.txtDistance.setText(Utils.formatDistance(var4.getPharmacy_object().getClosest_location().doubleValue()));
            } else {
               this.txtDistance.setVisibility(8);
               this.imgLocation.setVisibility(8);
            }

            if(var4.getType().equals("coupon")) {
               this.setColor(2130837607, ContextCompat.getColor(PriceListAdapter.this.mContext, 2131755085));
               return;
            }

            if(var4.getType().equals("cash")) {
               this.setColor(2130837606, ContextCompat.getColor(PriceListAdapter.this.mContext, 2131755021));
               return;
            }

            if(var4.getType().equals("discount")) {
               this.setColor(2130837608, ContextCompat.getColor(PriceListAdapter.this.mContext, 2131755109));
               this.txtType.setText("Membership");
               return;
            }
         } else {
            this.txtDistance.setText(2131427710);
            this.imgLocation.setImageResource(2130837708);
            this.setColor(2130837606, ContextCompat.getColor(PriceListAdapter.this.mContext, 2131755021));
         }

      }

      public void onClick(View var1) {
         int var2 = -1 + this.getAdapterPosition();
         PriceListAdapter.this.onItemClickedListener(var2, ((Price[])PriceListAdapter.this.mDataArray)[var2], var1);
      }
   }
}
