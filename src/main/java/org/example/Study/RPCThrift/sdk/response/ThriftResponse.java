/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPCThrift.sdk.response;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/10 17:13
 */
@ThriftStruct
public class ThriftResponse {

    @ThriftField(1)
    public int index;

    @ThriftField(2)
    public String s;
}
