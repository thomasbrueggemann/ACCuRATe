package org.droidparts.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import org.droidparts.adapter.widget.TextWatcherAdapter;
import org.droidparts.adapter.widget.TextWatcherAdapter$TextWatcherListener;
import org.droidparts.util.Strings;
import org.droidparts.widget.ClearableEditText.Listener;

public class ClearableEditText extends EditText implements OnFocusChangeListener, OnTouchListener, TextWatcherAdapter$TextWatcherListener {
   // $FF: renamed from: f android.view.View.OnFocusChangeListener
   private OnFocusChangeListener field_616;
   // $FF: renamed from: l android.view.View.OnTouchListener
   private OnTouchListener field_617;
   private Listener listener;
   // $FF: renamed from: xD android.graphics.drawable.Drawable
   private Drawable field_618;

   public ClearableEditText(Context var1) {
      super(var1);
      this.init();
   }

   public ClearableEditText(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init();
   }

   public ClearableEditText(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init();
   }

   private void init() {
      this.field_618 = this.getCompoundDrawables()[2];
      if(this.field_618 == null) {
         this.field_618 = this.getResources().getDrawable(17301610);
      }

      this.field_618.setBounds(0, 0, this.field_618.getIntrinsicWidth(), this.field_618.getIntrinsicHeight());
      this.setClearIconVisible(false);
      super.setOnTouchListener(this);
      super.setOnFocusChangeListener(this);
      this.addTextChangedListener(new TextWatcherAdapter(this, this));
   }

   public void onFocusChange(View var1, boolean var2) {
      if(var2) {
         this.setClearIconVisible(Strings.isNotEmpty(this.getText()));
      } else {
         this.setClearIconVisible(false);
      }

      if(this.field_616 != null) {
         this.field_616.onFocusChange(var1, var2);
      }

   }

   public void onTextChanged(EditText var1, String var2) {
      if(this.isFocused()) {
         this.setClearIconVisible(Strings.isNotEmpty(var2));
      }

   }

   public boolean onTouch(View var1, MotionEvent var2) {
      if(this.getCompoundDrawables()[2] != null) {
         boolean var3;
         if(var2.getX() > (float)(this.getWidth() - this.getPaddingRight() - this.field_618.getIntrinsicWidth())) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3) {
            if(var2.getAction() == 1) {
               this.setText("");
               if(this.listener != null) {
                  this.listener.didClearText();
               }
            }

            return true;
         }
      }

      return this.field_617 != null?this.field_617.onTouch(var1, var2):false;
   }

   protected void setClearIconVisible(boolean var1) {
      Drawable var2;
      if(var1) {
         var2 = this.field_618;
      } else {
         var2 = null;
      }

      this.setCompoundDrawables(this.getCompoundDrawables()[0], this.getCompoundDrawables()[1], var2, this.getCompoundDrawables()[3]);
   }

   public void setListener(Listener var1) {
      this.listener = var1;
   }

   public void setOnFocusChangeListener(OnFocusChangeListener var1) {
      this.field_616 = var1;
   }

   public void setOnTouchListener(OnTouchListener var1) {
      this.field_617 = var1;
   }
}
