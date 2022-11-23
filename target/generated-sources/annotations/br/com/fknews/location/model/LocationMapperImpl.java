package br.com.fknews.location.model;

import br.com.fknews.location.model.domain.LocationDomain;
import br.com.fknews.location.model.domain.LocationDomain.LocationDomainBuilder;
import br.com.fknews.location.model.domain.LocationTypeDomain;
import br.com.fknews.location.model.dto.LocationDTO;
import br.com.fknews.location.model.dto.LocationDTO.LocationDTOBuilder;
import br.com.fknews.location.model.dto.LocationTypeDTO;
import br.com.fknews.location.model.dto.LocationTypeDTO.LocationTypeDTOBuilder;
import br.com.fknews.location.model.request.LocationRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-23T10:11:12-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationDTO domainToDTO(LocationDomain domain) {
        if ( domain == null ) {
            return null;
        }

        LocationDTOBuilder locationDTO = LocationDTO.builder();

        locationDTO.id( domain.getId() );
        locationDTO.name( domain.getName() );
        locationDTO.type( locationTypeDomainToLocationTypeDTO( domain.getType() ) );

        return locationDTO.build();
    }

    @Override
    public LocationDomain requestToDomain(LocationRequest request) {
        if ( request == null ) {
            return null;
        }

        LocationDomainBuilder locationDomain = LocationDomain.builder();

        locationDomain.name( request.getName() );

        return locationDomain.build();
    }

    protected LocationTypeDTO locationTypeDomainToLocationTypeDTO(LocationTypeDomain locationTypeDomain) {
        if ( locationTypeDomain == null ) {
            return null;
        }

        LocationTypeDTOBuilder locationTypeDTO = LocationTypeDTO.builder();

        locationTypeDTO.id( locationTypeDomain.getId() );
        locationTypeDTO.name( locationTypeDomain.getName() );

        return locationTypeDTO.build();
    }
}
