package com.facebook.common.file;

import java.io.File;

public interface FileTreeVisitor {
   void postVisitDirectory(File var1);

   void preVisitDirectory(File var1);

   void visitFile(File var1);
}
