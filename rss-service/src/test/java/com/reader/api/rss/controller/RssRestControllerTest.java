package com.reader.api.rss.controller;

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

import com.reader.api.rss.util.BaseResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RssRestControllerTest {

	@Autowired
	private RssRestController rssRestController;

	@Test
	public void readerControllerTest() {
		// Given
		String format = "xml";
		// When
		ResponseEntity<BaseResponse<?>> result = rssRestController.reader(format);
		// Then
		assertEquals(result.getStatusCode(), HttpStatus.OK);
		assertNotNull(result.getBody().getResult());
	}

}
