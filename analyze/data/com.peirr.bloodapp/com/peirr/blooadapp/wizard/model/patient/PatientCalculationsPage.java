package com.peirr.blooadapp.wizard.model.patient;

import android.app.Fragment;
import android.text.TextUtils;
import com.peirr.blooadapp.fragments.patient.PatientCalculationsFragment;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import java.util.ArrayList;

public class PatientCalculationsPage extends Page {
   public static final String ANAESTHETIC_FLUID_DATA_KEY = "fluid_prebypass";
   public static final String FIRST_PASS_BLOOD_DATA_KEY = "first_pass_removed";
   public static final String HAEMOGLOBIN_LEVEL_DATA_KEY = "preop_lab_level";
   public static final String PRIME_VOLUME_DATA_KEY = "prime_volume";
   public static final String RBC_DATA_KEY = "rbc_required";
   public static final String REQUIRED_DATA_KEY = "required_hb";
   public static final String URINE_OUTPUT_DATA_KEY = "urine_prebypass";

   public PatientCalculationsPage(ModelCallbacks var1, String var2) {
      super(var1, var2);
   }

   public Fragment createFragment() {
      return PatientCalculationsFragment.create(this.getKey());
   }

   public void getReviewItems(ArrayList<ReviewItem> var1) {
      var1.add(new ReviewItem("preop_lab_level", "Preop Laboratory Haemoglobin Level (g/dl)", this.mData.getString("preop_lab_level"), this.getKey(), -1));
      var1.add(new ReviewItem("first_pass_removed", "First Pass Blood Removed on Pump  (Litres)", this.mData.getString("first_pass_removed"), this.getKey(), -1));
      var1.add(new ReviewItem("prime_volume", "Prime Volume of bypass circuit (Litres)", this.mData.getString("prime_volume"), this.getKey(), -1));
      var1.add(new ReviewItem("fluid_prebypass", "Anaesthetic Fluid during prebypass period (Litres)", this.mData.getString("fluid_prebypass"), this.getKey(), -1));
      var1.add(new ReviewItem("urine_prebypass", "Urine Output during prebypass period (Litres)", this.mData.getString("urine_prebypass"), this.getKey(), -1));
      var1.add(new ReviewItem("rbc_required", "Red Blood Cells", this.mData.getString("rbc_required"), this.getKey(), -1));
      var1.add(new ReviewItem("required_hb", "Required Hb on Pump", this.mData.getString("required_hb"), this.getKey(), -1));
   }

   public boolean isCompleted() {
      return !TextUtils.isEmpty(this.mData.getString("preop_lab_level")) && !TextUtils.isEmpty(this.mData.getString("first_pass_removed"));
   }
}
