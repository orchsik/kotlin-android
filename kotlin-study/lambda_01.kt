// 람다는 간단히 익명함수이며
// 함수의 인자와 리턴 타입이 명확할 때 구현 내용만 작성하는 기술.

/* 간단한 익명함수  */
val greeting = fun() { println("hello")}
greeting("chacha")
// 람다표현식
val greeting: () -> Unit = { println("hello")}
greeting()

/* 인자를 받고, 값을 리턴하는 익명함수 */
fun main(args: Array<String>) {
  val greeting = { name: String, age: String -> "hello my name is $name. I'm $age years old."}
  val result = greeting("sonic", 12)
  println(result)
}
/*
인자 타입을 생략하는 익명함수
컴파일러가 타입을 알면 생략할 수 있다. <- 익명함수를 할당하는 변수에 타입 정의
*/
fun main(args: Array<string>) {
  val greeting : (String, String) -> String = {
    name, age -> "hello my name is $name. I'm $age years old."
  }
  val result = greeting();
  println(result)
}

/*
인자 선언을 생략할 수 있는 익명함수
익명함수의 인자가 1개인 경우, name과 같은 인자 이름을 생략할 수 있다.
인자가 1개일 때 선언을 생략할 수 있으며 인자에 접근하려면 it라는 이름으로 접근해야 한다.
*/
 fun greeting = (String) -> String = { name -> "hello. my name is $name."}
 fun greeting = (String) -> String = { "hello. my name is $it" }


/*
라이브러리에서 사용되는 익명함수
컴파일러가 모든 정보를 알고 있기 때문에 생략해도 빌드 에러가 발생하지 않을 수 있다.
코틀린에서 여러 객체는 함수를 인자로 받는 함수가 많다.
 */
val numbers = listOf<Int>(5, 1, 3, 2, 9, 6, 7, 8, 4)
println(numbers)  // 5, 1, 3, 2, 9, 6, 7, 8, 4

val sorted = numbers.sortedBy({ it })
println(sorted) // 1, 2, 3, 4, 5, 6, 7, 8, 9

val biggerThan5 = numbers.sortedBy({ it }).filter({ it > 5 })
println(biggerThan5)  // 6, 7, 8, 9

/**
SAM(Single Abstract Method)
추상 메소드에 하나의 메소드만 있는 것을 SAM이라고 합니다.
람다 표현식으로 SAM의 익명객체를 만들어 인자로 넘길 수 있습니다.
*/

// setOnClickListener는 익명 클래스를 인자로 받습니다.
fun setOnClickListener(listener : (View) -> Unit)

// 4줄의 익명 클래스 코드에서 실질적인 구현 코드는 doSomething뿐이지만 클래스를 정의하기 위해 형식적인(boilerplate) 코드를 써줘야 합니다.
button.setOnClickListener(object: OnClickListener {
  override fun onCLick(view : View) {
    doSomething()
  }
})
// 람다표현식 사용
button.setOnClickListener({ view -> doSomething() })
// 컴파일러는 인자의 타입을 이미 알고 있기 때문에 아래와 같이 인자를 생략할 수 있다.
button.setOnClickListener({  doSomething() })
// 마지막 인자가 익명함수 또는 익명 클래스인 경우 ()를 생략할 수 있다.
button.setOnClickListener {  doSomething() }
