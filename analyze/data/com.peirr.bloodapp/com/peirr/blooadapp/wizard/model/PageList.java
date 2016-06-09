package com.peirr.blooadapp.wizard.model;

import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.PageTreeNode;
import java.util.ArrayList;
import java.util.Iterator;

public class PageList extends ArrayList<Page> implements PageTreeNode {
   public PageList(Page... var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         this.add(var1[var3]);
      }

   }

   public Page findByKey(String var1) {
      Iterator var2 = this.iterator();

      Page var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = ((Page)var2.next()).findByKey(var1);
      } while(var3 == null);

      return var3;
   }

   public void flattenCurrentPageSequence(ArrayList<Page> var1) {
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         ((Page)var2.next()).flattenCurrentPageSequence(var1);
      }

   }
}
