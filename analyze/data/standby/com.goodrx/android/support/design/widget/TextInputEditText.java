package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public class TextInputEditText extends AppCompatEditText {
   public TextInputEditText(Context var1) {
      super(var1);
   }

   public TextInputEditText(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public TextInputEditText(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public InputConnection onCreateInputConnection(EditorInfo var1) {
      InputConnection var2 = super.onCreateInputConnection(var1);
      if(var2 != null && var1.hintText == null) {
         ViewParent var3 = this.getParent();
         if(var3 instanceof TextInputLayout) {
            var1.hintText = ((TextInputLayout)var3).getHint();
         }
      }

      return var2;
   }
}
