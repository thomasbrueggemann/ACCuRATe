package android.support.design.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
   public Dialog onCreateDialog(Bundle var1) {
      return new BottomSheetDialog(this.getActivity(), this.getTheme());
   }

   public void setupDialog(Dialog var1, int var2) {
      if(var1 instanceof BottomSheetDialog) {
         ((BottomSheetDialog)var1).supportRequestWindowFeature(1);
      } else {
         super.setupDialog(var1, var2);
      }
   }
}
