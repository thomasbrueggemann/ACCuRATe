package com.peirr.blooadapp.wizard.model.doctor;

import android.app.Fragment;
import android.text.TextUtils;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import com.peirr.blooadapp.wizard.ui.DoctorInfoFragment;
import java.util.ArrayList;

public class DoctorInfoPage extends Page {
   public static final String EMAIL_DATA_KEY = "email";
   public static final String NAME_DATA_KEY = "name";
   public static final String PASSWORD_DATA_KEY = "password";

   public DoctorInfoPage(ModelCallbacks var1, String var2) {
      super(var1, var2);
   }

   public Fragment createFragment() {
      return DoctorInfoFragment.create(this.getKey());
   }

   public void getReviewItems(ArrayList<ReviewItem> var1) {
      var1.add(new ReviewItem("Your name", this.mData.getString("name"), this.getKey(), -1));
      var1.add(new ReviewItem("Your email", this.mData.getString("email"), this.getKey(), -1));
      var1.add(new ReviewItem("Your password", this.mData.getString("password"), this.getKey(), -1));
   }

   public boolean isCompleted() {
      return !TextUtils.isEmpty(this.mData.getString("name")) && !TextUtils.isEmpty(this.mData.getString("email")) && !TextUtils.isEmpty(this.mData.getString("password"));
   }
}
