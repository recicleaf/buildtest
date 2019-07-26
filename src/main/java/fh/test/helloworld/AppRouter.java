package fh.test.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class AppRouter {

    @Value("${name}")
    private String name;

    @Bean
    RouterFunction<ServerResponse> updateEmployeeRoute() {
        return RouterFunctions.route(RequestPredicates.GET("/hello"),
                                     request -> ok().syncBody(this.name + " World!"))
                              .andRoute(RequestPredicates.GET("/hello2"),
                                        request -> ok().syncBody(this.name + " World 2!"));
    }
}
