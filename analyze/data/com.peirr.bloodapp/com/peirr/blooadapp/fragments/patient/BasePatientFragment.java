package com.peirr.blooadapp.fragments.patient;

import android.app.Fragment;
import android.view.View;
import android.widget.Switch;
import com.peirr.blooadapp.io.ViewUtil;
import com.peirr.blooadapp.wizard.model.Page;

public abstract class BasePatientFragment extends Fragment {
   protected String gender;

   public abstract Page getPage();

   public abstract View getRootView();

   public abstract Switch getSwitch();

   public void init() {
      if(this.getPage() != null) {
         this.gender = this.getPage().getData().getString("gender");
      }

   }

   public void setUserVisibleHint(boolean var1) {
      if(this.getRootView() != null && var1) {
         ViewUtil.changeBackGround(this.getActivity(), this.getRootView(), this.getSwitch(), this.gender);
      }

   }
}
