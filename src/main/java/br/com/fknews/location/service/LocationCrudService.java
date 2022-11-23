package br.com.fknews.location.service;

import br.com.fknews.location.model.LocationMapper;
import br.com.fknews.location.model.domain.LocationDomain;
import br.com.fknews.location.model.dto.LocationDTO;
import br.com.fknews.location.model.request.LocationRequest;
import br.com.fknews.location.repository.LocationRepository;
import br.com.fknews.location.repository.LocationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LocationCrudService {

    private final LocationRepository repository;
    private final LocationTypeRepository locationTypeRepository;
    public List<LocationDTO> listAll(Integer page, Integer pageSize) {
        List<LocationDomain> domainList;
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id").descending());

        domainList =  repository.findAll(pageable).toList();
        return domainList
                .stream()
                .map(location -> LocationMapper.map.domainToDTO(location))
                .collect(Collectors.toList());
    }

    public LocationDTO searchId(Long id) {
        return LocationMapper.map.domainToDTO(repository.getById(id));
    }

    @Transactional
    public LocationDTO create(LocationRequest request) {

        LocationDomain domain = LocationMapper.map.requestToDomain(request);
        domain.setType(locationTypeRepository.getById(request.getTypeId()));

        return LocationMapper.map.domainToDTO(repository.save(domain));
    }

    @Transactional
    public LocationDTO update(LocationRequest request, Long id) {

        LocationDomain domain = repository.getById(id);
        domain.setName(request.getName());
        domain.setType(locationTypeRepository.getById(request.getTypeId()));

        return LocationMapper.map.domainToDTO(repository.save(domain));
    }

    @Transactional
    public void remover(Long id) {
        repository.deleteById(id);
    }
}
