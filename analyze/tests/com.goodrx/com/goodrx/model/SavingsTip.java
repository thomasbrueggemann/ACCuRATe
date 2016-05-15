package com.goodrx.model;

public class SavingsTip {
   boolean highlight;
   String icon;
   String link;
   String link_text;
   String long_description;
   String short_description;
   String slug;
   String tip_type;
   String title;

   public String getIconFullUrl() {
      return this.icon == null?"":(!this.icon.startsWith("http")?"https:" + this.icon:this.icon);
   }

   public String getLink() {
      return this.link;
   }

   public String getLink_text() {
      return this.link_text;
   }

   public String getLong_description() {
      return this.long_description;
   }

   public String getShort_description() {
      return this.short_description;
   }

   public String getSlug() {
      return this.slug;
   }

   public String getTip_type() {
      return this.tip_type;
   }

   public String getTitle() {
      return this.title;
   }

   public boolean isHighlight() {
      return this.highlight;
   }

   public void setHighlight(boolean var1) {
      this.highlight = var1;
   }
}
