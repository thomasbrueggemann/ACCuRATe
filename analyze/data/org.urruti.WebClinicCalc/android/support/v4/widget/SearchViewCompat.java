package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.SearchViewCompatHoneycomb;
import android.support.v4.widget.SearchViewCompatIcs;
import android.view.View;

public class SearchViewCompat {
   private static final SearchViewCompat.SearchViewCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new SearchViewCompat.SearchViewCompatIcsImpl();
      } else if(VERSION.SDK_INT >= 11) {
         IMPL = new SearchViewCompat.SearchViewCompatHoneycombImpl();
      } else {
         IMPL = new SearchViewCompat.SearchViewCompatStubImpl();
      }
   }

   private SearchViewCompat(Context var1) {
   }

   public static CharSequence getQuery(View var0) {
      return IMPL.getQuery(var0);
   }

   public static boolean isIconified(View var0) {
      return IMPL.isIconified(var0);
   }

   public static boolean isQueryRefinementEnabled(View var0) {
      return IMPL.isQueryRefinementEnabled(var0);
   }

   public static boolean isSubmitButtonEnabled(View var0) {
      return IMPL.isSubmitButtonEnabled(var0);
   }

   public static View newSearchView(Context var0) {
      return IMPL.newSearchView(var0);
   }

   public static void setIconified(View var0, boolean var1) {
      IMPL.setIconified(var0, var1);
   }

   public static void setImeOptions(View var0, int var1) {
      IMPL.setImeOptions(var0, var1);
   }

   public static void setInputType(View var0, int var1) {
      IMPL.setInputType(var0, var1);
   }

   public static void setMaxWidth(View var0, int var1) {
      IMPL.setMaxWidth(var0, var1);
   }

   public static void setOnCloseListener(View var0, SearchViewCompat.OnCloseListenerCompat var1) {
      IMPL.setOnCloseListener(var0, var1.mListener);
   }

   public static void setOnQueryTextListener(View var0, SearchViewCompat.OnQueryTextListenerCompat var1) {
      IMPL.setOnQueryTextListener(var0, var1.mListener);
   }

   public static void setQuery(View var0, CharSequence var1, boolean var2) {
      IMPL.setQuery(var0, var1, var2);
   }

   public static void setQueryHint(View var0, CharSequence var1) {
      IMPL.setQueryHint(var0, var1);
   }

   public static void setQueryRefinementEnabled(View var0, boolean var1) {
      IMPL.setQueryRefinementEnabled(var0, var1);
   }

   public static void setSearchableInfo(View var0, ComponentName var1) {
      IMPL.setSearchableInfo(var0, var1);
   }

   public static void setSubmitButtonEnabled(View var0, boolean var1) {
      IMPL.setSubmitButtonEnabled(var0, var1);
   }

   public abstract static class OnCloseListenerCompat {
      final Object mListener;

      public OnCloseListenerCompat() {
         this.mListener = SearchViewCompat.IMPL.newOnCloseListener(this);
      }

      public boolean onClose() {
         return false;
      }
   }

   public abstract static class OnQueryTextListenerCompat {
      final Object mListener;

      public OnQueryTextListenerCompat() {
         this.mListener = SearchViewCompat.IMPL.newOnQueryTextListener(this);
      }

      public boolean onQueryTextChange(String var1) {
         return false;
      }

      public boolean onQueryTextSubmit(String var1) {
         return false;
      }
   }

   static class SearchViewCompatHoneycombImpl extends SearchViewCompat.SearchViewCompatStubImpl {
      public CharSequence getQuery(View var1) {
         return SearchViewCompatHoneycomb.getQuery(var1);
      }

      public boolean isIconified(View var1) {
         return SearchViewCompatHoneycomb.isIconified(var1);
      }

      public boolean isQueryRefinementEnabled(View var1) {
         return SearchViewCompatHoneycomb.isQueryRefinementEnabled(var1);
      }

      public boolean isSubmitButtonEnabled(View var1) {
         return SearchViewCompatHoneycomb.isSubmitButtonEnabled(var1);
      }

      public Object newOnCloseListener(final SearchViewCompat.OnCloseListenerCompat var1) {
         return SearchViewCompatHoneycomb.newOnCloseListener(new SearchViewCompatHoneycomb.OnCloseListenerCompatBridge() {
            public boolean onClose() {
               return var1.onClose();
            }
         });
      }

      public Object newOnQueryTextListener(final SearchViewCompat.OnQueryTextListenerCompat var1) {
         return SearchViewCompatHoneycomb.newOnQueryTextListener(new SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge() {
            public boolean onQueryTextChange(String var1x) {
               return var1.onQueryTextChange(var1x);
            }

            public boolean onQueryTextSubmit(String var1x) {
               return var1.onQueryTextSubmit(var1x);
            }
         });
      }

      public View newSearchView(Context var1) {
         return SearchViewCompatHoneycomb.newSearchView(var1);
      }

      public void setIconified(View var1, boolean var2) {
         SearchViewCompatHoneycomb.setIconified(var1, var2);
      }

      public void setMaxWidth(View var1, int var2) {
         SearchViewCompatHoneycomb.setMaxWidth(var1, var2);
      }

      public void setOnCloseListener(Object var1, Object var2) {
         SearchViewCompatHoneycomb.setOnCloseListener(var1, var2);
      }

      public void setOnQueryTextListener(Object var1, Object var2) {
         SearchViewCompatHoneycomb.setOnQueryTextListener(var1, var2);
      }

      public void setQuery(View var1, CharSequence var2, boolean var3) {
         SearchViewCompatHoneycomb.setQuery(var1, var2, var3);
      }

      public void setQueryHint(View var1, CharSequence var2) {
         SearchViewCompatHoneycomb.setQueryHint(var1, var2);
      }

      public void setQueryRefinementEnabled(View var1, boolean var2) {
         SearchViewCompatHoneycomb.setQueryRefinementEnabled(var1, var2);
      }

      public void setSearchableInfo(View var1, ComponentName var2) {
         SearchViewCompatHoneycomb.setSearchableInfo(var1, var2);
      }

      public void setSubmitButtonEnabled(View var1, boolean var2) {
         SearchViewCompatHoneycomb.setSubmitButtonEnabled(var1, var2);
      }
   }

   static class SearchViewCompatIcsImpl extends SearchViewCompat.SearchViewCompatHoneycombImpl {
      public View newSearchView(Context var1) {
         return SearchViewCompatIcs.newSearchView(var1);
      }

      public void setImeOptions(View var1, int var2) {
         SearchViewCompatIcs.setImeOptions(var1, var2);
      }

      public void setInputType(View var1, int var2) {
         SearchViewCompatIcs.setInputType(var1, var2);
      }
   }

   interface SearchViewCompatImpl {
      CharSequence getQuery(View var1);

      boolean isIconified(View var1);

      boolean isQueryRefinementEnabled(View var1);

      boolean isSubmitButtonEnabled(View var1);

      Object newOnCloseListener(SearchViewCompat.OnCloseListenerCompat var1);

      Object newOnQueryTextListener(SearchViewCompat.OnQueryTextListenerCompat var1);

      View newSearchView(Context var1);

      void setIconified(View var1, boolean var2);

      void setImeOptions(View var1, int var2);

      void setInputType(View var1, int var2);

      void setMaxWidth(View var1, int var2);

      void setOnCloseListener(Object var1, Object var2);

      void setOnQueryTextListener(Object var1, Object var2);

      void setQuery(View var1, CharSequence var2, boolean var3);

      void setQueryHint(View var1, CharSequence var2);

      void setQueryRefinementEnabled(View var1, boolean var2);

      void setSearchableInfo(View var1, ComponentName var2);

      void setSubmitButtonEnabled(View var1, boolean var2);
   }

   static class SearchViewCompatStubImpl implements SearchViewCompat.SearchViewCompatImpl {
      public CharSequence getQuery(View var1) {
         return null;
      }

      public boolean isIconified(View var1) {
         return true;
      }

      public boolean isQueryRefinementEnabled(View var1) {
         return false;
      }

      public boolean isSubmitButtonEnabled(View var1) {
         return false;
      }

      public Object newOnCloseListener(SearchViewCompat.OnCloseListenerCompat var1) {
         return null;
      }

      public Object newOnQueryTextListener(SearchViewCompat.OnQueryTextListenerCompat var1) {
         return null;
      }

      public View newSearchView(Context var1) {
         return null;
      }

      public void setIconified(View var1, boolean var2) {
      }

      public void setImeOptions(View var1, int var2) {
      }

      public void setInputType(View var1, int var2) {
      }

      public void setMaxWidth(View var1, int var2) {
      }

      public void setOnCloseListener(Object var1, Object var2) {
      }

      public void setOnQueryTextListener(Object var1, Object var2) {
      }

      public void setQuery(View var1, CharSequence var2, boolean var3) {
      }

      public void setQueryHint(View var1, CharSequence var2) {
      }

      public void setQueryRefinementEnabled(View var1, boolean var2) {
      }

      public void setSearchableInfo(View var1, ComponentName var2) {
      }

      public void setSubmitButtonEnabled(View var1, boolean var2) {
      }
   }
}
