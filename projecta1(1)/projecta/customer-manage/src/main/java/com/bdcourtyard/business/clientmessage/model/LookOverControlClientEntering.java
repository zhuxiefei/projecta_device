package com.bdcourtyard.business.clientmessage.model;

import java.util.List;

public class LookOverControlClientEntering {
    private ControlClientEntering controlClientEntering;

    private List<ClientNeedreturn> clientNeedreturnList;

    public ControlClientEntering getControlClientEntering() {
        return controlClientEntering;
    }

    public void setControlClientEntering(ControlClientEntering controlClientEntering) {
        this.controlClientEntering = controlClientEntering;
    }

    public List<ClientNeedreturn> getClientNeedreturnList() {
        return clientNeedreturnList;
    }

    public void setClientNeedreturnList(List<ClientNeedreturn> clientNeedreturnList) {
        this.clientNeedreturnList = clientNeedreturnList;
    }
}
