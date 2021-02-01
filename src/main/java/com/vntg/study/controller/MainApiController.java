package com.vntg.study.controller;

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
		producer.sendMessage("Hello, World!");
		producer.sendGreetingMessage(message.toJSONString());
	}
}
