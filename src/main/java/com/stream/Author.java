package com.stream;

import lombok.*;

import java.util.List;

/**
 * @Author: Aaron
 * @Date: 2023/6/2 16:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Author {

    private Long id;

    private String name;

    private Integer age;

    private String intro;

    private List<Book> books;
}
