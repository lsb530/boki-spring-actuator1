package com.boki.bokispringactuator1.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;

@Endpoint(id = "my-library-info")
public class MyLibraryInfoEndpoint {

    @ReadOperation
    public List<LibraryInfo> getLibraryInfos(@Nullable String name, boolean includeVersion) {
        LibraryInfo libraryInfo1 = new LibraryInfo();
        libraryInfo1.setName("logback");
        libraryInfo1.setVersion("1.0.0");

        LibraryInfo libraryInfo2 = new LibraryInfo();
        libraryInfo2.setName("jackson");
        libraryInfo2.setVersion("2.0.0");

        List<LibraryInfo> endPoints = Arrays.asList(libraryInfo1, libraryInfo2);

        if (name != null) {
            endPoints = endPoints.stream()
                .filter(libraryInfo -> libraryInfo.getName().equals(name))
                .toList();
        }

        if (!includeVersion) {
            endPoints = endPoints.stream()
                .map(libraryInfo -> {
                    LibraryInfo temp = new LibraryInfo();
                    temp.setName(libraryInfo.getName());
                    return temp;
                })
                .toList();
        }

        return endPoints;
    }
}
