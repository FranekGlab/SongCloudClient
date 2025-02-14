package com.example.songcloudclient.config;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public OkHttpClient feignClient() {
        return new OkHttpClient();
    }
}
