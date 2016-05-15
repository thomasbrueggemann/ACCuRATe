package com.goodrx.model;

import com.goodrx.model.Condition;

public class DrugInformation {
   String default_image;
   String disclaimer;
   Condition[] drug_conditions;
   boolean education_available;
   int image_count;
   String information;
   int news_count;
   int tip_count;

   public String getDefault_image() {
      return this.default_image;
   }

   public String getDisclaimer() {
      return this.disclaimer;
   }

   public Condition[] getDrug_conditions() {
      return this.drug_conditions;
   }

   public int getImage_count() {
      return this.image_count;
   }

   public String getInformation() {
      return this.information;
   }

   public int getNews_count() {
      return this.news_count;
   }

   public int getTip_count() {
      return this.tip_count;
   }

   public boolean isEducation_available() {
      return this.education_available;
   }
}
