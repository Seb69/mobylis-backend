package com.mobylis.fr.controller;

import com.mobylis.fr.service.FileService;
import javassist.bytecode.ByteArray;
import org.apache.logging.log4j.core.util.FileUtils;
import org.springframework.core.codec.Decoder;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.reactive.function.BodyExtractor;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ANDRE
 * @since 03/03/2018
 */
@RestController
@RequestMapping("/api/private")
public class FileController {

    private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/file")
    public String uploadFile(@RequestBody byte[] files) {

        return fileService.upload(files);
    }

//    @PostMapping(
//            value = "/file",
//            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
//    )
//    public String uploadFile(MultipartHttpServletRequest multipartHttpServletRequest) {
//
//        return "dsfsqd";
//    }
//    @PostMapping(
//            value = "/file",
//            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
//    )
//    public String uploadFile(@RequestPart("filePart") Mono<FilePart> filePart) {
//        try {
//            File fileDest = new File(filePart.block().filename());
//            final Mono<List<Byte>> collect = filePart.block().content().map(dataBuffer -> dataBuffer.read()).collect(Collectors.toList());
//            System.out.println(collect.block());
//            fileDest.createNewFile();
//
////            final byte[] bytes = filePart.content().blockLast().asInputStream().readAllBytes();
////            System.out.println(bytes.length);
//            filePart.block().transferTo(fileDest);
//            fileService.upload(fileDest);
//        } catch (IOException e) {
//        }
//
//        return "dsfsqd";
//    }

//    @PostMapping(
//            value = "/file"
//    )
//    public Mono<String> uploadFile(ServerWebExchange serverHttpRequest) throws IOException {
//        final Mono<List<Byte>> collect = serverHttpRequest.getRequest().getBody().map(dataBuffer -> dataBuffer.read()).collect(Collectors.toList());
//
//        System.out.println(collect.block().size());
////        serverHttpRequest.getRequest().getBody().doOnComplete(()-> )
////        BodyExtractors.toMono(serverHttpRequest.getRequest().getBody().)
//
//        File fileDest = new File("Adneom Luxembourg (Extranet).jpg");
//        FileInputStream fileInputStream = new FileInputStream(fileDest);
//        final byte[] bytes = fileInputStream.readAllBytes();
//        System.out.println(bytes.length);
//        return Mono.create((tMonoSink) -> {
//            System.out.println("dsfsqd");
//        });
//    }

//    @PostMapping(
//            value = "/file",
//            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
//    )
//    public String uploadFile(MultipartFile multipartFile) {
//
//
//        multipartFile.getName();
////        fileService.upload(fileDestination);
////        System.out.println(multipartHttpServletRequest.toString());
//        return "dsfsqd";
//    }


}
