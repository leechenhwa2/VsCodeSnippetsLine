package com.uniuwo.tool;

import static org.junit.jupiter.api.Assertions.*;

class FileToSnippetTest {

//    @org.junit.jupiter.api.Test
    void processTest() {
        String file = "G:\\workspace-angular\\2Others-limited\\bootstrap5-starter\\src\\start.html";
        FileToSnippet.process(file);

        System.out.println("Done.");
    }
}