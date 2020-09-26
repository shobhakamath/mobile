package com.mobile;

import com.mobile.web.MobileController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MobileApplicationTests {
	@Autowired
	private MobileController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}


}
