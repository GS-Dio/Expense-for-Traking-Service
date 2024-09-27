package com.example.demo.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import java.sql.Statement;

public class V3__Create_Expense_Limit_Table extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        try (Statement statement = context.getConnection().createStatement()) {
            statement.execute("CREATE TABLE expense_limit (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "limit_amount DECIMAL(19, 4)," +
                    "category VARCHAR(255)," +
                    "set_date DATE" +
                    ");"
            );
        }
    }
}
