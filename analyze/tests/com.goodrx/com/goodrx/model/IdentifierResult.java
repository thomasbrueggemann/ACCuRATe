package com.goodrx.model;

import com.goodrx.model.DrugObject;
import com.goodrx.model.Pill;

public class IdentifierResult {
   private DrugObject drug_object;
   private Pill[] pills;

   public DrugObject getDrug_object() {
      return this.drug_object;
   }

   public Pill[] getPills() {
      return this.pills;
   }
}
