/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.Raptor;

import com.dianping.cat.Cat;

/**
 * <p>
 *
 * </p>
 *
 * @author liushixing@meituan.com
 * @date 2023/5/5 11:39
 */
public class Catclient {

    public void logEvent(String type,String name){
        Cat.logEvent(type,name);
    }
}
