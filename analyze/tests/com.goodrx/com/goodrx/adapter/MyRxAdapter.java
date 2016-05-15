package com.goodrx.adapter;

import android.app.Activity;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.goodrx.activity.BestPharmacyActivity;
import com.goodrx.activity.BestPharmacyAddressFormater;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.model.BestPharmacy;
import com.goodrx.model.EventBusMessage;
import com.goodrx.model.MyRx;
import com.goodrx.utils.ArrayUtils;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.recyclerview.BaseRecyclerViewAdapter;
import com.goodrx.utils.recyclerview.BaseViewHolder;
import com.goodrx.utils.recyclerview.ItemTouchHelperAdapter;
import com.goodrx.utils.recyclerview.ItemTouchHelperViewHolder;
import com.goodrx.widget.BaseActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.greenrobot.eventbus.EventBus;

public abstract class MyRxAdapter extends BaseRecyclerViewAdapter<MyRx> implements ItemTouchHelperAdapter {
   public static final int LIST_ITEM_FOOTER = 2;
   public static final int LIST_ITEM_HEADER = 1;
   public static final int LIST_ITEM_NORMAL;
   private View rootView;

   public MyRxAdapter(Activity var1, View var2) {
      super(var1);
      this.rootView = var2;
   }

   public int getItemCount() {
      int var1 = ((MyRx[])this.mDataArray).length;
      return var1 < 2?var1 + 1:var1 + 2;
   }

   public int getItemViewType(int var1) {
      return var1 == 0?1:(var1 == 1 + ((MyRx[])this.mDataArray).length?2:0);
   }

