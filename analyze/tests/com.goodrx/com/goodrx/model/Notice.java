package com.goodrx.model;

public class Notice {
   String icon;
   String link;
   String link_text;
   String long_description;
   String name;
   String short_description;
   String slug;
   String tip_category;
   String tip_type;
   String title;

   public String getIcon() {
      return this.icon;
   }

   public String getLink() {
      if(this.link != null && !this.link.startsWith("http")) {
         this.link = "https:" + this.link;
      }

      return this.link;
   }

   public String getLink_text() {
      return this.link_text;
   }

   public String getLong_description() {
      return this.long_description;
   }

   public String getName() {
      return this.name;
   }

   public String getShort_description() {
      return this.short_description;
   }

   public String getSlug() {
      return this.slug;
   }

   public String getTip_category() {
      return this.tip_category;
   }

   public String getTip_type() {
      return this.tip_type;
   }

   public String getTitle() {
      return this.title;
   }
}
