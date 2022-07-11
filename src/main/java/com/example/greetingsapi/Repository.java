package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Greeting.java.Greeting;

public interface Repository extends JpaRepository<Greeting, Integer>{

}
