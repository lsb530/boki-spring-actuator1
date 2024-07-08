package com.boki.bokispringactuator1.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Endpoint(id = "my-library-info")
public class MyLibraryInfoEndpoint {

    @Autowired
    private ObjectMapper objectMapper;

    @WriteOperation
    public void changeSomething(String name, boolean enableSomething) {
        log.info("name: {}, enableSomething: {}", name, enableSomething);
    }

    @ReadOperation
    public ObjectNode getSinglePathTest(@Selector String path) {
        log.info("path: {}", path);
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("path", path);
        return objectNode;
    }

    @ReadOperation
    public ObjectNode getMultiPathTest(@Selector(match = Selector.Match.ALL_REMAINING) String[] paths) {
        log.info("paths {}", Arrays.asList(paths));
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("paths", Arrays.toString(paths));
        return objectNode;
    }

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
