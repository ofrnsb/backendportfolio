package com.portfoliobackend.pb;

import com.portfoliobackend.pb.Utils.CustomErrorAttributes;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PbApplication {

  public static void main(String[] args) {
    SpringApplication.run(PbApplication.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public DefaultErrorAttributes errorAttributes() {
    return new CustomErrorAttributes();
  }
}
