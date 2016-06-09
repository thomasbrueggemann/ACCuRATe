package com.goodrx.model;

import com.goodrx.model.Dosage;
import com.goodrx.model.Form;
import org.json.JSONException;
import org.json.JSONObject;

public class SelectedDrug {
   private Dosage dosage;
   private String drugId;
   private Form form;
   private String formPlural;
   private String formSingular;
   private String label;
   private String nameDisplay;
   private int quantity;
   private String slug;

   public SelectedDrug(JSONObject var1) throws JSONException {
      this.dosage = new Dosage(var1.getString("selected_dosage"), var1.getString("selected_dosage_slug"));
      this.form = new Form(var1.getString("selected_form"), var1.getString("selected_form_slug"));
      this.nameDisplay = var1.getString("selected_drug");
      this.slug = var1.getString("selected_drug_slug");
      this.drugId = var1.getString("selected_drug_id");
      this.label = var1.getString("selected_drug_label");
      this.formPlural = var1.getString("selected_form_plural");
      this.formSingular = var1.getString("selected_form_singular");
      this.quantity = var1.getInt("selected_quantity");
   }

   public boolean equals(Object var1) {
      if(var1 instanceof SelectedDrug) {
         SelectedDrug var2 = (SelectedDrug)var1;
         if(var2.getSlug().equals(this.slug) && var2.getForm().equals(this.form) && var2.getDosage().equals(this.dosage) && var2.getQuantity() == this.quantity) {
            return true;
         }
      }

      return false;
   }

   public Dosage getDosage() {
      return this.dosage;
   }

   public String getDrugId() {
      return this.drugId;
   }

   public Form getForm() {
      return this.form;
   }

   public String getFormPlural() {
      return this.formPlural;
   }

   public String getFormSingular() {
      return this.formSingular;
   }

   public String getLabel() {
      return this.label;
   }

   public String getNameDisplay() {
      return this.nameDisplay;
   }

   public int getQuantity() {
      return this.quantity;
   }

   public String getSlug() {
      return this.slug;
   }

   public void setDosage(Dosage var1) {
      this.dosage = var1;
   }

   public void setForm(Form var1) {
      this.form = var1;
   }

   public void setQuantity(int var1) {
      this.quantity = var1;
   }

   public void setSlug(String var1) {
      this.slug = var1;
   }
}
