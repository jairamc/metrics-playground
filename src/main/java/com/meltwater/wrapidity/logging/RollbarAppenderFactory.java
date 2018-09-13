package com.meltwater.wrapidity.logging;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.rollbar.logback.RollbarAppender;
import io.dropwizard.logging.AbstractAppenderFactory;
import io.dropwizard.logging.AppenderFactory;
import io.dropwizard.logging.async.AsyncAppenderFactory;
import io.dropwizard.logging.filter.LevelFilterFactory;
import io.dropwizard.logging.layout.LayoutFactory;

@JsonTypeName("rollbar")
public class RollbarAppenderFactory extends AbstractAppenderFactory<ILoggingEvent> {

    private String accessToken;

    @JsonProperty
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Appender<ILoggingEvent> build(
            LoggerContext context,
            String applicationName,
            LayoutFactory<ILoggingEvent> layoutFactory,
            LevelFilterFactory<ILoggingEvent> levelFilterFactory,
            AsyncAppenderFactory<ILoggingEvent> asyncAppenderFactory) {
        RollbarAppender appender = new RollbarAppender();
        appender.setAccessToken(accessToken);
        appender.setContext(context);
        appender.setName("ROLLBAR");
        appender.start();
        return  wrapAsync(appender, asyncAppenderFactory);
    }
}
