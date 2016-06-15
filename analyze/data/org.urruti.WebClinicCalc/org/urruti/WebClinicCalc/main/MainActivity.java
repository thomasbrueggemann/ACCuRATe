package org.urruti.WebClinicCalc.main;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import java.util.Locale;
import org.urruti.WebClinicCalc.fragments.Bronquiolitis;
import org.urruti.WebClinicCalc.fragments.Fagerstrom;
import org.urruti.WebClinicCalc.fragments.FragmentAlcohol;
import org.urruti.WebClinicCalc.fragments.FragmentAnion;
import org.urruti.WebClinicCalc.fragments.FragmentApgar;
import org.urruti.WebClinicCalc.fragments.FragmentAxis;
import org.urruti.WebClinicCalc.fragments.FragmentCa;
import org.urruti.WebClinicCalc.fragments.FragmentChads;
import org.urruti.WebClinicCalc.fragments.FragmentChild;
import org.urruti.WebClinicCalc.fragments.FragmentCreatina;
import org.urruti.WebClinicCalc.fragments.FragmentExcreNa;
import org.urruti.WebClinicCalc.fragments.FragmentExcreUrea;
import org.urruti.WebClinicCalc.fragments.FragmentFCMax;
import org.urruti.WebClinicCalc.fragments.FragmentFiltrado;
import org.urruti.WebClinicCalc.fragments.FragmentGOLD;
import org.urruti.WebClinicCalc.fragments.FragmentGlasgow;
import org.urruti.WebClinicCalc.fragments.FragmentHasBled;
import org.urruti.WebClinicCalc.fragments.FragmentMeld;
import org.urruti.WebClinicCalc.fragments.FragmentNaCor;
import org.urruti.WebClinicCalc.fragments.FragmentOne;
import org.urruti.WebClinicCalc.fragments.FragmentOsmolar;
import org.urruti.WebClinicCalc.fragments.FragmentSilverman;
import org.urruti.WebClinicCalc.fragments.FragmentTwo;
import org.urruti.WebClinicCalc.main.DrawerItemCustomAdapter;
import org.urruti.WebClinicCalc.main.ObjectDrawerItem;

public class MainActivity extends Activity {
   private int iFragmentSelected;
   private DrawerLayout mDrawerLayout;
   private ListView mDrawerList;
   private CharSequence mDrawerTitle;
   private ActionBarDrawerToggle mDrawerToggle;
   private String[] mNavigationDrawerItemTitles;
   private CharSequence mTitle;
   private int pos;

   private void refresh() {
      this.finish();
      Intent var1 = new Intent(this, MainActivity.class);
      var1.putExtra("selectfrag", this.pos);
      this.startActivity(var1);
   }

   private void selectItem(int var1) {
      this.pos = var1;
      Object var2 = null;
      switch(var1) {
      case 0:
         var2 = new FragmentOne();
         this.iFragmentSelected = 1;
         break;
      case 1:
         var2 = new FragmentTwo();
         break;
      case 2:
         var2 = new FragmentCreatina();
         break;
      case 3:
         var2 = new FragmentFiltrado();
         break;
      case 4:
         var2 = new FragmentExcreNa();
         break;
      case 5:
         var2 = new FragmentExcreUrea();
         break;
      case 6:
         var2 = new FragmentChads();
         break;
      case 7:
         var2 = new FragmentHasBled();
         break;
      case 8:
         var2 = new FragmentFCMax();
         break;
      case 9:
         var2 = new FragmentCa();
         break;
      case 10:
         var2 = new FragmentAxis();
         break;
      case 11:
         var2 = new FragmentGlasgow();
         break;
      case 12:
         var2 = new FragmentGOLD();
         break;
      case 13:
         var2 = new FragmentApgar();
         break;
      case 14:
         var2 = new FragmentSilverman();
         break;
      case 15:
         var2 = new Bronquiolitis();
         break;
      case 16:
         var2 = new Fagerstrom();
         break;
      case 17:
         var2 = new FragmentAlcohol();
         break;
      case 18:
         var2 = new FragmentChild();
         break;
      case 19:
         var2 = new FragmentMeld();
         break;
      case 20:
         var2 = new FragmentNaCor();
         break;
      case 21:
         var2 = new FragmentAnion();
         break;
      case 22:
         var2 = new FragmentOsmolar();
      }

      if(var2 != null) {
         this.getFragmentManager().beginTransaction().replace(2131296277, (Fragment)var2).commit();
         this.mDrawerList.setItemChecked(var1, true);
         this.mDrawerList.setSelection(var1);
         this.setTitle(this.mNavigationDrawerItemTitles[var1]);
         this.mDrawerLayout.closeDrawer(this.mDrawerList);
      } else {
         Log.e("MainActivity", "Error in creating fragment");
      }
   }

