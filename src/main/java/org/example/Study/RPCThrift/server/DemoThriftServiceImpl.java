/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPCThrift.server;

import org.apache.thrift.TException;
import org.example.Study.RPCThrift.sdk.DemoThriftService;
import org.example.Study.RPCThrift.sdk.request.ThriftRequest;
import org.example.Study.RPCThrift.sdk.response.ThriftResponse;
import org.springframework.stereotype.Service;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/10 16:48
 */
@Service
public class DemoThriftServiceImpl implements DemoThriftService {
    @Override
    public ThriftResponse demoThriftMethod(ThriftRequest thriftRequest) throws TException {

        return null;
    }
}
