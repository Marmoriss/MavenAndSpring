package com.kh.app.strategy.pattern;

/**
 * 철수는 강아지를 키운다.
 * 영희는 고양이를 키운다.
 * 
 * -> Person클래스를 설계
 * -> 철수 Person has a Dog.
 * -> 영희 Person has a Cat.
 * 
 * 
 * 전략패턴 Strategy Pattern
 * - GoF의 디자인 패턴에 소개된 행위패턴 중의 하나
 * 
 * - Context : Strategy를 이용하는 클래스. 필요에 따라 구체적인 전략을 바꿔서 사용할 수 있어야한다. => Person
 * - Strategy : Interface나 추상 클래스. Context가 의존하는 타입으로, 자식 클래스에 대해서 동일한 규격을 제공한다. => Pet
 * - Concrete Strategy : Strategy클래스의 구현체. Strategy를 수행하는 주체 => Dog, Cat
 * 
 */
public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("철수", new Dog("쪼꼬미"));
		Person p2 = new Person("영희", new Cat("정감자"));
		
		System.out.println(p1);
		System.out.println(p2);
		
		// Person이 가질 수 있는 반려동물 Class는 이후에 추가될 수 있다.
		Person p3 = new Person("송강", new Snake("배미"));
		System.out.println(p3);
	}

}
