package com.goodrx.model;

import com.goodrx.model.Brand;
import com.goodrx.model.Dosage;
import com.goodrx.model.Form;
import com.goodrx.model.Generic;
import com.goodrx.model.SelectedDrug;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DrugDetail {
   private Brand[] brands;
   private Dosage[] dosages;
   private String drug_page_type;
   private Form[] forms;
   private Generic[] generics;
   private int[] quantities;
   private SelectedDrug selectedDrug;

   public DrugDetail(JSONObject var1) throws JSONException {
      JSONArray var2 = var1.getJSONArray("brand");
      this.brands = new Brand[var2.length()];

      for(int var3 = 0; var3 < this.brands.length; ++var3) {
         JSONArray var15 = var2.getJSONArray(var3);
         this.brands[var3] = new Brand(var15.getString(0), var15.getString(1));
      }

      JSONArray var4 = var1.getJSONArray("dosages");
      this.dosages = new Dosage[var4.length()];

      for(int var5 = 0; var5 < this.dosages.length; ++var5) {
         JSONArray var14 = var4.getJSONArray(var5);
         this.dosages[var5] = new Dosage(var14.getString(0), var14.getString(1));
      }

      JSONArray var6 = var1.getJSONArray("forms");
      this.forms = new Form[var6.length()];

      for(int var7 = 0; var7 < this.forms.length; ++var7) {
         JSONArray var13 = var6.getJSONArray(var7);
         this.forms[var7] = new Form(var13.getString(0), var13.getString(1));
      }

      JSONArray var8 = var1.getJSONArray("generic");
      this.generics = new Generic[var8.length()];

      for(int var9 = 0; var9 < this.generics.length; ++var9) {
         JSONArray var12 = var8.getJSONArray(var9);
         this.generics[var9] = new Generic(var12.getString(0), var12.getString(1));
      }

      JSONArray var10 = var1.getJSONArray("quantities");
      this.quantities = new int[var10.length()];

      for(int var11 = 0; var11 < this.quantities.length; ++var11) {
         this.quantities[var11] = var10.getInt(var11);
      }

      this.selectedDrug = new SelectedDrug(var1);
      this.drug_page_type = var1.getString("drug_page_type");
   }

   public Brand[] getBrands() {
      return this.brands;
   }

   public Dosage[] getDosages() {
      return this.dosages;
   }

   public Form[] getForms() {
      return this.forms;
   }

   public Generic[] getGenerics() {
      return this.generics;
   }

   public int[] getQuantities() {
      return this.quantities;
   }

   public SelectedDrug getSelectedDrug() {
      return this.selectedDrug;
   }

   public String getSelectedDrugLongName() {
      String var1 = this.selectedDrug.getSlug();
      Brand[] var2 = this.brands;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if(var2[var4].getSlug().equals(var1)) {
            return this.selectedDrug.getNameDisplay() + " (brand)";
         }
      }

      return this.selectedDrug.getNameDisplay() + " (generic)";
   }

   public void setQuantities(int[] var1) {
      this.quantities = var1;
   }
}
