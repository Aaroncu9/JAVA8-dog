package com.stream;


import lombok.*;

/**
 * @Author: liuchuanlong
 * @Date: 2023/6/2 16:42
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {

    private Long id;

    private String name;

    private String category;

    private Integer score;

    private String intro;
}
