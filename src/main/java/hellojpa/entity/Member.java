package hellojpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // auto increment
    private Long id;
    @Column(name = "username")      // username : DB 컬럼명
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private MemberType memberType;
    @ManyToOne(fetch = FetchType.LAZY)      // fetch type 거의 lazy 쓰자. 속단해서 최적화하지 말자.
    @JoinColumn(name = "team_id")
    private Team team;

    /**
     *  getter, setter, 기본생성자 필요함.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Member{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", memberType=" + memberType +
            ", team=" + team +
            '}';
    }
}
