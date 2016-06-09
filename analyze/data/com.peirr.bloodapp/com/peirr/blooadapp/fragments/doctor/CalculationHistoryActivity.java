package com.peirr.blooadapp.fragments.doctor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.Builders;
import com.peirr.blooadapp.activities.PatientActivity;
import com.peirr.blooadapp.activities.SummaryActivity;
import com.peirr.blooadapp.io.Cache;
import com.peirr.blooadapp.io.CalculationHelper;
import com.peirr.blooadapp.io.Patient;
import com.peirr.blooadapp.io.PreBypassCalculation;
import com.peirr.blooadapp.io.ResponseHelper;
import com.peirr.blooadapp.io.Settings;
import java.util.List;
import java.util.Map;

public class CalculationHistoryActivity extends Activity {
   private CalculationHistoryActivity.HistoryAdapter adapter;
   private ListView listView;
   private List<Patient> patientList;
   private ProgressBar progressBar;
   private Settings settings;

   // $FF: synthetic method
   static CalculationHistoryActivity.HistoryAdapter access$002(CalculationHistoryActivity var0, CalculationHistoryActivity.HistoryAdapter var1) {
      var0.adapter = var1;
      return var1;
   }

   // $FF: synthetic method
   static List access$100(CalculationHistoryActivity var0) {
      return var0.patientList;
   }

   // $FF: synthetic method
   static List access$102(CalculationHistoryActivity var0, List var1) {
      var0.patientList = var1;
      return var1;
   }

   // $FF: synthetic method
   static ListView access$200(CalculationHistoryActivity var0) {
      return var0.listView;
   }

   // $FF: synthetic method
   static ProgressBar access$300(CalculationHistoryActivity var0) {
      return var0.progressBar;
   }

   public void fetchHistory() {
      this.progressBar.setVisibility(0);
      ((Builders.class_8)((Builders.class_8)Ion.with(this, (String)"http://indigostorage.co.za/bloodapp/index.php/firehose/history").setBodyParameter("docid", "" + this.settings.getInt("docid"))).setBodyParameter("format", "json")).asJsonObject().setCallback(new FutureCallback() {
         public void onCompleted(Exception param1, JsonObject param2) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903040);
      this.settings = new Settings(this);
      this.progressBar = (ProgressBar)this.findViewById(2131427329);
      this.listView = (ListView)this.findViewById(2131427330);
      this.listView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            Map var6 = ResponseHelper.createPatientHash(CalculationHistoryActivity.this.adapter.getItem(var3));
            String var7 = (String)var6.get("gender");
            Cache.getInstance().setFemale(var7.equals("1"));
            PreBypassCalculation var8 = CalculationHelper.calculate(var6);
            Intent var9 = new Intent(CalculationHistoryActivity.this, SummaryActivity.class);
            var9.putExtra("calculation", var8);
            CalculationHistoryActivity.this.startActivity(var9);
         }
      });
      this.fetchHistory();
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131361792, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 2131427390) {
         this.startActivity(new Intent(this, PatientActivity.class));
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   public static class HistoryAdapter extends ArrayAdapter {
      private Context context;
      private List<Patient> list;

      HistoryAdapter(Context var1, List<Patient> var2) {
         super(var1, 2130903058, var2);
         this.context = var1;
         this.list = var2;
      }

      public int getCount() {
         return this.list.size();
      }

      public Patient getItem(int var1) {
         return (Patient)this.list.get(var1);
      }

      public int getPosition(Object var1) {
         return super.getPosition(var1);
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         View var4;
         if(var2 == null) {
            var4 = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130903058, (ViewGroup)null);
            CalculationHistoryActivity.ViewHolder var6 = new CalculationHistoryActivity.ViewHolder();
            var6.patientID = (TextView)var4.findViewById(2131427388);
            var6.date = (TextView)var4.findViewById(2131427389);
            var4.setTag(var6);
         } else {
            var4 = var2;
         }

         CalculationHistoryActivity.ViewHolder var5 = (CalculationHistoryActivity.ViewHolder)var4.getTag();
         var5.patientID.setText(Html.fromHtml("Patient: <b>" + String.valueOf(((Patient)this.list.get(var1)).calcid) + "</b> "));
         var5.date.setText(Html.fromHtml("Date: <b>" + ((Patient)this.list.get(var1)).calc_ts + "</b> "));
         return var4;
      }
   }

   static class ViewHolder {
      protected TextView date;
      protected TextView patientID;
   }
}
