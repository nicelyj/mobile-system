package com.song7749.order.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "tOrderGoodsDelivery")
@org.hibernate.annotations.Table(comment = "주문 상품 배송정보", appliesTo = "tOrderGoodsDelivery")
public class OrderGoodsDelivery {

	/**
	 * 주문상품 고유키
	 */
	@Id
	@GenericGenerator(name="foreign_one_to_one_generator", strategy = "foreign",parameters = @Parameter(name="property",value="orderGoods"))
	@GeneratedValue(generator = "foreign_one_to_one_generator")
	@Column(name = " nOrderGoodsSeq", columnDefinition = "int(10) unsigned COMMENT '주문상품 고유키'", nullable = false)
	private Long orderGoodsSeq;

	/**
	 * 배송업체고유키
	 */
	@Column(name = " nDeliveryCompanySeq", columnDefinition = "int(10) unsigned COMMENT '배송업체고유키'", nullable = false)
	private Long deliveryCompanySeq;

	/**
	 * 송장번호
	 */
	@Column(name = " sInvoiceNumber", columnDefinition = "varchar(20) COMMENT '송장번호'", nullable = true)
	private String invoiceNumber;

	/**
	 * WMS 주문상태정보 고유키
	 */
	@Column(name = " nWMSOrderStateSeq", columnDefinition = "int(10) unsigned COMMENT 'WMS 주문상태정보 고유키'", nullable = false)
	private Long wMSOrderStateSeq;

	/**
	 * WMS 주문상품 바코트 정보 (Interleaved2of5 타입)
	 */
	@Column(name = " sWMSBarcode", columnDefinition = "varchar(30) COMMENT 'WMS 주문상품 바코트 정보 (Interleaved2of5 타입)'", nullable = true)
	private String wMSBarcode;

	/**
	 * 주문상태정보 고유키
	 */
	@Column(name = " nOrderStateSeq", columnDefinition = "int(10) unsigned COMMENT '주문상태정보 고유키'", nullable = false)
	private Long orderStateSeq;


	@OneToOne(fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@JoinColumn(name="nGoodsSeq")
	private OrderGoods orderGoods;

	/**
	 * 기본 생성자
	 */
	public OrderGoodsDelivery() {
	}

	/**
	 * Setter 생성자
	 */
	public OrderGoodsDelivery(Long deliveryCompanySeq, String invoiceNumber,
			Long wMSOrderStateSeq, String wMSBarcode, Long orderStateSeq) {
		this.deliveryCompanySeq = deliveryCompanySeq;
		this.invoiceNumber = invoiceNumber;
		this.wMSOrderStateSeq = wMSOrderStateSeq;
		this.wMSBarcode = wMSBarcode;
		this.orderStateSeq = orderStateSeq;
	}

	/**
	 * 주문상품 고유키 setter
	 */
	public void setOrderGoodsSeq(Long orderGoodsSeq) {
		this.orderGoodsSeq = orderGoodsSeq;
	}

	/**
	 * 주문상품 고유키 getter
	 */
	public Long getOrderGoodsSeq() {
		return this.orderGoodsSeq;
	}

	/**
	 * 배송업체고유키 setter
	 */
	public void setDeliveryCompanySeq(Long deliveryCompanySeq) {
		this.deliveryCompanySeq = deliveryCompanySeq;
	}

	/**
	 * 배송업체고유키 getter
	 */
	public Long getDeliveryCompanySeq() {
		return this.deliveryCompanySeq;
	}

	/**
	 * 송장번호 setter
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 * 송장번호 getter
	 */
	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	/**
	 * WMS 주문상태정보 고유키 setter
	 */
	public void setWMSOrderStateSeq(Long wMSOrderStateSeq) {
		this.wMSOrderStateSeq = wMSOrderStateSeq;
	}

	/**
	 * WMS 주문상태정보 고유키 getter
	 */
	public Long getWMSOrderStateSeq() {
		return this.wMSOrderStateSeq;
	}

	/**
	 * WMS 주문상품 바코트 정보 (Interleaved2of5 타입) setter
	 */
	public void setWMSBarcode(String wMSBarcode) {
		this.wMSBarcode = wMSBarcode;
	}

	/**
	 * WMS 주문상품 바코트 정보 (Interleaved2of5 타입) getter
	 */
	public String getWMSBarcode() {
		return this.wMSBarcode;
	}

	/**
	 * 주문상태정보 고유키 setter
	 */
	public void setOrderStateSeq(Long orderStateSeq) {
		this.orderStateSeq = orderStateSeq;
	}

	/**
	 * 주문상태정보 고유키 getter
	 */
	public Long getOrderStateSeq() {
		return this.orderStateSeq;
	}

	/**
	 * @return the orderGoods
	 */
	public OrderGoods getOrderGoods() {
		return orderGoods;
	}

	/**
	 * @param orderGoods the orderGoods to set
	 */
	public void setOrderGoods(OrderGoods orderGoods) {
		this.orderGoods = orderGoods;
	}


}