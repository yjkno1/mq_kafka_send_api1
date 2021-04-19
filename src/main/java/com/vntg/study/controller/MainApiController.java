package com.vntg.study.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vntg.study.producer.MessageProducer;

@RestController
public class MainApiController {
	
	@Autowired
	MessageProducer producer;
	
	@PostMapping("/send")	public void sendMessage(@RequestBody JSONObject message) throws Exception {
		System.out.println("SEND MESSAGE to KAFKA " +message.toJSONString());
		producer.sendMessage("Topic Test");
		producer.sendGreetingMessage(message.toJSONString());
	}

	@PostMapping("/send/aiteam")	public void sendAiteamMessage(@RequestBody List<JSONObject> message) throws Exception {
		System.out.println("SEND MESSAGE to KAFKA " +message.toString());
		producer.sendMessage("Topic Test");
		producer.sendAiteamMessage(message);
	}
}
