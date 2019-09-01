package com.revise.Refreshrevise.data;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GithubProjectRepository extends PagingAndSortingRepository<GithubProject, Long> {

	GithubProject findByRepoName(String repoName);
	
}
