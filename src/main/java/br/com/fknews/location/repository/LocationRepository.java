package br.com.fknews.location.repository;

import br.com.fknews.location.model.domain.LocationDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationDomain, Long>, PagingAndSortingRepository<LocationDomain, Long> {
}
