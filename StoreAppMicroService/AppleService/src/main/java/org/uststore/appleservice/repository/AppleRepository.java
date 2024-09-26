package org.uststore.appleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uststore.appleservice.model.Apple;

@Repository
public interface AppleRepository extends JpaRepository<Apple, Long> {
}
