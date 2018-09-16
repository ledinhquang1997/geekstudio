package com.codingmanstudio.courses.bootstrap;

import com.codingmanstudio.courses.domain.*;
import com.codingmanstudio.courses.repository.*;
import com.codingmanstudio.courses.Utils.EncrytedPasswordUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;
    private final LessonRepository lessonRepository;
    private final TopicRepository topicRepository;
    private final SectionRepository sectionRepository;
    private final CourseRepository courseRepository;

    public DataLoader(RoleRepository roleRepository, AccountRepository accountRepository, CategoryRepository categoryRepository, LessonRepository lessonRepository, TopicRepository topicRepository, SectionRepository sectionRepository, CourseRepository courseRepository) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
        this.lessonRepository = lessonRepository;
        this.topicRepository = topicRepository;
        this.sectionRepository = sectionRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count()==0) {
            Role role_user = new Role();
            role_user.setRole("ROLE_USER");
            Role saved_role_user = roleRepository.save(role_user);

            Role role_learner = new Role();
            role_learner.setRole("ROLE_LEARNER");
            Role saved_role_learner = roleRepository.save(role_learner);

            Role role_admin = new Role();
            role_admin.setRole("ROLE_ADMIN");
            Role saved_role_admin = roleRepository.save(role_admin);

            Account user1 = new Account();
            user1.setUsername("quang");
            user1.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            System.out.println(user1.getEncrytedPassword());
            user1.getRoles().add(saved_role_admin);
            user1.getRoles().add(saved_role_user);
            accountRepository.save(user1);

            Account user2 = new Account();
            user2.setUsername("thang");
            user2.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            user2.getRoles().add(saved_role_learner);
            accountRepository.save(user2);

            Account user3 = new Account();
            user3.setUsername("hai");
            user3.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            accountRepository.save(user3);

            Category cat1 = new Category();
            cat1.setName("Programming");
            cat1.setDescription("That’s all you have to do to let Hibernate generate UUIDs as primary key values. You can see an example of it in the following code snippet");
            Category savedcat1= categoryRepository.save(cat1);
            System.out.println(savedcat1.getId().toString());

            Category cat2 = new Category();
            cat2.setName("Business");
            cat2.setDescription("That’s all you have to do to let Hibernate generate UUIDs as primary key values. You can see an example of it in the following code snippet");
            Category savedcat2= categoryRepository.save(cat2);


            Instructor alex = new Instructor();
            alex.setName("Alex Jefferson");
            alex.setEmail("alex@gmail.com");
            alex.setCompany("FPT");

            Lessons les1 = new Lessons();
            les1.setName("Lesson1_Python");
            les1.setDescription("This lesson'll introduce for you about how to create a new web app");
            Lessons saveles1 = lessonRepository.save(les1);

            Lessons les2 = new Lessons();
            les2.setName("Lesson1_Angular");
            les2.setDescription("This lesson'll teach you about how to design and decorate a web app");
            Lessons saveles2 = lessonRepository.save(les2);

            Topics top1 = new Topics();
            top1.setName("Python");
            top1.setDescription("How to create a new web app or how to learn machine learning");
            Topics savetop1 = topicRepository.save(top1);

            Topics top2 = new Topics();
            top2.setName("Angular");
            top2.setDescription("How to create a new web app");
            Topics savetop2 = topicRepository.save(top2);

            Sections sec1 = new Sections();
            sec1.setContent("Section1_Python");
            sec1.setDescription("Machine Learning");
            Sections savesec1 = sectionRepository.save(sec1);

            Sections sec2 = new Sections();
            sec2.setContent("Section1_Angular");
            sec2.setDescription("Describing about creating web app");
            Sections savesec2 = sectionRepository.save(sec2);

            Courses cour1 = new Courses();
            cour1.setName("Spring Boot");
            cour1.setDatecreate(LocalDate.now());
            cour1.setCost(15.000);
            cour1.setDescription("Talking about constructor of Spring framework");
            cour1.setRating(10);
            Courses savecour1 = courseRepository.save(cour1);

            Courses cour2 = new Courses();
            cour2.setName("Spring MVC");
            cour2.setDatecreate(LocalDate.now());
            cour2.setCost(35.000);
            cour2.setDescription("Talking about constructor of Spring framework");
            cour2.setRating(10);
            Courses savecour2 = courseRepository.save(cour2);
        }
    }
}
