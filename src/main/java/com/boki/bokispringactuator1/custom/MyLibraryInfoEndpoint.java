package com.boki.bokispringactuator1.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.Arrays;
import java.util.List;

@Endpoint(id = "my-library-info")
public class MyLibraryInfoEndpoint {

    @ReadOperation
    public List<LibraryInfo> getLibraryInfos() {
        LibraryInfo libraryInfo1 = new LibraryInfo();
        libraryInfo1.setName("logback");
        libraryInfo1.setVersion("1.0.0");

        LibraryInfo libraryInfo2 = new LibraryInfo();
        libraryInfo2.setName("jackson");
        libraryInfo2.setVersion("2.0.0");

        return Arrays.asList(libraryInfo1, libraryInfo2);
    }
}
