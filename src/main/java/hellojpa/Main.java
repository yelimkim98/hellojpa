package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        /* transaction 시작*/
        Team cutePeople = new Team("귀요미");

        Member jongseong = new Member("이종성", 23, cutePeople);
        Member yelim = new Member("김예림", 23, cutePeople);

        entityManager.persist(cutePeople);
        entityManager.persist(jongseong);
        entityManager.persist(yelim);

        /* transaction 끝 */
        transaction.commit();

        emf.close();
    }
}
