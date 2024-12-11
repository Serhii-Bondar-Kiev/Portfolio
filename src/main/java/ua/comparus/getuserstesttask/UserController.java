package ua.comparus.getuserstesttask;

import java.util.Collection;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserAggregationService userAggregationService;

    public UserController(UserAggregationService userAggregationService) {
        this.userAggregationService = userAggregationService;
    }


    @Operation(
            summary = "Users",
            description = "Get users from different datasource.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Operation succeeded"),
                    @ApiResponse(responseCode = "500", description = "Failed")
            }
    )
    @GetMapping("/users")
    public Collection<User> getUsers() {
        return userAggregationService.getAllUsers();
    }
}
