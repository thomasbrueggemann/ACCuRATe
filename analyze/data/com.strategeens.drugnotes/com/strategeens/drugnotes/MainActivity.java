package com.strategeens.drugnotes;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.strategeens.drugnotes.AddUpdateDrug;
import com.strategeens.drugnotes.DatabaseHandler;
import com.strategeens.drugnotes.MyApplication;
import com.strategeens.drugnotes.SwipeDismissListViewTouchListener;
import com.strategeens.drugnotes.adapter.NavDrawerListAdapter;
import com.strategeens.drugnotes.model.Drug;
import com.strategeens.drugnotes.model.NavDrawerItem;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class MainActivity extends Activity {
   private static long back_pressed;
   ListView Contact_listview;
   String Toast_msg;
   int USER_ID;
   private NavDrawerListAdapter adapter;
   Button add_btn;
   MainActivity.Contact_Adapter cAdapter;
   ArrayList<Drug> contact_data = new ArrayList();
   // $FF: renamed from: db com.strategeens.drugnotes.DatabaseHandler
   DatabaseHandler field_2777;
   DatabaseHandler db2;
   private DrawerLayout mDrawerLayout;
   private ListView mDrawerList;
   private CharSequence mDrawerTitle;
   private ActionBarDrawerToggle mDrawerToggle;
   private CharSequence mTitle;
   private ArrayList<NavDrawerItem> navDrawerItems;
   private String[] navMenuTitles;
   ImageView tap_on_plus;

   private void exportDB() {
      try {
         File var3 = Environment.getExternalStorageDirectory();
         File var4 = Environment.getDataDirectory();
         if(var3.canWrite()) {
            File var5 = new File(var4, "//data//com.strategeens.drugnotes//databases//drugsManager");
            File var6 = new File(var3, "/Android/data/com.strategeens/Drugnotes/drugsManager");
            var6.setWritable(true);
            var6.setReadable(true);
            FileChannel var9 = (new FileInputStream(var5)).getChannel();
            FileChannel var10 = (new FileOutputStream(var6)).getChannel();
            var10.transferFrom(var9, 0L, var9.size());
            var9.close();
            var10.close();
            Toast.makeText(this.getBaseContext(), "Exported to: \n\n" + var6.toString(), 1).show();
         }

      } catch (Exception var11) {
         Log.e("FILE", var11.toString());
         Toast.makeText(this.getBaseContext(), var11.toString(), 1).show();
      }
   }

   private void importDB() {
      // $FF: Couldn't be decompiled
   }

   public static byte[] readBytes(File var0) {
      try {
         byte[] var2 = new byte[(int)var0.length()];
         BufferedInputStream var3 = new BufferedInputStream(new FileInputStream(var0));
         var3.read(var2, 0, var2.length);
         var3.close();
         return var2;
      } catch (IOException var4) {
         var4.printStackTrace();
         return null;
      }
   }

   public static void writeBytesToFile(File var0, int var1, int var2, byte[] var3) throws IOException {
      BufferedOutputStream var4 = new BufferedOutputStream(new FileOutputStream(var0));
      var4.write(var3, var1, var2);
      var4.close();
   }

   public void Set_Referash_Data() {
      this.contact_data.clear();
      this.field_2777 = new DatabaseHandler(this);
      ArrayList var1 = this.field_2777.Get_Contacts();

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         int var3 = ((Drug)var1.get(var2)).getID();
         String var4 = ((Drug)var1.get(var2)).getName();
         String var5 = ((Drug)var1.get(var2)).getNote();
         String var6 = ((Drug)var1.get(var2)).getDate();
         Drug var7 = new Drug();
         var7.setID(var3);
         var7.setName(var4);
         var7.setNote(var5);
         var7.setDate(var6);
         this.contact_data.add(var7);
      }

      this.field_2777.close();
      this.cAdapter = new MainActivity.Contact_Adapter(this, 2130903044, this.contact_data);
      this.Contact_listview.setAdapter(this.cAdapter);
      this.cAdapter.notifyDataSetChanged();
   }

   public void Show_Toast(String var1) {
      Toast.makeText(this.getApplicationContext(), var1, 1).show();
   }

   public void onBackPressed() {
      GoogleAnalytics.getInstance(this).reportActivityStop(this);
      if(2000L + back_pressed > System.currentTimeMillis()) {
         super.onBackPressed();
      } else {
         Toast.makeText(this.getBaseContext(), "Press once again to exit!", 0).show();
      }

      back_pressed = System.currentTimeMillis();
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.mDrawerToggle.onConfigurationChanged(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903042);
      ((MyApplication)this.getApplication()).getTracker(MyApplication.TrackerName.APP_TRACKER);

      try {
         this.tap_on_plus = (ImageView)this.findViewById(2131558431);
         this.Contact_listview = (ListView)this.findViewById(2131558430);
         this.Set_Referash_Data();
      } catch (Exception var8) {
         Log.e("some error", "" + var8);
      }

      File var5 = new File(Environment.getExternalStorageDirectory() + "/Android/data/com.strategeens");
      File var6 = new File(Environment.getExternalStorageDirectory() + "/Android/data/com.strategeens/Drugnotes");
      if(!var5.exists() && var5.mkdir() && !var6.exists()) {
         var6.mkdir();
      }

      CharSequence var7 = this.getTitle();
      this.mDrawerTitle = var7;
      this.mTitle = var7;
      this.navMenuTitles = this.getResources().getStringArray(2131427328);
      this.mDrawerLayout = (DrawerLayout)this.findViewById(2131558429);
      this.mDrawerList = (ListView)this.findViewById(2131558432);
      this.navDrawerItems = new ArrayList();
      this.navDrawerItems.add(new NavDrawerItem(this.navMenuTitles[0], 1));
      this.navDrawerItems.add(new NavDrawerItem(this.navMenuTitles[1], 1));
      this.adapter = new NavDrawerListAdapter(this.getApplicationContext(), this.navDrawerItems);
      this.mDrawerList.setAdapter(this.adapter);
      this.getActionBar().setDisplayHomeAsUpEnabled(true);
      this.getActionBar().setHomeButtonEnabled(true);
      this.mDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, 2130837535, 2131165219, 2131165219) {
         public void onDrawerClosed(View var1) {
            MainActivity.this.getActionBar().setTitle(MainActivity.this.mTitle);
            MainActivity.this.invalidateOptionsMenu();
         }

         public void onDrawerOpened(View var1) {
            MainActivity.this.getActionBar().setTitle(MainActivity.this.mDrawerTitle);
            MainActivity.this.invalidateOptionsMenu();
         }
      };
      this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
      this.mDrawerList.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            switch(var3) {
            case 0:
               MainActivity.this.importDB();
               break;
            case 1:
               MainActivity.this.exportDB();
            }

            MainActivity.this.mDrawerList.setSelection(var3);
            MainActivity.this.setTitle(MainActivity.this.navMenuTitles[var3]);
            MainActivity.this.mDrawerLayout.closeDrawer(MainActivity.this.mDrawerList);
         }
      });
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131492867, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(!this.mDrawerToggle.onOptionsItemSelected(var1) && var1.getItemId() != 2131558441) {
         super.onOptionsItemSelected(var1);
         if(var1.getItemId() == 2131558442) {
            Intent var3 = new Intent(this, AddUpdateDrug.class);
            var3.putExtra("called", "add");
            var3.setFlags(335544320);
            this.startActivity(var3);
            this.finish();
         }

         return false;
      } else {
         return true;
      }
   }

   protected void onPostCreate(Bundle var1) {
      super.onPostCreate(var1);
      this.mDrawerToggle.syncState();
   }

   public void onResume() {
      super.onResume();
      this.Set_Referash_Data();
   }

   public class Contact_Adapter extends ArrayAdapter<Drug> {
      Activity activity;
      ArrayList<Drug> data = new ArrayList();
      int layoutResourceId;
      Drug user;

      public Contact_Adapter(Activity var1, int var2, ArrayList<Drug> var3) {
         super(var2, var3, var4);
         this.layoutResourceId = var3;
         this.activity = var2;
         this.data = var4;
         this.notifyDataSetChanged();
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         View var4 = var2;
         MainActivity.UserHolder var5;
         if(var2 == null) {
            var4 = LayoutInflater.from(this.activity).inflate(this.layoutResourceId, var3, false);
            var5 = new MainActivity.UserHolder();
            var5.name = (TextView)var4.findViewById(2131558437);
            var5.number = (TextView)var4.findViewById(2131558438);
            var4.setTag(var5);
         } else {
            var5 = (MainActivity.UserHolder)var2.getTag();
         }

         this.user = (Drug)this.data.get(var1);
         MainActivity.this.Contact_listview.setTag(Integer.valueOf(this.user.getID()));
         var5.name.setText(this.user.getName());
         var5.number.setText(this.user.getDate());
         MainActivity.this.tap_on_plus.setVisibility(8);
         MainActivity.this.Contact_listview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
               Drug var6 = (Drug)MainActivity.this.cAdapter.getItem(var3);
               Intent var7 = new Intent(Contact_Adapter.this.activity, AddUpdateDrug.class);
               Bundle var8 = new Bundle();
               var8.putString("called", "update");
               var8.putInt("USER_ID", var6.getID());
               var7.putExtras(var8);
               Contact_Adapter.this.activity.startActivity(var7);
            }
         });
         SwipeDismissListViewTouchListener var6 = new SwipeDismissListViewTouchListener(MainActivity.this.Contact_listview, new SwipeDismissListViewTouchListener.DismissCallbacks() {
            public boolean canDismiss(int var1) {
               return true;
            }

            public void onDismiss(View var1, int[] var2) {
               int var3 = var2.length;

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var2[var4];
                  Drug var6 = (Drug)MainActivity.this.cAdapter.getItem(var5);
                  (new DatabaseHandler(MainActivity.this.getApplicationContext())).Delete_Contact(var6.getID());
                  Toast.makeText(MainActivity.this.getApplicationContext(), "Deleted Successfully", 0).show();
                  MainActivity.this.cAdapter.remove((Drug)MainActivity.this.cAdapter.getItem(var5));
               }

               MainActivity.this.tap_on_plus.setVisibility(0);
               MainActivity.this.cAdapter.notifyDataSetChanged();
            }
         });
         MainActivity.this.Contact_listview.setOnTouchListener(var6);
         MainActivity.this.Contact_listview.setOnScrollListener(var6.makeScrollListener());
         return var4;
      }
   }

   class UserHolder {
      TextView name;
      TextView number;
   }
}
