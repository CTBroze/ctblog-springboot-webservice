package net.ctblog.domain.posts;

import lombok.Builder; //해당 클래스의 빌더 패턴 클래스 생성, 생성자 상다에 선언시 생성자에 포함된 필드(객체)만 빌더에 포함
import lombok.Getter; //클래스내에 모든 필드에 Getter생성
import lombok.NoArgsConstructor; //기본생성자 자동추가
import net.ctblog.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타낸다, 기본값으로 카멜케이스 이름을 언더스코어네이밍으로 테이블 이름과 매칭한다.
public class Posts extends BaseTimeEntity { //참고 : Entity 클래스에는 Setter를 만들지 않는다(인스턴스 값이 어디서 변하는지 구분이 어려워짐), 필요시 각각의 메소드를 추가한다.

    @Id //해당 테이블의 PK 필드를 뜻한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성규칙을 나타낸다
    private Long id;

    @Column(length = 500, nullable = false) //Column을 굳이 선언하지 않아도 Entity클래스이기에 전부 Column취급이지만 기본값 이외 변경이 필요할때 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
