/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPC.client.consumer;

import org.example.Study.RPC.client.proxy.RemoteServiceImplProxy;
import org.example.Study.RPC.server.service.HelloService;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/19 15:15
 */
public class ConsumerClient {

    public static void main(String[] args) {

        //HelloService是远程服务暴露出来的sdk接口，通过导入jar包引入远程服务的sdk接口
        HelloService service = new RemoteServiceImplProxy();
        String res = service.hello("WHU");
        System.out.println(res);
    }
}
