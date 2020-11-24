[![Build Status](https://api.travis-ci.org/mabutamail/tipograf.svg?branch=master)](https://travis-ci.org/mabutamail/tipograf)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/070d6ae3da2a4756a2a2d42d8d85935b)](https://www.codacy.com/gh/mabutamail/TipoGraf/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mabutamail/TipoGraf&amp;utm_campaign=Badge_Grade)


# TipoGraf
----------------------------    Учет заказов (впоследствии для типографий)      ----------------------------

Минимально жизнеспособный продукт (minimum viable product, MVP)
1)  Заказ имеет поля: номер, дата-время, клиент, цена, комментарий, состояние
2)  Заказ имеет состояния: принят, в работе, на складе, выполнен, удалён
3)  Заказ можно создавать, читать, редактировать
4)  Работа с заказами происходит через браузер и интернет
5)  Должна быть возможность просмотреть все заказы

----------------------------        спринт 1 (создаём структуру проекта)        ----------------------------
-   структуру папок проекта и выбираем технологии: java 11, PostgreSQL, Hibernate, git, maven, junit, logback
-   репозиторий на github.com, описание readme.md, pom.xml, .gitignore
-   декомпозиция
-   сущность Class PrintOrder (заказ) с полями: номер, дата-время, клиент, цена, комментарий, состояние
-   Enum Condition (состояние) с полями: принят, в работе, на складе, выполнен, удалён
-   сущность Client (клиент) с полями: имя, примечание
-   маппинг POJO классов аннотациями 
    https://mkyong.com/hibernate/hibernate-one-to-many-relationship-example-annotation/
-   тестовые данные на SQL (DDL, DML)

----------------------------                        спринт 2                    ----------------------------

/*TODO
-   dao слой OrderDAO и OrderDAOImpl                                                        in action
-   flywaydb.org закончить с миграцией                                                      done
-   configure the C3P0 connection pool in Hibernate (hibernate.cfg.xml)                     done
-   перенести создание заказа в junit                                                       done
-   аннотации к геттерам перенести в объявление полей                                       done
-   аннотация к enum OrderCondition @Enumerated(value = EnumType.STRING)                    done
-   результаты тестов записывать еще и в файл                                               done
-   рефакторинг с hibernate.cfg.xml (Hibernate) на persistence.xml (JPA) entity manager     done

----------------------------                        вопросы?                     ----------------------------
1)  
