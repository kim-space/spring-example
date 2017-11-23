package com.kimtd;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;


@RestController
public class UpLoadController {

    @RequestMapping("/fileupload")
    public String testFileUpload(@RequestParam("file") MultipartFile file ) throws IOException {
        System.out.println("fileName: "+file.getOriginalFilename());
        System.out.println("size: "+file.getSize());
        return "success";
    }

    @RequestMapping("/fileupload2")
    public String testFileUpload2(HttpServletRequest request){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
            while (fileNames.hasNext()){
                MultipartFile file = multipartHttpServletRequest.getFile(fileNames.next());
                if (file != null){
                    System.out.println(file.getOriginalFilename());
                }
            }
        }
        return "success";
    }

    @RequestMapping("/fileupload3")
    public String testFileUpload3(@RequestParam("file")CommonsMultipartFile file){
        System.out.println("fileName: "+file.getOriginalFilename());
        System.out.println("size: "+file.getSize());
        return "success";
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> downLoad() throws IOException {
        String path = "";
        File file = new File(path);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment","hello.png");
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
    }

}
