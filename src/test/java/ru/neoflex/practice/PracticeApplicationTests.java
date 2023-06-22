package ru.neoflex.practice;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class PracticeApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void ReturnPlus() throws Exception{
		this.mockMvc.perform(get("/plus/40/40")).andDo(print()).andExpect(content().string(containsString("80")));
	}

	@Test
	public void ReturnMinus() throws Exception{
		this.mockMvc.perform(get("/minus/200/40")).andDo(print()).andExpect(content().string(containsString("160")));
	}

	@Test
	public void ReturnDivision() throws Exception{
		this.mockMvc.perform(get("/division/99/3")).andDo(print()).andExpect(content().string(containsString("33")));
	}

	@Test
	public void ReturnMultiplication() throws Exception{
		this.mockMvc.perform(get("/multiplication/3/5")).andDo(print()).andExpect(content().string(containsString("15")));
	}

}
