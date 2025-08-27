package com.github_actions.air.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HelloControllerTest {

    @InjectMocks
    HelloController contollerTest;


    @Test
    void getHello() {
        assertEquals("Hello World!", contollerTest.getHello());
    }
}