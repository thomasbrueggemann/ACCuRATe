package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplBase;
import android.support.v7.app.AppCompatViewInflater;
import android.support.v7.app.ToolbarActionBar;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.LayoutInflater.Factory;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class AppCompatDelegateImplV7 extends AppCompatDelegateImplBase implements LayoutInflaterFactory, MenuBuilder.Callback {
   private AppCompatDelegateImplV7.ActionMenuPresenterCallback mActionMenuPresenterCallback;
   ActionMode mActionMode;
   PopupWindow mActionModePopup;
   ActionBarContextView mActionModeView;
   private AppCompatViewInflater mAppCompatViewInflater;
   private boolean mClosingActionMenu;
   private DecorContentParent mDecorContentParent;
   private boolean mEnableDefaultActionBarUp;
   ViewPropertyAnimatorCompat mFadeAnim = null;
   private boolean mFeatureIndeterminateProgress;
   private boolean mFeatureProgress;
   private int mInvalidatePanelMenuFeatures;
   private boolean mInvalidatePanelMenuPosted;
   private final Runnable mInvalidatePanelMenuRunnable = new Runnable() {
      public void run() {
         if((1 & AppCompatDelegateImplV7.this.mInvalidatePanelMenuFeatures) != 0) {
            AppCompatDelegateImplV7.this.doInvalidatePanelMenu(0);
         }

         if((4096 & AppCompatDelegateImplV7.this.mInvalidatePanelMenuFeatures) != 0) {
            AppCompatDelegateImplV7.this.doInvalidatePanelMenu(108);
         }

         AppCompatDelegateImplV7.this.mInvalidatePanelMenuPosted = false;
         AppCompatDelegateImplV7.this.mInvalidatePanelMenuFeatures = 0;
      }
   };
   private boolean mLongPressBackDown;
   private AppCompatDelegateImplV7.PanelMenuPresenterCallback mPanelMenuPresenterCallback;
   private AppCompatDelegateImplV7.PanelFeatureState[] mPanels;
   private AppCompatDelegateImplV7.PanelFeatureState mPreparedPanel;
   Runnable mShowActionModePopup;
   private View mStatusGuard;
   private ViewGroup mSubDecor;
   private boolean mSubDecorInstalled;
   private Rect mTempRect1;
   private Rect mTempRect2;
   private TextView mTitleView;

   AppCompatDelegateImplV7(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   private void applyFixedSizeWindow() {
      ContentFrameLayout var1 = (ContentFrameLayout)this.mSubDecor.findViewById(16908290);
      View var2 = this.mWindow.getDecorView();
      var1.setDecorPadding(var2.getPaddingLeft(), var2.getPaddingTop(), var2.getPaddingRight(), var2.getPaddingBottom());
      TypedArray var3 = this.mContext.obtainStyledAttributes(class_22.styleable.AppCompatTheme);
      var3.getValue(class_22.styleable.AppCompatTheme_windowMinWidthMajor, var1.getMinWidthMajor());
      var3.getValue(class_22.styleable.AppCompatTheme_windowMinWidthMinor, var1.getMinWidthMinor());
      if(var3.hasValue(class_22.styleable.AppCompatTheme_windowFixedWidthMajor)) {
         var3.getValue(class_22.styleable.AppCompatTheme_windowFixedWidthMajor, var1.getFixedWidthMajor());
      }

      if(var3.hasValue(class_22.styleable.AppCompatTheme_windowFixedWidthMinor)) {
         var3.getValue(class_22.styleable.AppCompatTheme_windowFixedWidthMinor, var1.getFixedWidthMinor());
      }

      if(var3.hasValue(class_22.styleable.AppCompatTheme_windowFixedHeightMajor)) {
         var3.getValue(class_22.styleable.AppCompatTheme_windowFixedHeightMajor, var1.getFixedHeightMajor());
      }

      if(var3.hasValue(class_22.styleable.AppCompatTheme_windowFixedHeightMinor)) {
         var3.getValue(class_22.styleable.AppCompatTheme_windowFixedHeightMinor, var1.getFixedHeightMinor());
      }

      var3.recycle();
      var1.requestLayout();
   }

   private void callOnPanelClosed(int var1, AppCompatDelegateImplV7.PanelFeatureState var2, Menu var3) {
      if(var3 == null) {
         if(var2 == null && var1 >= 0 && var1 < this.mPanels.length) {
            var2 = this.mPanels[var1];
         }

         if(var2 != null) {
            var3 = var2.menu;
         }
      }

      if((var2 == null || var2.isOpen) && !this.isDestroyed()) {
         this.mOriginalWindowCallback.onPanelClosed(var1, (Menu)var3);
      }
   }

   private void checkCloseActionMenu(MenuBuilder var1) {
      if(!this.mClosingActionMenu) {
         this.mClosingActionMenu = true;
         this.mDecorContentParent.dismissPopups();
         Callback var2 = this.getWindowCallback();
         if(var2 != null && !this.isDestroyed()) {
            var2.onPanelClosed(108, var1);
         }

         this.mClosingActionMenu = false;
      }
   }

   private void closePanel(int var1) {
      this.closePanel(this.getPanelState(var1, true), true);
   }

   private void closePanel(AppCompatDelegateImplV7.PanelFeatureState var1, boolean var2) {
      if(var2 && var1.featureId == 0 && this.mDecorContentParent != null && this.mDecorContentParent.isOverflowMenuShowing()) {
         this.checkCloseActionMenu(var1.menu);
      } else {
         WindowManager var3 = (WindowManager)this.mContext.getSystemService("window");
         if(var3 != null && var1.isOpen && var1.decorView != null) {
            var3.removeView(var1.decorView);
            if(var2) {
               this.callOnPanelClosed(var1.featureId, var1, (Menu)null);
            }
         }

         var1.isPrepared = false;
         var1.isHandled = false;
         var1.isOpen = false;
         var1.shownPanelView = null;
         var1.refreshDecorView = true;
         if(this.mPreparedPanel == var1) {
            this.mPreparedPanel = null;
            return;
         }
      }

   }

   private ViewGroup createSubDecor() {
      TypedArray var1 = this.mContext.obtainStyledAttributes(class_22.styleable.AppCompatTheme);
      if(!var1.hasValue(class_22.styleable.AppCompatTheme_windowActionBar)) {
         var1.recycle();
         throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      } else {
         if(var1.getBoolean(class_22.styleable.AppCompatTheme_windowNoTitle, false)) {
            this.requestWindowFeature(1);
         } else if(var1.getBoolean(class_22.styleable.AppCompatTheme_windowActionBar, false)) {
            this.requestWindowFeature(108);
         }

         if(var1.getBoolean(class_22.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            this.requestWindowFeature(109);
         }

         if(var1.getBoolean(class_22.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            this.requestWindowFeature(10);
         }

         this.mIsFloating = var1.getBoolean(class_22.styleable.AppCompatTheme_android_windowIsFloating, false);
         var1.recycle();
         LayoutInflater var3 = LayoutInflater.from(this.mContext);
         ViewGroup var4;
         if(!this.mWindowNoTitle) {
            if(this.mIsFloating) {
               var4 = (ViewGroup)var3.inflate(class_22.layout.abc_dialog_title_material, (ViewGroup)null);
               this.mOverlayActionBar = false;
               this.mHasActionBar = false;
            } else {
               boolean var8 = this.mHasActionBar;
               var4 = null;
               if(var8) {
                  TypedValue var9 = new TypedValue();
                  this.mContext.getTheme().resolveAttribute(class_22.attr.actionBarTheme, var9, true);
                  Object var11;
                  if(var9.resourceId != 0) {
                     var11 = new ContextThemeWrapper(this.mContext, var9.resourceId);
                  } else {
                     var11 = this.mContext;
                  }

                  var4 = (ViewGroup)LayoutInflater.from((Context)var11).inflate(class_22.layout.abc_screen_toolbar, (ViewGroup)null);
                  this.mDecorContentParent = (DecorContentParent)var4.findViewById(class_22.class_93.decor_content_parent);
                  this.mDecorContentParent.setWindowCallback(this.getWindowCallback());
                  if(this.mOverlayActionBar) {
                     this.mDecorContentParent.initFeature(109);
                  }

                  if(this.mFeatureProgress) {
                     this.mDecorContentParent.initFeature(2);
                  }

                  if(this.mFeatureIndeterminateProgress) {
                     this.mDecorContentParent.initFeature(5);
                  }
               }
            }
         } else {
            if(this.mOverlayActionMode) {
               var4 = (ViewGroup)var3.inflate(class_22.layout.abc_screen_simple_overlay_action_mode, (ViewGroup)null);
            } else {
               var4 = (ViewGroup)var3.inflate(class_22.layout.abc_screen_simple, (ViewGroup)null);
            }

            if(VERSION.SDK_INT >= 21) {
               ViewCompat.setOnApplyWindowInsetsListener(var4, new OnApplyWindowInsetsListener() {
                  public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
                     int var3 = var2.getSystemWindowInsetTop();
                     int var4 = AppCompatDelegateImplV7.this.updateStatusGuard(var3);
                     if(var3 != var4) {
                        var2 = var2.replaceSystemWindowInsets(var2.getSystemWindowInsetLeft(), var4, var2.getSystemWindowInsetRight(), var2.getSystemWindowInsetBottom());
                     }

                     return ViewCompat.onApplyWindowInsets(var1, var2);
                  }
               });
            } else {
               ((FitWindowsViewGroup)var4).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() {
                  public void onFitSystemWindows(Rect var1) {
                     var1.top = AppCompatDelegateImplV7.this.updateStatusGuard(var1.top);
                  }
               });
            }
         }

         if(var4 == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
         } else {
            if(this.mDecorContentParent == null) {
               this.mTitleView = (TextView)var4.findViewById(class_22.class_93.title);
            }

            ViewUtils.makeOptionalFitsSystemWindows(var4);
            ViewGroup var5 = (ViewGroup)this.mWindow.findViewById(16908290);
            ContentFrameLayout var6 = (ContentFrameLayout)var4.findViewById(class_22.class_93.action_bar_activity_content);

            while(var5.getChildCount() > 0) {
               View var7 = var5.getChildAt(0);
               var5.removeViewAt(0);
               var6.addView(var7);
            }

            this.mWindow.setContentView(var4);
            var5.setId(-1);
            var6.setId(16908290);
            if(var5 instanceof FrameLayout) {
               ((FrameLayout)var5).setForeground((Drawable)null);
            }

            var6.setAttachListener(new ContentFrameLayout.OnAttachListener() {
               public void onAttachedFromWindow() {
               }

               public void onDetachedFromWindow() {
                  AppCompatDelegateImplV7.this.dismissPopups();
               }
            });
            return var4;
         }
      }
   }

   private void dismissPopups() {
      if(this.mDecorContentParent != null) {
         this.mDecorContentParent.dismissPopups();
      }

      if(this.mActionModePopup != null) {
         this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
         if(this.mActionModePopup.isShowing()) {
            try {
               this.mActionModePopup.dismiss();
            } catch (IllegalArgumentException var4) {
               ;
            }
         }

         this.mActionModePopup = null;
      }

      this.endOnGoingFadeAnimation();
      AppCompatDelegateImplV7.PanelFeatureState var1 = this.getPanelState(0, false);
      if(var1 != null && var1.menu != null) {
         var1.menu.close();
      }

   }

   private void doInvalidatePanelMenu(int var1) {
      AppCompatDelegateImplV7.PanelFeatureState var2 = this.getPanelState(var1, true);
      if(var2.menu != null) {
         Bundle var3 = new Bundle();
         var2.menu.saveActionViewStates(var3);
         if(var3.size() > 0) {
            var2.frozenActionViewState = var3;
         }

         var2.menu.stopDispatchingItemsChanged();
         var2.menu.clear();
      }

      var2.refreshMenuContent = true;
      var2.refreshDecorView = true;
      if((var1 == 108 || var1 == 0) && this.mDecorContentParent != null) {
         AppCompatDelegateImplV7.PanelFeatureState var4 = this.getPanelState(0, false);
         if(var4 != null) {
            var4.isPrepared = false;
            this.preparePanel(var4, (KeyEvent)null);
         }
      }

   }

   private void endOnGoingFadeAnimation() {
      if(this.mFadeAnim != null) {
         this.mFadeAnim.cancel();
      }

   }

   private void ensureSubDecor() {
      if(!this.mSubDecorInstalled) {
         this.mSubDecor = this.createSubDecor();
         CharSequence var1 = this.getTitle();
         if(!TextUtils.isEmpty(var1)) {
            this.onTitleChanged(var1);
         }

         this.applyFixedSizeWindow();
         this.onSubDecorInstalled(this.mSubDecor);
         this.mSubDecorInstalled = true;
         AppCompatDelegateImplV7.PanelFeatureState var2 = this.getPanelState(0, false);
         if(!this.isDestroyed() && (var2 == null || var2.menu == null)) {
            this.invalidatePanelMenu(108);
         }
      }

   }

   private AppCompatDelegateImplV7.PanelFeatureState findMenuPanel(Menu var1) {
      AppCompatDelegateImplV7.PanelFeatureState[] var2 = this.mPanels;
      int var3;
      if(var2 != null) {
         var3 = var2.length;
      } else {
         var3 = 0;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         AppCompatDelegateImplV7.PanelFeatureState var5 = var2[var4];
         if(var5 != null && var5.menu == var1) {
            return var5;
         }
      }

      return null;
   }

   private AppCompatDelegateImplV7.PanelFeatureState getPanelState(int var1, boolean var2) {
      AppCompatDelegateImplV7.PanelFeatureState[] var3 = this.mPanels;
      if(var3 == null || var3.length <= var1) {
         AppCompatDelegateImplV7.PanelFeatureState[] var4 = new AppCompatDelegateImplV7.PanelFeatureState[var1 + 1];
         if(var3 != null) {
            System.arraycopy(var3, 0, var4, 0, var3.length);
         }

         var3 = var4;
         this.mPanels = var4;
      }

      AppCompatDelegateImplV7.PanelFeatureState var5 = var3[var1];
      if(var5 == null) {
         var5 = new AppCompatDelegateImplV7.PanelFeatureState(var1);
         var3[var1] = var5;
      }

      return var5;
   }

   private boolean initializePanelContent(AppCompatDelegateImplV7.PanelFeatureState var1) {
      if(var1.createdPanelView != null) {
         var1.shownPanelView = var1.createdPanelView;
      } else {
         if(var1.menu == null) {
            return false;
         }

         if(this.mPanelMenuPresenterCallback == null) {
            this.mPanelMenuPresenterCallback = new AppCompatDelegateImplV7.PanelMenuPresenterCallback(null);
         }

         var1.shownPanelView = (View)var1.getListMenuView(this.mPanelMenuPresenterCallback);
         if(var1.shownPanelView == null) {
            return false;
         }
      }

      return true;
   }

   private boolean initializePanelDecor(AppCompatDelegateImplV7.PanelFeatureState var1) {
      var1.setStyle(this.getActionBarThemedContext());
      var1.decorView = new AppCompatDelegateImplV7.ListMenuDecorView(var1.listPresenterContext);
      var1.gravity = 81;
      return true;
   }

   private boolean initializePanelMenu(AppCompatDelegateImplV7.PanelFeatureState var1) {
      Object var2 = this.mContext;
      if((var1.featureId == 0 || var1.featureId == 108) && this.mDecorContentParent != null) {
         TypedValue var3 = new TypedValue();
         Theme var4 = ((Context)var2).getTheme();
         var4.resolveAttribute(class_22.attr.actionBarTheme, var3, true);
         Theme var7;
         if(var3.resourceId != 0) {
            var7 = ((Context)var2).getResources().newTheme();
            var7.setTo(var4);
            var7.applyStyle(var3.resourceId, true);
            var7.resolveAttribute(class_22.attr.actionBarWidgetTheme, var3, true);
         } else {
            var4.resolveAttribute(class_22.attr.actionBarWidgetTheme, var3, true);
            var7 = null;
         }

         if(var3.resourceId != 0) {
            if(var7 == null) {
               var7 = ((Context)var2).getResources().newTheme();
               var7.setTo(var4);
            }

            var7.applyStyle(var3.resourceId, true);
         }

         if(var7 != null) {
            ContextThemeWrapper var8 = new ContextThemeWrapper((Context)var2, 0);
            var8.getTheme().setTo(var7);
            var2 = var8;
         }
      }

      MenuBuilder var9 = new MenuBuilder((Context)var2);
      var9.setCallback(this);
      var1.setMenu(var9);
      return true;
   }

   private void invalidatePanelMenu(int var1) {
      this.mInvalidatePanelMenuFeatures |= 1 << var1;
      if(!this.mInvalidatePanelMenuPosted) {
         ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
         this.mInvalidatePanelMenuPosted = true;
      }

   }

   private boolean onKeyDownPanel(int var1, KeyEvent var2) {
      if(var2.getRepeatCount() == 0) {
         AppCompatDelegateImplV7.PanelFeatureState var3 = this.getPanelState(var1, true);
         if(!var3.isOpen) {
            return this.preparePanel(var3, var2);
         }
      }

      return false;
   }

   private boolean onKeyUpPanel(int var1, KeyEvent var2) {
      boolean var4;
      if(this.mActionMode != null) {
         var4 = false;
      } else {
         AppCompatDelegateImplV7.PanelFeatureState var3 = this.getPanelState(var1, true);
         if(var1 == 0 && this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
            if(!this.mDecorContentParent.isOverflowMenuShowing()) {
               boolean var9 = this.isDestroyed();
               var4 = false;
               if(!var9) {
                  boolean var10 = this.preparePanel(var3, var2);
                  var4 = false;
                  if(var10) {
                     var4 = this.mDecorContentParent.showOverflowMenu();
                  }
               }
            } else {
               var4 = this.mDecorContentParent.hideOverflowMenu();
            }
         } else if(!var3.isOpen && !var3.isHandled) {
            boolean var7 = var3.isPrepared;
            var4 = false;
            if(var7) {
               boolean var8 = true;
               if(var3.refreshMenuContent) {
                  var3.isPrepared = false;
                  var8 = this.preparePanel(var3, var2);
               }

               var4 = false;
               if(var8) {
                  this.openPanel(var3, var2);
                  var4 = true;
               }
            }
         } else {
            var4 = var3.isOpen;
            this.closePanel(var3, true);
         }

         if(var4) {
            AudioManager var5 = (AudioManager)this.mContext.getSystemService("audio");
            if(var5 != null) {
               var5.playSoundEffect(0);
               return var4;
            }

            Log.w("AppCompatDelegate", "Couldn\'t get audio manager");
            return var4;
         }
      }

      return var4;
   }

   private void openPanel(AppCompatDelegateImplV7.PanelFeatureState var1, KeyEvent var2) {
      WindowManager var4;
      byte var5;
      label82: {
         if(!var1.isOpen && !this.isDestroyed()) {
            if(var1.featureId == 0) {
               Context var12 = this.mContext;
               boolean var13;
               if((15 & var12.getResources().getConfiguration().screenLayout) == 4) {
                  var13 = true;
               } else {
                  var13 = false;
               }

               boolean var14;
               if(var12.getApplicationInfo().targetSdkVersion >= 11) {
                  var14 = true;
               } else {
                  var14 = false;
               }

               if(var13 && var14) {
                  return;
               }
            }

            Callback var3 = this.getWindowCallback();
            if(var3 != null && !var3.onMenuOpened(var1.featureId, var1.menu)) {
               this.closePanel(var1, true);
               return;
            }

            var4 = (WindowManager)this.mContext.getSystemService("window");
            if(var4 != null && this.preparePanel(var1, var2)) {
               var5 = -2;
               if(var1.decorView != null && !var1.refreshDecorView) {
                  if(var1.createdPanelView != null) {
                     LayoutParams var11 = var1.createdPanelView.getLayoutParams();
                     if(var11 != null && var11.width == -1) {
                        var5 = -1;
                     }
                  }
                  break label82;
               }

               if(var1.decorView == null) {
                  if(!this.initializePanelDecor(var1) || var1.decorView == null) {
                     return;
                  }
               } else if(var1.refreshDecorView && var1.decorView.getChildCount() > 0) {
                  var1.decorView.removeAllViews();
               }

               if(this.initializePanelContent(var1) && var1.hasPanelItems()) {
                  LayoutParams var6 = var1.shownPanelView.getLayoutParams();
                  if(var6 == null) {
                     var6 = new LayoutParams(-2, -2);
                  }

                  int var7 = var1.background;
                  var1.decorView.setBackgroundResource(var7);
                  ViewParent var8 = var1.shownPanelView.getParent();
                  if(var8 != null && var8 instanceof ViewGroup) {
                     ((ViewGroup)var8).removeView(var1.shownPanelView);
                  }

                  var1.decorView.addView(var1.shownPanelView, var6);
                  if(!var1.shownPanelView.hasFocus()) {
                     var1.shownPanelView.requestFocus();
                  }
                  break label82;
               }
            }
         }

         return;
      }

      var1.isHandled = false;
      android.view.WindowManager.LayoutParams var9 = new android.view.WindowManager.LayoutParams(var5, -2, var1.field_142, var1.field_143, 1002, 8519680, -3);
      var9.gravity = var1.gravity;
      var9.windowAnimations = var1.windowAnimations;
      var4.addView(var1.decorView, var9);
      var1.isOpen = true;
   }

   private boolean performPanelShortcut(AppCompatDelegateImplV7.PanelFeatureState var1, int var2, KeyEvent var3, int var4) {
      boolean var6;
      if(var3.isSystem()) {
         var6 = false;
      } else {
         label22: {
            if(!var1.isPrepared) {
               boolean var7 = this.preparePanel(var1, var3);
               var6 = false;
               if(!var7) {
                  break label22;
               }
            }

            MenuBuilder var5 = var1.menu;
            var6 = false;
            if(var5 != null) {
               var6 = var1.menu.performShortcut(var2, var3, var4);
            }
         }

         if(var6 && (var4 & 1) == 0 && this.mDecorContentParent == null) {
            this.closePanel(var1, true);
            return var6;
         }
      }

      return var6;
   }

   private boolean preparePanel(AppCompatDelegateImplV7.PanelFeatureState var1, KeyEvent var2) {
      if(!this.isDestroyed()) {
         if(var1.isPrepared) {
            return true;
         } else {
            if(this.mPreparedPanel != null && this.mPreparedPanel != var1) {
               this.closePanel(this.mPreparedPanel, false);
            }

            Callback var3 = this.getWindowCallback();
            if(var3 != null) {
               var1.createdPanelView = var3.onCreatePanelView(var1.featureId);
            }

            boolean var4;
            if(var1.featureId != 0 && var1.featureId != 108) {
               var4 = false;
            } else {
               var4 = true;
            }

            if(var4 && this.mDecorContentParent != null) {
               this.mDecorContentParent.setMenuPrepared();
            }

            if(var1.createdPanelView == null && (!var4 || !(this.peekSupportActionBar() instanceof ToolbarActionBar))) {
               if(var1.menu == null || var1.refreshMenuContent) {
                  if(var1.menu == null && (!this.initializePanelMenu(var1) || var1.menu == null)) {
                     return false;
                  }

                  if(var4 && this.mDecorContentParent != null) {
                     if(this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new AppCompatDelegateImplV7.ActionMenuPresenterCallback(null);
                     }

                     this.mDecorContentParent.setMenu(var1.menu, this.mActionMenuPresenterCallback);
                  }

                  var1.menu.stopDispatchingItemsChanged();
                  if(!var3.onCreatePanelMenu(var1.featureId, var1.menu)) {
                     var1.setMenu((MenuBuilder)null);
                     if(var4 && this.mDecorContentParent != null) {
                        this.mDecorContentParent.setMenu((Menu)null, this.mActionMenuPresenterCallback);
                        return false;
                     }

                     return false;
                  }

                  var1.refreshMenuContent = false;
               }

               var1.menu.stopDispatchingItemsChanged();
               if(var1.frozenActionViewState != null) {
                  var1.menu.restoreActionViewStates(var1.frozenActionViewState);
                  var1.frozenActionViewState = null;
               }

               if(!var3.onPreparePanel(0, var1.createdPanelView, var1.menu)) {
                  if(var4 && this.mDecorContentParent != null) {
                     this.mDecorContentParent.setMenu((Menu)null, this.mActionMenuPresenterCallback);
                  }

                  var1.menu.startDispatchingItemsChanged();
                  return false;
               }

               int var5;
               if(var2 != null) {
                  var5 = var2.getDeviceId();
               } else {
                  var5 = -1;
               }

               boolean var6;
               if(KeyCharacterMap.load(var5).getKeyboardType() != 1) {
                  var6 = true;
               } else {
                  var6 = false;
               }

               var1.qwertyMode = var6;
               var1.menu.setQwertyMode(var1.qwertyMode);
               var1.menu.startDispatchingItemsChanged();
            }

            var1.isPrepared = true;
            var1.isHandled = false;
            this.mPreparedPanel = var1;
            return true;
         }
      } else {
         return false;
      }
   }

   private void reopenMenu(MenuBuilder var1, boolean var2) {
      if(this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) || this.mDecorContentParent.isOverflowMenuShowPending())) {
         Callback var4 = this.getWindowCallback();
         if(this.mDecorContentParent.isOverflowMenuShowing() && var2) {
            this.mDecorContentParent.hideOverflowMenu();
            if(!this.isDestroyed()) {
               var4.onPanelClosed(108, this.getPanelState(0, true).menu);
               return;
            }
         } else if(var4 != null && !this.isDestroyed()) {
            if(this.mInvalidatePanelMenuPosted && (1 & this.mInvalidatePanelMenuFeatures) != 0) {
               this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
               this.mInvalidatePanelMenuRunnable.run();
            }

            AppCompatDelegateImplV7.PanelFeatureState var5 = this.getPanelState(0, true);
            if(var5.menu != null && !var5.refreshMenuContent && var4.onPreparePanel(0, var5.createdPanelView, var5.menu)) {
               var4.onMenuOpened(108, var5.menu);
               this.mDecorContentParent.showOverflowMenu();
            }
         }

      } else {
         AppCompatDelegateImplV7.PanelFeatureState var3 = this.getPanelState(0, true);
         var3.refreshDecorView = true;
         this.closePanel(var3, false);
         this.openPanel(var3, (KeyEvent)null);
      }
   }

   private int sanitizeWindowFeatureId(int var1) {
      if(var1 == 8) {
         Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
         var1 = 108;
      } else if(var1 == 9) {
         Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
         return 109;
      }

      return var1;
   }

   private boolean shouldInheritContext(ViewParent var1) {
      if(var1 == null) {
         return false;
      } else {
         for(View var2 = this.mWindow.getDecorView(); var1 != null; var1 = var1.getParent()) {
            if(var1 == var2 || !(var1 instanceof View) || ViewCompat.isAttachedToWindow((View)var1)) {
               return false;
            }
         }

         return true;
      }
   }

   private void throwFeatureRequestIfSubDecorInstalled() {
      if(this.mSubDecorInstalled) {
         throw new AndroidRuntimeException("Window feature must be requested before adding content");
      }
   }

   private int updateStatusGuard(int var1) {
      ActionBarContextView var2 = this.mActionModeView;
      boolean var3 = false;
      if(var2 != null) {
         boolean var6 = this.mActionModeView.getLayoutParams() instanceof MarginLayoutParams;
         var3 = false;
         if(var6) {
            MarginLayoutParams var7 = (MarginLayoutParams)this.mActionModeView.getLayoutParams();
            boolean var9;
            if(this.mActionModeView.isShown()) {
               if(this.mTempRect1 == null) {
                  this.mTempRect1 = new Rect();
                  this.mTempRect2 = new Rect();
               }

               Rect var10 = this.mTempRect1;
               Rect var11 = this.mTempRect2;
               var10.set(0, var1, 0, 0);
               ViewUtils.computeFitSystemWindows(this.mSubDecor, var10, var11);
               int var12;
               if(var11.top == 0) {
                  var12 = var1;
               } else {
                  var12 = 0;
               }

               int var13 = var7.topMargin;
               var9 = false;
               if(var13 != var12) {
                  var9 = true;
                  var7.topMargin = var1;
                  if(this.mStatusGuard == null) {
                     this.mStatusGuard = new View(this.mContext);
                     this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(class_22.color.abc_input_method_navigation_guard));
                     this.mSubDecor.addView(this.mStatusGuard, -1, new LayoutParams(-1, var1));
                  } else {
                     LayoutParams var14 = this.mStatusGuard.getLayoutParams();
                     if(var14.height != var1) {
                        var14.height = var1;
                        this.mStatusGuard.setLayoutParams(var14);
                     }
                  }
               }

               if(this.mStatusGuard != null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               if(!this.mOverlayActionMode && var3) {
                  var1 = 0;
               }
            } else {
               int var8 = var7.topMargin;
               var9 = false;
               var3 = false;
               if(var8 != 0) {
                  var9 = true;
                  var7.topMargin = 0;
                  var3 = false;
               }
            }

            if(var9) {
               this.mActionModeView.setLayoutParams(var7);
            }
         }
      }

      if(this.mStatusGuard != null) {
         View var4 = this.mStatusGuard;
         byte var5 = 0;
         if(!var3) {
            var5 = 8;
         }

         var4.setVisibility(var5);
      }

      return var1;
   }

   public void addContentView(View var1, LayoutParams var2) {
      this.ensureSubDecor();
      ((ViewGroup)this.mSubDecor.findViewById(16908290)).addView(var1, var2);
      this.mOriginalWindowCallback.onContentChanged();
   }

   View callActivityOnCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      if(this.mOriginalWindowCallback instanceof Factory) {
         View var5 = ((Factory)this.mOriginalWindowCallback).onCreateView(var2, var3, var4);
         if(var5 != null) {
            return var5;
         }
      }

      return null;
   }

   public View createView(View var1, String var2, @NonNull Context var3, @NonNull AttributeSet var4) {
      boolean var5;
      if(VERSION.SDK_INT < 21) {
         var5 = true;
      } else {
         var5 = false;
      }

      if(this.mAppCompatViewInflater == null) {
         this.mAppCompatViewInflater = new AppCompatViewInflater();
      }

      boolean var6;
      if(var5 && this.shouldInheritContext((ViewParent)var1)) {
         var6 = true;
      } else {
         var6 = false;
      }

      return this.mAppCompatViewInflater.createView(var1, var2, var3, var4, var6, var5, true, var5);
   }

   boolean dispatchKeyEvent(KeyEvent var1) {
      if(var1.getKeyCode() == 82 && this.mOriginalWindowCallback.dispatchKeyEvent(var1)) {
         return true;
      } else {
         int var2 = var1.getKeyCode();
         boolean var3;
         if(var1.getAction() == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3?this.onKeyDown(var2, var1):this.onKeyUp(var2, var1);
      }
   }

   ViewGroup getSubDecor() {
      return this.mSubDecor;
   }

   public boolean hasWindowFeature(int var1) {
      int var2 = this.sanitizeWindowFeatureId(var1);
      switch(var2) {
      case 1:
         return this.mWindowNoTitle;
      case 2:
         return this.mFeatureProgress;
      case 5:
         return this.mFeatureIndeterminateProgress;
      case 10:
         return this.mOverlayActionMode;
      case 108:
         return this.mHasActionBar;
      case 109:
         return this.mOverlayActionBar;
      default:
         return this.mWindow.hasFeature(var2);
      }
   }

   public void initWindowDecorActionBar() {
      this.ensureSubDecor();
      if(this.mHasActionBar && this.mActionBar == null) {
         if(this.mOriginalWindowCallback instanceof Activity) {
            this.mActionBar = new WindowDecorActionBar((Activity)this.mOriginalWindowCallback, this.mOverlayActionBar);
         } else if(this.mOriginalWindowCallback instanceof Dialog) {
            this.mActionBar = new WindowDecorActionBar((Dialog)this.mOriginalWindowCallback);
         }

         if(this.mActionBar != null) {
            this.mActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            return;
         }
      }

   }

   public void installViewFactory() {
      LayoutInflater var1 = LayoutInflater.from(this.mContext);
      if(var1.getFactory() == null) {
         LayoutInflaterCompat.setFactory(var1, this);
      } else if(!(LayoutInflaterCompat.getFactory(var1) instanceof AppCompatDelegateImplV7)) {
         Log.i("AppCompatDelegate", "The Activity\'s LayoutInflater already has a Factory installed so we can not install AppCompat\'s");
         return;
      }

   }

   public void invalidateOptionsMenu() {
      ActionBar var1 = this.getSupportActionBar();
      if(var1 == null || !var1.invalidateOptionsMenu()) {
         this.invalidatePanelMenu(0);
      }
   }

   boolean onBackPressed() {
      if(this.mActionMode != null) {
         this.mActionMode.finish();
      } else {
         ActionBar var1 = this.getSupportActionBar();
         if(var1 == null || !var1.collapseActionView()) {
            return false;
         }
      }

      return true;
   }

   public void onConfigurationChanged(Configuration var1) {
      if(this.mHasActionBar && this.mSubDecorInstalled) {
         ActionBar var2 = this.getSupportActionBar();
         if(var2 != null) {
            var2.onConfigurationChanged(var1);
         }
      }

   }

   public void onCreate(Bundle var1) {
      if(this.mOriginalWindowCallback instanceof Activity && NavUtils.getParentActivityName((Activity)this.mOriginalWindowCallback) != null) {
         ActionBar var2 = this.peekSupportActionBar();
         if(var2 != null) {
            var2.setDefaultDisplayHomeAsUpEnabled(true);
            return;
         }

         this.mEnableDefaultActionBarUp = true;
      }

   }

   public final View onCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      View var5 = this.callActivityOnCreateView(var1, var2, var3, var4);
      return var5 != null?var5:this.createView(var1, var2, var3, var4);
   }

   public void onDestroy() {
      super.onDestroy();
      if(this.mActionBar != null) {
         this.mActionBar.onDestroy();
         this.mActionBar = null;
      }

   }

   boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3 = true;
      switch(var1) {
      case 4:
         if((128 & var2.getFlags()) == 0) {
            var3 = false;
         }

         this.mLongPressBackDown = var3;
      default:
         if(VERSION.SDK_INT < 11) {
            this.onKeyShortcut(var1, var2);
         }

         return false;
      case 82:
         this.onKeyDownPanel(0, var2);
         return var3;
      }
   }

   boolean onKeyShortcut(int var1, KeyEvent var2) {
      ActionBar var3 = this.getSupportActionBar();
      if(var3 == null || !var3.onKeyShortcut(var1, var2)) {
         if(this.mPreparedPanel != null && this.performPanelShortcut(this.mPreparedPanel, var2.getKeyCode(), var2, 1)) {
            if(this.mPreparedPanel != null) {
               this.mPreparedPanel.isHandled = true;
               return true;
            }
         } else {
            if(this.mPreparedPanel == null) {
               AppCompatDelegateImplV7.PanelFeatureState var4 = this.getPanelState(0, true);
               this.preparePanel(var4, var2);
               boolean var6 = this.performPanelShortcut(var4, var2.getKeyCode(), var2, 1);
               var4.isPrepared = false;
               if(var6) {
                  return true;
               }
            }

            return false;
         }
      }

      return true;
   }

   boolean onKeyUp(int var1, KeyEvent var2) {
      boolean var3 = true;
      switch(var1) {
      case 4:
         boolean var4 = this.mLongPressBackDown;
         this.mLongPressBackDown = false;
         AppCompatDelegateImplV7.PanelFeatureState var5 = this.getPanelState(0, false);
         if(var5 != null && var5.isOpen) {
            if(!var4) {
               this.closePanel(var5, var3);
               return var3;
            }
            break;
         } else if(this.onBackPressed()) {
            return var3;
         }
      default:
         var3 = false;
         break;
      case 82:
         this.onKeyUpPanel(0, var2);
         return var3;
      }

      return var3;
   }

   public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      Callback var3 = this.getWindowCallback();
      if(var3 != null && !this.isDestroyed()) {
         AppCompatDelegateImplV7.PanelFeatureState var4 = this.findMenuPanel(var1.getRootMenu());
         if(var4 != null) {
            return var3.onMenuItemSelected(var4.featureId, var2);
         }
      }

      return false;
   }

   public void onMenuModeChange(MenuBuilder var1) {
      this.reopenMenu(var1, true);
   }

   boolean onMenuOpened(int var1, Menu var2) {
      if(var1 == 108) {
         ActionBar var3 = this.getSupportActionBar();
         if(var3 != null) {
            var3.dispatchMenuVisibilityChanged(true);
         }

         return true;
      } else {
         return false;
      }
   }

   void onPanelClosed(int var1, Menu var2) {
      if(var1 == 108) {
         ActionBar var4 = this.getSupportActionBar();
         if(var4 != null) {
            var4.dispatchMenuVisibilityChanged(false);
         }
      } else if(var1 == 0) {
         AppCompatDelegateImplV7.PanelFeatureState var3 = this.getPanelState(var1, true);
         if(var3.isOpen) {
            this.closePanel(var3, false);
            return;
         }
      }

   }

   public void onPostCreate(Bundle var1) {
      this.ensureSubDecor();
   }

   public void onPostResume() {
      ActionBar var1 = this.getSupportActionBar();
      if(var1 != null) {
         var1.setShowHideAnimationEnabled(true);
      }

   }

   public void onStop() {
      ActionBar var1 = this.getSupportActionBar();
      if(var1 != null) {
         var1.setShowHideAnimationEnabled(false);
      }

   }

   void onSubDecorInstalled(ViewGroup var1) {
   }

   void onTitleChanged(CharSequence var1) {
      if(this.mDecorContentParent != null) {
         this.mDecorContentParent.setWindowTitle(var1);
      } else {
         if(this.peekSupportActionBar() != null) {
            this.peekSupportActionBar().setWindowTitle(var1);
            return;
         }

         if(this.mTitleView != null) {
            this.mTitleView.setText(var1);
            return;
         }
      }

   }

   public boolean requestWindowFeature(int var1) {
      int var2 = this.sanitizeWindowFeatureId(var1);
      if(this.mWindowNoTitle && var2 == 108) {
         return false;
      } else {
         if(this.mHasActionBar && var2 == 1) {
            this.mHasActionBar = false;
         }

         switch(var2) {
         case 1:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
         case 2:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
         case 5:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
         case 10:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
         case 108:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
         case 109:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionBar = true;
            return true;
         default:
            return this.mWindow.requestFeature(var2);
         }
      }
   }

   public void setContentView(int var1) {
      this.ensureSubDecor();
      ViewGroup var2 = (ViewGroup)this.mSubDecor.findViewById(16908290);
      var2.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(var1, var2);
      this.mOriginalWindowCallback.onContentChanged();
   }

   public void setContentView(View var1) {
      this.ensureSubDecor();
      ViewGroup var2 = (ViewGroup)this.mSubDecor.findViewById(16908290);
      var2.removeAllViews();
      var2.addView(var1);
      this.mOriginalWindowCallback.onContentChanged();
   }

   public void setContentView(View var1, LayoutParams var2) {
      this.ensureSubDecor();
      ViewGroup var3 = (ViewGroup)this.mSubDecor.findViewById(16908290);
      var3.removeAllViews();
      var3.addView(var1, var2);
      this.mOriginalWindowCallback.onContentChanged();
   }

   public void setSupportActionBar(Toolbar var1) {
      if(this.mOriginalWindowCallback instanceof Activity) {
         ActionBar var2 = this.getSupportActionBar();
         if(var2 instanceof WindowDecorActionBar) {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
         } else {
            this.mMenuInflater = null;
            if(var2 != null) {
               var2.onDestroy();
            }

            if(var1 != null) {
               ToolbarActionBar var3 = new ToolbarActionBar(var1, ((Activity)this.mContext).getTitle(), this.mAppCompatWindowCallback);
               this.mActionBar = var3;
               this.mWindow.setCallback(var3.getWrappedWindowCallback());
            } else {
               this.mActionBar = null;
               this.mWindow.setCallback(this.mAppCompatWindowCallback);
            }

            this.invalidateOptionsMenu();
         }
      }
   }

   public ActionMode startSupportActionMode(ActionMode.Callback var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("ActionMode callback can not be null.");
      } else {
         if(this.mActionMode != null) {
            this.mActionMode.finish();
         }

         AppCompatDelegateImplV7.ActionModeCallbackWrapperV7 var2 = new AppCompatDelegateImplV7.ActionModeCallbackWrapperV7(var1);
         ActionBar var3 = this.getSupportActionBar();
         if(var3 != null) {
            this.mActionMode = var3.startActionMode(var2);
            if(this.mActionMode != null && this.mAppCompatCallback != null) {
               this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
            }
         }

         if(this.mActionMode == null) {
            this.mActionMode = this.startSupportActionModeFromWindow(var2);
         }

         return this.mActionMode;
      }
   }

   ActionMode startSupportActionModeFromWindow(ActionMode.Callback var1) {
      this.endOnGoingFadeAnimation();
      if(this.mActionMode != null) {
         this.mActionMode.finish();
      }

      AppCompatDelegateImplV7.ActionModeCallbackWrapperV7 var2 = new AppCompatDelegateImplV7.ActionModeCallbackWrapperV7(var1);
      AppCompatCallback var3 = this.mAppCompatCallback;
      ActionMode var4 = null;
      if(var3 != null) {
         boolean var19 = this.isDestroyed();
         var4 = null;
         if(!var19) {
            label54: {
               ActionMode var21;
               try {
                  var21 = this.mAppCompatCallback.onWindowStartingSupportActionMode(var2);
               } catch (AbstractMethodError var22) {
                  var4 = null;
                  break label54;
               }

               var4 = var21;
            }
         }
      }

      if(var4 != null) {
         this.mActionMode = var4;
      } else {
         if(this.mActionModeView == null) {
            if(this.mIsFloating) {
               TypedValue var11 = new TypedValue();
               Theme var12 = this.mContext.getTheme();
               var12.resolveAttribute(class_22.attr.actionBarTheme, var11, true);
               Object var14;
               if(var11.resourceId != 0) {
                  Theme var17 = this.mContext.getResources().newTheme();
                  var17.setTo(var12);
                  var17.applyStyle(var11.resourceId, true);
                  var14 = new ContextThemeWrapper(this.mContext, 0);
                  ((Context)var14).getTheme().setTo(var17);
               } else {
                  var14 = this.mContext;
               }

               this.mActionModeView = new ActionBarContextView((Context)var14);
               this.mActionModePopup = new PopupWindow((Context)var14, (AttributeSet)null, class_22.attr.actionModePopupWindowStyle);
               PopupWindowCompat.setWindowLayoutType(this.mActionModePopup, 2);
               this.mActionModePopup.setContentView(this.mActionModeView);
               this.mActionModePopup.setWidth(-1);
               ((Context)var14).getTheme().resolveAttribute(class_22.attr.actionBarSize, var11, true);
               int var16 = TypedValue.complexToDimensionPixelSize(var11.data, ((Context)var14).getResources().getDisplayMetrics());
               this.mActionModeView.setContentHeight(var16);
               this.mActionModePopup.setHeight(-2);
               this.mShowActionModePopup = new Runnable() {
                  public void run() {
                     AppCompatDelegateImplV7.this.mActionModePopup.showAtLocation(AppCompatDelegateImplV7.this.mActionModeView, 55, 0, 0);
                     AppCompatDelegateImplV7.this.endOnGoingFadeAnimation();
                     ViewCompat.setAlpha(AppCompatDelegateImplV7.this.mActionModeView, 0.0F);
                     AppCompatDelegateImplV7.this.mFadeAnim = ViewCompat.animate(AppCompatDelegateImplV7.this.mActionModeView).alpha(1.0F);
                     AppCompatDelegateImplV7.this.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter() {
                        public void onAnimationEnd(View var1) {
                           ViewCompat.setAlpha(AppCompatDelegateImplV7.this.mActionModeView, 1.0F);
                           AppCompatDelegateImplV7.this.mFadeAnim.setListener((ViewPropertyAnimatorListener)null);
                           AppCompatDelegateImplV7.this.mFadeAnim = null;
                        }

                        public void onAnimationStart(View var1) {
                           AppCompatDelegateImplV7.this.mActionModeView.setVisibility(0);
                        }
                     });
                  }
               };
            } else {
               ViewStubCompat var18 = (ViewStubCompat)this.mSubDecor.findViewById(class_22.class_93.action_mode_bar_stub);
               if(var18 != null) {
                  var18.setLayoutInflater(LayoutInflater.from(this.getActionBarThemedContext()));
                  this.mActionModeView = (ActionBarContextView)var18.inflate();
               }
            }
         }

         if(this.mActionModeView != null) {
            this.endOnGoingFadeAnimation();
            this.mActionModeView.killMode();
            Context var5 = this.mActionModeView.getContext();
            ActionBarContextView var6 = this.mActionModeView;
            boolean var7;
            if(this.mActionModePopup == null) {
               var7 = true;
            } else {
               var7 = false;
            }

            StandaloneActionMode var8 = new StandaloneActionMode(var5, var6, var2, var7);
            if(var1.onCreateActionMode(var8, var8.getMenu())) {
               var8.invalidate();
               this.mActionModeView.initForMode(var8);
               this.mActionMode = var8;
               ViewCompat.setAlpha(this.mActionModeView, 0.0F);
               this.mFadeAnim = ViewCompat.animate(this.mActionModeView).alpha(1.0F);
               this.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter() {
                  public void onAnimationEnd(View var1) {
                     ViewCompat.setAlpha(AppCompatDelegateImplV7.this.mActionModeView, 1.0F);
                     AppCompatDelegateImplV7.this.mFadeAnim.setListener((ViewPropertyAnimatorListener)null);
                     AppCompatDelegateImplV7.this.mFadeAnim = null;
                  }

                  public void onAnimationStart(View var1) {
                     AppCompatDelegateImplV7.this.mActionModeView.setVisibility(0);
                     AppCompatDelegateImplV7.this.mActionModeView.sendAccessibilityEvent(32);
                     if(AppCompatDelegateImplV7.this.mActionModeView.getParent() != null) {
                        ViewCompat.requestApplyInsets((View)AppCompatDelegateImplV7.this.mActionModeView.getParent());
                     }

                  }
               });
               if(this.mActionModePopup != null) {
                  this.mWindow.getDecorView().post(this.mShowActionModePopup);
               }
            } else {
               this.mActionMode = null;
            }
         }
      }

      if(this.mActionMode != null && this.mAppCompatCallback != null) {
         this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
      }

      return this.mActionMode;
   }

   private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
      private ActionMenuPresenterCallback() {
      }

      // $FF: synthetic method
      ActionMenuPresenterCallback(Object var2) {
         this();
      }

      public void onCloseMenu(MenuBuilder var1, boolean var2) {
         AppCompatDelegateImplV7.this.checkCloseActionMenu(var1);
      }

      public boolean onOpenSubMenu(MenuBuilder var1) {
         Callback var2 = AppCompatDelegateImplV7.this.getWindowCallback();
         if(var2 != null) {
            var2.onMenuOpened(108, var1);
         }

         return true;
      }
   }

   class ActionModeCallbackWrapperV7 implements ActionMode.Callback {
      private ActionMode.Callback mWrapped;

      public ActionModeCallbackWrapperV7(ActionMode.Callback var2) {
         this.mWrapped = var2;
      }

      public boolean onActionItemClicked(ActionMode var1, MenuItem var2) {
         return this.mWrapped.onActionItemClicked(var1, var2);
      }

      public boolean onCreateActionMode(ActionMode var1, Menu var2) {
         return this.mWrapped.onCreateActionMode(var1, var2);
      }

      public void onDestroyActionMode(ActionMode var1) {
         this.mWrapped.onDestroyActionMode(var1);
         if(AppCompatDelegateImplV7.this.mActionModePopup != null) {
            AppCompatDelegateImplV7.this.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.mShowActionModePopup);
         }

         if(AppCompatDelegateImplV7.this.mActionModeView != null) {
            AppCompatDelegateImplV7.this.endOnGoingFadeAnimation();
            AppCompatDelegateImplV7.this.mFadeAnim = ViewCompat.animate(AppCompatDelegateImplV7.this.mActionModeView).alpha(0.0F);
            AppCompatDelegateImplV7.this.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter() {
               public void onAnimationEnd(View var1) {
                  AppCompatDelegateImplV7.this.mActionModeView.setVisibility(8);
                  if(AppCompatDelegateImplV7.this.mActionModePopup != null) {
                     AppCompatDelegateImplV7.this.mActionModePopup.dismiss();
                  } else if(AppCompatDelegateImplV7.this.mActionModeView.getParent() instanceof View) {
                     ViewCompat.requestApplyInsets((View)AppCompatDelegateImplV7.this.mActionModeView.getParent());
                  }

                  AppCompatDelegateImplV7.this.mActionModeView.removeAllViews();
                  AppCompatDelegateImplV7.this.mFadeAnim.setListener((ViewPropertyAnimatorListener)null);
                  AppCompatDelegateImplV7.this.mFadeAnim = null;
               }
            });
         }

         if(AppCompatDelegateImplV7.this.mAppCompatCallback != null) {
            AppCompatDelegateImplV7.this.mAppCompatCallback.onSupportActionModeFinished(AppCompatDelegateImplV7.this.mActionMode);
         }

         AppCompatDelegateImplV7.this.mActionMode = null;
      }

      public boolean onPrepareActionMode(ActionMode var1, Menu var2) {
         return this.mWrapped.onPrepareActionMode(var1, var2);
      }
   }

   private class ListMenuDecorView extends ContentFrameLayout {
      public ListMenuDecorView(Context var2) {
         super(var2);
      }

      private boolean isOutOfBounds(int var1, int var2) {
         return var1 < -5 || var2 < -5 || var1 > 5 + this.getWidth() || var2 > 5 + this.getHeight();
      }

      public boolean dispatchKeyEvent(KeyEvent var1) {
         return AppCompatDelegateImplV7.this.dispatchKeyEvent(var1) || super.dispatchKeyEvent(var1);
      }

      public boolean onInterceptTouchEvent(MotionEvent var1) {
         if(var1.getAction() == 0 && this.isOutOfBounds((int)var1.getX(), (int)var1.getY())) {
            AppCompatDelegateImplV7.this.closePanel(0);
            return true;
         } else {
            return super.onInterceptTouchEvent(var1);
         }
      }

      public void setBackgroundResource(int var1) {
         this.setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(this.getContext(), var1));
      }
   }

   private static final class PanelFeatureState {
      int background;
      View createdPanelView;
      ViewGroup decorView;
      int featureId;
      Bundle frozenActionViewState;
      Bundle frozenMenuState;
      int gravity;
      boolean isHandled;
      boolean isOpen;
      boolean isPrepared;
      ListMenuPresenter listMenuPresenter;
      Context listPresenterContext;
      MenuBuilder menu;
      public boolean qwertyMode;
      boolean refreshDecorView;
      boolean refreshMenuContent;
      View shownPanelView;
      boolean wasLastOpen;
      int windowAnimations;
      // $FF: renamed from: x int
      int field_142;
      // $FF: renamed from: y int
      int field_143;

      PanelFeatureState(int var1) {
         this.featureId = var1;
         this.refreshDecorView = false;
      }

      void applyFrozenState() {
         if(this.menu != null && this.frozenMenuState != null) {
            this.menu.restorePresenterStates(this.frozenMenuState);
            this.frozenMenuState = null;
         }

      }

      public void clearMenuPresenters() {
         if(this.menu != null) {
            this.menu.removeMenuPresenter(this.listMenuPresenter);
         }

         this.listMenuPresenter = null;
      }

      MenuView getListMenuView(MenuPresenter.Callback var1) {
         if(this.menu == null) {
            return null;
         } else {
            if(this.listMenuPresenter == null) {
               this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, class_22.layout.abc_list_menu_item_layout);
               this.listMenuPresenter.setCallback(var1);
               this.menu.addMenuPresenter(this.listMenuPresenter);
            }

            return this.listMenuPresenter.getMenuView(this.decorView);
         }
      }

      public boolean hasPanelItems() {
         boolean var1 = true;
         if(this.shownPanelView == null) {
            var1 = false;
         } else if(this.createdPanelView == null && this.listMenuPresenter.getAdapter().getCount() <= 0) {
            return false;
         }

         return var1;
      }

      void onRestoreInstanceState(Parcelable var1) {
         AppCompatDelegateImplV7.SavedState var2 = (AppCompatDelegateImplV7.SavedState)var1;
         this.featureId = var2.featureId;
         this.wasLastOpen = var2.isOpen;
         this.frozenMenuState = var2.menuState;
         this.shownPanelView = null;
         this.decorView = null;
      }

      Parcelable onSaveInstanceState() {
         AppCompatDelegateImplV7.SavedState var1 = new AppCompatDelegateImplV7.SavedState(null);
         var1.featureId = this.featureId;
         var1.isOpen = this.isOpen;
         if(this.menu != null) {
            var1.menuState = new Bundle();
            this.menu.savePresenterStates(var1.menuState);
         }

         return var1;
      }

      void setMenu(MenuBuilder var1) {
         if(var1 != this.menu) {
            if(this.menu != null) {
               this.menu.removeMenuPresenter(this.listMenuPresenter);
            }

            this.menu = var1;
            if(var1 != null && this.listMenuPresenter != null) {
               var1.addMenuPresenter(this.listMenuPresenter);
               return;
            }
         }

      }

      void setStyle(Context var1) {
         TypedValue var2 = new TypedValue();
         Theme var3 = var1.getResources().newTheme();
         var3.setTo(var1.getTheme());
         var3.resolveAttribute(class_22.attr.actionBarPopupTheme, var2, true);
         if(var2.resourceId != 0) {
            var3.applyStyle(var2.resourceId, true);
         }

         var3.resolveAttribute(class_22.attr.panelMenuListTheme, var2, true);
         if(var2.resourceId != 0) {
            var3.applyStyle(var2.resourceId, true);
         } else {
            var3.applyStyle(class_22.style.Theme_AppCompat_CompactMenu, true);
         }

         ContextThemeWrapper var6 = new ContextThemeWrapper(var1, 0);
         var6.getTheme().setTo(var3);
         this.listPresenterContext = var6;
         TypedArray var7 = var6.obtainStyledAttributes(class_22.styleable.AppCompatTheme);
         this.background = var7.getResourceId(class_22.styleable.AppCompatTheme_panelBackground, 0);
         this.windowAnimations = var7.getResourceId(class_22.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
         var7.recycle();
      }
   }

   private static class SavedState implements Parcelable {
      public static final Creator<AppCompatDelegateImplV7.SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks() {
         public AppCompatDelegateImplV7.SavedState createFromParcel(Parcel var1, ClassLoader var2) {
            return AppCompatDelegateImplV7.SavedState.readFromParcel(var1, var2);
         }

         public AppCompatDelegateImplV7.SavedState[] newArray(int var1) {
            return new AppCompatDelegateImplV7.SavedState[var1];
         }
      });
      int featureId;
      boolean isOpen;
      Bundle menuState;

      private SavedState() {
      }

      // $FF: synthetic method
      SavedState(Object var1) {
         this();
      }

      private static AppCompatDelegateImplV7.SavedState readFromParcel(Parcel var0, ClassLoader var1) {
         byte var2 = 1;
         AppCompatDelegateImplV7.SavedState var3 = new AppCompatDelegateImplV7.SavedState();
         var3.featureId = var0.readInt();
         if(var0.readInt() != var2) {
            var2 = 0;
         }

         var3.isOpen = (boolean)var2;
         if(var3.isOpen) {
            var3.menuState = var0.readBundle(var1);
         }

         return var3;
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeInt(this.featureId);
         byte var3;
         if(this.isOpen) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
         if(this.isOpen) {
            var1.writeBundle(this.menuState);
         }

      }
   }

   private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
      private PanelMenuPresenterCallback() {
      }

      // $FF: synthetic method
      PanelMenuPresenterCallback(Object var2) {
         this();
      }

      public void onCloseMenu(MenuBuilder var1, boolean var2) {
         MenuBuilder var3 = var1.getRootMenu();
         boolean var4;
         if(var3 != var1) {
            var4 = true;
         } else {
            var4 = false;
         }

         AppCompatDelegateImplV7 var5 = AppCompatDelegateImplV7.this;
         if(var4) {
            var1 = var3;
         }

         AppCompatDelegateImplV7.PanelFeatureState var6 = var5.findMenuPanel(var1);
         if(var6 != null) {
            if(!var4) {
               AppCompatDelegateImplV7.this.closePanel(var6, var2);
               return;
            }

            AppCompatDelegateImplV7.this.callOnPanelClosed(var6.featureId, var6, var3);
            AppCompatDelegateImplV7.this.closePanel(var6, true);
         }

      }

      public boolean onOpenSubMenu(MenuBuilder var1) {
         if(var1 == null && AppCompatDelegateImplV7.this.mHasActionBar) {
            Callback var2 = AppCompatDelegateImplV7.this.getWindowCallback();
            if(var2 != null && !AppCompatDelegateImplV7.this.isDestroyed()) {
               var2.onMenuOpened(108, var1);
            }
         }

         return true;
      }
   }
}
