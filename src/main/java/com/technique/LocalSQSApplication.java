package com.technique;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LocalSQSApplication extends Application<LocalSQSConfiguration> {
    public static void main(String[] args) throws Exception {
        new LocalSQSApplication().run(args);
    }

    @Override
    public String getName() {
        return "Local SQS";
    }

    @Override
    public void initialize(Bootstrap<LocalSQSConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(LocalSQSConfiguration configuration, Environment environment) {
        final AddRemoveResource resource = new AddRemoveResource();
        environment.jersey().register(resource);
    }

}

