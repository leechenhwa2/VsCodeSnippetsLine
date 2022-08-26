package com.uniuwo.tool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileToSnippet {

    public static void main(String[] args) {
        String filepath = args[0];
        process(filepath);
    }

    public static void process(String filepath) {
        Path path = Paths.get(filepath);
        if(Files.notExists(path)){
            System.err.println("File not exit.");
            return;
        }

        String filename = path.getFileName().toString();
        String tag = "";
        int pos = filename.lastIndexOf('.');
        if (pos > 0) {
            tag = filename.substring(0, pos);
            filename = tag + ".snippet";
        } else {
            tag = filename;
            filename = tag + ".snippet";
        }

        Path output = path.getParent().resolve(filename);

        try {
            String content = Files.readString(path);
            String result = content.replace("\r\n", "\\n");
            result = result.replace("\"", "\\\"");

            String snippet = "\"" + tag + "\": {\n" +
                    "\t\t\"description\": \"" + tag + " template\",\n" +
                    "\t\t\"scope\": \"\",\n" +
                    "\t\t\"prefix\":\"" + tag + "\",\n" +
                    "\t\t\"body\": \"" + result + "\"\n\t}";
            Files.writeString(output, snippet);

            System.out.println("\r\nOutput to :" + output);
        } catch (IOException e) {
            System.err.println("Cannot read file as string");;
        }

    }
}
