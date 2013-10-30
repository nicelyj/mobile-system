package com.song7749.order.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.song7749.base.BaseObject;

@Entity
@Table(name = "tOrderGoods")
@org.hibernate.annotations.Table(comment = "주문상품", appliesTo = "tOrderGoods")
public class OrderGoods extends BaseObject {

	private static final long serialVersionUID = -7152714832477261951L;

	/**
	 * 주문상품 고유키
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = " nOrderGoodsSeq", columnDefinition = "int(10) unsigned COMMENT '주문상품 고유키'", nullable = false)
	private Long orderGoodsSeq;

	/**
	 * 상품기본정보 고유키
	 */
	@Column(name = " nGoodsSeq", columnDefinition = "int(10) unsigned COMMENT '상품기본정보 고유키'", nullable = false)
	private Long goodsSeq;

	/**
	 * 판매자 기본정보 고유키
	 */
	@Column(name = " nSellerSeq", columnDefinition = "int(10) unsigned COMMENT '판매자 기본정보 고유키'", nullable = false)
	private Long sellerSeq;

	/**
	 * 주문상태정보 고유키
	 */
	@Column(name = " nOrderStateSeq", columnDefinition = "int(10) unsigned COMMENT '주문상태정보 고유키'", nullable = false)
	private Long orderStateSeq;

	/**
	 * 상품명
	 */
	@Column(name = " sGoodsName", columnDefinition = "varchar(200) COMMENT '상품명'", nullable = true)
	private String goodsName;

	/**
	 * 상품가격
	 */
	@Column(name = " nPrice", columnDefinition = "int(10) unsigned COMMENT '상품가격'", nullable = false)
	private Long price;

	/**
	 * 수수료 적용금액
	 */
	@Column(name = " nCommissionPrice", columnDefinition = "int(10) unsigned COMMENT '수수료 적용금액'", nullable = false)
	private Long commissionPrice;

	/**
	 * 갯수
	 */
	@Column(name = " nQuantity", columnDefinition = "smallint(5) unsigned COMMENT '갯수'", nullable = false)
	private Integer quantity;

	/**
	 * 배송비
	 */
	@Column(name = " nDeliveryPrice", columnDefinition = "int(10) unsigned COMMENT '배송비'", nullable = false)
	private Long deliveryPrice;

	/**
	 * 배송수단 고유키
	 */
	@Column(name = " nDeliveryMethodSeq", columnDefinition = "int(10) unsigned COMMENT '배송수단 고유키'", nullable = false)
	private Long deliveryMethodSeq;

	/**
	 * 배송비 지급구분 고유키
	 */
	@Column(name = " nDeliveryPaymentDivisionSeq", columnDefinition = "int(10) unsigned COMMENT '배송비 지급구분 고유키'", nullable = false)
	private Long deliveryPaymentDivisionSeq;

	/**
	 * 할인금액
	 */
	@Column(name = " nDiscountPrice", columnDefinition = "int(10) COMMENT '할인금액'", nullable = false)
	private Integer discountPrice;

	/**
	 * 주문 (부모 객체)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nOrderNumberSeq",nullable=false)
	private Order order;

	/**
	 * 주문 상품 배송정보
	 */
	@OneToOne(mappedBy="orderGoods",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="nOrderGoodsSeq")
	private OrderGoodsDelivery orderGoodsDelivery;

	/**
	 * 기본 생성자
	 */
	public OrderGoods() {
	}

	/**
	 * Setter 생성자
	 */
	public OrderGoods(Long goodsSeq, Long sellerSeq, Long orderStateSeq,
			String goodsName, Long price, Long commissionPrice,
			Integer quantity, Long deliveryPrice, Long deliveryMethodSeq,
			Long deliveryPaymentDivisionSeq, Integer discountPrice) {
		this.goodsSeq = goodsSeq;
		this.sellerSeq = sellerSeq;
		this.orderStateSeq = orderStateSeq;
		this.goodsName = goodsName;
		this.price = price;
		this.commissionPrice = commissionPrice;
		this.quantity = quantity;
		this.deliveryPrice = deliveryPrice;
		this.deliveryMethodSeq = deliveryMethodSeq;
		this.deliveryPaymentDivisionSeq = deliveryPaymentDivisionSeq;
		this.discountPrice = discountPrice;
	}

	/**
	 * 주문상품 고유키 getter
	 */
	public Long getOrderGoodsSeq() {
		return this.orderGoodsSeq;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * 상품기본정보 고유키 setter
	 */
	public void setGoodsSeq(Long goodsSeq) {
		this.goodsSeq = goodsSeq;
	}

	/**
	 * 상품기본정보 고유키 getter
	 */
	public Long getGoodsSeq() {
		return this.goodsSeq;
	}

	/**
	 * 판매자 기본정보 고유키 setter
	 */
	public void setSellerSeq(Long sellerSeq) {
		this.sellerSeq = sellerSeq;
	}

	/**
	 * 판매자 기본정보 고유키 getter
	 */
	public Long getSellerSeq() {
		return this.sellerSeq;
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
	 * 상품명 setter
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * 상품명 getter
	 */
	public String getGoodsName() {
		return this.goodsName;
	}

	/**
	 * 상품가격 setter
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * 상품가격 getter
	 */
	public Long getPrice() {
		return this.price;
	}

	/**
	 * 수수료 적용금액 setter
	 */
	public void setCommissionPrice(Long commissionPrice) {
		this.commissionPrice = commissionPrice;
	}

	/**
	 * 수수료 적용금액 getter
	 */
	public Long getCommissionPrice() {
		return this.commissionPrice;
	}

	/**
	 * 갯수 setter
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 갯수 getter
	 */
	public Integer getQuantity() {
		return this.quantity;
	}

	/**
	 * 배송비 setter
	 */
	public void setDeliveryPrice(Long deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	/**
	 * 배송비 getter
	 */
	public Long getDeliveryPrice() {
		return this.deliveryPrice;
	}

	/**
	 * 배송수단 고유키 setter
	 */
	public void setDeliveryMethodSeq(Long deliveryMethodSeq) {
		this.deliveryMethodSeq = deliveryMethodSeq;
	}

	/**
	 * 배송수단 고유키 getter
	 */
	public Long getDeliveryMethodSeq() {
		return this.deliveryMethodSeq;
	}

	/**
	 * 배송비 지급구분 고유키 setter
	 */
	public void setDeliveryPaymentDivisionSeq(Long deliveryPaymentDivisionSeq) {
		this.deliveryPaymentDivisionSeq = deliveryPaymentDivisionSeq;
	}

	/**
	 * 배송비 지급구분 고유키 getter
	 */
	public Long getDeliveryPaymentDivisionSeq() {
		return this.deliveryPaymentDivisionSeq;
	}

	/**
	 * 할인금액 setter
	 */
	public void setDiscountPrice(Integer discountPrice) {
		this.discountPrice = discountPrice;
	}

	/**
	 * 할인금액 getter
	 */
	public Integer getDiscountPrice() {
		return this.discountPrice;
	}

	/**
	 * @return the orderGoodsDelivery
	 */
	public OrderGoodsDelivery getOrderGoodsDelivery() {
		return orderGoodsDelivery;
	}

	/**
	 * @param orderGoodsDelivery the orderGoodsDelivery to set
	 */
	public void setOrderGoodsDelivery(OrderGoodsDelivery orderGoodsDelivery) {
		if(orderGoodsDelivery != null){
			orderGoodsDelivery.setOrderGoods(this);
		}
		this.orderGoodsDelivery = orderGoodsDelivery;
	}


}