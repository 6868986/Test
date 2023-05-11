/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.MTthrift.sdk.request;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;
import com.meituan.servicecatalog.api.annotations.FieldDoc;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/10 16:46
 */
@ThriftStruct
public class ThriftRequest {

    @FieldDoc(
            description = "RPC请求实体中的index"
    )
    public int index;

    @FieldDoc(
            description = "RPC请求实体中的s"
    )
    public String s;

    @ThriftField(1)
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @ThriftField(2)
    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
