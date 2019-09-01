package com.revise.Refreshrevise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revise.Refreshrevise.RepositoryEvents.GithubClient;
import com.revise.Refreshrevise.RepositoryEvents.RepositoryEvent;
import com.revise.Refreshrevise.data.GithubProject;
import com.revise.Refreshrevise.data.GithubProjectRepository;

@Controller
public class EventsController {

	private final GithubProjectRepository repository;

	private final GithubClient githubClient;

	public EventsController(GithubProjectRepository repository, GithubClient githubClient) {
		super();
		this.repository = repository;
		this.githubClient = githubClient;
	}

	@GetMapping("/events/{repoName}")
	@ResponseBody
	public RepositoryEvent[] fetchEvents(@PathVariable("repoName") String reponame) {

		GithubProject findByRepoName = this.repository.findByRepoName(reponame);

		RepositoryEvent[] body = this.githubClient
				.fetchEvents(findByRepoName.getOrgName(), findByRepoName.getRepoName()).getBody();

		return body;
	}
}
