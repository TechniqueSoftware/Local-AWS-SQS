package com.technique;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesRequest;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesResult;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.PurgeQueueRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;

import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

@Singleton
public class AmazonSQSLocal implements AmazonSQS {
    private final LocalAmazonSQSContainer localAmazonSQSContainer = new LocalAmazonSQSContainer();

    @Override
    public void setEndpoint(final String s) throws IllegalArgumentException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void setRegion(final Region region) throws IllegalArgumentException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void setQueueAttributes(final SetQueueAttributesRequest setQueueAttributesRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(final ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void changeMessageVisibility(final ChangeMessageVisibilityRequest changeMessageVisibilityRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public GetQueueUrlResult getQueueUrl(final GetQueueUrlRequest getQueueUrlRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void removePermission(final RemovePermissionRequest removePermissionRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public GetQueueAttributesResult getQueueAttributes(final GetQueueAttributesRequest getQueueAttributesRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public SendMessageBatchResult sendMessageBatch(final SendMessageBatchRequest sendMessageBatchRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void purgeQueue(final PurgeQueueRequest purgeQueueRequest) throws AmazonServiceException, AmazonClientException {

    }

    @Override
    public ListDeadLetterSourceQueuesResult listDeadLetterSourceQueues(final ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void deleteQueue(final DeleteQueueRequest deleteQueueRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public SendMessageResult sendMessage(final SendMessageRequest sendMessageRequest) throws AmazonServiceException, AmazonClientException {
        localAmazonSQSContainer.addMessage(sendMessageRequest.getQueueUrl(), sendMessageRequest.getMessageBody());
        return new SendMessageResult();
    }

    @Override
    public ReceiveMessageResult receiveMessage(final ReceiveMessageRequest receiveMessageRequest) throws AmazonServiceException, AmazonClientException {
        final List<Message> messages = localAmazonSQSContainer.getMessages(receiveMessageRequest.getQueueUrl(), receiveMessageRequest.getMaxNumberOfMessages());
        final ReceiveMessageResult receiveMessageResult = new ReceiveMessageResult();
        receiveMessageResult.setMessages(messages);
        return receiveMessageResult;
    }

    @Override
    public ListQueuesResult listQueues(final ListQueuesRequest listQueuesRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public DeleteMessageBatchResult deleteMessageBatch(final DeleteMessageBatchRequest deleteMessageBatchRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public CreateQueueResult createQueue(final CreateQueueRequest createQueueRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void addPermission(final AddPermissionRequest addPermissionRequest) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void deleteMessage(final DeleteMessageRequest deleteMessageRequest) throws AmazonServiceException, AmazonClientException {

    }

    @Override
    public ListQueuesResult listQueues() throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void setQueueAttributes(final String s, final Map<String, String> map) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(final String s, final List<ChangeMessageVisibilityBatchRequestEntry> list) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void changeMessageVisibility(final String s, final String s1, final Integer integer) throws AmazonServiceException, AmazonClientException {

    }

    @Override
    public GetQueueUrlResult getQueueUrl(final String s) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void removePermission(final String s, final String s1) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public GetQueueAttributesResult getQueueAttributes(final String s, final List<String> list) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public SendMessageBatchResult sendMessageBatch(final String s, final List<SendMessageBatchRequestEntry> list) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void deleteQueue(final String s) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public SendMessageResult sendMessage(final String s, final String s1) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public ReceiveMessageResult receiveMessage(final String s) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public ListQueuesResult listQueues(final String s) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public DeleteMessageBatchResult deleteMessageBatch(final String s, final List<DeleteMessageBatchRequestEntry> list) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public CreateQueueResult createQueue(final String s) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void addPermission(final String s, final String s1, final List<String> list, final List<String> list1) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void deleteMessage(final String s, final String s1) throws AmazonServiceException, AmazonClientException {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void shutdown() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public ResponseMetadata getCachedResponseMetadata(final AmazonWebServiceRequest amazonWebServiceRequest) {
        throw new RuntimeException("not implemented");
    }
}