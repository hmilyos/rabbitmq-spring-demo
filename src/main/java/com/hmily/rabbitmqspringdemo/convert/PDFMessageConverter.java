package com.hmily.rabbitmqspringdemo.convert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Slf4j
public class PDFMessageConverter implements MessageConverter {

	@Override
	public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
		throw new MessageConversionException(" convert error ! ");
	}

	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
		log.info("-----------PDF MessageConverter----------");
		
		byte[] body = message.getBody();
		String fileName = UUID.randomUUID().toString();
		String path = "G:/test/file/new/" + fileName + ".pdf";
		File f = new File(path);
		try {
			Files.copy(new ByteArrayInputStream(body), f.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

}
