/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Config;

import com.meituan.service.mobile.mtthrift.proxy.ThriftServerPublisher;
import org.example.Study.RPCThrift.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author liushixing@meituan.com
 * @date 2023/5/5 17:54
 */
@Configuration
public class ThriftConfiguration {

    @Bean
    public ThriftServerPublisher thriftServerPublisher() throws Exception {
        ThriftServerPublisher publisher = new ThriftServerPublisher();
        publisher.setPort(20000);
        //publisher.setServiceInterface(Class.forName(HelloService));
        publisher.setServiceImpl(new HelloService());
        publisher.afterPropertiesSet();  //发布服务

        publisher.destroy();  //使用完记得销毁服务
        return publisher;
    }
}
