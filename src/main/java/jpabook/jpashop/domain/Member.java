package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(indexes = @Index()) //index도 넣어주는게 좋아, jpql에 where 문 짤 때 바로 확인하고 짤 수 있음
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
//    @Column(length = 10) //메타데이터를 Entity에 직접 적어주면 개발자가 알 수 있으니 좋음
    private String name;
    private String city;
    private String street;
    private String zipcode;

    //이 연관관계는 굳이 필요하지 않음.
    //주문이 필요하면 주문에서 시작하면 됨
    //JPQL도 ORDER 파라미터에 MEMBER를 넘길 수 있음?
    //필요하면 따로 조회 해
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); //관례상

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
