package ua.comparus.getuserstesttask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class UserAggregationService {

    private final DataSourceConfig dataSourceConfig;

    public UserAggregationService(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        for (DataSourceConfig.DataSourceProperties source : dataSourceConfig.getSources()) {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl(source.getUrl());
            dataSource.setUsername(source.getUser());
            dataSource.setPassword(source.getPassword());

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            String query = String.format("SELECT * FROM %s", source.getTable());
            List<Map<String, Object>> results = jdbcTemplate.queryForList(query);

            for (Map<String, Object> row : results) {
                String id = row.get(source.getMapping().get("id")).toString();
                String username = row.get(source.getMapping().get("username")).toString();
                String name = row.get(source.getMapping().get("name")).toString();
                String surname = row.get(source.getMapping().get("surname")).toString();

                users.add(new User(id, username, name, surname));
            }
        }
        return users;
    }
}