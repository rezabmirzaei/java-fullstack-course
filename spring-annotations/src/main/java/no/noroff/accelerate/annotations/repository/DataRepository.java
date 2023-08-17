package no.noroff.accelerate.annotations.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {

    // A specialized (extended) form of @Component.
    // Translates database exceptions into Spring's DataAccessException hierarchy.
    // Indicates that a class is a repository, used to manage data access.
    // Typically used at the persistence layer.

}
