package com.org.helloflink;

import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

public class FooConnector extends RichParallelSourceFunction<FooMessage> {

    private FooConnectorConfig connectorConfig;

    public FooConnector(FooConnectorConfig cfg) {
        connectorConfig = cfg;
    }

    private Boolean running = true;

    @Override
    public void run(SourceContext<FooMessage> sourceContext) throws Exception {
        while(running) {
            sourceContext.collect(new FooMessage("yo"));
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {
        this.running = false;
    }
}
