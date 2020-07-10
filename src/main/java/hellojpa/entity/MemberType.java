package hellojpa.entity;

public enum MemberType {
    /**
     * 엔티티에서 @Enumerated(EnumType.ORDINAL) 어노테이션으로 사용된다고 하자.
     *
     * EnumType.ORDINAL 이거때문에
     * USER 가 0, ADMIN 이 1 이런식으로 들어감.
     *
     * USER, ADMIN  -->  USER, FAKE_USER, ADMIN 이렇게
     * 중간에 새 enum 필드가 끼게되면
     * 기존에 저장되어있던 0, 1 의미까지 이상해짐...
     *
     * 그러니까 무조건 @Enumerated(EnumType.STRING) 쓰자.
     */
    USER, ADMIN
}
