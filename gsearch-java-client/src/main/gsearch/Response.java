
package gsearch;

import java.util.*;

public class Response
{
	private String json;
	private ResponseData responseData;
	private String responseDetails;
	private String responseStatus;
	
	public void setJson(String j)
	{
		this.json = j;
	}

	
	public ResponseData getResponseData()
	{
		return responseData;
	}


	public void setResponseData(ResponseData responseData)
	{
		this.responseData = responseData;
	}


	public String getJson()
	{
		return json;
	}

	public boolean isOK()
	{
		return "200".equalsIgnoreCase(this.getResponseStatus());
	}
	
	public boolean isError()
	{
		return !isOK();
	}
	

	public String getResponseDetails()
	{
		return responseDetails;
	}


	public void setResponseDetails(String details)
	{
		this.responseDetails = details;
	}


	public String getResponseStatus()
	{
		return responseStatus;
	}


	public void setResponseStatus(String responseStatus)
	{
		this.responseStatus = responseStatus;
	}


	public static class ResponseData
	{
		// @SerializedName("results")
		private List<Result> results;
		
		public List<Result> getResults()
		{
			if (results == null)
			{
				results = new ArrayList<Result>();
			}
			return results;
		}

		public void setResults(List<Result> resultList)
		{
			this.results = resultList;
		}

	}
	
}
