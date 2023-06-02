package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Author: liuchuanlong
 * @Date: 2023/6/2 16:50
 */
public class StreamDemo {

    public static void main(String[] args) {

        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));
    }

    public static List<Author> getAuthors() {
        // 数据初始化
        Author author1 = new Author(1L, "蒙多", 33, "一个从菜刀中明悟真理的祖安人", null);
        Author author2 = new Author(2L, "亚索", 15, "死亡如风，常伴吾身", null);
        Author author3 = new Author(3L, "易大师", 14, "一击几盏", null);
        Author author4 = new Author(3L, "易大师", 14, "一击几盏", null);

        // 书籍列表
        ArrayList<Book> books1 = new ArrayList<>();
        ArrayList<Book> books2 = new ArrayList<>();
        ArrayList<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "马克思主义思想", "哲学，小说", 88, "一本烂书"));
        books1.add(new Book(2L, "列宁思想", "教育，爱情", 88, "一本烂书"));


        books2.add(new Book(3L, "毛思想", "哲学", 88, "一本烂书"));
        books2.add(new Book(3L, "邓理论", "哲学", 88, "一本烂书"));
        books2.add(new Book(4L, "邓理论", "爱情,个人传记", 88, "一本烂书"));

        books3.add(new Book(5L, "肯尼迪", "爱情", 88, "一本烂书"));
        books2.add(new Book(6L, "麦肯锡", "个人传记", 88, "一本烂书"));
        books2.add(new Book(6L, "麦肯锡", "个人传记", 88, "一本烂书"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        return new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
    }
}
