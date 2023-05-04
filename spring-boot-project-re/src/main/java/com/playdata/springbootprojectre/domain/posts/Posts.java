package com.playdata.springbootprojectre.domain.posts;

import com.playdata.springbootprojectre.domain.AuditingEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends AuditingEntity {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id; //BIGINT

    @Column(length = 500, nullable = false) // 속성을 변경해줄 수 잇음
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // text 타입으로 매핑
    private String content;

    @Column // Column을 달지 않아도 괜찮음, Entity가 있기 때문
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
