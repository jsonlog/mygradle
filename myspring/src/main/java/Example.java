import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import com.util.*;

@RestController
@EnableAutoConfiguration
public class Example {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Example.class, args);
		ConstantsUtil.test();
		System.out.println(PasswordUtil.hashAndEncodePasswordSHA("123456"));
		System.out.println(PasswordUtil.hashAndEncodePasswordSHA("12345678"));
//        {SHA}fEqNCco3Yq9h5ZUglD3CZJT4lBs=
//        {SHA}fCIvspJ9goryL1khNOiTJIBjfA0=
//        {SHA}SdAKpU8WG0Z5Aw8gh4PIIGg1NB8=
	}

}
