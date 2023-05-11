/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.MTthrift.sdk;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import org.apache.thrift.TException;
import org.example.Study.MTthrift.sdk.request.ThriftRequest;
import org.example.Study.MTthrift.sdk.response.ThriftResponse;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/10 16:04
 */
@ThriftService
public interface DemoThriftService  {

    @ThriftMethod
    public ThriftResponse demoThriftMethod(ThriftRequest thriftRequest) throws TException;
}
