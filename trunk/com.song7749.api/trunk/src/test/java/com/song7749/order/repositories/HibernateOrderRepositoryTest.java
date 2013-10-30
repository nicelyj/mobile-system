package com.song7749.order.repositories;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.sql.Time;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.song7749.order.entities.Order;
import com.song7749.order.entities.OrderGoods;
import com.song7749.order.entities.OrderGoodsDelivery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/root-context.xml" })
@TransactionConfiguration(transactionManager="billingTransactionManager",defaultRollback=false)
public class HibernateOrderRepositoryTest {

	@Resource
	OrderRepository hibernateOrderRepository;

	@Resource
	protected SessionFactory billingSessionFactory;
	Session session;

	/* fixture */
	Order order;

	@Before
	public void setUp() throws Exception {
		order = new Order();
		session = billingSessionFactory.getCurrentSession();
	}

	@Test
	@Transactional
	public void testSave() throws Exception {
		order.setOrderNumberSeq(1L);
		order.setCreateDate(new Date(System.currentTimeMillis()));
		order.setCreateTime(new Time(System.currentTimeMillis()));
		order.setDeliverySeq(1L);
		order.setIDNumber("1");
		order.setMarketPlaceSeq(1L);
		order.setMemberId("쀍");
		order.setMemberIP("1111");
		order.setMemberSeq(1L);
		order.setOrderStateSeq(1L);
		order.setPaymentMethodSeq(1L);
		order.setPrice(1000);
		order.setTotalDeliveryPrice(100L);
		order.setVoucherSeq(1L);

		OrderGoods orderGoods = new OrderGoods(1L, 1L, 1L, "aaaa", 1000L, 1000L, 100, 1000L, 1L, 1L, 1000);
		OrderGoods orderGoods2 = new OrderGoods(2L, 2L, 2L, "bbbb", 1000L, 1000L, 100, 1000L, 1L, 1L, 1000);

		OrderGoodsDelivery orderGoodsDelivery = new OrderGoodsDelivery(1L, "1234", 1L, "aaaaa", 1L);
		orderGoods.setOrderGoodsDelivery(orderGoodsDelivery );

		orderGoods.setOrder(order);
		order.addOrderGoods(orderGoods);
		order.addOrderGoods(orderGoods2);
		hibernateOrderRepository.save(order);


		// 저장하려는 객체와 이미 저장되어 있는 객체간에 데이터 일치를 검증한다.
		Order selectedOrder = (Order)session.createCriteria(order.getClass()).add(Restrictions.eq("orderNumberSeq", 1L)).list().get(0);

		assertThat(order, is(selectedOrder));
		assertThat(selectedOrder.getOrderGoodsList().size(), is(order.getOrderGoodsList().size()));

		selectedOrder.getOrderGoodsList().remove(0);
		session.save(order);
	}

	@Test
	@Transactional(readOnly=true)
	public void testFindByOrderNumberSeq() throws Exception {
		order.setOrderNumberSeq(1L);
		Order selectedOrder = hibernateOrderRepository.findByOrderNumberSeq(order);

		assertThat(selectedOrder.getOrderNumberSeq(), is(order.getOrderNumberSeq()));
	}
}