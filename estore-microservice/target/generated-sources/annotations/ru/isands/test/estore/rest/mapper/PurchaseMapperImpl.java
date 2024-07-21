package ru.isands.test.estore.rest.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.isands.test.estore.dao.entity.Purchase;
import ru.isands.test.estore.dto.PurchaseDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T15:45:11+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.23 (Amazon.com Inc.)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private PurchaseTypeMapper purchaseTypeMapper;

    @Override
    public Purchase toEntity(PurchaseDTO purchaseDTO) {
        if ( purchaseDTO == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        purchase.setElectroId( purchaseDTO.getElectroId() );
        purchase.setEmployeeId( employeeMapper.map( purchaseDTO.getEmployeeId() ) );
        purchase.setShopId( shopMapper.map( purchaseDTO.getShopId() ) );
        purchase.setPurchaseDate( purchaseDTO.getPurchaseDate() );
        purchase.setTypeId( purchaseTypeMapper.map( purchaseDTO.getTypeId() ) );

        return purchase;
    }

    @Override
    public PurchaseDTO toDto(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        PurchaseDTO purchaseDTO = new PurchaseDTO();

        purchaseDTO.setElectroId( purchase.getElectroId() );
        purchaseDTO.setEmployeeId( employeeMapper.map( purchase.getEmployeeId() ) );
        purchaseDTO.setShopId( shopMapper.map( purchase.getShopId() ) );
        purchaseDTO.setPurchaseDate( purchase.getPurchaseDate() );
        purchaseDTO.setTypeId( purchaseTypeMapper.map( purchase.getTypeId() ) );

        return purchaseDTO;
    }

    @Override
    public void updateEntityFromDto(PurchaseDTO purchaseDTO, Purchase purchase) {
        if ( purchaseDTO == null ) {
            return;
        }

        purchase.setElectroId( purchaseDTO.getElectroId() );
        purchase.setEmployeeId( employeeMapper.map( purchaseDTO.getEmployeeId() ) );
        purchase.setShopId( shopMapper.map( purchaseDTO.getShopId() ) );
        purchase.setPurchaseDate( purchaseDTO.getPurchaseDate() );
        purchase.setTypeId( purchaseTypeMapper.map( purchaseDTO.getTypeId() ) );
    }
}
