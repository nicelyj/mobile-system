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
import javax.persistence.Table;

import com.song7749.base.BaseObject;

/**
 * <pre>
 * Class Name : OrderAdvertisementInfo.java
 * Description : 주문별 광고 정보
 *
 *  Modification Information
 *  Modify Date 	Modifier	Comment
 *  -----------------------------------------------
 *  2013. 11. 5.	song7749	신규생성
 *
 * </pre>
 *
 * @author song7749
 * @since 2013. 11. 5.
 */

@Entity
@Table(name = "tOrderAdvertisementInfo")
@org.hibernate.annotations.Table(comment = "주문별 광고 정보", appliesTo = "tOrderAdvertisementInfo")
public class OrderAdvertisementInfo extends BaseObject{

	private static final long serialVersionUID = 3237207876689178122L;

	/**
	* 주문별 광고정보 고유키
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name=" nOrderAdvertisementInfoSeq" , columnDefinition="int(10) unsigned COMMENT '주문별 광고정보 고유키'", nullable=false)
	private Long orderAdvertisementInfoSeq;

	/**
	* 광고 고유키
	*/
	@Column(name=" nAdvertisementSeq" , columnDefinition="int(10) unsigned COMMENT '광고 고유키'", nullable=false)
	private Long advertisementSeq;

	/**
	 * 주문 (부모 객체)
	 */
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "nOrderNumberSeq",nullable=false)
	private Order order;

	/**
	* 기본 생성자
	*/
	public OrderAdvertisementInfo(){}
	/**
	* Setter 생성자
	*/
	public OrderAdvertisementInfo(Long advertisementSeq){
		this.advertisementSeq=advertisementSeq;
	}
	/**
	* 주문별 광고정보 고유키 setter
	*/
	public void setOrderAdvertisementInfoSeq(Long orderAdvertisementInfoSeq){
		this.orderAdvertisementInfoSeq = orderAdvertisementInfoSeq;
	}
	/**
	* 주문별 광고정보 고유키 getter
	*/
	public Long getOrderAdvertisementInfoSeq(){
		return this.orderAdvertisementInfoSeq;
	}

	/**
	* 광고 고유키 setter
	*/
	public void setAdvertisementSeq(Long advertisementSeq){
		this.advertisementSeq = advertisementSeq;
	}
	/**
	* 광고 고유키 getter
	*/
	public Long getAdvertisementSeq(){
		return this.advertisementSeq;
	}
	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
}