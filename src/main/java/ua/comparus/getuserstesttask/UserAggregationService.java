package ua.comparus.getuserstesttask;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class UserAggregationService {

    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String NAME = "name";

    public static final String SURNAME = "surname";

    private final DataSourceConfig dataSourceConfig;

    public UserAggregationService(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    private static String map(DataSourceProperties source, Map<String, Object> row, String key) {
        return row.get(source.getMapping().get(key)).toString();
    }

    public Collection<User> getAllUsers() {

        return dataSourceConfig.getSources().stream().map(source -> {
                    JdbcTemplate jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource(source.getUrl(), source.getUser(), source.getPassword()));
                    String query = String.format("SELECT * FROM %s", source.getTable());
                    return jdbcTemplate.queryForList(query).stream()
                            .map(row -> new User(
                                    map(source, row, ID),
                                    map(source, row, USERNAME),
                                    map(source, row, NAME),
                                    map(source, row, SURNAME)));
                }).flatMap(stream -> stream)
                .collect(Collectors.toList());
    }

}