package ru.isands.test.estore.dao.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class ElectronicShopItemId implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *  Идентификатор магазина
	 */
	private Long shopId;

	/**
	 *  Идентификатор электротовара
	 */
	private Long electronicItemId;

}
