package com.technique;

import com.amazonaws.services.sqs.model.Message;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/sqs")
@Produces(MediaType.APPLICATION_JSON)
public class AddRemoveResource {
    private final LocalAmazonSQSContainer localAmazonSQSContainer = new LocalAmazonSQSContainer();

    static class Entity2 {
        @JsonProperty
        String name;
    }

    @GET
    @Timed
    public Map<String, Stack<String>> getQueues() {
        return localAmazonSQSContainer.getQueues();
    }

    @GET
    @Path("/{queueName}")
    @Timed
    public List<Message> fetchMessages(@PathParam("queueName") String queueName, @QueryParam("numberOfMessages") Optional<String> numberOfMessages) {
        final Integer value = Integer.valueOf(numberOfMessages.orElse("0"));
        return localAmazonSQSContainer.getMessages(queueName, value);
    }

    @GET
    @Path("/{queueName}/peek")
    @Timed
    public List<Message> peekMessages(@PathParam("queueName") String queueName) {
        return localAmazonSQSContainer.peekMessages(queueName);
    }

    @POST
    @Path("/{queueName}/put")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void putMessage(@PathParam("queueName") final String queueName, Entity2 message){
            localAmazonSQSContainer.addMessage(queueName, message.name);
    }
}
