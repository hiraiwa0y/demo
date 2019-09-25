package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageController {
	@Autowired
	MessageMapper messageMapper;
	
	@RequestMapping(method=RequestMethod.GET, value = "/{arg}")
	public List<Message> getMessages(@PathVariable("arg") int id){
		return messageMapper.findById(id);
	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	public Message getMessages(){
//		return messageMapper.findAll();
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Message postMessages(@RequestBody Message message)
	{
		messageMapper.create(message);
		return message;
	}
}
