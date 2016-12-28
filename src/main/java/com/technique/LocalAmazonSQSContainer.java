package com.technique;

import com.amazonaws.services.sqs.model.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

class LocalAmazonSQSContainer {
    private final Map<String, Stack<String>> queues = new ConcurrentHashMap<>();

    synchronized Map<String, Stack<String>> getQueues() {
        return queues;
    }

    synchronized void addMessage(final String queueName, final String message) {
        if(message == null) return;

        if (!queues.containsKey(queueName)) {
            queues.put(queueName, new Stack<String>());
        }
        queues.get(queueName).add(message);
    }

    synchronized List<Message> getMessages(final String queueName, final Integer numberOfMessages) {
        if (!queues.containsKey(queueName)) return Collections.emptyList();

        final Stack<String> messagesFromQueue = queues.get(queueName);
        final List<String> messagesFromQueueToConvert = new ArrayList<>();
        for (Integer i = 0; i < numberOfMessages; i++) {
            if(!messagesFromQueue.empty()) {
                final String messageString = messagesFromQueue.pop();
                if(messageString != null) {
                    messagesFromQueueToConvert.add(messageString);
                }
            }
        }
        return convertMessages(messagesFromQueueToConvert);
    }

    synchronized List<Message> peekMessages(final String queueName) {
        if (!queues.containsKey(queueName)) return Collections.emptyList();

        final Stack<String> messagesFromQueue = queues.get(queueName);
        final List<String> messagesFromQueueToConvert = new ArrayList<>(messagesFromQueue);
        return convertMessages(messagesFromQueueToConvert);
    }

    private List<Message> convertMessages(final List<String> messagesFromQueueToConvert) {
        final List<Message> convertedMessages = new ArrayList<>();

        for (final String messageToConvert : messagesFromQueueToConvert) {
            final Message convertedMessage = new Message();
            convertedMessage.setBody(messageToConvert);
            convertedMessages.add(convertedMessage);
        }

        return convertedMessages;
    }
}
