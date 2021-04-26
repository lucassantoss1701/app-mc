package com.lucas.springionic;

import com.lucas.springionic.domain.*;
import com.lucas.springionic.domain.enums.EstadoPagamento;
import com.lucas.springionic.domain.enums.TipoCliente;
import com.lucas.springionic.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class SpringionicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringionicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
