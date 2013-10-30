package com.song7749.order.repositories;

import com.song7749.order.entities.Order;

/**
 * <pre>
 * Class Name : OrderRepository.java
 * Description :
 *
 *  Modification Information
 *  Modify Date 	Modifier	Comment
 *  -----------------------------------------------
 *  2013. 10. 23.	song7749	주문 객체 저장소 인터페이스
 *
 * </pre>
 *
 * @author song7749
 * @since 2013. 10. 23.
 */

public interface OrderRepository {
	/**
	 * 주문 저장
	 * @param order
	 * @return Order
	 */
	void save(Order order);

	/**
	 * 주문 번호를 이용한 주문 조회
	 * @param order
	 * @return Order
	 */
	Order findByOrderNumberSeq(Order order);
}