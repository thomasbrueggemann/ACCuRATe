package com.goodrx.activity.price;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.activity.store.StoreActivity;
import com.goodrx.model.DrugObject;
import com.goodrx.model.LocationEntity;
import com.goodrx.model.Price;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.Utils;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import org.parceler.Parcels;

public class OtcFragment extends BaseFragmentWitGA {
   private static final String DRUG_OBJECT = "drug_object";
   private DrugObject drugObject;
   private View rootView;

   private void getPrices(DrugObject var1) {
      if(this.isAdded()) {
         final MyProgressBar var2 = (MyProgressBar)this.getActivity().findViewById(2131886399);
         String var3 = "https://www.goodrx.com/mobile-api/v3/price/" + var1.getDrug_slug();
         RequestParams var4 = new RequestParams();
         var4.put("form", var1.getForm());
         var4.put("dosage", var1.getDosage());
         var4.put("quantity", var1.getQuantity());
         var4.put("label_override", var1.getDrug_slug());
         LocationEntity var5 = LocationUtils.getLocationEntity(this.getActivity());
         if(var5 != null) {
            var4.put("set_coords", var5.getLatitude() + "," + var5.getLongitude());
         }

         CacheHttpRequestHelper.getInstance().getUsingLocationSensitiveCache(var3, var4, 14400000L, new MyResponseHandler(this.getActivity()) {
            public void onSuccess(String var1) {
               if(OtcFragment.this.isAdded()) {
                  var2.dismiss();
                  JsonObject var2x = (new JsonParser()).parse(var1).getAsJsonObject();
                  Gson var3 = new Gson();
                  JsonArray var4 = var2x.getAsJsonArray("prices");
                  Object var5;
                  if(!(var3 instanceof Gson)) {
                     var5 = var3.fromJson((JsonElement)var4, (Class)Price[].class);
                  } else {
                     var5 = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var4, (Class)Price[].class);
                  }

                  Price[] var6 = (Price[])var5;
                  if(var6 != null && var6.length > 0) {
                     OtcFragment.this.showOtcPrice(var6[0]);
                     return;
                  }
               }

            }
         });
      }
   }

   public static OtcFragment newInstance(DrugObject var0) {
      OtcFragment var1 = new OtcFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("drug_object", Parcels.wrap(var0));
      var1.setArguments(var2);
      return var1;
   }

   private void showOtcPrice(final Price var1) {
      if(this.isAdded()) {
         View var2 = this.rootView.findViewById(2131886465);
         var2.setVisibility(0);
         TextView var3 = (TextView)this.rootView.findViewById(2131886600);
         TextView var4 = (TextView)this.rootView.findViewById(2131886605);
         ImageView var5 = (ImageView)this.rootView.findViewById(2131886602);
         TextView var6 = (TextView)this.rootView.findViewById(2131886603);
         TextView var7 = (TextView)this.rootView.findViewById(2131886606);
         var3.setText(var1.getPharmacy_object().getName());
         var4.setText(Utils.formatPrice(Double.valueOf(var1.getPrice())));
         var5.setImageResource(2130837708);
         var6.setText(2131427710);
         var7.setText(var1.getType_display());
         var2.setOnClickListener(new OnClickListener() {
            public void onClick(View var1x) {
               if(OtcFragment.this.isAdded()) {
                  StoreActivity.launch(OtcFragment.this.getActivity(), OtcFragment.this.drugObject.getId(), var1.getPharmacy_object().getId(), OtcFragment.this.drugObject.getQuantity(), 5, false);
               }
            }
         });
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         this.drugObject = (DrugObject)Parcels.unwrap(this.getArguments().getParcelable("drug_object"));
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130968685, var2, false);
      ((Button)var4.findViewById(2131886466)).setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            String var2 = "http://www.amazon.com/s/?tag=goo03b-30&field-keywords=" + OtcFragment.this.drugObject.getDrug_slug();
            DialogHelper.showDialog(DialogHelper.openExternalWebsite(OtcFragment.this.getActivity(), var2));
         }
      });
      this.rootView = var4;
      this.getPrices(this.drugObject);
      return var4;
   }
}
