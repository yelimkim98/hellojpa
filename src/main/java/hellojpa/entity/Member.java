package hellojpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // auto increment
    private Long id;

    @Column(name = "username")      // username : DB 컬럼명
    private String name;

//    @Enumerated(EnumType.ORDINAL)     // ordinal 절대 쓰지 말자..
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

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
}
