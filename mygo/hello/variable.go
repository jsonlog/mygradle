package main

import "fmt"


/* 声明全局变量 */
var g int = 20

func main() {
	/* 声明局部变量 */
	var a, b, c int

	/* 初始化参数 */
	a = 10
	b = 20
	c = a + b

	fmt.Printf ("结果： a = %d, b = %d and c = %d\n", a, b, c)

	/* 声明局部变量 */
	var g int = 10

	fmt.Printf ("结果： g = %d\n",  g)
}