package com.example.soapservice2;

//import jakarta.xml.ws.Endpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class SoapService2Application {


    private static Hello hello = null;

    public SoapService2Application(Hello hello) {
        SoapService2Application.hello = hello;
    }

    public static void main(String[] args) {
        SpringApplication.run(SoapService2Application.class, args);
        Endpoint.publish("http://localhost:8080/hello", hello);
//        Endpoint.publish("http://tempuri.org:8080/hello", hello);
    }

}
