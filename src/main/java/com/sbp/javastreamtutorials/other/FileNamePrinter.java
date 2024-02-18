package com.sbp.javastreamtutorials.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileNamePrinter {

    private static final Logger Log = LoggerFactory.getLogger(FileNamePrinter.class);

    private static final String FILE_PATH = "/";
    private static final String FILE_PATH_SEPARATOR = "/";

    public FileNamePrinter(){
           printFileName(FILE_PATH);
    }

    // Assumption: Directories or Files
    private static void printFileName(String FILE_PATH){

        File file = new File(FILE_PATH);
        List<File> files = Arrays.asList(file.listFiles());

        for(int i= 0; i<files.size(); i++)
        {
            if(files.get(i).isFile())
                if(FILE_PATH.equals("/"))
                    Log.info(FILE_PATH + files.get(i).getName());
                else
                    Log.info(FILE_PATH + FILE_PATH_SEPARATOR +files.get(i).getName());
            else
            {
                String path = FILE_PATH + "/" + files.get(i).getName();
                printFileName(path);
            }
        }
    }

    private static void design(){
//
//     Consumers: xml, json
//     provider:
//
//     get /coinDetails/
//         XML ==>    Header: Accept: Application/xml;
//
//        Header: Accept: Application/xml;
//
//        Header: Accept: Application/json;
//
//        POST:
//        Content-type:
//
//      Our
//            3rd party-out ==> Parser ==>  Desired format
//            Abstract Parser:
//            subclass new
    }


}
