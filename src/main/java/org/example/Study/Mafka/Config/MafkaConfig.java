/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.Mafka.Config;

import com.meituan.mafka.client.MafkaClient;
import com.meituan.mafka.client.bean.MafkaProducer;
import com.meituan.mafka.client.consumer.ConsumerConstants;
import com.meituan.mafka.client.consumer.IConsumerProcessor;
import com.meituan.mafka.client.producer.IProducerProcessor;
import com.meituan.mafka.client.producer.ProducerConstants;
import org.example.Study.Mafka.Listener.WorkListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * <p>
 *
 * </p>
 *
 * @author liushixing@meituan.com
 * @date 2023/5/10 10:56
 */
@Configuration
public class MafkaConfig {

    @Resource
    private WorkListener workListener;

    @Bean(name = "workConsumer")
    public IConsumerProcessor workConsumer() throws Exception {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConstants.MafkaBGNamespace,"waimai");
        properties.setProperty(ConsumerConstants.MafkaClientAppkey,"com.sankuai.health.merchant.pricing");
        properties.setProperty(ConsumerConstants.SubscribeGroup,"consumerGroup");
        IConsumerProcessor consumer = MafkaClient.buildConsumerFactory(properties,"topic");
        consumer.recvMessageWithParallel(String.class,workListener);
        return consumer;
    }

    @Bean(name = "workProducer")
    public MafkaProducer workProducer(){
        MafkaProducer producer = new MafkaProducer();
        producer.setNamespace("waimai");
        producer.setAppkey("com.sankuai.health.merchant.pricing");
        producer.setTopic("topic");
        return producer;
    }
}
