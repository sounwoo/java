package com.example.practice.common.entity;


import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 상속했을 때, 컬럼으로 인식
@EntityListeners(AbstractMethodError.class) // 변경시 자동으로 기록됨
@Getter
public class BaseEntity {

    @CreationTimestamp // 생성되었을때 시간 생성
    @Column(updatable = false) // 수정시에는 관여 없음
    private LocalDateTime createAt;

    @UpdateTimestamp // 업데이트 했을때 시간 생성
    @Column(insertable = false) // 생성시에는 관여 없음
    private LocalDateTime updateAt;
}
