package com.goodrx.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import com.goodrx.activity.CreateAccountActivity;
import org.droidparts.widget.ClearableEditText;

public class CreateAccountActivity$$ViewBinder<T extends CreateAccountActivity> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      View var4 = (View)var1.findRequiredView(var3, 2131886267, "field \'etxtEmail\' and method \'onTextChanged\'");
      var2.etxtEmail = (ClearableEditText)var1.castView(var4, 2131886267, "field \'etxtEmail\'");
      ((TextView)var4).addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable var1) {
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3, int var4) {
            var2.onTextChanged(var1);
         }
      });
      View var5 = (View)var1.findRequiredView(var3, 2131886268, "field \'etxtPasswd\' and method \'onTextChanged\'");
      var2.etxtPasswd = (ClearableEditText)var1.castView(var5, 2131886268, "field \'etxtPasswd\'");
      ((TextView)var5).addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable var1) {
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3, int var4) {
            var2.onTextChanged(var1);
         }
      });
      View var6 = (View)var1.findRequiredView(var3, 2131886270, "field \'btnCreate\' and method \'onClicked\'");
      var2.btnCreate = (Button)var1.castView(var6, 2131886270, "field \'btnCreate\'");
      var6.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClicked(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886269, "method \'onClicked\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClicked(var1);
         }
      });
   }

   public void unbind(T var1) {
      var1.etxtEmail = null;
      var1.etxtPasswd = null;
      var1.btnCreate = null;
   }
}
