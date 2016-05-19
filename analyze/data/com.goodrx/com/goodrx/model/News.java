package com.goodrx.model;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;

public class News {
   private String author;
   private String content;
   private String contentSnippet;
   private String publishedDate;
   private boolean selected;
   private String title;

   public String getAuthor() {
      return this.author;
   }

   public String getContent() {
      return this.content;
   }

   public String getContentSnippet() {
      return this.contentSnippet;
   }

   public String getPublishedDate() {
      try {
         String var2 = this.publishedDate;
         if(var2.contains("T")) {
            var2 = var2.replace("T", " ");
         }

         DateTime var3 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime(var2);
         String var4 = DateTimeFormat.forPattern("MMMM dd, yyyy-hh:mm aa").print((ReadableInstant)var3).replace("-", " at ");
         return var4;
      } catch (Exception var5) {
         return this.publishedDate;
      }
   }

   public String getTitle() {
      return this.title;
   }

   public boolean isSelected() {
      return this.selected;
   }

   public void setSelected(boolean var1) {
      this.selected = var1;
   }
}
