package com.robotium.solo;

import java.util.Hashtable;

public class WebElement {
   private Hashtable<String, String> attributes;
   private String className;
   // $FF: renamed from: id java.lang.String
   private String field_10;
   private int locationX = 0;
   private int locationY = 0;
   private String name;
   private String tagName;
   private String text;

   public WebElement(String var1, String var2, String var3, String var4, String var5, Hashtable<String, String> var6) {
      this.setId(var1);
      this.setTextContent(var2);
      this.setName(var3);
      this.setClassName(var4);
      this.setTagName(var5);
      this.setAttributes(var6);
   }

   public String getAttribute(String var1) {
      return var1 != null?(String)this.attributes.get(var1):null;
   }

   public String getClassName() {
      return this.className;
   }

   public String getId() {
      return this.field_10;
   }

   public void getLocationOnScreen(int[] var1) {
      var1[0] = this.locationX;
      var1[1] = this.locationY;
   }

   public int getLocationX() {
      return this.locationX;
   }

   public int getLocationY() {
      return this.locationY;
   }

   public String getName() {
      return this.name;
   }

   public String getTagName() {
      return this.tagName;
   }

   public String getText() {
      return this.text;
   }

   public void setAttributes(Hashtable<String, String> var1) {
      this.attributes = var1;
   }

   public void setClassName(String var1) {
      this.className = var1;
   }

   public void setId(String var1) {
      this.field_10 = var1;
   }

   public void setLocationX(int var1) {
      this.locationX = var1;
   }

   public void setLocationY(int var1) {
      this.locationY = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setTagName(String var1) {
      this.tagName = var1;
   }

   public void setTextContent(String var1) {
      this.text = var1;
   }
}
