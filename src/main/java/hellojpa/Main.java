package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager =  emf.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Team teamA = new Team();
        teamA.setName("이따비");

        entityManager.persist(teamA);  // persist 뜻 : 영구저장하다.  이렇게 생각하면 된다.

        Member member = new Member();
        member.setName("김예림");
        member.setTeam(teamA);

        entityManager.persist(member);  // persist 뜻 : 영구저장하다.  이렇게 생각하면 된다.

        entityManager.flush();  // DB 에 쿼리 전부 보내기
        entityManager.clear();  // 캐시 비우기

        /** 역방향 조회하기 */

        /*
         * Member foundMember = entityManager.find(Member.class, member.getId());
         * Team foundTeam = foundMember.getTeam();
         * */
        Team foundTeam = entityManager.find(Team.class, teamA.getId());

        for (Member found : foundTeam.getMembers()) {
            System.out.println(found);
        }

        entityTransaction.commit();

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
