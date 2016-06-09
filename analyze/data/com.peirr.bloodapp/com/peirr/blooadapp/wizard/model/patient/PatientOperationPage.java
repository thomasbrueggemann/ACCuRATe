package com.peirr.blooadapp.wizard.model.patient;

import android.app.Fragment;
import android.text.TextUtils;
import com.peirr.blooadapp.fragments.patient.PatientOperationFragment;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import java.util.ArrayList;

public class PatientOperationPage extends Page {
   public static final String CARDIAC_DATA_KEY = "cardiac";
   public static final String OPERATION_DATA_KEY = "operation";

   public PatientOperationPage(ModelCallbacks var1, String var2) {
      super(var1, var2);
   }

   public Fragment createFragment() {
      return PatientOperationFragment.create(this.getKey());
   }

   public void getReviewItems(ArrayList<ReviewItem> var1) {
      var1.add(new ReviewItem("operation", "Patient Operation", this.mData.getString("operation"), this.getKey(), -1));
      var1.add(new ReviewItem("cardiac", "Cardiac", this.mData.getString("cardiac"), this.getKey(), -1));
   }

   public boolean isCompleted() {
      return !TextUtils.isEmpty(this.mData.getString("operation"));
   }
}
