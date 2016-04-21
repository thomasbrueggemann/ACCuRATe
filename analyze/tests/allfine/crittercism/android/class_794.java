package crittercism.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import crittercism.android.class_662;
import crittercism.android.class_674;
import crittercism.android.class_676;
import crittercism.android.class_764;
import crittercism.android.class_790;

// $FF: renamed from: crittercism.android.bd
public final class class_794 extends BroadcastReceiver {
    // $FF: renamed from: a crittercism.android.az
    private class_790 field_3742;
    // $FF: renamed from: b java.lang.String
    private String field_3743;
    // $FF: renamed from: c crittercism.android.b
    private class_676 field_3744;

    public class_794(Context var1, class_790 var2) {
        this.field_3742 = var2;
        class_662 var3 = new class_662(var1);
        this.field_3743 = var3.method_3715();
        this.field_3744 = var3.method_3714();
    }

    public final void onReceive(Context var1, Intent var2) {
        (new StringBuilder("CrittercismReceiver: INTENT ACTION = ")).append(var2.getAction());
        class_764.method_4020();
        class_662 var4 = new class_662(var1);
        class_676 var5 = var4.method_3714();
        if(this.field_3744 != var5 && var5 != class_676.field_3281) {
            if(var5 == class_676.field_3282) {
                this.field_3742.method_4088(new class_674(class_674.class_1234.field_3369));
            } else if(this.field_3744 == class_676.field_3282 || this.field_3744 == class_676.field_3281) {
                this.field_3742.method_4088(new class_674(class_674.class_1234.field_3368));
            }

            this.field_3744 = var5;
        }

        String var6 = var4.method_3715();
        if(!var6.equals(this.field_3743)) {
            if(!this.field_3743.equals("unknown") && !this.field_3743.equals("disconnected")) {
                if(var6.equals("disconnected")) {
                    this.field_3742.method_4088(new class_674(class_674.class_1234.field_3371, this.field_3743));
                } else if(!var6.equals("unknown")) {
                    this.field_3742.method_4088(new class_674(class_674.class_1234.field_3372, this.field_3743, var6));
                }
            } else if(!var6.equals("unknown") && !var6.equals("disconnected")) {
                this.field_3742.method_4088(new class_674(class_674.class_1234.field_3370, var6));
            }

            this.field_3743 = var6;
        }

    }
}
