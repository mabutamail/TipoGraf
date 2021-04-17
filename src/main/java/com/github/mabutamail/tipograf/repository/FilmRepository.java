package com.github.mabutamail.tipograf.repository;
//
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//import ru.simplex_software.vr360_main_server.model.Film;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface FilmRepository extends CrudRepository<Film, Long> {
//
//    /**
//     * Возвращает список всех доступных фильмов
//     */
//    @Query("FROM Film WHERE activated = TRUE")
//    List<Film> findAllActivated();
//
//    @Query("FROM Film WHERE hash = :hash")
//    Optional<Film> findByHash(@Param("hash") String hash);
//
//    /**
//     * Возвращает путь активного фильма по hash
//     */
//    @Query("SELECT f.path FROM Film f WHERE activated = TRUE AND hash = :hash")
//    String findActivatedFilmPathByHash(@Param("hash") String hash);
//
//    @Transactional
//    @Modifying
//    @Query("DELETE FROM Film  WHERE hash = :hash")
//    void deleteByHash(@Param("hash") String hash);
//}
