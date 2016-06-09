package com.goodrx.activity.pillid;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.goodrx.activity.pillid.PillIdActivity;
import com.goodrx.widget.MyProgressBar;
import com.goodrx.widget.PillIdDropdownButton;

public class PillIdActivity$$ViewBinder<T extends PillIdActivity> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      var2.viewIdentifierResult = (View)var1.findRequiredView(var3, 2131886310, "field \'viewIdentifierResult\'");
      View var4 = (View)var1.findRequiredView(var3, 2131886316, "field \'lvImprint\', method \'onImprintItemClicked\', and method \'onListViewTouched\'");
      var2.lvImprint = (ListView)var1.castView(var4, 2131886316, "field \'lvImprint\'");
      ((AdapterView)var4).setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2x, int var3, long var4) {
            var2.onImprintItemClicked(var3);
         }
      });
      var4.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2x) {
            return var2.onListViewTouched();
         }
      });
      var2.noResultOverlay = (View)var1.findRequiredView(var3, 2131886644, "field \'noResultOverlay\'");
      View var5 = (View)var1.findRequiredView(var3, 2131886309, "field \'btnShape\' and method \'onClick\'");
      var2.btnShape = (PillIdDropdownButton)var1.castView(var5, 2131886309, "field \'btnShape\'");
      var5.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      View var6 = (View)var1.findRequiredView(var3, 2131886308, "field \'btnColor\' and method \'onClick\'");
      var2.btnColor = (PillIdDropdownButton)var1.castView(var6, 2131886308, "field \'btnColor\'");
      var6.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      View var7 = (View)var1.findRequiredView(var3, 2131886311, "field \'lvResult\', method \'onIdentifierClicked\', and method \'onListViewTouched\'");
      var2.lvResult = (ListView)var1.castView(var7, 2131886311, "field \'lvResult\'");
      ((AdapterView)var7).setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2x, int var3, long var4) {
            var2.onIdentifierClicked(var3);
         }
      });
      var7.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2x) {
            return var2.onListViewTouched();
         }
      });
      var2.emptyView = (View)var1.findRequiredView(var3, 2131886312, "field \'emptyView\'");
      var2.startView = (View)var1.findRequiredView(var3, 2131886314, "field \'startView\'");
      var2.myProgressBar = (MyProgressBar)var1.castView((View)var1.findRequiredView(var3, 2131886399, "field \'myProgressBar\'"), 2131886399, "field \'myProgressBar\'");
      var2.mBottomSheetLayout = (BottomSheetLayout)var1.castView((View)var1.findRequiredView(var3, 2131886307, "field \'mBottomSheetLayout\'"), 2131886307, "field \'mBottomSheetLayout\'");
      ((View)var1.findRequiredView(var3, 2131886315, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
   }

   public void unbind(T var1) {
      var1.viewIdentifierResult = null;
      var1.lvImprint = null;
      var1.noResultOverlay = null;
      var1.btnShape = null;
      var1.btnColor = null;
      var1.lvResult = null;
      var1.emptyView = null;
      var1.startView = null;
      var1.myProgressBar = null;
      var1.mBottomSheetLayout = null;
   }
}
