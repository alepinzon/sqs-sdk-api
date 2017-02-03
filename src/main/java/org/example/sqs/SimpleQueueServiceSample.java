package org.example.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SimpleQueueServiceSample {


    private static final String DEFAULT_QUEUE_NAME = "test-sdk";


    @RequestMapping("/sqs/")
    public HttpEntity getSqsQueues(){
        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        ListQueuesResult listQueuesResult = sqs.listQueues();
        return new ResponseEntity(listQueuesResult, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/sqs/message",
            method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity addMessage(@RequestBody  @Valid CreateMessage createMessage){

        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        GetQueueUrlResult getQueueUrlResult = sqs.getQueueUrl(DEFAULT_QUEUE_NAME);
        String queueUrl = getQueueUrlResult.getQueueUrl();

        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setQueueUrl(queueUrl);
        sendMessageRequest.setMessageBody(createMessage.getMessage());

        SendMessageResult messageResult = sqs.sendMessage(sendMessageRequest);

        return new ResponseEntity(messageResult, HttpStatus.CREATED);
    }

}
