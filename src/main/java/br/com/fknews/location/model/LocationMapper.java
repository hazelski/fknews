package br.com.fknews.location.model;

import br.com.fknews.location.model.domain.LocationDomain;
import br.com.fknews.location.model.dto.LocationDTO;
import br.com.fknews.location.model.request.LocationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {
    LocationMapper map = Mappers.getMapper(LocationMapper.class);

    LocationDTO domainToDTO(LocationDomain domain);
    LocationDomain requestToDomain(LocationRequest request);
}
