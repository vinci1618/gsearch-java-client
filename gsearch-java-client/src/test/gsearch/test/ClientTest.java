
package gsearch.test;

import java.util.*;

import gsearch.*;
import junit.framework.TestCase;

public class ClientTest extends TestCase
{

	static
	{
		System.getProperties().put("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.getProperties().put("org.apache.commons.logging.simplelog.defaultlog", "trace");
	}
	
	public Client getClient()
	{
		return new Client();
	}
	
	public void testNewsByZipCode() throws Exception
	{
		Client c = getClient();
		
		List<Result> results = c.searchNewsByLocation("97202");

		assertValidResults(results);
	}
	
	public void testNewsByCityState() throws Exception
	{
		Client c = getClient();
		
		List<Result> results = c.searchNewsByLocation("Seattle, WA");
		
		assertValidResults(results);
		
	}

	public void testNewsByTopic() throws Exception
	{
		Client c = getClient();
		
		List<Result> results = c.searchNews(NewsTopic.WORLD);
		
		assertValidResults(results);
		
	}

	public void testNewsByZipAndTopic() throws Exception
	{
		Client c = getClient();
		
		List<Result> results = c.searchNews("97202", NewsTopic.SPORTS);
		
		assertValidResults(results);
		
	}

	public void testNewsByCityAndTopic() throws Exception
	{
		Client c = getClient();
		
		List<Result> results = c.searchNews("Boston, MA", NewsTopic.BUSINESS);
		
		assertValidResults(results);
		
	}

	private void assertValidResults(List<Result> results)
	{
		assertNotNull(results);
		
		assertTrue(results.size() > 0);
		
		for (Result r : results)
		{
			assertValid(r);
		}
		
	}

	private void assertValid(Result r)
	{
		System.out.println("--------------------------------------------------------");
		System.out.println(r);
		
		assertNotNull(r.getTitle());
		assertNotNull(r.getUnescapedUrl());
		
	}
	
}
