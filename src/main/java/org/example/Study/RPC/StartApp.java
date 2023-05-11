/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPC;

import lombok.val;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/11 11:23
 */
public class StartApp {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service,8081);
        System.out.println(1);

        HelloService ser = RpcFramework.refer(HelloService.class,"127.0.0.1",8081);
        System.out.println(ser.hello("world"));
    }
}
