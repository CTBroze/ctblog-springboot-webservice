package com.ctbroze.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity클래스들이 이 클래스를 상속할 경우 필드들도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) //이 클래스에 Auditing기능을 포함한다
public class BaseTimeEntity {

    @CreatedDate //Entity가 생성될때의 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값이 변경될때의 시간을 저장합니다.
    private LocalDateTime modifiedDate;
}