   public void EHU(View var1) {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getResources().getText(2131034240).toString())));
   }

   public void FacultadMed(View var1) {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getResources().getText(2131034241).toString())));
   }

   public void alerta(String var1) {
      View var2 = ((LayoutInflater)this.getSystemService("layout_inflater")).inflate(2130903045, (ViewGroup)this.findViewById(2131296279));
      ((TextView)var2.findViewById(2131296281)).setText(var1);
      ((ImageView)var2.findViewById(2131296280)).setImageResource(2130837514);
      ((ImageView)var2.findViewById(2131296282)).setImageResource(2130837516);
      Builder var3 = new Builder(this);
      var3.setView(var2);
      var3.setNegativeButton("OK", new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
         }
      });
      var3.setCancelable(true).setTitle(this.getResources().getText(2131034238).toString());
      var3.create().show();
   }

   public void onBackPressed() {
      if(this.iFragmentSelected == 1) {
         this.selectItem(0);
      } else {
         this.finish();
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.pos = 0;
      this.iFragmentSelected = 0;
      ActionBar var2 = this.getActionBar();
      var2.setDisplayHomeAsUpEnabled(true);
      var2.setHomeButtonEnabled(true);
      var2.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1a237e")));
      if(this.getBaseContext().getSharedPreferences("shprefreg", 0).getBoolean("isBasque", false)) {
         String var9 = Locale.getDefault().getLanguage();
         String var10 = Locale.getDefault().getCountry();
         Locale var11 = new Locale("eu", "ESP");
         Locale.setDefault(var11);
         Configuration var12 = new Configuration();
         var12.locale = var11;
         this.getBaseContext().getResources().updateConfiguration(var12, this.getBaseContext().getResources().getDisplayMetrics());
         Locale var13 = new Locale(var9, var10);
         Locale.setDefault(var13);
      } else {
         Locale var3 = new Locale(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
         Locale.getDefault().getCountry();
         Configuration var5 = new Configuration();
         var5.locale = var3;
         this.getBaseContext().getResources().updateConfiguration(var5, this.getBaseContext().getResources().getDisplayMetrics());
      }

      this.setContentView(2130903043);
      CharSequence var6 = this.getTitle();
      this.mDrawerTitle = var6;
      this.mTitle = var6;
      this.mNavigationDrawerItemTitles = this.getResources().getStringArray(2131099648);
      this.mDrawerLayout = (DrawerLayout)this.findViewById(2131296276);
      this.mDrawerList = (ListView)this.findViewById(2131296278);
      ObjectDrawerItem[] var7 = new ObjectDrawerItem[]{new ObjectDrawerItem(2130837526, this.getResources().getText(2131034117).toString()), new ObjectDrawerItem(2130837527, this.getResources().getText(2131034118).toString()), new ObjectDrawerItem(2130837505, this.getResources().getText(2131034119).toString()), new ObjectDrawerItem(2130837519, this.getResources().getText(2131034120).toString()), new ObjectDrawerItem(2130837506, this.getResources().getText(2131034121).toString()), new ObjectDrawerItem(2130837520, this.getResources().getText(2131034122).toString()), new ObjectDrawerItem(2130837512, this.getResources().getText(2131034123).toString()), new ObjectDrawerItem(2130837523, this.getResources().getText(2131034124).toString()), new ObjectDrawerItem(2130837518, this.getResources().getText(2131034125).toString()), new ObjectDrawerItem(2130837511, this.getResources().getText(2131034126).toString()), new ObjectDrawerItem(2130837515, this.getResources().getText(2131034127).toString()), new ObjectDrawerItem(2130837521, this.getResources().getText(2131034128).toString()), new ObjectDrawerItem(2130837522, this.getResources().getText(2131034269).toString()), new ObjectDrawerItem(2130837509, this.getResources().getText(2131034286).toString()), new ObjectDrawerItem(2130837530, this.getResources().getText(2131034308).toString()), new ObjectDrawerItem(2130837510, this.getResources().getText(2131034130).toString()), new ObjectDrawerItem(2130837517, this.getResources().getText(2131034129).toString()), new ObjectDrawerItem(2130837507, this.getResources().getText(2131034345).toString()), new ObjectDrawerItem(2130837513, this.getResources().getText(2131034393).toString()), new ObjectDrawerItem(2130837513, this.getResources().getText(2131034458).toString()), new ObjectDrawerItem(2130837528, this.getResources().getText(2131034473).toString()), new ObjectDrawerItem(2130837508, this.getResources().getText(2131034476).toString()), new ObjectDrawerItem(2130837529, this.getResources().getText(2131034482).toString())};
      DrawerItemCustomAdapter var8 = new DrawerItemCustomAdapter(this, 2130903068, var7);
      this.mDrawerList.setAdapter(var8);
      this.mDrawerList.setOnItemClickListener(new MainActivity.DrawerItemClickListener((MainActivity.DrawerItemClickListener)null));
      this.mDrawerLayout = (DrawerLayout)this.findViewById(2131296276);
      this.mDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, 2130837524, 2131034131, 2131034132) {
         public void onDrawerClosed(View var1) {
            super.onDrawerClosed(var1);
            MainActivity.this.getActionBar().setTitle(MainActivity.this.mTitle);
         }

         public void onDrawerOpened(View var1) {
            super.onDrawerOpened(var1);
            MainActivity.this.getActionBar().setTitle(MainActivity.this.mDrawerTitle);
         }
      };
      this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
      this.selectItem(this.getIntent().getIntExtra("selectfrag", 0));
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131230744, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      SharedPreferences var2 = this.getBaseContext().getSharedPreferences("shprefreg", 0);
      Editor var3 = var2.edit();
      if(this.mDrawerToggle.onOptionsItemSelected(var1)) {
         return true;
      } else {
         switch(var1.getItemId()) {
         case 2131296686:
            if(!var2.getBoolean("isBasque", false)) {
               var3.putBoolean("isBasque", true);
               var3.commit();
               Toast.makeText(this, "Orain aplikazioa euskeraz egongo da", 0).show();
               this.refresh();
               return true;
            }

            Toast.makeText(this, "Orain aplikazioa ez da euskeraz egongo", 0).show();
            var3.putBoolean("isBasque", false);
            var3.commit();
            this.refresh();
            return true;
         case 2131296687:
         default:
            return super.onOptionsItemSelected(var1);
         case 2131296688:
            Toast.makeText(this, "Sistema métrico internacional", 1).show();
            var3.putBoolean("isImperial", false);
            var3.commit();
            this.refresh();
            return true;
         case 2131296689:
            Toast.makeText(this, "Sistema métrico imperial", 1).show();
            var3.putBoolean("isImperial", true);
            var3.commit();
            this.refresh();
            return true;
         case 2131296690:
            this.alerta(this.getResources().getText(2131034239).toString());
            return true;
         case 2131296691:
            this.alerta(this.getResources().getText(2131034116).toString());
            return true;
         }
      }
   }

   protected void onPostCreate(Bundle var1) {
      super.onPostCreate(var1);
      this.mDrawerToggle.syncState();
   }

   public void setTitle(CharSequence var1) {
      this.mTitle = var1;
      this.getActionBar().setTitle(this.mTitle);
   }

   private class DrawerItemClickListener implements OnItemClickListener {
      private DrawerItemClickListener() {
      }

      // $FF: synthetic method
      DrawerItemClickListener(MainActivity.DrawerItemClickListener var2) {
         this();
      }

      public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
         MainActivity.this.selectItem(var3);
      }
   }
}
