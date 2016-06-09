package android.support.v4.widget;

import android.content.Context;
import android.view.View;
import android.widget.SearchView;

class SearchViewCompatIcs {
   public static View newSearchView(Context var0) {
      return new SearchViewCompatIcs.MySearchView(var0);
   }

   public static void setImeOptions(View var0, int var1) {
      ((SearchView)var0).setImeOptions(var1);
   }

   public static void setInputType(View var0, int var1) {
      ((SearchView)var0).setInputType(var1);
   }

   public static class MySearchView extends SearchView {
      public MySearchView(Context var1) {
         super(var1);
      }

      public void onActionViewCollapsed() {
         this.setQuery("", false);
         super.onActionViewCollapsed();
      }
   }
}
