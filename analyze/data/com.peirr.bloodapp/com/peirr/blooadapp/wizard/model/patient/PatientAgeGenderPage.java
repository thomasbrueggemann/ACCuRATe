package com.peirr.blooadapp.wizard.model.patient;

import android.app.Fragment;
import android.text.TextUtils;
import com.peirr.blooadapp.fragments.patient.PatientAgeGenderFragment;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import java.util.ArrayList;

public class PatientAgeGenderPage extends Page {
   public static final String AGE_DATA_KEY = "age";
   public static final String GENDER_DATA_KEY = "gender";

   public PatientAgeGenderPage(ModelCallbacks var1, String var2) {
      super(var1, var2);
   }

   public Fragment createFragment() {
      return PatientAgeGenderFragment.create(this.getKey());
   }

   public void getReviewItems(ArrayList<ReviewItem> var1) {
      var1.add(new ReviewItem("age", "Age", this.mData.getString("age"), this.getKey(), -1));
      var1.add(new ReviewItem("gender", "Gender", this.mData.getString("gender"), this.getKey(), -1));
   }

   public boolean isCompleted() {
      return !TextUtils.isEmpty(this.mData.getString("age"));
   }
}
