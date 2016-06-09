package com.robotium.solo;

// $FF: renamed from: com.robotium.solo.By
public abstract class class_0 {
   public static class_0 className(String var0) {
      return new class_0.ClassName(var0);
   }

   public static class_0 cssSelector(String var0) {
      return new class_0.CssSelector(var0);
   }

   // $FF: renamed from: id (java.lang.String) com.robotium.solo.By
   public static class_0 method_3(String var0) {
      return new class_0.class_2(var0);
   }

   public static class_0 name(String var0) {
      return new class_0.Name(var0);
   }

   public static class_0 tagName(String var0) {
      return new class_0.TagName(var0);
   }

   public static class_0 textContent(String var0) {
      return new class_0.Text(var0);
   }

   public static class_0 xpath(String var0) {
      return new class_0.Xpath(var0);
   }

   public String getValue() {
      return "";
   }

   static class ClassName extends class_0 {
      private final String className;

      public ClassName(String var1) {
         this.className = var1;
      }

      public String getValue() {
         return this.className;
      }
   }

   static class CssSelector extends class_0 {
      private final String selector;

      public CssSelector(String var1) {
         this.selector = var1;
      }

      public String getValue() {
         return this.selector;
      }
   }

   static class class_2 extends class_0 {
      // $FF: renamed from: id java.lang.String
      private final String field_3;

      public class_2(String var1) {
         this.field_3 = var1;
      }

      public String getValue() {
         return this.field_3;
      }
   }

   static class Name extends class_0 {
      private final String name;

      public Name(String var1) {
         this.name = var1;
      }

      public String getValue() {
         return this.name;
      }
   }

   static class TagName extends class_0 {
      private final String tagName;

      public TagName(String var1) {
         this.tagName = var1;
      }

      public String getValue() {
         return this.tagName;
      }
   }

   static class Text extends class_0 {
      private final String textContent;

      public Text(String var1) {
         this.textContent = var1;
      }

      public String getValue() {
         return this.textContent;
      }
   }

   static class Xpath extends class_0 {
      private final String xpath;

      public Xpath(String var1) {
         this.xpath = var1;
      }

      public String getValue() {
         return this.xpath;
      }
   }
}
