//package com.github.mabutamail.tipograf.web;
//
//import org.apache.wicket.markup.html.WebPage;
//import org.apache.wicket.markup.html.basic.Label;
//import ru.simplex_software.vr360_main_server.util.PropertiesLoader;
//
//import java.util.Properties;
//
///**
// * Страница с версией приложения.
// */
//public class VersionPage extends WebPage {
//
//    public VersionPage() {
//
//        // Загрузка свойств.
//        Properties properties = PropertiesLoader.getProperties("git.properties");
//
//        Label commitIdLabel = new Label("commitId", properties.getProperty("git.commit.id"));
//        add(commitIdLabel);
//
//        Label commitTimeLabel = new Label("commitTime", properties.getProperty("git.commit.time"));
//        add(commitTimeLabel);
//
//        Label branchLabel = new Label("branch", properties.getProperty("git.branch"));
//        add(branchLabel);
//
//        Label timestampLabel = new Label("timestamp", properties.getProperty("git.build.time"));
//        add(timestampLabel);
//    }
//}
