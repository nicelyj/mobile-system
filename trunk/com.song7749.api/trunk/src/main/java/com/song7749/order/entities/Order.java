package com.song7749.order.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnTransformer;

import com.song7749.base.BaseObject;

/**
 * <pre>
 * Class Name : Order.java
 * Description :
 *
 *  Modification Information
 *  Modify Date 	Modifier	Comment
 *  -----------------------------------------------
 *  2013. 10. 23.	song7749	주문 객체
 *
 * </pre>
 *
 * @author song7749
 * @since 2013. 10. 23.
 */

@Entity
@Table(name = "tOrder")
@org.hibernate.annotations.Table(comment = "주문", appliesTo = "tOrder")
public class Order extends BaseObject {

	private static final long serialVersionUID = -2793083177124951030L;

	/**
	 * 주문번호
	 */
	@Id
	@Column(name = " nOrderNumberSeq", columnDefinition = "int(10) unsigned COMMENT '주문번호'", nullable = false)
	private Long orderNumberSeq;

	/**
	 * 결제수단 고유키
	 */
//	@Transient 무시하기
	@Column(name = " nPaymentMethodSeq", columnDefinition = "int(10) unsigned COMMENT '결제수단 고유키'", nullable = false)
	private Long paymentMethodSeq;

	/**
	 * 배송방법 고유키
	 */
	@Column(name = " nDeliverySeq", columnDefinition = "int(10) unsigned COMMENT '배송방법 고유키'", nullable = false)
	private Long deliverySeq;

	/**
	 * 주문상태정보 고유키
	 */
	@Column(name = " nOrderStateSeq", columnDefinition = "int(10) unsigned COMMENT '주문상태정보 고유키'", nullable = false)
	private Long orderStateSeq;

	/**
	 * MP별 기본정보 고유키
	 */
	@Column(name = " nMarketPlaceSeq", columnDefinition = "int(10) unsigned COMMENT 'MP별 기본정보 고유키'", nullable = false)
	private Long marketPlaceSeq;

	/**
	 * 주문회원 아이디
	 */
	@Column(name = " sMemberId", columnDefinition = "varchar(20) COMMENT '주문회원 아이디'", nullable = true)
	@ColumnTransformer(read = "unseal_text(sMemberId)", write = "seal_text(?)")
	private String memberId;

	/**
	 * 주문회원 고유키
	 */
	@Column(name = " nMemberSeq", columnDefinition = "int(10) unsigned COMMENT '주문회원 고유키'", nullable = false)
	private Long memberSeq;

	/**
	 * 등록일
	 */
	@Column(name = " dtCreateDate", columnDefinition = "date COMMENT '등록일'", nullable = false)
	private Date createDate;

	/**
	 * 등록시간
	 */
	@Column(name = " dtCreateTime", columnDefinition = "time COMMENT '등록시간'", nullable = false)
	private Time createTime;

	/**
	 * 주문회원 아이피
	 */
	@Column(name = " sMemberIP", columnDefinition = "varchar(39) COMMENT '주문회원 아이피'", nullable = true)
	@ColumnTransformer(read = "unseal_text(sMemberIP)", write = "seal_text(?)")
	private String memberIP;

	/**
	 * 결제금액
	 */
	@Column(name = " nPrice", columnDefinition = "int(10) COMMENT '결제금액'", nullable = true)
	private Integer price;

	/**
	 * 증빙서류 고유키
	 */
	@Column(name = " nVoucherSeq", columnDefinition = "int(10) unsigned COMMENT '증빙서류 고유키'", nullable = false)
	private Long voucherSeq;

	/**
	 * 총 배송비금액
	 */
	@Column(name = " nTotalDeliveryPrice", columnDefinition = "int(10) unsigned COMMENT '총 배송비금액'", nullable = false)
	private Long totalDeliveryPrice;

	/**
	 * 주문자 주민번호
	 */
	@Column(name = " sIDNumber", columnDefinition = "varchar(64) COMMENT '주문자 주민번호'", nullable = true)
	private String iDNumber;

