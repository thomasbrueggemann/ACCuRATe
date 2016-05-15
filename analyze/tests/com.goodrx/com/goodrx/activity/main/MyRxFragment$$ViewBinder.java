package com.goodrx.activity.main;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import com.goodrx.activity.main.MyRxFragment;
import com.goodrx.widget.MySwipeRefreshLayout;

public class MyRxFragment$$ViewBinder<T extends MyRxFragment> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      var2.busyOverlay = (View)var1.findRequiredView(var3, 2131886462, "field \'busyOverlay\'");
      var2.recyclerView = (RecyclerView)var1.castView((View)var1.findRequiredView(var3, 2131886461, "field \'recyclerView\'"), 2131886461, "field \'recyclerView\'");
      var2.emptyView = (View)var1.findRequiredView(var3, 2131886459, "field \'emptyView\'");
      var2.swipeRefreshLayout = (MySwipeRefreshLayout)var1.castView((View)var1.findRequiredView(var3, 2131886460, "field \'swipeRefreshLayout\'"), 2131886460, "field \'swipeRefreshLayout\'");
      var2.appBarLayout = (AppBarLayout)var1.castView((View)var1.findRequiredView(var3, 2131886237, "field \'appBarLayout\'"), 2131886237, "field \'appBarLayout\'");
      ((View)var1.findRequiredView(var3, 2131886323, "method \'onFloatingButtonClicked\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onFloatingButtonClicked();
         }
      });
   }

   public void unbind(T var1) {
      var1.busyOverlay = null;
      var1.recyclerView = null;
      var1.emptyView = null;
      var1.swipeRefreshLayout = null;
      var1.appBarLayout = null;
   }
}
