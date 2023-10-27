package org.example.java8;

import java.util.Optional;

public class UnemploymentServiceImpl implements UnemploymentService {

	private JobService jobService;

	public UnemploymentServiceImpl(JobService jobService) {
		this.jobService = jobService;
	}

	@Override
	public boolean personIsEntitledToUnemploymentSupport(Person person) {
		Optional<JobPosition> optional = jobService.findCurrentJobPosition(person);

		return optional.isEmpty();
	}

	@Override
	public Optional<JobPosition> searchJob(Person person, String searchString) {
		return jobService.listJobs(person)
				.filter(j -> j.getTitle().contains(searchString))
				.findFirst();
	}
}
