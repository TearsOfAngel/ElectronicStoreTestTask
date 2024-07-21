package ru.isands.test.estore.rest.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.isands.test.estore.dao.entity.ElectroItem;
import ru.isands.test.estore.dto.ElectroItemDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T15:45:11+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.23 (Amazon.com Inc.)"
)
@Component
public class ElectroItemMapperImpl implements ElectroItemMapper {

    @Override
    public ElectroItemDTO toDto(ElectroItem electroItem) {
        if ( electroItem == null ) {
            return null;
        }

        ElectroItemDTO electroItemDTO = new ElectroItemDTO();

        electroItemDTO.setName( electroItem.getName() );
        electroItemDTO.setPrice( electroItem.getPrice() );
        electroItemDTO.setCount( electroItem.getCount() );
        electroItemDTO.setArchive( electroItem.isArchive() );
        electroItemDTO.setDescription( electroItem.getDescription() );

        return electroItemDTO;
    }

    @Override
    public ElectroItem toEntity(ElectroItemDTO electroItemDTO) {
        if ( electroItemDTO == null ) {
            return null;
        }

        ElectroItem electroItem = new ElectroItem();

        electroItem.setName( electroItemDTO.getName() );
        electroItem.setPrice( electroItemDTO.getPrice() );
        electroItem.setCount( electroItemDTO.getCount() );
        electroItem.setArchive( electroItemDTO.isArchive() );
        electroItem.setDescription( electroItemDTO.getDescription() );

        return electroItem;
    }

    @Override
    public void updateEntityFromDto(ElectroItemDTO electroItemDTO, ElectroItem electroItem) {
        if ( electroItemDTO == null ) {
            return;
        }

        electroItem.setName( electroItemDTO.getName() );
        electroItem.setPrice( electroItemDTO.getPrice() );
        electroItem.setCount( electroItemDTO.getCount() );
        electroItem.setArchive( electroItemDTO.isArchive() );
        electroItem.setDescription( electroItemDTO.getDescription() );
    }
}
