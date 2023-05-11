/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPC;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/11 11:19
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
