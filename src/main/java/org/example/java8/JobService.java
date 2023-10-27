package org.example.java8;

import java.util.Optional;
import java.util.stream.Stream;

public interface JobService {
 
    Optional<JobPosition> findCurrentJobPosition(Person person);

    Stream<JobPosition> listJobs(Person person);
    
    default boolean assignJobPosition(Person person, JobPosition jobPosition) {
        if(findCurrentJobPosition(person).isEmpty()) {
            person.setCurrentJobPosition(jobPosition);
            return true;
        } else {
            return false;
        }
    }
}
