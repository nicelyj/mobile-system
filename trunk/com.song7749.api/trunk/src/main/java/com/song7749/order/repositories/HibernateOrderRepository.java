package com.song7749.order.repositories;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.song7749.order.entities.Order;

@Repository("hibernateOrderRepository")
public class HibernateOrderRepository implements OrderRepository {

	@Resource
	protected SessionFactory billingSessionFactory;

	private final Session getSesson() {
		return billingSessionFactory.getCurrentSession();
	}

	@Override
	public void save(final Order order) {
		if(order == null){
			throw new IllegalArgumentException("order is null!");
		}
		getSesson().save(order);
	}

	@Override
	public Order findByOrderNumberSeq(Order order) {
		if(order == null){
			throw new IllegalArgumentException("order is null!");
		}
		if(order.getOrderNumberSeq() == null){
			throw new IllegalArgumentException("order.orderNumber is null!");
		}
		return (Order) getSesson().byId(order.getClass()).load(
				order.getOrderNumberSeq());
	}
}