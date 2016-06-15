package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.class_639;
import android.support.v7.widget.SearchView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements OnClickListener {
   private static final boolean DBG = false;
   static final int INVALID_INDEX = -1;
   private static final String LOG_TAG = "SuggestionsAdapter";
   private static final int QUERY_LIMIT = 50;
   static final int REFINE_ALL = 2;
   static final int REFINE_BY_ENTRY = 1;
   static final int REFINE_NONE;
   private boolean mClosed = false;
   private int mFlagsCol = -1;
   private int mIconName1Col = -1;
   private int mIconName2Col = -1;
   private WeakHashMap<String, ConstantState> mOutsideDrawablesCache;
   private Context mProviderContext;
   private int mQueryRefinement = 1;
   private SearchManager mSearchManager;
   private SearchView mSearchView;
   private SearchableInfo mSearchable;
   private int mText1Col = -1;
   private int mText2Col = -1;
   private int mText2UrlCol = -1;
   private ColorStateList mUrlColor;

   public SuggestionsAdapter(Context var1, SearchView var2, SearchableInfo var3, WeakHashMap<String, ConstantState> var4) {
      super(var1, class_639.layout.abc_search_dropdown_item_icons_2line, (Cursor)null, true);
      this.mSearchManager = (SearchManager)this.mContext.getSystemService("search");
      this.mSearchView = var2;
      this.mSearchable = var3;
      this.mProviderContext = var1;
      this.mOutsideDrawablesCache = var4;
   }

   private Drawable checkIconCache(String var1) {
      ConstantState var2 = (ConstantState)this.mOutsideDrawablesCache.get(var1);
      return var2 == null?null:var2.newDrawable();
   }

   private CharSequence formatUrl(CharSequence var1) {
      if(this.mUrlColor == null) {
         TypedValue var2 = new TypedValue();
         this.mContext.getTheme().resolveAttribute(class_639.attr.textColorSearchUrl, var2, true);
         this.mUrlColor = this.mContext.getResources().getColorStateList(var2.resourceId);
      }

      SpannableString var4 = new SpannableString(var1);
      var4.setSpan(new TextAppearanceSpan((String)null, 0, 0, this.mUrlColor, (ColorStateList)null), 0, var1.length(), 33);
      return var4;
   }

   private Drawable getActivityIcon(ComponentName var1) {
      PackageManager var2 = this.mContext.getPackageManager();

      ActivityInfo var5;
      try {
         var5 = var2.getActivityInfo(var1, 128);
      } catch (NameNotFoundException var8) {
         Log.w("SuggestionsAdapter", var8.toString());
         return null;
      }

      int var6 = var5.getIconResource();
      Drawable var7;
      if(var6 == 0) {
         var7 = null;
      } else {
         var7 = var2.getDrawable(var1.getPackageName(), var6, var5.applicationInfo);
         if(var7 == null) {
            Log.w("SuggestionsAdapter", "Invalid icon resource " + var6 + " for " + var1.flattenToShortString());
            return null;
         }
      }

      return var7;
   }

   private Drawable getActivityIconWithCache(ComponentName var1) {
      String var2 = var1.flattenToShortString();
      if(this.mOutsideDrawablesCache.containsKey(var2)) {
         ConstantState var6 = (ConstantState)this.mOutsideDrawablesCache.get(var2);
         return var6 == null?null:var6.newDrawable(this.mProviderContext.getResources());
      } else {
         Drawable var3 = this.getActivityIcon(var1);
         ConstantState var4;
         if(var3 == null) {
            var4 = null;
         } else {
            var4 = var3.getConstantState();
         }

         this.mOutsideDrawablesCache.put(var2, var4);
         return var3;
      }
   }

   public static String getColumnString(Cursor var0, String var1) {
      return getStringOrNull(var0, var0.getColumnIndex(var1));
   }

   private Drawable getDefaultIcon1(Cursor var1) {
      Drawable var2 = this.getActivityIconWithCache(this.mSearchable.getSearchActivity());
      return var2 != null?var2:this.mContext.getPackageManager().getDefaultActivityIcon();
   }

   private Drawable getDrawable(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   private Drawable getDrawableFromResourceValue(String param1) {
      // $FF: Couldn't be decompiled
   }

   private Drawable getIcon1(Cursor var1) {
      Drawable var2;
      if(this.mIconName1Col == -1) {
         var2 = null;
      } else {
         var2 = this.getDrawableFromResourceValue(var1.getString(this.mIconName1Col));
         if(var2 == null) {
            return this.getDefaultIcon1(var1);
         }
      }

      return var2;
   }

   private Drawable getIcon2(Cursor var1) {
      return this.mIconName2Col == -1?null:this.getDrawableFromResourceValue(var1.getString(this.mIconName2Col));
   }

   private static String getStringOrNull(Cursor var0, int var1) {
      if(var1 == -1) {
         return null;
      } else {
         try {
            String var4 = var0.getString(var1);
            return var4;
         } catch (Exception var5) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", var5);
            return null;
         }
      }
   }

   private void setViewDrawable(ImageView var1, Drawable var2, int var3) {
      var1.setImageDrawable(var2);
      if(var2 == null) {
         var1.setVisibility(var3);
      } else {
         var1.setVisibility(0);
         var2.setVisible(false, false);
         var2.setVisible(true, false);
      }
   }

   private void setViewText(TextView var1, CharSequence var2) {
      var1.setText(var2);
      if(TextUtils.isEmpty(var2)) {
         var1.setVisibility(8);
      } else {
         var1.setVisibility(0);
      }
   }

   private void storeInIconCache(String var1, Drawable var2) {
      if(var2 != null) {
         this.mOutsideDrawablesCache.put(var1, var2.getConstantState());
      }

   }

   private void updateSpinnerState(Cursor var1) {
      Bundle var2;
      if(var1 != null) {
         var2 = var1.getExtras();
      } else {
         var2 = null;
      }

      if(var2 != null && var2.getBoolean("in_progress")) {
         ;
      }

   }

   public void bindView(View var1, Context var2, Cursor var3) {
      SuggestionsAdapter.ChildViewCache var4 = (SuggestionsAdapter.ChildViewCache)var1.getTag();
      int var5 = this.mFlagsCol;
      int var6 = 0;
      if(var5 != -1) {
         var6 = var3.getInt(this.mFlagsCol);
      }

      if(var4.mText1 != null) {
         String var9 = getStringOrNull(var3, this.mText1Col);
         this.setViewText(var4.mText1, var9);
      }

      if(var4.mText2 != null) {
         String var7 = getStringOrNull(var3, this.mText2UrlCol);
         Object var8;
         if(var7 != null) {
            var8 = this.formatUrl(var7);
         } else {
            var8 = getStringOrNull(var3, this.mText2Col);
         }

         if(TextUtils.isEmpty((CharSequence)var8)) {
            if(var4.mText1 != null) {
               var4.mText1.setSingleLine(false);
               var4.mText1.setMaxLines(2);
            }
         } else if(var4.mText1 != null) {
            var4.mText1.setSingleLine(true);
            var4.mText1.setMaxLines(1);
         }

         this.setViewText(var4.mText2, (CharSequence)var8);
      }

      if(var4.mIcon1 != null) {
         this.setViewDrawable(var4.mIcon1, this.getIcon1(var3), 4);
      }

      if(var4.mIcon2 != null) {
         this.setViewDrawable(var4.mIcon2, this.getIcon2(var3), 8);
      }

      if(this.mQueryRefinement != 2 && (this.mQueryRefinement != 1 || (var6 & 1) == 0)) {
         var4.mIconRefine.setVisibility(8);
      } else {
         var4.mIconRefine.setVisibility(0);
         var4.mIconRefine.setTag(var4.mText1.getText());
         var4.mIconRefine.setOnClickListener(this);
      }
   }

   public void changeCursor(Cursor param1) {
      // $FF: Couldn't be decompiled
   }

   public void close() {
      this.changeCursor((Cursor)null);
      this.mClosed = true;
   }

   public CharSequence convertToString(Cursor var1) {
      String var2;
      if(var1 == null) {
         var2 = null;
      } else {
         var2 = getColumnString(var1, "suggest_intent_query");
         if(var2 == null) {
            if(this.mSearchable.shouldRewriteQueryFromData()) {
               String var4 = getColumnString(var1, "suggest_intent_data");
               if(var4 != null) {
                  return var4;
               }
            }

            if(this.mSearchable.shouldRewriteQueryFromText()) {
               String var3 = getColumnString(var1, "suggest_text_1");
               if(var3 != null) {
                  return var3;
               }
            }

            return null;
         }
      }

      return var2;
   }

   Drawable getDrawableFromResourceUri(Uri var1) throws FileNotFoundException {
      String var2 = var1.getAuthority();
      if(TextUtils.isEmpty(var2)) {
         throw new FileNotFoundException("No authority: " + var1);
      } else {
         Resources var4;
         try {
            var4 = this.mContext.getPackageManager().getResourcesForApplication(var2);
         } catch (NameNotFoundException var11) {
            throw new FileNotFoundException("No package found for authority: " + var1);
         }

         List var5 = var1.getPathSegments();
         if(var5 == null) {
            throw new FileNotFoundException("No path: " + var1);
         } else {
            int var6 = var5.size();
            int var7;
            if(var6 == 1) {
               int var9;
               try {
                  var9 = Integer.parseInt((String)var5.get(0));
               } catch (NumberFormatException var10) {
                  throw new FileNotFoundException("Single path segment is not a resource ID: " + var1);
               }

               var7 = var9;
            } else {
               if(var6 != 2) {
                  throw new FileNotFoundException("More than two path segments: " + var1);
               }

               var7 = var4.getIdentifier((String)var5.get(1), (String)var5.get(0), var2);
            }

            if(var7 == 0) {
               throw new FileNotFoundException("No resource found for: " + var1);
            } else {
               return var4.getDrawable(var7);
            }
         }
      }
   }

   public int getQueryRefinement() {
      return this.mQueryRefinement;
   }

   Cursor getSearchManagerSuggestions(SearchableInfo var1, String var2, int var3) {
      if(var1 != null) {
         String var4 = var1.getSuggestAuthority();
         if(var4 != null) {
            Builder var5 = (new Builder()).scheme("content").authority(var4).query("").fragment("");
            String var6 = var1.getSuggestPath();
            if(var6 != null) {
               var5.appendEncodedPath(var6);
            }

            var5.appendPath("search_suggest_query");
            String var8 = var1.getSuggestSelection();
            String[] var9;
            if(var8 != null) {
               var9 = new String[]{var2};
            } else {
               var5.appendPath(var2);
               var9 = null;
            }

            if(var3 > 0) {
               var5.appendQueryParameter("limit", String.valueOf(var3));
            }

            Uri var10 = var5.build();
            return this.mContext.getContentResolver().query(var10, (String[])null, var8, var9, (String)null);
         }
      }

      return null;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      View var6;
      View var7;
      try {
         var7 = super.getView(var1, var2, var3);
      } catch (RuntimeException var8) {
         Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", var8);
         var6 = this.newView(this.mContext, this.mCursor, var3);
         if(var6 == null) {
            return var6;
         }

         ((SuggestionsAdapter.ChildViewCache)var6.getTag()).mText1.setText(var8.toString());
         return var6;
      }

      var6 = var7;
      return var6;
   }

   public boolean hasStableIds() {
      return false;
   }

   public View newView(Context var1, Cursor var2, ViewGroup var3) {
      View var4 = super.newView(var1, var2, var3);
      var4.setTag(new SuggestionsAdapter.ChildViewCache(var4));
      return var4;
   }

   public void notifyDataSetChanged() {
      super.notifyDataSetChanged();
      this.updateSpinnerState(this.getCursor());
   }

   public void notifyDataSetInvalidated() {
      super.notifyDataSetInvalidated();
      this.updateSpinnerState(this.getCursor());
   }

   public void onClick(View var1) {
      Object var2 = var1.getTag();
      if(var2 instanceof CharSequence) {
         this.mSearchView.onQueryRefine((CharSequence)var2);
      }

   }

   public Cursor runQueryOnBackgroundThread(CharSequence param1) {
      // $FF: Couldn't be decompiled
   }

   public void setQueryRefinement(int var1) {
      this.mQueryRefinement = var1;
   }

   private static final class ChildViewCache {
      public final ImageView mIcon1;
      public final ImageView mIcon2;
      public final ImageView mIconRefine;
      public final TextView mText1;
      public final TextView mText2;

      public ChildViewCache(View var1) {
         this.mText1 = (TextView)var1.findViewById(16908308);
         this.mText2 = (TextView)var1.findViewById(16908309);
         this.mIcon1 = (ImageView)var1.findViewById(16908295);
         this.mIcon2 = (ImageView)var1.findViewById(16908296);
         this.mIconRefine = (ImageView)var1.findViewById(class_639.class_981.edit_query);
      }
   }
}
