/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPC.server.service;

import org.example.Study.RPC.server.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/11 11:19
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name + "!";
    }
}
