//package com.github.mabutamail.tipograf.web.viewmodel;
//
//import org.apache.commons.io.FileDeleteStrategy;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.zkoss.bind.BindUtils;
//import org.zkoss.bind.annotation.BindingParam;
//import org.zkoss.bind.annotation.Command;
//import org.zkoss.bind.annotation.GlobalCommand;
//import org.zkoss.bind.annotation.NotifyChange;
//import org.zkoss.util.media.Media;
//import org.zkoss.zk.ui.event.EventQueues;
//import org.zkoss.zk.ui.select.annotation.VariableResolver;
//import org.zkoss.zk.ui.select.annotation.WireVariable;
//import org.zkoss.zk.ui.util.Clients;
//import org.zkoss.zkplus.spring.DelegatingVariableResolver;
//import org.zkoss.zul.Filedownload;
//import ru.simplex_software.vr360_main_server.model.Film;
//import ru.simplex_software.vr360_main_server.repository.FilmRepository;
//
//import javax.xml.bind.DatatypeConverter;
//import java.io.*;
//import java.security.DigestInputStream;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.List;
//
//@VariableResolver(DelegatingVariableResolver.class)
//public class FilesVM {
//    private static final Logger LOG = LoggerFactory.getLogger(FilesVM.class);
//
//
//    private List<File> files;
//
//    @WireVariable
//    private String basePath;
//
//    @WireVariable
//    private FilmRepository filmRepository;
//
//    @GlobalCommand
//    @NotifyChange("films")
//    public void refreshFiles() {
//        BindUtils.postNotifyChange(null, EventQueues.APPLICATION, this, "films");
//    }
//
//    @Command
//    @NotifyChange("films")
//    public void upload(@BindingParam("media") Media media) {
//
//        String nameFilm = media.getName();
//        String contentType = media.getContentType();
//        String hash = null;
//
//        try (BufferedInputStream in = new BufferedInputStream(media.getStreamData());
//             OutputStream fileOut = new FileOutputStream(basePath + nameFilm);
//             BufferedOutputStream out = new BufferedOutputStream(fileOut)) {
//
//            byte[] buffer = new byte[2048];
//            int ch = in.read(buffer);
//            while (ch > 0) {
//                out.write(buffer, 0, ch);
//                ch = in.read(buffer);
//            }
//
//        } catch (IOException e) {
//            LOG.error(e.getMessage(), e);
//            Clients.alert("Upload ERROR");
//        }
//
//        //алгоритм хеширования
//        MessageDigest md = null;
//        try {
//            md = MessageDigest.getInstance("SHA-256");
//        } catch (NoSuchAlgorithmException e) {
//            LOG.error(e.getMessage(), e);
//        }
//
//        try (
//                //  входящий поток байт текущего фильма
//                BufferedInputStream in = new BufferedInputStream(new FileInputStream(basePath + nameFilm), 2048);
//                DigestInputStream dis = new DigestInputStream(in, md)
//        ) {
//            while ((dis.read()) != -1) ;
//            //  получаем hash в виде 32 байтов
//            byte[] digest = md.digest();
//            //  конвертируем bytesToHex
//            hash = DatatypeConverter.printHexBinary(digest);
//        } catch (IOException e) {
//            LOG.error(e.getMessage(), e);
//        }
//
//        //   если фильма нет (по hash), то сохраняем файл и пишем в БД
//        if (filmRepository.findByHash(hash).isEmpty()) {
//            Film film = new Film(nameFilm, nameFilm, true, hash, contentType);
//            filmRepository.save(film);
//        } else {
//            //   если фильм есть, то сообщаем пользователю
//            Clients.alert("Такой файл уже есть " + media.getName());
//        }
//    }
//
//    @Command
//    public void download(@BindingParam("film") Film film) {
//        try {
//            Filedownload.save(new File(basePath + film.getName()), basePath);
//        } catch (FileNotFoundException e) {
//            LOG.error(e.getMessage(), e);
//        }
//    }
//
//    @Command
//    @NotifyChange("films")
//    public void delete(@BindingParam("film") Film film) {
//        try {
//            FileDeleteStrategy.NORMAL.delete(new File(basePath + film.getName()));
//            filmRepository.deleteByHash(film.getHash());
//        } catch (IOException e) {
//            LOG.error(e.getMessage(), e);
//        }
//    }
//
//    @Command
//    public void isActivated(@BindingParam("film") Film film) {
//        Film selectedFilm = filmRepository.findById(film.getId()).get();
//        selectedFilm.setActivated(!selectedFilm.isActivated());
//        filmRepository.save(selectedFilm);
//    }
//
//    public List<Film> getFilms() {
//        return (List<Film>) filmRepository.findAll();
//    }
//
//}