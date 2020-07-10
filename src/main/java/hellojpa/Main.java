package hellojpa;

import hellojpa.entity.Member;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hello");
        /*  윗줄에 대한 설명
         * persistence.xml 에 persistence-unit name="hello" 이부분!!
         * hello 라는 이름을 이용해서 EntityManagerFactory 객체를 생성한다.
         */
        EntityManager entityManager =  emf.createEntityManager();
        /* 실제 개발할때는 고객의 요청이 들어올 때 마다 Entity Manager 만들어서 쓰면 된다. */

        EntityTransaction entityTransaction = entityManager.getTransaction();
        /*
         * 엔티티매니저를 통해서 먼저 해야할 것은
         * 트랜젝션을 얻는 것이다.
         * JPA 의 모든 활동은 트랜젝션 안에서 이루어져야한다.
         */
        entityTransaction.begin();  // 트랜젝션이 시작된다.
        /** 요약 : DB에 접근해서, 트랜젝션을 가져온 담에, 트랜젝션을 시작한다. */

        Member member = new Member();
        member.setId(100L);
        member.setName("이종성");

        entityManager.persist(member);  // persist 뜻 : 영구저장하다.  이렇게 생각하면 된다.

        entityTransaction.commit();

        System.out.println("hello");
        emf.close();

        /**
         * 영상 마지막부분 필기
         *
         * 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유하고,
         * 엔티티 매니저는 쓰레드간 공유하면 안되고(사용하고 버리도록 하자),
         * JPA의 모든 데이터변경은 트랜젝션 안에서 실행
         */
    }
}
