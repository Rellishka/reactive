package com.example.mongodb;

import com.example.mongodb.config.RouterFunctionConfiguration;
import com.example.mongodb.entity.Employee;
import com.example.mongodb.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoFluxApplicationTests {

	@Mock
	private EmployeeService employeeService;

	@Autowired
	private RouterFunctionConfiguration routerConfiguration;

	@Test
	public void testGetEmployeeByIdRoute() {
		WebTestClient client = WebTestClient
				.bindToRouterFunction(routerConfiguration.routerFunction())
				.build();

		Employee expected = new Employee(1L, "Some test name");

		//when(employeeService.findById(1L)).thenReturn(Mono.just(expected));
		client.get()
				.uri("/employees/1")
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody(Employee.class)
				.isEqualTo(expected);


		EntityExchangeResult<List<Employee>> listEntityExchangeResult =
				client.get()
				.uri("/employees")
				.exchange()
				.expectStatus()
				.isOk()
				.expectBodyList(Employee.class)
				.returnResult();


		System.out.println(listEntityExchangeResult.getResponseBody().size());

	}

}

