package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

/*
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId);
*/

            //주문 객체를 만들어서 원하는 orderItem들을 넣을 수 있음
//            Order order = new Order();
//            order.addOrderItem(new OrderItem());

            //양방향 연관관계가 아니어도 이렇게 하면 된다.
            //조회 편의를 위해 양방향 연관관계를 사용한다.
            //예) order 엔티티를 조회했을 때 orderItems를 바로 알고싶을 때 (JPQL 짤 때 order 조회할 때 orderItems 끌고 오고싶을 때)
            //하지만 이것도 필요하면 orderItem을 다시 조회 하면 된다.
            //좀 더 객체지향적으로 짜고싶고, 비즈니스상 양방향 연관관계가 애플리케이션 개발이 더 순조로울때가 있음
            Order order = new Order();
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOder(order);

            em.persist(orderItem);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
