package com.goodrx.activity.pillid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.goodrx.activity.IdentifierDetailActivity;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.activity.pillid.ColorSelectorView;
import com.goodrx.activity.pillid.ShapeSelectorView;
import com.goodrx.adapter.ColorSelectorAdapter;
import com.goodrx.adapter.IdentifierResultAdapter;
import com.goodrx.adapter.ImprintAdapter;
import com.goodrx.adapter.ShapeSelectorAdapter;
import com.goodrx.model.Color;
import com.goodrx.model.DrugObject;
import com.goodrx.model.IdentifierResult;
import com.goodrx.model.ImprintResult;
import com.goodrx.model.PagingResource;
import com.goodrx.model.Pill;
import com.goodrx.model.Shape;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.goodrx.widget.PillIdDropdownButton;
import com.goodrx.widget.MySearchView.MySearchView;
import com.goodrx.widget.MySearchView.OnCollapseListener;
import com.goodrx.widget.MySearchView.OnSearchListener;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PillIdActivity extends BaseActivityWithPasscode {
   PillIdDropdownButton btnColor;
   PillIdDropdownButton btnShape;
   private int colorIndex;
   View emptyView;
   private View footer;
   private String imprint = null;
   private ImprintAdapter imprintAdapter;
   ListView lvImprint;
   ListView lvResult;
   BottomSheetLayout mBottomSheetLayout;
   MyProgressBar myProgressBar;
   View noResultOverlay;
   private PagingResource pager;
   private IdentifierResultAdapter resultAdapter;
   private MenuItem searchMenuItem;
   private MySearchView searchView;
   private int shapeIndex;
   View startView;
   private TextView txtMatchCount;
   View viewIdentifierResult;

   // $FF: synthetic method
   static PagingResource access$100(PillIdActivity var0) {
      return var0.pager;
   }

   // $FF: synthetic method
   static PagingResource access$102(PillIdActivity var0, PagingResource var1) {
      var0.pager = var1;
      return var1;
   }

   // $FF: synthetic method
   static TextView access$200(PillIdActivity var0) {
      return var0.txtMatchCount;
   }

   // $FF: synthetic method
   static IdentifierResultAdapter access$300(PillIdActivity var0) {
      return var0.resultAdapter;
   }

   // $FF: synthetic method
   static View access$400(PillIdActivity var0) {
      return var0.footer;
   }

   private void getResult(String var1, String var2, String var3, final Integer var4) {
      if(var1.length() + var2.length() != 0 || var3 != null && var3.length() != 0) {
         this.myProgressBar.show();
         if(var2.equals("Other")) {
            var2 = "not applicable";
         }

         String var5 = "https://www.goodrx.com/mobile-api/v3/pill-identifier/";
         if(var3 != null && var3.length() > 0) {
            String var8;
            try {
               var8 = URLEncoder.encode(var3, "utf-8");
            } catch (UnsupportedEncodingException var9) {
               return;
            }

            var5 = var5 + var8;
         } else if(var1.length() > 0) {
            var5 = var5 + var1;
         } else if(var2.length() > 0) {
            var5 = var5 + var2;
         }

         RequestParams var6 = new RequestParams();
         var6.add("color", var1);
         var6.add("shape", var2);
         var6.add("drug_object", "1");
         if(var4 != null) {
            var6.add("start", "0");
            var6.add("end", String.valueOf(var4));
         }

         CacheHttpRequestHelper.getInstance().getUsingCache(var5, var6, 604800000L, new MyResponseHandler(this) {
            public void onSuccess(String param1) {
               // $FF: Couldn't be decompiled
            }
         });
      } else {
         this.setScreenMode(PillIdActivity.ScreenMode.START);
      }
   }

   private void hideKeyboard() {
      if(this.searchView != null) {
         this.searchView.clearFocus();
      }

   }

   private boolean isFirstTime() {
      SharedPreferences var1 = PreferenceManager.getDefaultSharedPreferences(this);
      boolean var2 = var1.getBoolean("pill_id_first_time", true);
      if(var2) {
         var1.edit().putBoolean("pill_id_first_time", false).apply();
      }

      return var2;
   }

   public static void launch(Activity var0, String var1) {
      Intent var2 = new Intent(var0, PillIdActivity.class);
      var2.putExtra("imprint", var1);
      var0.startActivity(var2);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   private void showIntroDialog() {
      AlertDialog.Builder var1 = new AlertDialog.Builder(this);
      var1.setTitle(2131427744).setMessage(2131427743).setPositiveButton(2131427603, (OnClickListener)null);
      var1.show();
   }

   void onClick(View var1) {
      int var2 = var1.getId();
      if(var2 == 2131886309) {
         this.hideKeyboard();
         ShapeSelectorView var5 = new ShapeSelectorView(this, this.shapeIndex) {
            public void onShapeSelected(int var1) {
               PillIdActivity.this.mBottomSheetLayout.dismissSheet();
               PillIdActivity.this.setSelectedShape(var1);
            }
         };
         this.mBottomSheetLayout.showWithSheetView(var5);
      } else {
         if(var2 == 2131886308) {
            this.hideKeyboard();
            ColorSelectorView var4 = new ColorSelectorView(this, this.colorIndex) {
               public void onColorSelected(int var1) {
                  PillIdActivity.this.mBottomSheetLayout.dismissSheet();
                  PillIdActivity.this.setSelectedColor(var1);
               }
            };
            this.mBottomSheetLayout.showWithSheetView(var4);
            return;
         }

         if(var2 == 2131886315) {
            this.searchMenuItem.expandActionView();
            return;
         }
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427851);
      this.setContentView(2130968628);
      ButterKnife.bind(this);
      this.setSupportActionBar((Toolbar)this.findViewById(2131886238));
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      this.getSupportActionBar().setHomeAsUpIndicator(2130837666);
      this.imprintAdapter = new ImprintAdapter(this);
      this.lvImprint.setAdapter(this.imprintAdapter);
      this.shapeIndex = 0;
      this.colorIndex = 0;
      this.footer = View.inflate(this, 2130968699, (ViewGroup)null);
      View var2 = View.inflate(this, 2130968706, (ViewGroup)null);
      this.txtMatchCount = (TextView)var2.findViewById(2131886524);
      this.lvResult.addHeaderView(var2, (Object)null, false);
      this.lvResult.setHeaderDividersEnabled(false);
      this.resultAdapter = new IdentifierResultAdapter(this);
      this.lvResult.setAdapter(this.resultAdapter);
      this.lvResult.setVisibility(8);
      if(this.getIntent().hasExtra("imprint")) {
         this.imprint = this.getIntent().getStringExtra("imprint");
      }

      if(var1 == null) {
         this.setScreenMode(PillIdActivity.ScreenMode.START);
      }

      if(this.isFirstTime()) {
         this.showIntroDialog();
      }

   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131951624, var1);
      return true;
   }

   void onIdentifierClicked(int var1) {
      int var2 = var1 - 1;
      if(var2 == this.resultAdapter.getCount()) {
         int var15 = 18 + this.pager.getEnd();
         this.getResult(((Color)ColorSelectorAdapter.getColors().get(this.colorIndex)).getName(), ((Shape)ShapeSelectorAdapter.getShapes().get(this.shapeIndex)).getName(), this.imprint, Integer.valueOf(var15));
      } else {
         IdentifierResult var3 = (IdentifierResult)this.resultAdapter.getItem(var2);
         Intent var4 = new Intent(this, IdentifierDetailActivity.class);
         DrugObject var5 = var3.getDrug_object();
         var4.putExtra("title", var5.getDisplay());
         var4.putExtra("slug", var5.getDrug_slug());
         var4.putExtra("form", var5.getForm());
         var4.putExtra("dosage", var5.getDosage());
         var4.putExtra("drug_name", var5.getDisplay());
         Gson var11 = new Gson();
         Pill[] var12 = var3.getPills();
         String var13;
         if(!(var11 instanceof Gson)) {
            var13 = var11.toJson((Object)var12);
         } else {
            var13 = GsonInstrumentation.toJson((Gson)var11, (Object)var12);
         }

         var4.putExtra("pills", var13);
         this.startActivity(var4);
         this.overridePendingTransition(2131034130, 2131034140);
      }
   }

   void onImprintItemClicked(int var1) {
      this.imprint = ((ImprintResult)this.imprintAdapter.getItem(var1)).getDisplay();
      this.getResult(((Color)ColorSelectorAdapter.getColors().get(this.colorIndex)).getName(), ((Shape)ShapeSelectorAdapter.getShapes().get(this.shapeIndex)).getName(), this.imprint, (Integer)null);
      this.searchView.setTextWithoutSubmit(this.imprint);
      this.searchView.clearFocus();
   }

   boolean onListViewTouched() {
      this.hideKeyboard();
      return false;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 16908332) {
         MainActivity.launchClearTop(this);
         this.finish();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   public boolean onPrepareOptionsMenu(Menu var1) {
      this.searchMenuItem = var1.findItem(2131886786);
      this.searchView = (MySearchView)MenuItemCompat.getActionView(this.searchMenuItem);
      this.searchView.setDelay(300);
      this.searchView.setQueryHint(this.getResources().getString(2131427875));
      if(this.imprint != null) {
         this.searchView.setSearchEnabled(false);
         this.searchMenuItem.expandActionView();
         this.searchView.setTextWithoutSubmit(this.imprint);
         this.searchView.clearFocus();
         this.searchView.setSearchEnabled(true);
         this.getResult(((Color)ColorSelectorAdapter.getColors().get(this.colorIndex)).getName(), ((Shape)ShapeSelectorAdapter.getShapes().get(this.shapeIndex)).getName(), this.imprint, (Integer)null);
      }

      this.searchView.setOnCollapseListener(new OnCollapseListener() {
         public void onCollapse() {
            PillIdActivity.this.onBackPressed();
         }
      });
      this.searchView.setOnSearchListener(new OnSearchListener() {
         public void onSearch(String var1) {
            PillIdActivity.this.searchImprint(var1);
         }
      });
      return super.onPrepareOptionsMenu(var1);
   }

   public void onResume() {
      super.onResume();
      if(this.lvImprint.getVisibility() != 0) {
         this.hideKeyboard();
      }

   }

   public void searchImprint(String var1) {
      if(var1 != null && var1.length() != 0) {
         GoodRxAPI.getInstance().searchImprint(this, var1, new OnRequestFinishListener() {
            public void onSuccess(ImprintResult[] var1) {
               if(var1.length == 0) {
                  PillIdActivity.this.noResultOverlay.setVisibility(0);
               } else {
                  PillIdActivity.this.setScreenMode(PillIdActivity.ScreenMode.IMPRINT);
                  PillIdActivity.this.noResultOverlay.setVisibility(8);
                  PillIdActivity.this.imprintAdapter.updateData(var1);
               }
            }
         });
      } else {
         this.imprint = var1;
         this.getResult(((Color)ColorSelectorAdapter.getColors().get(this.colorIndex)).getName(), ((Shape)ShapeSelectorAdapter.getShapes().get(this.shapeIndex)).getName(), var1, (Integer)null);
      }
   }

   public void setScreenMode(PillIdActivity.ScreenMode var1) {
      this.startView.setVisibility(8);
      this.emptyView.setVisibility(8);
      this.lvResult.setVisibility(8);
      this.lvImprint.setVisibility(8);
      this.noResultOverlay.setVisibility(8);
      this.viewIdentifierResult.setVisibility(0);
      if(var1 == PillIdActivity.ScreenMode.START) {
         this.startView.setVisibility(0);
      } else {
         if(var1 == PillIdActivity.ScreenMode.IMPRINT) {
            this.lvImprint.setVisibility(0);
            this.viewIdentifierResult.setVisibility(8);
            return;
         }

         if(var1 == PillIdActivity.ScreenMode.RESULT) {
            this.lvResult.setVisibility(0);
            return;
         }

         if(var1 == PillIdActivity.ScreenMode.NO_RESULT) {
            this.emptyView.setVisibility(0);
            return;
         }
      }

   }

   public void setSelectedColor(int var1) {
      this.colorIndex = var1;
      Color var2 = (Color)ColorSelectorAdapter.getColors().get(var1);
      if(var1 == 0) {
         this.btnColor.setText(this.getResources().getString(2131427428));
         this.btnColor.setBackground(2130837748);
         this.btnColor.getImageView().setColorFilter(0);
      } else {
         this.btnColor.setText(var2.getName());
         this.btnColor.getImageView().setColorFilter(var2.getRgb());
      }

      this.getResult(((Color)ColorSelectorAdapter.getColors().get(var1)).getName(), ((Shape)ShapeSelectorAdapter.getShapes().get(this.shapeIndex)).getName(), this.imprint, (Integer)null);
   }

   public void setSelectedShape(int var1) {
      this.shapeIndex = var1;
      Shape var2 = (Shape)ShapeSelectorAdapter.getShapes().get(var1);
      this.btnShape.setImageSrc(var2.getImageSrc());
      String var3;
      if(var1 == 0) {
         var3 = this.getResources().getString(2131427429);
      } else {
         var3 = var2.getName();
      }

      this.btnShape.setText(var3);
      this.getResult(((Color)ColorSelectorAdapter.getColors().get(this.colorIndex)).getName(), ((Shape)ShapeSelectorAdapter.getShapes().get(var1)).getName(), this.imprint, (Integer)null);
   }

   public static enum ScreenMode {
      IMPRINT,
      NO_RESULT,
      RESULT,
      START;

      static {
         PillIdActivity.ScreenMode[] var0 = new PillIdActivity.ScreenMode[]{START, IMPRINT, RESULT, NO_RESULT};
      }
   }
}
