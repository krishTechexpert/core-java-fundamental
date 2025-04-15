package com.krish.API_Gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import java.util.List;
import java.util.Set;

@Component

//custom filter
public class MyFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("inside filter....");
       //HttpHeaders headers =  exchange.getRequest().getHeaders();//get first headers only

        // contains multiple keys in Headers
       ServerHttpRequest request =  exchange.getRequest();
       HttpHeaders headers = request.getHeaders();
       Set<String> keySet =  headers.keySet();

       //way-1 you can extract first key only
        String myKey="zzzz";
        String APIKEY=headers.getFirst("X-API-KEY");
        if(APIKEY == null || !APIKEY.equals(myKey)){
            //reject code
           ServerHttpResponse response =  exchange.getResponse();
           response.setStatusCode(HttpStatus.UNAUTHORIZED);
           return response.setComplete();
        }

       //way-2 you can extract multiple key
//        keySet.forEach(key -> {
//           List<String> values = headers.get(key);
//            System.out.println(key+":"+values);
//        });
        return chain.filter(exchange);
    }
}


/* ----------------Now to learn filter in API Gateway ----------------

* routing we have done now and let us learn to filter in api gateway

Jab UI s request send krengy to get resource data for some API..then
we we send x-api-key/token alongwith headers from UI.

ab hum api gateway per hi header k andar api key/token ko check/filter ker lengy
if api/token is valid then further process otherwise give some error to client.

way-1 results
http://localhost:3333/welcome with single headers such as

X-API-KEY : zzzz
Good Morning , I am from Greet-API MS 9090 Hi, I am from Welcome API

and
X-API-KEY : 123
401 unauthorized error aa ye gi
------------------------------------------------------

way-2 results
 when you hit http://localhost:3333/welcome with two headers such as

    username: krish
    course: java


* result show
*
* inside filter....
username:[krish]
course:[java]
user-agent:[PostmanRuntime/7.43.3]
accept:
cache-control:[no-cache]
postman-token:[660b804d-56af-4bb9-8d3c-0f7f10eda4d6]
host:[localhost:3333]
accept-encoding:[gzip, deflate, br]
connection:[keep-alive]
inside filter....
username:[krish]
course:[java]
user-agent:[PostmanRuntime/7.43.3]
accept:
cache-control:[no-cache]
postman-token:[5b14a373-e9ca-44d6-ba21-3ce0daed1e95]
host:[localhost:3333]
accept-encoding:[gzip, deflate, br]
connection:[keep-alive]


*/
