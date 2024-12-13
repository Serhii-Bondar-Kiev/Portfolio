package ua.comparus.getuserstesttask;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "data")
public class DataSourceConfig {

    private List<DataSourceProperties> sources;

    public List<DataSourceProperties> getSources() {
        return sources;
    }

    public void setSources(List<DataSourceProperties> sources) {
        this.sources = sources;
    }


}