package com.google.tagmanager.protobuf.nano;

import com.google.tagmanager.protobuf.nano.Extension;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.UnknownFieldData;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.util.ArrayList;
import java.util.List;

public abstract class ExtendableMessageNano extends MessageNano {
    protected List<UnknownFieldData> unknownFieldData;

    public <T> T getExtension(Extension<T> var1) {
        return WireFormatNano.getExtension(var1, this.unknownFieldData);
    }

    public int getSerializedSize() {
        int var1 = WireFormatNano.computeWireSize(this.unknownFieldData);
        this.cachedSize = var1;
        return var1;
    }

    public <T> void setExtension(Extension<T> var1, T var2) {
        if(this.unknownFieldData == null) {
            this.unknownFieldData = new ArrayList();
        }

        WireFormatNano.setExtension(var1, var2, this.unknownFieldData);
    }
}
