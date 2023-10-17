package org.example.infrastructure.person.repository.mapper;

import org.example.infrastructure.person.repository.po.PersonPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author sherry
 */
@Repository
public interface PersonDao extends JpaRepository<PersonPo, Integer> {

    @Query(value = "select p from PersonPO  p where p.relationshipPO.personId=?1")
    PersonPo findLeaderByPersonId(String personId);
}
