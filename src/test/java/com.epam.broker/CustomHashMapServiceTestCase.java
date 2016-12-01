package com.epam.broker;

import com.epam.broker.service.CustomHashMapService;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class CustomHashMapServiceTestCase {
	private CustomHashMapService<String, Object> hashMap = new CustomHashMapService();

	@Test
	public void testHashMapGetAndPut(){
		assertNull(hashMap.put("A", "e"));
		assertThat(hashMap.get("A"), is("e"));

		assertThat(hashMap.put("A", "b"), is("e"));
		assertThat(hashMap.get("A"), is("b"));

		assertNull(hashMap.put("a", "c"));
		assertThat(hashMap.get("a"), is("c"));
	}

	@Test
	public void testHashMapSize(){
		assertNull(hashMap.put("A", "e"));
		assertThat(hashMap.put("A", "b"), is("e"));
		assertNull(hashMap.put("a", "c"));
		assertThat(hashMap.remove("A"), is("b"));
		assertNull(hashMap.put("C", "b"));
		assertThat(hashMap.size(), is(2));
	}
}
