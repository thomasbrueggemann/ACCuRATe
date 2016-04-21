package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import java.util.List;

public interface NodeApi {
    PendingResult<Status> addListener(GoogleApiClient var1, NodeApi.NodeListener var2);

    PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient var1);

    PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient var1);

    PendingResult<Status> removeListener(GoogleApiClient var1, NodeApi.NodeListener var2);

    public interface GetConnectedNodesResult extends Result {
        List<Node> getNodes();
    }

    public interface GetLocalNodeResult extends Result {
        Node getNode();
    }

    public interface NodeListener {
        void onPeerConnected(Node var1);

        void onPeerDisconnected(Node var1);
    }
}
