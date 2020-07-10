package hellojpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "member")
public class Member {

    @Id
    private Long id;
    private String name;

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
