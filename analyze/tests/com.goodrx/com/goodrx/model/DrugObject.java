package com.goodrx.model;

import com.goodrx.model.DrugInformation;
import com.goodrx.utils.ArrayUtils;

public class DrugObject {
   String display;
   String dosage;
   String dosage_display;
   String dosage_form_display;
   String dosage_form_display_short;
   DrugInformation drug_information;
   String drug_market_type;
   String drug_page_type;
   String drug_slug;
   String form;
   String form_display;
   String form_plural;
   // $FF: renamed from: id java.lang.String
   String field_465;
   boolean is_default;
   String name;
   int quantity;
   String type;

   public String getDisplay() {
      return this.display;
   }

   public String getDosage() {
      return this.dosage;
   }

   public String getDosage_display() {
      return this.dosage_display;
   }

   public String getDosage_form_display() {
      return this.dosage_form_display;
   }

   public String getDosage_form_display_short() {
      return this.dosage_form_display_short;
   }

   public String getDrugInfo() {
      return this.getDisplay() + " " + this.getDosage_form_display_short();
   }

   public DrugInformation getDrug_information() {
      return this.drug_information;
   }

   public String getDrug_market_type() {
      return this.drug_market_type;
   }

   public String getDrug_page_type() {
      return this.drug_page_type;
   }

   public String getDrug_slug() {
      return this.drug_slug;
   }

   public String getForm() {
      return this.form;
   }

   public String getForm_display() {
      return this.form_display;
   }

   public String getForm_plural() {
      return this.form_plural;
   }

   public String getId() {
      return this.field_465;
   }

   public String getName() {
      return this.name;
   }

   public int getQuantity() {
      return this.quantity;
   }

   public String getType() {
      return this.type;
   }

   public boolean isAddable() {
      String[] var1 = new String[]{"discontinued", "pre-market", "hcp-administered"};
      String[] var2 = new String[]{"otc", "pet"};
      return !ArrayUtils.contains(var1, this.drug_market_type) && !ArrayUtils.contains(var2, this.drug_page_type);
   }

   public boolean isIs_default() {
      return this.is_default;
   }
}
