package com.goodrx.widget.MyRx;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.goodrx.class_3;
import com.goodrx.utils.DialogHelper;
import com.goodrx.widget.MyRx.RxEditOption;

public class RxEditTextInput extends RxEditOption implements OnClickListener {
   private String content;
   private int inputType;

   public RxEditTextInput(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.setOnClickListener(this);
   }

   public void onClick(View var1) {
      View var2 = View.inflate(var1.getContext(), 2130968670, (ViewGroup)null);
      final EditText var3 = (EditText)var2.findViewById(2131886422);
      var3.setInputType(this.inputType);
      if(this.content != null) {
         var3.setText(this.content);
         var3.setSelection(this.content.length());
      }

      AlertDialog.Builder var4 = new AlertDialog.Builder(var1.getContext());
      var4.setTitle(this.getText1());
      var4.setView(var2);
      var4.setNegativeButton(2131427459, (android.content.DialogInterface.OnClickListener)null);
      var4.setPositiveButton(2131427709, new android.content.DialogInterface.OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            String var3x = var3.getText().toString();
            if(var3x.length() == 0) {
               var3x = "------";
               RxEditTextInput.this.content = null;
            } else {
               RxEditTextInput.this.content = var3x;
            }

            RxEditTextInput.this.setText2(var3x);
         }
      });
      DialogHelper.showDialog(var4);
   }

   public void setAttrs(Context var1, AttributeSet var2) {
      super.setAttrs(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.RxEditTextInput);
      this.inputType = var3.getInt(0, 1);
      var3.recycle();
   }
}
