import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                        names.get(new Random().nextInt(names.size())),
                        families.get(new Random().nextInt(families.size())),
                        new Random().nextInt(100),
                        Sex.values()[new Random().nextInt(Sex.values().length)],
                        Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        // Task1
        Stream<Person> s1 = persons.stream();
        long count18 = s1.filter(p -> p.getAge() < 18).count();

        // Task2
        Stream<Person> s2 = persons.stream();
        List<String> l1 = s2.filter(p -> p.getAge() >= 18 && p.getAge() < 27).map(p -> p.getFamily()).collect(Collectors.toList());

        // Task3
        Stream<Person> s3 = persons.stream();
        List<Person> l2 = s3.filter(p -> p.getEducation() == Education.HIGHER)
                .filter(p -> p.getSex() == Sex.MAN ? p.getAge() >= 18 && p.getAge() < 65 : p.getAge() >= 18 && p.getAge() < 60)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

    }
}
