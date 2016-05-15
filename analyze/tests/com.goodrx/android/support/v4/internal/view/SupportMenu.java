package android.support.v4.internal.view;

import android.view.Menu;

public interface SupportMenu extends Menu {
   int CATEGORY_MASK = -65536;
   int CATEGORY_SHIFT = 16;
   int USER_MASK = 65535;
   int USER_SHIFT;
}
