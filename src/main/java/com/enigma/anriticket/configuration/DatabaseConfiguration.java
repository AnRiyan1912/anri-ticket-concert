//package com.enigma.anriticket.configuration;
//
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//@Configuration
//@RequiredArgsConstructor
//public class DatabaseConfiguration {
//    private final JdbcTemplate jdbcTemplate;
//    String createUUID = "CREATE EXTENSION IF NOT EXISTS\"uuid-ossp\";";
//    String createEnumRole = "CREATE TYPE IF NOT EXISTS ERole AS ENUM('ROLE_CUSTOMER', 'ROLE_SELLER', 'ROLE_ADMIN');";
//    String createTableRole = "CREATE TABLE IF NOT EXISTS m_role (id UUID default uuid_generate_v4() PRIMARY KEY, role ERole);";
//    String createTableUser = "CREATE TABLE IF NOT EXISTS m_user (id UUID default uuid_generate_v4() PRIMARY KEY, username VARCHAR(80), email varchar(80), password VARCHAR(170)," +
//            " role_id UUID, created_at TIMESTAMP, updated_at TIMESTAMP);";
//    String addRelationUserAndRole = "ALTER TABLE IF NOT EXISTS m_user ADD CONSTRAINT fk_m_user_m_customer FOREIGN KEY (role_id) REFERENCES m_role (id);";
//    String createTableCustomer = "CREATE TABLE IF NOT EXISTS m_customer (id UUID default uuid_generate_v4() PRIMARY KEY, first_name VARCHAR(80), last_name VARCHAR(100), " +
//            " birth_date TIMESTAMP, saldo DOUBLE PRECISION, user_id UUID, created_at TIMESTAMP, updated_at TIMESTAMP);";
//
//    String addRelationCustomerAndUser = "ALTER TABLE IF NOT EXISTS m_customer ADD CONSTRAINT fk_m_customer_m_user FOREIGN KEY (user_id) REFERENCES m_user (id);";
//    @PostConstruct
//    public void initializeDatabase() {
//        if (!isEnumTypeExists("ERole")) {
//            jdbcTemplate.execute(createEnumRole);
//        }
//        if (!isTableExists("m_role")) {
//            jdbcTemplate.execute(createUUID);
//            jdbcTemplate.execute(createTableRole);
//        }
//        if (!isTableExists("m_user")) {
//            jdbcTemplate.execute(createTableUser);
//            jdbcTemplate.execute(addRelationUserAndRole);
//        }
//        if (!isTableExists("m_customer")) {
//            jdbcTemplate.execute(createTableCustomer);
//            jdbcTemplate.execute(addRelationCustomerAndUser);
//        }
//    }
//
//    private Boolean isTableExists(String tableName) {
//        try {
//            jdbcTemplate.queryForObject("SELECT 1 FROM " + tableName + " LIMIT 1", Integer.class);
//            return true;
//        } catch (DataAccessException e) {
//            return false;
//        }
//    }
//
//    public boolean isEnumTypeExists(String enumTypeName) {
//        String query = "SELECT 1 FROM pg_type WHERE typname = ?";
//
//        try {
//            jdbcTemplate.queryForObject(query, Integer.class, enumTypeName);
//            return true;
//        } catch (EmptyResultDataAccessException e) {
//            return false;
//        }
//    }
//
//
//}
