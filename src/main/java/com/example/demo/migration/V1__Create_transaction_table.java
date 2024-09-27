package com.example.demo.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Connection;
import java.sql.Statement;

public class V1__Create_transaction_table extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE transaction (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "account_from VARCHAR(255)," +
                    "account_to VARCHAR(255)," +
                    "amount DECIMAL(10, 2)," +
                    "currency VARCHAR(3)," +
                    "usd_amount DECIMAL(10, 2)," +
                    "category VARCHAR(255)," +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "transaction_date DATE," +
                    "limit_exceeded BOOLEAN" +
                    ")");
        }
    }
}
