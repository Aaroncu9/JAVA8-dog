package com.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: Aaron
 * @Date: 2023/6/13 16:04
 */
public class CompletableFutureMallDemo {

    public static void main(String[] args) {
        Student student = new Student();
        student.setId(100).setName("xiaoming").setMajor("qigong");
        System.out.println(student.toString());
    }
}


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
class Student {
    private Integer id;
    private String name;
    private String major;
}
