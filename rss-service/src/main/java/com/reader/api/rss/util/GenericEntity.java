package com.reader.api.rss.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class GenericEntity implements Serializable {

	private static final long serialVersionUID = 6276953925841544519L;

	@Override
    public final int hashCode() {  return HashCodeBuilder.reflectionHashCode(this); }

    @Override
    public final boolean equals(final Object obj) {  return EqualsBuilder.reflectionEquals(this, obj); }


}