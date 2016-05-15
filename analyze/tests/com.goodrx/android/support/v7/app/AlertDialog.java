package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AlertController;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.appcompat.class_22;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemSelectedListener;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
   static final int LAYOUT_HINT_NONE = 0;
   static final int LAYOUT_HINT_SIDE = 1;
   private AlertController mAlert;

   protected AlertDialog(Context var1) {
      this(var1, resolveDialogTheme(var1, 0), true);
   }

   protected AlertDialog(Context var1, int var2) {
      this(var1, var2, true);
   }

   AlertDialog(Context var1, int var2, boolean var3) {
      super(var1, resolveDialogTheme(var1, var2));
      this.mAlert = new AlertController(this.getContext(), this, this.getWindow());
   }

   protected AlertDialog(Context var1, boolean var2, OnCancelListener var3) {
      super(var1, resolveDialogTheme(var1, 0));
      this.setCancelable(var2);
      this.setOnCancelListener(var3);
      this.mAlert = new AlertController(var1, this, this.getWindow());
   }

   static int resolveDialogTheme(Context var0, int var1) {
      if(var1 >= 16777216) {
         return var1;
      } else {
         TypedValue var2 = new TypedValue();
         var0.getTheme().resolveAttribute(class_22.attr.alertDialogTheme, var2, true);
         return var2.resourceId;
      }
   }

   public Button getButton(int var1) {
      return this.mAlert.getButton(var1);
   }

   public ListView getListView() {
      return this.mAlert.getListView();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.mAlert.installContent();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      return this.mAlert.onKeyDown(var1, var2)?true:super.onKeyDown(var1, var2);
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      return this.mAlert.onKeyUp(var1, var2)?true:super.onKeyUp(var1, var2);
   }

   public void setButton(int var1, CharSequence var2, OnClickListener var3) {
      this.mAlert.setButton(var1, var2, var3, (Message)null);
   }

   public void setButton(int var1, CharSequence var2, Message var3) {
      this.mAlert.setButton(var1, var2, (OnClickListener)null, var3);
   }

   void setButtonPanelLayoutHint(int var1) {
      this.mAlert.setButtonPanelLayoutHint(var1);
   }

   public void setCustomTitle(View var1) {
      this.mAlert.setCustomTitle(var1);
   }

   public void setIcon(int var1) {
      this.mAlert.setIcon(var1);
   }

   public void setIcon(Drawable var1) {
      this.mAlert.setIcon(var1);
   }

   public void setIconAttribute(int var1) {
      TypedValue var2 = new TypedValue();
      this.getContext().getTheme().resolveAttribute(var1, var2, true);
      this.mAlert.setIcon(var2.resourceId);
   }

   public void setMessage(CharSequence var1) {
      this.mAlert.setMessage(var1);
   }

   public void setTitle(CharSequence var1) {
      super.setTitle(var1);
      this.mAlert.setTitle(var1);
   }

   public void setView(View var1) {
      this.mAlert.setView(var1);
   }

   public void setView(View var1, int var2, int var3, int var4, int var5) {
      this.mAlert.setView(var1, var2, var3, var4, var5);
   }

   public static class Builder {
      // $FF: renamed from: P android.support.v7.app.AlertController$AlertParams
      private final AlertController.AlertParams field_546;
      private int mTheme;

      public Builder(Context var1) {
         this(var1, AlertDialog.resolveDialogTheme(var1, 0));
      }

      public Builder(Context var1, int var2) {
         this.field_546 = new AlertController.AlertParams(new ContextThemeWrapper(var1, AlertDialog.resolveDialogTheme(var1, var2)));
         this.mTheme = var2;
      }

      public AlertDialog create() {
         AlertDialog var1 = new AlertDialog(this.field_546.mContext, this.mTheme, false);
         this.field_546.apply(var1.mAlert);
         var1.setCancelable(this.field_546.mCancelable);
         if(this.field_546.mCancelable) {
            var1.setCanceledOnTouchOutside(true);
         }

         var1.setOnCancelListener(this.field_546.mOnCancelListener);
         var1.setOnDismissListener(this.field_546.mOnDismissListener);
         if(this.field_546.mOnKeyListener != null) {
            var1.setOnKeyListener(this.field_546.mOnKeyListener);
         }

         return var1;
      }

      public Context getContext() {
         return this.field_546.mContext;
      }

      public AlertDialog.Builder setAdapter(ListAdapter var1, OnClickListener var2) {
         this.field_546.mAdapter = var1;
         this.field_546.mOnClickListener = var2;
         return this;
      }

      public AlertDialog.Builder setCancelable(boolean var1) {
         this.field_546.mCancelable = var1;
         return this;
      }

      public AlertDialog.Builder setCursor(Cursor var1, OnClickListener var2, String var3) {
         this.field_546.mCursor = var1;
         this.field_546.mLabelColumn = var3;
         this.field_546.mOnClickListener = var2;
         return this;
      }

      public AlertDialog.Builder setCustomTitle(View var1) {
         this.field_546.mCustomTitleView = var1;
         return this;
      }

      public AlertDialog.Builder setIcon(int var1) {
         this.field_546.mIconId = var1;
         return this;
      }

      public AlertDialog.Builder setIcon(Drawable var1) {
         this.field_546.mIcon = var1;
         return this;
      }

      public AlertDialog.Builder setIconAttribute(int var1) {
         TypedValue var2 = new TypedValue();
         this.field_546.mContext.getTheme().resolveAttribute(var1, var2, true);
         this.field_546.mIconId = var2.resourceId;
         return this;
      }

      public AlertDialog.Builder setInverseBackgroundForced(boolean var1) {
         this.field_546.mForceInverseBackground = var1;
         return this;
      }

      public AlertDialog.Builder setItems(int var1, OnClickListener var2) {
         this.field_546.mItems = this.field_546.mContext.getResources().getTextArray(var1);
         this.field_546.mOnClickListener = var2;
         return this;
      }

      public AlertDialog.Builder setItems(CharSequence[] var1, OnClickListener var2) {
         this.field_546.mItems = var1;
         this.field_546.mOnClickListener = var2;
         return this;
      }

      public AlertDialog.Builder setMessage(int var1) {
         this.field_546.mMessage = this.field_546.mContext.getText(var1);
         return this;
      }

      public AlertDialog.Builder setMessage(CharSequence var1) {
         this.field_546.mMessage = var1;
         return this;
      }

      public AlertDialog.Builder setMultiChoiceItems(int var1, boolean[] var2, OnMultiChoiceClickListener var3) {
         this.field_546.mItems = this.field_546.mContext.getResources().getTextArray(var1);
         this.field_546.mOnCheckboxClickListener = var3;
         this.field_546.mCheckedItems = var2;
         this.field_546.mIsMultiChoice = true;
         return this;
      }

      public AlertDialog.Builder setMultiChoiceItems(Cursor var1, String var2, String var3, OnMultiChoiceClickListener var4) {
         this.field_546.mCursor = var1;
         this.field_546.mOnCheckboxClickListener = var4;
         this.field_546.mIsCheckedColumn = var2;
         this.field_546.mLabelColumn = var3;
         this.field_546.mIsMultiChoice = true;
         return this;
      }

      public AlertDialog.Builder setMultiChoiceItems(CharSequence[] var1, boolean[] var2, OnMultiChoiceClickListener var3) {
         this.field_546.mItems = var1;
         this.field_546.mOnCheckboxClickListener = var3;
         this.field_546.mCheckedItems = var2;
         this.field_546.mIsMultiChoice = true;
         return this;
      }

      public AlertDialog.Builder setNegativeButton(int var1, OnClickListener var2) {
         this.field_546.mNegativeButtonText = this.field_546.mContext.getText(var1);
         this.field_546.mNegativeButtonListener = var2;
         return this;
      }

      public AlertDialog.Builder setNegativeButton(CharSequence var1, OnClickListener var2) {
         this.field_546.mNegativeButtonText = var1;
         this.field_546.mNegativeButtonListener = var2;
         return this;
      }

      public AlertDialog.Builder setNeutralButton(int var1, OnClickListener var2) {
         this.field_546.mNeutralButtonText = this.field_546.mContext.getText(var1);
         this.field_546.mNeutralButtonListener = var2;
         return this;
      }

      public AlertDialog.Builder setNeutralButton(CharSequence var1, OnClickListener var2) {
         this.field_546.mNeutralButtonText = var1;
         this.field_546.mNeutralButtonListener = var2;
         return this;
      }

      public AlertDialog.Builder setOnCancelListener(OnCancelListener var1) {
         this.field_546.mOnCancelListener = var1;
         return this;
      }

      public AlertDialog.Builder setOnDismissListener(OnDismissListener var1) {
         this.field_546.mOnDismissListener = var1;
         return this;
      }

      public AlertDialog.Builder setOnItemSelectedListener(OnItemSelectedListener var1) {
         this.field_546.mOnItemSelectedListener = var1;
         return this;
      }

      public AlertDialog.Builder setOnKeyListener(OnKeyListener var1) {
         this.field_546.mOnKeyListener = var1;
         return this;
      }

      public AlertDialog.Builder setPositiveButton(int var1, OnClickListener var2) {
         this.field_546.mPositiveButtonText = this.field_546.mContext.getText(var1);
         this.field_546.mPositiveButtonListener = var2;
         return this;
      }

      public AlertDialog.Builder setPositiveButton(CharSequence var1, OnClickListener var2) {
         this.field_546.mPositiveButtonText = var1;
         this.field_546.mPositiveButtonListener = var2;
         return this;
      }

      public AlertDialog.Builder setRecycleOnMeasureEnabled(boolean var1) {
         this.field_546.mRecycleOnMeasure = var1;
         return this;
      }

      public AlertDialog.Builder setSingleChoiceItems(int var1, int var2, OnClickListener var3) {
         this.field_546.mItems = this.field_546.mContext.getResources().getTextArray(var1);
         this.field_546.mOnClickListener = var3;
         this.field_546.mCheckedItem = var2;
         this.field_546.mIsSingleChoice = true;
         return this;
      }

      public AlertDialog.Builder setSingleChoiceItems(Cursor var1, int var2, String var3, OnClickListener var4) {
         this.field_546.mCursor = var1;
         this.field_546.mOnClickListener = var4;
         this.field_546.mCheckedItem = var2;
         this.field_546.mLabelColumn = var3;
         this.field_546.mIsSingleChoice = true;
         return this;
      }

      public AlertDialog.Builder setSingleChoiceItems(ListAdapter var1, int var2, OnClickListener var3) {
         this.field_546.mAdapter = var1;
         this.field_546.mOnClickListener = var3;
         this.field_546.mCheckedItem = var2;
         this.field_546.mIsSingleChoice = true;
         return this;
      }

      public AlertDialog.Builder setSingleChoiceItems(CharSequence[] var1, int var2, OnClickListener var3) {
         this.field_546.mItems = var1;
         this.field_546.mOnClickListener = var3;
         this.field_546.mCheckedItem = var2;
         this.field_546.mIsSingleChoice = true;
         return this;
      }

      public AlertDialog.Builder setTitle(int var1) {
         this.field_546.mTitle = this.field_546.mContext.getText(var1);
         return this;
      }

      public AlertDialog.Builder setTitle(CharSequence var1) {
         this.field_546.mTitle = var1;
         return this;
      }

      public AlertDialog.Builder setView(int var1) {
         this.field_546.mView = null;
         this.field_546.mViewLayoutResId = var1;
         this.field_546.mViewSpacingSpecified = false;
         return this;
      }

      public AlertDialog.Builder setView(View var1) {
         this.field_546.mView = var1;
         this.field_546.mViewLayoutResId = 0;
         this.field_546.mViewSpacingSpecified = false;
         return this;
      }

      public AlertDialog.Builder setView(View var1, int var2, int var3, int var4, int var5) {
         this.field_546.mView = var1;
         this.field_546.mViewLayoutResId = 0;
         this.field_546.mViewSpacingSpecified = true;
         this.field_546.mViewSpacingLeft = var2;
         this.field_546.mViewSpacingTop = var3;
         this.field_546.mViewSpacingRight = var4;
         this.field_546.mViewSpacingBottom = var5;
         return this;
      }

      public AlertDialog show() {
         AlertDialog var1 = this.create();
         var1.show();
         return var1;
      }
   }
}
