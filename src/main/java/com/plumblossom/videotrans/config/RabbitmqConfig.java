package com.plumblossom.videotrans.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: ZuoYanCoder
 * @Description:
 *   1. m3u8  h264[流畅、高清、超清]  h265[流畅、高清、超清]
 *   2. mp4   h264[流畅、高清、超清]  h265[流畅、高清、超清]
 *  总计: 12个
 *
 * @Date: 2020/10/9 9:37
 * @Version: 1.0
 */

@Configuration
public class RabbitmqConfig {

    // 定义处理 m3u8 视频的消息队列
    public static final String QUEUE_M3U8_H264_FLUENT = "queue_m3u8_h264_fluent";
    public static final String QUEUE_M3U8_H264_HD = "queue_m3u8_h264_hd";
    public static final String QUEUE_M3U8_H264_HQ = "queue_m3u8_h264_hq";
    public static final String QUEUE_M3U8_H265_FLUENT = "queue_m3u8_h265_fluent";
    public static final String QUEUE_M3U8_H265_HD = "queue_m3u8_h265_hd";
    public static final String QUEUE_M3U8_H265_HQ = "queue_m3u8_h265_hq";

    // 定义处理 mp4 视频的消息队列
    public static final String QUEUE_MP4_H264_FLUENT = "queue_mp4_h264_fluent";
    public static final String QUEUE_MP4_H264_HD = "queue_mp4_h264_hd";
    public static final String QUEUE_MP4_H264_HQ = "queue_mp4_h264_hq";
    public static final String QUEUE_MP4_H265_FLUENT = "queue_mp4_h265_fluent";
    public static final String QUEUE_MP4_H265_HD = "queue_mp4_h265_hd";
    public static final String QUEUE_MP4_H265_HQ = "queue_mp4_h265_hq";


    // 定义视频处理完的消息队列
    public static final String QUEUE_VIDEO_PROCESS_STATUS = "queue_video_process_status";


    // 定义处理消息的交换机
    public static final String EXCHANGE_PROCESS_VIDEO = "exchange_process_video";

    public static final String EXCHANGE_PROCESSED_STATUS = "exchange_process_status_video";

    // 设置视频处理机器并发处理数量
    public static final int DEFAULT_CONCURRENT = 1;

