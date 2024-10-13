package com.phdwebsite.phdwebsite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // Use the actual database
public class PhdwebsiteApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        // Attempt to query the database
        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Long.class);
        assertThat(count).isNotNull();
        System.out.println("Number of users in the database: " + count);
    }
}

