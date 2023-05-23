/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPC.server.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/19 15:44
 */
//@Data
public class Response implements Serializable {
    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    private String res;

    public Response(String res){
        this.res = res;
    }
}
