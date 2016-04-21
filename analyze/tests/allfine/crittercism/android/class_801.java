package crittercism.android;

import crittercism.android.class_724;
import crittercism.android.class_803;
import java.util.Iterator;
import org.json.JSONArray;

// $FF: renamed from: crittercism.android.bo
public final class class_801 {
    // $FF: renamed from: a org.json.JSONArray
    public JSONArray field_3795 = new JSONArray();

    public class_801(class_803 var1) {
        Iterator var2 = var1.method_4171().iterator();

        while(var2.hasNext()) {
            Object var3 = ((class_724)var2.next()).method_3953();
            if(var3 != null) {
                this.field_3795.put(var3);
            }
        }

    }
}
