package com.google.tagmanager.proto;

import com.google.analytics.containertag.proto.Serving;
import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Resource {
    public static final class ResourceWithMetadata extends ExtendableMessageNano {
        public static final Resource.ResourceWithMetadata[] EMPTY_ARRAY = new Resource.ResourceWithMetadata[0];
        public Serving.Resource resource = null;
        public Serving.SupplementedResource supplementedResource = null;
        public long timeStamp = 0L;

        public static Resource.ResourceWithMetadata parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Resource.ResourceWithMetadata()).mergeFrom(var0);
        }

        public static Resource.ResourceWithMetadata parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Resource.ResourceWithMetadata)MessageNano.mergeFrom(new Resource.ResourceWithMetadata(), var0);
        }

        public final Resource.ResourceWithMetadata clear() {
            this.timeStamp = 0L;
            this.resource = null;
            this.supplementedResource = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Resource.ResourceWithMetadata)) {
                    return false;
                } else {
                    Resource.ResourceWithMetadata var2 = (Resource.ResourceWithMetadata)var1;
                    if(this.timeStamp == var2.timeStamp) {
                        if(this.resource == null) {
                            if(var2.resource != null) {
                                return false;
                            }
                        } else if(!this.resource.equals(var2.resource)) {
                            return false;
                        }

                        if(this.supplementedResource == null) {
                            if(var2.supplementedResource != null) {
                                return false;
                            }
                        } else if(!this.supplementedResource.equals(var2.supplementedResource)) {
                            return false;
                        }

                        if(this.unknownFieldData == null) {
                            if(var2.unknownFieldData == null) {
                                return true;
                            }
                        } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                            return true;
                        }
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            int var1 = 0 + CodedOutputByteBufferNano.computeInt64Size(1, this.timeStamp);
            if(this.resource != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.resource);
            }

            if(this.supplementedResource != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.supplementedResource);
            }

            int var2 = var1 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var2;
            return var2;
        }

        public int hashCode() {
            int var1 = 31 * (527 + (int)(this.timeStamp ^ this.timeStamp >>> 32));
            int var2;
            if(this.resource == null) {
                var2 = 0;
            } else {
                var2 = this.resource.hashCode();
            }

            int var3 = 31 * (var1 + var2);
            int var4;
            if(this.supplementedResource == null) {
                var4 = 0;
            } else {
                var4 = this.supplementedResource.hashCode();
            }

            int var5 = 31 * (var3 + var4);
            List var6 = this.unknownFieldData;
            int var7 = 0;
            if(var6 != null) {
                var7 = this.unknownFieldData.hashCode();
            }

            return var5 + var7;
        }

        public Resource.ResourceWithMetadata mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 8:
                        this.timeStamp = var1.readInt64();
                        break;
                    case 18:
                        this.resource = new Serving.Resource();
                        var1.readMessage(this.resource);
                        break;
                    case 26:
                        this.supplementedResource = new Serving.SupplementedResource();
                        var1.readMessage(this.supplementedResource);
                        break;
                    default:
                        if(this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }

                        if(WireFormatNano.storeUnknownField(this.unknownFieldData, var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            var1.writeInt64(1, this.timeStamp);
            if(this.resource != null) {
                var1.writeMessage(2, this.resource);
            }

            if(this.supplementedResource != null) {
                var1.writeMessage(3, this.supplementedResource);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }
}
