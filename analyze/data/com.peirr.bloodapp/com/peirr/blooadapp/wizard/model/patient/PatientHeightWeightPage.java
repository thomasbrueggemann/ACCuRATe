package com.peirr.blooadapp.wizard.model.patient;

import android.app.Fragment;
import android.text.TextUtils;
import com.peirr.blooadapp.fragments.patient.PatientHeightWeightFragment;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import java.util.ArrayList;

public class PatientHeightWeightPage extends Page {
   public static final String HEIGHT_DATA_KEY = "height";
   public static final String WEIGHT_DATA_KEY = "weight";

   public PatientHeightWeightPage(ModelCallbacks var1, String var2) {
      super(var1, var2);
   }

   public Fragment createFragment() {
      return PatientHeightWeightFragment.create(this.getKey());
   }

   public void getReviewItems(ArrayList<ReviewItem> var1) {
      var1.add(new ReviewItem("height", "Patient Height", this.mData.getString("height"), this.getKey(), -1));
      var1.add(new ReviewItem("weight", "Patient Weight", this.mData.getString("weight"), this.getKey(), -1));
   }

   public boolean isCompleted() {
      return !TextUtils.isEmpty(this.mData.getString("height")) && !TextUtils.isEmpty(this.mData.getString("weight"));
   }
}
