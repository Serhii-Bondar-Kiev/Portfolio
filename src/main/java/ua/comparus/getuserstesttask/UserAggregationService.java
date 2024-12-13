package ua.comparus.getuserstesttask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class UserAggregationService {

    private final DataSourceConfig dataSourceConfig;

    public UserAggregationService(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    /*public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        for (DataSourceProperties source : dataSourceConfig.getSources()) {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl(source.getUrl());
            dataSource.setUsername(source.getUser());
            dataSource.setPassword(source.getPassword());

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            String query = String.format("SELECT * FROM %s", source.getTable());
            List<Map<String, Object>> results = jdbcTemplate.queryForList(query);

            results.stream().map(row -> new User(
                    map(source, row , "id"),
                    map(source, row , "username"),
                    map(source, row , "name"),
                    map(source, row , "surname"))
            ).forEach(users::add);


        }
        return users;
    }*/

    private static String map(DataSourceProperties source, Map<String, Object> row, String key) {
        return row.get(source.getMapping().get(key)).toString();
    }

    public Collection<User> getAllUsers() {

        return dataSourceConfig.getSources().stream().map(source -> {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource(source.getUrl(), source.getUser(), source.getPassword()));
            String query = String.format("SELECT * FROM %s", source.getTable());
            return jdbcTemplate.queryForList(query).stream()
                    .map(row -> new User(
                            map(source, row, "id"),
                            map(source, row, "username"),
                            map(source, row, "name"),
                            map(source, row, "surname")));
        }).flatMap(stream -> stream)
                .collect(Collectors.toList());
    }

}