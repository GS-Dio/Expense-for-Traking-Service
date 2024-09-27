package com.example.demo.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import java.sql.Statement;

public class V2__Create_Currency_Rate_Table extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        try (Statement statement = context.getConnection().createStatement()) {
            statement.execute("CREATE TABLE currency_rate (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "currency_pair VARCHAR(7)," +
                    "rate DECIMAL(19, 4)," +
                    "date DATE" +
                    ");"
            );
        }
    }
}
