package com.duong.demo.rest.api;

import com.duong.demo.entity.Student;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

@RequestMapping("/api/text")
@RestController
public class TextStreamApi {


    @GetMapping("/resource")
    public Flux<DataBuffer> serve(){
        Path path = Paths.get("C:/PROJECT/SHOPPING_MALL/business-service/log_daily/shopapp-debug.2021-03-15.log");
        return DataBufferUtils.read(
                path,
                new DefaultDataBufferFactory(),
                4096
        );
    }

    @GetMapping("/d2")
    public static Flux<String> fromPath() {
        Path path = Paths.get("C:/PROJECT/SHOPPING_MALL/business-service/log_daily/shopapp-debug.2021-03-15.log");
        return Flux.using(() -> Files.lines(path),
                Flux::fromStream,
                BaseStream::sequential
        );
    }

    @GetMapping(value = "/line")
    public Flux<String> streamJsonObjects() throws IOException {
        String fileName = "C:/PROJECT/SHOPPING_MALL/business-service/log_daily/shopapp-debug.2021-03-16.log";

        //read file into stream, try-with-resources
//        Stream<String> stream = Files.lines(Paths.get(fileName));
        BufferedReader file = new BufferedReader(new FileReader(fileName));

        return Flux.interval(Duration.ofMillis(500)).map(i -> {
            try {
                String line = file.readLine();
                while(line != null) {
                    return line + "<br/>";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
