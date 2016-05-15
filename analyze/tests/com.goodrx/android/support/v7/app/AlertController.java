package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.appcompat.class_22;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import java.lang.ref.WeakReference;

class AlertController {
   private ListAdapter mAdapter;
   private int mAlertDialogLayout;
   private final OnClickListener mButtonHandler = new OnClickListener() {
      public void onClick(View var1) {
         Message var2;
         if(var1 == AlertController.this.mButtonPositive && AlertController.this.mButtonPositiveMessage != null) {
            var2 = Message.obtain(AlertController.this.mButtonPositiveMessage);
         } else if(var1 == AlertController.this.mButtonNegative && AlertController.this.mButtonNegativeMessage != null) {
            var2 = Message.obtain(AlertController.this.mButtonNegativeMessage);
         } else if(var1 == AlertController.this.mButtonNeutral && AlertController.this.mButtonNeutralMessage != null) {
            var2 = Message.obtain(AlertController.this.mButtonNeutralMessage);
         } else {
            var2 = null;
         }

         if(var2 != null) {
            var2.sendToTarget();
         }

         AlertController.this.mHandler.obtainMessage(1, AlertController.this.mDialog).sendToTarget();
      }
   };
   private Button mButtonNegative;
   private Message mButtonNegativeMessage;
   private CharSequence mButtonNegativeText;
   private Button mButtonNeutral;
   private Message mButtonNeutralMessage;
   private CharSequence mButtonNeutralText;
   private int mButtonPanelLayoutHint = 0;
   private int mButtonPanelSideLayout;
   private Button mButtonPositive;
   private Message mButtonPositiveMessage;
   private CharSequence mButtonPositiveText;
   private int mCheckedItem = -1;
   private final Context mContext;
   private View mCustomTitleView;
   private final AppCompatDialog mDialog;
   private Handler mHandler;
   private Drawable mIcon;
   private int mIconId = 0;
   private ImageView mIconView;
   private int mListItemLayout;
   private int mListLayout;
   private ListView mListView;
   private CharSequence mMessage;
   private TextView mMessageView;
   private int mMultiChoiceItemLayout;
   private NestedScrollView mScrollView;
   private int mSingleChoiceItemLayout;
   private CharSequence mTitle;
   private TextView mTitleView;
   private View mView;
   private int mViewLayoutResId;
   private int mViewSpacingBottom;
   private int mViewSpacingLeft;
   private int mViewSpacingRight;
   private boolean mViewSpacingSpecified = false;
   private int mViewSpacingTop;
   private final Window mWindow;

   public AlertController(Context var1, AppCompatDialog var2, Window var3) {
      this.mContext = var1;
      this.mDialog = var2;
      this.mWindow = var3;
      this.mHandler = new AlertController.ButtonHandler(var2);
      TypedArray var4 = var1.obtainStyledAttributes((AttributeSet)null, class_22.styleable.AlertDialog, class_22.attr.alertDialogStyle, 0);
      this.mAlertDialogLayout = var4.getResourceId(class_22.styleable.AlertDialog_android_layout, 0);
      this.mButtonPanelSideLayout = var4.getResourceId(class_22.styleable.AlertDialog_buttonPanelSideLayout, 0);
      this.mListLayout = var4.getResourceId(class_22.styleable.AlertDialog_listLayout, 0);
      this.mMultiChoiceItemLayout = var4.getResourceId(class_22.styleable.AlertDialog_multiChoiceItemLayout, 0);
      this.mSingleChoiceItemLayout = var4.getResourceId(class_22.styleable.AlertDialog_singleChoiceItemLayout, 0);
      this.mListItemLayout = var4.getResourceId(class_22.styleable.AlertDialog_listItemLayout, 0);
      var4.recycle();
   }

   static boolean canTextInput(View var0) {
      if(var0.onCheckIsTextEditor()) {
         return true;
      } else if(!(var0 instanceof ViewGroup)) {
         return false;
      } else {
         ViewGroup var1 = (ViewGroup)var0;
         int var2 = var1.getChildCount();

         do {
            if(var2 <= 0) {
               return false;
            }

            --var2;
         } while(!canTextInput(var1.getChildAt(var2)));

         return true;
      }
   }

