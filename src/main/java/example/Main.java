package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
    }

    private static void test1() {
        Student student = new Student();
        student.setName("김종현");
        student.setGender("남성");
        student.setAddress("서울");
        student.setPhoneNo("010-1111-2222");

        Map<String, Object> convertMap = ConvertUtils.convertToMap(student);
        System.out.println("VO -> Map");
        System.out.println(convertMap);

        Student convertValueObject = ConvertUtils.convertToValueObject(convertMap, Student.class);
        System.out.println("Map -> VO");
        System.out.println(convertValueObject);
    }

    private static void test2() {
        List<Student> students = new ArrayList<>();

        Student student = new Student();
        student.setName("김종현");
        student.setGender("남성");
        student.setAddress("서울");
        student.setPhoneNo("010-1111-2222");
        students.add(student);

        student = new Student();
        student.setName("홍길동");
        student.setGender("남성");
        student.setAddress("서울");
        student.setPhoneNo("010-3333-4444");
        students.add(student);

        List<Map<String, Object>> convertMaps = ConvertUtils.convertToMaps(students);
        System.out.println("List<VO> -> List<Map>");
        convertMaps.forEach(System.out::println);

        List<Student> convertValueObjects = ConvertUtils.convertToValueObjects(convertMaps, Student.class);
        System.out.println("List<Map> -> List<VO>");
        convertValueObjects.forEach(System.out::println);
    }
}
