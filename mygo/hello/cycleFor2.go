package main

import "fmt"

func main() {
	sum := 1
	for ; sum <= 10; {
		sum += sum
	}
	fmt.Println(sum)

	// 这样写也可以，更像 While 语句形式
	for sum <= 10{
		sum += sum
	}
	fmt.Println(sum)

	//for true  {
	//	fmt.Printf("这是无限循环。\n");
	//}
}