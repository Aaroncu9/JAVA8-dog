package com.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: liuchuanlong
 * @Date: 2023/6/2 16:50
 */
public class StreamDemo {

    public static void main(String[] args) {
        test14();
        // test13();
        // test12();
        // test11();
        // test10();
        // test9();
        // test8();
        // test7();
        // test6();
        // test5();
        // test4();
        // test3();
        // test2();
        // test(authors);
    }

    private static void test(List<Author> authors) {
        authors.stream()
                .distinct()
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));
    }

    public static void test2() {
        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(arr);
        stream.distinct()
                .filter(index -> index > 2)
                .forEach(System.out::println);
    }

    public static void test3() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("小黑", 19);
        map.put("小白", 17);
        map.put("小虎", 16);

        map.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 17).forEach(System.out::println);
    }

    public static void test4() {
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(author -> author.getName().length() > 2)
                .forEach(System.out::println);
    }

    public static void test5() {
        List<Author> authors = getAuthors();
        authors.stream().map(Author::getName)
                .forEach(System.out::println);
    }

    public static void test6() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Author::getAge))
                .forEach(author -> System.out.println(author.getName()));
    }

    public static void test7() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Author::getAge).reversed())
                .skip(1)
                .limit(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    public static void test8() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(System.out::println);
    }

    public static void test9() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);
    }

    public static void test10() {
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    public static void test11() {
        List<Author> authors = getAuthors();
        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .min(Comparator.comparingInt(s -> s));
        System.out.println(min.get());
    }

    public static void test12() {
        List<Author> authors = getAuthors();
        List<String> collect = authors.stream()
                .map(Author::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void test13() {
        List<Author> authors = getAuthors();
        List<String> collect = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void test14() {
        List<Author> authors = getAuthors();
        Map<String, List<Book>> collect = authors.stream()
                .distinct()
                .collect(Collectors.toMap(Author::getName, Author::getBooks));
        System.out.println(collect);
    }

    public static List<Author> getAuthors() {
        // 数据初始化
        Author author1 = new Author(1L, "蒙多", 33, "一个从菜刀中明悟真理的祖安人", null);
        Author author2 = new Author(2L, "亚索", 1, "死亡如风，常伴吾身", null);
        Author author3 = new Author(3L, "易大师", 14, "一击几盏", null);
        Author author4 = new Author(3L, "易大师", 14, "一击几盏", null);

        // 书籍列表
        ArrayList<Book> books1 = new ArrayList<>();
        ArrayList<Book> books2 = new ArrayList<>();
        ArrayList<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "马克思主义思想", "哲学,小说", 88, "一本烂书"));
        books1.add(new Book(2L, "列宁思想", "教育,爱情", 78, "一本烂书"));


        books2.add(new Book(3L, "毛思想", "哲学", 68, "一本烂书"));
        books2.add(new Book(3L, "邓理论", "哲学", 58, "一本烂书"));
        books2.add(new Book(4L, "邓理论", "爱情,个人传记", 48, "一本烂书"));

        books3.add(new Book(5L, "肯尼迪", "爱情", 38, "一本烂书"));
        books2.add(new Book(6L, "麦肯锡", "个人传记", 28, "一本烂书"));
        books2.add(new Book(6L, "麦肯锡", "个人传记", 18, "一本烂书"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        return new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
    }
}
