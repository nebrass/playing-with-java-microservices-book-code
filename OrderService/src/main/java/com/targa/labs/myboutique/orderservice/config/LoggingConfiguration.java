package com.targa.labs.myboutique.orderservice.config;

import java.net.InetSocketAddress;

import ch.qos.logback.classic.AsyncAppender;
import ch.qos.logback.classic.LoggerContext;
import net.logstash.logback.appender.LogstashTcpSocketAppender;
import net.logstash.logback.encoder.LogstashEncoder;
import net.logstash.logback.stacktrace.ShortenedThrowableConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfiguration {

    private static final String LOGSTASH_APPENDER_NAME = "LOGSTASH";
    private static final String ASYNC_LOGSTASH_APPENDER_NAME = "ASYNC_LOGSTASH";

    private final Logger LOG = LoggerFactory.getLogger(LoggingConfiguration.class);
    private final LoggerContext CONTEXT = (LoggerContext) LoggerFactory.getILoggerFactory();

    private final String appName;
    private final String logstashHost;
    private final Integer logstashPort;
    private final Integer logstashQueueSize;

    public LoggingConfiguration(
            @Value("${spring.application.name}") String appName,
            @Value("${logstash.host}") String logstashHost,
            @Value("${logstash.port}") Integer logstashPort,
            @Value("${logstash.queue-size}") Integer logstashQueueSize) {

        this.appName = appName;
        this.logstashHost = logstashHost;
        this.logstashPort = logstashPort;
        this.logstashQueueSize = logstashQueueSize;

        addLogstashAppender(CONTEXT);

    }

    private void addLogstashAppender(LoggerContext context) {
        LOG.info("Initializing Logstash logging");

        LogstashTcpSocketAppender logstashAppender = new LogstashTcpSocketAppender();
        logstashAppender.setName(LOGSTASH_APPENDER_NAME);
        logstashAppender.setContext(context);
        String customFields = "{\"servicename\":\"" + this.appName + "\"}";

        // More documentation is available at: https://github.com/logstash/logstash-logback-encoder
        LogstashEncoder logstashEncoder = new LogstashEncoder();
        // Set the Logstash appender config
        logstashEncoder.setCustomFields(customFields);
        // Set the Logstash appender config
        logstashAppender.addDestinations(
                new InetSocketAddress(this.logstashHost, this.logstashPort)
        );

        ShortenedThrowableConverter throwableConverter = new ShortenedThrowableConverter();
        throwableConverter.setRootCauseFirst(true);
        logstashEncoder.setThrowableConverter(throwableConverter);
        logstashEncoder.setCustomFields(customFields);

        logstashAppender.setEncoder(logstashEncoder);
        logstashAppender.start();

        // Wrap the appender in an Async appender for performance
        AsyncAppender asyncLogstashAppender = new AsyncAppender();
        asyncLogstashAppender.setContext(context);
        asyncLogstashAppender.setName(ASYNC_LOGSTASH_APPENDER_NAME);
        asyncLogstashAppender.setQueueSize(this.logstashQueueSize);
        asyncLogstashAppender.addAppender(logstashAppender);
        asyncLogstashAppender.start();

        context.getLogger("ROOT").addAppender(asyncLogstashAppender);
    }

}
