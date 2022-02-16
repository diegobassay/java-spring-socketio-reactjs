package com.diegobassay.ip.address.management.component;

import com.diegobassay.ip.address.management.domain.model.IptableModel;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocketComponent {

    private static final Logger log = LoggerFactory.getLogger(SocketComponent.class);

    private final SocketIONamespace namespace;

    @Autowired
    public SocketComponent(SocketIOServer server) {
        this.namespace = server.addNamespace("/ipinfo");
        this.namespace.addEventListener("ipinfo", IptableModel.class, onEventIpInfo());
    }

    private DataListener<IptableModel> onEventIpInfo() {
        return (client, data, ackSender) -> {
            log.debug("Client[{}] - Received chat message '{}'", client.getSessionId().toString(), data);
            namespace.getBroadcastOperations().sendEvent("ipinfo", data);
        };
    }

}
