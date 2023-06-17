package eCourse.repositories;

import eCourse.domain.Meeting;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.security.core.userdetails.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MeetingsRepository extends DomainRepository<Long, Meeting> {

    Iterable<Meeting> findByUsername(final Username name);



}
