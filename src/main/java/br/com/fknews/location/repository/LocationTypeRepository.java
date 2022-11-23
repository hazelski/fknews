package br.com.fknews.location.repository;

import br.com.fknews.location.model.domain.LocationTypeDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationTypeRepository extends JpaRepository<LocationTypeDomain, Long> {
}
