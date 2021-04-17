package com.org.helloflink;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.UUID;

public class FooConnector extends RichParallelSourceFunction<CloudEvent> {

    private FooConnectorConfig connectorConfig;

    public FooConnector(FooConnectorConfig cfg) {
        connectorConfig = cfg;
    }

    private Boolean running = true;

    @Override
    public void run(SourceContext<CloudEvent> sourceContext) throws Exception {
        while(running) {
            CloudEvent ce = CloudEventBuilder.v1()
                    .withId(UUID.randomUUID().toString())
                    .withSource(URI.create("ab/c/d"))
                    .withData("text/plain", "hello flink".getBytes())
                    .withType("e1")
                    .withTime(OffsetDateTime.now())
                    .build();

            sourceContext.collect(ce);
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {
        this.running = false;
    }
}
