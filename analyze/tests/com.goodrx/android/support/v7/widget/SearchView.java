package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.os.Build.VERSION;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.SuggestionsAdapter;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.ViewUtils;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.KeyEvent.DispatcherState;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView.OnEditorActionListener;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
   private static final boolean DBG = false;
   static final SearchView.AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER;
   private static final String IME_OPTION_NO_MICROPHONE = "nm";
   private static final boolean IS_AT_LEAST_FROYO = false;
   private static final String LOG_TAG = "SearchView";
   private Bundle mAppSearchData;
   private boolean mClearingFocus;
   private final ImageView mCloseButton;
   private final ImageView mCollapsedIcon;
   private int mCollapsedImeOptions;
   private final CharSequence mDefaultQueryHint;
   private final AppCompatDrawableManager mDrawableManager;
   private final View mDropDownAnchor;
   private boolean mExpandedInActionView;
   private final ImageView mGoButton;
   private boolean mIconified;
   private boolean mIconifiedByDefault;
   private int mMaxWidth;
   private CharSequence mOldQueryText;
   private final OnClickListener mOnClickListener;
   private SearchView.OnCloseListener mOnCloseListener;
   private final OnEditorActionListener mOnEditorActionListener;
   private final OnItemClickListener mOnItemClickListener;
   private final OnItemSelectedListener mOnItemSelectedListener;
   private SearchView.OnQueryTextListener mOnQueryChangeListener;
   private OnFocusChangeListener mOnQueryTextFocusChangeListener;
   private OnClickListener mOnSearchClickListener;
   private SearchView.OnSuggestionListener mOnSuggestionListener;
   private final WeakHashMap<String, ConstantState> mOutsideDrawablesCache;
   private CharSequence mQueryHint;
   private boolean mQueryRefinement;
   private Runnable mReleaseCursorRunnable;
   private final ImageView mSearchButton;
   private final View mSearchEditFrame;
   private final Drawable mSearchHintIcon;
   private final View mSearchPlate;
   private final SearchView.SearchAutoComplete mSearchSrcTextView;
   private SearchableInfo mSearchable;
   private Runnable mShowImeRunnable;
   private final View mSubmitArea;
   private boolean mSubmitButtonEnabled;
   private final int mSuggestionCommitIconResId;
   private final int mSuggestionRowLayout;
   private CursorAdapter mSuggestionsAdapter;
   OnKeyListener mTextKeyListener;
   private TextWatcher mTextWatcher;
   private final Runnable mUpdateDrawableStateRunnable;
   private CharSequence mUserQuery;
   private final Intent mVoiceAppSearchIntent;
   private final ImageView mVoiceButton;
   private boolean mVoiceButtonEnabled;
   private final Intent mVoiceWebSearchIntent;

   static {
      boolean var0;
      if(VERSION.SDK_INT >= 8) {
         var0 = true;
      } else {
         var0 = false;
      }

      IS_AT_LEAST_FROYO = var0;
      HIDDEN_METHOD_INVOKER = new SearchView.AutoCompleteTextViewReflector();
   }

   public SearchView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SearchView(Context var1, AttributeSet var2) {
      this(var1, var2, class_22.attr.searchViewStyle);
   }

   public SearchView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mShowImeRunnable = new Runnable() {
         public void run() {
            InputMethodManager var1 = (InputMethodManager)SearchView.this.getContext().getSystemService("input_method");
            if(var1 != null) {
               SearchView.HIDDEN_METHOD_INVOKER.showSoftInputUnchecked(var1, SearchView.this, 0);
            }

         }
      };
      this.mUpdateDrawableStateRunnable = new Runnable() {
         public void run() {
            SearchView.this.updateFocusedState();
         }
      };
      this.mReleaseCursorRunnable = new Runnable() {
         public void run() {
            if(SearchView.this.mSuggestionsAdapter != null && SearchView.this.mSuggestionsAdapter instanceof SuggestionsAdapter) {
               SearchView.this.mSuggestionsAdapter.changeCursor((Cursor)null);
            }

         }
      };
      this.mOutsideDrawablesCache = new WeakHashMap();
      this.mOnClickListener = new OnClickListener() {
         public void onClick(View var1) {
            if(var1 == SearchView.this.mSearchButton) {
               SearchView.this.onSearchClicked();
            } else {
               if(var1 == SearchView.this.mCloseButton) {
                  SearchView.this.onCloseClicked();
                  return;
               }

               if(var1 == SearchView.this.mGoButton) {
                  SearchView.this.onSubmitQuery();
                  return;
               }

               if(var1 == SearchView.this.mVoiceButton) {
                  SearchView.this.onVoiceClicked();
                  return;
               }

               if(var1 == SearchView.this.mSearchSrcTextView) {
                  SearchView.this.forceSuggestionQuery();
                  return;
               }
            }

         }
      };
      this.mTextKeyListener = new OnKeyListener() {
         public boolean onKey(View var1, int var2, KeyEvent var3) {
            if(SearchView.this.mSearchable != null) {
               if(SearchView.this.mSearchSrcTextView.isPopupShowing() && SearchView.this.mSearchSrcTextView.getListSelection() != -1) {
                  return SearchView.this.onSuggestionsKey(var1, var2, var3);
               }

               if(!SearchView.this.mSearchSrcTextView.isEmpty() && KeyEventCompat.hasNoModifiers(var3) && var3.getAction() == 1 && var2 == 66) {
                  var1.cancelLongPress();
                  SearchView.this.launchQuerySearch(0, (String)null, SearchView.this.mSearchSrcTextView.getText().toString());
                  return true;
               }
            }

            return false;
         }
      };
      this.mOnEditorActionListener = new OnEditorActionListener() {
         public boolean onEditorAction(TextView var1, int var2, KeyEvent var3) {
            SearchView.this.onSubmitQuery();
            return true;
         }
      };
      this.mOnItemClickListener = new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            SearchView.this.onItemClicked(var3, 0, (String)null);
         }
      };
      this.mOnItemSelectedListener = new OnItemSelectedListener() {
         public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
            SearchView.this.onItemSelected(var3);
         }

         public void onNothingSelected(AdapterView<?> var1) {
         }
      };
      this.mTextWatcher = new TextWatcher() {
         public void afterTextChanged(Editable var1) {
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
            SearchView.this.onTextChanged(var1);
         }
      };
      this.mDrawableManager = AppCompatDrawableManager.get();
      TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(var1, var2, class_22.styleable.SearchView, var3, 0);
      LayoutInflater.from(var1).inflate(var4.getResourceId(class_22.styleable.SearchView_layout, class_22.layout.abc_search_view), this, true);
      this.mSearchSrcTextView = (SearchView.SearchAutoComplete)this.findViewById(class_22.class_93.search_src_text);
      this.mSearchSrcTextView.setSearchView(this);
      this.mSearchEditFrame = this.findViewById(class_22.class_93.search_edit_frame);
      this.mSearchPlate = this.findViewById(class_22.class_93.search_plate);
      this.mSubmitArea = this.findViewById(class_22.class_93.submit_area);
      this.mSearchButton = (ImageView)this.findViewById(class_22.class_93.search_button);
      this.mGoButton = (ImageView)this.findViewById(class_22.class_93.search_go_btn);
      this.mCloseButton = (ImageView)this.findViewById(class_22.class_93.search_close_btn);
      this.mVoiceButton = (ImageView)this.findViewById(class_22.class_93.search_voice_btn);
      this.mCollapsedIcon = (ImageView)this.findViewById(class_22.class_93.search_mag_icon);
      this.mSearchPlate.setBackgroundDrawable(var4.getDrawable(class_22.styleable.SearchView_queryBackground));
      this.mSubmitArea.setBackgroundDrawable(var4.getDrawable(class_22.styleable.SearchView_submitBackground));
      this.mSearchButton.setImageDrawable(var4.getDrawable(class_22.styleable.SearchView_searchIcon));
      this.mGoButton.setImageDrawable(var4.getDrawable(class_22.styleable.SearchView_goIcon));
      this.mCloseButton.setImageDrawable(var4.getDrawable(class_22.styleable.SearchView_closeIcon));
      this.mVoiceButton.setImageDrawable(var4.getDrawable(class_22.styleable.SearchView_voiceIcon));
      this.mCollapsedIcon.setImageDrawable(var4.getDrawable(class_22.styleable.SearchView_searchIcon));
      this.mSearchHintIcon = var4.getDrawable(class_22.styleable.SearchView_searchHintIcon);
      this.mSuggestionRowLayout = var4.getResourceId(class_22.styleable.SearchView_suggestionRowLayout, class_22.layout.abc_search_dropdown_item_icons_2line);
      this.mSuggestionCommitIconResId = var4.getResourceId(class_22.styleable.SearchView_commitIcon, 0);
      this.mSearchButton.setOnClickListener(this.mOnClickListener);
      this.mCloseButton.setOnClickListener(this.mOnClickListener);
      this.mGoButton.setOnClickListener(this.mOnClickListener);
      this.mVoiceButton.setOnClickListener(this.mOnClickListener);
      this.mSearchSrcTextView.setOnClickListener(this.mOnClickListener);
      this.mSearchSrcTextView.addTextChangedListener(this.mTextWatcher);
      this.mSearchSrcTextView.setOnEditorActionListener(this.mOnEditorActionListener);
      this.mSearchSrcTextView.setOnItemClickListener(this.mOnItemClickListener);
      this.mSearchSrcTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
      this.mSearchSrcTextView.setOnKeyListener(this.mTextKeyListener);
      this.mSearchSrcTextView.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(SearchView.this.mOnQueryTextFocusChangeListener != null) {
               SearchView.this.mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, var2);
            }

         }
      });
      this.setIconifiedByDefault(var4.getBoolean(class_22.styleable.SearchView_iconifiedByDefault, true));
      int var6 = var4.getDimensionPixelSize(class_22.styleable.SearchView_android_maxWidth, -1);
      if(var6 != -1) {
         this.setMaxWidth(var6);
      }

      this.mDefaultQueryHint = var4.getText(class_22.styleable.SearchView_defaultQueryHint);
      this.mQueryHint = var4.getText(class_22.styleable.SearchView_queryHint);
      int var7 = var4.getInt(class_22.styleable.SearchView_android_imeOptions, -1);
      if(var7 != -1) {
         this.setImeOptions(var7);
      }

      int var8 = var4.getInt(class_22.styleable.SearchView_android_inputType, -1);
      if(var8 != -1) {
         this.setInputType(var8);
      }

      this.setFocusable(var4.getBoolean(class_22.styleable.SearchView_android_focusable, true));
      var4.recycle();
      this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
      this.mVoiceWebSearchIntent.addFlags(268435456);
      this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
      this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
      this.mVoiceAppSearchIntent.addFlags(268435456);
      this.mDropDownAnchor = this.findViewById(this.mSearchSrcTextView.getDropDownAnchor());
      if(this.mDropDownAnchor != null) {
         if(VERSION.SDK_INT >= 11) {
            this.addOnLayoutChangeListenerToDropDownAnchorSDK11();
         } else {
            this.addOnLayoutChangeListenerToDropDownAnchorBase();
         }
      }

      this.updateViewsVisibility(this.mIconifiedByDefault);
      this.updateQueryHint();
   }

   private void addOnLayoutChangeListenerToDropDownAnchorBase() {
      this.mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
         public void onGlobalLayout() {
            SearchView.this.adjustDropDownSizeAndPosition();
         }
      });
   }

   @TargetApi(11)
   private void addOnLayoutChangeListenerToDropDownAnchorSDK11() {
      this.mDropDownAnchor.addOnLayoutChangeListener(new OnLayoutChangeListener() {
         public void onLayoutChange(View var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
            SearchView.this.adjustDropDownSizeAndPosition();
         }
      });
   }

   private void adjustDropDownSizeAndPosition() {
      if(this.mDropDownAnchor.getWidth() > 1) {
         Resources var1 = this.getContext().getResources();
         int var2 = this.mSearchPlate.getPaddingLeft();
         Rect var3 = new Rect();
         boolean var4 = ViewUtils.isLayoutRtl(this);
         int var5;
         if(this.mIconifiedByDefault) {
            var5 = var1.getDimensionPixelSize(class_22.dimen.abc_dropdownitem_icon_width) + var1.getDimensionPixelSize(class_22.dimen.abc_dropdownitem_text_padding_left);
         } else {
            var5 = 0;
         }

         this.mSearchSrcTextView.getDropDownBackground().getPadding(var3);
         int var7;
         if(var4) {
            var7 = -var3.left;
         } else {
            var7 = var2 - (var5 + var3.left);
         }

         this.mSearchSrcTextView.setDropDownHorizontalOffset(var7);
         int var8 = var5 + this.mDropDownAnchor.getWidth() + var3.left + var3.right - var2;
         this.mSearchSrcTextView.setDropDownWidth(var8);
      }

   }

   private Intent createIntent(String var1, Uri var2, String var3, String var4, int var5, String var6) {
      Intent var7 = new Intent(var1);
      var7.addFlags(268435456);
      if(var2 != null) {
         var7.setData(var2);
      }

      var7.putExtra("user_query", this.mUserQuery);
      if(var4 != null) {
         var7.putExtra("query", var4);
      }

      if(var3 != null) {
         var7.putExtra("intent_extra_data_key", var3);
      }

      if(this.mAppSearchData != null) {
         var7.putExtra("app_data", this.mAppSearchData);
      }

      if(var5 != 0) {
         var7.putExtra("action_key", var5);
         var7.putExtra("action_msg", var6);
      }

      if(IS_AT_LEAST_FROYO) {
         var7.setComponent(this.mSearchable.getSearchActivity());
      }

      return var7;
   }

   private Intent createIntentFromSuggestion(Cursor param1, int param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   @TargetApi(8)
   private Intent createVoiceAppSearchIntent(Intent var1, SearchableInfo var2) {
      ComponentName var3 = var2.getSearchActivity();
      Intent var4 = new Intent("android.intent.action.SEARCH");
      var4.setComponent(var3);
      PendingIntent var6 = PendingIntent.getActivity(this.getContext(), 0, var4, 1073741824);
      Bundle var7 = new Bundle();
      if(this.mAppSearchData != null) {
         var7.putParcelable("app_data", this.mAppSearchData);
      }

      Intent var8 = new Intent(var1);
      String var9 = "free_form";
      int var10 = 1;
      int var11 = VERSION.SDK_INT;
      String var12 = null;
      String var13 = null;
      if(var11 >= 8) {
         Resources var22 = this.getResources();
         if(var2.getVoiceLanguageModeId() != 0) {
            var9 = var22.getString(var2.getVoiceLanguageModeId());
         }

         int var23 = var2.getVoicePromptTextId();
         var13 = null;
         if(var23 != 0) {
            var13 = var22.getString(var2.getVoicePromptTextId());
         }

         int var24 = var2.getVoiceLanguageId();
         var12 = null;
         if(var24 != 0) {
            var12 = var22.getString(var2.getVoiceLanguageId());
         }

         if(var2.getVoiceMaxResults() != 0) {
            var10 = var2.getVoiceMaxResults();
         }
      }

      var8.putExtra("android.speech.extra.LANGUAGE_MODEL", var9);
      var8.putExtra("android.speech.extra.PROMPT", var13);
      var8.putExtra("android.speech.extra.LANGUAGE", var12);
      var8.putExtra("android.speech.extra.MAX_RESULTS", var10);
      String var18;
      if(var3 == null) {
         var18 = null;
      } else {
         var18 = var3.flattenToShortString();
      }

      var8.putExtra("calling_package", var18);
      var8.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", var6);
      var8.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", var7);
      return var8;
   }

   @TargetApi(8)
   private Intent createVoiceWebSearchIntent(Intent var1, SearchableInfo var2) {
      Intent var3 = new Intent(var1);
      ComponentName var4 = var2.getSearchActivity();
      String var5;
      if(var4 == null) {
         var5 = null;
      } else {
         var5 = var4.flattenToShortString();
      }

      var3.putExtra("calling_package", var5);
      return var3;
   }

   private void dismissSuggestions() {
      this.mSearchSrcTextView.dismissDropDown();
   }

   private void forceSuggestionQuery() {
      HIDDEN_METHOD_INVOKER.doBeforeTextChanged(this.mSearchSrcTextView);
      HIDDEN_METHOD_INVOKER.doAfterTextChanged(this.mSearchSrcTextView);
   }

   private CharSequence getDecoratedHint(CharSequence var1) {
      if(this.mIconifiedByDefault && this.mSearchHintIcon != null) {
         int var2 = (int)(1.25D * (double)this.mSearchSrcTextView.getTextSize());
         this.mSearchHintIcon.setBounds(0, 0, var2, var2);
         SpannableStringBuilder var3 = new SpannableStringBuilder("   ");
         var3.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
         var3.append(var1);
         return var3;
      } else {
         return var1;
      }
   }

   private int getPreferredWidth() {
      return this.getContext().getResources().getDimensionPixelSize(class_22.dimen.abc_search_view_preferred_width);
   }

   @TargetApi(8)
   private boolean hasVoiceSearch() {
      SearchableInfo var1 = this.mSearchable;
      boolean var2 = false;
      if(var1 != null) {
         boolean var3 = this.mSearchable.getVoiceSearchEnabled();
         var2 = false;
         if(var3) {
            Intent var5;
            if(this.mSearchable.getVoiceSearchLaunchWebSearch()) {
               var5 = this.mVoiceWebSearchIntent;
            } else {
               boolean var4 = this.mSearchable.getVoiceSearchLaunchRecognizer();
               var5 = null;
               if(var4) {
                  var5 = this.mVoiceAppSearchIntent;
               }
            }

            var2 = false;
            if(var5 != null) {
               ResolveInfo var6 = this.getContext().getPackageManager().resolveActivity(var5, 65536);
               var2 = false;
               if(var6 != null) {
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   static boolean isLandscapeMode(Context var0) {
      return var0.getResources().getConfiguration().orientation == 2;
   }

   private boolean isSubmitAreaEnabled() {
      return (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !this.isIconified();
   }

   private void launchIntent(Intent var1) {
      if(var1 != null) {
         try {
            this.getContext().startActivity(var1);
         } catch (RuntimeException var3) {
            Log.e("SearchView", "Failed launch activity: " + var1, var3);
         }
      }
   }

   private void launchQuerySearch(int var1, String var2, String var3) {
      Intent var4 = this.createIntent("android.intent.action.SEARCH", (Uri)null, (String)null, var3, var1, var2);
      this.getContext().startActivity(var4);
   }

   private boolean launchSuggestion(int var1, int var2, String var3) {
      Cursor var4 = this.mSuggestionsAdapter.getCursor();
      if(var4 != null && var4.moveToPosition(var1)) {
         this.launchIntent(this.createIntentFromSuggestion(var4, var2, var3));
         return true;
      } else {
         return false;
      }
   }

   private void onCloseClicked() {
      if(!TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
         this.mSearchSrcTextView.setText("");
         this.mSearchSrcTextView.requestFocus();
         this.setImeVisibility(true);
      } else {
         if(this.mIconifiedByDefault && (this.mOnCloseListener == null || !this.mOnCloseListener.onClose())) {
            this.clearFocus();
            this.updateViewsVisibility(true);
         }

      }
   }

   private boolean onItemClicked(int var1, int var2, String var3) {
      boolean var5;
      if(this.mOnSuggestionListener != null) {
         boolean var6 = this.mOnSuggestionListener.onSuggestionClick(var1);
         var5 = false;
         if(var6) {
            return var5;
         }
      }

      this.launchSuggestion(var1, 0, (String)null);
      this.setImeVisibility(false);
      this.dismissSuggestions();
      var5 = true;
      return var5;
   }

   private boolean onItemSelected(int var1) {
      if(this.mOnSuggestionListener != null && this.mOnSuggestionListener.onSuggestionSelect(var1)) {
         return false;
      } else {
         this.rewriteQueryFromSuggestion(var1);
         return true;
      }
   }

   private void onSearchClicked() {
      this.updateViewsVisibility(false);
      this.mSearchSrcTextView.requestFocus();
      this.setImeVisibility(true);
      if(this.mOnSearchClickListener != null) {
         this.mOnSearchClickListener.onClick(this);
      }

   }

   private void onSubmitQuery() {
      Editable var1 = this.mSearchSrcTextView.getText();
      if(var1 != null && TextUtils.getTrimmedLength(var1) > 0 && (this.mOnQueryChangeListener == null || !this.mOnQueryChangeListener.onQueryTextSubmit(var1.toString()))) {
         if(this.mSearchable != null) {
            this.launchQuerySearch(0, (String)null, var1.toString());
         }

         this.setImeVisibility(false);
         this.dismissSuggestions();
      }

   }

   private boolean onSuggestionsKey(View var1, int var2, KeyEvent var3) {
      if(this.mSearchable != null && this.mSuggestionsAdapter != null && var3.getAction() == 0 && KeyEventCompat.hasNoModifiers(var3)) {
         if(var2 != 66 && var2 != 84 && var2 != 61) {
            if(var2 != 21 && var2 != 22) {
               if(var2 == 19 && this.mSearchSrcTextView.getListSelection() == 0) {
                  return false;
               } else {
                  return false;
               }
            } else {
               int var4;
               if(var2 == 21) {
                  var4 = 0;
               } else {
                  var4 = this.mSearchSrcTextView.length();
               }

               this.mSearchSrcTextView.setSelection(var4);
               this.mSearchSrcTextView.setListSelection(0);
               this.mSearchSrcTextView.clearListSelection();
               HIDDEN_METHOD_INVOKER.ensureImeVisible(this.mSearchSrcTextView, true);
               return true;
            }
         } else {
            return this.onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, (String)null);
         }
      } else {
         return false;
      }
   }

   private void onTextChanged(CharSequence var1) {
      boolean var2 = true;
      Editable var3 = this.mSearchSrcTextView.getText();
      this.mUserQuery = var3;
      boolean var4;
      if(!TextUtils.isEmpty(var3)) {
         var4 = var2;
      } else {
         var4 = false;
      }

      this.updateSubmitButton(var4);
      if(var4) {
         var2 = false;
      }

      this.updateVoiceButton(var2);
      this.updateCloseButton();
      this.updateSubmitArea();
      if(this.mOnQueryChangeListener != null && !TextUtils.equals(var1, this.mOldQueryText)) {
         this.mOnQueryChangeListener.onQueryTextChange(var1.toString());
      }

      this.mOldQueryText = var1.toString();
   }

   @TargetApi(8)
   private void onVoiceClicked() {
      if(this.mSearchable != null) {
         SearchableInfo var1 = this.mSearchable;

         try {
            if(var1.getVoiceSearchLaunchWebSearch()) {
               Intent var5 = this.createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, var1);
               this.getContext().startActivity(var5);
               return;
            }

            if(var1.getVoiceSearchLaunchRecognizer()) {
               Intent var4 = this.createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, var1);
               this.getContext().startActivity(var4);
               return;
            }
         } catch (ActivityNotFoundException var6) {
            Log.w("SearchView", "Could not find voice search activity");
            return;
         }
      }

   }

   private void postUpdateFocusedState() {
      this.post(this.mUpdateDrawableStateRunnable);
   }

   private void rewriteQueryFromSuggestion(int var1) {
      Editable var2 = this.mSearchSrcTextView.getText();
      Cursor var3 = this.mSuggestionsAdapter.getCursor();
      if(var3 != null) {
         if(var3.moveToPosition(var1)) {
            CharSequence var4 = this.mSuggestionsAdapter.convertToString(var3);
            if(var4 != null) {
               this.setQuery(var4);
            } else {
               this.setQuery(var2);
            }
         } else {
            this.setQuery(var2);
         }
      }
   }

   private void setImeVisibility(boolean var1) {
      if(var1) {
         this.post(this.mShowImeRunnable);
      } else {
         this.removeCallbacks(this.mShowImeRunnable);
         InputMethodManager var3 = (InputMethodManager)this.getContext().getSystemService("input_method");
         if(var3 != null) {
            var3.hideSoftInputFromWindow(this.getWindowToken(), 0);
            return;
         }
      }

   }

   private void setQuery(CharSequence var1) {
      this.mSearchSrcTextView.setText(var1);
      SearchView.SearchAutoComplete var2 = this.mSearchSrcTextView;
      int var3;
      if(TextUtils.isEmpty(var1)) {
         var3 = 0;
      } else {
         var3 = var1.length();
      }

      var2.setSelection(var3);
   }

   private void updateCloseButton() {
      boolean var1 = true;
      boolean var2;
      if(!TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
         var2 = var1;
      } else {
         var2 = false;
      }

      if(!var2 && (!this.mIconifiedByDefault || this.mExpandedInActionView)) {
         var1 = false;
      }

      ImageView var3 = this.mCloseButton;
      byte var4 = 0;
      if(!var1) {
         var4 = 8;
      }

      var3.setVisibility(var4);
      Drawable var5 = this.mCloseButton.getDrawable();
      if(var5 != null) {
         int[] var6;
         if(var2) {
            var6 = ENABLED_STATE_SET;
         } else {
            var6 = EMPTY_STATE_SET;
         }

         var5.setState(var6);
      }

   }

   private void updateFocusedState() {
      int[] var1;
      if(this.mSearchSrcTextView.hasFocus()) {
         var1 = FOCUSED_STATE_SET;
      } else {
         var1 = EMPTY_STATE_SET;
      }

      Drawable var2 = this.mSearchPlate.getBackground();
      if(var2 != null) {
         var2.setState(var1);
      }

      Drawable var3 = this.mSubmitArea.getBackground();
      if(var3 != null) {
         var3.setState(var1);
      }

      this.invalidate();
   }

   private void updateQueryHint() {
      Object var1 = this.getQueryHint();
      SearchView.SearchAutoComplete var2 = this.mSearchSrcTextView;
      if(var1 == null) {
         var1 = "";
      }

      var2.setHint(this.getDecoratedHint((CharSequence)var1));
   }

   @TargetApi(8)
   private void updateSearchAutoComplete() {
      byte var1 = 1;
      this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
      this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
      int var2 = this.mSearchable.getInputType();
      if((var2 & 15) == var1) {
         var2 &= -65537;
         if(this.mSearchable.getSuggestAuthority() != null) {
            var2 = 524288 | var2 | 65536;
         }
      }

      this.mSearchSrcTextView.setInputType(var2);
      if(this.mSuggestionsAdapter != null) {
         this.mSuggestionsAdapter.changeCursor((Cursor)null);
      }

      if(this.mSearchable.getSuggestAuthority() != null) {
         this.mSuggestionsAdapter = new SuggestionsAdapter(this.getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
         this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
         SuggestionsAdapter var3 = (SuggestionsAdapter)this.mSuggestionsAdapter;
         if(this.mQueryRefinement) {
            var1 = 2;
         }

         var3.setQueryRefinement(var1);
      }

   }

   private void updateSubmitArea() {
      byte var1 = 8;
      if(this.isSubmitAreaEnabled() && (this.mGoButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) {
         var1 = 0;
      }

      this.mSubmitArea.setVisibility(var1);
   }

   private void updateSubmitButton(boolean var1) {
      byte var2 = 8;
      if(this.mSubmitButtonEnabled && this.isSubmitAreaEnabled() && this.hasFocus() && (var1 || !this.mVoiceButtonEnabled)) {
         var2 = 0;
      }

      this.mGoButton.setVisibility(var2);
   }

   private void updateViewsVisibility(boolean var1) {
      byte var2 = 8;
      boolean var3 = true;
      this.mIconified = var1;
      byte var4;
      if(var1) {
         var4 = 0;
      } else {
         var4 = var2;
      }

      boolean var5;
      if(!TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
         var5 = var3;
      } else {
         var5 = false;
      }

      this.mSearchButton.setVisibility(var4);
      this.updateSubmitButton(var5);
      View var6 = this.mSearchEditFrame;
      if(!var1) {
         var2 = 0;
      }

      var6.setVisibility(var2);
      byte var7;
      if(this.mCollapsedIcon.getDrawable() != null && !this.mIconifiedByDefault) {
         var7 = 0;
      } else {
         var7 = 8;
      }

      this.mCollapsedIcon.setVisibility(var7);
      this.updateCloseButton();
      if(var5) {
         var3 = false;
      }

      this.updateVoiceButton(var3);
      this.updateSubmitArea();
   }

   private void updateVoiceButton(boolean var1) {
      byte var2 = 8;
      if(this.mVoiceButtonEnabled && !this.isIconified() && var1) {
         var2 = 0;
         this.mGoButton.setVisibility(8);
      }

      this.mVoiceButton.setVisibility(var2);
   }

   public void clearFocus() {
      this.mClearingFocus = true;
      this.setImeVisibility(false);
      super.clearFocus();
      this.mSearchSrcTextView.clearFocus();
      this.mClearingFocus = false;
   }

   public int getImeOptions() {
      return this.mSearchSrcTextView.getImeOptions();
   }

   public int getInputType() {
      return this.mSearchSrcTextView.getInputType();
   }

   public int getMaxWidth() {
      return this.mMaxWidth;
   }

   public CharSequence getQuery() {
      return this.mSearchSrcTextView.getText();
   }

   public CharSequence getQueryHint() {
      return this.mQueryHint != null?this.mQueryHint:(IS_AT_LEAST_FROYO && this.mSearchable != null && this.mSearchable.getHintId() != 0?this.getContext().getText(this.mSearchable.getHintId()):this.mDefaultQueryHint);
   }

   int getSuggestionCommitIconResId() {
      return this.mSuggestionCommitIconResId;
   }

   int getSuggestionRowLayout() {
      return this.mSuggestionRowLayout;
   }

   public CursorAdapter getSuggestionsAdapter() {
      return this.mSuggestionsAdapter;
   }

   public boolean isIconfiedByDefault() {
      return this.mIconifiedByDefault;
   }

   public boolean isIconified() {
      return this.mIconified;
   }

   public boolean isQueryRefinementEnabled() {
      return this.mQueryRefinement;
   }

   public boolean isSubmitButtonEnabled() {
      return this.mSubmitButtonEnabled;
   }

   public void onActionViewCollapsed() {
      this.setQuery("", false);
      this.clearFocus();
      this.updateViewsVisibility(true);
      this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
      this.mExpandedInActionView = false;
   }

   public void onActionViewExpanded() {
      if(!this.mExpandedInActionView) {
         this.mExpandedInActionView = true;
         this.mCollapsedImeOptions = this.mSearchSrcTextView.getImeOptions();
         this.mSearchSrcTextView.setImeOptions(33554432 | this.mCollapsedImeOptions);
         this.mSearchSrcTextView.setText("");
         this.setIconified(false);
      }
   }

   protected void onDetachedFromWindow() {
      this.removeCallbacks(this.mUpdateDrawableStateRunnable);
      this.post(this.mReleaseCursorRunnable);
      super.onDetachedFromWindow();
   }

   protected void onMeasure(int var1, int var2) {
      if(this.isIconified()) {
         super.onMeasure(var1, var2);
      } else {
         int var3 = MeasureSpec.getMode(var1);
         int var4 = MeasureSpec.getSize(var1);
         switch(var3) {
         case Integer.MIN_VALUE:
            if(this.mMaxWidth > 0) {
               var4 = Math.min(this.mMaxWidth, var4);
            } else {
               var4 = Math.min(this.getPreferredWidth(), var4);
            }
            break;
         case 0:
            if(this.mMaxWidth > 0) {
               var4 = this.mMaxWidth;
            } else {
               var4 = this.getPreferredWidth();
            }
            break;
         case 1073741824:
            if(this.mMaxWidth > 0) {
               var4 = Math.min(this.mMaxWidth, var4);
            }
         }

         super.onMeasure(MeasureSpec.makeMeasureSpec(var4, 1073741824), var2);
      }
   }

   void onQueryRefine(CharSequence var1) {
      this.setQuery(var1);
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      SearchView.SavedState var2 = (SearchView.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      this.updateViewsVisibility(var2.isIconified);
      this.requestLayout();
   }

   protected Parcelable onSaveInstanceState() {
      SearchView.SavedState var1 = new SearchView.SavedState(super.onSaveInstanceState());
      var1.isIconified = this.isIconified();
      return var1;
   }

   void onTextFocusChanged() {
      this.updateViewsVisibility(this.isIconified());
      this.postUpdateFocusedState();
      if(this.mSearchSrcTextView.hasFocus()) {
         this.forceSuggestionQuery();
      }

   }

   public void onWindowFocusChanged(boolean var1) {
      super.onWindowFocusChanged(var1);
      this.postUpdateFocusedState();
   }

   public boolean requestFocus(int var1, Rect var2) {
      boolean var3;
      if(this.mClearingFocus) {
         var3 = false;
      } else {
         if(!this.isFocusable()) {
            return false;
         }

         if(this.isIconified()) {
            return super.requestFocus(var1, var2);
         }

         var3 = this.mSearchSrcTextView.requestFocus(var1, var2);
         if(var3) {
            this.updateViewsVisibility(false);
            return var3;
         }
      }

      return var3;
   }

   public void setAppSearchData(Bundle var1) {
      this.mAppSearchData = var1;
   }

   public void setIconified(boolean var1) {
      if(var1) {
         this.onCloseClicked();
      } else {
         this.onSearchClicked();
      }
   }

   public void setIconifiedByDefault(boolean var1) {
      if(this.mIconifiedByDefault != var1) {
         this.mIconifiedByDefault = var1;
         this.updateViewsVisibility(var1);
         this.updateQueryHint();
      }
   }

   public void setImeOptions(int var1) {
      this.mSearchSrcTextView.setImeOptions(var1);
   }

   public void setInputType(int var1) {
      this.mSearchSrcTextView.setInputType(var1);
   }

   public void setMaxWidth(int var1) {
      this.mMaxWidth = var1;
      this.requestLayout();
   }

   public void setOnCloseListener(SearchView.OnCloseListener var1) {
      this.mOnCloseListener = var1;
   }

   public void setOnQueryTextFocusChangeListener(OnFocusChangeListener var1) {
      this.mOnQueryTextFocusChangeListener = var1;
   }

   public void setOnQueryTextListener(SearchView.OnQueryTextListener var1) {
      this.mOnQueryChangeListener = var1;
   }

   public void setOnSearchClickListener(OnClickListener var1) {
      this.mOnSearchClickListener = var1;
   }

   public void setOnSuggestionListener(SearchView.OnSuggestionListener var1) {
      this.mOnSuggestionListener = var1;
   }

   public void setQuery(CharSequence var1, boolean var2) {
      this.mSearchSrcTextView.setText(var1);
      if(var1 != null) {
         this.mSearchSrcTextView.setSelection(this.mSearchSrcTextView.length());
         this.mUserQuery = var1;
      }

      if(var2 && !TextUtils.isEmpty(var1)) {
         this.onSubmitQuery();
      }

   }

   public void setQueryHint(CharSequence var1) {
      this.mQueryHint = var1;
      this.updateQueryHint();
   }

   public void setQueryRefinementEnabled(boolean var1) {
      this.mQueryRefinement = var1;
      if(this.mSuggestionsAdapter instanceof SuggestionsAdapter) {
         SuggestionsAdapter var2 = (SuggestionsAdapter)this.mSuggestionsAdapter;
         byte var3;
         if(var1) {
            var3 = 2;
         } else {
            var3 = 1;
         }

         var2.setQueryRefinement(var3);
      }

   }

   public void setSearchableInfo(SearchableInfo var1) {
      this.mSearchable = var1;
      if(this.mSearchable != null) {
         if(IS_AT_LEAST_FROYO) {
            this.updateSearchAutoComplete();
         }

         this.updateQueryHint();
      }

      boolean var2;
      if(IS_AT_LEAST_FROYO && this.hasVoiceSearch()) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mVoiceButtonEnabled = var2;
      if(this.mVoiceButtonEnabled) {
         this.mSearchSrcTextView.setPrivateImeOptions("nm");
      }

      this.updateViewsVisibility(this.isIconified());
   }

   public void setSubmitButtonEnabled(boolean var1) {
      this.mSubmitButtonEnabled = var1;
      this.updateViewsVisibility(this.isIconified());
   }

   public void setSuggestionsAdapter(CursorAdapter var1) {
      this.mSuggestionsAdapter = var1;
      this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
   }

   private static class AutoCompleteTextViewReflector {
      private Method doAfterTextChanged;
      private Method doBeforeTextChanged;
      private Method ensureImeVisible;
      private Method showSoftInputUnchecked;

      AutoCompleteTextViewReflector() {
         try {
            this.doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.doBeforeTextChanged.setAccessible(true);
         } catch (NoSuchMethodException var10) {
            ;
         }

         try {
            this.doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.doAfterTextChanged.setAccessible(true);
         } catch (NoSuchMethodException var9) {
            ;
         }

         try {
            Class[] var6 = new Class[]{Boolean.TYPE};
            this.ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", var6);
            this.ensureImeVisible.setAccessible(true);
         } catch (NoSuchMethodException var8) {
            ;
         }

         try {
            Class[] var5 = new Class[]{Integer.TYPE, ResultReceiver.class};
            this.showSoftInputUnchecked = InputMethodManager.class.getMethod("showSoftInputUnchecked", var5);
            this.showSoftInputUnchecked.setAccessible(true);
         } catch (NoSuchMethodException var7) {
            ;
         }
      }

      void doAfterTextChanged(AutoCompleteTextView var1) {
         if(this.doAfterTextChanged != null) {
            try {
               this.doAfterTextChanged.invoke(var1, new Object[0]);
            } catch (Exception var3) {
               return;
            }
         }

      }

      void doBeforeTextChanged(AutoCompleteTextView var1) {
         if(this.doBeforeTextChanged != null) {
            try {
               this.doBeforeTextChanged.invoke(var1, new Object[0]);
            } catch (Exception var3) {
               return;
            }
         }

      }

      void ensureImeVisible(AutoCompleteTextView var1, boolean var2) {
         if(this.ensureImeVisible != null) {
            try {
               Method var4 = this.ensureImeVisible;
               Object[] var5 = new Object[]{Boolean.valueOf(var2)};
               var4.invoke(var1, var5);
            } catch (Exception var6) {
               return;
            }
         }

      }

      void showSoftInputUnchecked(InputMethodManager var1, View var2, int var3) {
         if(this.showSoftInputUnchecked != null) {
            try {
               Method var6 = this.showSoftInputUnchecked;
               Object[] var7 = new Object[]{Integer.valueOf(var3), null};
               var6.invoke(var1, var7);
               return;
            } catch (Exception var8) {
               ;
            }
         }

         var1.showSoftInput(var2, var3);
      }
   }

   public interface OnCloseListener {
      boolean onClose();
   }

   public interface OnQueryTextListener {
      boolean onQueryTextChange(String var1);

      boolean onQueryTextSubmit(String var1);
   }

   public interface OnSuggestionListener {
      boolean onSuggestionClick(int var1);

      boolean onSuggestionSelect(int var1);
   }

   static class SavedState extends BaseSavedState {
      boolean isIconified;

      public SavedState(Parcel var1) {
         super(var1);
         this.isIconified = ((Boolean)var1.readValue((ClassLoader)null)).booleanValue();
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public String toString() {
         return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeValue(Boolean.valueOf(this.isIconified));
      }
   }

   public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
      private SearchView mSearchView;
      private int mThreshold;

      public SearchAutoComplete(Context var1) {
         this(var1, (AttributeSet)null);
      }

      public SearchAutoComplete(Context var1, AttributeSet var2) {
         this(var1, var2, class_22.attr.autoCompleteTextViewStyle);
      }

      public SearchAutoComplete(Context var1, AttributeSet var2, int var3) {
         super(var1, var2, var3);
         this.mThreshold = this.getThreshold();
      }

      private boolean isEmpty() {
         return TextUtils.getTrimmedLength(this.getText()) == 0;
      }

      public boolean enoughToFilter() {
         return this.mThreshold <= 0 || super.enoughToFilter();
      }

      protected void onFocusChanged(boolean var1, int var2, Rect var3) {
         super.onFocusChanged(var1, var2, var3);
         this.mSearchView.onTextFocusChanged();
      }

      public boolean onKeyPreIme(int var1, KeyEvent var2) {
         if(var1 == 4) {
            if(var2.getAction() == 0 && var2.getRepeatCount() == 0) {
               DispatcherState var4 = this.getKeyDispatcherState();
               if(var4 != null) {
                  var4.startTracking(var2, this);
               }

               return true;
            }

            if(var2.getAction() == 1) {
               DispatcherState var3 = this.getKeyDispatcherState();
               if(var3 != null) {
                  var3.handleUpEvent(var2);
               }

               if(var2.isTracking() && !var2.isCanceled()) {
                  this.mSearchView.clearFocus();
                  this.mSearchView.setImeVisibility(false);
                  return true;
               }
            }
         }

         return super.onKeyPreIme(var1, var2);
      }

      public void onWindowFocusChanged(boolean var1) {
         super.onWindowFocusChanged(var1);
         if(var1 && this.mSearchView.hasFocus() && this.getVisibility() == 0) {
            ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput(this, 0);
            if(SearchView.isLandscapeMode(this.getContext())) {
               SearchView.HIDDEN_METHOD_INVOKER.ensureImeVisible(this, true);
            }
         }

      }

      public void performCompletion() {
      }

      protected void replaceText(CharSequence var1) {
      }

      void setSearchView(SearchView var1) {
         this.mSearchView = var1;
      }

      public void setThreshold(int var1) {
         super.setThreshold(var1);
         this.mThreshold = var1;
      }
   }
}
