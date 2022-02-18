package com.howtodoinjava.demo.ribbonServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

public class myRestController {
    // auto-inject Environment
    @Autowired
    Environment environment;

    @GetMapping("/")
    public String health() {
        return "I am Ok";
    }

    @GetMapping("/backend")
    public String backend() {
        System.out.println("Inside MyRestController::backend...");

        // call a backend server with right port
        String serverPort = environment.getProperty("local.server.port");

        // show message from backend with server port
        System.out.println("Port : " + serverPort);

        return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
    }
}
