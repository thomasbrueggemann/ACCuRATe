package com.goodrx.widget.MySearchView;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import com.goodrx.class_3;
import com.goodrx.model.EventBusMessage;
import com.goodrx.widget.MySearchView.OnCollapseListener;
import com.goodrx.widget.MySearchView.OnSearchListener;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.EventBus;

public class MySearchView extends SearchView {
   private static int SEARCH_UPDATE = 1;
   private int delay;
   private MySearchView.SearchHandler handler;
   private OnCollapseListener onCollapseListener;
   private OnSearchListener onSearchListener;
   private boolean triggerSearch;

   public MySearchView(Context var1) {
      super(var1);
      this.init(var1);
   }

   public MySearchView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.setAttrs(var1, var2);
      this.init(var1);
   }

   public void init(final Context var1) {
      this.handler = new MySearchView.SearchHandler(this);
      this.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
         public boolean onQueryTextChange(String var1x) {
            if(!MySearchView.this.triggerSearch) {
               return false;
            } else {
               MySearchView.this.handler.removeMessages(MySearchView.SEARCH_UPDATE);
               MySearchView.this.handler.sendEmptyMessageDelayed(MySearchView.SEARCH_UPDATE, (long)MySearchView.this.delay);
               return false;
            }
         }

         public boolean onQueryTextSubmit(String var1x) {
            if(!MySearchView.this.triggerSearch) {
               return false;
            } else {
               if(MySearchView.this.onSearchListener != null) {
                  MySearchView.this.onSearchListener.onSearch(var1x);
               }

               ((InputMethodManager)var1.getSystemService("input_method")).hideSoftInputFromWindow(MySearchView.this.getWindowToken(), 0);
               EventBus.getDefault().post(new EventBusMessage("search_submit", var1x));
               return false;
            }
         }
      });
      this.triggerSearch = true;
   }

   public void onActionViewCollapsed() {
      super.onActionViewCollapsed();
      if(this.onCollapseListener != null) {
         this.onCollapseListener.onCollapse();
      }

   }

   public void onActionViewExpanded() {
      super.onActionViewExpanded();
      if(this.onCollapseListener != null) {
         this.onCollapseListener.onExpand();
      }

   }

   public void setAttrs(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.MySearchView);
      this.delay = var3.getInt(0, 300);
      var3.recycle();
   }

   public void setDelay(int var1) {
      this.delay = var1;
   }

   public void setOnCollapseListener(OnCollapseListener var1) {
      this.onCollapseListener = var1;
   }

   public void setOnSearchListener(OnSearchListener var1) {
      this.onSearchListener = var1;
   }

   public void setSearchEnabled(boolean var1) {
      this.triggerSearch = var1;
   }

   public void setTextWithoutSubmit(String var1) {
      this.triggerSearch = false;
      this.setQuery(var1, false);
      this.triggerSearch = true;
   }

   public void setVisible(boolean var1) {
      if(var1) {
         this.setVisibility(0);
      } else {
         this.setVisibility(8);
      }
   }

   private static class SearchHandler extends Handler {
      private WeakReference<MySearchView> mWeakRefSearchView;

      public SearchHandler(MySearchView var1) {
         this.mWeakRefSearchView = new WeakReference(var1);
      }

      public void handleMessage(Message var1) {
         super.handleMessage(var1);
         MySearchView var2 = (MySearchView)this.mWeakRefSearchView.get();
         if(var2 != null && var1.what == MySearchView.SEARCH_UPDATE && var2.getQuery() != null && var2.onSearchListener != null) {
            var2.onSearchListener.onSearch(var2.getQuery().toString());
         }
      }
   }
}
