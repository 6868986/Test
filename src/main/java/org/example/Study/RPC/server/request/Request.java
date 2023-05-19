/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPC.server.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/19 15:35
 */

public class Request implements Serializable {

    private String name;

    private String method;

    public void setName(String name) {
        this.name = name;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public String getName() {
        return name;
    }
}