   private static void manageScrollIndicators(View var0, View var1, View var2) {
      if(var1 != null) {
         byte var5;
         if(ViewCompat.canScrollVertically(var0, -1)) {
            var5 = 0;
         } else {
            var5 = 4;
         }

         var1.setVisibility(var5);
      }

      if(var2 != null) {
         boolean var3 = ViewCompat.canScrollVertically(var0, 1);
         byte var4 = 0;
         if(!var3) {
            var4 = 4;
         }

         var2.setVisibility(var4);
      }

   }

   @Nullable
   private ViewGroup resolvePanel(@Nullable View var1, @Nullable View var2) {
      if(var1 == null) {
         if(var2 instanceof ViewStub) {
            var2 = ((ViewStub)var2).inflate();
         }

         return (ViewGroup)var2;
      } else {
         if(var2 != null) {
            ViewParent var3 = var2.getParent();
            if(var3 instanceof ViewGroup) {
               ((ViewGroup)var3).removeView(var2);
            }
         }

         if(var1 instanceof ViewStub) {
            var1 = ((ViewStub)var1).inflate();
         }

         return (ViewGroup)var1;
      }
   }

   private int selectContentView() {
      return this.mButtonPanelSideLayout == 0?this.mAlertDialogLayout:(this.mButtonPanelLayoutHint == 1?this.mButtonPanelSideLayout:this.mAlertDialogLayout);
   }

