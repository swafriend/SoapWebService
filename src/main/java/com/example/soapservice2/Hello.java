package com.example.soapservice2;//import javax.jws.WebMethod;//import javax.jws.WebService;//import jakarta.jws.WebService;//import jakarta.jws.WebMethod;import org.springframework.stereotype.Component;import javax.jws.WebMethod;import javax.jws.WebService;import javax.xml.ws.WebServiceException;import java.io.BufferedInputStream;import java.io.File;import java.io.FileInputStream;import java.io.IOException;import java.nio.file.Path;import java.nio.file.Paths;@WebService(targetNamespace = "http://tempuri.org")//@WebService@Componentpublic class Hello {    @WebMethod    public String sayHello(String name) {        return "Hello, " + name + "!";    }    @WebMethod    public byte[] download(String fileName) {        String filePath = "D:\\tmp\\Download\\" + fileName;        System.out.println("Sending file: " + filePath);        File file = new File(filePath);        try (FileInputStream fis = new FileInputStream(file);             BufferedInputStream inputStream = new BufferedInputStream(fis);        ) {            byte[] fileBytes = new byte[(int) file.length()];            int readSize = inputStream.read(fileBytes, 0, (int) file.length());            System.out.println("inputStream.read size=" + readSize);            return fileBytes;        } catch (IOException ex) {            throw new WebServiceException(ex);        }    }}