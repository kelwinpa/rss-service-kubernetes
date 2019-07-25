package com.reader.api.rss.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.reader.api.rss.entity.RssEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RssRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RssRepository rssRepository;

	@Test
	public void readerRepositoryTest() {

		RssEntity rssEntityTest = new RssEntity();
		rssEntityTest.setDescription("test");
		rssEntityTest.setImage("test");
		rssEntityTest.setPubDate("test");
		rssEntityTest.setTitle("test");
		entityManager.persist(rssEntityTest);

		RssEntity rssEntity = rssRepository.findByTitle("test");

		assertThat(rssEntity.getId(), is(equalTo(rssEntityTest.getId())));

	}

}
