package com.hmily.rabbitmqspringdemo.convert;

import com.bfxy.spring.convert.Message;
import com.bfxy.spring.convert.MessageConversionException;
import com.bfxy.spring.convert.MessageConverter;
import com.bfxy.spring.convert.MessageProperties;

public class TextMessageConverter implements MessageConverter {
	
	@Override
	public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
		return new Message(object.toString().getBytes(), messageProperties);
	}

	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
		String contentType = message.getMessageProperties().getContentType();
		if(null != contentType && contentType.contains("text")) {
			return new String(message.getBody());
		}
		return message.getBody();
	}

}
