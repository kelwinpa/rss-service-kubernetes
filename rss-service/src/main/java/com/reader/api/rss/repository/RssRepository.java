package com.reader.api.rss.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reader.api.rss.entity.RssEntity;

@Repository
public interface RssRepository extends CrudRepository<RssEntity, Integer> {

	RssEntity findByTitle(String title);
}
