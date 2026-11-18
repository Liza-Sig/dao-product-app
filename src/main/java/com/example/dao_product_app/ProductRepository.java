package com.example.dao_product_app;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String sql = read("myScript.sql");

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public String getProductName(String name) {
        MapSqlParameterSource params = new MapSqlParameterSource("name", name);
        List<String> products = jdbcTemplate.queryForList(sql, params, String.class);
        return products.isEmpty() ? null : products.get(0);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
