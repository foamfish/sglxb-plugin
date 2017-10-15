package com.sglxb;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Mojo(name = "sglxbgoal", defaultPhase = LifecyclePhase.PACKAGE)
public class TestMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.sourceDirectory}")
    private String param;

    @Parameter(defaultValue = "${project.build.directory}", property = "args")
    private String args;

    private Map<String, Integer> fileTypeMap = new HashMap<String, Integer>();

    public void execute() throws MojoExecutionException, MojoFailureException {

        System.out.println("森国龙欣博 插件");
        File javaPath = new File(param);
        statistics(javaPath);
        System.out.println("param-->" + param);
        System.out.println("—Dargs-->" + args);
        for (Map.Entry<String, Integer> entry : fileTypeMap.entrySet()) {
            System.out.printf("%s,%s\n", entry.getKey(), entry.getValue());
        }
    }

    private void statistics(File file) {

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                statistics(f);
            }
        } else if (file.isFile()) {
            String fileType = file.getName().split("\\.")[1];
            if (fileTypeMap.containsKey(fileType)) {
                Integer num = fileTypeMap.get(fileType);
                fileTypeMap.put(fileType, ++num);
            } else {
                fileTypeMap.put(fileType, new Integer(1));
            }

        }

    }


}
