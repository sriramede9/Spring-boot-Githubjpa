package com.revise.Refreshrevise.RepositoryEvents;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubClient {

	private static final String Event_Issues_Url="https://api.github.com/repos/{owner}/{repo}/issues/events";
	
	private final RestTemplate restTemplate;

	public GithubClient(RestTemplateBuilder builder) {
		super();
		this.restTemplate = builder.build();
	}
	
	public ResponseEntity<RepositoryEvent[]> fetchEvents(String orgName,String repoName){
		return this.restTemplate.getForEntity(Event_Issues_Url, RepositoryEvent[].class,orgName,repoName);
	}
	
}
