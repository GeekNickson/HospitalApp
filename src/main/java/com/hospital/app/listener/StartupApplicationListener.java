package com.hospital.app.listener;

import com.hospital.app.model.Doctor;
import com.hospital.app.model.Specialty;
import com.hospital.app.service.DoctorService;
import com.hospital.app.service.SpecialtyService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class StartupApplicationListener {
    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    DoctorService doctorService;

    ArrayList<Specialty> specialtiesList = new ArrayList<>();
    ArrayList<Doctor> doctorsList = new ArrayList<>();

    public void insertSpecialties() throws URISyntaxException {

        String[] specialties = {"Невролог", "Нейрохирург", "Терапевт", "Стоматолог", "Дерматолог", "Офтальмолог", "Хирург", "Травматолог", "ЛОР", "Педиатр",
                "Патологоанатом", "Фармацевт", "Эндокринолог", "Ортодонт", "Иммунолог", "Кардиолог", "Вирусолог"};

        for (String specialty : specialties) {
            specialtiesList.add(new Specialty(specialty));
        }

        specialtyService.saveAllSpecialties(specialtiesList);
    }

    public void insertDoctors() throws URISyntaxException {

        String[] categories = {"Первая", "Вторая", "Высшая"};
        String[] schedules = {"пн-пт; 9:00-17:00", "вт-чт; 9:00-17:00", "пн-ср; 9:00-12:00", "сб-вс; 12:00-14:00"};
        String[] firstNamesMale = {"Игорь", "Анатолий", "Сергей", "Алексей", "Платон", "Виктор", "Николай", "Евгений", "Александр", "Патрик",
                "Павел", "Андрей", "Тимур", "Тимофей", "Степан", "Руслан", "Роберт", "Альберт", "Борис", "Богдан", "Василий",
                "Константин", "Иван", "Илья", "Семён", "Федор", "Олег", "Эдуард"};
        String[] lastNamesMale = {"Иванов", "Сидоров", "Васечкин", "Бабочкин", "Кузнецов", "Петров", "Соколов", "Михайлов", "Цветочкин", "Богословский",
                "Белухин", "Барсиков", "Баринов", "Акимов", "Трофимов", "Васильев", "Носков", "Фрикаделькин", "Емцов", "Терентьев",
                "Гаврилов", "Галкин", "Блинов", "Ефремов", "Фомин", "Королёв", "Фадеев", "Черничкин", "Клубничкин", "Земляничкин",
                "Тарасов", "Кузнечиков", "Александров", "Гришин", "Нестеров", "Чернов", "Дмитриев", "Крылов", "Пушкин", "Опушкин",
                "Тургенев", "Марков", "Блок", "Горький", "Суворов", "Грозный", "Костин", "Брусничкин", "Пицкин", "Петухов", "Горлов"};
        String[] firstNamesFemale = {"Оксана", "Наталья", "Анастасия", "Светлана", "Любовь", "Анфиса", "Екатерина", "Лидия", "Галина", "Карина",
                "Ксения", "Клавдия", "Юлия", "Яна", "Елена", "Алёна", "Людмила", "Лада", "Вероника", "Виктория", "Тамара", "Снежана",
                "София", "Ирина", "Полина", "Ольга", "Александра", "Анжела", "Афродита"};
        String[] lastNamesFemale = {"Иванова", "Сидорова", "Васечкина", "Бабочкина", "Кузнецова", "Петрова", "Соколова", "Михайлова", "Цветочкина", "Богословскийа",
                "Белухина", "Барсикова", "Баринова", "Акимова", "Трофимова", "Васильева", "Носкова", "Фрикаделькина", "Емцова", "Терентьева",
                "Гаврилова", "Галкина", "Блинова", "Ефремова", "Фомина", "Королёва", "Фадеева", "Черничкина", "Клубничкина", "Земляничкина",
                "Тарасова", "Кузнечикова", "Александрова", "Гришина", "Нестерова", "Чернова", "Дмитриева", "Крылова", "Пушкина", "Опушкина",
                "Тургенева", "Маркова", "Блок", "Горькая", "Суворова", "Грозная", "Костина", "Брусничкина", "Пицкина", "Петухова", "Горлова", "Нахмурина"};

        Random randomFirstNameMale = new Random();
        Random randomLastNameMale = new Random();
        Random randomFirstNameFemale = new Random();
        Random randomLastNameFemale = new Random();
        Random randomCategory = new Random();
        Random randomSchedule = new Random();
        Random randomSpecialty = new Random();

        for (int i = 0; i < 10000; i++) {

            if (i % 2 == 0) {
                int firstName = randomFirstNameMale.nextInt(firstNamesMale.length);
                int lastName = randomLastNameMale.nextInt(lastNamesMale.length);
                int category = randomCategory.nextInt(categories.length);
                int schedule = randomSchedule.nextInt(schedules.length);
                int specialty = randomSpecialty.nextInt(specialtiesList.size());
                doctorsList.add(new Doctor(firstNamesMale[firstName] + " " + lastNamesMale[lastName], categories[category], schedules[schedule], specialtiesList.get(specialty)));
            } else {
                int firstName = randomFirstNameFemale.nextInt(firstNamesFemale.length);
                int lastName = randomLastNameFemale.nextInt(lastNamesFemale.length);
                int category = randomCategory.nextInt(categories.length);
                int schedule = randomSchedule.nextInt(schedules.length);
                int specialty = randomSpecialty.nextInt(specialtiesList.size());
                doctorsList.add(new Doctor(firstNamesFemale[firstName] + " " + lastNamesFemale[lastName], categories[category], schedules[schedule], specialtiesList.get(specialty)));
            }
        }
        doctorService.saveAllDoctors(doctorsList);
    }

    private static final Logger LOG
            = Logger.getLogger(StartupApplicationListener.class);


    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        LOG.info("checking data");
        if (specialtyService.countRows() == 0) {
            LOG.info("inserting specialties");
            try {
                insertSpecialties();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        if (doctorService.countRows() == 0) {
            if (specialtyService.countRows() == 0) {
                LOG.info("inserting specialties");
                try {

                    insertSpecialties();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            LOG.info("inserting doctors");
            try {
                insertDoctors();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        LOG.info("done");
    }
}