	/**
	 * 주문 상품 객체
	 */
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 10)
	private final List<OrderGoods> orderGoodsList = new ArrayList<OrderGoods>();

	/**
	 * 주문 상품 광고 객체
	 */
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 10)
	private final List<OrderAdvertisementInfo> orderAdvertisementInfoList = new ArrayList<OrderAdvertisementInfo>();

	public Order() {
	}

	public Order(Long paymentMethodSeq, Long deliverySeq, Long orderStateSeq,
			Long marketPlaceSeq, String memberId, Long memberSeq,
			Date createDate, Time createTime, String memberIP, Integer price,
			Long voucherSeq, Long totalDeliveryPrice, String iDNumber) {

		this.paymentMethodSeq = paymentMethodSeq;
		this.deliverySeq = deliverySeq;
		this.orderStateSeq = orderStateSeq;
		this.marketPlaceSeq = marketPlaceSeq;
		this.memberId = memberId;
		this.memberSeq = memberSeq;
		this.createDate = createDate;
		this.createTime = createTime;
		this.memberIP = memberIP;
		this.price = price;
		this.voucherSeq = voucherSeq;
		this.totalDeliveryPrice = totalDeliveryPrice;
		this.iDNumber = iDNumber;
	}

	/**
	 * 주문번호 setter
	 */
	public Long setOrderNumberSeq(Long orderNumberSeq) {
		return this.orderNumberSeq = orderNumberSeq;
	}

	/**
	 * 주문번호 getter
	 */
	public Long getOrderNumberSeq() {
		return this.orderNumberSeq;
	}

	/**
	 * 결제수단 고유키 setter
	 */
	public void setPaymentMethodSeq(Long paymentMethodSeq) {
		this.paymentMethodSeq = paymentMethodSeq;
	}

	/**
	 * 결제수단 고유키 getter
	 */
	public Long getPaymentMethodSeq() {
		return this.paymentMethodSeq;
	}

	/**
	 * 배송방법 고유키 setter
	 */
	public void setDeliverySeq(Long deliverySeq) {
		this.deliverySeq = deliverySeq;
	}

	/**
	 * 배송방법 고유키 getter
	 */
	public Long getDeliverySeq() {
		return this.deliverySeq;
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
	 * MP별 기본정보 고유키 setter
	 */
	public void setMarketPlaceSeq(Long marketPlaceSeq) {
		this.marketPlaceSeq = marketPlaceSeq;
	}

	/**
	 * MP별 기본정보 고유키 getter
	 */
	public Long getMarketPlaceSeq() {
		return this.marketPlaceSeq;
	}

	/**
	 * 주문회원 아이디 setter
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * 주문회원 아이디 getter
	 */
	public String getMemberId() {
		return this.memberId;
	}

	/**
	 * 주문회원 고유키 setter
	 */
	public void setMemberSeq(Long memberSeq) {
		this.memberSeq = memberSeq;
	}

	/**
	 * 주문회원 고유키 getter
	 */
	public Long getMemberSeq() {
		return this.memberSeq;
	}

	/**
	 * 등록일 setter
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 등록일 getter
	 */
	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 등록시간 setter
	 */
	public void setCreateTime(Time createTime) {
		this.createTime = createTime;
	}

	/**
	 * 등록시간 getter
	 */
	public Time getCreateTime() {
		return this.createTime;
	}

	/**
	 * 주문회원 아이피 setter
	 */
	public void setMemberIP(String memberIP) {
		this.memberIP = memberIP;
	}

	/**
	 * 주문회원 아이피 getter
	 */
	public String getMemberIP() {
		return this.memberIP;
	}

	/**
	 * 결제금액 setter
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * 결제금액 getter
	 */
	public Integer getPrice() {
		return this.price;
	}

	/**
	 * 증빙서류 고유키 setter
	 */
	public void setVoucherSeq(Long voucherSeq) {
		this.voucherSeq = voucherSeq;
	}

	/**
	 * 증빙서류 고유키 getter
	 */
	public Long getVoucherSeq() {
		return this.voucherSeq;
	}

	/**
	 * 총 배송비금액 setter
	 */
	public void setTotalDeliveryPrice(Long totalDeliveryPrice) {
		this.totalDeliveryPrice = totalDeliveryPrice;
	}

	/**
	 * 총 배송비금액 getter
	 */
	public Long getTotalDeliveryPrice() {
		return this.totalDeliveryPrice;
	}

	/**
	 * 주문자 주민번호 setter
	 */
	public void setIDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}

	/**
	 * 주문자 주민번호 getter
	 */
	public String getIDNumber() {
		return this.iDNumber;
	}

	/**
	 * 주문 상품 추가
	 *
	 * @param orderGoods
	 */
	public void addOrderGoods(OrderGoods orderGoods) {
		if (orderGoods == null) {
			throw new IllegalArgumentException("orderGoods is null !");
		}
		orderGoods.setOrder(this);
		this.orderGoodsList.add(orderGoods);
	}

	public void removeOrderGoods(OrderGoods orderGoods) {
		if (orderGoods == null) {
			throw new IllegalArgumentException("orderGoods is null !");
		}
		this.orderGoodsList.remove(orderGoods);
	}

	/**
	 * 주문 상품 조회
	 *
	 * @return List<orderGoods>
	 */
	public List<OrderGoods> getOrderGoodsList() {
		return orderGoodsList;
	}

	/**
	 * 주문 광고 정보 추가
	 * @param orderAdvertisementInfo
	 */
	public void addOrderAdvertisementInfo(OrderAdvertisementInfo orderAdvertisementInfo){
		if(null==orderAdvertisementInfo){
			throw new IllegalArgumentException("orderAdvertisementInfo is null !");
		}
		orderAdvertisementInfo.setOrder(this);
		this.orderAdvertisementInfoList.add(orderAdvertisementInfo);
	}

	/**
	 * 주문 광고 조회
	 * @return the orderAdvertisementInfoList
	 */
	public List<OrderAdvertisementInfo> getOrderAdvertisementInfoList() {
		return orderAdvertisementInfoList;
	}
}