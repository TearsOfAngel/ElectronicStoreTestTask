package ru.isands.test.estore.dao.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(ElectronicShopItemId.class)
@Entity(name = "electronic_item_shop")
public class ElectroShop {
	
	/**
	 * Идентификатор магазина
	 */
	@Id
	@ManyToOne
	@JoinColumn(name = "shopId", nullable = false)
	private Shop shopId;
	
	/**
	 * Идентификатор электротовара
	 */
	@Id
	@ManyToOne
	@JoinColumn(name = "electronic_item_id", nullable = false)
	private ElectroItem electronicItemId;
	
	/**
	 * Оставшееся количество
	 */
	@Column(name = "count", nullable = false)
	int count;
}
