import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ua.comparus.getuserstesttask.GetUsersTestTaskApplication;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(classes = GetUsersTestTaskApplication.class)
@ActiveProfiles("integration-test")
public class PostgresIntegrationTest {

    @Container
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15.2")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @Test
    void testDatabaseContainer() {
        assertThat(postgres.isRunning()).isTrue();

        String jdbcUrl = postgres.getJdbcUrl();
        String username = postgres.getUsername();
        String password = postgres.getPassword();

        postgres.withInitScript("init-schema.sql");
        postgres.withReuse(true);
        postgres.setWaitStrategy(Wait.forListeningPort());
        postgres.start();



        System.out.printf("JDBC URL: %s%nUsername: %s%nPassword: %s%n", jdbcUrl, username, password);
        // Perform tests using the database connection
    }
}
