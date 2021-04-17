package com.github.mabutamail.tipograf.repository;

//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import ru.simplex_software.vr360_main_server.model.Statistic;
//
//import java.time.Instant;
//import java.util.List;

//public interface StatisticRepository extends CrudRepository<Statistic, Long> {
//    /**
//     * Статистика. Все действия.
//     */
//    @Query("FROM Statistic")
//    List<Statistic> findAll();
//
//    /**
//     * Статистика. Все планшеты на которых запускался фильм на выбранную дату.
//     */
//    @Query(
//            "SELECT DISTINCT tabletImei " +
//                    "FROM Statistic s " +
//                    "WHERE s.stateType='START' AND s.date BETWEEN :begin AND :end"
//    )
//    List<String> findAllActiveTabletsByDate(@Param("begin") Instant startOfTheDay, @Param("end") Instant endOfTheDay);
//
//
//    /**
//     * Статистика. На планшетах: {название фильма : количество просмотров}.
//     */
//    @Query(
//            "SELECT s.film.name, COUNT(s)" +
//                    "FROM Statistic s " +
//                    "WHERE s.stateType='START' AND s.tabletImei=:tabletsImei  AND s.date BETWEEN :begin AND :end " +
//                    "GROUP BY s.film.id, s.film.name "
//    )
//    List<Object[]> findFilmAndCountByTabletImei(@Param("tabletsImei") String activeTabletImeiByDate, @Param("begin") Instant startOfTheDay, @Param("end") Instant endOfTheDay);
//
//    /**
//     * Статистика. Количество просмотров на выбранную дату.
//     */
//    @Query(
//            "SELECT COUNT(s)" +
//                    "FROM Statistic s " +
//                    "WHERE s.stateType='START' AND s.date BETWEEN :begin AND :end"
//    )
//    Long findCountOfViewsByAllTablets(@Param("begin") Instant startOfTheDay, @Param("end") Instant endOfTheDay);
//
//}