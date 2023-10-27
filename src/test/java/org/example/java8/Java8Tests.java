package org.example.java8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class Java8Tests {

	@Mock
	private JobService jobService;

	@InjectMocks
	private UnemploymentServiceImpl unemploymentService;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/*
	Default method from the interface
	 */
	@Test
	public void givenDefaultMethod_whenCallRealMethod_thenNoExceptionIsRaised() {
		Person person = new Person();

		when(jobService.findCurrentJobPosition(person))
				.thenReturn(Optional.of(new JobPosition()));

		doCallRealMethod().when(jobService)
				.assignJobPosition(
						any(Person.class),
						any(JobPosition.class)
				);

		assertFalse(jobService.assignJobPosition(person, new JobPosition()));
	}

	/*
	Default value of optional
	 */
	@Test
	public void givenReturnIsOfTypeOptional_whenMocked_thenValueIsEmpty() {
		Person person = new Person();

		//Necessary before mockito 2
		when(jobService.findCurrentJobPosition(any(Person.class)))
				.thenReturn(Optional.empty());

		assertTrue(unemploymentService.personIsEntitledToUnemploymentSupport(person));
	}

	/*
	Default value of stream
	 */
	@Test
	public void givenReturnIsOfTypeStream_whenMocked_thenValueIsEmpty() {
		Person person = new Person();

		//Necessary before mockito 2
		when(jobService.listJobs(any(Person.class))).thenReturn(Stream.empty());

		assertFalse(unemploymentService.searchJob(person, "").isPresent());
	}

	/*
	Lambdas
	 */
	@Test
	public void whenPersonWithJob_thenIsNotEntitled() {
		Person peter = new Person("Peter");
		Person linda = new Person("Linda");

		JobPosition teacher = new JobPosition("Teacher");

		when(jobService.findCurrentJobPosition(
				ArgumentMatchers.argThat(p -> p.getName().equals("Peter"))))
				.thenReturn(Optional.of(teacher));

		assertTrue(unemploymentService.personIsEntitledToUnemploymentSupport(linda));
		assertFalse(unemploymentService.personIsEntitledToUnemploymentSupport(peter));
	}
}
