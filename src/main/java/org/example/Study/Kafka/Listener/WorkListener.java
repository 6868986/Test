/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.Kafka.Listener;

import com.meituan.mafka.client.consumer.ConsumeStatus;
import com.meituan.mafka.client.consumer.IMessageListener;
import com.meituan.mafka.client.message.MafkaMessage;
import com.meituan.mafka.client.message.MessagetContext;
import org.springframework.stereotype.Component;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/10 11:07
 */
@Component
public class WorkListener implements IMessageListener {
    @Override
    public ConsumeStatus recvMessage(MafkaMessage mafkaMessage, MessagetContext messagetContext) {
        String body = mafkaMessage.getBody().toString();

        return ConsumeStatus.CONSUME_SUCCESS;
    }
}
