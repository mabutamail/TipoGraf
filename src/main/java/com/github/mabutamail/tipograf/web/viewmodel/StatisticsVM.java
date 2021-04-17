//package com.github.mabutamail.tipograf.web.viewmodel;
//
//
//import org.zkoss.bind.BindUtils;
//import org.zkoss.bind.annotation.BindingParam;
//import org.zkoss.bind.annotation.Command;
//import org.zkoss.bind.annotation.GlobalCommand;
//import org.zkoss.bind.annotation.NotifyChange;
//import org.zkoss.zk.ui.event.EventQueues;
//import org.zkoss.zk.ui.select.annotation.VariableResolver;
//import org.zkoss.zk.ui.select.annotation.WireVariable;
//import org.zkoss.zkplus.spring.DelegatingVariableResolver;
//import ru.simplex_software.vr360_main_server.repository.StatisticRepository;
//
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//import java.util.List;
//
//
///**
// * ViewModel статистика по просмотрам фильмов.
// */
//@VariableResolver(DelegatingVariableResolver.class)
//public class StatisticsVM {
//
//    @WireVariable
//    private StatisticRepository statisticRepository;
//
//    private List<String> listOfActionsByDate;
//
//    private List<Object[]> listOfFilmsAndCountByTablet;
//
//    /**
//     * Инициализируем дату на начало текущего дня 00:00 с таймзоной по умолчанию.
//     */
//    private Date date = Date.from(LocalDate.ofInstant((new Date()).toInstant(), ZoneId.systemDefault()).atStartOfDay(ZoneId.systemDefault()).toInstant());
//
//    private Long countOfAllViewsFilm;
//
//    @GlobalCommand
//    @NotifyChange("date")
//    public void refreshClientList() {
//        BindUtils.postNotifyChange(null, EventQueues.APPLICATION, this, "listOfActionsByDate");
//        BindUtils.postNotifyChange(null, EventQueues.APPLICATION, this, "countOfAllViewsFilm");
//    }
//
//
//    /**
//     * Получаем все планшеты на которых запускался фильм на выбранную дату.
//     */
//    @Command
//    @NotifyChange("listOfActionsByDate")
//    public void findAction(@BindingParam("date") Date date) {
//        Instant startOfTheDay = date.toInstant();
//        Instant endOfTheDay = date.toInstant().plus(1, ChronoUnit.DAYS);
//        listOfActionsByDate = statisticRepository.findAllActiveTabletsByDate(startOfTheDay, endOfTheDay);
//        countOfAllViewsFilm = statisticRepository.findCountOfViewsByAllTablets(startOfTheDay, endOfTheDay);
//    }
//
//
//    /**
//     * Получаем List {название фильма : количество просмотров}.
//     */
//    public List<Object[]> findByImei(String imei, @BindingParam("date") Date date) {
//        Instant startOfTheDay = date.toInstant();
//        Instant endOfTheDay = date.toInstant().plus(1, ChronoUnit.DAYS);
//        return statisticRepository.findFilmAndCountByTabletImei(imei, startOfTheDay, endOfTheDay);
//    }
//
//
//    /**
//     * Получаем количество просмотров фильмов с планшета по imei.
//     */
//    public long countOfViewsFilmByImei(String imei, @BindingParam("date") Date date) {
//        Instant startOfTheDay = date.toInstant();
//        Instant endOfTheDay = date.toInstant().plus(1, ChronoUnit.DAYS);
//        List<Object[]> listCountOfViewsByFilmName = statisticRepository.findFilmAndCountByTabletImei(imei, startOfTheDay, endOfTheDay);
//        long sum = 0;
//
//        for (Object[] objects : listCountOfViewsByFilmName) {
//            sum = sum + (long) objects[1];
//        }
//        return sum;
//    }
//
//
//    /**
//     * Получаем количество просмотров фильмов со ВСЕХ планшетов.
//     */
//    public long countOfAllViewsFilm(@BindingParam("date") Date date) {
//        Instant startOfTheDay = date.toInstant();
//        Instant endOfTheDay = date.toInstant().plus(1, ChronoUnit.DAYS);
//        return statisticRepository.findCountOfViewsByAllTablets(startOfTheDay, endOfTheDay);
//    }
//
//
//    public Long getCountOfAllViewsFilm() {
//        return countOfAllViewsFilm;
//    }
//
//    public List<String> getListOfActionsByDate() {
//        return listOfActionsByDate;
//    }
//
//    public List<Object[]> getListOfFilmsAndCountByTablet() {
//        return listOfFilmsAndCountByTablet;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public StatisticRepository getStatisticRepository() {
//        return statisticRepository;
//    }
//
//    public void setStatisticRepository(StatisticRepository statisticRepository) {
//        this.statisticRepository = statisticRepository;
//    }
//
//}