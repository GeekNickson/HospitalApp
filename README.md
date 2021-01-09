# Hospital App

**Тестовое задание на стажировку в компании InrecoLAN**

---

Веб-приложение состоит из двух разделов

### Первый раздел

При заходе в первый раздел веб-приложения, пользователь попадает на страницу, на которой представлен список специальностей врачей больницы. При нажатии на специальность, происходит переход на вторую страницу, на которой представлена информация о врачах, работающих по данной специальности (ФИО, специальность, расписание). При нажатии на врача, происходит переход на страницу информации об этом враче (ФИО, категория, специальность, расписание).

### Второй раздел

При заходе во второй раздел веб-приложения, пользователь попадает на страницу, на которой представлена информация о всех врачах больницы (идентификационный номер, ФИО, специальность, категория). Количество записей в таблице врачей – 10000 (нагенерировать скриптом / java-кодом). Над таблицей находится фильтр с кнопкой "Фильтровать" и полями: "специальность" (выпадающий список со всеми специальностями) и "ФИО" (текстовое поле). При заполнении полей и нажатии кнопки должна выполняться фильтрация таблицы по заданным критериям и переход на первую страницу таблицы.

## **Все таблицы должны иметь пагинатор, количество записей на странице - 10. Данные в таблицах должны подгружаться по 10 строк при переходе по страницам**

---

## Используемые технологии

**Backend**

- PostgresSQL
- Spring

---

**Frontend**

- JSP
- JQuery
- CSS
