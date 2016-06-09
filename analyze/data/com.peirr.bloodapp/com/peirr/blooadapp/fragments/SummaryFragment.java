package com.peirr.blooadapp.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.Builders;
import com.peirr.blooadapp.io.Cache;
import com.peirr.blooadapp.io.NetworkResponse;
import com.peirr.blooadapp.io.PreBypassCalculation;
import com.peirr.blooadapp.io.ResponseHelper;
import com.peirr.blooadapp.io.Settings;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;

public class SummaryFragment extends Fragment {
   public static final String ACTUAL_DATA = "actual_pump_hb";
   protected static final String TAG = SummaryFragment.class.getSimpleName();
   private PreBypassCalculation calculation;
   private ProgressDialog progress;
   private View rootView;
   private Settings settings;
   private String value;

   public static SummaryFragment newinstance(PreBypassCalculation var0) {
      SummaryFragment var1 = new SummaryFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("calculations", var0);
      var1.setArguments(var2);
      return var1;
   }

   public void changeBackground() {
      if(Cache.getInstance().isFemale()) {
         this.rootView.setBackgroundColor(this.getResources().getColor(2131099648));
      } else {
         this.rootView.setBackgroundColor(this.getResources().getColor(2131099649));
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.settings = new Settings(this.getActivity());
      this.progress = new ProgressDialog(this.getActivity());
      this.progress.setMessage(this.getString(2131230792));
      if(this.getArguments() != null) {
         this.calculation = (PreBypassCalculation)this.getArguments().getParcelable("calculations");
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      if(this.getActivity() != null) {
         this.getActivity().getActionBar().setTitle("Blood App");
      }

      this.rootView = var1.inflate(2130903056, var2, false);
      this.changeBackground();
      TextView var4 = (TextView)this.rootView.findViewById(2131427378);
      TextView var5 = (TextView)this.rootView.findViewById(2131427379);
      TextView var6 = (TextView)this.rootView.findViewById(2131427380);
      TextView var7 = (TextView)this.rootView.findViewById(2131427381);
      TextView var8 = (TextView)this.rootView.findViewById(2131427382);
      TextView var10000 = (TextView)this.rootView.findViewById(2131427386);
      TextView var10 = (TextView)this.rootView.findViewById(2131427383);
      TextView var11 = (TextView)this.rootView.findViewById(2131427384);
      TextView var12 = (TextView)this.rootView.findViewById(2131427385);
      Button var13 = (Button)this.rootView.findViewById(2131427377);
      final EditText var14 = (EditText)this.rootView.findViewById(2131427387);
      var4.setText(Html.fromHtml("Patient Age: <b>" + this.calculation.age + "</b> "));
      var5.setText(Html.fromHtml("Patient Weight: <b>" + this.calculation.weight + "</b> "));
      StringBuilder var15 = (new StringBuilder()).append("Patient Height: <b>");
      Object[] var16 = new Object[]{Float.valueOf(this.calculation.height)};
      var6.setText(Html.fromHtml(var15.append(String.format("%.2f", var16)).append("</b> ").toString()));
      var7.setText(Html.fromHtml("Operation: <b>" + this.calculation.operation + "</b> "));
      StringBuilder var17 = (new StringBuilder()).append("Blood Volume: <b>");
      Object[] var18 = new Object[]{Float.valueOf(this.calculation.bloodvolume)};
      var10.setText(Html.fromHtml(var17.append(String.format("%.2f", var18)).append("</b> ").toString()));
      float var19 = 10.0F * this.calculation.predictedHbOnPump * this.calculation.bloodvolume;
      if(this.calculation.cardiac) {
         var12.setVisibility(0);
         StringBuilder var24 = (new StringBuilder()).append("Total HB: <b>");
         Object[] var25 = new Object[]{Float.valueOf(var19)};
         var12.setText(Html.fromHtml(var24.append(String.format("%.2f", var25)).append("</b> ").toString()));
         StringBuilder var26 = (new StringBuilder()).append("Predicted Pump Hb: <b>");
         Object[] var27 = new Object[]{Float.valueOf(this.calculation.predictedHbOnPump)};
         var8.setText(Html.fromHtml(var26.append(String.format("%.2f", var27)).append("</b> ").toString()));
         if(this.calculation.rbc > 0.0F) {
            StringBuilder var28 = (new StringBuilder()).append("Initial Hb on pump if <b>").append(this.calculation.rbc).append("</b> ").append(" units RBC added: ").append("<b>");
            Object[] var29 = new Object[]{Float.valueOf(this.calculation.numberOfUnitsRBCNecessary)};
            var11.setText(Html.fromHtml(var28.append(String.format("%.2f", var29)).append("</b> ").toString()));
         }
      } else {
         var12.setVisibility(8);
         StringBuilder var20 = (new StringBuilder()).append("Predicted Post Hb: <b>");
         Object[] var21 = new Object[]{Float.valueOf(this.calculation.predictedHbOnPump)};
         var8.setText(Html.fromHtml(var20.append(String.format("%.2f", var21)).append("</b> ").toString()));
         StringBuilder var22 = (new StringBuilder()).append("Number of RBC required to achieve a post op Hb of ").append(this.calculation.requiredHb).append(": ").append("<b>");
         Object[] var23 = new Object[]{Float.valueOf(this.calculation.numberOfUnitsRBCNecessary)};
         var11.setText(Html.fromHtml(var22.append(String.format("%.2f", var23)).append("</b> ").toString()));
      }

      var13.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            Map var2 = Cache.getInstance().getValues();
            var2.put("actual_pump_hb", var14.getText().toString());
            Builders.class_3 var4 = Ion.with(SummaryFragment.this.getActivity(), (String)"http://indigostorage.co.za/bloodapp/index.php/firehose/report");
            Iterator var5 = var2.entrySet().iterator();

            while(var5.hasNext()) {
               Entry var7 = (Entry)var5.next();
               if((((String)var7.getKey()).equals("fluid_prebypass") || ((String)var7.getKey()).equals("rbc_required") || ((String)var7.getKey()).equals("urine_prebypass") || ((String)var7.getKey()).equals("prime_volume")) && var7.getValue() == null) {
                  var7.setValue("0");
               }

               var4.setBodyParameter((String)var7.getKey(), (String)var7.getValue());
               System.out.println("Key : " + (String)var7.getKey() + " Value : " + (String)var7.getValue());
            }

            ((Builders.class_8)((Builders.class_8)var4.setBodyParameter("docid", SummaryFragment.this.settings.getInt("docid") + "")).setBodyParameter("format", "json")).asJsonObject().setCallback(new FutureCallback() {
               public void onCompleted(Exception var1, JsonObject var2) {
                  SummaryFragment.this.progress.dismiss();
                  Toast.makeText(SummaryFragment.this.getActivity(), "Saved", 0).show();

                  try {
                     NetworkResponse var5 = ResponseHelper.createResponse(var2);
                     Log.d(SummaryFragment.TAG, "[RESPONSE]" + var5);
                     Log.d(SummaryFragment.TAG, "result:" + var2);
                  } catch (JSONException var6) {
                     Log.e(SummaryFragment.TAG, "error:", var6);
                  }
               }
            });
         }
      });
      return this.rootView;
   }

   public void setUserVisibleHint(boolean var1) {
      if(this.rootView != null) {
         this.changeBackground();
      }

   }
}
