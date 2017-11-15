package datastructure.tree.treeSet;


import java.util.*;

// Demo code for Treeset Implementation of Person Class using Comparable
public class TreeSetPerson {
	private static TreeSet<Person> s = new TreeSet<Person>();

	public static void main(String a[]) {
		s.add(new Person("Rani", 20));
		s.add(new Person("Raja", 30));
		s.add(new Person("Sunil", 10));
		s.add(new Person("Babu", 50));
		s.add(new Person("Tomy", 40));
		// s.add(new Person(10));
		System.out.println(s);
	}
}

class Person implements Comparable<Person> {
	String name;
	int age;

	Person(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public int compareTo(Person o) {
		return this.age-o.age;
	}

	public String toString() {
		return this.name + " & " + this.age;
	}
}
/*
[Sunil & 10, Rani & 20, Raja & 30, Tomy & 40, Babu & 50]
*/
