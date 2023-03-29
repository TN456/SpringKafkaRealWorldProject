package com.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.model.WikimediaData;
import com.springboot.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

	
	@Autowired
	private WikimediaDataRepository wikimediaDataRepository;
	@KafkaListener(topics = "wikimedia",
			groupId = "myGroup")
	
	public void consume(String eventMessage) {
		
		LOGGER.info(String.format("Event message received : %s", eventMessage));
		
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		
		wikimediaDataRepository.save(wikimediaData);
	}
}