    @Bean("customContainerFactory")
    public SimpleRabbitListenerContainerFactory containerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(DEFAULT_CONCURRENT);
        factory.setMaxConcurrentConsumers(DEFAULT_CONCURRENT);
        factory.setPrefetchCount(1);
        configurer.configure(factory, connectionFactory);
        return factory;
    }


    /**
     * 定义视频处理完成的消息交换机
     * @return
     */
    @Bean(EXCHANGE_PROCESSED_STATUS)
    public Exchange EXCHANGE_PROCESSED_STATUS(){
        return ExchangeBuilder.directExchange(EXCHANGE_PROCESS_VIDEO).durable(true).build();
    }


    /**
     * 交换机配置 [使用 fanout 模式交换机]
     *
     *  ExchangeBuilder提供了fanout、direct、topic、header交换机类型的配置
     *
     * @return
     */
    @Bean(EXCHANGE_PROCESS_VIDEO)
    public Exchange EXCHANGE_ROUTING_VIDEO_INFORM(){
        // directExchange 指定交换机的类型 1:1  durable(true) 支持持久化
//        return ExchangeBuilder.directExchange(EXCHANGE_ROUTING_VIDEO_INFORM).durable(true).build();
        return ExchangeBuilder.fanoutExchange(EXCHANGE_PROCESS_VIDEO).durable(true).build();
    }

    // 定义处理视频消息的消息队列
    @Bean(QUEUE_VIDEO_PROCESS_STATUS)
    public Queue QUEUE_VIDEO_PROCESS_STATUS(){
        return new Queue(QUEUE_VIDEO_PROCESS_STATUS);
    }

    // 定义消息队列
    @Bean(QUEUE_M3U8_H264_FLUENT)
    public Queue QUEUE_M3U8_H264_FLUENT(){
       return new Queue(QUEUE_M3U8_H264_FLUENT);
    }

    @Bean(QUEUE_M3U8_H264_HD)
    public Queue QUEUE_M3U8_H264_HD(){
        return new Queue(QUEUE_M3U8_H264_HD);
    }

    @Bean(QUEUE_M3U8_H264_HQ)
    public Queue QUEUE_M3U8_H264_HQ(){
        return new Queue(QUEUE_M3U8_H264_HQ);
    }

    @Bean(QUEUE_M3U8_H265_FLUENT)
    public Queue QUEUE_M3U8_H265_FLUENT(){
        return new Queue(QUEUE_M3U8_H265_FLUENT);
    }

    @Bean(QUEUE_M3U8_H265_HD)
    public Queue QUEUE_M3U8_H265_HD(){
        return new Queue(QUEUE_M3U8_H265_HD);
    }

    @Bean(QUEUE_M3U8_H265_HQ)
    public Queue QUEUE_M3U8_H265_HQ(){
        return new Queue(QUEUE_M3U8_H265_HQ);
    }

    // MP4
    @Bean(QUEUE_MP4_H264_FLUENT)
    public Queue QUEUE_MP4_H264_FLUENT(){
        return new Queue(QUEUE_MP4_H264_FLUENT);
    }

    @Bean(QUEUE_MP4_H264_HD)
    public Queue QUEUE_MP4_H264_HD(){
        return new Queue(QUEUE_MP4_H264_HD);
    }

    @Bean(QUEUE_MP4_H264_HQ)
    public Queue QUEUE_MP4_H264_HQ(){
        return new Queue(QUEUE_MP4_H264_HQ);
    }

    @Bean(QUEUE_MP4_H265_FLUENT)
    public Queue QUEUE_MP4_H265_FLUENT(){
        return new Queue(QUEUE_MP4_H265_FLUENT);
    }

    @Bean(QUEUE_MP4_H265_HD)
    public Queue QUEUE_MP4_H265_HD(){
        return new Queue(QUEUE_MP4_H265_HD);
    }

    @Bean(QUEUE_MP4_H265_HQ)
    public Queue QUEUE_MP4_H265_HQ() {
        return new Queue(QUEUE_MP4_H265_HQ);
    }


    /**
     * 绑定队列
     * @param queue
     * @param exchange
     * @return
     *
     */


    @Bean
    public Binding BINDING_QUEUE_VIDEO_PROCESS_STATUS(@Qualifier(QUEUE_VIDEO_PROCESS_STATUS) Queue queue, @Qualifier(EXCHANGE_PROCESSED_STATUS) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

    @Bean
    public Binding BINDING_QUEUE_M3U8_H264_FLUENT(@Qualifier(QUEUE_M3U8_H264_FLUENT) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }


    @Bean
    public Binding BINDING_QUEUE_M3U8_H264_HD(@Qualifier(QUEUE_M3U8_H264_HD) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

    @Bean
    public Binding BINDING_QUEUE_M3U8_H264_HQ(@Qualifier(QUEUE_M3U8_H264_HQ) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }


    @Bean
    public Binding BINDING_QUEUE_M3U8_H265_FLUENT(@Qualifier(QUEUE_M3U8_H265_FLUENT) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

    @Bean
    public Binding BINDING_QUEUE_M3U8_H265_HD(@Qualifier(QUEUE_M3U8_H265_HD) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

    @Bean
    public Binding BINDING_QUEUE_M3U8_H265_HQ(@Qualifier(QUEUE_M3U8_H265_HQ) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }


    @Bean
    public Binding BINDING_QUEUE_MP4_H264_FLUENT(@Qualifier(QUEUE_MP4_H264_FLUENT) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }


    @Bean
    public Binding BINDING_QUEUE_MP4_H264_HD(@Qualifier(QUEUE_MP4_H264_HD) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

    @Bean
    public Binding BINDING_QUEUE_MP4_H264_HQ(@Qualifier(QUEUE_MP4_H264_HQ) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }


    @Bean
    public Binding BINDING_QUEUE_MP4_H265_FLUENT(@Qualifier(QUEUE_MP4_H265_FLUENT) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }


    @Bean
    public Binding BINDING_QUEUE_MP4_H265_HD(@Qualifier(QUEUE_MP4_H265_HD) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

    @Bean
    public Binding BINDING_QUEUE_MP4_H265_HQ(@Qualifier(QUEUE_MP4_H265_HQ) Queue queue, @Qualifier(EXCHANGE_PROCESS_VIDEO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }



}
