/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPCThrift;

import com.meituan.sample.Request;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author liushixing@meituan.com
 * @date 2023/5/5 17:45
 */
@Component
public class HelloService implements com.meituan.sample.HelloService.Iface {
    @Override
    public Request sayHello(Request request) throws TException {
        //处理逻辑
        System.out.println(request.getUserId());
        System.out.println(request.getContent());
        return request;
    }
}
