package com.mobylis.fr.controller;

import com.mobylis.fr.service.file.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ANDREŒŒŒOŒŒŒŒŒ
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

//    @PostMapping(:
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