   public BaseViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return (BaseViewHolder)(var2 == 1?new MyRxAdapter.TitleHolder(this.mInflater.inflate(2130968712, var1, false)):(var2 == 2?new MyRxAdapter.FooterHolder(this.mInflater.inflate(2130968698, var1, false)):new MyRxAdapter.ContentViewHolder(this.mInflater.inflate(2130968731, var1, false))));
   }

   public void onDrop(int var1, int var2) {
      if(var1 != var2) {
         this.reorderItems();
      }

   }

   public void onItemDismiss(final int var1) {
      final int var2 = var1 - 1;
      View var3 = this.rootView;
      String var4 = this.mContext.getString(2131427808);
      Object[] var5 = new Object[]{((MyRx[])this.mDataArray)[var2].getDrug().getSelected_drug()};
      Snackbar var6 = Utils.makeSnackBar(var3, String.format(var4, var5));
      var6.setAction(2131427999, new OnClickListener() {
         public void onClick(View var1x) {
            MyRxAdapter.this.mDataArray = MyRxUtils.getRx(MyRxAdapter.this.mContext);
            MyRxAdapter.this.notifyItemInserted(var1);
         }
      });
      var6.setCallback(new Snackbar.Callback() {
         public void onDismissed(Snackbar var1, int var2x) {
            if(var2x != 1 && var2x != 3) {
               MyRxAdapter var3 = MyRxAdapter.this;
               String[] var4 = new String[]{MyRxUtils.getRx(MyRxAdapter.this.mContext)[var2].getDrug().getDrug_id()};
               var3.remove(var4);
            }

            super.onDismissed(var1, var2x);
         }
      });
      var6.show();
      this.mDataArray = ArrayUtils.remove(this.mDataArray, var2);
      this.notifyItemRemoved(var1);
      if(((MyRx[])this.mDataArray).length == 1) {
         this.notifyItemRemoved(1 + ((MyRx[])this.mDataArray).length);
      }

   }

   public boolean onItemMove(int var1, int var2) {
      int var3 = var1 - 1;
      int var4 = var2 - 1;
      ArrayUtils.swapInPlace(this.mDataArray, var3, var4);
      this.notifyItemMoved(var1, var2);
      return true;
   }

   public void remove(final String... var1) {
      if(this.mContext != null && this.mContext instanceof BaseActivity) {
         GoodRxAPI.getInstance().removeRx((BaseActivity)this.mContext, new OnRequestFinishListener() {
            public void onSuccess(String var1x) {
               int var2;
               if(((MyRx[])MyRxAdapter.this.mDataArray).length > 1 && !MyRxUtils.isBestPharmacyExpired(MyRxAdapter.this.mContext)) {
                  var2 = MyRxUtils.removeRx(MyRxAdapter.this.mContext, var1);
                  MyRxAdapter.this.notifyItemChanged(1 + ((MyRx[])MyRxAdapter.this.mDataArray).length);
               } else {
                  var2 = MyRxUtils.removeRx(MyRxAdapter.this.mContext, var1);
               }

               if(var2 == 0) {
                  EventBusMessage var3 = new EventBusMessage("changeContent", MainActivity.MainFragmentStatus.WELCOME);
                  EventBus.getDefault().post(var3);
               }

            }
         }, var1);
      }
   }

   public void reorderItems() {
      if(this.mContext != null && this.mContext instanceof BaseActivity) {
         GoodRxAPI.getInstance().reorderRx((BaseActivity)this.mContext, (MyRx[])this.mDataArray, new OnRequestFinishListener() {
            public void onFailure(int var1, String var2) {
               DialogHelper.showErrorDialog(MyRxAdapter.this.mContext, MyRxAdapter.this.mContext.getString(2131427809), var2);
            }

            public void onSuccess(String var1) {
            }
         });
      }
   }

   class ContentViewHolder extends BaseViewHolder implements OnClickListener, ItemTouchHelperViewHolder {
      View container;
      SimpleDraweeView imageView;
      TextView txtAmount;
      TextView txtAsLowAs;
      TextView txtDrugName;
      TextView txtPharmacy;
      TextView txtPrice;
      TextView txtSaving;

      public ContentViewHolder(View var2) {
         super(var2);
         var2.setOnClickListener(this);
      }

      protected void onBind(int var1) {
         int var2 = var1 - 1;
         MyRx var3 = ((MyRx[])MyRxAdapter.this.mDataArray)[var2];
         MyRx.Drug var4 = var3.getDrug();
         if(var4.getImage() == null) {
            Uri var12 = (new Builder()).scheme("res").path(String.valueOf(2130837715)).build();
            this.imageView.setImageURI(var12);
         } else {
            this.imageView.setImageURI(Uri.parse(var4.getImage()));
         }

         this.txtDrugName.setText(var4.getSelected_drug());
         this.txtAmount.setText(var4.getAmount());
         MyRx.PreferredPharmacy var5 = var3.getPreferredPharmacy();
         if(var5 != null && var5.getPharm_id() != null) {
            this.txtPharmacy.setVisibility(0);
            String var11 = "at <b>" + var5.getName() + "</b>";
            this.txtPharmacy.setText(Html.fromHtml(var11));
            this.txtAsLowAs.setVisibility(8);
            this.txtPrice.setText(Utils.formatPrice(var5.getPrice()));
         } else {
            this.txtPharmacy.setVisibility(8);
            this.txtAsLowAs.setVisibility(0);
            this.txtPrice.setText(Utils.formatPrice(var4.getLow_price()));
         }

         this.txtSaving.setVisibility(8);
         if(var4.getLow_price() != null && var5 != null && var5.getPrice() != null) {
            double var6 = var5.getPrice().doubleValue() - var4.getLow_price().doubleValue();
            if(var6 > 0.2D) {
               this.txtSaving.setVisibility(0);
               TextView var8 = this.txtSaving;
               String var9 = MyRxAdapter.this.mContext.getResources().getString(2131427991);
               Object[] var10 = new Object[]{Utils.formatPrice(Double.valueOf(var6))};
               var8.setText(String.format(var9, var10));
            }
         }

         if(var3.isHighlight()) {
            this.container.setBackgroundColor(ContextCompat.getColor(MyRxAdapter.this.mContext, 2131755162));
         } else {
            this.container.setBackgroundResource(17170443);
         }
      }

      public void onClick(View var1) {
         int var2 = -1 + this.getAdapterPosition();
         MyRx var3 = ((MyRx[])MyRxAdapter.this.mDataArray)[var2];
         MyRxAdapter.this.onItemClickedListener(this.getAdapterPosition(), var3, var1);
      }

      public void onItemClear() {
      }

      public void onItemSelected() {
      }
   }

   class FooterHolder extends BaseViewHolder implements OnClickListener {
      TextView txtPharmacyName;
      TextView txtPrice;
      TextView txtSubTitle;
      View viewBestPharmacy;
      View viewButton;

      public FooterHolder(View var2) {
         super(var2);
         this.viewButton.setOnClickListener(this);
         this.viewBestPharmacy.setOnClickListener(this);
      }

      private void setBestPharmacyReady(boolean var1) {
         if(var1) {
            this.viewButton.setVisibility(8);
            this.viewBestPharmacy.setVisibility(0);
         } else {
            this.viewButton.setVisibility(0);
            this.viewBestPharmacy.setVisibility(8);
         }
      }

      private void updateBestPharmacyInfo(BestPharmacy var1) {
         if(var1 != null) {
            this.txtPharmacyName.setText(var1.getName());
            if(var1.getPharmacy_info() != null && var1.getPharmacy_info().length > 0) {
               this.txtSubTitle.setText(BestPharmacyAddressFormater.getAddressText(MyRxAdapter.this.mContext, var1));
            }

            this.txtPrice.setText(Utils.formatPrice(Double.valueOf(var1.getTotal_price())));
         }
      }

      protected void onBind(int var1) {
         BestPharmacy[] var2 = MyRxUtils.getBestpharmacies(MyRxAdapter.this.mContext);
         if(var2.length != 0 && !MyRxUtils.isBestPharmacyExpired(MyRxAdapter.this.mContext)) {
            this.setBestPharmacyReady(true);
            this.updateBestPharmacyInfo(var2[0]);
         } else {
            this.setBestPharmacyReady(false);
         }
      }

      public void onClick(View var1) {
         BestPharmacyActivity.launch((BaseActivity)MyRxAdapter.this.mContext);
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface ListItemType {
   }

   protected class TitleHolder extends BaseViewHolder {
      public TitleHolder(View var2) {
         super(var2);
      }

      protected void onBind(int var1) {
      }
   }
}
