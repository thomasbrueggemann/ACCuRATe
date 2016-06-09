package com.peirr.blooadapp.wizard.model;

import com.peirr.blooadapp.wizard.model.Page;
import java.util.ArrayList;

public interface PageTreeNode {
   Page findByKey(String var1);

   void flattenCurrentPageSequence(ArrayList<Page> var1);
}
