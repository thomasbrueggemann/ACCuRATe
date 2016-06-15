package com.strategeens.drugnotes.model;

public class Drug {
   public String _date;
   public int _id;
   public String _name;
   public String _note;

   public Drug() {
   }

   public Drug(int var1, String var2, String var3, String var4) {
      this._id = var1;
      this._name = var2;
      this._note = var3;
      this._date = var4;
   }

   public Drug(String var1, String var2, String var3) {
      this._name = var1;
      this._note = var2;
      this._date = var3;
   }

   public String getDate() {
      return this._date;
   }

   public int getID() {
      return this._id;
   }

   public String getName() {
      return this._name;
   }

   public String getNote() {
      return this._note;
   }

   public void setDate(String var1) {
      this._date = var1;
   }

   public void setID(int var1) {
      this._id = var1;
   }

   public void setName(String var1) {
      this._name = var1;
   }

   public void setNote(String var1) {
      this._note = var1;
   }
}
