package eCourse.repositories;

import eCourse.domain.Notification;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public interface NotificationRepository extends DomainRepository<Long, Notification> {

    Iterable<Notification> findByUser(final SystemUser user);
}
