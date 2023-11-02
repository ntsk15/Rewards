package com.demo.rewards;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.rewards.model.Points;
import com.demo.rewards.service.RewardsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RewardsControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Mock
	private RewardsService rewardsService;

	@Mock
	private ObjectMapper objectMapper;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testEmployee() throws Exception {
		mockMvc.perform(get("/rewardsGenerated/customers/1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.customerId").value("1"));

	}
	@Test 
	public void test_getPointsByCustomerId_success() throws Exception {
		Points	points=new Points (1l,123,0,0,0); 
		
		Mockito.when(rewardsService.getPointsByCustId(1l)).thenReturn(points);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
				.get("/rewardsGenerated/customers/1")
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		int status =mvcResult.getResponse().getStatus();
		assertEquals(200, status); 		

	}
	@Test 
	public void test_getPointsByCustomerId() throws Exception {
		Points	points=new Points (4l,123,0,0,0); 
		Mockito.when(rewardsService.getPointsByCustId(5l)).thenReturn(points);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
				.get("/rewardsGenerated/customers/10")
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		String status =mvcResult.getResponse().getContentAsString();
		assertEquals("No Transaction found for this customer Id", status); 		

	}

}
