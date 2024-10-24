package com.snhu.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
@AutoConfigureMockMvc
public class ServerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateHash() throws NoSuchAlgorithmException {
        String input = "Shekhar Chaudhary!";
        String expectedHash = "edec1e9c343d5133ba798e688dfd1a4032ba3b3bfaf3c33be13ebfef1d5e36a1";
        String actualHash = ServerApplicationTests.calculateHash(input);
        assertEquals(expectedHash, actualHash, "The calculated hash should match the expected hash.");
    }

    private static String calculateHash(String input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void testCalculateHashWithDifferentInput() throws NoSuchAlgorithmException {
        String input = "Hello, World!";
        String expectedHash = "dffd6021bb2bd7d3e85db5803c30e1a8c66d9dfc85f1196f5c03765bd4e4d70e";
        String actualHash = ServerApplicationTests.calculateHash(input);
        assertEquals(expectedHash, actualHash, "The calculated hash should match the expected hash for different input.");
    }

    @Test
    public void testHashEndpoint() throws Exception {
        mockMvc.perform(get("/hash"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("data: Shekhar Chaudhary!")))
                .andExpect(content().string(containsString("checksum: edec1e9c343d5133ba798e688dfd1a4032ba3b3bfaf3c33be13ebfef1d5e36a1")));
    }
}
