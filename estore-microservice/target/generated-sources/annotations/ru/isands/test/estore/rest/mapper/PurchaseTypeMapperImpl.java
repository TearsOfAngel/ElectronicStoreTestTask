package ru.isands.test.estore.rest.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.dto.PurchaseTypeDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T15:45:11+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.23 (Amazon.com Inc.)"
)
@Component
public class PurchaseTypeMapperImpl implements PurchaseTypeMapper {

    @Override
    public PurchaseTypeDTO toDTO(PurchaseType purchaseType) {
        if ( purchaseType == null ) {
            return null;
        }

        PurchaseTypeDTO purchaseTypeDTO = new PurchaseTypeDTO();

        purchaseTypeDTO.setName( purchaseType.getName() );

        return purchaseTypeDTO;
    }

    @Override
    public PurchaseType toEntity(PurchaseTypeDTO purchaseTypeDTO) {
        if ( purchaseTypeDTO == null ) {
            return null;
        }

        PurchaseType purchaseType = new PurchaseType();

        purchaseType.setName( purchaseTypeDTO.getName() );

        return purchaseType;
    }

    @Override
    public void updateEntityFromDto(PurchaseTypeDTO purchaseTypeDTO, PurchaseType purchaseType) {
        if ( purchaseTypeDTO == null ) {
            return;
        }

        purchaseType.setName( purchaseTypeDTO.getName() );
    }
}