   private void setScrollIndicators(ViewGroup var1, View var2, int var3, int var4) {
      final View var5 = this.mWindow.findViewById(class_22.class_93.scrollIndicatorUp);
      final View var6 = this.mWindow.findViewById(class_22.class_93.scrollIndicatorDown);
      if(VERSION.SDK_INT >= 23) {
         ViewCompat.setScrollIndicators(var2, var3, var4);
         if(var5 != null) {
            var1.removeView(var5);
         }

         if(var6 != null) {
            var1.removeView(var6);
         }
      } else {
         if(var5 != null && (var3 & 1) == 0) {
            var1.removeView(var5);
            var5 = null;
         }

         if(var6 != null && (var3 & 2) == 0) {
            var1.removeView(var6);
            var6 = null;
         }

         if(var5 != null || var6 != null) {
            if(this.mMessage != null) {
               this.mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                  public void onScrollChange(NestedScrollView var1, int var2, int var3, int var4, int var5x) {
                     AlertController.manageScrollIndicators(var1, var5, var6);
                  }
               });
               this.mScrollView.post(new Runnable() {
                  public void run() {
                     AlertController.manageScrollIndicators(AlertController.this.mScrollView, var5, var6);
                  }
               });
               return;
            }

            if(this.mListView != null) {
               this.mListView.setOnScrollListener(new OnScrollListener() {
                  public void onScroll(AbsListView var1, int var2, int var3, int var4) {
                     AlertController.manageScrollIndicators(var1, var5, var6);
                  }

                  public void onScrollStateChanged(AbsListView var1, int var2) {
                  }
               });
               this.mListView.post(new Runnable() {
                  public void run() {
                     AlertController.manageScrollIndicators(AlertController.this.mListView, var5, var6);
                  }
               });
               return;
            }

            if(var5 != null) {
               var1.removeView(var5);
            }

            if(var6 != null) {
               var1.removeView(var6);
               return;
            }
         }
      }

   }

   private void setupButtons(ViewGroup var1) {
      int var2 = 0;
      this.mButtonPositive = (Button)var1.findViewById(16908313);
      this.mButtonPositive.setOnClickListener(this.mButtonHandler);
      if(TextUtils.isEmpty(this.mButtonPositiveText)) {
         this.mButtonPositive.setVisibility(8);
      } else {
         this.mButtonPositive.setText(this.mButtonPositiveText);
         this.mButtonPositive.setVisibility(0);
         var2 = 0 | 1;
      }

      this.mButtonNegative = (Button)var1.findViewById(16908314);
      this.mButtonNegative.setOnClickListener(this.mButtonHandler);
      if(TextUtils.isEmpty(this.mButtonNegativeText)) {
         this.mButtonNegative.setVisibility(8);
      } else {
         this.mButtonNegative.setText(this.mButtonNegativeText);
         this.mButtonNegative.setVisibility(0);
         var2 |= 2;
      }

      this.mButtonNeutral = (Button)var1.findViewById(16908315);
      this.mButtonNeutral.setOnClickListener(this.mButtonHandler);
      if(TextUtils.isEmpty(this.mButtonNeutralText)) {
         this.mButtonNeutral.setVisibility(8);
      } else {
         this.mButtonNeutral.setText(this.mButtonNeutralText);
         this.mButtonNeutral.setVisibility(0);
         var2 |= 4;
      }

      boolean var3 = false;
      if(var2 != 0) {
         var3 = true;
      }

      if(!var3) {
         var1.setVisibility(8);
      }

   }

   private void setupContent(ViewGroup var1) {
      this.mScrollView = (NestedScrollView)this.mWindow.findViewById(class_22.class_93.scrollView);
      this.mScrollView.setFocusable(false);
      this.mScrollView.setNestedScrollingEnabled(false);
      this.mMessageView = (TextView)var1.findViewById(16908299);
      if(this.mMessageView != null) {
         if(this.mMessage != null) {
            this.mMessageView.setText(this.mMessage);
         } else {
            this.mMessageView.setVisibility(8);
            this.mScrollView.removeView(this.mMessageView);
            if(this.mListView != null) {
               ViewGroup var2 = (ViewGroup)this.mScrollView.getParent();
               int var3 = var2.indexOfChild(this.mScrollView);
               var2.removeViewAt(var3);
               var2.addView(this.mListView, var3, new LayoutParams(-1, -1));
            } else {
               var1.setVisibility(8);
            }
         }
      }
   }

   private void setupCustomContent(ViewGroup var1) {
      View var2;
      if(this.mView != null) {
         var2 = this.mView;
      } else if(this.mViewLayoutResId != 0) {
         var2 = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, var1, false);
      } else {
         var2 = null;
      }

      boolean var3 = false;
      if(var2 != null) {
         var3 = true;
      }

      if(!var3 || !canTextInput(var2)) {
         this.mWindow.setFlags(131072, 131072);
      }

      if(var3) {
         FrameLayout var4 = (FrameLayout)this.mWindow.findViewById(class_22.class_93.custom);
         var4.addView(var2, new LayoutParams(-1, -1));
         if(this.mViewSpacingSpecified) {
            var4.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
         }

         if(this.mListView != null) {
            ((android.widget.LinearLayout.LayoutParams)var1.getLayoutParams()).weight = 0.0F;
         }

      } else {
         var1.setVisibility(8);
      }
   }

   private void setupTitle(ViewGroup var1) {
      if(this.mCustomTitleView != null) {
         LayoutParams var2 = new LayoutParams(-1, -2);
         var1.addView(this.mCustomTitleView, 0, var2);
         this.mWindow.findViewById(class_22.class_93.title_template).setVisibility(8);
      } else {
         this.mIconView = (ImageView)this.mWindow.findViewById(16908294);
         boolean var3 = TextUtils.isEmpty(this.mTitle);
         boolean var4 = false;
         if(!var3) {
            var4 = true;
         }

         if(var4) {
            this.mTitleView = (TextView)this.mWindow.findViewById(class_22.class_93.alertTitle);
            this.mTitleView.setText(this.mTitle);
            if(this.mIconId != 0) {
               this.mIconView.setImageResource(this.mIconId);
            } else if(this.mIcon != null) {
               this.mIconView.setImageDrawable(this.mIcon);
            } else {
               this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
               this.mIconView.setVisibility(8);
            }
         } else {
            this.mWindow.findViewById(class_22.class_93.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            var1.setVisibility(8);
         }
      }
   }

   private void setupView() {
      View var1 = this.mWindow.findViewById(class_22.class_93.parentPanel);
      View var2 = var1.findViewById(class_22.class_93.topPanel);
      View var3 = var1.findViewById(class_22.class_93.contentPanel);
      View var4 = var1.findViewById(class_22.class_93.buttonPanel);
      ViewGroup var5 = (ViewGroup)var1.findViewById(class_22.class_93.customPanel);
      this.setupCustomContent(var5);
      View var6 = var5.findViewById(class_22.class_93.topPanel);
      View var7 = var5.findViewById(class_22.class_93.contentPanel);
      View var8 = var5.findViewById(class_22.class_93.buttonPanel);
      ViewGroup var9 = this.resolvePanel(var6, var2);
      ViewGroup var10 = this.resolvePanel(var7, var3);
      ViewGroup var11 = this.resolvePanel(var8, var4);
      this.setupContent(var10);
      this.setupButtons(var11);
      this.setupTitle(var9);
      boolean var12;
      if(var5 != null && var5.getVisibility() != 8) {
         var12 = true;
      } else {
         var12 = false;
      }

      boolean var13;
      if(var9 != null && var9.getVisibility() != 8) {
         var13 = true;
      } else {
         var13 = false;
      }

      boolean var14;
      if(var11 != null && var11.getVisibility() != 8) {
         var14 = true;
      } else {
         var14 = false;
      }

      if(!var14 && var10 != null) {
         View var20 = var10.findViewById(class_22.class_93.textSpacerNoButtons);
         if(var20 != null) {
            var20.setVisibility(0);
         }
      }

      if(var13 && this.mScrollView != null) {
         this.mScrollView.setClipToPadding(true);
      }

      if(!var12) {
         Object var17;
         if(this.mListView != null) {
            var17 = this.mListView;
         } else {
            var17 = this.mScrollView;
         }

         if(var17 != null) {
            byte var18;
            if(var13) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            byte var19;
            if(var14) {
               var19 = 2;
            } else {
               var19 = 0;
            }

            this.setScrollIndicators(var10, (View)var17, var18 | var19, 3);
         }
      }

      ListView var15 = this.mListView;
      if(var15 != null && this.mAdapter != null) {
         var15.setAdapter(this.mAdapter);
         int var16 = this.mCheckedItem;
         if(var16 > -1) {
            var15.setItemChecked(var16, true);
            var15.setSelection(var16);
         }
      }

   }

   public Button getButton(int var1) {
      switch(var1) {
      case -3:
         return this.mButtonNeutral;
      case -2:
         return this.mButtonNegative;
      case -1:
         return this.mButtonPositive;
      default:
         return null;
      }
   }

   public int getIconAttributeResId(int var1) {
      TypedValue var2 = new TypedValue();
      this.mContext.getTheme().resolveAttribute(var1, var2, true);
      return var2.resourceId;
   }

   public ListView getListView() {
      return this.mListView;
   }

   public void installContent() {
      this.mDialog.supportRequestWindowFeature(1);
      int var2 = this.selectContentView();
      this.mDialog.setContentView(var2);
      this.setupView();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      return this.mScrollView != null && this.mScrollView.executeKeyEvent(var2);
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      return this.mScrollView != null && this.mScrollView.executeKeyEvent(var2);
   }

   public void setButton(int var1, CharSequence var2, android.content.DialogInterface.OnClickListener var3, Message var4) {
      if(var4 == null && var3 != null) {
         var4 = this.mHandler.obtainMessage(var1, var3);
      }

      switch(var1) {
      case -3:
         this.mButtonNeutralText = var2;
         this.mButtonNeutralMessage = var4;
         return;
      case -2:
         this.mButtonNegativeText = var2;
         this.mButtonNegativeMessage = var4;
         return;
      case -1:
         this.mButtonPositiveText = var2;
         this.mButtonPositiveMessage = var4;
         return;
      default:
         throw new IllegalArgumentException("Button does not exist");
      }
   }

   public void setButtonPanelLayoutHint(int var1) {
      this.mButtonPanelLayoutHint = var1;
   }

   public void setCustomTitle(View var1) {
      this.mCustomTitleView = var1;
   }

   public void setIcon(int var1) {
      this.mIcon = null;
      this.mIconId = var1;
      if(this.mIconView != null) {
         if(var1 == 0) {
            this.mIconView.setVisibility(8);
            return;
         }

         this.mIconView.setVisibility(0);
         this.mIconView.setImageResource(this.mIconId);
      }

   }

   public void setIcon(Drawable var1) {
      this.mIcon = var1;
      this.mIconId = 0;
      if(this.mIconView != null) {
         if(var1 == null) {
            this.mIconView.setVisibility(8);
            return;
         }

         this.mIconView.setVisibility(0);
         this.mIconView.setImageDrawable(var1);
      }

   }

   public void setMessage(CharSequence var1) {
      this.mMessage = var1;
      if(this.mMessageView != null) {
         this.mMessageView.setText(var1);
      }

   }

   public void setTitle(CharSequence var1) {
      this.mTitle = var1;
      if(this.mTitleView != null) {
         this.mTitleView.setText(var1);
      }

   }

   public void setView(int var1) {
      this.mView = null;
      this.mViewLayoutResId = var1;
      this.mViewSpacingSpecified = false;
   }

   public void setView(View var1) {
      this.mView = var1;
      this.mViewLayoutResId = 0;
      this.mViewSpacingSpecified = false;
   }

   public void setView(View var1, int var2, int var3, int var4, int var5) {
      this.mView = var1;
      this.mViewLayoutResId = 0;
      this.mViewSpacingSpecified = true;
      this.mViewSpacingLeft = var2;
      this.mViewSpacingTop = var3;
      this.mViewSpacingRight = var4;
      this.mViewSpacingBottom = var5;
   }

   public static class AlertParams {
      public ListAdapter mAdapter;
      public boolean mCancelable;
      public int mCheckedItem = -1;
      public boolean[] mCheckedItems;
      public final Context mContext;
      public Cursor mCursor;
      public View mCustomTitleView;
      public boolean mForceInverseBackground;
      public Drawable mIcon;
      public int mIconAttrId = 0;
      public int mIconId = 0;
      public final LayoutInflater mInflater;
      public String mIsCheckedColumn;
      public boolean mIsMultiChoice;
      public boolean mIsSingleChoice;
      public CharSequence[] mItems;
      public String mLabelColumn;
      public CharSequence mMessage;
      public android.content.DialogInterface.OnClickListener mNegativeButtonListener;
      public CharSequence mNegativeButtonText;
      public android.content.DialogInterface.OnClickListener mNeutralButtonListener;
      public CharSequence mNeutralButtonText;
      public OnCancelListener mOnCancelListener;
      public OnMultiChoiceClickListener mOnCheckboxClickListener;
      public android.content.DialogInterface.OnClickListener mOnClickListener;
      public OnDismissListener mOnDismissListener;
      public OnItemSelectedListener mOnItemSelectedListener;
      public OnKeyListener mOnKeyListener;
      public AlertController.OnPrepareListViewListener mOnPrepareListViewListener;
      public android.content.DialogInterface.OnClickListener mPositiveButtonListener;
      public CharSequence mPositiveButtonText;
      public boolean mRecycleOnMeasure = true;
      public CharSequence mTitle;
      public View mView;
      public int mViewLayoutResId;
      public int mViewSpacingBottom;
      public int mViewSpacingLeft;
      public int mViewSpacingRight;
      public boolean mViewSpacingSpecified = false;
      public int mViewSpacingTop;

      public AlertParams(Context var1) {
         this.mContext = var1;
         this.mCancelable = true;
         this.mInflater = (LayoutInflater)var1.getSystemService("layout_inflater");
      }

      private void createListView(final AlertController var1) {
         final ListView var2 = (ListView)this.mInflater.inflate(var1.mListLayout, (ViewGroup)null);
         Object var4;
         if(this.mIsMultiChoice) {
            if(this.mCursor == null) {
               var4 = new ArrayAdapter(this.mContext, var1.mMultiChoiceItemLayout, 16908308, this.mItems) {
                  public View getView(int var1, View var2x, ViewGroup var3) {
                     View var4 = super.getView(var1, var2x, var3);
                     if(AlertParams.this.mCheckedItems != null && AlertParams.this.mCheckedItems[var1]) {
                        var2.setItemChecked(var1, true);
                     }

                     return var4;
                  }
               };
            } else {
               final Context var11 = this.mContext;
               final Cursor var12 = this.mCursor;
               var4 = new CursorAdapter(var11, var12, false) {
                  private final int mIsCheckedIndex;
                  private final int mLabelIndex;

                  {
                     Cursor var7 = this.getCursor();
                     this.mLabelIndex = var7.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                     this.mIsCheckedIndex = var7.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                  }

                  public void bindView(View var1x, Context var2x, Cursor var3) {
                     byte var4 = 1;
                     ((CheckedTextView)var1x.findViewById(16908308)).setText(var3.getString(this.mLabelIndex));
                     ListView var5 = var2;
                     int var6 = var3.getPosition();
                     if(var3.getInt(this.mIsCheckedIndex) != var4) {
                        var4 = 0;
                     }

                     var5.setItemChecked(var6, (boolean)var4);
                  }

                  public View newView(Context var1x, Cursor var2x, ViewGroup var3) {
                     return AlertParams.this.mInflater.inflate(var1.mMultiChoiceItemLayout, var3, false);
                  }
               };
            }
         } else {
            int var3;
            if(this.mIsSingleChoice) {
               var3 = var1.mSingleChoiceItemLayout;
            } else {
               var3 = var1.mListItemLayout;
            }

            if(this.mCursor != null) {
               Context var8 = this.mContext;
               Cursor var9 = this.mCursor;
               String[] var10 = new String[]{this.mLabelColumn};
               var4 = new SimpleCursorAdapter(var8, var3, var9, var10, new int[]{16908308});
            } else if(this.mAdapter != null) {
               var4 = this.mAdapter;
            } else {
               var4 = new AlertController.CheckedItemAdapter(this.mContext, var3, 16908308, this.mItems);
            }
         }

         if(this.mOnPrepareListViewListener != null) {
            this.mOnPrepareListViewListener.onPrepareListView(var2);
         }

         var1.mAdapter = (ListAdapter)var4;
         var1.mCheckedItem = this.mCheckedItem;
         if(this.mOnClickListener != null) {
            var2.setOnItemClickListener(new OnItemClickListener() {
               public void onItemClick(AdapterView<?> var1x, View var2, int var3, long var4) {
                  AlertParams.this.mOnClickListener.onClick(var1.mDialog, var3);
                  if(!AlertParams.this.mIsSingleChoice) {
                     var1.mDialog.dismiss();
                  }

               }
            });
         } else if(this.mOnCheckboxClickListener != null) {
            var2.setOnItemClickListener(new OnItemClickListener() {
               public void onItemClick(AdapterView<?> var1x, View var2x, int var3, long var4) {
                  if(AlertParams.this.mCheckedItems != null) {
                     AlertParams.this.mCheckedItems[var3] = var2.isItemChecked(var3);
                  }

                  AlertParams.this.mOnCheckboxClickListener.onClick(var1.mDialog, var3, var2.isItemChecked(var3));
               }
            });
         }

         if(this.mOnItemSelectedListener != null) {
            var2.setOnItemSelectedListener(this.mOnItemSelectedListener);
         }

         if(this.mIsSingleChoice) {
            var2.setChoiceMode(1);
         } else if(this.mIsMultiChoice) {
            var2.setChoiceMode(2);
         }

         var1.mListView = var2;
      }

      public void apply(AlertController var1) {
         if(this.mCustomTitleView != null) {
            var1.setCustomTitle(this.mCustomTitleView);
         } else {
            if(this.mTitle != null) {
               var1.setTitle(this.mTitle);
            }

            if(this.mIcon != null) {
               var1.setIcon(this.mIcon);
            }

            if(this.mIconId != 0) {
               var1.setIcon(this.mIconId);
            }

            if(this.mIconAttrId != 0) {
               var1.setIcon(var1.getIconAttributeResId(this.mIconAttrId));
            }
         }

         if(this.mMessage != null) {
            var1.setMessage(this.mMessage);
         }

         if(this.mPositiveButtonText != null) {
            var1.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, (Message)null);
         }

         if(this.mNegativeButtonText != null) {
            var1.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, (Message)null);
         }

         if(this.mNeutralButtonText != null) {
            var1.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, (Message)null);
         }

         if(this.mItems != null || this.mCursor != null || this.mAdapter != null) {
            this.createListView(var1);
         }

         if(this.mView != null) {
            if(!this.mViewSpacingSpecified) {
               var1.setView(this.mView);
               return;
            }

            var1.setView(this.mView, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
         } else if(this.mViewLayoutResId != 0) {
            var1.setView(this.mViewLayoutResId);
            return;
         }

      }
   }

   public interface OnPrepareListViewListener {
      void onPrepareListView(ListView var1);
   }

   private static final class ButtonHandler extends Handler {
      private static final int MSG_DISMISS_DIALOG = 1;
      private WeakReference<DialogInterface> mDialog;

      public ButtonHandler(DialogInterface var1) {
         this.mDialog = new WeakReference(var1);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case -3:
         case -2:
         case -1:
            ((android.content.DialogInterface.OnClickListener)var1.obj).onClick((DialogInterface)this.mDialog.get(), var1.what);
            return;
         case 0:
         default:
            return;
         case 1:
            ((DialogInterface)var1.obj).dismiss();
         }
      }
   }

   private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
      public CheckedItemAdapter(Context var1, int var2, int var3, CharSequence[] var4) {
         super(var1, var2, var3, var4);
      }

      public long getItemId(int var1) {
         return (long)var1;
      }

      public boolean hasStableIds() {
         return true;
      }
   }
}
