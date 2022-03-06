package com.teste.dev;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import java.net.URI;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
class DevApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	void testRest() throws Exception {
//		Assertions.assertTrue(true);
		URI uri = new URI("/distance");
		String json="{\"geoLocationInit\": {\"lat\": 27.1009343,\"lng\":-52.615699},\"geoLocationEnd\": {\"lat\": -26.830328,\"lng\": 27.1009343}}";
		mockMvc.perform(get(uri).content(json).contentType(MediaType.APPLICATION_JSON));
		
	}
}
