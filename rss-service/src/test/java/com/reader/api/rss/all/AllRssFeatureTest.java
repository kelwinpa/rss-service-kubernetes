package com.reader.api.rss.all;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.reader.api.rss.controller.RssRestControllerTest;
import com.reader.api.rss.repository.RssRepositoryTest;
import com.reader.api.rss.service.RssServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ RssRestControllerTest.class, RssServiceTest.class, RssRepositoryTest.class })
public class AllRssFeatureTest {

	// intentionally empty
}
