package com.song7749.order.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.song7749.base.BaseObject;

@Entity
@Table(name = "tOrderTaxInvoice")
@org.hibernate.annotations.Table(comment = "주문 세금계산서 정보", appliesTo = "tOrderTaxInvoice")
public class OrderTaxInvoice extends BaseObject{

	private static final long serialVersionUID = -6312106868538989248L;

	/**
	* 주문별 세금계산서 신청 고유번호
	*/
	@Id
	@Column(name=" nOrderTaxInvoiceSeq" , columnDefinition="int(10) unsigned COMMENT '주문별 세금계산서 신청 고유번호'", nullable=false)
	private Long orderTaxInvoiceSeq;

	/**
	* 주문번호
	*/
	@Column(name=" nOrderNumberSeq" , columnDefinition="int(10) unsigned COMMENT '주문번호'", nullable=false)
	private Long orderNumberSeq;

	/**
	* 사업자 등록번호
	*/
	@Column(name=" sCompanyNumber" , columnDefinition="char(12) COMMENT '사업자 등록번호'", nullable=true)
	private String companyNumber;

	/**
	* 대표자
	*/
	@Column(name=" sCEOName" , columnDefinition="varchar(30) COMMENT '대표자'", nullable=true)
	private String cEOName;

	/**
	* 판매자 상호
	*/
	@Column(name=" sCompanyName" , columnDefinition="varchar(20) COMMENT '판매자 상호'", nullable=true)
	private String companyName;

	/**
	* 주소
	*/
	@Column(name=" sAddress" , columnDefinition="varchar(200) COMMENT '주소'", nullable=true)
	private String address;

	/**
	* 업태
	*/
	@Column(name=" sBusinessType" , columnDefinition="varchar(50) COMMENT '업태'", nullable=true)
	private String businessType;

	/**
	* 종목
	*/
	@Column(name=" sBusinessItem" , columnDefinition="varchar(50) COMMENT '종목'", nullable=true)
	private String businessItem;

	/**
	* 이메일
	*/
	@Column(name=" sEmail" , columnDefinition="varchar(50) COMMENT '이메일'", nullable=true)
	private String email;

	/**
	* 기본 생성자
	*/
	public OrderTaxInvoice(){}
	/**
	* Setter 생성자
	*/
	public OrderTaxInvoice(Long orderNumberSeq,String companyNumber,String cEOName,String companyName,String address,String businessType,String businessItem,String email){
		this.orderNumberSeq=orderNumberSeq;
		this.companyNumber=companyNumber;
		this.cEOName=cEOName;
		this.companyName=companyName;
		this.address=address;
		this.businessType=businessType;
		this.businessItem=businessItem;
		this.email=email;
	}
	/**
	* 주문별 세금계산서 신청 고유번호 setter
	*/
	public void setOrderTaxInvoiceSeq(Long orderTaxInvoiceSeq){
		this.orderTaxInvoiceSeq = orderTaxInvoiceSeq;
	}
	/**
	* 주문별 세금계산서 신청 고유번호 getter
	*/
	public Long getOrderTaxInvoiceSeq(){
		return this.orderTaxInvoiceSeq;
	}
	/**
	* 주문번호 setter
	*/
	public void setOrderNumberSeq(Long orderNumberSeq){
		this.orderNumberSeq = orderNumberSeq;
	}
	/**
	* 주문번호 getter
	*/
	public Long getOrderNumberSeq(){
		return this.orderNumberSeq;
	}
	/**
	* 사업자 등록번호 setter
	*/
	public void setCompanyNumber(String companyNumber){
		this.companyNumber = companyNumber;
	}
	/**
	* 사업자 등록번호 getter
	*/
	public String getCompanyNumber(){
		return this.companyNumber;
	}
	/**
	* 대표자 setter
	*/
	public void setCEOName(String cEOName){
		this.cEOName = cEOName;
	}
	/**
	* 대표자 getter
	*/
	public String getCEOName(){
		return this.cEOName;
	}
	/**
	* 판매자 상호 setter
	*/
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	/**
	* 판매자 상호 getter
	*/
	public String getCompanyName(){
		return this.companyName;
	}
	/**
	* 주소 setter
	*/
	public void setAddress(String address){
		this.address = address;
	}
	/**
	* 주소 getter
	*/
	public String getAddress(){
		return this.address;
	}
	/**
	* 업태 setter
	*/
	public void setBusinessType(String businessType){
		this.businessType = businessType;
	}
	/**
	* 업태 getter
	*/
	public String getBusinessType(){
		return this.businessType;
	}
	/**
	* 종목 setter
	*/
	public void setBusinessItem(String businessItem){
		this.businessItem = businessItem;
	}
	/**
	* 종목 getter
	*/
	public String getBusinessItem(){
		return this.businessItem;
	}
	/**
	* 이메일 setter
	*/
	public void setEmail(String email){
		this.email = email;
	}
	/**
	* 이메일 getter
	*/
	public String getEmail(){
		return this.email;
	}
}