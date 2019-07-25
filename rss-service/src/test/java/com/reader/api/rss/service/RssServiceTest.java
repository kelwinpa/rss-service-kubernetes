package com.reader.api.rss.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.reader.api.rss.entity.RssEntity;
import com.reader.api.rss.repository.RssRepository;
import com.reader.api.rss.rest.RsstDriverRest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class RssServiceTest {

	@Autowired
	private RssRepository rssRepository;

	@Autowired
	private RsstDriverRest rsstDriverRest;

	@Test
	public void readerServiceTest() {
		// Given
		String format = "xml";
		// When
		ResponseEntity<String> response = rsstDriverRest.reader(format);
		// Then
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);

		// Given
		RssEntity rssEntityTest = new RssEntity();
		rssEntityTest.setDescription("test");
		rssEntityTest.setImage("test");
		rssEntityTest.setPubDate("test");
		rssEntityTest.setTitle("test");
		// When
		rssRepository.save(rssEntityTest);
		// Then
		assertNotNull(rssEntityTest.getId());
	}

}
