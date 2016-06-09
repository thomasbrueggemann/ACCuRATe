package com.peirr.blooadapp.activities;

import android.content.Context;
import com.peirr.blooadapp.wizard.model.AbstractWizardModel;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.PageList;
import com.peirr.blooadapp.wizard.model.patient.PatientAgeGenderPage;
import com.peirr.blooadapp.wizard.model.patient.PatientCalculationsPage;
import com.peirr.blooadapp.wizard.model.patient.PatientHeightWeightPage;
import com.peirr.blooadapp.wizard.model.patient.PatientOperationPage;

public class PatientWizardmodel extends AbstractWizardModel {
   public PatientWizardmodel(Context var1) {
      super(var1);
   }

   protected PageList onNewRootPageList() {
      Page[] var1 = new Page[]{(new PatientOperationPage(this, "Patient Operation")).setRequired(true), (new PatientAgeGenderPage(this, "Patient")).setRequired(true), (new PatientHeightWeightPage(this, "Patient Measurements")).setRequired(true), (new PatientCalculationsPage(this, "Patient Details")).setRequired(true)};
      return new PageList(var1);
   }
}
